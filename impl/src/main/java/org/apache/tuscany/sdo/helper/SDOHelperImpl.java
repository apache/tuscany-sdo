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
package org.apache.tuscany.sdo.helper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.tuscany.sdo.SDOExtendedMetaData;
import org.apache.tuscany.sdo.SDOFactory;
import org.apache.tuscany.sdo.SimpleAnyTypeDataObject;
import org.apache.tuscany.sdo.api.SDOHelper;
import org.apache.tuscany.sdo.api.XMLStreamHelper;
import org.apache.tuscany.sdo.api.EventListener;
import org.apache.tuscany.sdo.impl.ClassImpl;
import org.apache.tuscany.sdo.impl.DataGraphImpl;
import org.apache.tuscany.sdo.impl.DynamicDataObjectImpl;
import org.apache.tuscany.sdo.model.ModelFactory;
import org.apache.tuscany.sdo.model.impl.ModelFactoryImpl;
import org.apache.tuscany.sdo.spi.SDOHelperBase;
import org.apache.tuscany.sdo.util.DataObjectUtil;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;

import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.Type;
import commonj.sdo.helper.CopyHelper;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.impl.HelperProvider;

public class SDOHelperImpl extends SDOHelperBase implements SDOHelper, SDOHelper.MetaDataBuilder {
  
  public DataObject createDataTypeWrapper(Type dataType, Object value) {
        SimpleAnyTypeDataObject simpleAnyType = SDOFactory.eINSTANCE.createSimpleAnyTypeDataObject();
        simpleAnyType.setInstanceType((EDataType)dataType);
        simpleAnyType.setValue(value);
        return simpleAnyType;
    }

    public Object createFromString(Type dataType, String literal) {
        return EcoreUtil.createFromString((EDataType)dataType, literal);
    }

    public String convertToString(Type dataType, Object value) {
        return EcoreUtil.convertToString((EDataType)dataType, value);
    }

    public Type getXSDSDOType(String xsdType) {
        Type type = null;
        String name = (String)xsdToSdoMappings.get(xsdType);
        if (name != null)
            type = (Type)((ModelFactoryImpl)ModelFactory.INSTANCE).getEClassifier(name);
        return type;
    }

    public Sequence getSubstitutionValues(DataObject dataObject, Property head) {
        final EStructuralFeature group = ExtendedMetaData.INSTANCE.getGroup((EStructuralFeature)head);
        return null == group ? null : (Sequence)((FeatureMap.Internal)((EObject)dataObject).eGet(group)).getWrapper();
    }

    public Type getJavaSDOType(Class javaClass) {
        String name = (String)javaToSdoMappings.get(javaClass);
        if (name != null) {
            return (Type)((ModelFactoryImpl)ModelFactory.INSTANCE).getEClassifier(name);
        }
        return null;
    }

    public boolean isRequired(Property property) {
        return ((EStructuralFeature)property).isRequired();
    }

    public int getUpperBound(Property property) {
        return ((EStructuralFeature)property).getUpperBound();
    }

    public int getLowerBound(Property property) {
        return ((EStructuralFeature)property).getLowerBound();
    }
    
    public List getEnumerationFacet(Type type) {
    	List instProps = type.getInstanceProperties();
    	String propertyName = "enumeration";
    	Property enumProperty = null;
    	
		for (int i = 0; i < instProps.size(); i++)
		{
		  Property prop = (Property)instProps.get(i);
		  if (propertyName.equals(prop.getName()))
			  enumProperty = prop;
		}

		return (List)DataObjectUtil.getMetaObjectInstanceProperty((EModelElement)type, enumProperty);
    }
    
    public List getPatternFacet(Type type) {
    	List instProps = type.getInstanceProperties();
    	String propertyName = "pattern";
    	Property patternProperty = null;
    	
		for (int i = 0; i < instProps.size(); i++)
		{
		  Property prop = (Property)instProps.get(i);
		  if (propertyName.equals(prop.getName()))
			  patternProperty = prop;
		}

		return (List)DataObjectUtil.getMetaObjectInstanceProperty((EModelElement)type, patternProperty);
    }

    public boolean isMany(Property property, DataObject context) {
        return FeatureMapUtil.isMany((EObject)context, (EStructuralFeature)property);
    }

    public DataGraph createDataGraph() {
        return SDOFactory.eINSTANCE.createDataGraph();
    }

    public void setRootObject(DataGraph dataGraph, DataObject rootObject) {
        ((DataGraphImpl)dataGraph).setERootObject((EObject)rootObject);
    }

    public static DataGraph loadDataGraph(InputStream inputStream, Map options) throws IOException {
        ResourceSet resourceSet = DataObjectUtil.createResourceSet();
        Resource resource = resourceSet.createResource(URI.createURI("all.datagraph"));
        resource.load(inputStream, options);
        return (DataGraph)resource.getContents().get(0);
    }

