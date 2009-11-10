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

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.tuscany.sdo.api.SDOUtil;
import org.apache.tuscany.sdo.model.ModelFactory;
import org.apache.tuscany.sdo.model.internal.InternalFactory;
import org.apache.tuscany.sdo.model.java.JavaFactory;
import org.apache.tuscany.sdo.model.xml.XMLFactory;
import org.apache.tuscany.sdo.model.xml.impl.XMLFactoryImpl;
import org.apache.tuscany.sdo.util.DataObjectUtil;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.Type;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;

/**
 * Look up a Type given the uri and typeName or interfaceClass. SDO Types are
 * available through the getType("commonj.sdo", typeName) method. Defines Types
 * from DataObjects.
 */
public class TypeHelperImpl implements TypeHelper {
    protected HelperContext helperContext;
    private ExtendedMetaData extendedMetaData;

    static protected Set builtInModels = null;

    static public Set getBuiltInModels() {
        if (builtInModels == null) {
            builtInModels = new HashSet();
            builtInModels.add(ModelFactory.INSTANCE);
            builtInModels.add(JavaFactory.INSTANCE);
            builtInModels.add(XMLFactory.INSTANCE);
            builtInModels.add(InternalFactory.INSTANCE);
        }
        return TypeHelperImpl.builtInModels;
    }

    public ExtendedMetaData getExtendedMetaData() {
        return extendedMetaData;
    }

    // JIRA-helperContext
    public TypeHelperImpl(HelperContext hc) {
        this.helperContext = hc;
        this.extendedMetaData = ((HelperContextImpl)hc).extendedMetaData;
        
        // Register the standard (predefined) SDO types
        getBuiltInModels(); // Simply accessing EMF packages causes auto
                            // registration in global registry

        // MetadataFactoryImpl.init(); //FB do we want to preregister this?
    }


    public Type getType(String uri, String typeName) {
        EPackage ePackage = extendedMetaData.getPackage(uri);

        if (ePackage != null) {
            EClassifier eClassifier = ePackage.getEClassifier(typeName);
            if (eClassifier == null) {
                eClassifier = extendedMetaData.getType(ePackage, typeName);
            }
            return (Type)eClassifier;
        }
        return null;
    }

