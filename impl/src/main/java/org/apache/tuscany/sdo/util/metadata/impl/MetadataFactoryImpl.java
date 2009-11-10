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
package org.apache.tuscany.sdo.util.metadata.impl;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

import org.apache.tuscany.sdo.SDOFactory;

import org.apache.tuscany.sdo.impl.FactoryBase;

import org.apache.tuscany.sdo.model.ModelFactory;

import org.apache.tuscany.sdo.model.impl.ModelFactoryImpl;

import org.apache.tuscany.sdo.util.SDOUtil;

import org.apache.tuscany.sdo.util.metadata.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetadataFactoryImpl extends FactoryBase implements MetadataFactory
{

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_URI = "org.apache.tuscany.sdo/metadata";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_PREFIX = "metadata";	
  public static final int JAVA_META_DATA = 1;	
  public static final int SDO_META_DATA_GROUP = 2;	
  public static final int TYPE_META_DATA = 3;	
  public static final int XSD_META_DATA = 4;
  
  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MetadataFactoryImpl()
  {
    super(NAMESPACE_URI, NAMESPACE_PREFIX);
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
      case JAVA_META_DATA: return (DataObject)createJavaMetaData();
      case SDO_META_DATA_GROUP: return (DataObject)createSDOMetaDataGroup();
      case TYPE_META_DATA: return (DataObject)createTypeMetaData();
      case XSD_META_DATA: return (DataObject)createXSDMetaData();
      default:
        return super.create(typeNumber);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaMetaData createJavaMetaData()
  {
    JavaMetaDataImpl javaMetaData = new JavaMetaDataImpl();
    return javaMetaData;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SDOMetaDataGroup createSDOMetaDataGroup()
  {
    SDOMetaDataGroupImpl sdoMetaDataGroup = new SDOMetaDataGroupImpl();
    return sdoMetaDataGroup;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeMetaData createTypeMetaData()
  {
    TypeMetaDataImpl typeMetaData = new TypeMetaDataImpl();
    return typeMetaData;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XSDMetaData createXSDMetaData()
  {
    XSDMetaDataImpl xsdMetaData = new XSDMetaDataImpl();
    return xsdMetaData;
  }
  
  // Following creates and initializes SDO metadata for the supported types.			
  protected Type javaMetaDataType = null;

  public Type getJavaMetaData()
  {
    return javaMetaDataType;
  }
    
  protected Type sdoMetaDataGroupType = null;

  public Type getSDOMetaDataGroup()
  {
    return sdoMetaDataGroupType;
  }
    
  protected Type typeMetaDataType = null;

  public Type getTypeMetaData()
  {
    return typeMetaDataType;
  }
    
  protected Type xsdMetaDataType = null;

  public Type getXSDMetaData()
  {
    return xsdMetaDataType;
  }
  

  private static boolean isInited = false;

  public static MetadataFactoryImpl init()
  {
    if (isInited) return (MetadataFactoryImpl)FactoryBase.getStaticFactory(MetadataFactoryImpl.NAMESPACE_URI);
    MetadataFactoryImpl theMetadataFactoryImpl = new MetadataFactoryImpl();
    isInited = true;

    // Initialize simple dependencies
    SDOUtil.registerStaticTypes(SDOFactory.class);
    SDOUtil.registerStaticTypes(ModelFactory.class);

    // Create package meta-data objects
    theMetadataFactoryImpl.createMetaData();

    // Initialize created meta-data
    theMetadataFactoryImpl.initializeMetaData();

    // Mark meta-data to indicate it can't be changed
    //theMetadataFactoryImpl.freeze(); //FB do we need to freeze / should we freeze ????

    return theMetadataFactoryImpl;
  }
  
  private boolean isCreated = false;

  public void createMetaData()
  {
    if (isCreated) return;
    isCreated = true;	


    javaMetaDataType = createType(false, JAVA_META_DATA);
    createProperty(true, javaMetaDataType, JavaMetaDataImpl.FACTORY_INTERFACE);
    createProperty(true, javaMetaDataType, JavaMetaDataImpl.TYPE_INTERFACE);

    sdoMetaDataGroupType = createType(false, SDO_META_DATA_GROUP);
    createProperty(false, sdoMetaDataGroupType, SDOMetaDataGroupImpl.JAVA_META_DATA);
    createProperty(false, sdoMetaDataGroupType, SDOMetaDataGroupImpl.XSD_META_DATA);
    createProperty(false, sdoMetaDataGroupType, SDOMetaDataGroupImpl.TYPE_META_DATA);

    typeMetaDataType = createType(false, TYPE_META_DATA);
    createProperty(true, typeMetaDataType, TypeMetaDataImpl.LOCATION);

    xsdMetaDataType = createType(false, XSD_META_DATA);
    createProperty(true, xsdMetaDataType, XSDMetaDataImpl.LOCATION);
  }
  
  private boolean isInitialized = false;

  public void initializeMetaData()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Obtain other dependent packages
    ModelFactoryImpl theModelPackageImpl = (ModelFactoryImpl)FactoryBase.getStaticFactory(ModelFactoryImpl.NAMESPACE_URI);
    Property property = null;

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initializeType(javaMetaDataType, JavaMetaData.class, "JavaMetaData");

    property = (Property)javaMetaDataType.getProperties().get(JavaMetaDataImpl.FACTORY_INTERFACE);
    initializeProperty(property, theModelPackageImpl.getString(), "factoryInterface", null, 0, 1, JavaMetaData.class, false, false, false);

    property = (Property)javaMetaDataType.getProperties().get(JavaMetaDataImpl.TYPE_INTERFACE);
    initializeProperty(property, theModelPackageImpl.getString(), "typeInterface", null, 0, 1, JavaMetaData.class, false, false, false);

    initializeType(sdoMetaDataGroupType, SDOMetaDataGroup.class, "SDOMetaDataGroup");

    property = (Property)sdoMetaDataGroupType.getProperties().get(SDOMetaDataGroupImpl.JAVA_META_DATA);
    initializeProperty(property, this.getJavaMetaData(), "javaMetaData", null, 0, -1, SDOMetaDataGroup.class, false, false, false, true , null);

    property = (Property)sdoMetaDataGroupType.getProperties().get(SDOMetaDataGroupImpl.XSD_META_DATA);
    initializeProperty(property, this.getXSDMetaData(), "xsdMetaData", null, 0, -1, SDOMetaDataGroup.class, false, false, false, true , null);

    property = (Property)sdoMetaDataGroupType.getProperties().get(SDOMetaDataGroupImpl.TYPE_META_DATA);
    initializeProperty(property, this.getTypeMetaData(), "typeMetaData", null, 0, -1, SDOMetaDataGroup.class, false, false, false, true , null);

    initializeType(typeMetaDataType, TypeMetaData.class, "TypeMetaData");

    property = (Property)typeMetaDataType.getProperties().get(TypeMetaDataImpl.LOCATION);
    initializeProperty(property, theModelPackageImpl.getString(), "location", null, 1, 1, TypeMetaData.class, false, false, false);

    initializeType(xsdMetaDataType, XSDMetaData.class, "XSDMetaData");

    property = (Property)xsdMetaDataType.getProperties().get(XSDMetaDataImpl.LOCATION);
    initializeProperty(property, theModelPackageImpl.getString(), "location", null, 1, 1, XSDMetaData.class, false, false, false);

    createXSDMetaData(theModelPackageImpl);
  }
    
  protected void createXSDMetaData(ModelFactoryImpl theModelPackageImpl)
  {
    super.initXSD();
    
    Property property = null;
    
    property = createGlobalProperty
      ("sdoMetaDataGroup",
      this.getSDOMetaDataGroup(),
       new String[]
       {
       "kind", "element",
       "name", "sdoMetaDataGroup",
       "namespace", "##targetNamespace"
       });
                
    addXSDMapping
      (javaMetaDataType,
       new String[] 
       {
       "name", "JavaMetaData",
       "kind", "empty"
       });

    addXSDMapping
      ((Property)javaMetaDataType.getProperties().get(JavaMetaDataImpl.FACTORY_INTERFACE),
       new String[]
       {
       "kind", "attribute",
       "name", "factoryInterface"
       });

    addXSDMapping
      ((Property)javaMetaDataType.getProperties().get(JavaMetaDataImpl.TYPE_INTERFACE),
       new String[]
       {
       "kind", "attribute",
       "name", "typeInterface"
       });

    addXSDMapping
      (sdoMetaDataGroupType,
       new String[] 
       {
       "name", "SDOMetaDataGroup",
       "kind", "elementOnly"
       });

    addXSDMapping
      ((Property)sdoMetaDataGroupType.getProperties().get(SDOMetaDataGroupImpl.JAVA_META_DATA),
       new String[]
       {
       "kind", "element",
       "name", "javaMetaData"
       });

    addXSDMapping
      ((Property)sdoMetaDataGroupType.getProperties().get(SDOMetaDataGroupImpl.XSD_META_DATA),
       new String[]
       {
       "kind", "element",
       "name", "xsdMetaData"
       });

    addXSDMapping
      ((Property)sdoMetaDataGroupType.getProperties().get(SDOMetaDataGroupImpl.TYPE_META_DATA),
       new String[]
       {
       "kind", "element",
       "name", "typeMetaData"
       });

    addXSDMapping
      (typeMetaDataType,
       new String[] 
       {
       "name", "TypeMetaData",
       "kind", "empty"
       });

    addXSDMapping
      ((Property)typeMetaDataType.getProperties().get(TypeMetaDataImpl.LOCATION),
       new String[]
       {
       "kind", "attribute",
       "name", "location"
       });

    addXSDMapping
      (xsdMetaDataType,
       new String[] 
       {
       "name", "XSDMetaData",
       "kind", "empty"
       });

    addXSDMapping
      ((Property)xsdMetaDataType.getProperties().get(XSDMetaDataImpl.LOCATION),
       new String[]
       {
       "kind", "attribute",
       "name", "location"
       });

  }
  
} //MetadataFactoryImpl
