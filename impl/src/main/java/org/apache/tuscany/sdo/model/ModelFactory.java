/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.sdo.model;


/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @generated
 */
public interface ModelFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ModelFactory INSTANCE = org.apache.tuscany.sdo.model.impl.ModelFactoryImpl.eINSTANCE;

  /**
   * Returns a new object of class '<em>Change Summary Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Change Summary Type</em>'.
   * @generated
   */
  ChangeSummaryType createChangeSummaryType();

  /**
   * Returns a new object of class '<em>Data Graph Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Graph Type</em>'.
   * @generated
   */
  DataGraphType createDataGraphType();

  /**
   * Returns a new object of class '<em>Models Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Models Type</em>'.
   * @generated
   */
  ModelsType createModelsType();

  /**
   * Returns a new object of class '<em>Property</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property</em>'.
   * @generated
   */
  Property createProperty();

  /**
   * Returns a new object of class '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type</em>'.
   * @generated
   */
  Type createType();

  /**
   * Returns a new object of class '<em>Types</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Types</em>'.
   * @generated
   */
  Types createTypes();

  /**
   * Returns a new object of class '<em>XSD Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>XSD Type</em>'.
   * @generated
   */
  XSDType createXSDType();

} //ModelFactory
