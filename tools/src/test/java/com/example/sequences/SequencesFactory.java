/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.example.sequences;

import commonj.sdo.helper.HelperContext;


/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @generated
 */
public interface SequencesFactory
{

  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SequencesFactory INSTANCE = com.example.sequences.impl.SequencesFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Mixed Quote</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mixed Quote</em>'.
   * @generated
   */
  MixedQuote createMixedQuote();

  /**
   * Returns a new object of class '<em>Mixed Repeating Choice</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mixed Repeating Choice</em>'.
   * @generated
   */
  MixedRepeatingChoice createMixedRepeatingChoice();

  /**
   * Returns a new object of class '<em>Repeating Choice</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Repeating Choice</em>'.
   * @generated
   */
  RepeatingChoice createRepeatingChoice();

  /**
   * Returns a new object of class '<em>Two RCs</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Two RCs</em>'.
   * @generated
   */
  TwoRCs createTwoRCs();

  /**
   * Returns a new object of class '<em>Two RCs Mixed</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Two RCs Mixed</em>'.
   * @generated
   */
  TwoRCsMixed createTwoRCsMixed();

  /**
   * Registers the types supported by this Factory within the supplied scope.argument
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param scope an instance of HelperContext used to manage the scoping of types.
   * @generated
   */
  public void register(HelperContext scope);
   
} //SequencesFactory
