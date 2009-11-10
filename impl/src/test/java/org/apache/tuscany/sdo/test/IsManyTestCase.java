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

import org.apache.tuscany.sdo.util.SDOUtil;

import junit.framework.TestCase;

import commonj.sdo.*;
import commonj.sdo.helper.*;

public class IsManyTestCase extends TestCase {
    private final String TEST_MODEL = "/open.xsd";
    private final String TEST_MODEL1ANY = "/open1any.xsd";
    private final String TEST_NAMESPACE = "http://www.example.com/open";
    private final String TEST_NAMESPACE1ANY = "http://www.example.com/open1any";

    public void testIsMany() {
        Property priceProperty = XSDHelper.INSTANCE.getGlobalProperty(TEST_NAMESPACE, "price", true);
        
        Type quoteType = TypeHelper.INSTANCE.getType(TEST_NAMESPACE, "OpenQuote");
        DataObject quote = DataFactory.INSTANCE.create(quoteType);
        assertTrue( SDOUtil.isMany(priceProperty, quote));

        quoteType = TypeHelper.INSTANCE.getType(TEST_NAMESPACE1ANY, "OpenQuote");
        quote = DataFactory.INSTANCE.create(quoteType);
        assertFalse( SDOUtil.isMany(priceProperty, quote));
    }

    protected void setUp() throws Exception {
        super.setUp();

        // Populate the meta data for the test (Stock Quote) model
        URL url = getClass().getResource(TEST_MODEL);
        InputStream inputStream = url.openStream();
        XSDHelper.INSTANCE.define(inputStream, url.toString());
        inputStream.close();

        // Populate the meta data for the test (Stock Quote) model with maxOccurs=1 <any>
        url = getClass().getResource(TEST_MODEL1ANY);
        inputStream = url.openStream();
        XSDHelper.INSTANCE.define(inputStream, url.toString());
        inputStream.close();
    }
}