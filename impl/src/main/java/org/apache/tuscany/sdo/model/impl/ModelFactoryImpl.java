/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.sdo.model.impl;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.util.Date;
import java.util.List;

import org.apache.tuscany.sdo.model.*;

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
public class ModelFactoryImpl extends EFactoryImpl implements ModelFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final ModelFactoryImpl eINSTANCE = init();

  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ModelFactoryImpl init()
  {
    try
    {
      ModelFactoryImpl theModelFactory = (ModelFactoryImpl)EPackage.Registry.INSTANCE.getEFactory("commonj.sdo"); 
      if (theModelFactory != null)
      {
        return theModelFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ModelFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelFactoryImpl()
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
      case ModelPackageImpl.CHANGE_SUMMARY_TYPE: return (EObject)createChangeSummaryType();
      case ModelPackageImpl.DATA_GRAPH_TYPE: return (EObject)createDataGraphType();
      case ModelPackageImpl.DOCUMENT_ROOT: return (EObject)createDocumentRoot();
      case ModelPackageImpl.MODELS_TYPE: return (EObject)createModelsType();
      case ModelPackageImpl.PROPERTY: return (EObject)createProperty();
      case ModelPackageImpl.TYPE: return (EObject)createType();
      case ModelPackageImpl.TYPES: return (EObject)createTypes();
      case ModelPackageImpl.XSD_TYPE: return (EObject)createXSDType();
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
      case ModelPackageImpl.BOOLEAN:
        return createBooleanFromString(eDataType, initialValue);
      case ModelPackageImpl.BOOLEAN_OBJECT:
        return createBooleanObjectFromString(eDataType, initialValue);
      case ModelPackageImpl.BYTE:
        return createByteFromString(eDataType, initialValue);
      case ModelPackageImpl.BYTE_OBJECT:
        return createByteObjectFromString(eDataType, initialValue);
      case ModelPackageImpl.BYTES:
        return createBytesFromString(eDataType, initialValue);
      case ModelPackageImpl.CHARACTER:
        return createCharacterFromString(eDataType, initialValue);
      case ModelPackageImpl.CHARACTER_OBJECT:
        return createCharacterObjectFromString(eDataType, initialValue);
      case ModelPackageImpl.DATE:
        return createDateFromString(eDataType, initialValue);
      case ModelPackageImpl.DATE_TIME:
        return createDateTimeFromString(eDataType, initialValue);
      case ModelPackageImpl.DAY:
        return createDayFromString(eDataType, initialValue);
      case ModelPackageImpl.DECIMAL:
        return createDecimalFromString(eDataType, initialValue);
      case ModelPackageImpl.DOUBLE:
        return createDoubleFromString(eDataType, initialValue);
      case ModelPackageImpl.DOUBLE_OBJECT:
        return createDoubleObjectFromString(eDataType, initialValue);
      case ModelPackageImpl.DURATION:
        return createDurationFromString(eDataType, initialValue);
      case ModelPackageImpl.FLOAT:
        return createFloatFromString(eDataType, initialValue);
      case ModelPackageImpl.FLOAT_OBJECT:
        return createFloatObjectFromString(eDataType, initialValue);
      case ModelPackageImpl.INT:
        return createIntFromString(eDataType, initialValue);
      case ModelPackageImpl.INTEGER:
        return createIntegerFromString(eDataType, initialValue);
      case ModelPackageImpl.INT_OBJECT:
        return createIntObjectFromString(eDataType, initialValue);
      case ModelPackageImpl.LONG:
        return createLongFromString(eDataType, initialValue);
      case ModelPackageImpl.LONG_OBJECT:
        return createLongObjectFromString(eDataType, initialValue);
      case ModelPackageImpl.MONTH:
        return createMonthFromString(eDataType, initialValue);
      case ModelPackageImpl.MONTH_DAY:
        return createMonthDayFromString(eDataType, initialValue);
      case ModelPackageImpl.OBJECT:
        return createObjectFromString(eDataType, initialValue);
      case ModelPackageImpl.SHORT:
        return createShortFromString(eDataType, initialValue);
      case ModelPackageImpl.SHORT_OBJECT:
        return createShortObjectFromString(eDataType, initialValue);
      case ModelPackageImpl.STRING:
        return createStringFromString(eDataType, initialValue);
      case ModelPackageImpl.STRINGS:
        return createStringsFromString(eDataType, initialValue);
      case ModelPackageImpl.TIME:
        return createTimeFromString(eDataType, initialValue);
      case ModelPackageImpl.URI:
        return createURIFromString(eDataType, initialValue);
      case ModelPackageImpl.YEAR:
        return createYearFromString(eDataType, initialValue);
      case ModelPackageImpl.YEAR_MONTH:
        return createYearMonthFromString(eDataType, initialValue);
      case ModelPackageImpl.YEAR_MONTH_DAY:
        return createYearMonthDayFromString(eDataType, initialValue);
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
      case ModelPackageImpl.BOOLEAN:
        return convertBooleanToString(eDataType, instanceValue);
      case ModelPackageImpl.BOOLEAN_OBJECT:
        return convertBooleanObjectToString(eDataType, instanceValue);
      case ModelPackageImpl.BYTE:
        return convertByteToString(eDataType, instanceValue);
      case ModelPackageImpl.BYTE_OBJECT:
        return convertByteObjectToString(eDataType, instanceValue);
      case ModelPackageImpl.BYTES:
        return convertBytesToString(eDataType, instanceValue);
      case ModelPackageImpl.CHARACTER:
        return convertCharacterToString(eDataType, instanceValue);
      case ModelPackageImpl.CHARACTER_OBJECT:
        return convertCharacterObjectToString(eDataType, instanceValue);
      case ModelPackageImpl.DATE:
        return convertDateToString(eDataType, instanceValue);
      case ModelPackageImpl.DATE_TIME:
        return convertDateTimeToString(eDataType, instanceValue);
      case ModelPackageImpl.DAY:
        return convertDayToString(eDataType, instanceValue);
      case ModelPackageImpl.DECIMAL:
        return convertDecimalToString(eDataType, instanceValue);
      case ModelPackageImpl.DOUBLE:
        return convertDoubleToString(eDataType, instanceValue);
      case ModelPackageImpl.DOUBLE_OBJECT:
        return convertDoubleObjectToString(eDataType, instanceValue);
      case ModelPackageImpl.DURATION:
        return convertDurationToString(eDataType, instanceValue);
      case ModelPackageImpl.FLOAT:
        return convertFloatToString(eDataType, instanceValue);
      case ModelPackageImpl.FLOAT_OBJECT:
        return convertFloatObjectToString(eDataType, instanceValue);
      case ModelPackageImpl.INT:
        return convertIntToString(eDataType, instanceValue);
      case ModelPackageImpl.INTEGER:
        return convertIntegerToString(eDataType, instanceValue);
      case ModelPackageImpl.INT_OBJECT:
        return convertIntObjectToString(eDataType, instanceValue);
      case ModelPackageImpl.LONG:
        return convertLongToString(eDataType, instanceValue);
      case ModelPackageImpl.LONG_OBJECT:
        return convertLongObjectToString(eDataType, instanceValue);
      case ModelPackageImpl.MONTH:
        return convertMonthToString(eDataType, instanceValue);
      case ModelPackageImpl.MONTH_DAY:
        return convertMonthDayToString(eDataType, instanceValue);
      case ModelPackageImpl.OBJECT:
        return convertObjectToString(eDataType, instanceValue);
      case ModelPackageImpl.SHORT:
        return convertShortToString(eDataType, instanceValue);
      case ModelPackageImpl.SHORT_OBJECT:
        return convertShortObjectToString(eDataType, instanceValue);
      case ModelPackageImpl.STRING:
        return convertStringToString(eDataType, instanceValue);
      case ModelPackageImpl.STRINGS:
        return convertStringsToString(eDataType, instanceValue);
      case ModelPackageImpl.TIME:
        return convertTimeToString(eDataType, instanceValue);
      case ModelPackageImpl.URI:
        return convertURIToString(eDataType, instanceValue);
      case ModelPackageImpl.YEAR:
        return convertYearToString(eDataType, instanceValue);
      case ModelPackageImpl.YEAR_MONTH:
        return convertYearMonthToString(eDataType, instanceValue);
      case ModelPackageImpl.YEAR_MONTH_DAY:
        return convertYearMonthDayToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeSummaryType createChangeSummaryType()
  {
    ChangeSummaryTypeImpl changeSummaryType = new ChangeSummaryTypeImpl();
    return changeSummaryType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataGraphType createDataGraphType()
  {
    DataGraphTypeImpl dataGraphType = new DataGraphTypeImpl();
    return dataGraphType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject createDocumentRoot()
  {
    EObject documentRoot = super.create(ModelPackageImpl.Literals.DOCUMENT_ROOT);
    return documentRoot;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelsType createModelsType()
  {
    ModelsTypeImpl modelsType = new ModelsTypeImpl();
    return modelsType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property createProperty()
  {
    PropertyImpl property = new PropertyImpl();
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type createType()
  {
    TypeImpl type = new TypeImpl();
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Types createTypes()
  {
    TypesImpl types = new TypesImpl();
    return types;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XSDType createXSDType()
  {
    XSDTypeImpl xsdType = new XSDTypeImpl();
    return xsdType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Boolean createBooleanFromString(EDataType eDataType, String initialValue)
  {
    return (Boolean)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertBooleanToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Boolean createBooleanObjectFromString(EDataType eDataType, String initialValue)
  {
    return (Boolean)createBooleanFromString(ModelPackageImpl.Literals.BOOLEAN, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertBooleanObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertBooleanToString(ModelPackageImpl.Literals.BOOLEAN, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Byte createByteFromString(EDataType eDataType, String initialValue)
  {
    return (Byte)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertByteToString(EDataType eDataType, Object instanceValue)
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
    return (Byte)createByteFromString(ModelPackageImpl.Literals.BYTE, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertByteObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertByteToString(ModelPackageImpl.Literals.BYTE, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public byte[] createBytesFromString(EDataType eDataType, String initialValue)
  {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertBytesToString(EDataType eDataType, Object instanceValue)
  {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Character createCharacterFromString(EDataType eDataType, String initialValue)
  {
    return (Character)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertCharacterToString(EDataType eDataType, Object instanceValue)
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
    return (Character)createCharacterFromString(ModelPackageImpl.Literals.CHARACTER, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertCharacterObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertCharacterToString(ModelPackageImpl.Literals.CHARACTER, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Date createDateFromString(EDataType eDataType, String initialValue)
  {
    return (Date)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertDateToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createDateTimeFromString(EDataType eDataType, String initialValue)
  {
    return (String)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertDateTimeToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createDayFromString(EDataType eDataType, String initialValue)
  {
    return (String)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertDayToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigDecimal createDecimalFromString(EDataType eDataType, String initialValue)
  {
    return (BigDecimal)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertDecimalToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Double createDoubleFromString(EDataType eDataType, String initialValue)
  {
    return (Double)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertDoubleToString(EDataType eDataType, Object instanceValue)
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
    return (Double)createDoubleFromString(ModelPackageImpl.Literals.DOUBLE, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertDoubleObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertDoubleToString(ModelPackageImpl.Literals.DOUBLE, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createDurationFromString(EDataType eDataType, String initialValue)
  {
    return (String)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertDurationToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Float createFloatFromString(EDataType eDataType, String initialValue)
  {
    return (Float)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertFloatToString(EDataType eDataType, Object instanceValue)
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
    return (Float)createFloatFromString(ModelPackageImpl.Literals.FLOAT, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertFloatObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertFloatToString(ModelPackageImpl.Literals.FLOAT, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Integer createIntFromString(EDataType eDataType, String initialValue)
  {
    return (Integer)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertIntToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigInteger createIntegerFromString(EDataType eDataType, String initialValue)
  {
    return (BigInteger)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertIntegerToString(EDataType eDataType, Object instanceValue)
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
    return (Integer)createIntFromString(ModelPackageImpl.Literals.INT, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertIntObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertIntToString(ModelPackageImpl.Literals.INT, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Long createLongFromString(EDataType eDataType, String initialValue)
  {
    return (Long)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertLongToString(EDataType eDataType, Object instanceValue)
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
    return (Long)createLongFromString(ModelPackageImpl.Literals.LONG, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertLongObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertLongToString(ModelPackageImpl.Literals.LONG, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createMonthFromString(EDataType eDataType, String initialValue)
  {
    return (String)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertMonthToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createMonthDayFromString(EDataType eDataType, String initialValue)
  {
    return (String)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertMonthDayToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object createObjectFromString(EDataType eDataType, String initialValue)
  {
    return (Object)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertObjectToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Short createShortFromString(EDataType eDataType, String initialValue)
  {
    return (Short)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertShortToString(EDataType eDataType, Object instanceValue)
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
    return (Short)createShortFromString(ModelPackageImpl.Literals.SHORT, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertShortObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertShortToString(ModelPackageImpl.Literals.SHORT, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createStringFromString(EDataType eDataType, String initialValue)
  {
    return (String)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertStringToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List createStringsFromString(EDataType eDataType, String initialValue)
  {
    return (List)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertStringsToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createTimeFromString(EDataType eDataType, String initialValue)
  {
    return (String)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTimeToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createURIFromString(EDataType eDataType, String initialValue)
  {
    return (String)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertURIToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createYearFromString(EDataType eDataType, String initialValue)
  {
    return (String)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertYearToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createYearMonthFromString(EDataType eDataType, String initialValue)
  {
    return (String)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertYearMonthToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createYearMonthDayFromString(EDataType eDataType, String initialValue)
  {
    return (String)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertYearMonthDayToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelPackageImpl getModelPackageImpl()
  {
    return (ModelPackageImpl)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  public static ModelPackageImpl getPackage()
  {
    return ModelPackageImpl.eINSTANCE;
  }

} //ModelFactoryImpl
