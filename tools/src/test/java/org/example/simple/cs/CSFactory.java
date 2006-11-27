/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.simple.cs;


/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @generated
 */
public interface CSFactory
{

  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CSFactory INSTANCE = org.example.simple.cs.impl.CSFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Quote</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Quote</em>'.
   * @generated
   */
  Quote createQuote();

  /**
   * Returns a new object of class '<em>Quote Base</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Quote Base</em>'.
   * @generated
   */
  QuoteBase createQuoteBase();

} //CSFactory
