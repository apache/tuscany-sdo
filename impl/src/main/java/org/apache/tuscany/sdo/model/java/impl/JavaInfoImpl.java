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
package org.apache.tuscany.sdo.model.java.impl;

import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import org.apache.tuscany.sdo.model.java.JavaFactory;
import org.apache.tuscany.sdo.model.java.JavaInfo;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.model.java.impl.JavaInfoImpl#getJavaClass <em>Java Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JavaInfoImpl extends DataObjectBase implements JavaInfo
{

  public final static int JAVA_CLASS = 0;

  public final static int SDO_PROPERTY_COUNT = 1;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Java Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_JAVA_CLASS = 0;

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
      case INTERNAL_JAVA_CLASS: return JAVA_CLASS;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The default value of the '{@link #getJavaClass() <em>Java Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJavaClass()
   * @generated
   * @ordered
   */
  protected static final String JAVA_CLASS_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getJavaClass() <em>Java Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJavaClass()
   * @generated
   * @ordered
   */
  protected String javaClass = JAVA_CLASS_DEFAULT_;

  /**
   * This is true if the Java Class attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean javaClass_set_ = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaInfoImpl()
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
    return ((JavaFactoryImpl)JavaFactory.INSTANCE).getJavaInfo();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getJavaClass()
  {
    return javaClass;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setJavaClass(String newJavaClass)
  {
    String oldJavaClass = javaClass;
    javaClass = newJavaClass;
    boolean oldJavaClass_set_ = javaClass_set_;
    javaClass_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_JAVA_CLASS, oldJavaClass, javaClass, !oldJavaClass_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetJavaClass()
  {
    String oldJavaClass = javaClass;
    boolean oldJavaClass_set_ = javaClass_set_;
    javaClass = JAVA_CLASS_DEFAULT_;
    javaClass_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_JAVA_CLASS, oldJavaClass, JAVA_CLASS_DEFAULT_, oldJavaClass_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetJavaClass()
  {
    return javaClass_set_;
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
      case JAVA_CLASS:
        return getJavaClass();
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
      case JAVA_CLASS:
        setJavaClass((String)newValue);
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
      case JAVA_CLASS:
        unsetJavaClass();
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
      case JAVA_CLASS:
        return isSetJavaClass();
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
    result.append(" (javaClass: ");
    if (javaClass_set_) result.append(javaClass); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //JavaInfoImpl
