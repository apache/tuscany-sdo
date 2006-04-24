/**
 *
 *  Copyright 2005 The Apache Software Foundation or its licensors, as applicable.
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
package org.apache.tuscany.sdo.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.util.SDOUtil;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;

public class DefineTypeTestCase extends TestCase 
{
  private static final String CUSTOMER1_XML = "/customer1.xml";
  private static final String CUSTOMER2_XML = "/customer2.xml";
  private static final String OPEN_XML = "/open2.xml";
  private static final String MIXED_XML = "/mixed2.xml";
  
  public void testDefineTypeRoundTrip() throws Exception {
    TypeHelper types = SDOUtil.createTypeHelper();
    DataFactory factory = SDOUtil.createDataFactory(types);
    XMLHelper xmlHelper = SDOUtil.createXMLHelper(types);

    Type intType = types.getType("commonj.sdo", "Int");
    Type stringType = types.getType("commonj.sdo", "String");
    
    // create a new Type for Customers
    DataObject customerType = factory.create("commonj.sdo",
    "Type");
    customerType.set("uri", "http://example.com/customer");
    customerType.set("name", "Customer");
    
    // create a customer number property
    DataObject custNumProperty = customerType.createDataObject("property");
    custNumProperty.set("name", "custNum");
    custNumProperty.set("type", intType);
     
    // create a first name property
    DataObject firstNameProperty =
    customerType.createDataObject("property");
    firstNameProperty.set("name", "firstName");
    firstNameProperty.set("type", stringType);

    // create a last name property
    DataObject lastNameProperty = customerType.createDataObject("property");
    lastNameProperty.set("name", "lastName");
    lastNameProperty.set("type", stringType);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    xmlHelper.save(customerType, "commonj.sdo", "type", baos);
    
    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
    XMLDocument xdoc = xmlHelper.load(bais);

    customerType = xdoc.getRootObject();
    
    // now define the Customer type so that customers can be made
    types.define(customerType);
    
    DataObject customer1 = factory.create("http://example.com/customer",
    "Customer");
    
    customer1.setInt("custNum", 1);
    customer1.set("firstName", "John");
    customer1.set("lastName", "Adams");
    DataObject customer2 = factory.create("http://example.com/customer",
    "Customer");    
    customer2.setInt("custNum", 2);
    customer2.set("firstName", "Jeremy");
    customer2.set("lastName", "Pavick");
    
    assertNotNull(customer1);
    Type type = customer1.getType();
    assertNotNull(type.getProperty("custNum"));
    assertNotNull(type.getProperty("firstName"));
    assertNotNull(type.getProperty("lastName"));
    assertEquals(type.getProperty("custNum").getType(), intType);
    assertEquals(type.getProperty("firstName").getType(), stringType);
    assertEquals(type.getProperty("lastName").getType(), stringType);
    
    assertNotNull(customer2);
    type = customer2.getType();
    assertNotNull(type.getProperty("custNum"));
    assertNotNull(type.getProperty("firstName"));
    assertNotNull(type.getProperty("lastName"));
    assertEquals(type.getProperty("custNum").getType(), intType);
    assertEquals(type.getProperty("firstName").getType(), stringType);
    assertEquals(type.getProperty("lastName").getType(), stringType);
    
    baos = new ByteArrayOutputStream();
    xmlHelper.save(
      customer1, 
      "http://example.com/customer",
      "Customer", baos);
    assertTrue(
      TestUtil.equalXmlFiles(
        new ByteArrayInputStream(baos.toByteArray()), 
        getClass().getResource(CUSTOMER1_XML)));
    
    baos = new ByteArrayOutputStream();
    xmlHelper.save(
      customer2, 
      "http://example.com/customer",
      "Customer", baos);
    assertTrue(
        TestUtil.equalXmlFiles(
          new ByteArrayInputStream(baos.toByteArray()), 
          getClass().getResource(CUSTOMER2_XML)));
  }
  
  public void testDefineType() throws Exception 
  {
    TypeHelper types = SDOUtil.createTypeHelper();
    DataFactory factory = SDOUtil.createDataFactory(types);
    XMLHelper xmlHelper = SDOUtil.createXMLHelper(types);

    Type intType = types.getType("commonj.sdo", "Int");
    Type stringType = types.getType("commonj.sdo", "String");
    
    // create a new Type for Customers
    DataObject customerType = factory.create("commonj.sdo",
    "Type");
    customerType.set("uri", "http://example.com/customer");
    customerType.set("name", "Customer");

    // create a customer number property
    DataObject custNumProperty = customerType.createDataObject("property");
    custNumProperty.set("name", "custNum");
    custNumProperty.set("type", intType);

    // create a first name property
    DataObject firstNameProperty =
    customerType.createDataObject("property");
    firstNameProperty.set("name", "firstName");
    firstNameProperty.set("type", stringType);

    // create a last name property
    DataObject lastNameProperty = customerType.createDataObject("property");
    lastNameProperty.set("name", "lastName");
    lastNameProperty.set("type", stringType);

    // now define the Customer type so that customers can be made
    types.define(customerType);
    
    DataObject customer1 = factory.create("http://example.com/customer",
    "Customer");
    customer1.setInt("custNum", 1);
    customer1.set("firstName", "John");
    customer1.set("lastName", "Adams");
    DataObject customer2 = factory.create("http://example.com/customer",
    "Customer");    
    customer2.setInt("custNum", 2);
    customer2.set("firstName", "Jeremy");
    customer2.set("lastName", "Pavick");

    assertNotNull(customer1);
    Type type = customer1.getType();
    assertNotNull(type.getProperty("custNum"));
    assertNotNull(type.getProperty("firstName"));
    assertNotNull(type.getProperty("lastName"));
    assertEquals(type.getProperty("custNum").getType(), intType);
    assertEquals(type.getProperty("firstName").getType(), stringType);
    assertEquals(type.getProperty("lastName").getType(), stringType);
    
    assertNotNull(customer2);
    type = customer2.getType();
    assertNotNull(type.getProperty("custNum"));
    assertNotNull(type.getProperty("firstName"));
    assertNotNull(type.getProperty("lastName"));
    assertEquals(type.getProperty("custNum").getType(), intType);
    assertEquals(type.getProperty("firstName").getType(), stringType);
    assertEquals(type.getProperty("lastName").getType(), stringType);
    
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    xmlHelper.save(
      customer1, 
      "http://example.com/customer",
      "Customer", baos);
    assertTrue(
      TestUtil.equalXmlFiles(
        new ByteArrayInputStream(baos.toByteArray()), 
        getClass().getResource(CUSTOMER1_XML)));
    
    baos = new ByteArrayOutputStream();
    xmlHelper.save(
      customer2, 
      "http://example.com/customer",
      "Customer", baos);
    assertTrue(
        TestUtil.equalXmlFiles(
          new ByteArrayInputStream(baos.toByteArray()), 
          getClass().getResource(CUSTOMER2_XML)));
  }
  
  public void testDefineDataType() throws Exception 
  {
    TypeHelper types = SDOUtil.createTypeHelper();
    DataFactory factory = SDOUtil.createDataFactory(types);
    XSDHelper xsdHelper = SDOUtil.createXSDHelper(types);
    XMLHelper xmlHelper = SDOUtil.createXMLHelper(types);

    Property javaClassProperty = xsdHelper.getGlobalProperty("commonj.sdo/java", "javaClass", false);
    
    // create a data types
    DataObject intType = factory.create("commonj.sdo", "Type");
    intType.set("uri", "http://example.com/customer");
    intType.set("name", "MyIntType");
    intType.setBoolean("dataType", true);
    intType.set(javaClassProperty, "int");
    
    DataObject stringType = factory.create("commonj.sdo", "Type");
    stringType.set("uri", "http://example.com/customer");
    stringType.set("name", "MyStringType");
    stringType.setBoolean("dataType", true);
    stringType.set(javaClassProperty, "java.lang.String");
    
    // create a new Type for Customers
    DataObject customerType = factory.create("commonj.sdo",
    "Type");
    customerType.set("uri", "http://example.com/customer");
    customerType.set("name", "Customer");
    
    // create a customer number property
    DataObject custNumProperty = customerType.createDataObject("property");
    custNumProperty.set("name", "custNum");
    custNumProperty.set("type", intType);

    // create a first name property
    DataObject firstNameProperty =
    customerType.createDataObject("property");
    firstNameProperty.set("name", "firstName");
    firstNameProperty.set("type", stringType);

    // create a last name property
    DataObject lastNameProperty = customerType.createDataObject("property");
    lastNameProperty.set("name", "lastName");
    lastNameProperty.set("type", stringType);

    // now define the Customer type so that customers can be made
    types.define(customerType);
    
    DataObject customer1 = factory.create("http://example.com/customer",
    "Customer");
    
    customer1.setInt("custNum", 1);
    customer1.set("firstName", "John");
    customer1.set("lastName", "Adams");
    DataObject customer2 = factory.create("http://example.com/customer",
    "Customer");
    customer2.setInt("custNum", 2);
    customer2.set("firstName", "Jeremy");
    customer2.set("lastName", "Pavick");
    
    assertNotNull(customer1);
    Type type = customer1.getType();
    assertNotNull(type.getProperty("custNum"));
    assertNotNull(type.getProperty("firstName"));
    assertNotNull(type.getProperty("lastName"));
    assertNotNull(type.getProperty("custNum"));
    assertNotNull(type.getProperty("firstName"));
    assertNotNull(type.getProperty("lastName"));
    
    type = type.getProperty("custNum").getType();
    assertEquals(type.getURI(), "http://example.com/customer");
    assertEquals(type.getName(), "MyIntType");
    assertTrue(type.isDataType());
    
    assertNotNull(customer2);
    type = customer2.getType();
    assertNotNull(type.getProperty("custNum"));
    assertNotNull(type.getProperty("firstName"));
    assertNotNull(type.getProperty("lastName"));
    assertNotNull(type.getProperty("custNum"));
    assertNotNull(type.getProperty("firstName"));
    assertNotNull(type.getProperty("lastName"));
    
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    xmlHelper.save(
      customer1, 
      "http://example.com/customer",
      "Customer", baos);
    assertTrue(
      TestUtil.equalXmlFiles(
        new ByteArrayInputStream(baos.toByteArray()), 
        getClass().getResource(CUSTOMER1_XML)));
    
    baos = new ByteArrayOutputStream();
    xmlHelper.save(
      customer2, 
      "http://example.com/customer",
      "Customer", baos);
    assertTrue(
        TestUtil.equalXmlFiles(
          new ByteArrayInputStream(baos.toByteArray()), 
          getClass().getResource(CUSTOMER2_XML)));
  }
  
  public void testFastDefineType() throws Exception 
  {
    TypeHelper types = SDOUtil.createTypeHelper();
    DataFactory factory = SDOUtil.createDataFactory(types);
    XMLHelper xmlHelper = SDOUtil.createXMLHelper(types);

    Type intType = types.getType("commonj.sdo", "Int");
    Type stringType = types.getType("commonj.sdo", "String");
    
    // create a new Type for Customers
    Type customerType = SDOUtil.createType(types, "http://example.com/customer", "Customer", false);

    // create a customer number property
    SDOUtil.createProperty(customerType, "custNum", intType);

    // create a first name property
    SDOUtil.createProperty(customerType, "firstName", stringType);

    // create a last name property
    SDOUtil.createProperty(customerType, "lastName", stringType);

    DataObject customer1 = factory.create("http://example.com/customer",
    "Customer");
    customer1.setInt("custNum", 1);
    customer1.set("firstName", "John");
    customer1.set("lastName", "Adams");
    DataObject customer2 = factory.create("http://example.com/customer",
    "Customer");
    customer2.setInt("custNum", 2);
    customer2.set("firstName", "Jeremy");
    customer2.set("lastName", "Pavick");
    
    assertNotNull(customer1);
    Type type = customer1.getType();
    assertNotNull(type.getProperty("custNum"));
    assertNotNull(type.getProperty("firstName"));
    assertNotNull(type.getProperty("lastName"));
    assertEquals(type.getProperty("custNum").getType(), intType);
    assertEquals(type.getProperty("firstName").getType(), stringType);
    assertEquals(type.getProperty("lastName").getType(), stringType);
    
    assertNotNull(customer2);
    type = customer2.getType();
    assertNotNull(type.getProperty("custNum"));
    assertNotNull(type.getProperty("firstName"));
    assertNotNull(type.getProperty("lastName"));
    assertEquals(type.getProperty("custNum").getType(), intType);
    assertEquals(type.getProperty("firstName").getType(), stringType);
    assertEquals(type.getProperty("lastName").getType(), stringType);  
    
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    xmlHelper.save(
      customer1, 
      "http://example.com/customer",
      "Customer", baos);
    assertTrue(
      TestUtil.equalXmlFiles(
        new ByteArrayInputStream(baos.toByteArray()), 
        getClass().getResource(CUSTOMER1_XML)));
    
    baos = new ByteArrayOutputStream();
    xmlHelper.save(
      customer2, 
      "http://example.com/customer",
      "Customer", baos);
    assertTrue(
        TestUtil.equalXmlFiles(
          new ByteArrayInputStream(baos.toByteArray()), 
          getClass().getResource(CUSTOMER2_XML)));
  }
  
  public void testDefineSequencedType() throws Exception 
  {
    /*
    TypeHelper types = SDOUtil.createTypeHelper();
    DataFactory factory = SDOUtil.createDataFactory(types);
    XMLHelper xmlHelper = SDOUtil.createXMLHelper(types);
    
    Type stringType = types.getType("commonj.sdo", "String");
    Type decimalType = types.getType("commonj.sdo", "Decimal");
    
    // Define a new mixed type - MixedQuote
    DataObject mixedQuoteType = factory.create("commonj.sdo", "Type");
    mixedQuoteType.set("uri", "http://www.example.com/mixed");
    mixedQuoteType.set("name", "MixedQuote");
    mixedQuoteType.set("sequenced", Boolean.TRUE);
    
    DataObject symbolProperty = mixedQuoteType.createDataObject("property");
    symbolProperty.set("name", "symbol");
    symbolProperty.set("type", stringType);
    
    DataObject companyNameProperty = mixedQuoteType.createDataObject("property");
    companyNameProperty.set("name", "companyName");
    companyNameProperty.set("type", stringType);
    
    DataObject priceProperty = mixedQuoteType.createDataObject("property");
    priceProperty.set("name", "price");
    priceProperty.set("type", decimalType);
    
    DataObject quotesProperty = mixedQuoteType.createDataObject("property");
    quotesProperty.set("name", "quotes");
    quotesProperty.set("type", mixedQuoteType);
    quotesProperty.set("many", Boolean.TRUE);
    quotesProperty.set("containment", Boolean.TRUE);
    
    types.define(mixedQuoteType);
    
    DataObject quote = factory.create("http://www.example.com/mixed", "MixedQuote");

    assertTrue(quote.getType().isSequenced());
    
    Sequence sequence = quote.getSequence();

    sequence.add("\n  ");

    quote.setString("symbol", "fbnt");

    sequence.add("\n  ");

    quote.setString("companyName", "FlyByNightTechnology");

    sequence.add("\n  some text\n  ");

    DataObject child = quote.createDataObject("quotes");
    child.setBigDecimal("price", new BigDecimal("2000.0"));

    sequence.add("\n  more text\n  ");

    // quote.setBigDecimal("price", new BigDecimal("1000.0"));
    sequence.add("price", new BigDecimal("1000.0"));

    sequence.add("\n");

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    xmlHelper.save(quote, "http://www.example.com/sequenced", "mixedStockQuote", baos);
    assertTrue(TestUtil.equalXmlFiles(new ByteArrayInputStream(baos.toByteArray()), getClass().getResource(MIXED_XML)));
    */
  }
  
  public void testDefineOpenType() throws Exception 
  {
    TypeHelper types = SDOUtil.createTypeHelper();
    DataFactory factory = SDOUtil.createDataFactory(types);
    XMLHelper xmlHelper = SDOUtil.createXMLHelper(types);
    
    Type stringType = types.getType("commonj.sdo", "String");
    Type decimalType = types.getType("commonj.sdo", "Decimal");
    
    // Define a new open type - OpenQuote
    DataObject openQuoteType = factory.create("commonj.sdo", "Type");
    openQuoteType.set("uri", "http://www.example.com/open");
    openQuoteType.set("name", "OpenQuote");
    openQuoteType.set("open", Boolean.TRUE);
    openQuoteType.setBoolean("open", true);
    
    types.define(openQuoteType);
    
    // Define new type - CompanyType
    DataObject companyType = factory.create("commonj.sdo", "Type");
    companyType.set("uri", "http://www.example.com/open");
    companyType.set("name", "CompanyType");
    
    // Create CompanyType property - "name"
    DataObject nameProperty = companyType.createDataObject("property");
    nameProperty.set("name", "name");
    nameProperty.set("type", stringType);
    nameProperty.set("containment", Boolean.TRUE);
    
    types.define(companyType);
    
    // Define a global type
    DataObject globalType = factory.create("commonj.sdo", "Type");
    globalType.set("uri", "http://www.example.com/open");
    // no need to specify the type's name
    
    DataObject symbolProperty = globalType.createDataObject("property");
    symbolProperty.set("name", "symbol");
    symbolProperty.set("type", stringType);
    symbolProperty.set("containment", Boolean.TRUE);
    
    // Define a global property - company
    DataObject companyProperty = globalType.createDataObject("property");
    companyProperty.set("name", "company");
    companyProperty.set("type", companyType);
    companyProperty.set("containment", Boolean.TRUE);
    
    // Define a global property - price
    DataObject priceProperty = globalType.createDataObject("property");
    priceProperty.set("name", "price");
    priceProperty.set("type", decimalType);
    
    types.define(globalType);
    
    // Create DataObject instances
    DataObject openQuote = factory.create("http://www.example.com/open", "OpenQuote");
    
    assertTrue(openQuote.getType().isOpen());
    
    // Get global type
    Type definedGlobalType = types.getType("http://www.example.com/open", null);
    
    Property definedSymbolProperty = definedGlobalType.getProperty("symbol");
    openQuote.set(definedSymbolProperty, "s1");
    
    Property definedCompanyProperty = definedGlobalType.getProperty("company");
    
    DataObject company = openQuote.createDataObject(definedCompanyProperty);
    company.setString("name", "FlyByNightTechnology");
      
    Property definedPriceProperty = definedGlobalType.getProperty("price");
    openQuote.setBigDecimal(definedPriceProperty, new BigDecimal("1000.0"));
    
    assertEquals(definedPriceProperty.getType(), decimalType);
    
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    xmlHelper.save(
      openQuote, 
      "http://www.example.com/open",
      "openStockQuote", baos);
    assertTrue(
      TestUtil.equalXmlFiles(
        new ByteArrayInputStream(baos.toByteArray()), 
        getClass().getResource(OPEN_XML)));
  }
  
}
