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

import org.apache.tuscany.sdo.SDOFactory;
import org.apache.tuscany.sdo.SDOPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EFactoryImpl;

import commonj.sdo.DataObject;
import commonj.sdo.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extensible Data Object</b></em>'.
 * @extends EStructuralFeature.Internal.DynamicValueHolder
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ExtensibleDataObjectImpl extends DataObjectImpl implements DataObject, EStructuralFeature.Internal.DynamicValueHolder
{
  protected EClass eClass;
  protected Object [] eSettings;

  protected static final Object [] ENO_SETTINGS = new Object [0];

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExtensibleDataObjectImpl()
  {
    super();
  }

  /**
   * Creates an extensible DataObject.
   */
  public ExtensibleDataObjectImpl(EClass eClass) 
  {
    super();
    eSetClass(eClass);
    Property csp = ((ClassImpl)eClass).getChangeSummaryProperty();
    if (csp != null)
    {
      ChangeSummaryImpl changeSummary = (ChangeSummaryImpl)SDOFactory.eINSTANCE.createChangeSummary();
      set(csp, changeSummary);
      changeSummary.setDataObject(this);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EClass eStaticClass()
  {
    return SDOPackage.eINSTANCE.getExtensibleDataObject();
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

  protected EClass eDynamicClass()
  {
    return eClass;
  }

  protected boolean isDynamic()
  {
    return (eClass != null);
  }

  public Object get(int featureID, boolean resolve)
  {
    return get(featureID, resolve, true);  
  }
  
  public Object get(int featureID, boolean resolve, boolean coreType)
  {
    Object result = null;
    if (isDynamic() || featureID >= eStaticFeatureCount())
    {
      result = super.eGet(featureID, resolve, coreType);
    } 
    else
    {
      result = super.get(featureID);
    }
    return result;
  }
  
  public void set(int featureID, Object newValue)
  {
    if (isDynamic() || featureID >= eStaticFeatureCount())
    {
      super.eSet(featureID, newValue);
    } 
    else 
    {
      super.set(featureID, newValue);
    }
  } 

  public void unset(int featureID)
  {
    if (isDynamic() || featureID >= eStaticFeatureCount())
    {
      super.eUnset(featureID);
    } 
    else 
    {
      super.unset(featureID);
    }
  }
  
  public boolean isSet(int featureID)
  {
    if (isDynamic() || featureID >= eStaticFeatureCount())
    {
      return super.eIsSet(featureID);
    } 
    else
    {
      return super.isSet(featureID);
    }
  }
  
  public EClass eClass()
  {
    return isDynamic() ? eClass : eStaticClass();
  }

  public void eSetClass(EClass eClass)
  {
    this.eClass = eClass;
  }

  public Object dynamicGet(int dynamicFeatureID)
  {
    return eSettings[dynamicFeatureID];
  }

  public void dynamicSet(int dynamicFeatureID, Object value)
  {
    eSettings[dynamicFeatureID] = value;
  }

  public void dynamicUnset(int dynamicFeatureID)
  {
    eSettings[dynamicFeatureID] = null;
  }
  
  public Object eDynamicGet(int featureID, boolean resolve, boolean coreType)
  {
    int dynamicFeatureID = featureID - eStaticFeatureCount();
    if (featureID < eClass().getFeatureCount())
    {
      EStructuralFeature eFeature = eClass().getEStructuralFeature(featureID);
      return eSettingDelegate(eFeature).dynamicGet(this, eSettings(), dynamicFeatureID, resolve, coreType);
    }
    else
    {
      return super.eDynamicGet(dynamicFeatureID, resolve, coreType);
    }
  }
  
  public void eDynamicSet(int featureID, Object newValue)
  {
    int dynamicFeatureID = featureID - eStaticFeatureCount();
    if (featureID < eClass().getFeatureCount())
    {
      EStructuralFeature eFeature = eClass().getEStructuralFeature(featureID);
      eDynamicSet(dynamicFeatureID, eFeature, newValue);
    }
    else
    {
      super.eDynamicSet(dynamicFeatureID, newValue);
    }
  }

  public void eDynamicUnset(int featureID)
  {
    int dynamicFeatureID = featureID - eStaticFeatureCount();
    if (featureID < eClass().getFeatureCount())
    {
      EStructuralFeature eFeature = eClass().getEStructuralFeature(featureID);
      eDynamicUnset(dynamicFeatureID, eFeature);
    }
    else
    {
      super.eDynamicUnset(dynamicFeatureID);
    }
  }

  public boolean eDynamicIsSet(int featureID)
  {
    int dynamicFeatureID = featureID - eStaticFeatureCount();
    if (featureID < eClass().getFeatureCount())
    {
      EStructuralFeature eFeature = eClass().getEStructuralFeature(featureID);
      return eSettingDelegate(eFeature).dynamicIsSet(this, eSettings(), dynamicFeatureID);
    }
    else
    {
      return super.eDynamicIsSet(dynamicFeatureID);
    }
  }

  /**
   * An EFactoryImpl that creates ExtensibleDataObjectImpl instances.
   */
  public static class FactoryImpl extends EFactoryImpl
  {
    public FactoryImpl()
    {
    }

    public EObject basicCreate(EClass eClass)
    {
      return new ExtensibleDataObjectImpl(eClass);
    }
  }

} //ExtensibleDataObjectImpl
