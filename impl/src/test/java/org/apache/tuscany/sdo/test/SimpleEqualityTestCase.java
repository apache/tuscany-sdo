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

import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.EqualityHelper;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;
import commonj.sdo.impl.HelperProvider;
import junit.framework.TestCase;

public class SimpleEqualityTestCase extends TestCase {
    private static final String TEST_MODEL = "/simple.xsd";
    private static final String QUOTE_XML = "/quote.xml";
    private static final String SHALLOW_QUOTE_XML = "/shallowquote.xml";

    public void testEquality() throws IOException {

        XMLDocument doc = XMLHelper.INSTANCE.load(getClass().getResourceAsStream(QUOTE_XML));
        DataObject sdo = doc.getRootObject();

        doc = XMLHelper.INSTANCE.load(getClass().getResourceAsStream(SHALLOW_QUOTE_XML));
        DataObject shallowSdo = doc.getRootObject();

        boolean result = EqualityHelper.INSTANCE.equalShallow(sdo, shallowSdo);
        assertTrue(result);

        result = EqualityHelper.INSTANCE.equal(sdo, shallowSdo);
        assertFalse(result);
    }


    protected void setUp() throws Exception {
        super.setUp();

        // Populate the meta data for the test (Stock Quote) model
        URL url = getClass().getResource(TEST_MODEL);
        InputStream inputStream = url.openStream();
        XSDHelper.INSTANCE.define(inputStream, url.toString());
        inputStream.close();
    }
    
    public void testBytesEquality() {
        // Dynamically create a type
        HelperContext scope = HelperProvider.getDefaultContext();
        TypeHelper types = scope.getTypeHelper();
        Type BytesType = types.getType("commonj.sdo", "Bytes");
        DataObject customerType = DataFactory.INSTANCE.create("commonj.sdo", "Type");
        customerType.set("uri", "http://example.com/simple");
        customerType.set("name", "Simple");
        DataObject BytesProperty = customerType.createDataObject("property");
        BytesProperty.set("name", "BytesVal");
        BytesProperty.set("type", BytesType);
        types.define(customerType);
        
        // Create two instances
        DataObject obj1 = DataFactory.INSTANCE.create("http://example.com/simple", "Simple");
        DataObject obj2 = DataFactory.INSTANCE.create("http://example.com/simple", "Simple");

        obj1.setBytes("BytesVal", new byte[] {120, 80, -40});
        obj2.setBytes("BytesVal", new byte[] {120, 80, -40});

        assertTrue( scope.getEqualityHelper().equal(obj1, obj2) );
    }
}
