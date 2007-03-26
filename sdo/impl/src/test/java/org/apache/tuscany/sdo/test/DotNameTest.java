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
import java.io.InputStream;
import java.net.URL;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.util.SDOUtil;

import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;


public class DotNameTest extends TestCase {
    private final String TEST_MODEL = "/dotNames.xsd";
    private final String TEST_NAMESPACE = "http://www.example.com/dotNames";
    private HelperContext hc;
    private TypeHelper th;
    private DataFactory df;

    /**
     * Simple Dynamic SDO 2 test.
     */
    public void testDynamic() throws IOException {
        Type quoteType = th.getType(TEST_NAMESPACE, "DotNameType");
        DataObject quote = df.create(quoteType);


        quote.getList("property.2.1").add(TEST_NAMESPACE);
        assertTrue(quote.isSet("property.2.1"));
        assertSame(quote.get("property.2.1.0"), TEST_NAMESPACE);
        quote.getList("foo.bar").add(TEST_NAMESPACE);
        assertTrue(quote.isSet("foo.bar"));
        assertSame(quote.get("foo.bar.0"), TEST_NAMESPACE);
    }


    protected void setUp() throws Exception {
        super.setUp();

        // Populate the meta data for the test (Stock Quote) model
        URL url = getClass().getResource(TEST_MODEL);
        hc = SDOUtil.createHelperContext();
        th = hc.getTypeHelper();
        df = hc.getDataFactory();
        
        InputStream inputStream = url.openStream();
        hc.getXSDHelper().define(inputStream, url.toString());
        inputStream.close();
        

    }

}