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

import org.apache.tuscany.sdo.SDOFactory;
import org.apache.tuscany.sdo.impl.SDOFactoryImpl.SDOEcoreFactory;
import org.apache.tuscany.sdo.util.DataObjectUtil;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

/**
 * Base class for generated (static) SDO factories
 */
public class FactoryBase extends EPackageImpl
{
  
  public static final boolean IS_ATTRIBUTE = true;
  
  protected FactoryBase(String namespaceURI, String namespacePrefix)
  {
    super(new SDOEFactoryImpl());
    ecoreFactory = new SDOEcoreFactory();
    
    int index = namespacePrefix.lastIndexOf(".");
    setName(index != -1 ? namespacePrefix.substring(index + 1) : namespacePrefix);
    setNsPrefix(namespacePrefix);

    createResource(namespaceURI);
    setNsURI(namespaceURI);
    
    ((SDOEFactoryImpl)getEFactoryInstance()).sdoFactory = this;
  }
  
  protected FactoryBase(String namespaceURI, String namespacePrefix, String interfacePackage)
  {
    super(new SDOEFactoryImpl());
    ecoreFactory = new SDOEcoreFactory();
    
    int index = interfacePackage.lastIndexOf(".");
    setName(index != -1 ? interfacePackage.substring(index + 1) : interfacePackage);
    setNsPrefix(namespacePrefix);

    createResource(namespaceURI);
    setNsURI(namespaceURI);
    
    ((SDOEFactoryImpl)getEFactoryInstance()).sdoFactory = this;
  }

 

  public DataObject create(int typeNumber)
  {
    return null;
  }
  
  public Object createFromString(int typeNumber, String stringValue)
  {
    return ((SDOEFactoryImpl)getEFactoryInstance()).createFromString(typeNumber, stringValue);
  }
  
  public String convertToString(int typeNumber, Object objectValue)
  {
    return ((SDOEFactoryImpl)getEFactoryInstance()).convertToString(typeNumber, objectValue);
  }
  
  protected Type createType(boolean isDataType, int typeNumber)
  {
    if (isDataType)
      return (Type)createEDataType(typeNumber);
    else
      return (Type)createEClass(typeNumber);
  }
  
  protected void createProperty(boolean isDataType, Type containingType, int internalPropertyNumber)
  {
    if (isDataType)
      createEAttribute((EClass)containingType, internalPropertyNumber);
    else
      createEReference((EClass)containingType, internalPropertyNumber);
  }
  
  /**
   * @deprecated - use getLocalProperty instead, since getProperty causes
   * caching of structural features. 
   */
  protected Property getProperty(Type type, int internalPropertyNumber)
  {
    return (Property)((EClass)type).getEAllStructuralFeatures().get(internalPropertyNumber);
  }
  
  protected Property getLocalProperty(Type type, int localPropertyIndex)
  {
    return (Property)((EClass)type).getEStructuralFeatures().get(localPropertyIndex);
  }
  
  
  protected void initializeType(Type type, Class instanceClass, String name)
  {
    initEClass((EClass)type, instanceClass, name, !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);   
  }

  protected void initializeType(Type type, Class instanceClass, String name, boolean isAbstract)
  {
    initEClass((EClass)type, instanceClass, name, isAbstract, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);   
  }

  protected void initializeType(Type type, Class instanceClass, String name, boolean isSerializable, boolean isGenerated)
  {
    initEDataType((EDataType)type, instanceClass, name, isSerializable, isGenerated);   
  }
  
  protected void initializeProperty(Property property, Type type, String name, String defaultValue, int lower, int upper, Class containerClass, boolean isReadonly, boolean isUnsettable, boolean isDerived)
  {
    initEAttribute((EAttribute)property, type != sequence ? (EClassifier)type : ecorePackage.getEFeatureMapEntry(), name, defaultValue, lower, upper, containerClass, isDerived, isDerived, !isReadonly, isUnsettable, !IS_ID, !IS_UNIQUE, isDerived, IS_ORDERED);
  }
  
