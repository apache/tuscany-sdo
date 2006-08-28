/**
 *
 * Copyright 2005 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.tuscany.sdo.model.java.impl;

import org.apache.tuscany.sdo.impl.DataObjectImpl;

import org.apache.tuscany.sdo.model.java.JavaInfo;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.model.java.impl.JavaInfoImpl#getJavaClass <em>Java Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JavaInfoImpl extends DataObjectImpl implements JavaInfo
{
  /**
   * The default value of the '{@link #getJavaClass() <em>Java Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJavaClass()
   * @generated
   * @ordered
   */
  protected static final String JAVA_CLASS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getJavaClass() <em>Java Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJavaClass()
   * @generated
   * @ordered
   */
  protected String javaClass = JAVA_CLASS_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected JavaInfoImpl()
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
    return JavaPackageImpl.Literals.JAVA_INFO;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getJavaClass()
  {
    return javaClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setJavaClass(String newJavaClass)
  {
    String oldJavaClass = javaClass;
    javaClass = newJavaClass;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, JavaPackageImpl.JAVA_INFO__JAVA_CLASS, oldJavaClass, javaClass));
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
      case JavaPackageImpl.JAVA_INFO__JAVA_CLASS:
        return getJavaClass();
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
      case JavaPackageImpl.JAVA_INFO__JAVA_CLASS:
        setJavaClass((String)newValue);
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
      case JavaPackageImpl.JAVA_INFO__JAVA_CLASS:
        setJavaClass(JAVA_CLASS_EDEFAULT);
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
      case JavaPackageImpl.JAVA_INFO__JAVA_CLASS:
        return JAVA_CLASS_EDEFAULT == null ? javaClass != null : !JAVA_CLASS_EDEFAULT.equals(javaClass);
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
    result.append(" (javaClass: ");
    result.append(javaClass);
    result.append(')');
    return result.toString();
  }

} //JavaInfoImpl
