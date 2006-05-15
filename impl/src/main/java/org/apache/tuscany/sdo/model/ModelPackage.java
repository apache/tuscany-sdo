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
package org.apache.tuscany.sdo.model;

import org.apache.tuscany.sdo.model.impl.ModelPackageImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

public interface ModelPackage extends EPackage {

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
   * @generated
   */
  public static final String eNS_PREFIX = "commonj";

  public static final ModelPackage eINSTANCE = ModelPackageImpl.eINSTANCE;
  
  public EClass getBaseDataGraphType();
  public EReference getBaseDataGraphType_Models();
  public EReference getBaseDataGraphType_Xsd();
  public EReference getBaseDataGraphType_ChangeSummary();
  public EAttribute getBaseDataGraphType_AnyAttribute();
  public EClass getChangeSummaryType();
  public EAttribute getChangeSummaryType_Any();
  public EAttribute getChangeSummaryType_Create();
  public EAttribute getChangeSummaryType_Delete();
  public EAttribute getChangeSummaryType_Logging();
  public EClass getDataGraphType();
  public EAttribute getDataGraphType_Any();
  public EClass getDataObject();
  public EClass getDocumentRoot();
  public EAttribute getDocumentRoot_Mixed();
  public EReference getDocumentRoot_XMLNSPrefixMap();
  public EReference getDocumentRoot_XSISchemaLocation();
  public EReference getDocumentRoot_Datagraph();
  public EReference getDocumentRoot_DataObject();
  public EReference getDocumentRoot_Type();
  public EReference getDocumentRoot_Types();
  public EAttribute getDocumentRoot_Ref();
  public EClass getModelsType();
  public EAttribute getModelsType_Any();
  public EClass getProperty();
  public EAttribute getProperty_AliasName();
  public EAttribute getProperty_Any();
  public EAttribute getProperty_Containment();
  public EAttribute getProperty_Default();
  public EAttribute getProperty_Many();
  public EAttribute getProperty_Name();
  public EReference getProperty_Opposite();
  public EAttribute getProperty_ReadOnly();
  public EReference getProperty_Type();
  public EAttribute getProperty_AnyAttribute();
  public EClass getTextType();
  public EAttribute getTextType_Text();
  public EClass getType();
  public EReference getType_BaseType();
  public EReference getType_Property();
  public EAttribute getType_AliasName();
  public EAttribute getType_Any();
  public EAttribute getType_Abstract();
  public EAttribute getType_DataType();
  public EAttribute getType_Name();
  public EAttribute getType_Open();
  public EAttribute getType_Sequenced();
  public EAttribute getType_Uri();
  public EAttribute getType_AnyAttribute();
  public EClass getTypes();
  public EReference getTypes_Type();
  public EClass getXSDType();
  public EAttribute getXSDType_Any();
  public EDataType getBoolean();
  public EDataType getBooleanObject();
  public EDataType getByte();
  public EDataType getByteObject();
  public EDataType getBytes();
  public EDataType getCharacter();
  public EDataType getCharacterObject();
  public EDataType getDate();
  public EDataType getDateTime();
  public EDataType getDay();
  public EDataType getDecimal();
  public EDataType getDouble();
  public EDataType getDoubleObject();
  public EDataType getDuration();
  public EDataType getFloat();
  public EDataType getFloatObject();
  public EDataType getInt();
  public EDataType getInteger();
  public EDataType getIntObject();
  public EDataType getLong();
  public EDataType getLongObject();
  public EDataType getMonth();
  public EDataType getMonthDay();
  public EDataType getObject();
  public EDataType getShort();
  public EDataType getShortObject();
  public EDataType getString();
  public EDataType getStrings();
  public EDataType getTime();
  public EDataType getURI();
  public EDataType getYear();
  public EDataType getYearMonth();
  public EDataType getYearMonthDay();
  public ModelFactory getModelFactory();
}
