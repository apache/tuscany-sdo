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
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.tuscany.sdo.util.StAX2SAXAdapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIException;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLHelperImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLLoadImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class SDOXMLResourceImpl extends XMLResourceImpl {
    private XMLStreamReader reader;

    /**
     * [rfeng] Override the XMLHelperImpl to replace the NamespaceSupport so that it's aware of the NamespaceContext from the XMLStreamReader
     */
    public static class SDOXMLHelperImpl extends XMLHelperImpl {

        private static class StreamNamespaceSupport extends XMLHelperImpl.NamespaceSupport {
            private XMLStreamReader reader;

            public String getPrefix(String uri) {
                if (reader == null)
                    return super.getPrefix(uri);
                String prefix = null;
                try {
                    prefix = uri != null ? reader.getNamespaceContext().getPrefix(uri) : null;
                } catch (Exception e) {
                    // HACK:
                    // java.lang.UnsupportedOperationException
                    // at org.apache.axiom.om.impl.llom.OMStAXWrapper.getNamespaceContext(OMStAXWrapper.java:984)

                    prefix = null;
                }
                return prefix != null ? prefix : super.getPrefix(uri);
            }

            public String getURI(String prefix) {
                if (reader == null)
                    return super.getURI(prefix);
                String uri;
                try {
                    uri = prefix != null ? reader.getNamespaceContext().getNamespaceURI(prefix) : null;
                } catch (Exception e) {
                    // HACK:
                    // java.lang.UnsupportedOperationException
                    // at org.apache.axiom.om.impl.llom.OMStAXWrapper.getNamespaceContext(OMStAXWrapper.java:984)

                    uri = null;
                }
                return uri != null && uri.length()!=0 ? uri : super.getURI(prefix);
            }

            public StreamNamespaceSupport(XMLStreamReader reader) {
                super();
                this.reader = reader;
            }

        }

        public SDOXMLHelperImpl(XMLResource resource, XMLStreamReader reader) {
            this(reader);
            setResource(resource);
        }

        public SDOXMLHelperImpl(XMLStreamReader reader) {
            super();
            this.namespaceSupport = new StreamNamespaceSupport(reader);
        }
    }

    /**
     * An EMF XMLLoad that loads a model from a StAX stream
     */
    public class SDOXMLLoadImpl extends XMLLoadImpl {
        public SDOXMLLoadImpl(XMLHelper helper) {
            super(helper);
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
}
