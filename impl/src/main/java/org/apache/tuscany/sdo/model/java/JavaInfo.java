/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.sdo.model.java;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.model.java.JavaInfo#getJavaClass <em>Java Class</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface JavaInfo extends Serializable
{
  /**
   * Returns the value of the '<em><b>Java Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Java Class</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Java Class</em>' attribute.
   * @see #isSetJavaClass()
   * @see #unsetJavaClass()
   * @see #setJavaClass(String)
   * @generated
   */
  String getJavaClass();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.java.JavaInfo#getJavaClass <em>Java Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Java Class</em>' attribute.
   * @see #isSetJavaClass()
   * @see #unsetJavaClass()
   * @see #getJavaClass()
   * @generated
   */
  void setJavaClass(String value);

  /**
   * Unsets the value of the '{@link org.apache.tuscany.sdo.model.java.JavaInfo#getJavaClass <em>Java Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetJavaClass()
   * @see #getJavaClass()
   * @see #setJavaClass(String)
   * @generated
   */
  void unsetJavaClass();

  /**
   * Returns whether the value of the '{@link org.apache.tuscany.sdo.model.java.JavaInfo#getJavaClass <em>Java Class</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Java Class</em>' attribute is set.
   * @see #unsetJavaClass()
   * @see #getJavaClass()
   * @see #setJavaClass(String)
   * @generated
   */
  boolean isSetJavaClass();

} // JavaInfo
