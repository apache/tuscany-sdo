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
package org.apache.tuscany.sdo.util;


import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.tuscany.sdo.SDOExtendedMetaData;
import org.apache.tuscany.sdo.impl.DataGraphImpl;
import org.apache.tuscany.sdo.impl.SDOFactoryImpl;
import org.apache.tuscany.sdo.model.impl.ModelPackageImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xmi.impl.EMOFResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.ecore.xml.type.internal.XMLCalendar;
import org.eclipse.xsd.util.XSDResourceFactoryImpl;

import commonj.sdo.ChangeSummary;
import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.Type;
import commonj.sdo.helper.TypeHelper;


public final class DataObjectUtil
{
  public static Object get(org.apache.tuscany.sdo.model.Type type, int propertyIndex) {
    switch (propertyIndex)
    {
      case ModelPackageImpl.TYPE__BASE_TYPE:
        return type.getBaseType();
      case ModelPackageImpl.TYPE__PROPERTY:
        return type.getProperty();
      case ModelPackageImpl.TYPE__ALIAS_NAME:
        return type.getAliasName();
      case ModelPackageImpl.TYPE__ANY:
        return type.getAny();
      case ModelPackageImpl.TYPE__ABSTRACT:
        return type.isAbstract() ? Boolean.TRUE : Boolean.FALSE;
      case ModelPackageImpl.TYPE__DATA_TYPE:
        return type.isDataType() ? Boolean.TRUE : Boolean.FALSE;
      case ModelPackageImpl.TYPE__NAME:
        return type.getName();
      case ModelPackageImpl.TYPE__OPEN:
        return type.isOpen() ? Boolean.TRUE : Boolean.FALSE;
      case ModelPackageImpl.TYPE__SEQUENCED:
        return type.isSequenced() ? Boolean.TRUE : Boolean.FALSE;
      case ModelPackageImpl.TYPE__URI:
        return type.getUri();
      case ModelPackageImpl.TYPE__ANY_ATTRIBUTE:
        return type.getAnyAttribute();
    }
    return null;
  }
  
  public static boolean isSet(org.apache.tuscany.sdo.model.Type type, int propertyIndex) {
    //FB Note that this implementation has the undesirable effect of invoking lazy creation of feature lists
    switch (propertyIndex)
    {
      case ModelPackageImpl.TYPE__BASE_TYPE:
        return !type.getBaseType().isEmpty();
      case ModelPackageImpl.TYPE__PROPERTY:
        return !type.getProperty().isEmpty();
      case ModelPackageImpl.TYPE__ALIAS_NAME:
        return !type.getAliasName().isEmpty();
      case ModelPackageImpl.TYPE__ANY:
        return false;
      case ModelPackageImpl.TYPE__ABSTRACT:
        return type.isSetAbstract();
      case ModelPackageImpl.TYPE__DATA_TYPE:
        return type.isSetDataType();
      case ModelPackageImpl.TYPE__NAME:
        return type.getName() != null;
      case ModelPackageImpl.TYPE__OPEN:
        return type.isSetOpen();
      case ModelPackageImpl.TYPE__SEQUENCED:
        return type.isSetSequenced();
      case ModelPackageImpl.TYPE__URI:
        return type.getUri() != null;
      case ModelPackageImpl.TYPE__ANY_ATTRIBUTE:
        return false;
    }
    return false;
  }
  
  public static Object writeReplace(DataObject dataObject) throws ObjectStreamException
  {
    DataGraph dataGraph = dataObject.getDataGraph();
    if (dataGraph != null)
    {
      return ((DataGraphImpl)dataGraph).getWriteReplacement((EObject)dataObject);
    }
    else
    {
      throw new InvalidObjectException("The object must be in a datagraph to be serialized " + dataObject);
    }
  }
  
  public static void setString(DataObject dataObject, Property property, String value) {
    dataObject.set(property, getSetValue(property, value));
  }
  
  public static void setShort(DataObject dataObject, Property property, short value) {
    dataObject.set(property, getSetValue(property, value));
  }
  
  public static void setLong(DataObject dataObject, Property property, long value) {
    dataObject.set(property, getSetValue(property, value));
  }
  
  public static void setList(DataObject dataObject, Property property, List value) {
    dataObject.set(property, value);
  }
  
  public static void setInt(DataObject dataObject, Property property, int value) {
    dataObject.set(property, getSetValue(property, value));
  }
  
  public static void setFloat(DataObject dataObject, Property property, float value) {
    dataObject.set(property, getSetValue(property, value));
  }
 
  public static void setDouble(DataObject dataObject, Property property, double value) {
    dataObject.set(property, getSetValue(property, value));
  }
  
  public static void setDate(DataObject dataObject, Property property, Date value) {
    dataObject.set(property, getSetValue(property, value));
  }
  
  public static void setDataObject(DataObject dataObject, Property property, DataObject value) {
    dataObject.set(property, value);
  }
  
  public static void setChar(DataObject dataObject, Property property, char value) {
    dataObject.set(property, getSetValue(property, value));
  }
  
  public static void setBytes(DataObject dataObject, Property property, byte[] value) {
    dataObject.set(property, getSetValue(property, value));
  }
  
  public static void setByte(DataObject dataObject, Property property, byte value) {
    dataObject.set(property, getSetValue(property, value));
  }
  
  public static void setBoolean(DataObject dataObject, Property property, boolean value) {
    dataObject.set(property, getSetValue(property, value));
  }
  
  public static void setBigInteger(DataObject dataObject, Property property, BigInteger value)
  {
    dataObject.set(property, getSetValue(property, value));
  }
  
  public static void setBigDecimal(DataObject dataObject, Property property, BigDecimal value)
  {
    dataObject.set(property, getSetValue(property, value));
  }
   
  public static String getString(DataObject dataObject, Property property)
  {
    return getString(dataObject.get(property));
  }
  
  public static short getShort(DataObject dataObject, Property property)
  {
    return getShort(dataObject.get(property));
  }
  
  public static Sequence getSequence(DataObject dataObject, Property property)
  {
    return (Sequence)dataObject.get(property);
  }
  
  public static long getLong(DataObject dataObject, Property property)
  {
    return getLong(dataObject.get(property));
  }
  
  public static List getList(DataObject dataObject, Property property)
  {
    return (List)dataObject.get(property);
  }
  
  public static int getInt(DataObject dataObject, Property property)
  {
    return getInt(dataObject.get(property));
  }
  
  public static float getFloat(DataObject dataObject, Property property)
  {
    return getFloat(dataObject.get(property));
  }
  
  public static double getDouble(DataObject dataObject, Property property)
  {
    return getDouble(dataObject.get(property));
  }
  
  public static Date getDate(DataObject dataObject, Property property)
  {
    return getDate(dataObject.get(property));
  }
  
  public static DataObject getDataObject(DataObject dataObject, Property property)
  {
    return (DataObject)dataObject.get(property);
  }
  
  public static char getChar(DataObject dataObject, Property property)
  {
    return getChar(dataObject.get(property));
  }
  
  public static byte[] getBytes(DataObject dataObject, Property property)
  {
    return getBytes(dataObject.get(property));
  }
  
  public static byte getByte(DataObject dataObject, Property property)
  {
    return getByte(dataObject.get(property));
  }
  
