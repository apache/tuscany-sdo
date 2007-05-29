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
import com.example.customer.Customer;
import com.example.customer.CustomerFactory;

import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Customer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.example.customer.impl.CustomerImpl#getAccount <em>Account</em>}</li>
 *   <li>{@link com.example.customer.impl.CustomerImpl#getFirstName <em>First Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CustomerImpl extends DataObjectBase implements Customer
{

  public final static int ACCOUNT = 0;

  public final static int FIRST_NAME = 1;

  public final static int SDO_PROPERTY_COUNT = 2;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Account</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ACCOUNT = 0;

  /**
   * The internal feature id for the '<em><b>First Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_FIRST_NAME = 1;

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
      case INTERNAL_ACCOUNT: return ACCOUNT;
      case INTERNAL_FIRST_NAME: return FIRST_NAME;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getAccount() <em>Account</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAccount()
   * @generated
   * @ordered
   */
  
  protected Account account = null;
  
  /**
   * This is true if the Account containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean account_set_ = false;

  /**
   * The default value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirstName()
   * @generated
   * @ordered
   */
  protected static final String FIRST_NAME_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirstName()
   * @generated
   * @ordered
   */
  protected String firstName = FIRST_NAME_DEFAULT_;

  /**
   * This is true if the First Name attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean firstName_set_ = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CustomerImpl()
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
    return ((CustomerFactoryImpl)CustomerFactory.INSTANCE).getCustomer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Account getAccount()
  {
    return account;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetAccount(Account newAccount, ChangeContext changeContext)
  {
    Account oldAccount = account;
    account = newAccount;
    boolean oldAccount_set_ = account_set_;
    account_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, ACCOUNT, oldAccount, newAccount, !oldAccount_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAccount(Account newAccount)
  {
    if (newAccount != account)
    {
      ChangeContext changeContext = null;
      if (account != null)
        changeContext = inverseRemove(account, this, OPPOSITE_FEATURE_BASE - ACCOUNT, null, changeContext);
      if (newAccount != null)
        changeContext = inverseAdd(newAccount, this, OPPOSITE_FEATURE_BASE - ACCOUNT, null, changeContext);
      changeContext = basicSetAccount(newAccount, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldAccount_set_ = account_set_;
      account_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, ACCOUNT, newAccount, newAccount, !oldAccount_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetAccount(ChangeContext changeContext)
  {
    Account oldAccount = account;
    account = null;
    boolean oldAccount_set_ = account_set_;
    account_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, ACCOUNT, oldAccount, null, !oldAccount_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetAccount()
  {
    if (account != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(account, this, EOPPOSITE_FEATURE_BASE - ACCOUNT, null, changeContext);
      changeContext = basicUnsetAccount(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldAccount_set_ = account_set_;
      account_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, ACCOUNT, null, null, oldAccount_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetAccount()
  {
    return account_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFirstName()
  {
    return firstName;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFirstName(String newFirstName)
  {
    String oldFirstName = firstName;
    firstName = newFirstName;
    boolean oldFirstName_set_ = firstName_set_;
    firstName_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, FIRST_NAME, oldFirstName, firstName, !oldFirstName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetFirstName()
  {
    String oldFirstName = firstName;
    boolean oldFirstName_set_ = firstName_set_;
    firstName = FIRST_NAME_DEFAULT_;
    firstName_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, FIRST_NAME, oldFirstName, FIRST_NAME_DEFAULT_, oldFirstName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetFirstName()
  {
    return firstName_set_;
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
      case ACCOUNT:
        return basicUnsetAccount(changeContext);
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
      case ACCOUNT:
        return getAccount();
      case FIRST_NAME:
        return getFirstName();
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
      case ACCOUNT:
        setAccount((Account)newValue);
        return;
      case FIRST_NAME:
        setFirstName((String)newValue);
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
      case ACCOUNT:
        unsetAccount();
        return;
      case FIRST_NAME:
        unsetFirstName();
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
      case ACCOUNT:
        return isSetAccount();
      case FIRST_NAME:
        return isSetFirstName();
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
    result.append(" (firstName: ");
    if (firstName_set_) result.append(firstName); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //CustomerImpl
