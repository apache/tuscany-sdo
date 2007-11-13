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

import org.apache.tuscany.sdo.SDOFactory;
import org.apache.tuscany.sdo.helper.HelperContextImpl;
import org.apache.tuscany.sdo.util.BasicSequence;
import org.apache.tuscany.sdo.util.DataObjectUtil;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.SettingDelegate;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.Type;


/**
 * Base implementation of the SDO DataObject interface. Used as base class for generated (static) SDO classes
 */
public abstract class DataObjectBase extends ExtensibleDataObjectImpl
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

  /**
   * notify methods for types: boolean, byte, char, double, float, int, long, short, and Object 
   */
  
  protected void notify(int changeKind, int property, boolean oldBooleanValue, boolean newBooleanValue)
  {
  	eNotify(new ENotificationImpl(this, Notification.SET, property, oldBooleanValue, newBooleanValue));
  }
  
  protected void notify(int changeKind, int property, boolean oldBooleanValue, boolean newBooleanValue, boolean isSetChange)
  {
  	eNotify(new ENotificationImpl(this, Notification.SET, property, oldBooleanValue, newBooleanValue, isSetChange));
  }
  
  protected void notify(int changeKind, int property, byte oldByteValue, byte newByteValue)
  {
  	eNotify(new ENotificationImpl(this, Notification.SET, property, oldByteValue, newByteValue));
  }
  
  protected void notify(int changeKind, int property, byte oldByteValue, byte newByteValue, boolean isSetChange)
  {
  	eNotify(new ENotificationImpl(this, Notification.SET, property, oldByteValue, newByteValue, isSetChange));
  }
  
  protected void notify(int changeKind, int property, char oldCharValue, char newCharValue)
  {
  	eNotify(new ENotificationImpl(this, Notification.SET, property, oldCharValue, newCharValue));
  }
  
  protected void notify(int changeKind, int property, char oldCharValue, char newCharValue, boolean isSetChange)
  {
  	eNotify(new ENotificationImpl(this, Notification.SET, property, oldCharValue, newCharValue, isSetChange));
  }
  
  protected void notify(int changeKind, int property, double oldDoubleValue, double newDoubleValue)
  {
    eNotify(new ENotificationImpl(this, Notification.SET, property, oldDoubleValue, newDoubleValue));
  }
  
  protected void notify(int changeKind, int property, double oldDoubleValue, double newDoubleValue, boolean isSetChange)
  {
    eNotify(new ENotificationImpl(this, Notification.SET, property, oldDoubleValue, newDoubleValue, isSetChange));
  }
  
  protected void notify(int changeKind, int property, float oldFloatValue, float newFloatValue)
  {
    eNotify(new ENotificationImpl(this, Notification.SET, property, oldFloatValue, newFloatValue));
  }
  
  protected void notify(int changeKind, int property, float oldFloatValue, float newFloatValue, boolean isSetChange)
  {
    eNotify(new ENotificationImpl(this, Notification.SET, property, oldFloatValue, newFloatValue, isSetChange));
  }
  
  protected void notify(int changeKind, int property, int oldIntValue, int newIntValue)
  {
  	eNotify(new ENotificationImpl(this, Notification.SET, property, oldIntValue, newIntValue));
  }
  
  protected void notify(int changeKind, int property, int oldIntValue, int newIntValue, boolean isSetChange)
  {
  	eNotify(new ENotificationImpl(this, Notification.SET, property, oldIntValue, newIntValue, isSetChange));
  }
  
  protected void notify(int changeKind, int property, long oldLongValue, long newLongValue)
  {
  	eNotify(new ENotificationImpl(this, Notification.SET, property, oldLongValue, newLongValue));
  }
  
  protected void notify(int changeKind, int property, long oldLongValue, long newLongValue, boolean isSetChange)
  {
  	eNotify(new ENotificationImpl(this, Notification.SET, property, oldLongValue, newLongValue, isSetChange));
  }
  
  protected void notify(int changeKind, int property, short oldShortValue, short newShortValue)
  {
  	eNotify(new ENotificationImpl(this, Notification.SET, property, oldShortValue, newShortValue));
  }
  
  protected void notify(int changeKind, int property, short oldShortValue, short newShortValue, boolean isSetChange)
  {
  	eNotify(new ENotificationImpl(this, Notification.SET, property, oldShortValue, newShortValue, isSetChange));
  }
  
  protected void notify(int changeKind, int property, Object oldValue, Object newValue)
  {
  	eNotify(new ENotificationImpl(this, Notification.SET, property, oldValue, newValue));
  }
  
  protected void notify(int changeKind, int property, Object oldValue, Object newValue, boolean isSetChange)
  {
  	eNotify(new ENotificationImpl(this, Notification.SET, property, oldValue, newValue, isSetChange));
  }
  
  public interface ListKind
  {
    int CONTAINMENT = 0;
    int CONTAINMENT_UNSETTABLE = 1;
    int CONTAINMENT_RESOLVING = 2;
    int CONTAINMENT_RESOLVING_UNSETTABLE = 3;
    int CONTAINMENT_INVERSE = 4;
    int CONTAINMENT_INVERSE_UNSETTABLE = 5;
    int CONTAINMENT_INVERSE_RESOLVING = 6;
    int CONTAINMENT_INVERSE_RESOLVING_UNSETTABLE = 7;

    int NONCONTAINMENT = 8;
    int NONCONTAINMENT_UNSETTABLE = 9;
    int NONCONTAINMENT_RESOLVING = 10;
    int NONCONTAINMENT_RESOLVING_UNSETTABLE = 11;
    int NONCONTAINMENT_INVERSE = 12;
    int NONCONTAINMENT_INVERSE_UNSETTABLE = 13;
    int NONCONTAINMENT_MANYINVERSE = 14;
    int NONCONTAINMENT_MANYINVERSE_UNSETTABLE = 15;
    int NONCONTAINMENT_INVERSE_RESOLVING = 16;
    int NONCONTAINMENT_INVERSE_RESOLVING_UNSETTABLE = 17;
    int NONCONTAINMENT_MANYINVERSE_RESOLVING = 18;
    int NONCONTAINMENT_MANYINVERSE_RESOLVING_UNSETTABLE = 19;
    
    int DATATYPE = 20;
    int DATATYPE_UNSETTABLE = 21;
    int DATATYPE_UNIQUE = 22;
    int DATATYPE_UNIQUE_UNSETTABLE = 23;
    
    int BASIC = 24;
  }
  
  /**
   * @deprecated
   */
  protected List createPropertyList(int listKind, Class dataClass, int property)
  {
    return createPropertyList(listKind, dataClass, property, 0);
  }
  
  protected List createPropertyList(int listKind, Class dataClass, int property, int reverseProperty)
  {
    switch (listKind)
    {
      case ListKind.CONTAINMENT:
        return new EObjectContainmentEList(dataClass, this, property);
      case ListKind.CONTAINMENT_INVERSE_RESOLVING_UNSETTABLE:
        return new EObjectContainmentWithInverseEList.Unsettable.Resolving(dataClass, this, property, reverseProperty);
      case ListKind.CONTAINMENT_INVERSE_RESOLVING:
        return new EObjectContainmentWithInverseEList.Resolving(dataClass, this, property, reverseProperty);
      case ListKind.CONTAINMENT_INVERSE_UNSETTABLE:
        return new EObjectContainmentWithInverseEList.Unsettable(dataClass, this, property, reverseProperty);
      case ListKind.CONTAINMENT_INVERSE:
        return new EObjectContainmentWithInverseEList(dataClass, this, property, reverseProperty);
      case ListKind.CONTAINMENT_RESOLVING_UNSETTABLE:
        return new EObjectContainmentEList.Unsettable.Resolving(dataClass, this, property);
      case ListKind.CONTAINMENT_RESOLVING:
        return new EObjectContainmentEList.Resolving(dataClass, this, property);
      case ListKind.CONTAINMENT_UNSETTABLE:
        return new EObjectContainmentEList.Unsettable(dataClass, this, property);
      case ListKind.NONCONTAINMENT_MANYINVERSE_RESOLVING_UNSETTABLE:
        return new EObjectWithInverseResolvingEList.Unsettable.ManyInverse(dataClass, this, property, reverseProperty);
      case ListKind.NONCONTAINMENT_MANYINVERSE_RESOLVING:
        return new EObjectWithInverseResolvingEList.ManyInverse(dataClass, this, property, reverseProperty);
      case ListKind.NONCONTAINMENT_INVERSE_RESOLVING_UNSETTABLE:
        return new EObjectWithInverseResolvingEList.Unsettable(dataClass, this, property, reverseProperty);
      case ListKind.NONCONTAINMENT_INVERSE_RESOLVING:
        return new EObjectWithInverseResolvingEList(dataClass, this, property, reverseProperty);
      case ListKind.NONCONTAINMENT_MANYINVERSE_UNSETTABLE:
        return new EObjectWithInverseEList.Unsettable.ManyInverse(dataClass, this, property, reverseProperty);
      case ListKind.NONCONTAINMENT_MANYINVERSE:
        return new EObjectWithInverseEList.ManyInverse(dataClass, this, property, reverseProperty);
      case ListKind.NONCONTAINMENT_INVERSE_UNSETTABLE:
        return new EObjectWithInverseEList.Unsettable(dataClass, this, property, reverseProperty);
      case ListKind.NONCONTAINMENT_INVERSE:
        return new EObjectWithInverseEList(dataClass, this, property, reverseProperty);
      case ListKind.NONCONTAINMENT_RESOLVING_UNSETTABLE:
        return new EObjectResolvingEList.Unsettable(dataClass, this, property);
      case ListKind.NONCONTAINMENT_RESOLVING:
        return new EObjectResolvingEList(dataClass, this, property);
      case ListKind.NONCONTAINMENT_UNSETTABLE:
        return new EObjectEList.Unsettable(dataClass, this, property);
      case ListKind.NONCONTAINMENT:
        return new EObjectEList(dataClass, this, property);
      case ListKind.DATATYPE_UNIQUE_UNSETTABLE:
        return new EDataTypeUniqueEList.Unsettable(dataClass, this, property);
      case ListKind.DATATYPE_UNIQUE:
        return new EDataTypeUniqueEList(dataClass, this, property);
      case ListKind.DATATYPE_UNSETTABLE:
        return new EDataTypeEList.Unsettable(dataClass, this, property);
      case ListKind.DATATYPE:
        return new EDataTypeEList(dataClass, this, property);
    }
    return null;
  }
  
  protected BasicSequence createSequence(int property) {
    return new BasicSequence(new BasicFeatureMap(this, property));
  }
  
  protected Sequence createSequence(Sequence sequence, Type type, int propertyIndex) {
    return new BasicSequence((FeatureMap.Internal)((FeatureMap.Internal.Wrapper)sequence).featureMap().list(((EClass)type).getEStructuralFeature(propertyIndex)));
  }
  
  protected void createChangeSummary(int property) {
    ChangeSummaryImpl changeSummary = (ChangeSummaryImpl)SDOFactory.eINSTANCE.createChangeSummary();
    set(property, changeSummary);
    changeSummary.setDataObject(this);
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
  
  protected ChangeContext addNotification(Object notifier, int eventType, int featureID, Object oldValue, Object newValue, boolean isSetChanged, ChangeContext changeContext) 
  {
    ENotificationImpl notification = new ENotificationImpl((InternalEObject)notifier, eventType, featureID, oldValue, newValue, isSetChanged );
    ChangeContextImpl changeContextImpl = initializeChangeContext(changeContext);
    if (changeContextImpl.notificationChain == null) changeContextImpl.notificationChain = notification; else changeContextImpl.notificationChain.add(notification);
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
    Resource resource = this.eResource();
    ResourceSet resourceSet = resource != null ? resource.getResourceSet() : null;
    if (resourceSet != null) return EcoreUtil.resolve((EObject)proxy, resourceSet);
      
    URI proxyURI = ((InternalEObject)proxy).eProxyURI();
    if (proxyURI != null)
    {
      EPackage ePackage = HelperContextImpl.getBuiltInModelRegistry().getEPackage(proxyURI.trimFragment().toString());
      if (ePackage != null)
      {
        resource = ePackage.eResource();
        if (resource != null)
        {
          return resource.getEObject(proxyURI.fragment().toString());
        }
      }
    }
    return null;
  }
  

  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Following methods override EMF methods to work with pure SDO generated subclasses
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  public EClass eStaticClass()
  {
    return (EClass)getStaticType();
  }
  
  public Type getStaticType() // must be overridden in subclasses
  {
    throw new UnsupportedOperationException();
  }
  
  public int eStaticFeatureCount()
  {
    return getStaticPropertyCount();  
  }
  
  public int getStaticPropertyCount() // must be overridden in subclasses
  {
    throw new UnsupportedOperationException();
  }
  
  protected int internalConvertIndex(int internalIndex)
  {
    return internalIndex;
  }
  
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    Object result = get(internalConvertIndex(featureID), resolve);
    if (coreType)
    {
      if (result instanceof FeatureMap.Internal.Wrapper) result = ((FeatureMap.Internal.Wrapper)result).featureMap();
    }
    return result;
  }

  public void eSet(int featureID, Object newValue)
  {
    set(internalConvertIndex(featureID), newValue);
  } 

  public void eUnset(int featureID)
  {
    unset(internalConvertIndex(featureID));
  }
  
  public boolean eIsSet(int featureID)
  {
    return isSet(internalConvertIndex(featureID));
  }
  
  private class ChangeContextImpl implements ChangeContext
  {
    protected NotificationChain notificationChain;
    public ChangeContextImpl(NotificationChain notificationChain) {
      this.notificationChain = notificationChain;
    }
  }
  
  //FB TODO ... review this? ... what about eInverseAdd?
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int internalIndex, NotificationChain msgs)
  {
    return ((ChangeContextImpl)inverseRemove(otherEnd, internalConvertIndex(internalIndex), new ChangeContextImpl(msgs))).notificationChain;
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







