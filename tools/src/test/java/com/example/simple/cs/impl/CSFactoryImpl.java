/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.example.simple.cs.impl;

import commonj.sdo.helper.HelperContext;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;

import com.example.simple.cs.*;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

import org.apache.tuscany.sdo.SDOFactory;

import org.apache.tuscany.sdo.impl.FactoryBase;

import org.apache.tuscany.sdo.model.ModelFactory;

import org.apache.tuscany.sdo.model.impl.ModelFactoryImpl;

import org.apache.tuscany.sdo.util.SDOUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * Generator information:
 * patternVersion=1.1; -prefix CS
 * <!-- end-user-doc -->
 * @generated
 */
public class CSFactoryImpl extends FactoryBase implements CSFactory
{

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_URI = "http://www.example.com/simpleCS";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_PREFIX = "simpleCS";

  /**
   * The version of the generator pattern used to generate this class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String PATTERN_VERSION = "1.1";
  
  public static final int QUOTE = 1;	
  public static final int QUOTE_BASE = 2;
  
  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CSFactoryImpl()
  {
    super(NAMESPACE_URI, NAMESPACE_PREFIX, "com.example.simple.cs");
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
      case QUOTE_BASE: return (DataObject)createQuoteBase();
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
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QuoteBase createQuoteBase()
  {
    QuoteBaseImpl quoteBase = new QuoteBaseImpl();
    return quoteBase;
  }
  
  // Following creates and initializes SDO metadata for the supported types.			
  protected Type quoteType = null;

  public Type getQuote()
  {
    return quoteType;
  }
    
  protected Type quoteBaseType = null;

  public Type getQuoteBase()
  {
    return quoteBaseType;
  }
  

  private static boolean isInited = false;

  public static CSFactoryImpl init()
  {
    if (isInited) return (CSFactoryImpl)FactoryBase.getStaticFactory(CSFactoryImpl.NAMESPACE_URI);
    CSFactoryImpl theCSFactoryImpl = new CSFactoryImpl();
    isInited = true;

    // Initialize simple dependencies
    SDOUtil.registerStaticTypes(SDOFactory.class);
    SDOUtil.registerStaticTypes(ModelFactory.class);

    // Create package meta-data objects
    theCSFactoryImpl.createMetaData();

    // Initialize created meta-data
    theCSFactoryImpl.initializeMetaData();

    // Mark meta-data to indicate it can't be changed
    //theCSFactoryImpl.freeze(); //FB do we need to freeze / should we freeze ????

    return theCSFactoryImpl;
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
          quoteBaseType = createType(false, QUOTE_BASE);
    createProperty(true, quoteBaseType,QuoteBaseImpl.INTERNAL_CHANGES); 
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
    addSuperType(quoteBaseType, quoteType);

    // Initialize types and properties
    initializeType(quoteType, Quote.class, "Quote", false);
    property = getProperty(quoteType, QuoteImpl.INTERNAL_SYMBOL);
    initializeProperty(property, theModelPackageImpl.getString(), "symbol", null, 1, 1, Quote.class, false, true, false);

    property = getProperty(quoteType, QuoteImpl.INTERNAL_COMPANY_NAME);
    initializeProperty(property, theModelPackageImpl.getString(), "companyName", null, 1, 1, Quote.class, false, true, false);

    property = getProperty(quoteType, QuoteImpl.INTERNAL_PRICE);
    initializeProperty(property, theModelPackageImpl.getDecimal(), "price", null, 1, 1, Quote.class, false, true, false);

    property = getProperty(quoteType, QuoteImpl.INTERNAL_OPEN1);
    initializeProperty(property, theModelPackageImpl.getDecimal(), "open1", null, 1, 1, Quote.class, false, true, false);

    property = getProperty(quoteType, QuoteImpl.INTERNAL_HIGH);
    initializeProperty(property, theModelPackageImpl.getDecimal(), "high", null, 1, 1, Quote.class, false, true, false);

    property = getProperty(quoteType, QuoteImpl.INTERNAL_LOW);
    initializeProperty(property, theModelPackageImpl.getDecimal(), "low", null, 1, 1, Quote.class, false, true, false);

    property = getProperty(quoteType, QuoteImpl.INTERNAL_VOLUME);
    initializeProperty(property, theModelPackageImpl.getDouble(), "volume", null, 1, 1, Quote.class, false, true, false);

    property = getProperty(quoteType, QuoteImpl.INTERNAL_CHANGE1);
    initializeProperty(property, theModelPackageImpl.getDouble(), "change1", null, 1, 1, Quote.class, false, true, false);

    property = getProperty(quoteType, QuoteImpl.INTERNAL_QUOTES);
    initializeProperty(property, this.getQuote(), "quotes", null, 0, -1, Quote.class, false, false, false, true , null);

    initializeType(quoteBaseType, QuoteBase.class, "QuoteBase", false);
    property = getProperty(quoteBaseType, QuoteBaseImpl.INTERNAL_CHANGES);
    initializeProperty(property, theModelPackageImpl.getChangeSummaryType(), "changes", null, 1, 1, QuoteBase.class, false, true, false);

    createXSDMetaData(theModelPackageImpl);
  }
    
  protected void createXSDMetaData(ModelFactoryImpl theModelPackageImpl)
  {
    super.initXSD();
    
    Property property = null;
    

    property = createGlobalProperty
      ("stockQuote",
      this.getQuoteBase(),
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

    addXSDMapping
      (quoteBaseType,
       new String[] 
       {
       "name", "QuoteBase",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(quoteBaseType, QuoteBaseImpl.INTERNAL_CHANGES),
       new String[]
       {
       "kind", "element",
       "name", "changes"
       });

  }
    
} //CSFactoryImpl
