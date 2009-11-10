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

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.tuscany.sdo.api.SDOHelper.XMLOptions;
import org.apache.tuscany.sdo.helper.DataFactoryImpl;
import org.apache.tuscany.sdo.helper.HelperContextImpl;
import org.apache.tuscany.sdo.helper.SDOExtendedMetaDataImpl;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;
import org.apache.tuscany.sdo.helper.XMLHelperImpl;
import org.apache.tuscany.sdo.helper.XMLStreamHelper;
import org.apache.tuscany.sdo.helper.XSDHelperImpl;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.Type;
import commonj.sdo.helper.CopyHelper;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;

/**
 * This class provides some useful static utility functions which are not specified in the SDO 
 *  specification itself. Use of the functions in this class is recommended, instead of resorting 
 *  to low-level implementation-specific APIs.
 *  @deprecated
 *  @see {@link org.apache.tuscany.sdo.api.SDOUtil}.
 *  @see {@link org.apache.tuscany.sdo.api.SDOHelper.XMLOptions}.
 */
public final class SDOUtil
{
  /**
   * Line Break String such as "\n", "\r\n", "\r" and "", absence/null is the default (line.separator System Property)
   *  @deprecated see {@link org.apache.tuscany.sdo.api.SDOHelper.XMLOptions}.
   */
  static public final String XML_SAVE_LineBreak = XMLOptions.XML_SAVE_LINE_BREAK,
  /**
   * Indent String such as "\t", "", etc. absence/null is the default ("  ")
   */
  XML_SAVE_INDENT = XMLOptions.XML_SAVE_INDENT,
  /**
   * Margin String such as " ", "\t\t", etc. Absence/null/"" is the default (no margin)
   */
  XML_SAVE_MARGIN = XMLOptions.XML_SAVE_MARGIN,
  /**
   * Attribute formatting that exceeds the specified width as Integer will cause a line break so that formatting will continue indented on the next line
   */
  XML_SAVE_LineWidth = XMLOptions.XML_SAVE_LINE_WIDTH,
  /**
   * Boolean to save a doctype declaration 
   */
  XML_SAVE_DocType = XMLOptions.XML_SAVE_DOCTYPE,
  /**
   * Boolean to process the schemaLocation/noNamespaceSchemaLocation attributes occurring in the instance document to {@link XSDHelper#define convert XSD(s) to Types} 
   */
  XML_LOAD_SCHEMA = XMLOptions.XML_LOAD_SCHEMA,
  /**
   * To tolerate malformed elements and attributes (default unless set by System property XML.load.form.lax). 0 not to.  
   */
  XML_LOAD_LaxForm = XMLOptions.XML_LOAD_LAX_FORM;

  /**
   * Create a new TypeHelper instance. The returned type helper will have visibility of types registered
   *  directly by calling a define method on it or by calling define on an associated XSDHelper. It will
   *  also have visibility of static types registered by calling SDOUtil.registerStaticTypes in the 
   *  same classLoader scope.
   * @return the new TypeHelper.
   * @deprecated see {@link org.apache.tuscany.sdo.api.SDOUtil#createHelperContext}
   */
  public static TypeHelper createTypeHelper()
  {
    EPackage.Registry registry = new EPackageRegistryImpl(EPackage.Registry.INSTANCE);
    ExtendedMetaData extendedMetaData = new SDOExtendedMetaDataImpl(registry); //TODO create subclass that makes demand() methods synchronous
    //return new TypeHelperImpl(extendedMetaData);
    return (new HelperContextImpl(extendedMetaData, false)).getTypeHelper();
  }

  /**
   * Create a new DataFactory, with visibility to types in the specified TypeHelper scope.
   * @param scope the TypeHelper to use for locating types.
   * @return the new DataFactory.
   * @deprecated see {@link org.apache.tuscany.sdo.api.SDOUtil#createHelperContext}
   */
  public static DataFactory createDataFactory(TypeHelper scope)
  {
	  return ((TypeHelperImpl)scope).getHelperContext().getDataFactory();
  }

  /**
   * Create a new XMLHelper, with visibility to types in the specified TypeHelper scope.
   * @param scope the TypeHelper to use for locating types.
   * @return the new XMLHelper.
   * @deprecated see {@link org.apache.tuscany.sdo.api.SDOUtil#createHelperContext}
   */
  public static XMLHelper createXMLHelper(TypeHelper scope)
  {
	  return ((TypeHelperImpl)scope).getHelperContext().getXMLHelper();
  }
  
  /**
   * Create a new XSDHelper, with visibility to types in the specified TypeHelper scope.
   * @param scope the TypeHelper to use for locating and populating types.
   * @return the new XSDHelper.
   * @deprecated see {@link org.apache.tuscany.sdo.api.SDOUtil#createHelperContext}
   */
  public static XSDHelper createXSDHelper(TypeHelper scope)
  {
	  return ((TypeHelperImpl)scope).getHelperContext().getXSDHelper();
  }
  
