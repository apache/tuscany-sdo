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
package com.example.noInterfaces.simple;

import commonj.sdo.helper.HelperContext;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.FactoryBase;

import org.apache.tuscany.sdo.model.ModelFactory;

import org.apache.tuscany.sdo.model.impl.ModelFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * patternVersion=1.2; -noInterfaces
 * @generated
 */
public class SimpleFactory extends FactoryBase
{

  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final SimpleFactory INSTANCE = com.example.noInterfaces.simple.SimpleFactory.init();

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_URI = "http://www.example.com/simple";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_PREFIX = "simple";

  /**
   * The version of the generator pattern used to generate this class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String PATTERN_VERSION = "1.2";
  
  public static final int QUOTE = 1;
  
  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleFactory()
  {
    super(NAMESPACE_URI, NAMESPACE_PREFIX, "com.example.noInterfaces.simple");
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
      case QUOTE: return (DataObject)createQuote();
      default:
        return super.create(typeNumber);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Quote createQuote()
  {
    Quote quote = new Quote();
    return quote;
  }
  
  // Following creates and initializes SDO metadata for the supported types.			
  protected Type quoteType = null;

  public Type getQuote()
  {
    return quoteType;
  }
  

  private static SimpleFactory instance = null; 
  public static SimpleFactory init()
  {
    if (instance != null ) return instance;
    instance = new SimpleFactory();

    // Initialize dependent packages
    ModelFactory ModelFactoryInstance = ModelFactory.INSTANCE;
    
    // Create package meta-data objects
    instance.createMetaData();

    // Initialize created meta-data
    instance.initializeMetaData();
    
    // Mark meta-data to indicate it can't be changed
    //theSimpleFactory.freeze(); //FB do we need to freeze / should we freeze ????

    return instance;
  }
  
  private boolean isCreated = false;

  public void createMetaData()
  {
    if (isCreated) return;
    isCreated = true;	

    // Create types and their properties
    quoteType = createType(false, QUOTE);
    createProperty(true, quoteType,Quote.INTERNAL_SYMBOL); 
    createProperty(true, quoteType,Quote.INTERNAL_COMPANY_NAME); 
    createProperty(true, quoteType,Quote.INTERNAL_PRICE); 
    createProperty(true, quoteType,Quote.INTERNAL_OPEN1); 
    createProperty(true, quoteType,Quote.INTERNAL_HIGH); 
    createProperty(true, quoteType,Quote.INTERNAL_LOW); 
    createProperty(true, quoteType,Quote.INTERNAL_VOLUME); 
    createProperty(true, quoteType,Quote.INTERNAL_CHANGE1); 
    createProperty(false, quoteType,Quote.INTERNAL_QUOTES); 
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
    initializeType(quoteType, Quote.class, "Quote", false);
    property = getLocalProperty(quoteType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "symbol", null, 1, 1, Quote.class, false, true, false);

    property = getLocalProperty(quoteType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "companyName", null, 1, 1, Quote.class, false, true, false);

    property = getLocalProperty(quoteType, 2);
    initializeProperty(property, theModelPackageImpl.getDecimal(), "price", null, 1, 1, Quote.class, false, true, false);

    property = getLocalProperty(quoteType, 3);
    initializeProperty(property, theModelPackageImpl.getDecimal(), "open1", null, 1, 1, Quote.class, false, true, false);

    property = getLocalProperty(quoteType, 4);
    initializeProperty(property, theModelPackageImpl.getDecimal(), "high", null, 1, 1, Quote.class, false, true, false);

    property = getLocalProperty(quoteType, 5);
    initializeProperty(property, theModelPackageImpl.getDecimal(), "low", null, 1, 1, Quote.class, false, true, false);

    property = getLocalProperty(quoteType, 6);
    initializeProperty(property, theModelPackageImpl.getDouble(), "volume", null, 1, 1, Quote.class, false, true, false);

    property = getLocalProperty(quoteType, 7);
    initializeProperty(property, theModelPackageImpl.getDouble(), "change1", null, 1, 1, Quote.class, false, true, false);

    property = getLocalProperty(quoteType, 8);
    initializeProperty(property, this.getQuote(), "quotes", null, 0, -1, Quote.class, false, false, false, true , null);

    createXSDMetaData(theModelPackageImpl);
  }
    
  protected void createXSDMetaData(ModelFactoryImpl theModelPackageImpl)
  {
    super.initXSD();
    
    Property property = null;
    

    property = createGlobalProperty
      ("stockQuote",
      this.getQuote(),
       new String[]
       {
       "kind", "element",
       "name", "stockQuote",
       "namespace", "##targetNamespace"
       });
                
    addXSDMapping
      (quoteType,
       new String[] 
       {
       "name", "Quote",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(quoteType, Quote.INTERNAL_SYMBOL),
       new String[]
       {
       "kind", "element",
       "name", "symbol"
       });

    addXSDMapping
      (getProperty(quoteType, Quote.INTERNAL_COMPANY_NAME),
       new String[]
       {
       "kind", "element",
       "name", "companyName"
       });

    addXSDMapping
      (getProperty(quoteType, Quote.INTERNAL_PRICE),
       new String[]
       {
       "kind", "element",
       "name", "price"
       });

    addXSDMapping
      (getProperty(quoteType, Quote.INTERNAL_OPEN1),
       new String[]
       {
       "kind", "element",
       "name", "open1"
       });

    addXSDMapping
      (getProperty(quoteType, Quote.INTERNAL_HIGH),
       new String[]
       {
       "kind", "element",
       "name", "high"
       });

    addXSDMapping
      (getProperty(quoteType, Quote.INTERNAL_LOW),
       new String[]
       {
       "kind", "element",
       "name", "low"
       });

    addXSDMapping
      (getProperty(quoteType, Quote.INTERNAL_VOLUME),
       new String[]
       {
       "kind", "element",
       "name", "volume"
       });

    addXSDMapping
      (getProperty(quoteType, Quote.INTERNAL_CHANGE1),
       new String[]
       {
       "kind", "element",
       "name", "change1"
       });

    addXSDMapping
      (getProperty(quoteType, Quote.INTERNAL_QUOTES),
       new String[]
       {
       "kind", "element",
       "name", "quotes"
       });

  }
    
} //SimpleFactory
