/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.sdo.util.metadata;

import java.util.List;

import commonj.sdo.helper.TypeHelper;

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
 * @generated
 */
public interface SDOMetaDataGroup
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
  
  void register(TypeHelper scope);
  void register(TypeHelper scope, ClassLoader classLoader);

} // SDOMetaDataGroup