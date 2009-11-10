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

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.tuscany.sdo.helper.HelperContextImpl;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;
import org.apache.tuscany.sdo.helper.XMLStreamHelper;
import org.apache.tuscany.sdo.helper.XMLStreamHelperImpl;
import org.apache.tuscany.sdo.util.StreamDeserializer;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLResource;

import commonj.sdo.Property;
import commonj.sdo.Type;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XSDHelper;

/**
 * SDO StAX Deserializer. The instance isn't thread-safe, however it's safe to use the instance any times on the same thread.
 */
public class SDODeserializer extends StreamDeserializer {
	private HelperContext hc;
    protected final void initialize(XMLStreamReader stream, HelperContext scope, Object rootObject) {
    	hc = scope;
        reader = stream;
        xsdHelper = scope.getXSDHelper();
        typeHelper = scope.getTypeHelper();
        extendedMetaData = ((TypeHelperImpl) typeHelper).getExtendedMetaData();
        deserializer = (XMLStreamHelperImpl)((HelperContextImpl)scope).getXMLStreamHelper();;
        root = (EObject) rootObject;
    }

    XSDHelper xsdHelper;

    protected Property propertyInSequence;

    Property getProperty(Object type) {
        EClass c = (EClass) type;
        EStructuralFeature containment = (EStructuralFeature) propertyInSequence;
        Object containing = extendedMetaData.getAffiliation(c, containment);
        // if (containing == null) report error?
        if (containment == containing && containment.isDerived()) {
            containing = extendedMetaData.getMixedFeature(c);
            if (containing == null) {
                containing = extendedMetaData.getGroup(containment);
                if (containing == null)
                    return propertyInSequence;
            }
        }
        return (Property) containing;
    }

    protected final Property getProperty(Type type, String nameSpace, String name, boolean element) {
        for (Iterator iterator = type.getProperties().iterator(); iterator.hasNext();) {
            propertyInSequence = (Property) iterator.next();
            if (name.equals(xsdHelper.getLocalName(propertyInSequence))
                    && nameSpace.equals(xsdHelper.getNamespaceURI(propertyInSequence)))
                return getProperty(type);
        }
        propertyInSequence = xsdHelper.getGlobalProperty(nameSpace, name, element);
        // if (propertyInSequence == null) report error?
        return getProperty(type);
    }

    protected final Property getProperty(Type type, String name) {
        propertyInSequence = type.getProperty(name);
        // if (propertyInSequence == null) report error?
        return getProperty(type);
    }

    protected final Property getProperty(String nameSpace, String name, Type type) {
        return null == nameSpace ? getProperty(type, name) : getProperty(type, nameSpace, name, true);
    }

    XMLStreamHelperImpl deserializer;

    TypeHelper typeHelper;

    protected Object load(XMLStreamReader reader, Map options) throws XMLStreamException {
        return deserializer.loadObject(reader, options);
    }

    static Object value(Type type, XMLStreamReader reader) throws XMLStreamException {
        return value(type, reader.getElementText(), reader.getNamespaceContext());
    }

    protected final Object value(Type type) throws XMLStreamException {
        return "true".equals(reader.getAttributeValue(ExtendedMetaData.XSI_URI, XMLResource.NIL)) ? null : type.isDataType() ? value(type, reader)
                : load(reader, null);
    }

    Map options/* = null */;

    protected final Object value(XMLStreamReader reader) throws XMLStreamException {
        Type propertyType = propertyInSequence.getType();
        if (propertyType.isDataType())
            return value(propertyType, reader);
        if (options == null)
            options = new HashMap();
        options.put(XMLStreamHelper.OPTION_DEFAULT_ROOT_TYPE, propertyType);
        return load(reader, options);
    }

    private boolean match(String name, String space, EStructuralFeature feature) {
        return name.equals(extendedMetaData.getName(feature)) && space.equals(extendedMetaData.getNamespace(feature));
    }

    EObject step(String ref, int step, int index, EObject container, String prefix, NamespaceContext nameSpaces) {
        String name = ref.substring(step, index);
        Iterator iterator = container.eContents().iterator();
        if (iterator.hasNext())
            if (prefix == null)
                do {
                    container = (EObject) iterator.next();
                    // if( container == null )continue;
                    if (name.equals(extendedMetaData.getName(container.eContainmentFeature())))
                        return container;
                } while (iterator.hasNext());
            else {
                prefix = nameSpaces.getNamespaceURI(prefix);
                do {
                    container = (EObject) iterator.next();
                    // if( container == null )continue;
                    if (match(name, prefix, container.eContainmentFeature()))
                        return container;
                } while (iterator.hasNext());
            }
        return null;
    }

