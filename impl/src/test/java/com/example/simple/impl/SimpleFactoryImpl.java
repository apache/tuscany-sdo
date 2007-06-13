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
package com.example.simple.impl;

import commonj.sdo.helper.HelperContext;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;

import com.example.simple.*;

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
public class SimpleFactoryImpl extends FactoryBase implements SimpleFactory
{

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
  public SimpleFactoryImpl()
  {
    super(NAMESPACE_URI, NAMESPACE_PREFIX, "com.example.simple");
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
    QuoteImpl quote = new QuoteImpl();
    return quote;
  }
  
  // Following creates and initializes SDO metadata for the supported types.			
  protected Type quoteType = null;

  public Type getQuote()
  {
    return quoteType;
  }
  

  private static boolean isInited = false;

  public static SimpleFactoryImpl init()
  {
    if (isInited) return (SimpleFactoryImpl)FactoryBase.getStaticFactory(SimpleFactoryImpl.NAMESPACE_URI);
    SimpleFactoryImpl theSimpleFactoryImpl = new SimpleFactoryImpl();
    isInited = true;

    // Initialize dependencies
    SDOUtil.registerStaticTypes(SDOFactory.class);
    SDOUtil.registerStaticTypes(ModelFactory.class);
    SDOUtil.registerStaticTypes(InternalFactory.class);

    // Create package meta-data objects
    theSimpleFactoryImpl.createMetaData();

    // Initialize created meta-data
    theSimpleFactoryImpl.initializeMetaData();

    // Mark meta-data to indicate it can't be changed
    //theSimpleFactoryImpl.freeze(); //FB do we need to freeze / should we freeze ????

    return theSimpleFactoryImpl;
  }
  
  private boolean isCreated = false;

  public void createMetaData()
  {
    if (isCreated) return;
    isCreated = true;	

    // Create types and their properties
          quoteType = createType(false, QUOTE);
    createProperty(true, quoteType,QuoteImpl.INTERNAL_SYMBOL); 
    createProperty(true, quoteType,QuoteImpl.INTERNAL_COMPANY_NAME); 
    createProperty(true, quoteType,QuoteImpl.INTERNAL_PRICE); 
    createProperty(true, quoteType,QuoteImpl.INTERNAL_OPEN1); 
    createProperty(true, quoteType,QuoteImpl.INTERNAL_HIGH); 
    createProperty(true, quoteType,QuoteImpl.INTERNAL_LOW); 
    createProperty(true, quoteType,QuoteImpl.INTERNAL_VOLUME); 
    createProperty(true, quoteType,QuoteImpl.INTERNAL_CHANGE1); 
    createProperty(false, quoteType,QuoteImpl.INTERNAL_QUOTES); 
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
      (getProperty(quoteType, QuoteImpl.INTERNAL_SYMBOL),
       new String[]
       {
       "kind", "element",
       "name", "symbol"
       });

    addXSDMapping
      (getProperty(quoteType, QuoteImpl.INTERNAL_COMPANY_NAME),
       new String[]
       {
       "kind", "element",
       "name", "companyName"
       });

    addXSDMapping
      (getProperty(quoteType, QuoteImpl.INTERNAL_PRICE),
       new String[]
       {
       "kind", "element",
       "name", "price"
       });

    addXSDMapping
      (getProperty(quoteType, QuoteImpl.INTERNAL_OPEN1),
       new String[]
       {
       "kind", "element",
       "name", "open1"
       });

    addXSDMapping
      (getProperty(quoteType, QuoteImpl.INTERNAL_HIGH),
       new String[]
       {
       "kind", "element",
       "name", "high"
       });

    addXSDMapping
      (getProperty(quoteType, QuoteImpl.INTERNAL_LOW),
       new String[]
       {
       "kind", "element",
       "name", "low"
       });

    addXSDMapping
      (getProperty(quoteType, QuoteImpl.INTERNAL_VOLUME),
       new String[]
       {
       "kind", "element",
       "name", "volume"
       });

    addXSDMapping
      (getProperty(quoteType, QuoteImpl.INTERNAL_CHANGE1),
       new String[]
       {
       "kind", "element",
       "name", "change1"
       });

    addXSDMapping
      (getProperty(quoteType, QuoteImpl.INTERNAL_QUOTES),
       new String[]
       {
       "kind", "element",
       "name", "quotes"
       });

  }
    
} //SimpleFactoryImpl
