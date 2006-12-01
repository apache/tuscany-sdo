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
import java.util.Iterator;

import org.apache.tuscany.sdo.util.SDOUtil;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;
import junit.framework.TestCase;


public class OpenTypeTestCase extends TestCase {
    private HelperContext hc;
    private TypeHelper th;
    private XSDHelper xsdh;
    private XMLHelper xmlh;
    private DataFactory df;
    private final String TEST_MODEL = "/open.xsd";
    private final String TEST_NAMESPACE = "http://www.example.com/open";
    private final String TEST_DATA = "/open.xml";

    /**
     * Open content SDO 2 test.
     */
    public void testOpenType() throws IOException {
        Type quoteType = th.getType(TEST_NAMESPACE, "OpenQuote");
        DataObject quote = df.create(quoteType);

        quote.setString("symbol", "s1");

        for (Iterator iter = quote.getInstanceProperties().iterator(); iter.hasNext();) {
            Property property = (Property) iter.next();
        }

        Property companyProperty = xsdh.getGlobalProperty(TEST_NAMESPACE, "company", true);
        DataObject company = quote.createDataObject(companyProperty);
        company.setString("name", "FlyByNightTechnology");

        Property priceProperty = xsdh.getGlobalProperty(TEST_NAMESPACE, "price", true);
        quote.getList(priceProperty).add(new BigDecimal("1000.0"));

        for (Iterator iter = quote.getInstanceProperties().iterator(); iter.hasNext();) {
            Property property = (Property) iter.next();
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        xmlh.save(quote, TEST_NAMESPACE, "openStockQuote", baos);
        
        assertTrue(TestUtil.equalXmlFiles(new ByteArrayInputStream(baos.toByteArray()), getClass().getResource(TEST_DATA)));
    }
    
    // TODO introduce this test once the EMF issue behind TUSCANY-396 has been fixed
    public void dont_testOpenType_Tuscany_396() throws IOException {
      Type quoteType = th.getType(TEST_NAMESPACE, "OpenQuote");
      DataObject quote = df.create(quoteType);

      quote.setString("symbol", "s1");

      for (Iterator iter = quote.getInstanceProperties().iterator(); iter.hasNext();) {
          Property property = (Property) iter.next();
      }

      Property companyProperty = xsdh.getGlobalProperty(TEST_NAMESPACE, "company", true);
      DataObject company = quote.createDataObject(companyProperty);
      company.setString("name", "FlyByNightTechnology");

      Property priceProperty = xsdh.getGlobalProperty(TEST_NAMESPACE, "price", true);
      quote.set(priceProperty, new BigDecimal("1000.0"));

      for (Iterator iter = quote.getInstanceProperties().iterator(); iter.hasNext();) {
          Property property = (Property) iter.next();
      }

      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      xmlh.save(quote, TEST_NAMESPACE, "openStockQuote", baos);
      
      assertTrue(TestUtil.equalXmlFiles(new ByteArrayInputStream(baos.toByteArray()), getClass().getResource(TEST_DATA)));
  }

    protected void setUp() throws Exception {
        super.setUp();

        // Populate the meta data for the test (Stock Quote) model
        URL url = getClass().getResource(TEST_MODEL);
        InputStream inputStream = url.openStream();
        hc = SDOUtil.createHelperContext();
        th = hc.getTypeHelper();
        xsdh = hc.getXSDHelper();
        df = hc.getDataFactory();
        xmlh = hc.getXMLHelper();
        hc.getXSDHelper().define(inputStream, url.toString());
        inputStream.close();
    }
}