    static final Object LOADING_SCOPE = XMLResource.OPTION_EXTENDED_META_DATA;

    protected void registerLoadingScope(Map options, TypeHelper scope) {
        Object extendedMetaData = ((TypeHelperImpl)scope).getExtendedMetaData();
        options.put(LOADING_SCOPE, extendedMetaData);
    }

    public DataGraph loadDataGraph(InputStream inputStream, Map options, HelperContext scope) throws IOException {
        if (scope == null) {
            scope = HelperProvider.getDefaultContext();
        }
        TypeHelper th = scope.getTypeHelper();
        DataGraph result = null;
		if (th == null || th == TypeHelper.INSTANCE) {
		    result = loadDataGraph(inputStream, options);
		} else if (options == null) {
		    options = new HashMap();
		    registerLoadingScope(options, th);
		    result = loadDataGraph(inputStream, options);
		} else if (options.containsKey(LOADING_SCOPE)) {
		    Object restore = options.get(LOADING_SCOPE);
		    registerLoadingScope(options, th);
		    try {
		        result = loadDataGraph(inputStream, options);
		    } finally {
		        options.put(LOADING_SCOPE, restore);
		    }
		} else {
		    registerLoadingScope(options, th);
		    try {
		        result = loadDataGraph(inputStream, options);
		    } finally {
		        options.remove(LOADING_SCOPE);
		    }
		}
		return result;
    }

    public void saveDataGraph(DataGraph dataGraph, OutputStream outputStream, Map options) throws IOException {
        ((DataGraphImpl)dataGraph).getDataGraphResource().save(outputStream, options);
    }

    public void registerDataGraphTypes(DataGraph dataGraph, List/* Type */types) {
        // if (types == null)
        // types = SDOUtil.getDataGraphTypes(dataGraph);

        Set/* EPackage */packages = new HashSet();
        for (final Iterator iterator = types.iterator(); iterator.hasNext();) {
            EClassifier type = (EClassifier)iterator.next();
            packages.add(type.getEPackage());
        }

        ResourceSet resourceSet = ((DataGraphImpl)dataGraph).getResourceSet();

        for (Iterator iterator = packages.iterator(); iterator.hasNext();) {
            EPackage typePackage = (EPackage)iterator.next();
            Resource resource = typePackage.eResource();
            if (resource == null) {
                resource = resourceSet.createResource(URI.createURI(".ecore"));
                resource.setURI(URI.createURI(typePackage.getNsURI()));
                resource.getContents().add(typePackage);
            } else if (resource.getResourceSet() != resourceSet)
                resourceSet.getResources().add(resource);
        }
    }

    public HelperContext createHelperContext() {
        return new HelperContextImpl(false, null);
    }
    
    public HelperContext createHelperContext(boolean extensibleNamespaces) {
        return new HelperContextImpl(extensibleNamespaces);
    }
    
    public HelperContext createHelperContext(Map options) {
        return new HelperContextImpl(false, options);
    }

    public HelperContext createHelperContext(boolean extensibleNamespaces, Map options) {
        return new HelperContextImpl(extensibleNamespaces, options);
    }


    public CopyHelper createCrossScopeCopyHelper(HelperContext hc) {
        return new CrossScopeCopyHelperImpl(hc.getTypeHelper());
    }

    
    public XMLStreamHelper createXMLStreamHelper(HelperContext hc) {
        return ((HelperContextImpl)hc).getXMLStreamHelper();
    }

    
    public List getTypes(HelperContext hc, String uri) {

        EPackage ePackage = ((HelperContextImpl)hc).getExtendedMetaData().getPackage(uri);
        if (ePackage != null) {
            return new ArrayList(ePackage.getEClassifiers());
        }
        return null;
    }

    public List getOpenContentProperties(DataObject dataObject) {
        List result = new UniqueEList();
        ((ClassImpl)dataObject.getType()).addOpenProperties((EObject)dataObject, result);
        return result;
    }

