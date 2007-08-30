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
import java.io.InputStream;
import java.net.URL;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.api.SDOUtil;

import com.example.extensible.customer.CustomerFactory;
import com.example.extensible.customer.CustomersType;
import com.example.extensible.customer.InfoType;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLDocument;

public class ExtensibleTestCase extends TestCase {

	private final String[] MODELS = new String[] {
			"/extensible/nonamespace.xsd", 
			"/extensible/infostreet.xsd", 
			"/extensible/infozipcode.xsd"
	};
    
  private final String CUSTOMERS_XML = "/extensible/customers.xml";
  private final String INFOSTREET_XML = "/extensible/infostreet.xml";
  private final String INFOZIPCODE_XML = "/extensible/infozipcode.xml";

	private HelperContext scope;

	public void testCustomersLoad() throws IOException {
		XMLDocument doc = scope.getXMLHelper().load(
		    getClass().getResourceAsStream(CUSTOMERS_XML));
		assertEquals("customers", doc.getRootElementName());
		assertTrue("RootObject of " + CUSTOMERS_XML + " should be instanceof CustomersType", 
				doc.getRootObject() instanceof CustomersType);
		String strdoc = scope.getXMLHelper().save(
				doc.getRootObject(), doc.getRootElementURI(), doc.getRootElementName());
		assertTrue(strdoc.indexOf("<street>341 Duckworth Way</street>") != -1);
	}

	public void testInfoLoad() throws IOException {
		String[] infoXmls = new String[] {INFOSTREET_XML, INFOZIPCODE_XML};
		for (int i = 0; i < infoXmls.length; i++) {
			String infoXml = infoXmls[i];
			XMLDocument doc = scope.getXMLHelper().load(
			    getClass().getResourceAsStream(infoXml));
			assertEquals("info", doc.getRootElementName());
			assertTrue("RootObject of " + infoXml + " should be instanceof InfoType", 
					doc.getRootObject() instanceof InfoType);
			String strdoc = scope.getXMLHelper().save(
					doc.getRootObject(), doc.getRootElementURI(), doc.getRootElementName());
			String elementName = (i == 0) ? "street" : "zipcode";
			String valuePrefix = "21043";
			assertTrue(strdoc.indexOf("<" + elementName + ">") != -1);
			assertTrue(strdoc.indexOf("</" + elementName + ">") != -1);
			assertTrue(strdoc.indexOf(">" + valuePrefix) != -1);
		}
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		scope = SDOUtil.createHelperContext();

		CustomerFactory.INSTANCE.register(scope);
		
        // Populate the meta data for the models
		for (int i = 0; i < MODELS.length; i++) {
			String model = MODELS[i];
	        URL url = getClass().getResource(model);
	        InputStream inputStream = url.openStream();
	        scope.getXSDHelper().define(inputStream, url.toString());
	        inputStream.close();
		}
	}

}
