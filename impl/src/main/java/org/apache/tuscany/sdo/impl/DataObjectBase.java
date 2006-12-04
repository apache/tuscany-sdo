/**
 *
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.apache.tuscany.sdo.impl;


import java.util.List;

import org.apache.tuscany.sdo.util.BasicSequence;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;


import commonj.sdo.Sequence;
import commonj.sdo.Type;


/**
 * Base implementation of the SDO DataObject interface. Used as base class for prototype of EMF-less generated subclasses
 */
public abstract class DataObjectBase extends DataObjectImpl
{
  
  protected int OPPOSITE_FEATURE_BASE = EOPPOSITE_FEATURE_BASE; 
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Following methods should be proposed SPI for generated subclasses to use
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  protected boolean isNotifying()
  {
    return changeRecorder != null;
  }
  
  protected interface ChangeKind
  {
    int SET = Notification.SET;
    int UNSET = Notification.UNSET;
    int RESOLVE = Notification.RESOLVE;
  }

  protected void notify(int changeKind, int property, Object oldValue, Object newValue)
  {
    eNotify(new ENotificationImpl(this, Notification.SET, property, oldValue, newValue));
  }

  protected void notify(int changeKind, int property, Object oldValue, Object newValue, boolean isSetChange)
  {
    eNotify(new ENotificationImpl(this, Notification.SET, property, oldValue, newValue, isSetChange));
  }
  
  protected void notify(int changeKind, int property, double oldDoubleValue, double newDoubleValue, boolean isSetChange)
  {
    eNotify(new ENotificationImpl(this, Notification.SET, property, oldDoubleValue, newDoubleValue, isSetChange));
  }
  
  protected void notify(int changeKind, int property, boolean oldBooleanValue, boolean newBooleanValue, boolean isSetChange)
  {
    eNotify(new ENotificationImpl(this, Notification.SET, property, oldBooleanValue, newBooleanValue, isSetChange));
  }
  
  protected interface ListKind
  {
    int CONTAINMENT = 0;
  }
  
  protected List createPropertyList(int listKind, Class dataClass, int property)
  {
    switch (listKind)
    {
      case ListKind.CONTAINMENT:
        return new EObjectContainmentEList(dataClass, this, property);
    }
    return null;
  }
  
  protected BasicSequence createSequence(int property) {
    return new BasicSequence(new BasicFeatureMap(this, property));
  }
  
  protected Sequence createSequence(Sequence sequence, Type type, int propertyIndex) {
    return new BasicSequence((FeatureMap.Internal)((FeatureMap.Internal.Wrapper)sequence).featureMap().list(((EClass)type).getEStructuralFeature(propertyIndex)));
  }
  
 /*
  * get the value of the type's property at propertyIndex via the sequence  
  * @param seq
  * @param type
  * @param propertyIndex
  * @return
  */
  protected Object get(Sequence seq, Type type, int propertyIndex) {
    return ((FeatureMap.Internal.Wrapper)seq).featureMap().get(((EClass)type).getEStructuralFeature(propertyIndex), true);
  }
  
  protected List getList(Sequence seq, Type type, int propertyIndex) {
    return ((FeatureMap.Internal.Wrapper)seq).featureMap().list(((EClass)type).getEStructuralFeature(propertyIndex));
  }
  
  protected void set(Sequence seq, Type type, int propertyIndex, Object newValue) {
    ((FeatureMap.Internal)((FeatureMap.Internal.Wrapper)seq).featureMap()).set(((EClass)type).getEStructuralFeature(propertyIndex), newValue);
  }
  
  protected void unset(Sequence seq, Type type, int propertyIndex) {
    ((FeatureMap.Internal)((FeatureMap.Internal.Wrapper)seq).featureMap()).clear(((EClass)type).getEStructuralFeature(propertyIndex));
     
  }
  protected boolean isSet(Sequence seq, Type type, int propertyIndex) {
    return !((FeatureMap.Internal)((FeatureMap.Internal.Wrapper)seq).featureMap()).isEmpty(((EClass)type).getEStructuralFeature(propertyIndex));     
  }
  
  protected boolean isSequenceEmpty(Sequence sequence) {
    return ((FeatureMap.Internal.Wrapper)sequence).featureMap().isEmpty();  
  }
  
  protected void setSequence(Sequence seq, Object newValue) {
    ((FeatureMap.Internal)((FeatureMap.Internal.Wrapper)seq).featureMap()).set(newValue);
  }
  
  protected void unsetSequence(Sequence seq) {
    ((FeatureMap.Internal.Wrapper)seq).featureMap().clear();
  }

  protected ChangeContext basicAdd(Sequence seq, Type type, int propertyIndex, Object newValue, ChangeContext changeContext) {
    ChangeContextImpl changeContextImpl = (ChangeContextImpl)changeContext;
    changeContextImpl.notificationChain = ((FeatureMap.Internal)((FeatureMap.Internal.Wrapper)seq).featureMap()).basicAdd(((EClass)type).getEStructuralFeature(propertyIndex), newValue, changeContextImpl.notificationChain);
    return changeContextImpl;
  }
  
  protected Object get(int featureID, boolean resolve)
  {
    return null;
  }
  
  private ChangeContextImpl initializeChangeContext(ChangeContext changeContext)
  {
    ChangeContextImpl changeContextImpl;
    if (changeContext == null) 
    {
      changeContextImpl = new ChangeContextImpl(null);
    } else 
    {
      changeContextImpl = (ChangeContextImpl)changeContext;
    }
    return changeContextImpl;
  }
  
