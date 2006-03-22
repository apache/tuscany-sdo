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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.tuscany.sdo.SDOExtendedMetaData;
import org.apache.tuscany.sdo.SDOFactory;
import org.apache.tuscany.sdo.SDOPackage;
import org.apache.tuscany.sdo.helper.DataFactoryImpl;
import org.apache.tuscany.sdo.helper.SDOExtendedMetaDataImpl;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;
import org.apache.tuscany.sdo.helper.XMLHelperImpl;
import org.apache.tuscany.sdo.helper.XSDHelperImpl;
import org.apache.tuscany.sdo.impl.DataGraphImpl;
import org.apache.tuscany.sdo.model.ModelFactory;
import org.apache.tuscany.sdo.model.impl.ModelPackageImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import commonj.sdo.DataGraph;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;

/**
 * This class provides some useful static utility functions which are not specified in the SDO 
 *  specification itself. Use of the functions in this class is recommended, instead of resorting 
 *  to low-level implementation-specific APIs.
 */
public final class SDOUtil
{
  //XSD to SDO Mappings mappings (p.95 of the SDO spec)
  private static Map<String,String> xsdToSdoMappings = new HashMap<String,String>();
  static {
    xsdToSdoMappings.put("anySimpleType", "Object");
    xsdToSdoMappings.put("anyType", "DataObject");
    xsdToSdoMappings.put("anyURI", "URI");
    xsdToSdoMappings.put("base64Binary", "Bytes");
    xsdToSdoMappings.put("boolean", "Boolean");
    xsdToSdoMappings.put("byte", "Byte");
    xsdToSdoMappings.put("date", "YearMonthDay");
    xsdToSdoMappings.put("dateTime", "DateTime");
    xsdToSdoMappings.put("decimal", "Decimal");
    xsdToSdoMappings.put("double", "Double");
    xsdToSdoMappings.put("duration", "Duration");
    xsdToSdoMappings.put("ENTITIES", "Strings");
    xsdToSdoMappings.put("ENTITY", "String");
    xsdToSdoMappings.put("float", "Float");
    xsdToSdoMappings.put("gDay", "Day");
    xsdToSdoMappings.put("gMonth", "Month");
    xsdToSdoMappings.put("gMonthDay", "MonthDay");
    xsdToSdoMappings.put("gYear", "Year");
    xsdToSdoMappings.put("gYearMonth", "YearMonth");
    xsdToSdoMappings.put("hexBinary", "Bytes");
    xsdToSdoMappings.put("ID","String");
    xsdToSdoMappings.put("IDREF","String");
    xsdToSdoMappings.put("IDREFS","Strings");
    xsdToSdoMappings.put("int","Int");
    xsdToSdoMappings.put("integer","Integer");
    xsdToSdoMappings.put("language","String");
    xsdToSdoMappings.put("long","Long");
    xsdToSdoMappings.put("Name","String");
    xsdToSdoMappings.put("NCName","String");
    xsdToSdoMappings.put("negativeInteger","Integer");
    xsdToSdoMappings.put("NMTOKEN","String");
    xsdToSdoMappings.put("NMTOKENS","Strings");
    xsdToSdoMappings.put("nonNegativeInteger","Integer");
    xsdToSdoMappings.put("nonPositiveInteger","Integer");
    xsdToSdoMappings.put("normalizedString","String");
    xsdToSdoMappings.put("NOTATION","String");
    xsdToSdoMappings.put("positiveInteger","Integer");
    xsdToSdoMappings.put("QName","URI");
    xsdToSdoMappings.put("short","Short");
    xsdToSdoMappings.put("string","String");
    xsdToSdoMappings.put("time","Time");
    xsdToSdoMappings.put("token","String");
    xsdToSdoMappings.put("unsignedByte","Short");
    xsdToSdoMappings.put("unsignedInt","Long");
    xsdToSdoMappings.put("unsignedLong","Integer");
    xsdToSdoMappings.put("unsignedShort","Int");
  }
  
  /**
   * Creates an instance of a data type from the specified string.
   * @param dataType a Type, for which isDataType() returns true, to instantiate.
   * @param literal the string value of the dataType.
   * @return an instance of the dataType.
   * @see #convertToString(Type, Object)
   */
  public static Object createFromString(Type dataType, String literal)
  {
    return EcoreUtil.createFromString((EDataType)dataType, literal);
  }
  
  /**
   * Converts an instance of a data type to a string literal representation.
   * @param dataType the Type, for which isDataType() returns true, of the value to convert.
   * @param value a value of the dataType.
   * @return the string literal representation of the value.
   * @see #createFromString(Type, String)
   */
  public static String convertToString(Type dataType, Object value)
  {
    return EcoreUtil.convertToString((EDataType)dataType, value);
  }

