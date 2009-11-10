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
package org.apache.tuscany.sdo.model.impl;

import commonj.sdo.Type;

import java.util.Collection;
import java.util.List;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import org.apache.tuscany.sdo.model.ModelFactory;
import org.apache.tuscany.sdo.model.Types;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Types</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.TypesImpl#getType_ <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypesImpl extends DataObjectBase implements Types
{

  public final static int TYPE = 0;

  public final static int SDO_PROPERTY_COUNT = 1;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Type</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TYPE = 0;

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
      case INTERNAL_TYPE: return TYPE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getType_() <em>Type</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType_()
   * @generated
   * @ordered
   */
  
  protected List type = null;
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypesImpl()
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
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).getTypes();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getType_()
  {
    if (type == null)
    {
      type = createPropertyList(ListKind.CONTAINMENT, org.apache.tuscany.sdo.model.Type.class, TYPE, 0);
    }
    return type;
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
      case TYPE:
        return removeFromList(getType_(), otherEnd, changeContext);
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
      case TYPE:
        return getType_();
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
      case TYPE:
        getType_().clear();
        getType_().addAll((Collection)newValue);
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
      case TYPE:
        getType_().clear();
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
      case TYPE:
        return type != null && !type.isEmpty();
    }
    return super.isSet(propertyIndex);
  }
  
  public List getTypeList()
  {
    return getType_();
  }

} //TypesImpl
