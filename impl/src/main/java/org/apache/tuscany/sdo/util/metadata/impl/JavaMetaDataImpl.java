/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.sdo.util.metadata.impl;

import org.apache.tuscany.sdo.impl.DataObjectImpl;

import org.apache.tuscany.sdo.util.metadata.JavaMetaData;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Meta Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.util.metadata.impl.JavaMetaDataImpl#getFactoryInterface <em>Factory Interface</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.util.metadata.impl.JavaMetaDataImpl#getTypeInterface <em>Type Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JavaMetaDataImpl extends DataObjectImpl implements JavaMetaData
{
  /**
   * The default value of the '{@link #getFactoryInterface() <em>Factory Interface</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFactoryInterface()
   * @generated
   * @ordered
   */
  protected static final String FACTORY_INTERFACE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFactoryInterface() <em>Factory Interface</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFactoryInterface()
   * @generated
   * @ordered
   */
  protected String factoryInterface = FACTORY_INTERFACE_EDEFAULT;

  /**
   * The default value of the '{@link #getTypeInterface() <em>Type Interface</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeInterface()
   * @generated
   * @ordered
   */
  protected static final String TYPE_INTERFACE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTypeInterface() <em>Type Interface</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeInterface()
   * @generated
   * @ordered
   */
  protected String typeInterface = TYPE_INTERFACE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected JavaMetaDataImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EClass eStaticClass()
  {
    return MetadataPackageImpl.Literals.JAVA_META_DATA;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFactoryInterface()
  {
    return factoryInterface;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFactoryInterface(String newFactoryInterface)
  {
    String oldFactoryInterface = factoryInterface;
    factoryInterface = newFactoryInterface;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackageImpl.JAVA_META_DATA__FACTORY_INTERFACE, oldFactoryInterface, factoryInterface));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTypeInterface()
  {
    return typeInterface;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeInterface(String newTypeInterface)
  {
    String oldTypeInterface = typeInterface;
    typeInterface = newTypeInterface;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackageImpl.JAVA_META_DATA__TYPE_INTERFACE, oldTypeInterface, typeInterface));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MetadataPackageImpl.JAVA_META_DATA__FACTORY_INTERFACE:
        return getFactoryInterface();
      case MetadataPackageImpl.JAVA_META_DATA__TYPE_INTERFACE:
        return getTypeInterface();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MetadataPackageImpl.JAVA_META_DATA__FACTORY_INTERFACE:
        setFactoryInterface((String)newValue);
        return;
      case MetadataPackageImpl.JAVA_META_DATA__TYPE_INTERFACE:
        setTypeInterface((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MetadataPackageImpl.JAVA_META_DATA__FACTORY_INTERFACE:
        setFactoryInterface(FACTORY_INTERFACE_EDEFAULT);
        return;
      case MetadataPackageImpl.JAVA_META_DATA__TYPE_INTERFACE:
        setTypeInterface(TYPE_INTERFACE_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MetadataPackageImpl.JAVA_META_DATA__FACTORY_INTERFACE:
        return FACTORY_INTERFACE_EDEFAULT == null ? factoryInterface != null : !FACTORY_INTERFACE_EDEFAULT.equals(factoryInterface);
      case MetadataPackageImpl.JAVA_META_DATA__TYPE_INTERFACE:
        return TYPE_INTERFACE_EDEFAULT == null ? typeInterface != null : !TYPE_INTERFACE_EDEFAULT.equals(typeInterface);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (factoryInterface: ");
    result.append(factoryInterface);
    result.append(", typeInterface: ");
    result.append(typeInterface);
    result.append(')');
    return result.toString();
  }

} //JavaMetaDataImpl