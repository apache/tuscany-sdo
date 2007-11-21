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

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import org.apache.tuscany.sdo.SDOExtendedMetaData;
import org.apache.tuscany.sdo.helper.HelperContextImpl;
import org.apache.tuscany.sdo.helper.SDOExtendedMetaDataImpl;
import org.apache.tuscany.sdo.helper.XMLStreamHelper;
import org.apache.tuscany.sdo.helper.XSDHelperImpl;
import org.apache.tuscany.sdo.api.SDOHelper;
import org.apache.tuscany.sdo.api.SDOUtil;
import org.apache.tuscany.sdo.util.StAX2SAXAdapter;
import org.apache.tuscany.sdo.model.internal.InternalFactory;
import org.apache.tuscany.sdo.model.internal.impl.InternalFactoryImpl;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.XMIException;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.XMLOptions;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.SAXXMLHandler;
import org.eclipse.emf.ecore.xmi.impl.XMLHelperImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLLoadImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLOptionsImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLSaveImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLString;
import org.eclipse.emf.ecore.xmi.util.DefaultEcoreBuilder;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import commonj.sdo.ChangeSummary;
import commonj.sdo.DataObject;
import commonj.sdo.helper.XSDHelper;

public class SDOXMLResourceImpl extends XMLResourceImpl {
    private XMLStreamReader reader;

    /**
     * [rfeng] Override the XMLHelperImpl to replace the NamespaceSupport so that it's aware of the NamespaceContext from the XMLStreamReader
     */
    public static class SDOXMLHelperImpl extends XMLHelperImpl {

        /**
         * EMF XMLResource (SAX) may be used to load from only a *portion* of a StAX stream
         * which may reference (global) namespaces bound outside the (local) portion.
         * This class extends EMF's NamespaceSupport to make {@link #getPrefix} and {@link #getURI}
         * query these global binding(s) after first checking the local context(s).
         */
        private static class StreamNamespaceSupport extends XMLHelperImpl.NamespaceSupport {
            protected NamespaceContext nameSpaceContext;

            public String getPrefix(String uri) {
                String prefix = super.getPrefix(uri);
                if (prefix == null)
                    try {
                        prefix = nameSpaceContext.getPrefix(uri);
                    } catch (Exception e) {
                        // HACK:
                        // java.lang.UnsupportedOperationException
                        // at org.apache.axiom.om.impl.llom.OMStAXWrapper.getNamespaceContext(OMStAXWrapper.java:984)
                    }
                return prefix;
            }

            public String getURI(String prefix) {
                String uri = super.getURI(prefix);
                if (uri == null)
                    try {
                        uri = nameSpaceContext.getNamespaceURI(prefix);
                    } catch (Exception e) {
                        // HACK:
                        // java.lang.UnsupportedOperationException
                        // at org.apache.axiom.om.impl.llom.OMStAXWrapper.getNamespaceContext(OMStAXWrapper.java:984)
                    }
                return uri;
            }

            public StreamNamespaceSupport(XMLStreamReader reader) {
                super();
                nameSpaceContext = reader.getNamespaceContext();
            }

        }

        public SDOXMLHelperImpl(XMLResource resource, XMLStreamReader reader) {
            this(reader);
            setResource(resource);
        }

        public SDOXMLHelperImpl(XMLStreamReader reader) {
            super();
            if (reader instanceof XMLDocumentStreamReader) // Only use StreamNamespaceSupport when loading from a *portion* of a StAX stream
                namespaceSupport = new StreamNamespaceSupport(reader);
        }
        
        private class NameSpaceContext implements NamespaceContext { // TODO Helper# pushContext() & popContext
            public String getNamespaceURI(String prefix) {
                return SDOXMLHelperImpl.this.getNamespaceURI(prefix);
            }

            public String getPrefix(String namespaceURI) {
                return SDOXMLHelperImpl.this.getPrefix(namespaceURI);
            }

            public Iterator getPrefixes(String namespaceURI) {
                return ((Collection) urisToPrefixes.get(namespaceURI)).iterator();
            }
        }

        NameSpaceContext nameSpaceContext/* = null */;

