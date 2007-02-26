/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.example.subgroup;

import commonj.sdo.helper.HelperContext;


/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @generated
 */
public interface SubgroupFactory
{

  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SubgroupFactory INSTANCE = com.example.subgroup.impl.SubgroupFactoryImpl.init();

  /**
   * Returns a new object of class '<em>A</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>A</em>'.
   * @generated
   */
  A createA();

  /**
   * Returns a new object of class '<em>B</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>B</em>'.
   * @generated
   */
  B createB();

  /**
   * Returns a new object of class '<em>Bprime</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bprime</em>'.
   * @generated
   */
  Bprime createBprime();

  /**
   * Registers the types supported by this Factory within the supplied scope.argument
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param scope an instance of HelperContext used to manage the scoping of types.
   * @generated
   */
  public void register(HelperContext scope);
   
} //SubgroupFactory
