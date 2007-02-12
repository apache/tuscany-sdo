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
import commonj.sdo.Property;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;


public class SimpleDynamicTestCase extends TestCase {
    private final String TEST_MODEL = "/simple.xsd";
    private final String TEST_NAMESPACE = "http://www.example.com/simple";
    private final String QUOTE_XML = "/quote.xml";

	private final String TEST_MODEL2 = "/simple2.xsd";
    private final String TEST_NAMESPACE2 = "http://www.example.com/simple2";
    private final String QUOTE_XML2 = "/quote2.xml";

    /**
     * Simple Dynamic SDO 2 test.
     */
    public void donttestDynamic() throws IOException {
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
	
	public void testResolveXSDWithoutSchemaLocation() throws IOException {
        Type quote2Type = TypeHelper.INSTANCE.getType(TEST_NAMESPACE2, "Quote2");
        DataObject quote2 = DataFactory.INSTANCE.create(quote2Type);
        
        quote2.setString("symbol", "fbnt");
        quote2.setString("companyName", "FlyByNightTechnology");
        quote2.setBigDecimal("price", new BigDecimal("1000.0"));
        quote2.setBigDecimal("open1", new BigDecimal("1000.0"));
        quote2.setBigDecimal("high", new BigDecimal("1000.0"));
        quote2.setBigDecimal("low", new BigDecimal("1000.0"));
        quote2.setDouble("volume", 1000);
        quote2.setDouble("change1", 1000);

        DataObject child = quote2.createDataObject("quotes");
        child.setBigDecimal("price", new BigDecimal("2000.0"));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
		XMLHelper.INSTANCE.save(quote2, TEST_NAMESPACE2, "stockQuote", System.out);
    }

    protected void setUp() throws Exception {
        super.setUp();

        // Populate the meta data for the test (Stock Quote) model
        URL url = getClass().getResource(TEST_MODEL);
        InputStream inputStream = url.openStream();
        XSDHelper.INSTANCE.define(inputStream, url.toString());
        inputStream.close();

		url = getClass().getResource(TEST_MODEL2);
		inputStream = url.openStream();
        XSDHelper.INSTANCE.define(inputStream, null);
        inputStream.close();
    }

}
