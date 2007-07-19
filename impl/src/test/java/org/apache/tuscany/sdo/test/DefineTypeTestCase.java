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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.api.SDOUtil;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.HelperContext;
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
  private static final String MIXEDOPEN_XML = "/mixedopen.xml";
  
  HelperContext hc;
  
  protected void setUp() throws Exception {
    super.setUp();
    hc = SDOUtil.createHelperContext();
  }

  public void testDefineTypeRoundTrip() throws Exception {
    TypeHelper types = hc.getTypeHelper();
    DataFactory factory = hc.getDataFactory();
    XMLHelper xmlHelper = hc.getXMLHelper();

    Type intType = types.getType("commonj.sdo", "Int");
    Type stringType = types.getType("commonj.sdo", "String");
    
    Property xmlElementProp = hc.getXSDHelper().getGlobalProperty("commonj.sdo/xml", "xmlElement", false); 
    
    // create a new Type for Customers
    DataObject customerType = factory.create("commonj.sdo",
    "Type");
    customerType.set("uri", "http://example.com/customer");
    customerType.set("name", "Customer");
    
    // create a customer number property as an XSD attribute
    DataObject custNumProperty = customerType.createDataObject("property");
    custNumProperty.set("name", "custNum");
    custNumProperty.set("type", intType);
    custNumProperty.setBoolean(xmlElementProp, false);
     
    // create a first name property as an XSD attribute
    DataObject firstNameProperty =
    customerType.createDataObject("property");
    firstNameProperty.set("name", "firstName");
    firstNameProperty.set("type", stringType);
    firstNameProperty.setBoolean(xmlElementProp, false);

    // create a last name property as an XSD attribute
    DataObject lastNameProperty = customerType.createDataObject("property");
    lastNameProperty.set("name", "lastName");
    lastNameProperty.set("type", stringType);
    lastNameProperty.setBoolean(xmlElementProp, false);

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
    TypeHelper types = hc.getTypeHelper();
    DataFactory factory = hc.getDataFactory();
    XMLHelper xmlHelper = hc.getXMLHelper();

    Type intType = types.getType("commonj.sdo", "Int");
    Type stringType = types.getType("commonj.sdo", "String");
    
    Property xmlElementProp = hc.getXSDHelper().getGlobalProperty("commonj.sdo/xml", "xmlElement", false); 
    
    // create a new Type for Customers
    DataObject customerType = factory.create("commonj.sdo",
    "Type");
    customerType.set("uri", "http://example.com/customer");
    customerType.set("name", "Customer");

    // create a customer number property
    DataObject custNumProperty = customerType.createDataObject("property");
    custNumProperty.set("name", "custNum");
    custNumProperty.set("type", intType);
    custNumProperty.setBoolean(xmlElementProp, false);

    // create a first name property
    DataObject firstNameProperty =
    customerType.createDataObject("property");
    firstNameProperty.set("name", "firstName");
    firstNameProperty.set("type", stringType);
    firstNameProperty.setBoolean(xmlElementProp, false);

    // create a last name property
    DataObject lastNameProperty = customerType.createDataObject("property");
    lastNameProperty.set("name", "lastName");
    lastNameProperty.set("type", stringType);
    lastNameProperty.setBoolean(xmlElementProp, false);

    // now define the Customer type so that customers can be made
    types.define(customerType);
    
    DataObject customer1 = factory.create("http://example.com/customer",
    "Customer");

    customer1.setInt("custNum", 0);
    assertTrue(customer1.isSet("custNum"));

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
    assertNotNull(types.getOpenContentProperty("http://example.com/customer", "customer"));

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
    TypeHelper types = hc.getTypeHelper();
    DataFactory factory = hc.getDataFactory();
    XMLHelper xmlHelper = hc.getXMLHelper();
    XSDHelper xsdHelper = hc.getXSDHelper();

    Property xmlElementProp = hc.getXSDHelper().getGlobalProperty("commonj.sdo/xml", "xmlElement", false);
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
    custNumProperty.setBoolean(xmlElementProp, false);

    // create a first name property
    DataObject firstNameProperty =
    customerType.createDataObject("property");
    firstNameProperty.set("name", "firstName");
    firstNameProperty.set("type", stringType);
    firstNameProperty.setBoolean(xmlElementProp, false);

    // create a last name property
    DataObject lastNameProperty = customerType.createDataObject("property");
    lastNameProperty.set("name", "lastName");
    lastNameProperty.set("type", stringType);
    lastNameProperty.setBoolean(xmlElementProp, false);

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
    assertNotNull(types.getOpenContentProperty("http://example.com/customer", "customer"));
    
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
    TypeHelper types = hc.getTypeHelper();
    DataFactory factory = hc.getDataFactory();
    XMLHelper xmlHelper = hc.getXMLHelper();

    Type intType = types.getType("commonj.sdo", "Int");
    Type stringType = types.getType("commonj.sdo", "String");
    
    // create a new Type for Customers
    Type customerType = SDOUtil.createType(hc, "http://example.com/customer", "Customer", false);

    // create a customer number property
    Property custNumProperty = SDOUtil.createProperty(customerType, "custNum", intType);
    SDOUtil.setPropertyXMLKind(custNumProperty, false);

    // create a first name property
    Property firstNameProperty = SDOUtil.createProperty(customerType, "firstName", stringType);
    SDOUtil.setPropertyXMLKind(firstNameProperty, false);

    // create a last name property
    Property lastNameProperty = SDOUtil.createProperty(customerType, "lastName", stringType);
    SDOUtil.setPropertyXMLKind(lastNameProperty, false);

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

    TypeHelper types = hc.getTypeHelper();
    DataFactory factory = hc.getDataFactory();
    XMLHelper xmlHelper = hc.getXMLHelper();
    
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

    sequence.addText("\n  ");

    quote.setString("symbol", "fbnt");

    sequence.addText("\n  ");

    quote.setString("companyName", "FlyByNightTechnology");

    sequence.addText("\n  some text\n  ");

    DataObject child = quote.createDataObject("quotes");
    child.setBigDecimal("price", new BigDecimal("2000.0"));

    sequence.addText("\n  more text\n  ");

    // quote.setBigDecimal("price", new BigDecimal("1000.0"));
    sequence.add("price", new BigDecimal("1000.0"));

    sequence.addText("\n");

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    xmlHelper.save(quote, "http://www.example.com/mixed", "mixedStockQuote", baos);
    assertTrue(TestUtil.equalXmlFiles(new ByteArrayInputStream(baos.toByteArray()), getClass().getResource(MIXED_XML)));
  }
  
  public void testDefineSequencedOpenType() throws Exception 
  {
    TypeHelper types = hc.getTypeHelper();
    DataFactory factory = hc.getDataFactory();
    XMLHelper xmlHelper = hc.getXMLHelper();
    
    Type stringType = types.getType("commonj.sdo", "String");
    Type decimalType = types.getType("commonj.sdo", "Decimal");
    
    // Define a new mixed type - MixedQuote
    DataObject mixedQuoteType = factory.create("commonj.sdo", "Type");
    mixedQuoteType.set("uri", "http://www.example.com/mixed");
    mixedQuoteType.set("name", "MixedOpenQuote");
    mixedQuoteType.set("sequenced", Boolean.TRUE);
    mixedQuoteType.set("open", Boolean.TRUE);
    
//    DataObject symbolProperty = mixedQuoteType.createDataObject("property");
//    symbolProperty.set("name", "symbol");
//    symbolProperty.set("type", stringType);
    
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
    
    // Define a global type
    DataObject globalType = factory.create("commonj.sdo", "Type");
    globalType.set("uri", "http://www.example.com/open");
    // Don't set the type's name - null is used for types containing global properties.
    
    DataObject symbolProperty = globalType.createDataObject("property");
    symbolProperty.set("name", "symbol");
    symbolProperty.set("type", stringType);
    symbolProperty.set("containment", Boolean.TRUE);
    
    types.define(globalType);
    
    DataObject quote = factory.create("http://www.example.com/mixed", "MixedOpenQuote");

    assertTrue(quote.getType().isSequenced());
    
    Sequence sequence = quote.getSequence();

    sequence.addText("\n  ");

    Type definedGlobalType = types.getType("http://www.example.com/open", "DocumentRoot");
    
    Property definedSymbolProperty = definedGlobalType.getProperty("symbol");
    quote.setString(definedSymbolProperty, "fbnt");

    sequence.addText("\n  ");

    quote.setString("companyName", "FlyByNightTechnology");

    sequence.addText("\n  some text\n  ");

    DataObject child = quote.createDataObject("quotes");
    child.setBigDecimal("price", new BigDecimal("2000.0"));

    sequence.addText("\n  more text\n  ");

    // quote.setBigDecimal("price", new BigDecimal("1000.0"));
    sequence.add("price", new BigDecimal("1000.0"));

    sequence.addText("\n");

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    xmlHelper.save(quote, "http://www.example.com/mixed", "mixedOpenStockQuote", baos);
    assertTrue(TestUtil.equalXmlFiles(new ByteArrayInputStream(baos.toByteArray()), getClass().getResource(MIXEDOPEN_XML)));
  }

  
  public void testDefineOpenType() throws Exception 
  {
    TypeHelper types = hc.getTypeHelper();
    DataFactory factory = hc.getDataFactory();
    XMLHelper xmlHelper = hc.getXMLHelper();

    Type stringType = types.getType("commonj.sdo", "String");
    Type decimalType = types.getType("commonj.sdo", "Decimal");
    
    Property xmlElementProp = hc.getXSDHelper().getGlobalProperty("commonj.sdo/xml", "xmlElement", false);
    
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
    
    // Create CompanyType property - "name" as an XSD attribute
    DataObject nameProperty = companyType.createDataObject("property");
    nameProperty.set("name", "name");
    nameProperty.set("type", stringType);
    nameProperty.set("containment", Boolean.TRUE);
    nameProperty.setBoolean(xmlElementProp, false);
    
    types.define(companyType);
    
    // Define open content property - company
    DataObject symbolProperty = factory.create("commonj.sdo", "Property");
    symbolProperty.set("name", "symbol");
    symbolProperty.set("type", stringType);
    types.defineOpenContentProperty("http://www.example.com/open", symbolProperty);

    // Define open content property - company
    DataObject companyProperty = factory.create("commonj.sdo", "Property");
    companyProperty.set("name", "company");
    companyProperty.set("type", companyType);
    companyProperty.set("containment", Boolean.TRUE);
    types.defineOpenContentProperty("http://www.example.com/open", companyProperty);
    
    // Define open content property - price
    DataObject priceProperty = factory.create("commonj.sdo", "Property");
    priceProperty.set("name", "price");
    priceProperty.set("type", decimalType);
    types.defineOpenContentProperty("http://www.example.com/open", priceProperty);
    
    // Create DataObject instances
    DataObject openQuote = factory.create("http://www.example.com/open", "OpenQuote");
    assertTrue(openQuote.getType().isOpen());
    
    Property definedSymbolProperty = types.getOpenContentProperty("http://www.example.com/open", "symbol");
    openQuote.set(definedSymbolProperty, "s1");
    
    Property definedCompanyProperty = types.getOpenContentProperty("http://www.example.com/open", "company");
    DataObject company = openQuote.createDataObject(definedCompanyProperty);
    company.setString("name", "FlyByNightTechnology");
      
    Property definedPriceProperty = types.getOpenContentProperty("http://www.example.com/open", "price");
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
  
/**
 * Type T1 has property t1p of type T2, type T2 has property t2p of type T1.
 * Ensure that the typehelper can handle this circularity
 */
public void testInterdependentTypes()
  {
	    DataObject t1 = DataFactory.INSTANCE.create("commonj.sdo", "Type");
	    DataObject t1p = DataFactory.INSTANCE.create("commonj.sdo", "Property");
	    DataObject t2 = DataFactory.INSTANCE.create("commonj.sdo", "Type");
	    DataObject t2p = DataFactory.INSTANCE.create("commonj.sdo", "Property");

	    t1.set("name", "T1");
	    t1.set("uri", "foo");
	    t2.set("name", "T2");
	    t2.set("uri", "foo");
	    
	    t1.getList("property").add(t1p);
	    t2.getList("property").add(t2p);
	    t1p.set("name", "t1p");
	    t1p.set("type", t2);
	    t2p.set("name", "t2p");
	    t2p.set("type", t1);

	    List ts = new ArrayList();
	    ts.add(t1);
	    ts.add(t2);
	    List types = hc.getTypeHelper().define(ts);
	    
	    Type first = (Type)types.get(0);
	    Type second = (Type)types.get(1);
	    
	    Type firstsPropsType = ((Property)first.getProperties().get(0)).getType();
	    Type secondPropsType = ((Property)second.getProperties().get(0)).getType();
	    
	    assertNotNull(first);
	    assertNotNull(second);
	    assertEquals(first, secondPropsType);
	    assertEquals(second, firstsPropsType);
	    
  }
  
}
