/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