  /**
   * @deprecated see {@link org.apache.tuscany.sdo.api.SDOUtil#addTypeInstanceProperty(Type, Property, Object}
   */
  public static void addTypeInstanceProperties(Type definedType, DataObject modeledType)
  {
    List instanceProperties = getOpenContentProperties(modeledType);
    for (Iterator iter = instanceProperties.iterator(); iter.hasNext(); )
    {
      Property property = (Property)iter.next();
      org.apache.tuscany.sdo.api.SDOUtil.addTypeInstanceProperty(definedType, property, modeledType.get(property));
    }
  }

  /**
   * @deprecated see {@link org.apache.tuscany.sdo.api.SDOUtil#addPropertyInstanceProperty(Property, Property, Object}
   */
  public static void addPropertyInstanceProperties(Property definedProperty, DataObject modeledProperty)
  {
    List instanceProperties = getOpenContentProperties(modeledProperty);
    for (Iterator iter = instanceProperties.iterator(); iter.hasNext(); )
    {
      Property property = (Property)iter.next();
      org.apache.tuscany.sdo.api.SDOUtil.addPropertyInstanceProperty(definedProperty, property, modeledProperty.get(property));
    }
  }
 
  /**
   * Register and initialize the SDO types supported by the specified generated factory class.
   *  This function must be called before instances of the generated types can be created/used.
   *  The registered types will be visible in all TypeHelper's created in the same classLoader
   *  scope as the call to this function.
   * @param factoryClass the generated factory class.
   * @deprecated see the register(HelperContext) metods on generated Factory classes
   */
  public static void registerStaticTypes(Class factoryClass)
  {
    //TODO this implementation is temporary, until the SDO generated factory pattern is decided
    //TODO might want to clean this implementation in the light of the requirement to regenerate all classes
    //after noEMF became the default, so we have no compatibility requirements (unless we
    //cater for the simple hand edit that would make M2 generated classes work) -- as this is
    //deprecated I'm going to do nothing for now
    //
    String temp = factoryClass.getName().replaceFirst("Factory$", "PackageImpl");
    int lastDot = temp.lastIndexOf('.');
    String packageName = temp.substring(0, lastDot) + ".impl" + temp.substring(lastDot);
    
    try // this case handles the old style EMF pattern
    {
      Class javaClass = getPackageClass(factoryClass, packageName);
      Field field = javaClass.getField("eINSTANCE");
      EPackageImpl pkg = (EPackageImpl)field.get(null);
      EPackage.Registry.INSTANCE.put(pkg.getNsURI(), pkg);
    }
    catch (Exception e1)
    {
      packageName = factoryClass.getName().replaceFirst("Factory$", "Package");
      try // this case handles the EMF -noInterfaces generator pattern
      {
        Class javaClass = getPackageClass(factoryClass, packageName);
        Field field = javaClass.getField("eINSTANCE");
        EPackageImpl pkg = (EPackageImpl)field.get(null);
        EPackage.Registry.INSTANCE.put(pkg.getNsURI(), pkg);
      }
      catch (Exception e2)
      {
        try // this case handles the default (was -noEMF) generator pattern
        {
          Field field = factoryClass.getField("INSTANCE");
          EPackageImpl pkg = (EPackageImpl)field.get(null);
          EPackage.Registry.INSTANCE.put(pkg.getNsURI(), pkg);
          // TODO -- decide if we should block global initialization of Factories with the new register method.
        }
        catch (Exception e3)
        {
          e3.printStackTrace();
        }
      }
    }
  }

