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

import commonj.sdo.Sequence;

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
 * @generated
 */
public interface BaseDataGraphType
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
   * @see #setModels(ModelsType)
   * @generated
   */
  ModelsType getModels();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getModels <em>Models</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Models</em>' containment reference.
   * @see #getModels()
   * @generated
   */
  void setModels(ModelsType value);

  /**
   * Returns the value of the '<em><b>Xsd</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Xsd</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Xsd</em>' containment reference.
   * @see #setXsd(XSDType)
   * @generated
   */
  XSDType getXsd();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getXsd <em>Xsd</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Xsd</em>' containment reference.
   * @see #getXsd()
   * @generated
   */
  void setXsd(XSDType value);

  /**
   * Returns the value of the '<em><b>Change Summary</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Change Summary</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Change Summary</em>' containment reference.
   * @see #setChangeSummary(ChangeSummaryType)
   * @generated
   */
  ChangeSummaryType getChangeSummary_();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getChangeSummary <em>Change Summary</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Change Summary</em>' containment reference.
   * @see #getChangeSummary()
   * @generated
   */
  void setChangeSummary(ChangeSummaryType value);

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
