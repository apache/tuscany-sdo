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
package org.apache.tuscany.sdo.test;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.api.SDOUtil;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XSDHelper;


public class MetadataInstancePropertiesTestCase extends TestCase
{
  private final String TEST_MODEL = "/TypePropertyMetadataInfo.xsd";
  private final String TEST_NAMESPACE = "http://www.example.com/metadata/retrievaltest";
  private final String DYNAMIC_TEST_NAMESPACE = "http://www.example.com/metadata/dynamicmetadata";

  private HelperContext helperContext;
  private TypeHelper typeHelper;
  private XSDHelper xsdHelper;
  private DataFactory dataFactory;

  public void testXSDTypeProperties()
  {
    // Note: We won't check the actual value of XSD instance properties yet since they're not defined 
    // in the SDO spec yet.

    //displayInstanceProperties(TEST_NAMESPACE);

    Type type = typeHelper.getType(TEST_NAMESPACE, "Example");
    assertTrue(getInstanceProperty(type, "appinfo") != null); 
    assertTrue(getInstanceProperty(type, "foo") == null);

    Property property = type.getProperty("number");
    assertTrue(getInstanceProperty(property, "appinfo") != null);
    assertTrue(getInstanceProperty(property, "foo") == null);

    property = type.getProperty("Exampletype");
    assertTrue(getInstanceProperty(property, "appinfo") != null);
    assertTrue(getInstanceProperty(property, "foo") == null);

    type = typeHelper.getType(TEST_NAMESPACE, "ExampleNumber");
    assertTrue(getInstanceProperty(type, "appinfo") != null);
    assertTrue(getInstanceProperty(type, "minInclusive") != null);
    assertTrue(getInstanceProperty(type, "maxInclusive") != null);
    assertTrue(getInstanceProperty(type, "foo") == null);

    type = typeHelper.getType(TEST_NAMESPACE, "ExampleRating");
    assertTrue(getInstanceProperty(type, "enumeration") != null);
    assertTrue(getInstanceProperty(type, "foo") == null);

    type = typeHelper.getType(TEST_NAMESPACE, "PhoneNumber");
    assertTrue(getInstanceProperty(type, "appinfo") != null);
    assertTrue(getInstanceProperty(type, "length") != null);
    assertTrue(getInstanceProperty(type, "pattern") != null);
    assertTrue(getInstanceProperty(type, "foo") == null);
  }

  public void testDynamicTypeProperties()
  {
    // Create dynamic model
    Type intType = typeHelper.getType("commonj.sdo", "Int");
    Type stringType = typeHelper.getType("commonj.sdo", "String");
    
    Property openContentProperty = typeHelper.getOpenContentProperty("commonj.sdo/xml", "xmlElement");
    
    // create a new Type for Customers
    DataObject customerType = dataFactory.create("commonj.sdo", "Type");
    customerType.set("uri", DYNAMIC_TEST_NAMESPACE);
    customerType.set("name", "Customer");
    customerType.set(openContentProperty, Boolean.TRUE);

    // create a customer number property
    DataObject custNumProperty = customerType.createDataObject("property");
    custNumProperty.set("name", "custNum");
    custNumProperty.set("type", intType);

    // create a first name property
    DataObject firstNameProperty =
    customerType.createDataObject("property");
    firstNameProperty.set("name", "firstName");
    firstNameProperty.set("type", stringType);
    firstNameProperty.set(openContentProperty, Boolean.FALSE);

    // create a last name property
    DataObject lastNameProperty = customerType.createDataObject("property");
    lastNameProperty.set("name", "lastName");
    lastNameProperty.set("type", stringType);

    // now define the Customer type so that customers can be made
    typeHelper.define(customerType);

    //displayInstanceProperties(DYNAMIC_TEST_NAMESPACE);
    
    Type type = typeHelper.getType(DYNAMIC_TEST_NAMESPACE, "Customer");
    assertTrue(getInstanceProperty(type, "xmlElement") == openContentProperty);
    assertTrue(type.get(openContentProperty) == Boolean.TRUE);
    assertTrue(getInstanceProperty(type, "foo") == null);

    Property property = type.getProperty("custNum");
    assertTrue(getInstanceProperty(property, "xmlElement") == null);
    assertTrue(getInstanceProperty(property, "foo") == null);
   
    property = type.getProperty("firstName");
    assertTrue(getInstanceProperty(property, "xmlElement") == openContentProperty);
    assertTrue(property.get(openContentProperty) == Boolean.FALSE);
    assertTrue(getInstanceProperty(property, "foo") == null);
   
    property = type.getProperty("lastName");
    assertTrue(getInstanceProperty(property, "xmlElement") == null);
    assertTrue(getInstanceProperty(property, "foo") == null);
  }
  
