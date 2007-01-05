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

import java.util.*;
import javax.xml.namespace.*;
import javax.xml.stream.*;

import commonj.sdo.*;
import commonj.sdo.helper.XSDHelper;

import org.apache.tuscany.sdo.SDOPackage;
import org.apache.tuscany.sdo.helper.*;
import org.apache.tuscany.sdo.impl.ChangeSummaryImpl;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.change.*;
import org.eclipse.emf.ecore.util.*;
import org.eclipse.emf.ecore.xmi.XMLResource;

/**
 * ChangeSummary StAX Serializer whose output conforms to the SDO Java/C++/PHP specifications. The instance isn't thread-safe, however it's safe to
 * use the instance any times on the same thread.
 */
public class ChangeSummaryStreamSerializer {
    private XMLStreamWriter writer;

    private String writeNamespace(String prefix, String nameSpace) throws XMLStreamException {
        writer.writeNamespace(prefix, nameSpace);
        writer.setPrefix(prefix, nameSpace);
        return prefix;
    }

    private int nsPrefixSuffix;

    private String prefix(String nameSpace, String preference) throws XMLStreamException {
        if (preference != null) {
            String bound = writer.getNamespaceContext().getNamespaceURI(preference);
            if (bound == null) {
                String prefix = writer.getPrefix(nameSpace);
                return prefix == null ? writeNamespace(preference, nameSpace) : prefix/* or null */;
            }
            if (bound.equals(nameSpace))
                return preference;
        }
        Object automaticNsPrefix = writer.getProperty(XMLOutputFactory.IS_REPAIRING_NAMESPACES);
        if (automaticNsPrefix != null && automaticNsPrefix.getClass() == Boolean.class // faster than instanceof since Boolean is final
                && ((Boolean) automaticNsPrefix).booleanValue())
            return null;
        String prefix = writer.getPrefix(nameSpace);
        if (prefix != null)
            return prefix; // or null
        NamespaceContext nameSpaces = writer.getNamespaceContext();
        do
            prefix = "CS" + nsPrefixSuffix++;
        while (nameSpaces.getNamespaceURI(prefix) != null);
        return writeNamespace(prefix, nameSpace);
    }

    void writeGlobalAttribute(String prefix, String nameSpace, String name, String value) throws XMLStreamException {
        prefix = prefix(nameSpace, prefix);
        if (prefix == null)
            writer.writeAttribute(nameSpace, name, value);
        else
            writer.writeAttribute(prefix, nameSpace, name, value);
    }
    
    XSDHelper xsdHelper;

    protected final void writeAttribute(Property property, String value) throws XMLStreamException {
        String name = xsdHelper.getLocalName(property), nameSpace = xsdHelper.getNamespaceURI(property);
        // TODO "" for no-NameSpace global attribute
        if (nameSpace == null)
            writer.writeAttribute(name, value);
        else
            writeGlobalAttribute(null, nameSpace, name, value);
    }

    private String lineBreak, indent, margin;

    private int nest;

    private void breakLine() throws XMLStreamException {
        writer.writeCharacters(lineBreak);

        if (margin != null)
            writer.writeCharacters(margin);

        if (indent != null)
            for (int count = nest; count != 0; --count)
                writer.writeCharacters(indent);
    }

    private Map options;

    static private final String STRING_OPTION = "String option";

    void startElement() throws XMLStreamException {
        if (options == null)
            return;
        if (lineBreak == STRING_OPTION)
            lineBreak = (String) options.get(OPTION_LINE_BREAK);
        if (lineBreak == null)
            return;
        if (margin == STRING_OPTION)
            margin = (String) options.get(OPTION_MARGIN);
        if (indent == STRING_OPTION)
            indent = (String) options.get(OPTION_INDENT);
        breakLine();
    }

    void writeStartElement(String prefix, String nameSpace, String name) throws XMLStreamException {
        startElement();
        if (nameSpace == null)
            writer.writeStartElement(name);
        else {
            prefix = prefix(nameSpace, prefix);
            if (prefix == null)
                writer.writeStartElement(nameSpace, name);
            else
                writer.writeStartElement(prefix, name, nameSpace);
        }
    }

    void writeStartElement(Property property) throws XMLStreamException {
        ++nest;
        writeStartElement(null, xsdHelper.getNamespaceURI(property),// TODO "" for no-NameSpace global element
                xsdHelper.getLocalName(property));
    }

