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
import java.util.*;

import org.apache.tuscany.sdo.SDOPackage;
import org.apache.tuscany.sdo.util.SDOUtil;

import junit.framework.TestCase;

import commonj.sdo.helper.*;

public class SchemaLocationTestCase extends TestCase {
    private final String TEST_XML_DOCUMENT = "/SchemaLocationTestCase.xml";

    /**
     * This method will load an xml document consisting of a xsi:schemaLocation and xsi:noNamespaceSchemaLocation defined. It will then use the
     * XMLDocument API to get and set the schemaLocation property.
     * 
     * @throws IOException
     */
    public void testSchemaLocation() throws IOException {
        // load the xml document which has xsi:noNamespaceSchemaLocation and xsi:schemaLocation defined
        Map options = new HashMap();
        options.put(SDOUtil.XML_LOAD_SCHEMA, Boolean.TRUE);
        XMLDocument doc = XMLHelper.INSTANCE.load(getClass().getResourceAsStream(TEST_XML_DOCUMENT), "whatever", options);
        assertNotSame(doc.getRootObject().getType(), SDOPackage.eINSTANCE.getAnyTypeDataObject());
    }
}