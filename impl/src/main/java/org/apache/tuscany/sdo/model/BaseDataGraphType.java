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
package org.apache.tuscany.sdo.model;

import commonj.sdo.ChangeSummary;
import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base Data Graph Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getModels <em>Models</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getXsd <em>Xsd</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getChangeSummary <em>Change Summary</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface BaseDataGraphType extends Serializable
{
  /**
   * Returns the value of the '<em><b>Models</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Models</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Models</em>' containment reference.
   * @see #isSetModels()
   * @see #unsetModels()
   * @see #setModels(ModelsType)
   * @generated
   */
  ModelsType getModels();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getModels <em>Models</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Models</em>' containment reference.
   * @see #isSetModels()
   * @see #unsetModels()
   * @see #getModels()
   * @generated
   */
  void setModels(ModelsType value);

  /**
   * Unsets the value of the '{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getModels <em>Models</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetModels()
   * @see #getModels()
   * @see #setModels(ModelsType)
   * @generated
   */
  void unsetModels();

  /**
   * Returns whether the value of the '{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getModels <em>Models</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Models</em>' containment reference is set.
   * @see #unsetModels()
   * @see #getModels()
   * @see #setModels(ModelsType)
   * @generated
   */
  boolean isSetModels();

  /**
   * Returns the value of the '<em><b>Xsd</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Xsd</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Xsd</em>' containment reference.
   * @see #isSetXsd()
   * @see #unsetXsd()
   * @see #setXsd(XSDType)
   * @generated
   */
  XSDType getXsd();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getXsd <em>Xsd</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Xsd</em>' containment reference.
   * @see #isSetXsd()
   * @see #unsetXsd()
   * @see #getXsd()
   * @generated
   */
  void setXsd(XSDType value);

  /**
   * Unsets the value of the '{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getXsd <em>Xsd</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetXsd()
   * @see #getXsd()
   * @see #setXsd(XSDType)
   * @generated
   */
  void unsetXsd();

  /**
   * Returns whether the value of the '{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getXsd <em>Xsd</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Xsd</em>' containment reference is set.
   * @see #unsetXsd()
   * @see #getXsd()
   * @see #setXsd(XSDType)
   * @generated
   */
  boolean isSetXsd();

  /**
   * Returns the value of the '<em><b>Change Summary</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Change Summary</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Change Summary</em>' attribute.
   * @see #isSetChangeSummary()
   * @see #unsetChangeSummary()
   * @see #setChangeSummary(ChangeSummary)
   * @generated
   */
  ChangeSummary getChangeSummary();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getChangeSummary <em>Change Summary</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Change Summary</em>' attribute.
   * @see #isSetChangeSummary()
   * @see #unsetChangeSummary()
   * @see #getChangeSummary()
   * @generated
   */
  void setChangeSummary(ChangeSummary value);

  /**
   * Unsets the value of the '{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getChangeSummary <em>Change Summary</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetChangeSummary()
   * @see #getChangeSummary()
   * @see #setChangeSummary(ChangeSummary)
   * @generated
   */
  void unsetChangeSummary();

  /**
   * Returns whether the value of the '{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getChangeSummary <em>Change Summary</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Change Summary</em>' attribute is set.
   * @see #unsetChangeSummary()
   * @see #getChangeSummary()
   * @see #setChangeSummary(ChangeSummary)
   * @generated
   */
  boolean isSetChangeSummary();

  /**
   * Returns the value of the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Any Attribute</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Any Attribute</em>' attribute list.
   * @generated
   */
  Sequence getAnyAttribute();

} // BaseDataGraphType
