/**
 *
 *  Copyright 2005 The Apache Software Foundation or its licensors, as applicable.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.example.simple.impl;

import com.example.simple.Quote;
import com.example.simple.SimpleFactory;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.example.simple.SimpleFactory
 * @generated
 */
public class SimplePackageImpl extends EPackageImpl
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String eNAME = "simple";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String eNS_URI = "http://www.example.com/simple";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String eNS_PREFIX = "simple";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final SimplePackageImpl eINSTANCE = com.example.simple.impl.SimplePackageImpl.init();

  /**
   * The meta object id for the '{@link com.example.simple.impl.DocumentRootImpl <em>Document Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.example.simple.impl.DocumentRootImpl
   * @see com.example.simple.impl.SimplePackageImpl#getDocumentRoot()
   * @generated
   */
  public static final int DOCUMENT_ROOT = 0;

  /**
   * The feature id for the '<em><b>Mixed</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DOCUMENT_ROOT__MIXED = 0;

  /**
   * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

  /**
   * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

  /**
   * The feature id for the '<em><b>Stock Quote</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DOCUMENT_ROOT__STOCK_QUOTE = 3;

  /**
   * The number of structural features of the '<em>Document Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DOCUMENT_ROOT_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link com.example.simple.impl.QuoteImpl <em>Quote</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.example.simple.impl.QuoteImpl
   * @see com.example.simple.impl.SimplePackageImpl#getQuote()
   * @generated
   */
  public static final int QUOTE = 1;

  /**
   * The feature id for the '<em><b>Symbol</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int QUOTE__SYMBOL = 0;

  /**
   * The feature id for the '<em><b>Company Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int QUOTE__COMPANY_NAME = 1;

  /**
   * The feature id for the '<em><b>Price</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int QUOTE__PRICE = 2;

  /**
   * The feature id for the '<em><b>Open1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int QUOTE__OPEN1 = 3;

  /**
   * The feature id for the '<em><b>High</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int QUOTE__HIGH = 4;

  /**
   * The feature id for the '<em><b>Low</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int QUOTE__LOW = 5;

  /**
   * The feature id for the '<em><b>Volume</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int QUOTE__VOLUME = 6;

  /**
   * The feature id for the '<em><b>Change1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int QUOTE__CHANGE1 = 7;

  /**
   * The feature id for the '<em><b>Quotes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int QUOTE__QUOTES = 8;

  /**
   * The number of structural features of the '<em>Quote</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int QUOTE_FEATURE_COUNT = 9;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass documentRootEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass quoteEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see com.example.simple.impl.SimplePackageImpl#eNS_URI
   * @see #init()
   * @generated
   */
  private SimplePackageImpl()
  {
    super(eNS_URI, ((EFactory)SimpleFactory.INSTANCE));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this
   * model, and for any others upon which it depends.  Simple
   * dependencies are satisfied by calling this method on all
   * dependent packages before doing anything else.  This method drives
   * initialization for interdependent packages directly, in parallel
   * with this package, itself.
   * <p>Of this package and its interdependencies, all packages which
   * have not yet been registered by their URI values are first created
   * and registered.  The packages are then initialized in two steps:
   * meta-model objects for all of the packages are created before any
   * are initialized, since one package's meta-model objects may refer to
   * those of another.
   * <p>Invocation of this method will not affect any packages that have
   * already been initialized.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static SimplePackageImpl init()
  {
    if (isInited) return (SimplePackageImpl)EPackage.Registry.INSTANCE.getEPackage(SimplePackageImpl.eNS_URI);

    // Obtain or create and register package
    SimplePackageImpl theSimplePackageImpl = (SimplePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof SimplePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new SimplePackageImpl());

    isInited = true;

    // Initialize simple dependencies
    XMLTypePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theSimplePackageImpl.createPackageContents();

    // Initialize created meta-data
    theSimplePackageImpl.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theSimplePackageImpl.freeze();

    return theSimplePackageImpl;
  }


  /**
   * Returns the meta object for class '{@link org.eclipse.emf.ecore.EObject <em>Document Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Document Root</em>'.
   * @see org.eclipse.emf.ecore.EObject
   * @generated
   */
  public EClass getDocumentRoot()
  {
    return documentRootEClass;
  }

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.emf.ecore.EObject#getMixed <em>Mixed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Mixed</em>'.
   * @see org.eclipse.emf.ecore.EObject#getMixed()
   * @see #getDocumentRoot()
   * @generated
   */
  public EAttribute getDocumentRoot_Mixed()
  {
    return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for the map '{@link org.eclipse.emf.ecore.EObject#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
   * @see org.eclipse.emf.ecore.EObject#getXMLNSPrefixMap()
   * @see #getDocumentRoot()
   * @generated
   */
  public EReference getDocumentRoot_XMLNSPrefixMap()
  {
    return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
  }

  /**
   * Returns the meta object for the map '{@link org.eclipse.emf.ecore.EObject#getXSISchemaLocation <em>XSI Schema Location</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the map '<em>XSI Schema Location</em>'.
   * @see org.eclipse.emf.ecore.EObject#getXSISchemaLocation()
   * @see #getDocumentRoot()
   * @generated
   */
  public EReference getDocumentRoot_XSISchemaLocation()
  {
    return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
  }

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecore.EObject#getStockQuote <em>Stock Quote</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Stock Quote</em>'.
   * @see org.eclipse.emf.ecore.EObject#getStockQuote()
   * @see #getDocumentRoot()
   * @generated
   */
  public EReference getDocumentRoot_StockQuote()
  {
    return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
  }

  /**
   * Returns the meta object for class '{@link com.example.simple.Quote <em>Quote</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Quote</em>'.
   * @see com.example.simple.Quote
   * @generated
   */
  public EClass getQuote()
  {
    return quoteEClass;
  }

  /**
   * Returns the meta object for the attribute '{@link com.example.simple.Quote#getSymbol <em>Symbol</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Symbol</em>'.
   * @see com.example.simple.Quote#getSymbol()
   * @see #getQuote()
   * @generated
   */
  public EAttribute getQuote_Symbol()
  {
    return (EAttribute)quoteEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for the attribute '{@link com.example.simple.Quote#getCompanyName <em>Company Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Company Name</em>'.
   * @see com.example.simple.Quote#getCompanyName()
   * @see #getQuote()
   * @generated
   */
  public EAttribute getQuote_CompanyName()
  {
    return (EAttribute)quoteEClass.getEStructuralFeatures().get(1);
  }

  /**
   * Returns the meta object for the attribute '{@link com.example.simple.Quote#getPrice <em>Price</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Price</em>'.
   * @see com.example.simple.Quote#getPrice()
   * @see #getQuote()
   * @generated
   */
  public EAttribute getQuote_Price()
  {
    return (EAttribute)quoteEClass.getEStructuralFeatures().get(2);
  }

  /**
   * Returns the meta object for the attribute '{@link com.example.simple.Quote#getOpen1 <em>Open1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Open1</em>'.
   * @see com.example.simple.Quote#getOpen1()
   * @see #getQuote()
   * @generated
   */
  public EAttribute getQuote_Open1()
  {
    return (EAttribute)quoteEClass.getEStructuralFeatures().get(3);
  }

  /**
   * Returns the meta object for the attribute '{@link com.example.simple.Quote#getHigh <em>High</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>High</em>'.
   * @see com.example.simple.Quote#getHigh()
   * @see #getQuote()
   * @generated
   */
  public EAttribute getQuote_High()
  {
    return (EAttribute)quoteEClass.getEStructuralFeatures().get(4);
  }

  /**
   * Returns the meta object for the attribute '{@link com.example.simple.Quote#getLow <em>Low</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Low</em>'.
   * @see com.example.simple.Quote#getLow()
   * @see #getQuote()
   * @generated
   */
  public EAttribute getQuote_Low()
  {
    return (EAttribute)quoteEClass.getEStructuralFeatures().get(5);
  }

  /**
   * Returns the meta object for the attribute '{@link com.example.simple.Quote#getVolume <em>Volume</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Volume</em>'.
   * @see com.example.simple.Quote#getVolume()
   * @see #getQuote()
   * @generated
   */
  public EAttribute getQuote_Volume()
  {
    return (EAttribute)quoteEClass.getEStructuralFeatures().get(6);
  }

  /**
   * Returns the meta object for the attribute '{@link com.example.simple.Quote#getChange1 <em>Change1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Change1</em>'.
   * @see com.example.simple.Quote#getChange1()
   * @see #getQuote()
   * @generated
   */
  public EAttribute getQuote_Change1()
  {
    return (EAttribute)quoteEClass.getEStructuralFeatures().get(7);
  }

  /**
   * Returns the meta object for the containment reference list '{@link com.example.simple.Quote#getQuotes <em>Quotes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Quotes</em>'.
   * @see com.example.simple.Quote#getQuotes()
   * @see #getQuote()
   * @generated
   */
  public EReference getQuote_Quotes()
  {
    return (EReference)quoteEClass.getEStructuralFeatures().get(8);
  }

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  public SimpleFactory getSimpleFactory()
  {
    return (SimpleFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    documentRootEClass = createEClass(DOCUMENT_ROOT);
    createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
    createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
    createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
    createEReference(documentRootEClass, DOCUMENT_ROOT__STOCK_QUOTE);

    quoteEClass = createEClass(QUOTE);
    createEAttribute(quoteEClass, QUOTE__SYMBOL);
    createEAttribute(quoteEClass, QUOTE__COMPANY_NAME);
    createEAttribute(quoteEClass, QUOTE__PRICE);
    createEAttribute(quoteEClass, QUOTE__OPEN1);
    createEAttribute(quoteEClass, QUOTE__HIGH);
    createEAttribute(quoteEClass, QUOTE__LOW);
    createEAttribute(quoteEClass, QUOTE__VOLUME);
    createEAttribute(quoteEClass, QUOTE__CHANGE1);
    createEReference(quoteEClass, QUOTE__QUOTES);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(documentRootEClass, null, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_StockQuote(), this.getQuote(), null, "stockQuote", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

    initEClass(quoteEClass, Quote.class, "Quote", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getQuote_Symbol(), theXMLTypePackage.getString(), "symbol", null, 1, 1, Quote.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getQuote_CompanyName(), theXMLTypePackage.getString(), "companyName", null, 1, 1, Quote.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getQuote_Price(), theXMLTypePackage.getDecimal(), "price", null, 1, 1, Quote.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getQuote_Open1(), theXMLTypePackage.getDecimal(), "open1", null, 1, 1, Quote.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getQuote_High(), theXMLTypePackage.getDecimal(), "high", null, 1, 1, Quote.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getQuote_Low(), theXMLTypePackage.getDecimal(), "low", null, 1, 1, Quote.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getQuote_Volume(), theXMLTypePackage.getDouble(), "volume", null, 1, 1, Quote.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getQuote_Change1(), theXMLTypePackage.getDouble(), "change1", null, 1, 1, Quote.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getQuote_Quotes(), this.getQuote(), null, "quotes", null, 0, -1, Quote.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
    createExtendedMetaDataAnnotations();
  }

  /**
   * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createExtendedMetaDataAnnotations()
  {
    String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
    addAnnotation
      (documentRootEClass, 
       source, 
       new String[] 
       {
       "name", "",
       "kind", "mixed"
       });		
    addAnnotation
      (getDocumentRoot_Mixed(), 
       source, 
       new String[] 
       {
       "kind", "elementWildcard",
       "name", ":mixed"
       });		
    addAnnotation
      (getDocumentRoot_XMLNSPrefixMap(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "xmlns:prefix"
       });		
    addAnnotation
      (getDocumentRoot_XSISchemaLocation(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "xsi:schemaLocation"
       });		
    addAnnotation
      (getDocumentRoot_StockQuote(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "stockQuote",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (quoteEClass, 
       source, 
       new String[] 
       {
       "name", "Quote",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getQuote_Symbol(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "symbol"
       });		
    addAnnotation
      (getQuote_CompanyName(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "companyName"
       });		
    addAnnotation
      (getQuote_Price(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "price"
       });		
    addAnnotation
      (getQuote_Open1(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "open1"
       });		
    addAnnotation
      (getQuote_High(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "high"
       });		
    addAnnotation
      (getQuote_Low(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "low"
       });		
    addAnnotation
      (getQuote_Volume(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "volume"
       });		
    addAnnotation
      (getQuote_Change1(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "change1"
       });		
    addAnnotation
      (getQuote_Quotes(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "quotes"
       });
  }

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  public interface Literals
  {
    /**
     * The meta object literal for the '{@link com.example.simple.impl.DocumentRootImpl <em>Document Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.example.simple.impl.DocumentRootImpl
     * @see com.example.simple.impl.SimplePackageImpl#getDocumentRoot()
     * @generated
     */
    public static final EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

    /**
     * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

    /**
     * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

    /**
     * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

    /**
     * The meta object literal for the '<em><b>Stock Quote</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference DOCUMENT_ROOT__STOCK_QUOTE = eINSTANCE.getDocumentRoot_StockQuote();

    /**
     * The meta object literal for the '{@link com.example.simple.impl.QuoteImpl <em>Quote</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.example.simple.impl.QuoteImpl
     * @see com.example.simple.impl.SimplePackageImpl#getQuote()
     * @generated
     */
    public static final EClass QUOTE = eINSTANCE.getQuote();

    /**
     * The meta object literal for the '<em><b>Symbol</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute QUOTE__SYMBOL = eINSTANCE.getQuote_Symbol();

    /**
     * The meta object literal for the '<em><b>Company Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute QUOTE__COMPANY_NAME = eINSTANCE.getQuote_CompanyName();

    /**
     * The meta object literal for the '<em><b>Price</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute QUOTE__PRICE = eINSTANCE.getQuote_Price();

    /**
     * The meta object literal for the '<em><b>Open1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute QUOTE__OPEN1 = eINSTANCE.getQuote_Open1();

    /**
     * The meta object literal for the '<em><b>High</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute QUOTE__HIGH = eINSTANCE.getQuote_High();

    /**
     * The meta object literal for the '<em><b>Low</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute QUOTE__LOW = eINSTANCE.getQuote_Low();

    /**
     * The meta object literal for the '<em><b>Volume</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute QUOTE__VOLUME = eINSTANCE.getQuote_Volume();

    /**
     * The meta object literal for the '<em><b>Change1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute QUOTE__CHANGE1 = eINSTANCE.getQuote_Change1();

    /**
     * The meta object literal for the '<em><b>Quotes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference QUOTE__QUOTES = eINSTANCE.getQuote_Quotes();

  }

} //SimplePackageImpl
