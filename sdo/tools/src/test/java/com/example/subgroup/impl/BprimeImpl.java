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
package com.example.subgroup.impl;

import com.example.subgroup.Bprime;
import com.example.subgroup.SubgroupFactory;

import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bprime</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.example.subgroup.impl.BprimeImpl#getImInTypeBprime <em>Im In Type Bprime</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BprimeImpl extends BImpl implements Bprime
{

  public final static int IM_IN_TYPE_BPRIME = BImpl.SDO_PROPERTY_COUNT + 0;

  public final static int SDO_PROPERTY_COUNT = BImpl.SDO_PROPERTY_COUNT + 1;

  public final static int EXTENDED_PROPERTY_COUNT = BImpl.EXTENDED_PROPERTY_COUNT - 0;


  /**
   * The internal feature id for the '<em><b>Im In Type B</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_IM_IN_TYPE_B = BImpl.IM_IN_TYPE_B;

  /**
   * The internal feature id for the '<em><b>Im In Type Bprime</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_IM_IN_TYPE_BPRIME = BImpl.INTERNAL_PROPERTY_COUNT + 0;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = BImpl.INTERNAL_PROPERTY_COUNT + 1;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_IM_IN_TYPE_B: return IM_IN_TYPE_B;
      case INTERNAL_IM_IN_TYPE_BPRIME: return IM_IN_TYPE_BPRIME;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The default value of the '{@link #getImInTypeBprime() <em>Im In Type Bprime</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImInTypeBprime()
   * @generated
   * @ordered
   */
  protected static final String IM_IN_TYPE_BPRIME_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getImInTypeBprime() <em>Im In Type Bprime</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImInTypeBprime()
   * @generated
   * @ordered
   */
  protected String imInTypeBprime = IM_IN_TYPE_BPRIME_DEFAULT_;

  /**
   * This is true if the Im In Type Bprime attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean imInTypeBprime_set_ = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BprimeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getType()
  {
    return ((SubgroupFactoryImpl)SubgroupFactory.INSTANCE).getBprime();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getImInTypeBprime()
  {
    return imInTypeBprime;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImInTypeBprime(String newImInTypeBprime)
  {
    String oldImInTypeBprime = imInTypeBprime;
    imInTypeBprime = newImInTypeBprime;
    boolean oldImInTypeBprime_set_ = imInTypeBprime_set_;
    imInTypeBprime_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, IM_IN_TYPE_BPRIME, oldImInTypeBprime, imInTypeBprime, !oldImInTypeBprime_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetImInTypeBprime()
  {
    String oldImInTypeBprime = imInTypeBprime;
    boolean oldImInTypeBprime_set_ = imInTypeBprime_set_;
    imInTypeBprime = IM_IN_TYPE_BPRIME_DEFAULT_;
    imInTypeBprime_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, IM_IN_TYPE_BPRIME, oldImInTypeBprime, IM_IN_TYPE_BPRIME_DEFAULT_, oldImInTypeBprime_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetImInTypeBprime()
  {
    return imInTypeBprime_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object get(int propertyIndex, boolean resolve)
  {
    switch (propertyIndex)
    {
      case IM_IN_TYPE_BPRIME:
        return getImInTypeBprime();
    }
    return super.get(propertyIndex, resolve);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void set(int propertyIndex, Object newValue)
  {
    switch (propertyIndex)
    {
      case IM_IN_TYPE_BPRIME:
        setImInTypeBprime((String)newValue);
        return;
    }
    super.set(propertyIndex, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unset(int propertyIndex)
  {
    switch (propertyIndex)
    {
      case IM_IN_TYPE_BPRIME:
        unsetImInTypeBprime();
        return;
    }
    super.unset(propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSet(int propertyIndex)
  {
    switch (propertyIndex)
    {
      case IM_IN_TYPE_BPRIME:
        return isSetImInTypeBprime();
    }
    return super.isSet(propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String toString()
  {
    if (isProxy(this)) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (imInTypeBprime: ");
    if (imInTypeBprime_set_) result.append(imInTypeBprime); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //BprimeImpl