  /**
   * @deprecated
   */
  private static Class getPackageClass(Class factoryClass, String packageName) throws Exception
  {
    final Class factoryClassTemp = factoryClass;
    final String packageNameTemp = packageName;
    return (Class)AccessController.doPrivileged(new PrivilegedExceptionAction() {
        public Object run() throws Exception {
          return factoryClassTemp.getClassLoader().loadClass(packageNameTemp);
        }
      });
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#createDataTypeWrapper(Type, Object)}.
   * @deprecated
   */
  public static DataObject createDataTypeWrapper(Type dataType, Object value)
  {
    return org.apache.tuscany.sdo.api.SDOUtil.createDataTypeWrapper(dataType, value);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#createFromString(Type, String)}.
   * @deprecated
   */
  public static Object createFromString(Type dataType, String literal)
  {
    return org.apache.tuscany.sdo.api.SDOUtil.createFromString(dataType, literal);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#convertToString(Type, Object)}.
   * @deprecated
   */
  public static String convertToString(Type dataType, Object value)
  {
    return org.apache.tuscany.sdo.api.SDOUtil.convertToString(dataType, value);
  }

  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#getXSDSDOType(String)}.
   * @deprecated
   */
  public static Type getXSDSDOType(String xsdType)
  {    
    return org.apache.tuscany.sdo.api.SDOUtil.getXSDSDOType(xsdType);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#getSubstitutionValues(DataObject, Property)}.
   * @deprecated
   */
  public static Sequence getSubstitutionValues(DataObject dataObject, Property head)
  {
    return org.apache.tuscany.sdo.api.SDOUtil.getSubstitutionValues(dataObject, head);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#getJavaSDOType(Class)}.
   * @deprecated
   */
  public static Type getJavaSDOType(Class javaClass)
  {    
    return org.apache.tuscany.sdo.api.SDOUtil.getJavaSDOType(javaClass);
  }

  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#isRequired(Property)}.
   * @deprecated
   */
  public static boolean isRequired(Property property)
  {
    return org.apache.tuscany.sdo.api.SDOUtil.isRequired(property);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#getUpperBound(Property)}.
   * @deprecated
   */
  public static int getUpperBound(Property property)
  {
    return org.apache.tuscany.sdo.api.SDOUtil.getUpperBound(property);
  }

  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#isMany(Property, DataObject)}.
   * @deprecated
   */
  public static boolean isMany(Property property, DataObject context) 
  {
    return org.apache.tuscany.sdo.api.SDOUtil.isMany(property, context);
  }

  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#createDataGraph}.
   * @deprecated
   */
  public static DataGraph createDataGraph()
  {
    return org.apache.tuscany.sdo.api.SDOUtil.createDataGraph();
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#setRootObject(DataGraph, DataObject)}.
   * @deprecated
   */
  public static void setRootObject(DataGraph dataGraph, DataObject rootObject)
  {
    org.apache.tuscany.sdo.api.SDOUtil.setRootObject(dataGraph, rootObject);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#loadDataGraph(InputStream, Map, TypeHelper)}.
   * @deprecated
   */
  public static DataGraph loadDataGraph(InputStream inputStream, Map options) throws IOException
  {
    return org.apache.tuscany.sdo.api.SDOUtil.loadDataGraph(inputStream, options, (HelperContext)null);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#loadDataGraph(InputStream, Map, TypeHelper)}.
   * @deprecated
   */
  public static DataGraph loadDataGraph(InputStream inputStream, Map options, TypeHelper scope) throws IOException
  {
    return org.apache.tuscany.sdo.api.SDOUtil.loadDataGraph(inputStream, options, ((TypeHelperImpl)scope).getHelperContext());
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#saveDataGraph(DataGraph, OutputStream, Map)}.
   * @deprecated
   */
  public static void saveDataGraph(DataGraph dataGraph, OutputStream outputStream, Map options) throws IOException
  {
    org.apache.tuscany.sdo.api.SDOUtil.saveDataGraph(dataGraph, outputStream, options);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#registerDataGraphTypes(DataGraph, List)}.
   * @deprecated
   */
  public static void registerDataGraphTypes(DataGraph dataGraph, List/*Type*/ types)
  {
    org.apache.tuscany.sdo.api.SDOUtil.registerDataGraphTypes(dataGraph, types);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#createHelperContext(boolean)}.
   * @deprecated
   */
  public static HelperContext createHelperContext(boolean extensibleNamespaces)
  {
    return org.apache.tuscany.sdo.api.SDOUtil.createHelperContext(extensibleNamespaces);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#createHelperContext}.
   * @deprecated
   */
  public static HelperContext createHelperContext()
  {
    return org.apache.tuscany.sdo.api.SDOUtil.createHelperContext();
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#createCrossScopeCopyHelper(TypeHelper)}.
   * @deprecated
   */
  public static CopyHelper createCrossScopeCopyHelper(TypeHelper targetScope) 
  {
    return org.apache.tuscany.sdo.api.SDOUtil.createCrossScopeCopyHelper(((TypeHelperImpl)targetScope).getHelperContext()); 
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#createXMLStreamHelper(TypeHelper)}.
   * @deprecated
   */
  public static XMLStreamHelper createXMLStreamHelper(TypeHelper scope)
  {
    return (XMLStreamHelper)org.apache.tuscany.sdo.api.SDOUtil.createXMLStreamHelper(((TypeHelperImpl)scope).getHelperContext());
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#createObjectInputStream(InputStream, HelperContext)}.
   * @deprecated
   */
  public static ObjectInputStream createObjectInputStream(InputStream inputStream, HelperContext helperContext) throws IOException
  {
    return org.apache.tuscany.sdo.api.SDOUtil.createObjectInputStream(inputStream, helperContext);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#createObjectOutputStream(OutputStream, HelperContext)}.
   * @deprecated
   */
  public static ObjectOutputStream createObjectOutputStream(OutputStream outputStream, HelperContext helperContext) throws IOException
  {
    return org.apache.tuscany.sdo.api.SDOUtil.createObjectOutputStream(outputStream, helperContext);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#getTypes(TypeHelper, String)}.
   * @deprecated
   */
  public static List getTypes(TypeHelper scope, String uri) {

    return org.apache.tuscany.sdo.api.SDOUtil.getTypes(((TypeHelperImpl)scope).getHelperContext(), uri);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#getOpenContentProperties(DataObject)}.
   * @deprecated
   */
  public static List getOpenContentProperties(DataObject dataObject)
  {
    return org.apache.tuscany.sdo.api.SDOUtil.getOpenContentProperties(dataObject);
  }

  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper#isDocumentRoot(Type)}.
   * @deprecated
   */
  public static boolean isDocumentRoot(Type type)
  {
    return org.apache.tuscany.sdo.api.SDOUtil.isDocumentRoot(type);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#createType(TypeHelper, String, String, boolean)}.
   * @deprecated
   */
  public static Type createType(TypeHelper scope, String uri, String name, boolean isDataType)
  {
    return org.apache.tuscany.sdo.api.SDOUtil.createType(((TypeHelperImpl)scope).getHelperContext(), uri, name, isDataType);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#addBaseType(Type, Type)}.
   * @deprecated
   */
  public static void addBaseType(Type type, Type baseType)
  {
    org.apache.tuscany.sdo.api.SDOUtil.addBaseType(type, baseType);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#addAliasName(Type, String)}.
   * @deprecated
   */
  public static void addAliasName(Type type, String aliasName)
  {
    org.apache.tuscany.sdo.api.SDOUtil.addAliasName(type, aliasName);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#setOpen(Type, boolean)}.
   * @deprecated
   */
  public static void setOpen(Type type, boolean isOpen)
  {
    org.apache.tuscany.sdo.api.SDOUtil.setOpen(type, isOpen);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#setSequenced(Type, boolean)}.
   * @deprecated
   */
  public static void setSequenced(Type type, boolean isSequenced)
  {
    org.apache.tuscany.sdo.api.SDOUtil.setSequenced(type, isSequenced);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#setAbstract(Type, boolean)}.
   * @deprecated
   */
  public static void setAbstract(Type type, boolean isAbstract)
  {
    org.apache.tuscany.sdo.api.SDOUtil.setAbstract(type, isAbstract);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#setJavaClassName(Type, String)}.
   * @deprecated
   */
  public static void setJavaClassName(Type type, String javaClassName)
  {
    org.apache.tuscany.sdo.api.SDOUtil.setJavaClassName(type, javaClassName);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#createProperty(Type, String, Type)}.
    * @deprecated
  */
  public static Property createProperty(Type containingType, String name, Type propertyType)
  {
    return org.apache.tuscany.sdo.api.SDOUtil.createProperty(containingType, name, propertyType);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#createGlobalProperty(TypeHelper, String, String, Type)}.
   * @deprecated
   */
  public static Property createGlobalProperty(TypeHelper scope, String uri, String name, Type type)
  {
    return org.apache.tuscany.sdo.api.SDOUtil.createOpenContentProperty(((TypeHelperImpl)scope).getHelperContext(), uri, name, type);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#addAliasName(Property, String)}.
   * @deprecated
   */
  public static void addAliasName(Property property, String aliasName)
  {
    org.apache.tuscany.sdo.api.SDOUtil.addAliasName(property, aliasName);
  }
 
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#setMany(Property, boolean)}.
   * @deprecated
   */
  public static void setMany(Property property, boolean isMany)
  {
    org.apache.tuscany.sdo.api.SDOUtil.setMany(property, isMany);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#setContainment(Property, boolean)}.
   * @deprecated
   */
  public static void setContainment(Property property, boolean isContainment)
  {
    org.apache.tuscany.sdo.api.SDOUtil.setContainment(property, isContainment);
  }

  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#setDefault(Property, String)}.
   * @deprecated
   */
  public static void setDefault(Property property, String defaultValue)
  {
    org.apache.tuscany.sdo.api.SDOUtil.setDefault(property, defaultValue);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#setReadOnly(Property, boolean)}.
   * @deprecated
   */
  public static void setReadOnly(Property property, boolean isReadOnly)
  {
    org.apache.tuscany.sdo.api.SDOUtil.setReadOnly(property, isReadOnly);
  }
  
  /**
   * @see {@link org.apache.tuscany.sdo.api.SDOHelper.MetaDataBuilder#setOpposite(Property, Property)}.
   * @deprecated
   */
  public static void setOpposite(Property property, Property opposite)
  {
    org.apache.tuscany.sdo.api.SDOUtil.setOpposite(property, opposite);
  }
    
}
