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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;

import org.apache.tuscany.sdo.impl.AttributeImpl;
import org.apache.tuscany.sdo.impl.ReferenceImpl;
import org.apache.tuscany.sdo.util.SDOUtil;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.Type;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XSDHelper;

public class DataObjectXMLStreamReader implements XMLFragmentStreamReader {
    private static final QName XSI_TYPE_QNAME = new QName("http://www.w3.org/2001/XMLSchema-instance", "type", "xsi");
    private Property rootElement = null;
    private DataObject dataObject;

    private String rootElementURI;

    private String rootElementName;
    
    private DataObject serializeRoot;

    private TypeHelper typeHelper;

    private XSDHelper xsdHelper;

    private Map.Entry[] properties;

    private Map.Entry[] attributes;

    private QName elementQName;

    // we always create a new namespace context
    private NameSpaceContext namespaceContext;

    private Map declaredNamespaceMap = new HashMap();

    // states for this pullparser - it can only have three states
    private static final int START_ELEMENT_STATE = 0;

    private static final int END_ELEMENT_STATE = 1;

    private static final int DELEGATED_STATE = 2;

    private static final int TEXT_STATE = 3;

    // integer field that keeps the state of this
    // parser.
    private int state = START_ELEMENT_STATE;

    // reference to the child reader
    private XMLFragmentStreamReader childReader;

    // current property index
    // initialized at zero
    private int currentPropertyIndex = 0;

    public DataObjectXMLStreamReader(DataObject dataObject, String rootElmentURI, String rootElementName) {
        this(dataObject, rootElmentURI, rootElementName, null, null);
    }

    public DataObjectXMLStreamReader(DataObject dataObject, String rootElmentURI, String rootElementName, TypeHelper typeHelper) {
        this(dataObject, rootElmentURI, rootElementName, typeHelper, null);
    }

    public DataObjectXMLStreamReader(DataObject dataObject, String rootElmentURI, String rootElementName, TypeHelper typeHelper, XSDHelper xsdHelper) {
        this.dataObject = dataObject;
        this.rootElementURI = rootElmentURI;
        this.rootElementName = rootElementName;
        this.serializeRoot = dataObject;
        this.typeHelper = typeHelper == null ? TypeHelper.INSTANCE : typeHelper;
        this.xsdHelper = (xsdHelper != null) ? xsdHelper : ((typeHelper == null) ? XSDHelper.INSTANCE : SDOUtil.createXSDHelper(typeHelper));
        rootElement = this.xsdHelper.getGlobalProperty(rootElmentURI, rootElementName, true);
        namespaceContext = new NameSpaceContext();
        populateProperties();
    }

    protected DataObjectXMLStreamReader(TypeHelper typeHelper, XSDHelper xsdHelper, Property rootElement, DataObject dataObject) {
        this.typeHelper = typeHelper == null ? TypeHelper.INSTANCE : typeHelper;
        this.xsdHelper = (xsdHelper != null) ? xsdHelper : ((typeHelper == null) ? XSDHelper.INSTANCE : SDOUtil.createXSDHelper(typeHelper));
        this.rootElement = rootElement;
        this.dataObject = dataObject;
        this.rootElementURI = xsdHelper.getNamespaceURI(rootElement);
        this.rootElementName = xsdHelper.getLocalName(rootElement);
    }
    
    protected DataObjectXMLStreamReader(TypeHelper typeHelper, XSDHelper xsdHelper, Property rootElement, DataObject dataObject, DataObject serializeRoot) {
        this.typeHelper = typeHelper == null ? TypeHelper.INSTANCE : typeHelper;
        this.xsdHelper = (xsdHelper != null) ? xsdHelper : ((typeHelper == null) ? XSDHelper.INSTANCE : SDOUtil.createXSDHelper(typeHelper));
        this.rootElement = rootElement;
        this.dataObject = dataObject;
        this.serializeRoot = serializeRoot;
        this.rootElementURI = xsdHelper.getNamespaceURI(rootElement);
        this.rootElementName = xsdHelper.getLocalName(rootElement);
    }
    public DataObjectXMLStreamReader(Property rootElement, DataObject dataObject, TypeHelper typeHelper, XSDHelper xsdHelper) {
        this(typeHelper, xsdHelper, rootElement, dataObject);
        namespaceContext = new NameSpaceContext();
        populateProperties();
    }
    
    public DataObjectXMLStreamReader(XMLDocument document, TypeHelper typeHelper) {
        this.dataObject = document.getRootObject();
        this.rootElementName = document.getRootElementName();
        this.rootElementURI = document.getRootElementURI();
        this.serializeRoot = this.dataObject;
        this.typeHelper = typeHelper;
        this.xsdHelper = typeHelper == null ? XSDHelper.INSTANCE : SDOUtil.createXSDHelper(typeHelper);
        namespaceContext = new NameSpaceContext();
        populateProperties();
    }

    /*
     * we need to pass in a namespace context since when delegated, we've no idea of the current namespace context. So it needs to be passed on here!
     */
    protected DataObjectXMLStreamReader(QName elementQName, Map.Entry[] properties, Map.Entry[] attributes) {
        // validate the lengths, since both the arrays are supposed
        // to have
        this.properties = properties;
        this.elementQName = elementQName;
        this.attributes = attributes;
        namespaceContext = new NameSpaceContext();
    }

