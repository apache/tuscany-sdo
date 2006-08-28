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
import org.apache.tuscany.sdo.model.BaseDataGraphType;
import org.apache.tuscany.sdo.model.ChangeSummaryType;
import org.apache.tuscany.sdo.model.ModelsType;
import org.apache.tuscany.sdo.model.XSDType;

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
 * An implementation of the model object '<em><b>Base Data Graph Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.BaseDataGraphTypeImpl#getModels <em>Models</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.BaseDataGraphTypeImpl#getXsd <em>Xsd</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.BaseDataGraphTypeImpl#getChangeSummary <em>Change Summary</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.BaseDataGraphTypeImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class BaseDataGraphTypeImpl extends DataObjectImpl implements BaseDataGraphType
{
  /**
   * The cached value of the '{@link #getModels() <em>Models</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModels()
   * @generated
   * @ordered
   */
  protected ModelsType models = null;

  /**
   * The cached value of the '{@link #getXsd() <em>Xsd</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXsd()
   * @generated
   * @ordered
   */
  protected XSDType xsd = null;

  /**
   * The cached value of the '{@link #getChangeSummary() <em>Change Summary</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChangeSummary()
   * @generated
   * @ordered
   */
  protected ChangeSummaryType changeSummary = null;

  /**
   * The cached value of the '{@link #getAnyAttribute() <em>Any Attribute</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnyAttribute()
   * @generated
   * @ordered
   */
  protected BasicSequence anyAttribute = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BaseDataGraphTypeImpl()
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
    return ModelPackageImpl.Literals.BASE_DATA_GRAPH_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelsType getModels()
  {
    return models;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModels(ModelsType newModels, NotificationChain msgs)
  {
    ModelsType oldModels = models;
    models = newModels;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackageImpl.BASE_DATA_GRAPH_TYPE__MODELS, oldModels, newModels);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModels(ModelsType newModels)
  {
    if (newModels != models)
    {
      NotificationChain msgs = null;
      if (models != null)
        msgs = ((InternalEObject)models).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackageImpl.BASE_DATA_GRAPH_TYPE__MODELS, null, msgs);
      if (newModels != null)
        msgs = ((InternalEObject)newModels).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackageImpl.BASE_DATA_GRAPH_TYPE__MODELS, null, msgs);
      msgs = basicSetModels(newModels, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.BASE_DATA_GRAPH_TYPE__MODELS, newModels, newModels));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XSDType getXsd()
  {
    return xsd;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetXsd(XSDType newXsd, NotificationChain msgs)
  {
    XSDType oldXsd = xsd;
    xsd = newXsd;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackageImpl.BASE_DATA_GRAPH_TYPE__XSD, oldXsd, newXsd);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setXsd(XSDType newXsd)
  {
    if (newXsd != xsd)
    {
      NotificationChain msgs = null;
      if (xsd != null)
        msgs = ((InternalEObject)xsd).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackageImpl.BASE_DATA_GRAPH_TYPE__XSD, null, msgs);
      if (newXsd != null)
        msgs = ((InternalEObject)newXsd).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackageImpl.BASE_DATA_GRAPH_TYPE__XSD, null, msgs);
      msgs = basicSetXsd(newXsd, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.BASE_DATA_GRAPH_TYPE__XSD, newXsd, newXsd));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeSummaryType getChangeSummary_()
  {
    return changeSummary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetChangeSummary(ChangeSummaryType newChangeSummary, NotificationChain msgs)
  {
    ChangeSummaryType oldChangeSummary = changeSummary;
    changeSummary = newChangeSummary;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackageImpl.BASE_DATA_GRAPH_TYPE__CHANGE_SUMMARY, oldChangeSummary, newChangeSummary);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChangeSummary(ChangeSummaryType newChangeSummary)
  {
    if (newChangeSummary != changeSummary)
    {
      NotificationChain msgs = null;
      if (changeSummary != null)
        msgs = ((InternalEObject)changeSummary).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackageImpl.BASE_DATA_GRAPH_TYPE__CHANGE_SUMMARY, null, msgs);
      if (newChangeSummary != null)
        msgs = ((InternalEObject)newChangeSummary).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackageImpl.BASE_DATA_GRAPH_TYPE__CHANGE_SUMMARY, null, msgs);
      msgs = basicSetChangeSummary(newChangeSummary, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.BASE_DATA_GRAPH_TYPE__CHANGE_SUMMARY, newChangeSummary, newChangeSummary));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sequence getAnyAttribute()
  {
    if (anyAttribute == null)
    {
      anyAttribute = new BasicSequence(new BasicFeatureMap(this, ModelPackageImpl.BASE_DATA_GRAPH_TYPE__ANY_ATTRIBUTE));
    }
    return anyAttribute;
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
      case ModelPackageImpl.BASE_DATA_GRAPH_TYPE__MODELS:
        return basicSetModels(null, msgs);
      case ModelPackageImpl.BASE_DATA_GRAPH_TYPE__XSD:
        return basicSetXsd(null, msgs);
      case ModelPackageImpl.BASE_DATA_GRAPH_TYPE__CHANGE_SUMMARY:
        return basicSetChangeSummary(null, msgs);
      case ModelPackageImpl.BASE_DATA_GRAPH_TYPE__ANY_ATTRIBUTE:
        return ((InternalEList)((FeatureMap.Internal.Wrapper)getAnyAttribute()).featureMap()).basicRemove(otherEnd, msgs);
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
      case ModelPackageImpl.BASE_DATA_GRAPH_TYPE__MODELS:
        return getModels();
      case ModelPackageImpl.BASE_DATA_GRAPH_TYPE__XSD:
        return getXsd();
      case ModelPackageImpl.BASE_DATA_GRAPH_TYPE__CHANGE_SUMMARY:
        return getChangeSummary();
      case ModelPackageImpl.BASE_DATA_GRAPH_TYPE__ANY_ATTRIBUTE:
        if (coreType) return ((FeatureMap.Internal.Wrapper)getAnyAttribute()).featureMap();
        return getAnyAttribute();
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
      case ModelPackageImpl.BASE_DATA_GRAPH_TYPE__MODELS:
        setModels((ModelsType)newValue);
        return;
      case ModelPackageImpl.BASE_DATA_GRAPH_TYPE__XSD:
        setXsd((XSDType)newValue);
        return;
      case ModelPackageImpl.BASE_DATA_GRAPH_TYPE__CHANGE_SUMMARY:
        setChangeSummary((ChangeSummaryType)newValue);
        return;
      case ModelPackageImpl.BASE_DATA_GRAPH_TYPE__ANY_ATTRIBUTE:
        ((FeatureMap.Internal)((FeatureMap.Internal.Wrapper)getAnyAttribute()).featureMap()).set(newValue);
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
      case ModelPackageImpl.BASE_DATA_GRAPH_TYPE__MODELS:
        setModels((ModelsType)null);
        return;
      case ModelPackageImpl.BASE_DATA_GRAPH_TYPE__XSD:
        setXsd((XSDType)null);
        return;
      case ModelPackageImpl.BASE_DATA_GRAPH_TYPE__CHANGE_SUMMARY:
        setChangeSummary((ChangeSummaryType)null);
        return;
      case ModelPackageImpl.BASE_DATA_GRAPH_TYPE__ANY_ATTRIBUTE:
        ((FeatureMap.Internal.Wrapper)getAnyAttribute()).featureMap().clear();
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
      case ModelPackageImpl.BASE_DATA_GRAPH_TYPE__MODELS:
        return models != null;
      case ModelPackageImpl.BASE_DATA_GRAPH_TYPE__XSD:
        return xsd != null;
      case ModelPackageImpl.BASE_DATA_GRAPH_TYPE__CHANGE_SUMMARY:
        return changeSummary != null;
      case ModelPackageImpl.BASE_DATA_GRAPH_TYPE__ANY_ATTRIBUTE:
        return anyAttribute != null && !anyAttribute.featureMap().isEmpty();
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
    result.append(" (anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //BaseDataGraphTypeImpl
