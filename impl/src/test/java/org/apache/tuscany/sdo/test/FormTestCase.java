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
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.util.SDOUtil;
import org.eclipse.emf.ecore.resource.Resource;

import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLHelper;

public class FormTestCase extends TestCase {
    XMLHelper xmlHelper;
    Map options;
    
    protected void setUp() throws Exception {
        super.setUp();
        HelperContext hc = SDOUtil.createHelperContext();
        hc.getXSDHelper().define(
"<schema xmlns=\"http://www.w3.org/2001/XMLSchema\" targetNamespace=\"testNS\">"+
  "<element name=\"root\">"+
    "<complexType>"+
      "<sequence>"+
        "<element name=\"unqualifiedElement\" type=\"string\"/>"+
        "<element name=\"qualifiedElement\" form=\"qualified\" type=\"string\"/>"+
      "</sequence>"+
      "<attribute name=\"unqualifiedAttribute\" type=\"string\"/>"+
      "<attribute name=\"qualifiedAttribute\" form=\"qualified\" type=\"string\"/>"+
    "</complexType>"+
  "</element>"+
"</schema>");
        xmlHelper = hc.getXMLHelper();
        options = new HashMap();
        /*
         * turn off default behaviour of tolerating malformed xml
         * tests using this option and bad xml should demonstrate failure to load
         */
        options.put(SDOUtil.XML_LOAD_LaxForm, new Integer(0));
    }

    void load(String xml, Object options) throws IOException {
        assertNotNull(xmlHelper.load(new StringReader(xml), null, options).getRootObject());
    }

    /*
     * this malformed xml will load, as it uses the default lax approach
     */
    public void testLaxForm() throws IOException {
        load(
"<p:root xmlns:p=\"testNS\" p:unqualifiedAttribute=\"u\" qualifiedAttribute=\"q\">"+
  "<p:unqualifiedElement/>"+
  "<qualifiedElement/>"+
"</p:root>", null);
    }

    /*
     * any malformed xml through this method will fail to load
     * since the options instance member disables lax processing
     */
    protected final void load(String xml) throws IOException {
        try {
            load(xml, options);
            fail();
        } catch (Resource.IOWrappedException featureNotFound) {
        }
    }

    public void testUnqualifiedAttribute() throws IOException {
        load("<p:root xmlns:p=\"testNS\" p:unqualifiedAttribute=\"u\"/>");
    }

    public void testQualifiedAttribute() throws IOException {
        load("<p:root xmlns:p=\"testNS\" qualifiedAttribute=\"q\"/>");
    }

    public void testUnqualifiedElement() throws IOException {
        load(
"<p:root xmlns:p=\"testNS\">"+
  "<p:unqualifiedElement/>"+
"</p:root>");
    }

    public void testQualifiedElement() throws IOException {
        load(
"<p:root xmlns:p=\"testNS\">"+
  "<qualifiedElement/>"+
"</p:root>");
    }
}