        protected final NameSpaceContext nameSpaceContext() {
            if (nameSpaceContext == null)
                nameSpaceContext = new NameSpaceContext();
            return nameSpaceContext;
        }
        
        private String xsdQName2SDOURI(String xsdQName) {
            org.eclipse.emf.ecore.xml.type.internal.QName qname = new org.eclipse.emf.ecore.xml.type.internal.QName(xsdQName);
            try {
                updateQNameURI(qname);
            }
            catch (IllegalArgumentException e) {
                return xsdQName;
            }
            String uri = qname.getNamespaceURI();
            if (uri != "")
              return uri + "#" + qname.getLocalPart();
            else
              return qname.getLocalPart();
        }
        
        private String getPrefixFromNamespaceURI(String nsURI) {
            String nsPrefix = null;

            List prefixes = (List)urisToPrefixes.get(nsURI);
            if (prefixes != null)
            {
              for (Iterator i = prefixes.iterator(); i.hasNext(); )
              {
                nsPrefix = (String)i.next();
                if (nsPrefix.length() >= 0) {
                    // When the length is 0, it's the default namespace
                    return nsPrefix;
                }
              }
            }
            
            nsPrefix = namespaceSupport.getPrefix(nsURI);
            if (nsPrefix != null)
            {
              return nsPrefix;
            }
            
            // Demand create a new package
            EPackage ePackage = extendedMetaData.demandPackage(nsURI);

            if (ExtendedMetaData.XSI_URI.equals(nsURI)) {
                ePackage.setNsPrefix(ExtendedMetaData.XSI_PREFIX);
            }
            
            // getPrefix() will make sure all mapping tables are configured correctly
            nsPrefix = getPrefix(ePackage, true);
            
            return nsPrefix;
        }
        
        private String SDOURI2XsdQName(String sdoURI) {
            String namespace = null;
            String localPart = sdoURI;
            
            int index = sdoURI.indexOf('#');
            if (index == -1) {
                return localPart;
            }
            else {
                namespace = sdoURI.substring(0, index);
                localPart = sdoURI.substring(index+1);
                
                String prefix = getPrefixFromNamespaceURI(namespace);

                if (prefix.length() == 0)
                    return localPart;
                
                return prefix + ":" + localPart;
            }
        }
        
        protected Object createFromString(EFactory eFactory, EDataType eDataType, String value) {
            Object obj = super.createFromString(eFactory, eDataType, value);
            if (eDataType == ((InternalFactoryImpl)InternalFactory.INSTANCE).getQName()) {
                if (extendedMetaData != null) {
                    if (obj instanceof List) {
                        List list = (List)obj;
                        for (int i=0; i<list.size(); i++) {
                            String xsdQName = (String)list.get(i);
                            list.set(i, xsdQName2SDOURI(xsdQName));
                        }
                    }
                    else {
                        obj = xsdQName2SDOURI((String)obj);
                    }
                }
            }
            return obj;
        }
        
        public String convertToString(EFactory factory, EDataType eDataType, Object value) {
            if (eDataType == ((InternalFactoryImpl)InternalFactory.INSTANCE).getQName()) {
                if (extendedMetaData != null) {
                    if (value instanceof List) {
                        List list = (List)value;
                        for (int i=0; i<list.size(); i++) {
                            String sdoURI = (String)list.get(i);
                            list.set(i, SDOURI2XsdQName(sdoURI));
                        }
                    }
                    else {
                        value = SDOURI2XsdQName((String)value);
                    }
                }
            }
            
            return super.convertToString(factory, eDataType, value);
        }
    }

    public EObject root;

    /**
     * An EMF XMLLoad that loads a model from a StAX stream
     */
    public class SDOXMLLoadImpl extends XMLLoadImpl {
        public SDOXMLLoadImpl(XMLHelper helper) {
            super(helper);
        }

        final class XmlHandler extends SAXXMLHandler {
            XmlHandler() {
                super(resource, SDOXMLLoadImpl.this.helper, options);
            }

