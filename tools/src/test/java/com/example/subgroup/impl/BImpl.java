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

import com.example.subgroup.B;
import com.example.subgroup.SubgroupFactory;

import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>B</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.example.subgroup.impl.BImpl#getImInTypeB <em>Im In Type B</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BImpl extends DataObjectBase implements B
{

  public final static int IM_IN_TYPE_B = 0;

  public final static int SDO_PROPERTY_COUNT = 1;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Im In Type B</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_IM_IN_TYPE_B = 0;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 1;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_IM_IN_TYPE_B: return IM_IN_TYPE_B;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The default value of the '{@link #getImInTypeB() <em>Im In Type B</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImInTypeB()
   * @generated
   * @ordered
   */
  protected static final String IM_IN_TYPE_B_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getImInTypeB() <em>Im In Type B</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImInTypeB()
   * @generated
   * @ordered
   */
  protected String imInTypeB = IM_IN_TYPE_B_DEFAULT_;

  /**
   * This is true if the Im In Type B attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean imInTypeB_set_ = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getStaticType()
  {
    return ((SubgroupFactoryImpl)SubgroupFactory.INSTANCE).getB();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getImInTypeB()
  {
    return imInTypeB;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImInTypeB(String newImInTypeB)
  {
    String oldImInTypeB = imInTypeB;
    imInTypeB = newImInTypeB;
    boolean oldImInTypeB_set_ = imInTypeB_set_;
    imInTypeB_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, IM_IN_TYPE_B, oldImInTypeB, imInTypeB, !oldImInTypeB_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetImInTypeB()
  {
    String oldImInTypeB = imInTypeB;
    boolean oldImInTypeB_set_ = imInTypeB_set_;
    imInTypeB = IM_IN_TYPE_B_DEFAULT_;
    imInTypeB_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, IM_IN_TYPE_B, oldImInTypeB, IM_IN_TYPE_B_DEFAULT_, oldImInTypeB_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetImInTypeB()
  {
    return imInTypeB_set_;
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
      case IM_IN_TYPE_B:
        return getImInTypeB();
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
      case IM_IN_TYPE_B:
        setImInTypeB((String)newValue);
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
      case IM_IN_TYPE_B:
        unsetImInTypeB();
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
      case IM_IN_TYPE_B:
        return isSetImInTypeB();
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
    result.append(" (imInTypeB: ");
    if (imInTypeB_set_) result.append(imInTypeB); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //BImpl
