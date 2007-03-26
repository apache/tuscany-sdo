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
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.model.Property#getAliasName <em>Alias Name</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.Property#getAny <em>Any</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.Property#getName <em>Name</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.Property#isMany <em>Many</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.Property#isContainment <em>Containment</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.Property#getDefault <em>Default</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.Property#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.Property#getType_ <em>Type</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.Property#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.Property#isNullable <em>Nullable</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.Property#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Property extends Serializable
{
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
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.Property#getName <em>Name</em>}' attribute.
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
   * Unsets the value of the '{@link org.apache.tuscany.sdo.model.Property#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetName()
   * @see #getName()
   * @see #setName(String)
   * @generated
   */
  void unsetName();

  /**
   * Returns whether the value of the '{@link org.apache.tuscany.sdo.model.Property#getName <em>Name</em>}' attribute is set.
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
   * Returns the value of the '<em><b>Many</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Many</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Many</em>' attribute.
   * @see #isSetMany()
   * @see #unsetMany()
   * @see #setMany(boolean)
   * @generated
   */
  boolean isMany();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.Property#isMany <em>Many</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Many</em>' attribute.
   * @see #isSetMany()
   * @see #unsetMany()
   * @see #isMany()
   * @generated
   */
  void setMany(boolean value);

  /**
   * Unsets the value of the '{@link org.apache.tuscany.sdo.model.Property#isMany <em>Many</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetMany()
   * @see #isMany()
   * @see #setMany(boolean)
   * @generated
   */
  void unsetMany();

  /**
   * Returns whether the value of the '{@link org.apache.tuscany.sdo.model.Property#isMany <em>Many</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Many</em>' attribute is set.
   * @see #unsetMany()
   * @see #isMany()
   * @see #setMany(boolean)
   * @generated
   */
  boolean isSetMany();

  /**
   * Returns the value of the '<em><b>Containment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Containment</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Containment</em>' attribute.
   * @see #isSetContainment()
   * @see #unsetContainment()
   * @see #setContainment(boolean)
   * @generated
   */
  boolean isContainment();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.Property#isContainment <em>Containment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Containment</em>' attribute.
   * @see #isSetContainment()
   * @see #unsetContainment()
   * @see #isContainment()
   * @generated
   */
  void setContainment(boolean value);

  /**
   * Unsets the value of the '{@link org.apache.tuscany.sdo.model.Property#isContainment <em>Containment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetContainment()
   * @see #isContainment()
   * @see #setContainment(boolean)
   * @generated
   */
  void unsetContainment();

  /**
   * Returns whether the value of the '{@link org.apache.tuscany.sdo.model.Property#isContainment <em>Containment</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Containment</em>' attribute is set.
   * @see #unsetContainment()
   * @see #isContainment()
   * @see #setContainment(boolean)
   * @generated
   */
  boolean isSetContainment();

  /**
   * Returns the value of the '<em><b>Default</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default</em>' attribute.
   * @see #isSetDefault()
   * @see #unsetDefault()
   * @see #setDefault_(String)
   * @generated
   */
  String getDefault_();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.Property#getDefault <em>Default</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default</em>' attribute.
   * @see #isSetDefault()
   * @see #unsetDefault()
   * @see #getDefault_()
   * @generated
   */
  void setDefault_(String value);

  /**
   * Unsets the value of the '{@link org.apache.tuscany.sdo.model.Property#getDefault <em>Default</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDefault()
   * @see #getDefault_()
   * @see #setDefault_(String)
   * @generated
   */
  void unsetDefault();

  /**
   * Returns whether the value of the '{@link org.apache.tuscany.sdo.model.Property#getDefault <em>Default</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Default</em>' attribute is set.
   * @see #unsetDefault()
   * @see #getDefault_()
   * @see #setDefault_(String)
   * @generated
   */
  boolean isSetDefault();

  /**
   * Returns the value of the '<em><b>Read Only</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Read Only</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Read Only</em>' attribute.
   * @see #isSetReadOnly()
   * @see #unsetReadOnly()
   * @see #setReadOnly(boolean)
   * @generated
   */
  boolean isReadOnly();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.Property#isReadOnly <em>Read Only</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Read Only</em>' attribute.
   * @see #isSetReadOnly()
   * @see #unsetReadOnly()
   * @see #isReadOnly()
   * @generated
   */
  void setReadOnly(boolean value);

  /**
   * Unsets the value of the '{@link org.apache.tuscany.sdo.model.Property#isReadOnly <em>Read Only</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetReadOnly()
   * @see #isReadOnly()
   * @see #setReadOnly(boolean)
   * @generated
   */
  void unsetReadOnly();

  /**
   * Returns whether the value of the '{@link org.apache.tuscany.sdo.model.Property#isReadOnly <em>Read Only</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Read Only</em>' attribute is set.
   * @see #unsetReadOnly()
   * @see #isReadOnly()
   * @see #setReadOnly(boolean)
   * @generated
   */
  boolean isSetReadOnly();

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #isSetType()
   * @see #unsetType()
   * @see #setType(Type)
   * @generated
   */
  Type getType_();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.Property#getType_ <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #isSetType()
   * @see #unsetType()
   * @see #getType_()
   * @generated
   */
  void setType(Type value);

  /**
   * Unsets the value of the '{@link org.apache.tuscany.sdo.model.Property#getType_ <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetType()
   * @see #getType_()
   * @see #setType(Type)
   * @generated
   */
  void unsetType();

  /**
   * Returns whether the value of the '{@link org.apache.tuscany.sdo.model.Property#getType_ <em>Type</em>}' reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Type</em>' reference is set.
   * @see #unsetType()
   * @see #getType_()
   * @see #setType(Type)
   * @generated
   */
  boolean isSetType();

  /**
   * Returns the value of the '<em><b>Opposite</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Opposite</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Opposite</em>' reference.
   * @see #isSetOpposite()
   * @see #unsetOpposite()
   * @see #setOpposite_(Property)
   * @generated
   */
  Property getOpposite_();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.Property#getOpposite <em>Opposite</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Opposite</em>' reference.
   * @see #isSetOpposite()
   * @see #unsetOpposite()
   * @see #getOpposite_()
   * @generated
   */
  void setOpposite_(Property value);

  /**
   * Unsets the value of the '{@link org.apache.tuscany.sdo.model.Property#getOpposite <em>Opposite</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetOpposite()
   * @see #getOpposite_()
   * @see #setOpposite_(Property)
   * @generated
   */
  void unsetOpposite();

  /**
   * Returns whether the value of the '{@link org.apache.tuscany.sdo.model.Property#getOpposite <em>Opposite</em>}' reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Opposite</em>' reference is set.
   * @see #unsetOpposite()
   * @see #getOpposite_()
   * @see #setOpposite_(Property)
   * @generated
   */
  boolean isSetOpposite();

  /**
   * Returns the value of the '<em><b>Nullable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nullable</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nullable</em>' attribute.
   * @see #isSetNullable()
   * @see #unsetNullable()
   * @see #setNullable(boolean)
   * @generated
   */
  boolean isNullable();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.Property#isNullable <em>Nullable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Nullable</em>' attribute.
   * @see #isSetNullable()
   * @see #unsetNullable()
   * @see #isNullable()
   * @generated
   */
  void setNullable(boolean value);

  /**
   * Unsets the value of the '{@link org.apache.tuscany.sdo.model.Property#isNullable <em>Nullable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetNullable()
   * @see #isNullable()
   * @see #setNullable(boolean)
   * @generated
   */
  void unsetNullable();

  /**
   * Returns whether the value of the '{@link org.apache.tuscany.sdo.model.Property#isNullable <em>Nullable</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Nullable</em>' attribute is set.
   * @see #unsetNullable()
   * @see #isNullable()
   * @see #setNullable(boolean)
   * @generated
   */
  boolean isSetNullable();

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

} // Property