    static protected final String CREATE_ATTRIBUTE = "create", DELETE_ATTRIBUTE = "delete", LOGGING_ATTRIBUTE = "logging", REF_ATTRIBUTE = "ref", UNSET = "unset";

    static private StringBuffer step(String nameSpace, String name, StringBuffer path) {
        return nameSpace == null ? path.append(name) : path.append("*:").append(name).append("[namespace-uri()='").append(nameSpace).append("']"); // *:name[namespace-uri()='nameSpace']
    }

    private StringBuffer step(Property containmentProperty, StringBuffer path) {
        return step(xsdHelper.getNamespaceURI(containmentProperty),// TODO "" for no-NameSpace global element
                xsdHelper.getLocalName(containmentProperty), path);
    }

    private StringBuffer step(Property containmentProperty) {
        return step(containmentProperty, new StringBuffer());
    }

    private DataObject dataObject;

    private StringBuffer step(Property containmentProperty, Object container) {
        StringBuffer step = step(containmentProperty);
        if (containmentProperty.isMany())
            step.append('[').append(((DataObject) container).getList(containmentProperty).indexOf(dataObject) + 1).append(']');
        return step;
    }

    private String pathRootObject;
    private DataObject rootObject;

    private String path() {
        if (pathRootObject == STRING_OPTION)
            pathRootObject = options == null ? null : (String) options.get(OPTION_RootObject_PATH);
        if (pathRootObject != null && dataObject == rootObject)
            return null;
        EObject container = ((EObject) dataObject).eContainer();
        if (!(container instanceof DataObject))
            return null;
        Property containmentProperty = dataObject.getContainmentProperty();
        StringBuffer step = step(containmentProperty, container);
        String path;
        while (true) {
            path = step.toString();
            dataObject = (DataObject) container;
            if (pathRootObject != null && container == rootObject)
                return path;
            container = container.eContainer();
            if (!(container instanceof DataObject))
                return path;
            containmentProperty = dataObject.getContainmentProperty();
            step = step(containmentProperty, container).append('/').append(path);
        }
    }

    /*
     * not to support DataGraph 3-1 private org.eclipse.emf.ecore.resource.Resource rootResource;
     */

    private String rootElement;

    String ref() {
        /*
         * not to support DataGraph 3-2 if (rootResource != null) return rootResource.getURIFragment((EObject) dataObject);
         */
        String id = EcoreUtil.getID((EObject) dataObject);
        if (id != null)
            return id;
        id = path();
        if (pathRootObject == null)
            return id == null ? "#/" + rootElement // descendant-or-self::node()
            : "#//" + id;
        return id == null ? pathRootObject/* + "."*/ : pathRootObject + id;
    }

    void writeRef(String ref) throws XMLStreamException {
        writer.writeAttribute(SDOAnnotations.COMMONJ_SDO_NS, REF_ATTRIBUTE, ref);
    }

    void writeRef() throws XMLStreamException {
        writeRef(ref());
    }

    void writeEndElement(String lineBreak) throws XMLStreamException {
        if (lineBreak != null)
            breakLine();
        writer.writeEndElement();
        --nest;
    }

    private StringBuffer pathDeleted/* = null */;

    private Collection modifiedDataObjects;
    
    private int lengthDeleted;

    private String nsElementCS, nameElementCS;

    private ChangeSummary changeSummary;

    String refDeleted() {
        String id = EcoreUtil.getID((EObject) dataObject);
        if (id != null)
            return id;
        id = path(); // "dataObject" is updated too!!
        DataObject deletedDataObject = dataObject;
        
        /*
         * construct "#//...changeSummary/"
         *  output: pathDeleted
         */
        if (lengthDeleted == -1) {
            String path = pathRootObject == null ? "#//" : pathRootObject;
            if (pathDeleted == null)
                pathDeleted = new StringBuffer(path);
            else
                pathDeleted.replace(0, pathDeleted.length(), path);
            dataObject = rootObject;
            path = path();
            if (path != null)
                pathDeleted.append(path).append('/');
            step(nsElementCS, nameElementCS, pathDeleted).append('/');
            lengthDeleted = pathDeleted.length();
        } else
            pathDeleted.delete(lengthDeleted, pathDeleted.length());
        
        dataObject = changeSummary.getOldContainer(deletedDataObject);
        Property containmentProperty = dataObject.getContainmentProperty();
        String name = containmentProperty == null ? rootElement : xsdHelper.getLocalName(containmentProperty);
        int index = 1;
        for (Iterator iterator = modifiedDataObjects.iterator(); iterator.hasNext();) {
            DataObject modifiedDataObject = (DataObject) iterator.next();
            if (modifiedDataObject == dataObject)
                break;
            Property property = modifiedDataObject.getContainmentProperty();
            if (property == containmentProperty || name.equals(property == null ? rootElement : xsdHelper.getLocalName(property)))
                ++index;
        }
        pathDeleted/*.append("*:")*/.append(name).append('[').append(index).append("]/");
        containmentProperty = changeSummary.getOldContainmentProperty(deletedDataObject);
        // assert containmentProperty != null;
        step(containmentProperty, pathDeleted);
        if (containmentProperty.isMany())
            pathDeleted.append('[').append(
                    ((List) changeSummary.getOldValue(dataObject, containmentProperty).getValue()).indexOf(deletedDataObject) + 1).append(']');
        if (id != null)
            pathDeleted.append('/').append(id);
        return pathDeleted.toString();
    }

