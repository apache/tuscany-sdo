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

import commonj.sdo.ChangeSummary;
import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EStructuralFeature;

import commonj.sdo.Property;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.apache.tuscany.sdo.SDOPackage
 * @generated
 */
public interface SDOFactory extends EFactory{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SDOFactory eINSTANCE = org.apache.tuscany.sdo.impl.SDOFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Change Summary</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Change Summary</em>'.
   * @generated
   */
  ChangeSummary createChangeSummary();

  /**
   * Returns a new object of class '<em>Change Summary Setting</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Change Summary Setting</em>'.
   * @generated
   */
  ChangeSummary.Setting createChangeSummarySetting();

  /**
   * Returns a new object of class '<em>Data Graph</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Graph</em>'.
   * @generated
   */
  DataGraph createDataGraph();

  /**
   * Returns a new object of class '<em>Any Type Data Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Any Type Data Object</em>'.
   * @generated
   */
  AnyTypeDataObject createAnyTypeDataObject();

  /**
   * Returns a new object of class '<em>Simple Any Type Data Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Simple Any Type Data Object</em>'.
   * @generated
   */
  SimpleAnyTypeDataObject createSimpleAnyTypeDataObject();

  /**
   * Returns a new object of class '<em>Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class</em>'.
   * @generated
   */
  Type createClass();

  /**
   * Returns a new object of class '<em>Data Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Type</em>'.
   * @generated
   */
  Type createDataType();

  /**
   * Returns a new object of class '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute</em>'.
   * @generated
   */
  Property createAttribute();

  /**
   * Returns a new object of class '<em>Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reference</em>'.
   * @generated
   */
  Property createReference();

  /**
   * Returns a new object of class '<em>Enum</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum</em>'.
   * @generated
   */
  Type createEnum();

  /**
   * Returns a new object of class '<em>Dynamic Data Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Dynamic Data Object</em>'.
   * @generated
   */
  DataObject createDynamicDataObject();

  /**
   * Returns a new object of class '<em>Store Data Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Store Data Object</em>'.
   * @generated
   */
  DataObject createStoreDataObject();

  /**
   * Returns a new object of class '<em>Dynamic Store Data Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Dynamic Store Data Object</em>'.
   * @generated
   */
  DataObject createDynamicStoreDataObject();

  /**
   * Returns a new object of class '<em>Extensible Data Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Extensible Data Object</em>'.
   * @generated
   */
  DataObject createExtensibleDataObject();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  SDOPackage getSDOPackage();

  ChangeSummary.Setting createChangeSummarySetting(EStructuralFeature eStructuralFeature, Object value, boolean isSet);

} //SDOFactory
