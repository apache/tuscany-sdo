/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.sdo.model.xml;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.model.xml.XMLInfo#isXmlElement <em>Xml Element</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface XMLInfo extends Serializable
{
  /**
   * Returns the value of the '<em><b>Xml Element</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Xml Element</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Xml Element</em>' attribute.
   * @see #isSetXmlElement()
   * @see #unsetXmlElement()
   * @see #setXmlElement(boolean)
   * @generated
   */
  boolean isXmlElement();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.xml.XMLInfo#isXmlElement <em>Xml Element</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Xml Element</em>' attribute.
   * @see #isSetXmlElement()
   * @see #unsetXmlElement()
   * @see #isXmlElement()
   * @generated
   */
  void setXmlElement(boolean value);

  /**
   * Unsets the value of the '{@link org.apache.tuscany.sdo.model.xml.XMLInfo#isXmlElement <em>Xml Element</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetXmlElement()
   * @see #isXmlElement()
   * @see #setXmlElement(boolean)
   * @generated
   */
  void unsetXmlElement();

  /**
   * Returns whether the value of the '{@link org.apache.tuscany.sdo.model.xml.XMLInfo#isXmlElement <em>Xml Element</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Xml Element</em>' attribute is set.
   * @see #unsetXmlElement()
   * @see #isXmlElement()
   * @see #setXmlElement(boolean)
   * @generated
   */
  boolean isSetXmlElement();

} // XMLInfo
