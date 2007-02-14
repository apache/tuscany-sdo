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
import java.io.Writer;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.*;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.*;

import org.apache.tuscany.sdo.helper.HelperContextImpl;
import org.apache.tuscany.sdo.helper.XMLStreamHelper;
import org.apache.tuscany.sdo.model.ModelFactory;
import org.apache.tuscany.sdo.model.impl.ModelFactoryImpl;
import org.apache.tuscany.sdo.util.*;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMIException;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import commonj.sdo.*;

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
    }

    static final Object ChangeSummary_TYPE = ((ModelFactoryImpl) ModelFactory.INSTANCE).getChangeSummaryType();

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
                    if (feature != null && feature.getEType() == ChangeSummary_TYPE) {
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
                        changeSummaryDeserializer.begin((DataObject) objects.peekEObject(), new HelperContextImpl(extendedMetaData), tag
                                .play(xmlResource));
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
            String lineBreak = (String) options.get(SDOUtil.XML_SAVE_LineBreak);
            if (lineBreak == null)
                changeSummaryOptions.put(SDOUtil.XML_SAVE_LineBreak, LINE_BREAK);
            else if (lineBreak.length() == 0)
                ++unformat;
            else {
                changeSummaryOptions.put(SDOUtil.XML_SAVE_LineBreak, LINE_BREAK);
                if (lineBreak.equals(LINE_SEPARATOR))
                    lineBreak = null;
            }
            String indent = (String) options.get(SDOUtil.XML_SAVE_INDENT);
            if (indent == null)
                changeSummaryOptions.put(SDOUtil.XML_SAVE_INDENT, INDENT);
            else if (indent.length() == 0)
                ++unformat;
            else {
                changeSummaryOptions.put(SDOUtil.XML_SAVE_INDENT, this.indent = indent);
                if (indent.equals(INDENT))
                    indent = null;
            }
            String margin = (String) options.get(SDOUtil.XML_SAVE_MARGIN);
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

        protected void saveDataTypeElementSingle(EObject o, EStructuralFeature f) {
            if (f.getEType() == ChangeSummary_TYPE) {
                Object changeSummary = helper.getValue(o, f);
                StringBuffer margin = new StringBuffer(this.margin);
                for (EObject container = o.eContainer(), grandContainer; (grandContainer = container.eContainer()) != null; container = grandContainer)
                    margin.append(indent);
                changeSummaryOptions.put(SDOUtil.XML_SAVE_MARGIN, margin.toString());
                try {
                    if (xmlStreamWriter == null) {
                        xmlStreamWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(new Writer() {
                            public void close() {
                            }

                            public void flush() {
                            }

                            protected final void add(char[] cbuf, int index, int off) {
                                doc.add(new String(cbuf, index, off - index));
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
                    changeSummarySerializer.saveChangeSummary((ChangeSummary) changeSummary, qName(f), xmlStreamWriter,
                            changeSummaryOptions);
                    doc.addLine();
                } catch (XMLStreamException e) {
                    xmlResource.getErrors().add(new XMIException(e));
                }
            } else
                super.saveDataTypeElementSingle(o, f);
        }
    }

    protected XMLSave createXMLSave() {
        return new SDOXMLSaveImpl(createXMLHelper());
    }
}
