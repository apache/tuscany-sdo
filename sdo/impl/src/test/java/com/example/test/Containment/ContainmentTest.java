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
package com.example.test.Containment;

import commonj.sdo.Sequence;

import java.io.Serializable;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.example.test.Containment.ContainmentTest#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.example.test.Containment.ContainmentTest#getName <em>Name</em>}</li>
 *   <li>{@link com.example.test.Containment.ContainmentTest#getContain <em>Contain</em>}</li>
 *   <li>{@link com.example.test.Containment.ContainmentTest#getContainMany <em>Contain Many</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface ContainmentTest extends Serializable
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
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #isSetName()
   * @see #unsetName()
   * @see #setName(String)
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.example.test.Containment.ContainmentTest#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #isSetName()
   * @see #unsetName()
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Unsets the value of the '{@link com.example.test.Containment.ContainmentTest#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetName()
   * @see #getName()
   * @see #setName(String)
   * @generated
   */
  void unsetName();

  /**
   * Returns whether the value of the '{@link com.example.test.Containment.ContainmentTest#getName <em>Name</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Name</em>' attribute is set.
   * @see #unsetName()
   * @see #getName()
   * @see #setName(String)
   * @generated
   */
  boolean isSetName();

  /**
   * Returns the value of the '<em><b>Contain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contain</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contain</em>' containment reference.
   * @see #isSetContain()
   * @see #unsetContain()
   * @see #setContain(ContainmentTest)
   * @generated
   */
  ContainmentTest getContain();

  /**
   * Sets the value of the '{@link com.example.test.Containment.ContainmentTest#getContain <em>Contain</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Contain</em>' containment reference.
   * @see #isSetContain()
   * @see #unsetContain()
   * @see #getContain()
   * @generated
   */
  void setContain(ContainmentTest value);

  /**
   * Unsets the value of the '{@link com.example.test.Containment.ContainmentTest#getContain <em>Contain</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetContain()
   * @see #getContain()
   * @see #setContain(ContainmentTest)
   * @generated
   */
  void unsetContain();

  /**
   * Returns whether the value of the '{@link com.example.test.Containment.ContainmentTest#getContain <em>Contain</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Contain</em>' containment reference is set.
   * @see #unsetContain()
   * @see #getContain()
   * @see #setContain(ContainmentTest)
   * @generated
   */
  boolean isSetContain();

  /**
   * Returns the value of the '<em><b>Contain Many</b></em>' containment reference list.
   * The list contents are of type {@link com.example.test.Containment.ContainmentTest}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contain Many</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contain Many</em>' containment reference list.
   * @generated
   */
  List getContainMany();

} // ContainmentTest
