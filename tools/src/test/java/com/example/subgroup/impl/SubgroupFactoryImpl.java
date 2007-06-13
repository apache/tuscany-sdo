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
package com.example.subgroup.impl;

import commonj.sdo.helper.HelperContext;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;

import com.example.subgroup.*;

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
 * patternVersion=1.2; -prefix Subgroup
 * <!-- end-user-doc -->
 * @generated
 */
public class SubgroupFactoryImpl extends FactoryBase implements SubgroupFactory
{

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_URI = "http://example.com/subgroup";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_PREFIX = "sg";

  /**
   * The version of the generator pattern used to generate this class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String PATTERN_VERSION = "1.2";
  
  public static final int A = 1;	
  public static final int B = 2;	
  public static final int BPRIME = 3;
  
  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubgroupFactoryImpl()
  {
    super(NAMESPACE_URI, NAMESPACE_PREFIX, "com.example.subgroup");
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
      case A: return (DataObject)createA();
      case B: return (DataObject)createB();
      case BPRIME: return (DataObject)createBprime();
      default:
        return super.create(typeNumber);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public A createA()
  {
    AImpl a = new AImpl();
    return a;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public B createB()
  {
    BImpl b = new BImpl();
    return b;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bprime createBprime()
  {
    BprimeImpl bprime = new BprimeImpl();
    return bprime;
  }
  
  // Following creates and initializes SDO metadata for the supported types.		
  protected Type aType = null;

  public Type getA()
  {
    return aType;
  }
    
  protected Type bType = null;

  public Type getB()
  {
    return bType;
  }
    
  protected Type bprimeType = null;

  public Type getBprime()
  {
    return bprimeType;
  }
    

  private static boolean isInited = false;

  public static SubgroupFactoryImpl init()
  {
    if (isInited) return (SubgroupFactoryImpl)FactoryBase.getStaticFactory(SubgroupFactoryImpl.NAMESPACE_URI);
    SubgroupFactoryImpl theSubgroupFactoryImpl = new SubgroupFactoryImpl();
    isInited = true;

    // Initialize dependencies
    SDOUtil.registerStaticTypes(SDOFactory.class);
    SDOUtil.registerStaticTypes(ModelFactory.class);
    SDOUtil.registerStaticTypes(InternalFactory.class);

    // Create package meta-data objects
    theSubgroupFactoryImpl.createMetaData();

    // Initialize created meta-data
    theSubgroupFactoryImpl.initializeMetaData();

    // Mark meta-data to indicate it can't be changed
    //theSubgroupFactoryImpl.freeze(); //FB do we need to freeze / should we freeze ????

    return theSubgroupFactoryImpl;
  }
  
  private boolean isCreated = false;

  public void createMetaData()
  {
    if (isCreated) return;
    isCreated = true;	

    // Create types and their properties
          aType = createType(false, A);
    createProperty(true, aType,AImpl.INTERNAL_GE1_GROUP); 
    createProperty(false, aType,AImpl.INTERNAL_GE1); 
          bType = createType(false, B);
    createProperty(true, bType,BImpl.INTERNAL_IM_IN_TYPE_B); 
          bprimeType = createType(false, BPRIME);
    createProperty(true, bprimeType,BprimeImpl.INTERNAL_IM_IN_TYPE_BPRIME); 
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
    addSuperType(bprimeType, this.getB());

    // Initialize types and properties
    initializeType(aType, A.class, "A", false);
    property = getLocalProperty(aType, 0);
    initializeProperty(property, getSequence(), "ge1Group", null, 1, 1, A.class, false, false, false);

    property = getLocalProperty(aType, 1);
    initializeProperty(property, this.getB(), "ge1", null, 1, 1, A.class, false, true, true, true , null);

    initializeType(bType, B.class, "B", false);
    property = getLocalProperty(bType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "imInTypeB", null, 1, 1, B.class, false, true, false);

    initializeType(bprimeType, Bprime.class, "Bprime", false);
    property = getLocalProperty(bprimeType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "imInTypeBprime", null, 1, 1, Bprime.class, false, true, false);

    createXSDMetaData(theModelPackageImpl);
  }
    
  protected void createXSDMetaData(ModelFactoryImpl theModelPackageImpl)
  {
    super.initXSD();
    
    Property property = null;
    

    addXSDMapping
      (aType,
       new String[] 
       {
       "name", "A",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(aType, AImpl.INTERNAL_GE1_GROUP),
       new String[]
       {
       "kind", "group",
       "name", "ge1:group",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(aType, AImpl.INTERNAL_GE1),
       new String[]
       {
       "kind", "element",
       "name", "ge1",
       "namespace", "##targetNamespace",
       "group", "ge1:group"
       });

    addXSDMapping
      (bType,
       new String[] 
       {
       "name", "B",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(bType, BImpl.INTERNAL_IM_IN_TYPE_B),
       new String[]
       {
       "kind", "element",
       "name", "imInTypeB",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (bprimeType,
       new String[] 
       {
       "name", "Bprime",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(bprimeType, BprimeImpl.INTERNAL_IM_IN_TYPE_BPRIME),
       new String[]
       {
       "kind", "element",
       "name", "imInTypeBprime",
       "namespace", "##targetNamespace"
       });

    property = createGlobalProperty
      ("a",
      this.getA(),
       new String[]
       {
       "kind", "element",
       "name", "a",
       "namespace", "##targetNamespace"
       });
                
    property = createGlobalProperty
      ("ge1",
      this.getB(),
       new String[]
       {
       "kind", "element",
       "name", "ge1",
       "namespace", "##targetNamespace"
       });
                
    property = createGlobalProperty
      ("se1",
      this.getBprime(),
       new String[]
       {
       "kind", "element",
       "name", "se1",
       "namespace", "##targetNamespace",
       "affiliation", "ge1"
       });
                
  }
    
} //SubgroupFactoryImpl
