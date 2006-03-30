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


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.tuscany.sdo.impl.DynamicDataObjectImpl;
import org.apache.tuscany.sdo.util.DataObjectUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.ecore.XSDEcoreBuilder;
import org.eclipse.xsd.util.XSDResourceImpl;
import org.xml.sax.InputSource;

import commonj.sdo.Property;
import commonj.sdo.Type;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XSDHelper;


/**
 * Provides access to additional information when the 
 * Type or Property is defined by an XML Schema (XSD).
 * Methods return null/false otherwise or if the information is unavailable.
 * Defines Types from an XSD.
 */
public class XSDHelperImpl implements XSDHelper
{
  private XSDEcoreBuilder ecoreBuilder;

  private ExtendedMetaData extendedMetaData;

  public XSDHelperImpl(ExtendedMetaData extendedMetaData)
  {
    this.extendedMetaData = extendedMetaData;
    ecoreBuilder = new SDOXSDEcoreBuilder(extendedMetaData);
  }

  public XSDHelperImpl(TypeHelper typeHelper)
  {
    this(((TypeHelperImpl)typeHelper).extendedMetaData);
  }
  
  public String getLocalName(Type type)
  {
    return extendedMetaData.getName((EClassifier)type);
  }

  public String getLocalName(Property property)
  {
    return extendedMetaData.getName((EStructuralFeature)property);
  }

  public String getNamespaceURI(Property property)
  {
    return extendedMetaData.getNamespace((EStructuralFeature)property);
  }

  public boolean isAttribute(Property property)
  {
    return extendedMetaData.getFeatureKind((EStructuralFeature)property) == ExtendedMetaData.ATTRIBUTE_FEATURE;
  }

  public boolean isElement(Property property)
  {
    return extendedMetaData.getFeatureKind((EStructuralFeature)property) == ExtendedMetaData.ELEMENT_FEATURE;
  }

  public boolean isMixed(Type type)
  {
    if (type instanceof EClass)
    {
      return extendedMetaData.getContentKind((EClass)type) == ExtendedMetaData.MIXED_CONTENT;
    }
    else
    {
      return false;
    }
  }

  public boolean isXSD(Type type)
  {
    return ((EModelElement)type).getEAnnotation(ExtendedMetaData.ANNOTATION_URI) != null;
  }

  public Property getGlobalProperty(String uri, String propertyName, boolean isElement)
  {
    if (isElement)
    {
      return (Property)extendedMetaData.getElement(uri, propertyName);
    }
    else
    {
      return (Property)extendedMetaData.getAttribute(uri, propertyName);
    }
  }

  public String getAppinfo(Type type, String source)
  {
    return getAppinfo((EModelElement)type, source);
  }

  public String getAppinfo(Property property, String source)
  {
    return getAppinfo((EModelElement)property, source);
  }

  protected String getAppinfo(EModelElement eModelElement, String source)
  {
    return (String)eModelElement.getEAnnotation(source).getDetails().get("appinfo");
  }

  public List /*Type*/define(String xsd)
  {
    InputStream inputStream = new ByteArrayInputStream(xsd.getBytes());
    return define(inputStream, "*.xsd");

  }

  public List /*Type*/define(Reader xsdReader, String schemaLocation)
  {

    InputSource inputSource = new InputSource(xsdReader);
    return define(inputSource, schemaLocation);

  }

  public List /*Type*/define(InputStream xsdInputStream, String schemaLocation)
  {
    InputSource inputSource = new InputSource(xsdInputStream);
    return define(inputSource, schemaLocation);
  }

  protected List /*Type*/define(InputSource inputSource, String schemaLocation)
  {
    try
    {
      ResourceSet resourceSet = DataObjectUtil.createResourceSet();
      Resource model = resourceSet.createResource(URI.createURI(schemaLocation != null ? schemaLocation : "null.xsd"));
      ((XSDResourceImpl)model).load(inputSource, null);
      XSDSchema schema = (XSDSchema)model.getContents().get(0);    

      // If define() is called more than once for the same XMLSchema, return the existing defined types
      //FIXME ... need to rethink this design
      //if (!ecoreBuilder.getTargetNamespaceToEPackageMap().containsKey(schema.getTargetNamespace()))
      // also return generated types registered via SDOUtil.registerStaticTypes()
      EPackage ePackage = extendedMetaData.getPackage(schema.getTargetNamespace());
      if (ePackage == null)
      {
        ecoreBuilder.generate(schema);
        Collection newEPackages = ecoreBuilder.getTargetNamespaceToEPackageMap().values();
      
        for (Iterator iter = newEPackages.iterator(); iter.hasNext();)
        {
          EPackage currentPackage = (EPackage)iter.next();
          currentPackage.setEFactoryInstance(new DynamicDataObjectImpl.FactoryImpl());
          EcoreUtil.freeze(currentPackage);
        }
      }
      ePackage = extendedMetaData.getPackage(schema.getTargetNamespace());
      return ePackage.getEClassifiers();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new IllegalArgumentException(e.getMessage());
    }
  }

  public String generate(List /*Type*/types)
  {
    throw new UnsupportedOperationException(); //TODO
  }

  public String generate(List /*Type*/types, Map /*String, String*/namespaceToSchemaLocation)
  {
    throw new UnsupportedOperationException(); //TODO
  }

}
