/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.example.ExpectedException;

import commonj.sdo.helper.HelperContext;


/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @generated
 */
public interface ExpectedExceptionFactory
{

  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ExpectedExceptionFactory INSTANCE = com.example.ExpectedException.impl.ExpectedExceptionFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type</em>'.
   * @generated
   */
  ExpectedExceptionType createExpectedExceptionType();

  /**
   * Returns a new object of class '<em>Sequence Read Only Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sequence Read Only Type</em>'.
   * @generated
   */
  SequenceReadOnlyType createSequenceReadOnlyType();

  /**
   * Registers the types supported by this Factory within the supplied scope.argument
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param scope an instance of HelperContext used to manage the scoping of types.
   * @generated
   */
  public void register(HelperContext scope);
   
} //ExpectedExceptionFactory
