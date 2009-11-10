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
package org.apache.tuscany.sdo;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.change.ChangePackage;

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
 * @see org.apache.tuscany.sdo.SDOFactory
 * @model kind="package"
 * @generated
 */
public interface SDOPackage extends EPackage{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "sdo";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.apache.org/tuscany/2005/SDO";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "sdo";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SDOPackage eINSTANCE = org.apache.tuscany.sdo.impl.SDOPackageImpl.init();

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.impl.DataGraphImpl <em>Data Graph</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.impl.DataGraphImpl
   * @see org.apache.tuscany.sdo.impl.SDOPackageImpl#getDataGraph()
   * @generated
   */
  int DATA_GRAPH = 2;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.impl.ChangeSummaryImpl <em>Change Summary</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.impl.ChangeSummaryImpl
   * @see org.apache.tuscany.sdo.impl.SDOPackageImpl#getChangeSummary()
   * @generated
   */
  int CHANGE_SUMMARY = 0;

  /**
   * The feature id for the '<em><b>Object Changes</b></em>' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHANGE_SUMMARY__OBJECT_CHANGES = ChangePackage.CHANGE_DESCRIPTION__OBJECT_CHANGES;

  /**
   * The feature id for the '<em><b>Objects To Detach</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHANGE_SUMMARY__OBJECTS_TO_DETACH = ChangePackage.CHANGE_DESCRIPTION__OBJECTS_TO_DETACH;

  /**
   * The feature id for the '<em><b>Objects To Attach</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHANGE_SUMMARY__OBJECTS_TO_ATTACH = ChangePackage.CHANGE_DESCRIPTION__OBJECTS_TO_ATTACH;

  /**
   * The feature id for the '<em><b>Resource Changes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHANGE_SUMMARY__RESOURCE_CHANGES = ChangePackage.CHANGE_DESCRIPTION__RESOURCE_CHANGES;

  /**
   * The feature id for the '<em><b>EData Graph</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHANGE_SUMMARY__EDATA_GRAPH = ChangePackage.CHANGE_DESCRIPTION_FEATURE_COUNT + 0;

//TODO T-153 
//  /**
//   * The feature id for the '<em><b>EData Graph</b></em>' reference.
//   * <!-- begin-user-doc -->
//   * <!-- end-user-doc -->
//   * *handcrafted but could be generated
//   * @ordered
//   */
//  int CHANGE_SUMMARY__EDATA_OBJECT = ChangePackage.CHANGE_DESCRIPTION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Change Summary</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   * @ordered
   */
//TODO T-153 
  int CHANGE_SUMMARY_FEATURE_COUNT = ChangePackage.CHANGE_DESCRIPTION_FEATURE_COUNT + 1;
  //int CHANGE_SUMMARY_FEATURE_COUNT = ChangePackage.CHANGE_DESCRIPTION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.impl.ChangeSummarySettingImpl <em>Change Summary Setting</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.impl.ChangeSummarySettingImpl
   * @see org.apache.tuscany.sdo.impl.SDOPackageImpl#getChangeSummarySetting()
   * @generated
   */
  int CHANGE_SUMMARY_SETTING = 1;

  /**
   * The feature id for the '<em><b>Feature Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHANGE_SUMMARY_SETTING__FEATURE_NAME = ChangePackage.FEATURE_CHANGE__FEATURE_NAME;

  /**
   * The feature id for the '<em><b>Data Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHANGE_SUMMARY_SETTING__DATA_VALUE = ChangePackage.FEATURE_CHANGE__DATA_VALUE;

  /**
   * The feature id for the '<em><b>Set</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHANGE_SUMMARY_SETTING__SET = ChangePackage.FEATURE_CHANGE__SET;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHANGE_SUMMARY_SETTING__VALUE = ChangePackage.FEATURE_CHANGE__VALUE;

  /**
   * The feature id for the '<em><b>Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHANGE_SUMMARY_SETTING__FEATURE = ChangePackage.FEATURE_CHANGE__FEATURE;

  /**
   * The feature id for the '<em><b>Reference Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHANGE_SUMMARY_SETTING__REFERENCE_VALUE = ChangePackage.FEATURE_CHANGE__REFERENCE_VALUE;

  /**
   * The feature id for the '<em><b>List Changes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHANGE_SUMMARY_SETTING__LIST_CHANGES = ChangePackage.FEATURE_CHANGE__LIST_CHANGES;

  /**
   * The number of structural features of the '<em>Change Summary Setting</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHANGE_SUMMARY_SETTING_FEATURE_COUNT = ChangePackage.FEATURE_CHANGE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Resource Set</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_GRAPH__RESOURCE_SET = EcorePackage.EOBJECT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Root Resource</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_GRAPH__ROOT_RESOURCE = EcorePackage.EOBJECT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>EChange Summary</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_GRAPH__ECHANGE_SUMMARY = EcorePackage.EOBJECT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>ERoot Object</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_GRAPH__EROOT_OBJECT = EcorePackage.EOBJECT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Data Graph</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_GRAPH_FEATURE_COUNT = EcorePackage.EOBJECT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.impl.DataObjectImpl <em>Data Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.impl.DataObjectImpl
   * @see org.apache.tuscany.sdo.impl.SDOPackageImpl#getDataObject()
   * @generated
   */
  int DATA_OBJECT = 3;

