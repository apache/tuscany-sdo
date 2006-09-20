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


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.tuscany.sdo.model.impl.ModelPackageImpl;
import org.apache.tuscany.sdo.model.java.impl.JavaPackageImpl;
import org.apache.tuscany.sdo.util.SDOUtil;
import org.apache.tuscany.sdo.util.metadata.impl.MetadataPackageImpl;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;
import commonj.sdo.helper.TypeHelper;


/**
 * Look up a Type given the uri and typeName or interfaceClass.
 * SDO Types are available through the
 *   getType("commonj.sdo", typeName) method.
 * Defines Types from DataObjects.
 */
public class TypeHelperImpl implements TypeHelper
{
  protected ExtendedMetaData extendedMetaData;
  
  public ExtendedMetaData getExtendedMetaData()
  {
    return extendedMetaData;
  }
  
  public TypeHelperImpl(ExtendedMetaData extendedMetaData)
  {
    this.extendedMetaData = extendedMetaData;
    
    // Register the standard (predefined) SDO types
    ModelPackageImpl.init();
    JavaPackageImpl.init();
    MetadataPackageImpl.init();
  }
  
  public Type getType(String uri, String typeName)
  {
    EPackage ePackage = extendedMetaData.getPackage(uri);
    if (ePackage != null)
    {
      EClassifier eClassifier = ePackage.getEClassifier(typeName);
      if (eClassifier == null)
      {
        eClassifier = extendedMetaData.getType(ePackage, typeName);
      }
      return (Type)eClassifier;
    }
    return null;
  }
  
  public Type getType(Class interfaceClass)
  {
    Type type = SDOUtil.getJavaSDOType(interfaceClass);
    if (type != null)
    {
      return type;
    }
    
    //TODO more efficient implementation ... this is a really bad one!
    for (Iterator iter = EPackage.Registry.INSTANCE.values().iterator(); iter.hasNext(); )
    {
      Object value = iter.next();
      if (value instanceof EPackage)
      {
        EPackage ePackage = (EPackage)value;
        for (Iterator iter2 = ePackage.getEClassifiers().iterator(); iter2.hasNext(); )
        {
          EClassifier eClassifier = (EClassifier)iter2.next();
          if (eClassifier.getInstanceClass() == interfaceClass)
          {
            return (Type)eClassifier;
          }
        }
      }
    }
    
    return null;
  }

  public Type define(DataObject type)
  {
    if (!(type instanceof org.apache.tuscany.sdo.model.Type))
      throw new IllegalArgumentException();
    org.apache.tuscany.sdo.model.Type modeledType = (org.apache.tuscany.sdo.model.Type)type;
    
    boolean isDataType = modeledType.isDataType();
    Type definedType = SDOUtil.createType(this, modeledType.getUri(), modeledType.getName(), isDataType);  
    if (definedType == null)
    {
      // If type already defined, return the existing Type.
      return getType(modeledType.getUri(), modeledType.getName());
    }
    
    SDOUtil.setJavaClassName(definedType, modeledType.getInstanceClassName()); 
    
    if (!isDataType)
    {
      SDOUtil.setSequenced(definedType, modeledType.isSequenced());
      SDOUtil.setOpen(definedType, modeledType.isOpen());
      SDOUtil.setAbstract(definedType, modeledType.isAbstract());
      
      for (Iterator iter = modeledType.getBaseType().iterator(); iter.hasNext(); )
      {
        Type baseType = getDefinedType((org.apache.tuscany.sdo.model.Type)iter.next());
        SDOUtil.addBaseType(definedType, baseType);
      }
      
      for (Iterator iter = modeledType.getAliasName().iterator(); iter.hasNext(); )
      {
        String aliasName = (String)iter.next();
        SDOUtil.addAliasName(definedType, aliasName);
      }
      
      for (Iterator iter = modeledType.getProperty().iterator(); iter.hasNext(); )
      {
        org.apache.tuscany.sdo.model.Property modeledProperty = (org.apache.tuscany.sdo.model.Property)iter.next();
        
        Type propertyType = getDefinedType(modeledProperty.getType_());
        Property definedProperty = SDOUtil.createProperty(definedType, modeledProperty.getName(), propertyType);
        
        SDOUtil.setMany(definedProperty, modeledProperty.isMany());
        SDOUtil.setDefault(definedProperty, modeledProperty.getDefault_());
        SDOUtil.setReadOnly(definedProperty, modeledProperty.isReadOnly());
        
        for (Iterator iter2 = modeledProperty.getAliasName().iterator(); iter2.hasNext(); )
        {
          String aliasName = (String)iter2.next();
          SDOUtil.addAliasName(definedProperty, aliasName);
        }
        
        if (!propertyType.isDataType())
        {
          SDOUtil.setContainment(definedProperty, modeledProperty.isContainment());
          if (modeledProperty.getOpposite_() != null)
          {
            SDOUtil.setOpposite(definedProperty, getDefinedProperty(modeledProperty.getOpposite_()));
          }
        }
      }
    } // if (!isDataType)

    return definedType;
  }

