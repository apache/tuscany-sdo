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
package org.apache.tuscany.sdo.model.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.apache.tuscany.sdo.SDOFactory;
import org.apache.tuscany.sdo.model.ChangeSummaryType;
import org.apache.tuscany.sdo.model.DataGraphType;
import org.apache.tuscany.sdo.model.ModelFactory;
import org.apache.tuscany.sdo.model.ModelsType;
import org.apache.tuscany.sdo.model.Property;
import org.apache.tuscany.sdo.model.Type;
import org.apache.tuscany.sdo.model.Types;
import org.apache.tuscany.sdo.model.XSDType;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;

import commonj.sdo.helper.DataHelper;

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
  public EObject createGen(EClass eClass)
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
  
  public EObject create(EClass eClass)
  {
    if (eClass.getClassifierID() == ModelPackageImpl.DATA_OBJECT) return SDOFactory.eINSTANCE.createAnyTypeDataObject();
    return createGen(eClass);
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
   * @generated NOT
   */
  public Boolean createBooleanFromString(EDataType eDataType, String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createBooleanObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertBooleanToString(EDataType eDataType, Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertBooleanObject((Boolean)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Boolean createBooleanObjectFromString(EDataType eDataType, String initialValue)
  {
    return (Boolean)createBooleanFromString(ModelPackageImpl.Literals.BOOLEAN, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertBooleanObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertBooleanToString(ModelPackageImpl.Literals.BOOLEAN, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Byte createByteFromString(EDataType eDataType, String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createByteObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertByteToString(EDataType eDataType, Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertByteObject((Byte)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Byte createByteObjectFromString(EDataType eDataType, String initialValue)
  {
    return (Byte)createByteFromString(ModelPackageImpl.Literals.BYTE, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertByteObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertByteToString(ModelPackageImpl.Literals.BYTE, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public byte[] createBytesFromString(EDataType eDataType, String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createBase64Binary(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertBytesToString(EDataType eDataType, Object instanceValue)
  {
    if (instanceValue instanceof byte[]) {
      return XMLTypeFactory.eINSTANCE.convertBase64Binary((byte[])instanceValue);
    } else {
      return XMLTypeFactory.eINSTANCE.convertBase64Binary(instanceValue.toString().getBytes());
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Character createCharacterFromString(EDataType eDataType, String initialValue)
  {
    return (initialValue == null && initialValue.length() > 0) 
    ? null : (new Character(collapseWhiteSpace(initialValue).charAt(0)));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertCharacterToString(EDataType eDataType, Object instanceValue)
  {
    return String.valueOf(((Character)instanceValue).charValue());
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Character createCharacterObjectFromString(EDataType eDataType, String initialValue)
  {
    return (Character)createCharacterFromString(ModelPackageImpl.Literals.CHARACTER, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertCharacterObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertCharacterToString(ModelPackageImpl.Literals.CHARACTER, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Date createDateFromString(EDataType eDataType, String initialValue)
  {
    // XMLCalendar cal = (XMLCalendar) XMLTypeFactory.eINSTANCE.createDate(initialValue);
    // return (cal != null) ? cal.getDate() : null;
    return DataHelper.INSTANCE.toDate(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertDateToString(EDataType eDataType, Object instanceValue)
  {
    // return XMLTypeFactory.eINSTANCE.convertDate(instanceValue);
    return DataHelper.INSTANCE.toDateTime((Date)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String createDateTimeFromString(EDataType eDataType, String initialValue)
  {
      return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertDateTimeToString(EDataType eDataType, Object instanceValue)
  {
      return (String)instanceValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String createDayFromString(EDataType eDataType, String initialValue)
  {
      return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertDayToString(EDataType eDataType, Object instanceValue)
  {
      return (String)instanceValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public BigDecimal createDecimalFromString(EDataType eDataType, String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createDecimal(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertDecimalToString(EDataType eDataType, Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertDecimal((BigDecimal)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Double createDoubleFromString(EDataType eDataType, String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createDoubleObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertDoubleToString(EDataType eDataType, Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertDoubleObject((Double)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Double createDoubleObjectFromString(EDataType eDataType, String initialValue)
  {
    return (Double)createDoubleFromString(ModelPackageImpl.Literals.DOUBLE, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertDoubleObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertDoubleToString(ModelPackageImpl.Literals.DOUBLE, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String createDurationFromString(EDataType eDataType, String initialValue)
  {
      return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertDurationToString(EDataType eDataType, Object instanceValue)
  {
      return (String)instanceValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Float createFloatFromString(EDataType eDataType, String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createFloatObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertFloatToString(EDataType eDataType, Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertFloatObject((Float)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Float createFloatObjectFromString(EDataType eDataType, String initialValue)
  {
    return (Float)createFloatFromString(ModelPackageImpl.Literals.FLOAT, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertFloatObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertFloatToString(ModelPackageImpl.Literals.FLOAT, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Integer createIntFromString(EDataType eDataType, String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createIntObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertIntToString(EDataType eDataType, Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertIntObject((Integer)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public BigInteger createIntegerFromString(EDataType eDataType, String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createInteger(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertIntegerToString(EDataType eDataType, Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertInteger((BigInteger)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Integer createIntObjectFromString(EDataType eDataType, String initialValue)
  {
    return (Integer)createIntFromString(ModelPackageImpl.Literals.INT, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertIntObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertIntToString(ModelPackageImpl.Literals.INT, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Long createLongFromString(EDataType eDataType, String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createLongObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertLongToString(EDataType eDataType, Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertLongObject((Long)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Long createLongObjectFromString(EDataType eDataType, String initialValue)
  {
    return (Long)createLongFromString(ModelPackageImpl.Literals.LONG, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertLongObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertLongToString(ModelPackageImpl.Literals.LONG, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String createMonthFromString(EDataType eDataType, String initialValue)
  {
      return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertMonthToString(EDataType eDataType, Object instanceValue)
  {
      return (String)instanceValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String createMonthDayFromString(EDataType eDataType, String initialValue)
  {
      return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertMonthDayToString(EDataType eDataType, Object instanceValue)
  {
      return (String)instanceValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Object createObjectFromString(EDataType eDataType, String initialValue)
  {
    return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertObjectToString(EDataType eDataType, Object instanceValue)
  {
    return (instanceValue != null) ? instanceValue.toString() : null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Short createShortFromString(EDataType eDataType, String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createShortObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertShortToString(EDataType eDataType, Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertShortObject((Short)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Short createShortObjectFromString(EDataType eDataType, String initialValue)
  {
    return (Short)createShortFromString(ModelPackageImpl.Literals.SHORT, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertShortObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertShortToString(ModelPackageImpl.Literals.SHORT, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String createStringFromString(EDataType eDataType, String initialValue)
  {
    return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertStringToString(EDataType eDataType, Object instanceValue)
  {
    return (instanceValue != null) ? instanceValue.toString() : null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public List createStringsFromString(EDataType eDataType, String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createENTITIES(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertStringsToString(EDataType eDataType, Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertENTITIES((List)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String createTimeFromString(EDataType eDataType, String initialValue)
  {
      return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertTimeToString(EDataType eDataType, Object instanceValue)
  {
      return (String)instanceValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String createURIFromString(EDataType eDataType, String initialValue)
  {
    return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertURIToString(EDataType eDataType, Object instanceValue)
  {
    return (instanceValue != null) ? instanceValue.toString() : null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String createYearFromString(EDataType eDataType, String initialValue)
  {
      return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertYearToString(EDataType eDataType, Object instanceValue)
  {
      return (String)instanceValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String createYearMonthFromString(EDataType eDataType, String initialValue)
  {
      return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertYearMonthToString(EDataType eDataType, Object instanceValue)
  {
      return (String)instanceValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String createYearMonthDayFromString(EDataType eDataType, String initialValue)
  {
      return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertYearMonthDayToString(EDataType eDataType, Object instanceValue)
  {
      return (String)instanceValue;
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
  
  // Following methods are temporary ... for interop with new factory codegen pattern
  //
  public static final String NAMESPACE_URI = ModelPackageImpl.eNS_URI;
  public commonj.sdo.Type getBoolean() { return (commonj.sdo.Type)getModelPackageImpl().getBoolean(); }
  public commonj.sdo.Type getBooleanObject() { return (commonj.sdo.Type)getModelPackageImpl().getBooleanObject(); }
  public commonj.sdo.Type getByte() { return (commonj.sdo.Type)getModelPackageImpl().getByte(); }
  public commonj.sdo.Type getByteObject() { return (commonj.sdo.Type)getModelPackageImpl().getByteObject(); }
  public commonj.sdo.Type getBytes() { return (commonj.sdo.Type)getModelPackageImpl().getBytes(); }
  public commonj.sdo.Type getCharacter() { return (commonj.sdo.Type)getModelPackageImpl().getCharacter(); }
  public commonj.sdo.Type getCharacterObject() { return (commonj.sdo.Type)getModelPackageImpl().getCharacterObject(); }
  public commonj.sdo.Type getDate() { return (commonj.sdo.Type)getModelPackageImpl().getDate(); }
  public commonj.sdo.Type getDateTime() { return (commonj.sdo.Type)getModelPackageImpl().getDateTime(); }
  public commonj.sdo.Type getDay() { return (commonj.sdo.Type)getModelPackageImpl().getDay(); }
  public commonj.sdo.Type getDecimal() { return (commonj.sdo.Type)getModelPackageImpl().getDecimal(); }
  public commonj.sdo.Type getDouble() { return (commonj.sdo.Type)getModelPackageImpl().getDouble(); }
  public commonj.sdo.Type getDoubleObject() { return (commonj.sdo.Type)getModelPackageImpl().getDoubleObject(); }
  public commonj.sdo.Type getDuration() { return (commonj.sdo.Type)getModelPackageImpl().getDuration(); }
  public commonj.sdo.Type getFloat() { return (commonj.sdo.Type)getModelPackageImpl().getFloat(); }
  public commonj.sdo.Type getFloatObject() { return (commonj.sdo.Type)getModelPackageImpl().getFloatObject(); }
  public commonj.sdo.Type getInt() { return (commonj.sdo.Type)getModelPackageImpl().getInt(); }
  public commonj.sdo.Type getInteger() { return (commonj.sdo.Type)getModelPackageImpl().getInteger(); }
  public commonj.sdo.Type getIntObject() { return (commonj.sdo.Type)getModelPackageImpl().getIntObject(); }
  public commonj.sdo.Type getLong() { return (commonj.sdo.Type)getModelPackageImpl().getLong(); }
  public commonj.sdo.Type getLongObject() { return (commonj.sdo.Type)getModelPackageImpl().getLongObject(); }
  public commonj.sdo.Type getMonth() { return (commonj.sdo.Type)getModelPackageImpl().getMonth(); }
  public commonj.sdo.Type getMonthDay() { return (commonj.sdo.Type)getModelPackageImpl().getMonthDay(); }
  public commonj.sdo.Type getObject() { return (commonj.sdo.Type)getModelPackageImpl().getObject(); }
  public commonj.sdo.Type getShort() { return (commonj.sdo.Type)getModelPackageImpl().getShort(); }
  public commonj.sdo.Type getShortObject() { return (commonj.sdo.Type)getModelPackageImpl().getShortObject(); }
  public commonj.sdo.Type getString() { return (commonj.sdo.Type)getModelPackageImpl().getString(); }
  public commonj.sdo.Type getStrings() { return (commonj.sdo.Type)getModelPackageImpl().getStrings(); }
  public commonj.sdo.Type getTime() { return (commonj.sdo.Type)getModelPackageImpl().getTime(); }
  public commonj.sdo.Type getURI() { return (commonj.sdo.Type)getModelPackageImpl().getURI(); }
  public commonj.sdo.Type getYear() { return (commonj.sdo.Type)getModelPackageImpl().getYear(); }
  public commonj.sdo.Type getYearMonth() { return (commonj.sdo.Type)getModelPackageImpl().getYearMonth(); }
  public commonj.sdo.Type getYearMonthDay() { return (commonj.sdo.Type)getModelPackageImpl().getYearMonthDay(); }

} //ModelFactoryImpl
