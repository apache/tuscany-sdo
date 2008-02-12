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
package commonj.sdo.impl;

import java.net.URL;
import java.net.URLClassLoader;

import junit.framework.TestCase;
import test.DefaultHelperProvider;
import test.TCCL1HelperProvider;

/**
 * @version $Revision$ $Date$
 */
public class HelperProviderTestCase extends TestCase {
    private URL classes;
    private URL testClasses;
    private URL def;
    private URL tccl1;

    public void testInstanceIsNullWithNoImplementation() throws Exception {
        assertNull(HelperProvider.INSTANCE);
    }

    public void testDefaultInstance() throws Exception {
        ClassLoader cl = new URLClassLoader(new URL[]{classes, def, testClasses}, null);
        Class providerClass = cl.loadClass(HelperProvider.class.getName());
        Class implClass = cl.loadClass(DefaultHelperProvider.class.getName());
        Object instance = providerClass.getField("INSTANCE").get(null);
        assertNotNull(instance);
        assertEquals(implClass, instance.getClass());
    }

    public void testLocateFromClassLoader() throws Exception {
        ClassLoader cl = new URLClassLoader(new URL[]{classes, tccl1, testClasses}, null);
        Class providerClass = cl.loadClass(HelperProvider.class.getName());
        Object provider = providerClass.getMethod("getInstance", new Class[] {ClassLoader.class})
            .invoke(null, new Object[] {cl});
        assertNotNull(provider);
        assertEquals(TCCL1HelperProvider.class.getName(), provider.getClass().getName());
    }

    public void testThreadContextInstance() throws Exception {
        ClassLoader cl = new URLClassLoader(new URL[]{classes, tccl1, testClasses}, null);
        ClassLoader tccl = Thread.currentThread().getContextClassLoader();
        try {
            Thread.currentThread().setContextClassLoader(cl);
            Class providerClass = cl.loadClass(HelperProvider.class.getName());
            Object provider = providerClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            assertNotNull(provider);
            assertEquals(TCCL1HelperProvider.class.getName(), provider.getClass().getName());
        } finally {
            Thread.currentThread().setContextClassLoader(tccl);
        }

    }

    public void testSystemProperty() {
        System.setProperty("commonj.sdo.impl.HelperProvider", "test.TCCL1HelperProvider");
        try {
            HelperProvider provider = HelperProvider.getInstance();
            assertNotNull(provider);
            assertEquals(TCCL1HelperProvider.class, provider.getClass());
        } finally {
            System.getProperties().remove("commonj.sdo.impl.HelperProvider");
        }
    }

    protected void setUp() throws Exception {
        super.setUp();
        classes = new URL(HelperProvider.class.getResource("HelperProvider.class"), "../../..");
        testClasses = new URL(HelperProviderTestCase.class.getResource("HelperProviderTestCase.class"), "../../..");
        tccl1 = new URL(testClasses, "tccl1/");
        def = new URL(testClasses, "default/");
    }
}
