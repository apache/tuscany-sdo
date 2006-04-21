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
package org.apache.tuscany.sdo.util.metadata.impl;

import org.apache.tuscany.sdo.impl.SDOPackageImpl;

import org.apache.tuscany.sdo.model.impl.ModelPackageImpl;

import org.apache.tuscany.sdo.util.metadata.JavaMetaData;
import org.apache.tuscany.sdo.util.metadata.MetadataFactory;
import org.apache.tuscany.sdo.util.metadata.SDOMetaDataGroup;
import org.apache.tuscany.sdo.util.metadata.TypeMetaData;
import org.apache.tuscany.sdo.util.metadata.XSDMetaData;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.apache.tuscany.sdo.util.metadata.MetadataFactory
 * @generated
 */
public class MetadataPackageImpl extends EPackageImpl
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String eNAME = "metadata";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String eNS_URI = "org.apache.tuscany.sdo/metadata";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String eNS_PREFIX = "metadata";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final MetadataPackageImpl eINSTANCE = org.apache.tuscany.sdo.util.metadata.impl.MetadataPackageImpl.init();

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.util.metadata.impl.DocumentRootImpl <em>Document Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.util.metadata.impl.DocumentRootImpl
   * @see org.apache.tuscany.sdo.util.metadata.impl.MetadataPackageImpl#getDocumentRoot()
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
   * The feature id for the '<em><b>Sdo Meta Data Group</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DOCUMENT_ROOT__SDO_META_DATA_GROUP = 3;

  /**
   * The number of structural features of the '<em>Document Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DOCUMENT_ROOT_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.util.metadata.impl.JavaMetaDataImpl <em>Java Meta Data</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.util.metadata.impl.JavaMetaDataImpl
   * @see org.apache.tuscany.sdo.util.metadata.impl.MetadataPackageImpl#getJavaMetaData()
   * @generated
   */
  public static final int JAVA_META_DATA = 1;

  /**
   * The feature id for the '<em><b>Factory Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int JAVA_META_DATA__FACTORY_INTERFACE = 0;

  /**
   * The feature id for the '<em><b>Type Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int JAVA_META_DATA__TYPE_INTERFACE = 1;

  /**
   * The number of structural features of the '<em>Java Meta Data</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int JAVA_META_DATA_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.util.metadata.impl.SDOMetaDataGroupImpl <em>SDO Meta Data Group</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.util.metadata.impl.SDOMetaDataGroupImpl
   * @see org.apache.tuscany.sdo.util.metadata.impl.MetadataPackageImpl#getSDOMetaDataGroup()
   * @generated
   */
  public static final int SDO_META_DATA_GROUP = 2;

  /**
   * The feature id for the '<em><b>Java Meta Data</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SDO_META_DATA_GROUP__JAVA_META_DATA = 0;

  /**
   * The feature id for the '<em><b>Xsd Meta Data</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SDO_META_DATA_GROUP__XSD_META_DATA = 1;

  /**
   * The feature id for the '<em><b>Type Meta Data</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SDO_META_DATA_GROUP__TYPE_META_DATA = 2;

  /**
   * The number of structural features of the '<em>SDO Meta Data Group</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SDO_META_DATA_GROUP_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.util.metadata.impl.TypeMetaDataImpl <em>Type Meta Data</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.util.metadata.impl.TypeMetaDataImpl
   * @see org.apache.tuscany.sdo.util.metadata.impl.MetadataPackageImpl#getTypeMetaData()
   * @generated
   */
  public static final int TYPE_META_DATA = 3;

  /**
   * The feature id for the '<em><b>Location</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int TYPE_META_DATA__LOCATION = 0;

  /**
   * The number of structural features of the '<em>Type Meta Data</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int TYPE_META_DATA_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.util.metadata.impl.XSDMetaDataImpl <em>XSD Meta Data</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.util.metadata.impl.XSDMetaDataImpl
   * @see org.apache.tuscany.sdo.util.metadata.impl.MetadataPackageImpl#getXSDMetaData()
   * @generated
   */
  public static final int XSD_META_DATA = 4;

  /**
   * The feature id for the '<em><b>Location</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int XSD_META_DATA__LOCATION = 0;

  /**
   * The number of structural features of the '<em>XSD Meta Data</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int XSD_META_DATA_FEATURE_COUNT = 1;

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
  private EClass javaMetaDataEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sdoMetaDataGroupEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeMetaDataEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xsdMetaDataEClass = null;

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
   * @see org.apache.tuscany.sdo.util.metadata.impl.MetadataPackageImpl#eNS_URI
   * @see #init()
   * @generated
   */
  private MetadataPackageImpl()
  {
    super(eNS_URI, ((EFactory)MetadataFactory.INSTANCE));
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
  public static MetadataPackageImpl init()
  {
    if (isInited) return (MetadataPackageImpl)EPackage.Registry.INSTANCE.getEPackage(MetadataPackageImpl.eNS_URI);

    // Obtain or create and register package
    MetadataPackageImpl theMetadataPackageImpl = (MetadataPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof MetadataPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new MetadataPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    SDOPackageImpl.eINSTANCE.eClass();
    ModelPackageImpl.eINSTANCE.eClass();

    // Create package meta-data objects
    theMetadataPackageImpl.createPackageContents();

    // Initialize created meta-data
    theMetadataPackageImpl.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theMetadataPackageImpl.freeze();

    return theMetadataPackageImpl;
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
   * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecore.EObject#getSdoMetaDataGroup <em>Sdo Meta Data Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Sdo Meta Data Group</em>'.
   * @see org.eclipse.emf.ecore.EObject#getSdoMetaDataGroup()
   * @see #getDocumentRoot()
   * @generated
   */
  public EReference getDocumentRoot_SdoMetaDataGroup()
  {
    return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
  }

  /**
   * Returns the meta object for class '{@link org.apache.tuscany.sdo.util.metadata.JavaMetaData <em>Java Meta Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Java Meta Data</em>'.
   * @see org.apache.tuscany.sdo.util.metadata.JavaMetaData
   * @generated
   */
  public EClass getJavaMetaData()
  {
    return javaMetaDataEClass;
  }

  /**
   * Returns the meta object for the attribute '{@link org.apache.tuscany.sdo.util.metadata.JavaMetaData#getFactoryInterface <em>Factory Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Factory Interface</em>'.
   * @see org.apache.tuscany.sdo.util.metadata.JavaMetaData#getFactoryInterface()
   * @see #getJavaMetaData()
   * @generated
   */
  public EAttribute getJavaMetaData_FactoryInterface()
  {
    return (EAttribute)javaMetaDataEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for the attribute '{@link org.apache.tuscany.sdo.util.metadata.JavaMetaData#getTypeInterface <em>Type Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Interface</em>'.
   * @see org.apache.tuscany.sdo.util.metadata.JavaMetaData#getTypeInterface()
   * @see #getJavaMetaData()
   * @generated
   */
  public EAttribute getJavaMetaData_TypeInterface()
  {
    return (EAttribute)javaMetaDataEClass.getEStructuralFeatures().get(1);
  }

  /**
   * Returns the meta object for class '{@link org.apache.tuscany.sdo.util.metadata.SDOMetaDataGroup <em>SDO Meta Data Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SDO Meta Data Group</em>'.
   * @see org.apache.tuscany.sdo.util.metadata.SDOMetaDataGroup
   * @generated
   */
  public EClass getSDOMetaDataGroup()
  {
    return sdoMetaDataGroupEClass;
  }

  /**
   * Returns the meta object for the containment reference list '{@link org.apache.tuscany.sdo.util.metadata.SDOMetaDataGroup#getJavaMetaData <em>Java Meta Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Java Meta Data</em>'.
   * @see org.apache.tuscany.sdo.util.metadata.SDOMetaDataGroup#getJavaMetaData()
   * @see #getSDOMetaDataGroup()
   * @generated
   */
  public EReference getSDOMetaDataGroup_JavaMetaData()
  {
    return (EReference)sdoMetaDataGroupEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for the containment reference list '{@link org.apache.tuscany.sdo.util.metadata.SDOMetaDataGroup#getXsdMetaData <em>Xsd Meta Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Xsd Meta Data</em>'.
   * @see org.apache.tuscany.sdo.util.metadata.SDOMetaDataGroup#getXsdMetaData()
   * @see #getSDOMetaDataGroup()
   * @generated
   */
  public EReference getSDOMetaDataGroup_XsdMetaData()
  {
    return (EReference)sdoMetaDataGroupEClass.getEStructuralFeatures().get(1);
  }

  /**
   * Returns the meta object for the containment reference list '{@link org.apache.tuscany.sdo.util.metadata.SDOMetaDataGroup#getTypeMetaData <em>Type Meta Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Type Meta Data</em>'.
   * @see org.apache.tuscany.sdo.util.metadata.SDOMetaDataGroup#getTypeMetaData()
   * @see #getSDOMetaDataGroup()
   * @generated
   */
  public EReference getSDOMetaDataGroup_TypeMetaData()
  {
    return (EReference)sdoMetaDataGroupEClass.getEStructuralFeatures().get(2);
  }

  /**
   * Returns the meta object for class '{@link org.apache.tuscany.sdo.util.metadata.TypeMetaData <em>Type Meta Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Meta Data</em>'.
   * @see org.apache.tuscany.sdo.util.metadata.TypeMetaData
   * @generated
   */
  public EClass getTypeMetaData()
  {
    return typeMetaDataEClass;
  }

  /**
   * Returns the meta object for the attribute '{@link org.apache.tuscany.sdo.util.metadata.TypeMetaData#getLocation <em>Location</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Location</em>'.
   * @see org.apache.tuscany.sdo.util.metadata.TypeMetaData#getLocation()
   * @see #getTypeMetaData()
   * @generated
   */
  public EAttribute getTypeMetaData_Location()
  {
    return (EAttribute)typeMetaDataEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for class '{@link org.apache.tuscany.sdo.util.metadata.XSDMetaData <em>XSD Meta Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XSD Meta Data</em>'.
   * @see org.apache.tuscany.sdo.util.metadata.XSDMetaData
   * @generated
   */
  public EClass getXSDMetaData()
  {
    return xsdMetaDataEClass;
  }

  /**
   * Returns the meta object for the attribute '{@link org.apache.tuscany.sdo.util.metadata.XSDMetaData#getLocation <em>Location</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Location</em>'.
   * @see org.apache.tuscany.sdo.util.metadata.XSDMetaData#getLocation()
   * @see #getXSDMetaData()
   * @generated
   */
  public EAttribute getXSDMetaData_Location()
  {
    return (EAttribute)xsdMetaDataEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  public MetadataFactory getMetadataFactory()
  {
    return (MetadataFactory)getEFactoryInstance();
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
    createEReference(documentRootEClass, DOCUMENT_ROOT__SDO_META_DATA_GROUP);

    javaMetaDataEClass = createEClass(JAVA_META_DATA);
    createEAttribute(javaMetaDataEClass, JAVA_META_DATA__FACTORY_INTERFACE);
    createEAttribute(javaMetaDataEClass, JAVA_META_DATA__TYPE_INTERFACE);

    sdoMetaDataGroupEClass = createEClass(SDO_META_DATA_GROUP);
    createEReference(sdoMetaDataGroupEClass, SDO_META_DATA_GROUP__JAVA_META_DATA);
    createEReference(sdoMetaDataGroupEClass, SDO_META_DATA_GROUP__XSD_META_DATA);
    createEReference(sdoMetaDataGroupEClass, SDO_META_DATA_GROUP__TYPE_META_DATA);

    typeMetaDataEClass = createEClass(TYPE_META_DATA);
    createEAttribute(typeMetaDataEClass, TYPE_META_DATA__LOCATION);

    xsdMetaDataEClass = createEClass(XSD_META_DATA);
    createEAttribute(xsdMetaDataEClass, XSD_META_DATA__LOCATION);
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
    initEReference(getDocumentRoot_SdoMetaDataGroup(), this.getSDOMetaDataGroup(), null, "sdoMetaDataGroup", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

    initEClass(javaMetaDataEClass, JavaMetaData.class, "JavaMetaData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getJavaMetaData_FactoryInterface(), theModelPackageImpl.getString(), "factoryInterface", null, 0, 1, JavaMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getJavaMetaData_TypeInterface(), theModelPackageImpl.getString(), "typeInterface", null, 0, 1, JavaMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sdoMetaDataGroupEClass, SDOMetaDataGroup.class, "SDOMetaDataGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSDOMetaDataGroup_JavaMetaData(), this.getJavaMetaData(), null, "javaMetaData", null, 0, -1, SDOMetaDataGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSDOMetaDataGroup_XsdMetaData(), this.getXSDMetaData(), null, "xsdMetaData", null, 0, -1, SDOMetaDataGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSDOMetaDataGroup_TypeMetaData(), this.getTypeMetaData(), null, "typeMetaData", null, 0, -1, SDOMetaDataGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeMetaDataEClass, TypeMetaData.class, "TypeMetaData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTypeMetaData_Location(), theModelPackageImpl.getString(), "location", null, 1, 1, TypeMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xsdMetaDataEClass, XSDMetaData.class, "XSDMetaData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getXSDMetaData_Location(), theModelPackageImpl.getString(), "location", null, 1, 1, XSDMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
      (getDocumentRoot_SdoMetaDataGroup(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "sdoMetaDataGroup",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (javaMetaDataEClass, 
       source, 
       new String[] 
       {
       "name", "JavaMetaData",
       "kind", "empty"
       });		
    addAnnotation
      (getJavaMetaData_FactoryInterface(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "factoryInterface"
       });		
    addAnnotation
      (getJavaMetaData_TypeInterface(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "typeInterface"
       });		
    addAnnotation
      (sdoMetaDataGroupEClass, 
       source, 
       new String[] 
       {
       "name", "SDOMetaDataGroup",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getSDOMetaDataGroup_JavaMetaData(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "javaMetaData"
       });		
    addAnnotation
      (getSDOMetaDataGroup_XsdMetaData(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "xsdMetaData"
       });		
    addAnnotation
      (getSDOMetaDataGroup_TypeMetaData(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "typeMetaData"
       });		
    addAnnotation
      (typeMetaDataEClass, 
       source, 
       new String[] 
       {
       "name", "TypeMetaData",
       "kind", "empty"
       });		
    addAnnotation
      (getTypeMetaData_Location(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "location"
       });		
    addAnnotation
      (xsdMetaDataEClass, 
       source, 
       new String[] 
       {
       "name", "XSDMetaData",
       "kind", "empty"
       });		
    addAnnotation
      (getXSDMetaData_Location(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "location"
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
     * The meta object literal for the '{@link org.apache.tuscany.sdo.util.metadata.impl.DocumentRootImpl <em>Document Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.util.metadata.impl.DocumentRootImpl
     * @see org.apache.tuscany.sdo.util.metadata.impl.MetadataPackageImpl#getDocumentRoot()
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
     * The meta object literal for the '<em><b>Sdo Meta Data Group</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference DOCUMENT_ROOT__SDO_META_DATA_GROUP = eINSTANCE.getDocumentRoot_SdoMetaDataGroup();

    /**
     * The meta object literal for the '{@link org.apache.tuscany.sdo.util.metadata.impl.JavaMetaDataImpl <em>Java Meta Data</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.util.metadata.impl.JavaMetaDataImpl
     * @see org.apache.tuscany.sdo.util.metadata.impl.MetadataPackageImpl#getJavaMetaData()
     * @generated
     */
    public static final EClass JAVA_META_DATA = eINSTANCE.getJavaMetaData();

    /**
     * The meta object literal for the '<em><b>Factory Interface</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute JAVA_META_DATA__FACTORY_INTERFACE = eINSTANCE.getJavaMetaData_FactoryInterface();

    /**
     * The meta object literal for the '<em><b>Type Interface</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute JAVA_META_DATA__TYPE_INTERFACE = eINSTANCE.getJavaMetaData_TypeInterface();

    /**
     * The meta object literal for the '{@link org.apache.tuscany.sdo.util.metadata.impl.SDOMetaDataGroupImpl <em>SDO Meta Data Group</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.util.metadata.impl.SDOMetaDataGroupImpl
     * @see org.apache.tuscany.sdo.util.metadata.impl.MetadataPackageImpl#getSDOMetaDataGroup()
     * @generated
     */
    public static final EClass SDO_META_DATA_GROUP = eINSTANCE.getSDOMetaDataGroup();

    /**
     * The meta object literal for the '<em><b>Java Meta Data</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference SDO_META_DATA_GROUP__JAVA_META_DATA = eINSTANCE.getSDOMetaDataGroup_JavaMetaData();

    /**
     * The meta object literal for the '<em><b>Xsd Meta Data</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference SDO_META_DATA_GROUP__XSD_META_DATA = eINSTANCE.getSDOMetaDataGroup_XsdMetaData();

    /**
     * The meta object literal for the '<em><b>Type Meta Data</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference SDO_META_DATA_GROUP__TYPE_META_DATA = eINSTANCE.getSDOMetaDataGroup_TypeMetaData();

    /**
     * The meta object literal for the '{@link org.apache.tuscany.sdo.util.metadata.impl.TypeMetaDataImpl <em>Type Meta Data</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.util.metadata.impl.TypeMetaDataImpl
     * @see org.apache.tuscany.sdo.util.metadata.impl.MetadataPackageImpl#getTypeMetaData()
     * @generated
     */
    public static final EClass TYPE_META_DATA = eINSTANCE.getTypeMetaData();

    /**
     * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute TYPE_META_DATA__LOCATION = eINSTANCE.getTypeMetaData_Location();

    /**
     * The meta object literal for the '{@link org.apache.tuscany.sdo.util.metadata.impl.XSDMetaDataImpl <em>XSD Meta Data</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.util.metadata.impl.XSDMetaDataImpl
     * @see org.apache.tuscany.sdo.util.metadata.impl.MetadataPackageImpl#getXSDMetaData()
     * @generated
     */
    public static final EClass XSD_META_DATA = eINSTANCE.getXSDMetaData();

    /**
     * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute XSD_META_DATA__LOCATION = eINSTANCE.getXSDMetaData_Location();

  }

} //MetadataPackageImpl
