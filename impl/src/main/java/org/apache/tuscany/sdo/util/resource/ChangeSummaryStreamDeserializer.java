/**
 *
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.apache.tuscany.sdo.util.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.tuscany.sdo.SDOFactory;
import org.apache.tuscany.sdo.helper.SDOAnnotations;
import org.apache.tuscany.sdo.impl.ChangeSummaryImpl;
import org.apache.tuscany.sdo.impl.ClassImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.ChangeFactory;
import org.eclipse.emf.ecore.change.ChangeKind;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.ecore.change.FeatureMapEntry;
import org.eclipse.emf.ecore.change.ListChange;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

import commonj.sdo.ChangeSummary;
import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;
import commonj.sdo.helper.HelperContext;

/**
 * ChangeSummary StAX Deserializer whose input conforms to the SDO Java/C++/PHP specifications. The instance isn't thread-safe, however it's safe to
 * use the instance any times on the same thread.
 */
public class ChangeSummaryStreamDeserializer extends SDODeserializer {
    static final class ForwardReference extends Ref {
        final String unset;

        ForwardReference(String ref, NamespaceContext nameSpaces, String u) {
            super(ref, nameSpaces);
            unset = u;
        }

        Collection attributes/* = null */, qualifiedAttributes/* = null */, tags/* = null */; // may be null, never empty
    }

    protected Collection forwardReferences/* = null */;

    static private final class ElementChange extends Ref {
        private final Object containing, containment;
        private ElementChange(String ref, NamespaceContext nameSpaces, Object property, Object propertyInSequence) {
            super(ref, nameSpaces);
            containing = property;
            containment = propertyInSequence;
        }
    }

    static private class PropertyMapChanges {
        Map/* Property,List */lists/* = null */;// may be null

        Collection put(Object property) {
            Collection list = new ArrayList();
            lists.put(property, list);
            return list;
        }

        protected final Collection get(Object property) {
            Object list = lists.get(property);
            return list == null ? put(property) : (Collection) list;
        }

        protected final Collection newList(Object property) {
            lists = new HashMap();
            return put(property);
        }
    }

    static final class ObjectChanges extends PropertyMapChanges {
        Collection elementChanges/* = null */,// may be null, never empty
                featureChanges;

        protected final void newElementChanges() {
            elementChanges = new ArrayList();
        }
    }

    Collection objectChangesCollection/* = null */, objectMapChanges, deletedDataObjects;

    protected final ObjectChanges newObjectChanges(Collection featureChanges) {
        ObjectChanges objectChanges = new ObjectChanges();
        objectChanges.featureChanges = featureChanges;
        if (objectChangesCollection == null)
            objectChangesCollection = new ArrayList();
        objectChangesCollection.add(objectChanges);
        return objectChanges;
    }

    private ChangeFactory changeFactory;

    private SDOFactory changeSettingFactory;

    private void logPropertyChange(Collection featureChanges, EStructuralFeature feature, Object value, boolean set) {
        if (changeSettingFactory == null)
            featureChanges.add(changeFactory.createFeatureChange(feature, value, set));
        else
            featureChanges.add(changeSettingFactory.createChangeSummarySetting(feature, value, set));
    }

    void unsetProperty(Collection featureChanges, String unset, int begin, int index, Type type) {
        logPropertyChange(featureChanges, (EStructuralFeature) type.getProperty(unset.substring(begin, index)), null, false);
    }

    static boolean isWhitespace(String unset, int index) {
        return Character.isWhitespace(unset.charAt(index));
    }

    protected final Collection unsetProperties(EObject referent, String unset, Type type) {
        Map.Entry entry = changeFactory.createEObjectToChangesMapEntry(referent);
        objectMapChanges.add(entry);
        Collection featureChanges = (Collection) entry.getValue();
        if (unset == null)
            return featureChanges;
        int end = unset.length();
        if (end != 0)
            for (int begin = 0, index = 1;/* true */; ++index) {
                if (index == end) {
                    unsetProperty(featureChanges, unset, begin, index, type);
                    break;
                }
                if (isWhitespace(unset, index)) {
                    unsetProperty(featureChanges, unset, begin, index, type);
                    while (true) {
                        if (++index != end)
                            return featureChanges;
                        if (!isWhitespace(unset, index)) {
                            begin = index;
                            break;
                        }
                    }
                }
            }
        return featureChanges;
    }