    private Method getGetStaticTypeMethod(Class classObj) {
        try {
            Method method = classObj.getMethod("getStaticType", null);
            return method;
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public Type getType(Class interfaceClass) {
        Type type = SDOUtil.getJavaSDOType(interfaceClass);
        if (type != null) {
            return type;
        }
        
        Class sdoTypeImplClass = interfaceClass;
        Method getStaticTypeMethod = getGetStaticTypeMethod(interfaceClass);
        if (getStaticTypeMethod == null) {
            String sdoTypeImplClassName = interfaceClass.getName();
            if (sdoTypeImplClassName.endsWith("Impl") == false) {
                sdoTypeImplClass = DataObjectUtil.getImplementationClass(interfaceClass, false);
                if (sdoTypeImplClass == null) {
                    return null;
                }
                
                getStaticTypeMethod = getGetStaticTypeMethod(sdoTypeImplClass);
                if (getStaticTypeMethod == null) {
                    return null;
                }
            }
            else {
                return null;
            }
        }
        
        try {
            Object implInstance = sdoTypeImplClass.newInstance();
            return (Type)getStaticTypeMethod.invoke(implInstance, null);
        }
        catch (Exception e) {
            return null;
        }
    }

    public Type define(DataObject type) {
        if (!(type instanceof org.apache.tuscany.sdo.model.Type))
            throw new IllegalArgumentException();
        org.apache.tuscany.sdo.model.Type modeledType = (org.apache.tuscany.sdo.model.Type)type;

        boolean isDataType = modeledType.isDataType();
        Type definedType = SDOUtil.createType(helperContext, modeledType.getUri(), modeledType.getName(), isDataType);
        if (definedType == null) {
            // If type already defined, return existing Type.
            return getType(modeledType.getUri(), modeledType.getName());
        }

        SDOUtil.setJavaClassName(definedType, modeledType.getInstanceClassName());

        if (!isDataType) {
            SDOUtil.setSequenced(definedType, modeledType.isSequenced());
            SDOUtil.setOpen(definedType, modeledType.isOpen());
            SDOUtil.setAbstract(definedType, modeledType.isAbstract());

            for (Iterator iter = modeledType.getBaseType().iterator(); iter.hasNext();) {
                Type baseType = getDefinedType((org.apache.tuscany.sdo.model.Type)iter.next());
                SDOUtil.addBaseType(definedType, baseType);
            }

            for (Iterator iter = modeledType.getAliasName().iterator(); iter.hasNext();) {
                String aliasName = (String)iter.next();
                SDOUtil.addAliasName(definedType, aliasName);
            }

            for (Iterator iter = modeledType.getProperty().iterator(); iter.hasNext();) {
                org.apache.tuscany.sdo.model.Property modeledProperty =
                    (org.apache.tuscany.sdo.model.Property)iter.next();

                Type propertyType = getDefinedType(modeledProperty.getType_());
                Property definedProperty = SDOUtil.createProperty(definedType, modeledProperty.getName(), propertyType);

                initializeProperty(definedProperty, modeledProperty);
            }

            // define a global property to accompany the type definition
            if (!SDOUtil.isDocumentRoot(definedType)) {
                String propertyName = definedType.getName();
                if (!Character.isLowerCase(propertyName.charAt(0))) {
                    propertyName = propertyName.substring(0, 1).toLowerCase() + propertyName.substring(1);
                }
                Property globalProperty =
                    SDOUtil.createOpenContentProperty(helperContext, definedType.getURI(), propertyName, definedType);
                SDOUtil.setContainment(globalProperty, true);
            }
        } // if (!isDataType)

        addTypeInstanceProperties(definedType, (DataObject)modeledType);

        return definedType;
    }

    protected void addTypeInstanceProperties(Type definedType, DataObject modeledType) {
        List instanceProperties = SDOUtil.getOpenContentProperties(modeledType);
        for (Iterator iter = instanceProperties.iterator(); iter.hasNext();) {
            Property property = (Property)iter.next();
            SDOUtil.addTypeInstanceProperty(definedType, property, modeledType.get(property));
        }
    }

    protected void addPropertyInstanceProperties(Property definedProperty, DataObject modeledProperty) {
        List instanceProperties = SDOUtil.getOpenContentProperties(modeledProperty);
        for (Iterator iter = instanceProperties.iterator(); iter.hasNext();) {
            Property property = (Property)iter.next();
            SDOUtil.addPropertyInstanceProperty(definedProperty, property, modeledProperty.get(property));
        }
    }

    public List /* Type */define(List /* DataObject */types) {
        int count = types.size();
        List definedTypes = new ArrayList(count);
        for (int i = 0; i < count; i++) {
            definedTypes.add(define((DataObject)types.get(i)));
        }
        return definedTypes;
    }

    protected Type getDefinedType(org.apache.tuscany.sdo.model.Type modeledType) {
        if (modeledType instanceof Type) {
            return (Type)modeledType;
        } else {
            EClassifier eClassifier = extendedMetaData.getType(modeledType.getUri(), modeledType.getName());
            if (eClassifier != null) {
                return (Type)eClassifier;
            } else {
                return define((DataObject)modeledType);
            }
        }
    }

    protected Property getDefinedProperty(org.apache.tuscany.sdo.model.Property modeledProperty) {
        if (modeledProperty instanceof Property) {
            return (Property)modeledProperty;
        } else {
            DataObject modeledContainingType = ((DataObject)modeledProperty).getContainer();

            Type definedContainingType = getDefinedType((org.apache.tuscany.sdo.model.Type)modeledContainingType);
            String propertyName = modeledProperty.getName();

            return definedContainingType.getProperty(propertyName);
        }
    }

    protected void initializeProperty(Property newProperty, org.apache.tuscany.sdo.model.Property modeledProperty) {
        SDOUtil.setMany(newProperty, modeledProperty.isMany());
        SDOUtil.setDefault(newProperty, modeledProperty.getDefault_());
        SDOUtil.setReadOnly(newProperty, modeledProperty.isReadOnly());
        for (Iterator iter = modeledProperty.getAliasName().iterator(); iter.hasNext();) {
            String aliasName = (String)iter.next();
            SDOUtil.addAliasName(newProperty, aliasName);
        }
    
    if (newProperty.getType().isDataType()) {
        // Setting xmlElement to FALSE only makes sense here
        Boolean isXmlElement = Boolean.TRUE;    // By default, a SDO property is an XSD element
        Sequence anyAttr = modeledProperty.getAnyAttribute();
        for (int i=0; i<anyAttr.size(); i++) {
            Property anyProp = anyAttr.getProperty(i);
            if (XMLFactoryImpl.NAMESPACE_URI.equals(anyProp.getContainingType().getURI())) {
                String propName = anyProp.getName();
                if ("xmlElement".equals(propName)) {
                    isXmlElement = (Boolean)anyAttr.getValue(i);
                }
            }
        }
        if (!isXmlElement.booleanValue()) {
            SDOUtil.setPropertyXMLKind(newProperty, false);
        }
    }
    else
    {
            SDOUtil.setContainment(newProperty, modeledProperty.isContainment());
            if (modeledProperty.getOpposite_() != null) {
                SDOUtil.setOpposite(newProperty, getDefinedProperty(modeledProperty.getOpposite_()));
            }
        }
        addPropertyInstanceProperties(newProperty, (DataObject)modeledProperty);
    }

    public static final String TUSCANY_NO_URI = "http://tuscany-no-uri";

    public Property defineOpenContentProperty(String uri, DataObject property) {
        // validate property and get type
        if (!(property instanceof org.apache.tuscany.sdo.model.impl.PropertyImpl))
            throw new IllegalArgumentException();
        org.apache.tuscany.sdo.model.Property modeledProperty = (org.apache.tuscany.sdo.model.Property)property;
        Type propertyType = getDefinedType(modeledProperty.getType_());

        if (uri == null)
            uri = TUSCANY_NO_URI;

        Property newProperty = SDOUtil.createOpenContentProperty(helperContext, uri, modeledProperty.getName(), propertyType);

        // Propagate the modeled property's attributes
        initializeProperty(newProperty, modeledProperty);

        return newProperty;
    }


    public Property getOpenContentProperty(String uri, String propertyName) {
        EClass documentRoot = (EClass)extendedMetaData.getType(uri, "");
        return documentRoot != null ? (Property)documentRoot.getEStructuralFeature(propertyName) : null;
    }

    public HelperContext getHelperContext() {
        return helperContext;
    }
}