  protected void initializeProperty(Property property, Type type, String name, String defaultValue, int lower, int upper, Class containerClass, boolean isReadonly, boolean isUnsettable, boolean isDerived, boolean isComposite, Property oppositeProperty)
  {
    initEReference((EReference)property, (EClassifier)type, (EReference)oppositeProperty, name, defaultValue, lower, upper, containerClass, isDerived, isDerived, !isReadonly, isComposite, !isComposite /*resolve*/, isUnsettable, IS_UNIQUE, isDerived, IS_ORDERED);
  }
  
  protected void initXSD()
  {
    createDocumentRoot();
  }

  protected void addXSDMapping(String[] xsdMappings, String annotationSource)
  {
    addAnnotation((ENamedElement)this, annotationSource, xsdMappings);
  }

  protected void addXSDMapping(Type type, String[] xsdMappings)
  {
    addAnnotation((ENamedElement)type, ANNOTATION_SOURCE, xsdMappings);
  }
  
  protected void addXSDMapping(Property property, String[] xsdMappings)
  {
    addAnnotation((ENamedElement)property, ANNOTATION_SOURCE, xsdMappings);
  }
  
  protected void setInstanceProperty(Type type, String namespaceURI, String propertyName, String propertyValue)
  {
    setInstanceProperty((ENamedElement)type, namespaceURI, propertyName, propertyValue);
  }

  protected void setInstanceProperty(Property property, String namespaceURI, String propertyName, String propertyValue)
  {
    setInstanceProperty((ENamedElement)property, namespaceURI, propertyName, propertyValue); 
  }
  
  private void setInstanceProperty(ENamedElement eNamedElement, String namespaceURI, String propertyName, String propertyValue)
  {
    EAnnotation annotation = eNamedElement.getEAnnotation(namespaceURI);
    if (annotation == null)
    {
      addAnnotation(eNamedElement, namespaceURI, new String[]{propertyName, propertyValue});
	  } else 
    {
      annotation.getDetails().put(propertyName, propertyValue);
    }
  }

  protected Property createGlobalProperty(String name, Type type, String[] xsdMappings)
  {
    return createGlobalProperty(name, type, xsdMappings, false);
  }
  
  protected Property createGlobalProperty(String name, Type type, String[] xsdMappings, boolean asAttribute)
  {
    return createGlobalProperty(name, type, xsdMappings, asAttribute, ANNOTATION_SOURCE);
  }