            protected void handleTopLocations(String prefix, String name) {
                processSchemaLocations(prefix, name);
                if (!processAnyXML)
                    return;
                String nameSpace = helper.getURI(prefix);
                if (extendedMetaData.getPackage(nameSpace) == null)
                    if (options.get(XMLStreamHelper.OPTION_DEFAULT_ROOT_TYPE) == null)
                        extendedMetaData.demandFeature(nameSpace, name, true);
                    else
                        extendedMetaData.demandPackage(nameSpace);
            }

            EClassifier defaultRootType(String prefix, String name, boolean isElement, EObject peekObject, String value) {
                Object type = options.get(XMLStreamHelper.OPTION_DEFAULT_ROOT_TYPE);
                if (type != null)
                    return (EClassifier) type;
                super.handleUnknownFeature(prefix, name, isElement, peekObject, value);
                return null;
            }

            protected void handleUnknownFeature(String prefix, String name, boolean isElement, EObject peekObject, String value) {
                if (objects.size() == 1) {
                    EFactory eFactory;
                    EClassifier type;
                    String typeQName = getXSIType();
                    if (typeQName == null) {
                        type = defaultRootType(prefix, name, isElement, peekObject, value);
                        if (type == null)
                            return;
                        eFactory = type.getEPackage().getEFactoryInstance();
                    } else {// createObjectFromTypeName
                        String typeName = null;
                        String xsiPrefix = XMLConstants.DEFAULT_NS_PREFIX;
                        int index = typeQName.indexOf(":");
                        if (index > 0) {
                            xsiPrefix = typeQName.substring(0, index);
                            typeName = typeQName.substring(index + 1);
                        } else
                            typeName = typeQName;
                        eFactory = getFactoryForPrefix(xsiPrefix);
                        if (eFactory != null)
                            type = helper.getType(eFactory, typeName);
                        else if (XMLConstants.DEFAULT_NS_PREFIX.equals(xsiPrefix) && helper.getURI(xsiPrefix) == null) {
                            EPackage ePackage = handleMissingPackage(null);
                            if (ePackage == null) {
                                type = defaultRootType(prefix, name, isElement, peekObject, value);
                                if (type == null)
                                    return;
                                eFactory = type.getEPackage().getEFactoryInstance();
                            } else
                                type = helper.getType(eFactory = ePackage.getEFactoryInstance(), typeName);
                        } else {
                            type = defaultRootType(prefix, name, isElement, peekObject, value);
                            if (type == null)
                                return;
                            eFactory = type.getEPackage().getEFactoryInstance();
                        }
                    }
                    root = helper.createObject(eFactory, type);
                    if (root != null) {
                        if (disableNotify)
                            root.eSetDeliver(false);
                        handleObjectAttribs(root);
                        processObject(root);
                        return;
                    }
                }
                super.handleUnknownFeature(prefix, name, isElement, peekObject, value);
            }

            protected RecordedEventXMLStreamReader.Tag tag/* =null */;

            protected List nameSpaces/* = null */;

            public void startPrefixMapping(String prefix, String uri) {
                if (nameSpaces == null)
                    nameSpaces = new ArrayList();
                RecordedEventXMLStreamReader.Tag.bind(prefix, uri, nameSpaces);
                if (tag == null)
                    super.startPrefixMapping(prefix, uri);
            }

            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (tag != null) {
                    tag.start(uri, localName, qName, attributes, locator, nameSpaces);
                    nameSpaces = null;
                    return;
                }
                EObject peekObject = objects.peekEObject();
                if (peekObject != null) {
                    String prefix = helper.getPrefix(uri.length() == 0 ? null : uri);
                    EStructuralFeature feature = getFeature(peekObject, prefix == null ? XMLConstants.DEFAULT_NS_PREFIX : prefix, localName, true);
                    if (feature != null && feature.getEType() == ChangeSummaryStreamSerializer.ChangeSummary_TYPE) {
                        tag = new RecordedEventXMLStreamReader.Tag(uri, localName, prefix, attributes, locator, ((SDOXMLHelperImpl) helper).nameSpaceContext(),
                                nameSpaces);
                        nameSpaces = null;
                        return;
                    }
                }
                if (nameSpaces != null)
                    nameSpaces.clear();
                super.startElement(uri, localName, qName, attributes);
            }

            public void characters(char[] ch, int start, int length) {
                if (tag == null)
                    super.characters(ch, start, length);
                else
                    tag.text(XMLStreamConstants.CHARACTERS, new String(ch, start, length), locator);
            }

