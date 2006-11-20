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

import org.apache.tuscany.sdo.SDOFactory;
import org.apache.tuscany.sdo.impl.FactoryBase;
import org.apache.tuscany.sdo.model.ModelFactory;
import org.apache.tuscany.sdo.model.impl.ModelFactoryImpl;
import org.apache.tuscany.sdo.util.SDOUtil;

import com.example.sequences.MixedQuote;
import com.example.sequences.MixedRepeatingChoice;
import com.example.sequences.RepeatingChoice;
import com.example.sequences.SequencesFactory;
import com.example.sequences.TwoRCs;
import com.example.sequences.TwoRCsMixed;
import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
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
public static final String NAMESPACE_PREFIX = "sequences";


public static final int MIXED_QUOTE = 1;
public static final int MIXED_REPEATING_CHOICE = 2;
public static final int REPEATING_CHOICE = 3;
public static final int TWO_RCS = 4;
public static final int TWO_RCS_MIXED = 5;
  
  
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequencesFactoryImpl()
  {
    super(NAMESPACE_URI, NAMESPACE_PREFIX);
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
      // TODO make sure we're supposed to ingore DOCUMENT_ROOT
      case MIXED_QUOTE: return (DataObject)createMixedQuote();
      // TODO make sure we're supposed to ingore DOCUMENT_ROOT
      case MIXED_REPEATING_CHOICE: return (DataObject)createMixedRepeatingChoice();
      // TODO make sure we're supposed to ingore DOCUMENT_ROOT
      case REPEATING_CHOICE: return (DataObject)createRepeatingChoice();
      // TODO make sure we're supposed to ingore DOCUMENT_ROOT
      case TWO_RCS: return (DataObject)createTwoRCs();
      // TODO make sure we're supposed to ingore DOCUMENT_ROOT
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
  
  // Following creates and initializes SDO metadata for the supported types.
  protected Type mixedQuoteType = null;
  
  public Type getMixedQuote()
  {
    // TODO - kdk - verify how to generate quoteType...mixedQuoteType?
    return mixedQuoteType;
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
  
  // Following creates and initializes SDO metadata for the supported types.
  protected Type mixedRepeatingChoiceType = null;
  
  public Type getMixedRepeatingChoice()
  {
    // TODO - kdk - verify how to generate quoteType...mixedRepeatingChoiceType?
    return mixedRepeatingChoiceType;
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
  
  // Following creates and initializes SDO metadata for the supported types.
  protected Type repeatingChoiceType = null;
  
  public Type getRepeatingChoice()
  {
    // TODO - kdk - verify how to generate quoteType...repeatingChoiceType?
    return repeatingChoiceType;
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
  
  // Following creates and initializes SDO metadata for the supported types.
  protected Type twoRCsType = null;
  
  public Type getTwoRCs()
  {
    // TODO - kdk - verify how to generate quoteType...twoRCsType?
    return twoRCsType;
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
  protected Type twoRCsMixedType = null;
  
  public Type getTwoRCsMixed()
  {
    // TODO - kdk - verify how to generate quoteType...twoRCsMixedType?
    return twoRCsMixedType;
    }

  private static boolean isInited = false;
  
  public static SequencesFactoryImpl init()
  {
    	if (isInited) return (SequencesFactoryImpl)FactoryBase.getStaticFactory(SequencesFactoryImpl.NAMESPACE_URI);
    	SequencesFactoryImpl theSequencesFactoryImpl = new SequencesFactoryImpl();
    	isInited = true;

    	// Initialize simple dependencies
    	SDOUtil.registerStaticTypes(SDOFactory.class);
    	SDOUtil.registerStaticTypes(ModelFactory.class);
    	
    	// Create package meta-data objects
    	theSequencesFactoryImpl.createMetaData();

    	// Initialize created meta-data
    	theSequencesFactoryImpl.initializeMetaData();

    	// Mark meta-data to indicate it can't be changed
    	//theSequencesFactoryImpl.freeze(); //FB do we need to freeze / should we freeze ????

    	return theSequencesFactoryImpl;
  }
  
  private boolean isCreated = false;

  public void createMetaData()
  {
    if (isCreated) return;
    isCreated = true;
  
  
    mixedQuoteType = createType(false, MIXED_QUOTE);
    createProperty(true, mixedQuoteType, MixedQuoteImpl.MIXED);
    createProperty(true, mixedQuoteType, MixedQuoteImpl.SYMBOL);
    createProperty(true, mixedQuoteType, MixedQuoteImpl.COMPANY_NAME);
    createProperty(true, mixedQuoteType, MixedQuoteImpl.PRICE);
    createProperty(true, mixedQuoteType, MixedQuoteImpl.OPEN1);
    createProperty(true, mixedQuoteType, MixedQuoteImpl.HIGH);
    createProperty(true, mixedQuoteType, MixedQuoteImpl.LOW);
    createProperty(true, mixedQuoteType, MixedQuoteImpl.VOLUME);
    createProperty(true, mixedQuoteType, MixedQuoteImpl.CHANGE1);
    createProperty(false, mixedQuoteType, MixedQuoteImpl.QUOTES);
  
    mixedRepeatingChoiceType = createType(false, MIXED_REPEATING_CHOICE);
    createProperty(true, mixedRepeatingChoiceType, MixedRepeatingChoiceImpl.MIXED);
    createProperty(true, mixedRepeatingChoiceType, MixedRepeatingChoiceImpl.GROUP);
    createProperty(true, mixedRepeatingChoiceType, MixedRepeatingChoiceImpl.A);
    createProperty(true, mixedRepeatingChoiceType, MixedRepeatingChoiceImpl.B);
  
    repeatingChoiceType = createType(false, REPEATING_CHOICE);
    createProperty(true, repeatingChoiceType, RepeatingChoiceImpl.GROUP);
    createProperty(true, repeatingChoiceType, RepeatingChoiceImpl.A);
    createProperty(true, repeatingChoiceType, RepeatingChoiceImpl.B);
  
    twoRCsType = createType(false, TWO_RCS);
    createProperty(true, twoRCsType, TwoRCsImpl.GROUP);
    createProperty(true, twoRCsType, TwoRCsImpl.A);
    createProperty(true, twoRCsType, TwoRCsImpl.B);
    createProperty(true, twoRCsType, TwoRCsImpl.SPLIT);
    createProperty(true, twoRCsType, TwoRCsImpl.GROUP1);
    createProperty(true, twoRCsType, TwoRCsImpl.Y);
    createProperty(true, twoRCsType, TwoRCsImpl.Z);
  
    twoRCsMixedType = createType(false, TWO_RCS_MIXED);
    createProperty(true, twoRCsMixedType, TwoRCsMixedImpl.MIXED);
    createProperty(true, twoRCsMixedType, TwoRCsMixedImpl.GROUP);
    createProperty(true, twoRCsMixedType, TwoRCsMixedImpl.A);
    createProperty(true, twoRCsMixedType, TwoRCsMixedImpl.B);
    createProperty(true, twoRCsMixedType, TwoRCsMixedImpl.SPLIT);
    createProperty(true, twoRCsMixedType, TwoRCsMixedImpl.GROUP1);
    createProperty(true, twoRCsMixedType, TwoRCsMixedImpl.Y);
    createProperty(true, twoRCsMixedType, TwoRCsMixedImpl.Z);
  }
  private boolean isInitialized = false;

  public void initializeMetaData()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Obtain other dependent packages
    ModelFactoryImpl theModelPackageImpl = (ModelFactoryImpl)FactoryBase.getStaticFactory(ModelFactoryImpl.NAMESPACE_URI);

    // Add supertypes to classes
    // Initialize classes and features; add operations and parameters
    
    initializeType(mixedQuoteType, MixedQuote.class, "MixedQuote");
    initializeProperty((Property)mixedQuoteType.getProperties().get(MixedQuoteImpl.MIXED), getSequence(), "mixed", null, 0, -1, MixedQuote.class, false, false, false);
    initializeProperty((Property)mixedQuoteType.getProperties().get(MixedQuoteImpl.SYMBOL), theModelPackageImpl.getString(), "symbol", null, 1, 1, MixedQuote.class, false, false, true);
    initializeProperty((Property)mixedQuoteType.getProperties().get(MixedQuoteImpl.COMPANY_NAME), theModelPackageImpl.getString(), "companyName", null, 1, 1, MixedQuote.class, false, false, true);
    initializeProperty((Property)mixedQuoteType.getProperties().get(MixedQuoteImpl.PRICE), theModelPackageImpl.getDecimal(), "price", null, 1, 1, MixedQuote.class, false, false, true);
    initializeProperty((Property)mixedQuoteType.getProperties().get(MixedQuoteImpl.OPEN1), theModelPackageImpl.getDecimal(), "open1", null, 1, 1, MixedQuote.class, false, false, true);
    initializeProperty((Property)mixedQuoteType.getProperties().get(MixedQuoteImpl.HIGH), theModelPackageImpl.getDecimal(), "high", null, 1, 1, MixedQuote.class, false, false, true);
    initializeProperty((Property)mixedQuoteType.getProperties().get(MixedQuoteImpl.LOW), theModelPackageImpl.getDecimal(), "low", null, 1, 1, MixedQuote.class, false, false, true);
    initializeProperty((Property)mixedQuoteType.getProperties().get(MixedQuoteImpl.VOLUME), theModelPackageImpl.getDouble(), "volume", null, 1, 1, MixedQuote.class, false, true, true);
    initializeProperty((Property)mixedQuoteType.getProperties().get(MixedQuoteImpl.CHANGE1), theModelPackageImpl.getDouble(), "change1", null, 1, 1, MixedQuote.class, false, true, true);
    initializeProperty((Property)mixedQuoteType.getProperties().get(MixedQuoteImpl.QUOTES), this.getMixedQuote(), "quotes", null, 0, -1, MixedQuote.class, false, false, true, true , null);
    
    initializeType(mixedRepeatingChoiceType, MixedRepeatingChoice.class, "MixedRepeatingChoice");
    initializeProperty((Property)mixedRepeatingChoiceType.getProperties().get(MixedRepeatingChoiceImpl.MIXED), getSequence(), "mixed", null, 0, -1, MixedRepeatingChoice.class, false, false, false);
    initializeProperty((Property)mixedRepeatingChoiceType.getProperties().get(MixedRepeatingChoiceImpl.GROUP), getSequence(), "group", null, 0, -1, MixedRepeatingChoice.class, false, false, true);
    initializeProperty((Property)mixedRepeatingChoiceType.getProperties().get(MixedRepeatingChoiceImpl.A), theModelPackageImpl.getString(), "a", null, 0, -1, MixedRepeatingChoice.class, false, false, true);
    initializeProperty((Property)mixedRepeatingChoiceType.getProperties().get(MixedRepeatingChoiceImpl.B), theModelPackageImpl.getInt(), "b", null, 0, -1, MixedRepeatingChoice.class, false, false, true);
    
    initializeType(repeatingChoiceType, RepeatingChoice.class, "RepeatingChoice");
    initializeProperty((Property)repeatingChoiceType.getProperties().get(RepeatingChoiceImpl.GROUP), getSequence(), "group", null, 0, -1, RepeatingChoice.class, false, false, false);
    initializeProperty((Property)repeatingChoiceType.getProperties().get(RepeatingChoiceImpl.A), theModelPackageImpl.getString(), "a", null, 0, -1, RepeatingChoice.class, false, false, true);
    initializeProperty((Property)repeatingChoiceType.getProperties().get(RepeatingChoiceImpl.B), theModelPackageImpl.getInt(), "b", null, 0, -1, RepeatingChoice.class, false, false, true);
    
    initializeType(twoRCsType, TwoRCs.class, "TwoRCs");
    initializeProperty((Property)twoRCsType.getProperties().get(TwoRCsImpl.GROUP), getSequence(), "group", null, 0, -1, TwoRCs.class, false, false, false);
    initializeProperty((Property)twoRCsType.getProperties().get(TwoRCsImpl.A), theModelPackageImpl.getString(), "a", null, 0, -1, TwoRCs.class, false, false, true);
    initializeProperty((Property)twoRCsType.getProperties().get(TwoRCsImpl.B), theModelPackageImpl.getInt(), "b", null, 0, -1, TwoRCs.class, false, false, true);
    initializeProperty((Property)twoRCsType.getProperties().get(TwoRCsImpl.SPLIT), theModelPackageImpl.getString(), "split", null, 1, 1, TwoRCs.class, false, false, false);
    initializeProperty((Property)twoRCsType.getProperties().get(TwoRCsImpl.GROUP1), getSequence(), "group1", null, 0, -1, TwoRCs.class, false, false, false);
    initializeProperty((Property)twoRCsType.getProperties().get(TwoRCsImpl.Y), theModelPackageImpl.getString(), "y", null, 0, -1, TwoRCs.class, false, false, true);
    initializeProperty((Property)twoRCsType.getProperties().get(TwoRCsImpl.Z), theModelPackageImpl.getInt(), "z", null, 0, -1, TwoRCs.class, false, false, true);
    
    initializeType(twoRCsMixedType, TwoRCsMixed.class, "TwoRCsMixed");
    initializeProperty((Property)twoRCsMixedType.getProperties().get(TwoRCsMixedImpl.MIXED), getSequence(), "mixed", null, 0, -1, TwoRCsMixed.class, false, false, false);
    initializeProperty((Property)twoRCsMixedType.getProperties().get(TwoRCsMixedImpl.GROUP), getSequence(), "group", null, 0, -1, TwoRCsMixed.class, false, false, true);
    initializeProperty((Property)twoRCsMixedType.getProperties().get(TwoRCsMixedImpl.A), theModelPackageImpl.getString(), "a", null, 0, -1, TwoRCsMixed.class, false, false, true);
    initializeProperty((Property)twoRCsMixedType.getProperties().get(TwoRCsMixedImpl.B), theModelPackageImpl.getInt(), "b", null, 0, -1, TwoRCsMixed.class, false, false, true);
    initializeProperty((Property)twoRCsMixedType.getProperties().get(TwoRCsMixedImpl.SPLIT), theModelPackageImpl.getString(), "split", null, 1, 1, TwoRCsMixed.class, false, false, true);
    initializeProperty((Property)twoRCsMixedType.getProperties().get(TwoRCsMixedImpl.GROUP1), getSequence(), "group1", null, 0, -1, TwoRCsMixed.class, false, false, true);
    initializeProperty((Property)twoRCsMixedType.getProperties().get(TwoRCsMixedImpl.Y), theModelPackageImpl.getString(), "y", null, 0, -1, TwoRCsMixed.class, false, false, true);
    initializeProperty((Property)twoRCsMixedType.getProperties().get(TwoRCsMixedImpl.Z), theModelPackageImpl.getInt(), "z", null, 0, -1, TwoRCsMixed.class, false, false, true);initXSD();
  }
  
  protected void initXSD()
  {
    super.initXSD();
    // TODO - kdk - is the order right?  should kind, elementOnly be first
    addXSDMapping
    (mixedQuoteType,
    new String[] 
    {
    "name", "MixedQuote",
    "kind", "elementOnly"
    });
    addXSDMapping
    ((Property)mixedQuoteType.getProperties().get(MixedQuoteImpl.MIXED),
    new String[]
    {
    "kind", "element",
    "name", "mixed"
    });
  
    addXSDMapping
    ((Property)mixedQuoteType.getProperties().get(MixedQuoteImpl.SYMBOL),
    new String[]
    {
    "kind", "element",
    "name", "symbol"
    });
  
    addXSDMapping
    ((Property)mixedQuoteType.getProperties().get(MixedQuoteImpl.COMPANY_NAME),
    new String[]
    {
    "kind", "element",
    "name", "companyName"
    });
  
    addXSDMapping
    ((Property)mixedQuoteType.getProperties().get(MixedQuoteImpl.PRICE),
    new String[]
    {
    "kind", "element",
    "name", "price"
    });
  
    addXSDMapping
    ((Property)mixedQuoteType.getProperties().get(MixedQuoteImpl.OPEN1),
    new String[]
    {
    "kind", "element",
    "name", "open1"
    });
  
    addXSDMapping
    ((Property)mixedQuoteType.getProperties().get(MixedQuoteImpl.HIGH),
    new String[]
    {
    "kind", "element",
    "name", "high"
    });
  
    addXSDMapping
    ((Property)mixedQuoteType.getProperties().get(MixedQuoteImpl.LOW),
    new String[]
    {
    "kind", "element",
    "name", "low"
    });
  
    addXSDMapping
    ((Property)mixedQuoteType.getProperties().get(MixedQuoteImpl.VOLUME),
    new String[]
    {
    "kind", "element",
    "name", "volume"
    });
  
    addXSDMapping
    ((Property)mixedQuoteType.getProperties().get(MixedQuoteImpl.CHANGE1),
    new String[]
    {
    "kind", "element",
    "name", "change1"
    });
  
    addXSDMapping
    ((Property)mixedQuoteType.getProperties().get(MixedQuoteImpl.QUOTES),
    new String[]
    {
    "kind", "element",
    "name", "quotes"
    });
  
    // TODO - kdk - is the order right?  should kind, elementOnly be first
    addXSDMapping
    (mixedRepeatingChoiceType,
    new String[] 
    {
    "name", "MixedRepeatingChoice",
    "kind", "elementOnly"
    });
    addXSDMapping
    ((Property)mixedRepeatingChoiceType.getProperties().get(MixedRepeatingChoiceImpl.MIXED),
    new String[]
    {
    "kind", "element",
    "name", "mixed"
    });
  
    addXSDMapping
    ((Property)mixedRepeatingChoiceType.getProperties().get(MixedRepeatingChoiceImpl.GROUP),
    new String[]
    {
    "kind", "element",
    "name", "group"
    });
  
    addXSDMapping
    ((Property)mixedRepeatingChoiceType.getProperties().get(MixedRepeatingChoiceImpl.A),
    new String[]
    {
    "kind", "element",
    "name", "a"
    });
  
    addXSDMapping
    ((Property)mixedRepeatingChoiceType.getProperties().get(MixedRepeatingChoiceImpl.B),
    new String[]
    {
    "kind", "element",
    "name", "b"
    });
  
    // TODO - kdk - is the order right?  should kind, elementOnly be first
    addXSDMapping
    (repeatingChoiceType,
    new String[] 
    {
    "name", "RepeatingChoice",
    "kind", "elementOnly"
    });
    addXSDMapping
    ((Property)repeatingChoiceType.getProperties().get(RepeatingChoiceImpl.GROUP),
    new String[]
    {
    "kind", "element",
    "name", "group"
    });
  
    addXSDMapping
    ((Property)repeatingChoiceType.getProperties().get(RepeatingChoiceImpl.A),
    new String[]
    {
    "kind", "element",
    "name", "a"
    });
  
    addXSDMapping
    ((Property)repeatingChoiceType.getProperties().get(RepeatingChoiceImpl.B),
    new String[]
    {
    "kind", "element",
    "name", "b"
    });
  
    // TODO - kdk - is the order right?  should kind, elementOnly be first
    addXSDMapping
    (twoRCsType,
    new String[] 
    {
    "name", "TwoRCs",
    "kind", "elementOnly"
    });
    addXSDMapping
    ((Property)twoRCsType.getProperties().get(TwoRCsImpl.GROUP),
    new String[]
    {
    "kind", "element",
    "name", "group"
    });
  
    addXSDMapping
    ((Property)twoRCsType.getProperties().get(TwoRCsImpl.A),
    new String[]
    {
    "kind", "element",
    "name", "a"
    });
  
    addXSDMapping
    ((Property)twoRCsType.getProperties().get(TwoRCsImpl.B),
    new String[]
    {
    "kind", "element",
    "name", "b"
    });
  
    addXSDMapping
    ((Property)twoRCsType.getProperties().get(TwoRCsImpl.SPLIT),
    new String[]
    {
    "kind", "element",
    "name", "split"
    });
  
    addXSDMapping
    ((Property)twoRCsType.getProperties().get(TwoRCsImpl.GROUP1),
    new String[]
    {
    "kind", "element",
    "name", "group1"
    });
  
    addXSDMapping
    ((Property)twoRCsType.getProperties().get(TwoRCsImpl.Y),
    new String[]
    {
    "kind", "element",
    "name", "y"
    });
  
    addXSDMapping
    ((Property)twoRCsType.getProperties().get(TwoRCsImpl.Z),
    new String[]
    {
    "kind", "element",
    "name", "z"
    });
  
    // TODO - kdk - is the order right?  should kind, elementOnly be first
    addXSDMapping
    (twoRCsMixedType,
    new String[] 
    {
    "name", "TwoRCsMixed",
    "kind", "elementOnly"
    });
    addXSDMapping
    ((Property)twoRCsMixedType.getProperties().get(TwoRCsMixedImpl.MIXED),
    new String[]
    {
    "kind", "element",
    "name", "mixed"
    });
  
    addXSDMapping
    ((Property)twoRCsMixedType.getProperties().get(TwoRCsMixedImpl.GROUP),
    new String[]
    {
    "kind", "element",
    "name", "group"
    });
  
    addXSDMapping
    ((Property)twoRCsMixedType.getProperties().get(TwoRCsMixedImpl.A),
    new String[]
    {
    "kind", "element",
    "name", "a"
    });
  
    addXSDMapping
    ((Property)twoRCsMixedType.getProperties().get(TwoRCsMixedImpl.B),
    new String[]
    {
    "kind", "element",
    "name", "b"
    });
  
    addXSDMapping
    ((Property)twoRCsMixedType.getProperties().get(TwoRCsMixedImpl.SPLIT),
    new String[]
    {
    "kind", "element",
    "name", "split"
    });
  
    addXSDMapping
    ((Property)twoRCsMixedType.getProperties().get(TwoRCsMixedImpl.GROUP1),
    new String[]
    {
    "kind", "element",
    "name", "group1"
    });
  
    addXSDMapping
    ((Property)twoRCsMixedType.getProperties().get(TwoRCsMixedImpl.Y),
    new String[]
    {
    "kind", "element",
    "name", "y"
    });
  
    addXSDMapping
    ((Property)twoRCsMixedType.getProperties().get(TwoRCsMixedImpl.Z),
    new String[]
    {
    "kind", "element",
    "name", "z"
    });
  

    // TODO - kdk - how do I filter out mixed, xMLNSPrefixMap, and xSISchemaLocation without hardcoding it
    // TODO - kdk - can I hardcode ##targetNamespace?
  
    createGlobalProperty
    ("mixedStockQuote", 
    this.getMixedQuote(),
    new String[] 
    {
    "kind", "element",
    "name", "mixedStockQuote",
    "namespace", "##targetNamespace"
    });  
  
    createGlobalProperty
    ("mrc", 
    this.getMixedRepeatingChoice(),
    new String[] 
    {
    "kind", "element",
    "name", "mrc",
    "namespace", "##targetNamespace"
    });  
  
    createGlobalProperty
    ("mrc2", 
    this.getTwoRCsMixed(),
    new String[] 
    {
    "kind", "element",
    "name", "mrc2",
    "namespace", "##targetNamespace"
    });  
  
    createGlobalProperty
    ("rc", 
    this.getRepeatingChoice(),
    new String[] 
    {
    "kind", "element",
    "name", "rc",
    "namespace", "##targetNamespace"
    });  
  
    createGlobalProperty
    ("rc2", 
    this.getTwoRCs(),
    new String[] 
    {
    "kind", "element",
    "name", "rc2",
    "namespace", "##targetNamespace"
    });  
  
  }

} //SequencesFactoryImpl
