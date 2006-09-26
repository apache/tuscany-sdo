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

import java.util.Iterator;

import org.apache.tuscany.sdo.SDOPackage;
import org.apache.tuscany.sdo.SimpleAnyTypeDataObject;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xml.type.SimpleAnyType;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EData Object Simple Any Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.impl.SimpleAnyTypeDataObjectImpl#getRawValue <em>Raw Value</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.impl.SimpleAnyTypeDataObjectImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.impl.SimpleAnyTypeDataObjectImpl#getInstanceType <em>Instance Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleAnyTypeDataObjectImpl extends AnyTypeDataObjectImpl implements SimpleAnyTypeDataObject
{
  /**
   * The default value of the '{@link #getRawValue() <em>Raw Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRawValue()
   * @generated
   * @ordered
   */
  protected static final String RAW_VALUE_EDEFAULT = null;

  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final Object VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getInstanceType() <em>Instance Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInstanceType()
   * @generated
   * @ordered
   */
  protected EDataType instanceType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SimpleAnyTypeDataObjectImpl()
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
    return SDOPackage.eINSTANCE.getSimpleAnyTypeDataObject();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String getRawValue()
  {
    StringBuffer value = new StringBuffer();
    for (Iterator i = getMixed().iterator(); i.hasNext(); )
    {
      FeatureMap.Entry entry = (FeatureMap.Entry)i.next();
      if (entry.getEStructuralFeature() == XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_Text())
      {
        value.append(entry.getValue());
      }
    }
    return value.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setRawValue(String newRawValue)
  {
    getMixed().clear();
    if (newRawValue != null)
    {
      getMixed().add(XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_Text(), newRawValue);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Object getValue()
  {
    return EcoreUtil.createFromString(instanceType, getRawValue());
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setValue(Object newValue)
  {
    setRawValue(EcoreUtil.convertToString(instanceType, newValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getInstanceType()
  {
    return instanceType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInstanceType(EDataType newInstanceType)
  {
    EDataType oldInstanceType = instanceType;
    instanceType = newInstanceType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__INSTANCE_TYPE, oldInstanceType, instanceType));
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
      case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__MIXED:
        if (coreType) return getMixed();
        return ((FeatureMap.Internal)getMixed()).getWrapper();
      case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__ANY:
        if (coreType) return getAny();
        return ((FeatureMap.Internal)getAny()).getWrapper();
      case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__ANY_ATTRIBUTE:
        if (coreType) return getAnyAttribute();
        return ((FeatureMap.Internal)getAnyAttribute()).getWrapper();
      case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__RAW_VALUE:
        return getRawValue();
      case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__VALUE:
        return getValue();
      case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__INSTANCE_TYPE:
        return getInstanceType();
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
      case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__MIXED:
        ((FeatureMap.Internal)getMixed()).set(newValue);
        return;
      case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__ANY:
        ((FeatureMap.Internal)getAny()).set(newValue);
        return;
      case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__ANY_ATTRIBUTE:
        ((FeatureMap.Internal)getAnyAttribute()).set(newValue);
        return;
      case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__RAW_VALUE:
        setRawValue((String)newValue);
        return;
      case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__VALUE:
        setValue((Object)newValue);
        return;
      case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__INSTANCE_TYPE:
        setInstanceType((EDataType)newValue);
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
      case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__MIXED:
        getMixed().clear();
        return;
      case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__ANY:
        getAny().clear();
        return;
      case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__ANY_ATTRIBUTE:
        getAnyAttribute().clear();
        return;
      case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__RAW_VALUE:
        setRawValue(RAW_VALUE_EDEFAULT);
        return;
      case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
      case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__INSTANCE_TYPE:
        setInstanceType((EDataType)null);
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
      case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__MIXED:
        return mixed != null && !mixed.isEmpty();
      case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__ANY:
        return !getAny().isEmpty();
      case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__ANY_ATTRIBUTE:
        return anyAttribute != null && !anyAttribute.isEmpty();
      case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__RAW_VALUE:
        return RAW_VALUE_EDEFAULT == null ? getRawValue() != null : !RAW_VALUE_EDEFAULT.equals(getRawValue());
      case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__VALUE:
        return VALUE_EDEFAULT == null ? getValue() != null : !VALUE_EDEFAULT.equals(getValue());
      case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__INSTANCE_TYPE:
        return instanceType != null;
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
    if (baseClass == SimpleAnyType.class)
    {
      switch (derivedFeatureID)
      {
        case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__RAW_VALUE: return XMLTypePackage.SIMPLE_ANY_TYPE__RAW_VALUE;
        case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__VALUE: return XMLTypePackage.SIMPLE_ANY_TYPE__VALUE;
        case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__INSTANCE_TYPE: return XMLTypePackage.SIMPLE_ANY_TYPE__INSTANCE_TYPE;
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
    if (baseClass == SimpleAnyType.class)
    {
      switch (baseFeatureID)
      {
        case XMLTypePackage.SIMPLE_ANY_TYPE__RAW_VALUE: return SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__RAW_VALUE;
        case XMLTypePackage.SIMPLE_ANY_TYPE__VALUE: return SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__VALUE;
        case XMLTypePackage.SIMPLE_ANY_TYPE__INSTANCE_TYPE: return SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT__INSTANCE_TYPE;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

} //EDataObjectSimpleAnyTypeImpl
