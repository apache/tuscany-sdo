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
package com.example.open.impl;

import commonj.sdo.helper.HelperContext;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;

import com.example.open.*;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

import org.apache.tuscany.sdo.SDOFactory;

import org.apache.tuscany.sdo.impl.FactoryBase;

import org.apache.tuscany.sdo.model.ModelFactory;

import org.apache.tuscany.sdo.model.impl.ModelFactoryImpl;

import org.apache.tuscany.sdo.model.internal.InternalFactory;

import org.apache.tuscany.sdo.util.SDOUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * Generator information:
 * patternVersion=1.1;
 * <!-- end-user-doc -->
 * @generated
 */
public class OpenFactoryImpl extends FactoryBase implements OpenFactory
{

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_URI = "http://www.example.com/open";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_PREFIX = "open";

  /**
   * The version of the generator pattern used to generate this class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String PATTERN_VERSION = "1.1";
  
  public static final int ONE_ELEMENT_AND_ANY_ATTR = 1;
  
  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OpenFactoryImpl()
  {
    super(NAMESPACE_URI, NAMESPACE_PREFIX, "com.example.open");
  }

  /**
   * Registers the Factory instance so that it is available within the supplied scope.
   * @argument scope a HelperContext instance that will make the types supported by this Factory available.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */	
  public void register(HelperContext scope) {
    if(scope == null) {
       throw new IllegalArgumentException("Scope can not be null");
    } 
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
      case ONE_ELEMENT_AND_ANY_ATTR: return (DataObject)createOneElementAndAnyAttr();
      default:
        return super.create(typeNumber);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OneElementAndAnyAttr createOneElementAndAnyAttr()
  {
    OneElementAndAnyAttrImpl oneElementAndAnyAttr = new OneElementAndAnyAttrImpl();
    return oneElementAndAnyAttr;
  }
  
  // Following creates and initializes SDO metadata for the supported types.			
  protected Type oneElementAndAnyAttrType = null;

  public Type getOneElementAndAnyAttr()
  {
    return oneElementAndAnyAttrType;
  }
  

  private static boolean isInited = false;

  public static OpenFactoryImpl init()
  {
    if (isInited) return (OpenFactoryImpl)FactoryBase.getStaticFactory(OpenFactoryImpl.NAMESPACE_URI);
    OpenFactoryImpl theOpenFactoryImpl = new OpenFactoryImpl();
    isInited = true;

    // Initialize simple dependencies
    SDOUtil.registerStaticTypes(SDOFactory.class);
    SDOUtil.registerStaticTypes(ModelFactory.class);
    SDOUtil.registerStaticTypes(InternalFactory.class);

    // Create package meta-data objects
    theOpenFactoryImpl.createMetaData();

    // Initialize created meta-data
    theOpenFactoryImpl.initializeMetaData();

    // Mark meta-data to indicate it can't be changed
    //theOpenFactoryImpl.freeze(); //FB do we need to freeze / should we freeze ????

    return theOpenFactoryImpl;
  }
  
  private boolean isCreated = false;

  public void createMetaData()
  {
    if (isCreated) return;
    isCreated = true;	

    // Create types and their properties
          oneElementAndAnyAttrType = createType(false, ONE_ELEMENT_AND_ANY_ATTR);
    createProperty(true, oneElementAndAnyAttrType,OneElementAndAnyAttrImpl.INTERNAL_NAME); 
    createProperty(true, oneElementAndAnyAttrType,OneElementAndAnyAttrImpl.INTERNAL_ANY_ATTRIBUTE); 
  }
  
  private boolean isInitialized = false;

  public void initializeMetaData()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Obtain other dependent packages
    ModelFactoryImpl theModelPackageImpl = (ModelFactoryImpl)FactoryBase.getStaticFactory(ModelFactoryImpl.NAMESPACE_URI);
    Property property = null;

    // Add supertypes to types

    // Initialize types and properties
    initializeType(oneElementAndAnyAttrType, OneElementAndAnyAttr.class, "OneElementAndAnyAttr", false);
    property = getProperty(oneElementAndAnyAttrType, OneElementAndAnyAttrImpl.INTERNAL_NAME);
    initializeProperty(property, theModelPackageImpl.getString(), "name", null, 1, 1, OneElementAndAnyAttr.class, false, true, false);

    property = getProperty(oneElementAndAnyAttrType, OneElementAndAnyAttrImpl.INTERNAL_ANY_ATTRIBUTE);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, OneElementAndAnyAttr.class, false, false, false);

    createXSDMetaData(theModelPackageImpl);
  }
    
  protected void createXSDMetaData(ModelFactoryImpl theModelPackageImpl)
  {
    super.initXSD();
    
    Property property = null;
    

    property = createGlobalProperty
      ("globAttribute",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "attribute",
       "name", "globAttribute",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                
    addXSDMapping
      (oneElementAndAnyAttrType,
       new String[] 
       {
       "name", "OneElementAndAnyAttr",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(oneElementAndAnyAttrType, OneElementAndAnyAttrImpl.INTERNAL_NAME),
       new String[]
       {
       "kind", "element",
       "name", "name"
       });

    addXSDMapping
      (getProperty(oneElementAndAnyAttrType, OneElementAndAnyAttrImpl.INTERNAL_ANY_ATTRIBUTE),
       new String[]
       {
       "kind", "attributeWildcard",
       "wildcards", "##any",
       "name", ":1",
       "processing", "lax"
       });

  }
    
} //OpenFactoryImpl