    private void addProperty(Property property, Object value, List propertyList) {
        if (property.isMany() && property.getContainingType().isOpen() && value instanceof Sequence) {
            addSequenceValue(propertyList, (Sequence) value);
        } else if (SDOUtil.isMany(property, dataObject) && value instanceof List) {
            addListValue(propertyList, property, (List) value);
        } else {
            // Complex Type
            addSingleValue(propertyList, property, value);
        }
    }

    void addProperty(List propertyList, Property property, Object value, Object type) {
        if (!isTransient(property, type))
            addProperty(property, value, propertyList);
    }

    private void addSequenceValue(List elements, Sequence seq) {
        if (seq != null && seq.size() > 0) {
            for (int j = 0; j < seq.size(); j++) {
                Object o = seq.getValue(j);
                Property p = seq.getProperty(j);
                addSingleValue(elements, p, o);
            }
        }
    }

    static private boolean isTransient(Property property, Object type) {
        // HACK: We need some SDOUtil extension to understand a property is derived
        EStructuralFeature feature = (EStructuralFeature) property;
        if (ExtendedMetaData.INSTANCE.getGroup(feature) != null)
            return false;
        feature = ExtendedMetaData.INSTANCE.getAffiliation((EClass) type, feature);
        if (feature != null && feature != property)
            return false;
        if (property instanceof ReferenceImpl) {
            ReferenceImpl r = (ReferenceImpl) property;
            if (r.isTransient())
                return true;
            EReference opposite = r.getEOpposite();
            if (opposite != null && opposite.isContainment()) {
                return true;
            }
        } else if (property instanceof AttributeImpl) {
            AttributeImpl a = (AttributeImpl) property;
            if (a.isTransient())
                return true;
            EDataType d = (EDataType) a.getEType();
            if (!d.isSerializable()) {
                return true;
            }
        }
        return false;
    }

    private void addListValue(List propertyList, Property property, List objList) {
        if (objList != null) {
            for (int j = 0; j < objList.size(); j++) {
                Object object = objList.get(j);
                addSingleValue(propertyList, property, object);
            }
        }
    }

    private void addSingleValue(List propertyList, Property property, Object value) {
        String uri = xsdHelper.getNamespaceURI(property);
        String name = xsdHelper.getLocalName(property);
        QName qname = namespaceContext.createQName(uri, name);
        Type propertyType = property.getType();

        if (property.getName().equals("value") && uri == null && name.equals(":0")) {
            // "value" is special property containing the value of simpleContent
            Map.Entry entry = new NameValuePair(ELEMENT_TEXT, value);
            propertyList.add(entry);
        } else

        // FIXME: We need to deal with non-containment properties
        if (value == null) {
            // Creating xsi:nil="true" for elements
            registerNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
            Map.Entry entry = new NameValuePair(qname, null);
            propertyList.add(entry);
        } else if (propertyType.isDataType()) {
            Map.Entry entry = new NameValuePair(qname, SDOUtil.convertToString(propertyType, value));
            propertyList.add(entry);
        } else if (property.isContainment() && value == serializeRoot) {
            // do not create the childReader because a containmentCycle exists and this is the second
            // time this DataObject has been encountered
        } else {
            DataObjectXMLStreamReader childReader = new DataObjectXMLStreamReader(typeHelper, xsdHelper, property, (DataObject) value, serializeRoot);
            childReader.namespaceContext = namespaceContext;
            childReader.populateProperties();
            childReader.rootElement = property;
            Map.Entry entry = new NameValuePair(qname, childReader);
            propertyList.add(entry);
        }
    }

    public void populateProperties() {
        /*declaredNamespaceMap.put("xml", "http://www.w3.org/XML/1998/namespace");
        declaredNamespaceMap.put("xmlns", "http://www.w3.org/2000/xmlns/");
        declaredNamespaceMap.put("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        */
        
        if (properties != null)
            return;
        if (elementQName == null)
            elementQName = namespaceContext.createQName(this.rootElementURI, this.rootElementName);
        else
            elementQName = namespaceContext.createQName(elementQName.getNamespaceURI(), elementQName.getLocalPart());

        List elementList = new ArrayList();
        List attributeList = new ArrayList();
        if (dataObject == null) {
            return;
        }
        Type type = dataObject.getType();
        
        // Add xsi:type if rootElement doesn't exist or the type is different
        if (rootElement == null || (rootElement != null && rootElement.getType() != type)) {
            // FIXME: XSDHelper.getLocalName() for annoymous type returns null?
            String typeName = xsdHelper.getLocalName(type);
            if (typeName != null) {
                QName realTypeName = namespaceContext.createQName(type.getURI(), typeName);
                String typeQName = realTypeName.getPrefix() + ":" + realTypeName.getLocalPart();
                registerNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
                registerNamespace(realTypeName.getPrefix(), realTypeName.getNamespaceURI());
                attributeList.add(new NameValuePair(XSI_TYPE_QNAME, typeQName));
            }
        }
        
        if (type.isSequenced()) {
            Sequence sequence = dataObject.getSequence();
            for (int i = 0; i < sequence.size(); i++) {
                Property property = sequence.getProperty(i);
                Object value = sequence.getValue(i);
                if (property == null) {
                    // property == null for text in mixed content
                    elementList.add(new NameValuePair(ELEMENT_TEXT, value));
                } else {
                    addProperty(property, value, elementList);
                }
            }
            // Attributes are not in the sequence
            List properties = dataObject.getInstanceProperties();
            for (Iterator i = properties.iterator(); i.hasNext();) {
                Property property = (Property) i.next();
                if (xsdHelper.isAttribute(property)) {
                    // FIXME: How to handle nilable=true?
                    if (!dataObject.isSet(property))
                        continue;
                    Object value = dataObject.get(property);
                    addProperty(attributeList, property, value, type);
                }
            }
        } else {
            List properties = dataObject.getInstanceProperties();
            for (Iterator i = properties.iterator(); i.hasNext();) {
                Property property = (Property) i.next();
                // FIXME: How to handle nilable=true?
                if (!dataObject.isSet(property))
                    continue;
                Object value = dataObject.get(property);
                if (xsdHelper.isAttribute(property))
                    addProperty(attributeList, property, value, type);
                else
                    addProperty(elementList, property, value, type);
            }
        }
        properties = (Map.Entry[]) elementList.toArray(new Map.Entry[0]);
        attributes = (Map.Entry[]) attributeList.toArray(new Map.Entry[0]);
    }

