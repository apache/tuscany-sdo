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
package org.apache.tuscany.sdo.model.java.impl;

import commonj.sdo.helper.HelperContext;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.FactoryBase;

import org.apache.tuscany.sdo.model.ModelFactory;

import org.apache.tuscany.sdo.model.impl.ModelFactoryImpl;

import org.apache.tuscany.sdo.model.java.*;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the commonj.sdo/java model factory.
 * This model is generated from sdoJava.xsd, in the sdo-api project.
 * Until the SDO code generator supports name conflicts and regen/merge, follow the following steps to regenerate this model:
 *   1. Regenerate the model into a temporary directory:
 *         XSD2JavaGenerator -generateBuiltIn commonj.sdo/java -targetDirectory <temp-dir> -javaPackage org.apache.tuscany.sdo.model.java <sdo-api-dir>/src/main/resources/xml/sdoJava.xsd
 *   2. Delete all the createXXXFromString() and convertXXXToString() methods in the newly generated JavaFactoryImpl and
 *      replace them with the ones from this file.
 *   3. Make sure the top of each generated file contains the ASF License.      
 *   4. Move this JavaDoc comment into the newly generated JavaFactoryImpl class.
 * <!-- end-user-doc -->
 * @generated
 */

public class JavaFactoryImpl extends FactoryBase implements JavaFactory
{

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_URI = "commonj.sdo/java";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_PREFIX = "sdoJava";

