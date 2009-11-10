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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;
import java.util.HashMap;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.api.SDOHelper;
import org.apache.tuscany.sdo.api.SDOUtil;
import org.apache.tuscany.sdo.api.XMLStreamHelper;

import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;

public class XMLSaveOptionsTestCase extends TestCase {
	  HelperContext hc;
	  private XSDHelper xsdHelper;
	  XMLHelper xmlh;
	  XMLStreamHelper xmlStreamHelper;
	  static final String INDENT = " ", MARGIN = " ", LINE_BREAK = "\n";
	  String formatted1 = 	MARGIN+  "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"  +LINE_BREAK+
		MARGIN+  "<cs:stockQuote xmlns:cs=\"http://www.example.com/simpleCS\">"  +LINE_BREAK+
		MARGIN+INDENT+  "<symbol>FBNT</symbol>"  +LINE_BREAK+
		MARGIN+INDENT+  "<companyName>FlyByNightTechnology</companyName>"  +LINE_BREAK+
		MARGIN+INDENT+  "<price>999.0</price>"  +LINE_BREAK+
		MARGIN+INDENT+  "<volume>1000.0</volume>"  +LINE_BREAK+
		MARGIN+INDENT+  "<quotes>"  +LINE_BREAK+
		MARGIN+INDENT+INDENT+  "<price>1500.0</price>"  +LINE_BREAK+
		MARGIN+INDENT+  "</quotes>"  +LINE_BREAK+
		MARGIN+INDENT+  "<quotes>"  +LINE_BREAK+
		MARGIN+INDENT+INDENT+  "<price>2500.0</price>"  +LINE_BREAK+
		MARGIN+INDENT+  "</quotes>"  +LINE_BREAK+
		MARGIN+INDENT+  "<quotes>"  +LINE_BREAK+
		MARGIN+INDENT+INDENT+  "<price>3000.0</price>"  +LINE_BREAK+
		MARGIN+INDENT+  "</quotes>"  +LINE_BREAK+
		MARGIN+INDENT+  "<quotes>"  +LINE_BREAK+
		MARGIN+INDENT+INDENT+  "<price>4000.0</price>"  +LINE_BREAK+
		MARGIN+INDENT+  "</quotes>"  +LINE_BREAK+
		MARGIN+INDENT+  "<changes create=\"#//quotes[3] #//quotes[4]\" delete=\"#//changes/stockQuote[1]/quotes[2]\" logging=\"false\" xmlns:sdo=\"commonj.sdo\">"  +LINE_BREAK+
		MARGIN+INDENT+INDENT+  "<cs:stockQuote sdo:ref=\"#/stockQuote\" sdo:unset=\"volume\">"  +LINE_BREAK+
		MARGIN+INDENT+INDENT+INDENT+  "<symbol>fbnt</symbol>"  +LINE_BREAK+
		MARGIN+INDENT+INDENT+INDENT+  "<price>1000.0</price>"  +LINE_BREAK+
		MARGIN+INDENT+INDENT+INDENT+  "<quotes sdo:ref=\"#//quotes[1]\" />"  +LINE_BREAK+
		MARGIN+INDENT+INDENT+INDENT+  "<quotes><price>2000.0</price><quotes><price>2000.99</price></quotes></quotes>"  +LINE_BREAK+
		MARGIN+INDENT+INDENT+INDENT+  "<quotes sdo:ref=\"#//quotes[2]\" />"  +LINE_BREAK+
		MARGIN+INDENT+INDENT+  "</cs:stockQuote>"  +LINE_BREAK+
		MARGIN+INDENT+  "</changes>"  +LINE_BREAK+
		MARGIN+  "</cs:stockQuote>";
		  