    static String convertToString(Property property, Object value) {
        return EcoreUtil.convertToString((EDataType) property.getType(), value);
    }

    void writeRefDeleted() throws XMLStreamException {
        writeRef(refDeleted());
    }

    Collection deletedDataObjects;
    static final String XSI = "http://www.w3.org/2001/XMLSchema-instance", XSI_PREFIX = "xsi", TYPE = "type";

    protected final void writeElement(Object value, Property property) throws XMLStreamException {
        if (value == null) {
            writeStartElement(property);
            writeGlobalAttribute(XSI_PREFIX, XSI, "nil", "true");
            writeEndElement(null);
        } else if (value instanceof DataObject) {
            dataObject = (DataObject) value;
            if (!changeSummary.isDeleted(dataObject)) {
                writeStartElement(property);
                writeRef();
                writeEndElement(null);
            } else if (property.isContainment() && deletedDataObjects.contains(dataObject)) {
                ++nest;
                startElement();
                --nest;
                new XMLStreamSerializer().serialize(new XMLDocumentStreamReader(new DataObjectXMLStreamReader(property, dataObject, null,
                        xsdHelper)), writer);
            } else {
                writeStartElement(property);
                writeRefDeleted();
                writeEndElement(null);
            }
        } else {
            writeStartElement(property);
            writer.writeCharacters(convertToString(property, value));
            writeEndElement(null);
        }
    }
    
    static protected List optimize(List values, Object featureChange, int size) {
        int fromIndex = size, toIndex = 0;
        for (Iterator changes = ((FeatureChange) featureChange).getListChanges().iterator(); changes.hasNext();) {
            ListChange change = (ListChange) changes.next();
            Object kind = change.getKind();
            if (kind == ChangeKind.MOVE_LITERAL)
                return values;
            int index = change.getIndex();
            if (kind == ChangeKind.ADD_LITERAL) {
                if (index == 0) {
                    fromIndex = 0;
                    if (toIndex == 0)
                        toIndex = 1;
                } else {
                    int to = index;
                    if (--index < fromIndex)
                        fromIndex = index;
                    if (++to > toIndex)
                        toIndex = to;
                    else if (to < toIndex)
                        ++toIndex;
                }
                ++size;
            } else {
                --size;
                if (index < fromIndex)
                    fromIndex = index;
                if (index < toIndex)
                    --toIndex;
                else if (index > toIndex && index != size)
                    toIndex = index;
            }
        }
        return values.subList(fromIndex, toIndex);
    }
    
    static protected final Object CHANGE_SUMMARY = SDOPackage.eINSTANCE.getChangeSummary();

    /**
     * Line Break String such as "\n", "\r\n" and "\r", absent/null is the default (no Line Breaking)
     */
    static public final String OPTION_LINE_BREAK = "LineBreak",
    /**
     * Indent String such as " ", "\t", etc. Absent/null is the default (no indentation)
     */
    OPTION_INDENT = "indent",
    /**
     * Margin String such as " ", "\t\t", etc. Absent/null is the default (no margin)
     */
    OPTION_MARGIN = "margin",
    /**
     * Root Object path String such as "#", etc. Absent/null is the default (automatic computation)
     */
    OPTION_RootObject_PATH = "RootObject path",
    /**
     * Boolean to  sequence/list/array. Absent/null/Boolean.FALSE is the default (no optimization)
     */
    OPTION_OPTIMIZE_LIST = "optimize sequence/list/array";

