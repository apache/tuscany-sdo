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

import com.example.subgroup.A;
import com.example.subgroup.B;
import com.example.subgroup.SubgroupFactory;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>A</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.example.subgroup.impl.AImpl#getGe1Group <em>Ge1 Group</em>}</li>
 *   <li>{@link com.example.subgroup.impl.AImpl#getGe1 <em>Ge1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AImpl extends DataObjectBase implements A
{

  public final static int GE1_GROUP = -1;

  public final static int GE1 = 0;

  public final static int SDO_PROPERTY_COUNT = 1;

  public final static int EXTENDED_PROPERTY_COUNT = -1;


  /**
   * The internal feature id for the '<em><b>Ge1 Group</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_GE1_GROUP = 0;

  /**
   * The internal feature id for the '<em><b>Ge1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_GE1 = 1;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 2;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_GE1_GROUP: return GE1_GROUP;
      case INTERNAL_GE1: return GE1;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getGe1Group() <em>Ge1 Group</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGe1Group()
   * @generated
   * @ordered
   */
  
  protected Sequence ge1Group = null;
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AImpl()
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
    return ((SubgroupFactoryImpl)SubgroupFactory.INSTANCE).getA();
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
  public Sequence getGe1Group()
  {
    if (ge1Group == null)
    {
      ge1Group = createSequence(INTERNAL_GE1_GROUP);
    }
    return ge1Group;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public B getGe1()
  {
    return (B)get(getGe1Group(), getType(), INTERNAL_GE1);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetGe1(B newGe1, ChangeContext changeContext)
  {
    return basicAdd(getGe1Group(), getType(), INTERNAL_GE1, newGe1, changeContext);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGe1(B newGe1)
  {
    set(getGe1Group(), getType(), INTERNAL_GE1, newGe1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetGe1(ChangeContext changeContext)
  {
    // TODO: implement this method to unset the contained 'Ge1' containment reference
    // -> this method is automatically invoked to keep the containment relationship in synch
    // -> do not modify other features
    // -> return changeContext, after adding any generated Notification to it (if it is null, a NotificationChain object must be created first)
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetGe1()
  {
        unset(getGe1Group(), getType(), INTERNAL_GE1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetGe1()
  {
        return isSet(getGe1Group(), getType(), INTERNAL_GE1);
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
      case GE1_GROUP:
        return removeFromSequence(getGe1Group(), otherEnd, changeContext);
      case GE1:
        return basicUnsetGe1(changeContext);
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
      case GE1_GROUP:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getGe1Group();
      case GE1:
        return getGe1();
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
      case GE1_GROUP:
      	setSequence(getGe1Group(), newValue);
        return;
      case GE1:
        setGe1((B)newValue);
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
      case GE1_GROUP:
        unsetSequence(getGe1Group());
        return;
      case GE1:
        unsetGe1();
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
      case GE1_GROUP:
        return ge1Group != null && !isSequenceEmpty(getGe1Group());
      case GE1:
        return isSetGe1();
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
    result.append(" (ge1Group: ");
    result.append(ge1Group);
    result.append(')');
    return result.toString();
  }

} //AImpl
