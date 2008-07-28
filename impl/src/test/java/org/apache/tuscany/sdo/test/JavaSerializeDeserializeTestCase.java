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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.util.SDOUtil;

import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;

public class JavaSerializeDeserializeTestCase extends TestCase
{
	
    public void testScopeDefinedSerializeDeserializeOfDataObject()
    {
        HelperContext hc = SDOUtil.createHelperContext();
        Object originalDataObject = createDynamically(hc,true);
        
        runSerializeDeserialize((DataObject)originalDataObject, hc);
    }
        
    public void testScopeDefinedSerializeDeserializeOfDataGraph()
    {
        HelperContext hc = SDOUtil.createHelperContext();
        DataGraph testDO = (DataGraph)createDynamically(hc,false);
        
        runSerializeDeserializeWithDataGraph(testDO, hc);
    }
    
    private String xsdString = "<xsd:schema targetNamespace=\"http://www.example.com/simple\" " +
        "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" " + 
        "xmlns:simple=\"http://www.example.com/simple\">" +
        "<xsd:element name=\"company\" type=\"simple:Company\"/>" +
        "<xsd:complexType name=\"Company\">" +
        "<xsd:sequence>" +
        "<xsd:element name=\"symbol\" type=\"xsd:string\"/>" +
        "<xsd:element name=\"companyName\" type=\"xsd:string\"/>" +
        "<xsd:element name=\"employees\" type=\"simple:Employee\" minOccurs=\"0\" maxOccurs=\"unbounded\"/>" +
        "</xsd:sequence>" +
        "</xsd:complexType>" +
        
        "<xsd:complexType name=\"Employee\">" +
        "<xsd:sequence>" +
        "<xsd:element name=\"employeeID\" type=\"xsd:string\"/>" +
        "<xsd:element name=\"employeeName\" type=\"xsd:string\"/>" +
        "</xsd:sequence>" +
        "</xsd:complexType>" +       
        "</xsd:schema>";
    