    public DataObject getDataObject() {
        return dataObject;
    }

    /**
     * we need to split out the calling to the populate namespaces seperately since this needs to be done *after* setting the parent namespace
     * context. We cannot assume it will happen at construction!
     */
    public void init() {
        // here we have an extra issue to attend to. we need to look at the
        // prefixes and uris (the combination) and populate a hashmap of
        // namespaces. The hashmap of namespaces will be used to serve the
        // namespace context

        populateNamespaceContext();
    }

    /**
     * 
     * @param key
     * @return
     * @throws IllegalArgumentException
     */
    public Object getProperty(String key) throws IllegalArgumentException {
        if (state == START_ELEMENT_STATE || state == END_ELEMENT_STATE) {
            return null;
        } else if (state == TEXT_STATE) {
            return null;
        } else if (state == DELEGATED_STATE) {
            return childReader.getProperty(key);
        } else {
            return null;
        }

    }

    public int next() throws XMLStreamException {
        return updateStatus();
    }

    public void require(int i, String string, String string1) throws XMLStreamException {
        throw new UnsupportedOperationException();
    }

    /**
     * todo implement the right contract for this
     * 
     * @return
     * @throws XMLStreamException
     */
    public String getElementText() throws XMLStreamException {
        if (state == DELEGATED_STATE) {
            return childReader.getElementText();
        } else {
            return null;
        }

    }

    /**
     * todo implement this
     * 
     * @return
     * @throws XMLStreamException
     */
    public int nextTag() throws XMLStreamException {
        return 0;
    }

    /**
     * @return
     * @throws XMLStreamException
     */
    public boolean hasNext() throws XMLStreamException {
        if (state == DELEGATED_STATE) {
            if (childReader.isEndOfFragment()) {
                // the child reader is done. We shouldn't be getting the
                // hasnext result from the child pullparser then
                return true;
            } else {
                return childReader.hasNext();
            }
        } else {
            return (state == START_ELEMENT_STATE || state == TEXT_STATE);

        }
    }

    public void close() throws XMLStreamException {
        // do nothing here - we have no resources to free
    }

    public String getNamespaceURI(String prefix) {
        return namespaceContext.getNamespaceURI(prefix);
    }

    public boolean isStartElement() {
        if (state == START_ELEMENT_STATE) {
            return true;
        } else if (state == END_ELEMENT_STATE) {
            return false;
        }
        return childReader.isStartElement();
    }

    public boolean isEndElement() {
        if (state == START_ELEMENT_STATE) {
            return false;
        } else if (state == END_ELEMENT_STATE) {
            return true;
        }
        return childReader.isEndElement();
    }

    public boolean isCharacters() {
        if (state == START_ELEMENT_STATE || state == END_ELEMENT_STATE) {
            return false;
        }
        return childReader.isCharacters();
    }

    public boolean isWhiteSpace() {
        if (state == START_ELEMENT_STATE || state == END_ELEMENT_STATE) {
            return false;
        }
        return childReader.isWhiteSpace();
    }

    // /////////////////////////////////////////////////////////////////////////
    // / attribute handling
    // /////////////////////////////////////////////////////////////////////////

    public String getAttributeValue(String nsUri, String localName) {

        int attribCount = getAttributeCount();
        String returnValue = null;
        QName attribQualifiedName;
        for (int i = 0; i < attribCount; i++) {
            attribQualifiedName = getAttributeName(i);
            if (nsUri == null) {
                if (localName.equals(attribQualifiedName.getLocalPart())) {
                    returnValue = getAttributeValue(i);
                    break;
                }
            } else {
                if (localName.equals(attribQualifiedName.getLocalPart()) && nsUri.equals(attribQualifiedName.getNamespaceURI())) {
                    returnValue = getAttributeValue(i);
                    break;
                }
            }

        }

        return returnValue;
    }

    public int getAttributeCount() {
        return (state == DELEGATED_STATE) ? childReader.getAttributeCount()
                : ((attributes != null) && (state == START_ELEMENT_STATE) ? attributes.length : 0);
    }