  /**
   * The meta object id for the '{@link commonj.sdo.Property <em>Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see commonj.sdo.Property
   * @see org.apache.tuscany.sdo.impl.SDOPackageImpl#getProperty()
   * @generated
   */
  int PROPERTY = 4;

  /**
   * The meta object id for the '{@link commonj.sdo.Sequence <em>Sequence</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see commonj.sdo.Sequence
   * @see org.apache.tuscany.sdo.impl.SDOPackageImpl#getSequence()
   * @generated
   */
  int SEQUENCE = 5;

  /**
   * The meta object id for the '{@link commonj.sdo.Type <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see commonj.sdo.Type
   * @see org.apache.tuscany.sdo.impl.SDOPackageImpl#getType()
   * @generated
   */
  int TYPE = 6;

  /**
   * The number of structural features of the '<em>Data Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_OBJECT_FEATURE_COUNT = 0;

  /**
   * The number of structural features of the '<em>Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_FEATURE_COUNT = 0;

  /**
   * The number of structural features of the '<em>Sequence</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENCE_FEATURE_COUNT = 0;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.impl.AnyTypeDataObjectImpl <em>Any Type Data Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.impl.AnyTypeDataObjectImpl
   * @see org.apache.tuscany.sdo.impl.SDOPackageImpl#getAnyTypeDataObject()
   * @generated
   */
  int ANY_TYPE_DATA_OBJECT = 7;

  /**
   * The feature id for the '<em><b>Mixed</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANY_TYPE_DATA_OBJECT__MIXED = DATA_OBJECT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANY_TYPE_DATA_OBJECT__ANY = DATA_OBJECT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANY_TYPE_DATA_OBJECT__ANY_ATTRIBUTE = DATA_OBJECT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Any Type Data Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANY_TYPE_DATA_OBJECT_FEATURE_COUNT = DATA_OBJECT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.impl.SimpleAnyTypeDataObjectImpl <em>Simple Any Type Data Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.impl.SimpleAnyTypeDataObjectImpl
   * @see org.apache.tuscany.sdo.impl.SDOPackageImpl#getSimpleAnyTypeDataObject()
   * @generated
   */
  int SIMPLE_ANY_TYPE_DATA_OBJECT = 8;

  /**
   * The feature id for the '<em><b>Mixed</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_ANY_TYPE_DATA_OBJECT__MIXED = ANY_TYPE_DATA_OBJECT__MIXED;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_ANY_TYPE_DATA_OBJECT__ANY = ANY_TYPE_DATA_OBJECT__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_ANY_TYPE_DATA_OBJECT__ANY_ATTRIBUTE = ANY_TYPE_DATA_OBJECT__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Raw Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_ANY_TYPE_DATA_OBJECT__RAW_VALUE = ANY_TYPE_DATA_OBJECT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_ANY_TYPE_DATA_OBJECT__VALUE = ANY_TYPE_DATA_OBJECT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Instance Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_ANY_TYPE_DATA_OBJECT__INSTANCE_TYPE = ANY_TYPE_DATA_OBJECT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Simple Any Type Data Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_ANY_TYPE_DATA_OBJECT_FEATURE_COUNT = ANY_TYPE_DATA_OBJECT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.impl.ClassImpl <em>Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.impl.ClassImpl
   * @see org.apache.tuscany.sdo.impl.SDOPackageImpl#getClass_()
   * @generated
   */
  int CLASS = 9;