    private Object value(EStructuralFeature containing, Object containment, Object value) {
        return FeatureMapUtil.isFeatureMap(containing) ? changeFactory.createFeatureMapEntry((EStructuralFeature) containment, value) : value;
    }

    private void logPropertyChange(Collection featureChanges, Object containing, Object containment, Object value) {
        EStructuralFeature feature = (EStructuralFeature) containing;
        logPropertyChange(featureChanges, feature, value(feature, containment, value), true);
    }

    private void logPropertyChange(Collection featureChanges, Object property, Object value) {
        logPropertyChange(featureChanges, property, propertyInSequence, value);
    }

    void logAttributeChange(Collection featureChanges, Property property, String literal, NamespaceContext nameSpaces) {
        logPropertyChange(featureChanges, property, value(property.getType(), literal, nameSpaces));
    }

    protected final void logAttributeChange(Collection featureChanges, String property, Type type, String value, NamespaceContext nameSpaces) {
        logAttributeChange(featureChanges, getProperty(type, property), value, nameSpaces);
    }

    protected final void logAttributeChange(Collection featureChanges, String nameSpace, String name, Type type, String value,
            NamespaceContext nameSpaces) {
        logAttributeChange(featureChanges, getProperty(type, nameSpace, name, false), value, nameSpaces);
    }

    protected final String ref() {
        return reader.getAttributeValue(SDOAnnotations.COMMONJ_SDO_NS, ChangeSummaryStreamSerializer.REF_ATTRIBUTE);
    }

    ChangeSummaryImpl changeSummary;

    protected Object load(XMLStreamReader reader, Map options) throws XMLStreamException {
        Object value = super.load(reader, options);
        deletedDataObjects.add(value);
        return value;
    }

    protected final void getChangeSummary(DataObject rootObject) {
        changeSummary = (ChangeSummaryImpl) rootObject.getChangeSummary(); // DynamicDataObjectImpl(EClass)
    }

    static protected final class Tag extends RecordedEventXMLStreamReader.Tag {
        protected String ref;

        protected Object value;

        protected Tag(XMLStreamReader reader) {
            super(reader);
        }
    }

    protected final void addPropertyChange(Collection list, Object value, Object containing) {
        list.add(value((EStructuralFeature) containing, propertyInSequence, value));
    }

    protected boolean logging;

