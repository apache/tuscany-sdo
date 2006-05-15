/**
 *
 * Copyright 2005 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.example.sequences;


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

} //SequencesFactory
