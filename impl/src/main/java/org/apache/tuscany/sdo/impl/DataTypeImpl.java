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

import java.util.Collections;
import java.util.List;

import org.apache.tuscany.sdo.SDOPackage;
import org.apache.tuscany.sdo.util.DataObjectUtil;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.impl.EDataTypeImpl;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DataTypeImpl extends EDataTypeImpl implements Type, org.apache.tuscany.sdo.model.Type/*, DataObject*/
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DataTypeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  protected EClass eStaticClass()
  {
    return SDOPackage.eINSTANCE.getDataType();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String getURI()
  {
    return getEPackage().getNsURI();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean isDataType()
  {
    return true;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean isOpen()
  {
    return false;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean isSequenced()
  {
    return false;
  }

  protected List aliasNames = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public List getAliasNames()
  {
    if (aliasNames == null)
    {
      aliasNames = DataObjectUtil.getAliasNames(this);
    }
    return aliasNames;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public List getDeclaredProperties()
  {
    return Collections.EMPTY_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public List getProperties()
  {
    return Collections.EMPTY_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public List getBaseTypes()
  {
    EDataType dataType = ExtendedMetaData.INSTANCE.getBaseType(this);
    if (dataType == null)
    {
      return Collections.EMPTY_LIST;
    }
    else
    {
      return Collections.singletonList(dataType);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Property getProperty(String propertyName)
  {
    return null;
  }
  
  public List getInstanceProperties() {
    return DataObjectUtil.getMetaObjectInstanceProperties(this);
  }

  public Object get(Property property) {
    return DataObjectUtil.getMetaObjectInstanceProperty(this, property);
  }
  
  /////////////////////////////////////////////////////////////////////////////////////////////////////////
  // org.apache.tuscany.sdo.model.Type method implementations
  /////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  public List getBaseType() {
    return this.getBaseTypes();
  }

  public List getProperty() {
    return this.getProperties();
  }

  public List getAliasName() {
    return this.getAliasNames();
  }

  public Sequence getAny() {
    throw new UnsupportedOperationException();
  }
  
  public Sequence getAnyAttribute() {
    throw new UnsupportedOperationException();
  }
  
  public boolean isAbstract()
  {
    return false;
  }

  public void setAbstract(boolean value) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public boolean isSetAbstract() {
    return false;
  }

  public void unsetAbstract() {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public void setDataType(boolean value) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public void unsetDataType() {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public boolean isSetDataType() {
    return true;
  }

  public void setOpen(boolean value) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public void unsetOpen() {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public boolean isSetOpen() {
    return false;
  }

  public void setSequenced(boolean value) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public void unsetSequenced() {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public boolean isSetSequenced() {
    return false;
  }

  public void unsetName()
  {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public boolean isSetName()
  {
    return true;
  }
  
  public void unsetUri()
  {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public boolean isSetUri()
  {
    return true;
  }

  public void setUri(String value) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }
  
  public String getUri() {
    return getURI();
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////
  // DataObject method implementations
  /////////////////////////////////////////////////////////////////////////////////////////////////////////
  /*
  public Object get(int propertyIndex) {
    Object ret = DataObjectUtil.get(this, propertyIndex);
    return (ret != null) ? 
        ret : eGet(propertyIndex, true, false);  
  }
  
  public void set(int propertyIndex, Object value) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public boolean isSet(int propertyIndex) {
    return eIsSet(propertyIndex);
  }

  public void unset(int propertyIndex) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public Object get(Property property) {
    Object ret = DataObjectUtil.get(this, ((EStructuralFeature)property).getFeatureID());
    return (ret != null) ? 
      ret : eGet((EStructuralFeature)property, true, false);
  }
  
  public void set(Property property, Object value) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public boolean isSet(Property property) {
    return eIsSet((EStructuralFeature)property);
  }

  public void unset(Property property) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public DataObject getContainer() {
    return (DataObject)eContainer();
  }

  public Property getContainmentProperty() {
    return (Property)eContainmentFeature();
  }

  public Type getType() {
    return (Type)ModelPackageImpl.eINSTANCE.getType();
  }
  
  // Remaining DataObject methods are (will be) implemented as straight delegation to DataObjectUtil

  public Object get(String path) {
    return DataObjectUtil.get(this, path);
  }
  
  public void set(String path, Object value) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public boolean isSet(String path) {
    return DataObjectUtil.isSet(this, path);
  }

  public void unset(String path) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public boolean getBoolean(String path) {
    return DataObjectUtil.getBoolean(get(path));
  }

  public byte getByte(String path) {
    return DataObjectUtil.getByte(get(path));
  }

  public char getChar(String path) {
    return DataObjectUtil.getChar(get(path));
  }

  public double getDouble(String path) {
    return DataObjectUtil.getDouble(get(path));
  }

  public float getFloat(String path) {
    return DataObjectUtil.getFloat(get(path));
  }

  public int getInt(String path) {
    return DataObjectUtil.getInt(get(path));
  }

  public long getLong(String path) {
    return DataObjectUtil.getLong(get(path));
  }

  public short getShort(String path) {
    return DataObjectUtil.getShort(get(path));
  }

  public byte[] getBytes(String path) {
    return DataObjectUtil.getBytes(get(path));
  }

  public BigDecimal getBigDecimal(String path) {
    return DataObjectUtil.getBigDecimal(get(path));
  }

  public BigInteger getBigInteger(String path) {
    return DataObjectUtil.getBigInteger(get(path));
  }

  public DataObject getDataObject(String path) {
    return (DataObject)get(path);
  }

  public Date getDate(String path) {
    return DataObjectUtil.getDate(get(path));
  }

  public String getString(String path) {
    return DataObjectUtil.getString(get(path));
  }

  public List getList(String path) {
    return (List)get(path);
  }

  public Sequence getSequence(String path) {
    return (Sequence)get(path);
  }

  public void setBoolean(String path, boolean value) {
    set(path, new Boolean(value));
  }

  public void setByte(String path, byte value) {
    set(path, new Byte(value));
  }

  public void setChar(String path, char value) {
    set(path, new Character(value));
  }

  public void setDouble(String path, double value) {
    set(path, new Double(value));
  }

  public void setFloat(String path, float value) {
    set(path, new Float(value));
  }

  public void setInt(String path, int value) {
    set(path, new Integer(value));
  }

  public void setLong(String path, long value) {
    set(path, new Long(value));
  }

  public void setShort(String path, short value) {
    set(path, new Short(value));
  }

  public void setBytes(String path, byte[] value) {
    set(path, value);
  }

  public void setBigDecimal(String path, BigDecimal value) {
    set(path, value);
  }

  public void setBigInteger(String path, BigInteger value) {
    set(path, value);
  }

  public void setDataObject(String path, DataObject value) {
    set(path, value);
  }

  public void setDate(String path, Date value) {
    set(path, value);
  }

  public void setString(String path, String value) {
    set(path, value);
  }

  public void setList(String path, List value) {
    set(path, value);
  }

  public boolean getBoolean(int propertyIndex) {
    return DataObjectUtil.getBoolean(this, propertyIndex);
  }

  public byte getByte(int propertyIndex) {
    return DataObjectUtil.getByte(this, propertyIndex);
  }

  public char getChar(int propertyIndex) {
    return DataObjectUtil.getChar(this, propertyIndex);
  }

  public double getDouble(int propertyIndex) {
    return DataObjectUtil.getDouble(this, propertyIndex);
  }

  public float getFloat(int propertyIndex) {
    return DataObjectUtil.getFloat(this, propertyIndex);
  }

  public int getInt(int propertyIndex) {
    return DataObjectUtil.getInt(this, propertyIndex);
  }

  public long getLong(int propertyIndex) {
    return DataObjectUtil.getLong(this, propertyIndex);
  }

  public short getShort(int propertyIndex) {
    return DataObjectUtil.getShort(this, propertyIndex);
  }

  public byte[] getBytes(int propertyIndex) {
    return DataObjectUtil.getBytes(this, propertyIndex);
  }

  public BigDecimal getBigDecimal(int propertyIndex) {
    return DataObjectUtil.getBigDecimal(this, propertyIndex);
  }

  public BigInteger getBigInteger(int propertyIndex) {
    return DataObjectUtil.getBigInteger(this, propertyIndex);
  }

  public DataObject getDataObject(int propertyIndex) {
    return DataObjectUtil.getDataObject(this, propertyIndex);
  }

  public Date getDate(int propertyIndex) {
    return DataObjectUtil.getDate(this, propertyIndex);
  }

  public String getString(int propertyIndex) {
    return DataObjectUtil.getString(this, propertyIndex);
  }

  public List getList(int propertyIndex) {
    return DataObjectUtil.getList(this, propertyIndex);
  }

  public Sequence getSequence(int propertyIndex) {
    return DataObjectUtil.getSequence(this, propertyIndex);
  }

  public void setBoolean(int propertyIndex, boolean value) {
    set(propertyIndex, new Boolean(value));
  }

  public void setByte(int propertyIndex, byte value) {
    set(propertyIndex, new Byte(value));
  }

  public void setChar(int propertyIndex, char value) {
    set(propertyIndex, new Character(value));
  }

  public void setDouble(int propertyIndex, double value) {
    set(propertyIndex, new Double(value));
  }

  public void setFloat(int propertyIndex, float value) {
    set(propertyIndex, new Float(value));
  }

  public void setInt(int propertyIndex, int value) {
    set(propertyIndex, new Integer(value));
  }

  public void setLong(int propertyIndex, long value) {
    set(propertyIndex, new Long(value));
  }

  public void setShort(int propertyIndex, short value) {
    set(propertyIndex, new Short(value));
  }

  public void setBytes(int propertyIndex, byte[] value) {
    set(propertyIndex, value);
  }

  public void setBigDecimal(int propertyIndex, BigDecimal value) {
    set(propertyIndex, value);
  }

  public void setBigInteger(int propertyIndex, BigInteger value) {
    set(propertyIndex, value);
  }

  public void setDataObject(int propertyIndex, DataObject value) {
    set(propertyIndex, value);
  }

  public void setDate(int propertyIndex, Date value) {
    set(propertyIndex, value);
  }

  public void setString(int propertyIndex, String value) {
    set(propertyIndex, value);
  }

  public void setList(int propertyIndex, List value) {
    set(propertyIndex, value);
  }

  public boolean getBoolean(Property property) {
    return DataObjectUtil.getBoolean(this, property);
  }

  public byte getByte(Property property) {
    return DataObjectUtil.getByte(this, property);
  }

  public char getChar(Property property) {
    return DataObjectUtil.getChar(this, property);
  }

  public double getDouble(Property property) {
    return DataObjectUtil.getDouble(this, property);
  }

  public float getFloat(Property property) {
    return DataObjectUtil.getFloat(this, property);
  }

  public int getInt(Property property) {
    return DataObjectUtil.getInt(this, property);
  }

  public long getLong(Property property) {
    return DataObjectUtil.getLong(this, property);
  }

  public short getShort(Property property) {
    return DataObjectUtil.getShort(this, property);
  }

  public byte[] getBytes(Property property) {
    return DataObjectUtil.getBytes(this, property);
  }

  public BigDecimal getBigDecimal(Property property) {
    return DataObjectUtil.getBigDecimal(this, property);
  }

  public BigInteger getBigInteger(Property property) {
    return DataObjectUtil.getBigInteger(this, property);
  }

  public DataObject getDataObject(Property property) {
    return DataObjectUtil.getDataObject(this, property);
  }

  public Date getDate(Property property) {
    return DataObjectUtil.getDate(this, property);
  }

  public String getString(Property property) {
    return DataObjectUtil.getString(this, property);
  }

  public List getList(Property property) {
    return DataObjectUtil.getList(this, property);
  }

  public Sequence getSequence(Property property) {
    return DataObjectUtil.getSequence(this, property);
  }

  public void setBoolean(Property property, boolean value) {
    set(property, new Boolean(value));
  }

  public void setByte(Property property, byte value) {
    set(property, new Byte(value));
  }

  public void setChar(Property property, char value) {
    set(property, new Character(value));
  }

  public void setDouble(Property property, double value) {
    set(property, new Double(value));
  }

  public void setFloat(Property property, float value) {
    set(property, new Float(value));
  }

  public void setInt(Property property, int value) {
    set(property, new Integer(value));
  }

  public void setLong(Property property, long value) {
    set(property, new Long(value));
  }

  public void setShort(Property property, short value) {
    set(property, new Short(value));
  }

  public void setBytes(Property property, byte[] value) {
    set(property, value);
  }

  public void setBigDecimal(Property property, BigDecimal value) {
    set(property, value);
  }

  public void setBigInteger(Property property, BigInteger value) {
    set(property, value);
  }

  public void setDataObject(Property property, DataObject value) {
    set(property, value);
  }

  public void setDate(Property property, Date value) {
    set(property, value);
  }

  public void setString(Property property, String value) {
    set(property, value);
  }

  public void setList(Property property, List value) {
    set(property, value);
  }

  public DataObject createDataObject(String propertyName) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public DataObject createDataObject(int propertyIndex) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public DataObject createDataObject(Property property) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public DataObject createDataObject(String propertyName, String namespaceURI, String typeName) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public DataObject createDataObject(int propertyIndex, String namespaceURI, String typeName) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public DataObject createDataObject(Property property, Type type) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public void delete() {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public DataGraph getDataGraph() {
    return DataObjectUtil.getDataGraph(this);
  }

  public Sequence getSequence() {
    EAttribute mixedFeature = BasicExtendedMetaData.INSTANCE.getMixedFeature(eClass());
    return mixedFeature != null ? (Sequence)eGet(mixedFeature, true, false) : null;
  }

  public List getInstanceProperties() {
    return DataObjectUtil.getInstanceProperties(this);
  }

  public DataObject getRootObject() {
    return DataObjectUtil.getRootObject(this);
  }

  public ChangeSummary getChangeSummary() {
    // TODO: implement this method
    throw new UnsupportedOperationException();
  }

  public void detach() {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }
  */
  
} //DataTypeImpl