  protected Property createGlobalProperty(String name, Type type, String[] xsdMappings, boolean asAttribute, String annotationSource)
  {
    int propertyNumber = documentRootEClass.getEStructuralFeatures().size();

    EStructuralFeature globalProperty;
    if(asAttribute) {
      createEAttribute(documentRootEClass, propertyNumber);
      EAttribute gatt = (EAttribute)documentRootEClass.getEStructuralFeatures().get(propertyNumber);
      initEAttribute(gatt, (EDataType)type, name, null, 0, -2, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
      globalProperty = gatt;
    } else {
      createEReference(documentRootEClass, propertyNumber);
      EReference gref = (EReference)documentRootEClass.getEStructuralFeatures().get(propertyNumber);
      initEReference(gref, (EClass)type, null, name, null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
      globalProperty = gref;
    } 
    addAnnotation((ENamedElement)globalProperty, annotationSource, xsdMappings);
    return (Property) globalProperty;
  }
  
  private static final Type sequence = SDOFactory.eINSTANCE.createDataType(); // dummy type

  protected Type getSequence() 
  {
    return sequence;
  }
  
  protected void addSuperType(Type subType, Type superType) 
  {
	((EClass)subType).getESuperTypes().add((EClass)superType);
  }
  
 /***
   * @param namespaceURI
   * @return Static factory (from the global scope) for the provided URI
   * 
   * @deprecated - Use of the global scope is no longer encouraged.  This method uses the
   * global scope for retrieving the URI's factory.  Instead, it is now possible to simply 
   * access SomeFactoryInterface.INSTANCE object directly.
   * 
   */
  public static Object getStaticFactory(String namespaceURI)
  {
    EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(namespaceURI);
    //return (FactoryBase)ePackage;
    return ePackage instanceof FactoryBase ? (Object)ePackage : (Object)ePackage.getEFactoryInstance(); 
  }
  
  // private EMF-specific methods

  private static class SDOEFactoryImpl extends DynamicDataObjectImpl.FactoryImpl
  {
    protected FactoryBase sdoFactory;
    
    public SDOEFactoryImpl()
    {
      super();
    }
    
    public EObject create(EClass eClass)
    {
      DataObject result = sdoFactory.create(eClass.getClassifierID());
      if (result == null) {
        if (eClass.isAbstract()) {
          Class instanceClass = eClass.getInstanceClass();
          try {
            Class concreteInstanceClass = DataObjectUtil.getImplementationClass(instanceClass, true);
            return (EObject)concreteInstanceClass.newInstance();          
          }
          catch (Exception e)
          {
            //System.out.println("Error: " + e);
          }
        }
        return super.create(eClass);
      }
      return (EObject)result;
    }
    
    public Object createFromString(EDataType eDataType, String stringValue)
    {
      return sdoFactory.createFromString(eDataType.getClassifierID(), stringValue);
    }
    
    public String convertToString(EDataType eDataType, Object objectValue)
    {
      return sdoFactory.convertToString(eDataType.getClassifierID(), objectValue);
    }
    
    protected Object createFromString(int typeNumber, String stringValue)
    {
      return super.createFromString((EDataType)sdoFactory.getEClassifiers().get(typeNumber), stringValue);
    }
    
    protected String convertToString(int typeNumber, Object objectValue)
    {
      return super.convertToString((EDataType)sdoFactory.getEClassifiers().get(typeNumber), objectValue);
    }
  }
  
  private static final int DOCUMENT_ROOT = 0;
  private static final int DOCUMENT_ROOT__MIXED = 0;
  private static final int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;
  private static final int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;
  private static final String ANNOTATION_SOURCE = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";
  private EClass documentRootEClass = null;
  
  private void createDocumentRoot()
  {
    documentRootEClass = ecoreFactory.createEClass();
    ((EClassImpl)documentRootEClass).setClassifierID(DOCUMENT_ROOT);
    getEClassifiers().add(DOCUMENT_ROOT, documentRootEClass);

    createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
    createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
    createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
    
    initEClass(documentRootEClass, null, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
    initEAttribute((EAttribute)documentRootEClass.getEStructuralFeatures().get(DOCUMENT_ROOT__MIXED), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference((EReference)documentRootEClass.getEStructuralFeatures().get(DOCUMENT_ROOT__XMLNS_PREFIX_MAP), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference((EReference)documentRootEClass.getEStructuralFeatures().get(DOCUMENT_ROOT__XSI_SCHEMA_LOCATION), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addAnnotation
      (documentRootEClass, 
       ANNOTATION_SOURCE, 
       new String[] 
       {
       "name", "",
       "kind", "mixed"
       });      
    addAnnotation
      ((EAttribute)documentRootEClass.getEStructuralFeatures().get(DOCUMENT_ROOT__MIXED), 
       ANNOTATION_SOURCE, 
       new String[] 
       {
       "kind", "elementWildcard",
       "name", ":mixed"
       });      
    addAnnotation
      ((EReference)documentRootEClass.getEStructuralFeatures().get(DOCUMENT_ROOT__XMLNS_PREFIX_MAP), 
       ANNOTATION_SOURCE, 
       new String[] 
       {
       "kind", "attribute",
       "name", "xmlns:prefix"
       });      
    addAnnotation
      ((EReference)documentRootEClass.getEStructuralFeatures().get(DOCUMENT_ROOT__XSI_SCHEMA_LOCATION), 
       ANNOTATION_SOURCE, 
       new String[] 
       {
       "kind", "attribute",
       "name", "xsi:schemaLocation"
       });      
  }
  
  /**
   * Initialize SDO runtime.
   */
  static
  {
    DataObjectUtil.initRuntime();
  }
}
