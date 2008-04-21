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
package org.apache.tuscany.sdo.util;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import org.apache.tuscany.sdo.SDOExtendedMetaData;
import org.apache.tuscany.sdo.SDOFactory;
import org.apache.tuscany.sdo.SDOPackage;
import org.apache.tuscany.sdo.api.SDOUtil;
import org.apache.tuscany.sdo.helper.HelperContextImpl;
import org.apache.tuscany.sdo.impl.ClassImpl;
import org.apache.tuscany.sdo.impl.DataGraphImpl;
import org.apache.tuscany.sdo.model.ModelFactory;
import org.apache.tuscany.sdo.model.impl.ModelFactoryImpl;
import org.apache.tuscany.sdo.util.resource.SDOURIConverterImpl;
import org.apache.tuscany.sdo.util.resource.SDOXMLResourceFactoryImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EDataTypeImpl;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xmi.XMLOptions;
import org.eclipse.emf.ecore.xmi.XMLParserPool;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EMOFResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLOptionsImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.xsd.util.XSDResourceFactoryImpl;

import commonj.sdo.ChangeSummary;
import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.Type;
import commonj.sdo.helper.DataHelper;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.impl.HelperProvider;


public final class DataObjectUtil
{
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
  

  public static void setString(DataObject dataObject, int propertyIndex, String value) {
      setString(dataObject,getProperty(dataObject, propertyIndex), value);
  }
  
  public static void setShort(DataObject dataObject, int propertyIndex, short value) {
      setShort(dataObject,getProperty(dataObject, propertyIndex), value);
  }
  
  public static void setLong(DataObject dataObject, int propertyIndex, long value) {
      setLong(dataObject,getProperty(dataObject, propertyIndex), value);
  }
  
  public static void setList(DataObject dataObject, int propertyIndex, List value) {
      setList(dataObject,getProperty(dataObject, propertyIndex), value);
  }
  
  public static void setInt(DataObject dataObject, int propertyIndex, int value) {
      setInt(dataObject,getProperty(dataObject, propertyIndex), value);
  }
  
  public static void setFloat(DataObject dataObject, int propertyIndex, float value) {
      setFloat(dataObject,getProperty(dataObject, propertyIndex), value);
  }
 
  public static void setDouble(DataObject dataObject, int propertyIndex, double value) {
      setDouble(dataObject,getProperty(dataObject, propertyIndex), value);
  }
  
  public static void setDate(DataObject dataObject, int propertyIndex, Date value) {
      setDate(dataObject,getProperty(dataObject, propertyIndex), value);
  }
  
  public static void setDataObject(DataObject dataObject, int propertyIndex, DataObject value) {
    dataObject.set(getProperty(dataObject, propertyIndex), value);
  }
  
  public static void setChar(DataObject dataObject, int propertyIndex, char value) {
      setChar(dataObject,getProperty(dataObject, propertyIndex), value);
  }
  
  public static void setBytes(DataObject dataObject, int propertyIndex, byte[] value) {
      setBytes(dataObject,getProperty(dataObject, propertyIndex), value);
  }
  
  public static void setByte(DataObject dataObject, int propertyIndex, byte value) {
      setByte(dataObject,getProperty(dataObject, propertyIndex), value);
  }
  
  public static void setBoolean(DataObject dataObject, int propertyIndex, boolean value) {
      setBoolean(dataObject,getProperty(dataObject, propertyIndex), value);
  }
  
  public static void setBigInteger(DataObject dataObject, int propertyIndex, BigInteger value)
  {
      setBigInteger(dataObject,getProperty(dataObject, propertyIndex), value);
  }
  
  public static void setBigDecimal(DataObject dataObject, int propertyIndex, BigDecimal value)
  {
    setBigDecimal(dataObject,getProperty(dataObject, propertyIndex), value);
  }
  
  public static String getString(DataObject dataObject, int propertyIndex)
  {
    return getString(dataObject.get(getProperty(dataObject, propertyIndex)));
  }
  
  public static short getShort(DataObject dataObject, int propertyIndex)
  {
    return getShort(dataObject.get(getProperty(dataObject, propertyIndex)));
  }
  

  public static Sequence getSequence(DataObject dataObject, int propertyIndex)
  {
    return (Sequence)dataObject.get(propertyIndex);
  }
  
  public static long getLong(DataObject dataObject, int propertyIndex)
  {
    return getLong(dataObject.get(getProperty(dataObject, propertyIndex)));
  }
  
  public static List getList(DataObject dataObject, int propertyIndex)
  {
    return (List)dataObject.get(getProperty(dataObject, propertyIndex));
  }
  
  public static int getInt(DataObject dataObject, int propertyIndex)
  {
    return getInt(dataObject.get(getProperty(dataObject, propertyIndex)));
  }
  
  public static float getFloat(DataObject dataObject, int propertyIndex)
  {
    return getFloat(dataObject.get(getProperty(dataObject, propertyIndex)));
  }
  
