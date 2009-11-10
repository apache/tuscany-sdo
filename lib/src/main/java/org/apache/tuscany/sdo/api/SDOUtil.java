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
package org.apache.tuscany.sdo.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.tuscany.sdo.api.EventListener;
import org.apache.tuscany.sdo.spi.HelperProviderBase;

import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.Type;
import commonj.sdo.helper.CopyHelper;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.impl.HelperProvider;

/**
 * This class provides convenient static utility functions for calling the default SDOHelper.
 */
public final class SDOUtil
{
  protected static SDOHelper defaultSDOHelper = ((HelperProviderBase)HelperProvider.INSTANCE).sdoHelper();
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#createDataTypeWrapper(Type, Object)}.
   */
  public static DataObject createDataTypeWrapper(Type dataType, Object value)
  {
    return defaultSDOHelper.createDataTypeWrapper(dataType, value);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#createFromString(Type, String)}.
   */
  public static Object createFromString(Type dataType, String literal)
  {
    return defaultSDOHelper.createFromString(dataType, literal);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#convertToString(Type, Object)}.
   */
  public static String convertToString(Type dataType, Object value)
  {
    return defaultSDOHelper.convertToString(dataType, value);
  }

  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#getXSDSDOType(String)}.
   */
  public static Type getXSDSDOType(String xsdType)
  {    
    return defaultSDOHelper.getXSDSDOType(xsdType);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#getSubstitutionValues(DataObject, Property)}.
   */
  public static Sequence getSubstitutionValues(DataObject dataObject, Property head)
  {
    return defaultSDOHelper.getSubstitutionValues(dataObject, head);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#getJavaSDOType(Class)}.
   */
  public static Type getJavaSDOType(Class javaClass)
  {    
    return defaultSDOHelper.getJavaSDOType(javaClass);
  }

  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#isRequired(Property)}.
   */
  public static boolean isRequired(Property property)
  {
    return defaultSDOHelper.isRequired(property);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#getUpperBound(Property)}.
   */
  public static int getUpperBound(Property property)
  {
    return defaultSDOHelper.getUpperBound(property);
  }

  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#getLowerBound(Property)}.
   */
  public static int getLowerBound(Property property)
  {
    return defaultSDOHelper.getLowerBound(property);
  }
  
  public static List getEnumerationFacet(Type type) {
	  return defaultSDOHelper.getEnumerationFacet(type);
  }

  public static List getPatternFacet(Type type) {
	  return defaultSDOHelper.getPatternFacet(type);
  }
	     
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#isMany(Property, DataObject)}.
   */
  public static boolean isMany(Property property, DataObject context) 
  {
    return defaultSDOHelper.isMany(property, context);
  }

  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#createDataGraph}.
   */
  public static DataGraph createDataGraph()
  {
    return defaultSDOHelper.createDataGraph();
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#setRootObject(DataGraph, DataObject)}.
   */
  public static void setRootObject(DataGraph dataGraph, DataObject rootObject)
  {
    defaultSDOHelper.setRootObject(dataGraph, rootObject);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#loadDataGraph(InputStream, Map, TypeHelper)}.
   */
  public static DataGraph loadDataGraph(InputStream inputStream, Map options) throws IOException
  {
    return defaultSDOHelper.loadDataGraph(inputStream, options, (HelperContext)null);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#loadDataGraph(InputStream, Map, HelperContext)}.
   */
  public static DataGraph loadDataGraph(InputStream inputStream, Map options, HelperContext hc) throws IOException
  {
    return defaultSDOHelper.loadDataGraph(inputStream, options, hc);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#saveDataGraph(DataGraph, OutputStream, Map)}.
   */
  public static void saveDataGraph(DataGraph dataGraph, OutputStream outputStream, Map options) throws IOException
  {
    defaultSDOHelper.saveDataGraph(dataGraph, outputStream, options);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#registerDataGraphTypes(DataGraph, List)}.
   */
  public static void registerDataGraphTypes(DataGraph dataGraph, List/*Type*/ types)
  {
    defaultSDOHelper.registerDataGraphTypes(dataGraph, types);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#createHelperContext(boolean,Map)}.
   */  
  public static HelperContext createHelperContext(boolean extensibleNamespaces,Map options){
	  return defaultSDOHelper.createHelperContext(extensibleNamespaces, options);
  }
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#createHelperContext(boolean)}.
   */
  public static HelperContext createHelperContext(boolean extensibleNamespaces)
  {
    return defaultSDOHelper.createHelperContext(extensibleNamespaces);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#createHelperContext}.
   */
  public static HelperContext createHelperContext(Map options)
  {
    return defaultSDOHelper.createHelperContext(options);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#createHelperContext}.
   */
  public static HelperContext createHelperContext()
  {
    return defaultSDOHelper.createHelperContext();
  }
  
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#createCrossScopeCopyHelper(HelperContext)}.
   */
  public static CopyHelper createCrossScopeCopyHelper(HelperContext hc) 
  {
    return defaultSDOHelper.createCrossScopeCopyHelper(hc); 
  }
  
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#createXMLStreamHelper(HelperContext)}.
   */
  public static XMLStreamHelper createXMLStreamHelper(HelperContext hc)
  {
    return defaultSDOHelper.createXMLStreamHelper(hc);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#createObjectInputStream(InputStream, HelperContext)}.
   */
  public static ObjectInputStream createObjectInputStream(InputStream inputStream, HelperContext helperContext) throws IOException
  {
    return defaultSDOHelper.createObjectInputStream(inputStream, helperContext);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#createObjectOutputStream(OutputStream, HelperContext)}.
   */
  public static ObjectOutputStream createObjectOutputStream(OutputStream outputStream, HelperContext helperContext) throws IOException
  {
    return defaultSDOHelper.createObjectOutputStream(outputStream, helperContext);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#getTypes(HelperContext, String)}.
   */
  public static List getTypes(HelperContext hc, String uri) {

    return defaultSDOHelper.getTypes(hc, uri);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#getOpenContentProperties(DataObject)}.
   */
  public static List getOpenContentProperties(DataObject dataObject)
  {
    return defaultSDOHelper.getOpenContentProperties(dataObject);
  }

  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#isDocumentRoot(Type)}.
   */
  public static boolean isDocumentRoot(Type type)
  {
    return defaultSDOHelper.isDocumentRoot(type);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#getXPath(DataObject)}.
   */
  public static String getXPath(DataObject dataObject) 
  {
    return defaultSDOHelper.getXPath(dataObject);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#createType(HelperContext, String, String, boolean)}.
   */
  public static Type createType(HelperContext hc, String uri, String name, boolean isDataType)
  {
    return defaultSDOHelper.getMetaDataBuilder().createType(hc, uri, name, isDataType);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#addBaseType(Type, Type)}.
   */
  public static void addBaseType(Type type, Type baseType)
  {
    defaultSDOHelper.getMetaDataBuilder().addBaseType(type, baseType);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#addAliasName(Type, String)}.
   */
  public static void addAliasName(Type type, String aliasName)
  {
    defaultSDOHelper.getMetaDataBuilder().addAliasName(type, aliasName);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#setOpen(Type, boolean)}.
   */
  public static void setOpen(Type type, boolean isOpen)
  {
    defaultSDOHelper.getMetaDataBuilder().setOpen(type, isOpen);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#setSequenced(Type, boolean)}.
   */
  public static void setSequenced(Type type, boolean isSequenced)
  {
    defaultSDOHelper.getMetaDataBuilder().setSequenced(type, isSequenced);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#setAbstract(Type, boolean)}.
   */
  public static void setAbstract(Type type, boolean isAbstract)
  {
    defaultSDOHelper.getMetaDataBuilder().setAbstract(type, isAbstract);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#setJavaClassName(Type, String)}.
   */
  public static void setJavaClassName(Type type, String javaClassName)
  {
    defaultSDOHelper.getMetaDataBuilder().setJavaClassName(type, javaClassName);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#createProperty(Type, String, Type)}.
   */
  public static Property createProperty(Type containingType, String name, Type propertyType)
  {
    return defaultSDOHelper.getMetaDataBuilder().createProperty(containingType, name, propertyType);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#setPropertyXMLKind(Property, boolean)}.
   */
  public static void setPropertyXMLKind(Property property, boolean isXmlElement) {
      defaultSDOHelper.getMetaDataBuilder().setPropertyXMLKind(property, isXmlElement);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#createOpenContentProperty(TypeHelper, String, String, Type)}.
   */
  public static Property createOpenContentProperty(HelperContext hc, String uri, String name, Type type)
  {
    return defaultSDOHelper.getMetaDataBuilder().createOpenContentProperty(hc, uri, name, type);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#addAliasName(Property, String)}.
   */
  public static void addAliasName(Property property, String aliasName)
  {
    defaultSDOHelper.getMetaDataBuilder().addAliasName(property, aliasName);
  }
 
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#setMany(Property, boolean)}.
   */
  public static void setMany(Property property, boolean isMany)
  {
    defaultSDOHelper.getMetaDataBuilder().setMany(property, isMany);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#setContainment(Property, boolean)}.
   */
  public static void setContainment(Property property, boolean isContainment)
  {
    defaultSDOHelper.getMetaDataBuilder().setContainment(property, isContainment);
  }

  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#setDefault(Property, String)}.
   */
  public static void setDefault(Property property, String defaultValue)
  {
    defaultSDOHelper.getMetaDataBuilder().setDefault(property, defaultValue);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#setReadOnly(Property, boolean)}.
   */
  public static void setReadOnly(Property property, boolean isReadOnly)
  {
    defaultSDOHelper.getMetaDataBuilder().setReadOnly(property, isReadOnly);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#setOpposite(Property, Property)}.
   */
  public static void setOpposite(Property property, Property opposite)
  {
    defaultSDOHelper.getMetaDataBuilder().setOpposite(property, opposite);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#addTypeInstanceProperty(Type, Property, Object)}.
   */
  public static void addTypeInstanceProperty(Type definedType, Property property, Object value)
  {
    defaultSDOHelper.getMetaDataBuilder().addTypeInstanceProperty(definedType, property, value);
  }

  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#addPropertyInstanceProperty(Property, Property, Object)}.
   */
  public static void addPropertyInstanceProperty(Property definedProperty, Property property, Object value)
  {
    defaultSDOHelper.getMetaDataBuilder().addPropertyInstanceProperty(definedProperty, property, value);
  }
  

  /**
   * @see SDOHelper#addChangeListener(DataObject, EventListener)
   * @param dob
   * @param l
   */
  public static void addChangeListener(DataObject dob, EventListener l) {
    defaultSDOHelper.addChangeListener(dob, l);
  }

  /**
   * @see SDOHelper#addChangeListener(DataObject, EventListener)
   * @param dob
   * @param l
   */
  public static void removeChangeListener(DataObject dob, EventListener l) {
    defaultSDOHelper.removeChangeListener(dob, l);
  }
  
  
}
