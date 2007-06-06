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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.TestCase;

import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLDocument;
import org.apache.tuscany.sdo.api.SDOUtil;

public class XSDQNameTestCase extends TestCase {
    private final String xsdString =
        "<xsd:schema targetNamespace=\"http://www.example.com/simple\" " +
        "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" " + 
        "xmlns:simple=\"http://www.example.com/simple\"> " +   
            "<xsd:element name=\"stockQuote\" type=\"simple:Quote\"/> " +
            "<xsd:complexType name=\"Quote\"> " +
                "<xsd:sequence> " +
                    "<xsd:element name=\"symbol\" type=\"xsd:string\"/> " +
                    "<xsd:element name=\"policy\" type=\"xsd:QName\"/> " +
                "</xsd:sequence> " +
            "</xsd:complexType> " +
        "</xsd:schema>";
  
    private final String xmlString =
        "<?xml version=\"1.0\" encoding=\"ASCII\"?> " +
        "<simple:stockQuote xmlns:simple=\"http://www.example.com/simple\"> " +
            "<symbol>fbnt</symbol> " +
            "<policy>simple:stockQuote</policy> " +
        "</simple:stockQuote>";
    
    private final String TEST_NAMESPACE = "http://www.example.com/simple";
    
    HelperContext hc;
    TypeHelper th;

    /**
     * Based on Spec 2.1, section 9.4.1, the return value of DataObject.get() on XSD QName property
     * should be http://www.example.com/simple#stockQuote
     * TODO add this to the CTS
     * 
     * @throws IOException
     */
    public void testLoad() throws IOException {
        XMLDocument doc = hc.getXMLHelper().load(xmlString);
        DataObject root = doc.getRootObject();
        assertEquals("http://www.example.com/simple#stockQuote", root.get("policy"));
    }
    
    /**
     * After serialization, the value of XSD QName property in XML should be <prefix>:stockQuote
     */
    public void testSave() throws IOException {
        Type quoteType = th.getType(TEST_NAMESPACE, "Quote");
        DataObject quote = hc.getDataFactory().create(quoteType);

        quote.setString("symbol", "fbnt");
        quote.set("policy", "http://www.example.com/simple#stockQuote");

        String str = hc.getXMLHelper().save(quote, TEST_NAMESPACE, "stockQuote");
        int start = str.indexOf("<policy>");
        int end = str.indexOf("</policy>");
        assertTrue(start != -1 && end != -1);
        
        String policyValue = str.substring(start + "<policy>".length(), end);
        
        Pattern pattern = Pattern.compile(".*:stockQuote");     // prefix can be anything
        
        Matcher matcher = pattern.matcher(policyValue);
        assertTrue(matcher.find());
    }
    
    /**
     * Test the scenario that the xsd:QName property value contains non-existent namespace
     */
    public void testSave2() throws IOException {
        Type quoteType = th.getType(TEST_NAMESPACE, "Quote");
        DataObject quote = hc.getDataFactory().create(quoteType);

        quote.setString("symbol", "fbnt");
        quote.set("policy", "http://www.example.com/simple2#stockQuote");

        String str = hc.getXMLHelper().save(quote, TEST_NAMESPACE, "stockQuote");
        
        // Make sure the non-existent namespace was serialized
        Pattern pattern = Pattern.compile(".*xmlns:.*=\"http://www.example.com/simple2\"");
        Matcher matcher = pattern.matcher(str);
        assertTrue(matcher.find());
    }

    protected void setUp() throws Exception {
        super.setUp();
        
        hc = SDOUtil.createHelperContext();
        th = hc.getTypeHelper();
        
        hc.getXSDHelper().define(xsdString);
    }
}
