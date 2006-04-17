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
package org.apache.tuscany.sdo.helper;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.tuscany.sdo.model.impl.ModelPackageImpl;
import org.apache.tuscany.sdo.model.java.impl.JavaPackageImpl;
import org.apache.tuscany.sdo.util.SDOUtil;
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
    
    SDOUtil.setJavaClassName(definedType, modeledType.getInstanceClassName()); 
    
    if (!isDataType)
    {
      SDOUtil.setOpen(definedType, modeledType.isOpen());
      SDOUtil.setSequenced(definedType, modeledType.isSequenced());
      SDOUtil.setAbstract(definedType, modeledType.isAbstract());
      
      for (Iterator iter = modeledType.getBaseType().iterator(); iter.hasNext(); )
      {
        Type baseType = getDefinedType((DataObject)iter.next());
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
        
        Type propertyType = getDefinedType((DataObject)modeledProperty.getType_());
        Property definedProperty = SDOUtil.createProperty(definedType, modeledProperty.getName(), propertyType);
        
        SDOUtil.setMany(definedProperty, modeledProperty.isMany());
        SDOUtil.setDefault(definedProperty, modeledProperty.getDefault());
        SDOUtil.setReadOnly(definedProperty, modeledProperty.isReadOnly());
        
        for (Iterator iter2 = modeledProperty.getAliasName().iterator(); iter2.hasNext(); )
        {
          String aliasName = (String)iter2.next();
          SDOUtil.addAliasName(definedProperty, aliasName);
        }
        
        if (!propertyType.isDataType())
        {
          SDOUtil.setContainment(definedProperty, modeledProperty.isContainment());
          if (modeledProperty.getOpposite() != null)
          {
            SDOUtil.setOpposite(definedProperty, getDefinedProperty((DataObject)modeledProperty.getOpposite()));
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
  
  protected Type getDefinedType(DataObject modeledType)
  {
    if (modeledType instanceof Type)
    {
      return (Type)modeledType;
    }
    else
    {
      org.apache.tuscany.sdo.model.Type type = (org.apache.tuscany.sdo.model.Type)modeledType;
      EClassifier eClassifier = extendedMetaData.getType(type.getUri(), type.getName());
      if (eClassifier != null)
      {
        return (Type)eClassifier;
      }
      else
      {
        return define(modeledType);
      }
    }
  }
  
  protected Property getDefinedProperty(DataObject modeledProperty)
  {
    Type definedType = getDefinedType(modeledProperty.getContainer());
    String propertyName = ((org.apache.tuscany.sdo.model.Property)modeledProperty).getName();
    
    return definedType.getProperty(propertyName);
  }

}