    public void testLargePayload()
    {
        HelperContext hc = SDOUtil.createHelperContext();
        hc.getXSDHelper().define(xsdString);
        DataObject company = hc.getDataFactory().create("http://www.example.com/simple", "Company");
        company.setString("symbol", "EXAMPLE");
        company.setString("companyName", "Example Inc.");
        List employees = company.getList("employees");
        DataObject employee;
        for (int i=0; i<1000; i++) {
            employee = hc.getDataFactory().create("http://www.example.com/simple", "Employee");
            employee.setString("employeeID", "ID #" + i);
            employee.setString("employeeName", "Empoyee #" + i);
            employees.add(employee);
        }
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = SDOUtil.createObjectOutputStream(bos, hc);
            oos.writeObject(company);
            oos.flush();
            byte[] bytes = bos.toByteArray();
            oos.close();
            bos.close();
            
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = SDOUtil.createObjectInputStream(bis, hc);
            ois.readObject();
            ois.close();
            bis.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            fail("An Exception occurred while deserializing the output of the serialization: "  + e.toString());
        }
    }
	
        
    /**
     * Serialize the DataObject then Deserialize the output. 
     * to testDO.
     * @param testDO
     * @param scope 
     */
    
    public void runSerializeDeserialize(DataObject originalDataObject, HelperContext hc) 
    {    	
            
        populateFields(originalDataObject);
        DataObject tempDO = null;
        ByteArrayOutputStream baos = null;
        
        try
        {
            baos = serialize(originalDataObject, hc);
        
        }
        catch (Exception e)
        {
            e.printStackTrace();
            fail("An Exception occurred while serializing the DataObject: " + e.toString());    		
        }
        
        try
        {
            tempDO = deserialize(baos, hc);
        
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            fail("An Exception occurred while deserializing the output of the serialization: "  + e.toString());
        }      
        
        assertNotNull("Deserialization returned a null value.", tempDO);
        
        assertSame(tempDO.getType(), originalDataObject.getType());
            

    } 
    
    /**
     * Serialize the DataGraph
     * @param dataGraph
     * @param scope
     */
    public void runSerializeDeserializeWithDataGraph(DataGraph dataGraph, HelperContext hc) 
    {           
        DataObject originalDataObject = dataGraph.getRootObject();
        populateFields(originalDataObject);
        DataObject tempDO = null;
        ByteArrayOutputStream baos = null;
            
        try
        {
            baos = serialize(dataGraph, hc);
        
        }
        catch (Exception e)
        {
            e.printStackTrace();
            fail("An Exception occurred while serializing the DataObject: " + e.toString());                
        }
        
        try
        {
            tempDO = deserialize(baos, hc);
        
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            fail("An Exception occurred while deserializing the output of the serialization: "  + e.toString());
        }      
        
        assertNotNull("Deserialization returned a null value.", tempDO);
        
        assertSame(tempDO.getType(), originalDataObject.getType());
        
        
    
    }  

    /**
     * serializeDataObject is a private method to be called by the other methods
     * in the ScrenarioLibrary
     * 
     * @param dataObject
     * @param fileName
     * @throws IOException
     */
    public ByteArrayOutputStream serialize(Object object, HelperContext hc) throws IOException 
    {
        //FileOutputStream fos = new FileOutputStream("temp");
        ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
        ObjectOutputStream out = SDOUtil.createObjectOutputStream(byteArrayOutput, hc);
        out.writeObject(object);
        out.close();
        return byteArrayOutput;
    }

    /**
     * deserializeDataObject is a private method to be called by the other
     * methods in the ScrenarioLibrary
     * 
     * @param fileName
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public DataObject deserialize(ByteArrayOutputStream baos, HelperContext hc) throws IOException, ClassNotFoundException 
    {
        //FileInputStream fis = new FileInputStream("temp");
        ObjectInputStream input = null;
        ByteArrayInputStream byteArrayInput = new ByteArrayInputStream(baos.toByteArray());
        
        input = SDOUtil.createObjectInputStream(byteArrayInput, hc);
        
        Object object = input.readObject();
        input.close();
        if(object instanceof DataGraph)
            return ((DataGraph)object).getRootObject();
        else
            return (DataObject)object;
    }
    
    /**
     * populateFields uses set<Type> to set each of the fields in the
     * DataObject. It is used to ensure a known set of expected values that are
     * not other than the default values for the various fields.
     * 
     * @param testDO
     * @throws ExpectedConditionError
     */
    public static void populateFields(DataObject testDO) 
    {

        testDO.setString("stringVal", "Testing");

    }
    /**
     * createDynamically() creates the SDO Types using the TypeHelper.  This method should be kept in
     * synch with the XSD used for createDynamicallyWithStaticResources.  The same XSD is used for
     * the static generation of SDO Types using XSD2JavaGenerator.
     */
    public Object createDynamically(HelperContext hc, boolean createDataObject)
    {
        
        TypeHelper types = hc.getTypeHelper();
        DataFactory dataFactory = hc.getDataFactory();
    
    	Type stringType = types.getType("commonj.sdo", "String");
        
    	DataObject testType = dataFactory.create("commonj.sdo", "Type");
    	testType.set("uri", "http://www.example.com/api_test");
    	testType.set("name", "APITest");
    	
        DataObject stringProperty = testType.createDataObject("property");
        stringProperty.set("name", "stringVal");
        stringProperty.set("type", stringType);
        
           
        List types2Define = new ArrayList();
        types2Define.add(testType);
        List apiXSD = types.define(types2Define);
        Type apiXSDType = (Type) apiXSD.get(0);
        
        if(createDataObject)
            return dataFactory.create(apiXSDType);;
        
        // Create an empty DataGraph and attach the document root to it. Otherwise, where is the documentRoot ?
        DataGraph dataGraph = SDOUtil.createDataGraph();
        /*DataObject testDO =*/ dataGraph.createRootObject(apiXSDType);
        
        
        return dataGraph;
        
    }
}
