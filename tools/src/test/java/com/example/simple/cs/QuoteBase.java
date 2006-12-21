/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.example.simple.cs;

import commonj.sdo.ChangeSummary;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Quote Base</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.example.simple.cs.QuoteBase#getChanges <em>Changes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public interface QuoteBase extends Quote
{
  /**
   * Returns the value of the '<em><b>Changes</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Changes</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Changes</em>' attribute.
   * @see #setChanges(ChangeSummary)
   * @generated
   */
  ChangeSummary getChanges();

  /**
   * Sets the value of the '{@link com.example.simple.cs.QuoteBase#getChanges <em>Changes</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Changes</em>' attribute.
   * @see #getChanges()
   * @generated
   */
  void setChanges(ChangeSummary value);

} // QuoteBase
