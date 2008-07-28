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
package com.example.ExpectedException.impl;

import com.example.ExpectedException.ExpectedExceptionFactory;
import com.example.ExpectedException.SequenceReadOnlyType;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Read Only Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.example.ExpectedException.impl.SequenceReadOnlyTypeImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.example.ExpectedException.impl.SequenceReadOnlyTypeImpl#getReadOnlyVal <em>Read Only Val</em>}</li>
 *   <li>{@link com.example.ExpectedException.impl.SequenceReadOnlyTypeImpl#getReadOnlyListVal <em>Read Only List Val</em>}</li>
 *   <li>{@link com.example.ExpectedException.impl.SequenceReadOnlyTypeImpl#getUniqueName <em>Unique Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceReadOnlyTypeImpl extends DataObjectBase implements SequenceReadOnlyType
{

  public final static int MIXED = -1;

  public final static int READ_ONLY_VAL = 0;

  public final static int READ_ONLY_LIST_VAL = 1;

  public final static int UNIQUE_NAME = 2;

  public final static int SDO_PROPERTY_COUNT = 3;

  public final static int EXTENDED_PROPERTY_COUNT = -1;


  /**
   * The internal feature id for the '<em><b>Mixed</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_MIXED = 0;

  /**
   * The internal feature id for the '<em><b>Read Only Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_READ_ONLY_VAL = 1;

  /**
   * The internal feature id for the '<em><b>Read Only List Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_READ_ONLY_LIST_VAL = 2;

  /**
   * The internal feature id for the '<em><b>Unique Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_UNIQUE_NAME = 3;

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
      case INTERNAL_READ_ONLY_VAL: return READ_ONLY_VAL;
      case INTERNAL_READ_ONLY_LIST_VAL: return READ_ONLY_LIST_VAL;
      case INTERNAL_UNIQUE_NAME: return UNIQUE_NAME;
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
  public SequenceReadOnlyTypeImpl()
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
    return ((ExpectedExceptionFactoryImpl)ExpectedExceptionFactory.INSTANCE).getSequenceReadOnlyType();
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
  public String getReadOnlyVal()
  {
    return (String)get(getMixed(), getType(), INTERNAL_READ_ONLY_VAL);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetReadOnlyVal()
  {
        return isSet(getMixed(), getType(), INTERNAL_READ_ONLY_VAL);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getReadOnlyListVal()
  {
    return (String)get(getMixed(), getType(), INTERNAL_READ_ONLY_LIST_VAL);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetReadOnlyListVal()
  {
        return isSet(getMixed(), getType(), INTERNAL_READ_ONLY_LIST_VAL);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUniqueName()
  {
    return (String)get(getMixed(), getType(), INTERNAL_UNIQUE_NAME);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUniqueName(String newUniqueName)
  {
    set(getMixed(), getType(), INTERNAL_UNIQUE_NAME, newUniqueName);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetUniqueName()
  {
        unset(getMixed(), getType(), INTERNAL_UNIQUE_NAME);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetUniqueName()
  {
        return isSet(getMixed(), getType(), INTERNAL_UNIQUE_NAME);
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
      case READ_ONLY_VAL:
        return getReadOnlyVal();
      case READ_ONLY_LIST_VAL:
        return getReadOnlyListVal();
      case UNIQUE_NAME:
        return getUniqueName();
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
      case UNIQUE_NAME:
        setUniqueName((String)newValue);
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
      case UNIQUE_NAME:
        unsetUniqueName();
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
      case READ_ONLY_VAL:
        return isSetReadOnlyVal();
      case READ_ONLY_LIST_VAL:
        return isSetReadOnlyListVal();
      case UNIQUE_NAME:
        return isSetUniqueName();
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

} //SequenceReadOnlyTypeImpl
