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
package com.example.sequences.impl;

import com.example.sequences.SequencesFactory;
import com.example.sequences.TwoRCs;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import java.util.Collection;
import java.util.List;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Two RCs</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.example.sequences.impl.TwoRCsImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link com.example.sequences.impl.TwoRCsImpl#getA <em>A</em>}</li>
 *   <li>{@link com.example.sequences.impl.TwoRCsImpl#getB <em>B</em>}</li>
 *   <li>{@link com.example.sequences.impl.TwoRCsImpl#getSplit <em>Split</em>}</li>
 *   <li>{@link com.example.sequences.impl.TwoRCsImpl#getGroup1 <em>Group1</em>}</li>
 *   <li>{@link com.example.sequences.impl.TwoRCsImpl#getY <em>Y</em>}</li>
 *   <li>{@link com.example.sequences.impl.TwoRCsImpl#getZ <em>Z</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TwoRCsImpl extends DataObjectBase implements TwoRCs
{

  public final static int GROUP = -1;

  public final static int A = 0;

  public final static int B = 1;

  public final static int SPLIT = 2;

  public final static int GROUP1 = -2;

  public final static int Y = 3;

  public final static int Z = 4;

  public final static int SDO_PROPERTY_COUNT = 5;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Group</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_GROUP = 0;

  /**
   * The internal feature id for the '<em><b>A</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_A = 1;

  /**
   * The internal feature id for the '<em><b>B</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_B = 2;

  /**
   * The internal feature id for the '<em><b>Split</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_SPLIT = 3;

  /**
   * The internal feature id for the '<em><b>Group1</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_GROUP1 = 4;

  /**
   * The internal feature id for the '<em><b>Y</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_Y = 5;

  /**
   * The internal feature id for the '<em><b>Z</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_Z = 6;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 7;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_GROUP: return GROUP;
      case INTERNAL_A: return A;
      case INTERNAL_B: return B;
      case INTERNAL_SPLIT: return SPLIT;
      case INTERNAL_GROUP1: return GROUP1;
      case INTERNAL_Y: return Y;
      case INTERNAL_Z: return Z;
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
   * The default value of the '{@link #getSplit() <em>Split</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSplit()
   * @generated
   * @ordered
   */
  protected static final String SPLIT_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getSplit() <em>Split</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSplit()
   * @generated
   * @ordered
   */
  protected String split = SPLIT_DEFAULT_;

  /**
   * This is true if the Split attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean split_set_ = false;

  /**
   * The cached value of the '{@link #getGroup1() <em>Group1</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroup1()
   * @generated
   * @ordered
   */
  
  protected Sequence group1 = null;
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TwoRCsImpl()
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
    return ((SequencesFactoryImpl)SequencesFactory.INSTANCE).getTwoRCs();
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
  public List getA()
  {
    return getList(getGroup(), getType(), INTERNAL_A);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getB()
  {
    return getList(getGroup(), getType(), INTERNAL_B);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSplit()
  {
    return split;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSplit(String newSplit)
  {
    String oldSplit = split;
    split = newSplit;
    boolean oldSplit_set_ = split_set_;
    split_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_SPLIT, oldSplit, split, !oldSplit_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetSplit()
  {
    String oldSplit = split;
    boolean oldSplit_set_ = split_set_;
    split = SPLIT_DEFAULT_;
    split_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_SPLIT, oldSplit, SPLIT_DEFAULT_, oldSplit_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetSplit()
  {
    return split_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sequence getGroup1()
  {
    if (group1 == null)
    {
      group1 = createSequence(INTERNAL_GROUP1);
    }
    return group1;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getY()
  {
    return getList(getGroup1(), getType(), INTERNAL_Y);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getZ()
  {
    return getList(getGroup1(), getType(), INTERNAL_Z);
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
      case GROUP1:
        return removeFromSequence(getGroup1(), otherEnd, changeContext);
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
      case A:
        return getA();
      case B:
        return getB();
      case SPLIT:
        return getSplit();
      case GROUP1:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getGroup1();
      case Y:
        return getY();
      case Z:
        return getZ();
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
      case A:
        getA().clear();
        getA().addAll((Collection)newValue);
        return;
      case B:
        getB().clear();
        getB().addAll((Collection)newValue);
        return;
      case SPLIT:
        setSplit((String)newValue);
        return;
      case GROUP1:
      	setSequence(getGroup1(), newValue);
        return;
      case Y:
        getY().clear();
        getY().addAll((Collection)newValue);
        return;
      case Z:
        getZ().clear();
        getZ().addAll((Collection)newValue);
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
      case A:
        getA().clear();
        return;
      case B:
        getB().clear();
        return;
      case SPLIT:
        unsetSplit();
        return;
      case GROUP1:
        unsetSequence(getGroup1());
        return;
      case Y:
        getY().clear();
        return;
      case Z:
        getZ().clear();
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
      case A:
        return !getA().isEmpty();
      case B:
        return !getB().isEmpty();
      case SPLIT:
        return isSetSplit();
      case GROUP1:
        return group1 != null && !isSequenceEmpty(getGroup1());
      case Y:
        return !getY().isEmpty();
      case Z:
        return !getZ().isEmpty();
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
    result.append(", split: ");
    if (split_set_) result.append(split); else result.append("<unset>");
    result.append(", group1: ");
    result.append(group1);
    result.append(')');
    return result.toString();
  }

} //TwoRCsImpl