    public boolean isDocumentRoot(Type type) {
        return "".equals(SDOExtendedMetaData.INSTANCE.getName((EClassifier)type));
    }

    
    public Type createType(HelperContext hc, String uri, String name, boolean isDataType) {
        ExtendedMetaData extendedMetaData = ((HelperContextImpl)hc).getExtendedMetaData();
        if ("".equals(uri))
            uri = null; // FB

        EPackage ePackage = extendedMetaData.getPackage(uri);
        if (ePackage == null) {
            ePackage = EcoreFactory.eINSTANCE.createEPackage();
            ePackage.setEFactoryInstance(new DynamicDataObjectImpl.FactoryImpl());
            ePackage.setNsURI(uri);
            String packagePrefix = uri != null ? URI.createURI(uri).trimFileExtension().lastSegment() : ""; // FB
            ePackage.setName(packagePrefix);
            ePackage.setNsPrefix(packagePrefix);
            extendedMetaData.putPackage(uri, ePackage);
        }

        EClassifier eClassifier = ePackage.getEClassifier(name);
        if (eClassifier != null) // already defined?
        {
            // throw new IllegalArgumentException();
            return null;
        }

        if (name != null) {
            eClassifier =
                isDataType ? (EClassifier)SDOFactory.eINSTANCE.createDataType() : (EClassifier)SDOFactory.eINSTANCE
                    .createClass();
            eClassifier.setName(name);
        } else {
            eClassifier = DataObjectUtil.createDocumentRoot();
        }

        ePackage.getEClassifiers().add(eClassifier);

        return (Type)eClassifier;
    }

    public void addBaseType(Type type, Type baseType) {
        ((EClass)type).getESuperTypes().add(baseType);
    }

    public void addAliasName(Type type, String aliasName) {
        throw new UnsupportedOperationException(); // TODO: implement this
                                                    // method properly
        // type.getAliasNames().add(aliasName);
    }

    public void setOpen(Type type, boolean isOpen) {
        if (isOpen == type.isOpen())
            return;

        if (isOpen) {
            EAttribute eAttribute = (EAttribute)SDOFactory.eINSTANCE.createAttribute();
            ((EClass)type).getEStructuralFeatures().add(eAttribute);

            eAttribute.setName("any");
            eAttribute.setUnique(false);
            eAttribute.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
            eAttribute.setEType(EcorePackage.eINSTANCE.getEFeatureMapEntry());
            ExtendedMetaData.INSTANCE.setFeatureKind(eAttribute, ExtendedMetaData.ELEMENT_WILDCARD_FEATURE);
            ExtendedMetaData.INSTANCE.setProcessingKind(eAttribute, ExtendedMetaData.LAX_PROCESSING);
            ExtendedMetaData.INSTANCE.setWildcards(eAttribute, Collections.singletonList("##any"));

            // FB TBD Add an "anyAttribute" EAttribute as well.

            if (ExtendedMetaData.INSTANCE.getMixedFeature((EClass)type) != null) {
                eAttribute.setDerived(true);
                eAttribute.setTransient(true);
                eAttribute.setVolatile(true);
            }
        } else {
            EClass eClass = (EClass)type;
            EAttribute any = (EAttribute)eClass.getEStructuralFeature("any");
            eClass.getEStructuralFeatures().remove(any);
        }
    }

    public void setSequenced(Type type, boolean isSequenced) {
        // currently, we require setSequenced to be called first, before
        // anything else is added to the type.
        if (type.isDataType() || !type.getProperties().isEmpty()) {
            if (type.getName() != "DocumentRoot") // document root is a
                                                    // special case
                throw new IllegalArgumentException();
        }

        if (isSequenced) {
            EClass eClass = (EClass)type;
            ExtendedMetaData.INSTANCE.setContentKind(eClass, ExtendedMetaData.MIXED_CONTENT);
            EAttribute mixedFeature = (EAttribute)SDOFactory.eINSTANCE.createAttribute();
            mixedFeature.setName("mixed");
            mixedFeature.setUnique(false);
            mixedFeature.setEType(EcorePackage.eINSTANCE.getEFeatureMapEntry());
            mixedFeature.setLowerBound(0);
            mixedFeature.setUpperBound(-1);
            // eClass.getEStructuralFeatures().add(mixedFeature);
            ((ClassImpl)eClass).setSequenceFeature(mixedFeature);
            ExtendedMetaData.INSTANCE.setFeatureKind(mixedFeature, ExtendedMetaData.ELEMENT_WILDCARD_FEATURE);
            ExtendedMetaData.INSTANCE.setName(mixedFeature, ":mixed");
        } else {
            // nothing to do, because of current restriction that setSequence
            // must be called first.
        }
    }

    public void setAbstract(Type type, boolean isAbstract) {
        ((EClass)type).setAbstract(isAbstract);
    }

    public void setJavaClassName(Type type, String javaClassName) {
        ((EClassifier)type).setInstanceClassName(javaClassName);
    }