  public List /*Type*/define(List /*DataObject*/types)
  {
    int count = types.size();
    List definedTypes = new ArrayList(count);
    for (int i = 0; i < count; i++)
    {
      definedTypes.add(define((DataObject)types.get(i)));
    }
    return definedTypes;
  }
  
  protected Type getDefinedType(org.apache.tuscany.sdo.model.Type modeledType)
  {
    if (modeledType instanceof Type)
    {
      return (Type)modeledType;
    }
    else
    {
      EClassifier eClassifier = extendedMetaData.getType(modeledType.getUri(), modeledType.getName());
      if (eClassifier != null)
      {
        return (Type)eClassifier;
      }
      else
      {
        return define((DataObject)modeledType);
      }
    }
  }
  
  protected Property getDefinedProperty(org.apache.tuscany.sdo.model.Property modeledProperty)
  {
    if (modeledProperty instanceof Property)
    {
      return (Property)modeledProperty;
    }
    else
    {
      DataObject modeledContainingType = ((DataObject)modeledProperty).getContainer();
      
      Type definedContainingType = getDefinedType((org.apache.tuscany.sdo.model.Type)modeledContainingType);
      String propertyName = modeledProperty.getName();
    
      return definedContainingType.getProperty(propertyName);
    }
  }
  
  public static final String TUSCANY_NO_URI="http://tuscany-no-uri";
  
  public Property defineOpenContentProperty(String uri, DataObject property)
  {
    // validate property and get type
    if (!(property instanceof org.apache.tuscany.sdo.model.impl.PropertyImpl))
      throw new IllegalArgumentException();
    org.apache.tuscany.sdo.model.Property modeledProperty = (org.apache.tuscany.sdo.model.Property)property;
    Type propertyType = getDefinedType(modeledProperty.getType_());

    if (uri == null) uri = TUSCANY_NO_URI;

    // get/create document root
    EPackage ePackage = extendedMetaData.getPackage(uri);
    Type documentRoot = 
      ePackage != null ? (Type)extendedMetaData.getType(extendedMetaData.getPackage(uri), "") : null;
    if (documentRoot == null) 
    {
      documentRoot = SDOUtil.createType(this, uri, null, false);
    }

    // Determine if property already exists
    Property newProperty = documentRoot.getProperty(modeledProperty.getName());
    if (newProperty == null)
    {
      //FB TBD ... is this code really supposed to be the same as in define()? If so, factor it out and reuse
       
      // Create the new property 'under' the document root.....
      newProperty = SDOUtil.createProperty(documentRoot, modeledProperty.getName(), propertyType);

      // Propagate the modeled property's attributes
      SDOUtil.setMany(newProperty, modeledProperty.isMany());
      SDOUtil.setDefault(newProperty, modeledProperty.getDefault_());
      SDOUtil.setReadOnly(newProperty, modeledProperty.isReadOnly());
      for (Iterator iter = modeledProperty.getAliasName().iterator(); iter.hasNext();)
      {
        String aliasName = (String)iter.next();
        SDOUtil.addAliasName(newProperty, aliasName);
      }
      if (!propertyType.isDataType())
      {
        SDOUtil.setContainment(newProperty, modeledProperty.isContainment());
        if (modeledProperty.getOpposite_() != null)
        {
          SDOUtil.setOpposite(newProperty, getDefinedProperty(modeledProperty.getOpposite_()));
        }
      }
    }
    else
    {
      // if property already exists, validate the expected type
      if (!newProperty.getType().equals(propertyType))
        throw new IllegalArgumentException();
    }

    return newProperty;
  }

  public Property getOpenContentProperty(String uri, String propertyName)
  {
    //FB TBD ... in the future we will allow elements or attributes - see SDOUtil.createProperty()
    return (Property)extendedMetaData.getElement(uri, propertyName);
  }  
}