  /**
   * Get the SDO built-in type corresponding to the specified XSD type in the XML Schema
   * namespace ("http://www.w3.org/2001/XMLSchema").
   * @param xsdType a type name in the XML Schema namespace.
   * @return the SDO built-in Type corresponding to the specified XSD type.
   */
  public static Type getXSDSDOType(String xsdType)
  {    
    Type type = null;
    if ("anyType".equals(xsdType)) {
      type = (Type)SDOPackage.eINSTANCE.getDataObject();
    } else {
      String name = xsdToSdoMappings.get(xsdType);
      if (name != null) {
        type = (Type)ModelPackageImpl.eINSTANCE.getEClassifier(name);
      } else {
        type = (Type)SDOExtendedMetaData.INSTANCE.getType(XMLTypePackage.eINSTANCE, xsdType);
      }
    }
    return type;
  }
  
  /**
   * Create an empty data graph.
   * @return the new data graph instance.
   */
  public static DataGraph createDataGraph()
  {
    return SDOFactory.eINSTANCE.createDataGraph();
  }
  
  /**
   * Load a serialized data graph from the specified insputStream.
   * @param inputStream the inputStream of the data graph.
   * @param options loader control options, or null.
   * @return the de-serialized data graph.
   * @throws IOException
   */
  public static DataGraph loadDataGraph(InputStream inputStream, Map options) throws IOException
  {
    ResourceSet resourceSet = DataObjectUtil.createResourceSet();
    Resource resource = resourceSet.createResource(URI.createURI("all.datagraph"));
    resource.load(inputStream, options);
    return (DataGraph)resource.getContents().get(0);
  }
  
  /**
   * Serialize the specified data graph to the specified outputStream.
   * @param dataGraph the data graph to save.
   * @param outputStream the outputStream for the data graph.
   * @param options serializer control options, or null.
   * @throws IOException
   */
  public static void saveDataGraph(DataGraph dataGraph, OutputStream outputStream, Map options) throws IOException
  {
    ((DataGraphImpl)dataGraph).getDataGraphResource().save(outputStream, options);
  }
  
  /**
   * Create a new TypeHelper instance. The returned type helper will have visibility of types registered
   *  directly by calling a define method on it or by calling define on an associated XSDHelper. It will
   *  also have visibility of static types registered by calling SDOUtil.registerStaticTypes in the 
   *  same classLoader scope.
   * @return the new TypeHelper.
   */
  public static TypeHelper createTypeHelper()
  {
    EPackage.Registry registry = new EPackageRegistryImpl(EPackage.Registry.INSTANCE);
    ExtendedMetaData extendedMetaData = new SDOExtendedMetaDataImpl(registry); //TODO create subclass that makes demand() methods synchronous
    return new TypeHelperImpl(extendedMetaData);
  }

  /**
   * Create a new DataFactory, with visibility to types in the specified TypeHelper scope.
   * @param scope the TypeHelper to use for locating types.
   * @return the new DataFactory.
   */
  public static DataFactory createDataFactory(TypeHelper scope)
  {
    return new DataFactoryImpl(scope);
  }

  /**
   * Create a new XMLHelper, with visibility to types in the specified TypeHelper scope.
   * @param scope the TypeHelper to use for locating types.
   * @return the new XMLHelper.
   */
  public static XMLHelper createXMLHelper(TypeHelper scope)
  {
    return new XMLHelperImpl(scope);
  }

  /**
   * Create a new XSDHelper, with visibility to types in the specified TypeHelper scope.
   * @param scope the TypeHelper to use for locating and populating types.
   * @return the new XSDHelper.
   */
  public static XSDHelper createXSDHelper(TypeHelper scope)
  {
    return new XSDHelperImpl(scope);
  }
  
  /**
   * Register and initialize the SDO types supported by the specified generated factory class.
   *  This function must be called before instances of the generated types can be created/used.
   *  The registered types will be visible in all TypeHelper's created in the same classLoader
   *  scope as the call to this function.
   * @param factoryClass the generated factory class.
   */
  public static void registerStaticTypes(Class factoryClass)
  {
    //TODO this implementation is a temporary kludge until the SDO generated factory pattern is decided
    String temp = factoryClass.getName().replaceFirst("Factory$", "PackageImpl");
    int lastDot = temp.lastIndexOf('.');
    String packageName = temp.substring(0, lastDot) + ".impl" + temp.substring(lastDot);
    try
    {
      Class javaClass = factoryClass.getClassLoader().loadClass(packageName);
      Field field = javaClass.getField("eINSTANCE");
      field.get(null); 
    }
    catch (Exception e1)
    {
      packageName = factoryClass.getName().replaceFirst("Factory$", "Package");
      try
      {
        Class javaClass = factoryClass.getClassLoader().loadClass(packageName);
        Field field = javaClass.getField("eINSTANCE");
        field.get(null); 
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }

  /**
   * Initialize SDO runtime.
   */
  static
  {
    DataObjectUtil.initRuntime();
  }
  
}
