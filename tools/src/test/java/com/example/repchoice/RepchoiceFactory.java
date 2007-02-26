/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.example.repchoice;

import commonj.sdo.helper.HelperContext;


/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @generated
 */
public interface RepchoiceFactory
{

  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  RepchoiceFactory INSTANCE = com.example.repchoice.impl.RepchoiceFactoryImpl.init();

  /**
   * Returns a new object of class '<em>RC Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>RC Type</em>'.
   * @generated
   */
  RCType createRCType();

  /**
   * Registers the types supported by this Factory within the supplied scope.argument
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param scope an instance of HelperContext used to manage the scoping of types.
   * @generated
   */
  public void register(HelperContext scope);
   
} //RepchoiceFactory
