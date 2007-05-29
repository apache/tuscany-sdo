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
package com.example.customer.impl;

import commonj.sdo.helper.HelperContext;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;

import com.example.customer.*;

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
 * patternVersion=1.2; -prefix Customer
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
  public static final String NAMESPACE_URI = "http://example.com/customer";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_PREFIX = "stn_1";

  /**
   * The version of the generator pattern used to generate this class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String PATTERN_VERSION = "1.2";
  
  public static final int ACCOUNT = 1;	
  public static final int CUSTOMER = 2;
  
  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CustomerFactoryImpl()
  {
    super(NAMESPACE_URI, NAMESPACE_PREFIX, "com.example.customer");
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
      case ACCOUNT: return (DataObject)createAccount();
      case CUSTOMER: return (DataObject)createCustomer();
      default:
        return super.create(typeNumber);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Account createAccount()
  {
    AccountImpl account = new AccountImpl();
    return account;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Customer createCustomer()
  {
    CustomerImpl customer = new CustomerImpl();
    return customer;
  }
  
  // Following creates and initializes SDO metadata for the supported types.		
  protected Type accountType = null;

  public Type getAccount()
  {
    return accountType;
  }
    
  protected Type customerType = null;

  public Type getCustomer()
  {
    return customerType;
  }
    

  private static boolean isInited = false;

  public static CustomerFactoryImpl init()
  {
    if (isInited) return (CustomerFactoryImpl)FactoryBase.getStaticFactory(CustomerFactoryImpl.NAMESPACE_URI);
    CustomerFactoryImpl theCustomerFactoryImpl = new CustomerFactoryImpl();
    isInited = true;

    // Initialize simple dependencies
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
          accountType = createType(false, ACCOUNT);
    createProperty(true, accountType,AccountImpl.INTERNAL_ACCOUNT_NUM); 
          customerType = createType(false, CUSTOMER);
    createProperty(false, customerType,CustomerImpl.INTERNAL_ACCOUNT); 
    createProperty(true, customerType,CustomerImpl.INTERNAL_FIRST_NAME); 
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
    initializeType(accountType, Account.class, "Account", false);
    property = getLocalProperty(accountType, 0);
    initializeProperty(property, theModelPackageImpl.getInt(), "accountNum", "0", 0, 1, Account.class, false, true, false);

    initializeType(customerType, Customer.class, "Customer", false);
    property = getLocalProperty(customerType, 0);
    initializeProperty(property, this.getAccount(), "account", null, 1, 1, Customer.class, false, true, false, true , null);

    property = getLocalProperty(customerType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "firstName", null, 0, 1, Customer.class, false, true, false);

    createXSDMetaData(theModelPackageImpl);
  }
    
  protected void createXSDMetaData(ModelFactoryImpl theModelPackageImpl)
  {
    super.initXSD();
    
    Property property = null;
    

    addXSDMapping
      (accountType,
       new String[] 
       {
       "name", "Account",
       "kind", "empty"
       });

    addXSDMapping
      (getProperty(accountType, AccountImpl.INTERNAL_ACCOUNT_NUM),
       new String[]
       {
       "kind", "attribute",
       "name", "accountNum",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (customerType,
       new String[] 
       {
       "name", "Customer",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(customerType, CustomerImpl.INTERNAL_ACCOUNT),
       new String[]
       {
       "kind", "element",
       "name", "account",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(customerType, CustomerImpl.INTERNAL_FIRST_NAME),
       new String[]
       {
       "kind", "attribute",
       "name", "firstName",
       "namespace", "##targetNamespace"
       });

    property = createGlobalProperty
      ("account",
      this.getAccount(),
       new String[]
       {
       "kind", "element",
       "name", "account",
       "namespace", "##targetNamespace"
       });
                
    property = createGlobalProperty
      ("customer",
      this.getCustomer(),
       new String[]
       {
       "kind", "element",
       "name", "customer",
       "namespace", "##targetNamespace"
       });
                
  }
    
} //CustomerFactoryImpl
