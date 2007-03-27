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

import java.io.Serializable;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SDO Meta Data Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.util.metadata.SDOMetaDataGroup#getJavaMetaData <em>Java Meta Data</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.util.metadata.SDOMetaDataGroup#getXsdMetaData <em>Xsd Meta Data</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.util.metadata.SDOMetaDataGroup#getTypeMetaData <em>Type Meta Data</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface SDOMetaDataGroup extends Serializable
{
  /**
   * Returns the value of the '<em><b>Java Meta Data</b></em>' containment reference list.
   * The list contents are of type {@link org.apache.tuscany.sdo.util.metadata.JavaMetaData}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Java Meta Data</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Java Meta Data</em>' containment reference list.
   * @generated
   */
  List getJavaMetaData();

  /**
   * Returns the value of the '<em><b>Xsd Meta Data</b></em>' containment reference list.
   * The list contents are of type {@link org.apache.tuscany.sdo.util.metadata.XSDMetaData}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Xsd Meta Data</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Xsd Meta Data</em>' containment reference list.
   * @generated
   */
  List getXsdMetaData();

  /**
   * Returns the value of the '<em><b>Type Meta Data</b></em>' containment reference list.
   * The list contents are of type {@link org.apache.tuscany.sdo.util.metadata.TypeMetaData}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Meta Data</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Meta Data</em>' containment reference list.
   * @generated
   */
  List getTypeMetaData();

} // SDOMetaDataGroup