  public static boolean getBoolean(DataObject dataObject, Property property)
  {
    return getBoolean(dataObject.get(property));
  }
  
  public static BigInteger getBigInteger(DataObject dataObject, Property property)
  {
    return getBigInteger(dataObject.get(property));
  }
  
  public static BigDecimal getBigDecimal(DataObject dataObject, Property property)
  {
    return getBigDecimal(dataObject.get(property));
  }
  

  
  private static Property getPropertyByIndex(DataObject dataObject, int propertyIndex) {
    EObject eObject = (EObject) dataObject;
    Property property = (Property)eObject.eClass().getEStructuralFeature(propertyIndex);
    return property;
  }

  public static void setString(DataObject dataObject, int propertyIndex, String value) {
    dataObject.set(propertyIndex, getSetValue(getPropertyByIndex(dataObject, propertyIndex), value));
  }
  
  public static void setShort(DataObject dataObject, int propertyIndex, short value) {
    dataObject.set(propertyIndex, getSetValue(getPropertyByIndex(dataObject, propertyIndex), value));
  }
  
  public static void setLong(DataObject dataObject, int propertyIndex, long value) {
    dataObject.set(propertyIndex, getSetValue(getPropertyByIndex(dataObject, propertyIndex), value));
  }
  
  public static void setList(DataObject dataObject, int propertyIndex, List value) {
    dataObject.set(propertyIndex, value);
  }
  
  public static void setInt(DataObject dataObject, int propertyIndex, int value) {
    dataObject.set(propertyIndex, getSetValue(getPropertyByIndex(dataObject, propertyIndex), value));
  }
  
  public static void setFloat(DataObject dataObject, int propertyIndex, float value) {
    dataObject.set(propertyIndex, getSetValue(getPropertyByIndex(dataObject, propertyIndex), value));
  }
 
  public static void setDouble(DataObject dataObject, int propertyIndex, double value) {
    dataObject.set(propertyIndex, getSetValue(getPropertyByIndex(dataObject, propertyIndex), value));
  }
  
  public static void setDate(DataObject dataObject, int propertyIndex, Date value) {
    dataObject.set(propertyIndex, getSetValue(getPropertyByIndex(dataObject, propertyIndex), value));
  }
  
  public static void setDataObject(DataObject dataObject, int propertyIndex, DataObject value) {
    dataObject.set(propertyIndex, value);
  }
  
  public static void setChar(DataObject dataObject, int propertyIndex, char value) {
    dataObject.set(propertyIndex, getSetValue(getPropertyByIndex(dataObject, propertyIndex), value));
  }
  
  public static void setBytes(DataObject dataObject, int propertyIndex, byte[] value) {
    dataObject.set(propertyIndex, getSetValue(getPropertyByIndex(dataObject, propertyIndex), value));
  }
  
  public static void setByte(DataObject dataObject, int propertyIndex, byte value) {
    dataObject.set(propertyIndex, getSetValue(getPropertyByIndex(dataObject, propertyIndex), value));
  }
  
  public static void setBoolean(DataObject dataObject, int propertyIndex, boolean value) {
    dataObject.set(propertyIndex, getSetValue(getPropertyByIndex(dataObject, propertyIndex), value));
  }
  
  public static void setBigInteger(DataObject dataObject, int propertyIndex, BigInteger value)
  {
    dataObject.set(propertyIndex, getSetValue(getPropertyByIndex(dataObject, propertyIndex), value));
  }
  
  public static void setBigDecimal(DataObject dataObject, int propertyIndex, BigDecimal value)
  {
    dataObject.set(propertyIndex, getSetValue(getPropertyByIndex(dataObject, propertyIndex), value));
  }
  
  public static String getString(DataObject dataObject, int propertyIndex)
  {
    return getString(dataObject.get(propertyIndex));
  }
  
  public static short getShort(DataObject dataObject, int propertyIndex)
  {
    return getShort(dataObject.get(propertyIndex));
  }
  
  public static Sequence getSequence(DataObject dataObject, int propertyIndex)
  {
    return (Sequence)dataObject.get(propertyIndex);
  }
  
  public static long getLong(DataObject dataObject, int propertyIndex)
  {
    return getLong(dataObject.get(propertyIndex));
  }
  
  public static List getList(DataObject dataObject, int propertyIndex)
  {
    return (List)dataObject.get(propertyIndex);
  }
  
  public static int getInt(DataObject dataObject, int propertyIndex)
  {
    return getInt(dataObject.get(propertyIndex));
  }
  
  public static float getFloat(DataObject dataObject, int propertyIndex)
  {
    return getFloat(dataObject.get(propertyIndex));
  }
  
  public static double getDouble(DataObject dataObject, int propertyIndex)
  {
    return getDouble(dataObject.get(propertyIndex));
  }
  
  public static Date getDate(DataObject dataObject, int propertyIndex)
  {
    return getDate(dataObject.get(propertyIndex));
  }
  
  public static DataObject getDataObject(DataObject dataObject, int propertyIndex)
  {
    return (DataObject)dataObject.get(propertyIndex);
  }
  
  public static char getChar(DataObject dataObject, int propertyIndex)
  {
    return getChar(dataObject.get(propertyIndex));
  }
  
  public static byte[] getBytes(DataObject dataObject, int propertyIndex)
  {
    return getBytes(dataObject.get(propertyIndex));
  }
  
  public static byte getByte(DataObject dataObject, int propertyIndex)
  {
    return getByte(dataObject.get(propertyIndex));
  }
  
  public static boolean getBoolean(DataObject dataObject, int propertyIndex)
  {
    return getBoolean(dataObject.get(propertyIndex));
  }
  
  public static BigInteger getBigInteger(DataObject dataObject, int propertyIndex)
  {
    return getBigInteger(dataObject.get(propertyIndex));
  }
  
  public static BigDecimal getBigDecimal(DataObject dataObject, int propertyIndex)
  {
    return getBigDecimal(dataObject.get(propertyIndex));
  }
  
  public static void detach(DataObject dataObject) {
    EcoreUtil.remove((EObject)dataObject);
  }
  
  public static DataObject getRootObject(DataObject dataObject)
  {
    return (DataObject)EcoreUtil.getRootContainer((EObject)dataObject);
  }
  