            protected Collection changeSummaryDeserializers/* = null */;

            public void endElement(String uri, String localName, String qName) {
                if (tag == null)
                    super.endElement(uri, localName, qName);
                else if (tag.end(uri, localName, qName, locator)) {
                    if (changeSummaryDeserializers == null)
                        changeSummaryDeserializers = new ArrayList();
                    ChangeSummaryStreamDeserializer changeSummaryDeserializer = new ChangeSummaryStreamDeserializer();
                    try {
                        changeSummaryDeserializer.begin(
                          (DataObject) objects.peekEObject(), 
                          new HelperContextImpl(extendedMetaData, false), 
                          tag.play(xmlResource));
                        changeSummaryDeserializers.add(changeSummaryDeserializer);
                    } catch (XMLStreamException e) {
                        xmlResource.getErrors().add(new XMIException(e));
                    }
                    tag = null;
                }
            }

            public void endDocument() {
                super.endDocument();
                if (changeSummaryDeserializers != null)
                    for (Iterator iterator = changeSummaryDeserializers.iterator(); iterator.hasNext();)
                        try {
                            ((ChangeSummaryStreamDeserializer) iterator.next()).end();
                            // iterator.remove();
                        } catch (XMLStreamException e) {
                            xmlResource.getErrors().add(new XMIException(e));
                        }
            }
        }

        protected DefaultHandler makeDefaultHandler() {
            return new XmlHandler();
        }

