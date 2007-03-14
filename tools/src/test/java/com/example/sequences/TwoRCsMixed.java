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
package com.example.sequences;

import commonj.sdo.Sequence;

import java.io.Serializable;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Two RCs Mixed</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.example.sequences.TwoRCsMixed#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.example.sequences.TwoRCsMixed#getGroup <em>Group</em>}</li>
 *   <li>{@link com.example.sequences.TwoRCsMixed#getA <em>A</em>}</li>
 *   <li>{@link com.example.sequences.TwoRCsMixed#getB <em>B</em>}</li>
 *   <li>{@link com.example.sequences.TwoRCsMixed#getSplit <em>Split</em>}</li>
 *   <li>{@link com.example.sequences.TwoRCsMixed#getGroup1 <em>Group1</em>}</li>
 *   <li>{@link com.example.sequences.TwoRCsMixed#getY <em>Y</em>}</li>
 *   <li>{@link com.example.sequences.TwoRCsMixed#getZ <em>Z</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface TwoRCsMixed extends Serializable
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
   * Returns the value of the '<em><b>Group</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group</em>' attribute list.
   * @generated
   */
  Sequence getGroup();

  /**
   * Returns the value of the '<em><b>A</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>A</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>A</em>' attribute list.
   * @generated
   */
  List getA();

  /**
   * Returns the value of the '<em><b>B</b></em>' attribute list.
   * The list contents are of type {@link java.lang.Integer}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>B</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>B</em>' attribute list.
   * @generated
   */
  List getB();

  /**
   * Returns the value of the '<em><b>Split</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Split</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Split</em>' attribute.
   * @see #isSetSplit()
   * @see #unsetSplit()
   * @see #setSplit(String)
   * @generated
   */
  String getSplit();

  /**
   * Sets the value of the '{@link com.example.sequences.TwoRCsMixed#getSplit <em>Split</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Split</em>' attribute.
   * @see #isSetSplit()
   * @see #unsetSplit()
   * @see #getSplit()
   * @generated
   */
  void setSplit(String value);

  /**
   * Unsets the value of the '{@link com.example.sequences.TwoRCsMixed#getSplit <em>Split</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetSplit()
   * @see #getSplit()
   * @see #setSplit(String)
   * @generated
   */
  void unsetSplit();

  /**
   * Returns whether the value of the '{@link com.example.sequences.TwoRCsMixed#getSplit <em>Split</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Split</em>' attribute is set.
   * @see #unsetSplit()
   * @see #getSplit()
   * @see #setSplit(String)
   * @generated
   */
  boolean isSetSplit();

  /**
   * Returns the value of the '<em><b>Group1</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group1</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group1</em>' attribute list.
   * @generated
   */
  Sequence getGroup1();

  /**
   * Returns the value of the '<em><b>Y</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Y</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Y</em>' attribute list.
   * @generated
   */
  List getY();

  /**
   * Returns the value of the '<em><b>Z</b></em>' attribute list.
   * The list contents are of type {@link java.lang.Integer}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Z</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Z</em>' attribute list.
   * @generated
   */
  List getZ();

} // TwoRCsMixed