  /**
   * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__EANNOTATIONS = EcorePackage.ECLASS__EANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__NAME = EcorePackage.ECLASS__NAME;

  /**
   * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__INSTANCE_CLASS_NAME = EcorePackage.ECLASS__INSTANCE_CLASS_NAME;

  /**
   * The feature id for the '<em><b>Instance Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__INSTANCE_CLASS = EcorePackage.ECLASS__INSTANCE_CLASS;

  /**
   * The feature id for the '<em><b>Default Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__DEFAULT_VALUE = EcorePackage.ECLASS__DEFAULT_VALUE;

  /**
   * The feature id for the '<em><b>EPackage</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__EPACKAGE = EcorePackage.ECLASS__EPACKAGE;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__ABSTRACT = EcorePackage.ECLASS__ABSTRACT;

  /**
   * The feature id for the '<em><b>Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__INTERFACE = EcorePackage.ECLASS__INTERFACE;

  /**
   * The feature id for the '<em><b>ESuper Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__ESUPER_TYPES = EcorePackage.ECLASS__ESUPER_TYPES;

  /**
   * The feature id for the '<em><b>EOperations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__EOPERATIONS = EcorePackage.ECLASS__EOPERATIONS;

  /**
   * The feature id for the '<em><b>EAll Attributes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__EALL_ATTRIBUTES = EcorePackage.ECLASS__EALL_ATTRIBUTES;

  /**
   * The feature id for the '<em><b>EAll References</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__EALL_REFERENCES = EcorePackage.ECLASS__EALL_REFERENCES;

  /**
   * The feature id for the '<em><b>EReferences</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__EREFERENCES = EcorePackage.ECLASS__EREFERENCES;

  /**
   * The feature id for the '<em><b>EAttributes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__EATTRIBUTES = EcorePackage.ECLASS__EATTRIBUTES;

  /**
   * The feature id for the '<em><b>EAll Containments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__EALL_CONTAINMENTS = EcorePackage.ECLASS__EALL_CONTAINMENTS;

  /**
   * The feature id for the '<em><b>EAll Operations</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__EALL_OPERATIONS = EcorePackage.ECLASS__EALL_OPERATIONS;

  /**
   * The feature id for the '<em><b>EAll Structural Features</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__EALL_STRUCTURAL_FEATURES = EcorePackage.ECLASS__EALL_STRUCTURAL_FEATURES;

  /**
   * The feature id for the '<em><b>EAll Super Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__EALL_SUPER_TYPES = EcorePackage.ECLASS__EALL_SUPER_TYPES;

  /**
   * The feature id for the '<em><b>EID Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__EID_ATTRIBUTE = EcorePackage.ECLASS__EID_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>EStructural Features</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__ESTRUCTURAL_FEATURES = EcorePackage.ECLASS__ESTRUCTURAL_FEATURES;

  /**
   * The number of structural features of the '<em>Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_FEATURE_COUNT = EcorePackage.ECLASS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.impl.DataTypeImpl <em>Data Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.impl.DataTypeImpl
   * @see org.apache.tuscany.sdo.impl.SDOPackageImpl#getDataType()
   * @generated
   */
  int DATA_TYPE = 10;