    /**
     * Imports ChangeSummary 2-1. Forward references will be resolved by {@link #end()}.
     * 
     * @param reader
     *            Never null
     * @throws XMLStreamException
     */
    public final void begin(DataObject rootObject, HelperContext scope, XMLStreamReader reader) throws XMLStreamException {
        /*
         * 3-1. Instantiate ChangeSummary input: reader (xsi:type), factory, rootObject output: changeSummary, changeDescription
         */
        initialize(reader, scope, rootObject);
        if (typedXSI()) {
            changeSummary = (ChangeSummaryImpl) scope.getDataFactory().create(nameSpace, name);
            if (changeSummary == null)
                getChangeSummary(rootObject);
            else {
                Property csp = ((ClassImpl) rootObject.getType()).getChangeSummaryProperty();
                rootObject.set(csp, changeSummary);
                changeSummary.setDataObject(rootObject);
            }
        } else
            getChangeSummary(rootObject);
        ChangeDescription changeDescription = (ChangeDescription) changeSummary;

        /*
         * 3-2. "logging" attribute input: reader output: logging
         */
        logging = Boolean.valueOf(reader.getAttributeValue(null, "logging")).booleanValue();

        /*
         * 3-3. Modified DataObjects input: changeDescription
         */
        if (forwardReferences != null)
            forwardReferences.clear();
        if (objectChangesCollection != null)
            objectChangesCollection.clear();
        if (START_ELEMENT == reader.nextTag()) {
            objectMapChanges = changeDescription.getObjectChanges();
            deletedDataObjects = changeDescription.getObjectsToAttach();
            Object factory = changeDescription.eClass().getEPackage().getEFactoryInstance();
            changeFactory = factory instanceof ChangeFactory ? (ChangeFactory) factory : ChangeFactory.eINSTANCE;
            changeSettingFactory = factory instanceof SDOFactory ? (SDOFactory) factory : null;
            do {
                /*
                 * Modified DataObject
                 */
                String ref = ref(), unset = reader.getAttributeValue(SDOAnnotations.COMMONJ_SDO_NS, ChangeSummaryStreamSerializer.UNSET);
                int attributes = reader.getAttributeCount();
                NamespaceContext nameSpaces = reader.getNamespaceContext();
                EObject referent = referent(ref, nameSpaces);
                if (referent == null) {
                    /*
                     * Forward-referenced(unresolved) modified DataObject
                     */
                    ForwardReference forwardReference = new ForwardReference(ref, nameSpaces, unset);
                    if (forwardReferences == null)
                        forwardReferences = new ArrayList();
                    forwardReferences.add(forwardReference);
                    do // what about xmlns="NS1" a1="qName" xmlns="NS2" a2="qName" ?
                    {
                        /*
                         * Record property old value as attribute for end()
                         */
                        String nameSpace = reader.getAttributeNamespace(--attributes), name = reader.getAttributeLocalName(attributes), value = reader
                                .getAttributeValue(attributes);
                        if (nameSpace == null) {
                            /*
                             * Local attribute
                             */
                            Attribute attribute = new Attribute();
                            attribute.name = name;
                            attribute.value = value;
                            if (forwardReference.attributes == null)
                                forwardReference.attributes = new ArrayList();
                            forwardReference.attributes.add(attribute);
                        } else if (!SDOAnnotations.COMMONJ_SDO_NS.equals(nameSpace) || !ChangeSummaryStreamSerializer.REF_ATTRIBUTE.equals(name)
                                && !ChangeSummaryStreamSerializer.UNSET.equals(name)) {
                            /*
                             * Qualified(global) attribute
                             */
                            QualifiedAttribute attribute = new QualifiedAttribute();
                            attribute.name = name;
                            attribute.value = value;
                            attribute.nameSpace = nameSpace;
                            if (forwardReference.qualifiedAttributes == null)
                                forwardReference.qualifiedAttributes = new ArrayList();
                            forwardReference.qualifiedAttributes.add(attribute);
                        }
                    } while (attributes != 0);
                    while (START_ELEMENT == reader.nextTag()) {
                        /*
                         * Record property old value as element for end()
                         */
                        Tag tag = new Tag(reader);
                        if (forwardReference.tags == null)
                            forwardReference.tags = new ArrayList();
                        forwardReference.tags.add(tag);
                        tag.ref = ref();
                        if (tag.ref != null)
                            continue;
                        Type xsi = typeXSI();
                        if (xsi == null) {
                            if (tag.nameSpace != null)
                                tag.value = value(globalElementType(tag.nameSpace, tag.name.getLocalPart())); // TODO substitutionGroup type if null
                            else if (tag.record(reader))
                                break;
                        } else
                            tag.value = value(xsi);
                    }
                } else {
                    /*
                     * Resolved(back-referenced) modified DataObject
                     */
                    Type type = ((DataObject) referent).getType();
                    Collection featureChanges = unsetProperties(referent, unset, type);
                    do // what about xmlns="NS1" a1="qName" xmlns="NS2" a2="qName" ?
                    {
                        /*
                         * Log property old value as attribute
                         */
                        String nameSpace = reader.getAttributeNamespace(--attributes), name = reader.getAttributeLocalName(attributes), value = reader
                                .getAttributeValue(attributes);
                        if (nameSpace == null)
                            logAttributeChange(featureChanges, name, type, value, nameSpaces);
                        else if (!SDOAnnotations.COMMONJ_SDO_NS.equals(nameSpace) || !ChangeSummaryStreamSerializer.REF_ATTRIBUTE.equals(name)
                                && !ChangeSummaryStreamSerializer.UNSET.equals(name))
                            logAttributeChange(featureChanges, nameSpace, name, type, value, nameSpaces);
                    } while (attributes != 0);
                    if (START_ELEMENT == reader.nextTag()) {
                        ObjectChanges objectChanges = null;
                        do {
                            /*
                             * Log property old value as element
                             */
                            String nameSpace = reader.getNamespaceURI(), name = reader.getLocalName();
                            Property property = getProperty(nameSpace, name, type);
                            boolean many = property.isMany();
                            Object value;
                            ref = ref();
                            if (ref == null) {
                                /*
                                 * Contained property old value
                                 */
                                Type xsi = typeXSI();
                                if (xsi != null)
                                    value = value(xsi);
                                else if (nameSpace == null)
                                    value = value(reader);
                                else {
                                    xsi = globalElementType(nameSpace, name);
                                    value = value(xsi == null ? propertyInSequence.getType() : xsi);
                                }
                            } else {
                                /*
                                 * Referenced child DataObject
                                 */
                                nameSpaces = reader.getNamespaceContext();
                                reader.nextTag()/* END_ELEMENT */;
                                value = referent(ref, nameSpaces);
                                if (value == null) {
                                    /*
                                     * Forward-referenced(unresolved) child DataObject
                                     */
                                    if (!many) {
                                        ElementChange elementChange = new ElementChange(ref, nameSpaces, property, propertyInSequence);
                                        if (objectChanges == null) {
                                            objectChanges = newObjectChanges(featureChanges);
                                            objectChanges.newElementChanges();
                                        } else if (objectChanges.elementChanges == null)
                                            objectChanges.newElementChanges();
                                        objectChanges.elementChanges.add(elementChange);
                                        continue;
                                    }
                                    value = new Ref(ref, nameSpaces);
                                }
                            }
                            if (many) {
                                Collection list;
                                if (objectChanges == null) {
                                    objectChanges = newObjectChanges(featureChanges);
                                    list = objectChanges.newList(property);
                                } else if (objectChanges.lists == null)
                                    list = objectChanges.newList(property);
                                else
                                    list = objectChanges.get(property);
                                addPropertyChange(list, value, property);
                            } else
                                logPropertyChange(featureChanges, property, value);
                        } while (START_ELEMENT == reader.nextTag());
                    }
                }
            } while (START_ELEMENT == reader.nextTag());
        }
    }

