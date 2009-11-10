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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.tuscany.sdo.SDOPackage;
import org.apache.tuscany.sdo.api.SDOHelper;
import org.apache.tuscany.sdo.api.SDOUtil;
import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XMLHelper;

public class XMLUnknownPropertiesTestCase extends TestCase {
    XMLHelper xmlHelper;
    Map options;

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    // SDOUtil->SDOHelper->SDOHelperImpl->HelperContextImpl->XMLHelperImpl
    public void testOptionUnknownProperties() throws IOException {
        options = new HashMap();
        options.put(SDOHelper.XMLOptions.XML_LOAD_UNKNOWN_PROPERTIES, Boolean.TRUE);

        final HelperContext hc = SDOUtil.createHelperContext(true);
        hc
            .getXSDHelper()
            .define("<schema xmlns=\"http://www.w3.org/2001/XMLSchema\" targetNamespace=\"testNS\">" + "<element name=\"root\">"
                + "<complexType>"
                + "<sequence>"
                + "<element name=\"unqualifiedElement\" type=\"string\"/>"
                + "<element name=\"qualifiedElement\" form=\"qualified\" type=\"string\"/>"
                + "</sequence>"
                + "<attribute name=\"unqualifiedAttribute\" type=\"string\"/>"
                + "<attribute name=\"qualifiedAttribute\" form=\"qualified\" type=\"string\"/>"
                + "</complexType>"
                + "</element>"
                + "</schema>");

        final String xml =
            "<p:root xmlns:p=\"testNS\">" + "<unqualifiedElement/>"
                + "<telem>my test data0</telem>"
                + "<zap>my test data1</zap>"
                + "</p:root>";

        try {
            final XMLDocument xmlDoc = hc.getXMLHelper().load(new StringReader(xml), null, options);// pass
                                                                                                // during
                                                                                                // invoke
            
            final DataObject root = xmlDoc.getRootObject();
            assertNotSame(root.getType(), SDOPackage.eINSTANCE.getAnyTypeDataObject());
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
            hc.getXMLHelper().save(xmlDoc, baos, null);
            assertTrue(baos.toString().indexOf("<telem>my test data0</telem>") != -1);
            assertTrue(baos.toString().indexOf("<zap>my test data1</zap>") != -1);
        } catch (final Exception e) {// (Resource.IOWrappedException featureNotFound)
            e.printStackTrace();
        }
    }

    public void testOptionUnknownProperties2() throws IOException {
        options = new HashMap();
        options.put(SDOHelper.XMLOptions.XML_LOAD_UNKNOWN_PROPERTIES, Boolean.FALSE);

        final HelperContext hc = SDOUtil.createHelperContext(true);
        hc
            .getXSDHelper()
            .define("<schema xmlns=\"http://www.w3.org/2001/XMLSchema\" targetNamespace=\"testNS\">" + "<element name=\"root\">"
                + "<complexType>"
                + "<sequence>"
                + "<element name=\"unqualifiedElement\" type=\"string\"/>"
                + "<element name=\"qualifiedElement\" form=\"qualified\" type=\"string\"/>"
                + "</sequence>"
                + "<attribute name=\"unqualifiedAttribute\" type=\"string\"/>"
                + "<attribute name=\"qualifiedAttribute\" form=\"qualified\" type=\"string\"/>"
                + "</complexType>"
                + "</element>"
                + "</schema>");

        final String xml =
            "<p:root xmlns:p=\"testNS\">" + "<unqualifiedElement/>"
                + "<telem>my test data</telem>"
                + "<telem1>my test data</telem1>"
                + "</p:root>";

        try {
            final XMLDocument xmlDoc = hc.getXMLHelper().load(new StringReader(xml), null, options);// pass
                                                                                                // on
                                                                                                // invokation
            final DataObject root = xmlDoc.getRootObject();
            assertNotSame(root.getType(), SDOPackage.eINSTANCE.getAnyTypeDataObject());
            fail();
        } catch (final Exception e) {// (Resource.IOWrappedException featureNotFound)
            // e.printStackTrace();
            if (e.getMessage().indexOf("telem") != -1) {
                Assert.assertTrue(true);
            }
        }
    }
}
