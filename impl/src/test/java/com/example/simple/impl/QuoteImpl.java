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
package com.example.simple.impl;

import com.example.simple.Quote;
import com.example.simple.SimpleFactory;

import commonj.sdo.Type;

import java.math.BigDecimal;

import java.util.Collection;
import java.util.List;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Quote</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.example.simple.impl.QuoteImpl#getSymbol <em>Symbol</em>}</li>
 *   <li>{@link com.example.simple.impl.QuoteImpl#getCompanyName <em>Company Name</em>}</li>
 *   <li>{@link com.example.simple.impl.QuoteImpl#getPrice <em>Price</em>}</li>
 *   <li>{@link com.example.simple.impl.QuoteImpl#getOpen1 <em>Open1</em>}</li>
 *   <li>{@link com.example.simple.impl.QuoteImpl#getHigh <em>High</em>}</li>
 *   <li>{@link com.example.simple.impl.QuoteImpl#getLow <em>Low</em>}</li>
 *   <li>{@link com.example.simple.impl.QuoteImpl#getVolume <em>Volume</em>}</li>
 *   <li>{@link com.example.simple.impl.QuoteImpl#getChange1 <em>Change1</em>}</li>
 *   <li>{@link com.example.simple.impl.QuoteImpl#getQuotes <em>Quotes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QuoteImpl extends DataObjectBase implements Quote
{

  public final static int SYMBOL = 0;

  public final static int COMPANY_NAME = 1;

  public final static int PRICE = 2;

  public final static int OPEN1 = 3;

  public final static int HIGH = 4;

  public final static int LOW = 5;

  public final static int VOLUME = 6;

  public final static int CHANGE1 = 7;

  public final static int QUOTES = 8;

  public final static int SDO_PROPERTY_COUNT = 9;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Symbol</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_SYMBOL = 0;

  /**
   * The internal feature id for the '<em><b>Company Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_COMPANY_NAME = 1;

  /**
   * The internal feature id for the '<em><b>Price</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PRICE = 2;

  /**
   * The internal feature id for the '<em><b>Open1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_OPEN1 = 3;

  /**
   * The internal feature id for the '<em><b>High</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_HIGH = 4;

  /**
   * The internal feature id for the '<em><b>Low</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_LOW = 5;

  /**
   * The internal feature id for the '<em><b>Volume</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_VOLUME = 6;

  /**
   * The internal feature id for the '<em><b>Change1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_CHANGE1 = 7;

  /**
   * The internal feature id for the '<em><b>Quotes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_QUOTES = 8;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 9;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_SYMBOL: return SYMBOL;
      case INTERNAL_COMPANY_NAME: return COMPANY_NAME;
      case INTERNAL_PRICE: return PRICE;
      case INTERNAL_OPEN1: return OPEN1;
      case INTERNAL_HIGH: return HIGH;
      case INTERNAL_LOW: return LOW;
      case INTERNAL_VOLUME: return VOLUME;
      case INTERNAL_CHANGE1: return CHANGE1;
      case INTERNAL_QUOTES: return QUOTES;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The default value of the '{@link #getSymbol() <em>Symbol</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSymbol()
   * @generated
   * @ordered
   */
  protected static final String SYMBOL_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getSymbol() <em>Symbol</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSymbol()
   * @generated
   * @ordered
   */
  protected String symbol = SYMBOL_DEFAULT_;

  /**
   * This is true if the Symbol attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean symbol_set_ = false;

  /**
   * The default value of the '{@link #getCompanyName() <em>Company Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCompanyName()
   * @generated
   * @ordered
   */
  protected static final String COMPANY_NAME_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getCompanyName() <em>Company Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCompanyName()
   * @generated
   * @ordered
   */
  protected String companyName = COMPANY_NAME_DEFAULT_;

  /**
   * This is true if the Company Name attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean companyName_set_ = false;

  /**
   * The default value of the '{@link #getPrice() <em>Price</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrice()
   * @generated
   * @ordered
   */
  protected static final BigDecimal PRICE_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getPrice() <em>Price</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrice()
   * @generated
   * @ordered
   */
  protected BigDecimal price = PRICE_DEFAULT_;

  /**
   * This is true if the Price attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean price_set_ = false;

  /**
   * The default value of the '{@link #getOpen1() <em>Open1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpen1()
   * @generated
   * @ordered
   */
  protected static final BigDecimal OPEN1_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getOpen1() <em>Open1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpen1()
   * @generated
   * @ordered
   */
  protected BigDecimal open1 = OPEN1_DEFAULT_;

  /**
   * This is true if the Open1 attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean open1_set_ = false;

  /**
   * The default value of the '{@link #getHigh() <em>High</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHigh()
   * @generated
   * @ordered
   */
  protected static final BigDecimal HIGH_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getHigh() <em>High</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHigh()
   * @generated
   * @ordered
   */
  protected BigDecimal high = HIGH_DEFAULT_;

  /**
   * This is true if the High attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean high_set_ = false;

  /**
   * The default value of the '{@link #getLow() <em>Low</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLow()
   * @generated
   * @ordered
   */
  protected static final BigDecimal LOW_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getLow() <em>Low</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLow()
   * @generated
   * @ordered
   */
  protected BigDecimal low = LOW_DEFAULT_;

  /**
   * This is true if the Low attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean low_set_ = false;

  /**
   * The default value of the '{@link #getVolume() <em>Volume</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVolume()
   * @generated
   * @ordered
   */
  protected static final double VOLUME_DEFAULT_ = 0.0;

  /**
   * The cached value of the '{@link #getVolume() <em>Volume</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVolume()
   * @generated
   * @ordered
   */
  protected double volume = VOLUME_DEFAULT_;

  /**
   * This is true if the Volume attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean volume_set_ = false;

  /**
   * The default value of the '{@link #getChange1() <em>Change1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChange1()
   * @generated
   * @ordered
   */
  protected static final double CHANGE1_DEFAULT_ = 0.0;

  /**
   * The cached value of the '{@link #getChange1() <em>Change1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChange1()
   * @generated
   * @ordered
   */
  protected double change1 = CHANGE1_DEFAULT_;

  /**
   * This is true if the Change1 attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean change1_set_ = false;

  /**
   * The cached value of the '{@link #getQuotes() <em>Quotes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQuotes()
   * @generated
   * @ordered
   */
  
  protected List quotes = null;
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QuoteImpl()
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
    return ((SimpleFactoryImpl)SimpleFactory.INSTANCE).getQuote();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSymbol()
  {
    return symbol;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSymbol(String newSymbol)
  {
    String oldSymbol = symbol;
    symbol = newSymbol;
    boolean oldSymbol_set_ = symbol_set_;
    symbol_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, SYMBOL, oldSymbol, symbol, !oldSymbol_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetSymbol()
  {
    String oldSymbol = symbol;
    boolean oldSymbol_set_ = symbol_set_;
    symbol = SYMBOL_DEFAULT_;
    symbol_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, SYMBOL, oldSymbol, SYMBOL_DEFAULT_, oldSymbol_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetSymbol()
  {
    return symbol_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCompanyName()
  {
    return companyName;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCompanyName(String newCompanyName)
  {
    String oldCompanyName = companyName;
    companyName = newCompanyName;
    boolean oldCompanyName_set_ = companyName_set_;
    companyName_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, COMPANY_NAME, oldCompanyName, companyName, !oldCompanyName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetCompanyName()
  {
    String oldCompanyName = companyName;
    boolean oldCompanyName_set_ = companyName_set_;
    companyName = COMPANY_NAME_DEFAULT_;
    companyName_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, COMPANY_NAME, oldCompanyName, COMPANY_NAME_DEFAULT_, oldCompanyName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetCompanyName()
  {
    return companyName_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigDecimal getPrice()
  {
    return price;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrice(BigDecimal newPrice)
  {
    BigDecimal oldPrice = price;
    price = newPrice;
    boolean oldPrice_set_ = price_set_;
    price_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, PRICE, oldPrice, price, !oldPrice_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetPrice()
  {
    BigDecimal oldPrice = price;
    boolean oldPrice_set_ = price_set_;
    price = PRICE_DEFAULT_;
    price_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, PRICE, oldPrice, PRICE_DEFAULT_, oldPrice_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetPrice()
  {
    return price_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigDecimal getOpen1()
  {
    return open1;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOpen1(BigDecimal newOpen1)
  {
    BigDecimal oldOpen1 = open1;
    open1 = newOpen1;
    boolean oldOpen1_set_ = open1_set_;
    open1_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, OPEN1, oldOpen1, open1, !oldOpen1_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetOpen1()
  {
    BigDecimal oldOpen1 = open1;
    boolean oldOpen1_set_ = open1_set_;
    open1 = OPEN1_DEFAULT_;
    open1_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, OPEN1, oldOpen1, OPEN1_DEFAULT_, oldOpen1_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetOpen1()
  {
    return open1_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigDecimal getHigh()
  {
    return high;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHigh(BigDecimal newHigh)
  {
    BigDecimal oldHigh = high;
    high = newHigh;
    boolean oldHigh_set_ = high_set_;
    high_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, HIGH, oldHigh, high, !oldHigh_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetHigh()
  {
    BigDecimal oldHigh = high;
    boolean oldHigh_set_ = high_set_;
    high = HIGH_DEFAULT_;
    high_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, HIGH, oldHigh, HIGH_DEFAULT_, oldHigh_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetHigh()
  {
    return high_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigDecimal getLow()
  {
    return low;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLow(BigDecimal newLow)
  {
    BigDecimal oldLow = low;
    low = newLow;
    boolean oldLow_set_ = low_set_;
    low_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, LOW, oldLow, low, !oldLow_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetLow()
  {
    BigDecimal oldLow = low;
    boolean oldLow_set_ = low_set_;
    low = LOW_DEFAULT_;
    low_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, LOW, oldLow, LOW_DEFAULT_, oldLow_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetLow()
  {
    return low_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public double getVolume()
  {
    return volume;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVolume(double newVolume)
  {
    double oldVolume = volume;
    volume = newVolume;
    boolean oldVolume_set_ = volume_set_;
    volume_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, VOLUME, oldVolume, volume, !oldVolume_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetVolume()
  {
    double oldVolume = volume;
    boolean oldVolume_set_ = volume_set_;
    volume = VOLUME_DEFAULT_;
    volume_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, VOLUME, oldVolume, VOLUME_DEFAULT_, oldVolume_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetVolume()
  {
    return volume_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public double getChange1()
  {
    return change1;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChange1(double newChange1)
  {
    double oldChange1 = change1;
    change1 = newChange1;
    boolean oldChange1_set_ = change1_set_;
    change1_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, CHANGE1, oldChange1, change1, !oldChange1_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetChange1()
  {
    double oldChange1 = change1;
    boolean oldChange1_set_ = change1_set_;
    change1 = CHANGE1_DEFAULT_;
    change1_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, CHANGE1, oldChange1, CHANGE1_DEFAULT_, oldChange1_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetChange1()
  {
    return change1_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getQuotes()
  {
    if (quotes == null)
    {
      quotes = createPropertyList(ListKind.CONTAINMENT, Quote.class, QUOTES, 0);
    }
    return quotes;
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
      case QUOTES:
        return removeFromList(getQuotes(), otherEnd, changeContext);
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
      case SYMBOL:
        return getSymbol();
      case COMPANY_NAME:
        return getCompanyName();
      case PRICE:
        return getPrice();
      case OPEN1:
        return getOpen1();
      case HIGH:
        return getHigh();
      case LOW:
        return getLow();
      case VOLUME:
        return new Double(getVolume());
      case CHANGE1:
        return new Double(getChange1());
      case QUOTES:
        return getQuotes();
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
      case SYMBOL:
        setSymbol((String)newValue);
        return;
      case COMPANY_NAME:
        setCompanyName((String)newValue);
        return;
      case PRICE:
        setPrice((BigDecimal)newValue);
        return;
      case OPEN1:
        setOpen1((BigDecimal)newValue);
        return;
      case HIGH:
        setHigh((BigDecimal)newValue);
        return;
      case LOW:
        setLow((BigDecimal)newValue);
        return;
      case VOLUME:
        setVolume(((Double)newValue).doubleValue());
        return;
      case CHANGE1:
        setChange1(((Double)newValue).doubleValue());
        return;
      case QUOTES:
        getQuotes().clear();
        getQuotes().addAll((Collection)newValue);
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
      case SYMBOL:
        unsetSymbol();
        return;
      case COMPANY_NAME:
        unsetCompanyName();
        return;
      case PRICE:
        unsetPrice();
        return;
      case OPEN1:
        unsetOpen1();
        return;
      case HIGH:
        unsetHigh();
        return;
      case LOW:
        unsetLow();
        return;
      case VOLUME:
        unsetVolume();
        return;
      case CHANGE1:
        unsetChange1();
        return;
      case QUOTES:
        getQuotes().clear();
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
      case SYMBOL:
        return isSetSymbol();
      case COMPANY_NAME:
        return isSetCompanyName();
      case PRICE:
        return isSetPrice();
      case OPEN1:
        return isSetOpen1();
      case HIGH:
        return isSetHigh();
      case LOW:
        return isSetLow();
      case VOLUME:
        return isSetVolume();
      case CHANGE1:
        return isSetChange1();
      case QUOTES:
        return quotes != null && !quotes.isEmpty();
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
    result.append(" (symbol: ");
    if (symbol_set_) result.append(symbol); else result.append("<unset>");
    result.append(", companyName: ");
    if (companyName_set_) result.append(companyName); else result.append("<unset>");
    result.append(", price: ");
    if (price_set_) result.append(price); else result.append("<unset>");
    result.append(", open1: ");
    if (open1_set_) result.append(open1); else result.append("<unset>");
    result.append(", high: ");
    if (high_set_) result.append(high); else result.append("<unset>");
    result.append(", low: ");
    if (low_set_) result.append(low); else result.append("<unset>");
    result.append(", volume: ");
    if (volume_set_) result.append(volume); else result.append("<unset>");
    result.append(", change1: ");
    if (change1_set_) result.append(change1); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //QuoteImpl
