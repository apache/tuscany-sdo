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

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import org.apache.tuscany.sdo.util.resource.DataObjectXMLStreamReader;
import org.eclipse.emf.ecore.resource.Resource;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLDocument;

/**
 * @version $Rev$ $Date$
 */
public class XMLStreamHelperImpl implements XMLStreamHelper
{
  TypeHelperImpl typeHelper;
  
  public XMLStreamHelperImpl(TypeHelper typeHelper)
  {
    this.typeHelper = (TypeHelperImpl)typeHelper;
  }

  public XMLDocument load(XMLStreamReader reader) throws XMLStreamException, IllegalStateException
  {
    if (reader.getEventType() != XMLStreamConstants.START_DOCUMENT)
      throw new IllegalStateException();
    
    return loadDocument(reader);
  }
  
  public void save(XMLDocument document, XMLStreamWriter writer) throws XMLStreamException
  {
    throw new UnsupportedOperationException();
  }

  public XMLStreamReader createXMLStreamReader(XMLDocument document) throws XMLStreamException
  {
    throw new UnsupportedOperationException();
  }

  public DataObject loadObject(XMLStreamReader reader) throws XMLStreamException, IllegalStateException
  {
    if (reader.getEventType() != XMLStreamConstants.START_ELEMENT)
      throw new IllegalStateException();
    
    return loadDocument(reader).getRootObject();
  }

  public void saveObject(DataObject sdo, XMLStreamWriter writer) throws XMLStreamException
  {
    throw new UnsupportedOperationException();
  }

  public XMLStreamReader createXMLStreamReader(DataObject dataObject)
  {
    String rootElementURI;
    String rootElementName;
    
    Property property = dataObject.getContainmentProperty();
    if (property != null)
    {
      rootElementName = property.getName();
      rootElementURI = property.getType().getURI();
    }
    else
    {
      rootElementName = dataObject.getType().getName();
      rootElementURI = dataObject.getType().getURI();
    }
    
    return new DataObjectXMLStreamReader(dataObject, rootElementURI, rootElementName, typeHelper);
  }
  
  protected XMLDocument loadDocument(XMLStreamReader reader) throws XMLStreamException
  {
    try {
      XMLDocumentImpl document = new XMLDocumentImpl(typeHelper.extendedMetaData, null);
      document.load(reader);
      return document;
    }
    catch (Exception e) {
      if (e instanceof Resource.IOWrappedException)
      {
        Resource.IOWrappedException ioe = (Resource.IOWrappedException)e;
        if (ioe.getWrappedException() instanceof XMLStreamException)
        {
          throw (XMLStreamException)ioe.getWrappedException();
        }
      }
      throw new RuntimeException(e); // ????
    }
  }

}