    EObject root;
    
    ExtendedMetaData extendedMetaData;

    protected final EObject referent(String ref, NamespaceContext nameSpaces) {
        int length = ref.length();
        switch (length) {
        case 0:
            return null;
        case 1: // #
            return root;
        }
        EObject container;
        int step;
        if (ref.charAt(1) == '/') {
            container = EcoreUtil.getRootContainer(root);
            if (length == 2)
                return container;
            if (ref.charAt(2) == '/') {
                for (Iterator iterator = container.eContents().iterator();/* true */;) {
                    if (!iterator.hasNext())
                        return null;
                    container = (EObject) iterator.next();
                    // if( container != null )
                    break;
                }
                /*#// is invalid
                if (length == 3)
                    return container; */
                step = 3;
            } else
                step = 2;
        } else {
            container = root;
            step = 1;
        }
        String prefix = null;
        for (int index = step; ++index != length;) {
            switch (ref.charAt(index)) {
            case '/':
                container = step(ref, step, index, container, prefix, nameSpaces);
                if (container == null)
                    return null;
                break;
            case ':':
                prefix = ref.substring(step, index);
                if (++index == length)
                    return container; // report error?
                step = index;
            default:
                continue;
            case '[':
                name = ref.substring(step, index);
                step = ref.indexOf(']', index + 2);
                if (step == -1)
                    return container; // report error?
                index = Integer.parseInt(ref.substring(++index, step));
                EStructuralFeature feature;
                Iterator iterator = container.eContents().iterator();
                if (prefix == null)
                    do {
                        if (!iterator.hasNext())
                            return null;
                        EObject content = (EObject) iterator.next();
                        // if( content == null )continue;
                        feature = content.eContainmentFeature();
                    } while (!name.equals(extendedMetaData.getName(feature)));
                else {
                    prefix = nameSpaces.getNamespaceURI(prefix);
                    do {
                        if (!iterator.hasNext())
                            return null;
                        EObject content = (EObject) iterator.next();
                        // if( content == null )continue;
                        feature = content.eContainmentFeature();
                    } while (!match(name, prefix, feature));
                }
                Object value = container.eGet(feature);
                if (value instanceof List) {
                    List values = (List) value;
                    if (index > values.size())
                        return null;
                    container = (EObject) values.get(--index);
                } else if (index == 1)
                    container = (EObject) value;
                else
                    return null;
                index = ref.indexOf('/', ++step);
                if (index == -1)
                    return container;
            }
            if (++index == length)
                return container;
            step = index;
            prefix = null;
        }
        return step(ref, step, length, container, prefix, nameSpaces);
    }

    static protected class Ref implements EObject // FeatureMapEntry value
    {
        protected Ref(String path, NamespaceContext context) {
            ref = path;
            nameSpaces = context;
        }

        final String ref;

        final NamespaceContext nameSpaces;

        public TreeIterator eAllContents() {
            return null;
        }
        public EClass eClass() {
            return null;
        }
        public EObject eContainer() {
            return null;
        }
        public EStructuralFeature eContainingFeature() {
            return null;
        }
        public EReference eContainmentFeature() {
            return null;
        }
        public EList eContents() {
            return null;
        }
        public EList eCrossReferences() {
            return null;
        }
        public Object eGet(EStructuralFeature feature) {
            return null;
        }
        public Object eGet(EStructuralFeature feature, boolean resolve) {
            return null;
        }
        public boolean eIsProxy() {
            return false;
        }
        public boolean eIsSet(EStructuralFeature feature) {
            return false;
        }
        public Resource eResource() {
            return null;
        }
        public void eSet(EStructuralFeature feature, Object newValue) {
        }
        public void eUnset(EStructuralFeature feature) {
        }
        public EList eAdapters() {
            return null;
        }
        public boolean eDeliver() {
            return false;
        }
        public void eNotify(Notification notification) {
        }
        public void eSetDeliver(boolean deliver) {
        }
    }

    protected final EObject referent(Ref path) {
        return referent(path.ref, path.nameSpaces);
    }

    protected final Type typeXSI() {
        return typedXSI() ? typeHelper.getType(nameSpace, name) : null;
    }

    protected final Type globalElementType(String nameSpace, String name) {
        return xsdHelper.getGlobalProperty(nameSpace, name, true).getType();
    }
}
