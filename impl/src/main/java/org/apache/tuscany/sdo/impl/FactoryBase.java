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

import org.apache.tuscany.sdo.model.impl.ModelFactoryImpl;
import org.apache.tuscany.sdo.model.impl.ModelPackageImpl;
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
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

/**
 */
public class FactoryBase extends EPackageImpl
{
  
  public static final boolean IS_ATTRIBUTE = true;
  
  protected FactoryBase(String namespaceURI, String namespacePrefix)
  {
    super(new SDOEFactoryImpl());
    
    int index = namespacePrefix.lastIndexOf(".");
    setName(index != -1 ? namespacePrefix.substring(index + 1) : namespacePrefix);
    setNsPrefix(namespacePrefix);

    createResource(namespaceURI);
    setNsURI(namespaceURI);
    //FIXME ... figure out proper (scoped) way to register static packages
    EPackage.Registry.INSTANCE.put(namespaceURI, this);
    
    ((SDOEFactoryImpl)getEFactoryInstance()).sdoFactory = this;
  }
  
  public DataObject create(int typeNumber)
  {
    return null;
  }
  
  protected Type createType(boolean isDataType, int typeNumber)
  {
    if (isDataType)
      return (Type)createEDataType(typeNumber);
    else
      return (Type)createEClass(typeNumber);
  }
  
  protected void createProperty(boolean isDataType, Type containingType, int propertyNumber)
  {
    if (isDataType)
      createEAttribute((EClass)containingType, propertyNumber);
    else
      createEReference((EClass)containingType, propertyNumber);
  }
  
  protected void initializeType(Type type, Class instanceClass, String name)
  {
    initEClass((EClass)type, instanceClass, name, !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);   
  }

  protected void initializeType(Type type, Class instanceClass, String name, boolean isSerializable, boolean isGenerated)
  {
    initEDataType((EDataType)type, instanceClass, name, isSerializable, isGenerated);   
  }
  
  protected void initializeProperty(Property property, Type type, String name, String defaultValue, int lower, int upper, Class containerClass, boolean isReadonly, boolean isUnsettable, boolean isDerived)
  {
    initEAttribute((EAttribute)property, (EClassifier)type, name, defaultValue, lower, upper, containerClass, isDerived, isDerived, !isReadonly, isUnsettable, !IS_ID, !IS_UNIQUE, isDerived, IS_ORDERED);
  }
  
  protected void initializeProperty(Property property, Type type, String name, String defaultValue, int lower, int upper, Class containerClass, boolean isReadonly, boolean isUnsettable, boolean isDerived, boolean isComposite, Property oppositeProperty)
  {
    initEReference((EReference)property, (EClassifier)type, (EReference)oppositeProperty, name, defaultValue, lower, upper, containerClass, isDerived, isDerived, !isReadonly, isComposite, !isComposite /*resolve*/, isUnsettable, IS_UNIQUE, isDerived, IS_ORDERED);
  }

  protected void createXSDMetaData()
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

  protected Type getSequence() 
  {
    return (Type)ecorePackage.getEFeatureMapEntry();
  }
  
  //public static FactoryBase getStaticFactory(String namespaceURI)
  // temporarily return Object - until everything is gen'd with new codegen pattern
  public static Object getStaticFactory(String namespaceURI)
  {
    EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(namespaceURI);
    //return (FactoryBase)ePackage;
    return ePackage instanceof FactoryBase ? (Object)ePackage : (Object)ePackage.getEFactoryInstance(); 
  }
  
  // default implementation of createFromString
  public Object createFromString(Type type, String stringValue, int propertyValue)
  {
	return (String)ModelFactoryImpl.eINSTANCE.createFromString(ModelPackageImpl.Literals.STRING, stringValue);
  }
  
  // default implementation of convertToString
  public String convertToString(Type type, Object objectValue, int propertyValue)
  {
	return ModelFactoryImpl.eINSTANCE.convertToString(ModelPackageImpl.Literals.STRING, objectValue);
  }
  
  // private EMF-specific methods

  private static class SDOEFactoryImpl extends EFactoryImpl
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
        return super.create(eClass);
      }
      return (EObject)result;
    }
    
    public Object createFromString(EDataType eDataType, String stringValue)
    {
      return sdoFactory.createFromString((Type)eDataType, stringValue, eDataType.getClassifierID());
    }
    
    public String convertToString(EDataType eDataType, Object objectValue)
    {
      return sdoFactory.convertToString((Type)eDataType, objectValue, eDataType.getClassifierID());
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
