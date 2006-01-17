/**
 *
 *  Copyright 2005 BEA Systems Inc.
 *  Copyright 2005 International Business Machines Corporation
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

import java.util.List;
import java.net.URL;
import java.io.IOException;

import junit.framework.TestCase;
import commonj.sdo.helper.XSDHelper;
import commonj.sdo.Type;

/**
 * @version $Rev$ $Date$
 */
public class XSDHelperTestCase extends TestCase {
    private static final String TEST_MODEL = "/simple.xsd";
    private URL modelURL;

    public void testDuplicateDefineWithLocation() throws IOException {
        List<Type> types = XSDHelper.INSTANCE.define(modelURL.openStream(), modelURL.toString());
        assertEquals(2, types.size());
    }

/*  FIXME null should be allowed but this throws a NPE
    public void testDefineWithNoLocation() {
        List<Type> types = XSDHelper.INSTANCE.define(getClass().getResourceAsStream(TEST_MODEL), null);
    }
*/

/* FIXME the same Types should be returned each time
    public void testDuplicateDefineWithLocation() throws IOException {
        List<Type> types = XSDHelper.INSTANCE.define(modelURL.openStream(), modelURL.toString());
        System.out.println("types = " + types);

        types = XSDHelper.INSTANCE.define(modelURL.openStream(), modelURL.toString());
        System.out.println("types = " + types);
    }
*/

    protected void setUp() throws Exception {
        super.setUp();
        modelURL = getClass().getResource(TEST_MODEL);
    }
}
