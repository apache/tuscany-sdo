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

import javax.xml.stream.*;

import commonj.sdo.*;
import commonj.sdo.helper.*;

import org.apache.tuscany.sdo.helper.*;
import org.apache.tuscany.sdo.util.StreamDeserializer;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.util.*;
import org.eclipse.emf.ecore.xmi.XMLResource;

/**
 * SDO StAX Deserializer. The instance isn't thread-safe, however it's safe to use the instance any times on the same thread.
 */
public class SDODeserializer extends StreamDeserializer {
    protected final void initialize(XMLStreamReader stream, HelperContext scope, Object rootObject) {
        reader = stream;
        xsdHelper = scope.getXSDHelper();
        typeHelper = scope.getTypeHelper();
        deserializer = null;
        root = (EObject) rootObject;
    }

    XSDHelper xsdHelper;

    protected final Property getProperty(Type type, String nameSpace, String name) {
        for (Iterator iterator = type.getProperties().iterator(); iterator.hasNext();) {
            Property property = (Property) iterator.next();
            if (nameSpace.equals(xsdHelper.getNamespaceURI(property)) && name.equals(xsdHelper.getLocalName(property)))
                return property;
        }
        return null; // TODO substitutionGroup & any
    }

    protected final Property getProperty(String nameSpace, String name, Type type) {
        return nameSpace == null ? type.getProperty(name) : getProperty(type, nameSpace, name);
        // if (property == null) report error?
    }

    XMLStreamHelperImpl deserializer;

    TypeHelper typeHelper;

    protected Object load(XMLStreamReader reader, Map options) throws XMLStreamException {
        if (deserializer == null)
            deserializer = new XMLStreamHelperImpl(typeHelper);
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

    protected final Object value(Property property, XMLStreamReader reader) throws XMLStreamException {
        Type propertyType = property.getType();
        if (propertyType.isDataType())
            return value(propertyType, reader);
        if (options == null)
            options = new HashMap();
        options.put(XMLStreamHelper.OPTION_DEFAULT_ROOT_TYPE, propertyType);
        return load(reader, options);
    }

    EObject root;

    static EObject step(String ref, int step, int index, EObject container, ExtendedMetaData extendedMetaData) {
        String name = ref.substring(step, index);
        for (Iterator iterator = container.eContents().iterator(); iterator.hasNext();) {
            container = (EObject) iterator.next();
            // if( container == null )continue;
            if (name.equals(extendedMetaData.getName(container.eContainmentFeature())))
                return container;
        }
        return null;
    }

    protected EObject referent(String ref) {
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
        ExtendedMetaData extendedMetaData = ((TypeHelperImpl) typeHelper).getExtendedMetaData();
        for (int index = step; ++index != length;) {
            switch (ref.charAt(index)) {
            case '/':
                container = step(ref, step, index, container, extendedMetaData);
                if (container == null)
                    return null;
                break;
            default:
                continue;
            case '[':
                name = ref.substring(step, index);
                step = ref.indexOf(']', index + 2);
                if (step == -1)
                    return null;
                index = Integer.parseInt(ref.substring(++index, step));
                EStructuralFeature feature;
                for (Iterator iterator = container.eContents().iterator();/* true */;) {
                    if (!iterator.hasNext())
                        return null;
                    EObject content = (EObject) iterator.next();
                    // if( content == null )continue;
                    feature = content.eContainmentFeature();
                    if (name.equals(extendedMetaData.getName(feature)))
                        break;
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
        }
        return step(ref, step, length, container, extendedMetaData);
    }

    protected final Type typeXSI() {
        return typedXSI() ? typeHelper.getType(nameSpace, name) : null;
    }

    protected final Type globalElementType(String name) {
        return xsdHelper.getGlobalProperty(nameSpace, name, true).getType();
    }
}