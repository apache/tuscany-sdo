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


import java.io.*;
import java.math.BigDecimal;
import java.net.URL;

import javax.xml.stream.*;

import org.apache.tuscany.sdo.api.XMLStreamHelper;
import org.apache.tuscany.sdo.api.SDOUtil;

import junit.framework.TestCase;

import commonj.sdo.*;
import commonj.sdo.helper.*;


public class XMLStreamHelperPerformanceTestCase extends TestCase {
    private final String TEST_MODEL = "/XMLStreamHelper.xsd";
    private final String TEST_NAMESPACE = "http://www.example.com/simple";

    HelperContext hc;
    
    /**
     * Simple Dynamic SDO 2 test.
     */
    public void testDynamic() throws Exception {
        final TypeHelper typeHelper = hc.getTypeHelper();
        final Type quoteType = typeHelper.getType(TEST_NAMESPACE, "Quote");
        final DataObject quote = hc.getDataFactory().create(quoteType);

        quote.setString("symbol", "fbnt");
        quote.setString("companyName", "FlyByNightTechnology");
        quote.setBigDecimal("price", new BigDecimal("1000.0"));
        quote.setBigDecimal("open1", new BigDecimal("1000.0"));
        quote.setBigDecimal("high", new BigDecimal("1000.0"));
        quote.setBigDecimal("low", new BigDecimal("1000.0"));
        quote.setDouble("volume", 1000);
        quote.setDouble("change1", 1000);

        final DataObject child = quote.createDataObject("quotes");
        child.setBigDecimal("price", new BigDecimal("2000.0"));
        
        final DataObject quote3 = quote.createDataObject("quotes3");
        quote3.setString("symbol3", "IBM");
        quote3.setString("company3", "IBM Corp.");
        
        final XMLStreamHelper streamHelper = SDOUtil.createXMLStreamHelper(hc);
        final XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        final StringWriter writer = new StringWriter();
        final XMLStreamWriter streamWriter = outputFactory.createXMLStreamWriter(writer);
        
        final XMLDocument doc = hc.getXMLHelper().createDocument(quote, TEST_NAMESPACE, "stockQuote");
        streamHelper.save(doc, streamWriter);
        streamWriter.flush();
        assertEquals("<p0:stockQuote xmlns:p0=\"http://www.example.com/simple\" xmlns:p1=\"http://www.example.com/simple3\"><p0:symbol>fbnt</p0:symbol><p0:companyName>FlyByNightTechnology</p0:companyName><p0:price>1000.0</p0:price><p0:open1>1000.0</p0:open1><p0:high>1000.0</p0:high><p0:low>1000.0</p0:low><p0:volume>1000.0</p0:volume><p0:change1>1000.0</p0:change1><p0:quotes><p0:price>2000.0</p0:price></p0:quotes><p0:quotes3><p1:symbol3>IBM</p1:symbol3><p1:company3>IBM Corp.</p1:company3></p0:quotes3></p0:stockQuote>",writer.toString());
    }
    
    protected void setUp() throws Exception {
        super.setUp();
        hc = SDOUtil.createHelperContext();

        // Populate the meta data for the test (Stock Quote) model
        final URL url = getClass().getResource(TEST_MODEL);
        final InputStream inputStream = url.openStream();
        hc.getXSDHelper().define(inputStream, url.toString());
        inputStream.close();

    }

}
