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
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.api.SDOUtil;

import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLDocument;

public class SerializeTypesTestCase extends TestCase {

    HelperContext hc;
  
    protected void setUp() throws Exception {
        super.setUp();
        hc = SDOUtil.createHelperContext();
    }
    
    public void testSerializeTypesRoundTrip() throws Exception {
        TypeHelper types = hc.getTypeHelper();
        DataFactory factory = hc.getDataFactory();

        Type intType = types.getType("commonj.sdo", "Int");
        Type stringType = types.getType("commonj.sdo", "String");

        // create a new Type for Addresses
        DataObject addressType = factory.create("commonj.sdo", "Type");
        addressType.set("uri", "http://example.com/address");
        addressType.set("name", "Address");

        // create a address street property
        DataObject addrStProperty = addressType.createDataObject("property");
        addrStProperty.set("name", "addrSt");
        addrStProperty.set("type", stringType);

        // create a new Type for Customers
        DataObject customerType = factory.create("commonj.sdo", "Type");
        customerType.set("uri", "http://example.com/customer");
        customerType.set("name", "Customer");

        // create a customer number property
        DataObject custNumProperty = customerType.createDataObject("property");
        custNumProperty.set("name", "custNum");
        custNumProperty.set("type", intType);

        // create a first name property
        DataObject firstNameProperty = customerType.createDataObject("property");
        firstNameProperty.set("name", "firstName");
        firstNameProperty.set("type", stringType);

        // create a last name property
        DataObject lastNameProperty = customerType.createDataObject("property");
        lastNameProperty.set("name", "lastName");
        lastNameProperty.set("type", stringType);

        // create an address property
        DataObject addressProperty = customerType.createDataObject("property");
        addressProperty.set("name", "address");
        addressProperty.set("type", addressType);
        addressProperty.setBoolean("containment", true);

        // now define the Address and Customer type so that addresses and customers can be made
        List types2define = new ArrayList();
        types2define.add(addressType);
        types2define.add(customerType);
        List typesDefined = types.define(types2define);

        // Create an empty data graph and add a root object, an instance of customerType
        //

        DataGraph dataGraph = SDOUtil.createDataGraph();
        Type customerTypeDefined = (Type) typesDefined.get(1);
        DataObject customer1 = dataGraph.createRootObject(customerTypeDefined);

        customer1.setInt("custNum", 1);
        customer1.set("firstName", "John");
        customer1.set("lastName", "Adams");
        DataObject address = customer1.createDataObject("address");
        address.set("addrSt", "577 Airport Blvd");

        SDOUtil.registerDataGraphTypes(dataGraph, typesDefined);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        SDOUtil.saveDataGraph(dataGraph, baos, null);
        //SDOUtil.saveDataGraph(dataGraph, System.out, null);

        byte[] serialized = baos.toByteArray();
        ByteArrayInputStream bais = new ByteArrayInputStream(serialized);
        DataGraph loadedDataGraph = SDOUtil.loadDataGraph(bais, null, hc);

        DataObject loadedRootObject = loadedDataGraph.getRootObject();
        assertNotSame(loadedRootObject.getType(), customer1.getType());

        // EqualityHelper requires same Type
        assertEquals(loadedRootObject.getInt("custNum"), customer1.getInt("custNum"));
        assertEquals(loadedRootObject.get("firstName"), customer1.get("firstName"));
        assertEquals(loadedRootObject.get("lastName"), customer1.get("lastName"));
        DataObject loadedAddress = loadedRootObject.getDataObject("address");
        assertEquals(loadedAddress.get("addrSt"), address.get("addrSt"));
    }
    
    private String xsdString =
        "<xsd:schema targetNamespace=\"http://www.example.com/simple\" " +
            "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" " + 
            "xmlns:simple=\"http://www.example.com/simple\"> " + 
            "<xsd:element name=\"bytesTypeTest\" type=\"simple:BytesTypeTest\"/> " +
            "<xsd:complexType name=\"BytesTypeTest\"> " +
                "<xsd:sequence> " +
                    "<xsd:element name=\"base64Binary\" type=\"xsd:base64Binary\"/> " +
                    "<xsd:element name=\"hexBinary\" type=\"xsd:hexBinary\"/> " +
                "</xsd:sequence> " +
            "</xsd:complexType> " +
        "</xsd:schema>";

    
    private String testString = "Hello World";
    private String testStringInBase64 = "SGVsbG8gV29ybGQ=";
    private String testStringInHex = "48656C6C6F20576F726C64";
    
    public void testSerializeXSDBase64BinaryRoundTrip() throws Exception {
        hc.getXSDHelper().define(xsdString);
        
        DataObject typeTest = hc.getDataFactory().create("http://www.example.com/simple", "BytesTypeTest");
        typeTest.setBytes("base64Binary", testString.getBytes());
        
        String output = hc.getXMLHelper().save(typeTest, typeTest.getType().getURI(), "bytesTypeTest");
        
        String startTag = "<base64Binary>";
        String endTag = "</base64Binary>";
        int start = output.indexOf(startTag) + startTag.length();
        int end = output.indexOf(endTag);
        
        String value = output.substring(start, end);
        assertEquals(testStringInBase64, value);
        
        XMLDocument xmlDoc = hc.getXMLHelper().load(output);
        typeTest = xmlDoc.getRootObject();
        assertEquals(testString, new String(typeTest.getBytes("base64Binary")));
    }
    
    public void testSerializeXSDHexBinaryRoundTrip() throws Exception {
        hc.getXSDHelper().define(xsdString);
        
        DataObject typeTest = hc.getDataFactory().create("http://www.example.com/simple", "BytesTypeTest");
        typeTest.setBytes("hexBinary", testString.getBytes());
        
        String output = hc.getXMLHelper().save(typeTest, typeTest.getType().getURI(), "bytesTypeTest");
        
        String startTag = "<hexBinary>";
        String endTag = "</hexBinary>";
        int start = output.indexOf(startTag) + startTag.length();
        int end = output.indexOf(endTag);
        
        String value = output.substring(start, end);
        assertEquals(testStringInHex, value);
        
        XMLDocument xmlDoc = hc.getXMLHelper().load(output);
        typeTest = xmlDoc.getRootObject();
        assertEquals(testString, new String(typeTest.getBytes("hexBinary")));
    }
}
