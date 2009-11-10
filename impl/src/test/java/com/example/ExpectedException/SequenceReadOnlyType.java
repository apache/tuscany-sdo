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
package com.example.ExpectedException;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Read Only Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.example.ExpectedException.SequenceReadOnlyType#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.example.ExpectedException.SequenceReadOnlyType#getReadOnlyVal <em>Read Only Val</em>}</li>
 *   <li>{@link com.example.ExpectedException.SequenceReadOnlyType#getReadOnlyListVal <em>Read Only List Val</em>}</li>
 *   <li>{@link com.example.ExpectedException.SequenceReadOnlyType#getUniqueName <em>Unique Name</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface SequenceReadOnlyType extends Serializable
{
  /**
   * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mixed</em>' attribute list.
   * @generated
   */
  Sequence getMixed();

  /**
   * Returns the value of the '<em><b>Read Only Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Read Only Val</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Read Only Val</em>' attribute.
   * @see #isSetReadOnlyVal()
   * @generated
   */
  String getReadOnlyVal();

  /**
   * Returns whether the value of the '{@link com.example.ExpectedException.SequenceReadOnlyType#getReadOnlyVal <em>Read Only Val</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Read Only Val</em>' attribute is set.
   * @see #getReadOnlyVal()
   * @generated
   */
  boolean isSetReadOnlyVal();

  /**
   * Returns the value of the '<em><b>Read Only List Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Read Only List Val</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Read Only List Val</em>' attribute.
   * @see #isSetReadOnlyListVal()
   * @generated
   */
  String getReadOnlyListVal();

  /**
   * Returns whether the value of the '{@link com.example.ExpectedException.SequenceReadOnlyType#getReadOnlyListVal <em>Read Only List Val</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Read Only List Val</em>' attribute is set.
   * @see #getReadOnlyListVal()
   * @generated
   */
  boolean isSetReadOnlyListVal();

  /**
   * Returns the value of the '<em><b>Unique Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unique Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unique Name</em>' attribute.
   * @see #isSetUniqueName()
   * @see #unsetUniqueName()
   * @see #setUniqueName(String)
   * @generated
   */
  String getUniqueName();

  /**
   * Sets the value of the '{@link com.example.ExpectedException.SequenceReadOnlyType#getUniqueName <em>Unique Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unique Name</em>' attribute.
   * @see #isSetUniqueName()
   * @see #unsetUniqueName()
   * @see #getUniqueName()
   * @generated
   */
  void setUniqueName(String value);

  /**
   * Unsets the value of the '{@link com.example.ExpectedException.SequenceReadOnlyType#getUniqueName <em>Unique Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetUniqueName()
   * @see #getUniqueName()
   * @see #setUniqueName(String)
   * @generated
   */
  void unsetUniqueName();

  /**
   * Returns whether the value of the '{@link com.example.ExpectedException.SequenceReadOnlyType#getUniqueName <em>Unique Name</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Unique Name</em>' attribute is set.
   * @see #unsetUniqueName()
   * @see #getUniqueName()
   * @see #setUniqueName(String)
   * @generated
   */
  boolean isSetUniqueName();

} // SequenceReadOnlyType
