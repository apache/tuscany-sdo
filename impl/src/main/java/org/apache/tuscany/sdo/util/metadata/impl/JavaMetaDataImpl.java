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
package org.apache.tuscany.sdo.util.metadata.impl;

import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import org.apache.tuscany.sdo.util.metadata.JavaMetaData;
import org.apache.tuscany.sdo.util.metadata.MetadataFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Meta Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.util.metadata.impl.JavaMetaDataImpl#getFactoryInterface <em>Factory Interface</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.util.metadata.impl.JavaMetaDataImpl#getTypeInterface <em>Type Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JavaMetaDataImpl extends DataObjectBase implements JavaMetaData
{
  /**
   * The feature id for the '<em><b>Factory Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int FACTORY_INTERFACE = 0;

  /**
   * The feature id for the '<em><b>Type Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int TYPE_INTERFACE = 1;

  /**
   * This represents the number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  
  public final static int SDO_PROPERTY_COUNT = 2;

  /**
   * The default value of the '{@link #getFactoryInterface() <em>Factory Interface</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFactoryInterface()
   * @generated
   * @ordered
   */
  protected static final String FACTORY_INTERFACE_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getFactoryInterface() <em>Factory Interface</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFactoryInterface()
   * @generated
   * @ordered
   */
  protected String factoryInterface = FACTORY_INTERFACE_DEFAULT_;

  /**
   * The default value of the '{@link #getTypeInterface() <em>Type Interface</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeInterface()
   * @generated
   * @ordered
   */
  protected static final String TYPE_INTERFACE_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getTypeInterface() <em>Type Interface</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeInterface()
   * @generated
   * @ordered
   */
  protected String typeInterface = TYPE_INTERFACE_DEFAULT_;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected JavaMetaDataImpl()
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
    return ((MetadataFactoryImpl)MetadataFactory.INSTANCE).getJavaMetaData();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFactoryInterface()
  {
    return factoryInterface;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFactoryInterface(String newFactoryInterface)
  {
    String oldFactoryInterface = factoryInterface;
    factoryInterface = newFactoryInterface;
    if (isNotifying())
      notify(ChangeKind.SET, FACTORY_INTERFACE, oldFactoryInterface, factoryInterface);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTypeInterface()
  {
    return typeInterface;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeInterface(String newTypeInterface)
  {
    String oldTypeInterface = typeInterface;
    typeInterface = newTypeInterface;
    if (isNotifying())
      notify(ChangeKind.SET, TYPE_INTERFACE, oldTypeInterface, typeInterface);
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
      case FACTORY_INTERFACE:
        return getFactoryInterface();
      case TYPE_INTERFACE:
        return getTypeInterface();
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
      case FACTORY_INTERFACE:
        setFactoryInterface((String)newValue);
        return;
      case TYPE_INTERFACE:
        setTypeInterface((String)newValue);
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
      case FACTORY_INTERFACE:
        setFactoryInterface(FACTORY_INTERFACE_DEFAULT_);
        return;
      case TYPE_INTERFACE:
        setTypeInterface(TYPE_INTERFACE_DEFAULT_);
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
      case FACTORY_INTERFACE:
        return FACTORY_INTERFACE_DEFAULT_ == null ? factoryInterface != null : !FACTORY_INTERFACE_DEFAULT_.equals(factoryInterface);
      case TYPE_INTERFACE:
        return TYPE_INTERFACE_DEFAULT_ == null ? typeInterface != null : !TYPE_INTERFACE_DEFAULT_.equals(typeInterface);
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
    result.append(" (factoryInterface: ");
    result.append(factoryInterface);
    result.append(", typeInterface: ");
    result.append(typeInterface);
    result.append(')');
    return result.toString();
  }

} //JavaMetaDataImpl
