/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.example.sequences;

import commonj.sdo.Sequence;

import java.io.Serializable;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Two RCs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.example.sequences.TwoRCs#getGroup <em>Group</em>}</li>
 *   <li>{@link com.example.sequences.TwoRCs#getA <em>A</em>}</li>
 *   <li>{@link com.example.sequences.TwoRCs#getB <em>B</em>}</li>
 *   <li>{@link com.example.sequences.TwoRCs#getSplit <em>Split</em>}</li>
 *   <li>{@link com.example.sequences.TwoRCs#getGroup1 <em>Group1</em>}</li>
 *   <li>{@link com.example.sequences.TwoRCs#getY <em>Y</em>}</li>
 *   <li>{@link com.example.sequences.TwoRCs#getZ <em>Z</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface TwoRCs extends Serializable
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
   * Sets the value of the '{@link com.example.sequences.TwoRCs#getSplit <em>Split</em>}' attribute.
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
   * Unsets the value of the '{@link com.example.sequences.TwoRCs#getSplit <em>Split</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetSplit()
   * @see #getSplit()
   * @see #setSplit(String)
   * @generated
   */
  void unsetSplit();

  /**
   * Returns whether the value of the '{@link com.example.sequences.TwoRCs#getSplit <em>Split</em>}' attribute is set.
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

} // TwoRCs
