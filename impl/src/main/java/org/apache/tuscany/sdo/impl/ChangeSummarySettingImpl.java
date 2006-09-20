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


import java.util.Map;

import org.apache.tuscany.sdo.SDOPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.change.impl.FeatureChangeImpl;

import commonj.sdo.ChangeSummary;
import commonj.sdo.Property;
/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EChange Summary Setting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ChangeSummarySettingImpl extends FeatureChangeImpl implements ChangeSummary.Setting
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ChangeSummarySettingImpl()
  {
    super();
  }

  protected ChangeSummarySettingImpl(EStructuralFeature feature, Object value, boolean isSet)
  {
    super(feature, value, isSet);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EClass eStaticClass()
  {
    return SDOPackage.eINSTANCE.getChangeSummarySetting();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Object getValue()
  {
    EStructuralFeature feature = getFeature();
    if (feature.isMany())
    {
      if (value == null)
      {
        EObject eObject = (EObject)((Map.Entry)eContainer()).getKey();
        value = getListValue((EList)eObject.eGet(feature));
      }
      return value;
    }
    else
    {
      return super.getValue();
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Property getProperty()
  {
    return (Property)getFeature();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean isSet()
  {
    return super.isSet();
  }

} //EChangeSummarySettingImpl