  public static double getDouble(DataObject dataObject, int propertyIndex)
  {
    return getDouble(dataObject.get(getProperty(dataObject, propertyIndex)));
  }
  
  public static Date getDate(DataObject dataObject, int propertyIndex)
  {
    return getDate(dataObject.get(getProperty(dataObject, propertyIndex)));
  }
  
  public static DataObject getDataObject(DataObject dataObject, int propertyIndex)
  {
    return (DataObject)dataObject.get(getProperty(dataObject, propertyIndex));
  }
  
  public static char getChar(DataObject dataObject, int propertyIndex)
  {
    return getChar(dataObject.get(getProperty(dataObject, propertyIndex)));
  }
  
  public static byte[] getBytes(DataObject dataObject, int propertyIndex)
  {
    return getBytes(dataObject.get(getProperty(dataObject, propertyIndex)));
  }
  
  public static byte getByte(DataObject dataObject, int propertyIndex)
  {
    return getByte(dataObject.get(getProperty(dataObject, propertyIndex)));
  }
  
  public static boolean getBoolean(DataObject dataObject, int propertyIndex)
  {
    return getBoolean(dataObject.get(getProperty(dataObject, propertyIndex)));
  }
  
  public static BigInteger getBigInteger(DataObject dataObject, int propertyIndex)
  {
    return getBigInteger(dataObject.get(getProperty(dataObject, propertyIndex)));
  }
  
  public static BigDecimal getBigDecimal(DataObject dataObject, int propertyIndex)
  {
    return getBigDecimal(dataObject.get(getProperty(dataObject, propertyIndex)));
  }
  
  public static void detach(DataObject dataObject) {
    EcoreUtil.remove((EObject)dataObject);
  }
  
  public static DataObject getRootObject(DataObject dataObject)
  {
    return (DataObject)EcoreUtil.getRootContainer((EObject)dataObject);
  }
  
  public static boolean isInternalProperty(EStructuralFeature eStructuralFeature)
  {
    //return FeatureMapUtil.isFeatureMap(eStructuralFeature);
    EClassifier eClassifier = eStructuralFeature.getEType();
    return !(eClassifier instanceof Type || eClassifier == XMLTypePackage.Literals.BASE64_BINARY);
  }

  public static List getInstanceProperties(DataObject dataObject)
  {
    Type type = dataObject.getType();
    List result = new UniqueEList(type.getProperties());
    ((ClassImpl)type).addOpenProperties((EObject)dataObject, result);
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
    Property property = getInstanceProperty(dataObject, propertyName);
    if (property != null) {
      Type type = DataObjectUtil.getType(dataObject, namespaceURI, typeName);
      return createDataObject(dataObject, property, type);
    }
    else {
      if (dataObject.getType().isOpen()) {
        HelperContext ctx = HelperProvider.getDefaultContext();
        Type propertyType = ctx.getTypeHelper().getType( namespaceURI, typeName );
        if (propertyType == null) {
          throw new IllegalStateException( "type does not exist: uri=" + namespaceURI + ", name=" + typeName );
        }
        DataObject value = ctx.getDataFactory().create( propertyType );
        List list = new ArrayList(1);
        list.add(value);
        dataObject.setList( propertyName, list );
        return value;
      }
      else {
        throw new IllegalArgumentException( "property '" + propertyName + "' does not exist" );
      }
    }
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
    Property property = (Property)getInstanceProperty(dataObject, propertyName);
    if (property != null) {
      Type type = property.getType();
      return createDataObject(dataObject,property, type);
    }
    else {
      return createDataObject(dataObject, propertyName, "http://www.apache.org/tuscany/2005/SDO", "AnyTypeDataObject" );
    }
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
    else
    {
      for (DataObject csDataObject = dataObject; csDataObject != null; csDataObject = csDataObject.getContainer())
      {
        Property csp = ((ClassImpl)csDataObject.getType()).getChangeSummaryProperty();
        if (csp != null) return (ChangeSummary)csDataObject.get(csp);
      }
    }
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
        (EObject)dataObject, path, value).setAndRecyle(value);
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
    
    if (value instanceof Long)
    {
      return new BigDecimal(((Long)value).longValue());
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

    throw new ClassCastException("The value of type '" + value.getClass().getName() + "' cannot be converted to BigDecimal");
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

    //Instead of throwing an ClassCastException we will pass the value to the property
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

    throw new ClassCastException("The value of type '" + value.getClass().getName() + "' cannot be converted to BigInteger");
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

    //Instead of throwing an ClassCastException we will pass the value to the property
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

    throw new ClassCastException("The value of type '" + value.getClass().getName() + "' cannot be converted to boolean");
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

    //Instead of throwing an ClassCastException we will pass the value to the property
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

    throw new ClassCastException("The value of type '" + value.getClass().getName() + "' cannot be converted to byte");
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

    //Instead of throwing an ClassCastException we will pass the value to the property
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

    if (value instanceof String)
    {
        return (XMLTypeFactory.eINSTANCE.createHexBinary((String)value));
    }
    
    if (value == null)
    {
      return null;
    }

    throw new ClassCastException("The value of type '" + value.getClass().getName() + "' cannot be converted to byte array");
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
    
    if (name == "java.lang.String" )
    {
      return XMLTypeFactory.eINSTANCE.convertHexBinary((byte[])value);
    }
    
    //Instead of throwing an ClassCastException we will pass the value to the property
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

    throw new ClassCastException("The value of type '" + value.getClass().getName() + "' cannot be converted to char");
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

    //Instead of throwing an ClassCastException we will pass the value to the property
    return new Character(value);
  }

