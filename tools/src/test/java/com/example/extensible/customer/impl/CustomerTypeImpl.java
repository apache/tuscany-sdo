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
package com.example.extensible.customer.impl;

import com.example.extensible.customer.CustomerFactory;
import com.example.extensible.customer.CustomerType;
import com.example.extensible.customer.InfoType;

import commonj.sdo.Type;

import java.math.BigInteger;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.example.extensible.customer.impl.CustomerTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.example.extensible.customer.impl.CustomerTypeImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link com.example.extensible.customer.impl.CustomerTypeImpl#getInfo <em>Info</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CustomerTypeImpl extends DataObjectBase implements CustomerType
{

  public final static int NAME = 0;

  public final static int NUMBER = 1;

  public final static int INFO = 2;

  public final static int SDO_PROPERTY_COUNT = 3;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_NAME = 0;

  /**
   * The internal feature id for the '<em><b>Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_NUMBER = 1;

  /**
   * The internal feature id for the '<em><b>Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_INFO = 2;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 3;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_NAME: return NAME;
      case INTERNAL_NUMBER: return NUMBER;
      case INTERNAL_INFO: return INFO;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_DEFAULT_;

  /**
   * This is true if the Name attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean name_set_ = false;

  /**
   * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumber()
   * @generated
   * @ordered
   */
  protected static final BigInteger NUMBER_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumber()
   * @generated
   * @ordered
   */
  protected BigInteger number = NUMBER_DEFAULT_;

  /**
   * This is true if the Number attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean number_set_ = false;

  /**
   * The cached value of the '{@link #getInfo() <em>Info</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInfo()
   * @generated
   * @ordered
   */
  
  protected InfoType info = null;
  
  /**
   * This is true if the Info containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean info_set_ = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CustomerTypeImpl()
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
    return ((CustomerFactoryImpl)CustomerFactory.INSTANCE).getCustomerType();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    boolean oldName_set_ = name_set_;
    name_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_NAME, oldName, name, !oldName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetName()
  {
    String oldName = name;
    boolean oldName_set_ = name_set_;
    name = NAME_DEFAULT_;
    name_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_NAME, oldName, NAME_DEFAULT_, oldName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetName()
  {
    return name_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigInteger getNumber()
  {
    return number;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNumber(BigInteger newNumber)
  {
    BigInteger oldNumber = number;
    number = newNumber;
    boolean oldNumber_set_ = number_set_;
    number_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_NUMBER, oldNumber, number, !oldNumber_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetNumber()
  {
    BigInteger oldNumber = number;
    boolean oldNumber_set_ = number_set_;
    number = NUMBER_DEFAULT_;
    number_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_NUMBER, oldNumber, NUMBER_DEFAULT_, oldNumber_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetNumber()
  {
    return number_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InfoType getInfo()
  {
    return info;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetInfo(InfoType newInfo, ChangeContext changeContext)
  {
    InfoType oldInfo = info;
    info = newInfo;
    boolean oldInfo_set_ = info_set_;
    info_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_INFO, oldInfo, newInfo, !oldInfo_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInfo(InfoType newInfo)
  {
    if (newInfo != info)
    {
      ChangeContext changeContext = null;
      if (info != null)
        changeContext = inverseRemove(info, this, OPPOSITE_FEATURE_BASE - INTERNAL_INFO, null, changeContext);
      if (newInfo != null)
        changeContext = inverseAdd(newInfo, this, OPPOSITE_FEATURE_BASE - INTERNAL_INFO, null, changeContext);
      changeContext = basicSetInfo(newInfo, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldInfo_set_ = info_set_;
      info_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_INFO, newInfo, newInfo, !oldInfo_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetInfo(ChangeContext changeContext)
  {
    InfoType oldInfo = info;
    info = null;
    boolean oldInfo_set_ = info_set_;
    info_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_INFO, oldInfo, null, !oldInfo_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetInfo()
  {
    if (info != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(info, this, EOPPOSITE_FEATURE_BASE - INTERNAL_INFO, null, changeContext);
      changeContext = basicUnsetInfo(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldInfo_set_ = info_set_;
      info_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_INFO, null, null, oldInfo_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetInfo()
  {
    return info_set_;
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
      case INFO:
        return basicUnsetInfo(changeContext);
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
      case NAME:
        return getName();
      case NUMBER:
        return getNumber();
      case INFO:
        return getInfo();
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
      case NAME:
        setName((String)newValue);
        return;
      case NUMBER:
        setNumber((BigInteger)newValue);
        return;
      case INFO:
        setInfo((InfoType)newValue);
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
      case NAME:
        unsetName();
        return;
      case NUMBER:
        unsetNumber();
        return;
      case INFO:
        unsetInfo();
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
      case NAME:
        return isSetName();
      case NUMBER:
        return isSetNumber();
      case INFO:
        return isSetInfo();
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
    result.append(" (name: ");
    if (name_set_) result.append(name); else result.append("<unset>");
    result.append(", number: ");
    if (number_set_) result.append(number); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //CustomerTypeImpl
