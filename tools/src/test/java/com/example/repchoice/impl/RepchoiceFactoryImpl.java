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
package com.example.repchoice.impl;

import commonj.sdo.helper.HelperContext;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;

import com.example.repchoice.*;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.FactoryBase;

import org.apache.tuscany.sdo.model.ModelFactory;

import org.apache.tuscany.sdo.model.impl.ModelFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * Generator information:
 * patternVersion=1.2;
 * <!-- end-user-doc -->
 * @generated
 */
public class RepchoiceFactoryImpl extends FactoryBase implements RepchoiceFactory
{

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_URI = "http://www.example.com/repchoice";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_PREFIX = "repchoice";

  /**
   * The version of the generator pattern used to generate this class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String PATTERN_VERSION = "1.2";
  
  public static final int RC_TYPE = 1;
  
  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RepchoiceFactoryImpl()
  {
    super(NAMESPACE_URI, NAMESPACE_PREFIX, "com.example.repchoice");
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
      case RC_TYPE: return (DataObject)createRCType();
      default:
        return super.create(typeNumber);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RCType createRCType()
  {
    RCTypeImpl rcType = new RCTypeImpl();
    return rcType;
  }
  
  // Following creates and initializes SDO metadata for the supported types.			
  protected Type rcTypeType = null;

  public Type getRCType()
  {
    return rcTypeType;
  }
  

  private static RepchoiceFactoryImpl instance = null; 
  public static RepchoiceFactoryImpl init()
  {
    if (instance != null ) return instance;
    instance = new RepchoiceFactoryImpl();

    // Initialize dependent packages
    ModelFactory ModelFactoryInstance = ModelFactory.INSTANCE;
    
    // Create package meta-data objects
    instance.createMetaData();

    // Initialize created meta-data
    instance.initializeMetaData();
    
    // Mark meta-data to indicate it can't be changed
    //theRepchoiceFactoryImpl.freeze(); //FB do we need to freeze / should we freeze ????

    return instance;
  }
  
  private boolean isCreated = false;

  public void createMetaData()
  {
    if (isCreated) return;
    isCreated = true;	

    // Create types and their properties
    rcTypeType = createType(false, RC_TYPE);
    createProperty(true, rcTypeType,RCTypeImpl.INTERNAL_GROUP); 
    createProperty(true, rcTypeType,RCTypeImpl.INTERNAL_S); 
    createProperty(true, rcTypeType,RCTypeImpl.INTERNAL_I); 
    createProperty(true, rcTypeType,RCTypeImpl.INTERNAL_F); 
  }
  
  private boolean isInitialized = false;

  public void initializeMetaData()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Obtain other dependent packages
    ModelFactoryImpl theModelPackageImpl = (ModelFactoryImpl)ModelFactory.INSTANCE;
    Property property = null;

    // Add supertypes to types

    // Initialize types and properties
    initializeType(rcTypeType, RCType.class, "RCType", false);
    property = getLocalProperty(rcTypeType, 0);
    initializeProperty(property, getSequence(), "group", null, 0, -1, RCType.class, false, false, false);

    property = getLocalProperty(rcTypeType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "s", null, 0, -1, RCType.class, false, false, true);

    property = getLocalProperty(rcTypeType, 2);
    initializeProperty(property, theModelPackageImpl.getInt(), "i", null, 0, -1, RCType.class, false, false, true);

    property = getLocalProperty(rcTypeType, 3);
    initializeProperty(property, theModelPackageImpl.getFloat(), "f", null, 0, -1, RCType.class, false, false, true);

    createXSDMetaData(theModelPackageImpl);
  }
    
  protected void createXSDMetaData(ModelFactoryImpl theModelPackageImpl)
  {
    super.initXSD();
    
    Property property = null;
    

    property = createGlobalProperty
      ("rc",
      this.getRCType(),
       new String[]
       {
       "kind", "element",
       "name", "rc",
       "namespace", "##targetNamespace"
       });
                
    addXSDMapping
      (rcTypeType,
       new String[] 
       {
       "name", "RCType",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(rcTypeType, RCTypeImpl.INTERNAL_GROUP),
       new String[]
       {
       "kind", "group",
       "name", "group:0"
       });

    addXSDMapping
      (getProperty(rcTypeType, RCTypeImpl.INTERNAL_S),
       new String[]
       {
       "kind", "element",
       "name", "s",
       "group", "#group:0"
       });

    addXSDMapping
      (getProperty(rcTypeType, RCTypeImpl.INTERNAL_I),
       new String[]
       {
       "kind", "element",
       "name", "i",
       "group", "#group:0"
       });

    addXSDMapping
      (getProperty(rcTypeType, RCTypeImpl.INTERNAL_F),
       new String[]
       {
       "kind", "element",
       "name", "f",
       "group", "#group:0"
       });

  }
    
} //RepchoiceFactoryImpl