  /**
   * The version of the generator pattern used to generate this class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String PATTERN_VERSION = "1.2";
  
  public static final int JAVA_INFO = 1;	
  public static final int BOOLEAN_OBJECT = 2;	
  public static final int BYTE_OBJECT = 3;	
  public static final int CHARACTER_OBJECT = 4;	
  public static final int DOUBLE_OBJECT = 5;	
  public static final int FLOAT_OBJECT = 6;	
  public static final int INT_OBJECT = 7;	
  public static final int LONG_OBJECT = 8;	
  public static final int SHORT_OBJECT = 9;
  
  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaFactoryImpl()
  {
    super(NAMESPACE_URI, NAMESPACE_PREFIX, "org.apache.tuscany.sdo.model.java");
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
    ModelFactory.INSTANCE.register(scope);
    
    // Initialize this package   
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
      case JAVA_INFO: return (DataObject)createJavaInfo();
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
      case BOOLEAN_OBJECT:
        return createBooleanObjectFromString(initialValue);
      case BYTE_OBJECT:
        return createByteObjectFromString(initialValue);
      case CHARACTER_OBJECT:
        return createCharacterObjectFromString(initialValue);
      case DOUBLE_OBJECT:
        return createDoubleObjectFromString(initialValue);
      case FLOAT_OBJECT:
        return createFloatObjectFromString(initialValue);
      case INT_OBJECT:
        return createIntObjectFromString(initialValue);
      case LONG_OBJECT:
        return createLongObjectFromString(initialValue);
      case SHORT_OBJECT:
        return createShortObjectFromString(initialValue);
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
      case BOOLEAN_OBJECT:
        return convertBooleanObjectToString(instanceValue);
      case BYTE_OBJECT:
        return convertByteObjectToString(instanceValue);
      case CHARACTER_OBJECT:
        return convertCharacterObjectToString(instanceValue);
      case DOUBLE_OBJECT:
        return convertDoubleObjectToString(instanceValue);
      case FLOAT_OBJECT:
        return convertFloatObjectToString(instanceValue);
      case INT_OBJECT:
        return convertIntObjectToString(instanceValue);
      case LONG_OBJECT:
        return convertLongObjectToString(instanceValue);
      case SHORT_OBJECT:
        return convertShortObjectToString(instanceValue);
      default:
        throw new IllegalArgumentException("The type number '" + typeNumber + "' is not a valid datatype");
    }
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
  
  // Following creates and initializes SDO metadata for the supported types.			
  protected Type javaInfoType = null;

  public Type getJavaInfo()
  {
    return javaInfoType;
  }
    
  protected Type booleanObjectType = null;

  public Type getBooleanObject()
  {
    return booleanObjectType;
  }
    
  protected Type byteObjectType = null;

  public Type getByteObject()
  {
    return byteObjectType;
  }
    
  protected Type characterObjectType = null;

  public Type getCharacterObject()
  {
    return characterObjectType;
  }
    
  protected Type doubleObjectType = null;

  public Type getDoubleObject()
  {
    return doubleObjectType;
  }
    
  protected Type floatObjectType = null;

  public Type getFloatObject()
  {
    return floatObjectType;
  }
    
  protected Type intObjectType = null;

  public Type getIntObject()
  {
    return intObjectType;
  }
    
  protected Type longObjectType = null;

  public Type getLongObject()
  {
    return longObjectType;
  }
    
  protected Type shortObjectType = null;

  public Type getShortObject()
  {
    return shortObjectType;
  }
  

  private static JavaFactoryImpl instance = null; 
  public static JavaFactoryImpl init()
  {
    if (instance != null ) return instance;
    instance = new JavaFactoryImpl();

    // Initialize dependent packages
    ModelFactory ModelFactoryInstance = ModelFactory.INSTANCE;
    
    // Create package meta-data objects
    instance.createMetaData();

    // Initialize created meta-data
    instance.initializeMetaData();
    
    // Mark meta-data to indicate it can't be changed
    //theJavaFactoryImpl.freeze(); //FB do we need to freeze / should we freeze ????

    return instance;
  }
  
  private boolean isCreated = false;

  public void createMetaData()
  {
    if (isCreated) return;
    isCreated = true;	

    // Create types and their properties
    javaInfoType = createType(false, JAVA_INFO);
    createProperty(true, javaInfoType,JavaInfoImpl.INTERNAL_JAVA_CLASS); 

    // Create data types
    booleanObjectType = createType(true, BOOLEAN_OBJECT );
    byteObjectType = createType(true, BYTE_OBJECT );
    characterObjectType = createType(true, CHARACTER_OBJECT );
    doubleObjectType = createType(true, DOUBLE_OBJECT );
    floatObjectType = createType(true, FLOAT_OBJECT );
    intObjectType = createType(true, INT_OBJECT );
    longObjectType = createType(true, LONG_OBJECT );
    shortObjectType = createType(true, SHORT_OBJECT );
  }
  
  private boolean isInitialized = false;

  public void initializeMetaData()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Obtain other dependent packages
    ModelFactoryImpl theModelPackageImpl = (ModelFactoryImpl)ModelFactory.INSTANCE;
    Property property = null;

    // Add supertypes to types

    // Initialize types and properties
    initializeType(javaInfoType, JavaInfo.class, "JavaInfo", false);
    property = getLocalProperty(javaInfoType, 0);
    initializeProperty(property, theModelPackageImpl.getString(), "javaClass", null, 0, 1, JavaInfo.class, false, true, false);

    // Initialize data types
    initializeType(booleanObjectType, Boolean.class, "BooleanObject", true, false);
    setInstanceProperty (booleanObjectType, "commonj.sdo/java", "instanceClass", "java.lang.Boolean");

    initializeType(byteObjectType, Byte.class, "ByteObject", true, false);
    setInstanceProperty (byteObjectType, "commonj.sdo/java", "instanceClass", "java.lang.Byte");

    initializeType(characterObjectType, Character.class, "CharacterObject", true, false);
    setInstanceProperty (characterObjectType, "commonj.sdo/java", "instanceClass", "java.lang.Character");

    initializeType(doubleObjectType, Double.class, "DoubleObject", true, false);
    setInstanceProperty (doubleObjectType, "commonj.sdo/java", "instanceClass", "java.lang.Double");

    initializeType(floatObjectType, Float.class, "FloatObject", true, false);
    setInstanceProperty (floatObjectType, "commonj.sdo/java", "instanceClass", "java.lang.Float");

    initializeType(intObjectType, Integer.class, "IntObject", true, false);
    setInstanceProperty (intObjectType, "commonj.sdo/java", "instanceClass", "java.lang.Integer");

    initializeType(longObjectType, Long.class, "LongObject", true, false);
    setInstanceProperty (longObjectType, "commonj.sdo/java", "instanceClass", "java.lang.Long");

    initializeType(shortObjectType, Short.class, "ShortObject", true, false);
    setInstanceProperty (shortObjectType, "commonj.sdo/java", "instanceClass", "java.lang.Short");

    createXSDMetaData(theModelPackageImpl);
  }
    
  protected void createXSDMetaData(ModelFactoryImpl theModelPackageImpl)
  {
    super.initXSD();
    
    Property property = null;
    

    property = createGlobalProperty
      ("extendedInstanceClass",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "attribute",
       "name", "extendedInstanceClass",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                  
    property = createGlobalProperty
      ("instanceClass",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "attribute",
       "name", "instanceClass",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                  
    property = createGlobalProperty
      ("javaClass",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "attribute",
       "name", "javaClass",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                  
    property = createGlobalProperty
      ("nestedInterfaces",
      theModelPackageImpl.getBoolean(),
       new String[]
       {
       "kind", "attribute",
       "name", "nestedInterfaces",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                  
    property = createGlobalProperty
      ("package",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "attribute",
       "name", "package",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);
                  
    addXSDMapping
      (javaInfoType,
       new String[] 
       {
       "name", "JavaInfo",
       "kind", "empty"
       });

    addXSDMapping
      (getProperty(javaInfoType, JavaInfoImpl.INTERNAL_JAVA_CLASS),
       new String[]
       {
       "kind", "attribute",
       "name", "javaClass"
       });

    addXSDMapping
      (booleanObjectType,
       new String[] 
       {
       "name", "BooleanObject"
       });

    addXSDMapping
      (byteObjectType,
       new String[] 
       {
       "name", "ByteObject"
       });

    addXSDMapping
      (characterObjectType,
       new String[] 
       {
       "name", "CharacterObject"
       });

    addXSDMapping
      (doubleObjectType,
       new String[] 
       {
       "name", "DoubleObject"
       });

    addXSDMapping
      (floatObjectType,
       new String[] 
       {
       "name", "FloatObject"
       });

    addXSDMapping
      (intObjectType,
       new String[] 
       {
       "name", "IntObject"
       });

    addXSDMapping
      (longObjectType,
       new String[] 
       {
       "name", "LongObject"
       });

    addXSDMapping
      (shortObjectType,
       new String[] 
       {
       "name", "ShortObject"
       });

  }
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Boolean createBooleanObjectFromString(String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createBooleanObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertBooleanObjectToString(Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertBooleanObject((Boolean)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Byte createByteObjectFromString(String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createByteObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertByteObjectToString(Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertByteObject((Byte)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Character createCharacterObjectFromString(String initialValue)
  {
    return (initialValue == null && initialValue.length() > 0) 
      ? null : (new Character(XMLTypeUtil.normalize(initialValue, true).charAt(0)));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertCharacterObjectToString(Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Double createDoubleObjectFromString(String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createDoubleObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertDoubleObjectToString(Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertDoubleObject((Double)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Float createFloatObjectFromString(String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createFloatObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertFloatObjectToString(Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertFloatObject((Float)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Integer createIntObjectFromString(String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createIntObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertIntObjectToString(Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertIntObject((Integer)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Long createLongObjectFromString(String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createLongObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertLongObjectToString(Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertLongObject((Long)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Short createShortObjectFromString(String initialValue)
  {
    return XMLTypeFactory.eINSTANCE.createShortObject(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertShortObjectToString(Object instanceValue)
  {
    return XMLTypeFactory.eINSTANCE.convertShortObject((Short)instanceValue);
  }

} //JavaFactoryImpl