  /**
   * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE__EANNOTATIONS = EcorePackage.EDATA_TYPE__EANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE__NAME = EcorePackage.EDATA_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE__INSTANCE_CLASS_NAME = EcorePackage.EDATA_TYPE__INSTANCE_CLASS_NAME;

  /**
   * The feature id for the '<em><b>Instance Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE__INSTANCE_CLASS = EcorePackage.EDATA_TYPE__INSTANCE_CLASS;

  /**
   * The feature id for the '<em><b>Default Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE__DEFAULT_VALUE = EcorePackage.EDATA_TYPE__DEFAULT_VALUE;

  /**
   * The feature id for the '<em><b>EPackage</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE__EPACKAGE = EcorePackage.EDATA_TYPE__EPACKAGE;

  /**
   * The feature id for the '<em><b>Serializable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE__SERIALIZABLE = EcorePackage.EDATA_TYPE__SERIALIZABLE;

  /**
   * The number of structural features of the '<em>Data Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE_FEATURE_COUNT = EcorePackage.EDATA_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.impl.AttributeImpl
   * @see org.apache.tuscany.sdo.impl.SDOPackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 11;

  /**
   * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__EANNOTATIONS = EcorePackage.EATTRIBUTE__EANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__NAME = EcorePackage.EATTRIBUTE__NAME;

  /**
   * The feature id for the '<em><b>Ordered</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__ORDERED = EcorePackage.EATTRIBUTE__ORDERED;

  /**
   * The feature id for the '<em><b>Unique</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__UNIQUE = EcorePackage.EATTRIBUTE__UNIQUE;

  /**
   * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__LOWER_BOUND = EcorePackage.EATTRIBUTE__LOWER_BOUND;

  /**
   * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__UPPER_BOUND = EcorePackage.EATTRIBUTE__UPPER_BOUND;

  /**
   * The feature id for the '<em><b>Many</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__MANY = EcorePackage.EATTRIBUTE__MANY;

  /**
   * The feature id for the '<em><b>Required</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__REQUIRED = EcorePackage.EATTRIBUTE__REQUIRED;

  /**
   * The feature id for the '<em><b>EType</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__ETYPE = EcorePackage.EATTRIBUTE__ETYPE;

  /**
   * The feature id for the '<em><b>Changeable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__CHANGEABLE = EcorePackage.EATTRIBUTE__CHANGEABLE;

  /**
   * The feature id for the '<em><b>Volatile</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__VOLATILE = EcorePackage.EATTRIBUTE__VOLATILE;

  /**
   * The feature id for the '<em><b>Transient</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__TRANSIENT = EcorePackage.EATTRIBUTE__TRANSIENT;

  /**
   * The feature id for the '<em><b>Default Value Literal</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__DEFAULT_VALUE_LITERAL = EcorePackage.EATTRIBUTE__DEFAULT_VALUE_LITERAL;

  /**
   * The feature id for the '<em><b>Default Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__DEFAULT_VALUE = EcorePackage.EATTRIBUTE__DEFAULT_VALUE;

  /**
   * The feature id for the '<em><b>Unsettable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__UNSETTABLE = EcorePackage.EATTRIBUTE__UNSETTABLE;

  /**
   * The feature id for the '<em><b>Derived</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__DERIVED = EcorePackage.EATTRIBUTE__DERIVED;

  /**
   * The feature id for the '<em><b>EContaining Class</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__ECONTAINING_CLASS = EcorePackage.EATTRIBUTE__ECONTAINING_CLASS;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__ID = EcorePackage.EATTRIBUTE__ID;

  /**
   * The feature id for the '<em><b>EAttribute Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__EATTRIBUTE_TYPE = EcorePackage.EATTRIBUTE__EATTRIBUTE_TYPE;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = EcorePackage.EATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.impl.ReferenceImpl <em>Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.impl.ReferenceImpl
   * @see org.apache.tuscany.sdo.impl.SDOPackageImpl#getReference()
   * @generated
   */
  int REFERENCE = 12;

