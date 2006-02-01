/**
 *
 *  Copyright 2005 The Apache Software Foundation or its licensors, as applicable.
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
package org.apache.tuscany.sdo.impl;


import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import org.apache.sdo.util.SDOUtil;

import org.apache.tuscany.sdo.SDOPackage;
import org.apache.tuscany.sdo.impl.ChangeSummaryImpl.SDOChangeRecorder;
import org.apache.tuscany.sdo.util.DataObjectUtil;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.DynamicValueHolder;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.EContentsEList;
import org.eclipse.emf.ecore.util.ECrossReferenceEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

import commonj.sdo.ChangeSummary;
import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.Type;


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
   * @generated
   */
  protected EClass eStaticClass()
  {
    return SDOPackage.eINSTANCE.getDataObject();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Object writeReplace() throws ObjectStreamException
  {
    //TODO implement this method properly
    DataGraph dataGraph = getDataGraph();
    if (dataGraph != null)
    {
      return ((DataGraphImpl)dataGraph).getWriteReplacement(this);
    }
    else
    {
      throw new InvalidObjectException("The object must be in a datagraph to be serialized " + this);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Object get(String path)
  {
    Property property = getType().getProperty(path);
    if (property != null)
    {
      return get(property);
    }
    else
    {
      return DataObjectUtil.Accessor.create(this, path).getAndRecyle();
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void set(String path, Object value)
  {
    Property property = getType().getProperty(path);
    if (property != null)
    {
      set(property, value);
    }
    else
    {
      DataObjectUtil.Accessor.create(this, path).setAndRecyle(value);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean isSet(String path)
  {
    Property property = getType().getProperty(path);
    if (property != null)
    {
      return isSet(property);
    }
    else
    {
      return DataObjectUtil.Accessor.create(this, path).isSetAndRecyle();
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void unset(String path)
  {
    Property property = getType().getProperty(path);
    if (property != null)
    {
      unset(property);
    }
    else
    {
      DataObjectUtil.Accessor.create(this, path).unsetAndRecyle();
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Object get(int propertyIndex)
  {
    return eGet(propertyIndex, true, false);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void set(int propertyIndex, Object value)
  {
    eSet(propertyIndex, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean isSet(int propertyIndex)
  {
    return eIsSet(propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void unset(int propertyIndex)
  {
    eUnset(propertyIndex);
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
  public DataGraph getDataGraph()
  {
    Resource resource = eResource();
    if (resource != null)
    {
      ResourceSet resourceSet = resource.getResourceSet();
      if (resourceSet != null)
      {
        return (DataGraphImpl)EcoreUtil.getAdapter(resourceSet.eAdapters(), DataGraph.class);
      }
    }
    return null;
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
    return (List)get(path);
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
    Property property = getType().getProperty(path);
    if (property != null)
    {
      set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create(this, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setBigInteger(String path, BigInteger value)
  {
    Property property = getType().getProperty(path);
    if (property != null)
    {
      set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create(this, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setBoolean(String path, boolean value)
  {
    Property property = getType().getProperty(path);
    if (property != null)
    {
      set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create(this, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setByte(String path, byte value)
  {
    Property property = getType().getProperty(path);
    if (property != null)
    {
      set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create(this, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setBytes(String path, byte[] value)
  {
    Property property = getType().getProperty(path);
    if (property != null)
    {
      set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create(this, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setChar(String path, char value)
  {
    Property property = getType().getProperty(path);
    if (property != null)
    {
      set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create(this, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setDataObject(String path, DataObject value)
  {
    set(path, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setDate(String path, Date value)
  {
    Property property = getType().getProperty(path);
    if (property != null)
    {
      set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create(this, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setDouble(String path, double value)
  {
    Property property = getType().getProperty(path);
    if (property != null)
    {
      set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create(this, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setFloat(String path, float value)
  {
    Property property = getType().getProperty(path);
    if (property != null)
    {
      set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create(this, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setInt(String path, int value)
  {
    Property property = getType().getProperty(path);
    if (property != null)
    {
      set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create(this, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setList(String path, List value)
  {
    set(path, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setLong(String path, long value)
  {
    Property property = getType().getProperty(path);
    if (property != null)
    {
      set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create(this, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setShort(String path, short value)
  {
    Property property = getType().getProperty(path);
    if (property != null)
    {
      set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create(this, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setString(String path, String value)
  {
    Property property = getType().getProperty(path);
    if (property != null)
    {
      set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create(this, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public BigDecimal getBigDecimal(int propertyIndex)
  {
    return DataObjectUtil.getBigDecimal(get(propertyIndex));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public BigInteger getBigInteger(int propertyIndex)
  {
    return DataObjectUtil.getBigInteger(get(propertyIndex));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean getBoolean(int propertyIndex)
  {
    return DataObjectUtil.getBoolean(get(propertyIndex));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public byte getByte(int propertyIndex)
  {
    return DataObjectUtil.getByte(get(propertyIndex));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public byte[] getBytes(int propertyIndex)
  {
    return DataObjectUtil.getBytes(get(propertyIndex));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public char getChar(int propertyIndex)
  {
    return DataObjectUtil.getChar(get(propertyIndex));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public DataObject getDataObject(int propertyIndex)
  {
    return (DataObject)get(propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Date getDate(int propertyIndex)
  {
    return DataObjectUtil.getDate(get(propertyIndex));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public double getDouble(int propertyIndex)
  {
    return DataObjectUtil.getDouble(get(propertyIndex));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public float getFloat(int propertyIndex)
  {
    return DataObjectUtil.getFloat(get(propertyIndex));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public int getInt(int propertyIndex)
  {
    return DataObjectUtil.getInt(get(propertyIndex));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public List getList(int propertyIndex)
  {
    return (List)get(propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public long getLong(int propertyIndex)
  {
    return DataObjectUtil.getLong(get(propertyIndex));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Sequence getSequence(int propertyIndex)
  {
    return (Sequence)get(propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public short getShort(int propertyIndex)
  {
    return DataObjectUtil.getShort(get(propertyIndex));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String getString(int propertyIndex)
  {
    return DataObjectUtil.getString(get(propertyIndex));
  }
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setBigDecimal(int propertyIndex, BigDecimal value)
  {
    set(propertyIndex, DataObjectUtil.getSetValue((Property)eClass().getEStructuralFeature(propertyIndex), value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setBigInteger(int propertyIndex, BigInteger value)
  {
    set(propertyIndex, DataObjectUtil.getSetValue((Property)eClass().getEStructuralFeature(propertyIndex), value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setBoolean(int propertyIndex, boolean value)
  {
    set(propertyIndex, DataObjectUtil.getSetValue((Property)eClass().getEStructuralFeature(propertyIndex), value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setByte(int propertyIndex, byte value)
  {
    set(propertyIndex, DataObjectUtil.getSetValue((Property)eClass().getEStructuralFeature(propertyIndex), value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setBytes(int propertyIndex, byte[] value)
  {
    set(propertyIndex, DataObjectUtil.getSetValue((Property)eClass().getEStructuralFeature(propertyIndex), value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setChar(int propertyIndex, char value)
  {
    set(propertyIndex, DataObjectUtil.getSetValue((Property)eClass().getEStructuralFeature(propertyIndex), value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setDataObject(int propertyIndex, DataObject value)
  {
    set(propertyIndex, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setDate(int propertyIndex, Date value)
  {
    set(propertyIndex, DataObjectUtil.getSetValue((Property)eClass().getEStructuralFeature(propertyIndex), value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setDouble(int propertyIndex, double value)
  {
    set(propertyIndex, DataObjectUtil.getSetValue((Property)eClass().getEStructuralFeature(propertyIndex), value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setFloat(int propertyIndex, float value)
  {
    set(propertyIndex, DataObjectUtil.getSetValue((Property)eClass().getEStructuralFeature(propertyIndex), value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setInt(int propertyIndex, int value)
  {
    set(propertyIndex, DataObjectUtil.getSetValue((Property)eClass().getEStructuralFeature(propertyIndex), value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setList(int propertyIndex, List value)
  {
    set(propertyIndex, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setLong(int propertyIndex, long value)
  {
    set(propertyIndex, DataObjectUtil.getSetValue((Property)eClass().getEStructuralFeature(propertyIndex), value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setShort(int propertyIndex, short value)
  {
    set(propertyIndex, DataObjectUtil.getSetValue((Property)eClass().getEStructuralFeature(propertyIndex), value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setString(int propertyIndex, String value)
  {
    set(propertyIndex, DataObjectUtil.getSetValue((Property)eClass().getEStructuralFeature(propertyIndex), value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public BigDecimal getBigDecimal(Property property)
  {
    return DataObjectUtil.getBigDecimal(get(property));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public BigInteger getBigInteger(Property property)
  {
    return DataObjectUtil.getBigInteger(get(property));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean getBoolean(Property property)
  {
    return DataObjectUtil.getBoolean(get(property));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public byte getByte(Property property)
  {
    return DataObjectUtil.getByte(get(property));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public byte[] getBytes(Property property)
  {
    return DataObjectUtil.getBytes(get(property));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public char getChar(Property property)
  {
    return DataObjectUtil.getChar(get(property));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public DataObject getDataObject(Property property)
  {
    return (DataObject)get(property);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Date getDate(Property property)
  {
    return DataObjectUtil.getDate(get(property));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public double getDouble(Property property)
  {
    return DataObjectUtil.getDouble(get(property));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public float getFloat(Property property)
  {
    return DataObjectUtil.getFloat(get(property));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public int getInt(Property property)
  {
    return DataObjectUtil.getInt(get(property));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public List getList(Property property)
  {
    return (List)get(property);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public long getLong(Property property)
  {
    return DataObjectUtil.getLong(get(property));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Sequence getSequence(Property property)
  {
    return (Sequence)get(property);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public short getShort(Property property)
  {
    return DataObjectUtil.getShort(get(property));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String getString(Property property)
  {
    return DataObjectUtil.getString(get(property));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setBigDecimal(Property property, BigDecimal value)
  {
    set(property, DataObjectUtil.getSetValue(property, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setBigInteger(Property property, BigInteger value)
  {
    set(property, DataObjectUtil.getSetValue(property, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setBoolean(Property property, boolean value)
  {
    set(property, DataObjectUtil.getSetValue(property, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setByte(Property property, byte value)
  {
    set(property, DataObjectUtil.getSetValue(property, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setBytes(Property property, byte[] value)
  {
    set(property, DataObjectUtil.getSetValue(property, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setChar(Property property, char value)
  {
    set(property, DataObjectUtil.getSetValue(property, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setDataObject(Property property, DataObject value)
  {
    set(property, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setDate(Property property, Date value)
  {
    set(property, DataObjectUtil.getSetValue(property, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setDouble(Property property, double value)
  {
    set(property, DataObjectUtil.getSetValue(property, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setFloat(Property property, float value)
  {
    set(property, DataObjectUtil.getSetValue(property, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setInt(Property property, int value)
  {
    set(property, DataObjectUtil.getSetValue(property, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setList(Property property, List value)
  {
    set(property, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setLong(Property property, long value)
  {
    set(property, DataObjectUtil.getSetValue(property, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setShort(Property property, short value)
  {
    set(property, DataObjectUtil.getSetValue(property, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setString(Property property, String value)
  {
    set(property, DataObjectUtil.getSetValue(property, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public DataObject createDataObject(String propertyName)
  {
    Property property = (Property)DataObjectUtil.getProperty(this, propertyName);
    Type type = property.getType();
    return createDataObject(property, type);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public DataObject createDataObject(int propertyIndex)
  {
    Property property = DataObjectUtil.getProperty(this, propertyIndex);
    Type type = property.getType();
    return createDataObject(property, type);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public DataObject createDataObject(Property property)
  {
    Type type = property.getType();
    return createDataObject(property, type);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public DataObject createDataObject(String propertyName, String namespaceURI, String typeName)
  {
    Property property = DataObjectUtil.getProperty(this, propertyName);
    Type type = DataObjectUtil.getType(this, namespaceURI, typeName);
    return createDataObject(property, type);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public DataObject createDataObject(int propertyIndex, String namespaceURI, String typeName)
  {
    Property property = DataObjectUtil.getProperty(this, propertyIndex);
    Type type = DataObjectUtil.getType(this, namespaceURI, typeName);
    return createDataObject(property, type);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public DataObject createDataObject(Property property, Type type)
  {
    if (!property.isContainment())
    {
      throw new IllegalArgumentException("The property '" + property.getName() + "' of '" + property.getContainingType().getName()
        + "' isn't a containment");
    }
    DataObject result = DataObjectUtil.create(type);
    if (FeatureMapUtil.isMany(this, (EStructuralFeature)property))
    {
      ((List)get(property)).add(result);
    }
    else
    {
      set(property, result);
    }
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void delete()
  {
    EcoreUtil.remove(this);
    List contents = new ArrayList(eContents());
    for (int i = 0, size = contents.size(); i < size; ++i)
    {
      ((DataObject)contents.get(i)).delete();
    }
    EClass eClass = eClass();
    for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i)
    {
      EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(i);
      if (eStructuralFeature.isChangeable() && !eStructuralFeature.isDerived() && !((Property)eStructuralFeature).isReadOnly())
      {
        eUnset(eStructuralFeature);
      }
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Sequence getSequence()
  {
    EAttribute mixedFeature = BasicExtendedMetaData.INSTANCE.getMixedFeature(eClass());
    return mixedFeature != null ? (Sequence)eGet(mixedFeature, true, false) : null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public List getInstanceProperties()
  {
    //TODO maybe optimize this to just return type.getProperties if type.isOpen (isOpen would need to be cached)
    List result = new UniqueEList(eClass().getEAllStructuralFeatures());
    for (int i = 0, count = result.size(); i < count; ++i)
    {
      EStructuralFeature eStructuralFeature = (EStructuralFeature)result.get(i);
      if (!eStructuralFeature.isDerived() && FeatureMapUtil.isFeatureMap(eStructuralFeature))
      {
        List features = (List)eGet(eStructuralFeature);
        for (int j = 0, size = features.size(); j < size; ++j)
        {
          FeatureMap.Entry entry = (FeatureMap.Entry)features.get(j);
          EStructuralFeature entryFeature = entry.getEStructuralFeature();
          result.add(entryFeature);
        }
      }
    }
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Property getProperty(String propertyName)
  {
    Property property = getType().getProperty(propertyName);
    if (property == null)
    {
      property = (Property)DataObjectUtil.getOpenFeature(this, propertyName);
    }
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public DataObject getRootObject()
  {
    return (DataObject)EcoreUtil.getRootContainer(this);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public ChangeSummary getChangeSummary()
  {
    // TODO: implement this method
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void detach()
  {
    EcoreUtil.remove(this);
  }
  
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Following methods customize BasicEObjectImpl, optimized for SDO 
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  public boolean eNotificationRequired()
  {
    return changeRecorder != null;
  }

  public void eNotify(Notification notification)
  {
    changeRecorder.notifyChanged(notification);
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
  
} //EDataObjectImpl

