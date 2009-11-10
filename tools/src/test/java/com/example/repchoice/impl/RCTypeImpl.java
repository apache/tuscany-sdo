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
package com.example.repchoice.impl;

import com.example.repchoice.RCType;
import com.example.repchoice.RepchoiceFactory;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import java.util.Collection;
import java.util.List;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>RC Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.example.repchoice.impl.RCTypeImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link com.example.repchoice.impl.RCTypeImpl#getS <em>S</em>}</li>
 *   <li>{@link com.example.repchoice.impl.RCTypeImpl#getI <em>I</em>}</li>
 *   <li>{@link com.example.repchoice.impl.RCTypeImpl#getF <em>F</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RCTypeImpl extends DataObjectBase implements RCType
{

  public final static int GROUP = -1;

  public final static int S = 0;

  public final static int I = 1;

  public final static int F = 2;

  public final static int SDO_PROPERTY_COUNT = 3;

  public final static int EXTENDED_PROPERTY_COUNT = -1;


  /**
   * The internal feature id for the '<em><b>Group</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_GROUP = 0;

  /**
   * The internal feature id for the '<em><b>S</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_S = 1;

  /**
   * The internal feature id for the '<em><b>I</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_I = 2;

  /**
   * The internal feature id for the '<em><b>F</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_F = 3;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 4;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_GROUP: return GROUP;
      case INTERNAL_S: return S;
      case INTERNAL_I: return I;
      case INTERNAL_F: return F;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroup()
   * @generated
   * @ordered
   */
  
  protected Sequence group = null;
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RCTypeImpl()
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
    return ((RepchoiceFactoryImpl)RepchoiceFactory.INSTANCE).getRCType();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getStaticPropertyCount()
  {
    return INTERNAL_PROPERTY_COUNT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sequence getGroup()
  {
    if (group == null)
    {
      group = createSequence(INTERNAL_GROUP);
    }
    return group;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getS()
  {
    return getList(getGroup(), getType(), INTERNAL_S);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getI()
  {
    return getList(getGroup(), getType(), INTERNAL_I);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getF()
  {
    return getList(getGroup(), getType(), INTERNAL_F);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext inverseRemove(Object otherEnd, int propertyIndex, ChangeContext changeContext)
  {
    switch (propertyIndex)
    {
      case GROUP:
        return removeFromSequence(getGroup(), otherEnd, changeContext);
    }
    return super.inverseRemove(otherEnd, propertyIndex, changeContext);
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
      case GROUP:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getGroup();
      case S:
        return getS();
      case I:
        return getI();
      case F:
        return getF();
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
      case GROUP:
      	setSequence(getGroup(), newValue);
        return;
      case S:
        getS().clear();
        getS().addAll((Collection)newValue);
        return;
      case I:
        getI().clear();
        getI().addAll((Collection)newValue);
        return;
      case F:
        getF().clear();
        getF().addAll((Collection)newValue);
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
      case GROUP:
        unsetSequence(getGroup());
        return;
      case S:
        getS().clear();
        return;
      case I:
        getI().clear();
        return;
      case F:
        getF().clear();
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
      case GROUP:
        return group != null && !isSequenceEmpty(getGroup());
      case S:
        return !getS().isEmpty();
      case I:
        return !getI().isEmpty();
      case F:
        return !getF().isEmpty();
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
    result.append(" (group: ");
    result.append(group);
    result.append(')');
    return result.toString();
  }

} //RCTypeImpl
