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
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.util.SDOUtil;

import commonj.sdo.ChangeSummary;
import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.HelperContext;

public class ChangeSummaryPropertyTestCase extends TestCase {
    private final String TEST_MODEL = "/simpleWithChangeSummary.xsd";
    private final String TEST_NAMESPACE = "http://www.example.com/simpleCS";

    private final String TEST_DATA_BEFORE_UNDO = "/simpleWithChangeSummary.xml";
    private final String TEST_DATA_AFTER_UNDO = "/simpleWithChangeSummaryUndone.xml";
    
    HelperContext hc;
    
    /**
     * Simple ChangeSummary property test.
     */
    public void testChangeSummary() throws Exception {
        Type quoteType = hc.getTypeHelper().getType(TEST_NAMESPACE, "RootQuote");
        DataObject quote = hc.getDataFactory().create(quoteType);
        
        ChangeSummary cs = quote.getChangeSummary();
        ChangeSummary csp = (ChangeSummary)quote.get("changes");

        assertSame(cs, csp);

        quote.setString("symbol", "fbnt");
        quote.setString("companyName", "FlyByNightTechnology");
        quote.setBigDecimal("price", new BigDecimal("1000.0"));
        DataObject child = quote.createDataObject("quotes");
        child.setBigDecimal("price", new BigDecimal("1500.0"));
        child = quote.createDataObject("quotes");
        child.setBigDecimal("price", new BigDecimal("2000.0"));
        child = quote.createDataObject("quotes");
        child.setBigDecimal("price", new BigDecimal("2500.0"));

        // Begin logging changes
        //
        cs.beginLogging();

        // Modify the data graph in various ways
        //
        quote.setString("symbol", "FBNT");
        quote.setBigDecimal("price", new BigDecimal("999.0"));
        quote.setDouble("volume", 1000);

        child = quote.createDataObject("quotes");
        child.setBigDecimal("price", new BigDecimal("3000.0"));
        child = quote.createDataObject("quotes");
        child.setBigDecimal("price", new BigDecimal("4000.0"));

        quote.getDataObject("quotes[2]").delete();

        // Stop logging changes and serialize the resulting data graph
        //
        cs.endLogging();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        hc.getXMLHelper().save(quote, TEST_NAMESPACE, "stockQuote", baos);
        //hc.getXMLHelper().save(quote, TEST_NAMESPACE, "stockQuote", System.out);

        //assertTrue(TestUtil.equalXmlFiles(new ByteArrayInputStream(baos.toByteArray()), getClass().getResource(TEST_DATA_BEFORE_UNDO)));
        
        // Undo all changes and then serialize the resulting data graph again
        //
        cs.undoChanges();
        
        baos = new ByteArrayOutputStream();
        hc.getXMLHelper().save(quote, TEST_NAMESPACE, "stockQuote", baos);
        //hc.getXMLHelper().save(quote, TEST_NAMESPACE, "stockQuote", System.out);
        
        //assertTrue(TestUtil.equalXmlFiles(new ByteArrayInputStream(baos.toByteArray()), getClass().getResource(TEST_DATA_AFTER_UNDO)));
    }

    protected void setUp() throws Exception {
        super.setUp();
        hc = SDOUtil.createHelperContext();

        // Populate the meta data for the test (Stock Quote) model
        URL url = getClass().getResource(TEST_MODEL);
        InputStream inputStream = url.openStream();
        hc.getXSDHelper().define(inputStream, url.toString());
        inputStream.close();
    }
}
