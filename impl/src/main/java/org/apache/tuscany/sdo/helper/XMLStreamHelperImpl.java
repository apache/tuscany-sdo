/**
 *
 * Copyright 2006 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.tuscany.sdo.helper;

import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import commonj.sdo.helper.XMLDocument;
import commonj.sdo.DataObject;

import org.apache.tuscany.sdo.XMLStreamHelper;

/**
 * @version $Rev$ $Date$
 */
public class XMLStreamHelperImpl implements XMLStreamHelper {
    public XMLDocument load(XMLStreamReader reader) throws XMLStreamException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void save(XMLDocument document, XMLStreamWriter writer) throws XMLStreamException {
        throw new UnsupportedOperationException();
    }

    public DataObject loadObject(XMLStreamReader reader) throws XMLStreamException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void saveObject(DataObject sdo, XMLStreamWriter writer) throws XMLStreamException {
        throw new UnsupportedOperationException();
    }
}
