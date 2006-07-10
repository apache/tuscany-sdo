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
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.tuscany.sdo.SDOExtendedMetaData;
import org.apache.tuscany.sdo.SDOFactory;
import org.apache.tuscany.sdo.SimpleAnyTypeDataObject;
import org.apache.tuscany.sdo.helper.DataFactoryImpl;
import org.apache.tuscany.sdo.helper.SDOExtendedMetaDataImpl;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;
import org.apache.tuscany.sdo.helper.XMLHelperImpl;
import org.apache.tuscany.sdo.helper.XMLStreamHelper;
import org.apache.tuscany.sdo.helper.XMLStreamHelperImpl;
import org.apache.tuscany.sdo.helper.XSDHelperImpl;
import org.apache.tuscany.sdo.impl.DataGraphImpl;
import org.apache.tuscany.sdo.impl.DynamicDataObjectImpl;
import org.apache.tuscany.sdo.model.impl.ModelPackageImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
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
    //if ("anyType".equals(xsdType)) {
    //  type = (Type)SDOPackage.eINSTANCE.getDataObject();
    //} else {
      String name = (String)xsdToSdoMappings.get(xsdType);
      if (name != null) {
        type = (Type)ModelPackageImpl.eINSTANCE.getEClassifier(name);
      } else {
        type = (Type)SDOExtendedMetaData.INSTANCE.getType(XMLTypePackage.eINSTANCE, xsdType);
      }
    //}
    return type;
  }
  
  /**
   * Get the SDO built-in type corresponding to the specified Java instanceClass.
   * @param javaClass the Java instanceClass of the type.
   * @return the SDO built-in Type corresponding to the specified instanceClass.
   */
  public static Type getJavaSDOType(Class javaClass)
  {    
    String name = (String)javaToSdoMappings.get(javaClass);
    if (name != null)
    {
      return (Type)ModelPackageImpl.eINSTANCE.getEClassifier(name);
    }
    return null;
  }

  /**
   * Return whether at least one value is required for a valid instance of the specified property.
   * @param the property in question.
   * @return true if the property is required.
   */
  public static boolean isRequired(Property property)
  {
    return ((EStructuralFeature)property).isRequired();
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
   * Set the root object of a data graph.
   * @param dataGraph the data graph in which to set the root object.
   * @param rootObject the root object.
   */
  public static void setRootObject(DataGraph dataGraph, DataObject rootObject)
  {
    ((DataGraphImpl)dataGraph).setERootObject((EObject)rootObject);
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
   * Create a new XMLStreamHelper, with visibility to types in the specified TypeHelper scope.
   * @param scope the TypeHelper to use for locating types.
   * @return the new XMLStreamHelper.
   */
  public static XMLStreamHelper createXMLStreamHelper(TypeHelper scope)
  {
    return new XMLStreamHelperImpl(scope);
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
    if (isOpen == type.isOpen()) return;

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
      
      if (type.isSequenced()) {
        eAttribute.setDerived(true);
        eAttribute.setTransient(true);
        eAttribute.setVolatile(true);
      }
    }
    else
    {
      EClass eClass = (EClass)type;
      EAttribute any = (EAttribute)eClass.getEStructuralFeature("any");
      eClass.getEStructuralFeatures().remove(any);  
    }
  }
  
  public static void setSequenced(Type type, boolean isSequenced)
  {
    if (isSequenced == type.isSequenced()) return;
    
    // currently, we require setSequenced to be called first, before anything else is added to the type.
    if (type.isDataType() || !type.getProperties().isEmpty())
    {
      if (type.getName() != null) // document root is a special case
        throw new IllegalArgumentException();
    }
    
    if (isSequenced) {
      EClass eClass = (EClass)type;
      ExtendedMetaData.INSTANCE.setContentKind(eClass, ExtendedMetaData.MIXED_CONTENT);
      EAttribute mixedFeature = EcoreFactory.eINSTANCE.createEAttribute();
      mixedFeature.setName("mixed");
      mixedFeature.setUnique(false);
      mixedFeature.setEType(EcorePackage.eINSTANCE.getEFeatureMapEntry());
      mixedFeature.setLowerBound(0);
      mixedFeature.setUpperBound(-1);
      eClass.getEStructuralFeatures().add(mixedFeature);
      ExtendedMetaData.INSTANCE.setFeatureKind(mixedFeature, ExtendedMetaData.ELEMENT_WILDCARD_FEATURE);
      ExtendedMetaData.INSTANCE.setName(mixedFeature, ":mixed"); 
    }
    else
    {
      // nothing to do, because of current restriction that setSequence must be called first.
    }
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
    ((EClass)containingType).getEStructuralFeatures().add(eStructuralFeature);

    //if (containingType.getName() == null)
    if ("".equals(ExtendedMetaData.INSTANCE.getName((EClass)containingType)))
    {
      ExtendedMetaData.INSTANCE.setFeatureKind(eStructuralFeature, ExtendedMetaData.ELEMENT_FEATURE);
      ExtendedMetaData.INSTANCE.setNamespace(eStructuralFeature, containingType.getURI());
    }
    
    if (containingType.isSequenced()) {
      eStructuralFeature.setDerived(true);
      eStructuralFeature.setTransient(true);
      eStructuralFeature.setVolatile(true);
    }
    
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
    //TODO this implementation is temporary, until the SDO generated factory pattern is decided
    //
    String temp = factoryClass.getName().replaceFirst("Factory$", "PackageImpl");
    int lastDot = temp.lastIndexOf('.');
    String packageName = temp.substring(0, lastDot) + ".impl" + temp.substring(lastDot);
    try // this case handles the current default generator pattern
    {
      Class javaClass = getPackageClass(factoryClass, packageName);
      Field field = javaClass.getField("eINSTANCE");
      field.get(null); 
    }
    catch (Exception e1)
    {
      packageName = factoryClass.getName().replaceFirst("Factory$", "Package");
      try // this case handles the -noInterfaces generator pattern
      {
        Class javaClass = getPackageClass(factoryClass, packageName);
        Field field = javaClass.getField("eINSTANCE");
        field.get(null); 
      }
      catch (Exception e2)
      {
        try // this case handles the -noEMF generator pattern
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
  
  //Java instance class to SDO mappings (p.69 - p.71 of the SDO spec)
  private static Map javaToSdoMappings = new HashMap();
  static {
    javaToSdoMappings.put(boolean.class, "Boolean");
    javaToSdoMappings.put(byte.class, "Byte");
    javaToSdoMappings.put(char.class, "Character");
    javaToSdoMappings.put(Date.class, "Date");
    javaToSdoMappings.put(BigDecimal.class, "Decimal");
    javaToSdoMappings.put(double.class, "Double");
    javaToSdoMappings.put(float.class, "Float");
    javaToSdoMappings.put(int.class, "Int");
    javaToSdoMappings.put(BigInteger.class, "Integer");
    javaToSdoMappings.put(long.class, "Long");
    javaToSdoMappings.put(Object.class, "Object");
    javaToSdoMappings.put(short.class, "Short");
    javaToSdoMappings.put(String.class, "String");
    javaToSdoMappings.put(Boolean.class, "BooleanObject");
    javaToSdoMappings.put(Byte.class, "ByteObject");
    javaToSdoMappings.put(Character.class, "CharacterObject");
    javaToSdoMappings.put(Double.class, "DoubleObject");
    javaToSdoMappings.put(Float.class, "FloatObject");
    javaToSdoMappings.put(Integer.class, "IntObject");
    javaToSdoMappings.put(Long.class, "LongObject");
    javaToSdoMappings.put(Short.class, "ShortObject");
  }

  //XSD to SDO mappings (p.95 of the SDO spec)
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
