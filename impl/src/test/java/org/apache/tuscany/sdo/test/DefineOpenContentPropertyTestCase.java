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

import org.apache.tuscany.sdo.helper.TypeHelperImpl;
import org.apache.tuscany.sdo.util.SDOUtil;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;
import junit.framework.TestCase;


public class DefineOpenContentPropertyTestCase extends TestCase {
    private final String TEST_MODEL = "/open.xsd";
    private final String TEST_NAMESPACE = "http://www.example.com/open";
    private final String TEST_DATA = "/openContentProperty.xml";

    private TypeHelperImpl typeHelper;
    private XSDHelper xsdHelper;
    private XMLHelper xmlHelper;
    private DataFactory dataFactory;
    
    public void testDefineOpenContentProperty() throws IOException {
        Type quoteType = typeHelper.getType(TEST_NAMESPACE, "OpenQuote");
        DataObject quote = dataFactory.create(quoteType);
        
        quote.setString("symbol", "s1");

        Property companyProperty = typeHelper.getOpenContentProperty(TEST_NAMESPACE, "company");
        DataObject company = quote.createDataObject(companyProperty);
        company.setString("name", "FlyByNightTechnology");

        Property priceProperty = typeHelper.getOpenContentProperty(TEST_NAMESPACE, "price");
        quote.getList(priceProperty).add(new BigDecimal("1000.0"));

        // Define a new SDO open content property with simple type
		DataObject p = dataFactory.create("commonj.sdo", "Property");
		p.set("type", typeHelper.getType("commonj.sdo", "Decimal"));
		p.set("name", "highPrice");
		Property highPrice = typeHelper.defineOpenContentProperty(TEST_NAMESPACE, p);
        
		quote.setBigDecimal(highPrice, new BigDecimal("1100.0"));
        
        // Define a new SDO open content property with complex type
        DataObject mutualFundQuotePropertyDef = dataFactory.create("commonj.sdo", "Property");
        mutualFundQuotePropertyDef.set("type", quoteType);
        mutualFundQuotePropertyDef.set("name", "mutualFundQuote");
        mutualFundQuotePropertyDef.setBoolean("containment", true);
        Property mutualFundQuoteProperty = typeHelper.defineOpenContentProperty(TEST_NAMESPACE, mutualFundQuotePropertyDef);
        
        DataObject mutualFundQuote = quote.createDataObject(mutualFundQuoteProperty);
        mutualFundQuote.setString("symbol", "mutual-1");
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        xmlHelper.save(quote, TEST_NAMESPACE, "openStockQuote", baos);

        assertTrue(TestUtil.equalXmlFiles(new ByteArrayInputStream(baos.toByteArray()), getClass().getResource(TEST_DATA)));
        
        // validate existing property condition
        Property duplicateProp = typeHelper.defineOpenContentProperty(TEST_NAMESPACE, p);
        assertTrue(highPrice.equals(duplicateProp));
        
        // validate error condition, where new property exists with different type
        boolean errorCondition = false;
        try
        {
            p = dataFactory.create("commonj.sdo", "Property");
            p.set("type", typeHelper.getType("commonj.sdo", "String"));
            p.set("name", "highPrice");
            highPrice = typeHelper.defineOpenContentProperty(TEST_NAMESPACE, p);
        }
        catch( IllegalArgumentException ex )
        {
            errorCondition = true;
        }
        assertTrue(errorCondition);
    }

    protected void setUp() throws Exception {
        super.setUp();

        typeHelper = (TypeHelperImpl)SDOUtil.createTypeHelper();
        xsdHelper = SDOUtil.createXSDHelper(typeHelper);
        xmlHelper = SDOUtil.createXMLHelper(typeHelper);
        dataFactory = SDOUtil.createDataFactory(typeHelper);
        
        // Populate the meta data for the test (Stock Quote) model
        URL url = getClass().getResource(TEST_MODEL);
        InputStream inputStream = url.openStream();
        xsdHelper.define(inputStream, url.toString());
        inputStream.close();
    }
}
