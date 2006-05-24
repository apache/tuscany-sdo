/**
 *
 *  Copyright 2006 The Apache Software Foundation or its licensors, as applicable.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.tuscany.sdo.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.tuscany.sdo.util.SDOUtil;

import junit.framework.TestCase;

import commonj.sdo.DataObject;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;

public class XPathTestCase extends TestCase {

    private final String TEST_MODEL = "/xpath.xsd";
    private final String XPATH_XML = "/xpath.xml";

    /**
     * The presence or absence of the @ sign in a path has no meaning.
     * Properties are always matched by name independent of their XML representation.
     * @throws IOException
     */
    public void testAtSignProperty() throws IOException {
        TypeHelper typeHelper = SDOUtil.createTypeHelper();
        XSDHelper xsdHelper = SDOUtil.createXSDHelper(typeHelper);
        XMLHelper xmlHelper = SDOUtil.createXMLHelper(typeHelper);
        
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
}
