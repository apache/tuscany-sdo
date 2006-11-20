/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.sdo.model.impl;

import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import org.apache.tuscany.sdo.model.DataObject;
import org.apache.tuscany.sdo.model.ModelFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class DataObjectImpl extends DataObjectBase implements DataObject
{
  /**
   * This represents the number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  
  public final static int SDO_PROPERTY_COUNT = 0;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DataObjectImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getType()
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).getDataObject();
  }

} //DataObjectImpl
