/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.sdo.model.xml;


/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @generated
 */
public interface XMLFactory
{

  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  XMLFactory INSTANCE = org.apache.tuscany.sdo.model.xml.impl.XMLFactoryImpl.init();

  /**
   * Returns a new object of class '<em>XML Info</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>XML Info</em>'.
   * @generated
   */
  XMLInfo createXMLInfo();

} //XmlFactory
