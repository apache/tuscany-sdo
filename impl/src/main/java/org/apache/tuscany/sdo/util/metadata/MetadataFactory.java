/**
 *
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.apache.tuscany.sdo.util.metadata;


/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @generated
 */
public interface MetadataFactory
{

  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MetadataFactory INSTANCE = org.apache.tuscany.sdo.util.metadata.impl.MetadataFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Java Meta Data</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Java Meta Data</em>'.
   * @generated
   */
  JavaMetaData createJavaMetaData();

  /**
   * Returns a new object of class '<em>SDO Meta Data Group</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>SDO Meta Data Group</em>'.
   * @generated
   */
  SDOMetaDataGroup createSDOMetaDataGroup();

  /**
   * Returns a new object of class '<em>Type Meta Data</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Meta Data</em>'.
   * @generated
   */
  TypeMetaData createTypeMetaData();

  /**
   * Returns a new object of class '<em>XSD Meta Data</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>XSD Meta Data</em>'.
   * @generated
   */
  XSDMetaData createXSDMetaData();

} //MetadataFactory
