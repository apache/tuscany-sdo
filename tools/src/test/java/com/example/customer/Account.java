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
 * A representation of the model object '<em><b>Account</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.example.customer.Account#getAccountNum <em>Account Num</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Account extends Serializable
{
  /**
   * Returns the value of the '<em><b>Account Num</b></em>' attribute.
   * The default value is <code>"0"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Account Num</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Account Num</em>' attribute.
   * @see #isSetAccountNum()
   * @see #unsetAccountNum()
   * @see #setAccountNum(int)
   * @generated
   */
  int getAccountNum();

  /**
   * Sets the value of the '{@link com.example.customer.Account#getAccountNum <em>Account Num</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Account Num</em>' attribute.
   * @see #isSetAccountNum()
   * @see #unsetAccountNum()
   * @see #getAccountNum()
   * @generated
   */
  void setAccountNum(int value);

  /**
   * Unsets the value of the '{@link com.example.customer.Account#getAccountNum <em>Account Num</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetAccountNum()
   * @see #getAccountNum()
   * @see #setAccountNum(int)
   * @generated
   */
  void unsetAccountNum();

  /**
   * Returns whether the value of the '{@link com.example.customer.Account#getAccountNum <em>Account Num</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Account Num</em>' attribute is set.
   * @see #unsetAccountNum()
   * @see #getAccountNum()
   * @see #setAccountNum(int)
   * @generated
   */
  boolean isSetAccountNum();

} // Account
