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
package org.apache.tuscany.sdo.util.metadata;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Meta Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.util.metadata.JavaMetaData#getFactoryInterface <em>Factory Interface</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.util.metadata.JavaMetaData#getTypeInterface <em>Type Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface JavaMetaData extends Serializable
{
  /**
   * Returns the value of the '<em><b>Factory Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Factory Interface</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Factory Interface</em>' attribute.
   * @see #setFactoryInterface(String)
   * @generated
   */
  String getFactoryInterface();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.util.metadata.JavaMetaData#getFactoryInterface <em>Factory Interface</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Factory Interface</em>' attribute.
   * @see #getFactoryInterface()
   * @generated
   */
  void setFactoryInterface(String value);

  /**
   * Returns the value of the '<em><b>Type Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Interface</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Interface</em>' attribute.
   * @see #setTypeInterface(String)
   * @generated
   */
  String getTypeInterface();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.util.metadata.JavaMetaData#getTypeInterface <em>Type Interface</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Interface</em>' attribute.
   * @see #getTypeInterface()
   * @generated
   */
  void setTypeInterface(String value);

} // JavaMetaData
