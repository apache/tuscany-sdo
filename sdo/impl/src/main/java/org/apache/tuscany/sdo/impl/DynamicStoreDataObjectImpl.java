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

import org.apache.tuscany.sdo.SDOPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import commonj.sdo.DataObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dynamic Store Data Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DynamicStoreDataObjectImpl extends StoreDataObjectImpl implements DataObject
{
  protected EClass eClass;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DynamicStoreDataObjectImpl()
  {
    super();
  }

  public DynamicStoreDataObjectImpl(InternalEObject.EStore eStore)
  {
    super(eStore);
  }

  public DynamicStoreDataObjectImpl(EClass eClass)
  {
    super(eClass);
  }
  
  public DynamicStoreDataObjectImpl(EClass eClass, InternalEObject.EStore eStore)
  {
    super(eClass, eStore);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EClass eStaticClass()
  {
    return SDOPackage.eINSTANCE.getDynamicStoreDataObject();
  }

  protected EClass eDynamicClass()
  {
    return eClass;
  }

  public EClass eClass()
  {
    return eClass;
  }

  public void eSetClass(EClass eClass)
  {
    this.eClass = eClass;
  }

} //DynamicStoreDataObjectImpl