  /**
   * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__EANNOTATIONS = EcorePackage.EREFERENCE__EANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__NAME = EcorePackage.EREFERENCE__NAME;

  /**
   * The feature id for the '<em><b>Ordered</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__ORDERED = EcorePackage.EREFERENCE__ORDERED;

  /**
   * The feature id for the '<em><b>Unique</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__UNIQUE = EcorePackage.EREFERENCE__UNIQUE;

  /**
   * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__LOWER_BOUND = EcorePackage.EREFERENCE__LOWER_BOUND;

  /**
   * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__UPPER_BOUND = EcorePackage.EREFERENCE__UPPER_BOUND;

  /**
   * The feature id for the '<em><b>Many</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__MANY = EcorePackage.EREFERENCE__MANY;

  /**
   * The feature id for the '<em><b>Required</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__REQUIRED = EcorePackage.EREFERENCE__REQUIRED;

  /**
   * The feature id for the '<em><b>EType</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__ETYPE = EcorePackage.EREFERENCE__ETYPE;

  /**
   * The feature id for the '<em><b>Changeable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__CHANGEABLE = EcorePackage.EREFERENCE__CHANGEABLE;

  /**
   * The feature id for the '<em><b>Volatile</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__VOLATILE = EcorePackage.EREFERENCE__VOLATILE;

  /**
   * The feature id for the '<em><b>Transient</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__TRANSIENT = EcorePackage.EREFERENCE__TRANSIENT;

  /**
   * The feature id for the '<em><b>Default Value Literal</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__DEFAULT_VALUE_LITERAL = EcorePackage.EREFERENCE__DEFAULT_VALUE_LITERAL;

  /**
   * The feature id for the '<em><b>Default Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__DEFAULT_VALUE = EcorePackage.EREFERENCE__DEFAULT_VALUE;

  /**
   * The feature id for the '<em><b>Unsettable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__UNSETTABLE = EcorePackage.EREFERENCE__UNSETTABLE;

  /**
   * The feature id for the '<em><b>Derived</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__DERIVED = EcorePackage.EREFERENCE__DERIVED;

  /**
   * The feature id for the '<em><b>EContaining Class</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__ECONTAINING_CLASS = EcorePackage.EREFERENCE__ECONTAINING_CLASS;

  /**
   * The feature id for the '<em><b>Containment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__CONTAINMENT = EcorePackage.EREFERENCE__CONTAINMENT;

  /**
   * The feature id for the '<em><b>Container</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__CONTAINER = EcorePackage.EREFERENCE__CONTAINER;

  /**
   * The feature id for the '<em><b>Resolve Proxies</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__RESOLVE_PROXIES = EcorePackage.EREFERENCE__RESOLVE_PROXIES;

  /**
   * The feature id for the '<em><b>EOpposite</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__EOPPOSITE = EcorePackage.EREFERENCE__EOPPOSITE;

  /**
   * The feature id for the '<em><b>EReference Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__EREFERENCE_TYPE = EcorePackage.EREFERENCE__EREFERENCE_TYPE;

  /**
   * The number of structural features of the '<em>Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_FEATURE_COUNT = EcorePackage.EREFERENCE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.impl.EnumImpl <em>Enum</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.impl.EnumImpl
   * @see org.apache.tuscany.sdo.impl.SDOPackageImpl#getEnum()
   * @generated
   */
  int ENUM = 13;

  /**
   * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM__EANNOTATIONS = EcorePackage.EENUM__EANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM__NAME = EcorePackage.EENUM__NAME;

  /**
   * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM__INSTANCE_CLASS_NAME = EcorePackage.EENUM__INSTANCE_CLASS_NAME;

  /**
   * The feature id for the '<em><b>Instance Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM__INSTANCE_CLASS = EcorePackage.EENUM__INSTANCE_CLASS;

  /**
   * The feature id for the '<em><b>Default Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM__DEFAULT_VALUE = EcorePackage.EENUM__DEFAULT_VALUE;

  /**
   * The feature id for the '<em><b>EPackage</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM__EPACKAGE = EcorePackage.EENUM__EPACKAGE;

  /**
   * The feature id for the '<em><b>Serializable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM__SERIALIZABLE = EcorePackage.EENUM__SERIALIZABLE;

  /**
   * The feature id for the '<em><b>ELiterals</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM__ELITERALS = EcorePackage.EENUM__ELITERALS;

  /**
   * The number of structural features of the '<em>Enum</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_FEATURE_COUNT = EcorePackage.EENUM_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.impl.DynamicDataObjectImpl <em>Dynamic Data Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.impl.DynamicDataObjectImpl
   * @see org.apache.tuscany.sdo.impl.SDOPackageImpl#getDynamicDataObject()
   * @generated
   */
  int DYNAMIC_DATA_OBJECT = 14;

  /**
   * The number of structural features of the '<em>Dynamic Data Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DYNAMIC_DATA_OBJECT_FEATURE_COUNT = DATA_OBJECT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.impl.StoreDataObjectImpl <em>Store Data Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.impl.StoreDataObjectImpl
   * @see org.apache.tuscany.sdo.impl.SDOPackageImpl#getStoreDataObject()
   * @generated
   */
  int STORE_DATA_OBJECT = 15;

  /**
   * The number of structural features of the '<em>Store Data Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORE_DATA_OBJECT_FEATURE_COUNT = DATA_OBJECT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.impl.DynamicStoreDataObjectImpl <em>Dynamic Store Data Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.impl.DynamicStoreDataObjectImpl
   * @see org.apache.tuscany.sdo.impl.SDOPackageImpl#getDynamicStoreDataObject()
   * @generated
   */
  int DYNAMIC_STORE_DATA_OBJECT = 16;

  /**
   * The number of structural features of the '<em>Dynamic Store Data Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DYNAMIC_STORE_DATA_OBJECT_FEATURE_COUNT = STORE_DATA_OBJECT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.impl.ExtensibleDataObjectImpl <em>Extensible Data Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.impl.ExtensibleDataObjectImpl
   * @see org.apache.tuscany.sdo.impl.SDOPackageImpl#getExtensibleDataObject()
   * @generated
   */
  int EXTENSIBLE_DATA_OBJECT = 17;

