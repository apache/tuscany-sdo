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
package com.example.customer;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Customer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.example.customer.Customer#getAccount <em>Account</em>}</li>
 *   <li>{@link com.example.customer.Customer#getFirstName <em>First Name</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Customer extends Serializable
{
  /**
   * Returns the value of the '<em><b>Account</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Account</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Account</em>' containment reference.
   * @see #isSetAccount()
   * @see #unsetAccount()
   * @see #setAccount(Account)
   * @generated
   */
  Account getAccount();

  /**
   * Sets the value of the '{@link com.example.customer.Customer#getAccount <em>Account</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Account</em>' containment reference.
   * @see #isSetAccount()
   * @see #unsetAccount()
   * @see #getAccount()
   * @generated
   */
  void setAccount(Account value);

  /**
   * Unsets the value of the '{@link com.example.customer.Customer#getAccount <em>Account</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetAccount()
   * @see #getAccount()
   * @see #setAccount(Account)
   * @generated
   */
  void unsetAccount();

  /**
   * Returns whether the value of the '{@link com.example.customer.Customer#getAccount <em>Account</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Account</em>' containment reference is set.
   * @see #unsetAccount()
   * @see #getAccount()
   * @see #setAccount(Account)
   * @generated
   */
  boolean isSetAccount();

  /**
   * Returns the value of the '<em><b>First Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>First Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>First Name</em>' attribute.
   * @see #isSetFirstName()
   * @see #unsetFirstName()
   * @see #setFirstName(String)
   * @generated
   */
  String getFirstName();

  /**
   * Sets the value of the '{@link com.example.customer.Customer#getFirstName <em>First Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>First Name</em>' attribute.
   * @see #isSetFirstName()
   * @see #unsetFirstName()
   * @see #getFirstName()
   * @generated
   */
  void setFirstName(String value);

  /**
   * Unsets the value of the '{@link com.example.customer.Customer#getFirstName <em>First Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetFirstName()
   * @see #getFirstName()
   * @see #setFirstName(String)
   * @generated
   */
  void unsetFirstName();

  /**
   * Returns whether the value of the '{@link com.example.customer.Customer#getFirstName <em>First Name</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>First Name</em>' attribute is set.
   * @see #unsetFirstName()
   * @see #getFirstName()
   * @see #setFirstName(String)
   * @generated
   */
  boolean isSetFirstName();

} // Customer
