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

import commonj.sdo.Sequence;

import java.io.Serializable;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.model.Type#getBaseType <em>Base Type</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.Type#getProperty <em>Property</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.Type#getAliasName <em>Alias Name</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.Type#getAny <em>Any</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.Type#getName <em>Name</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.Type#getUri <em>Uri</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.Type#isDataType <em>Data Type</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.Type#isOpen <em>Open</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.Type#isSequenced <em>Sequenced</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.Type#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.Type#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Type extends Serializable
{
  /**
   * Returns the value of the '<em><b>Base Type</b></em>' reference list.
   * The list contents are of type {@link org.apache.tuscany.sdo.model.Type}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Base Type</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Base Type</em>' reference list.
   * @generated
   */
  List getBaseType();

  /**
   * Returns the value of the '<em><b>Property</b></em>' containment reference list.
   * The list contents are of type {@link org.apache.tuscany.sdo.model.Property}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property</em>' containment reference list.
   * @generated
   */
  List getProperty();

  /**
   * Returns the value of the '<em><b>Alias Name</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Alias Name</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Alias Name</em>' attribute list.
   * @generated
   */
  List getAliasName();

  /**
   * Returns the value of the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Any</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Any</em>' attribute list.
   * @generated
   */
  Sequence getAny();

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
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.Type#getName <em>Name</em>}' attribute.
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
   * Unsets the value of the '{@link org.apache.tuscany.sdo.model.Type#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetName()
   * @see #getName()
   * @see #setName(String)
   * @generated
   */
  void unsetName();

  /**
   * Returns whether the value of the '{@link org.apache.tuscany.sdo.model.Type#getName <em>Name</em>}' attribute is set.
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
   * Returns the value of the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Uri</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Uri</em>' attribute.
   * @see #isSetUri()
   * @see #unsetUri()
   * @see #setUri(String)
   * @generated
   */
  String getUri();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.Type#getUri <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Uri</em>' attribute.
   * @see #isSetUri()
   * @see #unsetUri()
   * @see #getUri()
   * @generated
   */
  void setUri(String value);

  /**
   * Unsets the value of the '{@link org.apache.tuscany.sdo.model.Type#getUri <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetUri()
   * @see #getUri()
   * @see #setUri(String)
   * @generated
   */
  void unsetUri();

  /**
   * Returns whether the value of the '{@link org.apache.tuscany.sdo.model.Type#getUri <em>Uri</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Uri</em>' attribute is set.
   * @see #unsetUri()
   * @see #getUri()
   * @see #setUri(String)
   * @generated
   */
  boolean isSetUri();

  /**
   * Returns the value of the '<em><b>Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data Type</em>' attribute.
   * @see #isSetDataType()
   * @see #unsetDataType()
   * @see #setDataType(boolean)
   * @generated
   */
  boolean isDataType();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.Type#isDataType <em>Data Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data Type</em>' attribute.
   * @see #isSetDataType()
   * @see #unsetDataType()
   * @see #isDataType()
   * @generated
   */
  void setDataType(boolean value);

  /**
   * Unsets the value of the '{@link org.apache.tuscany.sdo.model.Type#isDataType <em>Data Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDataType()
   * @see #isDataType()
   * @see #setDataType(boolean)
   * @generated
   */
  void unsetDataType();

  /**
   * Returns whether the value of the '{@link org.apache.tuscany.sdo.model.Type#isDataType <em>Data Type</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Data Type</em>' attribute is set.
   * @see #unsetDataType()
   * @see #isDataType()
   * @see #setDataType(boolean)
   * @generated
   */
  boolean isSetDataType();

  /**
   * Returns the value of the '<em><b>Open</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Open</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Open</em>' attribute.
   * @see #isSetOpen()
   * @see #unsetOpen()
   * @see #setOpen(boolean)
   * @generated
   */
  boolean isOpen();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.Type#isOpen <em>Open</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Open</em>' attribute.
   * @see #isSetOpen()
   * @see #unsetOpen()
   * @see #isOpen()
   * @generated
   */
  void setOpen(boolean value);

  /**
   * Unsets the value of the '{@link org.apache.tuscany.sdo.model.Type#isOpen <em>Open</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetOpen()
   * @see #isOpen()
   * @see #setOpen(boolean)
   * @generated
   */
  void unsetOpen();

  /**
   * Returns whether the value of the '{@link org.apache.tuscany.sdo.model.Type#isOpen <em>Open</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Open</em>' attribute is set.
   * @see #unsetOpen()
   * @see #isOpen()
   * @see #setOpen(boolean)
   * @generated
   */
  boolean isSetOpen();

  /**
   * Returns the value of the '<em><b>Sequenced</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sequenced</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sequenced</em>' attribute.
   * @see #isSetSequenced()
   * @see #unsetSequenced()
   * @see #setSequenced(boolean)
   * @generated
   */
  boolean isSequenced();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.Type#isSequenced <em>Sequenced</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sequenced</em>' attribute.
   * @see #isSetSequenced()
   * @see #unsetSequenced()
   * @see #isSequenced()
   * @generated
   */
  void setSequenced(boolean value);

  /**
   * Unsets the value of the '{@link org.apache.tuscany.sdo.model.Type#isSequenced <em>Sequenced</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetSequenced()
   * @see #isSequenced()
   * @see #setSequenced(boolean)
   * @generated
   */
  void unsetSequenced();

  /**
   * Returns whether the value of the '{@link org.apache.tuscany.sdo.model.Type#isSequenced <em>Sequenced</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Sequenced</em>' attribute is set.
   * @see #unsetSequenced()
   * @see #isSequenced()
   * @see #setSequenced(boolean)
   * @generated
   */
  boolean isSetSequenced();

  /**
   * Returns the value of the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abstract</em>' attribute.
   * @see #isSetAbstract()
   * @see #unsetAbstract()
   * @see #setAbstract(boolean)
   * @generated
   */
  boolean isAbstract();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.Type#isAbstract <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Abstract</em>' attribute.
   * @see #isSetAbstract()
   * @see #unsetAbstract()
   * @see #isAbstract()
   * @generated
   */
  void setAbstract(boolean value);

  /**
   * Unsets the value of the '{@link org.apache.tuscany.sdo.model.Type#isAbstract <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetAbstract()
   * @see #isAbstract()
   * @see #setAbstract(boolean)
   * @generated
   */
  void unsetAbstract();

  /**
   * Returns whether the value of the '{@link org.apache.tuscany.sdo.model.Type#isAbstract <em>Abstract</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Abstract</em>' attribute is set.
   * @see #unsetAbstract()
   * @see #isAbstract()
   * @see #setAbstract(boolean)
   * @generated
   */
  boolean isSetAbstract();

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

  String getInstanceClassName();

} // Type