  /**
   * The number of structural features of the '<em>Extensible Data Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTENSIBLE_DATA_OBJECT_FEATURE_COUNT = DATA_OBJECT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '<em>EJava List</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.List
   * @see org.apache.tuscany.sdo.impl.SDOPackageImpl#getEJavaList()
   * @generated
   */
  int EJAVA_LIST = 18;

  /**
   * The meta object id for the '<em>EObject Stream Exception</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.io.ObjectStreamException
   * @see org.apache.tuscany.sdo.impl.SDOPackageImpl#getEObjectStreamException()
   * @generated
   */
  int EOBJECT_STREAM_EXCEPTION = 19;


  /**
   * Returns the meta object for class '{@link commonj.sdo.ChangeSummary <em>Change Summary</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Change Summary</em>'.
   * @see commonj.sdo.ChangeSummary
   * @model instanceClass="commonj.sdo.ChangeSummary"
   * @generated
   */
  EClass getChangeSummary();

  /**
   * Returns the meta object for the reference '{@link commonj.sdo.ChangeSummary#getEDataGraph <em>EData Graph</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>EData Graph</em>'.
   * @see commonj.sdo.ChangeSummary#getEDataGraph()
   * @see #getChangeSummary()
   * @generated
   */
  EReference getChangeSummary_EDataGraph();

// TODO T-153
//  /**
//   * Returns the meta object for the reference '{@link commonj.sdo.ChangeSummary#getEDataGraph <em>EData Graph</em>}'.
//   * <!-- begin-user-doc -->
//   * <!-- end-user-doc -->
//   * @return the meta object for the reference '<em>EData Graph</em>'.
//   * @see commonj.sdo.ChangeSummary#getEDataGraph()
//   * @see #getChangeSummary()
//   * *handcrafted but could be generated
//   */
//  EReference getChangeSummary_EDataObject();

  
  /**
   * Returns the meta object for class '{@link commonj.sdo.ChangeSummary.Setting <em>Change Summary Setting</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Change Summary Setting</em>'.
   * @see commonj.sdo.ChangeSummary.Setting
   * @model instanceClass="commonj.sdo.ChangeSummary$Setting"
   * @generated
   */
  EClass getChangeSummarySetting();

  /**
   * Returns the meta object for class '{@link commonj.sdo.DataGraph <em>Data Graph</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Data Graph</em>'.
   * @see commonj.sdo.DataGraph
   * @model instanceClass="commonj.sdo.DataGraph"
   * @generated
   */
  EClass getDataGraph();

  /**
   * Returns the meta object for the attribute '{@link commonj.sdo.DataGraph#getResourceSet <em>Resource Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Resource Set</em>'.
   * @see commonj.sdo.DataGraph#getResourceSet()
   * @see #getDataGraph()
   * @generated
   */
  EAttribute getDataGraph_ResourceSet();

  /**
   * Returns the meta object for the attribute '{@link commonj.sdo.DataGraph#getRootResource <em>Root Resource</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Root Resource</em>'.
   * @see commonj.sdo.DataGraph#getRootResource()
   * @see #getDataGraph()
   * @generated
   */
  EAttribute getDataGraph_RootResource();

  /**
   * Returns the meta object for the reference '{@link commonj.sdo.DataGraph#getEChangeSummary <em>EChange Summary</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>EChange Summary</em>'.
   * @see commonj.sdo.DataGraph#getEChangeSummary()
   * @see #getDataGraph()
   * @generated
   */
  EReference getDataGraph_EChangeSummary();

  /**
   * Returns the meta object for the reference '{@link commonj.sdo.DataGraph#getERootObject <em>ERoot Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>ERoot Object</em>'.
   * @see commonj.sdo.DataGraph#getERootObject()
   * @see #getDataGraph()
   * @generated
   */
  EReference getDataGraph_ERootObject();

  /**
   * Returns the meta object for class '{@link commonj.sdo.DataObject <em>Data Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Data Object</em>'.
   * @see commonj.sdo.DataObject
   * @model instanceClass="commonj.sdo.DataObject"
   * @generated
   */
  EClass getDataObject();

