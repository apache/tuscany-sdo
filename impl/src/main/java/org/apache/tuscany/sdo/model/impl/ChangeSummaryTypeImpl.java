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
package org.apache.tuscany.sdo.model.impl;

import commonj.sdo.Sequence;


import org.apache.tuscany.sdo.impl.DataObjectImpl;
import org.apache.tuscany.sdo.model.ChangeSummaryType;

import org.apache.tuscany.sdo.util.BasicSequence;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Change Summary Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.ChangeSummaryTypeImpl#getAny <em>Any</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.ChangeSummaryTypeImpl#getCreate <em>Create</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.ChangeSummaryTypeImpl#getDelete <em>Delete</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.ChangeSummaryTypeImpl#isLogging <em>Logging</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChangeSummaryTypeImpl extends DataObjectImpl implements ChangeSummaryType
{
  /**
   * The cached value of the '{@link #getAny() <em>Any</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAny()
   * @generated
   * @ordered
   */
  protected BasicSequence any = null;

  /**
   * The default value of the '{@link #getCreate() <em>Create</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCreate()
   * @generated
   * @ordered
   */
  protected static final String CREATE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCreate() <em>Create</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCreate()
   * @generated
   * @ordered
   */
  protected String create = CREATE_EDEFAULT;

  /**
   * The default value of the '{@link #getDelete() <em>Delete</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDelete()
   * @generated
   * @ordered
   */
  protected static final String DELETE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDelete() <em>Delete</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDelete()
   * @generated
   * @ordered
   */
  protected String delete = DELETE_EDEFAULT;

  /**
   * The default value of the '{@link #isLogging() <em>Logging</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLogging()
   * @generated
   * @ordered
   */
  protected static final boolean LOGGING_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isLogging() <em>Logging</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLogging()
   * @generated
   * @ordered
   */
  protected boolean logging = LOGGING_EDEFAULT;

  /**
   * This is true if the Logging attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean loggingESet = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ChangeSummaryTypeImpl()
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
    return ModelPackageImpl.Literals.CHANGE_SUMMARY_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sequence getAny()
  {
    if (any == null)
    {
      any = new BasicSequence(new BasicFeatureMap(this, ModelPackageImpl.CHANGE_SUMMARY_TYPE__ANY));
    }
    return any;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCreate()
  {
    return create;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCreate(String newCreate)
  {
    String oldCreate = create;
    create = newCreate;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.CHANGE_SUMMARY_TYPE__CREATE, oldCreate, create));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDelete()
  {
    return delete;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDelete(String newDelete)
  {
    String oldDelete = delete;
    delete = newDelete;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.CHANGE_SUMMARY_TYPE__DELETE, oldDelete, delete));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isLogging()
  {
    return logging;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLogging(boolean newLogging)
  {
    boolean oldLogging = logging;
    logging = newLogging;
    boolean oldLoggingESet = loggingESet;
    loggingESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.CHANGE_SUMMARY_TYPE__LOGGING, oldLogging, logging, !oldLoggingESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetLogging()
  {
    boolean oldLogging = logging;
    boolean oldLoggingESet = loggingESet;
    logging = LOGGING_EDEFAULT;
    loggingESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackageImpl.CHANGE_SUMMARY_TYPE__LOGGING, oldLogging, LOGGING_EDEFAULT, oldLoggingESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetLogging()
  {
    return loggingESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ModelPackageImpl.CHANGE_SUMMARY_TYPE__ANY:
        return ((InternalEList)((FeatureMap.Internal.Wrapper)getAny()).featureMap()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case ModelPackageImpl.CHANGE_SUMMARY_TYPE__ANY:
        if (coreType) return ((FeatureMap.Internal.Wrapper)getAny()).featureMap();
        return getAny();
      case ModelPackageImpl.CHANGE_SUMMARY_TYPE__CREATE:
        return getCreate();
      case ModelPackageImpl.CHANGE_SUMMARY_TYPE__DELETE:
        return getDelete();
      case ModelPackageImpl.CHANGE_SUMMARY_TYPE__LOGGING:
        return isLogging() ? Boolean.TRUE : Boolean.FALSE;
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
      case ModelPackageImpl.CHANGE_SUMMARY_TYPE__ANY:
        ((FeatureMap.Internal)((FeatureMap.Internal.Wrapper)getAny()).featureMap()).set(newValue);
        return;
      case ModelPackageImpl.CHANGE_SUMMARY_TYPE__CREATE:
        setCreate((String)newValue);
        return;
      case ModelPackageImpl.CHANGE_SUMMARY_TYPE__DELETE:
        setDelete((String)newValue);
        return;
      case ModelPackageImpl.CHANGE_SUMMARY_TYPE__LOGGING:
        setLogging(((Boolean)newValue).booleanValue());
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
      case ModelPackageImpl.CHANGE_SUMMARY_TYPE__ANY:
        ((FeatureMap.Internal.Wrapper)getAny()).featureMap().clear();
        return;
      case ModelPackageImpl.CHANGE_SUMMARY_TYPE__CREATE:
        setCreate(CREATE_EDEFAULT);
        return;
      case ModelPackageImpl.CHANGE_SUMMARY_TYPE__DELETE:
        setDelete(DELETE_EDEFAULT);
        return;
      case ModelPackageImpl.CHANGE_SUMMARY_TYPE__LOGGING:
        unsetLogging();
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
      case ModelPackageImpl.CHANGE_SUMMARY_TYPE__ANY:
        return any != null && !any.featureMap().isEmpty();
      case ModelPackageImpl.CHANGE_SUMMARY_TYPE__CREATE:
        return CREATE_EDEFAULT == null ? create != null : !CREATE_EDEFAULT.equals(create);
      case ModelPackageImpl.CHANGE_SUMMARY_TYPE__DELETE:
        return DELETE_EDEFAULT == null ? delete != null : !DELETE_EDEFAULT.equals(delete);
      case ModelPackageImpl.CHANGE_SUMMARY_TYPE__LOGGING:
        return isSetLogging();
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
    result.append(" (any: ");
    result.append(any);
    result.append(", create: ");
    result.append(create);
    result.append(", delete: ");
    result.append(delete);
    result.append(", logging: ");
    if (loggingESet) result.append(logging); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //ChangeSummaryTypeImpl
