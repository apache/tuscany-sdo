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
package com.example.extensible.customer.impl;

import commonj.sdo.helper.HelperContext;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;

import com.example.extensible.customer.*;

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
 * patternVersion=1.2;
 * <!-- end-user-doc -->
 * @generated
 */
public class CustomerFactoryImpl extends FactoryBase implements CustomerFactory
{

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_URI = "http://www.example.com/extensible/customer";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_PREFIX = "customer";

  /**
   * The version of the generator pattern used to generate this class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String PATTERN_VERSION = "1.2";
  
  public static final int CUSTOMERS_TYPE = 1;	
  public static final int CUSTOMER_TYPE = 2;	
  public static final int INFO_TYPE = 3;	
  public static final int CUST_NAME_TYPE = 4;
  
  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CustomerFactoryImpl()
  {
    super(NAMESPACE_URI, NAMESPACE_PREFIX, "com.example.extensible.customer");
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
      case CUSTOMERS_TYPE: return (DataObject)createCustomersType();
      case CUSTOMER_TYPE: return (DataObject)createCustomerType();
      case INFO_TYPE: return (DataObject)createInfoType();
      default:
        return super.create(typeNumber);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object createFromString(int typeNumber, String initialValue)
  {
    switch (typeNumber)
    {
      case CUST_NAME_TYPE:
        return createCustNameTypeFromString(initialValue);
      default:
        throw new IllegalArgumentException("The type number '" + typeNumber + "' is not a valid datatype");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertToString(int typeNumber, Object instanceValue)
  {
    switch (typeNumber)
    {
      case CUST_NAME_TYPE:
        return convertCustNameTypeToString(instanceValue);
      default:
        throw new IllegalArgumentException("The type number '" + typeNumber + "' is not a valid datatype");
    }
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CustomersType createCustomersType()
  {
    CustomersTypeImpl customersType = new CustomersTypeImpl();
    return customersType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CustomerType createCustomerType()
  {
    CustomerTypeImpl customerType = new CustomerTypeImpl();
    return customerType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InfoType createInfoType()
  {
    InfoTypeImpl infoType = new InfoTypeImpl();
    return infoType;
  }
  
  // Following creates and initializes SDO metadata for the supported types.		
  protected Type customersTypeType = null;

  public Type getCustomersType()
  {
    return customersTypeType;
  }
    
  protected Type customerTypeType = null;

  public Type getCustomerType()
  {
    return customerTypeType;
  }
      
  protected Type infoTypeType = null;

  public Type getInfoType()
  {
    return infoTypeType;
  }
    
  protected Type custNameTypeType = null;

  public Type getCustNameType()
  {
    return custNameTypeType;
  }
  

  private static boolean isInited = false;

  public static CustomerFactoryImpl init()
  {
    if (isInited) return (CustomerFactoryImpl)FactoryBase.getStaticFactory(CustomerFactoryImpl.NAMESPACE_URI);
    CustomerFactoryImpl theCustomerFactoryImpl = new CustomerFactoryImpl();
    isInited = true;

    // Initialize dependencies
    SDOUtil.registerStaticTypes(SDOFactory.class);
    SDOUtil.registerStaticTypes(ModelFactory.class);
    SDOUtil.registerStaticTypes(InternalFactory.class);

    // Create package meta-data objects
    theCustomerFactoryImpl.createMetaData();

    // Initialize created meta-data
    theCustomerFactoryImpl.initializeMetaData();

    // Mark meta-data to indicate it can't be changed
    //theCustomerFactoryImpl.freeze(); //FB do we need to freeze / should we freeze ????

    return theCustomerFactoryImpl;
  }
  
  private boolean isCreated = false;

  public void createMetaData()
  {
    if (isCreated) return;
    isCreated = true;	

    // Create types and their properties
          customersTypeType = createType(false, CUSTOMERS_TYPE);
    createProperty(false, customersTypeType,CustomersTypeImpl.INTERNAL_CUSTOMER); 
          customerTypeType = createType(false, CUSTOMER_TYPE);
    createProperty(true, customerTypeType,CustomerTypeImpl.INTERNAL_NAME); 
    createProperty(true, customerTypeType,CustomerTypeImpl.INTERNAL_NUMBER); 
    createProperty(false, customerTypeType,CustomerTypeImpl.INTERNAL_INFO); 
          infoTypeType = createType(false, INFO_TYPE);

    // Create data types
    custNameTypeType = createType(true, CUST_NAME_TYPE );
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
    initializeType(customersTypeType, CustomersType.class, "CustomersType", false);
    property = getLocalProperty(customersTypeType, 0);
    initializeProperty(property, this.getCustomerType(), "customer", null, 1, -1, CustomersType.class, false, false, false, true , null);

    initializeType(customerTypeType, CustomerType.class, "CustomerType", false);
    property = getLocalProperty(customerTypeType, 0);
    initializeProperty(property, this.getCustNameType(), "name", null, 1, 1, CustomerType.class, false, true, false);

    property = getLocalProperty(customerTypeType, 1);
    initializeProperty(property, theModelPackageImpl.getInteger(), "number", null, 1, 1, CustomerType.class, false, true, false);

    property = getLocalProperty(customerTypeType, 2);
    initializeProperty(property, this.getInfoType(), "info", null, 1, 1, CustomerType.class, false, true, false, true , null);

    initializeType(infoTypeType, InfoType.class, "InfoType", false);
    // Initialize data types
    initializeType(custNameTypeType, String.class, "CustNameType", true, false);

    createXSDMetaData(theModelPackageImpl);
  }
    
  protected void createXSDMetaData(ModelFactoryImpl theModelPackageImpl)
  {
    super.initXSD();
    
    Property property = null;
    

    addXSDMapping
      (customersTypeType,
       new String[] 
       {
       "name", "CustomersType",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(customersTypeType, CustomersTypeImpl.INTERNAL_CUSTOMER),
       new String[]
       {
       "kind", "element",
       "name", "customer",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (customerTypeType,
       new String[] 
       {
       "name", "CustomerType",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(customerTypeType, CustomerTypeImpl.INTERNAL_NAME),
       new String[]
       {
       "kind", "element",
       "name", "name",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(customerTypeType, CustomerTypeImpl.INTERNAL_NUMBER),
       new String[]
       {
       "kind", "element",
       "name", "number",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(customerTypeType, CustomerTypeImpl.INTERNAL_INFO),
       new String[]
       {
       "kind", "element",
       "name", "info"
       });

    property = createGlobalProperty
      ("customer",
      this.getCustomerType(),
       new String[]
       {
       "kind", "element",
       "name", "customer",
       "namespace", "##targetNamespace"
       });
                
    property = createGlobalProperty
      ("customers",
      this.getCustomersType(),
       new String[]
       {
       "kind", "element",
       "name", "customers",
       "namespace", "##targetNamespace"
       });
                
    addXSDMapping
      (infoTypeType,
       new String[] 
       {
       "name", "InfoType",
       "kind", "empty"
       });

    addXSDMapping
      (custNameTypeType,
       new String[] 
       {
       "name", "CustNameType",
       "baseType", "commonj.sdo#String"
       });

  }
    
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createCustNameTypeFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertCustNameTypeToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

} //CustomerFactoryImpl