  /**
   * Returns the meta object for class '{@link commonj.sdo.Property <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property</em>'.
   * @see commonj.sdo.Property
   * @model instanceClass="commonj.sdo.Property"
   * @generated
   */
  EClass getProperty();

  /**
   * Returns the meta object for class '{@link commonj.sdo.Sequence <em>Sequence</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sequence</em>'.
   * @see commonj.sdo.Sequence
   * @model instanceClass="commonj.sdo.Sequence"
   * @generated
   */
  EClass getSequence();

  /**
   * Returns the meta object for class '{@link commonj.sdo.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see commonj.sdo.Type
   * @model instanceClass="commonj.sdo.Type"
   * @generated
   */
  EClass getType();

  /**
   * Returns the meta object for class '{@link org.apache.tuscany.sdo.AnyTypeDataObject <em>Any Type Data Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Any Type Data Object</em>'.
   * @see org.apache.tuscany.sdo.AnyTypeDataObject
   * @generated
   */
  EClass getAnyTypeDataObject();

  /**
   * Returns the meta object for class '{@link org.apache.tuscany.sdo.SimpleAnyTypeDataObject <em>Simple Any Type Data Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Any Type Data Object</em>'.
   * @see org.apache.tuscany.sdo.SimpleAnyTypeDataObject
   * @generated
   */
  EClass getSimpleAnyTypeDataObject();

  /**
   * Returns the meta object for class '{@link commonj.sdo.Type <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class</em>'.
   * @see commonj.sdo.Type
   * @model instanceClass="commonj.sdo.Type"
   * @generated
   */
  EClass getClass_();

  /**
   * Returns the meta object for class '{@link commonj.sdo.Type <em>Data Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Data Type</em>'.
   * @see commonj.sdo.Type
   * @model instanceClass="commonj.sdo.Type"
   * @generated
   */
  EClass getDataType();

  /**
   * Returns the meta object for class '{@link commonj.sdo.Property <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see commonj.sdo.Property
   * @model instanceClass="commonj.sdo.Property"
   * @generated
   */
  EClass getAttribute();

  /**
   * Returns the meta object for class '{@link commonj.sdo.Property <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference</em>'.
   * @see commonj.sdo.Property
   * @model instanceClass="commonj.sdo.Property"
   * @generated
   */
  EClass getReference();

  /**
   * Returns the meta object for class '{@link commonj.sdo.Type <em>Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum</em>'.
   * @see commonj.sdo.Type
   * @model instanceClass="commonj.sdo.Type"
   * @generated
   */
  EClass getEnum();

  /**
   * Returns the meta object for class '{@link commonj.sdo.DataObject <em>Dynamic Data Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dynamic Data Object</em>'.
   * @see commonj.sdo.DataObject
   * @model instanceClass="commonj.sdo.DataObject"
   * @generated
   */
  EClass getDynamicDataObject();

  /**
   * Returns the meta object for class '{@link commonj.sdo.DataObject <em>Store Data Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Store Data Object</em>'.
   * @see commonj.sdo.DataObject
   * @model instanceClass="commonj.sdo.DataObject"
   * @generated
   */
  EClass getStoreDataObject();

  /**
   * Returns the meta object for class '{@link commonj.sdo.DataObject <em>Dynamic Store Data Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dynamic Store Data Object</em>'.
   * @see commonj.sdo.DataObject
   * @model instanceClass="commonj.sdo.DataObject"
   * @generated
   */
  EClass getDynamicStoreDataObject();

  /**
   * Returns the meta object for class '{@link commonj.sdo.DataObject <em>Extensible Data Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Extensible Data Object</em>'.
   * @see commonj.sdo.DataObject
   * @model instanceClass="commonj.sdo.DataObject"
   * @generated
   */
  EClass getExtensibleDataObject();

  /**
   * Returns the meta object for data type '{@link java.util.List <em>EJava List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>EJava List</em>'.
   * @see java.util.List
   * @model instanceClass="java.util.List" serializable="false"
   * @generated
   */
  EDataType getEJavaList();

  /**
   * Returns the meta object for data type '{@link java.io.ObjectStreamException <em>EObject Stream Exception</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>EObject Stream Exception</em>'.
   * @see java.io.ObjectStreamException
   * @model instanceClass="java.io.ObjectStreamException" serializable="false"
   * @generated
   */
  EDataType getEObjectStreamException();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  SDOFactory getSDOFactory();

} //SDOPackage
