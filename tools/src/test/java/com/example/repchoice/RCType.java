/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.example.repchoice;

import commonj.sdo.Sequence;

import java.io.Serializable;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>RC Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.example.repchoice.RCType#getGroup <em>Group</em>}</li>
 *   <li>{@link com.example.repchoice.RCType#getS <em>S</em>}</li>
 *   <li>{@link com.example.repchoice.RCType#getI <em>I</em>}</li>
 *   <li>{@link com.example.repchoice.RCType#getF <em>F</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface RCType extends Serializable
{
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
   * Returns the value of the '<em><b>S</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>S</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>S</em>' attribute list.
   * @generated
   */
  List getS();

  /**
   * Returns the value of the '<em><b>I</b></em>' attribute list.
   * The list contents are of type {@link java.lang.Integer}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>I</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>I</em>' attribute list.
   * @generated
   */
  List getI();

  /**
   * Returns the value of the '<em><b>F</b></em>' attribute list.
   * The list contents are of type {@link java.lang.Float}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>F</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>F</em>' attribute list.
   * @generated
   */
  List getF();

} // RCType
