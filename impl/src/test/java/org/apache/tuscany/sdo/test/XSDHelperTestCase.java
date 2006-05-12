/**
 *
 *  Copyright 2005 The Apache Software Foundation or its licensors, as applicable.
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
import java.net.URL;
import java.util.List;

import org.apache.tuscany.sdo.util.SDOUtil;

import junit.framework.TestCase;

import commonj.sdo.helper.XSDHelper;

/**
 * @version $Rev$ $Date$
 */
public class XSDHelperTestCase extends TestCase {
    private static final String TEST_MODEL = "/simple.xsd";
    private URL modelURL;

    public void testDefineWithLocation() throws IOException {
        XSDHelper xsdHelper = SDOUtil.createXSDHelper(SDOUtil.createTypeHelper());
        List types = xsdHelper.define(modelURL.openStream(), modelURL.toString());
        assertEquals(2, types.size());
    }

    public void testDefineWithNoLocation() {
        XSDHelper xsdHelper = SDOUtil.createXSDHelper(SDOUtil.createTypeHelper());
        List types = xsdHelper.define(getClass().getResourceAsStream(TEST_MODEL), null);
        assertEquals(2, types.size());
    }

    public void testDuplicateDefineWithLocation() throws IOException {
        XSDHelper xsdHelper = SDOUtil.createXSDHelper(SDOUtil.createTypeHelper());
        List types = xsdHelper.define(modelURL.openStream(), modelURL.toString());
        assertEquals(2, types.size());

        List types2 = xsdHelper.define(modelURL.openStream(), modelURL.toString());
        assertEquals(0, types2.size());
    }

    protected void setUp() throws Exception {
        super.setUp();
        modelURL = getClass().getResource(TEST_MODEL);
    }
}
