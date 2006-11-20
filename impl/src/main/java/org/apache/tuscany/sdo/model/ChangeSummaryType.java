/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.sdo.model;

import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Change Summary Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.model.ChangeSummaryType#getAny <em>Any</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.ChangeSummaryType#getCreate <em>Create</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.ChangeSummaryType#getDelete <em>Delete</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.ChangeSummaryType#isLogging <em>Logging</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface ChangeSummaryType extends Serializable
{
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
   * Returns the value of the '<em><b>Create</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Create</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Create</em>' attribute.
   * @see #setCreate(String)
   * @generated
   */
  String getCreate();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.ChangeSummaryType#getCreate <em>Create</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Create</em>' attribute.
   * @see #getCreate()
   * @generated
   */
  void setCreate(String value);

  /**
   * Returns the value of the '<em><b>Delete</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Delete</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Delete</em>' attribute.
   * @see #setDelete(String)
   * @generated
   */
  String getDelete();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.ChangeSummaryType#getDelete <em>Delete</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Delete</em>' attribute.
   * @see #getDelete()
   * @generated
   */
  void setDelete(String value);

  /**
   * Returns the value of the '<em><b>Logging</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Logging</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Logging</em>' attribute.
   * @see #isSetLogging()
   * @see #unsetLogging()
   * @see #setLogging(boolean)
   * @generated
   */
  boolean isLogging();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.ChangeSummaryType#isLogging <em>Logging</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Logging</em>' attribute.
   * @see #isSetLogging()
   * @see #unsetLogging()
   * @see #isLogging()
   * @generated
   */
  void setLogging(boolean value);

  /**
   * Unsets the value of the '{@link org.apache.tuscany.sdo.model.ChangeSummaryType#isLogging <em>Logging</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetLogging()
   * @see #isLogging()
   * @see #setLogging(boolean)
   * @generated
   */
  void unsetLogging();

  /**
   * Returns whether the value of the '{@link org.apache.tuscany.sdo.model.ChangeSummaryType#isLogging <em>Logging</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Logging</em>' attribute is set.
   * @see #unsetLogging()
   * @see #isLogging()
   * @see #setLogging(boolean)
   * @generated
   */
  boolean isSetLogging();

} // ChangeSummaryType
