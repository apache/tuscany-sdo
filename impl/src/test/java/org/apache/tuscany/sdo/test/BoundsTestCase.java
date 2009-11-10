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

import org.apache.tuscany.sdo.api.SDOUtil;
import org.apache.tuscany.sdo.api.SDOHelper;

import junit.framework.TestCase;

import commonj.sdo.*;
import commonj.sdo.helper.*;

public class BoundsTestCase extends TestCase {
    private final String TEST_MODEL = "/bounds.xsd";
    private final String TEST_NAMESPACE = "http://www.example.com/bounds";

    private TypeHelper typeHelper;
    private XSDHelper xsdHelper;
    private DataFactory dataFactory;

    public void testBounds() {
    	Property priceProperty = typeHelper.getOpenContentProperty(TEST_NAMESPACE, "price");
        assertTrue(priceProperty.isOpenContent());
        assertEquals(SDOHelper.UNSPECIFIED, SDOUtil.getUpperBound(priceProperty));
        assertEquals(0, SDOUtil.getLowerBound(priceProperty));
        
        Type quoteType = typeHelper.getType(TEST_NAMESPACE, "OpenQuote");
        DataObject quote = dataFactory.create(quoteType);
        assertEquals(2, SDOUtil.getUpperBound(quote.getInstanceProperty("symbol")));
        assertEquals(0, SDOUtil.getLowerBound(quote.getInstanceProperty("symbol")));
        
        //XSD default value of maxOccurs and minOccurs is 1, unbounded returns -1 for maxOccurs
        Type quoteType2 = typeHelper.getType(TEST_NAMESPACE, "OpenQuote2");
        DataObject quote2 = dataFactory.create(quoteType2);
        assertEquals(SDOHelper.UNBOUNDED, SDOUtil.getUpperBound(quote2.getInstanceProperty("symbol")));
        assertEquals(1, SDOUtil.getLowerBound(quote2.getInstanceProperty("symbol")));
        
        //XSD default value of maxOccurs and minOccurs is 1
        Type quoteType3 = typeHelper.getType(TEST_NAMESPACE, "OpenQuote3");
        DataObject quote3 = dataFactory.create(quoteType3);
        assertEquals(1, SDOUtil.getUpperBound(quote3.getInstanceProperty("symbol")));
        assertEquals(1, SDOUtil.getLowerBound(quote3.getInstanceProperty("symbol")));        
    }

    protected void setUp() throws Exception {
        super.setUp();

        HelperContext hc = SDOUtil.createHelperContext();
        typeHelper = hc.getTypeHelper();
        dataFactory = hc.getDataFactory();
        xsdHelper = hc.getXSDHelper();
        
        // Populate the meta data for the test (Stock Quote) model
        URL url = getClass().getResource(TEST_MODEL);
        InputStream inputStream = url.openStream();
        xsdHelper.define(inputStream, url.toString());
        inputStream.close();
    }
}