/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.sdo.model.java.impl;

import org.apache.tuscany.sdo.impl.SDOPackageImpl;

import org.apache.tuscany.sdo.model.impl.ModelPackageImpl;

import org.apache.tuscany.sdo.model.java.JavaFactory;
import org.apache.tuscany.sdo.model.java.JavaInfo;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

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
 * @see org.apache.tuscany.sdo.model.java.JavaFactory
 * @generated
 */
public class JavaPackageImpl extends EPackageImpl
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String eNAME = "java";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String eNS_URI = "commonj.sdo/java";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String eNS_PREFIX = "java";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final JavaPackageImpl eINSTANCE = org.apache.tuscany.sdo.model.java.impl.JavaPackageImpl.init();

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.model.java.impl.DocumentRootImpl <em>Document Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.model.java.impl.DocumentRootImpl
   * @see org.apache.tuscany.sdo.model.java.impl.JavaPackageImpl#getDocumentRoot()
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
   * The feature id for the '<em><b>Extended Instance Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DOCUMENT_ROOT__EXTENDED_INSTANCE_CLASS = 3;

  /**
   * The feature id for the '<em><b>Instance Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DOCUMENT_ROOT__INSTANCE_CLASS = 4;

  /**
   * The feature id for the '<em><b>Java Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DOCUMENT_ROOT__JAVA_CLASS = 5;

  /**
   * The feature id for the '<em><b>Nested Interfaces</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DOCUMENT_ROOT__NESTED_INTERFACES = 6;

  /**
   * The feature id for the '<em><b>Package</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DOCUMENT_ROOT__PACKAGE = 7;

  /**
   * The number of structural features of the '<em>Document Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DOCUMENT_ROOT_FEATURE_COUNT = 8;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.model.java.impl.JavaInfoImpl <em>Info</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.model.java.impl.JavaInfoImpl
   * @see org.apache.tuscany.sdo.model.java.impl.JavaPackageImpl#getJavaInfo()
   * @generated
   */
  public static final int JAVA_INFO = 1;

  /**
   * The feature id for the '<em><b>Java Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int JAVA_INFO__JAVA_CLASS = 0;

  /**
   * The number of structural features of the '<em>Info</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int JAVA_INFO_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '<em>Boolean Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.Boolean
   * @see org.apache.tuscany.sdo.model.java.impl.JavaPackageImpl#getBooleanObject()
   * @generated
   */
  public static final int BOOLEAN_OBJECT = 2;

  /**
   * The meta object id for the '<em>Byte Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.Byte
   * @see org.apache.tuscany.sdo.model.java.impl.JavaPackageImpl#getByteObject()
   * @generated
   */
  public static final int BYTE_OBJECT = 3;

  /**
   * The meta object id for the '<em>Character Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.Character
   * @see org.apache.tuscany.sdo.model.java.impl.JavaPackageImpl#getCharacterObject()
   * @generated
   */
  public static final int CHARACTER_OBJECT = 4;

  /**
   * The meta object id for the '<em>Double Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.Double
   * @see org.apache.tuscany.sdo.model.java.impl.JavaPackageImpl#getDoubleObject()
   * @generated
   */
  public static final int DOUBLE_OBJECT = 5;

  /**
   * The meta object id for the '<em>Float Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.Float
   * @see org.apache.tuscany.sdo.model.java.impl.JavaPackageImpl#getFloatObject()
   * @generated
   */
  public static final int FLOAT_OBJECT = 6;

  /**
   * The meta object id for the '<em>Int Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.Integer
   * @see org.apache.tuscany.sdo.model.java.impl.JavaPackageImpl#getIntObject()
   * @generated
   */
  public static final int INT_OBJECT = 7;

  /**
   * The meta object id for the '<em>Long Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.Long
   * @see org.apache.tuscany.sdo.model.java.impl.JavaPackageImpl#getLongObject()
   * @generated
   */
  public static final int LONG_OBJECT = 8;

  /**
   * The meta object id for the '<em>Short Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.Short
   * @see org.apache.tuscany.sdo.model.java.impl.JavaPackageImpl#getShortObject()
   * @generated
   */
  public static final int SHORT_OBJECT = 9;

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
  private EClass javaInfoEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType booleanObjectEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType byteObjectEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType characterObjectEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType doubleObjectEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType floatObjectEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType intObjectEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType longObjectEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType shortObjectEDataType = null;

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
   * @see org.apache.tuscany.sdo.model.java.impl.JavaPackageImpl#eNS_URI
   * @see #init()
   * @generated
   */
  private JavaPackageImpl()
  {
    super(eNS_URI, ((EFactory)JavaFactory.INSTANCE));
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
  public static JavaPackageImpl init()
  {
    if (isInited) return (JavaPackageImpl)EPackage.Registry.INSTANCE.getEPackage(JavaPackageImpl.eNS_URI);

    // Obtain or create and register package
    JavaPackageImpl theJavaPackageImpl = (JavaPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof JavaPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new JavaPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    SDOPackageImpl.eINSTANCE.eClass();
    ModelPackageImpl.eINSTANCE.eClass();

    // Create package meta-data objects
    theJavaPackageImpl.createPackageContents();

    // Initialize created meta-data
    theJavaPackageImpl.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theJavaPackageImpl.freeze();

    return theJavaPackageImpl;
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
   * Returns the meta object for the attribute '{@link org.eclipse.emf.ecore.EObject#getExtendedInstanceClass <em>Extended Instance Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Extended Instance Class</em>'.
   * @see org.eclipse.emf.ecore.EObject#getExtendedInstanceClass()
   * @see #getDocumentRoot()
   * @generated
   */
  public EAttribute getDocumentRoot_ExtendedInstanceClass()
  {
    return (EAttribute)documentRootEClass.getEStructuralFeatures().get(3);
  }

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.ecore.EObject#getInstanceClass <em>Instance Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Instance Class</em>'.
   * @see org.eclipse.emf.ecore.EObject#getInstanceClass()
   * @see #getDocumentRoot()
   * @generated
   */
  public EAttribute getDocumentRoot_InstanceClass()
  {
    return (EAttribute)documentRootEClass.getEStructuralFeatures().get(4);
  }

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.ecore.EObject#getJavaClass <em>Java Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Java Class</em>'.
   * @see org.eclipse.emf.ecore.EObject#getJavaClass()
   * @see #getDocumentRoot()
   * @generated
   */
  public EAttribute getDocumentRoot_JavaClass()
  {
    return (EAttribute)documentRootEClass.getEStructuralFeatures().get(5);
  }

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.ecore.EObject#isNestedInterfaces <em>Nested Interfaces</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Nested Interfaces</em>'.
   * @see org.eclipse.emf.ecore.EObject#isNestedInterfaces()
   * @see #getDocumentRoot()
   * @generated
   */
  public EAttribute getDocumentRoot_NestedInterfaces()
  {
    return (EAttribute)documentRootEClass.getEStructuralFeatures().get(6);
  }

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.ecore.EObject#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Package</em>'.
   * @see org.eclipse.emf.ecore.EObject#getPackage()
   * @see #getDocumentRoot()
   * @generated
   */
  public EAttribute getDocumentRoot_Package()
  {
    return (EAttribute)documentRootEClass.getEStructuralFeatures().get(7);
  }

  /**
   * Returns the meta object for class '{@link org.apache.tuscany.sdo.model.java.JavaInfo <em>Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Info</em>'.
   * @see org.apache.tuscany.sdo.model.java.JavaInfo
   * @generated
   */
  public EClass getJavaInfo()
  {
    return javaInfoEClass;
  }

  /**
   * Returns the meta object for the attribute '{@link org.apache.tuscany.sdo.model.java.JavaInfo#getJavaClass <em>Java Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Java Class</em>'.
   * @see org.apache.tuscany.sdo.model.java.JavaInfo#getJavaClass()
   * @see #getJavaInfo()
   * @generated
   */
  public EAttribute getJavaInfo_JavaClass()
  {
    return (EAttribute)javaInfoEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for data type '{@link java.lang.Boolean <em>Boolean Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Boolean Object</em>'.
   * @see java.lang.Boolean
   * @generated
   */
  public EDataType getBooleanObject()
  {
    return booleanObjectEDataType;
  }

  /**
   * Returns the meta object for data type '{@link java.lang.Byte <em>Byte Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Byte Object</em>'.
   * @see java.lang.Byte
   * @generated
   */
  public EDataType getByteObject()
  {
    return byteObjectEDataType;
  }

  /**
   * Returns the meta object for data type '{@link java.lang.Character <em>Character Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Character Object</em>'.
   * @see java.lang.Character
   * @generated
   */
  public EDataType getCharacterObject()
  {
    return characterObjectEDataType;
  }

  /**
   * Returns the meta object for data type '{@link java.lang.Double <em>Double Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Double Object</em>'.
   * @see java.lang.Double
   * @generated
   */
  public EDataType getDoubleObject()
  {
    return doubleObjectEDataType;
  }

  /**
   * Returns the meta object for data type '{@link java.lang.Float <em>Float Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Float Object</em>'.
   * @see java.lang.Float
   * @generated
   */
  public EDataType getFloatObject()
  {
    return floatObjectEDataType;
  }

  /**
   * Returns the meta object for data type '{@link java.lang.Integer <em>Int Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Int Object</em>'.
   * @see java.lang.Integer
   * @generated
   */
  public EDataType getIntObject()
  {
    return intObjectEDataType;
  }

  /**
   * Returns the meta object for data type '{@link java.lang.Long <em>Long Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Long Object</em>'.
   * @see java.lang.Long
   * @generated
   */
  public EDataType getLongObject()
  {
    return longObjectEDataType;
  }

  /**
   * Returns the meta object for data type '{@link java.lang.Short <em>Short Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Short Object</em>'.
   * @see java.lang.Short
   * @generated
   */
  public EDataType getShortObject()
  {
    return shortObjectEDataType;
  }

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  public JavaFactory getJavaFactory()
  {
    return (JavaFactory)getEFactoryInstance();
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
    createEAttribute(documentRootEClass, DOCUMENT_ROOT__EXTENDED_INSTANCE_CLASS);
    createEAttribute(documentRootEClass, DOCUMENT_ROOT__INSTANCE_CLASS);
    createEAttribute(documentRootEClass, DOCUMENT_ROOT__JAVA_CLASS);
    createEAttribute(documentRootEClass, DOCUMENT_ROOT__NESTED_INTERFACES);
    createEAttribute(documentRootEClass, DOCUMENT_ROOT__PACKAGE);

    javaInfoEClass = createEClass(JAVA_INFO);
    createEAttribute(javaInfoEClass, JAVA_INFO__JAVA_CLASS);

    // Create data types
    booleanObjectEDataType = createEDataType(BOOLEAN_OBJECT);
    byteObjectEDataType = createEDataType(BYTE_OBJECT);
    characterObjectEDataType = createEDataType(CHARACTER_OBJECT);
    doubleObjectEDataType = createEDataType(DOUBLE_OBJECT);
    floatObjectEDataType = createEDataType(FLOAT_OBJECT);
    intObjectEDataType = createEDataType(INT_OBJECT);
    longObjectEDataType = createEDataType(LONG_OBJECT);
    shortObjectEDataType = createEDataType(SHORT_OBJECT);
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
    ModelPackageImpl theModelPackageImpl = (ModelPackageImpl)EPackage.Registry.INSTANCE.getEPackage(ModelPackageImpl.eNS_URI);

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(documentRootEClass, null, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDocumentRoot_ExtendedInstanceClass(), theModelPackageImpl.getString(), "extendedInstanceClass", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDocumentRoot_InstanceClass(), theModelPackageImpl.getString(), "instanceClass", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDocumentRoot_JavaClass(), theModelPackageImpl.getString(), "javaClass", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDocumentRoot_NestedInterfaces(), theModelPackageImpl.getBoolean(), "nestedInterfaces", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDocumentRoot_Package(), theModelPackageImpl.getString(), "package", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(javaInfoEClass, JavaInfo.class, "JavaInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getJavaInfo_JavaClass(), theModelPackageImpl.getString(), "javaClass", null, 0, 1, JavaInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize data types
    initEDataType(booleanObjectEDataType, Boolean.class, "BooleanObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(byteObjectEDataType, Byte.class, "ByteObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(characterObjectEDataType, Character.class, "CharacterObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(doubleObjectEDataType, Double.class, "DoubleObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(floatObjectEDataType, Float.class, "FloatObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(intObjectEDataType, Integer.class, "IntObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(longObjectEDataType, Long.class, "LongObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(shortObjectEDataType, Short.class, "ShortObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

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
      (booleanObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "BooleanObject"
       });		
    addAnnotation
      (byteObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "ByteObject"
       });		
    addAnnotation
      (characterObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "CharacterObject"
       });		
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
      (getDocumentRoot_ExtendedInstanceClass(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "extendedInstanceClass",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (getDocumentRoot_InstanceClass(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "instanceClass",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (getDocumentRoot_JavaClass(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "javaClass",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (getDocumentRoot_NestedInterfaces(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "nestedInterfaces",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (getDocumentRoot_Package(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "package",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (doubleObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "DoubleObject"
       });		
    addAnnotation
      (floatObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "FloatObject"
       });		
    addAnnotation
      (intObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "IntObject"
       });		
    addAnnotation
      (javaInfoEClass, 
       source, 
       new String[] 
       {
       "name", "JavaInfo",
       "kind", "empty"
       });		
    addAnnotation
      (getJavaInfo_JavaClass(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "javaClass",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (longObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "LongObject"
       });		
    addAnnotation
      (shortObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "ShortObject"
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
     * The meta object literal for the '{@link org.apache.tuscany.sdo.model.java.impl.DocumentRootImpl <em>Document Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.model.java.impl.DocumentRootImpl
     * @see org.apache.tuscany.sdo.model.java.impl.JavaPackageImpl#getDocumentRoot()
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
     * The meta object literal for the '<em><b>Extended Instance Class</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute DOCUMENT_ROOT__EXTENDED_INSTANCE_CLASS = eINSTANCE.getDocumentRoot_ExtendedInstanceClass();

    /**
     * The meta object literal for the '<em><b>Instance Class</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute DOCUMENT_ROOT__INSTANCE_CLASS = eINSTANCE.getDocumentRoot_InstanceClass();

    /**
     * The meta object literal for the '<em><b>Java Class</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute DOCUMENT_ROOT__JAVA_CLASS = eINSTANCE.getDocumentRoot_JavaClass();

    /**
     * The meta object literal for the '<em><b>Nested Interfaces</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute DOCUMENT_ROOT__NESTED_INTERFACES = eINSTANCE.getDocumentRoot_NestedInterfaces();

    /**
     * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute DOCUMENT_ROOT__PACKAGE = eINSTANCE.getDocumentRoot_Package();

    /**
     * The meta object literal for the '{@link org.apache.tuscany.sdo.model.java.impl.JavaInfoImpl <em>Info</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.model.java.impl.JavaInfoImpl
     * @see org.apache.tuscany.sdo.model.java.impl.JavaPackageImpl#getJavaInfo()
     * @generated
     */
    public static final EClass JAVA_INFO = eINSTANCE.getJavaInfo();

    /**
     * The meta object literal for the '<em><b>Java Class</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute JAVA_INFO__JAVA_CLASS = eINSTANCE.getJavaInfo_JavaClass();

    /**
     * The meta object literal for the '<em>Boolean Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Boolean
     * @see org.apache.tuscany.sdo.model.java.impl.JavaPackageImpl#getBooleanObject()
     * @generated
     */
    public static final EDataType BOOLEAN_OBJECT = eINSTANCE.getBooleanObject();

    /**
     * The meta object literal for the '<em>Byte Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Byte
     * @see org.apache.tuscany.sdo.model.java.impl.JavaPackageImpl#getByteObject()
     * @generated
     */
    public static final EDataType BYTE_OBJECT = eINSTANCE.getByteObject();

    /**
     * The meta object literal for the '<em>Character Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Character
     * @see org.apache.tuscany.sdo.model.java.impl.JavaPackageImpl#getCharacterObject()
     * @generated
     */
    public static final EDataType CHARACTER_OBJECT = eINSTANCE.getCharacterObject();

    /**
     * The meta object literal for the '<em>Double Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Double
     * @see org.apache.tuscany.sdo.model.java.impl.JavaPackageImpl#getDoubleObject()
     * @generated
     */
    public static final EDataType DOUBLE_OBJECT = eINSTANCE.getDoubleObject();

    /**
     * The meta object literal for the '<em>Float Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Float
     * @see org.apache.tuscany.sdo.model.java.impl.JavaPackageImpl#getFloatObject()
     * @generated
     */
    public static final EDataType FLOAT_OBJECT = eINSTANCE.getFloatObject();

    /**
     * The meta object literal for the '<em>Int Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Integer
     * @see org.apache.tuscany.sdo.model.java.impl.JavaPackageImpl#getIntObject()
     * @generated
     */
    public static final EDataType INT_OBJECT = eINSTANCE.getIntObject();

    /**
     * The meta object literal for the '<em>Long Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Long
     * @see org.apache.tuscany.sdo.model.java.impl.JavaPackageImpl#getLongObject()
     * @generated
     */
    public static final EDataType LONG_OBJECT = eINSTANCE.getLongObject();

    /**
     * The meta object literal for the '<em>Short Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Short
     * @see org.apache.tuscany.sdo.model.java.impl.JavaPackageImpl#getShortObject()
     * @generated
     */
    public static final EDataType SHORT_OBJECT = eINSTANCE.getShortObject();

  }

} //JavaPackageImpl