  public static Date getDate(Object value)
  {
    if (value instanceof String) {
      return DataHelper.INSTANCE.toDate((String)value);
    }

    //if (value instanceof XMLCalendar)
    //{
      //return ((XMLCalendar)value).getDate();
    //}

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

    throw new ClassCastException("The value of type '" + value.getClass().getName() + "' cannot be converted to Date");
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
        
    if (name == "java.lang.String")
    {
      String typeName = getDateTypeName((EDataType)eType);
      if ("DateTime".equals(typeName)) {
          return DataHelper.INSTANCE.toDateTime(value);
      }
      else if ("Day".equals(typeName)) {
          return DataHelper.INSTANCE.toDay(value);
      }
      else if ("Duration".equals(typeName)) {
          return DataHelper.INSTANCE.toDuration(value);
      }
      else if ("Month".equals(typeName)) {
          return DataHelper.INSTANCE.toMonth(value);
      }
      else if ("MonthDay".equals(typeName)) {
          return DataHelper.INSTANCE.toMonthDay(value);
      }
      else if ("Time".equals(typeName)) {
          return DataHelper.INSTANCE.toTime(value);
      }
      else if ("Year".equals(typeName)) {
          return DataHelper.INSTANCE.toYear(value);
      }
      else if ("YearMonth".equals(typeName)) {
          return DataHelper.INSTANCE.toYearMonth(value);
      }
      else if ("YearMonthDay".equals(typeName)) {
          return DataHelper.INSTANCE.toYearMonthDay(value);
      }
      else if ("String".equals(typeName))
      {
        return DataHelper.INSTANCE.toDateTime(value);
      }
      
      // Instead of throwing an ClassCastException we will pass the value to the property
      return value;
    }

    //if (name == "java.util.Date")
    //{
      //return new XMLCalendar(value, XMLCalendar.DATE);
    //}
    
    if (name == "java.lang.Long" || name == "long")
    {
      return new Long(value.getTime());
    }

    // Instead of throwing an ClassCastException we will pass the value to the property
    return value;
  }

