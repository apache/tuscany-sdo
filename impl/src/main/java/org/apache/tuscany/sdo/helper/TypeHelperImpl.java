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


import java.util.Iterator;
import java.util.List;

import org.apache.tuscany.sdo.model.impl.ModelPackageImpl;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import commonj.sdo.DataObject;
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
  
  public TypeHelperImpl(ExtendedMetaData extendedMetaData)
  {
    this.extendedMetaData = extendedMetaData;
    
    // Register the standard (predefined) SDO types
    ModelPackageImpl.init();
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
    throw new UnsupportedOperationException(); //TODO
  }

  public List /*Type*/define(List /*DataObject*/types)
  {
    throw new UnsupportedOperationException(); //TODO
  }
  
}