    static private boolean sequence(Object listChanges) {
        return FeatureMapUtil.isFeatureMap(((FeatureChange) ((EStructuralFeature.Setting) listChanges).getEObject()).getFeature());
    }

    private ListChange createListChange(ChangeKind changeKind, int index, Collection listChanges) {
        ListChange listChange = changeFactory.createListChange();
        listChange.setKind(changeKind);
        listChange.setIndex(index);
        listChanges.add(listChange);
        return listChange;
    }

    Collection add(Collection adds, int change, Collection listChanges, Object value) {
        if (adds == null) {
            ListChange listChange = createListChange(ChangeKind.ADD_LITERAL, change, listChanges);
            adds = sequence(listChanges) ? listChange.getFeatureMapEntryValues() : listChange.getValues();
        }
        adds.add(value);
        return adds;
    }

    private int remove(int change, Collection listChanges, List list, int begin, int end) {
        ListChange listChange = createListChange(ChangeKind.REMOVE_LITERAL, change, listChanges);
        if (sequence(listChanges)) {
            Collection removes = listChange.getFeatureMapEntryValues();
            do {
                FeatureMap.Entry fme = (FeatureMap.Entry) list.get(begin);
                removes.add(changeFactory.createFeatureMapEntry(fme.getEStructuralFeature(), fme.getValue()));
            } while (++begin != end);
            return begin;
        }
        Collection removes = listChange.getValues();
        do
            removes.add(list.get(begin));
        while (++begin != end);
        return begin;
    }

