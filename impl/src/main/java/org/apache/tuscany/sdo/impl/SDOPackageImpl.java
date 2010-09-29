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
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SDOPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
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
		SDOPackageImpl theSDOPackage = (SDOPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SDOPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SDOPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();
		ChangePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSDOPackage.createPackageContents();

		// Initialize created meta-data
		theSDOPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSDOPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SDOPackage.eNS_URI, theSDOPackage);
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
		ChangePackage theChangePackage = (ChangePackage)EPackage.Registry.INSTANCE.getEPackage(ChangePackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

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

		EOperation op = addEOperation(changeSummaryEClass, ecorePackage.getEBoolean(), "isCreated", 0, 1);
		addEParameter(op, this.getDataObject(), "dataObject", 0, 1);

		op = addEOperation(changeSummaryEClass, ecorePackage.getEBoolean(), "isDeleted", 0, 1);
		addEParameter(op, this.getDataObject(), "dataObject", 0, 1);

		op = addEOperation(changeSummaryEClass, this.getEJavaList(), "getOldValues", 0, 1);
		addEParameter(op, this.getDataObject(), "dataObject", 0, 1);

		op = addEOperation(changeSummaryEClass, ecorePackage.getEBoolean(), "isModified", 0, 1);
		addEParameter(op, this.getDataObject(), "dataObject", 0, 1);

		op = addEOperation(changeSummaryEClass, this.getChangeSummarySetting(), "getOldValue", 0, 1);
		addEParameter(op, this.getDataObject(), "dataObject", 0, 1);
		addEParameter(op, this.getProperty(), "property", 0, 1);

		op = addEOperation(changeSummaryEClass, this.getDataObject(), "getOldContainer", 0, 1);
		addEParameter(op, this.getDataObject(), "dataObject", 0, 1);

		op = addEOperation(changeSummaryEClass, this.getProperty(), "getOldContainmentProperty", 0, 1);
		addEParameter(op, this.getDataObject(), "dataObject", 0, 1);

		op = addEOperation(changeSummaryEClass, this.getSequence(), "getOldSequence", 0, 1);
		addEParameter(op, this.getDataObject(), "dataObject", 0, 1);

		addEOperation(changeSummaryEClass, null, "undoChanges");

		addEOperation(changeSummaryEClass, ecorePackage.getEBoolean(), "isLogging", 0, 1);

		addEOperation(changeSummaryEClass, this.getDataGraph(), "getDataGraph", 0, 1);

		addEOperation(changeSummaryEClass, this.getEJavaList(), "getChangedObjects", 0, 1);

		addEOperation(changeSummaryEClass, this.getDataObject(), "getRootObject", 0, 1);

		initEClass(changeSummarySettingEClass, ChangeSummary.Setting.class, "ChangeSummarySetting", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		addEOperation(changeSummarySettingEClass, ecorePackage.getEBoolean(), "isSet", 0, 1);

		addEOperation(changeSummarySettingEClass, theEcorePackage.getEJavaObject(), "getValue", 0, 1);

		addEOperation(changeSummarySettingEClass, this.getProperty(), "getProperty", 0, 1);

		initEClass(dataGraphEClass, DataGraph.class, "DataGraph", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataGraph_ResourceSet(), theEcorePackage.getEResourceSet(), "resourceSet", null, 0, 1, DataGraph.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataGraph_RootResource(), theEcorePackage.getEResource(), "rootResource", null, 0, 1, DataGraph.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDataGraph_EChangeSummary(), this.getChangeSummary(), this.getChangeSummary_EDataGraph(), "eChangeSummary", null, 1, 1, DataGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataGraph_ERootObject(), theEcorePackage.getEObject(), null, "eRootObject", null, 1, 1, DataGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(dataGraphEClass, this.getDataObject(), "createRootObject", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "namespaceURI", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "typeName", 0, 1);

		op = addEOperation(dataGraphEClass, this.getDataObject(), "createRootObject", 0, 1);
		addEParameter(op, this.getType(), "type", 0, 1);

		op = addEOperation(dataGraphEClass, this.getType(), "getType", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "namespaceURI", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "typeName", 0, 1);

		addEOperation(dataGraphEClass, this.getDataObject(), "getRootObject", 0, 1);

		addEOperation(dataGraphEClass, this.getChangeSummary(), "getChangeSummary", 0, 1);

		initEClass(dataObjectEClass, DataObject.class, "DataObject", IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(dataObjectEClass, theEcorePackage.getEJavaObject(), "get", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);

		op = addEOperation(dataObjectEClass, null, "set");
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);
		addEParameter(op, theEcorePackage.getEJavaObject(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEBoolean(), "isSet", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);

		op = addEOperation(dataObjectEClass, null, "unset");
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);

		op = addEOperation(dataObjectEClass, theEcorePackage.getEJavaObject(), "get", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);

		op = addEOperation(dataObjectEClass, null, "set");
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);
		addEParameter(op, theEcorePackage.getEJavaObject(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEBoolean(), "isSet", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);

		op = addEOperation(dataObjectEClass, null, "unset");
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);

		op = addEOperation(dataObjectEClass, theEcorePackage.getEJavaObject(), "get", 0, 1);
		addEParameter(op, this.getProperty(), "property", 0, 1);

		op = addEOperation(dataObjectEClass, null, "set");
		addEParameter(op, this.getProperty(), "property", 0, 1);
		addEParameter(op, theEcorePackage.getEJavaObject(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEBoolean(), "isSet", 0, 1);
		addEParameter(op, this.getProperty(), "property", 0, 1);

		op = addEOperation(dataObjectEClass, null, "unset");
		addEParameter(op, this.getProperty(), "property", 0, 1);

		addEOperation(dataObjectEClass, this.getDataObject(), "getContainer", 0, 1);

		addEOperation(dataObjectEClass, this.getProperty(), "getContainmentProperty", 0, 1);

		addEOperation(dataObjectEClass, this.getDataGraph(), "getDataGraph", 0, 1);

		addEOperation(dataObjectEClass, this.getType(), "getType", 0, 1);

		op = addEOperation(dataObjectEClass, theEcorePackage.getEBigDecimal(), "getBigDecimal", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);

		op = addEOperation(dataObjectEClass, theEcorePackage.getEBigInteger(), "getBigInteger", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEBoolean(), "getBoolean", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEByte(), "getByte", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);

		op = addEOperation(dataObjectEClass, theEcorePackage.getEByteArray(), "getBytes", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEChar(), "getChar", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);

		op = addEOperation(dataObjectEClass, this.getDataObject(), "getDataObject", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);

		op = addEOperation(dataObjectEClass, theEcorePackage.getEDate(), "getDate", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEDouble(), "getDouble", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEFloat(), "getFloat", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEInt(), "getInt", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);

		op = addEOperation(dataObjectEClass, this.getEJavaList(), "getList", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getELong(), "getLong", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);

		op = addEOperation(dataObjectEClass, this.getSequence(), "getSequence", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEShort(), "getShort", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEString(), "getString", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setBigDecimal");
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);
		addEParameter(op, theEcorePackage.getEBigDecimal(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setBigInteger");
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);
		addEParameter(op, theEcorePackage.getEBigInteger(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setBoolean");
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);
		addEParameter(op, ecorePackage.getEBoolean(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setByte");
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);
		addEParameter(op, ecorePackage.getEByte(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setBytes");
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);
		addEParameter(op, theEcorePackage.getEByteArray(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setChar");
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);
		addEParameter(op, ecorePackage.getEChar(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setDataObject");
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);
		addEParameter(op, this.getDataObject(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setDate");
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);
		addEParameter(op, theEcorePackage.getEDate(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setDouble");
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);
		addEParameter(op, ecorePackage.getEDouble(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setFloat");
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);
		addEParameter(op, ecorePackage.getEFloat(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setInt");
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setList");
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);
		addEParameter(op, this.getEJavaList(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setLong");
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);
		addEParameter(op, ecorePackage.getELong(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setShort");
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);
		addEParameter(op, ecorePackage.getEShort(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setString");
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, theEcorePackage.getEBigDecimal(), "getBigDecimal", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);

		op = addEOperation(dataObjectEClass, theEcorePackage.getEBigInteger(), "getBigInteger", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEBoolean(), "getBoolean", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEByte(), "getByte", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);

		op = addEOperation(dataObjectEClass, theEcorePackage.getEByteArray(), "getBytes", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEChar(), "getChar", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);

		op = addEOperation(dataObjectEClass, this.getDataObject(), "getDataObject", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);

		op = addEOperation(dataObjectEClass, theEcorePackage.getEDate(), "getDate", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEDouble(), "getDouble", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEFloat(), "getFloat", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEInt(), "getInt", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);

		op = addEOperation(dataObjectEClass, this.getEJavaList(), "getList", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getELong(), "getLong", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);

		op = addEOperation(dataObjectEClass, this.getSequence(), "getSequence", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEShort(), "getShort", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEString(), "getString", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setBigDecimal");
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);
		addEParameter(op, theEcorePackage.getEBigDecimal(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setBigInteger");
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);
		addEParameter(op, theEcorePackage.getEBigInteger(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setBoolean");
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);
		addEParameter(op, ecorePackage.getEBoolean(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setByte");
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);
		addEParameter(op, ecorePackage.getEByte(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setBytes");
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);
		addEParameter(op, theEcorePackage.getEByteArray(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setChar");
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);
		addEParameter(op, ecorePackage.getEChar(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setDataObject");
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);
		addEParameter(op, this.getDataObject(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setDate");
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);
		addEParameter(op, theEcorePackage.getEDate(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setDouble");
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);
		addEParameter(op, ecorePackage.getEDouble(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setFloat");
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);
		addEParameter(op, ecorePackage.getEFloat(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setInt");
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setList");
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);
		addEParameter(op, this.getEJavaList(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setLong");
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);
		addEParameter(op, ecorePackage.getELong(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setShort");
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);
		addEParameter(op, ecorePackage.getEShort(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setString");
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, theEcorePackage.getEBigDecimal(), "getBigDecimal", 0, 1);
		addEParameter(op, this.getProperty(), "property", 0, 1);

		op = addEOperation(dataObjectEClass, theEcorePackage.getEBigInteger(), "getBigInteger", 0, 1);
		addEParameter(op, this.getProperty(), "property", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEBoolean(), "getBoolean", 0, 1);
		addEParameter(op, this.getProperty(), "property", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEByte(), "getByte", 0, 1);
		addEParameter(op, this.getProperty(), "property", 0, 1);

		op = addEOperation(dataObjectEClass, theEcorePackage.getEByteArray(), "getBytes", 0, 1);
		addEParameter(op, this.getProperty(), "property", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEChar(), "getChar", 0, 1);
		addEParameter(op, this.getProperty(), "property", 0, 1);

		op = addEOperation(dataObjectEClass, this.getDataObject(), "getDataObject", 0, 1);
		addEParameter(op, this.getProperty(), "property", 0, 1);

		op = addEOperation(dataObjectEClass, theEcorePackage.getEDate(), "getDate", 0, 1);
		addEParameter(op, this.getProperty(), "property", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEDouble(), "getDouble", 0, 1);
		addEParameter(op, this.getProperty(), "property", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEFloat(), "getFloat", 0, 1);
		addEParameter(op, this.getProperty(), "property", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEInt(), "getInt", 0, 1);
		addEParameter(op, this.getProperty(), "property", 0, 1);

		op = addEOperation(dataObjectEClass, this.getEJavaList(), "getList", 0, 1);
		addEParameter(op, this.getProperty(), "property", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getELong(), "getLong", 0, 1);
		addEParameter(op, this.getProperty(), "property", 0, 1);

		op = addEOperation(dataObjectEClass, this.getSequence(), "getSequence", 0, 1);
		addEParameter(op, this.getProperty(), "property", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEShort(), "getShort", 0, 1);
		addEParameter(op, this.getProperty(), "property", 0, 1);

		op = addEOperation(dataObjectEClass, ecorePackage.getEString(), "getString", 0, 1);
		addEParameter(op, this.getProperty(), "property", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setBigDecimal");
		addEParameter(op, this.getProperty(), "property", 0, 1);
		addEParameter(op, theEcorePackage.getEBigDecimal(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setBigInteger");
		addEParameter(op, this.getProperty(), "property", 0, 1);
		addEParameter(op, theEcorePackage.getEBigInteger(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setBoolean");
		addEParameter(op, this.getProperty(), "property", 0, 1);
		addEParameter(op, ecorePackage.getEBoolean(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setByte");
		addEParameter(op, this.getProperty(), "property", 0, 1);
		addEParameter(op, ecorePackage.getEByte(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setBytes");
		addEParameter(op, this.getProperty(), "property", 0, 1);
		addEParameter(op, theEcorePackage.getEByteArray(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setChar");
		addEParameter(op, this.getProperty(), "property", 0, 1);
		addEParameter(op, ecorePackage.getEChar(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setDataObject");
		addEParameter(op, this.getProperty(), "property", 0, 1);
		addEParameter(op, this.getDataObject(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setDate");
		addEParameter(op, this.getProperty(), "property", 0, 1);
		addEParameter(op, theEcorePackage.getEDate(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setDouble");
		addEParameter(op, this.getProperty(), "property", 0, 1);
		addEParameter(op, ecorePackage.getEDouble(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setFloat");
		addEParameter(op, this.getProperty(), "property", 0, 1);
		addEParameter(op, ecorePackage.getEFloat(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setInt");
		addEParameter(op, this.getProperty(), "property", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setList");
		addEParameter(op, this.getProperty(), "property", 0, 1);
		addEParameter(op, this.getEJavaList(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setLong");
		addEParameter(op, this.getProperty(), "property", 0, 1);
		addEParameter(op, ecorePackage.getELong(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setShort");
		addEParameter(op, this.getProperty(), "property", 0, 1);
		addEParameter(op, ecorePackage.getEShort(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, null, "setString");
		addEParameter(op, this.getProperty(), "property", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "value", 0, 1);

		op = addEOperation(dataObjectEClass, this.getDataObject(), "createDataObject", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "propertyName", 0, 1);

		op = addEOperation(dataObjectEClass, this.getDataObject(), "createDataObject", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);

		op = addEOperation(dataObjectEClass, this.getDataObject(), "createDataObject", 0, 1);
		addEParameter(op, this.getProperty(), "property", 0, 1);

		op = addEOperation(dataObjectEClass, this.getDataObject(), "createDataObject", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "propertyName", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "namespaceURI", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "typeName", 0, 1);

		op = addEOperation(dataObjectEClass, this.getDataObject(), "createDataObject", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "namespaceURI", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "typeName", 0, 1);

		op = addEOperation(dataObjectEClass, this.getDataObject(), "createDataObject", 0, 1);
		addEParameter(op, this.getProperty(), "property", 0, 1);
		addEParameter(op, this.getType(), "type", 0, 1);

		addEOperation(dataObjectEClass, null, "delete");

		addEOperation(dataObjectEClass, this.getSequence(), "getSequence", 0, 1);

		addEOperation(dataObjectEClass, this.getEJavaList(), "getInstanceProperties", 0, 1);

		op = addEOperation(dataObjectEClass, this.getProperty(), "getProperty", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "propertyName", 0, 1);

		addEOperation(dataObjectEClass, this.getDataObject(), "getRootObject", 0, 1);

		addEOperation(dataObjectEClass, this.getChangeSummary(), "getChangeSummary", 0, 1);

		addEOperation(dataObjectEClass, null, "detach");

		initEClass(propertyEClass, Property.class, "Property", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		addEOperation(propertyEClass, ecorePackage.getEString(), "getName", 0, 1);

		addEOperation(propertyEClass, this.getType(), "getType", 0, 1);

		addEOperation(propertyEClass, ecorePackage.getEBoolean(), "isMany", 0, 1);

		addEOperation(propertyEClass, ecorePackage.getEBoolean(), "isContainment", 0, 1);

		addEOperation(propertyEClass, ecorePackage.getEBoolean(), "isReadOnly", 0, 1);

		addEOperation(propertyEClass, this.getType(), "getContainingType", 0, 1);

		addEOperation(propertyEClass, this.getEJavaList(), "getAliasNames", 0, 1);

		addEOperation(propertyEClass, this.getProperty(), "getOpposite", 0, 1);

		addEOperation(propertyEClass, theEcorePackage.getEJavaObject(), "getDefault", 0, 1);

		initEClass(sequenceEClass, Sequence.class, "Sequence", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		addEOperation(sequenceEClass, ecorePackage.getEInt(), "size", 0, 1);

		op = addEOperation(sequenceEClass, this.getProperty(), "getProperty", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1);

		op = addEOperation(sequenceEClass, theEcorePackage.getEJavaObject(), "getValue", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1);

		op = addEOperation(sequenceEClass, theEcorePackage.getEJavaObject(), "setValue", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1);
		addEParameter(op, theEcorePackage.getEJavaObject(), "value", 0, 1);

		op = addEOperation(sequenceEClass, ecorePackage.getEBoolean(), "add", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "propertyName", 0, 1);
		addEParameter(op, theEcorePackage.getEJavaObject(), "value", 0, 1);

		op = addEOperation(sequenceEClass, ecorePackage.getEBoolean(), "add", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "propertIndex", 0, 1);
		addEParameter(op, theEcorePackage.getEJavaObject(), "value", 0, 1);

		op = addEOperation(sequenceEClass, ecorePackage.getEBoolean(), "add", 0, 1);
		addEParameter(op, this.getProperty(), "property", 0, 1);
		addEParameter(op, theEcorePackage.getEJavaObject(), "value", 0, 1);

		op = addEOperation(sequenceEClass, null, "add");
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "propertyName", 0, 1);
		addEParameter(op, theEcorePackage.getEJavaObject(), "value", 0, 1);

		op = addEOperation(sequenceEClass, null, "add");
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1);
		addEParameter(op, ecorePackage.getEInt(), "propertyIndex", 0, 1);
		addEParameter(op, theEcorePackage.getEJavaObject(), "value", 0, 1);

		op = addEOperation(sequenceEClass, null, "add");
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1);
		addEParameter(op, this.getProperty(), "property", 0, 1);
		addEParameter(op, theEcorePackage.getEJavaObject(), "value", 0, 1);

		op = addEOperation(sequenceEClass, null, "add");
		addEParameter(op, ecorePackage.getEString(), "text", 0, 1);

		op = addEOperation(sequenceEClass, null, "add");
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "text", 0, 1);

		initEClass(typeEClass, Type.class, "Type", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		addEOperation(typeEClass, ecorePackage.getEString(), "getName", 0, 1);

		addEOperation(typeEClass, ecorePackage.getEString(), "getURI", 0, 1);

		addEOperation(typeEClass, theEcorePackage.getEJavaClass(), "getInstanceClass", 0, 1);

		op = addEOperation(typeEClass, ecorePackage.getEBoolean(), "isInstance", 0, 1);
		addEParameter(op, theEcorePackage.getEJavaObject(), "object", 0, 1);

		addEOperation(typeEClass, ecorePackage.getEBoolean(), "isDataType", 0, 1);

		addEOperation(typeEClass, ecorePackage.getEBoolean(), "isSequenced", 0, 1);

		addEOperation(typeEClass, ecorePackage.getEBoolean(), "isOpen", 0, 1);

		addEOperation(typeEClass, ecorePackage.getEBoolean(), "isAbstract", 0, 1);

		addEOperation(typeEClass, this.getEJavaList(), "getBaseTypes", 0, 1);

		addEOperation(typeEClass, this.getEJavaList(), "getAliasNames", 0, 1);

		addEOperation(typeEClass, this.getEJavaList(), "getProperties", 0, 1);

		addEOperation(typeEClass, this.getEJavaList(), "getDeclaredProperties", 0, 1);

		op = addEOperation(typeEClass, this.getProperty(), "getProperty", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "propertyName", 0, 1);

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
		  (anyTypeDataObjectEClass, 
		   source, 
		   new String[] {
			 "kind", "mixed"
		   });		
		addAnnotation
		  (simpleAnyTypeDataObjectEClass, 
		   source, 
		   new String[] {
			 "kind", "simple"
		   });
	}

} //SDOPackageImpl
