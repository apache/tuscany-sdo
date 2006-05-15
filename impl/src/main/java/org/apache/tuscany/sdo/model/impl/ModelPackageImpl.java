/**
 *
 * Copyright 2005 The Apache Software Foundation
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
package org.apache.tuscany.sdo.model.impl;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.util.Date;
import java.util.List;

import org.apache.tuscany.sdo.SDOPackage;
import org.apache.tuscany.sdo.model.BaseDataGraphType;
import org.apache.tuscany.sdo.model.ChangeSummaryType;
import org.apache.tuscany.sdo.model.DataGraphType;
import org.apache.tuscany.sdo.model.DataObject;
import org.apache.tuscany.sdo.model.ModelFactory;
import org.apache.tuscany.sdo.model.ModelPackage;
import org.apache.tuscany.sdo.model.ModelsType;
import org.apache.tuscany.sdo.model.Property;
import org.apache.tuscany.sdo.model.TextType;
import org.apache.tuscany.sdo.model.Type;
import org.apache.tuscany.sdo.model.Types;
import org.apache.tuscany.sdo.model.XSDType;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.apache.tuscany.sdo.model.ModelFactory
 * @generated
 */
public class ModelPackageImpl extends EPackageImpl implements ModelPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String eNAME = "model";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String eNS_URI = "commonj.sdo";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public static final String eNS_PREFIX = "sdo"; //FB why was this generated = "commonj" ?

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final ModelPackageImpl eINSTANCE = org.apache.tuscany.sdo.model.impl.ModelPackageImpl.init();

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.model.impl.BaseDataGraphTypeImpl <em>Base Data Graph Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.model.impl.BaseDataGraphTypeImpl
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getBaseDataGraphType()
   * @generated
   */
  public static final int BASE_DATA_GRAPH_TYPE = 0;

  /**
   * The feature id for the '<em><b>Models</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int BASE_DATA_GRAPH_TYPE__MODELS = 0;

  /**
   * The feature id for the '<em><b>Xsd</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int BASE_DATA_GRAPH_TYPE__XSD = 1;

  /**
   * The feature id for the '<em><b>Change Summary</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int BASE_DATA_GRAPH_TYPE__CHANGE_SUMMARY = 2;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int BASE_DATA_GRAPH_TYPE__ANY_ATTRIBUTE = 3;

  /**
   * The number of structural features of the '<em>Base Data Graph Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int BASE_DATA_GRAPH_TYPE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.model.impl.ChangeSummaryTypeImpl <em>Change Summary Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.model.impl.ChangeSummaryTypeImpl
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getChangeSummaryType()
   * @generated
   */
  public static final int CHANGE_SUMMARY_TYPE = 1;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int CHANGE_SUMMARY_TYPE__ANY = 0;

  /**
   * The feature id for the '<em><b>Create</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int CHANGE_SUMMARY_TYPE__CREATE = 1;

  /**
   * The feature id for the '<em><b>Delete</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int CHANGE_SUMMARY_TYPE__DELETE = 2;

  /**
   * The feature id for the '<em><b>Logging</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int CHANGE_SUMMARY_TYPE__LOGGING = 3;

  /**
   * The number of structural features of the '<em>Change Summary Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int CHANGE_SUMMARY_TYPE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.model.impl.DataGraphTypeImpl <em>Data Graph Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.model.impl.DataGraphTypeImpl
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getDataGraphType()
   * @generated
   */
  public static final int DATA_GRAPH_TYPE = 2;

  /**
   * The feature id for the '<em><b>Models</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DATA_GRAPH_TYPE__MODELS = BASE_DATA_GRAPH_TYPE__MODELS;

  /**
   * The feature id for the '<em><b>Xsd</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DATA_GRAPH_TYPE__XSD = BASE_DATA_GRAPH_TYPE__XSD;

  /**
   * The feature id for the '<em><b>Change Summary</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DATA_GRAPH_TYPE__CHANGE_SUMMARY = BASE_DATA_GRAPH_TYPE__CHANGE_SUMMARY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DATA_GRAPH_TYPE__ANY_ATTRIBUTE = BASE_DATA_GRAPH_TYPE__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DATA_GRAPH_TYPE__ANY = BASE_DATA_GRAPH_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Data Graph Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DATA_GRAPH_TYPE_FEATURE_COUNT = BASE_DATA_GRAPH_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.model.impl.DataObjectImpl <em>Data Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.model.impl.DataObjectImpl
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getDataObject()
   * @generated
   */
  public static final int DATA_OBJECT = 3;

  /**
   * The number of structural features of the '<em>Data Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DATA_OBJECT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.model.impl.DocumentRootImpl <em>Document Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.model.impl.DocumentRootImpl
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getDocumentRoot()
   * @generated
   */
  public static final int DOCUMENT_ROOT = 4;

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
   * The feature id for the '<em><b>Datagraph</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DOCUMENT_ROOT__DATAGRAPH = 3;

  /**
   * The feature id for the '<em><b>Data Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DOCUMENT_ROOT__DATA_OBJECT = 4;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DOCUMENT_ROOT__TYPE = 5;

  /**
   * The feature id for the '<em><b>Types</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DOCUMENT_ROOT__TYPES = 6;

  /**
   * The feature id for the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DOCUMENT_ROOT__REF = 7;

  /**
   * The number of structural features of the '<em>Document Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int DOCUMENT_ROOT_FEATURE_COUNT = 8;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.model.impl.ModelsTypeImpl <em>Models Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.model.impl.ModelsTypeImpl
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getModelsType()
   * @generated
   */
  public static final int MODELS_TYPE = 5;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int MODELS_TYPE__ANY = 0;

  /**
   * The number of structural features of the '<em>Models Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int MODELS_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.model.impl.PropertyImpl <em>Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.model.impl.PropertyImpl
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getProperty()
   * @generated
   */
  public static final int PROPERTY = 6;

  /**
   * The feature id for the '<em><b>Alias Name</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int PROPERTY__ALIAS_NAME = 0;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int PROPERTY__ANY = 1;

  /**
   * The feature id for the '<em><b>Containment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int PROPERTY__CONTAINMENT = 2;

  /**
   * The feature id for the '<em><b>Default</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int PROPERTY__DEFAULT = 3;

  /**
   * The feature id for the '<em><b>Many</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int PROPERTY__MANY = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int PROPERTY__NAME = 5;

  /**
   * The feature id for the '<em><b>Opposite</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int PROPERTY__OPPOSITE = 6;

  /**
   * The feature id for the '<em><b>Read Only</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int PROPERTY__READ_ONLY = 7;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int PROPERTY__TYPE = 8;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int PROPERTY__ANY_ATTRIBUTE = 9;

  /**
   * The number of structural features of the '<em>Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int PROPERTY_FEATURE_COUNT = 10;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.model.impl.TextTypeImpl <em>Text Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.model.impl.TextTypeImpl
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getTextType()
   * @generated
   */
  public static final int TEXT_TYPE = 7;

  /**
   * The feature id for the '<em><b>Text</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int TEXT_TYPE__TEXT = 0;

  /**
   * The number of structural features of the '<em>Text Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int TEXT_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.model.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.model.impl.TypeImpl
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getType()
   * @generated
   */
  public static final int TYPE = 8;

  /**
   * The feature id for the '<em><b>Base Type</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int TYPE__BASE_TYPE = 0;

  /**
   * The feature id for the '<em><b>Property</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int TYPE__PROPERTY = 1;

  /**
   * The feature id for the '<em><b>Alias Name</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int TYPE__ALIAS_NAME = 2;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int TYPE__ANY = 3;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int TYPE__ABSTRACT = 4;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int TYPE__DATA_TYPE = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int TYPE__NAME = 6;

  /**
   * The feature id for the '<em><b>Open</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int TYPE__OPEN = 7;

  /**
   * The feature id for the '<em><b>Sequenced</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int TYPE__SEQUENCED = 8;

  /**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int TYPE__URI = 9;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int TYPE__ANY_ATTRIBUTE = 10;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int TYPE_FEATURE_COUNT = 11;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.model.impl.TypesImpl <em>Types</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.model.impl.TypesImpl
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getTypes()
   * @generated
   */
  public static final int TYPES = 9;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int TYPES__TYPE = 0;

  /**
   * The number of structural features of the '<em>Types</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int TYPES_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.apache.tuscany.sdo.model.impl.XSDTypeImpl <em>XSD Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.model.impl.XSDTypeImpl
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getXSDType()
   * @generated
   */
  public static final int XSD_TYPE = 10;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int XSD_TYPE__ANY = 0;

  /**
   * The number of structural features of the '<em>XSD Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int XSD_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '<em>Boolean</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getBoolean()
   * @generated
   */
  public static final int BOOLEAN = 11;

  /**
   * The meta object id for the '<em>Boolean Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.Boolean
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getBooleanObject()
   * @generated
   */
  public static final int BOOLEAN_OBJECT = 12;

  /**
   * The meta object id for the '<em>Byte</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getByte()
   * @generated
   */
  public static final int BYTE = 13;

  /**
   * The meta object id for the '<em>Byte Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.Byte
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getByteObject()
   * @generated
   */
  public static final int BYTE_OBJECT = 14;

  /**
   * The meta object id for the '<em>Bytes</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getBytes()
   * @generated
   */
  public static final int BYTES = 15;

  /**
   * The meta object id for the '<em>Character</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getCharacter()
   * @generated
   */
  public static final int CHARACTER = 16;

  /**
   * The meta object id for the '<em>Character Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.Character
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getCharacterObject()
   * @generated
   */
  public static final int CHARACTER_OBJECT = 17;

  /**
   * The meta object id for the '<em>Date</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.Date
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getDate()
   * @generated
   */
  public static final int DATE = 18;

  /**
   * The meta object id for the '<em>Date Time</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.String
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getDateTime()
   * @generated
   */
  public static final int DATE_TIME = 19;

  /**
   * The meta object id for the '<em>Day</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.String
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getDay()
   * @generated
   */
  public static final int DAY = 20;

  /**
   * The meta object id for the '<em>Decimal</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.math.BigDecimal
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getDecimal()
   * @generated
   */
  public static final int DECIMAL = 21;

  /**
   * The meta object id for the '<em>Double</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getDouble()
   * @generated
   */
  public static final int DOUBLE = 22;

  /**
   * The meta object id for the '<em>Double Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.Double
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getDoubleObject()
   * @generated
   */
  public static final int DOUBLE_OBJECT = 23;

  /**
   * The meta object id for the '<em>Duration</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.String
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getDuration()
   * @generated
   */
  public static final int DURATION = 24;

  /**
   * The meta object id for the '<em>Float</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getFloat()
   * @generated
   */
  public static final int FLOAT = 25;

  /**
   * The meta object id for the '<em>Float Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.Float
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getFloatObject()
   * @generated
   */
  public static final int FLOAT_OBJECT = 26;

  /**
   * The meta object id for the '<em>Int</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getInt()
   * @generated
   */
  public static final int INT = 27;

  /**
   * The meta object id for the '<em>Integer</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.math.BigInteger
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getInteger()
   * @generated
   */
  public static final int INTEGER = 28;

  /**
   * The meta object id for the '<em>Int Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.Integer
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getIntObject()
   * @generated
   */
  public static final int INT_OBJECT = 29;

  /**
   * The meta object id for the '<em>Long</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getLong()
   * @generated
   */
  public static final int LONG = 30;

  /**
   * The meta object id for the '<em>Long Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.Long
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getLongObject()
   * @generated
   */
  public static final int LONG_OBJECT = 31;

  /**
   * The meta object id for the '<em>Month</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.String
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getMonth()
   * @generated
   */
  public static final int MONTH = 32;

  /**
   * The meta object id for the '<em>Month Day</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.String
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getMonthDay()
   * @generated
   */
  public static final int MONTH_DAY = 33;

  /**
   * The meta object id for the '<em>Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.Object
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getObject()
   * @generated
   */
  public static final int OBJECT = 34;

  /**
   * The meta object id for the '<em>Short</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getShort()
   * @generated
   */
  public static final int SHORT = 35;

  /**
   * The meta object id for the '<em>Short Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.Short
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getShortObject()
   * @generated
   */
  public static final int SHORT_OBJECT = 36;

  /**
   * The meta object id for the '<em>String</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.String
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getString()
   * @generated
   */
  public static final int STRING = 37;

  /**
   * The meta object id for the '<em>Strings</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.List
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getStrings()
   * @generated
   */
  public static final int STRINGS = 38;

  /**
   * The meta object id for the '<em>Time</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.String
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getTime()
   * @generated
   */
  public static final int TIME = 39;

  /**
   * The meta object id for the '<em>URI</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.String
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getURI()
   * @generated
   */
  public static final int URI = 40;

  /**
   * The meta object id for the '<em>Year</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.String
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getYear()
   * @generated
   */
  public static final int YEAR = 41;

  /**
   * The meta object id for the '<em>Year Month</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.String
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getYearMonth()
   * @generated
   */
  public static final int YEAR_MONTH = 42;

  /**
   * The meta object id for the '<em>Year Month Day</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.String
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getYearMonthDay()
   * @generated
   */
  public static final int YEAR_MONTH_DAY = 43;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass baseDataGraphTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass changeSummaryTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dataGraphTypeEClass = null;

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
  private EClass documentRootEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelsTypeEClass = null;

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
  private EClass textTypeEClass = null;

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
  private EClass typesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xsdTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType booleanEDataType = null;

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
  private EDataType byteEDataType = null;

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
  private EDataType bytesEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType characterEDataType = null;

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
  private EDataType dateEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType dateTimeEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType dayEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType decimalEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType doubleEDataType = null;

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
  private EDataType durationEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType floatEDataType = null;

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
  private EDataType intEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType integerEDataType = null;

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
  private EDataType longEDataType = null;

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
  private EDataType monthEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType monthDayEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType objectEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType shortEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType shortObjectEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType stringEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType stringsEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType timeEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType uriEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType yearEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType yearMonthEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType yearMonthDayEDataType = null;

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
   * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#eNS_URI
   * @see #init()
   * @generated
   */
  private ModelPackageImpl()
  {
    super(eNS_URI, ((EFactory)ModelFactory.INSTANCE));
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
  public static ModelPackageImpl init()
  {
    if (isInited) return (ModelPackageImpl)EPackage.Registry.INSTANCE.getEPackage(ModelPackageImpl.eNS_URI);

    // Obtain or create and register package
    ModelPackageImpl theModelPackageImpl = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ModelPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    XMLTypePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theModelPackageImpl.createPackageContents();

    // Initialize created meta-data
    theModelPackageImpl.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theModelPackageImpl.freeze();

    return theModelPackageImpl;
  }


  /**
   * Returns the meta object for class '{@link org.apache.tuscany.sdo.model.BaseDataGraphType <em>Base Data Graph Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Base Data Graph Type</em>'.
   * @see org.apache.tuscany.sdo.model.BaseDataGraphType
   * @generated
   */
  public EClass getBaseDataGraphType()
  {
    return baseDataGraphTypeEClass;
  }

  /**
   * Returns the meta object for the containment reference '{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getModels <em>Models</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Models</em>'.
   * @see org.apache.tuscany.sdo.model.BaseDataGraphType#getModels()
   * @see #getBaseDataGraphType()
   * @generated
   */
  public EReference getBaseDataGraphType_Models()
  {
    return (EReference)baseDataGraphTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for the containment reference '{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getXsd <em>Xsd</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Xsd</em>'.
   * @see org.apache.tuscany.sdo.model.BaseDataGraphType#getXsd()
   * @see #getBaseDataGraphType()
   * @generated
   */
  public EReference getBaseDataGraphType_Xsd()
  {
    return (EReference)baseDataGraphTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * Returns the meta object for the containment reference '{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getChangeSummary <em>Change Summary</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Change Summary</em>'.
   * @see org.apache.tuscany.sdo.model.BaseDataGraphType#getChangeSummary()
   * @see #getBaseDataGraphType()
   * @generated
   */
  public EReference getBaseDataGraphType_ChangeSummary()
  {
    return (EReference)baseDataGraphTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * Returns the meta object for the attribute list '{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getAnyAttribute <em>Any Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Any Attribute</em>'.
   * @see org.apache.tuscany.sdo.model.BaseDataGraphType#getAnyAttribute()
   * @see #getBaseDataGraphType()
   * @generated
   */
  public EAttribute getBaseDataGraphType_AnyAttribute()
  {
    return (EAttribute)baseDataGraphTypeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * Returns the meta object for class '{@link org.apache.tuscany.sdo.model.ChangeSummaryType <em>Change Summary Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Change Summary Type</em>'.
   * @see org.apache.tuscany.sdo.model.ChangeSummaryType
   * @generated
   */
  public EClass getChangeSummaryType()
  {
    return changeSummaryTypeEClass;
  }

  /**
   * Returns the meta object for the attribute list '{@link org.apache.tuscany.sdo.model.ChangeSummaryType#getAny <em>Any</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Any</em>'.
   * @see org.apache.tuscany.sdo.model.ChangeSummaryType#getAny()
   * @see #getChangeSummaryType()
   * @generated
   */
  public EAttribute getChangeSummaryType_Any()
  {
    return (EAttribute)changeSummaryTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for the attribute '{@link org.apache.tuscany.sdo.model.ChangeSummaryType#getCreate <em>Create</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Create</em>'.
   * @see org.apache.tuscany.sdo.model.ChangeSummaryType#getCreate()
   * @see #getChangeSummaryType()
   * @generated
   */
  public EAttribute getChangeSummaryType_Create()
  {
    return (EAttribute)changeSummaryTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * Returns the meta object for the attribute '{@link org.apache.tuscany.sdo.model.ChangeSummaryType#getDelete <em>Delete</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Delete</em>'.
   * @see org.apache.tuscany.sdo.model.ChangeSummaryType#getDelete()
   * @see #getChangeSummaryType()
   * @generated
   */
  public EAttribute getChangeSummaryType_Delete()
  {
    return (EAttribute)changeSummaryTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * Returns the meta object for the attribute '{@link org.apache.tuscany.sdo.model.ChangeSummaryType#isLogging <em>Logging</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Logging</em>'.
   * @see org.apache.tuscany.sdo.model.ChangeSummaryType#isLogging()
   * @see #getChangeSummaryType()
   * @generated
   */
  public EAttribute getChangeSummaryType_Logging()
  {
    return (EAttribute)changeSummaryTypeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * Returns the meta object for class '{@link org.apache.tuscany.sdo.model.DataGraphType <em>Data Graph Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Data Graph Type</em>'.
   * @see org.apache.tuscany.sdo.model.DataGraphType
   * @generated
   */
  public EClass getDataGraphType()
  {
    return dataGraphTypeEClass;
  }

  /**
   * Returns the meta object for the attribute list '{@link org.apache.tuscany.sdo.model.DataGraphType#getAny <em>Any</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Any</em>'.
   * @see org.apache.tuscany.sdo.model.DataGraphType#getAny()
   * @see #getDataGraphType()
   * @generated
   */
  public EAttribute getDataGraphType_Any()
  {
    return (EAttribute)dataGraphTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for class '{@link org.apache.tuscany.sdo.model.DataObject <em>Data Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Data Object</em>'.
   * @see org.apache.tuscany.sdo.model.DataObject
   * @generated
   */
  public EClass getDataObject()
  {
    return dataObjectEClass;
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
   * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecore.EObject#getDatagraph <em>Datagraph</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Datagraph</em>'.
   * @see org.eclipse.emf.ecore.EObject#getDatagraph()
   * @see #getDocumentRoot()
   * @generated
   */
  public EReference getDocumentRoot_Datagraph()
  {
    return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
  }

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecore.EObject#getDataObject <em>Data Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Data Object</em>'.
   * @see org.eclipse.emf.ecore.EObject#getDataObject()
   * @see #getDocumentRoot()
   * @generated
   */
  public EReference getDocumentRoot_DataObject()
  {
    return (EReference)documentRootEClass.getEStructuralFeatures().get(4);
  }

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecore.EObject#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.emf.ecore.EObject#getType()
   * @see #getDocumentRoot()
   * @generated
   */
  public EReference getDocumentRoot_Type()
  {
    return (EReference)documentRootEClass.getEStructuralFeatures().get(5);
  }

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecore.EObject#getTypes <em>Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Types</em>'.
   * @see org.eclipse.emf.ecore.EObject#getTypes()
   * @see #getDocumentRoot()
   * @generated
   */
  public EReference getDocumentRoot_Types()
  {
    return (EReference)documentRootEClass.getEStructuralFeatures().get(6);
  }

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.ecore.EObject#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ref</em>'.
   * @see org.eclipse.emf.ecore.EObject#getRef()
   * @see #getDocumentRoot()
   * @generated
   */
  public EAttribute getDocumentRoot_Ref()
  {
    return (EAttribute)documentRootEClass.getEStructuralFeatures().get(7);
  }

  /**
   * Returns the meta object for class '{@link org.apache.tuscany.sdo.model.ModelsType <em>Models Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Models Type</em>'.
   * @see org.apache.tuscany.sdo.model.ModelsType
   * @generated
   */
  public EClass getModelsType()
  {
    return modelsTypeEClass;
  }

  /**
   * Returns the meta object for the attribute list '{@link org.apache.tuscany.sdo.model.ModelsType#getAny <em>Any</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Any</em>'.
   * @see org.apache.tuscany.sdo.model.ModelsType#getAny()
   * @see #getModelsType()
   * @generated
   */
  public EAttribute getModelsType_Any()
  {
    return (EAttribute)modelsTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for class '{@link org.apache.tuscany.sdo.model.Property <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property</em>'.
   * @see org.apache.tuscany.sdo.model.Property
   * @generated
   */
  public EClass getProperty()
  {
    return propertyEClass;
  }

  /**
   * Returns the meta object for the attribute list '{@link org.apache.tuscany.sdo.model.Property#getAliasName <em>Alias Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Alias Name</em>'.
   * @see org.apache.tuscany.sdo.model.Property#getAliasName()
   * @see #getProperty()
   * @generated
   */
  public EAttribute getProperty_AliasName()
  {
    return (EAttribute)propertyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for the attribute list '{@link org.apache.tuscany.sdo.model.Property#getAny <em>Any</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Any</em>'.
   * @see org.apache.tuscany.sdo.model.Property#getAny()
   * @see #getProperty()
   * @generated
   */
  public EAttribute getProperty_Any()
  {
    return (EAttribute)propertyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * Returns the meta object for the attribute '{@link org.apache.tuscany.sdo.model.Property#isContainment <em>Containment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Containment</em>'.
   * @see org.apache.tuscany.sdo.model.Property#isContainment()
   * @see #getProperty()
   * @generated
   */
  public EAttribute getProperty_Containment()
  {
    return (EAttribute)propertyEClass.getEStructuralFeatures().get(2);
  }

  /**
   * Returns the meta object for the attribute '{@link org.apache.tuscany.sdo.model.Property#getDefault <em>Default</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Default</em>'.
   * @see org.apache.tuscany.sdo.model.Property#getDefault()
   * @see #getProperty()
   * @generated
   */
  public EAttribute getProperty_Default()
  {
    return (EAttribute)propertyEClass.getEStructuralFeatures().get(3);
  }

  /**
   * Returns the meta object for the attribute '{@link org.apache.tuscany.sdo.model.Property#isMany <em>Many</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Many</em>'.
   * @see org.apache.tuscany.sdo.model.Property#isMany()
   * @see #getProperty()
   * @generated
   */
  public EAttribute getProperty_Many()
  {
    return (EAttribute)propertyEClass.getEStructuralFeatures().get(4);
  }

  /**
   * Returns the meta object for the attribute '{@link org.apache.tuscany.sdo.model.Property#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.apache.tuscany.sdo.model.Property#getName()
   * @see #getProperty()
   * @generated
   */
  public EAttribute getProperty_Name()
  {
    return (EAttribute)propertyEClass.getEStructuralFeatures().get(5);
  }

  /**
   * Returns the meta object for the reference '{@link org.apache.tuscany.sdo.model.Property#getOpposite <em>Opposite</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Opposite</em>'.
   * @see org.apache.tuscany.sdo.model.Property#getOpposite()
   * @see #getProperty()
   * @generated
   */
  public EReference getProperty_Opposite()
  {
    return (EReference)propertyEClass.getEStructuralFeatures().get(6);
  }

  /**
   * Returns the meta object for the attribute '{@link org.apache.tuscany.sdo.model.Property#isReadOnly <em>Read Only</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Read Only</em>'.
   * @see org.apache.tuscany.sdo.model.Property#isReadOnly()
   * @see #getProperty()
   * @generated
   */
  public EAttribute getProperty_ReadOnly()
  {
    return (EAttribute)propertyEClass.getEStructuralFeatures().get(7);
  }

  /**
   * Returns the meta object for the reference '{@link org.apache.tuscany.sdo.model.Property#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.apache.tuscany.sdo.model.Property#getType()
   * @see #getProperty()
   * @generated
   */
  public EReference getProperty_Type()
  {
    return (EReference)propertyEClass.getEStructuralFeatures().get(8);
  }

  /**
   * Returns the meta object for the attribute list '{@link org.apache.tuscany.sdo.model.Property#getAnyAttribute <em>Any Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Any Attribute</em>'.
   * @see org.apache.tuscany.sdo.model.Property#getAnyAttribute()
   * @see #getProperty()
   * @generated
   */
  public EAttribute getProperty_AnyAttribute()
  {
    return (EAttribute)propertyEClass.getEStructuralFeatures().get(9);
  }

  /**
   * Returns the meta object for class '{@link org.apache.tuscany.sdo.model.TextType <em>Text Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Text Type</em>'.
   * @see org.apache.tuscany.sdo.model.TextType
   * @generated
   */
  public EClass getTextType()
  {
    return textTypeEClass;
  }

  /**
   * Returns the meta object for the attribute list '{@link org.apache.tuscany.sdo.model.TextType#getText <em>Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Text</em>'.
   * @see org.apache.tuscany.sdo.model.TextType#getText()
   * @see #getTextType()
   * @generated
   */
  public EAttribute getTextType_Text()
  {
    return (EAttribute)textTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for class '{@link org.apache.tuscany.sdo.model.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see org.apache.tuscany.sdo.model.Type
   * @generated
   */
  public EClass getType()
  {
    return typeEClass;
  }

  /**
   * Returns the meta object for the reference list '{@link org.apache.tuscany.sdo.model.Type#getBaseType <em>Base Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Base Type</em>'.
   * @see org.apache.tuscany.sdo.model.Type#getBaseType()
   * @see #getType()
   * @generated
   */
  public EReference getType_BaseType()
  {
    return (EReference)typeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for the containment reference list '{@link org.apache.tuscany.sdo.model.Type#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Property</em>'.
   * @see org.apache.tuscany.sdo.model.Type#getProperty()
   * @see #getType()
   * @generated
   */
  public EReference getType_Property()
  {
    return (EReference)typeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * Returns the meta object for the attribute list '{@link org.apache.tuscany.sdo.model.Type#getAliasName <em>Alias Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Alias Name</em>'.
   * @see org.apache.tuscany.sdo.model.Type#getAliasName()
   * @see #getType()
   * @generated
   */
  public EAttribute getType_AliasName()
  {
    return (EAttribute)typeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * Returns the meta object for the attribute list '{@link org.apache.tuscany.sdo.model.Type#getAny <em>Any</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Any</em>'.
   * @see org.apache.tuscany.sdo.model.Type#getAny()
   * @see #getType()
   * @generated
   */
  public EAttribute getType_Any()
  {
    return (EAttribute)typeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * Returns the meta object for the attribute '{@link org.apache.tuscany.sdo.model.Type#isAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Abstract</em>'.
   * @see org.apache.tuscany.sdo.model.Type#isAbstract()
   * @see #getType()
   * @generated
   */
  public EAttribute getType_Abstract()
  {
    return (EAttribute)typeEClass.getEStructuralFeatures().get(4);
  }

  /**
   * Returns the meta object for the attribute '{@link org.apache.tuscany.sdo.model.Type#isDataType <em>Data Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Data Type</em>'.
   * @see org.apache.tuscany.sdo.model.Type#isDataType()
   * @see #getType()
   * @generated
   */
  public EAttribute getType_DataType()
  {
    return (EAttribute)typeEClass.getEStructuralFeatures().get(5);
  }

  /**
   * Returns the meta object for the attribute '{@link org.apache.tuscany.sdo.model.Type#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.apache.tuscany.sdo.model.Type#getName()
   * @see #getType()
   * @generated
   */
  public EAttribute getType_Name()
  {
    return (EAttribute)typeEClass.getEStructuralFeatures().get(6);
  }

  /**
   * Returns the meta object for the attribute '{@link org.apache.tuscany.sdo.model.Type#isOpen <em>Open</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Open</em>'.
   * @see org.apache.tuscany.sdo.model.Type#isOpen()
   * @see #getType()
   * @generated
   */
  public EAttribute getType_Open()
  {
    return (EAttribute)typeEClass.getEStructuralFeatures().get(7);
  }

  /**
   * Returns the meta object for the attribute '{@link org.apache.tuscany.sdo.model.Type#isSequenced <em>Sequenced</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Sequenced</em>'.
   * @see org.apache.tuscany.sdo.model.Type#isSequenced()
   * @see #getType()
   * @generated
   */
  public EAttribute getType_Sequenced()
  {
    return (EAttribute)typeEClass.getEStructuralFeatures().get(8);
  }

  /**
   * Returns the meta object for the attribute '{@link org.apache.tuscany.sdo.model.Type#getUri <em>Uri</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Uri</em>'.
   * @see org.apache.tuscany.sdo.model.Type#getUri()
   * @see #getType()
   * @generated
   */
  public EAttribute getType_Uri()
  {
    return (EAttribute)typeEClass.getEStructuralFeatures().get(9);
  }

  /**
   * Returns the meta object for the attribute list '{@link org.apache.tuscany.sdo.model.Type#getAnyAttribute <em>Any Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Any Attribute</em>'.
   * @see org.apache.tuscany.sdo.model.Type#getAnyAttribute()
   * @see #getType()
   * @generated
   */
  public EAttribute getType_AnyAttribute()
  {
    return (EAttribute)typeEClass.getEStructuralFeatures().get(10);
  }

  /**
   * Returns the meta object for class '{@link org.apache.tuscany.sdo.model.Types <em>Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Types</em>'.
   * @see org.apache.tuscany.sdo.model.Types
   * @generated
   */
  public EClass getTypes()
  {
    return typesEClass;
  }

  /**
   * Returns the meta object for the containment reference list '{@link org.apache.tuscany.sdo.model.Types#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Type</em>'.
   * @see org.apache.tuscany.sdo.model.Types#getType()
   * @see #getTypes()
   * @generated
   */
  public EReference getTypes_Type()
  {
    return (EReference)typesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for class '{@link org.apache.tuscany.sdo.model.XSDType <em>XSD Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XSD Type</em>'.
   * @see org.apache.tuscany.sdo.model.XSDType
   * @generated
   */
  public EClass getXSDType()
  {
    return xsdTypeEClass;
  }

  /**
   * Returns the meta object for the attribute list '{@link org.apache.tuscany.sdo.model.XSDType#getAny <em>Any</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Any</em>'.
   * @see org.apache.tuscany.sdo.model.XSDType#getAny()
   * @see #getXSDType()
   * @generated
   */
  public EAttribute getXSDType_Any()
  {
    return (EAttribute)xsdTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for data type '<em>Boolean</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Boolean</em>'.
   * @generated
   */
  public EDataType getBoolean()
  {
    return booleanEDataType;
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
   * Returns the meta object for data type '<em>Byte</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Byte</em>'.
   * @generated
   */
  public EDataType getByte()
  {
    return byteEDataType;
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
   * Returns the meta object for data type '<em>Bytes</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Bytes</em>'.
   * @generated
   */
  public EDataType getBytes()
  {
    return bytesEDataType;
  }

  /**
   * Returns the meta object for data type '<em>Character</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Character</em>'.
   * @generated
   */
  public EDataType getCharacter()
  {
    return characterEDataType;
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
   * Returns the meta object for data type '{@link java.util.Date <em>Date</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Date</em>'.
   * @see java.util.Date
   * @generated
   */
  public EDataType getDate()
  {
    return dateEDataType;
  }

  /**
   * Returns the meta object for data type '{@link java.lang.String <em>Date Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Date Time</em>'.
   * @see java.lang.String
   * @generated
   */
  public EDataType getDateTime()
  {
    return dateTimeEDataType;
  }

  /**
   * Returns the meta object for data type '{@link java.lang.String <em>Day</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Day</em>'.
   * @see java.lang.String
   * @generated
   */
  public EDataType getDay()
  {
    return dayEDataType;
  }

  /**
   * Returns the meta object for data type '{@link java.math.BigDecimal <em>Decimal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Decimal</em>'.
   * @see java.math.BigDecimal
   * @generated
   */
  public EDataType getDecimal()
  {
    return decimalEDataType;
  }

  /**
   * Returns the meta object for data type '<em>Double</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Double</em>'.
   * @generated
   */
  public EDataType getDouble()
  {
    return doubleEDataType;
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
   * Returns the meta object for data type '{@link java.lang.String <em>Duration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Duration</em>'.
   * @see java.lang.String
   * @generated
   */
  public EDataType getDuration()
  {
    return durationEDataType;
  }

  /**
   * Returns the meta object for data type '<em>Float</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Float</em>'.
   * @generated
   */
  public EDataType getFloat()
  {
    return floatEDataType;
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
   * Returns the meta object for data type '<em>Int</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Int</em>'.
   * @generated
   */
  public EDataType getInt()
  {
    return intEDataType;
  }

  /**
   * Returns the meta object for data type '{@link java.math.BigInteger <em>Integer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Integer</em>'.
   * @see java.math.BigInteger
   * @generated
   */
  public EDataType getInteger()
  {
    return integerEDataType;
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
   * Returns the meta object for data type '<em>Long</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Long</em>'.
   * @generated
   */
  public EDataType getLong()
  {
    return longEDataType;
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
   * Returns the meta object for data type '{@link java.lang.String <em>Month</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Month</em>'.
   * @see java.lang.String
   * @generated
   */
  public EDataType getMonth()
  {
    return monthEDataType;
  }

  /**
   * Returns the meta object for data type '{@link java.lang.String <em>Month Day</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Month Day</em>'.
   * @see java.lang.String
   * @generated
   */
  public EDataType getMonthDay()
  {
    return monthDayEDataType;
  }

  /**
   * Returns the meta object for data type '{@link java.lang.Object <em>Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Object</em>'.
   * @see java.lang.Object
   * @generated
   */
  public EDataType getObject()
  {
    return objectEDataType;
  }

  /**
   * Returns the meta object for data type '<em>Short</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Short</em>'.
   * @generated
   */
  public EDataType getShort()
  {
    return shortEDataType;
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
   * Returns the meta object for data type '{@link java.lang.String <em>String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>String</em>'.
   * @see java.lang.String
   * @generated
   */
  public EDataType getString()
  {
    return stringEDataType;
  }

  /**
   * Returns the meta object for data type '{@link java.util.List <em>Strings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Strings</em>'.
   * @see java.util.List
   * @generated
   */
  public EDataType getStrings()
  {
    return stringsEDataType;
  }

  /**
   * Returns the meta object for data type '{@link java.lang.String <em>Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Time</em>'.
   * @see java.lang.String
   * @generated
   */
  public EDataType getTime()
  {
    return timeEDataType;
  }

  /**
   * Returns the meta object for data type '{@link java.lang.String <em>URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>URI</em>'.
   * @see java.lang.String
   * @generated
   */
  public EDataType getURI()
  {
    return uriEDataType;
  }

  /**
   * Returns the meta object for data type '{@link java.lang.String <em>Year</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Year</em>'.
   * @see java.lang.String
   * @generated
   */
  public EDataType getYear()
  {
    return yearEDataType;
  }

  /**
   * Returns the meta object for data type '{@link java.lang.String <em>Year Month</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Year Month</em>'.
   * @see java.lang.String
   * @generated
   */
  public EDataType getYearMonth()
  {
    return yearMonthEDataType;
  }

  /**
   * Returns the meta object for data type '{@link java.lang.String <em>Year Month Day</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Year Month Day</em>'.
   * @see java.lang.String
   * @generated
   */
  public EDataType getYearMonthDay()
  {
    return yearMonthDayEDataType;
  }

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  public ModelFactory getModelFactory()
  {
    return (ModelFactory)getEFactoryInstance();
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
    baseDataGraphTypeEClass = createEClass(BASE_DATA_GRAPH_TYPE);
    createEReference(baseDataGraphTypeEClass, BASE_DATA_GRAPH_TYPE__MODELS);
    createEReference(baseDataGraphTypeEClass, BASE_DATA_GRAPH_TYPE__XSD);
    createEReference(baseDataGraphTypeEClass, BASE_DATA_GRAPH_TYPE__CHANGE_SUMMARY);
    createEAttribute(baseDataGraphTypeEClass, BASE_DATA_GRAPH_TYPE__ANY_ATTRIBUTE);

    changeSummaryTypeEClass = createEClass(CHANGE_SUMMARY_TYPE);
    createEAttribute(changeSummaryTypeEClass, CHANGE_SUMMARY_TYPE__ANY);
    createEAttribute(changeSummaryTypeEClass, CHANGE_SUMMARY_TYPE__CREATE);
    createEAttribute(changeSummaryTypeEClass, CHANGE_SUMMARY_TYPE__DELETE);
    createEAttribute(changeSummaryTypeEClass, CHANGE_SUMMARY_TYPE__LOGGING);

    dataGraphTypeEClass = createEClass(DATA_GRAPH_TYPE);
    createEAttribute(dataGraphTypeEClass, DATA_GRAPH_TYPE__ANY);

    dataObjectEClass = createEClass(DATA_OBJECT);

    documentRootEClass = createEClass(DOCUMENT_ROOT);
    createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
    createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
    createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
    createEReference(documentRootEClass, DOCUMENT_ROOT__DATAGRAPH);
    createEReference(documentRootEClass, DOCUMENT_ROOT__DATA_OBJECT);
    createEReference(documentRootEClass, DOCUMENT_ROOT__TYPE);
    createEReference(documentRootEClass, DOCUMENT_ROOT__TYPES);
    createEAttribute(documentRootEClass, DOCUMENT_ROOT__REF);

    modelsTypeEClass = createEClass(MODELS_TYPE);
    createEAttribute(modelsTypeEClass, MODELS_TYPE__ANY);

    propertyEClass = createEClass(PROPERTY);
    createEAttribute(propertyEClass, PROPERTY__ALIAS_NAME);
    createEAttribute(propertyEClass, PROPERTY__ANY);
    createEAttribute(propertyEClass, PROPERTY__CONTAINMENT);
    createEAttribute(propertyEClass, PROPERTY__DEFAULT);
    createEAttribute(propertyEClass, PROPERTY__MANY);
    createEAttribute(propertyEClass, PROPERTY__NAME);
    createEReference(propertyEClass, PROPERTY__OPPOSITE);
    createEAttribute(propertyEClass, PROPERTY__READ_ONLY);
    createEReference(propertyEClass, PROPERTY__TYPE);
    createEAttribute(propertyEClass, PROPERTY__ANY_ATTRIBUTE);

    textTypeEClass = createEClass(TEXT_TYPE);
    createEAttribute(textTypeEClass, TEXT_TYPE__TEXT);

    typeEClass = createEClass(TYPE);
    createEReference(typeEClass, TYPE__BASE_TYPE);
    createEReference(typeEClass, TYPE__PROPERTY);
    createEAttribute(typeEClass, TYPE__ALIAS_NAME);
    createEAttribute(typeEClass, TYPE__ANY);
    createEAttribute(typeEClass, TYPE__ABSTRACT);
    createEAttribute(typeEClass, TYPE__DATA_TYPE);
    createEAttribute(typeEClass, TYPE__NAME);
    createEAttribute(typeEClass, TYPE__OPEN);
    createEAttribute(typeEClass, TYPE__SEQUENCED);
    createEAttribute(typeEClass, TYPE__URI);
    createEAttribute(typeEClass, TYPE__ANY_ATTRIBUTE);

    typesEClass = createEClass(TYPES);
    createEReference(typesEClass, TYPES__TYPE);

    xsdTypeEClass = createEClass(XSD_TYPE);
    createEAttribute(xsdTypeEClass, XSD_TYPE__ANY);

    // Create data types
    booleanEDataType = createEDataType(BOOLEAN);
    booleanObjectEDataType = createEDataType(BOOLEAN_OBJECT);
    byteEDataType = createEDataType(BYTE);
    byteObjectEDataType = createEDataType(BYTE_OBJECT);
    bytesEDataType = createEDataType(BYTES);
    characterEDataType = createEDataType(CHARACTER);
    characterObjectEDataType = createEDataType(CHARACTER_OBJECT);
    dateEDataType = createEDataType(DATE);
    dateTimeEDataType = createEDataType(DATE_TIME);
    dayEDataType = createEDataType(DAY);
    decimalEDataType = createEDataType(DECIMAL);
    doubleEDataType = createEDataType(DOUBLE);
    doubleObjectEDataType = createEDataType(DOUBLE_OBJECT);
    durationEDataType = createEDataType(DURATION);
    floatEDataType = createEDataType(FLOAT);
    floatObjectEDataType = createEDataType(FLOAT_OBJECT);
    intEDataType = createEDataType(INT);
    integerEDataType = createEDataType(INTEGER);
    intObjectEDataType = createEDataType(INT_OBJECT);
    longEDataType = createEDataType(LONG);
    longObjectEDataType = createEDataType(LONG_OBJECT);
    monthEDataType = createEDataType(MONTH);
    monthDayEDataType = createEDataType(MONTH_DAY);
    objectEDataType = createEDataType(OBJECT);
    shortEDataType = createEDataType(SHORT);
    shortObjectEDataType = createEDataType(SHORT_OBJECT);
    stringEDataType = createEDataType(STRING);
    stringsEDataType = createEDataType(STRINGS);
    timeEDataType = createEDataType(TIME);
    uriEDataType = createEDataType(URI);
    yearEDataType = createEDataType(YEAR);
    yearMonthEDataType = createEDataType(YEAR_MONTH);
    yearMonthDayEDataType = createEDataType(YEAR_MONTH_DAY);
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
    dataGraphTypeEClass.getESuperTypes().add(this.getBaseDataGraphType());

    // Initialize classes and features; add operations and parameters
    initEClass(baseDataGraphTypeEClass, BaseDataGraphType.class, "BaseDataGraphType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBaseDataGraphType_Models(), this.getModelsType(), null, "models", null, 0, 1, BaseDataGraphType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBaseDataGraphType_Xsd(), this.getXSDType(), null, "xsd", null, 0, 1, BaseDataGraphType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBaseDataGraphType_ChangeSummary(), this.getChangeSummaryType(), null, "changeSummary", null, 0, 1, BaseDataGraphType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBaseDataGraphType_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, BaseDataGraphType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(changeSummaryTypeEClass, ChangeSummaryType.class, "ChangeSummaryType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getChangeSummaryType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, ChangeSummaryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getChangeSummaryType_Create(), theXMLTypePackage.getString(), "create", null, 0, 1, ChangeSummaryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getChangeSummaryType_Delete(), theXMLTypePackage.getString(), "delete", null, 0, 1, ChangeSummaryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getChangeSummaryType_Logging(), theXMLTypePackage.getBoolean(), "logging", null, 0, 1, ChangeSummaryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dataGraphTypeEClass, DataGraphType.class, "DataGraphType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDataGraphType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, 1, DataGraphType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dataObjectEClass, DataObject.class, "DataObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(documentRootEClass, null, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_Datagraph(), this.getDataGraphType(), null, "datagraph", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_DataObject(), ecorePackage.getEObject(), null, "dataObject", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_Type(), this.getType(), null, "type", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_Types(), this.getTypes(), null, "types", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
    initEAttribute(getDocumentRoot_Ref(), theXMLTypePackage.getString(), "ref", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(modelsTypeEClass, ModelsType.class, "ModelsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModelsType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, ModelsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getProperty_AliasName(), this.getString(), "aliasName", null, 0, -1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getProperty_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getProperty_Containment(), this.getBoolean(), "containment", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getProperty_Default(), this.getString(), "default", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getProperty_Many(), this.getBoolean(), "many", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getProperty_Name(), this.getString(), "name", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProperty_Opposite(), this.getProperty(), null, "opposite", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getProperty_ReadOnly(), this.getBoolean(), "readOnly", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProperty_Type(), this.getType(), null, "type", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getProperty_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(textTypeEClass, TextType.class, "TextType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTextType_Text(), theXMLTypePackage.getString(), "text", null, 0, -1, TextType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeEClass, Type.class, "Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getType_BaseType(), this.getType(), null, "baseType", null, 0, -1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getType_Property(), this.getProperty(), null, "property", null, 0, -1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getType_AliasName(), this.getString(), "aliasName", null, 0, -1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getType_Abstract(), this.getBoolean(), "abstract", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getType_DataType(), this.getBoolean(), "dataType", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getType_Name(), theXMLTypePackage.getID(), "name", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getType_Open(), this.getBoolean(), "open", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getType_Sequenced(), this.getBoolean(), "sequenced", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getType_Uri(), this.getURI(), "uri", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getType_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typesEClass, Types.class, "Types", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypes_Type(), this.getType(), null, "type", null, 0, -1, Types.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xsdTypeEClass, XSDType.class, "XSDType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getXSDType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, XSDType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize data types
    initEDataType(booleanEDataType, boolean.class, "Boolean", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(booleanObjectEDataType, Boolean.class, "BooleanObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(byteEDataType, byte.class, "Byte", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(byteObjectEDataType, Byte.class, "ByteObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(bytesEDataType, byte[].class, "Bytes", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(characterEDataType, char.class, "Character", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(characterObjectEDataType, Character.class, "CharacterObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(dateEDataType, Date.class, "Date", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(dateTimeEDataType, String.class, "DateTime", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(dayEDataType, String.class, "Day", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(decimalEDataType, BigDecimal.class, "Decimal", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(doubleEDataType, double.class, "Double", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(doubleObjectEDataType, Double.class, "DoubleObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(durationEDataType, String.class, "Duration", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(floatEDataType, float.class, "Float", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(floatObjectEDataType, Float.class, "FloatObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(intEDataType, int.class, "Int", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(integerEDataType, BigInteger.class, "Integer", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(intObjectEDataType, Integer.class, "IntObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(longEDataType, long.class, "Long", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(longObjectEDataType, Long.class, "LongObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(monthEDataType, String.class, "Month", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(monthDayEDataType, String.class, "MonthDay", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(objectEDataType, Object.class, "Object", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(shortEDataType, short.class, "Short", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(shortObjectEDataType, Short.class, "ShortObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(stringEDataType, String.class, "String", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(stringsEDataType, List.class, "Strings", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(timeEDataType, String.class, "Time", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(uriEDataType, String.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(yearEDataType, String.class, "Year", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(yearMonthEDataType, String.class, "YearMonth", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(yearMonthDayEDataType, String.class, "YearMonthDay", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

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
      (baseDataGraphTypeEClass, 
       source, 
       new String[] 
       {
       "name", "BaseDataGraphType",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getBaseDataGraphType_Models(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "models"
       });		
    addAnnotation
      (getBaseDataGraphType_Xsd(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "xsd"
       });		
    addAnnotation
      (getBaseDataGraphType_ChangeSummary(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "changeSummary"
       });		
    addAnnotation
      (getBaseDataGraphType_AnyAttribute(), 
       source, 
       new String[] 
       {
       "kind", "attributeWildcard",
       "wildcards", "##other",
       "name", ":3",
       "processing", "lax"
       });		
    addAnnotation
      (booleanEDataType, 
       source, 
       new String[] 
       {
       "name", "Boolean"
       });		
    addAnnotation
      (booleanObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "Boolean:Object",
       "baseType", "Boolean"
       });		
    addAnnotation
      (byteEDataType, 
       source, 
       new String[] 
       {
       "name", "Byte"
       });		
    addAnnotation
      (byteObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "Byte:Object",
       "baseType", "Byte"
       });		
    addAnnotation
      (bytesEDataType, 
       source, 
       new String[] 
       {
       "name", "Bytes"
       });		
    addAnnotation
      (changeSummaryTypeEClass, 
       source, 
       new String[] 
       {
       "name", "ChangeSummaryType",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getChangeSummaryType_Any(), 
       source, 
       new String[] 
       {
       "kind", "elementWildcard",
       "wildcards", "##any",
       "name", ":0",
       "processing", "lax"
       });		
    addAnnotation
      (getChangeSummaryType_Create(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "create"
       });		
    addAnnotation
      (getChangeSummaryType_Delete(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "delete"
       });		
    addAnnotation
      (getChangeSummaryType_Logging(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "logging"
       });		
    addAnnotation
      (characterEDataType, 
       source, 
       new String[] 
       {
       "name", "Character"
       });		
    addAnnotation
      (characterObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "Character:Object",
       "baseType", "Character"
       });		
    addAnnotation
      (dataGraphTypeEClass, 
       source, 
       new String[] 
       {
       "name", "DataGraphType",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getDataGraphType_Any(), 
       source, 
       new String[] 
       {
       "kind", "elementWildcard",
       "wildcards", "##other",
       "name", ":4",
       "processing", "lax"
       });		
    addAnnotation
      (dataObjectEClass, 
       source, 
       new String[] 
       {
       "name", "DataObject",
       "kind", "empty"
       });		
    addAnnotation
      (dateEDataType, 
       source, 
       new String[] 
       {
       "name", "Date"
       });		
    addAnnotation
      (dateTimeEDataType, 
       source, 
       new String[] 
       {
       "name", "DateTime"
       });		
    addAnnotation
      (dayEDataType, 
       source, 
       new String[] 
       {
       "name", "Day"
       });		
    addAnnotation
      (decimalEDataType, 
       source, 
       new String[] 
       {
       "name", "Decimal"
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
      (getDocumentRoot_Datagraph(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "datagraph",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (getDocumentRoot_DataObject(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "dataObject",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (getDocumentRoot_Type(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "type",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (getDocumentRoot_Types(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "types",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (getDocumentRoot_Ref(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "ref",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (doubleEDataType, 
       source, 
       new String[] 
       {
       "name", "Double"
       });		
    addAnnotation
      (doubleObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "Double:Object",
       "baseType", "Double"
       });		
    addAnnotation
      (durationEDataType, 
       source, 
       new String[] 
       {
       "name", "Duration"
       });		
    addAnnotation
      (floatEDataType, 
       source, 
       new String[] 
       {
       "name", "Float"
       });		
    addAnnotation
      (floatObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "Float:Object",
       "baseType", "Float"
       });		
    addAnnotation
      (intEDataType, 
       source, 
       new String[] 
       {
       "name", "Int"
       });		
    addAnnotation
      (integerEDataType, 
       source, 
       new String[] 
       {
       "name", "Integer"
       });		
    addAnnotation
      (intObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "Int:Object",
       "baseType", "Int"
       });		
    addAnnotation
      (longEDataType, 
       source, 
       new String[] 
       {
       "name", "Long"
       });		
    addAnnotation
      (longObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "Long:Object",
       "baseType", "Long"
       });			
    addAnnotation
      (modelsTypeEClass, 
       source, 
       new String[] 
       {
       "name", "ModelsType",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getModelsType_Any(), 
       source, 
       new String[] 
       {
       "kind", "elementWildcard",
       "wildcards", "##other",
       "name", ":0",
       "processing", "lax"
       });		
    addAnnotation
      (monthEDataType, 
       source, 
       new String[] 
       {
       "name", "Month"
       });		
    addAnnotation
      (monthDayEDataType, 
       source, 
       new String[] 
       {
       "name", "MonthDay"
       });		
    addAnnotation
      (objectEDataType, 
       source, 
       new String[] 
       {
       "name", "Object"
       });		
    addAnnotation
      (propertyEClass, 
       source, 
       new String[] 
       {
       "name", "Property",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getProperty_AliasName(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "aliasName",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (getProperty_Any(), 
       source, 
       new String[] 
       {
       "kind", "elementWildcard",
       "wildcards", "##other",
       "name", ":1",
       "processing", "lax"
       });		
    addAnnotation
      (getProperty_Containment(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "containment"
       });		
    addAnnotation
      (getProperty_Default(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "default"
       });		
    addAnnotation
      (getProperty_Many(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "many"
       });		
    addAnnotation
      (getProperty_Name(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "name"
       });		
    addAnnotation
      (getProperty_Opposite(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "opposite"
       });		
    addAnnotation
      (getProperty_ReadOnly(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "readOnly"
       });		
    addAnnotation
      (getProperty_Type(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "type"
       });		
    addAnnotation
      (getProperty_AnyAttribute(), 
       source, 
       new String[] 
       {
       "kind", "attributeWildcard",
       "wildcards", "##any",
       "name", ":9",
       "processing", "lax"
       });		
    addAnnotation
      (shortEDataType, 
       source, 
       new String[] 
       {
       "name", "Short"
       });		
    addAnnotation
      (shortObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "Short:Object",
       "baseType", "Short"
       });		
    addAnnotation
      (stringEDataType, 
       source, 
       new String[] 
       {
       "name", "String"
       });		
    addAnnotation
      (stringsEDataType, 
       source, 
       new String[] 
       {
       "name", "Strings"
       });		
    addAnnotation
      (textTypeEClass, 
       source, 
       new String[] 
       {
       "name", "TextType",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getTextType_Text(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "text",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (timeEDataType, 
       source, 
       new String[] 
       {
       "name", "Time"
       });		
    addAnnotation
      (typeEClass, 
       source, 
       new String[] 
       {
       "name", "Type",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getType_BaseType(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "baseType",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (getType_Property(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "property",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (getType_AliasName(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "aliasName",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (getType_Any(), 
       source, 
       new String[] 
       {
       "kind", "elementWildcard",
       "wildcards", "##other",
       "name", ":3",
       "processing", "lax"
       });		
    addAnnotation
      (getType_Abstract(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "abstract"
       });		
    addAnnotation
      (getType_DataType(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "dataType"
       });		
    addAnnotation
      (getType_Name(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "name"
       });		
    addAnnotation
      (getType_Open(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "open"
       });		
    addAnnotation
      (getType_Sequenced(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "sequenced"
       });		
    addAnnotation
      (getType_Uri(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "uri"
       });		
    addAnnotation
      (getType_AnyAttribute(), 
       source, 
       new String[] 
       {
       "kind", "attributeWildcard",
       "wildcards", "##any",
       "name", ":10",
       "processing", "lax"
       });		
    addAnnotation
      (typesEClass, 
       source, 
       new String[] 
       {
       "name", "Types",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getTypes_Type(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "type",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (uriEDataType, 
       source, 
       new String[] 
       {
       "name", "URI"
       });			
    addAnnotation
      (xsdTypeEClass, 
       source, 
       new String[] 
       {
       "name", "XSDType",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getXSDType_Any(), 
       source, 
       new String[] 
       {
       "kind", "elementWildcard",
       "wildcards", "http://www.w3.org/2001/XMLSchema",
       "name", ":0",
       "processing", "lax"
       });		
    addAnnotation
      (yearEDataType, 
       source, 
       new String[] 
       {
       "name", "Year"
       });		
    addAnnotation
      (yearMonthEDataType, 
       source, 
       new String[] 
       {
       "name", "YearMonth"
       });		
    addAnnotation
      (yearMonthDayEDataType, 
       source, 
       new String[] 
       {
       "name", "YearMonthDay"
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
     * The meta object literal for the '{@link org.apache.tuscany.sdo.model.impl.BaseDataGraphTypeImpl <em>Base Data Graph Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.model.impl.BaseDataGraphTypeImpl
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getBaseDataGraphType()
     * @generated
     */
    public static final EClass BASE_DATA_GRAPH_TYPE = eINSTANCE.getBaseDataGraphType();

    /**
     * The meta object literal for the '<em><b>Models</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference BASE_DATA_GRAPH_TYPE__MODELS = eINSTANCE.getBaseDataGraphType_Models();

    /**
     * The meta object literal for the '<em><b>Xsd</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference BASE_DATA_GRAPH_TYPE__XSD = eINSTANCE.getBaseDataGraphType_Xsd();

    /**
     * The meta object literal for the '<em><b>Change Summary</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference BASE_DATA_GRAPH_TYPE__CHANGE_SUMMARY = eINSTANCE.getBaseDataGraphType_ChangeSummary();

    /**
     * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute BASE_DATA_GRAPH_TYPE__ANY_ATTRIBUTE = eINSTANCE.getBaseDataGraphType_AnyAttribute();

    /**
     * The meta object literal for the '{@link org.apache.tuscany.sdo.model.impl.ChangeSummaryTypeImpl <em>Change Summary Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.model.impl.ChangeSummaryTypeImpl
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getChangeSummaryType()
     * @generated
     */
    public static final EClass CHANGE_SUMMARY_TYPE = eINSTANCE.getChangeSummaryType();

    /**
     * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute CHANGE_SUMMARY_TYPE__ANY = eINSTANCE.getChangeSummaryType_Any();

    /**
     * The meta object literal for the '<em><b>Create</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute CHANGE_SUMMARY_TYPE__CREATE = eINSTANCE.getChangeSummaryType_Create();

    /**
     * The meta object literal for the '<em><b>Delete</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute CHANGE_SUMMARY_TYPE__DELETE = eINSTANCE.getChangeSummaryType_Delete();

    /**
     * The meta object literal for the '<em><b>Logging</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute CHANGE_SUMMARY_TYPE__LOGGING = eINSTANCE.getChangeSummaryType_Logging();

    /**
     * The meta object literal for the '{@link org.apache.tuscany.sdo.model.impl.DataGraphTypeImpl <em>Data Graph Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.model.impl.DataGraphTypeImpl
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getDataGraphType()
     * @generated
     */
    public static final EClass DATA_GRAPH_TYPE = eINSTANCE.getDataGraphType();

    /**
     * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute DATA_GRAPH_TYPE__ANY = eINSTANCE.getDataGraphType_Any();

    /**
     * The meta object literal for the '{@link org.apache.tuscany.sdo.model.impl.DataObjectImpl <em>Data Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.model.impl.DataObjectImpl
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getDataObject()
     * @generated
     */
    public static final EClass DATA_OBJECT = eINSTANCE.getDataObject();

    /**
     * The meta object literal for the '{@link org.apache.tuscany.sdo.model.impl.DocumentRootImpl <em>Document Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.model.impl.DocumentRootImpl
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getDocumentRoot()
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
     * The meta object literal for the '<em><b>Datagraph</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference DOCUMENT_ROOT__DATAGRAPH = eINSTANCE.getDocumentRoot_Datagraph();

    /**
     * The meta object literal for the '<em><b>Data Object</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference DOCUMENT_ROOT__DATA_OBJECT = eINSTANCE.getDocumentRoot_DataObject();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference DOCUMENT_ROOT__TYPE = eINSTANCE.getDocumentRoot_Type();

    /**
     * The meta object literal for the '<em><b>Types</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference DOCUMENT_ROOT__TYPES = eINSTANCE.getDocumentRoot_Types();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute DOCUMENT_ROOT__REF = eINSTANCE.getDocumentRoot_Ref();

    /**
     * The meta object literal for the '{@link org.apache.tuscany.sdo.model.impl.ModelsTypeImpl <em>Models Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.model.impl.ModelsTypeImpl
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getModelsType()
     * @generated
     */
    public static final EClass MODELS_TYPE = eINSTANCE.getModelsType();

    /**
     * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute MODELS_TYPE__ANY = eINSTANCE.getModelsType_Any();

    /**
     * The meta object literal for the '{@link org.apache.tuscany.sdo.model.impl.PropertyImpl <em>Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.model.impl.PropertyImpl
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getProperty()
     * @generated
     */
    public static final EClass PROPERTY = eINSTANCE.getProperty();

    /**
     * The meta object literal for the '<em><b>Alias Name</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute PROPERTY__ALIAS_NAME = eINSTANCE.getProperty_AliasName();

    /**
     * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute PROPERTY__ANY = eINSTANCE.getProperty_Any();

    /**
     * The meta object literal for the '<em><b>Containment</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute PROPERTY__CONTAINMENT = eINSTANCE.getProperty_Containment();

    /**
     * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute PROPERTY__DEFAULT = eINSTANCE.getProperty_Default();

    /**
     * The meta object literal for the '<em><b>Many</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute PROPERTY__MANY = eINSTANCE.getProperty_Many();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute PROPERTY__NAME = eINSTANCE.getProperty_Name();

    /**
     * The meta object literal for the '<em><b>Opposite</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference PROPERTY__OPPOSITE = eINSTANCE.getProperty_Opposite();

    /**
     * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute PROPERTY__READ_ONLY = eINSTANCE.getProperty_ReadOnly();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference PROPERTY__TYPE = eINSTANCE.getProperty_Type();

    /**
     * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute PROPERTY__ANY_ATTRIBUTE = eINSTANCE.getProperty_AnyAttribute();

    /**
     * The meta object literal for the '{@link org.apache.tuscany.sdo.model.impl.TextTypeImpl <em>Text Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.model.impl.TextTypeImpl
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getTextType()
     * @generated
     */
    public static final EClass TEXT_TYPE = eINSTANCE.getTextType();

    /**
     * The meta object literal for the '<em><b>Text</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute TEXT_TYPE__TEXT = eINSTANCE.getTextType_Text();

    /**
     * The meta object literal for the '{@link org.apache.tuscany.sdo.model.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.model.impl.TypeImpl
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getType()
     * @generated
     */
    public static final EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '<em><b>Base Type</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference TYPE__BASE_TYPE = eINSTANCE.getType_BaseType();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference TYPE__PROPERTY = eINSTANCE.getType_Property();

    /**
     * The meta object literal for the '<em><b>Alias Name</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute TYPE__ALIAS_NAME = eINSTANCE.getType_AliasName();

    /**
     * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute TYPE__ANY = eINSTANCE.getType_Any();

    /**
     * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute TYPE__ABSTRACT = eINSTANCE.getType_Abstract();

    /**
     * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute TYPE__DATA_TYPE = eINSTANCE.getType_DataType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute TYPE__NAME = eINSTANCE.getType_Name();

    /**
     * The meta object literal for the '<em><b>Open</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute TYPE__OPEN = eINSTANCE.getType_Open();

    /**
     * The meta object literal for the '<em><b>Sequenced</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute TYPE__SEQUENCED = eINSTANCE.getType_Sequenced();

    /**
     * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute TYPE__URI = eINSTANCE.getType_Uri();

    /**
     * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute TYPE__ANY_ATTRIBUTE = eINSTANCE.getType_AnyAttribute();

    /**
     * The meta object literal for the '{@link org.apache.tuscany.sdo.model.impl.TypesImpl <em>Types</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.model.impl.TypesImpl
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getTypes()
     * @generated
     */
    public static final EClass TYPES = eINSTANCE.getTypes();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference TYPES__TYPE = eINSTANCE.getTypes_Type();

    /**
     * The meta object literal for the '{@link org.apache.tuscany.sdo.model.impl.XSDTypeImpl <em>XSD Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.model.impl.XSDTypeImpl
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getXSDType()
     * @generated
     */
    public static final EClass XSD_TYPE = eINSTANCE.getXSDType();

    /**
     * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute XSD_TYPE__ANY = eINSTANCE.getXSDType_Any();

    /**
     * The meta object literal for the '<em>Boolean</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getBoolean()
     * @generated
     */
    public static final EDataType BOOLEAN = eINSTANCE.getBoolean();

    /**
     * The meta object literal for the '<em>Boolean Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Boolean
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getBooleanObject()
     * @generated
     */
    public static final EDataType BOOLEAN_OBJECT = eINSTANCE.getBooleanObject();

    /**
     * The meta object literal for the '<em>Byte</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getByte()
     * @generated
     */
    public static final EDataType BYTE = eINSTANCE.getByte();

    /**
     * The meta object literal for the '<em>Byte Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Byte
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getByteObject()
     * @generated
     */
    public static final EDataType BYTE_OBJECT = eINSTANCE.getByteObject();

    /**
     * The meta object literal for the '<em>Bytes</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getBytes()
     * @generated
     */
    public static final EDataType BYTES = eINSTANCE.getBytes();

    /**
     * The meta object literal for the '<em>Character</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getCharacter()
     * @generated
     */
    public static final EDataType CHARACTER = eINSTANCE.getCharacter();

    /**
     * The meta object literal for the '<em>Character Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Character
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getCharacterObject()
     * @generated
     */
    public static final EDataType CHARACTER_OBJECT = eINSTANCE.getCharacterObject();

    /**
     * The meta object literal for the '<em>Date</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.Date
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getDate()
     * @generated
     */
    public static final EDataType DATE = eINSTANCE.getDate();

    /**
     * The meta object literal for the '<em>Date Time</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.String
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getDateTime()
     * @generated
     */
    public static final EDataType DATE_TIME = eINSTANCE.getDateTime();

    /**
     * The meta object literal for the '<em>Day</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.String
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getDay()
     * @generated
     */
    public static final EDataType DAY = eINSTANCE.getDay();

    /**
     * The meta object literal for the '<em>Decimal</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.math.BigDecimal
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getDecimal()
     * @generated
     */
    public static final EDataType DECIMAL = eINSTANCE.getDecimal();

    /**
     * The meta object literal for the '<em>Double</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getDouble()
     * @generated
     */
    public static final EDataType DOUBLE = eINSTANCE.getDouble();

    /**
     * The meta object literal for the '<em>Double Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Double
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getDoubleObject()
     * @generated
     */
    public static final EDataType DOUBLE_OBJECT = eINSTANCE.getDoubleObject();

    /**
     * The meta object literal for the '<em>Duration</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.String
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getDuration()
     * @generated
     */
    public static final EDataType DURATION = eINSTANCE.getDuration();

    /**
     * The meta object literal for the '<em>Float</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getFloat()
     * @generated
     */
    public static final EDataType FLOAT = eINSTANCE.getFloat();

    /**
     * The meta object literal for the '<em>Float Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Float
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getFloatObject()
     * @generated
     */
    public static final EDataType FLOAT_OBJECT = eINSTANCE.getFloatObject();

    /**
     * The meta object literal for the '<em>Int</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getInt()
     * @generated
     */
    public static final EDataType INT = eINSTANCE.getInt();

    /**
     * The meta object literal for the '<em>Integer</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.math.BigInteger
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getInteger()
     * @generated
     */
    public static final EDataType INTEGER = eINSTANCE.getInteger();

    /**
     * The meta object literal for the '<em>Int Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Integer
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getIntObject()
     * @generated
     */
    public static final EDataType INT_OBJECT = eINSTANCE.getIntObject();

    /**
     * The meta object literal for the '<em>Long</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getLong()
     * @generated
     */
    public static final EDataType LONG = eINSTANCE.getLong();

    /**
     * The meta object literal for the '<em>Long Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Long
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getLongObject()
     * @generated
     */
    public static final EDataType LONG_OBJECT = eINSTANCE.getLongObject();

    /**
     * The meta object literal for the '<em>Month</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.String
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getMonth()
     * @generated
     */
    public static final EDataType MONTH = eINSTANCE.getMonth();

    /**
     * The meta object literal for the '<em>Month Day</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.String
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getMonthDay()
     * @generated
     */
    public static final EDataType MONTH_DAY = eINSTANCE.getMonthDay();

    /**
     * The meta object literal for the '<em>Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Object
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getObject()
     * @generated
     */
    public static final EDataType OBJECT = eINSTANCE.getObject();

    /**
     * The meta object literal for the '<em>Short</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getShort()
     * @generated
     */
    public static final EDataType SHORT = eINSTANCE.getShort();

    /**
     * The meta object literal for the '<em>Short Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Short
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getShortObject()
     * @generated
     */
    public static final EDataType SHORT_OBJECT = eINSTANCE.getShortObject();

    /**
     * The meta object literal for the '<em>String</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.String
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getString()
     * @generated
     */
    public static final EDataType STRING = eINSTANCE.getString();

    /**
     * The meta object literal for the '<em>Strings</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.List
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getStrings()
     * @generated
     */
    public static final EDataType STRINGS = eINSTANCE.getStrings();

    /**
     * The meta object literal for the '<em>Time</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.String
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getTime()
     * @generated
     */
    public static final EDataType TIME = eINSTANCE.getTime();

    /**
     * The meta object literal for the '<em>URI</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.String
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getURI()
     * @generated
     */
    public static final EDataType URI = eINSTANCE.getURI();

    /**
     * The meta object literal for the '<em>Year</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.String
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getYear()
     * @generated
     */
    public static final EDataType YEAR = eINSTANCE.getYear();

    /**
     * The meta object literal for the '<em>Year Month</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.String
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getYearMonth()
     * @generated
     */
    public static final EDataType YEAR_MONTH = eINSTANCE.getYearMonth();

    /**
     * The meta object literal for the '<em>Year Month Day</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.String
     * @see org.apache.tuscany.sdo.model.impl.ModelPackageImpl#getYearMonthDay()
     * @generated
     */
    public static final EDataType YEAR_MONTH_DAY = eINSTANCE.getYearMonthDay();

  }

} //ModelPackageImpl