    int remove(int begin, int end, int change, Collection listChanges, List list) {
        return begin == end ? begin : remove(change, listChanges, list, begin, end);
    }

    protected final void logManyChanges(PropertyMapChanges propertyMapChanges, EObject referent, Collection featureChanges) {
        for (Iterator lists = propertyMapChanges.lists.entrySet().iterator(); lists.hasNext();) {
            /*
             * Compute ListChanges out of comparision of old and new list
             */
            Map.Entry entry = (Map.Entry) lists.next();
            EStructuralFeature property = (EStructuralFeature) entry.getKey();
            Iterator values = ((Collection) entry.getValue()).iterator(); // old list
            Object value = referent.eGet(property);
            List list = value instanceof FeatureMap.Internal.Wrapper ? ((FeatureMap.Internal.Wrapper) value).featureMap() : (List) value; // new
            int change = 0;
            FeatureChange featureChange = changeSettingFactory == null ? changeFactory.createFeatureChange() : (FeatureChange) changeSettingFactory
                    .createChangeSummarySetting();
            featureChange.setFeature(property);
            Collection listChanges = featureChange.getListChanges(), adds = null;
            featureChanges.add(featureChange);
            if (property.getEType() instanceof EClass) {
                /*
                 * Log child DataObject changes
                 */
                int begin = 0, end = list.size();
                while (values.hasNext()) {
                    value = values.next();
                    if (value.getClass() == Ref.class) {
                        value = referent((Ref) value);
                        if (value == null)
                            continue;// report error?
                    }
                    // values.remove();
                    for (int index = begin;/* true */; ++index)
                        if (index == end) {
                            adds = add(adds, change, listChanges, value);
                            break;
                        } else if (list.get(index) == value) // List#indexOf uses equals
                        {
                            begin = remove(begin, index, change, listChanges, list);
                            ++begin;
                            adds = null;
                            break;
                        }
                    ++change;
                }
                remove(begin, end, change, listChanges, list);
            } else if (FeatureMapUtil.isFeatureMap(property)) {
                /*
                 * Log Sequence changes
                 */
                int begin = 0, end = list.size();
                while (values.hasNext()) {
                    FeatureMapEntry featureMapEntry = (FeatureMapEntry) values.next();
                    value = featureMapEntry.getValue();
                    if (value.getClass() == Ref.class) {
                        value = referent((Ref) value);
                        if (value == null)
                            continue;// report error?
                    }
                    // values.remove();
                    Comparator equality;
                    ETypedElement feature = featureMapEntry.getFeature();
                    if (((Type) feature.getEType()).isDataType())
                        if (value == null)
                            equality = EQUAL_NULL;
                        else
                            equality = EQUAL;
                    else
                        equality = SAME;
                    for (int index = begin;/* true */; ++index)
                        if (index == end) {
                            adds = add(adds, change, listChanges, featureMapEntry);
                            break;
                        } else {
                            FeatureMap.Entry fme = (FeatureMap.Entry) list.get(index);
                            if (feature == fme.getEStructuralFeature() && equality.compare(fme.getValue(), value) == 0) {
                                begin = remove(begin, index, change, listChanges, list);
                                ++begin;
                                adds = null;
                                break;
                            }
                        }
                    ++change;
                }
                remove(begin, end, change, listChanges, list);
            } else {
                /*
                 * Log simple value changes
                 */
                while (values.hasNext()) {
                    value = values.next();
                    // values.remove();
                    int index = list.indexOf(value);
                    switch (index) {
                    case -1:
                        adds = add(adds, change, listChanges, value);
                        break;
                    default:
                        remove(change, listChanges, list, 0, index);
                    case 0:
                        list = list.subList(++index, list.size());
                        adds = null;
                    }
                    ++change;
                }
                remove(0, list.size(), change, listChanges, list);
            }
        }
    }

