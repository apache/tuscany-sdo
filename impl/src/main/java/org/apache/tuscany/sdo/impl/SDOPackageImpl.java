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
package org.apache.tuscany.sdo.impl;

import java.io.ObjectStreamException;
import java.util.Collections;
import java.util.List;

import org.apache.tuscany.sdo.AnyTypeDataObject;
import org.apache.tuscany.sdo.SDOFactory;
import org.apache.tuscany.sdo.SDOPackage;
import org.apache.tuscany.sdo.SimpleAnyTypeDataObject;
import org.apache.tuscany.sdo.impl.SDOFactoryImpl.SDOEcoreFactory;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.change.ChangePackage;
import org.eclipse.emf.ecore.change.impl.ChangePackageImpl;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.impl.EcorePackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.ecore.xml.type.impl.XMLTypePackageImpl;

import commonj.sdo.ChangeSummary;
import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SDOPackageImpl extends EPackageImpl implements SDOPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass changeSummaryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass changeSummarySettingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dataGraphEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dataObjectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sequenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anyTypeDataObjectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleAnyTypeDataObjectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dataTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass referenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dynamicDataObjectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass storeDataObjectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dynamicStoreDataObjectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass extensibleDataObjectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType eJavaListEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType eObjectStreamExceptionEDataType = null;

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
   * @see org.apache.tuscany.sdo.SDOPackage#eNS_URI
   * @see #init()
   * @generated NOT
   */
  private SDOPackageImpl()
  {
    super(eNS_URI, SDOFactory.eINSTANCE);
    ecoreFactory = new SDOEcoreFactory();
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
  public static SDOPackage init()
  {
    if (isInited) return (SDOPackage)EPackage.Registry.INSTANCE.getEPackage(SDOPackage.eNS_URI);

    // Obtain or create and register package
    SDOPackageImpl theSDOPackage = (SDOPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof SDOPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new SDOPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackageImpl.init();
    XMLTypePackageImpl.init();
    ChangePackageImpl.init();

    // Create package meta-data objects
    theSDOPackage.createPackageContents();

    // Initialize created meta-data
    theSDOPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theSDOPackage.freeze();

    return theSDOPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getChangeSummary()
  {
    return changeSummaryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getChangeSummary_EDataGraph()
  {
    return (EReference)changeSummaryEClass.getEStructuralFeatures().get(0);
  }

//  /**
//   * <!-- begin-user-doc -->
//   * <!-- end-user-doc -->
//   * <hand coded but could be generated>
//   */
//  public EReference getChangeSummary_EDataObject()
//  {
//    return (EReference)changeSummaryEClass.getEStructuralFeatures().get(1);
//  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getChangeSummarySetting()
  {
    return changeSummarySettingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDataGraph()
  {
    return dataGraphEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDataGraph_ResourceSet()
  {
    return (EAttribute)dataGraphEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDataGraph_RootResource()
  {
    return (EAttribute)dataGraphEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDataGraph_EChangeSummary()
  {
    return (EReference)dataGraphEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDataGraph_ERootObject()
  {
    return (EReference)dataGraphEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDataObject()
  {
    return dataObjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProperty()
  {
    return propertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSequence()
  {
    return sequenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getType()
  {
    return typeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnyTypeDataObject()
  {
    return anyTypeDataObjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleAnyTypeDataObject()
  {
    return simpleAnyTypeDataObjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClass_()
  {
    return classEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDataType()
  {
    return dataTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttribute()
  {
    return attributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReference()
  {
    return referenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnum()
  {
    return enumEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDynamicDataObject()
  {
    return dynamicDataObjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStoreDataObject()
  {
    return storeDataObjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDynamicStoreDataObject()
  {
    return dynamicStoreDataObjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExtensibleDataObject()
  {
    return extensibleDataObjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getEJavaList()
  {
    return eJavaListEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getEObjectStreamException()
  {
    return eObjectStreamExceptionEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SDOFactory getSDOFactory()
  {
    return (SDOFactory)getEFactoryInstance();
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
    changeSummaryEClass = createEClass(CHANGE_SUMMARY);
    createEReference(changeSummaryEClass, CHANGE_SUMMARY__EDATA_GRAPH);

    changeSummarySettingEClass = createEClass(CHANGE_SUMMARY_SETTING);

    dataGraphEClass = createEClass(DATA_GRAPH);
    createEAttribute(dataGraphEClass, DATA_GRAPH__RESOURCE_SET);
    createEAttribute(dataGraphEClass, DATA_GRAPH__ROOT_RESOURCE);
    createEReference(dataGraphEClass, DATA_GRAPH__ECHANGE_SUMMARY);
    createEReference(dataGraphEClass, DATA_GRAPH__EROOT_OBJECT);

    dataObjectEClass = createEClass(DATA_OBJECT);

    propertyEClass = createEClass(PROPERTY);

    sequenceEClass = createEClass(SEQUENCE);

    typeEClass = createEClass(TYPE);

    anyTypeDataObjectEClass = createEClass(ANY_TYPE_DATA_OBJECT);

    simpleAnyTypeDataObjectEClass = createEClass(SIMPLE_ANY_TYPE_DATA_OBJECT);

    classEClass = createEClass(CLASS);

    dataTypeEClass = createEClass(DATA_TYPE);

    attributeEClass = createEClass(ATTRIBUTE);

    referenceEClass = createEClass(REFERENCE);

    enumEClass = createEClass(ENUM);

    dynamicDataObjectEClass = createEClass(DYNAMIC_DATA_OBJECT);

    storeDataObjectEClass = createEClass(STORE_DATA_OBJECT);

    dynamicStoreDataObjectEClass = createEClass(DYNAMIC_STORE_DATA_OBJECT);

    extensibleDataObjectEClass = createEClass(EXTENSIBLE_DATA_OBJECT);

    // Create data types
    eJavaListEDataType = createEDataType(EJAVA_LIST);
    eObjectStreamExceptionEDataType = createEDataType(EOBJECT_STREAM_EXCEPTION);
  }
  
  protected EClass createEClass(int id)
  {
    EClassImpl c;
    switch(id) {
      case ANY_TYPE_DATA_OBJECT:
        c = new ClassImpl() {
          List baseTypes = null;
          public List getBaseTypes() {
            if (baseTypes == null)
              baseTypes = Collections.singletonList(getDataObject());
            return baseTypes;
          }
          public List getTypeFeatures() {
            return getEAllStructuralFeatures();
          }
        };
        break;
      case SIMPLE_ANY_TYPE_DATA_OBJECT:
        c = new ClassImpl() {
          List baseTypes = null;
          public List getBaseTypes() {
            if (baseTypes == null)
              baseTypes = Collections.singletonList(getAnyTypeDataObject());
            return baseTypes;
          }
        };
        break;
      default:
        c = (EClassImpl)ecoreFactory.createEClass();
    }
    c.setClassifierID(id);
    getEClassifiers().add(c);
    return c;
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
    ChangePackageImpl theChangePackage = (ChangePackageImpl)EPackage.Registry.INSTANCE.getEPackage(ChangePackage.eNS_URI);
    EcorePackageImpl theEcorePackage = (EcorePackageImpl)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
    XMLTypePackageImpl theXMLTypePackage = (XMLTypePackageImpl)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

    // Add supertypes to classes
    changeSummaryEClass.getESuperTypes().add(theChangePackage.getChangeDescription());
    changeSummarySettingEClass.getESuperTypes().add(theChangePackage.getFeatureChange());
    dataGraphEClass.getESuperTypes().add(theEcorePackage.getEObject());
    anyTypeDataObjectEClass.getESuperTypes().add(this.getDataObject());
    anyTypeDataObjectEClass.getESuperTypes().add(theXMLTypePackage.getAnyType());
    simpleAnyTypeDataObjectEClass.getESuperTypes().add(this.getAnyTypeDataObject());
    simpleAnyTypeDataObjectEClass.getESuperTypes().add(theXMLTypePackage.getSimpleAnyType());
    classEClass.getESuperTypes().add(theEcorePackage.getEClass());
    classEClass.getESuperTypes().add(this.getType());
    dataTypeEClass.getESuperTypes().add(theEcorePackage.getEDataType());
    dataTypeEClass.getESuperTypes().add(this.getType());
    attributeEClass.getESuperTypes().add(theEcorePackage.getEAttribute());
    attributeEClass.getESuperTypes().add(this.getProperty());
    referenceEClass.getESuperTypes().add(theEcorePackage.getEReference());
    referenceEClass.getESuperTypes().add(this.getProperty());
    enumEClass.getESuperTypes().add(theEcorePackage.getEEnum());
    enumEClass.getESuperTypes().add(this.getType());
    dynamicDataObjectEClass.getESuperTypes().add(this.getDataObject());
    storeDataObjectEClass.getESuperTypes().add(this.getDataObject());
    dynamicStoreDataObjectEClass.getESuperTypes().add(this.getStoreDataObject());
    extensibleDataObjectEClass.getESuperTypes().add(this.getDataObject());

    // Initialize classes and features; add operations and parameters
    initEClass(changeSummaryEClass, ChangeSummary.class, "ChangeSummary", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
    initEReference(getChangeSummary_EDataGraph(), this.getDataGraph(), this.getDataGraph_EChangeSummary(), "eDataGraph", null, 1, 1, ChangeSummary.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(changeSummaryEClass, null, "beginLogging");

    addEOperation(changeSummaryEClass, null, "endLogging");

    EOperation op = addEOperation(changeSummaryEClass, ecorePackage.getEBoolean(), "isCreated");
    addEParameter(op, this.getDataObject(), "dataObject");

    op = addEOperation(changeSummaryEClass, ecorePackage.getEBoolean(), "isDeleted");
    addEParameter(op, this.getDataObject(), "dataObject");

    op = addEOperation(changeSummaryEClass, this.getEJavaList(), "getOldValues");
    addEParameter(op, this.getDataObject(), "dataObject");

    op = addEOperation(changeSummaryEClass, ecorePackage.getEBoolean(), "isModified");
    addEParameter(op, this.getDataObject(), "dataObject");

    op = addEOperation(changeSummaryEClass, this.getChangeSummarySetting(), "getOldValue");
    addEParameter(op, this.getDataObject(), "dataObject");
    addEParameter(op, this.getProperty(), "property");

    op = addEOperation(changeSummaryEClass, this.getDataObject(), "getOldContainer");
    addEParameter(op, this.getDataObject(), "dataObject");

    op = addEOperation(changeSummaryEClass, this.getProperty(), "getOldContainmentProperty");
    addEParameter(op, this.getDataObject(), "dataObject");

    op = addEOperation(changeSummaryEClass, this.getSequence(), "getOldSequence");
    addEParameter(op, this.getDataObject(), "dataObject");

    addEOperation(changeSummaryEClass, null, "undoChanges");

    addEOperation(changeSummaryEClass, ecorePackage.getEBoolean(), "isLogging");

    addEOperation(changeSummaryEClass, this.getDataGraph(), "getDataGraph");

    addEOperation(changeSummaryEClass, this.getEJavaList(), "getChangedObjects");

    addEOperation(changeSummaryEClass, this.getDataObject(), "getRootObject");

    initEClass(changeSummarySettingEClass, ChangeSummary.Setting.class, "ChangeSummarySetting", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

    addEOperation(changeSummarySettingEClass, ecorePackage.getEBoolean(), "isSet");

    addEOperation(changeSummarySettingEClass, theEcorePackage.getEJavaObject(), "getValue");

    addEOperation(changeSummarySettingEClass, this.getProperty(), "getProperty");

    initEClass(dataGraphEClass, DataGraph.class, "DataGraph", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDataGraph_ResourceSet(), theEcorePackage.getEResourceSet(), "resourceSet", null, 0, 1, DataGraph.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDataGraph_RootResource(), theEcorePackage.getEResource(), "rootResource", null, 0, 1, DataGraph.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
    initEReference(getDataGraph_EChangeSummary(), this.getChangeSummary(), this.getChangeSummary_EDataGraph(), "eChangeSummary", null, 1, 1, DataGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDataGraph_ERootObject(), theEcorePackage.getEObject(), null, "eRootObject", null, 1, 1, DataGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    op = addEOperation(dataGraphEClass, this.getDataObject(), "createRootObject");
    addEParameter(op, ecorePackage.getEString(), "namespaceURI");
    addEParameter(op, ecorePackage.getEString(), "typeName");

    op = addEOperation(dataGraphEClass, this.getDataObject(), "createRootObject");
    addEParameter(op, this.getType(), "type");

    op = addEOperation(dataGraphEClass, this.getType(), "getType");
    addEParameter(op, ecorePackage.getEString(), "namespaceURI");
    addEParameter(op, ecorePackage.getEString(), "typeName");

    addEOperation(dataGraphEClass, this.getDataObject(), "getRootObject");

    addEOperation(dataGraphEClass, this.getChangeSummary(), "getChangeSummary");

    initEClass(dataObjectEClass, DataObject.class, "DataObject", IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

    op = addEOperation(dataObjectEClass, theEcorePackage.getEJavaObject(), "get");
    addEParameter(op, ecorePackage.getEString(), "path");

    op = addEOperation(dataObjectEClass, null, "set");
    addEParameter(op, ecorePackage.getEString(), "path");
    addEParameter(op, theEcorePackage.getEJavaObject(), "value");

    op = addEOperation(dataObjectEClass, ecorePackage.getEBoolean(), "isSet");
    addEParameter(op, ecorePackage.getEString(), "path");

    op = addEOperation(dataObjectEClass, null, "unset");
    addEParameter(op, ecorePackage.getEString(), "path");

    op = addEOperation(dataObjectEClass, theEcorePackage.getEJavaObject(), "get");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");

    op = addEOperation(dataObjectEClass, null, "set");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");
    addEParameter(op, theEcorePackage.getEJavaObject(), "value");

    op = addEOperation(dataObjectEClass, ecorePackage.getEBoolean(), "isSet");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");

    op = addEOperation(dataObjectEClass, null, "unset");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");

    op = addEOperation(dataObjectEClass, theEcorePackage.getEJavaObject(), "get");
    addEParameter(op, this.getProperty(), "property");

    op = addEOperation(dataObjectEClass, null, "set");
    addEParameter(op, this.getProperty(), "property");
    addEParameter(op, theEcorePackage.getEJavaObject(), "value");

    op = addEOperation(dataObjectEClass, ecorePackage.getEBoolean(), "isSet");
    addEParameter(op, this.getProperty(), "property");

    op = addEOperation(dataObjectEClass, null, "unset");
    addEParameter(op, this.getProperty(), "property");

    addEOperation(dataObjectEClass, this.getDataObject(), "getContainer");

    addEOperation(dataObjectEClass, this.getProperty(), "getContainmentProperty");

    addEOperation(dataObjectEClass, this.getDataGraph(), "getDataGraph");

    addEOperation(dataObjectEClass, this.getType(), "getType");

    op = addEOperation(dataObjectEClass, theEcorePackage.getEBigDecimal(), "getBigDecimal");
    addEParameter(op, ecorePackage.getEString(), "path");

    op = addEOperation(dataObjectEClass, theEcorePackage.getEBigInteger(), "getBigInteger");
    addEParameter(op, ecorePackage.getEString(), "path");

    op = addEOperation(dataObjectEClass, ecorePackage.getEBoolean(), "getBoolean");
    addEParameter(op, ecorePackage.getEString(), "path");

    op = addEOperation(dataObjectEClass, ecorePackage.getEByte(), "getByte");
    addEParameter(op, ecorePackage.getEString(), "path");

    op = addEOperation(dataObjectEClass, theEcorePackage.getEByteArray(), "getBytes");
    addEParameter(op, ecorePackage.getEString(), "path");

    op = addEOperation(dataObjectEClass, ecorePackage.getEChar(), "getChar");
    addEParameter(op, ecorePackage.getEString(), "path");

    op = addEOperation(dataObjectEClass, this.getDataObject(), "getDataObject");
    addEParameter(op, ecorePackage.getEString(), "path");

    op = addEOperation(dataObjectEClass, theEcorePackage.getEDate(), "getDate");
    addEParameter(op, ecorePackage.getEString(), "path");

    op = addEOperation(dataObjectEClass, ecorePackage.getEDouble(), "getDouble");
    addEParameter(op, ecorePackage.getEString(), "path");

    op = addEOperation(dataObjectEClass, ecorePackage.getEFloat(), "getFloat");
    addEParameter(op, ecorePackage.getEString(), "path");

    op = addEOperation(dataObjectEClass, ecorePackage.getEInt(), "getInt");
    addEParameter(op, ecorePackage.getEString(), "path");

    op = addEOperation(dataObjectEClass, this.getEJavaList(), "getList");
    addEParameter(op, ecorePackage.getEString(), "path");

    op = addEOperation(dataObjectEClass, ecorePackage.getELong(), "getLong");
    addEParameter(op, ecorePackage.getEString(), "path");

    op = addEOperation(dataObjectEClass, this.getSequence(), "getSequence");
    addEParameter(op, ecorePackage.getEString(), "path");

    op = addEOperation(dataObjectEClass, ecorePackage.getEShort(), "getShort");
    addEParameter(op, ecorePackage.getEString(), "path");

    op = addEOperation(dataObjectEClass, ecorePackage.getEString(), "getString");
    addEParameter(op, ecorePackage.getEString(), "path");

    op = addEOperation(dataObjectEClass, null, "setBigDecimal");
    addEParameter(op, ecorePackage.getEString(), "path");
    addEParameter(op, theEcorePackage.getEBigDecimal(), "value");

    op = addEOperation(dataObjectEClass, null, "setBigInteger");
    addEParameter(op, ecorePackage.getEString(), "path");
    addEParameter(op, theEcorePackage.getEBigInteger(), "value");

    op = addEOperation(dataObjectEClass, null, "setBoolean");
    addEParameter(op, ecorePackage.getEString(), "path");
    addEParameter(op, ecorePackage.getEBoolean(), "value");

    op = addEOperation(dataObjectEClass, null, "setByte");
    addEParameter(op, ecorePackage.getEString(), "path");
    addEParameter(op, ecorePackage.getEByte(), "value");

    op = addEOperation(dataObjectEClass, null, "setBytes");
    addEParameter(op, ecorePackage.getEString(), "path");
    addEParameter(op, theEcorePackage.getEByteArray(), "value");

    op = addEOperation(dataObjectEClass, null, "setChar");
    addEParameter(op, ecorePackage.getEString(), "path");
    addEParameter(op, ecorePackage.getEChar(), "value");

    op = addEOperation(dataObjectEClass, null, "setDataObject");
    addEParameter(op, ecorePackage.getEString(), "path");
    addEParameter(op, this.getDataObject(), "value");

    op = addEOperation(dataObjectEClass, null, "setDate");
    addEParameter(op, ecorePackage.getEString(), "path");
    addEParameter(op, theEcorePackage.getEDate(), "value");

    op = addEOperation(dataObjectEClass, null, "setDouble");
    addEParameter(op, ecorePackage.getEString(), "path");
    addEParameter(op, ecorePackage.getEDouble(), "value");

    op = addEOperation(dataObjectEClass, null, "setFloat");
    addEParameter(op, ecorePackage.getEString(), "path");
    addEParameter(op, ecorePackage.getEFloat(), "value");

    op = addEOperation(dataObjectEClass, null, "setInt");
    addEParameter(op, ecorePackage.getEString(), "path");
    addEParameter(op, ecorePackage.getEInt(), "value");

    op = addEOperation(dataObjectEClass, null, "setList");
    addEParameter(op, ecorePackage.getEString(), "path");
    addEParameter(op, this.getEJavaList(), "value");

    op = addEOperation(dataObjectEClass, null, "setLong");
    addEParameter(op, ecorePackage.getEString(), "path");
    addEParameter(op, ecorePackage.getELong(), "value");

    op = addEOperation(dataObjectEClass, null, "setShort");
    addEParameter(op, ecorePackage.getEString(), "path");
    addEParameter(op, ecorePackage.getEShort(), "value");

    op = addEOperation(dataObjectEClass, null, "setString");
    addEParameter(op, ecorePackage.getEString(), "path");
    addEParameter(op, ecorePackage.getEString(), "value");

    op = addEOperation(dataObjectEClass, theEcorePackage.getEBigDecimal(), "getBigDecimal");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");

    op = addEOperation(dataObjectEClass, theEcorePackage.getEBigInteger(), "getBigInteger");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");

    op = addEOperation(dataObjectEClass, ecorePackage.getEBoolean(), "getBoolean");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");

    op = addEOperation(dataObjectEClass, ecorePackage.getEByte(), "getByte");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");

    op = addEOperation(dataObjectEClass, theEcorePackage.getEByteArray(), "getBytes");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");

    op = addEOperation(dataObjectEClass, ecorePackage.getEChar(), "getChar");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");

    op = addEOperation(dataObjectEClass, this.getDataObject(), "getDataObject");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");

    op = addEOperation(dataObjectEClass, theEcorePackage.getEDate(), "getDate");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");

    op = addEOperation(dataObjectEClass, ecorePackage.getEDouble(), "getDouble");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");

    op = addEOperation(dataObjectEClass, ecorePackage.getEFloat(), "getFloat");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");

    op = addEOperation(dataObjectEClass, ecorePackage.getEInt(), "getInt");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");

    op = addEOperation(dataObjectEClass, this.getEJavaList(), "getList");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");

    op = addEOperation(dataObjectEClass, ecorePackage.getELong(), "getLong");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");

    op = addEOperation(dataObjectEClass, this.getSequence(), "getSequence");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");

    op = addEOperation(dataObjectEClass, ecorePackage.getEShort(), "getShort");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");

    op = addEOperation(dataObjectEClass, ecorePackage.getEString(), "getString");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");

    op = addEOperation(dataObjectEClass, null, "setBigDecimal");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");
    addEParameter(op, theEcorePackage.getEBigDecimal(), "value");

    op = addEOperation(dataObjectEClass, null, "setBigInteger");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");
    addEParameter(op, theEcorePackage.getEBigInteger(), "value");

    op = addEOperation(dataObjectEClass, null, "setBoolean");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");
    addEParameter(op, ecorePackage.getEBoolean(), "value");

    op = addEOperation(dataObjectEClass, null, "setByte");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");
    addEParameter(op, ecorePackage.getEByte(), "value");

    op = addEOperation(dataObjectEClass, null, "setBytes");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");
    addEParameter(op, theEcorePackage.getEByteArray(), "value");

    op = addEOperation(dataObjectEClass, null, "setChar");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");
    addEParameter(op, ecorePackage.getEChar(), "value");

    op = addEOperation(dataObjectEClass, null, "setDataObject");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");
    addEParameter(op, this.getDataObject(), "value");

    op = addEOperation(dataObjectEClass, null, "setDate");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");
    addEParameter(op, theEcorePackage.getEDate(), "value");

    op = addEOperation(dataObjectEClass, null, "setDouble");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");
    addEParameter(op, ecorePackage.getEDouble(), "value");

    op = addEOperation(dataObjectEClass, null, "setFloat");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");
    addEParameter(op, ecorePackage.getEFloat(), "value");

    op = addEOperation(dataObjectEClass, null, "setInt");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");
    addEParameter(op, ecorePackage.getEInt(), "value");

    op = addEOperation(dataObjectEClass, null, "setList");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");
    addEParameter(op, this.getEJavaList(), "value");

    op = addEOperation(dataObjectEClass, null, "setLong");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");
    addEParameter(op, ecorePackage.getELong(), "value");

    op = addEOperation(dataObjectEClass, null, "setShort");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");
    addEParameter(op, ecorePackage.getEShort(), "value");

    op = addEOperation(dataObjectEClass, null, "setString");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");
    addEParameter(op, ecorePackage.getEString(), "value");

    op = addEOperation(dataObjectEClass, theEcorePackage.getEBigDecimal(), "getBigDecimal");
    addEParameter(op, this.getProperty(), "property");

    op = addEOperation(dataObjectEClass, theEcorePackage.getEBigInteger(), "getBigInteger");
    addEParameter(op, this.getProperty(), "property");

    op = addEOperation(dataObjectEClass, ecorePackage.getEBoolean(), "getBoolean");
    addEParameter(op, this.getProperty(), "property");

    op = addEOperation(dataObjectEClass, ecorePackage.getEByte(), "getByte");
    addEParameter(op, this.getProperty(), "property");

    op = addEOperation(dataObjectEClass, theEcorePackage.getEByteArray(), "getBytes");
    addEParameter(op, this.getProperty(), "property");

    op = addEOperation(dataObjectEClass, ecorePackage.getEChar(), "getChar");
    addEParameter(op, this.getProperty(), "property");

    op = addEOperation(dataObjectEClass, this.getDataObject(), "getDataObject");
    addEParameter(op, this.getProperty(), "property");

    op = addEOperation(dataObjectEClass, theEcorePackage.getEDate(), "getDate");
    addEParameter(op, this.getProperty(), "property");

    op = addEOperation(dataObjectEClass, ecorePackage.getEDouble(), "getDouble");
    addEParameter(op, this.getProperty(), "property");

    op = addEOperation(dataObjectEClass, ecorePackage.getEFloat(), "getFloat");
    addEParameter(op, this.getProperty(), "property");

    op = addEOperation(dataObjectEClass, ecorePackage.getEInt(), "getInt");
    addEParameter(op, this.getProperty(), "property");

    op = addEOperation(dataObjectEClass, this.getEJavaList(), "getList");
    addEParameter(op, this.getProperty(), "property");

    op = addEOperation(dataObjectEClass, ecorePackage.getELong(), "getLong");
    addEParameter(op, this.getProperty(), "property");

    op = addEOperation(dataObjectEClass, this.getSequence(), "getSequence");
    addEParameter(op, this.getProperty(), "property");

    op = addEOperation(dataObjectEClass, ecorePackage.getEShort(), "getShort");
    addEParameter(op, this.getProperty(), "property");

    op = addEOperation(dataObjectEClass, ecorePackage.getEString(), "getString");
    addEParameter(op, this.getProperty(), "property");

    op = addEOperation(dataObjectEClass, null, "setBigDecimal");
    addEParameter(op, this.getProperty(), "property");
    addEParameter(op, theEcorePackage.getEBigDecimal(), "value");

    op = addEOperation(dataObjectEClass, null, "setBigInteger");
    addEParameter(op, this.getProperty(), "property");
    addEParameter(op, theEcorePackage.getEBigInteger(), "value");

    op = addEOperation(dataObjectEClass, null, "setBoolean");
    addEParameter(op, this.getProperty(), "property");
    addEParameter(op, ecorePackage.getEBoolean(), "value");

    op = addEOperation(dataObjectEClass, null, "setByte");
    addEParameter(op, this.getProperty(), "property");
    addEParameter(op, ecorePackage.getEByte(), "value");

    op = addEOperation(dataObjectEClass, null, "setBytes");
    addEParameter(op, this.getProperty(), "property");
    addEParameter(op, theEcorePackage.getEByteArray(), "value");

    op = addEOperation(dataObjectEClass, null, "setChar");
    addEParameter(op, this.getProperty(), "property");
    addEParameter(op, ecorePackage.getEChar(), "value");

    op = addEOperation(dataObjectEClass, null, "setDataObject");
    addEParameter(op, this.getProperty(), "property");
    addEParameter(op, this.getDataObject(), "value");

    op = addEOperation(dataObjectEClass, null, "setDate");
    addEParameter(op, this.getProperty(), "property");
    addEParameter(op, theEcorePackage.getEDate(), "value");

    op = addEOperation(dataObjectEClass, null, "setDouble");
    addEParameter(op, this.getProperty(), "property");
    addEParameter(op, ecorePackage.getEDouble(), "value");

    op = addEOperation(dataObjectEClass, null, "setFloat");
    addEParameter(op, this.getProperty(), "property");
    addEParameter(op, ecorePackage.getEFloat(), "value");

    op = addEOperation(dataObjectEClass, null, "setInt");
    addEParameter(op, this.getProperty(), "property");
    addEParameter(op, ecorePackage.getEInt(), "value");

    op = addEOperation(dataObjectEClass, null, "setList");
    addEParameter(op, this.getProperty(), "property");
    addEParameter(op, this.getEJavaList(), "value");

    op = addEOperation(dataObjectEClass, null, "setLong");
    addEParameter(op, this.getProperty(), "property");
    addEParameter(op, ecorePackage.getELong(), "value");

    op = addEOperation(dataObjectEClass, null, "setShort");
    addEParameter(op, this.getProperty(), "property");
    addEParameter(op, ecorePackage.getEShort(), "value");

    op = addEOperation(dataObjectEClass, null, "setString");
    addEParameter(op, this.getProperty(), "property");
    addEParameter(op, ecorePackage.getEString(), "value");

    op = addEOperation(dataObjectEClass, this.getDataObject(), "createDataObject");
    addEParameter(op, ecorePackage.getEString(), "propertyName");

    op = addEOperation(dataObjectEClass, this.getDataObject(), "createDataObject");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");

    op = addEOperation(dataObjectEClass, this.getDataObject(), "createDataObject");
    addEParameter(op, this.getProperty(), "property");

    op = addEOperation(dataObjectEClass, this.getDataObject(), "createDataObject");
    addEParameter(op, ecorePackage.getEString(), "propertyName");
    addEParameter(op, ecorePackage.getEString(), "namespaceURI");
    addEParameter(op, ecorePackage.getEString(), "typeName");

    op = addEOperation(dataObjectEClass, this.getDataObject(), "createDataObject");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");
    addEParameter(op, ecorePackage.getEString(), "namespaceURI");
    addEParameter(op, ecorePackage.getEString(), "typeName");

    op = addEOperation(dataObjectEClass, this.getDataObject(), "createDataObject");
    addEParameter(op, this.getProperty(), "property");
    addEParameter(op, this.getType(), "type");

    addEOperation(dataObjectEClass, null, "delete");

    addEOperation(dataObjectEClass, this.getSequence(), "getSequence");

    addEOperation(dataObjectEClass, this.getEJavaList(), "getInstanceProperties");

    op = addEOperation(dataObjectEClass, this.getProperty(), "getProperty");
    addEParameter(op, ecorePackage.getEString(), "propertyName");

    addEOperation(dataObjectEClass, this.getDataObject(), "getRootObject");

    addEOperation(dataObjectEClass, this.getChangeSummary(), "getChangeSummary");

    addEOperation(dataObjectEClass, null, "detach");

    initEClass(propertyEClass, Property.class, "Property", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

    addEOperation(propertyEClass, ecorePackage.getEString(), "getName");

    addEOperation(propertyEClass, this.getType(), "getType");

    addEOperation(propertyEClass, ecorePackage.getEBoolean(), "isMany");

    addEOperation(propertyEClass, ecorePackage.getEBoolean(), "isContainment");

    addEOperation(propertyEClass, ecorePackage.getEBoolean(), "isReadOnly");

    addEOperation(propertyEClass, this.getType(), "getContainingType");

    addEOperation(propertyEClass, this.getEJavaList(), "getAliasNames");

    addEOperation(propertyEClass, this.getProperty(), "getOpposite");

    addEOperation(propertyEClass, theEcorePackage.getEJavaObject(), "getDefault");

    initEClass(sequenceEClass, Sequence.class, "Sequence", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

    addEOperation(sequenceEClass, ecorePackage.getEInt(), "size");

    op = addEOperation(sequenceEClass, this.getProperty(), "getProperty");
    addEParameter(op, ecorePackage.getEInt(), "index");

    op = addEOperation(sequenceEClass, theEcorePackage.getEJavaObject(), "getValue");
    addEParameter(op, ecorePackage.getEInt(), "index");

    op = addEOperation(sequenceEClass, theEcorePackage.getEJavaObject(), "setValue");
    addEParameter(op, ecorePackage.getEInt(), "index");
    addEParameter(op, theEcorePackage.getEJavaObject(), "value");

    op = addEOperation(sequenceEClass, ecorePackage.getEBoolean(), "add");
    addEParameter(op, ecorePackage.getEString(), "propertyName");
    addEParameter(op, theEcorePackage.getEJavaObject(), "value");

    op = addEOperation(sequenceEClass, ecorePackage.getEBoolean(), "add");
    addEParameter(op, ecorePackage.getEInt(), "propertIndex");
    addEParameter(op, theEcorePackage.getEJavaObject(), "value");

    op = addEOperation(sequenceEClass, ecorePackage.getEBoolean(), "add");
    addEParameter(op, this.getProperty(), "property");
    addEParameter(op, theEcorePackage.getEJavaObject(), "value");

    op = addEOperation(sequenceEClass, null, "add");
    addEParameter(op, ecorePackage.getEInt(), "index");
    addEParameter(op, ecorePackage.getEString(), "propertyName");
    addEParameter(op, theEcorePackage.getEJavaObject(), "value");

    op = addEOperation(sequenceEClass, null, "add");
    addEParameter(op, ecorePackage.getEInt(), "index");
    addEParameter(op, ecorePackage.getEInt(), "propertyIndex");
    addEParameter(op, theEcorePackage.getEJavaObject(), "value");

    op = addEOperation(sequenceEClass, null, "add");
    addEParameter(op, ecorePackage.getEInt(), "index");
    addEParameter(op, this.getProperty(), "property");
    addEParameter(op, theEcorePackage.getEJavaObject(), "value");

    op = addEOperation(sequenceEClass, null, "add");
    addEParameter(op, ecorePackage.getEString(), "text");

    op = addEOperation(sequenceEClass, null, "add");
    addEParameter(op, ecorePackage.getEInt(), "index");
    addEParameter(op, ecorePackage.getEString(), "text");

    initEClass(typeEClass, Type.class, "Type", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

    addEOperation(typeEClass, ecorePackage.getEString(), "getName");

    addEOperation(typeEClass, ecorePackage.getEString(), "getURI");

    addEOperation(typeEClass, theEcorePackage.getEJavaClass(), "getInstanceClass");

    op = addEOperation(typeEClass, ecorePackage.getEBoolean(), "isInstance");
    addEParameter(op, theEcorePackage.getEJavaObject(), "object");

    addEOperation(typeEClass, ecorePackage.getEBoolean(), "isDataType");

    addEOperation(typeEClass, ecorePackage.getEBoolean(), "isSequenced");

    addEOperation(typeEClass, ecorePackage.getEBoolean(), "isOpen");

    addEOperation(typeEClass, ecorePackage.getEBoolean(), "isAbstract");

    addEOperation(typeEClass, this.getEJavaList(), "getBaseTypes");

    addEOperation(typeEClass, this.getEJavaList(), "getAliasNames");

    addEOperation(typeEClass, this.getEJavaList(), "getProperties");

    addEOperation(typeEClass, this.getEJavaList(), "getDeclaredProperties");

    op = addEOperation(typeEClass, this.getProperty(), "getProperty");
    addEParameter(op, ecorePackage.getEString(), "propertyName");

    initEClass(anyTypeDataObjectEClass, AnyTypeDataObject.class, "AnyTypeDataObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(simpleAnyTypeDataObjectEClass, SimpleAnyTypeDataObject.class, "SimpleAnyTypeDataObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(classEClass, Type.class, "Class", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

    initEClass(dataTypeEClass, Type.class, "DataType", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

    initEClass(attributeEClass, Property.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

    initEClass(referenceEClass, Property.class, "Reference", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

    initEClass(enumEClass, Type.class, "Enum", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

    initEClass(dynamicDataObjectEClass, DataObject.class, "DynamicDataObject", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

    initEClass(storeDataObjectEClass, DataObject.class, "StoreDataObject", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

    initEClass(dynamicStoreDataObjectEClass, DataObject.class, "DynamicStoreDataObject", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

    initEClass(extensibleDataObjectEClass, DataObject.class, "ExtensibleDataObject", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

    // Initialize data types
    initEDataType(eJavaListEDataType, List.class, "EJavaList", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(eObjectStreamExceptionEDataType, ObjectStreamException.class, "EObjectStreamException", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http://www.eclipse.org/emf/2002/GenModel
    createGenModelAnnotations();
    // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
    createExtendedMetaDataAnnotations();
  }

  /**
   * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createGenModelAnnotations()
  {
    String source = "http://www.eclipse.org/emf/2002/GenModel";		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(0), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.get(this, path);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(1), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.set(this, path, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(2), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.isSet(this, path);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(3), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.unset(this, path);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(4), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.get(this, propertyIndex);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(5), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.set(this, propertyIndex, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(6), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.isSet(this, propertyIndex);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(7), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.unset(this, propertyIndex);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(8), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.get(this, property);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(9), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.set(this, property, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(10), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.isSet(this, property);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(11), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.unset(this, property);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(12), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getContainer(this);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(13), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getContainmentProperty(this);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(14), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getDataGraph(this);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(15), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getType(this);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(16), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getBigDecimal(this, path);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(17), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getBigInteger(this, path);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(18), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getBoolean(this, path);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(19), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getByte(this, path);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(20), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getBytes(this, path);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(21), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getChar(this, path);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(22), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getDataObject(this, path);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(23), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getDate(this, path);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(24), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getDouble(this, path);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(25), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getFloat(this, path);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(26), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getInt(this, path);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(27), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getList(this, path);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(28), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getLong(this, path);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(29), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getSequence(this, path);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(30), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getShort(this, path);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(31), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getString(this, path);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(32), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setBigDecimal(this, path, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(33), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setBigInteger(this, path, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(34), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setBoolean(this, path, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(35), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setByte(this, path, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(36), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setBytes(this, path, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(37), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setChar(this, path, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(38), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setDataObject(this, path, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(39), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setDate(this, path, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(40), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setDouble(this, path, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(41), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setFloat(this, path, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(42), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setInt(this, path, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(43), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setList(this, path, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(44), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setLong(this, path, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(45), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setShort(this, path, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(46), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setString(this, path, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(47), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getBigDecimal(this, propertyIndex);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(48), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getBigInteger(this, propertyIndex);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(49), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getBoolean(this, propertyIndex);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(50), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getByte(this, propertyIndex);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(51), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getBytes(this, propertyIndex);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(52), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getChar(this, propertyIndex);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(53), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getDataObject(this, propertyIndex);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(54), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getDate(this, propertyIndex);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(55), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getDouble(this, propertyIndex);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(56), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getFloat(this, propertyIndex);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(57), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getInt(this, propertyIndex);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(58), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getList(this, propertyIndex);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(59), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getLong(this, propertyIndex);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(60), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getSequence(this, propertyIndex);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(61), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getShort(this, propertyIndex);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(62), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getString(this, propertyIndex);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(63), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setBigDecimal(this, propertyIndex, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(64), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setBigInteger(this, propertyIndex, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(65), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setBoolean(this, propertyIndex, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(66), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setByte(this, propertyIndex, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(67), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setBytes(this, propertyIndex, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(68), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setChar(this, propertyIndex, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(69), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setDataObject(this, propertyIndex, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(70), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setDate(this, propertyIndex, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(71), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setDouble(this, propertyIndex, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(72), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setFloat(this, propertyIndex, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(73), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setInt(this, propertyIndex, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(74), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setList(this, propertyIndex, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(75), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setLong(this, propertyIndex, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(76), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setShort(this, propertyIndex, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(77), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setString(this, propertyIndex, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(78), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getBigDecimal(this, property);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(79), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getBigInteger(this, property);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(80), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getBoolean(this, property);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(81), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getByte(this, property);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(82), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getBytes(this, property);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(83), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getChar(this, property);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(84), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getDataObject(this, property);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(85), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getDate(this, property);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(86), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getDouble(this, property);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(87), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getFloat(this, property);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(88), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getInt(this, property);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(89), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getList(this, property);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(90), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getLong(this, property);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(91), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getSequence(this, property);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(92), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getShort(this, property);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(93), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getString(this, property);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(94), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setBigDecimal(this, property, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(95), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setBigInteger(this, property, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(96), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setBoolean(this, property, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(97), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setByte(this, property, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(98), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setBytes(this, property, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(99), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setChar(this, property, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(100), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setDataObject(this, property, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(101), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setDate(this, property, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(102), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setDouble(this, property, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(103), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setFloat(this, property, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(104), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setInt(this, property, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(105), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setList(this, property, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(106), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setLong(this, property, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(107), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setShort(this, property, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(108), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.setString(this, property, value);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(109), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.createDataObject(this, propertyName);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(110), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.createDataObject(this, propertyIndex);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(111), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.createDataObject(this, property);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(112), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.createDataObject(this, propertyName, namespaceURI, typeName);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(113), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.createDataObject(this, propertyIndex, namespaceURI, typeName);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(114), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.createDataObject(this, property, type);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(115), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.delete(this);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(116), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getSequence(this);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(117), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getInstanceProperties(this);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(118), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getProperty(this, propertyName);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(119), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getRootObject(this);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(120), 
       source, 
       new String[] 
       {
       "body", "return <%org.apache.sdo.util.SDOUtil%>.getChangeSummary(this);"
       });		
    addAnnotation
      ((EOperation)dataObjectEClass.getEOperations().get(121), 
       source, 
       new String[] 
       {
       "body", "<%org.apache.sdo.util.SDOUtil%>.detach(this);"
       });		
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
      (anyTypeDataObjectEClass, 
       source, 
       new String[] 
       {
       "kind", "mixed"
       });		
    addAnnotation
      (simpleAnyTypeDataObjectEClass, 
       source, 
       new String[] 
       {
       "kind", "simple"
       });
  }

} //SDOPackageImpl
