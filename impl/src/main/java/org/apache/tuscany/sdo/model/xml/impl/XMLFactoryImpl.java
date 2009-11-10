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
package org.apache.tuscany.sdo.model.xml.impl;

import commonj.sdo.helper.HelperContext;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.FactoryBase;

import org.apache.tuscany.sdo.model.ModelFactory;

import org.apache.tuscany.sdo.model.impl.ModelFactoryImpl;

import org.apache.tuscany.sdo.model.internal.InternalFactory;

import org.apache.tuscany.sdo.model.internal.impl.InternalFactoryImpl;

import org.apache.tuscany.sdo.model.xml.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the commonj.sdo/xml model factory.
 * This model is generated from sdoXML.xsd, in the sdo-api project.
 * Until the SDO code generator supports name conflicts and regen/merge, follow the following steps to regenerate this model:
 *   1. Regenerate the model into a temporary directory:
 *         XSD2JavaGenerator -generateBuiltIn commonj.sdo/xml -prefix XML -targetDirectory <temp-dir> -javaPackage org.apache.tuscany.sdo.model.xml <sdo-api-dir>/src/main/resources/xml/sdoXML.xsd
 *   2. Make sure the top of each generated file contains the ASF License.      
 *   3. Move this JavaDoc comment into the newly generated XMLFactoryImpl class.
 * <!-- end-user-doc -->
 * @generated
 */
public class XMLFactoryImpl extends FactoryBase implements XMLFactory
{

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_URI = "commonj.sdo/xml";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_PREFIX = "sdoXML";

  /**
   * The version of the generator pattern used to generate this class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String PATTERN_VERSION = "1.2";
  
  public static final int XML_INFO = 1;
  
  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMLFactoryImpl()
  {
    super(NAMESPACE_URI, NAMESPACE_PREFIX, "org.apache.tuscany.sdo.model.xml");
  }

  /**
   * Registers the Factory instance so that it is available within the supplied scope.
   * @argument scope a HelperContext instance that will make the types supported by this Factory available.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void register(HelperContext scope) 
  {
    if(scope == null) {
      throw new IllegalArgumentException("Scope can not be null");
    }
    
    //Register dependent packages with provided scope
    ModelFactory.INSTANCE.register(scope);
    InternalFactory.INSTANCE.register(scope);
    
    // Initialize this package   
    TypeHelperImpl th = (TypeHelperImpl)scope.getTypeHelper();
    th.getExtendedMetaData().putPackage(NAMESPACE_URI, this);
  }
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataObject create(int typeNumber)
  {
    switch (typeNumber)
    {
      case XML_INFO: return (DataObject)createXMLInfo();
      default:
        return super.create(typeNumber);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMLInfo createXMLInfo()
  {
    XMLInfoImpl xmlInfo = new XMLInfoImpl();
    return xmlInfo;
  }
  
  // Following creates and initializes SDO metadata for the supported types.			
  protected Type xmlInfoType = null;

  public Type getXMLInfo()
  {
    return xmlInfoType;
  }
  

  private static XMLFactoryImpl instance = null; 
  public static XMLFactoryImpl init()
  {
    if (instance != null ) return instance;
    instance = new XMLFactoryImpl();

    // Initialize dependent packages
    ModelFactory ModelFactoryInstance = ModelFactory.INSTANCE;
    InternalFactory InternalFactoryInstance = InternalFactory.INSTANCE;
    
    // Create package meta-data objects
    instance.createMetaData();

    // Initialize created meta-data
    instance.initializeMetaData();
    
    // Mark meta-data to indicate it can't be changed
    //theXMLFactoryImpl.freeze(); //FB do we need to freeze / should we freeze ????

    return instance;
  }
  
  private boolean isCreated = false;

  public void createMetaData()
  {
    if (isCreated) return;
    isCreated = true;	

    // Create types and their properties
    xmlInfoType = createType(false, XML_INFO);
    createProperty(true, xmlInfoType,XMLInfoImpl.INTERNAL_XML_ELEMENT); 
  }
  
  private boolean isInitialized = false;

  public void initializeMetaData()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Obtain other dependent packages
    ModelFactoryImpl theModelPackageImpl = (ModelFactoryImpl)ModelFactory.INSTANCE;
    InternalFactoryImpl theInternalPackageImpl = (InternalFactoryImpl)InternalFactory.INSTANCE;
    Property property = null;

    // Add supertypes to types

    // Initialize types and properties
    initializeType(xmlInfoType, XMLInfo.class, "XMLInfo", false);
    property = getLocalProperty(xmlInfoType, 0);
    initializeProperty(property, theModelPackageImpl.getBoolean(), "xmlElement", null, 0, 1, XMLInfo.class, false, true, false);

    createXSDMetaData(theModelPackageImpl, theInternalPackageImpl);
  }
    
  protected void createXSDMetaData(ModelFactoryImpl theModelPackageImpl, InternalFactoryImpl theInternalPackageImpl)
  {
    super.initXSD();
    
    Property property = null;
    

    property = createGlobalProperty
      ("aliasName",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "attribute",
       "name", "aliasName",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("dataType",
      theInternalPackageImpl.getQName(),
       new String[]
       {
       "kind", "attribute",
       "name", "dataType",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("many",
      theModelPackageImpl.getBoolean(),
       new String[]
       {
       "kind", "attribute",
       "name", "many",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("name",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "attribute",
       "name", "name",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("oppositeProperty",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "attribute",
       "name", "oppositeProperty",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("propertyType",
      theInternalPackageImpl.getQName(),
       new String[]
       {
       "kind", "attribute",
       "name", "propertyType",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("readOnly",
      theModelPackageImpl.getBoolean(),
       new String[]
       {
       "kind", "attribute",
       "name", "readOnly",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("sequence",
      theModelPackageImpl.getBoolean(),
       new String[]
       {
       "kind", "attribute",
       "name", "sequence",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("string",
      theModelPackageImpl.getBoolean(),
       new String[]
       {
       "kind", "attribute",
       "name", "string",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    property = createGlobalProperty
      ("xmlElement",
      theModelPackageImpl.getBoolean(),
       new String[]
       {
       "kind", "attribute",
       "name", "xmlElement",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    addXSDMapping
      (xmlInfoType,
       new String[] 
       {
       "name", "XMLInfo",
       "kind", "empty"
       });

    addXSDMapping
      (getProperty(xmlInfoType, XMLInfoImpl.INTERNAL_XML_ELEMENT),
       new String[]
       {
       "kind", "attribute",
       "name", "xmlElement"
       });

  }
    
} //XMLFactoryImpl