    /**
     * @param i
     * @return
     */
    public QName getAttributeName(int i) {
        if (state == DELEGATED_STATE) {
            return childReader.getAttributeName(i);
        } else if (state == START_ELEMENT_STATE) {
            if (attributes == null) {
                return null;
            } else {
                if ((i >= (attributes.length)) || i < 0) { // out of range
                    return null;
                } else {
                    // get the attribute pointer
                    Object attribPointer = attributes[i].getKey();
                    // case one - attrib name is null
                    // this should be the pointer to the OMAttribute then
                    if (attribPointer instanceof String) {
                        return new QName((String) attribPointer);
                    } else if (attribPointer instanceof QName) {
                        return (QName) attribPointer;
                    } else {
                        return null;
                    }
                }
            }
        } else {
            throw new IllegalStateException();// as per the api contract
        }

    }

    public String getAttributeNamespace(int i) {
        if (state == DELEGATED_STATE) {
            return childReader.getAttributeNamespace(i);
        } else if (state == START_ELEMENT_STATE) {
            QName name = getAttributeName(i);
            if (name == null) {
                return null;
            } else {
                return name.getNamespaceURI();
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public String getAttributeLocalName(int i) {
        if (state == DELEGATED_STATE) {
            return childReader.getAttributeLocalName(i);
        } else if (state == START_ELEMENT_STATE) {
            QName name = getAttributeName(i);
            if (name == null) {
                return null;
            } else {
                return name.getLocalPart();
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public String getAttributePrefix(int i) {
        if (state == DELEGATED_STATE) {
            return childReader.getAttributePrefix(i);
        } else if (state == START_ELEMENT_STATE) {
            QName name = getAttributeName(i);
            if (name == null) {
                return null;
            } else {
                return name.getPrefix();
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public String getAttributeType(int i) {
        return null; // not supported
    }

    public String getAttributeValue(int i) {
        if (state == DELEGATED_STATE) {
            return childReader.getAttributeValue(i);
        } else if (state == START_ELEMENT_STATE) {
            if (attributes == null) {
                return null;
            } else {
                if ((i >= (attributes.length)) || i < 0) { // out of range
                    return null;
                } else {
                    // get the attribute pointer
                    Object attribPointer = attributes[i].getKey();
                    Object omAttribObj = attributes[i].getValue();
                    
                    // Handle xsd:QName/SDO URI type property
                    // Before save, convert <uri>#<local part> to <prefix>:<local part>
                    String propertyName = null;
                    if (attribPointer instanceof String)
                        propertyName = (String)attribPointer;
                    else if (attribPointer instanceof QName)
                        propertyName = ((QName)attribPointer).getLocalPart();
                    else
                        return null;
                    
                    String attrValue = (String)omAttribObj;

                    Property property = dataObject.getType().getProperty(propertyName);
                    // property can be null for xsi:type
                    if (property != null && "URI".equals(property.getType().getName())) {
                        String namespace = null;
                        String localPart = attrValue;
                        
                        int index = attrValue.indexOf('#');
                        if (index == -1) {
                            return localPart;
                        }
                        else {
                            namespace = localPart.substring(0, index);
                            localPart = localPart.substring(index+1);
                            
                            String prefix = namespaceContext.getPrefix(namespace);
                            if (prefix == null || prefix.length() == 0)
                                return localPart;
                            
                            return prefix + ":" + localPart;
                        }
                    }
                    else {
                        return attrValue;
                    }
                }
            }
        } else {
            throw new IllegalStateException();
        }

    }

    public boolean isAttributeSpecified(int i) {
        return false; // not supported
    }

    // /////////////////////////////////////////////////////////////////////////
    // //////////// end of attribute handling
    // /////////////////////////////////////////////////////////////////////////

    // //////////////////////////////////////////////////////////////////////////
    // //////////// namespace handling
    // //////////////////////////////////////////////////////////////////////////

    public int getNamespaceCount() {
        if (state == DELEGATED_STATE) {
            return childReader.getNamespaceCount();
        } else {
            return declaredNamespaceMap.size();
        }
    }

    /**
     * @param i
     * @return
     */
    public String getNamespacePrefix(int i) {
        if (state == DELEGATED_STATE) {
            return childReader.getNamespacePrefix(i);
        } else if (state != TEXT_STATE) {
            // order the prefixes
            String[] prefixes = makePrefixArray();
            if ((i >= prefixes.length) || (i < 0)) {
                return null;
            } else {
                return prefixes[i];
            }

        } else {
            throw new IllegalStateException();
        }

    }

    /**
     * Get the prefix list from the hastable and take that into an array
     * 
     * @return
     */
    private String[] makePrefixArray() {
        String[] prefixes = (String[]) declaredNamespaceMap.keySet().toArray(new String[declaredNamespaceMap.size()]);
        Arrays.sort(prefixes);
        return prefixes;
    }

    public String getNamespaceURI(int i) {
        if (state == DELEGATED_STATE) {
            return childReader.getNamespaceURI(i);
        } else if (state != TEXT_STATE) {
            String namespacePrefix = getNamespacePrefix(i);
            return namespacePrefix == null ? null : (String) declaredNamespaceMap.get(namespacePrefix);
        } else {
            throw new IllegalStateException();
        }

    }

    public NamespaceContext getNamespaceContext() {
        if (state == DELEGATED_STATE) {
            return childReader.getNamespaceContext();
        } else {
            return namespaceContext;
        }

    }

    // /////////////////////////////////////////////////////////////////////////
    // /////// end of namespace handling
    // /////////////////////////////////////////////////////////////////////////

    public int getEventType() {
        if (state == START_ELEMENT_STATE) {
            return START_ELEMENT;
        } else if (state == END_ELEMENT_STATE) {
            return END_ELEMENT;
        } else { // this is the delegated state
            return childReader.getEventType();
        }

    }

    public String getText() {
        if (state == DELEGATED_STATE) {
            return childReader.getText();
        } else if (state == TEXT_STATE) {
            return (String) properties[currentPropertyIndex - 1].getValue();
        } else {
            throw new IllegalStateException();
        }
    }

    public char[] getTextCharacters() {
        if (state == DELEGATED_STATE) {
            return childReader.getTextCharacters();
        } else if (state == TEXT_STATE) {
            return getTextData();
        } else {
            throw new IllegalStateException();
        }
    }

    private char[] getTextData() {
        return properties[currentPropertyIndex - 1].getValue() == null ? new char[0] : ((String) properties[currentPropertyIndex - 1].getValue())
                .toCharArray();
    }

    private int copy(int sourceStart, char[] target, int targetStart, int length) {
        char[] source = getTextData();
        if (sourceStart > source.length)
            throw new IndexOutOfBoundsException("source start > source length");
        int sourceLen = source.length - sourceStart;
        if (length > sourceLen)
            length = sourceLen;
        System.arraycopy(source, sourceStart, target, targetStart, length);
        return sourceLen;
    }
    
    public int getTextCharacters(int i, char[] chars, int i1, int i2) throws XMLStreamException {
        if (state == DELEGATED_STATE) {
            return childReader.getTextCharacters(i, chars, i1, i2);
        } else if (state == TEXT_STATE) {
            return copy(i, chars, i1, i2);
        } else {
            throw new IllegalStateException();
        }
    }

    public int getTextStart() {
        if (state == DELEGATED_STATE) {
            return childReader.getTextStart();
        } else if (state == TEXT_STATE) {
            return 0;// assume text always starts at 0
        } else {
            throw new IllegalStateException();
        }
    }

    public int getTextLength() {
        if (state == DELEGATED_STATE) {
            return childReader.getTextLength();
        } else if (state == TEXT_STATE) {
            return getTextData().length;
        } else {
            throw new IllegalStateException();
        }
    }

    public String getEncoding() {
        if (state == DELEGATED_STATE) {
            return childReader.getEncoding();
        } else {
            // we've no idea what the encoding is going to be in this case
            // perhaps we ought to return some constant here, which the user might
            // have access to change!
            return null;
        }
    }

    /**
     * check the validity of this implementation
     * 
     * @return
     */
    public boolean hasText() {
        if (state == DELEGATED_STATE) {
            return childReader.hasText();
        } else if (state == TEXT_STATE) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * @return
     */
    public Location getLocation() {
        // return a default location
        return new Location() {
            public int getLineNumber() {
                return 0;
            }

            public int getColumnNumber() {
                return 0;
            }

            public int getCharacterOffset() {
                return 0;
            }

            public String getPublicId() {
                return null;
            }

            public String getSystemId() {
                return null;
            }
        };
    }

    public QName getName() {
        if (state == DELEGATED_STATE) {
            return childReader.getName();
        } else if (state != TEXT_STATE) {
            return elementQName;
        } else {
            throw new IllegalStateException();
        }

    }

    public String getLocalName() {
        if (state == DELEGATED_STATE) {
            return childReader.getLocalName();
        } else if (state != TEXT_STATE) {
            return elementQName.getLocalPart();
        } else {
            throw new IllegalStateException();
        }
    }

    public boolean hasName() {
        // since this parser always has a name, the hasname
        // has to return true if we are still navigating this element
        // if not we should ask the child reader for it.
        if (state == DELEGATED_STATE) {
            return childReader.hasName();
        } else if (state != TEXT_STATE) {
            return true;
        } else {
            return false;
        }
    }

    public String getNamespaceURI() {
        if (state == DELEGATED_STATE) {
            return childReader.getNamespaceURI();
        } else if (state == TEXT_STATE) {
            return null;
        } else {
            return elementQName.getNamespaceURI();
        }
    }

    public String getPrefix() {
        if (state == DELEGATED_STATE) {
            return childReader.getPrefix();
        } else if (state == TEXT_STATE) {
            return null;
        } else {
            return elementQName.getPrefix();
        }
    }

    public String getVersion() {
        return null;
    }

    public boolean isStandalone() {
        return true;
    }

    public boolean standaloneSet() {
        return true;
    }

    public String getCharacterEncodingScheme() {
        return null; // todo - should we return something for this ?
    }

    public String getPITarget() {
        throw new UnsupportedOperationException("Yet to be implemented !!");
    }

    public String getPIData() {
        throw new UnsupportedOperationException("Yet to be implemented !!");
    }

    // /////////////////////////////////////////////////////////////////////////
    // / Other utility methods
    // ////////////////////////////////////////////////////////////////////////

    /**
     * Populates a namespace context
     */
    private void populateNamespaceContext() {

        // first add the current element namespace to the namespace context
        // declare it if not found
        registerNamespace(elementQName.getPrefix(), elementQName.getNamespaceURI());

        // traverse through the attributes and populate the namespace context
        // the attrib list can be of many combinations
        // the valid combinations are
        // String - String
        // QName - QName
        // null - OMAttribute

        if (attributes != null) {
            for (int i = 0; i < attributes.length; i++) { // jump in two
                Object attribName = attributes[i].getKey();
                if (attribName instanceof String) {
                    // ignore this case - Nothing to do
                } else if (attribName instanceof QName) {
                    QName attribQName = ((QName) attribName);
                    registerNamespace(attribQName.getPrefix(), attribQName.getNamespaceURI());

                }
            }
        }

    }

    /**
     * @param prefix
     * @param uri
     */
    private void registerNamespace(String prefix, String uri) {
        if (!uri.equals(namespaceContext.getNamespaceURI(prefix))) {
            namespaceContext.registerMapping(prefix, uri);
            declaredNamespaceMap.put(prefix, uri);
        }
    }

    /**
     * By far this should be the most important method in this class this method changes the state of the parser according to the change in the
     */
    private int updateStatus() throws XMLStreamException {
        int returnEvent = -1; // invalid state is the default state
        switch (state) {
        case START_ELEMENT_STATE:
            // current element is start element. We should be looking at the
            // property list and making a pullparser for the property value
            if (properties == null || properties.length == 0) {
                // no properties - move to the end element state straightaway
                state = END_ELEMENT_STATE;
                returnEvent = END_ELEMENT;
            } else {
                // there are properties. now we should delegate this task to a
                // child reader depending on the property type
                returnEvent = processProperties();

            }
            break;
        case END_ELEMENT_STATE:
            // we've reached the end element already. If the user tries to push
            // further ahead then it is an exception
            throw new XMLStreamException("Trying to go beyond the end of the pullparser");

        case DELEGATED_STATE:
            if (childReader.isEndOfFragment()) {
                // we've reached the end!
                if (currentPropertyIndex > (properties.length - 1)) {
                    state = END_ELEMENT_STATE;
                    returnEvent = END_ELEMENT;
                } else {
                    returnEvent = processProperties();
                }
            } else {
                returnEvent = childReader.next();
            }
            break;

        case TEXT_STATE:
            // if there are any more event we should be delegating to
            // processProperties. if not we just return an end element
            if (currentPropertyIndex > (properties.length - 1)) {
                state = END_ELEMENT_STATE;
                returnEvent = END_ELEMENT;
            } else {
                returnEvent = processProperties();
            }
            break;
        }
        return returnEvent;
    }

    /**
     * A convenient method to reuse the properties
     * 
     * @return event to be thrown
     * @throws XMLStreamException
     */
    private int processProperties() throws XMLStreamException {
        // move to the next property depending on the current property
        // index
        Object propPointer = properties[currentPropertyIndex].getKey();
        QName propertyQName = null;
        boolean textFound = false;
        if (propPointer == null) {
            throw new XMLStreamException("property key cannot be null!");
        } else if (propPointer instanceof String) {
            // propPointer being a String has a special case
            // that is it can be a the special constant ELEMENT_TEXT that
            // says this text event
            if (ELEMENT_TEXT.equals(propPointer)) {
                textFound = true;
            } else {
                propertyQName = new QName((String) propPointer);
            }
        } else if (propPointer instanceof QName) {
            propertyQName = (QName) propPointer;
        } else {
            // oops - we've no idea what kind of key this is
            throw new XMLStreamException("unidentified property key!!!" + propPointer);
        }

        // ok! we got the key. Now look at the value
        Object propertyValue = properties[currentPropertyIndex].getValue();
        // cater for the special case now
        if (textFound) {
            // no delegation here - make the parser null and immediately
            // return with the event characters
            childReader = null;
            state = TEXT_STATE;
            currentPropertyIndex++;
            return CHARACTERS;
        } else if (propertyValue == null || propertyValue instanceof String) {
            // strings are handled by the NameValuePairStreamReader
            childReader = new SimpleElementStreamReader(propertyQName, (String) propertyValue, namespaceContext);
            childReader.init();
        } else if (propertyValue instanceof DataObjectXMLStreamReader) {
            // ADBbean has it's own method to get a reader
            XMLFragmentStreamReader reader = (DataObjectXMLStreamReader) propertyValue;
            // we know for sure that this is an ADB XMLStreamreader.
            // However we need to make sure that it is compatible
            childReader = reader;
            childReader.init();
        } else {
            // all special possiblilities has been tried! Let's treat
            // the thing as a bean and try generating events from it
            throw new UnsupportedOperationException("Not supported");
            // childReader = new WrappingXMLStreamReader(BeanUtil.getPullParser(propertyValue, propertyQName));
            // we cannot register the namespace context here
        }

        // set the state here
        state = DELEGATED_STATE;
        // we are done with the delegation
        // increment the property index
        currentPropertyIndex++;
        return childReader.getEventType();
    }

    /**
     * are we done ?
     * 
     * @return
     */
    public boolean isEndOfFragment() {
        return (state == END_ELEMENT_STATE);
    }

    protected static class NameValuePair implements Map.Entry {
        private Object key;

        private Object value;

        public NameValuePair(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Object getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        public Object setValue(Object value) {
            Object v = this.value;
            this.value = value;
            return v;
        }

    }

    protected static class SimpleElementStreamReader implements XMLFragmentStreamReader {

        private static final int START_ELEMENT_STATE = 0;

        private static final int TEXT_STATE = 1;

        private static final int END_ELEMENT_STATE = 2;

        private static final int START_ELEMENT_STATE_WITH_NULL = 3;

        private static final QName XSI_NIL_QNAME = new QName("http://www.w3.org/2001/XMLSchema-instance", "nil", "xsi");

        private final NameSpaceContext namespaceContext;

        private QName name;

        private String value;

        private int state = START_ELEMENT_STATE;

        public SimpleElementStreamReader(QName name, String value, NameSpaceContext nameSpaces) {
            this.name = name;
            this.value = value;
            if (value == null)
                state = START_ELEMENT_STATE_WITH_NULL;
            namespaceContext = nameSpaces;
        }

        public Object getProperty(String key) throws IllegalArgumentException {
            return null;
        }

        public int next() throws XMLStreamException {
            switch (state) {
            case START_ELEMENT_STATE:
                state = TEXT_STATE;
                return CHARACTERS;
            case START_ELEMENT_STATE_WITH_NULL:
                state = END_ELEMENT_STATE;
                return END_ELEMENT;
            case END_ELEMENT_STATE:
                // oops, not supposed to happen!
                throw new XMLStreamException("end already reached!");
            case TEXT_STATE:
                state = END_ELEMENT_STATE;
                return END_ELEMENT;
            default:
                throw new XMLStreamException("unknown event type!");
            }
        }

        public void require(int i, String string, String string1) throws XMLStreamException {
            // not implemented
        }

        public String getElementText() throws XMLStreamException {
            if (state == START_ELEMENT) {
                // move to the end state and return the value
                state = END_ELEMENT_STATE;
                return value;
            } else {
                throw new XMLStreamException();
            }

        }

        public int nextTag() throws XMLStreamException {
            return 0;// todo
        }

        public boolean hasNext() throws XMLStreamException {
            return (state != END_ELEMENT_STATE);
        }

        public void close() throws XMLStreamException {
            // Do nothing - we've nothing to free here
        }

        public String getNamespaceURI(String prefix) {
            return namespaceContext.getNamespaceURI(prefix);
        }

        public boolean isStartElement() {
            return (state == START_ELEMENT_STATE || state == START_ELEMENT_STATE_WITH_NULL);
        }

        public boolean isEndElement() {
            return (state == END_ELEMENT_STATE);
        }

        public boolean isCharacters() {
            return (state == TEXT_STATE);
        }

        public boolean isWhiteSpace() {
            return false; // no whitespaces here
        }

        public boolean isAttributeSpecified(int i) {
            return false; // no attribs here
        }

        public NamespaceContext getNamespaceContext() {
            return this.namespaceContext;
        }

        public int getEventType() {
            switch (state) {
            case START_ELEMENT_STATE:
            case START_ELEMENT_STATE_WITH_NULL:
                return START_ELEMENT;
            case END_ELEMENT_STATE:
                return END_ELEMENT;
            case TEXT_STATE:
                return CHARACTERS;
            default:
                throw new UnsupportedOperationException();
            // we've no idea what this is!!!!!
            }

        }

        public String getText() {
            if (state == TEXT_STATE) {
                return value;
            } else {
                throw new IllegalStateException();
            }
        }

        public char[] getTextCharacters() {
            if (state == TEXT_STATE) {
                return value.toCharArray();
            } else {
                throw new IllegalStateException();
            }
        }

        public int getTextCharacters(int i, char[] chars, int i1, int i2) throws XMLStreamException {
            // not implemented
            throw new UnsupportedOperationException();
        }

        public int getTextStart() {
            if (state == TEXT_STATE) {
                return 0;
            } else {
                throw new IllegalStateException();
            }
        }

        public int getTextLength() {
            if (state == TEXT_STATE) {
                return value.length();
            } else {
                throw new IllegalStateException();
            }

        }

        public String getEncoding() {
            return "UTF-8";
        }

        public boolean hasText() {
            return (state == TEXT_STATE);
        }

        public Location getLocation() {
            return new Location() {
                public int getLineNumber() {
                    return 0;
                }

                public int getColumnNumber() {
                    return 0;
                }

                public int getCharacterOffset() {
                    return 0;
                }

                public String getPublicId() {
                    return null;
                }

                public String getSystemId() {
                    return null;
                }
            };
        }

        public QName getName() {
            if (state != TEXT_STATE) {
                return name;
            } else {
                return null;
            }
        }

        public String getLocalName() {
            if (state != TEXT_STATE) {
                return name.getLocalPart();
            } else {
                return null;
            }
        }

        public boolean hasName() {
            return (state != TEXT_STATE);

        }

        public String getNamespaceURI() {
            if (state != TEXT_STATE) {
                return name.getNamespaceURI();
            } else {
                return null;
            }

        }

        public String getPrefix() {
            if (state != TEXT_STATE) {
                return name.getPrefix();
            } else {
                return null;
            }
        }

        public String getVersion() {
            return null; // todo 1.0 ?
        }

        public boolean isStandalone() {
            return false;
        }

        public boolean standaloneSet() {
            return false;
        }

        public String getCharacterEncodingScheme() {
            return null;
        }

        public String getPITarget() {
            return null;
        }

        public String getPIData() {
            return null;
        }

        public boolean isEndOfFragment() {
            return (state == END_ELEMENT_STATE);
        }

        public void init() {
            // just add the current elements namespace and prefix to the this
            // elements nscontext
            registerNamespace(name.getPrefix(), name.getNamespaceURI());

        }

        /**
         * @param prefix
         * @param uri
         */
        private void registerNamespace(String prefix, String uri) {
            // todo - need to fix this up to cater for cases where
            // namespaces are having no prefixes
            if (!uri.equals(namespaceContext.getNamespaceURI(prefix))) {
                // this namespace is not there. Need to declare it
                namespaceContext.registerMapping(prefix, uri);
            }
        }

        public int getAttributeCount() {
            if (state == START_ELEMENT_STATE_WITH_NULL)
                return 1;
            if (state == START_ELEMENT_STATE) {
                return 0;
            } else {
                throw new IllegalStateException();
            }

        }

        public String getAttributeLocalName(int i) {
            if (state == START_ELEMENT_STATE_WITH_NULL && i == 0)
                return XSI_NIL_QNAME.getLocalPart();
            if (state == START_ELEMENT_STATE) {
                return null;
            } else {
                throw new IllegalStateException();
            }
        }

        public QName getAttributeName(int i) {
            if (state == START_ELEMENT_STATE_WITH_NULL && i == 0)
                return XSI_NIL_QNAME;
            if (state == START_ELEMENT_STATE) {
                return null;
            } else {
                throw new IllegalStateException();
            }
        }

        public String getAttributeNamespace(int i) {
            if (state == START_ELEMENT_STATE_WITH_NULL && i == 0)
                return XSI_NIL_QNAME.getNamespaceURI();
            if (state == START_ELEMENT_STATE) {
                return null;
            } else {
                throw new IllegalStateException();
            }
        }

        public String getAttributePrefix(int i) {
            if (state == START_ELEMENT_STATE_WITH_NULL && i == 0)
                return XSI_NIL_QNAME.getPrefix();
            if (state == START_ELEMENT_STATE) {
                return null;
            } else {
                throw new IllegalStateException();
            }
        }

        public String getAttributeType(int i) {
            return null; // not implemented
        }

        public String getAttributeValue(int i) {
            if (state == START_ELEMENT_STATE_WITH_NULL && i == 0)
                return "true";
            if (state == START_ELEMENT_STATE) {
                return null;
            } else {
                throw new IllegalStateException();
            }
        }

        public String getAttributeValue(String string, String string1) {
            if (state == TEXT_STATE) {
                // todo something
                return null;
            } else {
                return null;
            }

        }

        public int getNamespaceCount() {
            if (state == START_ELEMENT_STATE_WITH_NULL && isXsiNamespacePresent())
                return 1;
            else
                return 0;

        }

        public String getNamespacePrefix(int i) {
            if (state == START_ELEMENT_STATE_WITH_NULL && isXsiNamespacePresent() && i == 0)
                return XSI_NIL_QNAME.getPrefix();
            else
                return null;
        }

        public String getNamespaceURI(int i) {
            if (state == START_ELEMENT_STATE_WITH_NULL && isXsiNamespacePresent() && i == 0)
                return XSI_NIL_QNAME.getNamespaceURI();
            else
                return null;
        }

        /**
         * Test whether the xsi namespace is present
         * 
         * @return
         */
        private boolean isXsiNamespacePresent() {
            return (namespaceContext.getNamespaceURI(XSI_NIL_QNAME.getPrefix()) != null);
        }

    }

    protected class NameSpaceContext implements NamespaceContext {
        private Map prefixToNamespaceMapping = new HashMap();

        public NameSpaceContext() {
            prefixToNamespaceMapping.put("xml", "http://www.w3.org/XML/1998/namespace");
            prefixToNamespaceMapping.put("xmlns", "http://www.w3.org/2000/xmlns/");
            prefixToNamespaceMapping.put("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        }

        public String getNamespaceURI(String prefix) {
            if (prefix == null)
                throw new IllegalArgumentException("Prefix is null");

            String ns = (String) prefixToNamespaceMapping.get(prefix);
            if (ns != null)
                return ns;
            else
                return null;
        }

        public String getPrefix(String nsURI) {
            if (nsURI == null)
                throw new IllegalArgumentException("Namespace is null");
            for (Iterator i = prefixToNamespaceMapping.entrySet().iterator(); i.hasNext();) {
                Map.Entry entry = (Map.Entry) i.next();
                if (entry.getValue().equals(nsURI)) {
                    return (String) entry.getKey();
                }
            }
            return null;
        }

        public Iterator getPrefixes(String nsURI) {
            List prefixList = new ArrayList();
            for (Iterator i = prefixToNamespaceMapping.entrySet().iterator(); i.hasNext();) {
                Map.Entry entry = (Map.Entry) i.next();
                if (entry.getValue().equals(nsURI)) {
                    prefixList.add(entry.getKey());
                }
            }
            return prefixList.iterator();
        }

        public void registerMapping(String prefix, String nsURI) {
            prefixToNamespaceMapping.put(prefix, nsURI);
        }

        private int counter = 0;

        public synchronized QName createQName(String nsURI, String name) {
            String prefix = nsURI != null ? (String) getPrefix(nsURI) : null;
            if (prefix == null && nsURI != null && !nsURI.equals(""))
                prefix = "p" + (counter++);
            if (prefix == null)
                prefix = "";
            if (nsURI != null) {
                prefixToNamespaceMapping.put(prefix, nsURI);
                declaredNamespaceMap.put(prefix, nsURI);
            }
            return new QName(nsURI, name, prefix);
        }

        public void removeMapping(String prefix) {
            prefixToNamespaceMapping.remove(prefix);
        }
    }

}
