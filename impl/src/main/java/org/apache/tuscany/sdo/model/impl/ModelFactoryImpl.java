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
package org.apache.tuscany.sdo.model.impl;

import commonj.sdo.helper.DataHelper;
import commonj.sdo.helper.HelperContext;

import org.apache.tuscany.sdo.SDOFactory;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;

import commonj.sdo.ChangeSummary;
import commonj.sdo.DataObject;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.tuscany.sdo.impl.FactoryBase;

import org.apache.tuscany.sdo.model.*;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the commonj.sdo model factory.
 * This model is generated from sdoModel.xsd, in the sdo-api project.
 * Until the SDO code generator supports name conflicts and regen/merge, follow the following steps to regenerate this model:
 *   1. Regenerate the model into a temporary directory:
 *         XSD2JavaGenerator -generateBuiltIn commonj.sdo -targetDirectory <temp-dir> -javaPackage org.apache.tuscany.sdo.model <sdo-api-dir>/src/main/resources/xml/sdoModel.xsd
 *   2. Rename the following methods in the generated Property/PropertyImpl interface and implementation class:
 *         getDefault() to getDefault_();
 *         setDefault() to setDefault_();
 *         getOpposite() to getOpposite_();
 *         setOpposite() to setOpposite_();
 *   3. Copy the following method from the old to new generated Type/TypeImpl interface and implemention class (resolve any missing imports):
 *         String getInstanceClassName();
 *   4. Copy the following method from the old to new generated Types/TypesImpl interface and implemention class (resolve any missing imports):
 *         List getTypeList();
 *   5. Delete all the createXXXFromString() and convertXXXToString() methods in the newly generated ModelFactoryImpl and
 *      replace them with the ones from this file (resolve any missing imports).
 *   6. Comment out the call to registerStaticTypes of ModelFactory.class in the init() method
 *   7. Change org.apache.tuscany.sdo.model.DataObject.class to commonj.sdo.DataObject.class for the following method found in method initializeMetaData();
 *         initializeType(dataObjectType, commonj.sdo.DataObject.class, "DataObject", true); // generated as org.apache.tuscany.sdo.model.DataObject.class
 *   8. Add the following case to the generated create() method:
 *         case DATA_OBJECT: return SDOFactory.eINSTANCE.createAnyTypeDataObject();
 *   9. Make sure the top of each generated file contains the ASF License.      
 *  10. Move this JavaDoc comment into the newly generated ModelFactoryImpl class.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelFactoryImpl extends FactoryBase implements ModelFactory
{

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_URI = "commonj.sdo";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_PREFIX = "sdo";

  /**
   * The version of the generator pattern used to generate this class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String PATTERN_VERSION = "1.2";
  
  public static final int BASE_DATA_GRAPH_TYPE = 1;	
  public static final int DATA_GRAPH_TYPE = 2;	
  public static final int DATA_OBJECT = 3;	
  public static final int MODELS_TYPE = 4;	
  public static final int PROPERTY = 5;	
  public static final int TEXT_TYPE = 6;	
  public static final int TYPE = 7;	
  public static final int TYPES = 8;	
  public static final int XSD_TYPE = 9;	
  public static final int BOOLEAN = 10;	
  public static final int BOOLEAN_OBJECT = 11;	
  public static final int BYTE = 12;	
  public static final int BYTE_OBJECT = 13;	
  public static final int BYTES = 14;	
  public static final int CHANGE_SUMMARY_TYPE = 15;	
  public static final int CHARACTER = 16;	
  public static final int CHARACTER_OBJECT = 17;	
  public static final int DATE = 18;	
  public static final int DATE_TIME = 19;	
  public static final int DAY = 20;	
  public static final int DECIMAL = 21;	
  public static final int DOUBLE = 22;	
  public static final int DOUBLE_OBJECT = 23;	
  public static final int DURATION = 24;	
  public static final int FLOAT = 25;	
  public static final int FLOAT_OBJECT = 26;	
  public static final int INT = 27;	
  public static final int INTEGER = 28;	
  public static final int INT_OBJECT = 29;	
  public static final int LONG = 30;	
  public static final int LONG_OBJECT = 31;	
  public static final int MONTH = 32;	
  public static final int MONTH_DAY = 33;	
  public static final int OBJECT = 34;	
  public static final int SHORT = 35;	
  public static final int SHORT_OBJECT = 36;	
  public static final int STRING = 37;	
  public static final int STRINGS = 38;	
  public static final int TIME = 39;	
  public static final int URI = 40;	
  public static final int YEAR = 41;	
  public static final int YEAR_MONTH = 42;	
  public static final int YEAR_MONTH_DAY = 43;
  
  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelFactoryImpl()
  {
    super(NAMESPACE_URI, NAMESPACE_PREFIX, "org.apache.tuscany.sdo.model");
  }

  /**
   * Registers the Factory instance so that it is available within the supplied scope.
   * @argument scope a HelperContext instance that will make the types supported by this Factory available.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void register(HelperContext scope) 
  {
    if(scope == null) {
      throw new IllegalArgumentException("Scope can not be null");
    }
    
    //Register dependent packages with provided scope
    
    // Initialize this package   
    TypeHelperImpl th = (TypeHelperImpl)scope.getTypeHelper();
    th.getExtendedMetaData().putPackage(NAMESPACE_URI, this);
  }
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public DataObject create(int typeNumber)
  {
    switch (typeNumber)
    {
      case DATA_GRAPH_TYPE: return (DataObject)createDataGraphType();
      case MODELS_TYPE: return (DataObject)createModelsType();
      case PROPERTY: return (DataObject)createProperty();
      case TYPE: return (DataObject)createType();
      case TYPES: return (DataObject)createTypes();
      case XSD_TYPE: return (DataObject)createXSDType();
      case DATA_OBJECT: return SDOFactory.eINSTANCE.createAnyTypeDataObject();
      default:
        return super.create(typeNumber);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object createFromString(int typeNumber, String initialValue)
  {
    switch (typeNumber)
    {
      case BOOLEAN:
        return createBooleanFromString(initialValue);
      case BOOLEAN_OBJECT:
        return createBooleanObjectFromString(initialValue);
      case BYTE:
        return createByteFromString(initialValue);
      case BYTE_OBJECT:
        return createByteObjectFromString(initialValue);
      case BYTES:
        return createBytesFromString(initialValue);
      case CHANGE_SUMMARY_TYPE:
        return createChangeSummaryTypeFromString(initialValue);
      case CHARACTER:
        return createCharacterFromString(initialValue);
      case CHARACTER_OBJECT:
        return createCharacterObjectFromString(initialValue);
      case DATE:
        return createDateFromString(initialValue);
      case DATE_TIME:
        return createDateTimeFromString(initialValue);
      case DAY:
        return createDayFromString(initialValue);
      case DECIMAL:
        return createDecimalFromString(initialValue);
      case DOUBLE:
        return createDoubleFromString(initialValue);
      case DOUBLE_OBJECT:
        return createDoubleObjectFromString(initialValue);
      case DURATION:
        return createDurationFromString(initialValue);
      case FLOAT:
        return createFloatFromString(initialValue);
      case FLOAT_OBJECT:
        return createFloatObjectFromString(initialValue);
      case INT:
        return createIntFromString(initialValue);
      case INTEGER:
        return createIntegerFromString(initialValue);
      case INT_OBJECT:
        return createIntObjectFromString(initialValue);
      case LONG:
        return createLongFromString(initialValue);
      case LONG_OBJECT:
        return createLongObjectFromString(initialValue);
      case MONTH:
        return createMonthFromString(initialValue);
      case MONTH_DAY:
        return createMonthDayFromString(initialValue);
      case OBJECT:
        return createObjectFromString(initialValue);
      case SHORT:
        return createShortFromString(initialValue);
      case SHORT_OBJECT:
        return createShortObjectFromString(initialValue);
      case STRING:
        return createStringFromString(initialValue);
      case STRINGS:
        return createStringsFromString(initialValue);
      case TIME:
        return createTimeFromString(initialValue);
      case URI:
        return createURIFromString(initialValue);
      case YEAR:
        return createYearFromString(initialValue);
      case YEAR_MONTH:
        return createYearMonthFromString(initialValue);
      case YEAR_MONTH_DAY:
        return createYearMonthDayFromString(initialValue);
      default:
        throw new IllegalArgumentException("The type number '" + typeNumber + "' is not a valid datatype");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertToString(int typeNumber, Object instanceValue)
  {
    switch (typeNumber)
    {
      case BOOLEAN:
        return convertBooleanToString(instanceValue);
      case BOOLEAN_OBJECT:
        return convertBooleanObjectToString(instanceValue);
      case BYTE:
        return convertByteToString(instanceValue);
      case BYTE_OBJECT:
        return convertByteObjectToString(instanceValue);
      case BYTES:
        return convertBytesToString(instanceValue);
      case CHANGE_SUMMARY_TYPE:
        return convertChangeSummaryTypeToString(instanceValue);
      case CHARACTER:
        return convertCharacterToString(instanceValue);
      case CHARACTER_OBJECT:
        return convertCharacterObjectToString(instanceValue);
      case DATE:
        return convertDateToString(instanceValue);
      case DATE_TIME:
        return convertDateTimeToString(instanceValue);
      case DAY:
        return convertDayToString(instanceValue);
      case DECIMAL:
        return convertDecimalToString(instanceValue);
      case DOUBLE:
        return convertDoubleToString(instanceValue);
      case DOUBLE_OBJECT:
        return convertDoubleObjectToString(instanceValue);
      case DURATION:
        return convertDurationToString(instanceValue);
      case FLOAT:
        return convertFloatToString(instanceValue);
      case FLOAT_OBJECT:
        return convertFloatObjectToString(instanceValue);
      case INT:
        return convertIntToString(instanceValue);
      case INTEGER:
        return convertIntegerToString(instanceValue);
      case INT_OBJECT:
        return convertIntObjectToString(instanceValue);
      case LONG:
        return convertLongToString(instanceValue);
      case LONG_OBJECT:
        return convertLongObjectToString(instanceValue);
      case MONTH:
        return convertMonthToString(instanceValue);
      case MONTH_DAY:
        return convertMonthDayToString(instanceValue);
      case OBJECT:
        return convertObjectToString(instanceValue);
      case SHORT:
        return convertShortToString(instanceValue);
      case SHORT_OBJECT:
        return convertShortObjectToString(instanceValue);
      case STRING:
        return convertStringToString(instanceValue);
      case STRINGS:
        return convertStringsToString(instanceValue);
      case TIME:
        return convertTimeToString(instanceValue);
      case URI:
        return convertURIToString(instanceValue);
      case YEAR:
        return convertYearToString(instanceValue);
      case YEAR_MONTH:
        return convertYearMonthToString(instanceValue);
      case YEAR_MONTH_DAY:
        return convertYearMonthDayToString(instanceValue);
      default:
        throw new IllegalArgumentException("The type number '" + typeNumber + "' is not a valid datatype");
    }
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
  
  // Following creates and initializes SDO metadata for the supported types.		
  protected commonj.sdo.Type baseDataGraphTypeType = null;

  public commonj.sdo.Type getBaseDataGraphType()
  {
    return baseDataGraphTypeType;
  }
    
  protected commonj.sdo.Type dataGraphTypeType = null;

  public commonj.sdo.Type getDataGraphType()
  {
    return dataGraphTypeType;
  }
    
  protected commonj.sdo.Type dataObjectType = null;

  public commonj.sdo.Type getDataObject()
  {
    return dataObjectType;
  }
      
  protected commonj.sdo.Type modelsTypeType = null;

  public commonj.sdo.Type getModelsType()
  {
    return modelsTypeType;
  }
    
  protected commonj.sdo.Type propertyType = null;

  public commonj.sdo.Type getProperty()
  {
    return propertyType;
  }
    
  protected commonj.sdo.Type textTypeType = null;

  public commonj.sdo.Type getTextType()
  {
    return textTypeType;
  }
    
  protected commonj.sdo.Type typeType = null;

  public commonj.sdo.Type getType()
  {
    return typeType;
  }
    
  protected commonj.sdo.Type typesType = null;

  public commonj.sdo.Type getTypes()
  {
    return typesType;
  }
    
  protected commonj.sdo.Type xsdTypeType = null;

  public commonj.sdo.Type getXSDType()
  {
    return xsdTypeType;
  }
    
  protected commonj.sdo.Type boolean_Type = null;

  public commonj.sdo.Type getBoolean()
  {
    return boolean_Type;
  }
    
  protected commonj.sdo.Type booleanObjectType = null;

  public commonj.sdo.Type getBooleanObject()
  {
    return booleanObjectType;
  }
    
  protected commonj.sdo.Type byte_Type = null;

  public commonj.sdo.Type getByte()
  {
    return byte_Type;
  }
    
  protected commonj.sdo.Type byteObjectType = null;

  public commonj.sdo.Type getByteObject()
  {
    return byteObjectType;
  }
    
  protected commonj.sdo.Type bytesType = null;

  public commonj.sdo.Type getBytes()
  {
    return bytesType;
  }
    
  protected commonj.sdo.Type changeSummaryTypeType = null;

  public commonj.sdo.Type getChangeSummaryType()
  {
    return changeSummaryTypeType;
  }
    
  protected commonj.sdo.Type characterType = null;

  public commonj.sdo.Type getCharacter()
  {
    return characterType;
  }
    
  protected commonj.sdo.Type characterObjectType = null;

  public commonj.sdo.Type getCharacterObject()
  {
    return characterObjectType;
  }
    
  protected commonj.sdo.Type dateType = null;

  public commonj.sdo.Type getDate()
  {
    return dateType;
  }
    
  protected commonj.sdo.Type dateTimeType = null;

  public commonj.sdo.Type getDateTime()
  {
    return dateTimeType;
  }
    
  protected commonj.sdo.Type dayType = null;

  public commonj.sdo.Type getDay()
  {
    return dayType;
  }
    
  protected commonj.sdo.Type decimalType = null;

  public commonj.sdo.Type getDecimal()
  {
    return decimalType;
  }
    
  protected commonj.sdo.Type double_Type = null;

  public commonj.sdo.Type getDouble()
  {
    return double_Type;
  }
    
  protected commonj.sdo.Type doubleObjectType = null;

  public commonj.sdo.Type getDoubleObject()
  {
    return doubleObjectType;
  }
    
  protected commonj.sdo.Type durationType = null;

  public commonj.sdo.Type getDuration()
  {
    return durationType;
  }
    
  protected commonj.sdo.Type float_Type = null;

  public commonj.sdo.Type getFloat()
  {
    return float_Type;
  }
    
  protected commonj.sdo.Type floatObjectType = null;

  public commonj.sdo.Type getFloatObject()
  {
    return floatObjectType;
  }
    
  protected commonj.sdo.Type int_Type = null;

  public commonj.sdo.Type getInt()
  {
    return int_Type;
  }
    
  protected commonj.sdo.Type integerType = null;

  public commonj.sdo.Type getInteger()
  {
    return integerType;
  }
    
  protected commonj.sdo.Type intObjectType = null;

  public commonj.sdo.Type getIntObject()
  {
    return intObjectType;
  }
    
  protected commonj.sdo.Type long_Type = null;

  public commonj.sdo.Type getLong()
  {
    return long_Type;
  }
    
  protected commonj.sdo.Type longObjectType = null;

  public commonj.sdo.Type getLongObject()
  {
    return longObjectType;
  }
    
  protected commonj.sdo.Type monthType = null;

  public commonj.sdo.Type getMonth()
  {
    return monthType;
  }
    
  protected commonj.sdo.Type monthDayType = null;

  public commonj.sdo.Type getMonthDay()
  {
    return monthDayType;
  }
    
  protected commonj.sdo.Type objectType = null;

  public commonj.sdo.Type getObject()
  {
    return objectType;
  }
    
  protected commonj.sdo.Type short_Type = null;

  public commonj.sdo.Type getShort()
  {
    return short_Type;
  }
    
  protected commonj.sdo.Type shortObjectType = null;

  public commonj.sdo.Type getShortObject()
  {
    return shortObjectType;
  }
    
  protected commonj.sdo.Type stringType = null;

  public commonj.sdo.Type getString()
  {
    return stringType;
  }
    
  protected commonj.sdo.Type stringsType = null;

  public commonj.sdo.Type getStrings()
  {
    return stringsType;
  }
    
  protected commonj.sdo.Type timeType = null;

  public commonj.sdo.Type getTime()
  {
    return timeType;
  }
    
  protected commonj.sdo.Type uriType = null;

  public commonj.sdo.Type getURI()
  {
    return uriType;
  }
    
  protected commonj.sdo.Type yearType = null;

  public commonj.sdo.Type getYear()
  {
    return yearType;
  }
    
  protected commonj.sdo.Type yearMonthType = null;

  public commonj.sdo.Type getYearMonth()
  {
    return yearMonthType;
  }
    
  protected commonj.sdo.Type yearMonthDayType = null;

  public commonj.sdo.Type getYearMonthDay()
  {
    return yearMonthDayType;
  }
  

  private static ModelFactoryImpl instance = null; 
  public static ModelFactoryImpl init()
  {
    if (instance != null ) return instance;
    instance = new ModelFactoryImpl();

    // Initialize dependent packages
    
    // Create package meta-data objects
    instance.createMetaData();

    // Initialize created meta-data
    instance.initializeMetaData();
    
    // Mark meta-data to indicate it can't be changed
    //theModelFactoryImpl.freeze(); //FB do we need to freeze / should we freeze ????

    return instance;
  }
  
  private boolean isCreated = false;

  public void createMetaData()
  {
    if (isCreated) return;
    isCreated = true;	

    // Create types and their properties
    baseDataGraphTypeType = createType(false, BASE_DATA_GRAPH_TYPE);
    createProperty(false, baseDataGraphTypeType,BaseDataGraphTypeImpl.INTERNAL_MODELS); 
    createProperty(false, baseDataGraphTypeType,BaseDataGraphTypeImpl.INTERNAL_XSD); 
    createProperty(true, baseDataGraphTypeType,BaseDataGraphTypeImpl.INTERNAL_CHANGE_SUMMARY); 
    createProperty(true, baseDataGraphTypeType,BaseDataGraphTypeImpl.INTERNAL_ANY_ATTRIBUTE); 
    dataGraphTypeType = createType(false, DATA_GRAPH_TYPE);
    createProperty(true, dataGraphTypeType,DataGraphTypeImpl.INTERNAL_ANY); 
    dataObjectType = createType(false, DATA_OBJECT);
    modelsTypeType = createType(false, MODELS_TYPE);
    createProperty(true, modelsTypeType,ModelsTypeImpl.INTERNAL_ANY); 
    propertyType = createType(false, PROPERTY);
    createProperty(true, propertyType,PropertyImpl.INTERNAL_ALIAS_NAME); 
    createProperty(true, propertyType,PropertyImpl.INTERNAL_ANY); 
    createProperty(true, propertyType,PropertyImpl.INTERNAL_NAME); 
    createProperty(true, propertyType,PropertyImpl.INTERNAL_MANY); 
    createProperty(true, propertyType,PropertyImpl.INTERNAL_CONTAINMENT); 
    createProperty(true, propertyType,PropertyImpl.INTERNAL_DEFAULT); 
    createProperty(true, propertyType,PropertyImpl.INTERNAL_READ_ONLY); 
    createProperty(false, propertyType,PropertyImpl.INTERNAL_TYPE); 
    createProperty(false, propertyType,PropertyImpl.INTERNAL_OPPOSITE); 
    createProperty(true, propertyType,PropertyImpl.INTERNAL_NULLABLE); 
    createProperty(true, propertyType,PropertyImpl.INTERNAL_ANY_ATTRIBUTE); 
    textTypeType = createType(false, TEXT_TYPE);
    createProperty(true, textTypeType,TextTypeImpl.INTERNAL_TEXT); 
    typeType = createType(false, TYPE);
    createProperty(false, typeType,TypeImpl.INTERNAL_BASE_TYPE); 
    createProperty(false, typeType,TypeImpl.INTERNAL_PROPERTY); 
    createProperty(true, typeType,TypeImpl.INTERNAL_ALIAS_NAME); 
    createProperty(true, typeType,TypeImpl.INTERNAL_ANY); 
    createProperty(true, typeType,TypeImpl.INTERNAL_NAME); 
    createProperty(true, typeType,TypeImpl.INTERNAL_URI); 
    createProperty(true, typeType,TypeImpl.INTERNAL_DATA_TYPE); 
    createProperty(true, typeType,TypeImpl.INTERNAL_OPEN); 
    createProperty(true, typeType,TypeImpl.INTERNAL_SEQUENCED); 
    createProperty(true, typeType,TypeImpl.INTERNAL_ABSTRACT); 
    createProperty(true, typeType,TypeImpl.INTERNAL_ANY_ATTRIBUTE); 
    typesType = createType(false, TYPES);
    createProperty(false, typesType,TypesImpl.INTERNAL_TYPE); 
    xsdTypeType = createType(false, XSD_TYPE);
    createProperty(true, xsdTypeType,XSDTypeImpl.INTERNAL_ANY); 

    // Create data types
    boolean_Type = createType(true, BOOLEAN );
    booleanObjectType = createType(true, BOOLEAN_OBJECT );
    byte_Type = createType(true, BYTE );
    byteObjectType = createType(true, BYTE_OBJECT );
    bytesType = createType(true, BYTES );
    changeSummaryTypeType = createType(true, CHANGE_SUMMARY_TYPE );
    characterType = createType(true, CHARACTER );
    characterObjectType = createType(true, CHARACTER_OBJECT );
    dateType = createType(true, DATE );
    dateTimeType = createType(true, DATE_TIME );
    dayType = createType(true, DAY );
    decimalType = createType(true, DECIMAL );
    double_Type = createType(true, DOUBLE );
    doubleObjectType = createType(true, DOUBLE_OBJECT );
    durationType = createType(true, DURATION );
    float_Type = createType(true, FLOAT );
    floatObjectType = createType(true, FLOAT_OBJECT );
    int_Type = createType(true, INT );
    integerType = createType(true, INTEGER );
    intObjectType = createType(true, INT_OBJECT );
    long_Type = createType(true, LONG );
    longObjectType = createType(true, LONG_OBJECT );
    monthType = createType(true, MONTH );
    monthDayType = createType(true, MONTH_DAY );
    objectType = createType(true, OBJECT );
    short_Type = createType(true, SHORT );
    shortObjectType = createType(true, SHORT_OBJECT );
    stringType = createType(true, STRING );
    stringsType = createType(true, STRINGS );
    timeType = createType(true, TIME );
    uriType = createType(true, URI );
    yearType = createType(true, YEAR );
    yearMonthType = createType(true, YEAR_MONTH );
    yearMonthDayType = createType(true, YEAR_MONTH_DAY );
  }
  
  private boolean isInitialized = false;

  public void initializeMetaData()
  {
    if (isInitialized) return;
    isInitialized = true;
    commonj.sdo.Property property = null;

    // Add supertypes to types
    addSuperType(dataGraphTypeType, this.getBaseDataGraphType());

    // Initialize types and properties
    initializeType(baseDataGraphTypeType, BaseDataGraphType.class, "BaseDataGraphType", true);
    property = getLocalProperty(baseDataGraphTypeType, 0);
    initializeProperty(property, this.getModelsType(), "models", null, 0, 1, BaseDataGraphType.class, false, true, false, true , null);

    property = getLocalProperty(baseDataGraphTypeType, 1);
    initializeProperty(property, this.getXSDType(), "xsd", null, 0, 1, BaseDataGraphType.class, false, true, false, true , null);

    property = getLocalProperty(baseDataGraphTypeType, 2);
    initializeProperty(property, this.getChangeSummaryType(), "changeSummary", null, 0, 1, BaseDataGraphType.class, false, true, false);

    property = getLocalProperty(baseDataGraphTypeType, 3);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, BaseDataGraphType.class, false, false, false);

    initializeType(dataGraphTypeType, DataGraphType.class, "DataGraphType", false);
    property = getLocalProperty(dataGraphTypeType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, 1, DataGraphType.class, false, false, false);

    initializeType(dataObjectType, commonj.sdo.DataObject.class, "DataObject", true); // generated as org.apache.tuscany.sdo.model.DataObject.class
    initializeType(modelsTypeType, ModelsType.class, "ModelsType", false);
    property = getLocalProperty(modelsTypeType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, ModelsType.class, false, false, false);

    initializeType(propertyType, Property.class, "Property", false);
    property = getLocalProperty(propertyType, 0);
    initializeProperty(property, this.getString(), "aliasName", null, 0, -1, Property.class, false, false, false);

    property = getLocalProperty(propertyType, 1);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Property.class, false, false, false);

    property = getLocalProperty(propertyType, 2);
    initializeProperty(property, this.getString(), "name", null, 0, 1, Property.class, false, true, false);

    property = getLocalProperty(propertyType, 3);
    initializeProperty(property, this.getBoolean(), "many", null, 0, 1, Property.class, false, true, false);

    property = getLocalProperty(propertyType, 4);
    initializeProperty(property, this.getBoolean(), "containment", null, 0, 1, Property.class, false, true, false);

    property = getLocalProperty(propertyType, 5);
    initializeProperty(property, this.getString(), "default", null, 0, 1, Property.class, false, true, false);

    property = getLocalProperty(propertyType, 6);
    initializeProperty(property, this.getBoolean(), "readOnly", null, 0, 1, Property.class, false, true, false);

    property = getLocalProperty(propertyType, 7);
    initializeProperty(property, this.getType(), "type", null, 0, 1, Property.class, false, true, false, false , null);
    setInstanceProperty (property, "commonj.sdo/xml", "propertyType", "sdo:Type");

    property = getLocalProperty(propertyType, 8);
    initializeProperty(property, this.getProperty(), "opposite", null, 0, 1, Property.class, false, true, false, false , null);
    setInstanceProperty (property, "commonj.sdo/xml", "propertyType", "sdo:Property");

    property = getLocalProperty(propertyType, 9);
    initializeProperty(property, this.getBoolean(), "nullable", null, 0, 1, Property.class, false, true, false);

    property = getLocalProperty(propertyType, 10);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Property.class, false, false, false);

    initializeType(textTypeType, TextType.class, "TextType", true);
    property = getLocalProperty(textTypeType, 0);
    initializeProperty(property, this.getString(), "text", null, 0, -1, TextType.class, false, false, false);

    initializeType(typeType, Type.class, "Type", false);
    property = getLocalProperty(typeType, 0);
    initializeProperty(property, this.getType(), "baseType", null, 0, -1, Type.class, false, false, false, false , null);
    setInstanceProperty (property, "commonj.sdo/xml", "propertyType", "sdo:Type");

    property = getLocalProperty(typeType, 1);
    initializeProperty(property, this.getProperty(), "property", null, 0, -1, Type.class, false, false, false, true , null);

    property = getLocalProperty(typeType, 2);
    initializeProperty(property, this.getString(), "aliasName", null, 0, -1, Type.class, false, false, false);

    property = getLocalProperty(typeType, 3);
    initializeProperty(property, getSequence(), "any", null, 0, -1, Type.class, false, false, false);

    property = getLocalProperty(typeType, 4);
    initializeProperty(property, this.getString(), "name", null, 0, 1, Type.class, false, true, false);
    setInstanceProperty (property, "commonj.sdo/xml", "dataType", "sdo:String");

    property = getLocalProperty(typeType, 5);
    initializeProperty(property, this.getURI(), "uri", null, 0, 1, Type.class, false, true, false);

    property = getLocalProperty(typeType, 6);
    initializeProperty(property, this.getBoolean(), "dataType", null, 0, 1, Type.class, false, true, false);

    property = getLocalProperty(typeType, 7);
    initializeProperty(property, this.getBoolean(), "open", null, 0, 1, Type.class, false, true, false);

    property = getLocalProperty(typeType, 8);
    initializeProperty(property, this.getBoolean(), "sequenced", null, 0, 1, Type.class, false, true, false);

    property = getLocalProperty(typeType, 9);
    initializeProperty(property, this.getBoolean(), "abstract", null, 0, 1, Type.class, false, true, false);

    property = getLocalProperty(typeType, 10);
    initializeProperty(property, getSequence(), "anyAttribute", null, 0, -1, Type.class, false, false, false);

    initializeType(typesType, Types.class, "Types", false);
    property = getLocalProperty(typesType, 0);
    initializeProperty(property, this.getType(), "type", null, 0, -1, Types.class, false, false, false, true , null);

    initializeType(xsdTypeType, XSDType.class, "XSDType", false);
    property = getLocalProperty(xsdTypeType, 0);
    initializeProperty(property, getSequence(), "any", null, 0, -1, XSDType.class, false, false, false);

    // Initialize data types
    initializeType(boolean_Type, boolean.class, "Boolean", true, false);
    setInstanceProperty (boolean_Type, "commonj.sdo/java", "instanceClass", "boolean");

    initializeType(booleanObjectType, Boolean.class, "BooleanObject", true, false);

    initializeType(byte_Type, byte.class, "Byte", true, false);
    setInstanceProperty (byte_Type, "commonj.sdo/java", "instanceClass", "byte");

    initializeType(byteObjectType, Byte.class, "ByteObject", true, false);

    initializeType(bytesType, byte[].class, "Bytes", true, false);
    setInstanceProperty (bytesType, "commonj.sdo/java", "instanceClass", "byte[]");

    initializeType(changeSummaryTypeType, ChangeSummary.class, "ChangeSummaryType", true, false);
    setInstanceProperty (changeSummaryTypeType, "commonj.sdo/java", "instanceClass", "commonj.sdo.ChangeSummary");

    initializeType(characterType, char.class, "Character", true, false);
    setInstanceProperty (characterType, "commonj.sdo/java", "instanceClass", "char");

    initializeType(characterObjectType, Character.class, "CharacterObject", true, false);

    initializeType(dateType, Date.class, "Date", true, false);
    setInstanceProperty (dateType, "commonj.sdo/java", "instanceClass", "java.util.Date");

    initializeType(dateTimeType, String.class, "DateTime", true, false);
    setInstanceProperty (dateTimeType, "commonj.sdo/java", "instanceClass", "java.lang.String");

    initializeType(dayType, String.class, "Day", true, false);
    setInstanceProperty (dayType, "commonj.sdo/java", "instanceClass", "java.lang.String");

    initializeType(decimalType, BigDecimal.class, "Decimal", true, false);
    setInstanceProperty (decimalType, "commonj.sdo/java", "instanceClass", "java.math.BigDecimal");

    initializeType(double_Type, double.class, "Double", true, false);
    setInstanceProperty (double_Type, "commonj.sdo/java", "instanceClass", "double");

    initializeType(doubleObjectType, Double.class, "DoubleObject", true, false);

    initializeType(durationType, String.class, "Duration", true, false);
    setInstanceProperty (durationType, "commonj.sdo/java", "instanceClass", "java.lang.String");

    initializeType(float_Type, float.class, "Float", true, false);
    setInstanceProperty (float_Type, "commonj.sdo/java", "instanceClass", "float");

    initializeType(floatObjectType, Float.class, "FloatObject", true, false);

    initializeType(int_Type, int.class, "Int", true, false);
    setInstanceProperty (int_Type, "commonj.sdo/java", "instanceClass", "int");

    initializeType(integerType, BigInteger.class, "Integer", true, false);
    setInstanceProperty (integerType, "commonj.sdo/java", "instanceClass", "java.math.BigInteger");

    initializeType(intObjectType, Integer.class, "IntObject", true, false);

    initializeType(long_Type, long.class, "Long", true, false);
    setInstanceProperty (long_Type, "commonj.sdo/java", "instanceClass", "long");

    initializeType(longObjectType, Long.class, "LongObject", true, false);

    initializeType(monthType, String.class, "Month", true, false);
    setInstanceProperty (monthType, "commonj.sdo/java", "instanceClass", "java.lang.String");

    initializeType(monthDayType, String.class, "MonthDay", true, false);
    setInstanceProperty (monthDayType, "commonj.sdo/java", "instanceClass", "java.lang.String");

    initializeType(objectType, Object.class, "Object", true, false);
    setInstanceProperty (objectType, "commonj.sdo/java", "instanceClass", "java.lang.Object");

    initializeType(short_Type, short.class, "Short", true, false);
    setInstanceProperty (short_Type, "commonj.sdo/java", "instanceClass", "short");

    initializeType(shortObjectType, Short.class, "ShortObject", true, false);

    initializeType(stringType, String.class, "String", true, false);
    setInstanceProperty (stringType, "commonj.sdo/java", "instanceClass", "java.lang.String");

    initializeType(stringsType, List.class, "Strings", true, false);
    setInstanceProperty (stringsType, "commonj.sdo/java", "instanceClass", "java.util.List");

    initializeType(timeType, String.class, "Time", true, false);
    setInstanceProperty (timeType, "commonj.sdo/java", "instanceClass", "java.lang.String");

    initializeType(uriType, String.class, "URI", true, false);
    setInstanceProperty (uriType, "commonj.sdo/java", "instanceClass", "java.lang.String");

    initializeType(yearType, String.class, "Year", true, false);
    setInstanceProperty (yearType, "commonj.sdo/java", "instanceClass", "java.lang.String");

    initializeType(yearMonthType, String.class, "YearMonth", true, false);
    setInstanceProperty (yearMonthType, "commonj.sdo/java", "instanceClass", "java.lang.String");

    initializeType(yearMonthDayType, String.class, "YearMonthDay", true, false);
    setInstanceProperty (yearMonthDayType, "commonj.sdo/java", "instanceClass", "java.lang.String");

    createXSDMetaData();
  }
    
  protected void createXSDMetaData()
  {
    super.initXSD();
    
    commonj.sdo.Property property = null;
    

    addXSDMapping
      (baseDataGraphTypeType,
       new String[] 
       {
       "name", "BaseDataGraphType",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(baseDataGraphTypeType, BaseDataGraphTypeImpl.INTERNAL_MODELS),
       new String[]
       {
       "kind", "element",
       "name", "models"
       });

    addXSDMapping
      (getProperty(baseDataGraphTypeType, BaseDataGraphTypeImpl.INTERNAL_XSD),
       new String[]
       {
       "kind", "element",
       "name", "xsd"
       });

    addXSDMapping
      (getProperty(baseDataGraphTypeType, BaseDataGraphTypeImpl.INTERNAL_CHANGE_SUMMARY),
       new String[]
       {
       "kind", "element",
       "name", "changeSummary"
       });

    addXSDMapping
      (getProperty(baseDataGraphTypeType, BaseDataGraphTypeImpl.INTERNAL_ANY_ATTRIBUTE),
       new String[]
       {
       "kind", "attributeWildcard",
       "wildcards", "##other",
       "name", ":3",
       "processing", "lax"
       });

    addXSDMapping
      (dataGraphTypeType,
       new String[] 
       {
       "name", "DataGraphType",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(dataGraphTypeType, DataGraphTypeImpl.INTERNAL_ANY),
       new String[]
       {
       "kind", "elementWildcard",
       "wildcards", "##other",
       "name", ":4",
       "processing", "lax"
       });

    addXSDMapping
      (dataObjectType,
       new String[] 
       {
       "name", "DataObject",
       "kind", "empty"
       });

    property = createGlobalProperty
      ("datagraph",
      this.getDataGraphType(),
       new String[]
       {
       "kind", "element",
       "name", "datagraph",
       "namespace", "##targetNamespace"
       });
                    
    property = createGlobalProperty
      ("dataObject",
      this.getDataObject(),
       new String[]
       {
       "kind", "element",
       "name", "dataObject",
       "namespace", "##targetNamespace"
       });
                    
    property = createGlobalProperty
      ("type",
      this.getType(),
       new String[]
       {
       "kind", "element",
       "name", "type",
       "namespace", "##targetNamespace"
       });
                    
    property = createGlobalProperty
      ("types",
      this.getTypes(),
       new String[]
       {
       "kind", "element",
       "name", "types",
       "namespace", "##targetNamespace"
       });
                    
    property = createGlobalProperty
      ("ref",
      this.getString(),
       new String[]
       {
       "kind", "attribute",
       "name", "ref",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                    
    property = createGlobalProperty
      ("unset",
      this.getString(),
       new String[]
       {
       "kind", "attribute",
       "name", "unset",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                    
    addXSDMapping
      (modelsTypeType,
       new String[] 
       {
       "name", "ModelsType",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(modelsTypeType, ModelsTypeImpl.INTERNAL_ANY),
       new String[]
       {
       "kind", "elementWildcard",
       "wildcards", "##other",
       "name", ":0",
       "processing", "lax"
       });

    addXSDMapping
      (propertyType,
       new String[] 
       {
       "name", "Property",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(propertyType, PropertyImpl.INTERNAL_ALIAS_NAME),
       new String[]
       {
       "kind", "element",
       "name", "aliasName",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(propertyType, PropertyImpl.INTERNAL_ANY),
       new String[]
       {
       "kind", "elementWildcard",
       "wildcards", "##other",
       "name", ":1",
       "processing", "lax"
       });

    addXSDMapping
      (getProperty(propertyType, PropertyImpl.INTERNAL_NAME),
       new String[]
       {
       "kind", "attribute",
       "name", "name"
       });

    addXSDMapping
      (getProperty(propertyType, PropertyImpl.INTERNAL_MANY),
       new String[]
       {
       "kind", "attribute",
       "name", "many"
       });

    addXSDMapping
      (getProperty(propertyType, PropertyImpl.INTERNAL_CONTAINMENT),
       new String[]
       {
       "kind", "attribute",
       "name", "containment"
       });

    addXSDMapping
      (getProperty(propertyType, PropertyImpl.INTERNAL_DEFAULT),
       new String[]
       {
       "kind", "attribute",
       "name", "default"
       });

    addXSDMapping
      (getProperty(propertyType, PropertyImpl.INTERNAL_READ_ONLY),
       new String[]
       {
       "kind", "attribute",
       "name", "readOnly"
       });

    addXSDMapping
      (getProperty(propertyType, PropertyImpl.INTERNAL_TYPE),
       new String[]
       {
       "kind", "attribute",
       "name", "type"
       });

    addXSDMapping
      (getProperty(propertyType, PropertyImpl.INTERNAL_OPPOSITE),
       new String[]
       {
       "kind", "attribute",
       "name", "opposite"
       });

    addXSDMapping
      (getProperty(propertyType, PropertyImpl.INTERNAL_NULLABLE),
       new String[]
       {
       "kind", "attribute",
       "name", "nullable"
       });

    addXSDMapping
      (getProperty(propertyType, PropertyImpl.INTERNAL_ANY_ATTRIBUTE),
       new String[]
       {
       "kind", "attributeWildcard",
       "wildcards", "##any",
       "name", ":10",
       "processing", "lax"
       });

    addXSDMapping
      (textTypeType,
       new String[] 
       {
       "name", "TextType",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(textTypeType, TextTypeImpl.INTERNAL_TEXT),
       new String[]
       {
       "kind", "element",
       "name", "text",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (typeType,
       new String[] 
       {
       "name", "Type",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(typeType, TypeImpl.INTERNAL_BASE_TYPE),
       new String[]
       {
       "kind", "element",
       "name", "baseType",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(typeType, TypeImpl.INTERNAL_PROPERTY),
       new String[]
       {
       "kind", "element",
       "name", "property",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(typeType, TypeImpl.INTERNAL_ALIAS_NAME),
       new String[]
       {
       "kind", "element",
       "name", "aliasName",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (getProperty(typeType, TypeImpl.INTERNAL_ANY),
       new String[]
       {
       "kind", "elementWildcard",
       "wildcards", "##other",
       "name", ":3",
       "processing", "lax"
       });

    addXSDMapping
      (getProperty(typeType, TypeImpl.INTERNAL_NAME),
       new String[]
       {
       "kind", "attribute",
       "name", "name"
       });

    addXSDMapping
      (getProperty(typeType, TypeImpl.INTERNAL_URI),
       new String[]
       {
       "kind", "attribute",
       "name", "uri"
       });

    addXSDMapping
      (getProperty(typeType, TypeImpl.INTERNAL_DATA_TYPE),
       new String[]
       {
       "kind", "attribute",
       "name", "dataType"
       });

    addXSDMapping
      (getProperty(typeType, TypeImpl.INTERNAL_OPEN),
       new String[]
       {
       "kind", "attribute",
       "name", "open"
       });

    addXSDMapping
      (getProperty(typeType, TypeImpl.INTERNAL_SEQUENCED),
       new String[]
       {
       "kind", "attribute",
       "name", "sequenced"
       });

    addXSDMapping
      (getProperty(typeType, TypeImpl.INTERNAL_ABSTRACT),
       new String[]
       {
       "kind", "attribute",
       "name", "abstract"
       });

    addXSDMapping
      (getProperty(typeType, TypeImpl.INTERNAL_ANY_ATTRIBUTE),
       new String[]
       {
       "kind", "attributeWildcard",
       "wildcards", "##any",
       "name", ":10",
       "processing", "lax"
       });

    addXSDMapping
      (typesType,
       new String[] 
       {
       "name", "Types",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(typesType, TypesImpl.INTERNAL_TYPE),
       new String[]
       {
       "kind", "element",
       "name", "type",
       "namespace", "##targetNamespace"
       });

    addXSDMapping
      (xsdTypeType,
       new String[] 
       {
       "name", "XSDType",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(xsdTypeType, XSDTypeImpl.INTERNAL_ANY),
       new String[]
       {
       "kind", "elementWildcard",
       "wildcards", "http://www.w3.org/2001/XMLSchema",
       "name", ":0",
       "processing", "lax"
       });

    addXSDMapping
      (boolean_Type,
       new String[] 
       {
       "name", "Boolean"
       });

    addXSDMapping
      (booleanObjectType,
       new String[] 
       {
       "name", "Boolean:Object",
       "baseType", "Boolean"
       });

    addXSDMapping
      (byte_Type,
       new String[] 
       {
       "name", "Byte"
       });

    addXSDMapping
      (byteObjectType,
       new String[] 
       {
       "name", "Byte:Object",
       "baseType", "Byte"
       });

    addXSDMapping
      (bytesType,
       new String[] 
       {
       "name", "Bytes"
       });

    addXSDMapping
      (changeSummaryTypeType,
       new String[] 
       {
       "name", "ChangeSummaryType"
       });

    addXSDMapping
      (characterType,
       new String[] 
       {
       "name", "Character"
       });

    addXSDMapping
      (characterObjectType,
       new String[] 
       {
       "name", "Character:Object",
       "baseType", "Character"
       });

    addXSDMapping
      (dateType,
       new String[] 
       {
       "name", "Date"
       });

    addXSDMapping
      (dateTimeType,
       new String[] 
       {
       "name", "DateTime"
       });

    addXSDMapping
      (dayType,
       new String[] 
       {
       "name", "Day"
       });

    addXSDMapping
      (decimalType,
       new String[] 
       {
       "name", "Decimal"
       });

    addXSDMapping
      (double_Type,
       new String[] 
       {
       "name", "Double"
       });

    addXSDMapping
      (doubleObjectType,
       new String[] 
       {
       "name", "Double:Object",
       "baseType", "Double"
       });

    addXSDMapping
      (durationType,
       new String[] 
       {
       "name", "Duration"
       });

    addXSDMapping
      (float_Type,
       new String[] 
       {
       "name", "Float"
       });

    addXSDMapping
      (floatObjectType,
       new String[] 
       {
       "name", "Float:Object",
       "baseType", "Float"
       });

    addXSDMapping
      (int_Type,
       new String[] 
       {
       "name", "Int"
       });

    addXSDMapping
      (integerType,
       new String[] 
       {
       "name", "Integer"
       });

    addXSDMapping
      (intObjectType,
       new String[] 
       {
       "name", "Int:Object",
       "baseType", "Int"
       });

    addXSDMapping
      (long_Type,
       new String[] 
       {
       "name", "Long"
       });

    addXSDMapping
      (longObjectType,
       new String[] 
       {
       "name", "Long:Object",
       "baseType", "Long"
       });

    addXSDMapping
      (monthType,
       new String[] 
       {
       "name", "Month"
       });

    addXSDMapping
      (monthDayType,
       new String[] 
       {
       "name", "MonthDay"
       });

    addXSDMapping
      (objectType,
       new String[] 
       {
       "name", "Object"
       });

    addXSDMapping
      (short_Type,
       new String[] 
       {
       "name", "Short"
       });

    addXSDMapping
      (shortObjectType,
       new String[] 
       {
       "name", "Short:Object",
       "baseType", "Short"
       });

    addXSDMapping
      (stringType,
       new String[] 
       {
       "name", "String"
       });

    addXSDMapping
      (stringsType,
       new String[] 
       {
       "name", "Strings"
       });

    addXSDMapping
      (timeType,
       new String[] 
       {
       "name", "Time"
       });

    addXSDMapping
      (uriType,
       new String[] 
       {
       "name", "URI"
       });

    addXSDMapping
      (yearType,
       new String[] 
       {
       "name", "Year"
       });

    addXSDMapping
      (yearMonthType,
       new String[] 
       {
       "name", "YearMonth"
       });

    addXSDMapping
      (yearMonthDayType,
       new String[] 
       {
       "name", "YearMonthDay"
       });

  }
    
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Boolean createBooleanFromString(String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createBooleanObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertBooleanToString(Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertBooleanObject((Boolean)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Boolean createBooleanObjectFromString(String initialValue)
  {
    return (Boolean)createBooleanFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertBooleanObjectToString(Object instanceValue)
  {
    return convertBooleanToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Byte createByteFromString(String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createByteObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertByteToString(Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertByteObject((Byte)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Byte createByteObjectFromString(String initialValue)
  {
    return (Byte)createByteFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertByteObjectToString(Object instanceValue)
  {
    return convertByteToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public byte[] createBytesFromString(String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createHexBinary(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertBytesToString(Object instanceValue)
  {
    if (instanceValue instanceof byte[]) {
      return XMLTypeFactory.eINSTANCE.convertHexBinary((byte[])instanceValue);
    } else {
      return XMLTypeFactory.eINSTANCE.convertHexBinary(instanceValue.toString().getBytes());
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public ChangeSummary createChangeSummaryTypeFromString(String initialValue)
  {
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertChangeSummaryTypeToString(Object instanceValue)
  {
    return "change summary serialization goes here ...";
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Character createCharacterFromString(String initialValue)
  {
    return (initialValue == null && initialValue.length() > 0) 
    ? null : (new Character(XMLTypeUtil.normalize(initialValue, true).charAt(0)));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertCharacterToString(Object instanceValue)
  {
    return String.valueOf(((Character)instanceValue).charValue());
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Character createCharacterObjectFromString(String initialValue)
  {
    return (Character)createCharacterFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertCharacterObjectToString(Object instanceValue)
  {
    return convertCharacterToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Date createDateFromString(String initialValue)
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
  public String convertDateToString(Object instanceValue)
  {
    if (instanceValue == null)
    {
      return null;
    }
    
    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSS'Z'");
    f.setTimeZone(TimeZone.getTimeZone("GMT"));
    
    return f.format((Date)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String createDateTimeFromString(String initialValue)
  {
      return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertDateTimeToString(Object instanceValue)
  {
      return (String)instanceValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String createDayFromString(String initialValue)
  {
      return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertDayToString(Object instanceValue)
  {
      return (String)instanceValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public BigDecimal createDecimalFromString(String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createDecimal(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertDecimalToString(Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertDecimal((BigDecimal)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Double createDoubleFromString(String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createDoubleObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertDoubleToString(Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertDoubleObject((Double)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Double createDoubleObjectFromString(String initialValue)
  {
    return (Double)createDoubleFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertDoubleObjectToString(Object instanceValue)
  {
    return convertDoubleToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String createDurationFromString(String initialValue)
  {
      return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertDurationToString(Object instanceValue)
  {
      return (String)instanceValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Float createFloatFromString(String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createFloatObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertFloatToString(Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertFloatObject((Float)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Float createFloatObjectFromString(String initialValue)
  {
    return (Float)createFloatFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertFloatObjectToString(Object instanceValue)
  {
    return convertFloatToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Integer createIntFromString(String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createIntObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertIntToString(Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertIntObject((Integer)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public BigInteger createIntegerFromString(String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createInteger(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertIntegerToString(Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertInteger((BigInteger)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Integer createIntObjectFromString(String initialValue)
  {
    return (Integer)createIntFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertIntObjectToString(Object instanceValue)
  {
    return convertIntToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Long createLongFromString(String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createLongObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertLongToString(Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertLongObject((Long)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Long createLongObjectFromString(String initialValue)
  {
    return (Long)createLongFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertLongObjectToString(Object instanceValue)
  {
    return convertLongToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String createMonthFromString(String initialValue)
  {
      return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertMonthToString(Object instanceValue)
  {
      return (String)instanceValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String createMonthDayFromString(String initialValue)
  {
      return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertMonthDayToString(Object instanceValue)
  {
      return (String)instanceValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Object createObjectFromString(String initialValue)
  {
    return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertObjectToString(Object instanceValue)
  {
    return (instanceValue != null) ? instanceValue.toString() : null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Short createShortFromString(String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createShortObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertShortToString(Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertShortObject((Short)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Short createShortObjectFromString(String initialValue)
  {
    return (Short)createShortFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertShortObjectToString(Object instanceValue)
  {
    return convertShortToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String createStringFromString(String initialValue)
  {
    return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertStringToString(Object instanceValue)
  {
    return (instanceValue != null) ? instanceValue.toString() : null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public List createStringsFromString(String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createENTITIES(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertStringsToString(Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertENTITIES((List)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String createTimeFromString(String initialValue)
  {
      return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertTimeToString(Object instanceValue)
  {
      return (String)instanceValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String createURIFromString(String initialValue)
  {
    return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertURIToString(Object instanceValue)
  {
    return (instanceValue != null) ? instanceValue.toString() : null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String createYearFromString(String initialValue)
  {
      return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertYearToString(Object instanceValue)
  {
      return (String)instanceValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String createYearMonthFromString(String initialValue)
  {
      return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertYearMonthToString(Object instanceValue)
  {
      return (String)instanceValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String createYearMonthDayFromString(String initialValue)
  {
      return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertYearMonthDayToString(Object instanceValue)
  {
      return (String)instanceValue;
  }



} //ModelFactoryImpl
