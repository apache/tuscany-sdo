/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.sdo.model.xml.impl;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

import org.apache.tuscany.sdo.SDOFactory;

import org.apache.tuscany.sdo.impl.FactoryBase;

import org.apache.tuscany.sdo.model.ModelFactory;

import org.apache.tuscany.sdo.model.impl.ModelFactoryImpl;

import org.apache.tuscany.sdo.model.xml.*;

import org.apache.tuscany.sdo.util.SDOUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the commonj.sdo/xml model factory.
 * This model is generated from sdoXML.xsd, in the sdo-api project.
 * Until the SDO code generator supports name conflicts and regen/merge, follow the following steps to regenerate this model:
 *   1. Regenerate the model into a temporary directory:
 *         XSD2JavaGenerator -generateBuiltIn commonj.sdo/xml -prefix XML -targetDirectory <temp-dir> -javaPackage org.apache.tuscany.sdo.model.xml <sdo-api-dir>/src/main/resources/xml/sdoXML.xsd
 *   2. Change the value of the NAMESPACE_PREFIX to "sdoXML"
 *           public static final String NAMESPACE_PREFIX = "sdoXML"; //YZ generated as "_xml"
 *   3. Move this JavaDoc comment into the newly generated XMLFactoryImpl class.
 * <!-- end-user-doc -->
 * @generated
 */
public class XMLFactoryImpl extends FactoryBase implements XMLFactory
{

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_URI = "commonj.sdo/xml";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String NAMESPACE_PREFIX = "sdoXML"; //YZ generated as "_xml";
  public static final int XML_INFO = 1;

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMLFactoryImpl()
  {
    super(NAMESPACE_URI, NAMESPACE_PREFIX, "org.apache.tuscany.sdo.model.xml");
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
      case XML_INFO: return (DataObject)createXMLInfo();
      default:
        return super.create(typeNumber);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMLInfo createXMLInfo()
  {
    XMLInfoImpl xmlInfo = new XMLInfoImpl();
    return xmlInfo;
  }

  // Following creates and initializes SDO metadata for the supported types.
  protected Type xmlInfoType = null;

  public Type getXMLInfo()
  {
    return xmlInfoType;
  }


  private static boolean isInited = false;

  public static XMLFactoryImpl init()
  {
    if (isInited) return (XMLFactoryImpl)FactoryBase.getStaticFactory(XMLFactoryImpl.NAMESPACE_URI);
    XMLFactoryImpl theXmlFactoryImpl = new XMLFactoryImpl();
    isInited = true;

    // Initialize simple dependencies
    SDOUtil.registerStaticTypes(SDOFactory.class);
    SDOUtil.registerStaticTypes(ModelFactory.class);

    // Create package meta-data objects
    theXmlFactoryImpl.createMetaData();

    // Initialize created meta-data
    theXmlFactoryImpl.initializeMetaData();

    // Mark meta-data to indicate it can't be changed
    //theXmlFactoryImpl.freeze(); //FB do we need to freeze / should we freeze ????

    return theXmlFactoryImpl;
  }

  private boolean isCreated = false;

  public void createMetaData()
  {
    if (isCreated) return;
    isCreated = true;

    // Create types and their properties
    xmlInfoType = createType(false, XML_INFO);
    createProperty(true, xmlInfoType, XMLInfoImpl.XML_ELEMENT);
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
    initializeType(xmlInfoType, XMLInfo.class, "XMLInfo", false);
    property = (Property)xmlInfoType.getProperties().get(XMLInfoImpl.XML_ELEMENT);
    initializeProperty(property, theModelPackageImpl.getObject(), "xmlElement", null, 0, 1, XMLInfo.class, false, false, false);

    createXSDMetaData(theModelPackageImpl);
  }

  protected void createXSDMetaData(ModelFactoryImpl theModelPackageImpl)
  {
    super.initXSD();

    Property property = null;

    property = createGlobalProperty
      ("aliasName",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "attribute",
       "name", "aliasName",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);

    property = createGlobalProperty
      ("dataType",
      theModelPackageImpl.getURI(),
       new String[]
       {
       "kind", "attribute",
       "name", "dataType",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);

    property = createGlobalProperty
      ("many",
      theModelPackageImpl.getBoolean(),
       new String[]
       {
       "kind", "attribute",
       "name", "many",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);

    property = createGlobalProperty
      ("name",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "attribute",
       "name", "name",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);

    property = createGlobalProperty
      ("oppositeProperty",
      theModelPackageImpl.getString(),
       new String[]
       {
       "kind", "attribute",
       "name", "oppositeProperty",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);

    property = createGlobalProperty
      ("propertyType",
      theModelPackageImpl.getURI(),
       new String[]
       {
       "kind", "attribute",
       "name", "propertyType",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);

    property = createGlobalProperty
      ("readOnly",
      theModelPackageImpl.getBoolean(),
       new String[]
       {
       "kind", "attribute",
       "name", "readOnly",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);

    property = createGlobalProperty
      ("sequence",
      theModelPackageImpl.getBoolean(),
       new String[]
       {
       "kind", "attribute",
       "name", "sequence",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);

    property = createGlobalProperty
      ("string",
      theModelPackageImpl.getBoolean(),
       new String[]
       {
       "kind", "attribute",
       "name", "string",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);

    property = createGlobalProperty
      ("xmlElement",
      theModelPackageImpl.getObject(),
       new String[]
       {
       "kind", "attribute",
       "name", "xmlElement",
       "namespace", "##targetNamespace"
       },
       IS_ATTRIBUTE);

    addXSDMapping
      (xmlInfoType,
       new String[]
       {
       "name", "XMLInfo",
       "kind", "empty"
       });

    addXSDMapping
      ((Property)xmlInfoType.getProperties().get(XMLInfoImpl.XML_ELEMENT),
       new String[]
       {
       "kind", "attribute",
       "name", "xmlElement"
       });

  }

} //XmlFactoryImpl