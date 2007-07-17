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


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLStreamReader;

import org.apache.tuscany.sdo.SimpleAnyTypeDataObject;
import org.apache.tuscany.sdo.util.DataObjectUtil;
import org.apache.tuscany.sdo.util.SDOUtil;
import org.apache.tuscany.sdo.util.resource.SDOXMLResourceImpl;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.XMLDocument;


/**
 * Represents an XML Document containing a tree of DataObjects.
 * 
 * An example XMLDocument fragment is:
 * <?xml version="1.0"?>
 * <purchaseOrder orderDate="1999-10-20">
 * 
 * created from this XML Schema fragment:
 * <xsd:schema xmlns:xsd="http://www.w3.org/2001/XMLSchema">
 *   <xsd:element name="purchaseOrder" type="PurchaseOrderType"/>
 *   <xsd:complexType name="PurchaseOrderType">
 *
 * Upon loading this XMLDocument:
 *   DataObject is an instance of Type PurchaseOrderType.
 *   RootElementURI is null because the XSD has no targetNamespace URI.
 *   RootElementName is purchaseOrder.
 *   Encoding is null because the document did not specify an encoding.
 *   XMLDeclaration is true because the document contained an XML declaration.
 *   XMLVersion is 1.0
 *   SchemaLocation and noNamespaceSchemaLocation are null because they are
 *     not specified in the document.
 * 
 * When saving the root element, if the type of the root dataObject is not the
 *   type of global element specified by rootElementURI and rootElementName, 
 *   or if a global element does not exist for rootElementURI and rootElementName,
 *   then an xsi:type declaration is written to record the root DataObject's Type.
 * 
 * When loading the root element and an xsi:type declaration is found
 *   it is used as the type of the root DataObject.  In this case,
 *   if validation is not being performed, it is not an error if the
 *   rootElementName is not a global element.
 */
public class XMLDocumentImpl implements XMLDocument
{
  protected ExtendedMetaData extendedMetaData;

  protected EObject rootObject;

  protected XMLResource resource;

  protected EStructuralFeature rootElement;

  protected EObject documentRoot;
  
  protected final static String WHITESPACE_REGEX = "\\s";
  
