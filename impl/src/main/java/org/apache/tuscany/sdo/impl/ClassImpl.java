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

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.tuscany.sdo.util.DataObjectUtil;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import commonj.sdo.Property;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ClassImpl extends EClassImpl implements Type
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  protected EClass eStaticClass()
  {
    return EcorePackage.eINSTANCE.getEClass();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String getURI()
  {
    return getEPackage().getNsURI();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean isDataType()
  {
    return false;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean isOpen()
  {
    for (int i = 0, count = getFeatureCount(); i < count; ++i)
    {
      EStructuralFeature eStructuralFeature = getEStructuralFeature(i);
      switch (ExtendedMetaData.INSTANCE.getFeatureKind(eStructuralFeature))
      {
        case ExtendedMetaData.ELEMENT_WILDCARD_FEATURE:
        case ExtendedMetaData.ATTRIBUTE_WILDCARD_FEATURE:
        case ExtendedMetaData.GROUP_FEATURE:
          return true;
      }
    }
    return false;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean isSequenced()
  {
    // isSequenced == isMixed 
    return ExtendedMetaData.INSTANCE.getMixedFeature(this) != null;
  }

  protected List aliasNames = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public List getAliasNames()
  {
    if (aliasNames == null)
    {
      aliasNames = DataObjectUtil.getAliasNames(this);
    }
    return aliasNames;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public List getDeclaredProperties()
  {
    return getEStructuralFeatures();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public List getProperties()
  {
    return getEAllStructuralFeatures();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public List getBaseTypes()
  {
    return getESuperTypes();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Property getProperty(String propertyName)
  {
    if (propertyNameToPropertyMap == null) //FB use eNameToFeatureMap for this?
    {
      Map result = new HashMap();
      for (Iterator i = getProperties().iterator(); i.hasNext(); )
      {
        Property property = (Property)i.next();
        result.put(property.getName(), property);

        List aliasNames = property.getAliasNames();
        for (int count = aliasNames.size(); count > 0; )
        {
          result.put(aliasNames.get(--count), property);
        }
      }
      propertyNameToPropertyMap = result;
    }

    return (Property)propertyNameToPropertyMap.get(propertyName);
  }
  
  protected Map propertyNameToPropertyMap;

} //ClassTypeImpl
