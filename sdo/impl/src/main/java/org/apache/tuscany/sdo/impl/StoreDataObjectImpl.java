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

import org.apache.tuscany.sdo.SDOPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EStoreEObjectImpl.EStoreEList;
import org.eclipse.emf.ecore.impl.EStoreEObjectImpl.EStoreFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

import commonj.sdo.DataObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Store Data Object</b></em>'.
 * @extends EStructuralFeature.Internal.DynamicValueHolder
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class StoreDataObjectImpl extends DataObjectImpl implements DataObject, EStructuralFeature.Internal.DynamicValueHolder
{
  //TODO consider factoring the eSettings code into a new base class that this and DynamicDataObjectImpl could extend
  
  protected static final Object [] ENO_SETTINGS = new Object [0];
  protected static final InternalEObject EUNINITIALIZED_CONTAINER = new DynamicDataObjectImpl();

  protected Object [] eSettings;
  protected InternalEObject.EStore eStore;

  /**
   * Creates a store-based DataObject.
   */
  public StoreDataObjectImpl()
  {
    super();
    eContainer = EUNINITIALIZED_CONTAINER;
  }

  /**
   * Creates a store-based DataObject.
   */
  public StoreDataObjectImpl(InternalEObject.EStore eStore) 
  {
    super();
    eSetStore(eStore);
    eContainer = EUNINITIALIZED_CONTAINER;
  }

  /**
   * Creates a store-based DataObject.
   */
  public StoreDataObjectImpl(EClass eClass)
  {
    super();
    eSetClass(eClass);
    eContainer = EUNINITIALIZED_CONTAINER;
  }

  /**
   * Creates a store-based DataObject.
   */
  public StoreDataObjectImpl(EClass eClass, InternalEObject.EStore eStore) 
  {
    super();
    eSetClass(eClass);
    eSetStore(eStore);
    eContainer = EUNINITIALIZED_CONTAINER;
  }

  protected boolean eIsCaching()
  {
    return true;
  }

  public Object dynamicGet(int dynamicFeatureID)
  {
    Object result = eSettings[dynamicFeatureID];
    if (result == null)
    {
      EStructuralFeature eStructuralFeature = eDynamicFeature(dynamicFeatureID);
      if (!eStructuralFeature.isTransient())
      {
        if (FeatureMapUtil.isFeatureMap(eStructuralFeature))
        {
          eSettings[dynamicFeatureID] = result = createFeatureMap(eStructuralFeature);
        }
        else if (eStructuralFeature.isMany())
        {
          eSettings[dynamicFeatureID] = result = createList(eStructuralFeature);
        }
        else
        {
          result = eStore().get(this, eStructuralFeature, InternalEObject.EStore.NO_INDEX);
          if (eIsCaching())
          {
            eSettings[dynamicFeatureID] = result;
          }
        }
      }
    }
    return result;
  }

  public void dynamicSet(int dynamicFeatureID, Object value)
  {
    EStructuralFeature eStructuralFeature = eDynamicFeature(dynamicFeatureID);
    if (eStructuralFeature.isTransient())
    {
      eSettings[dynamicFeatureID] = value;
    }
    else
    {
      eStore().set(this, eStructuralFeature, InternalEObject.EStore.NO_INDEX, value == NIL ? null : value);
      if (eIsCaching())
      {
        eSettings[dynamicFeatureID] = value;
      }
    }
  }

  public void dynamicUnset(int dynamicFeatureID)
  {
    eStore().unset(this, eDynamicFeature(dynamicFeatureID));
    eSettings[dynamicFeatureID] = null;
  }

  public Object eDynamicGet(int featureID, boolean resolve, boolean coreType)
  {
    if (featureID < eClass().getFeatureCount())
    {
      EStructuralFeature eFeature = eClass().getEStructuralFeature(featureID);
      return eSettingDelegate(eFeature).dynamicGet(this, eSettings(), featureID, resolve, coreType);
    }
    else
    {
      return super.eDynamicGet(featureID, resolve, coreType);
    }
  }
  
  public void eDynamicSet(int featureID, Object newValue)
  {
    if (featureID < eClass().getFeatureCount())
    {
      EStructuralFeature eFeature = eClass().getEStructuralFeature(featureID);
      eDynamicSet(featureID, eFeature, newValue);
    }
    else
    {
      super.eDynamicSet(featureID, newValue);
    }
  }

  public void eDynamicUnset(int featureID)
  {
    if (featureID < eClass().getFeatureCount())
    {
      EStructuralFeature eFeature = eClass().getEStructuralFeature(featureID);
      eDynamicUnset(featureID, eFeature);
    }
    else
    {
      super.eDynamicUnset(featureID);
    }
  }

  public boolean eDynamicIsSet(int featureID)
  {
    if (featureID < eClass().getFeatureCount())
    {
      EStructuralFeature eFeature = eClass().getEStructuralFeature(featureID);
      return eFeature.isTransient() ?
        eSettingDelegate(eFeature).dynamicIsSet(this, eSettings(), featureID) :
        eStore().isSet(this, eFeature);
    }
    else
    {
      return super.eDynamicIsSet(featureID);
    }
  }

  /*
  public boolean eDynamicIsSet(EStructuralFeature eStructuralFeature)
  {
    return 
      eStructuralFeature.isTransient() ?
        super.eDynamicIsSet(eStructuralFeature) :
        eStore().isSet(this, eStructuralFeature);
  }
  */

  protected EList createList(EStructuralFeature eStructuralFeature)
  {
    return new EStoreEList(this, eStructuralFeature, eStore());
  }

  protected FeatureMap createFeatureMap(EStructuralFeature eStructuralFeature)
  {
    return new EStoreFeatureMap(this, eStructuralFeature, eStore());
  }

  public EObject eContainer()
  {
    if (eContainer == EUNINITIALIZED_CONTAINER)
    {
      eInitializeContainer();
    }

    return eContainer;
  }

  public int eContainerFeatureID()
  {
    if (eContainer == EUNINITIALIZED_CONTAINER)
    {
      eInitializeContainer();
    }

    return eContainerFeatureID;
  }

  protected void eInitializeContainer()
  {
    eContainer = eStore().getContainer(this);
    if (eContainer != null)
    {
      EStructuralFeature eContainingFeature = eStore().getContainingFeature(this);
      if (eContainingFeature instanceof EReference)
      {
        EReference eContainingReference = (EReference)eContainingFeature;
        EReference eOpposite = eContainingReference.getEOpposite();
        if (eOpposite != null)
        {
          eContainerFeatureID = eClass().getFeatureID(eOpposite);
          return;
        }
      }

      eContainerFeatureID = EOPPOSITE_FEATURE_BASE - eContainer.eClass().getFeatureID(eContainingFeature);
    }
  }

  public InternalEObject.EStore eStore()
  {
    return eStore;
  }

  public void eSetStore(InternalEObject.EStore store)
  {
    this.eStore = store;
  }

  protected int eStaticFeatureCount()
  {
    return 0;
  }

  public int eDerivedStructuralFeatureID(EStructuralFeature eStructuralFeature)
  {
    return eClass().getFeatureID(eStructuralFeature);
  }

  protected boolean eHasSettings()
  {
    return eSettings != null;
  }

  protected EStructuralFeature.Internal.DynamicValueHolder eSettings()
  {
    if (eSettings == null)
    {
      int size = eClass().getFeatureCount() - eStaticFeatureCount();
      eSettings = size == 0 ? ENO_SETTINGS : new Object [size];
    }

    return this;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EClass eStaticClass()
  {
    return SDOPackage.eINSTANCE.getStoreDataObject();
  }

} //StoreDataObjectImpl