    /**
     * Exports ChangeSummary
     * 
     * @param changeSummary
     *            Never null
     * @param elementCS
     *            changeSummary element; the NameSpace can be empty if no NameSpace, or null if local element; the prefix can be null(no preference)
     * @param writer
     *            Never null
     * @param rootElement
     *            Element QName if the changeSummary Root Object is a Document Root; the NameSpace can be empty, never null; the prefix is ignored
     * @param options
     *            {@link #OPTION_LINE_BREAK}, {@link #OPTION_INDENT}, {@link #OPTION_MARGIN}, {@link #OPTION_RootObject_PATH}, {@link #OPTION_OPTIMIZE_LIST} and XMLResource.OPTION_EXTENDED_META_DATA; can be null or empty
     */
    public final void saveChangeSummary(ChangeSummary changeSummary, QName elementCS, XMLStreamWriter writer, QName rootElement, Map options)
            throws XMLStreamException {
        /*
         * 6-1. Group created, deleted and modified DataObjects
         *  input: changeSummary output: createdDataObjects, deletedDataObjects & modifiedDataObjects
         *  implement: careful if compute from changeSummary.getChangedDataObjects() since it also includes children of deleted objects (thank Frank)
         */
        if (changeSummary.isLogging())
            ((ChangeSummaryImpl) changeSummary).summarize();
        ChangeDescription changeDescription = (ChangeDescription) changeSummary;
        Iterator createdDataObjects = changeDescription.getObjectsToDetach().iterator();
        deletedDataObjects = changeDescription.getObjectsToAttach();
        modifiedDataObjects = changeDescription.getObjectChanges().keySet(); // may contain DO(s) from createdDataObjects and/or deletedDataObjects

        /*
         * 6-2. Prepare to compute (X)Path
         *  input: changeSummary
         *  output: rootResource
         */
        /*not to support DataGraph 3-3
        Object dataGraph = changeSummary.getDataGraph();
        if (dataGraph == null) {
            DataObject rootObject = changeSummary.getRootObject();
            // assert rootObject != null;
            rootResource = rootObject.getContainer() == null ? ((EObject) rootObject).eResource() // Can be null since this *StAX* writer does NOT
                    // require rootObject contained by an *EMF* Resource
                    : null; // eResource() direct content may not necessarily always be the XML document
        } else
            // assert dataGraph instanceof DataGraphImpl;
            rootResource = ((org.apache.tuscany.sdo.impl.DataGraphImpl) dataGraph).getRootResource(); */

        /*
         * 6-2. Start ChangeSummary element
         *  input: writer, options, elementCS, changeSummary & changeDescription (6-1)
         */
        nsPrefixSuffix = 0;
        this.writer = writer;
        this.options = options;
        lineBreak = "";
        indent = margin = pathRootObject = STRING_OPTION;
        nest = 0;
        nsElementCS = elementCS.getNamespaceURI();
        nameElementCS = elementCS.getLocalPart();
        writeStartElement(elementCS.getPrefix(), nsElementCS, nameElementCS);
        lineBreak = STRING_OPTION;
        rootObject = changeSummary.getRootObject();
        ExtendedMetaData extendedMetaData = (ExtendedMetaData) options.get(XMLResource.OPTION_EXTENDED_META_DATA);
        if (extendedMetaData == null)
        {
            extendedMetaData = ExtendedMetaData.INSTANCE;
            xsdHelper = XSDHelper.INSTANCE;
        }
        else
            xsdHelper = new XSDHelperImpl(extendedMetaData, null);
        Property declaration = nsElementCS == null
                             ? rootObject.getType().getProperty(nameElementCS)
                             : xsdHelper.getGlobalProperty(nsElementCS, nameElementCS, true);
        if (declaration != null)
        {
            EClassifier type = changeDescription.eClass();
            if (type != declaration.getType() && type != CHANGE_SUMMARY)
            {
                writeGlobalAttribute(XSI_PREFIX, XSI, TYPE, new StringBuffer(prefix(extendedMetaData.getNamespace(type), null))
                        .append(':').append(extendedMetaData.getName(type)).toString());
            }
        }
        
        /*
         * 6-3. "create" attribute
         *  input: createdDataObjects (6-1), rootResource (6-2), changeSummary & writer
         */
        this.rootElement = rootElement.getLocalPart();
        this.changeSummary = changeSummary;
        if (createdDataObjects.hasNext()) {
            StringBuffer buffer = new StringBuffer();
            while (true) {
                dataObject = (DataObject) createdDataObjects.next();
                buffer.append(ref());
                if (!createdDataObjects.hasNext())
                    break;
                buffer.append(' ');
            }
            writer.writeAttribute(CREATE_ATTRIBUTE, buffer.toString());
        }

        /*
         * 6-4. "delete" attribute
         *  input: deletedDataObjects (6-1), modifiedDataObjects (6-1), rootElement & writer
         */
        Iterator iterator = deletedDataObjects.iterator();
        if (iterator.hasNext()) {
            lengthDeleted = -1;
            StringBuffer buffer = new StringBuffer();
            while (true) {
                dataObject = (DataObject) iterator.next();
                buffer.append(refDeleted());
                if (!iterator.hasNext())
                    break;
                buffer.append(' ');
            }
            writer.writeAttribute(DELETE_ATTRIBUTE, buffer.toString());
        }

        /*
         * 6-5. "logging" attribute
         *  input: changeSummary & writer
         */
        writer.writeAttribute(LOGGING_ATTRIBUTE, changeSummary.isLogging() ? "true" : "false");

        /*
         * 6-6. Modified DataObjects
         *  input: modifiedDataObjects (6-1), rootResource (6-2), changeSummary & writer
         */
        iterator = modifiedDataObjects.iterator();
        if (iterator.hasNext()) {
            boolean optimizeList;
            if (options == null)
                optimizeList = false;
            else
            {
                Object option = options.get(OPTION_OPTIMIZE_LIST);
                optimizeList = option == null ? false : ((Boolean)option).booleanValue();
            }
            prefix(SDOAnnotations.COMMONJ_SDO_NS, SDOPackage.eNS_PREFIX);
            do {
                DataObject container = dataObject = (DataObject) iterator.next();
                Collection oldValues = changeSummary.getOldValues(dataObject);
                if (deletedDataObjects.contains(dataObject)) {
                    writeStartElement(changeSummary.getOldContainmentProperty(dataObject));
                    writeRefDeleted();
                } else {
                    Property containmentProperty = dataObject.getContainmentProperty();
                    if (containmentProperty == null) {
                        ++nest;
                        startElement();
                        writer.writeStartElement(rootElement.getNamespaceURI(), rootElement.getLocalPart());
                    } else
                        writeStartElement(containmentProperty);
                    writeRef();
                }
                String lineBreak = null;
                Iterator settings = oldValues.iterator();
                if (settings.hasNext()) {
                    do {
                        ChangeSummary.Setting oldValue = (ChangeSummary.Setting) settings.next();
                        if (oldValue.isSet())
                            continue;
                        StringBuffer unset = step(oldValue.getProperty());
                        while (settings.hasNext()) {
                            oldValue = (ChangeSummary.Setting) settings.next();
                            if (!oldValue.isSet())
                                step(oldValue.getProperty(), unset.append(' '));
                        }
                        writer.writeAttribute(SDOAnnotations.COMMONJ_SDO_NS, UNSET, unset.toString());
                        break;
                    } while (settings.hasNext());
                    for (settings = oldValues.iterator(); settings.hasNext();) {
                        ChangeSummary.Setting oldValue = (ChangeSummary.Setting) settings.next();
                        Property property = oldValue.getProperty();
                        if (oldValue.isSet() && xsdHelper.isAttribute(property))
                            // assert ! property.isMany();
                            writeAttribute(property, convertToString(property, oldValue.getValue()));
                    }
                    for (settings = oldValues.iterator(); settings.hasNext();) {
                        ChangeSummary.Setting oldValue = (ChangeSummary.Setting) settings.next();
                        Property property = oldValue.getProperty();
                        if (!xsdHelper.isAttribute(property))
                            if (property.isMany()) {
                                List list = (List) oldValue.getValue();
                                if (optimizeList)
                                    list = optimize(list, oldValue, container.getList(property).size());
                                Iterator values = list.iterator();
                                if (values.hasNext()) {
                                    do
                                        writeElement(values.next(), property);
                                    while (values.hasNext());
                                    lineBreak = this.lineBreak;
                                }
                            } else if (oldValue.isSet()) {
                                writeElement(oldValue.getValue(), property);
                                lineBreak = this.lineBreak;
                            }
                    }
                }
                writeEndElement(lineBreak);
            } while (iterator.hasNext());
            writeEndElement(lineBreak);
        } else
            writeEndElement(null);
        writer.flush();
    }
}