/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.example.subgroup;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>A</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.example.subgroup.A#getGe1Group <em>Ge1 Group</em>}</li>
 *   <li>{@link com.example.subgroup.A#getGe1 <em>Ge1</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface A extends Serializable
{
  /**
   * Returns the value of the '<em><b>Ge1 Group</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ge1 Group</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ge1 Group</em>' attribute list.
   * @generated
   */
  Sequence getGe1Group();

  /**
   * Returns the value of the '<em><b>Ge1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ge1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ge1</em>' containment reference.
   * @see #isSetGe1()
   * @see #unsetGe1()
   * @see #setGe1(B)
   * @generated
   */
  B getGe1();

  /**
   * Sets the value of the '{@link com.example.subgroup.A#getGe1 <em>Ge1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ge1</em>' containment reference.
   * @see #isSetGe1()
   * @see #unsetGe1()
   * @see #getGe1()
   * @generated
   */
  void setGe1(B value);

  /**
   * Unsets the value of the '{@link com.example.subgroup.A#getGe1 <em>Ge1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetGe1()
   * @see #getGe1()
   * @see #setGe1(B)
   * @generated
   */
  void unsetGe1();

  /**
   * Returns whether the value of the '{@link com.example.subgroup.A#getGe1 <em>Ge1</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Ge1</em>' containment reference is set.
   * @see #unsetGe1()
   * @see #getGe1()
   * @see #setGe1(B)
   * @generated
   */
  boolean isSetGe1();

} // A
