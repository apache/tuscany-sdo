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

import java.util.List;

//import org.apache.tuscany.sdo.SDOPackage;

import org.apache.tuscany.sdo.util.BasicSequence;
import org.apache.tuscany.sdo.util.DataObjectUtil;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EAttributeImpl;
import org.eclipse.emf.ecore.util.FeatureMap;

import commonj.sdo.Property;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AttributeImpl extends EAttributeImpl implements Property
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttributeImpl()
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
    return EcorePackage.eINSTANCE.getEAttribute();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Object getDefault()
  {
    return getDefaultValue();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean isReadOnly()
  {
    //return "true".equals(EcoreUtil.getAnnotation(this, "commonj.sdo", "readOnly"));
    return !isChangeable(); //TODO semantics don't exactly match?
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
  public Type getType()
  {
    return (Type)getEType();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Type getContainingType()
  {
    return (Type)getEContainingClass();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Property getOpposite()
  {
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean isContainment()
  {
    return false;
  }
  
  protected EStructuralFeature.Internal.SettingDelegate createFeatureMapSettingDelegate()
  {
    return new InternalSettingDelegateSequence(this);
  }

  public static class InternalSettingDelegateSequence extends InternalSettingDelegateMany
  {
    InternalSettingDelegateSequence(EStructuralFeature feature)
    {
      super(InternalSettingDelegateMany.FEATURE_MAP, feature);
    }

    protected EStructuralFeature.Setting createDynamicSetting(InternalEObject owner)
    {
      FeatureMap.Internal featureMap = (FeatureMap.Internal)super.createDynamicSetting(owner);
      new BasicSequence(featureMap);
      return featureMap;
    }
  }

} //AttributeImpl
