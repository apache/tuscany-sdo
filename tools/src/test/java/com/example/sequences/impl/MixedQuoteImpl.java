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

import com.example.sequences.MixedQuote;
import com.example.sequences.SequencesFactory;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import java.math.BigDecimal;

import java.util.Collection;
import java.util.List;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mixed Quote</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.example.sequences.impl.MixedQuoteImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.example.sequences.impl.MixedQuoteImpl#getSymbol <em>Symbol</em>}</li>
 *   <li>{@link com.example.sequences.impl.MixedQuoteImpl#getCompanyName <em>Company Name</em>}</li>
 *   <li>{@link com.example.sequences.impl.MixedQuoteImpl#getPrice <em>Price</em>}</li>
 *   <li>{@link com.example.sequences.impl.MixedQuoteImpl#getOpen1 <em>Open1</em>}</li>
 *   <li>{@link com.example.sequences.impl.MixedQuoteImpl#getHigh <em>High</em>}</li>
 *   <li>{@link com.example.sequences.impl.MixedQuoteImpl#getLow <em>Low</em>}</li>
 *   <li>{@link com.example.sequences.impl.MixedQuoteImpl#getVolume <em>Volume</em>}</li>
 *   <li>{@link com.example.sequences.impl.MixedQuoteImpl#getChange1 <em>Change1</em>}</li>
 *   <li>{@link com.example.sequences.impl.MixedQuoteImpl#getQuotes <em>Quotes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MixedQuoteImpl extends DataObjectBase implements MixedQuote
{

  public final static int MIXED = -1;

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
   * The internal feature id for the '<em><b>Symbol</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_SYMBOL = 1;

  /**
   * The internal feature id for the '<em><b>Company Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_COMPANY_NAME = 2;

  /**
   * The internal feature id for the '<em><b>Price</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PRICE = 3;

  /**
   * The internal feature id for the '<em><b>Open1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_OPEN1 = 4;

  /**
   * The internal feature id for the '<em><b>High</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_HIGH = 5;

  /**
   * The internal feature id for the '<em><b>Low</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_LOW = 6;

  /**
   * The internal feature id for the '<em><b>Volume</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_VOLUME = 7;

  /**
   * The internal feature id for the '<em><b>Change1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_CHANGE1 = 8;

  /**
   * The internal feature id for the '<em><b>Quotes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_QUOTES = 9;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 10;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_MIXED: return MIXED;
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
  public MixedQuoteImpl()
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
    return ((SequencesFactoryImpl)SequencesFactory.INSTANCE).getMixedQuote();
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
  public String getSymbol()
  {
    return (String)get(getMixed(), getType(), INTERNAL_SYMBOL);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSymbol(String newSymbol)
  {
    set(getMixed(), getType(), INTERNAL_SYMBOL, newSymbol);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetSymbol()
  {
        unset(getMixed(), getType(), INTERNAL_SYMBOL);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetSymbol()
  {
        return isSet(getMixed(), getType(), INTERNAL_SYMBOL);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCompanyName()
  {
    return (String)get(getMixed(), getType(), INTERNAL_COMPANY_NAME);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCompanyName(String newCompanyName)
  {
    set(getMixed(), getType(), INTERNAL_COMPANY_NAME, newCompanyName);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetCompanyName()
  {
        unset(getMixed(), getType(), INTERNAL_COMPANY_NAME);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetCompanyName()
  {
        return isSet(getMixed(), getType(), INTERNAL_COMPANY_NAME);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigDecimal getPrice()
  {
    return (BigDecimal)get(getMixed(), getType(), INTERNAL_PRICE);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrice(BigDecimal newPrice)
  {
    set(getMixed(), getType(), INTERNAL_PRICE, newPrice);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetPrice()
  {
        unset(getMixed(), getType(), INTERNAL_PRICE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetPrice()
  {
        return isSet(getMixed(), getType(), INTERNAL_PRICE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigDecimal getOpen1()
  {
    return (BigDecimal)get(getMixed(), getType(), INTERNAL_OPEN1);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOpen1(BigDecimal newOpen1)
  {
    set(getMixed(), getType(), INTERNAL_OPEN1, newOpen1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetOpen1()
  {
        unset(getMixed(), getType(), INTERNAL_OPEN1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetOpen1()
  {
        return isSet(getMixed(), getType(), INTERNAL_OPEN1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigDecimal getHigh()
  {
    return (BigDecimal)get(getMixed(), getType(), INTERNAL_HIGH);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHigh(BigDecimal newHigh)
  {
    set(getMixed(), getType(), INTERNAL_HIGH, newHigh);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetHigh()
  {
        unset(getMixed(), getType(), INTERNAL_HIGH);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetHigh()
  {
        return isSet(getMixed(), getType(), INTERNAL_HIGH);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigDecimal getLow()
  {
    return (BigDecimal)get(getMixed(), getType(), INTERNAL_LOW);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLow(BigDecimal newLow)
  {
    set(getMixed(), getType(), INTERNAL_LOW, newLow);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetLow()
  {
        unset(getMixed(), getType(), INTERNAL_LOW);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetLow()
  {
        return isSet(getMixed(), getType(), INTERNAL_LOW);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public double getVolume()
  {
    return ((Double)get(getMixed(), getType(), INTERNAL_VOLUME)).doubleValue();
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVolume(double newVolume)
  {
    set(getMixed(), getType(), INTERNAL_VOLUME,  new Double(newVolume));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetVolume()
  {
        unset(getMixed(), getType(), INTERNAL_VOLUME);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetVolume()
  {
        return isSet(getMixed(), getType(), INTERNAL_VOLUME);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public double getChange1()
  {
    return ((Double)get(getMixed(), getType(), INTERNAL_CHANGE1)).doubleValue();
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChange1(double newChange1)
  {
    set(getMixed(), getType(), INTERNAL_CHANGE1,  new Double(newChange1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetChange1()
  {
        unset(getMixed(), getType(), INTERNAL_CHANGE1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetChange1()
  {
        return isSet(getMixed(), getType(), INTERNAL_CHANGE1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getQuotes()
  {
    return getList(getMixed(), getType(), INTERNAL_QUOTES);
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
      case MIXED:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getMixed();
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
      case MIXED:
      	setSequence(getMixed(), newValue);
        return;
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
      case MIXED:
        unsetSequence(getMixed());
        return;
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
      case MIXED:
        return mixed != null && !isSequenceEmpty(getMixed());
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
        return !getQuotes().isEmpty();
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

} //MixedQuoteImpl
