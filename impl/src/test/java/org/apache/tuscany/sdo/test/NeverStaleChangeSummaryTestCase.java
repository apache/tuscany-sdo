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
import java.net.URL;

import junit.framework.TestCase;

import commonj.sdo.ChangeSummary;
import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XSDHelper;

public class NeverStaleChangeSummaryTestCase extends TestCase {
    private final String TEST_MODEL = "/simpleWithChangeSummary.xsd";
    private final String TEST_NAMESPACE = "http://www.example.com/simpleCS";

    /**
     * Simple ChangeSummary test.
     */
    public void testChangeSummary() throws Exception {
        Type quoteType = TypeHelper.INSTANCE.getType(TEST_NAMESPACE, "RootQuote");
        DataObject quote = DataFactory.INSTANCE.create(quoteType);

        ChangeSummary cs = quote.getChangeSummary();

        // Begin logging changes
        //
        cs.beginLogging();

        DataObject child = quote.createDataObject("quotes");
        cs.isCreated(child);
        child = quote.createDataObject("quotes");
        assertTrue(cs.isCreated(child));

        // Stop logging changes and print the resulting data graph to stdout
        //
        cs.endLogging();

        cs.isCreated(child);

        cs.undoChanges();

        assertFalse(cs.isCreated(child));
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