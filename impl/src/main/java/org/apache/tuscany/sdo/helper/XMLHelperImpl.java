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
package org.apache.tuscany.sdo.helper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.xml.sax.InputSource;

import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XMLHelper;

/**
 * A helper to convert XML documents into DataObects and DataObjects into XML
 * documnets.
 */
public class XMLHelperImpl implements XMLHelper {
    protected HelperContext helperContext;
    private ExtendedMetaData extendedMetaData;


    public XMLHelperImpl(HelperContext hc) {
        this.helperContext = hc;
        this.extendedMetaData = ((HelperContextImpl)hc).extendedMetaData;
    }

    public XMLDocument load(String inputString) {
        try {
            return load(new StringReader(inputString), null, null);
        } catch (IOException e) {
            throw new RuntimeException(e); // should never happen
        }
    }

    public XMLDocument load(String inputString, Object options) {
        try {
            return load(new StringReader(inputString), null, options);
        } catch (IOException e) {
            throw new RuntimeException(e); // should never happen
        }
    }

    public XMLDocument load(InputStream inputStream) throws IOException {
        return load(inputStream, null, null);
    }

    private Object checkSetOptions(Object options) throws IOException {
        if (options != null && !(options instanceof Map)) {
            throw new IOException("Invalid load options!");
        }

        if (helperContext != null) {
            return ((HelperContextImpl)helperContext).getMergedOption((Map)options);
        } else {// null is acceptable as it will be ignored
            return options;
        }
    }

    public XMLDocument load(InputStream inputStream, String locationURI, Object options) throws IOException {
        options = checkSetOptions(options);
        XMLDocumentImpl document = new XMLDocumentImpl(extendedMetaData, options);
        document.load(inputStream, locationURI, options);
        return document;
    }

    public XMLDocument load(Reader inputReader, String locationURI, Object options) throws IOException {
        XMLDocumentImpl document = new XMLDocumentImpl(extendedMetaData, options);
        options = checkSetOptions(options);
        document.load(inputReader, locationURI, options);
        return document;
    }

    public XMLDocument load(Source source, String locationURI, Object options) throws IOException {
        options = checkSetOptions(options);
        if (source instanceof DOMSource) {
            DOMSource domSource = (DOMSource)source;
            XMLDocumentImpl document = new XMLDocumentImpl(extendedMetaData, options);
            document.load(domSource.getNode(), options);
            return document;
        } else if (source instanceof SAXSource) {
            XMLDocumentImpl document = new XMLDocumentImpl(extendedMetaData, options);
            InputSource inputSource = SAXSource.sourceToInputSource(source);
            document.load(inputSource, locationURI, options);
            return document;
        } else if (source instanceof StreamSource) {
            return load(((StreamSource)source).getInputStream(), locationURI, options);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public String save(DataObject dataObject, String rootElementURI, String rootElementName) {
        StringWriter stringWriter = new StringWriter();
        try {
            save(createDocument(dataObject, rootElementURI, rootElementName), stringWriter, null);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(e); // should never happen
        }
    }

    public String save(DataObject dataObject, String rootElementURI, String rootElementName, Object options) {
        StringWriter stringWriter = new StringWriter();
        try {
            save(createDocument(dataObject, rootElementURI, rootElementName), stringWriter, options);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(e); // should never happen
        }
    }

    public void save(DataObject dataObject, String rootElementURI, String rootElementName, OutputStream outputStream)
        throws IOException {
        save(createDocument(dataObject, rootElementURI, rootElementName), outputStream, null);
    }


    public void save(DataObject dataObject,
                     String rootElementURI,
                     String rootElementName,
                     OutputStream outputStream,
                     Object options) throws IOException {
        save(createDocument(dataObject, rootElementURI, rootElementName), outputStream, null);
    }

    public void save(XMLDocument xmlDocument, OutputStream outputStream, Object options) throws IOException {
        options = checkSetOptions(options);
        ((XMLDocumentImpl)xmlDocument).save(outputStream, options);
    }

    public void save(XMLDocument xmlDocument, Writer outputWriter, Object options) throws IOException {
        options = checkSetOptions(options);
        ((XMLDocumentImpl)xmlDocument).save(outputWriter, options);
    }

    public void save(XMLDocument xmlDocument, Result outputResult, Object options) throws IOException {
        options = checkSetOptions(options);
        if (outputResult instanceof DOMResult) {
            ((XMLDocumentImpl)xmlDocument).save(((DOMResult)outputResult).getNode(), options);
        } else if (outputResult instanceof SAXResult) {
            throw new UnsupportedOperationException();
        } else if (outputResult instanceof StreamResult) {
            save(xmlDocument, ((StreamResult)outputResult).getOutputStream(), options);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public XMLDocument createDocument(DataObject dataObject, String rootElementURI, String rootElementName) {
        XMLDocument xmlDocument = new XMLDocumentImpl(extendedMetaData, dataObject, rootElementURI, rootElementName);
        xmlDocument.setEncoding("UTF-8");
        return xmlDocument;
    }

    public HelperContext getHelperContext() {
        return helperContext;
    }
}