  //TODO clean up the options thing
  protected XMLDocumentImpl(ExtendedMetaData extendedMetaData, Object options)
  {
    this.extendedMetaData = extendedMetaData;
    ResourceSet resourceSet = DataObjectUtil.createResourceSet();
    
    if (options instanceof Map)
    {
      Class resourceFactoryClass = (Class)((Map)options).get("GENERATED_LOADER");
      if (resourceFactoryClass != null)
      {
        try
        {
          Object resourceFactory = resourceFactoryClass.newInstance();
          resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", resourceFactory);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    }
  
    resource = (XMLResource)resourceSet.createResource(URI.createURI("http:///temp.xml"));
    DataObjectUtil.configureXMLResource(resource, extendedMetaData);
  }

  protected XMLDocumentImpl(ExtendedMetaData extendedMetaData)
  {
    this(extendedMetaData, null);
  }

  protected XMLDocumentImpl(ExtendedMetaData extendedMetaData, DataObject dataObject, String rootElementURI, String rootElementName)
  {
    this(extendedMetaData);

    rootObject = (EObject)dataObject;

    rootElement = extendedMetaData.getElement(rootElementURI, rootElementName);
    if (rootElement == null)
    {
      rootElement = ExtendedMetaData.INSTANCE.demandFeature(rootElementURI, rootElementName, true);
    }

    EClass documentRootClass = rootElement.getEContainingClass();
    documentRoot = EcoreUtil.create(documentRootClass);
    resource.getContents().add(documentRoot);
  }

  protected void save(OutputStream outputStream, Object options) throws IOException
  {
    save(outputStream, null, options);
  }
    
  protected void save(Writer outputWriter, Object options) throws IOException
  {
    // TODO temporary brute-force implementation ... to be replaced
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    save(outputStream, options);
    outputWriter.write(new String(outputStream.toByteArray()));
  }

  protected void save(Node node, Object options) throws IOException
  {
    save(null, (Document)node, options);
  }
  
  protected void save(OutputStream outputStream, Document document, Object options) throws IOException
  {
    EObject oldContainer = null;
    Resource oldResource = null;
    EReference oldContainmentReference = null;
    int oldContainmentIndex = -1;

    if (documentRoot != null)
    {
      oldContainer = rootObject.eContainer();
      if (oldContainer != null)
        oldContainmentReference = rootObject.eContainmentFeature();
      else
        oldResource = rootObject.eResource();
      if (oldContainer != documentRoot || oldContainmentReference != rootElement)
      {
        if (oldResource != null)
        {
          oldContainmentIndex = oldResource.getContents().indexOf(rootObject);
          oldResource.getContents().remove(oldContainmentIndex);
        }
        else if (oldContainmentReference != null && FeatureMapUtil.isMany(oldContainer, oldContainmentReference))
          oldContainmentIndex = ((List)oldContainer.eGet(oldContainmentReference)).indexOf(rootObject);
        
        Object rootValue =
          rootElement instanceof EAttribute && rootObject instanceof SimpleAnyTypeDataObject ?
            ((SimpleAnyTypeDataObject)rootObject).getValue() : rootObject;
            
        documentRoot.eSet(rootElement, rootValue);
      }
    }

    if (outputStream != null)
      resource.save(outputStream, (Map)options);
    else // if (document != null)
      resource.save(document, (Map)options, null);

    if (oldResource != null)
    {
      oldResource.getContents().add(oldContainmentIndex, rootObject);
    }
    if (rootElement instanceof EReference)
    {
      if (oldContainer != null)
      {
        if (oldContainer != documentRoot || oldContainmentReference != rootElement)
        {
          if (FeatureMapUtil.isMany(oldContainer, oldContainmentReference))
            ((List)oldContainer.eGet(oldContainmentReference)).add(oldContainmentIndex, rootObject);
          else
            oldContainer.eSet(oldContainmentReference, rootObject);
        }
      }
      else if (documentRoot != null)
      {
        documentRoot.eSet(rootElement, null);
      }
    }
  }

  protected void load(InputStream inputStream, String locationURI, Object options) throws IOException
  {
    InputSource inputSource = new InputSource(inputStream);
    load(inputSource, locationURI, options);
  }

  protected void load(Reader inputReader, String locationURI, Object options) throws IOException
  {
    InputSource inputSource = new InputSource(inputReader);
    load(inputSource, locationURI, options);
  }
  
  protected final void load(Node node, Object options) throws IOException {
      resource.load(node, (Map)options);
      initLoadedRoot();
  }

  protected final void load(XMLStreamReader reader, Map options) throws IOException
  {
    ((SDOXMLResourceImpl)resource).load(reader, options);
    initLoadedRoot();
  }

  protected void load(InputSource inputSource, String locationURI, Object options) throws IOException
  {
    if (locationURI != null)
    {
      inputSource.setSystemId(locationURI);
      resource.setURI(URI.createURI(locationURI));
    }
    resource.load(inputSource, (Map)options);
    initLoadedRoot();
  }

  /**
   * @return a Map object with key-value pair where key is the DataObject and value contains the info 
   * about the unknown properties for the DataObject
   */
  public Map getUnknownProperties(){
      return resource.getEObjectToExtensionMap();
  }
  
  private void initLoadedRoot()
  {
    rootObject = null;
    rootElement = null;
    documentRoot = null;

    if (!resource.getContents().isEmpty())
    {
      documentRoot = (EObject)resource.getContents().get(0);
      EClass documentRootClass = documentRoot.eClass();
      if ("".equals(extendedMetaData.getName(documentRootClass))) //TODO efficient way to check this? Maybe DataObject.getContainer should also check this?
      {
        FeatureMap featureMap = (FeatureMap)documentRoot.eGet(documentRootClass.getEStructuralFeature(0)); // get mixed feature
        int size = featureMap.size();
        for (int index = 0; index < size; index++)
        {
          EStructuralFeature feature = featureMap.getEStructuralFeature(index);
          boolean isText = 
            feature == XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT ||
            feature == XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__CDATA ||    
            feature == XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__COMMENT;
          if (!isText)
          {
            if (feature instanceof EReference)
            {
              rootObject = (EObject)featureMap.getValue(index);
              documentRoot.eUnset(feature);
            }
            else //EAttribute
            {
              rootObject = (EObject)SDOUtil.createDataTypeWrapper((Type)feature.getEType(), featureMap.getValue(index));
            }
            rootElement = feature;
            break;
          }
        } //for
        if (rootObject == null)
          rootObject = ((SDOXMLResourceImpl) resource).root;
      }
      else
      {
        rootObject = documentRoot;
        documentRoot = null;
      }
    }
  }
  
  public DataObject getRootObject()
  {
    return (DataObject)rootObject;
  }

  public String getRootElementURI()
  {
    if (rootElement != null)
    {
      return extendedMetaData.getNamespace(rootElement);
    }
    else if (rootObject != null)
    {
      return extendedMetaData.getNamespace(rootObject.eClass());
    }
    return null;
  }

  public String getRootElementName()
  {
    if (rootElement != null)
    {
      return extendedMetaData.getName(rootElement);
    }
    else if (rootObject != null)
    {
      return extendedMetaData.getName(rootObject.eClass());
    }
    return null;
  }

  public String getEncoding()
  {
    return resource.getEncoding();
  }

  public void setEncoding(String encoding)
  {
    resource.setEncoding(encoding);
  }

  public boolean isXMLDeclaration()
  {
    return Boolean.FALSE.equals(resource.getDefaultSaveOptions().get(XMLResource.OPTION_DECLARE_XML));
  }

  public void setXMLDeclaration(boolean xmlDeclaration)
  {
    resource.getDefaultSaveOptions().put(XMLResource.OPTION_DECLARE_XML, xmlDeclaration ? Boolean.TRUE : Boolean.FALSE);
  }

  public String getXMLVersion()
  {
    return resource.getXMLVersion();
  }

  public void setXMLVersion(String xmlVersion)
  {
    resource.setXMLVersion(xmlVersion);
  }

  /**
   * @return an EMap containing the schema locations or null when no map
   */
  protected EMap getSchemaLocationMap()
  {
    EMap result = null;
    if ((documentRoot != null) && (extendedMetaData != null))
    {
      EReference xsiSchemaLocationMapFeature = extendedMetaData
          .getXSISchemaLocationMapFeature(documentRoot.eClass());
      if (xsiSchemaLocationMapFeature != null)
      {
        result = (EMap) documentRoot.eGet(xsiSchemaLocationMapFeature);
      }
    }
    return result;
  }

  /**
   * @param value
   *          from schema location map.
   * @return string form of URI from provided value, deresolved if appropriate.
   */
  protected String deresolve(String value)
  {
    URI location = URI.createURI(value);
    URI resourceURI = resource.getURI();
    boolean shouldDeresolve = resourceURI != null && !resourceURI.isRelative()
        && resourceURI.isHierarchical();
    if (shouldDeresolve && !location.isRelative())
    {
      URI deresolvedURI = location.deresolve(resourceURI, true, true, false);
      if (deresolvedURI.hasRelativePath())
      {
        location = deresolvedURI;
      }
    }
    return location.toString();
  }

  /**
   * @param value
   *          for schema location from input parameter.
   * @return string form of URI from provided value, resolved if appropriate.
   */
  protected String resolve(String value)
  {
    URI location = URI.createURI(value);
    URI resourceURI = resource.getURI();
    boolean shouldResolve = resourceURI != null && resourceURI.isHierarchical()
        && !resourceURI.isRelative();
    if (shouldResolve && location.isRelative() && location.hasRelativePath())
    {
      location = location.resolve(resourceURI, false);
    }
    return location.toString();
  }

  public String getSchemaLocation()
  {
    EMap xsiSchemaLocationMap = getSchemaLocationMap();
    if (xsiSchemaLocationMap != null)
    {
      if (!xsiSchemaLocationMap.isEmpty())
      {
        StringBuffer xsiSchemaLocation = new StringBuffer();
        for (Iterator i = xsiSchemaLocationMap.entrySet().iterator(); i
            .hasNext();)
        {
          Map.Entry entry = (Map.Entry) i.next();
          String namespace = (String) entry.getKey();
          if (namespace != null)
          {
            if (xsiSchemaLocation.length() > 0)
            {
              xsiSchemaLocation.append(' ');
            }
            xsiSchemaLocation.append(namespace);
            xsiSchemaLocation.append(' ');
            String value = entry.getValue().toString();
            xsiSchemaLocation.append(deresolve(value));
          }
        }
        return xsiSchemaLocation.toString().equals("") ? null
            : xsiSchemaLocation.toString();
      }
    }
    return null;
  }

  public void setSchemaLocation(String schemaLocation)
  {
    EMap xsiSchemaLocationMap = getSchemaLocationMap();
    if (xsiSchemaLocationMap != null)
    {
      // only remove the entries from xsiSchemaLocationMap that contain a
      // non-null key
      for (Iterator i = xsiSchemaLocationMap.entrySet().iterator(); i.hasNext();)
      {
        Map.Entry entry = (Map.Entry) i.next();
        if (entry.getKey() != null)
        {
          i.remove();
        }
      }
      if (xsiSchemaLocationMap.size() == 0)
      {
        resource.getDefaultSaveOptions().put(
            XMLResource.OPTION_SCHEMA_LOCATION, Boolean.FALSE);
      }
      if (schemaLocation != null)
      {
        String[] values = schemaLocation.split(WHITESPACE_REGEX);
        for (int i = 0; i < values.length; i++) // note: also incremented in
        // loop
        {
          String key = values[i++];
          if (i < values.length)
          {
            xsiSchemaLocationMap.put(key, resolve(values[i]));
          }
        }
        if (xsiSchemaLocationMap.size() != 0)
        {
          resource.getDefaultSaveOptions().put(
              XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
        }
      }
    }
  }

  public String getNoNamespaceSchemaLocation()
  {
    EMap xsiSchemaLocationMap = getSchemaLocationMap();
    if (xsiSchemaLocationMap != null)
    {
      StringBuffer xsiSchemaLocation = new StringBuffer();
      if (!xsiSchemaLocationMap.isEmpty())
      {
        Object valueObject = xsiSchemaLocationMap.get(null);
        if (valueObject != null)
        {
          String valueString = (String) valueObject;
          String[] values = valueString.split(WHITESPACE_REGEX);
          for (int i = 0; i < values.length; i++)
          {
            if (xsiSchemaLocation.length() > 0)
            {
              xsiSchemaLocation.append(' ');
            }
            xsiSchemaLocation.append(deresolve(values[i]));
          }
        }
        String result = xsiSchemaLocation.toString();
        return result.equals("") ? null : result;
      }
    }
    return null;
  }

  public void setNoNamespaceSchemaLocation(String schemaLocation)
  {
    EMap xsiSchemaLocationMap = getSchemaLocationMap();
    if (xsiSchemaLocationMap != null)
    {
      // only remove the entries from xsiSchemaLocationMap that contain a null
      // key
      xsiSchemaLocationMap.removeKey(null);
      if (xsiSchemaLocationMap.size() == 0)
      {
        resource.getDefaultSaveOptions().put(
            XMLResource.OPTION_SCHEMA_LOCATION, Boolean.FALSE);
      }
      if (schemaLocation != null)
      {
        String[] values = schemaLocation.split(WHITESPACE_REGEX);
        for (int i = 0; i < values.length; i++)
        {
          xsiSchemaLocationMap.put(null, resolve(values[i]));
        }
        if (xsiSchemaLocationMap.size() != 0)
        {
          resource.getDefaultSaveOptions().put(
              XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
        }
      }
    }
  }
}
