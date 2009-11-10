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
import com.example.ExpectedException.ExpectedExceptionType;

import commonj.sdo.Type;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.util.Collection;
import java.util.List;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.example.ExpectedException.impl.ExpectedExceptionTypeImpl#getStringVal <em>String Val</em>}</li>
 *   <li>{@link com.example.ExpectedException.impl.ExpectedExceptionTypeImpl#isBooleanVal <em>Boolean Val</em>}</li>
 *   <li>{@link com.example.ExpectedException.impl.ExpectedExceptionTypeImpl#getByteVal <em>Byte Val</em>}</li>
 *   <li>{@link com.example.ExpectedException.impl.ExpectedExceptionTypeImpl#getDecimalVal <em>Decimal Val</em>}</li>
 *   <li>{@link com.example.ExpectedException.impl.ExpectedExceptionTypeImpl#getIntVal <em>Int Val</em>}</li>
 *   <li>{@link com.example.ExpectedException.impl.ExpectedExceptionTypeImpl#getFloatVal <em>Float Val</em>}</li>
 *   <li>{@link com.example.ExpectedException.impl.ExpectedExceptionTypeImpl#getDoubleVal <em>Double Val</em>}</li>
 *   <li>{@link com.example.ExpectedException.impl.ExpectedExceptionTypeImpl#getDateVal <em>Date Val</em>}</li>
 *   <li>{@link com.example.ExpectedException.impl.ExpectedExceptionTypeImpl#getShortVal <em>Short Val</em>}</li>
 *   <li>{@link com.example.ExpectedException.impl.ExpectedExceptionTypeImpl#getLongVal <em>Long Val</em>}</li>
 *   <li>{@link com.example.ExpectedException.impl.ExpectedExceptionTypeImpl#getListVal <em>List Val</em>}</li>
 *   <li>{@link com.example.ExpectedException.impl.ExpectedExceptionTypeImpl#getBytesVal <em>Bytes Val</em>}</li>
 *   <li>{@link com.example.ExpectedException.impl.ExpectedExceptionTypeImpl#getIntegerVal <em>Integer Val</em>}</li>
 *   <li>{@link com.example.ExpectedException.impl.ExpectedExceptionTypeImpl#getCharVal <em>Char Val</em>}</li>
 *   <li>{@link com.example.ExpectedException.impl.ExpectedExceptionTypeImpl#getReadOnlyVal <em>Read Only Val</em>}</li>
 *   <li>{@link com.example.ExpectedException.impl.ExpectedExceptionTypeImpl#getReadOnlyListVal <em>Read Only List Val</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpectedExceptionTypeImpl extends DataObjectBase implements ExpectedExceptionType
{

  public final static int STRING_VAL = 0;

  public final static int BOOLEAN_VAL = 1;

  public final static int BYTE_VAL = 2;

  public final static int DECIMAL_VAL = 3;

  public final static int INT_VAL = 4;

  public final static int FLOAT_VAL = 5;

  public final static int DOUBLE_VAL = 6;

  public final static int DATE_VAL = 7;

  public final static int SHORT_VAL = 8;

  public final static int LONG_VAL = 9;

  public final static int LIST_VAL = 10;

  public final static int BYTES_VAL = 11;

  public final static int INTEGER_VAL = 12;

  public final static int CHAR_VAL = 13;

  public final static int READ_ONLY_VAL = 14;

  public final static int READ_ONLY_LIST_VAL = 15;

  public final static int SDO_PROPERTY_COUNT = 16;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>String Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_STRING_VAL = 0;

  /**
   * The internal feature id for the '<em><b>Boolean Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_BOOLEAN_VAL = 1;

  /**
   * The internal feature id for the '<em><b>Byte Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_BYTE_VAL = 2;

  /**
   * The internal feature id for the '<em><b>Decimal Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DECIMAL_VAL = 3;

  /**
   * The internal feature id for the '<em><b>Int Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_INT_VAL = 4;

  /**
   * The internal feature id for the '<em><b>Float Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_FLOAT_VAL = 5;

  /**
   * The internal feature id for the '<em><b>Double Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DOUBLE_VAL = 6;

  /**
   * The internal feature id for the '<em><b>Date Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DATE_VAL = 7;

  /**
   * The internal feature id for the '<em><b>Short Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_SHORT_VAL = 8;

  /**
   * The internal feature id for the '<em><b>Long Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_LONG_VAL = 9;

  /**
   * The internal feature id for the '<em><b>List Val</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_LIST_VAL = 10;

  /**
   * The internal feature id for the '<em><b>Bytes Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_BYTES_VAL = 11;

  /**
   * The internal feature id for the '<em><b>Integer Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_INTEGER_VAL = 12;

  /**
   * The internal feature id for the '<em><b>Char Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_CHAR_VAL = 13;

  /**
   * The internal feature id for the '<em><b>Read Only Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_READ_ONLY_VAL = 14;

  /**
   * The internal feature id for the '<em><b>Read Only List Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_READ_ONLY_LIST_VAL = 15;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 16;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_STRING_VAL: return STRING_VAL;
      case INTERNAL_BOOLEAN_VAL: return BOOLEAN_VAL;
      case INTERNAL_BYTE_VAL: return BYTE_VAL;
      case INTERNAL_DECIMAL_VAL: return DECIMAL_VAL;
      case INTERNAL_INT_VAL: return INT_VAL;
      case INTERNAL_FLOAT_VAL: return FLOAT_VAL;
      case INTERNAL_DOUBLE_VAL: return DOUBLE_VAL;
      case INTERNAL_DATE_VAL: return DATE_VAL;
      case INTERNAL_SHORT_VAL: return SHORT_VAL;
      case INTERNAL_LONG_VAL: return LONG_VAL;
      case INTERNAL_LIST_VAL: return LIST_VAL;
      case INTERNAL_BYTES_VAL: return BYTES_VAL;
      case INTERNAL_INTEGER_VAL: return INTEGER_VAL;
      case INTERNAL_CHAR_VAL: return CHAR_VAL;
      case INTERNAL_READ_ONLY_VAL: return READ_ONLY_VAL;
      case INTERNAL_READ_ONLY_LIST_VAL: return READ_ONLY_LIST_VAL;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The default value of the '{@link #getStringVal() <em>String Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStringVal()
   * @generated
   * @ordered
   */
  protected static final String STRING_VAL_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getStringVal() <em>String Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStringVal()
   * @generated
   * @ordered
   */
  protected String stringVal = STRING_VAL_DEFAULT_;

  /**
   * This is true if the String Val attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean stringVal_set_ = false;

  /**
   * The default value of the '{@link #isBooleanVal() <em>Boolean Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isBooleanVal()
   * @generated
   * @ordered
   */
  protected static final boolean BOOLEAN_VAL_DEFAULT_ = false;

  /**
   * The cached value of the '{@link #isBooleanVal() <em>Boolean Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isBooleanVal()
   * @generated
   * @ordered
   */
  protected boolean booleanVal = BOOLEAN_VAL_DEFAULT_;

  /**
   * This is true if the Boolean Val attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean booleanVal_set_ = false;

  /**
   * The default value of the '{@link #getByteVal() <em>Byte Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getByteVal()
   * @generated
   * @ordered
   */
  protected static final byte BYTE_VAL_DEFAULT_ = 0;

  /**
   * The cached value of the '{@link #getByteVal() <em>Byte Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getByteVal()
   * @generated
   * @ordered
   */
  protected byte byteVal = BYTE_VAL_DEFAULT_;

  /**
   * This is true if the Byte Val attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean byteVal_set_ = false;

  /**
   * The default value of the '{@link #getDecimalVal() <em>Decimal Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDecimalVal()
   * @generated
   * @ordered
   */
  protected static final BigDecimal DECIMAL_VAL_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getDecimalVal() <em>Decimal Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDecimalVal()
   * @generated
   * @ordered
   */
  protected BigDecimal decimalVal = DECIMAL_VAL_DEFAULT_;

  /**
   * This is true if the Decimal Val attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean decimalVal_set_ = false;

  /**
   * The default value of the '{@link #getIntVal() <em>Int Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntVal()
   * @generated
   * @ordered
   */
  protected static final int INT_VAL_DEFAULT_ = 0;

  /**
   * The cached value of the '{@link #getIntVal() <em>Int Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntVal()
   * @generated
   * @ordered
   */
  protected int intVal = INT_VAL_DEFAULT_;

  /**
   * This is true if the Int Val attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean intVal_set_ = false;

  /**
   * The default value of the '{@link #getFloatVal() <em>Float Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFloatVal()
   * @generated
   * @ordered
   */
  protected static final float FLOAT_VAL_DEFAULT_ = 0.0F;

  /**
   * The cached value of the '{@link #getFloatVal() <em>Float Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFloatVal()
   * @generated
   * @ordered
   */
  protected float floatVal = FLOAT_VAL_DEFAULT_;

  /**
   * This is true if the Float Val attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean floatVal_set_ = false;

  /**
   * The default value of the '{@link #getDoubleVal() <em>Double Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDoubleVal()
   * @generated
   * @ordered
   */
  protected static final double DOUBLE_VAL_DEFAULT_ = 0.0;

  /**
   * The cached value of the '{@link #getDoubleVal() <em>Double Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDoubleVal()
   * @generated
   * @ordered
   */
  protected double doubleVal = DOUBLE_VAL_DEFAULT_;

  /**
   * This is true if the Double Val attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean doubleVal_set_ = false;

  /**
   * The default value of the '{@link #getDateVal() <em>Date Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDateVal()
   * @generated
   * @ordered
   */
  protected static final String DATE_VAL_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getDateVal() <em>Date Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDateVal()
   * @generated
   * @ordered
   */
  protected String dateVal = DATE_VAL_DEFAULT_;

  /**
   * This is true if the Date Val attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean dateVal_set_ = false;

  /**
   * The default value of the '{@link #getShortVal() <em>Short Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShortVal()
   * @generated
   * @ordered
   */
  protected static final short SHORT_VAL_DEFAULT_ = 0;

  /**
   * The cached value of the '{@link #getShortVal() <em>Short Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShortVal()
   * @generated
   * @ordered
   */
  protected short shortVal = SHORT_VAL_DEFAULT_;

  /**
   * This is true if the Short Val attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean shortVal_set_ = false;

  /**
   * The default value of the '{@link #getLongVal() <em>Long Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLongVal()
   * @generated
   * @ordered
   */
  protected static final long LONG_VAL_DEFAULT_ = 0L;

  /**
   * The cached value of the '{@link #getLongVal() <em>Long Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLongVal()
   * @generated
   * @ordered
   */
  protected long longVal = LONG_VAL_DEFAULT_;

  /**
   * This is true if the Long Val attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean longVal_set_ = false;

  /**
   * The cached value of the '{@link #getListVal() <em>List Val</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getListVal()
   * @generated
   * @ordered
   */
  
  protected List listVal = null;
  
  /**
   * The default value of the '{@link #getBytesVal() <em>Bytes Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBytesVal()
   * @generated
   * @ordered
   */
  protected static final byte[] BYTES_VAL_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getBytesVal() <em>Bytes Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBytesVal()
   * @generated
   * @ordered
   */
  protected byte[] bytesVal = BYTES_VAL_DEFAULT_;

  /**
   * This is true if the Bytes Val attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean bytesVal_set_ = false;

  /**
   * The default value of the '{@link #getIntegerVal() <em>Integer Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntegerVal()
   * @generated
   * @ordered
   */
  protected static final BigInteger INTEGER_VAL_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getIntegerVal() <em>Integer Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntegerVal()
   * @generated
   * @ordered
   */
  protected BigInteger integerVal = INTEGER_VAL_DEFAULT_;

  /**
   * This is true if the Integer Val attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean integerVal_set_ = false;

  /**
   * The default value of the '{@link #getCharVal() <em>Char Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCharVal()
   * @generated
   * @ordered
   */
  protected static final String CHAR_VAL_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getCharVal() <em>Char Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCharVal()
   * @generated
   * @ordered
   */
  protected String charVal = CHAR_VAL_DEFAULT_;

  /**
   * This is true if the Char Val attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean charVal_set_ = false;

  /**
   * The default value of the '{@link #getReadOnlyVal() <em>Read Only Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReadOnlyVal()
   * @generated
   * @ordered
   */
  protected static final String READ_ONLY_VAL_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getReadOnlyVal() <em>Read Only Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReadOnlyVal()
   * @generated
   * @ordered
   */
  protected String readOnlyVal = READ_ONLY_VAL_DEFAULT_;

  /**
   * This is true if the Read Only Val attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean readOnlyVal_set_ = false;

  /**
   * The default value of the '{@link #getReadOnlyListVal() <em>Read Only List Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReadOnlyListVal()
   * @generated
   * @ordered
   */
  protected static final String READ_ONLY_LIST_VAL_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getReadOnlyListVal() <em>Read Only List Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReadOnlyListVal()
   * @generated
   * @ordered
   */
  protected String readOnlyListVal = READ_ONLY_LIST_VAL_DEFAULT_;

  /**
   * This is true if the Read Only List Val attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean readOnlyListVal_set_ = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpectedExceptionTypeImpl()
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
    return ((ExpectedExceptionFactoryImpl)ExpectedExceptionFactory.INSTANCE).getExpectedExceptionType();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStringVal()
  {
    return stringVal;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStringVal(String newStringVal)
  {
    String oldStringVal = stringVal;
    stringVal = newStringVal;
    boolean oldStringVal_set_ = stringVal_set_;
    stringVal_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, STRING_VAL, oldStringVal, stringVal, !oldStringVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetStringVal()
  {
    String oldStringVal = stringVal;
    boolean oldStringVal_set_ = stringVal_set_;
    stringVal = STRING_VAL_DEFAULT_;
    stringVal_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, STRING_VAL, oldStringVal, STRING_VAL_DEFAULT_, oldStringVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetStringVal()
  {
    return stringVal_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isBooleanVal()
  {
    return booleanVal;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBooleanVal(boolean newBooleanVal)
  {
    boolean oldBooleanVal = booleanVal;
    booleanVal = newBooleanVal;
    boolean oldBooleanVal_set_ = booleanVal_set_;
    booleanVal_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, BOOLEAN_VAL, oldBooleanVal, booleanVal, !oldBooleanVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetBooleanVal()
  {
    boolean oldBooleanVal = booleanVal;
    boolean oldBooleanVal_set_ = booleanVal_set_;
    booleanVal = BOOLEAN_VAL_DEFAULT_;
    booleanVal_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, BOOLEAN_VAL, oldBooleanVal, BOOLEAN_VAL_DEFAULT_, oldBooleanVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetBooleanVal()
  {
    return booleanVal_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public byte getByteVal()
  {
    return byteVal;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setByteVal(byte newByteVal)
  {
    byte oldByteVal = byteVal;
    byteVal = newByteVal;
    boolean oldByteVal_set_ = byteVal_set_;
    byteVal_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, BYTE_VAL, oldByteVal, byteVal, !oldByteVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetByteVal()
  {
    byte oldByteVal = byteVal;
    boolean oldByteVal_set_ = byteVal_set_;
    byteVal = BYTE_VAL_DEFAULT_;
    byteVal_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, BYTE_VAL, oldByteVal, BYTE_VAL_DEFAULT_, oldByteVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetByteVal()
  {
    return byteVal_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigDecimal getDecimalVal()
  {
    return decimalVal;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDecimalVal(BigDecimal newDecimalVal)
  {
    BigDecimal oldDecimalVal = decimalVal;
    decimalVal = newDecimalVal;
    boolean oldDecimalVal_set_ = decimalVal_set_;
    decimalVal_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, DECIMAL_VAL, oldDecimalVal, decimalVal, !oldDecimalVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDecimalVal()
  {
    BigDecimal oldDecimalVal = decimalVal;
    boolean oldDecimalVal_set_ = decimalVal_set_;
    decimalVal = DECIMAL_VAL_DEFAULT_;
    decimalVal_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, DECIMAL_VAL, oldDecimalVal, DECIMAL_VAL_DEFAULT_, oldDecimalVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDecimalVal()
  {
    return decimalVal_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getIntVal()
  {
    return intVal;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIntVal(int newIntVal)
  {
    int oldIntVal = intVal;
    intVal = newIntVal;
    boolean oldIntVal_set_ = intVal_set_;
    intVal_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INT_VAL, oldIntVal, intVal, !oldIntVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetIntVal()
  {
    int oldIntVal = intVal;
    boolean oldIntVal_set_ = intVal_set_;
    intVal = INT_VAL_DEFAULT_;
    intVal_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INT_VAL, oldIntVal, INT_VAL_DEFAULT_, oldIntVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetIntVal()
  {
    return intVal_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public float getFloatVal()
  {
    return floatVal;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFloatVal(float newFloatVal)
  {
    float oldFloatVal = floatVal;
    floatVal = newFloatVal;
    boolean oldFloatVal_set_ = floatVal_set_;
    floatVal_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, FLOAT_VAL, oldFloatVal, floatVal, !oldFloatVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetFloatVal()
  {
    float oldFloatVal = floatVal;
    boolean oldFloatVal_set_ = floatVal_set_;
    floatVal = FLOAT_VAL_DEFAULT_;
    floatVal_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, FLOAT_VAL, oldFloatVal, FLOAT_VAL_DEFAULT_, oldFloatVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetFloatVal()
  {
    return floatVal_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public double getDoubleVal()
  {
    return doubleVal;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDoubleVal(double newDoubleVal)
  {
    double oldDoubleVal = doubleVal;
    doubleVal = newDoubleVal;
    boolean oldDoubleVal_set_ = doubleVal_set_;
    doubleVal_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, DOUBLE_VAL, oldDoubleVal, doubleVal, !oldDoubleVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDoubleVal()
  {
    double oldDoubleVal = doubleVal;
    boolean oldDoubleVal_set_ = doubleVal_set_;
    doubleVal = DOUBLE_VAL_DEFAULT_;
    doubleVal_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, DOUBLE_VAL, oldDoubleVal, DOUBLE_VAL_DEFAULT_, oldDoubleVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDoubleVal()
  {
    return doubleVal_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDateVal()
  {
    return dateVal;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDateVal(String newDateVal)
  {
    String oldDateVal = dateVal;
    dateVal = newDateVal;
    boolean oldDateVal_set_ = dateVal_set_;
    dateVal_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, DATE_VAL, oldDateVal, dateVal, !oldDateVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDateVal()
  {
    String oldDateVal = dateVal;
    boolean oldDateVal_set_ = dateVal_set_;
    dateVal = DATE_VAL_DEFAULT_;
    dateVal_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, DATE_VAL, oldDateVal, DATE_VAL_DEFAULT_, oldDateVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDateVal()
  {
    return dateVal_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public short getShortVal()
  {
    return shortVal;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setShortVal(short newShortVal)
  {
    short oldShortVal = shortVal;
    shortVal = newShortVal;
    boolean oldShortVal_set_ = shortVal_set_;
    shortVal_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, SHORT_VAL, oldShortVal, shortVal, !oldShortVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetShortVal()
  {
    short oldShortVal = shortVal;
    boolean oldShortVal_set_ = shortVal_set_;
    shortVal = SHORT_VAL_DEFAULT_;
    shortVal_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, SHORT_VAL, oldShortVal, SHORT_VAL_DEFAULT_, oldShortVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetShortVal()
  {
    return shortVal_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public long getLongVal()
  {
    return longVal;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLongVal(long newLongVal)
  {
    long oldLongVal = longVal;
    longVal = newLongVal;
    boolean oldLongVal_set_ = longVal_set_;
    longVal_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, LONG_VAL, oldLongVal, longVal, !oldLongVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetLongVal()
  {
    long oldLongVal = longVal;
    boolean oldLongVal_set_ = longVal_set_;
    longVal = LONG_VAL_DEFAULT_;
    longVal_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, LONG_VAL, oldLongVal, LONG_VAL_DEFAULT_, oldLongVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetLongVal()
  {
    return longVal_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getListVal()
  {
    if (listVal == null)
    {
      listVal = createPropertyList(ListKind.DATATYPE, String.class, LIST_VAL, 0);
    }
    return listVal;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public byte[] getBytesVal()
  {
    return bytesVal;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBytesVal(byte[] newBytesVal)
  {
    byte[] oldBytesVal = bytesVal;
    bytesVal = newBytesVal;
    boolean oldBytesVal_set_ = bytesVal_set_;
    bytesVal_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, BYTES_VAL, oldBytesVal, bytesVal, !oldBytesVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetBytesVal()
  {
    byte[] oldBytesVal = bytesVal;
    boolean oldBytesVal_set_ = bytesVal_set_;
    bytesVal = BYTES_VAL_DEFAULT_;
    bytesVal_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, BYTES_VAL, oldBytesVal, BYTES_VAL_DEFAULT_, oldBytesVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetBytesVal()
  {
    return bytesVal_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigInteger getIntegerVal()
  {
    return integerVal;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIntegerVal(BigInteger newIntegerVal)
  {
    BigInteger oldIntegerVal = integerVal;
    integerVal = newIntegerVal;
    boolean oldIntegerVal_set_ = integerVal_set_;
    integerVal_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTEGER_VAL, oldIntegerVal, integerVal, !oldIntegerVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetIntegerVal()
  {
    BigInteger oldIntegerVal = integerVal;
    boolean oldIntegerVal_set_ = integerVal_set_;
    integerVal = INTEGER_VAL_DEFAULT_;
    integerVal_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTEGER_VAL, oldIntegerVal, INTEGER_VAL_DEFAULT_, oldIntegerVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetIntegerVal()
  {
    return integerVal_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCharVal()
  {
    return charVal;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCharVal(String newCharVal)
  {
    String oldCharVal = charVal;
    charVal = newCharVal;
    boolean oldCharVal_set_ = charVal_set_;
    charVal_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, CHAR_VAL, oldCharVal, charVal, !oldCharVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetCharVal()
  {
    String oldCharVal = charVal;
    boolean oldCharVal_set_ = charVal_set_;
    charVal = CHAR_VAL_DEFAULT_;
    charVal_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, CHAR_VAL, oldCharVal, CHAR_VAL_DEFAULT_, oldCharVal_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetCharVal()
  {
    return charVal_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getReadOnlyVal()
  {
    return readOnlyVal;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetReadOnlyVal()
  {
    return readOnlyVal_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getReadOnlyListVal()
  {
    return readOnlyListVal;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetReadOnlyListVal()
  {
    return readOnlyListVal_set_;
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
      case STRING_VAL:
        return getStringVal();
      case BOOLEAN_VAL:
        return isBooleanVal() ? Boolean.TRUE : Boolean.FALSE;
      case BYTE_VAL:
        return new Byte(getByteVal());
      case DECIMAL_VAL:
        return getDecimalVal();
      case INT_VAL:
        return new Integer(getIntVal());
      case FLOAT_VAL:
        return new Float(getFloatVal());
      case DOUBLE_VAL:
        return new Double(getDoubleVal());
      case DATE_VAL:
        return getDateVal();
      case SHORT_VAL:
        return new Short(getShortVal());
      case LONG_VAL:
        return new Long(getLongVal());
      case LIST_VAL:
        return getListVal();
      case BYTES_VAL:
        return getBytesVal();
      case INTEGER_VAL:
        return getIntegerVal();
      case CHAR_VAL:
        return getCharVal();
      case READ_ONLY_VAL:
        return getReadOnlyVal();
      case READ_ONLY_LIST_VAL:
        return getReadOnlyListVal();
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
      case STRING_VAL:
        setStringVal((String)newValue);
        return;
      case BOOLEAN_VAL:
        setBooleanVal(((Boolean)newValue).booleanValue());
        return;
      case BYTE_VAL:
        setByteVal(((Byte)newValue).byteValue());
        return;
      case DECIMAL_VAL:
        setDecimalVal((BigDecimal)newValue);
        return;
      case INT_VAL:
        setIntVal(((Integer)newValue).intValue());
        return;
      case FLOAT_VAL:
        setFloatVal(((Float)newValue).floatValue());
        return;
      case DOUBLE_VAL:
        setDoubleVal(((Double)newValue).doubleValue());
        return;
      case DATE_VAL:
        setDateVal((String)newValue);
        return;
      case SHORT_VAL:
        setShortVal(((Short)newValue).shortValue());
        return;
      case LONG_VAL:
        setLongVal(((Long)newValue).longValue());
        return;
      case LIST_VAL:
        getListVal().clear();
        getListVal().addAll((Collection)newValue);
        return;
      case BYTES_VAL:
        setBytesVal((byte[])newValue);
        return;
      case INTEGER_VAL:
        setIntegerVal((BigInteger)newValue);
        return;
      case CHAR_VAL:
        setCharVal((String)newValue);
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
      case STRING_VAL:
        unsetStringVal();
        return;
      case BOOLEAN_VAL:
        unsetBooleanVal();
        return;
      case BYTE_VAL:
        unsetByteVal();
        return;
      case DECIMAL_VAL:
        unsetDecimalVal();
        return;
      case INT_VAL:
        unsetIntVal();
        return;
      case FLOAT_VAL:
        unsetFloatVal();
        return;
      case DOUBLE_VAL:
        unsetDoubleVal();
        return;
      case DATE_VAL:
        unsetDateVal();
        return;
      case SHORT_VAL:
        unsetShortVal();
        return;
      case LONG_VAL:
        unsetLongVal();
        return;
      case LIST_VAL:
        getListVal().clear();
        return;
      case BYTES_VAL:
        unsetBytesVal();
        return;
      case INTEGER_VAL:
        unsetIntegerVal();
        return;
      case CHAR_VAL:
        unsetCharVal();
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
      case STRING_VAL:
        return isSetStringVal();
      case BOOLEAN_VAL:
        return isSetBooleanVal();
      case BYTE_VAL:
        return isSetByteVal();
      case DECIMAL_VAL:
        return isSetDecimalVal();
      case INT_VAL:
        return isSetIntVal();
      case FLOAT_VAL:
        return isSetFloatVal();
      case DOUBLE_VAL:
        return isSetDoubleVal();
      case DATE_VAL:
        return isSetDateVal();
      case SHORT_VAL:
        return isSetShortVal();
      case LONG_VAL:
        return isSetLongVal();
      case LIST_VAL:
        return listVal != null && !listVal.isEmpty();
      case BYTES_VAL:
        return isSetBytesVal();
      case INTEGER_VAL:
        return isSetIntegerVal();
      case CHAR_VAL:
        return isSetCharVal();
      case READ_ONLY_VAL:
        return isSetReadOnlyVal();
      case READ_ONLY_LIST_VAL:
        return isSetReadOnlyListVal();
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
    result.append(" (stringVal: ");
    if (stringVal_set_) result.append(stringVal); else result.append("<unset>");
    result.append(", booleanVal: ");
    if (booleanVal_set_) result.append(booleanVal); else result.append("<unset>");
    result.append(", byteVal: ");
    if (byteVal_set_) result.append(byteVal); else result.append("<unset>");
    result.append(", decimalVal: ");
    if (decimalVal_set_) result.append(decimalVal); else result.append("<unset>");
    result.append(", intVal: ");
    if (intVal_set_) result.append(intVal); else result.append("<unset>");
    result.append(", floatVal: ");
    if (floatVal_set_) result.append(floatVal); else result.append("<unset>");
    result.append(", doubleVal: ");
    if (doubleVal_set_) result.append(doubleVal); else result.append("<unset>");
    result.append(", dateVal: ");
    if (dateVal_set_) result.append(dateVal); else result.append("<unset>");
    result.append(", shortVal: ");
    if (shortVal_set_) result.append(shortVal); else result.append("<unset>");
    result.append(", longVal: ");
    if (longVal_set_) result.append(longVal); else result.append("<unset>");
    result.append(", listVal: ");
    result.append(listVal);
    result.append(", bytesVal: ");
    if (bytesVal_set_) result.append(bytesVal); else result.append("<unset>");
    result.append(", integerVal: ");
    if (integerVal_set_) result.append(integerVal); else result.append("<unset>");
    result.append(", charVal: ");
    if (charVal_set_) result.append(charVal); else result.append("<unset>");
    result.append(", readOnlyVal: ");
    if (readOnlyVal_set_) result.append(readOnlyVal); else result.append("<unset>");
    result.append(", readOnlyListVal: ");
    if (readOnlyListVal_set_) result.append(readOnlyListVal); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //ExpectedExceptionTypeImpl
