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

import org.apache.tuscany.sdo.AnyTypeDataObject;
import org.apache.tuscany.sdo.SDOPackage;
import org.apache.tuscany.sdo.util.BasicSequence;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EData Object Any Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.impl.AnyTypeDataObjectImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.impl.AnyTypeDataObjectImpl#getAny <em>Any</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.impl.AnyTypeDataObjectImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnyTypeDataObjectImpl extends DataObjectImpl implements AnyTypeDataObject
{
  /**
   * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMixed()
   * @generated
   * @ordered
   */
  protected FeatureMap mixed = null;

  /**
   * The cached value of the '{@link #getAnyAttribute() <em>Any Attribute</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnyAttribute()
   * @generated
   * @ordered
   */
  protected FeatureMap anyAttribute = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AnyTypeDataObjectImpl()
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
    return SDOPackage.eINSTANCE.getAnyTypeDataObject();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public FeatureMap getMixed()
  {
    if (mixed == null)
    {
      //mixed = new BasicFeatureMap(this, SDOPackage.ANY_TYPE_DATA_OBJECT__MIXED);
      mixed = new BasicSequence(new BasicFeatureMap(this, SDOPackage.ANY_TYPE_DATA_OBJECT__MIXED)).featureMap();
    }
    return mixed;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public FeatureMap getAny()
  {
    //return (FeatureMap)((FeatureMap)getMixed()).list(XMLTypePackage.eINSTANCE.getAnyType_Any());
    return new BasicSequence((FeatureMap.Internal)((FeatureMap)getMixed()).list(XMLTypePackage.eINSTANCE.getAnyType_Any())).featureMap();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public FeatureMap getAnyAttribute()
  {
    if (anyAttribute == null)
    {
      //anyAttribute = new BasicFeatureMap(this, SDOPackage.ANY_TYPE_DATA_OBJECT__ANY_ATTRIBUTE);
      anyAttribute = new BasicSequence(new BasicFeatureMap(this, SDOPackage.ANY_TYPE_DATA_OBJECT__ANY_ATTRIBUTE)).featureMap();
    }
    return anyAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs)
  {
    if (featureID >= 0)
    {
      switch (eDerivedStructuralFeatureID(featureID, baseClass))
      {
        case SDOPackage.ANY_TYPE_DATA_OBJECT__MIXED:
          return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
        case SDOPackage.ANY_TYPE_DATA_OBJECT__ANY:
          return ((InternalEList)getAny()).basicRemove(otherEnd, msgs);
        case SDOPackage.ANY_TYPE_DATA_OBJECT__ANY_ATTRIBUTE:
          return ((InternalEList)getAnyAttribute()).basicRemove(otherEnd, msgs);
        default:
          return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
      }
    }
    return eBasicSetContainer(null, featureID, msgs);
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
      case SDOPackage.ANY_TYPE_DATA_OBJECT__MIXED:
        if (coreType) return getMixed();
        return ((FeatureMap.Internal)getMixed()).getWrapper();
      case SDOPackage.ANY_TYPE_DATA_OBJECT__ANY:
        if (coreType) return getAny();
        return ((FeatureMap.Internal)getAny()).getWrapper();
      case SDOPackage.ANY_TYPE_DATA_OBJECT__ANY_ATTRIBUTE:
        if (coreType) return getAnyAttribute();
        return ((FeatureMap.Internal)getAnyAttribute()).getWrapper();
    }
    return eDynamicGet(featureID, resolve, coreType);
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
      case SDOPackage.ANY_TYPE_DATA_OBJECT__MIXED:
        ((FeatureMap.Internal)getMixed()).set(newValue);
        return;
      case SDOPackage.ANY_TYPE_DATA_OBJECT__ANY:
        ((FeatureMap.Internal)getAny()).set(newValue);
        return;
      case SDOPackage.ANY_TYPE_DATA_OBJECT__ANY_ATTRIBUTE:
        ((FeatureMap.Internal)getAnyAttribute()).set(newValue);
        return;
    }
    eDynamicSet(featureID, newValue);
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
      case SDOPackage.ANY_TYPE_DATA_OBJECT__MIXED:
        getMixed().clear();
        return;
      case SDOPackage.ANY_TYPE_DATA_OBJECT__ANY:
        getAny().clear();
        return;
      case SDOPackage.ANY_TYPE_DATA_OBJECT__ANY_ATTRIBUTE:
        getAnyAttribute().clear();
        return;
    }
    eDynamicUnset(featureID);
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
      case SDOPackage.ANY_TYPE_DATA_OBJECT__MIXED:
        return mixed != null && !mixed.isEmpty();
      case SDOPackage.ANY_TYPE_DATA_OBJECT__ANY:
        return !getAny().isEmpty();
      case SDOPackage.ANY_TYPE_DATA_OBJECT__ANY_ATTRIBUTE:
        return anyAttribute != null && !anyAttribute.isEmpty();
    }
    return eDynamicIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass)
  {
    if (baseClass == AnyType.class)
    {
      switch (derivedFeatureID)
      {
        case SDOPackage.ANY_TYPE_DATA_OBJECT__MIXED: return XMLTypePackage.ANY_TYPE__MIXED;
        case SDOPackage.ANY_TYPE_DATA_OBJECT__ANY: return XMLTypePackage.ANY_TYPE__ANY;
        case SDOPackage.ANY_TYPE_DATA_OBJECT__ANY_ATTRIBUTE: return XMLTypePackage.ANY_TYPE__ANY_ATTRIBUTE;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass)
  {
    if (baseClass == AnyType.class)
    {
      switch (baseFeatureID)
      {
        case XMLTypePackage.ANY_TYPE__MIXED: return SDOPackage.ANY_TYPE_DATA_OBJECT__MIXED;
        case XMLTypePackage.ANY_TYPE__ANY: return SDOPackage.ANY_TYPE_DATA_OBJECT__ANY;
        case XMLTypePackage.ANY_TYPE__ANY_ATTRIBUTE: return SDOPackage.ANY_TYPE_DATA_OBJECT__ANY_ATTRIBUTE;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
    result.append(" (mixed: ");
    result.append(mixed);
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //EDataObjectAnyTypeImpl
