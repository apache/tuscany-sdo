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
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.tuscany.sdo.SDOExtendedMetaData;
import org.apache.tuscany.sdo.SDOFactory;
import org.apache.tuscany.sdo.SDOPackage;
import org.apache.tuscany.sdo.SimpleAnyTypeDataObject;
import org.apache.tuscany.sdo.helper.DataFactoryImpl;
import org.apache.tuscany.sdo.helper.SDOExtendedMetaDataImpl;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;
import org.apache.tuscany.sdo.helper.XMLHelperImpl;
import org.apache.tuscany.sdo.helper.XSDHelperImpl;
import org.apache.tuscany.sdo.impl.DataGraphImpl;
import org.apache.tuscany.sdo.impl.DynamicDataObjectImpl;
import org.apache.tuscany.sdo.model.impl.ModelPackageImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.Property;
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
  /**
   * Create a DataObject wrapper for an instance of the specified dataType.
   * This method is typically used to create a root object that can be passed to the XMLHelper.save() 
   * method when the root element to be serialized is an XMLSchema simpleType.
   * @param dataType a Type for which isDataType() returns true.
   * @param value the instance value.
   * @return a DataObject wrapper for the specified value.
   */
  public static DataObject createDataTypeWrapper(Type dataType, Object value)
  {
    SimpleAnyTypeDataObject simpleAnyType = SDOFactory.eINSTANCE.createSimpleAnyTypeDataObject();
    simpleAnyType.setInstanceType((EDataType)dataType);
    simpleAnyType.setValue(value);
    return simpleAnyType;
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
      String name = (String)xsdToSdoMappings.get(xsdType);
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
  
  public static Type createType(TypeHelper scope, String uri, String name, boolean isDataType)
  {
    ExtendedMetaData extendedMetaData = ((TypeHelperImpl)scope).getExtendedMetaData();
    
    EPackage ePackage = extendedMetaData.getPackage(uri);
    if (ePackage == null)
    {
      ePackage = EcoreFactory.eINSTANCE.createEPackage();
      ePackage.setEFactoryInstance(new DynamicDataObjectImpl.FactoryImpl());
      ePackage.setNsURI(uri);
      String packagePrefix = URI.createURI(uri).trimFileExtension().lastSegment();
      ePackage.setName(packagePrefix);
      ePackage.setNsPrefix(packagePrefix);
      extendedMetaData.putPackage(uri, ePackage);
    }

    EClassifier eClassifier = ePackage.getEClassifier(name);
    if (eClassifier != null)
      throw new IllegalArgumentException(); // already defined
    
    if (name != null)
    { 
      eClassifier = isDataType ? (EClassifier)SDOFactory.eINSTANCE.createDataType() : (EClassifier)SDOFactory.eINSTANCE.createClass();
      eClassifier.setName(name);
    }
    else
    {
      eClassifier = DataObjectUtil.createDocumentRoot();
    }
    
    ePackage.getEClassifiers().add(eClassifier);

    return (Type)eClassifier;
  }
  
  public static void addBaseType(Type type, Type baseType)
  {
    ((EClass)type).getESuperTypes().add(baseType);
  }
  
  public static void addAliasName(Type type, String aliasName)
  {
    throw new UnsupportedOperationException(); // TODO: implement this method properly
    //type.getAliasNames().add(aliasName);
  }
  
  public static void setOpen(Type type, boolean isOpen)
  {
    if (type.isDataType() || !type.getProperties().isEmpty())
    {
      if (type.getName() != null) //FB TEMP ... figure out how to handle document root
        throw new IllegalArgumentException(); // type must a non dataType with no properties yet
    }
    if (isOpen)
    {
      EAttribute eAttribute = EcoreFactory.eINSTANCE.createEAttribute();
      ((EClass)type).getEStructuralFeatures().add(eAttribute);

      eAttribute.setName("any");
      eAttribute.setUnique(false);
      eAttribute.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
      eAttribute.setEType(EcorePackage.eINSTANCE.getEFeatureMapEntry());
      ExtendedMetaData.INSTANCE.setFeatureKind(eAttribute, ExtendedMetaData.ELEMENT_WILDCARD_FEATURE);
      ExtendedMetaData.INSTANCE.setProcessingKind(eAttribute, ExtendedMetaData.LAX_PROCESSING);
      ExtendedMetaData.INSTANCE.setWildcards(eAttribute, Collections.singletonList("##any"));
    }
  }
  
  /*
  private static boolean hasNonWildcardFeatures(EClass eclass) {
    boolean answer = false;
    List features = eclass.getEStructuralFeatures();
    for (int n = 0; n < features.size(); n++) {
      EStructuralFeature feature = (EStructuralFeature) features.get(n);
      int kind = ExtendedMetaData.INSTANCE.getFeatureKind(feature);
      if (kind != ExtendedMetaData.ELEMENT_WILDCARD_FEATURE && 
          kind != ExtendedMetaData.ATTRIBUTE_WILDCARD_FEATURE) {
        answer = true;
        break;
      }
    }
    return answer;
  }
  */
  
  public static void setSequenced(Type type, boolean isSequenced)
  {
    if (!isSequenced) return;
    throw new UnsupportedOperationException(); // TODO: implement this method properly
    /*
    if ((isSequenced && type.isSequenced()) || 
        !isSequenced && !type.isSequenced()) return;
    if (!(type instanceof EClass)) return;
    EClass eclass = (EClass)type;
    if (type.isDataType() || hasNonWildcardFeatures(eclass))
    {
      if (type.getName() != null)
        throw new IllegalArgumentException();
    }
    if (isSequenced) {
      ExtendedMetaData.INSTANCE.setContentKind(eclass, ExtendedMetaData.MIXED_CONTENT);
      EAttribute mixedFeature = EcoreFactory.eINSTANCE.createEAttribute();
      mixedFeature.setName("mixed");
      mixedFeature.setUnique(false);
      mixedFeature.setEType(EcorePackage.eINSTANCE.getEFeatureMapEntry());
      mixedFeature.setLowerBound(0);
      mixedFeature.setUpperBound(-1);
      eclass.getEStructuralFeatures().add(mixedFeature);
      ExtendedMetaData.INSTANCE.setFeatureKind(mixedFeature, ExtendedMetaData.ELEMENT_WILDCARD_FEATURE);
      ExtendedMetaData.INSTANCE.setName(mixedFeature, ":mixed");   
    } else {
      // do I really need to do anything here?
    }
    */
  }
  
  public static void setAbstract(Type type, boolean isAbstract)
  {
    ((EClass)type).setAbstract(isAbstract);
  }
  
  public static void setJavaClassName(Type type, String javaClassName)
  {
    ((EClassifier)type).setInstanceClassName(javaClassName);
  }
  
  public static Property createProperty(Type containingType, String name, Type propertyType)
  {
    EStructuralFeature eStructuralFeature = propertyType.isDataType() ? (EStructuralFeature)SDOFactory.eINSTANCE.createAttribute() : (EStructuralFeature)SDOFactory.eINSTANCE.createReference();
    eStructuralFeature.setName(name);
    eStructuralFeature.setEType((EClassifier)propertyType);
    if (containingType.getName() == null)
    {
      ExtendedMetaData.INSTANCE.setFeatureKind(eStructuralFeature, ExtendedMetaData.ELEMENT_FEATURE);
    }
    ((EClass)containingType).getEStructuralFeatures().add(eStructuralFeature);
    return (Property)eStructuralFeature;
  }
  
  public static void addAliasName(Property property, String aliasName)
  {
    throw new UnsupportedOperationException(); // TODO: implement this method properly
    //property.getAliasNames().add(aliasName);
  }
 
  public static void setMany(Property property, boolean isMany)
  {
    ((EStructuralFeature)property).setUpperBound(isMany ? EStructuralFeature.UNBOUNDED_MULTIPLICITY : 1);
  }
  
  public static void setContainment(Property property, boolean isContainment)
  {
    ((EReference)property).setContainment(isContainment);
  }

  public static void setDefault(Property property, String defaultValue)
  {
    ((EStructuralFeature)property).setDefaultValueLiteral(defaultValue);
  }
  
  public static void setReadOnly(Property property, boolean isReadOnly)
  {
    ((EStructuralFeature)property).setChangeable(!isReadOnly);
  }
  
  public static void setOpposite(Property property, Property opposite)
  {
    ((EReference)property).setEOpposite((EReference)opposite);
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
      catch (Exception e2)
      {
        try
        {
          Field field = factoryClass.getField("INSTANCE");
          field.get(null); 
        }
        catch (Exception e3)
        {
          e3.printStackTrace();
        }
      }
    }
  }

  //XSD to SDO Mappings mappings (p.95 of the SDO spec)
  private static Map xsdToSdoMappings = new HashMap();
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
   * Initialize SDO runtime.
   */
  static
  {
    DataObjectUtil.initRuntime();
  }
  
}
