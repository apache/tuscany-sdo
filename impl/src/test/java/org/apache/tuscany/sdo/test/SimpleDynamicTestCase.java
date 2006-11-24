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
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;

import junit.framework.TestCase;

import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;


public class SimpleDynamicTestCase extends TestCase {
    private final String TEST_MODEL = "/simple.xsd";
    private final String TEST_NAMESPACE = "http://www.example.com/simple";
    private final String QUOTE_XML = "/quote.xml";

    /**
     * Simple Dynamic SDO 2 test.
     */
    public void testDynamic() throws IOException {
        Type quoteType = TypeHelper.INSTANCE.getType(TEST_NAMESPACE, "Quote");
        DataObject quote = DataFactory.INSTANCE.create(quoteType);

        quote.setString("symbol", "fbnt");
        quote.setString("companyName", "FlyByNightTechnology");
        quote.setBigDecimal("price", new BigDecimal("1000.0"));
        quote.setBigDecimal("open1", new BigDecimal("1000.0"));
        quote.setBigDecimal("high", new BigDecimal("1000.0"));
        quote.setBigDecimal("low", new BigDecimal("1000.0"));
        quote.setDouble("volume", 1000);
        quote.setDouble("change1", 1000);

        DataObject child = quote.createDataObject("quotes");
        child.setBigDecimal("price", new BigDecimal("2000.0"));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        XMLHelper.INSTANCE.save(quote, TEST_NAMESPACE, "stockQuote", baos);
        
        assertFalse(quote.isSet("undefined"));
        assertSame(quote.get("undefined"), null);
        
        assertTrue(TestUtil.equalXmlFiles(new ByteArrayInputStream(baos.toByteArray()), getClass().getResource(QUOTE_XML)));
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
