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

import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;

import junit.framework.TestCase;

import commonj.sdo.ChangeSummary;
import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;

public class ChangeSummaryPropertyTestCase extends TestCase {
    private final String TEST_MODEL = "/simpleWithChangeSummary.xsd";
    private final String TEST_NAMESPACE = "http://www.example.com/simpleCS";

    /**
     * Simple ChangeSummary test.
     */
    public void testChangeSummary() throws Exception {
        Type quoteType = TypeHelper.INSTANCE.getType(TEST_NAMESPACE, "RootQuote");
        DataObject quote = DataFactory.INSTANCE.create(quoteType);
        
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

        quote.getDataObject("quotes.1").delete();

        // Stop logging changes and print the resulting data graph to stdout
        //
        cs.endLogging();

        //XMLHelper.INSTANCE.save(quote, TEST_NAMESPACE, "rootQuote", System.out);
               
        cs.undoChanges();
        
        //System.out.println("\nAfter Undo Changes:");
        //XMLHelper.INSTANCE.save(quote, TEST_NAMESPACE, "rootQuote", System.out);
    }

    protected void setUp() throws Exception {
        super.setUp();

        // Populate the meta data for the test (Stock Quote) model
        URL url = getClass().getResource(TEST_MODEL);
        InputStream inputStream = url.openStream();
        XSDHelper.INSTANCE.define(inputStream, url.toString());
        inputStream.close();
    }
}