  //Amita
  public void testEnumProperty()
  {
	    Type type = typeHelper.getType(TEST_NAMESPACE, "ExampleRating");
	    assertTrue(getInstanceProperty(type, "enumeration") != null);
	    List enumFacet = SDOUtil.getEnumerationFacet(type);
	    assertEquals(3, enumFacet.size());
	    assertEquals("", enumFacet.get(0));
	    assertEquals("Good", enumFacet.get(1));
	    assertEquals("Bad", enumFacet.get(2));	    
  }
  
  //Amita
  public void testPatternProperty()
  {
	    Type type = typeHelper.getType(TEST_NAMESPACE, "PhoneNumber");
	    assertTrue(getInstanceProperty(type, "pattern") != null);
	    List patternFacet = SDOUtil.getPatternFacet(type);
	    assertEquals(2, patternFacet.size());
	    assertEquals("\\d{3}-\\d{4}", patternFacet.get(0));
	    assertEquals("\\d{6}-\\d{8}", patternFacet.get(1));
  }
  
  public void setUp() throws Exception
  {
    super.setUp();

    helperContext = SDOUtil.createHelperContext();
    
    typeHelper = helperContext.getTypeHelper();
    xsdHelper = helperContext.getXSDHelper();
    dataFactory = helperContext.getDataFactory();

    URL url = getClass().getResource(TEST_MODEL);
    InputStream inputStream = url.openStream();

    xsdHelper.define(inputStream, url.toString());
    inputStream.close();
  }

  public Property getInstanceProperty(Type type, String propertyName)
  {
    return getInstanceProperty(type.getInstanceProperties(), propertyName);
  }

  public Property getInstanceProperty(Property property, String propertyName)
  {
    return getInstanceProperty(property.getInstanceProperties(), propertyName);
  }

  private Property getInstanceProperty(List instProps, String propertyName)
  {
    for (int i = 0; i < instProps.size(); i++)
    {
      Property prop = (Property)instProps.get(i);
      if (propertyName.equals(prop.getName()))
        return prop;
    }
    return null;
  }

  private void displayInstanceProperties(Type type)
  {
    System.out.println("Type's name: " + type.getName());
    List instProps = type.getInstanceProperties();
    for (int i = 0; i < instProps.size(); i++)
    {
      Property prop = (Property)instProps.get(i);
      System.out.println("\tType's instance property name: " + prop.getName());
      System.out.println("\tType's instance property value: \"" + type.get(prop) + "\"");
    }
  }

  private void displayInstanceProperties(Property prop)
  {
    System.out.println("\tProperty's name: " + prop.getName());
    List propsInstProps = prop.getInstanceProperties();
    for (int j = 0; j < propsInstProps.size(); j++)
    {
      Property propsInstProp = (Property)propsInstProps.get(j);
      System.out.println("\t\tProperty's instance property name: " + propsInstProp.getName());
      System.out.println("\t\tProperty's instance property value: \"" + prop.get(propsInstProp) + "\"");
    }
  }

  public void displayInstanceProperties(String namespace)
  {
    List types = SDOUtil.getTypes(helperContext, namespace);
    for (int i = 0; i < types.size(); i++)
    {
      Type type = (Type)types.get(i);
      displayInstanceProperties(type);
      List properties = type.getProperties();
      for (int j = 0; j < properties.size(); j++)
      {
        Property property = (Property)properties.get(j);
        displayInstanceProperties(property);
      }
      System.out.println("**************************************");
    }
  }

}
