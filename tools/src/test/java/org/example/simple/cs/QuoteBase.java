/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.simple.cs;

import org.apache.tuscany.sdo.model.ChangeSummaryType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Quote Base</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.example.simple.cs.QuoteBase#getChanges <em>Changes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public interface QuoteBase extends Quote
{
  /**
   * Returns the value of the '<em><b>Changes</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Changes</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Changes</em>' reference.
   * @see #setChanges(ChangeSummaryType)
   * @generated
   */
  ChangeSummaryType getChanges();

  /**
   * Sets the value of the '{@link org.example.simple.cs.QuoteBase#getChanges <em>Changes</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Changes</em>' reference.
   * @see #getChanges()
   * @generated
   */
  void setChanges(ChangeSummaryType value);

} // QuoteBase
