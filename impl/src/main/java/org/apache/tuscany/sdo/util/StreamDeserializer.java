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
package org.apache.tuscany.sdo.util;

import java.util.Comparator;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

import org.apache.tuscany.sdo.util.resource.RecordedEventXMLStreamReader;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xml.type.internal.QName;

/**
 * StAX Deserializer. The instance isn't thread-safe, however it's safe to use the instance any times on the same thread.
 */
public class StreamDeserializer implements XMLStreamConstants {
    protected XMLStreamReader reader;

    protected final XMLStreamReader play(RecordedEventXMLStreamReader.Tag tag) {
        return tag.play(reader);
    }

    protected String nameSpace, name;

    protected final boolean typedXSI() {
        name = reader.getAttributeValue(ExtendedMetaData.XSI_URI, XMLResource.TYPE);
        if (name == null)
            return false;
        int index = name.indexOf(':');
        if (index == -1)
            nameSpace = reader.getNamespaceURI(XMLConstants.DEFAULT_NS_PREFIX); // may be XMLConstants.NULL_NS_URI
        else {
            nameSpace = reader.getNamespaceURI(name.substring(0, index));
            name = name.substring(++index);
        }
        return true;
    }

    static protected Object value(Object type, String literal, NamespaceContext nameSpaces) {
        Object value = EcoreUtil.createFromString((EDataType) type, literal);
        if (!(value instanceof QName))
            return value;
        QName qName = (QName) value;
        qName.setNamespaceURI(nameSpaces.getNamespaceURI(qName.getPrefix()));
        return value;
    }

    static public class Attribute {
        public String name, value;
    }

    static public final class QualifiedAttribute extends Attribute {
        public String nameSpace;
    }

    static protected final Comparator EQUAL_NULL = new Comparator() {
        public int compare(Object v, Object NULL) {
            return v == null || v.equals(null) ? 0 : 1;
        }
    }, EQUAL = new Comparator() {
        public int compare(Object v, Object value) {
            return value.equals(v) ? 0 : -1;
        }
    }, SAME = new Comparator() {
        public int compare(Object v, Object value) {
            return value == v ? 0 : -1;
        }
    };
}