    protected PropertyMapChanges propertyMapChanges/* = null */;

    /**
     * Imports ChangeSummary 2-2. Resolves forward references from {@link #begin} and resumes logging if necessary. If it's invoked from
     * patching/resolving, try to make it last since logging may be turned on.
     * 
     * @see #begin
     */
    public final ChangeSummary end() throws XMLStreamException {
        if (forwardReferences != null)
            for (Iterator iterator = forwardReferences.iterator(); iterator.hasNext();) {
                /*
                 * Forward-referenced(unresolved) modified DataObject from begin(...)
                 */
                ForwardReference forwardReference = (ForwardReference) iterator.next();
                EObject referent = referent(forwardReference);
                if (referent == null)
                    continue; // report error?
                // iterator.remove();
                Type type = ((DataObject) referent).getType();
                Collection featureChanges = unsetProperties(referent, forwardReference.unset, type);
                if (forwardReference.attributes != null)
                    for (Iterator attributes = forwardReference.attributes.iterator(); attributes.hasNext();) {
                        /*
                         * Log property old value as local attribute from begin(...)
                         */
                        Attribute attribute = (Attribute) attributes.next();
                        logAttributeChange(featureChanges, attribute.name, type, attribute.value, forwardReference.nameSpaces);
                    }
                if (forwardReference.qualifiedAttributes != null)
                    for (Iterator attributes = forwardReference.qualifiedAttributes.iterator(); attributes.hasNext();) {
                        /*
                         * Log property old value as qualified/global attribute from begin(...)
                         */
                        QualifiedAttribute attribute = (QualifiedAttribute) attributes.next();
                        logAttributeChange(featureChanges, attribute.nameSpace, attribute.name, type, attribute.value, forwardReference.nameSpaces);
                    }
                if (forwardReference.tags != null) {
                    if (propertyMapChanges != null)
                        propertyMapChanges.lists.clear();
                    for (Iterator tags = forwardReference.tags.iterator(); tags.hasNext();) {
                        /*
                         * Log property old value as element from begin(...)
                         */
                        Tag tag = (Tag) tags.next();
                        Property property = getProperty(tag.nameSpace, tag.name.getLocalPart(), type);
                        if (tag.ref != null)
                            tag.value = referent(tag.ref, tag.nameSpaceContext);
                        // if (tag.value == null) report error?
                        else if (tag.events != null)
                            tag.value = value(play(tag));
                        if (property.isMany()) {
                            Collection list;
                            if (propertyMapChanges == null) {
                                propertyMapChanges = new PropertyMapChanges();
                                list = propertyMapChanges.newList(property);
                            } else
                                list = propertyMapChanges.get(property);
                            addPropertyChange( list, tag.value, property);
                        } else
                            logPropertyChange(featureChanges, property, tag.value);
                    }
                    if (propertyMapChanges != null)
                        logManyChanges(propertyMapChanges, referent, featureChanges);
                }
            }
        if (objectChangesCollection != null)
            for (Iterator iterator = objectChangesCollection.iterator(); iterator.hasNext();) {
                /*
                 * Forward-referenced(unresolved) child DataObject from begin(...)
                 */
                ObjectChanges objectChanges = (ObjectChanges) iterator.next();
                if (objectChanges.elementChanges != null)
                    for (Iterator elementChanges = objectChanges.elementChanges.iterator(); elementChanges.hasNext();) {
                        ElementChange elementChange = (ElementChange) elementChanges.next();
                        Object value = referent(elementChange);
                        if (value == null)
                            continue; // report error?
                        // iterator.remove();
                        logPropertyChange(objectChanges.featureChanges, elementChange.containing, elementChange.containment, value);
                    }
                if (objectChanges.lists != null)
                    logManyChanges(objectChanges, (EObject) ((Map.Entry) ((EStructuralFeature.Setting) objectChanges.featureChanges).getEObject())
                            .getKey(), objectChanges.featureChanges);
            }
        if (logging)
            changeSummary.resumeLogging();
        return changeSummary;
    }
}
