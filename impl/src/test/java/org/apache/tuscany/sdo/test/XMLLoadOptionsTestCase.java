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
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.SDOPackage;
import org.apache.tuscany.sdo.api.SDOHelper;
import org.apache.tuscany.sdo.api.SDOUtil;
import org.apache.tuscany.sdo.api.XMLStreamHelper;
import org.eclipse.emf.ecore.resource.Resource;

import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XMLHelper;

public class XMLLoadOptionsTestCase extends TestCase {
    XMLHelper xmlHelper;
    Map options;
    
    protected void setUp() throws Exception {
        super.setUp();
    }
    
	//SDOUtil->SDOHelper->SDOHelperImpl->HelperContextImpl->XMLHelperImpl
    public void testXMLOptionsSchema1() throws IOException{
    	final String TEST_XML_DOCUMENT = "/SchemaLocationTestCase.xml";
    	
    	options = new HashMap();
    	options.put(SDOHelper.XMLOptions.XML_LOAD_SCHEMA, Boolean.TRUE);
    	
    	final XMLHelper xmlHelper = SDOUtil.createHelperContext(true, options).getXMLHelper();
    	
    	final XMLDocument xmlDoc = xmlHelper.load(getClass().getResourceAsStream(TEST_XML_DOCUMENT), "whatever", null);
    	final DataObject root = xmlDoc.getRootObject();
        assertNotSame(root.getType(), SDOPackage.eINSTANCE.getAnyTypeDataObject());   
    }
    
//  SDOUtil->SDOHelper->SDOHelperImpl->HelperContextImpl->XMLHelperImpl
    public void testXMLOptionsSchema2() throws IOException{
    	final String TEST_XML_DOCUMENT = "/SchemaLocationTestCase.xml";
    	
    	options = new HashMap();
    	options.put(SDOHelper.XMLOptions.XML_LOAD_SCHEMA, Boolean.FALSE);
    	final XMLHelper xmlHelper = SDOUtil.createHelperContext(true, options).getXMLHelper();
    	final XMLDocument xmlDoc = xmlHelper.load(getClass().getResourceAsStream(TEST_XML_DOCUMENT), "whatever", null);
    	final DataObject root = xmlDoc.getRootObject();
        assertSame(root.getType(), SDOPackage.eINSTANCE.getAnyTypeDataObject());    
    }
    
    public void testXMLOptionsLax1() throws IOException{
    	options = new HashMap();
    	/*
         * turn off default behaviour of tolerating malformed xml
         * tests using this option and bad xml should demonstrate failure to load
         */
    	options.put(SDOHelper.XMLOptions.XML_LOAD_LAX_FORM, new Integer(0));
    	final HelperContext hc = SDOUtil.createHelperContext(true, options);
        hc.getXSDHelper().define(
        		"<schema xmlns=\"http://www.w3.org/2001/XMLSchema\" targetNamespace=\"testNS\">"+
        		  "<element name=\"root\">"+
        		    "<complexType>"+
        		      "<sequence>"+
        		        "<element name=\"unqualifiedElement\" type=\"string\"/>"+
        		        "<element name=\"qualifiedElement\" form=\"qualified\" type=\"string\"/>"+
        		      "</sequence>"+
        		      "<attribute name=\"unqualifiedAttribute\" type=\"string\"/>"+
        		      "<attribute name=\"qualifiedAttribute\" form=\"qualified\" type=\"string\"/>"+
        		    "</complexType>"+
        		  "</element>"+
        		"</schema>");   	

        final String xml="<p:root xmlns:p=\"testNS\">"+
  "<p:unqualifiedElement/>"+
"</p:root>";

        /*
         * this malformed xml will not load, as lax is forced OFF
         * changing p:unqualifiedElement to unqualifiedElement 
         * will work */
      try{
        hc.getXMLHelper().load(new StringReader(xml), null, null);
       fail();
    } catch (final Resource.IOWrappedException featureNotFound) {
    	assertTrue(true);
    }
    
    }
    
    public void testXMLOptionsLax2() throws IOException{
    	options = new HashMap();
    	/*
         * turn on default behaviour of tolerating malformed xml
         * tests using this option and bad xml will load
         */
    	options.put(SDOHelper.XMLOptions.XML_LOAD_LAX_FORM, new Integer(1));
    	final HelperContext hc = SDOUtil.createHelperContext(true, options);
        hc.getXSDHelper().define(
        		"<schema xmlns=\"http://www.w3.org/2001/XMLSchema\" targetNamespace=\"testNS\">"+
        		"<element name=\"root\">"+
        		"<complexType>"+
        		  "<sequence>"+
        		    "<element name=\"unqualifiedElement\" type=\"string\"/>"+
        		    "<element name=\"qualifiedElement\" form=\"qualified\" type=\"string\"/>"+
        		  "</sequence>"+
        		  "<attribute name=\"unqualifiedAttribute\" type=\"string\"/>"+
        		  "<attribute name=\"qualifiedAttribute\" form=\"qualified\" type=\"string\"/>"+
        		"</complexType>"+
        		"</element>"+
        		"</schema>");    	

        final String xml="<p:root xmlns:p=\"testNS\" p:unqualifiedAttribute=\"u\" qualifiedAttribute=\"q\">"+
        "<p:unqualifiedElement/>"+
        "<qualifiedElement/>"+
      "</p:root>";

        /*
         * this malformed xml will load, as lax is forced ON
         */
       assertNotNull(hc.getXMLHelper().load(new StringReader(xml), null, null).getRootObject());    	
    }
   
    //SDOUtil->SDOHelper->SDOHelperImpl->XMLStreamHelperImpl->XMLDocumentImpl
    public void testXMLStreamHelper() throws IOException, XMLStreamException{
    	options = new HashMap();
    	/*
         * turn off default behaviour of tolerating malformed xml
         * tests using this option and bad xml will load
         */
    	options.put(SDOHelper.XMLOptions.XML_LOAD_LAX_FORM, new Integer(1));
    	final HelperContext hc = SDOUtil.createHelperContext(false, options);
        final XMLStreamHelper streamHelper = SDOUtil.createXMLStreamHelper(hc);
        hc.getXSDHelper().define(
        "<schema xmlns=\"http://www.w3.org/2001/XMLSchema\" targetNamespace=\"testNS\">"+
		"<element name=\"root\">"+
		"<complexType>"+
		  "<sequence>"+
		    "<element name=\"unqualifiedElement\" type=\"string\"/>"+
		    "<element name=\"qualifiedElement\" form=\"qualified\" type=\"string\"/>"+
		  "</sequence>"+
		  "<attribute name=\"unqualifiedAttribute\" type=\"string\"/>"+
		  "<attribute name=\"qualifiedAttribute\" form=\"qualified\" type=\"string\"/>"+
		"</complexType>"+
		"</element>"+
		"</schema>");
        
        final String xml="<p:root xmlns:p=\"testNS\" p:unqualifiedAttribute=\"u\" qualifiedAttribute=\"q\">"+
        "<p:unqualifiedElement/>"+
        "<qualifiedElement/>"+
      "</p:root>";
        
        final XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        final XMLStreamReader reader1 = inputFactory.createXMLStreamReader(new StringReader(xml));
        int event = reader1.getEventType();
        while (!(event == XMLStreamConstants.START_ELEMENT)){
        	event = reader1.next();
        }
        final DataObject dataObject = streamHelper.loadObject(reader1);
        /*
         * this malformed xml will load, as lax is forced ON
         */
       assertNotNull(dataObject);        
    }     
}
