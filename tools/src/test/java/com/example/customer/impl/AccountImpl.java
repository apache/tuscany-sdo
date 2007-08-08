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
package com.example.customer.impl;

import com.example.customer.Account;
import com.example.customer.CustomerFactory;

import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Account</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.example.customer.impl.AccountImpl#getAccountNum <em>Account Num</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AccountImpl extends DataObjectBase implements Account
{

  public final static int ACCOUNT_NUM = 0;

  public final static int SDO_PROPERTY_COUNT = 1;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Account Num</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ACCOUNT_NUM = 0;

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
      case INTERNAL_ACCOUNT_NUM: return ACCOUNT_NUM;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The default value of the '{@link #getAccountNum() <em>Account Num</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAccountNum()
   * @generated
   * @ordered
   */
  protected static final int ACCOUNT_NUM_DEFAULT_ = 0;

  /**
   * The cached value of the '{@link #getAccountNum() <em>Account Num</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAccountNum()
   * @generated
   * @ordered
   */
  protected int accountNum = ACCOUNT_NUM_DEFAULT_;

  /**
   * This is true if the Account Num attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean accountNum_set_ = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AccountImpl()
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
    return ((CustomerFactoryImpl)CustomerFactory.INSTANCE).getAccount();
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
  public int getAccountNum()
  {
    return accountNum;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAccountNum(int newAccountNum)
  {
    int oldAccountNum = accountNum;
    accountNum = newAccountNum;
    boolean oldAccountNum_set_ = accountNum_set_;
    accountNum_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_ACCOUNT_NUM, oldAccountNum, accountNum, !oldAccountNum_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetAccountNum()
  {
    int oldAccountNum = accountNum;
    boolean oldAccountNum_set_ = accountNum_set_;
    accountNum = ACCOUNT_NUM_DEFAULT_;
    accountNum_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_ACCOUNT_NUM, oldAccountNum, ACCOUNT_NUM_DEFAULT_, oldAccountNum_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetAccountNum()
  {
    return accountNum_set_;
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
      case ACCOUNT_NUM:
        return new Integer(getAccountNum());
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
      case ACCOUNT_NUM:
        setAccountNum(((Integer)newValue).intValue());
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
      case ACCOUNT_NUM:
        unsetAccountNum();
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
      case ACCOUNT_NUM:
        return isSetAccountNum();
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
    result.append(" (accountNum: ");
    if (accountNum_set_) result.append(accountNum); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //AccountImpl
