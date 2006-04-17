package org.apache.tuscany.sdo.test;

import java.math.BigDecimal;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.util.SDOUtil;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XSDHelper;

public class DefineTypeTestCase extends TestCase 
{
  public void testDefineType() throws Exception 
  {
    TypeHelper types = SDOUtil.createTypeHelper();
    DataFactory factory = SDOUtil.createDataFactory(types);

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
  }
  
  public void testDefineDataType() throws Exception 
  {
    TypeHelper types = SDOUtil.createTypeHelper();
    DataFactory factory = SDOUtil.createDataFactory(types);
    XSDHelper xsdHelper = SDOUtil.createXSDHelper(types);
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
  }
  
  public void testFastDefineType() throws Exception 
  {
    TypeHelper types = SDOUtil.createTypeHelper();
    DataFactory factory = SDOUtil.createDataFactory(types);

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
  }
  
  public void testDefineOpenType() throws Exception 
  {
    TypeHelper types = SDOUtil.createTypeHelper();
    DataFactory factory = SDOUtil.createDataFactory(types);
    
    Type stringType = types.getType("commonj.sdo", "String");
    Type decimalType = types.getType("commonj.sdo", "Decimal");
    
    // Define a new open type - OpenQuote
    DataObject openQuoteType = factory.create("commonj.sdo", "Type");
    openQuoteType.set("uri", "http://www.example.com/open");
    openQuoteType.set("name", "OpenQuote");
    openQuoteType.set("open", Boolean.TRUE);
    openQuoteType.setBoolean("open", true);
    
    // create property - "symbol"
    DataObject symbolProperty = openQuoteType.createDataObject("property");
    symbolProperty.set("name", "symbol");
    symbolProperty.set("type", stringType);
    
    types.define(openQuoteType);
    
    // Define new type - CompanyType
    DataObject companyType = factory.create("commonj.sdo", "Type");
    companyType.set("uri", "http://www.example.com/open");
    companyType.set("name", "CompanyType");
    
    // Create CompanyType property - "name"
    DataObject nameProperty = companyType.createDataObject("property");
    nameProperty.set("name", "name");
    nameProperty.set("type", stringType);
    
    types.define(companyType);
    
    // Define a global type
    DataObject globalType = factory.create("commonj.sdo", "Type");
    globalType.set("uri", "http://www.example.com/open");
    // no need to specify the type's name
    
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
    
    openQuote.set("symbol", "s1");
    
    // Get global type
    Type definedGlobalType = types.getType("http://www.example.com/open", null);
    
    Property definedCompanyProperty = definedGlobalType.getProperty("company");
    
    DataObject company = openQuote.createDataObject(definedCompanyProperty);
    company.setString("name", "FlyByNightTechnology");
      
    Property definedPriceProperty = definedGlobalType.getProperty("price");
    openQuote.setBigDecimal(definedPriceProperty, new BigDecimal("1000.0"));
    
    assertEquals(definedPriceProperty.getType(), decimalType);   
  }
  
}
