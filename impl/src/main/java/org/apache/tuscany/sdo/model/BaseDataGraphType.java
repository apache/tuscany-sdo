/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.sdo.model;

import commonj.sdo.ChangeSummary;
import commonj.sdo.Sequence;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base Data Graph Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getModels <em>Models</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getXsd <em>Xsd</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getChangeSummary <em>Change Summary</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface BaseDataGraphType extends Serializable
{
  /**
   * Returns the value of the '<em><b>Models</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Models</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Models</em>' containment reference.
   * @see #setModels(ModelsType)
   * @generated
   */
  ModelsType getModels();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getModels <em>Models</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Models</em>' containment reference.
   * @see #getModels()
   * @generated
   */
  void setModels(ModelsType value);

  /**
   * Returns the value of the '<em><b>Xsd</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Xsd</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Xsd</em>' containment reference.
   * @see #setXsd(XSDType)
   * @generated
   */
  XSDType getXsd();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getXsd <em>Xsd</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Xsd</em>' containment reference.
   * @see #getXsd()
   * @generated
   */
  void setXsd(XSDType value);

  /**
   * Returns the value of the '<em><b>Change Summary</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Change Summary</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Change Summary</em>' attribute.
   * @see #setChangeSummary(ChangeSummary)
   * @generated
   */
  ChangeSummary getChangeSummary();

  /**
   * Sets the value of the '{@link org.apache.tuscany.sdo.model.BaseDataGraphType#getChangeSummary <em>Change Summary</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Change Summary</em>' attribute.
   * @see #getChangeSummary()
   * @generated
   */
  void setChangeSummary(ChangeSummary value);

  /**
   * Returns the value of the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Any Attribute</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Any Attribute</em>' attribute list.
   * @generated
   */
  Sequence getAnyAttribute();

} // BaseDataGraphType
