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

import java.util.Collection;
import java.util.List;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import org.apache.tuscany.sdo.util.metadata.JavaMetaData;
import org.apache.tuscany.sdo.util.metadata.MetadataFactory;
import org.apache.tuscany.sdo.util.metadata.SDOMetaDataGroup;
import org.apache.tuscany.sdo.util.metadata.TypeMetaData;
import org.apache.tuscany.sdo.util.metadata.XSDMetaData;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SDO Meta Data Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.util.metadata.impl.SDOMetaDataGroupImpl#getJavaMetaData <em>Java Meta Data</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.util.metadata.impl.SDOMetaDataGroupImpl#getXsdMetaData <em>Xsd Meta Data</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.util.metadata.impl.SDOMetaDataGroupImpl#getTypeMetaData <em>Type Meta Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SDOMetaDataGroupImpl extends DataObjectBase implements SDOMetaDataGroup
{
  /**
   * The feature id for the '<em><b>Java Meta Data</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int JAVA_META_DATA = 0;

  /**
   * The feature id for the '<em><b>Xsd Meta Data</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int XSD_META_DATA = 1;

  /**
   * The feature id for the '<em><b>Type Meta Data</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int TYPE_META_DATA = 2;

  /**
   * This represents the number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  
  public final static int SDO_PROPERTY_COUNT = 3;

  /**
   * The cached value of the '{@link #getJavaMetaData() <em>Java Meta Data</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJavaMetaData()
   * @generated
   * @ordered
   */
  
  protected List javaMetaData = null;
  
  /**
   * The cached value of the '{@link #getXsdMetaData() <em>Xsd Meta Data</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXsdMetaData()
   * @generated
   * @ordered
   */
  
  protected List xsdMetaData = null;
  
  /**
   * The cached value of the '{@link #getTypeMetaData() <em>Type Meta Data</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeMetaData()
   * @generated
   * @ordered
   */
  
  protected List typeMetaData = null;
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SDOMetaDataGroupImpl()
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
    return ((MetadataFactoryImpl)MetadataFactory.INSTANCE).getSDOMetaDataGroup();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getJavaMetaData()
  {
    if (javaMetaData == null)
    {
      javaMetaData = createPropertyList(ListKind.CONTAINMENT, JavaMetaData.class, JAVA_META_DATA);
    }
    return javaMetaData;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getXsdMetaData()
  {
    if (xsdMetaData == null)
    {
      xsdMetaData = createPropertyList(ListKind.CONTAINMENT, XSDMetaData.class, XSD_META_DATA);
    }
    return xsdMetaData;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getTypeMetaData()
  {
    if (typeMetaData == null)
    {
      typeMetaData = createPropertyList(ListKind.CONTAINMENT, TypeMetaData.class, TYPE_META_DATA);
    }
    return typeMetaData;
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
      case JAVA_META_DATA:
        return removeFromList(getJavaMetaData(), otherEnd, changeContext);
      case XSD_META_DATA:
        return removeFromList(getXsdMetaData(), otherEnd, changeContext);
      case TYPE_META_DATA:
        return removeFromList(getTypeMetaData(), otherEnd, changeContext);
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
      case JAVA_META_DATA:
        return getJavaMetaData();
      case XSD_META_DATA:
        return getXsdMetaData();
      case TYPE_META_DATA:
        return getTypeMetaData();
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
      case JAVA_META_DATA:
        getJavaMetaData().clear();
        getJavaMetaData().addAll((Collection)newValue);
        return;
      case XSD_META_DATA:
        getXsdMetaData().clear();
        getXsdMetaData().addAll((Collection)newValue);
        return;
      case TYPE_META_DATA:
        getTypeMetaData().clear();
        getTypeMetaData().addAll((Collection)newValue);
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
      case JAVA_META_DATA:
        getJavaMetaData().clear();
        return;
      case XSD_META_DATA:
        getXsdMetaData().clear();
        return;
      case TYPE_META_DATA:
        getTypeMetaData().clear();
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
      case JAVA_META_DATA:
        return javaMetaData != null && !javaMetaData.isEmpty();
      case XSD_META_DATA:
        return xsdMetaData != null && !xsdMetaData.isEmpty();
      case TYPE_META_DATA:
        return typeMetaData != null && !typeMetaData.isEmpty();
    }
    return super.isSet(propertyIndex);
  }

} //SDOMetaDataGroupImpl
