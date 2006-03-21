/**
 *
 *  Copyright 2005 The Apache Software Foundation or its licensors, as applicable.
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


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import org.apache.tuscany.sdo.SDOPackage;
import org.apache.tuscany.sdo.util.DataObjectUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLOptions;
import org.eclipse.emf.ecore.xmi.XMLParserPool;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLOptionsImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;
import org.xml.sax.InputSource;

import commonj.sdo.DataObject;
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
  
  protected static XMLParserPool globalXMLParserPool = new XMLParserPoolImpl();
  
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
    
    XMLOptions xmlOptions = new XMLOptionsImpl();
    xmlOptions.setProcessAnyXML(true);
    resource.getDefaultLoadOptions().put(XMLResource.OPTION_XML_OPTIONS, xmlOptions);

    resource.getDefaultSaveOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, extendedMetaData);
    resource.getDefaultLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, extendedMetaData);
    
    resource.getDefaultLoadOptions().put(XMLResource.OPTION_USE_PARSER_POOL, globalXMLParserPool);
    
    resource.getDefaultLoadOptions().put(XMLResource.OPTION_USE_DEPRECATED_METHODS, Boolean.FALSE);
    
    resource.getDefaultSaveOptions().put(XMLResource.OPTION_CONFIGURATION_CACHE, Boolean.TRUE);
    resource.getDefaultLoadOptions().put(XMLResource.OPTION_CONFIGURATION_CACHE, Boolean.TRUE);
    
    resource.getDefaultLoadOptions().put(XMLResource.OPTION_ANY_TYPE, SDOPackage.eINSTANCE.getAnyTypeDataObject());
    resource.getDefaultSaveOptions().put(XMLResource.OPTION_ANY_TYPE, SDOPackage.eINSTANCE.getAnyTypeDataObject());

    resource.getDefaultLoadOptions().put(XMLResource.OPTION_ANY_SIMPLE_TYPE, SDOPackage.eINSTANCE.getSimpleAnyTypeDataObject());
    resource.getDefaultSaveOptions().put(XMLResource.OPTION_ANY_SIMPLE_TYPE, SDOPackage.eINSTANCE.getSimpleAnyTypeDataObject());

    //resource.getDefaultLoadOptions().put(XMLResource.OPTION_USE_XML_NAME_TO_FEATURE_MAP, globalHashMap);

    //resource.getDefaultSaveOptions().put(XMLResource.OPTION_FORMATTED, Boolean.FALSE);
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
    EObject oldContainer = null;
    EReference oldContainmentReference = null;
    int oldContainmentIndex = -1;

    if (documentRoot != null)
    {
      //TODO also check if rootObject is directly contained in a resource
      oldContainer = rootObject.eContainer();
      if (oldContainer != null)
      {
        oldContainmentReference = rootObject.eContainmentFeature();
      }
      if (oldContainer != documentRoot || oldContainmentReference != rootElement)
      {
        if (oldContainmentReference != null && oldContainmentReference.isMany())
        {
          oldContainmentIndex = ((List)oldContainer.eGet(oldContainmentReference)).indexOf(rootObject);
        }
        documentRoot.eSet(rootElement, rootObject);
      }
    }

    resource.save(outputStream, (Map)options);

    if (oldContainer != null)
    {
      if (oldContainer != documentRoot || oldContainmentReference != rootElement)
      {
        if (oldContainmentReference.isMany())
        {
          ((List)oldContainer.eGet(oldContainmentReference)).add(oldContainmentIndex, rootObject);
        }
        else
        {
          oldContainer.eSet(oldContainmentReference, rootObject);
        }
      }
    }
    else if (documentRoot != null)
    {
      documentRoot.eSet(rootElement, null);
    }
  }

  protected void save(Writer outputWriter, Object options) throws IOException
  {
    // TODO temporary brute-force implementation ... to be replaced
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    save(outputStream, options);
    outputWriter.write(new String(outputStream.toByteArray()));
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

  protected void load(InputSource inputSource, String locationURI, Object options) throws IOException
  {
    rootObject = null;
    rootElement = null;
    documentRoot = null;

    if (locationURI != null)
    {
      inputSource.setSystemId(locationURI);
      resource.setURI(URI.createURI(locationURI));
    }

    resource.load(inputSource, (Map)options);

    if (!resource.getContents().isEmpty())
    {
      documentRoot = (EObject)resource.getContents().get(0);
      EClass documentRootClass = documentRoot.eClass();
      if ("".equals(extendedMetaData.getName(documentRootClass))) //TODO efficient way to check this? Maybe DataObject.getContainer should also check this?
      {
        if (!documentRoot.eContents().isEmpty())
        {
          rootObject = (EObject)documentRoot.eContents().get(0);
          rootElement = rootObject.eContainmentFeature();
          documentRoot.eUnset(rootElement);
        }
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

  public String getSchemaLocation()
  {
    throw new UnsupportedOperationException(); //TODO
  }

  public void setSchemaLocation(String schemaLocation)
  {
    throw new UnsupportedOperationException(); //TODO
  }

  public String getNoNamespaceSchemaLocation()
  {
    throw new UnsupportedOperationException(); //TODO
  }

  public void setNoNamespaceSchemaLocation(String schemaLocation)
  {
    throw new UnsupportedOperationException(); //TODO
  }
}
