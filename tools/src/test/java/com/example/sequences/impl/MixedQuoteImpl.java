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

import com.example.sequences.MixedQuote;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import commonj.sdo.helper.TypeHelper;

import java.math.BigDecimal;

import java.util.Collection;
import java.util.List;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import org.apache.tuscany.sdo.util.BasicSequence;

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
  /**
   * The feature id for the '<em><b>Mixed</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int MIXED = 0;

  /**
   * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMixed()
   * @generated
   * @ordered
   */
  
  // How to get BasicSequence from Sequence?
  
  protected BasicSequence mixed = null;
  
  /**
   * The feature id for the '<em><b>Symbol</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int SYMBOL = 1;

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
   * The feature id for the '<em><b>Company Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int COMPANY_NAME = 2;

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
   * The feature id for the '<em><b>Price</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int PRICE = 3;

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
   * The feature id for the '<em><b>Open1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int OPEN1 = 4;

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
   * The feature id for the '<em><b>High</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int HIGH = 5;

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
   * The feature id for the '<em><b>Low</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int LOW = 6;

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
   * The feature id for the '<em><b>Volume</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int VOLUME = 7;

  /**
   * The feature id for the '<em><b>Change1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int CHANGE1 = 8;

  /**
   * The feature id for the '<em><b>Quotes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int QUOTES = 9;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MixedQuoteImpl()
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
    return TypeHelper.INSTANCE.getType(MixedQuote.class); //TBD Generate a more efficient implementation
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
  public String getSymbol()
  {
    return (String)get(getMixed(), getType(), SYMBOL);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSymbol(String newSymbol)
  {
        set(getMixed(), getType(), SYMBOL, newSymbol);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCompanyName()
  {
    return (String)get(getMixed(), getType(), COMPANY_NAME);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCompanyName(String newCompanyName)
  {
        set(getMixed(), getType(), COMPANY_NAME, newCompanyName);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigDecimal getPrice()
  {
    return (BigDecimal)get(getMixed(), getType(), PRICE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrice(BigDecimal newPrice)
  {
        set(getMixed(), getType(), PRICE, newPrice);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigDecimal getOpen1()
  {
    return (BigDecimal)get(getMixed(), getType(), OPEN1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOpen1(BigDecimal newOpen1)
  {
        set(getMixed(), getType(), OPEN1, newOpen1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigDecimal getHigh()
  {
    return (BigDecimal)get(getMixed(), getType(), HIGH);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHigh(BigDecimal newHigh)
  {
        set(getMixed(), getType(), HIGH, newHigh);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigDecimal getLow()
  {
    return (BigDecimal)get(getMixed(), getType(), LOW);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLow(BigDecimal newLow)
  {
        set(getMixed(), getType(), LOW, newLow);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public double getVolume()
  {
    return ((Double)get(getMixed(), getType(), VOLUME)).doubleValue();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVolume(double newVolume)
  {
        set(getMixed(), getType(), VOLUME,  new Double(newVolume));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetVolume()
  {
        unset(getMixed(), getType(), VOLUME);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetVolume()
  {
        return isSet(getMixed(), getType(), VOLUME);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public double getChange1()
  {
    return ((Double)get(getMixed(), getType(), CHANGE1)).doubleValue();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChange1(double newChange1)
  {
        set(getMixed(), getType(), CHANGE1,  new Double(newChange1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetChange1()
  {
        unset(getMixed(), getType(), CHANGE1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetChange1()
  {
        return isSet(getMixed(), getType(), CHANGE1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getQuotes()
  {
          return getList(getMixed(), getType(), QUOTES);

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
        setSymbol(SYMBOL_DEFAULT_);
        return;
      case COMPANY_NAME:
        setCompanyName(COMPANY_NAME_DEFAULT_);
        return;
      case PRICE:
        setPrice(PRICE_DEFAULT_);
        return;
      case OPEN1:
        setOpen1(OPEN1_DEFAULT_);
        return;
      case HIGH:
        setHigh(HIGH_DEFAULT_);
        return;
      case LOW:
        setLow(LOW_DEFAULT_);
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
        		// KDK - should this be !isSequenceEmpty?
        return mixed != null && !isSequenceEmpty(getMixed());
      case SYMBOL:
        return SYMBOL_DEFAULT_ == null ? getSymbol() != null : !SYMBOL_DEFAULT_.equals(getSymbol());
      case COMPANY_NAME:
        return COMPANY_NAME_DEFAULT_ == null ? getCompanyName() != null : !COMPANY_NAME_DEFAULT_.equals(getCompanyName());
      case PRICE:
        return PRICE_DEFAULT_ == null ? getPrice() != null : !PRICE_DEFAULT_.equals(getPrice());
      case OPEN1:
        return OPEN1_DEFAULT_ == null ? getOpen1() != null : !OPEN1_DEFAULT_.equals(getOpen1());
      case HIGH:
        return HIGH_DEFAULT_ == null ? getHigh() != null : !HIGH_DEFAULT_.equals(getHigh());
      case LOW:
        return LOW_DEFAULT_ == null ? getLow() != null : !LOW_DEFAULT_.equals(getLow());
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
    if (isProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (mixed: ");
    result.append(mixed);
    result.append(')');
    return result.toString();
  }

} //MixedQuoteImpl
