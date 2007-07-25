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
package com.example.sequences.impl;

import commonj.sdo.helper.HelperContext;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;

import com.example.sequences.*;

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
 * patternVersion=1.2; -prefix Sequences
 * <!-- end-user-doc -->
 * @generated
 */
public class SequencesFactoryImpl extends FactoryBase implements SequencesFactory
{

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_URI = "http://www.example.com/sequences";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_PREFIX = "seq";

  /**
   * The version of the generator pattern used to generate this class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String PATTERN_VERSION = "1.2";
  
  public static final int MIXED_QUOTE = 1;	
  public static final int MIXED_REPEATING_CHOICE = 2;	
  public static final int REPEATING_CHOICE = 3;	
  public static final int TWO_RCS = 4;	
  public static final int TWO_RCS_MIXED = 5;
  
  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequencesFactoryImpl()
  {
    super(NAMESPACE_URI, NAMESPACE_PREFIX, "com.example.sequences");
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
      case MIXED_QUOTE: return (DataObject)createMixedQuote();
      case MIXED_REPEATING_CHOICE: return (DataObject)createMixedRepeatingChoice();
      case REPEATING_CHOICE: return (DataObject)createRepeatingChoice();
      case TWO_RCS: return (DataObject)createTwoRCs();
      case TWO_RCS_MIXED: return (DataObject)createTwoRCsMixed();
      default:
        return super.create(typeNumber);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MixedQuote createMixedQuote()
  {
    MixedQuoteImpl mixedQuote = new MixedQuoteImpl();
    return mixedQuote;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MixedRepeatingChoice createMixedRepeatingChoice()
  {
    MixedRepeatingChoiceImpl mixedRepeatingChoice = new MixedRepeatingChoiceImpl();
    return mixedRepeatingChoice;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RepeatingChoice createRepeatingChoice()
  {
    RepeatingChoiceImpl repeatingChoice = new RepeatingChoiceImpl();
    return repeatingChoice;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TwoRCs createTwoRCs()
  {
    TwoRCsImpl twoRCs = new TwoRCsImpl();
    return twoRCs;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TwoRCsMixed createTwoRCsMixed()
  {
    TwoRCsMixedImpl twoRCsMixed = new TwoRCsMixedImpl();
    return twoRCsMixed;
  }
  
  // Following creates and initializes SDO metadata for the supported types.			
  protected Type mixedQuoteType = null;

  public Type getMixedQuote()
  {
    return mixedQuoteType;
  }
    
  protected Type mixedRepeatingChoiceType = null;

  public Type getMixedRepeatingChoice()
  {
    return mixedRepeatingChoiceType;
  }
    
  protected Type repeatingChoiceType = null;

  public Type getRepeatingChoice()
  {
    return repeatingChoiceType;
  }
    
  protected Type twoRCsType = null;

  public Type getTwoRCs()
  {
    return twoRCsType;
  }
    
  protected Type twoRCsMixedType = null;

  public Type getTwoRCsMixed()
  {
    return twoRCsMixedType;
  }
  

  private static SequencesFactoryImpl instance = null; 
  public static SequencesFactoryImpl init()
  {
    if (instance != null ) return instance;
    instance = new SequencesFactoryImpl();

    // Initialize dependent packages
    ModelFactory ModelFactoryInstance = ModelFactory.INSTANCE;
    
    // Create package meta-data objects
    instance.createMetaData();

    // Initialize created meta-data
    instance.initializeMetaData();
    
    // Mark meta-data to indicate it can't be changed
    //theSequencesFactoryImpl.freeze(); //FB do we need to freeze / should we freeze ????

    return instance;
  }
  
  private boolean isCreated = false;

  public void createMetaData()
  {
    if (isCreated) return;
    isCreated = true;	

    // Create types and their properties
    mixedQuoteType = createType(false, MIXED_QUOTE);
    createProperty(true, mixedQuoteType,MixedQuoteImpl.INTERNAL_MIXED); 
    createProperty(true, mixedQuoteType,MixedQuoteImpl.INTERNAL_SYMBOL); 
    createProperty(true, mixedQuoteType,MixedQuoteImpl.INTERNAL_COMPANY_NAME); 
    createProperty(true, mixedQuoteType,MixedQuoteImpl.INTERNAL_PRICE); 
    createProperty(true, mixedQuoteType,MixedQuoteImpl.INTERNAL_OPEN1); 
    createProperty(true, mixedQuoteType,MixedQuoteImpl.INTERNAL_HIGH); 
    createProperty(true, mixedQuoteType,MixedQuoteImpl.INTERNAL_LOW); 
    createProperty(true, mixedQuoteType,MixedQuoteImpl.INTERNAL_VOLUME); 
    createProperty(true, mixedQuoteType,MixedQuoteImpl.INTERNAL_CHANGE1); 
    createProperty(false, mixedQuoteType,MixedQuoteImpl.INTERNAL_QUOTES); 
    mixedRepeatingChoiceType = createType(false, MIXED_REPEATING_CHOICE);
    createProperty(true, mixedRepeatingChoiceType,MixedRepeatingChoiceImpl.INTERNAL_MIXED); 
    createProperty(true, mixedRepeatingChoiceType,MixedRepeatingChoiceImpl.INTERNAL_GROUP); 
    createProperty(true, mixedRepeatingChoiceType,MixedRepeatingChoiceImpl.INTERNAL_A); 
    createProperty(true, mixedRepeatingChoiceType,MixedRepeatingChoiceImpl.INTERNAL_B); 
    repeatingChoiceType = createType(false, REPEATING_CHOICE);
    createProperty(true, repeatingChoiceType,RepeatingChoiceImpl.INTERNAL_GROUP); 
    createProperty(true, repeatingChoiceType,RepeatingChoiceImpl.INTERNAL_A); 
    createProperty(true, repeatingChoiceType,RepeatingChoiceImpl.INTERNAL_B); 
    twoRCsType = createType(false, TWO_RCS);
    createProperty(true, twoRCsType,TwoRCsImpl.INTERNAL_GROUP); 
    createProperty(true, twoRCsType,TwoRCsImpl.INTERNAL_A); 
    createProperty(true, twoRCsType,TwoRCsImpl.INTERNAL_B); 
    createProperty(true, twoRCsType,TwoRCsImpl.INTERNAL_SPLIT); 
    createProperty(true, twoRCsType,TwoRCsImpl.INTERNAL_GROUP1); 
    createProperty(true, twoRCsType,TwoRCsImpl.INTERNAL_Y); 
    createProperty(true, twoRCsType,TwoRCsImpl.INTERNAL_Z); 
    twoRCsMixedType = createType(false, TWO_RCS_MIXED);
    createProperty(true, twoRCsMixedType,TwoRCsMixedImpl.INTERNAL_MIXED); 
    createProperty(true, twoRCsMixedType,TwoRCsMixedImpl.INTERNAL_GROUP); 
    createProperty(true, twoRCsMixedType,TwoRCsMixedImpl.INTERNAL_A); 
    createProperty(true, twoRCsMixedType,TwoRCsMixedImpl.INTERNAL_B); 
    createProperty(true, twoRCsMixedType,TwoRCsMixedImpl.INTERNAL_SPLIT); 
    createProperty(true, twoRCsMixedType,TwoRCsMixedImpl.INTERNAL_GROUP1); 
    createProperty(true, twoRCsMixedType,TwoRCsMixedImpl.INTERNAL_Y); 
    createProperty(true, twoRCsMixedType,TwoRCsMixedImpl.INTERNAL_Z); 
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
    initializeType(mixedQuoteType, MixedQuote.class, "MixedQuote", false);
    property = getLocalProperty(mixedQuoteType, 0);
    initializeProperty(property, getSequence(), "mixed", null, 0, -1, MixedQuote.class, false, false, false);

    property = getLocalProperty(mixedQuoteType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "symbol", null, 1, 1, MixedQuote.class, false, true, true);

    property = getLocalProperty(mixedQuoteType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "companyName", null, 1, 1, MixedQuote.class, false, true, true);

    property = getLocalProperty(mixedQuoteType, 3);
    initializeProperty(property, theModelPackageImpl.getDecimal(), "price", null, 1, 1, MixedQuote.class, false, true, true);

    property = getLocalProperty(mixedQuoteType, 4);
    initializeProperty(property, theModelPackageImpl.getDecimal(), "open1", null, 1, 1, MixedQuote.class, false, true, true);

    property = getLocalProperty(mixedQuoteType, 5);
    initializeProperty(property, theModelPackageImpl.getDecimal(), "high", null, 1, 1, MixedQuote.class, false, true, true);

    property = getLocalProperty(mixedQuoteType, 6);
    initializeProperty(property, theModelPackageImpl.getDecimal(), "low", null, 1, 1, MixedQuote.class, false, true, true);

    property = getLocalProperty(mixedQuoteType, 7);
    initializeProperty(property, theModelPackageImpl.getDouble(), "volume", null, 1, 1, MixedQuote.class, false, true, true);

    property = getLocalProperty(mixedQuoteType, 8);
    initializeProperty(property, theModelPackageImpl.getDouble(), "change1", null, 1, 1, MixedQuote.class, false, true, true);

    property = getLocalProperty(mixedQuoteType, 9);
    initializeProperty(property, this.getMixedQuote(), "quotes", null, 0, -1, MixedQuote.class, false, false, true, true , null);

    initializeType(mixedRepeatingChoiceType, MixedRepeatingChoice.class, "MixedRepeatingChoice", false);
    property = getLocalProperty(mixedRepeatingChoiceType, 0);
    initializeProperty(property, getSequence(), "mixed", null, 0, -1, MixedRepeatingChoice.class, false, false, false);

    property = getLocalProperty(mixedRepeatingChoiceType, 1);
    initializeProperty(property, getSequence(), "group", null, 0, -1, MixedRepeatingChoice.class, false, false, true);

    property = getLocalProperty(mixedRepeatingChoiceType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "a", null, 0, -1, MixedRepeatingChoice.class, false, false, true);

    property = getLocalProperty(mixedRepeatingChoiceType, 3);
    initializeProperty(property, theModelPackageImpl.getInt(), "b", null, 0, -1, MixedRepeatingChoice.class, false, false, true);

    initializeType(repeatingChoiceType, RepeatingChoice.class, "RepeatingChoice", false);
    property = getLocalProperty(repeatingChoiceType, 0);
    initializeProperty(property, getSequence(), "group", null, 0, -1, RepeatingChoice.class, false, false, false);

    property = getLocalProperty(repeatingChoiceType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "a", null, 0, -1, RepeatingChoice.class, false, false, true);

    property = getLocalProperty(repeatingChoiceType, 2);
    initializeProperty(property, theModelPackageImpl.getInt(), "b", null, 0, -1, RepeatingChoice.class, false, false, true);

    initializeType(twoRCsType, TwoRCs.class, "TwoRCs", false);
    property = getLocalProperty(twoRCsType, 0);
    initializeProperty(property, getSequence(), "group", null, 0, -1, TwoRCs.class, false, false, false);

    property = getLocalProperty(twoRCsType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "a", null, 0, -1, TwoRCs.class, false, false, true);

    property = getLocalProperty(twoRCsType, 2);
    initializeProperty(property, theModelPackageImpl.getInt(), "b", null, 0, -1, TwoRCs.class, false, false, true);

    property = getLocalProperty(twoRCsType, 3);
    initializeProperty(property, theModelPackageImpl.getString(), "split", null, 1, 1, TwoRCs.class, false, true, false);

    property = getLocalProperty(twoRCsType, 4);
    initializeProperty(property, getSequence(), "group1", null, 0, -1, TwoRCs.class, false, false, false);

    property = getLocalProperty(twoRCsType, 5);
    initializeProperty(property, theModelPackageImpl.getString(), "y", null, 0, -1, TwoRCs.class, false, false, true);

    property = getLocalProperty(twoRCsType, 6);
    initializeProperty(property, theModelPackageImpl.getInt(), "z", null, 0, -1, TwoRCs.class, false, false, true);

    initializeType(twoRCsMixedType, TwoRCsMixed.class, "TwoRCsMixed", false);
    property = getLocalProperty(twoRCsMixedType, 0);
    initializeProperty(property, getSequence(), "mixed", null, 0, -1, TwoRCsMixed.class, false, false, false);

    property = getLocalProperty(twoRCsMixedType, 1);
    initializeProperty(property, getSequence(), "group", null, 0, -1, TwoRCsMixed.class, false, false, true);

    property = getLocalProperty(twoRCsMixedType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "a", null, 0, -1, TwoRCsMixed.class, false, false, true);

    property = getLocalProperty(twoRCsMixedType, 3);
    initializeProperty(property, theModelPackageImpl.getInt(), "b", null, 0, -1, TwoRCsMixed.class, false, false, true);

    property = getLocalProperty(twoRCsMixedType, 4);
    initializeProperty(property, theModelPackageImpl.getString(), "split", null, 1, 1, TwoRCsMixed.class, false, true, true);

    property = getLocalProperty(twoRCsMixedType, 5);
    initializeProperty(property, getSequence(), "group1", null, 0, -1, TwoRCsMixed.class, false, false, true);

    property = getLocalProperty(twoRCsMixedType, 6);
    initializeProperty(property, theModelPackageImpl.getString(), "y", null, 0, -1, TwoRCsMixed.class, false, false, true);

    property = getLocalProperty(twoRCsMixedType, 7);
    initializeProperty(property, theModelPackageImpl.getInt(), "z", null, 0, -1, TwoRCsMixed.class, false, false, true);

    createXSDMetaData(theModelPackageImpl);
  }
    
  protected void createXSDMetaData(ModelFactoryImpl theModelPackageImpl)
  {
    super.initXSD();
    
    Property property = null;
    

    property = createGlobalProperty
      ("mixedStockQuote",
      this.getMixedQuote(),
       new String[]
       {
       "kind", "element",
       "name", "mixedStockQuote",
       "namespace", "##targetNamespace"
       });
                
    property = createGlobalProperty
      ("mrc",
      this.getMixedRepeatingChoice(),
       new String[]
       {
       "kind", "element",
       "name", "mrc",
       "namespace", "##targetNamespace"
       });
                
    property = createGlobalProperty
      ("mrc2",
      this.getTwoRCsMixed(),
       new String[]
       {
       "kind", "element",
       "name", "mrc2",
       "namespace", "##targetNamespace"
       });
                
    property = createGlobalProperty
      ("rc",
      this.getRepeatingChoice(),
       new String[]
       {
       "kind", "element",
       "name", "rc",
       "namespace", "##targetNamespace"
       });
                
    property = createGlobalProperty
      ("rc2",
      this.getTwoRCs(),
       new String[]
       {
       "kind", "element",
       "name", "rc2",
       "namespace", "##targetNamespace"
       });
                
    addXSDMapping
      (mixedQuoteType,
       new String[] 
       {
       "name", "MixedQuote",
       "kind", "mixed"
       });

    addXSDMapping
      (getProperty(mixedQuoteType, MixedQuoteImpl.INTERNAL_MIXED),
       new String[]
       {
       "kind", "elementWildcard",
       "name", ":mixed"
       });

    addXSDMapping
      (getProperty(mixedQuoteType, MixedQuoteImpl.INTERNAL_SYMBOL),
       new String[]
       {
       "kind", "element",
       "name", "symbol"
       });

    addXSDMapping
      (getProperty(mixedQuoteType, MixedQuoteImpl.INTERNAL_COMPANY_NAME),
       new String[]
       {
       "kind", "element",
       "name", "companyName"
       });

    addXSDMapping
      (getProperty(mixedQuoteType, MixedQuoteImpl.INTERNAL_PRICE),
       new String[]
       {
       "kind", "element",
       "name", "price"
       });

    addXSDMapping
      (getProperty(mixedQuoteType, MixedQuoteImpl.INTERNAL_OPEN1),
       new String[]
       {
       "kind", "element",
       "name", "open1"
       });

    addXSDMapping
      (getProperty(mixedQuoteType, MixedQuoteImpl.INTERNAL_HIGH),
       new String[]
       {
       "kind", "element",
       "name", "high"
       });

    addXSDMapping
      (getProperty(mixedQuoteType, MixedQuoteImpl.INTERNAL_LOW),
       new String[]
       {
       "kind", "element",
       "name", "low"
       });

    addXSDMapping
      (getProperty(mixedQuoteType, MixedQuoteImpl.INTERNAL_VOLUME),
       new String[]
       {
       "kind", "element",
       "name", "volume"
       });

    addXSDMapping
      (getProperty(mixedQuoteType, MixedQuoteImpl.INTERNAL_CHANGE1),
       new String[]
       {
       "kind", "element",
       "name", "change1"
       });

    addXSDMapping
      (getProperty(mixedQuoteType, MixedQuoteImpl.INTERNAL_QUOTES),
       new String[]
       {
       "kind", "element",
       "name", "quotes"
       });

    addXSDMapping
      (mixedRepeatingChoiceType,
       new String[] 
       {
       "name", "MixedRepeatingChoice",
       "kind", "mixed"
       });

    addXSDMapping
      (getProperty(mixedRepeatingChoiceType, MixedRepeatingChoiceImpl.INTERNAL_MIXED),
       new String[]
       {
       "kind", "elementWildcard",
       "name", ":mixed"
       });

    addXSDMapping
      (getProperty(mixedRepeatingChoiceType, MixedRepeatingChoiceImpl.INTERNAL_GROUP),
       new String[]
       {
       "kind", "group",
       "name", "group:1"
       });

    addXSDMapping
      (getProperty(mixedRepeatingChoiceType, MixedRepeatingChoiceImpl.INTERNAL_A),
       new String[]
       {
       "kind", "element",
       "name", "a",
       "group", "#group:1"
       });

    addXSDMapping
      (getProperty(mixedRepeatingChoiceType, MixedRepeatingChoiceImpl.INTERNAL_B),
       new String[]
       {
       "kind", "element",
       "name", "b",
       "group", "#group:1"
       });

    addXSDMapping
      (repeatingChoiceType,
       new String[] 
       {
       "name", "RepeatingChoice",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(repeatingChoiceType, RepeatingChoiceImpl.INTERNAL_GROUP),
       new String[]
       {
       "kind", "group",
       "name", "group:0"
       });

    addXSDMapping
      (getProperty(repeatingChoiceType, RepeatingChoiceImpl.INTERNAL_A),
       new String[]
       {
       "kind", "element",
       "name", "a",
       "group", "#group:0"
       });

    addXSDMapping
      (getProperty(repeatingChoiceType, RepeatingChoiceImpl.INTERNAL_B),
       new String[]
       {
       "kind", "element",
       "name", "b",
       "group", "#group:0"
       });

    addXSDMapping
      (twoRCsType,
       new String[] 
       {
       "name", "TwoRCs",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(twoRCsType, TwoRCsImpl.INTERNAL_GROUP),
       new String[]
       {
       "kind", "group",
       "name", "group:0"
       });

    addXSDMapping
      (getProperty(twoRCsType, TwoRCsImpl.INTERNAL_A),
       new String[]
       {
       "kind", "element",
       "name", "a",
       "group", "#group:0"
       });

    addXSDMapping
      (getProperty(twoRCsType, TwoRCsImpl.INTERNAL_B),
       new String[]
       {
       "kind", "element",
       "name", "b",
       "group", "#group:0"
       });

    addXSDMapping
      (getProperty(twoRCsType, TwoRCsImpl.INTERNAL_SPLIT),
       new String[]
       {
       "kind", "element",
       "name", "split"
       });

    addXSDMapping
      (getProperty(twoRCsType, TwoRCsImpl.INTERNAL_GROUP1),
       new String[]
       {
       "kind", "group",
       "name", "group:4"
       });

    addXSDMapping
      (getProperty(twoRCsType, TwoRCsImpl.INTERNAL_Y),
       new String[]
       {
       "kind", "element",
       "name", "y",
       "group", "#group:4"
       });

    addXSDMapping
      (getProperty(twoRCsType, TwoRCsImpl.INTERNAL_Z),
       new String[]
       {
       "kind", "element",
       "name", "z",
       "group", "#group:4"
       });

    addXSDMapping
      (twoRCsMixedType,
       new String[] 
       {
       "name", "TwoRCsMixed",
       "kind", "mixed"
       });

    addXSDMapping
      (getProperty(twoRCsMixedType, TwoRCsMixedImpl.INTERNAL_MIXED),
       new String[]
       {
       "kind", "elementWildcard",
       "name", ":mixed"
       });

    addXSDMapping
      (getProperty(twoRCsMixedType, TwoRCsMixedImpl.INTERNAL_GROUP),
       new String[]
       {
       "kind", "group",
       "name", "group:1"
       });

    addXSDMapping
      (getProperty(twoRCsMixedType, TwoRCsMixedImpl.INTERNAL_A),
       new String[]
       {
       "kind", "element",
       "name", "a",
       "group", "#group:1"
       });

    addXSDMapping
      (getProperty(twoRCsMixedType, TwoRCsMixedImpl.INTERNAL_B),
       new String[]
       {
       "kind", "element",
       "name", "b",
       "group", "#group:1"
       });

    addXSDMapping
      (getProperty(twoRCsMixedType, TwoRCsMixedImpl.INTERNAL_SPLIT),
       new String[]
       {
       "kind", "element",
       "name", "split"
       });

    addXSDMapping
      (getProperty(twoRCsMixedType, TwoRCsMixedImpl.INTERNAL_GROUP1),
       new String[]
       {
       "kind", "group",
       "name", "group:5"
       });

    addXSDMapping
      (getProperty(twoRCsMixedType, TwoRCsMixedImpl.INTERNAL_Y),
       new String[]
       {
       "kind", "element",
       "name", "y",
       "group", "#group:5"
       });

    addXSDMapping
      (getProperty(twoRCsMixedType, TwoRCsMixedImpl.INTERNAL_Z),
       new String[]
       {
       "kind", "element",
       "name", "z",
       "group", "#group:5"
       });

  }
    
} //SequencesFactoryImpl