    public Property createProperty(Type containingType, String name, Type propertyType) {
      EStructuralFeature eStructuralFeature = 
            propertyType.isDataType() ? (EStructuralFeature)SDOFactory.eINSTANCE.createAttribute()
                : (EStructuralFeature)SDOFactory.eINSTANCE.createReference();

      eStructuralFeature.setName(name);
      eStructuralFeature.setEType((EClassifier)propertyType);
      ((EClass)containingType).getEStructuralFeatures().add(eStructuralFeature);

        if ("".equals(ExtendedMetaData.INSTANCE.getName((EClass)containingType))) // DocumentRoot
                                                                                    // containingType?
      {
        ExtendedMetaData.INSTANCE.setNamespace(eStructuralFeature, containingType.getURI());
        //FB???eStructuralFeature.setUnique(false);
        //FB???eStructuralFeature.setUpperBound(ETypedElement.UNSPECIFIED_MULTIPLICITY);
      }
      
      if (ExtendedMetaData.INSTANCE.getMixedFeature((EClass)containingType) != null) {
        eStructuralFeature.setDerived(true);
        eStructuralFeature.setTransient(true);
        eStructuralFeature.setVolatile(true);
        ExtendedMetaData.INSTANCE.setFeatureKind(eStructuralFeature, ExtendedMetaData.ELEMENT_FEATURE);
      } else {
          // By default, a SDO property is an XSD element
          ExtendedMetaData.INSTANCE.setFeatureKind(eStructuralFeature, ExtendedMetaData.ELEMENT_FEATURE);
      }
      
      return (Property)eStructuralFeature;
    }

  public void setPropertyXMLKind(Property property, boolean isXmlElement) {
      if (isXmlElement) {
          ExtendedMetaData.INSTANCE.setFeatureKind((EStructuralFeature)property, ExtendedMetaData.ELEMENT_FEATURE);
      }
      else {
          ExtendedMetaData.INSTANCE.setFeatureKind((EStructuralFeature)property, ExtendedMetaData.ATTRIBUTE_FEATURE);
      }
  }
  
  
  public Property createOpenContentProperty(HelperContext hc, String uri, String name, Type type)
  {
        ExtendedMetaData extendedMetaData = ((HelperContextImpl)hc).getExtendedMetaData();

        // get/create document root
        EPackage ePackage = extendedMetaData.getPackage(uri);
        Type documentRoot = ePackage != null ? (Type)extendedMetaData.getType(ePackage, "") : null;
        if (documentRoot == null) {
            documentRoot = createType(hc, uri, null, false);
        }

        // Determine if property already exists
        Property newProperty = documentRoot.getProperty(name);
        if (newProperty == null) {
            // Create the new property 'under' the document root.....
            newProperty = createProperty(documentRoot, name, type);
        } else {
            // if property already exists, validate the expected type
            if (!newProperty.getType().equals(type))
                throw new IllegalArgumentException();
        }
        return newProperty;
    }


    public void addAliasName(Property property, String aliasName) {
        throw new UnsupportedOperationException(); // TODO: implement this
                                                    // method properly
        // property.getAliasNames().add(aliasName);
    }

    public void setMany(Property property, boolean isMany) {
        ((EStructuralFeature)property).setUpperBound(isMany ? EStructuralFeature.UNBOUNDED_MULTIPLICITY : 1);
    }

    public void setContainment(Property property, boolean isContainment) {
        ((EReference)property).setContainment(isContainment);
    }

    public void setDefault(Property property, String defaultValue) {
        ((EStructuralFeature)property).setDefaultValueLiteral(defaultValue);
    }

    public void setReadOnly(Property property, boolean isReadOnly) {
        ((EStructuralFeature)property).setChangeable(!isReadOnly);
    }

    public void setOpposite(Property property, Property opposite) {
        ((EReference)property).setEOpposite((EReference)opposite);
    }

    public void addTypeInstanceProperty(Type definedType, Property instanceProperty, Object value) {
        addInstanceProperty((EModelElement)definedType, instanceProperty, value);
    }

    public void addPropertyInstanceProperty(Property definedProperty, Property instanceProperty, Object value) {
        addInstanceProperty((EModelElement)definedProperty, instanceProperty, value);
    }

    protected void addInstanceProperty(EModelElement metaObject, Property property, Object value) {
        String uri = property.getContainingType().getURI();
        EAnnotation eAnnotation = metaObject.getEAnnotation(uri);
        if (eAnnotation == null) {
            eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
            eAnnotation.setSource(uri);
            metaObject.getEAnnotations().add(eAnnotation);
        }
        // TODO if (property.isMany()) ... // convert list of values
        String stringValue = convertToString(property.getType(), value);
        eAnnotation.getDetails().put(property.getName(), stringValue);
    }

    
    public void addChangeListener(DataObject dob, EventListener listener) {
      // Adapter l = (Adapter)listener;
      ((Notifier)dob).eAdapters().add(listener);
    }
    
    public void removeChangeListener(DataObject dob, EventListener listener) {
      ((Notifier)dob).eAdapters().remove(listener);
    }
    
    
}
