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
import java.util.StringTokenizer;

import org.apache.tuscany.sdo.SDOExtendedMetaData;
import org.apache.tuscany.sdo.impl.SDOFactoryImpl.SDOEcoreFactory;
import org.apache.tuscany.sdo.model.ModelFactory;
import org.apache.tuscany.sdo.model.impl.ModelFactoryImpl;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EPackage.Registry;

/**
 * TODO make demand() methods synchronous?
 */
public class SDOExtendedMetaDataImpl 
  extends BaseSDOExtendedMetaDataImpl 
  implements SDOExtendedMetaData
{
 
  public SDOExtendedMetaDataImpl() {
      this(HelperContextImpl.getBuiltInModelRegistry());
  }

  public SDOExtendedMetaDataImpl(Registry registry) {
    super(registry);
    ecoreFactory = new SDOEcoreFactory();
    demandMetaData = new SDODemandMetaData();
  }

  public static class SDODemandMetaData extends DemandMetaData {
    EClassifier getEObject() { return (EClassifier)((ModelFactoryImpl)ModelFactory.INSTANCE).getDataObject(); }
    EClassifier getAnySimpleType() { return (EClassifier)((ModelFactoryImpl)ModelFactory.INSTANCE).getObject(); }
  }

  public EPackage getPackage(String namespace)
  {
    if ("".equals(namespace)) namespace = null; //FB
    EPackage result = registry.getEPackage(namespace);
    return result == null ? super.getPackage(namespace) : result;
  }

  /**
   * Returns the listing of alias names as specified by the sdo:aliasNames
   * property.
   */
  public List getAliasNames(EModelElement modelElement) {
    EAnnotation eAnnotation = getAnnotation(modelElement, false);
    List list = null;
    if (eAnnotation != null) {
      String aliasNames = (String)eAnnotation.getDetails().get("aliasNames");
      if (aliasNames != null) {
        list = new ArrayList();
        StringTokenizer st = new StringTokenizer(aliasNames, " ");
        while (st.hasMoreTokens()) {
          String t = st.nextToken();
          list.add(t);
        }
      }
    }
    return list;
  }

  
  public void setAliasNames(EModelElement modelElement, List aliasNames) {
    if (aliasNames == null || aliasNames.isEmpty()) {
      setAliasNames(modelElement, (String)null);
    } else {
      StringBuffer buf = new StringBuffer();
      for (int n = 0; n < aliasNames.size(); n++) {
        String name = (String) aliasNames.get(n);
        buf.append(name);
        buf.append(" ");
      }
      setAliasNames(modelElement, buf.toString());
    }
  }
  
  /**
   * Adds an alias name per sdo:aliasName
   */
  public void setAliasNames(EModelElement modelElement, String aliasNames) {
    EAnnotation eAnnotation = getAnnotation(modelElement, true);
    eAnnotation.getDetails().put("aliasNames", aliasNames);
  }
  
  public EPackage.Registry getRegistry()
  {
    return registry;
  }

  boolean featureNamespaceMatchingLax = true;

  public void setFeatureNamespaceMatchingLax(boolean b) {
    featureNamespaceMatchingLax = b;
  }

  protected boolean isFeatureNamespaceMatchingLax() {
    return featureNamespaceMatchingLax;
  }

  /*
   * (non-Javadoc)
   * 
   * Eagerly pre-cache the "holder"s for static packages.
   * 
   * @see org.eclipse.emf.ecore.util.BasicExtendedMetaData#putPackage(java.lang.String,
   *      org.eclipse.emf.ecore.EPackage)
   */
  public void putPackage(String namespace, EPackage ePackage) {
    for (Iterator iterator = ePackage.eAllContents(); iterator.hasNext();) {
      Object object = iterator.next();
      if (object instanceof EClassifier) {
        this.getName((EClassifier) object);
      } else if (object instanceof EStructuralFeature) {
        this.getName((EStructuralFeature) object);
      }
    }
    super.putPackage(namespace, ePackage);
  }
  
	/****************************************************************************************************** 
   * Following methods, getLocalAttribute & getLocalElement, ARE TEMPORARY COPIES FROM THE BASE CLASS. 
   * One line (the last line)in each method is changed to support lax namespace matching. 
   * DO NOT EDIT THESE METHODS. THEY WILL BE REMOVED WHEN WE MOVE TO EMF 2.3, WHICH FIXES THE PROBLEM.
   ******************************************************************************************************/
 
  public EStructuralFeature getLocalAttribute(EClass eClass, String namespace, String name)
  {
    EStructuralFeature result = null;
    if (isFeatureKindSpecific())
    {
      List allAttributes = getAllAttributes(eClass);
      for (int i = 0, size = allAttributes.size(); i < size; ++i)
      {
        EStructuralFeature eStructuralFeature = (EStructuralFeature) allAttributes.get(i);
        if (name.equals(getName(eStructuralFeature)))
        {
          String featureNamespace = getNamespace(eStructuralFeature);
          if (namespace == null) 
          {
            if (featureNamespace == null)
            {
              return eStructuralFeature;
            }
            else if (result == null)
            {
              result = eStructuralFeature;
            }
          }
          else if (namespace.equals(featureNamespace))
          {
            return eStructuralFeature;
          }
          else if (featureNamespace == null && result == null)
          {
            result = eStructuralFeature;
          }
        }
      }
    }
    else
    {
      for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i)
      {
        EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(i);
        switch (getFeatureKind(eStructuralFeature))
        {
          case UNSPECIFIED_FEATURE:
          case ATTRIBUTE_FEATURE:
          {
            if (name.equals(getName(eStructuralFeature)))
            {
              String featureNamespace = getNamespace(eStructuralFeature);
              if (namespace == null) 
              {
                if (featureNamespace == null)
                {
                  return eStructuralFeature;
                }
                else if (result == null)
                {
                  result = eStructuralFeature;
                }
              }
              else if (namespace.equals(featureNamespace))
              {
                return eStructuralFeature;
              }
              else if (featureNamespace == null && result == null)
              {
                result = eStructuralFeature;
              }
            }
            break;
          }
        }
      }
    }

    return isFeatureNamespaceMatchingLax() ? result : null;
  }

  protected EStructuralFeature getLocalElement(EClass eClass, String namespace, String name)
  {
    EStructuralFeature result = null;
    if (isFeatureKindSpecific())
    {
      List allElements = getAllElements(eClass);
      for (int i = 0, size = allElements.size(); i < size; ++i)
      {
        EStructuralFeature eStructuralFeature = (EStructuralFeature) allElements.get(i);
        if (name.equals(getName(eStructuralFeature)))
        {
          String featureNamespace = getNamespace(eStructuralFeature);
          if (namespace == null) 
          {
            if (featureNamespace == null)
            {
              return eStructuralFeature;
            }
            else if (result == null)
            {
              result = eStructuralFeature;
            }
          }
          else if (namespace.equals(featureNamespace))
          {
            return eStructuralFeature;
          }
          else if (featureNamespace == null && result == null)
          {
            result = eStructuralFeature;
          }
        }
      }
    }
    else
    {
      for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i)
      {
        EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(i);
        switch (getFeatureKind(eStructuralFeature))
        {
          case UNSPECIFIED_FEATURE:
          case ELEMENT_FEATURE:
          {
            if (name.equals(getName(eStructuralFeature)))
            {
              String featureNamespace = getNamespace(eStructuralFeature);
              if (namespace == null) 
              {
                if (featureNamespace == null)
                {
                  return eStructuralFeature;
                }
                else if (result == null)
                {
                  result = eStructuralFeature;
                }
              }
              else if (namespace.equals(featureNamespace))
              {
                return eStructuralFeature;
              }
              else if (featureNamespace == null && result == null)
              {
                result = eStructuralFeature;
              }
            }
            break;
          }
        }
      }
    }

    return isFeatureNamespaceMatchingLax() ? result : null;
  }
}
