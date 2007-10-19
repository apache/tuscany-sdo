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

import org.apache.tuscany.sdo.api.SDOUtil;

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
            iter.next();
        }

        Property companyProperty = xsdh.getGlobalProperty(TEST_NAMESPACE, "company", true);
        DataObject company = quote.createDataObject(companyProperty);
        company.setString("name", "FlyByNightTechnology");

        Property priceProperty = xsdh.getGlobalProperty(TEST_NAMESPACE, "price", true);
        quote.getList(priceProperty).add(new BigDecimal("1000.0"));

        for (Iterator iter = quote.getInstanceProperties().iterator(); iter.hasNext();) {
            iter.next();
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        xmlh.save(quote, TEST_NAMESPACE, "openStockQuote", baos);
        
        assertTrue(TestUtil.equalXmlFiles(new ByteArrayInputStream(baos.toByteArray()), getClass().getResource(TEST_DATA)));
    }
    

    public void testOpenType_Tuscany_396() throws IOException {
      Type quoteType = th.getType(TEST_NAMESPACE, "OpenQuote2");
      DataObject quote = df.create(quoteType);

      Property priceProperty = xsdh.getGlobalProperty(TEST_NAMESPACE, "price", true);
      // the importance of this is that the maxOccurs=1 attribute on the xsd:any
      // allows is to use the !isMany getters and setters for open content
      quote.set(priceProperty, new BigDecimal("1000.0"));
      
    }

    /**
     * Although this behavior is not mandated by the SDO 2.1 specification it should be possible
     * to demand-create DataObject properties by calling createDataObject(String name).
     * The behavior should be the same as that specified in section 9.10 for parsing XML that has
     * no types defined e.g. the property should be created as an open, sequenced type with many=true.
     *
     * See https://issues.apache.org/jira/browse/TUSCANY-1397 for more information.
     *
     * @throws Exception
     */
    public void testOnDemandCreateDataObject() throws Exception {
        // define an open type with no properties
        DataObject typeDef = df.create( "commonj.sdo", "Type" );
        typeDef.set( "uri", TEST_NAMESPACE );
        typeDef.set( "name", "testOnDemandCreateDataObjectType" );
        typeDef.setBoolean( "open", true );
        Type t = th.define( typeDef );
    
        // create a DataObject that uses this type
        DataObject testDO = df.create(t);

        // create an on-demand property
        DataObject foo = testDO.createDataObject( "foo" );
        assertNotNull( "createDataObject() demand created a DataObject", foo );
        assertTrue( "DataObject is open", foo.getType().isOpen() );
        assertTrue( "DataObject is sequenced", foo.getType().isSequenced() );
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
