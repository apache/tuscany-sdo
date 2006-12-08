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
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;

public class XPathTestCase extends TestCase {
  
    HelperContext hc;
  
    protected void setUp() throws Exception {
        super.setUp();
        hc = SDOUtil.createHelperContext();
    }

    private final String TEST_MODEL = "/xpath.xsd";
    private final String XPATH_XML = "/xpath.xml";

    /**
     * The presence or absence of the @ sign in a path has no meaning.
     * Properties are always matched by name independent of their XML representation.
     * @throws IOException
     */
    public void testAtSignProperty() throws IOException {
        XSDHelper xsdHelper = hc.getXSDHelper();
        XMLHelper xmlHelper = hc.getXMLHelper();
        
        URL url = getClass().getResource(TEST_MODEL);
        InputStream inputStream = url.openStream();
        xsdHelper.define(inputStream, url.toString());
        
        inputStream.close();
        
        XMLDocument doc = xmlHelper.load(getClass().getResourceAsStream(XPATH_XML));
          
        DataObject drive = doc.getRootObject();
        DataObject folder1 = (DataObject) drive.get("Folder.1");
        String value = folder1.getString("@creation_date");
         
        assertEquals(value, "2000-03-23");
    }
    
    public void testListIndexing() throws Exception {
        XSDHelper xsdHelper = hc.getXSDHelper();
        XMLHelper xmlHelper = hc.getXMLHelper();

        URL url = getClass().getResource(TEST_MODEL);
        InputStream inputStream = url.openStream();
        xsdHelper.define(inputStream, url.toString());

        inputStream.close();

        XMLDocument doc = xmlHelper.load(getClass().getResourceAsStream(XPATH_XML));

        DataObject root = doc.getRootObject();
        DataObject folder1 = root.getDataObject("Folder[1]");
        assertNotNull(folder1);
        DataObject folder1a = root.getDataObject("Folder.0");
        assertEquals(folder1, folder1a);
        folder1a = root.getDataObject("Folder[FolderName=Folder00000000000]");
        assertEquals(folder1, folder1a);

        DataObject noFolder = null;

        try {
            noFolder = root.getDataObject("Folder[3]");
            assertNull(noFolder);
        } catch (Exception e) {
            assertFalse("bad indexing generated exception" + e, true);
        }

        try {
            noFolder = root.getDataObject("Folder[0]");
            assertNull(noFolder);
        } catch (Exception e) {
            assertFalse("bad indexing generated exception" + e, true);
        }

        try {
            noFolder = root.getDataObject("Folder.2");
            assertNull(noFolder);
        } catch (Exception e) {
            assertFalse("bad indexing generated exception" + e, true);
        }

        try {
            noFolder = root.getDataObject("Folder.-1");
            assertNull(noFolder);
        } catch (Exception e) {
            assertFalse("bad indexing generated exception" + e, true);
        }

        noFolder = root.getDataObject("Folder[FolderName=foo]");
        assertNull(noFolder);
    }
}
