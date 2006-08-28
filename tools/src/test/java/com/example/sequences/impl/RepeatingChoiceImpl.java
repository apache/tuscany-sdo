/**
 *
 * Copyright 2005 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.example.sequences.impl;

import com.example.sequences.RepeatingChoice;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import commonj.sdo.helper.TypeHelper;

import java.util.Collection;
import java.util.List;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import org.apache.tuscany.sdo.util.BasicSequence;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repeating Choice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.example.sequences.impl.RepeatingChoiceImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link com.example.sequences.impl.RepeatingChoiceImpl#getA <em>A</em>}</li>
 *   <li>{@link com.example.sequences.impl.RepeatingChoiceImpl#getB <em>B</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RepeatingChoiceImpl extends DataObjectBase implements RepeatingChoice
{
  /**
   * The feature id for the '<em><b>Group</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int GROUP = 0;

  /**
   * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroup()
   * @generated
   * @ordered
   */
  
  // How to get BasicSequence from Sequence?
  
  protected BasicSequence group = null;
  
  /**
   * The feature id for the '<em><b>A</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int A = 1;

  /**
   * The feature id for the '<em><b>B</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int B = 2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RepeatingChoiceImpl()
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
    return TypeHelper.INSTANCE.getType(RepeatingChoice.class); //TBD Generate a more efficient implementation
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
        		group = createSequence(GROUP);
        	
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
      case GROUP:
        		// KDK - should this be !isSequenceEmpty?
        return group != null && !isSequenceEmpty(getGroup());
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
    if (isProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (group: ");
    result.append(group);
    result.append(')');
    return result.toString();
  }

} //RepeatingChoiceImpl
