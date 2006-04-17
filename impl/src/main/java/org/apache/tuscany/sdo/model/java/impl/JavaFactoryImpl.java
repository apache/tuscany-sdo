/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.sdo.model.java.impl;

import org.apache.tuscany.sdo.model.java.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

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
   * @generated
   */
  public Boolean createBooleanObjectFromString(EDataType eDataType, String initialValue)
  {
    return (Boolean)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertBooleanObjectToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Byte createByteObjectFromString(EDataType eDataType, String initialValue)
  {
    return (Byte)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertByteObjectToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Character createCharacterObjectFromString(EDataType eDataType, String initialValue)
  {
    return (Character)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertCharacterObjectToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Double createDoubleObjectFromString(EDataType eDataType, String initialValue)
  {
    return (Double)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertDoubleObjectToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Float createFloatObjectFromString(EDataType eDataType, String initialValue)
  {
    return (Float)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertFloatObjectToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Integer createIntObjectFromString(EDataType eDataType, String initialValue)
  {
    return (Integer)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertIntObjectToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Long createLongObjectFromString(EDataType eDataType, String initialValue)
  {
    return (Long)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertLongObjectToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Short createShortObjectFromString(EDataType eDataType, String initialValue)
  {
    return (Short)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertShortObjectToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
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
