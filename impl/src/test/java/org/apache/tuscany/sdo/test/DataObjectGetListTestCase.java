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


import java.io.IOException;
import java.util.List;

import org.apache.tuscany.sdo.api.SDOUtil;

import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;
import junit.framework.TestCase;

public class DataObjectGetListTestCase extends TestCase {
    private HelperContext hc;
    private DataObject companyDataObject;
    
    private final String TEST_NAMESPACE = "http://www.example.com/getList";

    private String xsdString =
    	"<xsd:schema " + 
    	  "xmlns:getList=\"http://www.example.com/getList\" " + 
    	  "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" " + 
    	  "targetNamespace=\"http://www.example.com/getList\">" + 
    	  
    	   "<xsd:element name=\"company\" type=\"getList:Company\"/>" +
    	   "<xsd:element name=\"employee\" type=\"xsd:string\"/>" +

    	   "<xsd:complexType name=\"Company\">" +
		       "<xsd:sequence>" +
		          "<xsd:element name=\"openCompany\" type=\"getList:OpenCompany\"/>" +
		          "<xsd:element name=\"closeCompany\" type=\"getList:CloseCompany\"/>" +
		       "</xsd:sequence>" +
		   "</xsd:complexType>" +
	   
    	   "<xsd:complexType name=\"OpenCompany\">" +
    	       "<xsd:sequence>" +
    	          "<xsd:element name=\"company\" type=\"xsd:string\"/>" +
    	          "<xsd:element name=\"employees\" maxOccurs=\"unbounded\" type=\"xsd:string\"/>" +
    	          "<xsd:any maxOccurs=\"unbounded\" namespace=\"##any\"/>" +
    	       "</xsd:sequence>" +
    	   "</xsd:complexType>" +
    	   
    	   "<xsd:complexType name=\"CloseCompany\">" +
		       "<xsd:sequence>" +
		          "<xsd:element name=\"company\" type=\"xsd:string\"/>" +
		          "<xsd:element name=\"employees\" maxOccurs=\"unbounded\" type=\"xsd:string\"/>" +
		       "</xsd:sequence>" +
		   "</xsd:complexType>" +

    	"</xsd:schema>";
    	
    /**
     * Test DataObject.getList() on open type
     */
    public void testUnknownPropertyOnOpenType() throws IOException {
    	String companyName = companyDataObject.getString("openCompany/company");
    	assertEquals(companyName, "OpenCompany");
    	List unknownProperty = companyDataObject.getList("openCompany/unknownProperty");
    	assertNotNull(unknownProperty);
    	assertTrue(unknownProperty instanceof List);
    	
    	List unknownProperty2 = companyDataObject.getList("openCompany/unknownProperty");
    	assertNotNull(unknownProperty2);
    	assertTrue(unknownProperty2 instanceof List);

    	// unknownProperty and unknownProperty2 are in fact the same value for the same property
    	
    	unknownProperty.add("employee1");
    	assertTrue(unknownProperty.size() == 1);
    	
    	unknownProperty2.add("employee2");
    	assertTrue(unknownProperty2.size() == 2);
    	   	
    	unknownProperty.remove(0);
    	assertTrue(unknownProperty.size() == 1);
    	
    	assertEquals(unknownProperty.get(0), "employee2");
    }
    
    /**
     * Test DataObject.getList() on non-open type
     */
    public void testUnknownPropertyOnClosedType() throws IOException {
    	String companyName = companyDataObject.getString("closeCompany/company");
    	assertEquals(companyName, "CloseCompany");
    	List unknownProperty = companyDataObject.getList("closeCompany/unknownProperty");
    	assertNotNull(unknownProperty);
    	assertTrue(unknownProperty instanceof List);

    	try {
    		unknownProperty.add("employee1");
    		fail("An exception should have been thrown.");
    	}
    	catch (Exception e) {
    	}
    }
    
    protected void setUp() throws Exception {
        super.setUp();

        hc = SDOUtil.createHelperContext();
        hc.getXSDHelper().define(xsdString);
        
        companyDataObject = hc.getDataFactory().create(TEST_NAMESPACE, "Company");
        DataObject openCompany = companyDataObject.createDataObject("openCompany");
        openCompany.setString("company", "OpenCompany");
        DataObject closeCompany = companyDataObject.createDataObject("closeCompany");
        closeCompany.setString("company", "CloseCompany");
    }
}
