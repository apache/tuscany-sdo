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
package org.apache.tuscany.sdo.api;

import java.util.Map;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLDocument;

/**
 * Helper interface for reading and writing SDO DataObjects from XML streams
 * (StAX).
 * 
 * @version $Rev: 503913 $ $Date: 2007-02-05 17:53:34 -0500 (Mon, 05 Feb 2007) $
 */
public interface XMLStreamHelper {
    /**
     * Creates and returns an XMLDocument from an XML input stream. The reader
     * must be positioned on a START_DOCUMENT event.
     * 
     * @param reader the stream to read
     * @return an XMLDocument created from the stream
     * @throws XMLStreamException if there was a problem reading the stream
     * @throws IllegalStateException if the reader is not positioned on a
     *             START_DOCUMENT event
     */
    XMLDocument load(XMLStreamReader reader) throws XMLStreamException, IllegalStateException;

    /**
     * Save a XMLDocument to an XML stream.
     * 
     * @param document the document to be written
     * @param writer the stream to write to
     * @throws XMLStreamException if there was a problem writing to the stream
     */
    void save(XMLDocument document, XMLStreamWriter writer) throws XMLStreamException;

    void save(XMLDocument document, XMLStreamWriter writer, Map options) throws XMLStreamException;

    /**
     * Creates and returns a XMLStreamReader that can be used to read an
     * XMLDocument as a XML event stream. The reader will be positioned on a
     * START_DOCUMENT event.
     * 
     * @param document the XMLDocument to be read
     * @return an XMLStreamReader that can be used to read the document
     */
    XMLStreamReader createXMLStreamReader(XMLDocument document) throws XMLStreamException;

    /**
     * Create a DataObject from an element in a XML stream. The reader must be
     * positioned on a START_ELEMENT event.
     * 
     * @param reader the stream to read
     * @return a DataObject created from the element in the stream
     * @throws XMLStreamException if there was a problem reading the stream
     * @throws IllegalStateException if the reader is not positioned on a
     *             START_ELEMENT event
     */
    DataObject loadObject(XMLStreamReader reader) throws XMLStreamException, IllegalStateException;

    /**
     * Default Type to load DataObject if the element is unqualified/local
     * without xsi:type or the qualified/global element or xsi:type fail to
     * resolve. Can be null.
     */
    String OPTION_DEFAULT_ROOT_TYPE = "default root type";

    /**
     * Create a DataObject from an element in a XML stream. The reader must be
     * positioned on a START_ELEMENT event.
     * 
     * @param reader the stream to read
     * @param options {@link OPTION_DEFAULT_ROOT_TYPE}; can be null or empty
     * @return a DataObject created from the element in the stream
     * @throws XMLStreamException if there was a problem reading the stream
     * @throws IllegalStateException if the reader is not positioned on a
     *             START_ELEMENT event
     */
    DataObject loadObject(XMLStreamReader reader, Map options) throws XMLStreamException, IllegalStateException;

    /**
     * Save a DataObject to an XML stream.
     * 
     * @param sdo the DataObject to be written
     * @param writer the stream to write to
     * @throws XMLStreamException if there was a problem writing to the stream
     */
    void saveObject(DataObject sdo, XMLStreamWriter writer) throws XMLStreamException;

    void saveObject(DataObject sdo, XMLStreamWriter writer, Map options) throws XMLStreamException;

    /**
     * Creates and returns a XMLStreamReader that can be used to read a
     * DataObject as a XML event stream. The reader will be positioned on a
     * START_ELEMENT event.
     * 
     * @param sdo the DataObject to be read
     * @return an XMLStreamReader that can be used to read the DataObject
     */
    XMLStreamReader createXMLStreamReader(DataObject sdo);

    HelperContext getHelperContext();
}
