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

import com.example.sequences.MixedRepeatingChoice;
import com.example.sequences.SequencesFactory;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import java.util.Collection;
import java.util.List;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mixed Repeating Choice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.example.sequences.impl.MixedRepeatingChoiceImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.example.sequences.impl.MixedRepeatingChoiceImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link com.example.sequences.impl.MixedRepeatingChoiceImpl#getA <em>A</em>}</li>
 *   <li>{@link com.example.sequences.impl.MixedRepeatingChoiceImpl#getB <em>B</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MixedRepeatingChoiceImpl extends DataObjectBase implements MixedRepeatingChoice
{

  public final static int MIXED = -1;

  public final static int GROUP = -2;

  public final static int A = 0;

  public final static int B = 1;

  public final static int SDO_PROPERTY_COUNT = 2;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Mixed</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_MIXED = 0;

  /**
   * The internal feature id for the '<em><b>Group</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_GROUP = 1;

  /**
   * The internal feature id for the '<em><b>A</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_A = 2;

  /**
   * The internal feature id for the '<em><b>B</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_B = 3;

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
      case INTERNAL_MIXED: return MIXED;
      case INTERNAL_GROUP: return GROUP;
      case INTERNAL_A: return A;
      case INTERNAL_B: return B;
    }
    return super.internalConvertIndex(internalIndex);
  }


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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MixedRepeatingChoiceImpl()
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
    return ((SequencesFactoryImpl)SequencesFactory.INSTANCE).getMixedRepeatingChoice();
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
  public Sequence getMixed()
  {
    if (mixed == null)
    {
      mixed = createSequence(INTERNAL_MIXED);
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
    return createSequence(getMixed(), getType(), INTERNAL_GROUP);
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
  public ChangeContext inverseRemove(Object otherEnd, int propertyIndex, ChangeContext changeContext)
  {
    switch (propertyIndex)
    {
      case MIXED:
        return removeFromSequence(getMixed(), otherEnd, changeContext);
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

} //MixedRepeatingChoiceImpl
