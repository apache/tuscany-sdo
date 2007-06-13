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

import org.apache.tuscany.sdo.AnyTypeDataObject;
import org.apache.tuscany.sdo.SDOFactory;
import org.apache.tuscany.sdo.SDOPackage;
import org.apache.tuscany.sdo.SimpleAnyTypeDataObject;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.impl.EcoreFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import commonj.sdo.ChangeSummary;
import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SDOFactoryImpl extends EFactoryImpl implements SDOFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public static SDOFactory init()
  {
    try
    {
      SDOFactory theSDOFactory = (SDOFactory)EPackage.Registry.INSTANCE.getEFactory(SDOPackage.eNS_URI); 
      if (theSDOFactory != null)
      {
        return theSDOFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SDOFactoryImpl();
  }

  public static class SDOEcoreFactory extends EcoreFactoryImpl
  {
    public EClass createEClass() { return new ClassImpl(); }
    public EDataType createEDataType() { return new DataTypeImpl(); }
    //public EEnum createEEnum() { return new EnumImpl(); }
    public EAttribute createEAttribute() { return new AttributeImpl(); }
    public EReference createEReference() { return new ReferenceImpl(); }
    
//    public EFactory createEFactory()
//    {
//      EFactoryImpl eFactory = new EFactoryImpl() { OVERRIDE basicCreate(); } // TODO think about doing this 
//      return eFactory;
//    }  
  }
  
  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SDOFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case SDOPackage.CHANGE_SUMMARY: return (EObject)createChangeSummary();
      case SDOPackage.CHANGE_SUMMARY_SETTING: return (EObject)createChangeSummarySetting();
      case SDOPackage.DATA_GRAPH: return (EObject)createDataGraph();
      case SDOPackage.ANY_TYPE_DATA_OBJECT: return createAnyTypeDataObject();
      case SDOPackage.SIMPLE_ANY_TYPE_DATA_OBJECT: return createSimpleAnyTypeDataObject();
      case SDOPackage.CLASS: return (EObject)createClass();
      case SDOPackage.DATA_TYPE: return (EObject)createDataType();
      case SDOPackage.ATTRIBUTE: return (EObject)createAttribute();
      case SDOPackage.REFERENCE: return (EObject)createReference();
      case SDOPackage.ENUM: return (EObject)createEnum();
      case SDOPackage.DYNAMIC_DATA_OBJECT: return (EObject)createDynamicDataObject();
      case SDOPackage.STORE_DATA_OBJECT: return (EObject)createStoreDataObject();
      case SDOPackage.DYNAMIC_STORE_DATA_OBJECT: return (EObject)createDynamicStoreDataObject();
      case SDOPackage.EXTENSIBLE_DATA_OBJECT: return (EObject)createExtensibleDataObject();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeSummary createChangeSummary()
  {
    ChangeSummaryImpl changeSummary = new ChangeSummaryImpl();
    return changeSummary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeSummary.Setting createChangeSummarySetting()
  {
    ChangeSummarySettingImpl changeSummarySetting = new ChangeSummarySettingImpl();
    return changeSummarySetting;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataGraph createDataGraph()
  {
    DataGraphImpl dataGraph = new DataGraphImpl();
    return dataGraph;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnyTypeDataObject createAnyTypeDataObject()
  {
    AnyTypeDataObjectImpl anyTypeDataObject = new AnyTypeDataObjectImpl();
    return anyTypeDataObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleAnyTypeDataObject createSimpleAnyTypeDataObject()
  {
    SimpleAnyTypeDataObjectImpl simpleAnyTypeDataObject = new SimpleAnyTypeDataObjectImpl();
    return simpleAnyTypeDataObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type createClass()
  {
    ClassImpl class_ = new ClassImpl();
    return class_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type createDataType()
  {
    DataTypeImpl dataType = new DataTypeImpl();
    return dataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property createAttribute()
  {
    AttributeImpl attribute = new AttributeImpl();
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property createReference()
  {
    ReferenceImpl reference = new ReferenceImpl();
    return reference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type createEnum()
  {
    EnumImpl enum_ = new EnumImpl();
    return enum_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataObject createDynamicDataObject()
  {
    DynamicDataObjectImpl dynamicDataObject = new DynamicDataObjectImpl();
    return dynamicDataObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataObject createStoreDataObject()
  {
    StoreDataObjectImpl storeDataObject = new StoreDataObjectImpl();
    return storeDataObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataObject createDynamicStoreDataObject()
  {
    DynamicStoreDataObjectImpl dynamicStoreDataObject = new DynamicStoreDataObjectImpl();
    return dynamicStoreDataObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataObject createExtensibleDataObject()
  {
    ExtensibleDataObjectImpl extensibleDataObject = new ExtensibleDataObjectImpl();
    return extensibleDataObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SDOPackage getSDOPackage()
  {
    return (SDOPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  public static SDOPackage getPackage()
  {
    return SDOPackage.eINSTANCE;
  }

  public ChangeSummary.Setting createChangeSummarySetting(EStructuralFeature eStructuralFeature, Object value, boolean isSet)
  {
    ChangeSummarySettingImpl eChangeSummarySetting = new ChangeSummarySettingImpl(eStructuralFeature, value, isSet);
    return eChangeSummarySetting;
  }

} //SDOFactoryImpl