  protected static String getDateTypeName(EDataType eDataType)
  {
    String name = eDataType.getName();
    if (("DateTime".equals(name)) ||
            ("Day".equals(name)) ||
            ("Duration".equals(name)) ||
            ("Month".equals(name)) ||
            ("MonthDay".equals(name)) ||
            ("Time".equals(name)) ||
            ("Year".equals(name)) ||
            ("YearMonth".equals(name)) ||
            ("YearMonthDay".equals(name)) ||
            ("String".equals(name)))
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
        if (("DateTime".equals(memberTypeName)) ||
                ("Day".equals(memberTypeName)) ||
                ("Duration".equals(memberTypeName)) ||
                ("Month".equals(memberTypeName)) ||
                ("MonthDay".equals(memberTypeName)) ||
                ("Time".equals(memberTypeName)) ||
                ("Year".equals(memberTypeName)) ||
                ("YearMonth".equals(memberTypeName)) ||
                ("YearMonthDay".equals(memberTypeName)) ||
                ("String".equals(memberTypeName)))
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

    throw new ClassCastException("The value of type '" + value.getClass().getName() + "' cannot be converted to double");
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

    //Instead of throwing an ClassCastException we will pass the value to the property
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

    throw new ClassCastException("The value of type '" + value.getClass().getName() + "' cannot be converted to float");
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

    // Instead of throwing an ClassCastException we will pass the value to the property
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

    throw new ClassCastException("The value of type '" + value.getClass().getName() + "' cannot be converted to int");
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

    // Instead of throwing an ClassCastException we will pass the value to the property
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

    throw new ClassCastException("The value of type '" + value.getClass().getName() + "' cannot be converted to long");
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

    // Instead of throwing an ClassCastException we will pass the value to the property
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

    throw new ClassCastException("The value of type '" + value.getClass().getName() + "' cannot be converted to short");
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

    // Instead of throwing an ClassCastException we will pass the value to the property
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
    
    if (value instanceof Date)
    {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy'-'MM'-'dd'T'H':'mm':'ss.S'Z'");
      sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
      return sdf.format((Date) value);
    }

    if (value instanceof byte[]) {
      return XMLTypeFactory.eINSTANCE.convertHexBinary((byte[])value);
    }
    
    if (value == null)
    {
      return null;
    }

    throw new ClassCastException("The value of type '" + value.getClass().getName() + "' cannot be converted to String");
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

    if (name == "java.util.Date")
    {
      return DataHelper.INSTANCE.toDate(value);
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
    
    if (name == "byte[]")
    {
        return XMLTypeFactory.eINSTANCE.createHexBinary(value);
    }

    // Instead of throwing an ClassCastException we will pass the value to the property
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
  
  protected static Property demandOpenProperty(Type type, String name, Object value, boolean isSequence)
  {
    TypeHelper typeHelper = TypeHelper.INSTANCE; //FB TODO: what TypeHelper to use?
    
    String uri = type.getURI() + "/" + type.getName(); // unique URI for open content properties on instances of the type
    Property property = typeHelper.getOpenContentProperty(uri, name);
    if (property != null)
      return property;

    boolean isMany = isSequence;
    boolean isContainment = false;
    Type propertyType;
    
    if (value instanceof DataObject)
    {
      DataObject dataObject = (DataObject)value;
      propertyType = dataObject.getType();
      isContainment = dataObject.getContainer() == null;
    }
    else if (value instanceof List && !((List)value).isEmpty())
    {
      Object listValue = ((List)value).get(0); //TODO: get common base class if all values are not the same type?
      if (listValue instanceof DataObject)
        propertyType = ((DataObject)listValue).getType();
      else
        propertyType = typeHelper.getType(listValue.getClass());
      isMany = true;
    }
    else
    {
      propertyType = typeHelper.getType(value.getClass()); 
    }
    if (propertyType == null)
    {
      propertyType = ((ModelFactoryImpl)ModelFactory.INSTANCE).getObject();
    }
    
    Property newProperty = SDOUtil.createOpenContentProperty(HelperProvider.getDefaultContext(), uri, name, propertyType);
    if (isMany)
      SDOUtil.setMany(newProperty, isMany);
    if (isContainment)
      SDOUtil.setContainment(newProperty, isContainment);

    return newProperty;
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
      return create(eObject, path, null);
    }
      
    public static Accessor create(EObject eObject, String path, Object value)
    {
      Accessor result = pool.get();
      result.init(eObject, path, value);
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
    protected Object value;

    protected EStructuralFeature feature;

    protected int index;
    
    RuntimeException runtimeException;

    protected Accessor()
    {
    }

    //protected Accessor(EObject eObject, String path)
    //{
    //  init(eObject, path);
    //}

    protected void init(EObject eObject, String path, Object value)
    {
      this.eObject = eObject;
      this.value = value;
      runtimeException = null;

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
    
    protected final void assertSuccessfulProcess()
    {
      if (runtimeException != null)  
        throw runtimeException;
    }

    public void set(Object newValue)
    {
      assertSuccessfulProcess();
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
      return feature != null && eObject.eIsSet(feature);
    }

    public boolean isSetAndRecyle()
    {
      boolean result = isSet();
      pool.recycle(this);
      return result;
    }

    public void unset()
    {
      assertSuccessfulProcess();
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
      assertSuccessfulProcess();
      return (Property)feature;
    }

    protected void setFeatureName(String name)
    {
      if (name != null)
      {
        feature = (EStructuralFeature)((DataObject)eObject).getInstanceProperty(name);
        if (feature == null)
        {
          int index = name.lastIndexOf('.');
          if (index == -1)
          {
            Type type = (Type)eObject.eClass();
            if (value != null && type.isOpen())
            {
              feature = (EStructuralFeature)demandOpenProperty(type, name, value, false);
              this.index = NO_INDEX;
              return;
            }
            runtimeException = new IllegalArgumentException("Class '" + eObject.eClass().getName() + "' does not have a feature named '" + name + '\'');
          }
          else
          {
            int propertyNameEnd = index;
            try
            {
              index = Integer.parseInt(name.substring(++index));
                //  NumberFormatException may be thrown
              String propertyName = name.substring(0, propertyNameEnd);
              feature = (EStructuralFeature)((DataObject)eObject).getInstanceProperty(propertyName);
              if (feature != null)
              {
                setIndex(index);
                return;
              }
              runtimeException = new IllegalArgumentException("Class '" + eObject.eClass().getName() + "' does not have a feature named '" + name + "' or '" + propertyName + '\'');
            }
            catch(NumberFormatException eNumberFormat)
            {
              runtimeException = eNumberFormat;
            }
          }
          setEObject(null);
        }
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

    /*
     * calling constraint, this method is not to be used for semantic of setting index to NO_INDEX
     */ 
    protected void setIndex(int index)
    {
      if (index < 0) {
        // The index value should not be less than 0.
        runtimeException = new IndexOutOfBoundsException("Index value is too low");
        setEObject(null);
        return;
      }
      if (!FeatureMapUtil.isMany(eObject, feature))
      {
        runtimeException = new IndexOutOfBoundsException("Index applies only to multi-valued features");
        setEObject(null);
        return;
      }
      int size = ((List) eObject.eGet(feature)).size();
      if (index >= size)
      {
        // The index value should be less than size.
        runtimeException = new IndexOutOfBoundsException("Index value should have been less than " + size);
        setEObject(null);
      }
      this.index = index;
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
          if (eObject == null) break;
        }
        else if ("..".equals(token))
        {
          setEObject(eObject.eContainer());
          if (eObject == null) break;
        }
        else if ('[' == c)
        {
          x++; // skip [
          token = tokens.peek(x); // name or index
          char following = tokens.peek(x + 1).charAt(0);
          if ('=' != following)
          {
            try
            {
              setIndex(Integer.parseInt(token) - 1);
                //  runtimeException may be recorded
            }
            catch(NumberFormatException eNumberFormat)
            {
              runtimeException = eNumberFormat;
              setEObject(null);
              break;
            }
            if (runtimeException != null)
              break;
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
              break;
            }
            else
            {
              setIndex(index);
            }
          }
        }
        else if ('@' == c)
        {
          // skip @
        }
        else
        {
          setFeatureName(token);
          if (eObject == null) break;
        }
      }
    }

    protected static int matchingIndex(List dataObjects, String attributeName, String attributeValue)
    {
      for (int i = 0, size = dataObjects.size(); i < size; i++)
      {
        DataObject dataObject = (DataObject)dataObjects.get(i);
        Property property = getInstanceProperty(dataObject, attributeName);
        if (property != null)
        {
          Object test = dataObject.get(property);
          if (test != null)
          {
            String testString = EcoreUtil.convertToString((EDataType)property.getType(), test);
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

              // double token (..)
              case '.':
                if (cNext == '.')
                  endToken(token, false);
                token.append(c);
                if (cPrev == '.')
                  endToken(token, false);
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

  public static Property getInstanceProperty(DataObject dataObject, String propertyName)
  {
    ClassImpl type = (ClassImpl)dataObject.getType();
    Property property = type.getProperty(propertyName);
    if (property == null)
    {
      property = type.getOpenProperty((EObject)dataObject, propertyName);
      //throw new IllegalArgumentException("Type '" + dataObject.getType().getName() + "' does not have a property named '" + propertyName + "'");
    }
  
    return property;
  }

  public static Property getProperty(DataObject dataObject, int propertyIndex)
  {
    List typeProperties = dataObject.getType().getProperties();
    try {
      Property property = propertyIndex < typeProperties.size() ?
          (Property)typeProperties.get(propertyIndex) :
          (Property)dataObject.getInstanceProperties().get(propertyIndex);
    
      return property;
      } catch (IndexOutOfBoundsException e) {
        throw new IllegalArgumentException();
      }
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
    //return (DataObject)EcoreUtil.create((EClass)type);
    if ((type instanceof EClass) && !type.isAbstract()) {
      EClass eClass = (EClass)type;
      try {
          return (DataObject)EcoreUtil.create(eClass);
      } catch (ClassCastException e) {
          throw new IllegalArgumentException();
      }
    }
    throw new IllegalArgumentException();
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
      
      Resource.Factory factory = Resource.Factory.Registry.INSTANCE.getFactory(URI.createURI("*.datagraph"));
      result.put("datagraph", factory instanceof DataGraphResourceFactoryImpl ? factory : new DataGraphResourceFactoryImpl());

      factory = Resource.Factory.Registry.INSTANCE.getFactory(URI.createURI("*.ecore"));
      result.put("ecore", factory instanceof EcoreResourceFactoryImpl ? factory : new EcoreResourceFactoryImpl());
      
      factory = Resource.Factory.Registry.INSTANCE.getFactory(URI.createURI("*.emof"));
      result.put("emof", factory instanceof EMOFResourceFactoryImpl ? factory : new EMOFResourceFactoryImpl());

      factory = Resource.Factory.Registry.INSTANCE.getFactory(URI.createURI("*.xsd"));
      result.put("xsd", factory instanceof XSDResourceFactoryImpl ? factory : new XSDResourceFactoryImpl());

      factory = Resource.Factory.Registry.INSTANCE.getFactory(URI.createURI("*.wsdl"));
      result.put("wsdl", factory instanceof XSDResourceFactoryImpl ? factory : new XSDResourceFactoryImpl());
      
      factory = Resource.Factory.Registry.INSTANCE.getFactory(URI.createURI("*.*"));
      result.put("*", factory instanceof SDOXMLResourceFactoryImpl ? factory : new SDOXMLResourceFactoryImpl());
      
      registrations = result;
    }

    return registrations;
  }

  protected static void configureResourceSet(ResourceSet resourceSet)
  {
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().putAll(getRegistrations());
    resourceSet.setPackageRegistry(new EPackageRegistryImpl(HelperContextImpl.getBuiltInModelRegistry()));      
    resourceSet.setURIConverter(new SDOURIConverterImpl());
  }
  
  public static EClass createDocumentRoot()
  {
    EClass documentRootEClass = (EClass)SDOFactory.eINSTANCE.createClass();
    documentRootEClass.setName("DocumentRoot");
    ExtendedMetaData.INSTANCE.setName(documentRootEClass, "");
    ExtendedMetaData.INSTANCE.setContentKind(documentRootEClass, ExtendedMetaData.MIXED_CONTENT);
    
    EAttribute mixed = (EAttribute)SDOFactory.eINSTANCE.createAttribute();
    mixed.setName("mixed");
    mixed.setEType(EcorePackage.eINSTANCE.getEFeatureMapEntry());
    mixed.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
    ExtendedMetaData.INSTANCE.setName(mixed, ":mixed");
    ExtendedMetaData.INSTANCE.setFeatureKind(mixed, ExtendedMetaData.ELEMENT_WILDCARD_FEATURE);
    documentRootEClass.getEStructuralFeatures().add(mixed);
    
    EReference xmlnsPrefixMap = (EReference)SDOFactory.eINSTANCE.createReference();
    xmlnsPrefixMap.setName("xMLNSPrefixMap");
    xmlnsPrefixMap.setEType(EcorePackage.eINSTANCE.getEStringToStringMapEntry());
    xmlnsPrefixMap.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
    xmlnsPrefixMap.setContainment(true);
    xmlnsPrefixMap.setTransient(true);
    ExtendedMetaData.INSTANCE.setName(xmlnsPrefixMap, "xmlns:prefix");
    ExtendedMetaData.INSTANCE.setFeatureKind(xmlnsPrefixMap, ExtendedMetaData.ATTRIBUTE_FEATURE);
    documentRootEClass.getEStructuralFeatures().add(xmlnsPrefixMap);
    
    EReference xsiSchemaLocation = (EReference)SDOFactory.eINSTANCE.createReference();
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
  /*
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
  */
  
  /*
  protected static StringBuffer getXPath(DataObject dataObject, StringBuffer path, DataObject root)
  {
    DataObject container = dataObject.getContainer();
    if (container == null) return path;
    
    if (container == root) {
        throw new IllegalStateException("There is a cycle in the containment hierarchy of " + root);
    }

    boolean first = path.length() == 0;
    Property property = dataObject.getContainmentProperty();
    if (SDOUtil.isMany(property, dataObject))
    {
      List list = container.getList(property);
      int pos = list.indexOf(dataObject);
      path.insert(0, property.getName() + "." + pos + (first ? "" : "/"));
    }
    else
    {
      path.insert(0, property.getName() + (first ? "" : "/"));
    }

    return getXPath(container, path, root);
  }
  */

  public static String getXPath(DataObject dataObject)
  {
    return SDOUtil.getXPath(dataObject);
    //StringBuffer path = getXPath(dataObject, new StringBuffer(), dataObject);
    //return path.toString();
  }
  
  protected static XMLParserPool globalXMLParserPool = new XMLParserPoolImpl();
  
  public static void configureXMLResource(XMLResource resource, ExtendedMetaData extendedMetaData)
  {
    XMLOptions xmlOptions = new XMLOptionsImpl();
    xmlOptions.setProcessAnyXML(true);
    resource.getDefaultLoadOptions().put(XMLResource.OPTION_XML_OPTIONS, xmlOptions);

    resource.getDefaultSaveOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, extendedMetaData);
    resource.getDefaultLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, extendedMetaData);
    
    resource.getDefaultLoadOptions().put(XMLResource.OPTION_USE_PARSER_POOL, globalXMLParserPool);
    
    resource.getDefaultLoadOptions().put(XMLResource.OPTION_USE_DEPRECATED_METHODS, Boolean.FALSE);
    
    resource.getDefaultSaveOptions().put(XMLResource.OPTION_CONFIGURATION_CACHE, Boolean.TRUE);
    resource.getDefaultLoadOptions().put(XMLResource.OPTION_CONFIGURATION_CACHE, Boolean.TRUE);
    
    resource.getDefaultLoadOptions().put(XMLResource.OPTION_ANY_TYPE, SDOPackage.eINSTANCE.getAnyTypeDataObject());
    resource.getDefaultSaveOptions().put(XMLResource.OPTION_ANY_TYPE, SDOPackage.eINSTANCE.getAnyTypeDataObject());

    resource.getDefaultLoadOptions().put(XMLResource.OPTION_ANY_SIMPLE_TYPE, SDOPackage.eINSTANCE.getSimpleAnyTypeDataObject());
    resource.getDefaultSaveOptions().put(XMLResource.OPTION_ANY_SIMPLE_TYPE, SDOPackage.eINSTANCE.getSimpleAnyTypeDataObject());

    //resource.getDefaultLoadOptions().put(XMLResource.OPTION_USE_XML_NAME_TO_FEATURE_MAP, globalHashMap);

    //resource.getDefaultSaveOptions().put(XMLResource.OPTION_FORMATTED, Boolean.FALSE);
  }

  /**
   * @deprecated SDO runtime initialization is no longer required
   */
  public static void initRuntime()
  {
    // NOOP since init is done during static initialization of this class. See above.
  }
  
  /*
  public static Object get(org.apache.tuscany.sdo.model.Property property, int propertyIndex) {
    switch(propertyIndex)
    {
      case ModelPackageImpl.PROPERTY__ALIAS_NAME:
        return property.getAliasName();
      case ModelPackageImpl.PROPERTY__ANY:
        return property.getAny();
      case ModelPackageImpl.PROPERTY__ANY_ATTRIBUTE:
        return property.getAnyAttribute();
      case ModelPackageImpl.PROPERTY__CONTAINMENT:
        return Boolean.valueOf(property.isContainment());
      case ModelPackageImpl.PROPERTY__DEFAULT:
        return property.getDefault_();
      case ModelPackageImpl.PROPERTY__MANY:
        return Boolean.valueOf(property.isMany());
      case ModelPackageImpl.PROPERTY__NAME:
        return property.getName();
      case ModelPackageImpl.PROPERTY__OPPOSITE:
        return property.getOpposite_();
      case ModelPackageImpl.PROPERTY__READ_ONLY:
        return Boolean.valueOf(property.isReadOnly());
      case ModelPackageImpl.PROPERTY__TYPE:
        return property.getType_();
    }
    return null;
  }
  
  public static boolean isSet(org.apache.tuscany.sdo.model.Property property, int propertyIndex) {
    switch(propertyIndex)
    {
      case ModelPackageImpl.PROPERTY__ALIAS_NAME:
        return !property.getAliasName().isEmpty();
      case ModelPackageImpl.PROPERTY__ANY:
        return false;
      case ModelPackageImpl.PROPERTY__ANY_ATTRIBUTE:
        return false;
      case ModelPackageImpl.PROPERTY__CONTAINMENT:
        return property.isSetContainment();
      case ModelPackageImpl.PROPERTY__DEFAULT:
        return property.getDefault_() != null;
      case ModelPackageImpl.PROPERTY__MANY:
        return property.isSetMany();
      case ModelPackageImpl.PROPERTY__NAME:
        return property.getName() != null;
      case ModelPackageImpl.PROPERTY__OPPOSITE:
        return property.getOpposite_() != null;
      case ModelPackageImpl.PROPERTY__READ_ONLY:
        return property.isSetReadOnly();
      case ModelPackageImpl.PROPERTY__TYPE:
        return property.getType_() != null;
    }
    return false;
  }
  
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
        return Boolean.valueOf(type.isAbstract());
      case ModelPackageImpl.TYPE__DATA_TYPE:
        return Boolean.valueOf(type.isDataType());
      case ModelPackageImpl.TYPE__NAME:
        return type.getName();
      case ModelPackageImpl.TYPE__OPEN:
        return Boolean.valueOf(type.isOpen());
      case ModelPackageImpl.TYPE__SEQUENCED:
        return Boolean.valueOf(type.isSequenced());
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
  */

  /**
   * Returns a unique list of meta object instance properties (stored in EAnnotations)
   *  
   * @param metaObject - A Type or Property instance
   * @return A list of commonj.sdo.Property instances
   */
  public static List getMetaObjectInstanceProperties(EModelElement metaObject) 
  {
    // Use the default helper context for now
	// TypeHelper typeHelper = HelperProvider.getDefaultContext().getTypeHelper();
      HelperContext hc = HelperProvider.getDefaultContext();
      
    List result = new UniqueEList();
    List annotations = metaObject.getEAnnotations();
    int size = annotations.size();
    for (int i=0; i<size; i++) 
    {
      EAnnotation annotation = (EAnnotation)annotations.get(i);
      String propertyURI = annotation.getSource();
      
      for (Iterator iter = annotation.getDetails().iterator(); iter.hasNext(); ) 
      {
        EStringToStringMapEntryImpl entry = (EStringToStringMapEntryImpl)iter.next();
        String propertyName = entry.getTypedKey();
        
        Property globalProperty = getGlobalProperty(hc, propertyURI, propertyName);
        if (globalProperty != null)
        {
          result.add(globalProperty);
        }
      }
    }
    return result; 
  }
  
  /**
   * Return the value of the specified mata object instance property (stored in EAnnotations)
   * 
   * @param metaObject - A Type or Property instance
   * @param property - The instance property to retrieve
   * @return The value of the instance property
   */
  /*public static Object getMetaObjectInstanceProperty(EModelElement metaObject, Property property)
  {
    String value = EcoreUtil.getAnnotation(metaObject, property.getContainingType().getURI(), property.getName());
    //TODO if (property.isMany()) ... // create list of values from from string
    return SDOUtil.createFromString(property.getType(), value);
  }*/
  
	 public static Object getMetaObjectInstanceProperty(EModelElement metaObject, Property property)
	 {
	  if(metaObject instanceof EDataTypeImpl){
		  if(property.getName().equals("enumeration")) {
				  List enumVals = ((EDataTypeImpl)metaObject).getExtendedMetaData().getEnumerationFacet();
				  return enumVals;
			  }
	 
			  if(property.getName().equals("pattern")) {
			  List patternVals = ((EDataTypeImpl)metaObject).getExtendedMetaData().getPatternFacet();
			  return patternVals;
		  }
	  }
	  String value = EcoreUtil.getAnnotation(metaObject, property.getContainingType().getURI(), property.getName());
	  //TODO if (property.isMany()) ... // create list of values from from string
	  return SDOUtil.createFromString(property.getType(), value);
	 }
  
  
/*
  protected static Property getGlobalProperty(TypeHelper typeHelper, String uri, String name)
  {
    Property property;
    if (ExtendedMetaData.ANNOTATION_URI.equals(uri)) {
      if ("minExclusive".equals(name) ||
          "minInclusive".equals(name) ||
          "maxExclusive".equals(name) ||
          "maxInclusive".equals(name) ||
          "totalDigits".equals(name) ||
          "fractionDigits".equals(name) ||
          "length".equals(name) ||
          "minLength".equals(name) ||
          "maxLength".equals(name) ||
          "enumeration".equals(name) ||
          "whiteSpace".equals(name) ||
          "pattern".equals(name))
      {
        //TODO Use standard facet properties, once SDO defines them
        //TODO property = getSDOFacetProperty(name);
        //TEMP For now just expose a string property for the EMF (ExtendedMetaData) facets
        property = SDOUtil.createOpenContentProperty(typeHelper, uri, name, ((ModelFactoryImpl)ModelFactory.INSTANCE).getString());
      }
      else
      {
        //TODO Should we consider exposing more ExtendedMetaData?
        property = null;
      }
    }
    else
    {
      property = typeHelper.getOpenContentProperty(uri, name);
      if (property == null)
      {
        property = SDOUtil.createOpenContentProperty(typeHelper, uri, name, ((ModelFactoryImpl)ModelFactory.INSTANCE).getString());
      }
    }
    return property;
  }
*/
  protected static Property getGlobalProperty(HelperContext hc, String uri, String name)
  {
    Property property;
    if (ExtendedMetaData.ANNOTATION_URI.equals(uri)) {
      if ("minExclusive".equals(name) ||
          "minInclusive".equals(name) ||
          "maxExclusive".equals(name) ||
          "maxInclusive".equals(name) ||
          "totalDigits".equals(name) ||
          "fractionDigits".equals(name) ||
          "length".equals(name) ||
          "minLength".equals(name) ||
          "maxLength".equals(name) ||
          "enumeration".equals(name) ||
          "whiteSpace".equals(name) ||
          "pattern".equals(name))
      {
        //TODO Use standard facet properties, once SDO defines them
        //TODO property = getSDOFacetProperty(name);
        //TEMP For now just expose a string property for the EMF (ExtendedMetaData) facets
        property = SDOUtil.createOpenContentProperty(hc, uri, name, ((ModelFactoryImpl)ModelFactory.INSTANCE).getString());
      }
      else
      {
        //TODO Should we consider exposing more ExtendedMetaData?
        property = null;
      }
    }
    else
    {
      property = hc.getTypeHelper().getOpenContentProperty(uri, name);
      if (property == null)
      {
        property = SDOUtil.createOpenContentProperty(hc, uri, name, ((ModelFactoryImpl)ModelFactory.INSTANCE).getString());
      }
    }
    return property;
  }
  
  protected static Class loadClass(final ClassLoader classLoader, final String className) {
    Class returnClass = null;
    try
    {
      returnClass = (Class)AccessController.doPrivileged(new PrivilegedExceptionAction()
        {
          public Object run() throws Exception
          {
            return classLoader.loadClass(className);
          }
        });
    }
    catch (Exception e)
    {
      return null;
    }

    return returnClass;
  }
  
  public static Class getImplementationClass(Class instanceClass, boolean concrete)
  {
    if (instanceClass.isInterface())
    {
      String sdoTypeImplClassName = instanceClass.getName();
      int index = sdoTypeImplClassName.lastIndexOf('.');
      if (index == -1) {
        sdoTypeImplClassName = "impl." + sdoTypeImplClassName + "Impl";
      }
      else {
        sdoTypeImplClassName = sdoTypeImplClassName.substring(0, index) + ".impl" + sdoTypeImplClassName.substring(index) + "Impl";
      }
      if (concrete) sdoTypeImplClassName += "$ConcreteBase";
      return loadClass(instanceClass.getClassLoader(), sdoTypeImplClassName);
    }
    else
    {
      return instanceClass;
    }
  }     

}