  protected interface ChangeContext {}
  
  protected ChangeContext inverseRemove(Object otherEnd, int propertyIndex, ChangeContext changeContext)
  {
    ChangeContextImpl changeContextImpl = initializeChangeContext(changeContext);
    changeContextImpl.notificationChain = super.eInverseRemove((InternalEObject)otherEnd, propertyIndex, changeContextImpl.notificationChain);
    return changeContextImpl;
  }
  
  protected ChangeContext inverseAdd(Object otherEnd, int propertyIndex, ChangeContext changeContext)
  {
    ChangeContextImpl changeContextImpl = initializeChangeContext(changeContext);
    changeContextImpl.notificationChain = super.eInverseAdd((InternalEObject)otherEnd, propertyIndex, changeContextImpl.notificationChain);
    return changeContextImpl;
  }

  protected ChangeContext inverseRemove(Object thisEnd, Object otherEnd, int propertyIndex, Class baseClass, ChangeContext changeContext)
  {
    ChangeContextImpl changeContextImpl = initializeChangeContext(changeContext);
    changeContextImpl.notificationChain = ((InternalEObject)thisEnd).eInverseRemove((InternalEObject)otherEnd, propertyIndex, baseClass, changeContextImpl.notificationChain);
    return changeContextImpl;
  }

  protected ChangeContext inverseAdd(Object thisEnd, Object otherEnd, int propertyIndex, Class baseClass, ChangeContext changeContext)
  {
    ChangeContextImpl changeContextImpl = initializeChangeContext(changeContext);
    changeContextImpl.notificationChain = ((InternalEObject)thisEnd).eInverseAdd((InternalEObject)otherEnd, propertyIndex, baseClass, changeContextImpl.notificationChain);
    return changeContextImpl;
  }
  
  protected ChangeContext addNotification(Object notifier, int eventType, int featureID, Object oldValue, Object newValue, ChangeContext changeContext) 
  {
    ENotificationImpl notification = new ENotificationImpl((InternalEObject)notifier, eventType, featureID, oldValue, newValue);
    ChangeContextImpl changeContextImpl = initializeChangeContext(changeContext);
    if (changeContextImpl.notificationChain == null) changeContextImpl.notificationChain = notification; else changeContextImpl.notificationChain.add(notification);
    return changeContextImpl;
  }
  
  protected ChangeContext removeFromList(List propertyList, Object objectToRemove, ChangeContext changeContext)
  {
    ChangeContextImpl changeContextImpl = initializeChangeContext(changeContext);
    changeContextImpl.notificationChain = ((InternalEList)propertyList).basicRemove(objectToRemove, changeContextImpl.notificationChain); 
    return changeContextImpl;
  }
  
  protected ChangeContext removeFromSequence(Sequence sequence, Object otherEnd, ChangeContext changeContext) 
  {
    ChangeContextImpl changeContextImpl = initializeChangeContext(changeContext);
    changeContextImpl.notificationChain = ((InternalEList)((FeatureMap.Internal.Wrapper)sequence).featureMap()).basicRemove(otherEnd, changeContextImpl.notificationChain);
    return changeContextImpl;
  }
  
  protected void dispatch(ChangeContext changeContext)
  {
    ChangeContextImpl changeContextImpl = initializeChangeContext(changeContext);
    if (changeContextImpl.notificationChain != null)
    {
      changeContextImpl.notificationChain.dispatch();
    }
  }

  protected boolean isProxy() // FB TODO : regen models and then remove this method
  {
    return eIsProxy();
  }
  
  protected boolean isProxy(Object object)
  {
    return ((EObject)object).eIsProxy();
  }
  
  protected Object resolveProxy(Object proxy)
  {
    return EcoreUtil.resolve((EObject)proxy, this);
  }
  

  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Following methods override EMF methods to work with pure SDO generated subclasses
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  public EClass eStaticClass()
  {
    return (EClass)getType();
  }
  
  public Type getType() // must be overridem in subclasses
  {
    throw new UnsupportedOperationException();
  }
  
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    Object result = get(featureID, resolve);
    if (coreType)
    {
      if (result instanceof FeatureMap.Internal.Wrapper) result = ((FeatureMap.Internal.Wrapper)result).featureMap();
    }
    return result;
  }

  public void eSet(int featureID, Object newValue)
  {
    set(featureID, newValue);
  } 

  public void eUnset(int featureID)
  {
    unset(featureID);
  }
  
  public boolean eIsSet(int featureID)
  {
    return isSet(featureID);
  }
  
  private class ChangeContextImpl implements ChangeContext
  {
    protected NotificationChain notificationChain;
    public ChangeContextImpl(NotificationChain notificationChain) {
      this.notificationChain = notificationChain;
    }
  }
  
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int propertyIndex, NotificationChain msgs)
  {
    return ((ChangeContextImpl)inverseRemove(otherEnd, propertyIndex, new ChangeContextImpl(msgs))).notificationChain;
  }
  
  public String toString()
  {
    StringBuffer result = new StringBuffer(getClass().getName());
    result.append('@');
    result.append(Integer.toHexString(hashCode()));
    if (eIsProxy())
    {
      result.append(" (proxyURI: ");
      result.append(eProxyURI());
      result.append(')');
    }
    return result.toString();
  }
  
} //DataObjectBase

