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
package org.apache.tuscany.sdo.impl;


import java.io.ObjectStreamException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.tuscany.sdo.SDOPackage;
import org.apache.tuscany.sdo.impl.ChangeSummaryImpl.SDOChangeRecorder;
import org.apache.tuscany.sdo.lib.UnknownPropertyList;
import org.apache.tuscany.sdo.util.DataObjectUtil;
import org.apache.tuscany.sdo.util.VirtualSequence;
import org.apache.tuscany.sdo.util.DataObjectUtil.Accessor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.DynamicValueHolder;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentsEList;
import org.eclipse.emf.ecore.util.ECrossReferenceEList;

import commonj.sdo.ChangeSummary;
import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.Type;
import commonj.sdo.impl.ExternalizableDelegator;


/**
 * <!-- begin-user-doc -->
 * Base implementation of the SDO DataObject interface. This implementation allocates the minimum storage
 * overhead needed for SDO. It provides a complete implementation of the API, but does not, however, allocate
 * any storage for the actual properties of the data object. It instead requires subclasses for this purpose.
 * The subclass, DynamicDataObjectImpl serves as a concrete implementation class for dynamic data objects.
 * Static data object storage is provided by generated classes, which also directly or indirectly derive from
 * this class. 
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class DataObjectImpl extends BasicEObjectImpl implements DataObject
{
  protected InternalEObject eContainer;
  protected int eContainerFeatureID;
  protected SDOChangeRecorder changeRecorder;
  protected Object location; // Resource.Internal (if object is directly contained in a resource) or URI (if it is a proxy)
  protected BasicEList eAdapters;
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DataObjectImpl()
  {
    super();
  }
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Object get(int propertyIndex)
  {
    return get(DataObjectUtil.getProperty(this, propertyIndex));  
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void set(int propertyIndex, Object value)
  {
    set(DataObjectUtil.getProperty(this, propertyIndex), value);  
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean isSet(int propertyIndex)
  {
    return isSet(DataObjectUtil.getProperty(this, propertyIndex));  
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void unset(int propertyIndex)
  {
    unset(DataObjectUtil.getProperty(this, propertyIndex));  
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Object get(Property property)
  {
    return eGet((EStructuralFeature)property, true, false);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void set(Property property, Object value)
  {
    eSet((EStructuralFeature)property, value);
  }
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean isSet(Property property)
  {
    return eIsSet((EStructuralFeature)property);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void unset(Property property)
  {
    eUnset((EStructuralFeature)property);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public DataObject getContainer()
  {
    return (DataObject)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Property getContainmentProperty()
  {
    return (Property)eContainmentFeature();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Type getType()
  {
    return (Type)eClass();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Object writeReplace() throws ObjectStreamException
  {
    return new ExternalizableDelegator(this);
  }

  
  // Remaining DataObject methods are implemented as straight delegation to DataObjectUtil

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Object get(String path)
  {
    return DataObjectUtil.get(this, path);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void set(String path, Object value)
  {
    DataObjectUtil.set(this, path, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean isSet(String path)
  {
    return DataObjectUtil.isSet(this, path);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void unset(String path)
  {
    DataObjectUtil.unset(this, path);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public DataGraph getDataGraph()
  {
    return DataObjectUtil.getDataGraph(this);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public BigDecimal getBigDecimal(String path)
  {
    return DataObjectUtil.getBigDecimal(get(path));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public BigInteger getBigInteger(String path)
  {
    return DataObjectUtil.getBigInteger(get(path));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean getBoolean(String path)
  {
    return DataObjectUtil.getBoolean(get(path));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public byte getByte(String path)
  {
    return DataObjectUtil.getByte(get(path));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public byte[] getBytes(String path)
  {
    return DataObjectUtil.getBytes(get(path));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public char getChar(String path)
  {
    return DataObjectUtil.getChar(get(path));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public DataObject getDataObject(String path)
  {
    return (DataObject)get(path);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Date getDate(String path)
  {
    return DataObjectUtil.getDate(get(path));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public double getDouble(String path)
  {
    return DataObjectUtil.getDouble(get(path));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public float getFloat(String path)
  {
    return DataObjectUtil.getFloat(get(path));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public int getInt(String path)
  {
    return DataObjectUtil.getInt(get(path));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public List getList(String path)
  {
    List result = (List)get(path);
    if (result == null) {
    	result = new UnknownPropertyList(this, path);
    }
    
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public long getLong(String path)
  {
    return DataObjectUtil.getLong(get(path));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Sequence getSequence(String path)
  {
    return (Sequence)get(path);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public short getShort(String path)
  {
    return DataObjectUtil.getShort(get(path));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String getString(String path)
  {
    return DataObjectUtil.getString(get(path));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setBigDecimal(String path, BigDecimal value)
  {
    DataObjectUtil.setBigDecimal(this, path, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setBigInteger(String path, BigInteger value)
  {
    DataObjectUtil.setBigInteger(this, path, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setBoolean(String path, boolean value)
  {
    DataObjectUtil.setBoolean(this, path, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setByte(String path, byte value)
  {
    DataObjectUtil.setByte(this, path, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setBytes(String path, byte[] value)
  {
    DataObjectUtil.setBytes(this, path, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setChar(String path, char value)
  {
    DataObjectUtil.setChar(this, path, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setDataObject(String path, DataObject value)
  {
    DataObjectUtil.set(this, path, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setDate(String path, Date value)
  {
    DataObjectUtil.setDate(this,path,value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setDouble(String path, double value)
  {
    DataObjectUtil.setDouble(this, path, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setFloat(String path, float value)
  {
    DataObjectUtil.setFloat(this, path, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setInt(String path, int value)
  {
    DataObjectUtil.setInt(this, path, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setList(String path, List value)
  {
    DataObjectUtil.set(this, path, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setLong(String path, long value)
  {
    DataObjectUtil.setLong(this, path, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setShort(String path, short value)
  {
    DataObjectUtil.setShort(this, path, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setString(String path, String value)
  {
    DataObjectUtil.setString(this, path, value);
  } 

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public BigDecimal getBigDecimal(int propertyIndex)
  {
    return DataObjectUtil.getBigDecimal(this, propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public BigInteger getBigInteger(int propertyIndex)
  {
    return DataObjectUtil.getBigInteger(this,propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean getBoolean(int propertyIndex)
  {
    return DataObjectUtil.getBoolean(this, propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public byte getByte(int propertyIndex)
  {
    return DataObjectUtil.getByte(this, propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public byte[] getBytes(int propertyIndex)
  {
    return DataObjectUtil.getBytes(this, propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public char getChar(int propertyIndex)
  {
    return DataObjectUtil.getChar(this, propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public DataObject getDataObject(int propertyIndex)
  {
    return DataObjectUtil.getDataObject(this, propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Date getDate(int propertyIndex)
  {
    return DataObjectUtil.getDate(this,propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public double getDouble(int propertyIndex)
  {
    return DataObjectUtil.getDouble(this, propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public float getFloat(int propertyIndex)
  {
    return DataObjectUtil.getFloat(this,propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public int getInt(int propertyIndex)
  {
    return DataObjectUtil.getInt(this,propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public List getList(int propertyIndex)
  {
    return DataObjectUtil.getList(this, propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public long getLong(int propertyIndex)
  {
    return DataObjectUtil.getLong(this,propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Sequence getSequence(int propertyIndex)
  {
    return DataObjectUtil.getSequence(this, propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public short getShort(int propertyIndex)
  {
    return DataObjectUtil.getShort(this,propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String getString(int propertyIndex)
  {
    return DataObjectUtil.getString(this,propertyIndex);
  }
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setBigDecimal(int propertyIndex, BigDecimal value)
  {
    DataObjectUtil.setBigDecimal(this, propertyIndex, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setBigInteger(int propertyIndex, BigInteger value)
  {
    DataObjectUtil.setBigInteger(this, propertyIndex, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setBoolean(int propertyIndex, boolean value)
  {
    DataObjectUtil.setBoolean(this, propertyIndex, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setByte(int propertyIndex, byte value)
  {
    DataObjectUtil.setByte(this, propertyIndex, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setBytes(int propertyIndex, byte[] value)
  {
    DataObjectUtil.setBytes(this, propertyIndex, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setChar(int propertyIndex, char value)
  {
    DataObjectUtil.setChar(this, propertyIndex, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setDataObject(int propertyIndex, DataObject value)
  {
    DataObjectUtil.setDataObject(this, propertyIndex, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setDate(int propertyIndex, Date value)
  {
    DataObjectUtil.setDate(this, propertyIndex, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setDouble(int propertyIndex, double value)
  {
    DataObjectUtil.setDouble(this, propertyIndex, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setFloat(int propertyIndex, float value)
  {
    DataObjectUtil.setFloat(this, propertyIndex, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setInt(int propertyIndex, int value)
  {
    DataObjectUtil.setInt(this, propertyIndex, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setList(int propertyIndex, List value)
  {
    DataObjectUtil.setList(this, propertyIndex, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setLong(int propertyIndex, long value)
  {
    DataObjectUtil.setLong(this, propertyIndex, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setShort(int propertyIndex, short value)
  {
    DataObjectUtil.setShort(this, propertyIndex, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setString(int propertyIndex, String value)
  {
    DataObjectUtil.setString(this, propertyIndex, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public BigDecimal getBigDecimal(Property property)
  {
    return DataObjectUtil.getBigDecimal(this, property);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public BigInteger getBigInteger(Property property)
  {
    return DataObjectUtil.getBigInteger(this, property);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean getBoolean(Property property)
  {
    return DataObjectUtil.getBoolean(this, property);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public byte getByte(Property property)
  {
    return DataObjectUtil.getByte(this, property);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public byte[] getBytes(Property property)
  {
    return DataObjectUtil.getBytes(this, property);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public char getChar(Property property)
  {
    return DataObjectUtil.getChar(this, property);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public DataObject getDataObject(Property property)
  {
    return (DataObject)DataObjectUtil.getDataObject(this,property);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Date getDate(Property property)
  {
    return DataObjectUtil.getDate(this, property);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public double getDouble(Property property)
  {
    return DataObjectUtil.getDouble(this, property);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public float getFloat(Property property)
  {
    return DataObjectUtil.getFloat(this, property);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public int getInt(Property property)
  {
    return DataObjectUtil.getInt(this, property);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public List getList(Property property)
  {
    return (List)DataObjectUtil.getList(this, property);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public long getLong(Property property)
  {
    return DataObjectUtil.getLong(this, property);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Sequence getSequence(Property property)
  {
    return (Sequence)DataObjectUtil.getSequence(this, property);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public short getShort(Property property)
  {
    return DataObjectUtil.getShort(this, property);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String getString(Property property)
  {
    return DataObjectUtil.getString(this, property);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setBigDecimal(Property property, BigDecimal value)
  {
    DataObjectUtil.setBigDecimal(this,property, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setBigInteger(Property property, BigInteger value)
  {
    DataObjectUtil.setBigInteger(this,property, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setBoolean(Property property, boolean value)
  {
    DataObjectUtil.setBoolean(this,property, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setByte(Property property, byte value)
  {
    DataObjectUtil.setByte(this,property, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setBytes(Property property, byte[] value)
  {
    DataObjectUtil.setBytes(this,property, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setChar(Property property, char value)
  {
    DataObjectUtil.setChar(this,property, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setDataObject(Property property, DataObject value)
  {
    DataObjectUtil.setDataObject(this,property, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setDate(Property property, Date value)
  {
    DataObjectUtil.setDate(this,property, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setDouble(Property property, double value)
  {
    DataObjectUtil.setDouble(this,property, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setFloat(Property property, float value)
  {
    DataObjectUtil.setFloat(this,property, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setInt(Property property, int value)
  {
    DataObjectUtil.setInt(this,property, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setList(Property property, List value)
  {
    DataObjectUtil.setList(this,property, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setLong(Property property, long value)
  {
    DataObjectUtil.setLong(this,property, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setShort(Property property, short value)
  {
    DataObjectUtil.setShort(this,property, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setString(Property property, String value)
  {
    DataObjectUtil.setString(this,property, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public DataObject createDataObject(String propertyName)
  {
    return DataObjectUtil.createDataObject(this, propertyName);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public DataObject createDataObject(int propertyIndex)
  {
    return DataObjectUtil.createDataObject(this, propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public DataObject createDataObject(Property property)
  {
    return DataObjectUtil.createDataObject(this,property);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public DataObject createDataObject(String propertyName, String namespaceURI, String typeName)
  {
    return DataObjectUtil.createDataObject(this, propertyName, namespaceURI, typeName);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public DataObject createDataObject(int propertyIndex, String namespaceURI, String typeName)
  {
    return DataObjectUtil.createDataObject(this, propertyIndex, namespaceURI, typeName);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public DataObject createDataObject(Property property, Type type)
  {
    return DataObjectUtil.createDataObject(this, property, type);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void delete()
  {
    DataObjectUtil.delete(this);
  }
  
  protected Sequence sequence = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Sequence getSequence()
  {
    if (sequence == null)
    {
      EStructuralFeature sequenceFeature = ((ClassImpl)eClass()).getSequenceFeature();
      if (sequenceFeature == null) return null;
      if (sequenceFeature == ClassImpl.VIRTUAL_SEQUENCE_FEATURE)
        sequence = new VirtualSequence(this);
      else
        sequence = (Sequence)eGet(sequenceFeature, true, false);
    }
    return sequence;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public List getInstanceProperties()
  {
    return DataObjectUtil.getInstanceProperties(this);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Property getInstanceProperty(String propertyName)
  {
    return DataObjectUtil.getInstanceProperty(this, propertyName);
  }

  /**
   * @deprecated
   */
  public Property getProperty(String propertyName)
  {
    return DataObjectUtil.getInstanceProperty(this, propertyName);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public DataObject getRootObject()
  {
    return DataObjectUtil.getRootObject(this);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public ChangeSummary getChangeSummary()
  {
    return DataObjectUtil.getChangeSummary(this);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void detach()
  {
    DataObjectUtil.detach(this);
  }
  
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Following methods customize BasicEObjectImpl, optimized for SDO 
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EClass eStaticClass()
  {
    return SDOPackage.eINSTANCE.getDataObject();
  }

  public boolean eNotificationRequired()
  {
    return changeRecorder != null || super.eNotificationRequired();
  }

  public boolean eDeliver()
  {
    return true;
  }
  
  public void eNotify(Notification notification)
  {
    if(changeRecorder != null) changeRecorder.notifyChanged(notification);
    super.eNotify(notification);
  }

  public void setChangeRecorder(SDOChangeRecorder changeRecorder)
  {
    if (this.changeRecorder != null)
    {
      this.changeRecorder.unsetTarget(this);
    }

    if (changeRecorder != null)
    {
      changeRecorder.setTarget(this);
    }
    
    this.changeRecorder = changeRecorder;
  }

  public InternalEObject eInternalContainer()
  {
    return eContainer;
  }

  public int eContainerFeatureID()
  {
    return eContainerFeatureID;
  }

  protected void eBasicSetContainer(InternalEObject newContainer, int newContainerFeatureID)
  {
    eContainer = newContainer;
    eContainerFeatureID = newContainerFeatureID;
  }

  public EClass eClass()
  {
    return eStaticClass();
  }

  public EList eContents()
  {
    return new EContentsEList(this);
  }

  public EList eCrossReferences()
  {
    return new ECrossReferenceEList(this);
  }

  public Resource.Internal eDirectResource()
  {
    return location instanceof Resource.Internal ? (Resource.Internal)location : null;
  }

  protected EClass eDynamicClass()
  {
    return null;
  }

  protected boolean eHasSettings()
  {
    return false;
  }

  public boolean eIsProxy()
  {
    return location instanceof URI;
  }

  public URI eProxyURI()
  {
    return location instanceof URI ? (URI)location : null;
  }

  public void eSetClass(EClass eClass)
  {
    throw new UnsupportedOperationException();
  }

  protected void eSetDirectResource(Resource.Internal resource)
  {
    location = resource;
  }

  public void eSetProxyURI(URI uri)
  {
    location = uri;
  }

  protected DynamicValueHolder eSettings()
  {
    return null;
  }
  
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    return eDynamicGet(featureID, resolve, coreType);
  }

  public void eSet(int featureID, Object newValue)
  {
    eDynamicSet(featureID, newValue);
  }

  public void eUnset(int featureID)
  {
    eDynamicUnset(featureID);
  }

  public boolean eIsSet(int featureID)
  {
    return eDynamicIsSet(featureID);
  }
  
  public Object eDynamicGet(int featureID, boolean resolve, boolean coreType)
  {
    return eOpenGet(DataObjectUtil.getOpenFeature(this, featureID), resolve);
  }
  
  public void eDynamicSet(int featureID, Object newValue)
  {
    eOpenSet(DataObjectUtil.getOpenFeature(this, featureID), newValue);
  }

  public void eDynamicUnset(int featureID)
  {
    eOpenUnset(DataObjectUtil.getOpenFeature(this, featureID));
  }

  public boolean eDynamicIsSet(int featureID)
  {
    return eOpenIsSet(DataObjectUtil.getOpenFeature(this, featureID));
  }
  
  public EList eAdapters()
  {
    if (eAdapters == null)
    {
      eAdapters =  new EAdapterList(this);
    }
    return eAdapters;
  }

  public BasicEList eBasicAdapters()
  {
    return eAdapters;
  }

  
  /*
  public int eDerivedStructuralFeatureID(EStructuralFeature eStructuralFeature)
  {
    Class containerClass = eStructuralFeature.getContainerClass();
    return 
      containerClass == null ? 
        eClass().getFeatureID(eStructuralFeature) : 
          containerClass.isInstance(this) ?
            eDerivedStructuralFeatureID(eStructuralFeature.getFeatureID(), containerClass) : 
              -1;
  }
  
  public void eOpenSet(EStructuralFeature eFeature, Object newValue) 
  {
    EStructuralFeature openFeature = ExtendedMetaData.INSTANCE.getAffiliation(eClass(), eFeature);
    if (openFeature == null)
    {
      openFeature = (EStructuralFeature)eClass().getEStructuralFeature("any");
    }
    if (openFeature != null)
    {
      if (!FeatureMapUtil.isFeatureMap(openFeature))
      {
        openFeature = ExtendedMetaData.INSTANCE.getGroup(openFeature);
      }
      FeatureMap featureMap = (FeatureMap)eGet(openFeature);
      ((FeatureMap.Internal)featureMap).set(eFeature, newValue);
    }
    else
    {
      throw new IllegalArgumentException("The feature '" + eFeature.getName() + "' is not a valid changeable feature");
    }
  }
  */

} //DataObjectImpl



