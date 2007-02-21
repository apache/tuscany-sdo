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
import com.example.sequences.TwoRCsMixed;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import java.util.Collection;
import java.util.List;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Two RCs Mixed</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.example.sequences.impl.TwoRCsMixedImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.example.sequences.impl.TwoRCsMixedImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link com.example.sequences.impl.TwoRCsMixedImpl#getA <em>A</em>}</li>
 *   <li>{@link com.example.sequences.impl.TwoRCsMixedImpl#getB <em>B</em>}</li>
 *   <li>{@link com.example.sequences.impl.TwoRCsMixedImpl#getSplit <em>Split</em>}</li>
 *   <li>{@link com.example.sequences.impl.TwoRCsMixedImpl#getGroup1 <em>Group1</em>}</li>
 *   <li>{@link com.example.sequences.impl.TwoRCsMixedImpl#getY <em>Y</em>}</li>
 *   <li>{@link com.example.sequences.impl.TwoRCsMixedImpl#getZ <em>Z</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TwoRCsMixedImpl extends DataObjectBase implements TwoRCsMixed
{
  /**
   * The feature id for the '<em><b>Mixed</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int MIXED = 0;

  /**
   * The feature id for the '<em><b>Group</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int GROUP = 1;

  /**
   * The feature id for the '<em><b>A</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int A = 2;

  /**
   * The feature id for the '<em><b>B</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int B = 3;

  /**
   * The feature id for the '<em><b>Split</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int SPLIT = 4;

  /**
   * The feature id for the '<em><b>Group1</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int GROUP1 = 5;

  /**
   * The feature id for the '<em><b>Y</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int Y = 6;

  /**
   * The feature id for the '<em><b>Z</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int Z = 7;

  /**
   * This represents the number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  
  public final static int SDO_PROPERTY_COUNT = 8;

  /**
   * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMixed()
   * @generated
   * @ordered
   */
  
  protected Sequence mixed = null;
  
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TwoRCsMixedImpl()
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
    return ((SequencesFactoryImpl)SequencesFactory.INSTANCE).getTwoRCsMixed();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sequence getMixed()
  {
    if (mixed == null)
    {
      mixed = createSequence(MIXED);
    }
    return mixed;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sequence getGroup()
  {
    return createSequence(getMixed(), getType(), GROUP);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getA()
  {
          return getList(getGroup(), getType(), A);

  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getB()
  {
          return getList(getGroup(), getType(), B);

  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSplit()
  {
    return (String)get(getMixed(), getType(), SPLIT);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSplit(String newSplit)
  {
    set(getMixed(), getType(), SPLIT, newSplit);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sequence getGroup1()
  {
    return createSequence(getMixed(), getType(), GROUP1);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getY()
  {
          return getList(getGroup1(), getType(), Y);

  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getZ()
  {
          return getList(getGroup1(), getType(), Z);

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
      case MIXED:
        return removeFromSequence(getMixed(), otherEnd, changeContext);
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
      case MIXED:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getMixed();
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
      case MIXED:
      	setSequence(getMixed(), newValue);
        return;
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
      case MIXED:
        unsetSequence(getMixed());
        return;
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
        setSplit(SPLIT_DEFAULT_);
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
      case MIXED:
        return mixed != null && !isSequenceEmpty(getMixed());
      case GROUP:
        return !isSequenceEmpty(getGroup());
      case A:
        return !getA().isEmpty();
      case B:
        return !getB().isEmpty();
      case SPLIT:
        return SPLIT_DEFAULT_ == null ? getSplit() != null : !SPLIT_DEFAULT_.equals(getSplit());
      case GROUP1:
        return !isSequenceEmpty(getGroup1());
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
    result.append(" (mixed: ");
    result.append(mixed);
    result.append(')');
    return result.toString();
  }

} //TwoRCsMixedImpl
