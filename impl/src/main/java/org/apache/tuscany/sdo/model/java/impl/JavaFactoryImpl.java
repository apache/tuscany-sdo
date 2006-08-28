/**
 *
 * Copyright 2005 The Apache Software Foundation
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
package org.apache.tuscany.sdo.model.java.impl;

import org.apache.tuscany.sdo.model.java.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JavaFactoryImpl extends EFactoryImpl implements JavaFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final JavaFactoryImpl eINSTANCE = init();

  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static JavaFactoryImpl init()
  {
    try
    {
      JavaFactoryImpl theJavaFactory = (JavaFactoryImpl)EPackage.Registry.INSTANCE.getEFactory("commonj.sdo/java"); 
      if (theJavaFactory != null)
      {
        return theJavaFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new JavaFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaFactoryImpl()
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
      case JavaPackageImpl.DOCUMENT_ROOT: return (EObject)createDocumentRoot();
      case JavaPackageImpl.JAVA_INFO: return (EObject)createJavaInfo();
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
      case JavaPackageImpl.BOOLEAN_OBJECT:
        return createBooleanObjectFromString(eDataType, initialValue);
      case JavaPackageImpl.BYTE_OBJECT:
        return createByteObjectFromString(eDataType, initialValue);
      case JavaPackageImpl.CHARACTER_OBJECT:
        return createCharacterObjectFromString(eDataType, initialValue);
      case JavaPackageImpl.DOUBLE_OBJECT:
        return createDoubleObjectFromString(eDataType, initialValue);
      case JavaPackageImpl.FLOAT_OBJECT:
        return createFloatObjectFromString(eDataType, initialValue);
      case JavaPackageImpl.INT_OBJECT:
        return createIntObjectFromString(eDataType, initialValue);
      case JavaPackageImpl.LONG_OBJECT:
        return createLongObjectFromString(eDataType, initialValue);
      case JavaPackageImpl.SHORT_OBJECT:
        return createShortObjectFromString(eDataType, initialValue);
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
      case JavaPackageImpl.BOOLEAN_OBJECT:
        return convertBooleanObjectToString(eDataType, instanceValue);
      case JavaPackageImpl.BYTE_OBJECT:
        return convertByteObjectToString(eDataType, instanceValue);
      case JavaPackageImpl.CHARACTER_OBJECT:
        return convertCharacterObjectToString(eDataType, instanceValue);
      case JavaPackageImpl.DOUBLE_OBJECT:
        return convertDoubleObjectToString(eDataType, instanceValue);
      case JavaPackageImpl.FLOAT_OBJECT:
        return convertFloatObjectToString(eDataType, instanceValue);
      case JavaPackageImpl.INT_OBJECT:
        return convertIntObjectToString(eDataType, instanceValue);
      case JavaPackageImpl.LONG_OBJECT:
        return convertLongObjectToString(eDataType, instanceValue);
      case JavaPackageImpl.SHORT_OBJECT:
        return convertShortObjectToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject createDocumentRoot()
  {
    EObject documentRoot = super.create(JavaPackageImpl.Literals.DOCUMENT_ROOT);
    return documentRoot;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaInfo createJavaInfo()
  {
    JavaInfoImpl javaInfo = new JavaInfoImpl();
    return javaInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Boolean createBooleanObjectFromString(EDataType eDataType, String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createBooleanObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertBooleanObjectToString(EDataType eDataType, Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertBooleanObject((Boolean)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Byte createByteObjectFromString(EDataType eDataType, String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createByteObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertByteObjectToString(EDataType eDataType, Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertByteObject((Byte)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Character createCharacterObjectFromString(EDataType eDataType, String initialValue)
  {
    return (initialValue == null && initialValue.length() > 0) 
      ? null : (new Character(collapseWhiteSpace(initialValue).charAt(0)));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertCharacterObjectToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Double createDoubleObjectFromString(EDataType eDataType, String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createDoubleObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertDoubleObjectToString(EDataType eDataType, Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertDoubleObject((Double)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Float createFloatObjectFromString(EDataType eDataType, String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createFloatObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertFloatObjectToString(EDataType eDataType, Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertFloatObject((Float)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Integer createIntObjectFromString(EDataType eDataType, String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createIntObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertIntObjectToString(EDataType eDataType, Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertIntObject((Integer)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Long createLongObjectFromString(EDataType eDataType, String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createLongObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertLongObjectToString(EDataType eDataType, Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertLongObject((Long)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Short createShortObjectFromString(EDataType eDataType, String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createShortObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertShortObjectToString(EDataType eDataType, Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertShortObject((Short)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaPackageImpl getJavaPackageImpl()
  {
    return (JavaPackageImpl)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  public static JavaPackageImpl getPackage()
  {
    return JavaPackageImpl.eINSTANCE;
  }

} //JavaFactoryImpl