	  String formatted2 = 	
	   //MARGIN+ "<?xml version=\"1.0\" encoding=\"ASCII\"?>"  +LINE_BREAK+
	   MARGIN+ "<p0:stockQuote xmlns:p0=\"http://www.example.com/simple\">"  +LINE_BREAK+
	   MARGIN+INDENT+"<symbol>fbnt</symbol>"  +LINE_BREAK+
	   MARGIN+INDENT+"<companyName>FlyByNightTechnology</companyName>"  +LINE_BREAK+
	   MARGIN+INDENT+"<price>1000.0</price>"  +LINE_BREAK+
	   MARGIN+INDENT+"<open1>1000.0</open1>"  +LINE_BREAK+
	   MARGIN+INDENT+"<high>1000.0</high>"  +LINE_BREAK+
	   MARGIN+INDENT+"<low>1000.0</low>"  +LINE_BREAK+
	   MARGIN+INDENT+"<volume>1000.0</volume>"  +LINE_BREAK+
	   MARGIN+INDENT+"<change1>1000.0</change1>"  +LINE_BREAK+
	   MARGIN+"</p0:stockQuote>"		    +LINE_BREAK;
	  	  
	  void define(final String model) throws IOException {
	    // Populate the meta data for the test model
	    final URL url = getClass().getResource(model);
	    xsdHelper.define(url.openStream(), url.toString());
	  }
	  
	  protected void setUp() throws Exception {
	    super.setUp();
	  }

	  protected void tearDown() throws Exception {
	    super.tearDown();
	  }

	  //use XMLHelper
	  public void testSaveXMLDocumentXMLHelper() throws IOException {
		    final HashMap options = new HashMap();
		    options.put(org.apache.tuscany.sdo.api.SDOHelper.XMLOptions.XML_SAVE_INDENT, INDENT);
		    options.put(org.apache.tuscany.sdo.api.SDOHelper.XMLOptions.XML_SAVE_MARGIN, MARGIN);
		    options.put(org.apache.tuscany.sdo.api.SDOHelper.XMLOptions.XML_SAVE_LINE_BREAK, LINE_BREAK);
		    hc = SDOUtil.createHelperContext(false,options);
		    xsdHelper = hc.getXSDHelper();
		    xmlh = hc.getXMLHelper();
  
		    // Populate the meta data for the test (Stock Quote) model
		    define("/simpleWithChangeSummary.xsd");
		    final XMLDocument doc = xmlh.load(getClass().getResource("/simpleWithChangeSummary.xml").openStream());
		    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    xmlh.save(xmlh.createDocument(doc.getRootObject(), doc.getRootElementURI(), doc.getRootElementName()), baos, null);
		    assertEquals(formatted1, baos.toString());
	  }
	  
	  //use XMLStreamHelper
	  public void testSaveXMLDocumentXMLStreamHelper() throws Exception {	  
		  	final HashMap options = new HashMap();
		    options.put(SDOHelper.XMLOptions.XML_LOAD_SCHEMA, Boolean.FALSE);
		    options.put(org.apache.tuscany.sdo.api.SDOHelper.XMLOptions.XML_SAVE_INDENT, INDENT);
		    options.put(org.apache.tuscany.sdo.api.SDOHelper.XMLOptions.XML_SAVE_MARGIN, MARGIN);
		    options.put(org.apache.tuscany.sdo.api.SDOHelper.XMLOptions.XML_SAVE_LINE_BREAK, LINE_BREAK);
		    final HelperContext hc = SDOUtil.createHelperContext(false, options);
                    xmlStreamHelper = SDOUtil.createXMLStreamHelper(hc);
		    
		    xsdHelper = hc.getXSDHelper();
			define("/simple.xsd");
	  	
			final InputStream inStrm = getClass().getResourceAsStream("/shallowquote.xml");
		    final XMLDocument document = hc.getXMLHelper().load(inStrm, null, null);
		    
		    final XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();	    
	        final StringWriter writer = new StringWriter();
	        final XMLStreamWriter streamWriter = outputFactory.createXMLStreamWriter(writer);
	        
	        xmlStreamHelper.save(document, streamWriter, null);
	        streamWriter.flush();
	        assertEquals(formatted2, writer.toString());	
	  }      
}