        /**
         * Start parsing an XMLReader with the default handler.
         */
        public void load(XMLResource resource, final XMLStreamReader reader, Map options) throws IOException {
            this.resource = resource;
            Map mergedOptions = new HashMap(defaultLoadOptions);
            if (options != null)
                mergedOptions.putAll(options);

            this.options = mergedOptions;

            final ContentHandler handler = makeDefaultHandler();

            if (errors != null) {
                errors.clear();
            }

            final StAX2SAXAdapter adapter = new StAX2SAXAdapter(true);
            // Parse the XMLReader and generate SAX events
            try {
                AccessController.doPrivileged(new PrivilegedExceptionAction() {
                    public Object run() throws XMLStreamException, SAXException {
                        adapter.parse(reader, handler);
                        return null;
                    }
                });
            } catch (PrivilegedActionException e) {
                throw new Resource.IOWrappedException(e.getException());
            }

            helper = null;
            if (!resource.getErrors().isEmpty()) {
                Exception error = (Exception) resource.getErrors().get(0);
                if (error instanceof XMIException) {
                    XMIException exception = (XMIException) error;
                    if (exception.getWrappedException() != null) {
                        throw new Resource.IOWrappedException(exception.getWrappedException());
                    }
                }
                throw new Resource.IOWrappedException(error);
            }
        }
    }

    public SDOXMLResourceImpl(URI uri) {
        super(uri);
    }

    protected XMLHelper createXMLHelper() {
        return new SDOXMLHelperImpl(this, reader);
    }

    /**
     * @see org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl#createXMLLoad()
     */
    protected XMLLoad createXMLLoad() {
        return new SDOXMLLoadImpl(createXMLHelper());
    }

    static protected int loadLaxForm;
    static {
        int defaultLaxForm = 0x4242;
        String property = System.getProperty("XML.load.form.lax");
        if (property == null)
            loadLaxForm = defaultLaxForm;
        else
            try {
                loadLaxForm = Integer.decode(property).intValue();
            } catch (NumberFormatException eNumberFormat) {
                loadLaxForm = defaultLaxForm;
            }
    }
    
    public void doLoad(InputSource inputSource, Map options) throws IOException {
        if (options != null) {
            /*
             * Tolerates element/attribute malform unless indicated not to
             */
            Object option = options.get(SDOHelper.XMLOptions.XML_LOAD_LAX_FORM);
            int tolerance = option == null ? loadLaxForm : ((Number) option).intValue();
            option = options.get(OPTION_EXTENDED_META_DATA);
            if (tolerance == 0) {
                if (option instanceof SDOExtendedMetaData)
                    ((SDOExtendedMetaData) option).setFeatureNamespaceMatchingLax(false);
            } else if (option instanceof SDOExtendedMetaData){
                ((SDOExtendedMetaData) option).setFeatureNamespaceMatchingLax(true);
            }
            else{
                options.put(OPTION_EXTENDED_META_DATA, option = new SDOExtendedMetaDataImpl()); // TODO copy (BasicExtendedMetaData)option
            }
            /*
             * Loads schema if necessary
             */
            if (Boolean.TRUE.equals(options.get(SDOHelper.XMLOptions.XML_LOAD_SCHEMA))){
                XMLOptions xmlOptions = (XMLOptions) options.get(OPTION_XML_OPTIONS);
                if (xmlOptions == null) {
                    xmlOptions = new XMLOptionsImpl();
                    options.put(OPTION_XML_OPTIONS, xmlOptions);
                }
                xmlOptions.setProcessSchemaLocations(true);
                if (option == null){
                    option = getDefaultLoadOptions().get(OPTION_EXTENDED_META_DATA);
                }
                ExtendedMetaData extendedMetaData;
                final XSDHelper xsdHelper;
                if (option == null) {
                    extendedMetaData = ExtendedMetaData.INSTANCE;
                    xsdHelper = XSDHelper.INSTANCE;
                } else {
                    extendedMetaData = (ExtendedMetaData) option;
                    xsdHelper = (new HelperContextImpl(extendedMetaData, false)).getXSDHelper();
                }
                xmlOptions.setEcoreBuilder(new DefaultEcoreBuilder(extendedMetaData) {
                    public Collection generate(Map targetNamespaceToURI) throws IOException {
                        for (Iterator iterator = targetNamespaceToURI.values().iterator(); iterator.hasNext();) {
                            String uri = iterator.next().toString();
                            xsdHelper.define(uri.indexOf(":/") == -1 ? Thread.currentThread().getContextClassLoader().getResourceAsStream(uri)
                                    : new URL(uri).openStream(), uri);
                        }
                        return null; // XMLHandler#processSchemaLocations doesn't take the result
                    }
                });
            }
            
            if (Boolean.TRUE.equals(options.get(SDOHelper.XMLOptions.XML_LOAD_UNKNOWN_PROPERTIES))) {
                options.put(OPTION_RECORD_UNKNOWN_FEATURE , Boolean.TRUE);
            }
        }
        else if (loadLaxForm != 0) {
            /*
             * Tolerates element/attribute malform
             */
            options = new HashMap();
            options.put(OPTION_EXTENDED_META_DATA, new SDOExtendedMetaDataImpl());
        }
        super.doLoad(inputSource, options);
        // TODO there is some thinking to be done about the restoration of options
    }

    /**
     * Loads the resource from a StAX XMLStreamReader.
     */
    public void load(XMLStreamReader reader, Map options) throws IOException {
        this.reader = reader;
        SDOXMLLoadImpl xmlLoad = (SDOXMLLoadImpl) createXMLLoad();
        Map mergedOptions = new HashMap(defaultLoadOptions);
        if (options != null)
            mergedOptions.putAll(options);
        xmlLoad.load(this, reader, mergedOptions);
    }

    ChangeSummaryStreamSerializer changeSummarySerializer/* = null*/;

    static private final class LocalName extends QName {
        private LocalName(String name) {
            super(name);
        }

        public String getNamespaceURI() {
            return null;
        }
    }

    static final String INDENT = "  ", LINE_SEPARATOR = System.getProperty("line.separator");

    static final class XmlString extends XMLString {
        XmlString(int lineWidth, String temporaryFileName) {
            super(lineWidth, temporaryFileName); // setLineWidth & setTemporaryFileName
        }

        XmlString(int lineWidth, String publicId, String systemId, String temporaryFileName) {
            super(lineWidth, publicId, systemId, temporaryFileName);
        }

        void setLineBreak(String lineBreak) {
            lineSeparator = lineBreak;
        }

        void margin(String margin) {
            indents.set(0, margin);
        }

        String indent = INDENT;

        protected String getElementIndent(int extra) {
            int nesting = depth + extra - 1;
            for (int i = indents.size() - 1; i < nesting; ++i) {
                indents.add(indents.get(i) + indent);
            }
            return (String) indents.get(nesting);
        }

        protected String getAttributeIndent() {
            return getElementIndent();
        }
        
        public final boolean mixed() {
            return isMixed;
        }

        public void reset(String publicId, String systemId, int lineWidth, String temporaryFileName) {
            super.reset(publicId, systemId, lineWidth, temporaryFileName);
            setLineBreak(LINE_SEPARATOR);
            indent = INDENT;
        }
    }

    static final char MARK = '\n';

    static final String LINE_BREAK = new String(new char[] { MARK });

    final class SDOXMLSaveImpl extends XMLSaveImpl {
        SDOXMLSaveImpl(XMLHelper helper) {
            super(helper);
        }

        XmlString doc(XMLResource resource, Map options) {
            if (doc instanceof XmlString)
                return (XmlString) doc;
            Object lineWidth = options.get(OPTION_LINE_WIDTH);
            int width = lineWidth == null ? Integer.MAX_VALUE : ((Number) lineWidth).intValue();
            XmlString d = resource != null && Boolean.TRUE.equals(options.get(OPTION_SAVE_DOCTYPE)) ? new XmlString(width, resource.getPublicId(),
                    resource.getSystemId(), doc.getTemporaryFileName()) : new XmlString(width, doc.getTemporaryFileName());
            doc = d;
            return d;
        }

        Map changeSummaryOptions = new HashMap();
        String indent = INDENT, margin;

        protected void init(XMLResource resource, Map options) {
            super.init(resource, options);
            int unformat = 0;
            String lineBreak = (String) options.get(SDOHelper.XMLOptions.XML_SAVE_LINE_BREAK);
            if (lineBreak == null)
                changeSummaryOptions.put(SDOHelper.XMLOptions.XML_SAVE_LINE_BREAK, LINE_BREAK);
            else if (lineBreak.length() == 0)
                ++unformat;
            else {
                changeSummaryOptions.put(SDOHelper.XMLOptions.XML_SAVE_LINE_BREAK, LINE_BREAK);
                if (lineBreak.equals(LINE_SEPARATOR))
                    lineBreak = null;
            }
            String indent = (String) options.get(SDOHelper.XMLOptions.XML_SAVE_INDENT);
            if (indent == null)
                changeSummaryOptions.put(SDOHelper.XMLOptions.XML_SAVE_INDENT, INDENT);
            else if (indent.length() == 0)
                ++unformat;
            else {
                changeSummaryOptions.put(SDOHelper.XMLOptions.XML_SAVE_INDENT, this.indent = indent);
                if (indent.equals(INDENT))
                    indent = null;
            }
            String margin = (String) options.get(SDOHelper.XMLOptions.XML_SAVE_MARGIN);
            if (margin == null || margin.length() == 0) {
                if (unformat == 2)
                    doc.setUnformatted(true);
                else if (lineBreak != null) {
                    XmlString d = doc(resource, options);
                    d.setLineBreak(lineBreak);
                    if (indent != null)
                        d.indent = indent;
                } else if (indent != null)
                    doc(resource, options).indent = indent;
                this.margin = this.indent;
            } else {
                XmlString d = doc(resource, options);
                d.margin(margin);
                if (lineBreak != null)
                    d.setLineBreak(lineBreak);
                if (indent != null)
                    d.indent = indent;
                this.margin = margin + this.indent;
                if (!toDOM && declareXML)
                    d.add(margin);
            }
            // changeSummaryOptions.put(ChangeSummaryStreamSerializer.OPTION_RootObject_PATH, "#");
            // changeSummaryOptions.put(ChangeSummaryStreamSerializer.OPTION_OPTIMIZE_LIST, Boolean.TRUE);
            changeSummaryOptions.put(OPTION_EXTENDED_META_DATA, extendedMetaData);
        }

        QName qName(EStructuralFeature f) {
            if (extendedMetaData == null)
                return new LocalName(f.getName());
            String nameSpace = extendedMetaData.getNamespace(f), name = extendedMetaData.getName(f);
            return nameSpace == null ? new LocalName(name) : new QName(nameSpace, name);
        }

        XMLStreamWriter xmlStreamWriter/* = null*/;

        void saveChangeSummary(EObject o, EStructuralFeature f, Object changeSummary) {
            boolean notMixed;
            if (doc instanceof XmlString)
                notMixed = !((XmlString) doc).mixed();
            else if (extendedMetaData == null)
                notMixed = true;
            else
                switch (extendedMetaData.getContentKind(o.eClass())) {
                case ExtendedMetaData.MIXED_CONTENT:
                case ExtendedMetaData.SIMPLE_CONTENT:
                    notMixed = false;
                    break;
                default:
                    notMixed = true;
                }
            if (notMixed) {
                StringBuffer margin = new StringBuffer(this.margin);
                for (EObject container = o.eContainer(), grandContainer; (grandContainer = container.eContainer()) != null; container = grandContainer)
                    margin.append(indent);
                changeSummaryOptions.put(SDOHelper.XMLOptions.XML_SAVE_MARGIN, margin.toString());
            }
            try {
                if (xmlStreamWriter == null) {
                    xmlStreamWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(new Writer() {
                        public void close() {
                        }

                        public void flush() {
                        }

                        protected final void add(char[] cbuf, int index, int off) {
                            doc.addText(new String(cbuf, index, off - index));
                        }

                        public void write(char[] cbuf, int off, int len) {
                            if (len != 0)
                                for (;;) {
                                    while (cbuf[off] == MARK) {
                                        doc.addLine();
                                        if (--len == 0)
                                            return;
                                        ++off;
                                    }
                                    for (int index = off;/* true */;) {
                                        ++off;
                                        if (--len == 0)
                                            add(cbuf, index, off);
                                        else {
                                            if (cbuf[off] != MARK)
                                                continue;
                                            add(cbuf, index, off);
                                            doc.addLine();
                                            if (--len != 0)
                                                break;
                                        }
                                        return;
                                    }
                                    ++off;
                                }
                        }
                    });
                    xmlStreamWriter.setNamespaceContext(((SDOXMLHelperImpl) helper).new NameSpaceContext() {
                        public String getNamespaceURI(String prefix) {
                            return declareXSI && ExtendedMetaData.XSI_PREFIX.equals(prefix) ? ExtendedMetaData.XSI_URI : super
                                    .getNamespaceURI(prefix);
                        }

                        public String getPrefix(String namespaceURI) {
                            return declareXSI && ExtendedMetaData.XSI_URI.equals(namespaceURI) ? ExtendedMetaData.XSI_PREFIX : super
                                    .getPrefix(namespaceURI);
                        }

                        public Iterator getPrefixes(String namespaceURI) {
                            final Iterator iterator = super.getPrefixes(namespaceURI);
                            return ExtendedMetaData.XSI_URI.equals(namespaceURI) ? new Iterator() {
                                boolean first = true;

                                public boolean hasNext() {
                                    if (first)
                                        if (declareXSI) // never from true to false
                                            return true;
                                        else
                                            first = false;
                                    return iterator.hasNext();
                                }

                                public Object next() {
                                    if (first) {
                                        first = false;
                                        if (declareXSI)
                                            return ExtendedMetaData.XSI_PREFIX;
                                    }
                                    return iterator.next();
                                }

                                public void remove() {
                                    if (first)
                                        declareXSI = false;
                                    else
                                        iterator.remove();
                                }
                            } : iterator;
                        }
                    });
                    for (Iterator iterator = helper.getPrefixToNamespaceMap().iterator(); iterator.hasNext();) {
                        Map.Entry entry = (Map.Entry) iterator.next();
                        xmlStreamWriter.setPrefix((String) entry.getKey(), (String) entry.getValue());
                    }
                    if (declareXSI)
                        xmlStreamWriter.setPrefix(ExtendedMetaData.XSI_PREFIX, ExtendedMetaData.XSI_URI);
                    if (changeSummarySerializer == null)
                        changeSummarySerializer = new ChangeSummaryStreamSerializer();
                }
                changeSummarySerializer.saveChangeSummary((ChangeSummary) changeSummary, qName(f), xmlStreamWriter, changeSummaryOptions);
                if (notMixed)
                    doc.addLine();
            } catch (XMLStreamException e) {
                xmlResource.getErrors().add(new XMIException(e));
            }
        }

        protected void saveDataTypeElementSingle(EObject o, EStructuralFeature f) {
            if (f.getEType() == ChangeSummaryStreamSerializer.ChangeSummary_TYPE)
                saveChangeSummary(o, f, helper.getValue(o, f));
            else
                super.saveDataTypeElementSingle(o, f);
        }
        
        /*
         * TEMPORARILY COPIED FROM BASE CLASS - DO NOT EDIT - WILL BE REMOVED WHEN WE MOVE TO EMF 2.3
         */
        protected boolean saveElementFeatureMap(EObject o, EStructuralFeature f)
        {
          List values = (List)helper.getValue(o, f);
          int size = values.size();
          for (int i = 0; i < size; i++)
          {
            FeatureMap.Entry entry = (FeatureMap.Entry)values.get(i);
            EStructuralFeature entryFeature = entry.getEStructuralFeature();
            Object value = entry.getValue();
            if (entryFeature instanceof EReference)
            {
              if (value == null)
              {
                saveNil(o, entryFeature);
              }
              else 
              {
                EReference referenceEntryFeature = (EReference)entryFeature;
                if (referenceEntryFeature.isContainment())
                {
                  saveElement((InternalEObject)value, entryFeature);
                }
                else if (referenceEntryFeature.isResolveProxies())
                {
                  saveFeatureMapElementReference((EObject)value, referenceEntryFeature);
                }
                else
                {
                  saveElementIDRef(o, (EObject)value, entryFeature);
                }
              }
            }
            else
            {
              if (entryFeature == XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_Text())
              {
                String svalue = value.toString();
                if (escape != null)
                {
                  svalue =  escape.convertText(svalue);
                }        
                if (!toDOM)
                {    
                  doc.addText(svalue);
                }
                else
                {
                  Node text = document.createTextNode(svalue);
                  currentNode.appendChild(text);
                  handler.recordValues(text, o, f, entry);
                }
              }
              else if (entryFeature == XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_CDATA())
              {
                String stringValue = value.toString();
                if (escape != null)
                {
                  stringValue = escape.convertLines(stringValue);
                }
                if (!toDOM)
                {
                  doc.addCDATA(stringValue);
                }
                else
                {
                  Node cdata = document.createCDATASection(stringValue);
                  currentNode.appendChild(cdata);
                  handler.recordValues(cdata, o, f, entry);            
                }
              }
              else if (entryFeature == XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_Comment())
              {
                String stringValue = value.toString();
                if (escape != null)
                {
                  stringValue = escape.convertLines(stringValue);
                }
                if (!toDOM)
                {
                  doc.addComment(stringValue);
                }
                else
                {
                  // TODO comments are not sent to recordValues
                  currentNode.appendChild(document.createComment(stringValue));
                }
              }
              else
              {
                saveElement(o, value, entryFeature);
              }
            }
          }
          return size > 0;
        }

        protected final void saveElement(EObject o, Object value, EStructuralFeature f)
        {
          if (f.getEType() == ChangeSummaryStreamSerializer.ChangeSummary_TYPE)
          {
            saveChangeSummary(o, f, value);
            return;
          }
          /* super.saveElement(o, value, f);
           * TEMPORARILY COPIED FROM BASE CLASS - DO NOT EDIT - WILL BE REMOVED WHEN WE MOVE TO EMF 2.3
           */
          if (value == null)
          {
            saveNil(o, f);
          }
          else
          {
            String svalue =  getDatatypeValue(value, f, false);
            if (!toDOM)
            {
              doc.saveDataValueElement(helper.getQName(f), svalue);
            }
            else
            {
              helper.populateNameInfo(nameInfo, f);
              Element elem = document.createElementNS(nameInfo.getNamespaceURI(), nameInfo.getQualifiedName());
              Node text = document.createTextNode(svalue);
              elem.appendChild(text);
              currentNode.appendChild(elem);
              handler.recordValues(elem, o, f, value);
              handler.recordValues(text, o, f, value);
            }
          }
        }
    }

    protected XMLSave createXMLSave() {
        return new SDOXMLSaveImpl(createXMLHelper());
    }
}
