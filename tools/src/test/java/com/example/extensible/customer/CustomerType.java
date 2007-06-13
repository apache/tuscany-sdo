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
package com.example.extensible.customer;

import java.io.Serializable;

import java.math.BigInteger;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.example.extensible.customer.CustomerType#getName <em>Name</em>}</li>
 *   <li>{@link com.example.extensible.customer.CustomerType#getNumber <em>Number</em>}</li>
 *   <li>{@link com.example.extensible.customer.CustomerType#getInfo <em>Info</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface CustomerType extends Serializable
{
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
   * Sets the value of the '{@link com.example.extensible.customer.CustomerType#getName <em>Name</em>}' attribute.
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
   * Unsets the value of the '{@link com.example.extensible.customer.CustomerType#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetName()
   * @see #getName()
   * @see #setName(String)
   * @generated
   */
  void unsetName();

  /**
   * Returns whether the value of the '{@link com.example.extensible.customer.CustomerType#getName <em>Name</em>}' attribute is set.
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
   * Returns the value of the '<em><b>Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Number</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Number</em>' attribute.
   * @see #isSetNumber()
   * @see #unsetNumber()
   * @see #setNumber(BigInteger)
   * @generated
   */
  BigInteger getNumber();

  /**
   * Sets the value of the '{@link com.example.extensible.customer.CustomerType#getNumber <em>Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Number</em>' attribute.
   * @see #isSetNumber()
   * @see #unsetNumber()
   * @see #getNumber()
   * @generated
   */
  void setNumber(BigInteger value);

  /**
   * Unsets the value of the '{@link com.example.extensible.customer.CustomerType#getNumber <em>Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetNumber()
   * @see #getNumber()
   * @see #setNumber(BigInteger)
   * @generated
   */
  void unsetNumber();

  /**
   * Returns whether the value of the '{@link com.example.extensible.customer.CustomerType#getNumber <em>Number</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Number</em>' attribute is set.
   * @see #unsetNumber()
   * @see #getNumber()
   * @see #setNumber(BigInteger)
   * @generated
   */
  boolean isSetNumber();

  /**
   * Returns the value of the '<em><b>Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Info</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Info</em>' containment reference.
   * @see #isSetInfo()
   * @see #unsetInfo()
   * @see #setInfo(InfoType)
   * @generated
   */
  InfoType getInfo();

  /**
   * Sets the value of the '{@link com.example.extensible.customer.CustomerType#getInfo <em>Info</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Info</em>' containment reference.
   * @see #isSetInfo()
   * @see #unsetInfo()
   * @see #getInfo()
   * @generated
   */
  void setInfo(InfoType value);

  /**
   * Unsets the value of the '{@link com.example.extensible.customer.CustomerType#getInfo <em>Info</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetInfo()
   * @see #getInfo()
   * @see #setInfo(InfoType)
   * @generated
   */
  void unsetInfo();

  /**
   * Returns whether the value of the '{@link com.example.extensible.customer.CustomerType#getInfo <em>Info</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Info</em>' containment reference is set.
   * @see #unsetInfo()
   * @see #getInfo()
   * @see #setInfo(InfoType)
   * @generated
   */
  boolean isSetInfo();

} // CustomerType
