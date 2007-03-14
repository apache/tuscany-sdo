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
package com.example.sequences;

import commonj.sdo.Sequence;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mixed Quote</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.example.sequences.MixedQuote#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.example.sequences.MixedQuote#getSymbol <em>Symbol</em>}</li>
 *   <li>{@link com.example.sequences.MixedQuote#getCompanyName <em>Company Name</em>}</li>
 *   <li>{@link com.example.sequences.MixedQuote#getPrice <em>Price</em>}</li>
 *   <li>{@link com.example.sequences.MixedQuote#getOpen1 <em>Open1</em>}</li>
 *   <li>{@link com.example.sequences.MixedQuote#getHigh <em>High</em>}</li>
 *   <li>{@link com.example.sequences.MixedQuote#getLow <em>Low</em>}</li>
 *   <li>{@link com.example.sequences.MixedQuote#getVolume <em>Volume</em>}</li>
 *   <li>{@link com.example.sequences.MixedQuote#getChange1 <em>Change1</em>}</li>
 *   <li>{@link com.example.sequences.MixedQuote#getQuotes <em>Quotes</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface MixedQuote extends Serializable
{
  /**
   * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mixed</em>' attribute list.
   * @generated
   */
  Sequence getMixed();

  /**
   * Returns the value of the '<em><b>Symbol</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Symbol</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Symbol</em>' attribute.
   * @see #isSetSymbol()
   * @see #unsetSymbol()
   * @see #setSymbol(String)
   * @generated
   */
  String getSymbol();

  /**
   * Sets the value of the '{@link com.example.sequences.MixedQuote#getSymbol <em>Symbol</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Symbol</em>' attribute.
   * @see #isSetSymbol()
   * @see #unsetSymbol()
   * @see #getSymbol()
   * @generated
   */
  void setSymbol(String value);

  /**
   * Unsets the value of the '{@link com.example.sequences.MixedQuote#getSymbol <em>Symbol</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetSymbol()
   * @see #getSymbol()
   * @see #setSymbol(String)
   * @generated
   */
  void unsetSymbol();

  /**
   * Returns whether the value of the '{@link com.example.sequences.MixedQuote#getSymbol <em>Symbol</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Symbol</em>' attribute is set.
   * @see #unsetSymbol()
   * @see #getSymbol()
   * @see #setSymbol(String)
   * @generated
   */
  boolean isSetSymbol();

  /**
   * Returns the value of the '<em><b>Company Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Company Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Company Name</em>' attribute.
   * @see #isSetCompanyName()
   * @see #unsetCompanyName()
   * @see #setCompanyName(String)
   * @generated
   */
  String getCompanyName();

  /**
   * Sets the value of the '{@link com.example.sequences.MixedQuote#getCompanyName <em>Company Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Company Name</em>' attribute.
   * @see #isSetCompanyName()
   * @see #unsetCompanyName()
   * @see #getCompanyName()
   * @generated
   */
  void setCompanyName(String value);

  /**
   * Unsets the value of the '{@link com.example.sequences.MixedQuote#getCompanyName <em>Company Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetCompanyName()
   * @see #getCompanyName()
   * @see #setCompanyName(String)
   * @generated
   */
  void unsetCompanyName();

  /**
   * Returns whether the value of the '{@link com.example.sequences.MixedQuote#getCompanyName <em>Company Name</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Company Name</em>' attribute is set.
   * @see #unsetCompanyName()
   * @see #getCompanyName()
   * @see #setCompanyName(String)
   * @generated
   */
  boolean isSetCompanyName();

  /**
   * Returns the value of the '<em><b>Price</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Price</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Price</em>' attribute.
   * @see #isSetPrice()
   * @see #unsetPrice()
   * @see #setPrice(BigDecimal)
   * @generated
   */
  BigDecimal getPrice();

  /**
   * Sets the value of the '{@link com.example.sequences.MixedQuote#getPrice <em>Price</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Price</em>' attribute.
   * @see #isSetPrice()
   * @see #unsetPrice()
   * @see #getPrice()
   * @generated
   */
  void setPrice(BigDecimal value);

  /**
   * Unsets the value of the '{@link com.example.sequences.MixedQuote#getPrice <em>Price</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetPrice()
   * @see #getPrice()
   * @see #setPrice(BigDecimal)
   * @generated
   */
  void unsetPrice();

  /**
   * Returns whether the value of the '{@link com.example.sequences.MixedQuote#getPrice <em>Price</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Price</em>' attribute is set.
   * @see #unsetPrice()
   * @see #getPrice()
   * @see #setPrice(BigDecimal)
   * @generated
   */
  boolean isSetPrice();

  /**
   * Returns the value of the '<em><b>Open1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Open1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Open1</em>' attribute.
   * @see #isSetOpen1()
   * @see #unsetOpen1()
   * @see #setOpen1(BigDecimal)
   * @generated
   */
  BigDecimal getOpen1();

  /**
   * Sets the value of the '{@link com.example.sequences.MixedQuote#getOpen1 <em>Open1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Open1</em>' attribute.
   * @see #isSetOpen1()
   * @see #unsetOpen1()
   * @see #getOpen1()
   * @generated
   */
  void setOpen1(BigDecimal value);

  /**
   * Unsets the value of the '{@link com.example.sequences.MixedQuote#getOpen1 <em>Open1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetOpen1()
   * @see #getOpen1()
   * @see #setOpen1(BigDecimal)
   * @generated
   */
  void unsetOpen1();

  /**
   * Returns whether the value of the '{@link com.example.sequences.MixedQuote#getOpen1 <em>Open1</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Open1</em>' attribute is set.
   * @see #unsetOpen1()
   * @see #getOpen1()
   * @see #setOpen1(BigDecimal)
   * @generated
   */
  boolean isSetOpen1();

  /**
   * Returns the value of the '<em><b>High</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>High</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>High</em>' attribute.
   * @see #isSetHigh()
   * @see #unsetHigh()
   * @see #setHigh(BigDecimal)
   * @generated
   */
  BigDecimal getHigh();

  /**
   * Sets the value of the '{@link com.example.sequences.MixedQuote#getHigh <em>High</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>High</em>' attribute.
   * @see #isSetHigh()
   * @see #unsetHigh()
   * @see #getHigh()
   * @generated
   */
  void setHigh(BigDecimal value);

  /**
   * Unsets the value of the '{@link com.example.sequences.MixedQuote#getHigh <em>High</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetHigh()
   * @see #getHigh()
   * @see #setHigh(BigDecimal)
   * @generated
   */
  void unsetHigh();

  /**
   * Returns whether the value of the '{@link com.example.sequences.MixedQuote#getHigh <em>High</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>High</em>' attribute is set.
   * @see #unsetHigh()
   * @see #getHigh()
   * @see #setHigh(BigDecimal)
   * @generated
   */
  boolean isSetHigh();

  /**
   * Returns the value of the '<em><b>Low</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Low</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Low</em>' attribute.
   * @see #isSetLow()
   * @see #unsetLow()
   * @see #setLow(BigDecimal)
   * @generated
   */
  BigDecimal getLow();

  /**
   * Sets the value of the '{@link com.example.sequences.MixedQuote#getLow <em>Low</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Low</em>' attribute.
   * @see #isSetLow()
   * @see #unsetLow()
   * @see #getLow()
   * @generated
   */
  void setLow(BigDecimal value);

  /**
   * Unsets the value of the '{@link com.example.sequences.MixedQuote#getLow <em>Low</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetLow()
   * @see #getLow()
   * @see #setLow(BigDecimal)
   * @generated
   */
  void unsetLow();

  /**
   * Returns whether the value of the '{@link com.example.sequences.MixedQuote#getLow <em>Low</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Low</em>' attribute is set.
   * @see #unsetLow()
   * @see #getLow()
   * @see #setLow(BigDecimal)
   * @generated
   */
  boolean isSetLow();

  /**
   * Returns the value of the '<em><b>Volume</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Volume</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Volume</em>' attribute.
   * @see #isSetVolume()
   * @see #unsetVolume()
   * @see #setVolume(double)
   * @generated
   */
  double getVolume();

  /**
   * Sets the value of the '{@link com.example.sequences.MixedQuote#getVolume <em>Volume</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Volume</em>' attribute.
   * @see #isSetVolume()
   * @see #unsetVolume()
   * @see #getVolume()
   * @generated
   */
  void setVolume(double value);

  /**
   * Unsets the value of the '{@link com.example.sequences.MixedQuote#getVolume <em>Volume</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetVolume()
   * @see #getVolume()
   * @see #setVolume(double)
   * @generated
   */
  void unsetVolume();

  /**
   * Returns whether the value of the '{@link com.example.sequences.MixedQuote#getVolume <em>Volume</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Volume</em>' attribute is set.
   * @see #unsetVolume()
   * @see #getVolume()
   * @see #setVolume(double)
   * @generated
   */
  boolean isSetVolume();

  /**
   * Returns the value of the '<em><b>Change1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Change1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Change1</em>' attribute.
   * @see #isSetChange1()
   * @see #unsetChange1()
   * @see #setChange1(double)
   * @generated
   */
  double getChange1();

  /**
   * Sets the value of the '{@link com.example.sequences.MixedQuote#getChange1 <em>Change1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Change1</em>' attribute.
   * @see #isSetChange1()
   * @see #unsetChange1()
   * @see #getChange1()
   * @generated
   */
  void setChange1(double value);

  /**
   * Unsets the value of the '{@link com.example.sequences.MixedQuote#getChange1 <em>Change1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetChange1()
   * @see #getChange1()
   * @see #setChange1(double)
   * @generated
   */
  void unsetChange1();

  /**
   * Returns whether the value of the '{@link com.example.sequences.MixedQuote#getChange1 <em>Change1</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Change1</em>' attribute is set.
   * @see #unsetChange1()
   * @see #getChange1()
   * @see #setChange1(double)
   * @generated
   */
  boolean isSetChange1();

  /**
   * Returns the value of the '<em><b>Quotes</b></em>' containment reference list.
   * The list contents are of type {@link com.example.sequences.MixedQuote}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Quotes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Quotes</em>' containment reference list.
   * @generated
   */
  List getQuotes();

} // MixedQuote
