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
package com.example.test.Containment.impl;

import commonj.sdo.helper.HelperContext;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;

import com.example.test.Containment.*;

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
 * patternVersion=1.2; -prefix Containment
 * <!-- end-user-doc -->
 * @generated
 */
public class ContainmentFactoryImpl extends FactoryBase implements ContainmentFactory
{

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_URI = "http://www.example.com/ContainmentTest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_PREFIX = "contain";

  /**
   * The version of the generator pattern used to generate this class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String PATTERN_VERSION = "1.2";
  
  public static final int CONTAINMENT_TEST = 1;
  
  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContainmentFactoryImpl()
  {
    super(NAMESPACE_URI, NAMESPACE_PREFIX, "com.example.test.Containment");
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
      case CONTAINMENT_TEST: return (DataObject)createContainmentTest();
      default:
        return super.create(typeNumber);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContainmentTest createContainmentTest()
  {
    ContainmentTestImpl containmentTest = new ContainmentTestImpl();
    return containmentTest;
  }
  
  // Following creates and initializes SDO metadata for the supported types.		
  protected Type containmentTestType = null;

  public Type getContainmentTest()
  {
    return containmentTestType;
  }
    

  private static boolean isInited = false;

  public static ContainmentFactoryImpl init()
  {
    if (isInited) return (ContainmentFactoryImpl)FactoryBase.getStaticFactory(ContainmentFactoryImpl.NAMESPACE_URI);
    ContainmentFactoryImpl theContainmentFactoryImpl = new ContainmentFactoryImpl();
    isInited = true;

    // Initialize dependencies
    SDOUtil.registerStaticTypes(SDOFactory.class);
    SDOUtil.registerStaticTypes(ModelFactory.class);
    SDOUtil.registerStaticTypes(InternalFactory.class);

    // Create package meta-data objects
    theContainmentFactoryImpl.createMetaData();

    // Initialize created meta-data
    theContainmentFactoryImpl.initializeMetaData();

    // Mark meta-data to indicate it can't be changed
    //theContainmentFactoryImpl.freeze(); //FB do we need to freeze / should we freeze ????

    return theContainmentFactoryImpl;
  }
  
  private boolean isCreated = false;

  public void createMetaData()
  {
    if (isCreated) return;
    isCreated = true;	

    // Create types and their properties
          containmentTestType = createType(false, CONTAINMENT_TEST);
    createProperty(true, containmentTestType,ContainmentTestImpl.INTERNAL_MIXED); 
    createProperty(true, containmentTestType,ContainmentTestImpl.INTERNAL_NAME); 
    createProperty(false, containmentTestType,ContainmentTestImpl.INTERNAL_CONTAIN); 
    createProperty(false, containmentTestType,ContainmentTestImpl.INTERNAL_CONTAIN_MANY); 
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
    initializeType(containmentTestType, ContainmentTest.class, "ContainmentTest", false);
    property = getLocalProperty(containmentTestType, 0);
    initializeProperty(property, getSequence(), "mixed", null, 0, -1, ContainmentTest.class, false, false, false);

    property = getLocalProperty(containmentTestType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "Name", null, 1, 1, ContainmentTest.class, false, true, true);

    property = getLocalProperty(containmentTestType, 2);
    initializeProperty(property, this.getContainmentTest(), "Contain", null, 1, 1, ContainmentTest.class, false, true, true, true , null);

    property = getLocalProperty(containmentTestType, 3);
    initializeProperty(property, this.getContainmentTest(), "ContainMany", null, 0, -1, ContainmentTest.class, false, false, true, true , null);

    createXSDMetaData(theModelPackageImpl);
  }
    
  protected void createXSDMetaData(ModelFactoryImpl theModelPackageImpl)
  {
    super.initXSD();
    
    Property property = null;
    

    addXSDMapping
      (containmentTestType,
       new String[] 
       {
       "name", "ContainmentTest",
       "kind", "mixed"
       });

    addXSDMapping
      (getProperty(containmentTestType, ContainmentTestImpl.INTERNAL_MIXED),
       new String[]
       {
       "kind", "elementWildcard",
       "name", ":mixed"
       });

    addXSDMapping
      (getProperty(containmentTestType, ContainmentTestImpl.INTERNAL_NAME),
       new String[]
       {
       "kind", "element",
       "name", "Name"
       });

    addXSDMapping
      (getProperty(containmentTestType, ContainmentTestImpl.INTERNAL_CONTAIN),
       new String[]
       {
       "kind", "element",
       "name", "Contain"
       });

    addXSDMapping
      (getProperty(containmentTestType, ContainmentTestImpl.INTERNAL_CONTAIN_MANY),
       new String[]
       {
       "kind", "element",
       "name", "ContainMany"
       });

    property = createGlobalProperty
      ("containTestInstance",
      this.getContainmentTest(),
       new String[]
       {
       "kind", "element",
       "name", "containTestInstance",
       "namespace", "##targetNamespace"
       });
                
  }
    
} //ContainmentFactoryImpl
