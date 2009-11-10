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
package com.example.ExpectedException.impl;

import commonj.sdo.helper.HelperContext;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;

import com.example.ExpectedException.*;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

import org.apache.tuscany.sdo.SDOFactory;

import org.apache.tuscany.sdo.impl.FactoryBase;

import org.apache.tuscany.sdo.model.ModelFactory;

import org.apache.tuscany.sdo.model.impl.ModelFactoryImpl;

import org.apache.tuscany.sdo.model.internal.InternalFactory;

import org.apache.tuscany.sdo.util.SDOUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * Generator information:
 * patternVersion=1.2; -prefix ExpectedException
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpectedExceptionFactoryImpl extends FactoryBase implements ExpectedExceptionFactory
{

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_URI = "http://example.com/ExpectedException";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_PREFIX = "expect";

  /**
   * The version of the generator pattern used to generate this class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String PATTERN_VERSION = "1.2";
  
  public static final int EXPECTED_EXCEPTION_TYPE = 1;	
  public static final int SEQUENCE_READ_ONLY_TYPE = 2;	
  public static final int CHAR = 3;
  
  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpectedExceptionFactoryImpl()
  {
    super(NAMESPACE_URI, NAMESPACE_PREFIX, "com.sdo.test.ExpectedException");
  }

  /**
   * Registers the Factory instance so that it is available within the supplied scope.
   * @argument scope a HelperContext instance that will make the types supported by this Factory available.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */	
  public void register(HelperContext scope) {
    if(scope == null) {
       throw new IllegalArgumentException("Scope can not be null");
    } 
    TypeHelperImpl th = (TypeHelperImpl)scope.getTypeHelper();
    th.getExtendedMetaData().putPackage(NAMESPACE_URI, this);
  }
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataObject create(int typeNumber)
  {
    switch (typeNumber)
    {
      case EXPECTED_EXCEPTION_TYPE: return (DataObject)createExpectedExceptionType();
      case SEQUENCE_READ_ONLY_TYPE: return (DataObject)createSequenceReadOnlyType();
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
      case CHAR:
        return createcharFromString(initialValue);
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
      case CHAR:
        return convertcharToString(instanceValue);
      default:
        throw new IllegalArgumentException("The type number '" + typeNumber + "' is not a valid datatype");
    }
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpectedExceptionType createExpectedExceptionType()
  {
    ExpectedExceptionTypeImpl expectedExceptionType = new ExpectedExceptionTypeImpl();
    return expectedExceptionType;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceReadOnlyType createSequenceReadOnlyType()
  {
    SequenceReadOnlyTypeImpl sequenceReadOnlyType = new SequenceReadOnlyTypeImpl();
    return sequenceReadOnlyType;
  }
  
  // Following creates and initializes SDO metadata for the supported types.			
  protected Type expectedExceptionTypeType = null;

  public Type getExpectedExceptionType()
  {
    return expectedExceptionTypeType;
  }
    
  protected Type sequenceReadOnlyTypeType = null;

  public Type getSequenceReadOnlyType()
  {
    return sequenceReadOnlyTypeType;
  }
    
  protected Type char_Type = null;

  public Type getchar()
  {
    return char_Type;
  }
  

  private static boolean isInited = false;

  public static ExpectedExceptionFactoryImpl init()
  {
    if (isInited) return (ExpectedExceptionFactoryImpl)FactoryBase.getStaticFactory(ExpectedExceptionFactoryImpl.NAMESPACE_URI);
    ExpectedExceptionFactoryImpl theExpectedExceptionFactoryImpl = new ExpectedExceptionFactoryImpl();
    isInited = true;

    // Initialize dependencies
    SDOUtil.registerStaticTypes(SDOFactory.class);
    SDOUtil.registerStaticTypes(ModelFactory.class);
    SDOUtil.registerStaticTypes(InternalFactory.class);

    // Create package meta-data objects
    theExpectedExceptionFactoryImpl.createMetaData();

    // Initialize created meta-data
    theExpectedExceptionFactoryImpl.initializeMetaData();

    // Mark meta-data to indicate it can't be changed
    //theExpectedExceptionFactoryImpl.freeze(); //FB do we need to freeze / should we freeze ????

    return theExpectedExceptionFactoryImpl;
  }
  
  private boolean isCreated = false;

  public void createMetaData()
  {
    if (isCreated) return;
    isCreated = true;	

    // Create types and their properties
          expectedExceptionTypeType = createType(false, EXPECTED_EXCEPTION_TYPE);
    createProperty(true, expectedExceptionTypeType,ExpectedExceptionTypeImpl.INTERNAL_STRING_VAL); 
    createProperty(true, expectedExceptionTypeType,ExpectedExceptionTypeImpl.INTERNAL_BOOLEAN_VAL); 
    createProperty(true, expectedExceptionTypeType,ExpectedExceptionTypeImpl.INTERNAL_BYTE_VAL); 
    createProperty(true, expectedExceptionTypeType,ExpectedExceptionTypeImpl.INTERNAL_DECIMAL_VAL); 
    createProperty(true, expectedExceptionTypeType,ExpectedExceptionTypeImpl.INTERNAL_INT_VAL); 
    createProperty(true, expectedExceptionTypeType,ExpectedExceptionTypeImpl.INTERNAL_FLOAT_VAL); 
    createProperty(true, expectedExceptionTypeType,ExpectedExceptionTypeImpl.INTERNAL_DOUBLE_VAL); 
    createProperty(true, expectedExceptionTypeType,ExpectedExceptionTypeImpl.INTERNAL_DATE_VAL); 
    createProperty(true, expectedExceptionTypeType,ExpectedExceptionTypeImpl.INTERNAL_SHORT_VAL); 
    createProperty(true, expectedExceptionTypeType,ExpectedExceptionTypeImpl.INTERNAL_LONG_VAL); 
    createProperty(true, expectedExceptionTypeType,ExpectedExceptionTypeImpl.INTERNAL_LIST_VAL); 
    createProperty(true, expectedExceptionTypeType,ExpectedExceptionTypeImpl.INTERNAL_BYTES_VAL); 
    createProperty(true, expectedExceptionTypeType,ExpectedExceptionTypeImpl.INTERNAL_INTEGER_VAL); 
    createProperty(true, expectedExceptionTypeType,ExpectedExceptionTypeImpl.INTERNAL_CHAR_VAL); 
    createProperty(true, expectedExceptionTypeType,ExpectedExceptionTypeImpl.INTERNAL_READ_ONLY_VAL); 
    createProperty(true, expectedExceptionTypeType,ExpectedExceptionTypeImpl.INTERNAL_READ_ONLY_LIST_VAL); 
          sequenceReadOnlyTypeType = createType(false, SEQUENCE_READ_ONLY_TYPE);
    createProperty(true, sequenceReadOnlyTypeType,SequenceReadOnlyTypeImpl.INTERNAL_MIXED); 
    createProperty(true, sequenceReadOnlyTypeType,SequenceReadOnlyTypeImpl.INTERNAL_READ_ONLY_VAL); 
    createProperty(true, sequenceReadOnlyTypeType,SequenceReadOnlyTypeImpl.INTERNAL_READ_ONLY_LIST_VAL); 
    createProperty(true, sequenceReadOnlyTypeType,SequenceReadOnlyTypeImpl.INTERNAL_UNIQUE_NAME); 

    // Create data types
    char_Type = createType(true, CHAR );
  }
  
  private boolean isInitialized = false;

  public void initializeMetaData()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Obtain other dependent packages
    ModelFactoryImpl theModelPackageImpl = (ModelFactoryImpl)FactoryBase.getStaticFactory(ModelFactoryImpl.NAMESPACE_URI);
    Property property = null;

    // Add supertypes to types

    // Initialize types and properties
    initializeType(expectedExceptionTypeType, ExpectedExceptionType.class, "ExpectedExceptionType", false);
    property = getLocalProperty(expectedExceptionTypeType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "stringVal", null, 1, 1, ExpectedExceptionType.class, false, true, false);

    property = getLocalProperty(expectedExceptionTypeType, 1);
    initializeProperty(property, theModelPackageImpl.getBoolean(), "booleanVal", null, 1, 1, ExpectedExceptionType.class, false, true, false);

    property = getLocalProperty(expectedExceptionTypeType, 2);
    initializeProperty(property, theModelPackageImpl.getByte(), "byteVal", null, 1, 1, ExpectedExceptionType.class, false, true, false);

    property = getLocalProperty(expectedExceptionTypeType, 3);
    initializeProperty(property, theModelPackageImpl.getDecimal(), "decimalVal", null, 1, 1, ExpectedExceptionType.class, false, true, false);

    property = getLocalProperty(expectedExceptionTypeType, 4);
    initializeProperty(property, theModelPackageImpl.getInt(), "intVal", null, 1, 1, ExpectedExceptionType.class, false, true, false);

    property = getLocalProperty(expectedExceptionTypeType, 5);
    initializeProperty(property, theModelPackageImpl.getFloat(), "floatVal", null, 1, 1, ExpectedExceptionType.class, false, true, false);

    property = getLocalProperty(expectedExceptionTypeType, 6);
    initializeProperty(property, theModelPackageImpl.getDouble(), "doubleVal", null, 1, 1, ExpectedExceptionType.class, false, true, false);

    property = getLocalProperty(expectedExceptionTypeType, 7);
    initializeProperty(property, theModelPackageImpl.getDateTime(), "dateVal", null, 1, 1, ExpectedExceptionType.class, false, true, false);

    property = getLocalProperty(expectedExceptionTypeType, 8);
    initializeProperty(property, theModelPackageImpl.getShort(), "shortVal", null, 1, 1, ExpectedExceptionType.class, false, true, false);

    property = getLocalProperty(expectedExceptionTypeType, 9);
    initializeProperty(property, theModelPackageImpl.getLong(), "longVal", null, 1, 1, ExpectedExceptionType.class, false, true, false);

    property = getLocalProperty(expectedExceptionTypeType, 10);
    initializeProperty(property, theModelPackageImpl.getString(), "listVal", null, 0, -1, ExpectedExceptionType.class, false, false, false);

    property = getLocalProperty(expectedExceptionTypeType, 11);
    initializeProperty(property, theModelPackageImpl.getBytes(), "bytesVal", null, 1, 1, ExpectedExceptionType.class, false, true, false);

    property = getLocalProperty(expectedExceptionTypeType, 12);
    initializeProperty(property, theModelPackageImpl.getInteger(), "integerVal", null, 1, 1, ExpectedExceptionType.class, false, true, false);

    property = getLocalProperty(expectedExceptionTypeType, 13);
    initializeProperty(property, this.getchar(), "charVal", null, 1, 1, ExpectedExceptionType.class, false, true, false);

    property = getLocalProperty(expectedExceptionTypeType, 14);
    initializeProperty(property, theModelPackageImpl.getString(), "readOnlyVal", null, 1, 1, ExpectedExceptionType.class, true, true, false);
    setInstanceProperty (property, "commonj.sdo/xml", "readOnly", "true");

    property = getLocalProperty(expectedExceptionTypeType, 15);
    initializeProperty(property, theModelPackageImpl.getString(), "readOnlyListVal", null, 1, 1, ExpectedExceptionType.class, true, true, false);
    setInstanceProperty (property, "commonj.sdo/xml", "readOnly", "true");

    initializeType(sequenceReadOnlyTypeType, SequenceReadOnlyType.class, "SequenceReadOnlyType", false);
    property = getLocalProperty(sequenceReadOnlyTypeType, 0);
    initializeProperty(property, getSequence(), "mixed", null, 0, -1, SequenceReadOnlyType.class, false, false, false);

    property = getLocalProperty(sequenceReadOnlyTypeType, 1);
    initializeProperty(property, theModelPackageImpl.getString(), "readOnlyVal", null, 1, 1, SequenceReadOnlyType.class, true, true, true);
    setInstanceProperty (property, "commonj.sdo/xml", "readOnly", "true");

    property = getLocalProperty(sequenceReadOnlyTypeType, 2);
    initializeProperty(property, theModelPackageImpl.getString(), "readOnlyListVal", null, 1, 1, SequenceReadOnlyType.class, true, true, true);
    setInstanceProperty (property, "commonj.sdo/xml", "readOnly", "true");

    property = getLocalProperty(sequenceReadOnlyTypeType, 3);
    initializeProperty(property, theModelPackageImpl.getString(), "uniqueName", null, 1, 1, SequenceReadOnlyType.class, false, true, true);

    // Initialize data types
    initializeType(char_Type, String.class, "char", true, false);

    createXSDMetaData(theModelPackageImpl);
  }
    
  protected void createXSDMetaData(ModelFactoryImpl theModelPackageImpl)
  {
    super.initXSD();
    
    Property property = null;
    

    property = createGlobalProperty
      ("expectedExceptionsElem",
      this.getExpectedExceptionType(),
       new String[]
       {
       "kind", "element",
       "name", "expectedExceptionsElem",
       "namespace", "##targetNamespace"
       });
                  
    property = createGlobalProperty
      ("sequencedReadOnlyElem",
      this.getSequenceReadOnlyType(),
       new String[]
       {
       "kind", "element",
       "name", "sequencedReadOnlyElem",
       "namespace", "##targetNamespace"
       });
                  
    addXSDMapping
      (expectedExceptionTypeType,
       new String[] 
       {
       "name", "ExpectedExceptionType",
       "kind", "elementOnly"
       });

    addXSDMapping
      (getProperty(expectedExceptionTypeType, ExpectedExceptionTypeImpl.INTERNAL_STRING_VAL),
       new String[]
       {
       "kind", "element",
       "name", "stringVal"
       });

    addXSDMapping
      (getProperty(expectedExceptionTypeType, ExpectedExceptionTypeImpl.INTERNAL_BOOLEAN_VAL),
       new String[]
       {
       "kind", "element",
       "name", "booleanVal"
       });

    addXSDMapping
      (getProperty(expectedExceptionTypeType, ExpectedExceptionTypeImpl.INTERNAL_BYTE_VAL),
       new String[]
       {
       "kind", "element",
       "name", "byteVal"
       });

    addXSDMapping
      (getProperty(expectedExceptionTypeType, ExpectedExceptionTypeImpl.INTERNAL_DECIMAL_VAL),
       new String[]
       {
       "kind", "element",
       "name", "decimalVal"
       });

    addXSDMapping
      (getProperty(expectedExceptionTypeType, ExpectedExceptionTypeImpl.INTERNAL_INT_VAL),
       new String[]
       {
       "kind", "element",
       "name", "intVal"
       });

    addXSDMapping
      (getProperty(expectedExceptionTypeType, ExpectedExceptionTypeImpl.INTERNAL_FLOAT_VAL),
       new String[]
       {
       "kind", "element",
       "name", "floatVal"
       });

    addXSDMapping
      (getProperty(expectedExceptionTypeType, ExpectedExceptionTypeImpl.INTERNAL_DOUBLE_VAL),
       new String[]
       {
       "kind", "element",
       "name", "doubleVal"
       });

    addXSDMapping
      (getProperty(expectedExceptionTypeType, ExpectedExceptionTypeImpl.INTERNAL_DATE_VAL),
       new String[]
       {
       "kind", "element",
       "name", "dateVal"
       });

    addXSDMapping
      (getProperty(expectedExceptionTypeType, ExpectedExceptionTypeImpl.INTERNAL_SHORT_VAL),
       new String[]
       {
       "kind", "element",
       "name", "shortVal"
       });

    addXSDMapping
      (getProperty(expectedExceptionTypeType, ExpectedExceptionTypeImpl.INTERNAL_LONG_VAL),
       new String[]
       {
       "kind", "element",
       "name", "longVal"
       });

    addXSDMapping
      (getProperty(expectedExceptionTypeType, ExpectedExceptionTypeImpl.INTERNAL_LIST_VAL),
       new String[]
       {
       "kind", "element",
       "name", "listVal"
       });

    addXSDMapping
      (getProperty(expectedExceptionTypeType, ExpectedExceptionTypeImpl.INTERNAL_BYTES_VAL),
       new String[]
       {
       "kind", "element",
       "name", "bytesVal"
       });

    addXSDMapping
      (getProperty(expectedExceptionTypeType, ExpectedExceptionTypeImpl.INTERNAL_INTEGER_VAL),
       new String[]
       {
       "kind", "element",
       "name", "integerVal"
       });

    addXSDMapping
      (getProperty(expectedExceptionTypeType, ExpectedExceptionTypeImpl.INTERNAL_CHAR_VAL),
       new String[]
       {
       "kind", "element",
       "name", "charVal"
       });

    addXSDMapping
      (getProperty(expectedExceptionTypeType, ExpectedExceptionTypeImpl.INTERNAL_READ_ONLY_VAL),
       new String[]
       {
       "kind", "element",
       "name", "readOnlyVal"
       });

    addXSDMapping
      (getProperty(expectedExceptionTypeType, ExpectedExceptionTypeImpl.INTERNAL_READ_ONLY_LIST_VAL),
       new String[]
       {
       "kind", "element",
       "name", "readOnlyListVal"
       });

    addXSDMapping
      (sequenceReadOnlyTypeType,
       new String[] 
       {
       "name", "SequenceReadOnlyType",
       "kind", "mixed"
       });

    addXSDMapping
      (getProperty(sequenceReadOnlyTypeType, SequenceReadOnlyTypeImpl.INTERNAL_MIXED),
       new String[]
       {
       "kind", "elementWildcard",
       "name", ":mixed"
       });

    addXSDMapping
      (getProperty(sequenceReadOnlyTypeType, SequenceReadOnlyTypeImpl.INTERNAL_READ_ONLY_VAL),
       new String[]
       {
       "kind", "element",
       "name", "readOnlyVal"
       });

    addXSDMapping
      (getProperty(sequenceReadOnlyTypeType, SequenceReadOnlyTypeImpl.INTERNAL_READ_ONLY_LIST_VAL),
       new String[]
       {
       "kind", "element",
       "name", "readOnlyListVal"
       });

    addXSDMapping
      (getProperty(sequenceReadOnlyTypeType, SequenceReadOnlyTypeImpl.INTERNAL_UNIQUE_NAME),
       new String[]
       {
       "kind", "element",
       "name", "uniqueName"
       });

    addXSDMapping
      (char_Type,
       new String[] 
       {
       "name", "char",
       "baseType", "commonj.sdo#String",
       "length", "1"
       });

  }
    
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createcharFromString(String initialValue)
  {
    return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertcharToString(Object instanceValue)
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
  }

} //ExpectedExceptionFactoryImpl
