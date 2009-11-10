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
package org.apache.tuscany.sdo.model.internal.impl;

import commonj.sdo.helper.HelperContext;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.FactoryBase;

import org.apache.tuscany.sdo.model.internal.*;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the commonj.sdo.internal model factory.
 * This model is generated from sdoInternal.xsd, in the tuscany-sdo-impl project.
 * Until the SDO code generator supports regen/merge, follow the following steps to regenerate this model:
 *   1. Regenerate the model into a temporary directory:
 *         XSD2JavaGenerator -generateBuiltIn http://www.apache.org/tuscany/commonj.sdo.internal -targetDirectory <temp-dir> -javaPackage org.apache.tuscany.sdo.model.internal <tuscany-sdo-impl-dir>/src/main/resources/xml/sdoInternal.xsd
 *   2. Delete all the createXXXFromString() and convertXXXToString() methods in the newly generated InternalFactoryImpl and
 *      replace them with the ones from this file (resolve any missing imports).
 *   3. Comment out all simple depedencies (SDOUtil.registerStaticTypes calls) in the init() method.
 *   4. Make sure the top of each generated file contains the ASF License.      
 *   5. Move this JavaDoc comment into the newly generated ModelFactoryImpl class.
 * <!-- end-user-doc -->
 * @generated
 */
public class InternalFactoryImpl extends FactoryBase implements InternalFactory
{

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_URI = "http://www.apache.org/tuscany/commonj.sdo.internal";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_PREFIX = "internal";

  /**
   * The version of the generator pattern used to generate this class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String PATTERN_VERSION = "1.2";
  
  public static final int BASE64_BYTES = 1;	
  public static final int QNAME = 2;
  
  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InternalFactoryImpl()
  {
    super(NAMESPACE_URI, NAMESPACE_PREFIX, "org.apache.tuscany.sdo.model.internal");
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
   * @generated
   */
  public DataObject create(int typeNumber)
  {
    switch (typeNumber)
    {
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
      case BASE64_BYTES:
        return createBase64BytesFromString(initialValue);
      case QNAME:
        return createQNameFromString(initialValue);
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
      case BASE64_BYTES:
        return convertBase64BytesToString(instanceValue);
      case QNAME:
        return convertQNameToString(instanceValue);
      default:
        throw new IllegalArgumentException("The type number '" + typeNumber + "' is not a valid datatype");
    }
  }
  
  // Following creates and initializes SDO metadata for the supported types.		
  protected Type base64BytesType = null;

  public Type getBase64Bytes()
  {
    return base64BytesType;
  }
    
  protected Type qNameType = null;

  public Type getQName()
  {
    return qNameType;
  }
  

  private static InternalFactoryImpl instance = null; 
  public static InternalFactoryImpl init()
  {
    if (instance != null ) return instance;
    instance = new InternalFactoryImpl();

    // Initialize dependent packages
    
    // Create package meta-data objects
    instance.createMetaData();

    // Initialize created meta-data
    instance.initializeMetaData();
    
    // Mark meta-data to indicate it can't be changed
    //theInternalFactoryImpl.freeze(); //FB do we need to freeze / should we freeze ????

    return instance;
  }
  
  private boolean isCreated = false;

  public void createMetaData()
  {
    if (isCreated) return;
    isCreated = true;

    // Create data types
    base64BytesType = createType(true, BASE64_BYTES );
    qNameType = createType(true, QNAME );
  }
  
  private boolean isInitialized = false;

  public void initializeMetaData()
  {
    if (isInitialized) return;
    isInitialized = true;
    Property property = null;

    // Add supertypes to types

    // Initialize types and properties
    // Initialize data types
    initializeType(base64BytesType, byte[].class, "Base64Bytes", true, false);
    setInstanceProperty (base64BytesType, "commonj.sdo/java", "instanceClass", "byte[]");

    initializeType(qNameType, String.class, "QName", true, false);
    setInstanceProperty (qNameType, "commonj.sdo/java", "instanceClass", "java.lang.String");

    createXSDMetaData();
  }
    
  protected void createXSDMetaData()
  {
    super.initXSD();
    
    Property property = null;
    

    addXSDMapping
      (base64BytesType,
       new String[] 
       {
       "name", "Base64Bytes"
       });

    addXSDMapping
      (qNameType,
       new String[] 
       {
       "name", "QName"
       });

  }
    
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public byte[] createBase64BytesFromString(String initialValue)
  {
      return XMLTypeFactory.eINSTANCE.createBase64Binary(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String convertBase64BytesToString(Object instanceValue)
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
   * @generated
   */
  public String createQNameFromString(String initialValue)
  {
    return (String)super.createFromString(QNAME, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertQNameToString(Object instanceValue)
  {
    return super.convertToString(QNAME, instanceValue);
  }

} //InternalFactoryImpl