  public static List getInstanceProperties(DataObject dataObject)
  {
    //TODO maybe optimize this to just return type.getProperties if type.isOpen (isOpen would need to be cached)
    EObject eDataObject = (EObject) dataObject;
    List result = new UniqueEList(eDataObject.eClass().getEAllStructuralFeatures());
    for (int i = 0, count = result.size(); i < count; ++i)
    {
      EStructuralFeature eStructuralFeature = (EStructuralFeature)result.get(i);
      if (!eStructuralFeature.isDerived() && FeatureMapUtil.isFeatureMap(eStructuralFeature))
      {
        List features = (List)eDataObject.eGet(eStructuralFeature);
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
  
  public static void delete(DataObject dataObject)
  {
    EObject eDataObject = (EObject)dataObject;
    EcoreUtil.remove(eDataObject);
    List contents = new ArrayList((eDataObject).eContents());
    for (int i = 0, size = contents.size(); i < size; ++i)
    {
      ((DataObject)contents.get(i)).delete();
    }
    EClass eClass = eDataObject.eClass();
    for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i)
    {
      EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(i);
      if (eStructuralFeature.isChangeable() && !eStructuralFeature.isDerived() && !((Property)eStructuralFeature).isReadOnly())
      {
        eDataObject.eUnset(eStructuralFeature);
      }
    }
  }
  
  public static DataObject createDataObject(DataObject dataObject, Property property, Type type)
  {
    if (!property.isContainment())
    {
      throw new IllegalArgumentException("The property '" + property.getName() + "' of '" + property.getContainingType().getName()
        + "' isn't a containment");
    }
    DataObject result = DataObjectUtil.create(type);
    if (FeatureMapUtil.isMany((EObject)dataObject, (EStructuralFeature)property))
    {
      ((List)dataObject.get(property)).add(result);
    }
    else
    {
      dataObject.set(property, result);
    }
    return result;
  }
  
  public static DataObject createDataObject(DataObject dataObject, int propertyIndex, String namespaceURI, String typeName)
  {
    Property property = DataObjectUtil.getProperty(dataObject, propertyIndex);
    Type type = DataObjectUtil.getType(dataObject, namespaceURI, typeName);
    return createDataObject(dataObject, property, type);
  }
  
  public static DataObject createDataObject(DataObject dataObject, String propertyName, String namespaceURI, String typeName)
  {
    Property property = getProperty(dataObject, propertyName);
    Type type = DataObjectUtil.getType(dataObject, namespaceURI, typeName);
    return createDataObject(dataObject, property, type);
  }
  
  public static DataObject createDataObject(DataObject dataObject, Property property)
  {
    Type type = property.getType();
    return createDataObject(dataObject, property, type);
  }
  
  public static DataObject createDataObject(DataObject dataObject, int propertyIndex)
  {
    Property property = getProperty(dataObject, propertyIndex);
    Type type = property.getType();
    return createDataObject(dataObject,property, type);
  }

  public static DataObject createDataObject(DataObject dataObject, String propertyName)
  {
    Property property = (Property)getProperty(dataObject, propertyName);
    Type type = property.getType();
    return createDataObject(dataObject,property, type);
  }
  
  public static void setString(DataObject dataObject, String path, String value)
  {
    Property property = dataObject.getType().getProperty(path);
    if (property != null)
    {
      dataObject.set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create((EObject)dataObject, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }

  
  public static void setShort(DataObject dataObject, String path, short value)
  {
    Property property = dataObject.getType().getProperty(path);
    if (property != null)
    {
      dataObject.set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create((EObject)dataObject, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }
  
  public static void setLong(DataObject dataObject, String path, long value)
  {
    Property property = dataObject.getType().getProperty(path);
    if (property != null)
    {
      dataObject.set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create((EObject)dataObject, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }
  
  public static void setList(DataObject dataObject, String path, List value)
  {
    dataObject.set(path, value);
  }
  
  public static void setInt(DataObject dataObject, String path, int value)
  {
    Property property = dataObject.getType().getProperty(path);
    if (property != null)
    {
      dataObject.set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create((EObject)dataObject, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }
  
  public static void setFloat(DataObject dataObject, String path, float value)
  {
    Property property = dataObject.getType().getProperty(path);
    if (property != null)
    {
      dataObject.set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create((EObject)dataObject, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }
  
  public static void setDouble(DataObject dataObject, String path, double value)
  {
    Property property = dataObject.getType().getProperty(path);
    if (property != null)
    {
      dataObject.set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create((EObject)dataObject, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }  
  
  public static void setDate(DataObject dataObject, String path, Date value)
  {
    Property property = dataObject.getType().getProperty(path);
    if (property != null)
    {
      dataObject.set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create((EObject)dataObject, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }
  
  public static void setDataObject(DataObject dataObject, String path, DataObject value)
  {
    dataObject.set(path, value);
  }
  
  public static void setChar(DataObject dataObject, String path, char value)
  {
    Property property = dataObject.getType().getProperty(path);
    if (property != null)
    {
      dataObject.set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create((EObject)dataObject, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }
  
  public static void setBytes(DataObject dataObject, String path, byte[] value)
  {
    Property property = dataObject.getType().getProperty(path);
    if (property != null)
    {
      dataObject.set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create((EObject)dataObject, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }
  
  public static void setByte(DataObject dataObject, String path, byte value)
  {
    Property property = dataObject.getType().getProperty(path);
    if (property != null)
    {
      dataObject.set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create((EObject)dataObject, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }
  
  public static void setBoolean(DataObject dataObject, String path, boolean value)
  {
    Property property = dataObject.getType().getProperty(path);
    if (property != null)
    {
      dataObject.set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create((EObject)dataObject, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }
  
  public static void setBigInteger(DataObject dataObject, String path, BigInteger value)
  {
    Property property = dataObject.getType().getProperty(path);
    if (property != null)
    {
      dataObject.set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create((EObject)dataObject, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }
  
  public static void setBigDecimal(DataObject dataObject, String path, BigDecimal value)
  {
    Property property = dataObject.getType().getProperty(path);
    if (property != null)
    {
      dataObject.set(property, DataObjectUtil.getSetValue(property, value));
    }
    else
    {
      DataObjectUtil.Accessor accessor = DataObjectUtil.Accessor.create((EObject)dataObject, path);
      accessor.setAndRecyle(DataObjectUtil.getSetValue(accessor.getProperty(), value));
    }
  }
  
  public static DataGraph getDataGraph(DataObject dataObject)
  {
    Resource resource = ((EObject)dataObject).eResource();
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
  
  public static ChangeSummary getChangeSummary(DataObject dataObject)
  {
    DataGraph dataGraph = getDataGraph(dataObject);
    if (dataGraph != null)
    {
      return dataGraph.getChangeSummary();
    }
    // TODO: handle ChangeSummary-type property
    return null;
  }
  
  public static void unset(DataObject dataObject, String path)
  {
    Property property = dataObject.getType().getProperty(path);
    if (property != null)
    {
      dataObject.unset(property);
    }
    else
    {
      DataObjectUtil.Accessor.create((EObject)dataObject, path).unsetAndRecyle();
    }
  }
  
  public static boolean isSet(DataObject dataObject, String path)
  {
    Property property = dataObject.getType().getProperty(path);
    if (property != null)
    {
      return dataObject.isSet(property);
    }
    else
    {
      return DataObjectUtil.Accessor.create(
        (EObject)dataObject, path).isSetAndRecyle();
    }
  }  
  
  public static void set(DataObject dataObject, String path, Object value) 
  {
    Property property = dataObject.getType().getProperty(path);
    if (property != null)
    {
      dataObject.set(property, value);
    } 
    else 
    {
      DataObjectUtil.Accessor.create(
        (EObject)dataObject, path).setAndRecyle(value);
    }
  }
  
  public static Object get(DataObject dataObject, String path) 
  {
    Property property = dataObject.getType().getProperty(path);
    if (property != null) {
      return dataObject.get(property);
    } else {
      return Accessor.create((EObject)dataObject, path).getAndRecyle();
    }
  }
  
  public static BigDecimal getBigDecimal(Object value)
  {
    if (value instanceof BigDecimal)
    {
      return (BigDecimal)value;
    }

    if (value instanceof BigInteger)
    {
      return new BigDecimal((BigInteger)value);
    }

    if (value instanceof Number)
    {
      return new BigDecimal(((Number)value).doubleValue());
    }

    if (value instanceof String)
    {
      return new BigDecimal((String)value);
    }

    if (value == null)
    {
      return null;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to BigDecimal");
  }

  public static Object getSetValue(Property property, BigDecimal value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    EClassifier eType = eStructuralFeature.getEType();
    if (value == null)
    {
      return eType.getDefaultValue();
    }

    String name = eType.getInstanceClassName();
    if (name == "java.math.BigDecimal")
    {
      return value;
    }

    if (name == "java.math.BigInteger")
    {
      return value.toBigInteger();
    }

    if (name == "java.lang.Byte" || name == "byte")
    {
      return new Byte(value.byteValue());
    }

    if (name == "java.lang.Double" || name == "double")
    {
      return new Double(value.doubleValue());
    }

    if (name == "java.lang.Float" || name == "float")
    {
      return new Float(value.floatValue());
    }

    if (name == "java.lang.Integer" || name == "int")
    {
      return new Integer(value.intValue());
    }

    if (name == "java.lang.Long" || name == "long")
    {
      return new Long(value.longValue());
    }

    if (name == "java.lang.Short" || name == "short")
    {
      return new Short(value.shortValue());
    }

    if (name == "java.lang.String")
    {
      return String.valueOf(value);
    }

    //Instead of throwing an IllegalArgumentException we will pass the value to the property
    return value;
  }

  public static BigInteger getBigInteger(Object value)
  {
    if (value instanceof BigInteger)
    {
      return (BigInteger)value;
    }

    if (value instanceof BigDecimal)
    {
      return ((BigDecimal)value).toBigInteger();
    }

    if (value instanceof Number)
    {
      return BigInteger.valueOf(((Number)value).longValue());
    }

    if (value instanceof String)
    {
      return new BigInteger((String)value);
    }

    if (value instanceof byte[])
    {
      return new BigInteger((byte[])value);
    }

    if (value == null)
    {
      return null;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to BigInteger");
  }

  public static Object getSetValue(Property property, BigInteger value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    EClassifier eType = eStructuralFeature.getEType();
    if (value == null)
    {
      return eType.getDefaultValue();
    }

    String name = eType.getInstanceClassName();
    if (name == "java.math.BigInteger")
    {
      return value;
    }

    if (name == "java.math.BigDecimal")
    {
      return new BigDecimal(value);
    }

    if (name == "java.lang.Byte" || name == "byte")
    {
      return new Byte(value.byteValue());
    }

    if (name == "java.lang.Double" || name == "double")
    {
      return new Double(value.doubleValue());
    }

    if (name == "java.lang.Float" || name == "float")
    {
      return new Float(value.floatValue());
    }

    if (name == "java.lang.Integer" || name == "int")
    {
      return new Integer(value.intValue());
    }

    if (name == "java.lang.Long" || name == "long")
    {
      return new Long(value.longValue());
    }

    if (name == "java.lang.Short" || name == "short")
    {
      return new Short(value.shortValue());
    }

    if (name == "java.lang.String")
    {
      return String.valueOf(value);
    }

    if (name == "byte[]")
    {
      return value.toByteArray();
    }

    //Instead of throwing an IllegalArgumentException we will pass the value to the property
    return value;
  }

  public static boolean getBoolean(Object value)
  {
    if (value instanceof Boolean)
    {
      return ((Boolean)value).booleanValue();
    }

    if (value instanceof String)
    {
      return Boolean.valueOf((String)value).booleanValue();
    }

    if (value == null)
    {
      return false;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to boolean");
  }

  public static Object getSetValue(Property property, boolean value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    String name = eStructuralFeature.getEType().getInstanceClassName();
    if (name == "java.lang.Boolean" || name == "boolean")
    {
      return value ? Boolean.TRUE : Boolean.FALSE;
    }

    if (name == "java.lang.String")
    {
      return String.valueOf(value);
    }

    //Instead of throwing an IllegalArgumentException we will pass the value to the property
    return value ? Boolean.TRUE : Boolean.FALSE;
  }

  public static byte getByte(Object value)
  {
    if (value instanceof Number)
    {
      return ((Number)value).byteValue();
    }

    if (value instanceof String)
    {
      return Byte.parseByte((String)value);
    }

    if (value == null)
    {
      return 0;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to byte");
  }

  public static Object getSetValue(Property property, byte value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    String name = eStructuralFeature.getEType().getInstanceClassName();
    if (name == "java.lang.Byte" || name == "byte")
    {
      return new Byte(value);
    }

    if (name == "java.lang.Double" || name == "double")
    {
      return new Double(value);
    }

    if (name == "java.lang.Float" || name == "float")
    {
      return new Float(value);
    }

    if (name == "java.lang.Integer" || name == "int")
    {
      return new Integer(value);
    }

    if (name == "java.lang.Long" || name == "long")
    {
      return new Long(value);
    }

    if (name == "java.lang.Short" || name == "short")
    {
      return new Short(value);
    }

    if (name == "java.math.BigDecimal")
    {
      return getBigDecimal(new Byte(value));
    }

    if (name == "java.math.BigInteger")
    {
      return getBigInteger(new Byte(value));
    }

    if (name == "java.lang.String")
    {
      return String.valueOf(value);
    }

    //Instead of throwing an IllegalArgumentException we will pass the value to the property
    return new Byte(value);
  }

  public static byte[] getBytes(Object value)
  {
    if (value instanceof byte[])
    {
      return (byte[])value;
    }

    if (value instanceof BigInteger)
    {
      return ((BigInteger)value).toByteArray();
    }

    if (value == null)
    {
      return null;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to byte array");
  }

  public static Object getSetValue(Property property, byte[] value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    EClassifier eType = eStructuralFeature.getEType();
    if (value == null)
    {
      return eType.getDefaultValue();
    }

    String name = eType.getInstanceClassName();
    if (name == "byte[]")
    {
      return value;
    }

    if (name == "java.math.BigInteger")
    {
      return new BigInteger(value);
    }

    //Instead of throwing an IllegalArgumentException we will pass the value to the property
    return value;
  }

  public static char getChar(Object value)
  {
    if (value instanceof Character)
    {
      return ((Character)value).charValue();
    }

    if (value instanceof String)
    {
      return ((String)value).charAt(0);
    }

    if (value == null)
    {
      return 0;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to char");
  }

  public static Object getSetValue(Property property, char value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    String name = eStructuralFeature.getEType().getInstanceClassName();
    if (name == "java.lang.Character" || name == "char")
    {
      return new Character(value);
    }

    if (name == "java.lang.String")
    {
      return String.valueOf(value);
    }

    //Instead of throwing an IllegalArgumentException we will pass the value to the property
    return new Character(value);
  }

  public static Date getDate(Object value)
  {
    if (value instanceof XMLCalendar)
    {
      return ((XMLCalendar)value).getDate();
    }

    if (value instanceof Date)
    {
      return (Date)value;
    }

    if (value instanceof Long)
    {
      return new Date(((Long)value).longValue());
    }

    if (value == null)
    {
      return null;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to Date");
  }

  public static Object getSetValue(Property property, Date value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    EClassifier eType = eStructuralFeature.getEType();
    if (value == null)
    {
      return eType.getDefaultValue();
    }

    String name = eType.getInstanceClassName();
    if (name == "java.lang.Object")
    {
      String typeName = getDateTypeName((EDataType)eType);
      if ("Date".equals(typeName))
      {
        return new XMLCalendar(value, XMLCalendar.DATE);
      }
      if ("DateTime".equals(typeName))
      {
        return new XMLCalendar(value, XMLCalendar.DATETIME);
      }
      // Instead of throwing an IllegalArgumentException we will pass the value to the property
      return value;
    }

    if (name == "java.lang.Long" || name == "long")
    {
      return new Long(value.getTime());
    }
    if (name == "java.lang.String")
    {
      return value.toString();
    }

    // Instead of throwing an IllegalArgumentException we will pass the value to the property
    return value;
  }

  protected static String getDateTypeName(EDataType eDataType)
  {
    String name = eDataType.getName();
    if (("DateTime".equals(name)) || ("Date".equals(name)))
    {
      return name;
    }

    EDataType baseType = ExtendedMetaData.INSTANCE.getBaseType(eDataType);
    if (baseType != null)
    {
      return getDateTypeName(baseType);
    }

    List memberTypes = ExtendedMetaData.INSTANCE.getMemberTypes(eDataType);
    if (!memberTypes.isEmpty())
    {
      for (int i = 0, size = memberTypes.size(); i < size; ++i)
      {
        EDataType memberType = (EDataType)memberTypes.get(i);
        String memberTypeName = getDateTypeName(memberType);
        if (("DateTime".equals(memberTypeName)) || ("Date".equals(memberTypeName)))
        {
          return memberTypeName;
        }
      }
    }

    return "";
  }

  public static double getDouble(Object value)
  {
    if (value instanceof Number)
    {
      return ((Number)value).doubleValue();
    }

    if (value instanceof String)
    {
      return Double.parseDouble((String)value);
    }

    if (value == null)
    {
      return 0;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to double");
  }

  public static Object getSetValue(Property property, double value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    String name = eStructuralFeature.getEType().getInstanceClassName();
    if (name == "java.lang.Byte" || name == "byte")
    {
      return new Byte((byte)value);
    }

    if (name == "java.lang.Double" || name == "double")
    {
      return new Double(value);
    }

    if (name == "java.lang.Float" || name == "float")
    {
      return new Float(value);
    }

    if (name == "java.lang.Integer" || name == "int")
    {
      return new Integer((int)value);
    }

    if (name == "java.lang.Long" || name == "long")
    {
      return new Long((long)value);
    }

    if (name == "java.lang.Short" || name == "short")
    {
      return new Short((short)value);
    }

    if (name == "java.math.BigDecimal")
    {
      return getBigDecimal(new Double(value));
    }

    if (name == "java.math.BigInteger")
    {
      return getBigInteger(new Double(value));
    }

    if (name == "java.lang.String")
    {
      return String.valueOf(value);
    }

    //Instead of throwing an IllegalArgumentException we will pass the value to the property
    return new Double(value);
  }

  public static float getFloat(Object value)
  {
    if (value instanceof Number)
    {
      return ((Number)value).floatValue();
    }

    if (value instanceof String)
    {
      return Float.parseFloat((String)value);
    }

    if (value == null)
    {
      return 0;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to float");
  }

  public static Object getSetValue(Property property, float value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    String name = eStructuralFeature.getEType().getInstanceClassName();
    if (name == "java.lang.Byte" || name == "byte")
    {
      return new Byte((byte)value);
    }

    if (name == "java.lang.Double" || name == "double")
    {
      return new Double(value);
    }

    if (name == "java.lang.Float" || name == "float")
    {
      return new Float(value);
    }

    if (name == "java.lang.Integer" || name == "int")
    {
      return new Integer((int)value);
    }

    if (name == "java.lang.Long" || name == "long")
    {
      return new Long((long)value);
    }

    if (name == "java.lang.Short" || name == "short")
    {
      return new Short((short)value);
    }

    if (name == "java.math.BigDecimal")
    {
      return getBigDecimal(new Float(value));
    }

    if (name == "java.math.BigInteger")
    {
      return getBigInteger(new Float(value));
    }

    if (name == "java.lang.String")
    {
      return String.valueOf(value);
    }

    // Instead of throwing an IllegalArgumentException we will pass the value to the property
    return new Float(value);
  }

  public static int getInt(Object value)
  {
    if (value instanceof Number)
    {
      return ((Number)value).intValue();
    }

    if (value instanceof String)
    {
      return Integer.parseInt((String)value);
    }

    if (value == null)
    {
      return 0;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to int");
  }

  public static Object getSetValue(Property property, int value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    String name = eStructuralFeature.getEType().getInstanceClassName();
    if (name == "java.lang.Byte" || name == "byte")
    {
      return new Byte((byte)value);
    }

    if (name == "java.lang.Double" || name == "double")
    {
      return new Double(value);
    }

    if (name == "java.lang.Float" || name == "float")
    {
      return new Float(value);
    }

    if (name == "java.lang.Integer" || name == "int")
    {
      return new Integer(value);
    }

    if (name == "java.lang.Long" || name == "long")
    {
      return new Long(value);
    }

    if (name == "java.lang.Short" || name == "short")
    {
      return new Short((short)value);
    }

    if (name == "java.math.BigDecimal")
    {
      return getBigDecimal(new Integer(value));
    }

    if (name == "java.math.BigInteger")
    {
      return getBigInteger(new Integer(value));
    }

    if (name == "java.lang.String")
    {
      return String.valueOf(value);
    }

    // Instead of throwing an IllegalArgumentException we will pass the value to the property
    return new Integer(value);
  }

  public static long getLong(Object value)
  {
    if (value instanceof Number)
    {
      return ((Number)value).longValue();
    }

    if (value instanceof String)
    {
      return Long.parseLong((String)value);
    }

    if (value instanceof Date)
    {
      return ((Date)value).getTime();
    }

    if (value == null)
    {
      return 0;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to long");
  }

  public static Object getSetValue(Property property, long value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    String name = eStructuralFeature.getEType().getInstanceClassName();
    if (name == "java.lang.Byte" || name == "byte")
    {
      return new Byte((byte)value);
    }

    if (name == "java.lang.Double" || name == "double")
    {
      return new Double(value);
    }

    if (name == "java.lang.Float" || name == "float")
    {
      return new Float(value);
    }

    if (name == "java.lang.Integer" || name == "int")
    {
      return new Integer((int)value);
    }

    if (name == "java.lang.Long" || name == "long")
    {
      return new Long(value);
    }

    if (name == "java.lang.Short" || name == "short")
    {
      return new Short((short)value);
    }

    if (name == "java.math.BigDecimal")
    {
      return getBigDecimal(new Long(value));
    }

    if (name == "java.math.BigInteger")
    {
      return getBigInteger(new Long(value));
    }

    if (name == "java.lang.String")
    {
      return String.valueOf(value);
    }

    if (name == "java.util.Date")
    {
      return new Date(value);
    }

    // Instead of throwing an IllegalArgumentException we will pass the value to the property
    return new Long(value);
  }

  public static short getShort(Object value)
  {
    if (value instanceof Number)
    {
      return ((Number)value).shortValue();
    }

    if (value instanceof String)
    {
      return Short.parseShort((String)value);
    }

    if (value == null)
    {
      return 0;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to short");
  }

  public static Object getSetValue(Property property, short value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    String name = eStructuralFeature.getEType().getInstanceClassName();
    if (name == "java.lang.Byte" || name == "byte")
    {
      return new Byte((byte)value);
    }

    if (name == "java.lang.Double" || name == "double")
    {
      return new Double(value);
    }

    if (name == "java.lang.Float" || name == "float")
    {
      return new Float(value);
    }

    if (name == "java.lang.Integer" || name == "int")
    {
      return new Integer(value);
    }

    if (name == "java.lang.Long" || name == "long")
    {
      return new Long(value);
    }

    if (name == "java.lang.Short" || name == "short")
    {
      return new Short(value);
    }

    if (name == "java.math.BigDecimal")
    {
      return getBigDecimal(new Short(value));
    }

    if (name == "java.math.BigInteger")
    {
      return getBigInteger(new Short(value));
    }

    if (name == "java.lang.String")
    {
      return String.valueOf(value);
    }

    // Instead of throwing an IllegalArgumentException we will pass the value to the property
    return new Short(value);
  }

  public static String getString(Object value)
  {
    if (value instanceof String)
    {
      return (String)value;
    }

    if (value instanceof Number || value instanceof Boolean || value instanceof Character)
    {
      return String.valueOf(value);
    }

    if (value == null)
    {
      return null;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to String");
  }

  public static Object getSetValue(Property property, String value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    EClassifier eType = eStructuralFeature.getEType();
    if (value == null)
    {
      return eType.getDefaultValue();
    }

    String name = eType.getInstanceClassName();
    if (name == "java.lang.String")
    {
      return value;
    }

    if (name == "java.lang.Byte" || name == "byte")
    {
      return Byte.valueOf(value);
    }

    if (name == "java.lang.Double" || name == "double" || name == "java.lang.Number")
    {
      return Double.valueOf(value);
    }

    if (name == "java.lang.Float" || name == "float")
    {
      return new Float(value);
    }

    if (name == "java.lang.Integer" || name == "int")
    {
      return Integer.valueOf(value);
    }

    if (name == "java.lang.Long" || name == "long")
    {
      return Long.valueOf(value);
    }

    if (name == "java.lang.Short" || name == "short")
    {
      return Short.valueOf(value);
    }

    if (name == "java.lang.Character" || name == "char")
    {
      return new Character(value.charAt(0));
    }

    if (name == "java.math.BigDecimal")
    {
      return getBigDecimal(value);
    }

    if (name == "java.math.BigInteger")
    {
      return getBigInteger(value);
    }

    if (name == "java.lang.Boolean" || name == "boolean")
    {
      return Boolean.valueOf(value);
    }

    // Instead of throwing an IllegalArgumentException we will pass the value to the property
    return value;
  }
  
  public static EStructuralFeature getOpenFeature(EObject eObject, int featureID)
  {
    EClass eClass = eObject.eClass();
    int openFeatureCount = featureID - eClass.getFeatureCount();
    Set openFeatureSet = new HashSet();
    for (int i = 0, count = eClass.getEAllStructuralFeatures().size(); i < count; ++i)
    {
      EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(i);
      if (!eStructuralFeature.isDerived() && FeatureMapUtil.isFeatureMap(eStructuralFeature))
      {
        List features = (List)eObject.eGet(eStructuralFeature);
        for (int j = 0, size = features.size(); j < size; ++j)
        {
          FeatureMap.Entry entry = (FeatureMap.Entry)features.get(j);
          EStructuralFeature entryFeature = entry.getEStructuralFeature();
          if (openFeatureSet.add(entryFeature))
          {
            if (--openFeatureCount < 0) return entryFeature;
          }
        }
      }
    }
    throw new IndexOutOfBoundsException();
  }
  
  public static EStructuralFeature getOpenFeature(EObject eObject, String featureName)
  {
    EClass eClass = eObject.eClass();
    Set openFeatureSet = new HashSet();
    for (int i = 0, count = eClass.getEAllStructuralFeatures().size(); i < count; ++i)
    {
      EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(i);
      if (/*!eStructuralFeature.isDerived() && */FeatureMapUtil.isFeatureMap(eStructuralFeature))
      {
        List features = (List)eObject.eGet(eStructuralFeature);
        for (int j = 0, size = features.size(); j < size; ++j)
        {
          FeatureMap.Entry entry = (FeatureMap.Entry)features.get(j);
          EStructuralFeature entryFeature = entry.getEStructuralFeature();
          if (openFeatureSet.add(entryFeature))
          {
            Property property = (Property)entryFeature;
            if (property.getName().equals(featureName)) return entryFeature;

            List aliasNames = property.getAliasNames();
            for (int aliasCount = aliasNames.size(); aliasCount > 0; )
            {
              if (aliasNames.get(--aliasCount).equals(featureName)) return entryFeature;
            }
          }
        }
      }
    }
    throw new IllegalArgumentException("Class '" + eObject.eClass().getName() + "' does not have a feature named '" + featureName + "'");
  }
  
  public static List getAliasNames(EStructuralFeature eStructuralFeature)
  {
    List list = SDOExtendedMetaData.INSTANCE.getAliasNames(eStructuralFeature);
    if (list == null) {
      list = new ArrayList();
    }
    return list;
  }

  public static List getAliasNames(EClassifier eClassifier)
  {
    List list = SDOExtendedMetaData.INSTANCE.getAliasNames(eClassifier);
    if (list == null) {
      list = new ArrayList();
    }
    return list;
  }

  /**
   * Process the default EMF path and minimal XPath syntax.
   * This design is still under review and construction.
   *
   * Syntax:
   * 
   *<pre>
   * path = /? (step '/')* step
   * step = feature
   *      | feature '.' index_from_0 
   *      | feature '[' index_from_1 ']'
   *      | reference '[' attribute '=' value ']'
   *      | ..
   *      | '@' step
   *</pre>
   * 
   * feature = the name of an attribute or reference
   * attribute = the name of an attribute
   * reference = the name of a reference
   * index = positive integer
   * value = the string value of an attribute
   * leading / begins at the root
   * .. is containing object
   * 
   * features must be multi-valued to use '.' and '[' operations.
   * Only the last step may have an attribute as the feature.
   */
  public static final class Accessor //TODO rewrite this using SDO APIs
  {
    /**
     * Creates an accessor for the path of the object.
     */
    public static Accessor create(EObject eObject, String path)
    {
      Accessor result = pool.get();
      result.init(eObject, path);
      return result;
    }

    /**
     * Only the get and recycle methods should be call; they are the only synchronized methods.
     */
    protected static class Pool extends BasicEList
    {
      protected Accessor[] accessors;

      public Pool()
      {
        super(10);
      }

      protected Object[] newData(int capacity)
      {
        return accessors = new Accessor [capacity];
      }

      /**
       *  Returns a recyled instance or a new instance.
       */
      public synchronized Accessor get()
      {
        if (size > 0)
        {
          return accessors[--size];
        }
        else
        {
          return new Accessor();
        }
      }

      /** Safely gives the accessor back for recycled use.
       */
      public synchronized void recycle(Accessor accessor)
      {
        int minimumCapacity = size + 1;
        if (minimumCapacity > data.length)
        {
          grow(minimumCapacity);
        }
        accessors[size++] = accessor;
      }
    }

    /**
     * A static thread safe pool of Accessors.
     */
    static final Pool pool = new Pool();

    protected static final int NO_INDEX = -1;

    protected EObject eObject;

    protected EStructuralFeature feature;

    protected int index;

    protected Accessor()
    {
    }

    protected Accessor(EObject eObject, String path)
    {
      init(eObject, path);
    }

    protected void init(EObject eObject, String path)
    {
      this.eObject = eObject;

      // This should only be called with a path right now.
      //
      //feature = getType(eObject).getProperty(path).getEStructuralFeature(); 
      //if (feature == null)
      {
        process(path);
      }
      //else
      {
        //index = NO_INDEX;
      }
    }

    public Object get()
    {
      if (feature == null)
      {
        return eObject;
      }
      else
      {
        Object value = eObject.eGet(feature, true);
        if (index >= 0)
        {
          value = ((List)value).get(index);
          if (value instanceof FeatureMap.Entry)
          {
            value = ((FeatureMap.Entry)value).getValue();
          }
        }
        else if (FeatureMapUtil.isFeatureMap(feature))
        {
          value = new BasicSequence((FeatureMap.Internal)value);
        }
        return value;
      }
    }

    public Object getAndRecyle()
    {
      Object result = get();
      pool.recycle(this);
      return result;
    }

    public void set(Object newValue)
    {
      if (index >= 0)
      {
        List list = (List)eObject.eGet(feature, true);
        list.set(index, newValue);
      }
      else
      {
        // EATM newValue = string2Enum(feature, newValue);
        eObject.eSet(feature, newValue);
      }
    }

    public void setAndRecyle(Object newValue)
    {
      set(newValue);
      pool.recycle(this);
    }

    public boolean isSet()
    {
      return eObject.eIsSet(feature);
    }

    public boolean isSetAndRecyle()
    {
      boolean result = isSet();
      pool.recycle(this);
      return result;
    }

    public void unset()
    {
      eObject.eUnset(feature);
    }

    public void unsetAndRecyle()
    {
      unset();
      pool.recycle(this);
    }

    public void recycle()
    {
      pool.recycle(this);
    }

    public EObject getEObject()
    {
      return eObject;
    }

    protected void setEObject(EObject eObject)
    {
      this.eObject = eObject;
      feature = null;
      index = NO_INDEX;
    }

    public EStructuralFeature getEStructuralFeature()
    {
      return feature;
    }

    public Property getProperty()
    {
      return (Property)feature;
    }

    protected void setFeatureName(String name)
    {
      if (name != null)
      {
        feature = (EStructuralFeature)((DataObject)eObject).getProperty(name);
      }
      else
      {
        feature = null;
      }
      index = NO_INDEX;
    }

    protected int getIndex()
    {
      return index;
    }

    protected void setIndex(int index)
    {
      this.index = index;
      if (!FeatureMapUtil.isMany(eObject, feature))
      {
        throw new IndexOutOfBoundsException("Index applies only to multi-valued features.");
      }
    }

    protected void process(String pathString)
    {
      TokenList tokens = new TokenList(pathString.toCharArray());
      String token;
      int size = tokens.size();
      int x = 0;

      if ("/".equals(tokens.peek(0)))
      {
        setEObject(EcoreUtil.getRootContainer(eObject));
        x++;
      }

      for (; x < size; x++)
      {
        token = tokens.peek(x);
        char c = token.charAt(0);
        if ('/' == c)
        {
          setEObject((EObject)get());
        }
        else if ("..".equals(token))
        {
          EObject container = eObject.eContainer();
          if (container == null)
          {
            throw new IllegalArgumentException("No containing object for " + eObject);
          }
          setEObject(container);
        }
        else if ('.' == c)
        {
          x++; // skip .
          token = tokens.peek(x);
          int index = Integer.parseInt(token);
          setIndex(index);
        }
        else if ('[' == c)
        {
          x++; // skip [
          token = tokens.peek(x); // name or index
          char following = tokens.peek(x + 1).charAt(0);
          if ('=' != following)
          {
            int index = Integer.parseInt(token) - 1;
            setIndex(index);
            x++; // skip ]
          }
          else
          {
            x++; // done name
            x++; // skip =
            String attributeValue = tokens.peek(x); // value
            if ("\"".equals(attributeValue))
            {
              x++; // skip "
              attributeValue = tokens.peek(++x);
            }
            x++; // skip ]
            int index = matchingIndex((List)get(), token, attributeValue);
            if (index < 0)
            {
              setEObject(null);
            }
            else
            {
              setIndex(index);
            }
          }
        }
        else if ('@' == c)
        {
          x++; // skip @
        }
        else
        {
          setFeatureName(token);
        }
      }
    }

    protected static int matchingIndex(List eObjects, String attributeName, String attributeValue)
    {
      for (int i = 0, size = eObjects.size(); i < size; i++)
      {
        EObject eObject = (EObject)eObjects.get(i);
        EStructuralFeature feature = (EStructuralFeature)((Type)eObject.eClass()).getProperty(attributeName);
        if (feature != null)
        {
          Object test = eObject.eGet(feature, true);
          if (test != null)
          {
            String testString = EcoreUtil.convertToString((EDataType)feature.getEType(), test);
            if (attributeValue.equals(testString))
            {
              return i;
            }
          }
        }
      }
      return -1;
    }

    protected static class TokenList extends BasicEList
    {
      public TokenList(char[] path)
      {
        super(4);

        int pathLength = path.length;
        StringBuffer token = new StringBuffer();
        char cPrev;
        char c = 0;
        char cNext;
        char stringConstant = 0;
        for (int pos = 0; pos < pathLength; pos++)
        {
          cPrev = c;
          c = path[pos];
          cNext = pos < pathLength - 1 ? path[pos + 1] : 0;

          if (stringConstant != 0)
          {
            if (c == stringConstant)
            {
              endToken(token, true);
              stringConstant = 0;
            }
            else
            {
              token.append(c);
            }
          }
          else
          {
            switch (c)
            {
              case ' ':
              case 0xA:
              case 0xD:
              case 0x9:
                if (cPrev != ' ')
                {
                  endToken(token, false);
                }
                c = ' ';
                break;

              case '"':
              case '\'':
                endToken(token, false);
                stringConstant = c;
                break;

              // double or single tokens
              case '/':
              case ':':
              case '.':
                if (cPrev != c)
                {
                  endToken(token, false);
                }
                token.append(c);
                if (cNext != c)
                {
                  endToken(token, false);
                }
                break;

              // single tokens
              case '*':
              case '@':
              case '[':
              case ']':
              case '(':
              case ')':
              case '|':
                endToken(token, false);
                add(String.valueOf(c));
                break;

              // TODO: < > <= >= + - !=
              case '!':
                endToken(token, false);
                token.append(c);
                break;

              case '=':
                endToken(token, false);
                add(String.valueOf(c));
                break;

              default:
                token.append(c);
            }
          }
        }
        endToken(token, false);
      }

      public String peek()
      {
        return size > 0 ? (String)data[0] : " ";
      }

      public String peek(int index)
      {
        return index < size ? (String)data[index] : " ";
      }

      public TokenList pop()
      {
        remove(0);
        return this;
      }

      public TokenList pop(int count)
      {
        while (count-- > 0)
        {
          remove(count);
        }
        return this;
      }

      protected void endToken(StringBuffer token, boolean includeEmpty)
      {
        if (includeEmpty || token.length() > 0)
        {
          add(token.toString());
        }
        token.setLength(0);
      }

      protected boolean canContainNull()
      {
        return false;
      }

      protected Object[] newData(int capacity)
      {
        return new String [capacity];
      }
    }

    public String toString()
    {
      StringBuffer result = new StringBuffer("Accessor (object:");
      result.append(eObject == null ? "null" : eObject.toString());
      result.append(", feature:");
      result.append(feature == null ? "null" : feature.getName());
      result.append(", index:");
      result.append(index);
      result.append(")");
      return result.toString();
    }
  }
  
  public static Type getType(DataObject dataObject, String namespaceURI, String typeName)
  {
    DataGraph dataGraph = dataObject.getDataGraph();
    if (dataGraph != null)
    {
      return dataGraph.getType(namespaceURI, typeName);
    }
    else
    {
      //TODO think about where else to find the type
      return TypeHelper.INSTANCE.getType(namespaceURI, typeName);
    }
  }

  public static Property getProperty(DataObject dataObject, String propertyName)
  {
    Property property = dataObject.getType().getProperty(propertyName);
    if (property == null)
    {
      property = (Property)DataObjectUtil.getOpenFeature((EObject)dataObject, propertyName);
      //throw new IllegalArgumentException("Type '" + dataObject.getType().getName() + "' does not have a property named '" + propertyName + "'");
    }
  
    return property;
  }

  public static Property getProperty(DataObject dataObject, int propertyIndex)
  {
    List typeProperties = dataObject.getType().getProperties();
    
    Property property = propertyIndex < typeProperties.size() ?
        (Property)typeProperties.get(propertyIndex) :
        (Property)dataObject.getInstanceProperties().get(propertyIndex);
    
    //FB maybe should catch bad index exception and throw IllegalArgumentException?
    return property;
  }

  public static Property getContainmentProperty(Property property)
  {
    if (property.isContainment())
    {
      return property;
    }
    throw new IllegalArgumentException("The property '" + property.getName() + "' of '" + property.getContainingType().getName()
      + "' isn't a containment");
  }

  public static DataObject create(Type type)
  {
    return (DataObject)EcoreUtil.create((EClass)type);
  }
  
  public static ResourceSet createResourceSet()
  {
    ResourceSet result = new ResourceSetImpl();
    configureResourceSet(result);
    return result;
  }

  protected static Map registrations;

  protected static Map getRegistrations()
  {
    if (registrations == null)
    {
      Map result = new HashMap();

      if (!(Resource.Factory.Registry.INSTANCE.getFactory(URI.createURI("*.datagraph")) instanceof DataGraphResourceFactoryImpl))
      {
        result.put("datagraph", new DataGraphResourceFactoryImpl());
      }
      if (!(Resource.Factory.Registry.INSTANCE.getFactory(URI.createURI("*.ecore")) instanceof EcoreResourceFactoryImpl))
      {
        result.put("ecore", new EcoreResourceFactoryImpl());
      }

      if (!(Resource.Factory.Registry.INSTANCE.getFactory(URI.createURI("*.emof")) instanceof EMOFResourceFactoryImpl))
      {
        result.put("emof", new EMOFResourceFactoryImpl());
      }

      if (Resource.Factory.Registry.INSTANCE.getFactory(URI.createURI("*.xsd")) == null)
      {
        result.put("xsd", new XSDResourceFactoryImpl());
      }

      //FIXME ClassCastException in XSDHelper.define() if you give it a WSDL file
      // Patch for JIRA TUSCANY-42
      if (Resource.Factory.Registry.INSTANCE.getFactory(URI.createURI("*.wsdl")) == null)
      {
        result.put("wsdl", new XSDResourceFactoryImpl());
      }

      if (Resource.Factory.Registry.INSTANCE.getFactory(URI.createURI("*.*")) == null)
      {
        result.put("*", new XMLResourceFactoryImpl());
      }

      registrations = result;
    }

    return registrations;
  }

  protected static void configureResourceSet(ResourceSet resourceSet)
  {
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().putAll(getRegistrations());
  }
  
  public static EClass createDocumentRoot()
  {
    EClass documentRootEClass = EcoreFactory.eINSTANCE.createEClass();
    ExtendedMetaData.INSTANCE.setName(documentRootEClass, "");
    ExtendedMetaData.INSTANCE.setContentKind(documentRootEClass, ExtendedMetaData.MIXED_CONTENT);
    
    EAttribute mixed = EcoreFactory.eINSTANCE.createEAttribute();
    mixed.setName("mixed");
    mixed.setEType(EcorePackage.eINSTANCE.getEFeatureMapEntry());
    mixed.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
    ExtendedMetaData.INSTANCE.setName(mixed, ":mixed");
    ExtendedMetaData.INSTANCE.setFeatureKind(mixed, ExtendedMetaData.ELEMENT_WILDCARD_FEATURE);
    documentRootEClass.getEStructuralFeatures().add(mixed);
    
    EReference xmlnsPrefixMap = EcoreFactory.eINSTANCE.createEReference();
    xmlnsPrefixMap.setName("xMLNSPrefixMap");
    xmlnsPrefixMap.setEType(EcorePackage.eINSTANCE.getEStringToStringMapEntry());
    xmlnsPrefixMap.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
    xmlnsPrefixMap.setContainment(true);
    xmlnsPrefixMap.setTransient(true);
    ExtendedMetaData.INSTANCE.setName(xmlnsPrefixMap, "xmlns:prefix");
    ExtendedMetaData.INSTANCE.setFeatureKind(xmlnsPrefixMap, ExtendedMetaData.ATTRIBUTE_FEATURE);
    documentRootEClass.getEStructuralFeatures().add(xmlnsPrefixMap);
    
    EReference xsiSchemaLocation = EcoreFactory.eINSTANCE.createEReference();
    xsiSchemaLocation.setName("xSISchemaLocation");
    xsiSchemaLocation.setEType(EcorePackage.eINSTANCE.getEStringToStringMapEntry());
    xsiSchemaLocation.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
    xsiSchemaLocation.setContainment(true);
    xsiSchemaLocation.setTransient(true);
    ExtendedMetaData.INSTANCE.setName(xsiSchemaLocation, "xsi:schemaLocation");
    ExtendedMetaData.INSTANCE.setFeatureKind(xsiSchemaLocation, ExtendedMetaData.ATTRIBUTE_FEATURE);
    documentRootEClass.getEStructuralFeatures().add(xsiSchemaLocation);
    
    return documentRootEClass;
  }

  /**
   * Configure EMF to support the SDO runtime by registering a specialized Ecore factory, SDOEcoreFactory.
   *  This static initializion must run before any SDO metadata is created or loaded.
   *  As long as SDO helper classes (e.g., TypeHelper, XMLHelper, etc.) are accessed though their
   *  corresponding INSTANCE fields (e.g., TypeHelper.INSTANCE), or using the SDOUtil methods (e.g.,
   *  SDOUtil.createTypeHelper(), this will always be the case.
   */
  static
  {
    EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, new EPackage.Descriptor()
      {
        public EPackage getEPackage()
        {
          return EcorePackage.eINSTANCE;
        }

        public EFactory getEFactory()
        {
          return new SDOFactoryImpl.SDOEcoreFactory();
        }
      });
  }
  
  public static void initRuntime()
  {
    // NOOP since init is done during static initialization of this class. See above.
  }
  
}
