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
package org.apache.tuscany.sdo.codegen;

import java.lang.reflect.Method;
import java.util.List;

import junit.framework.TestCase;

/**
 * @version $Rev$ $Date$
 */
public class BytecodeInterfaceGeneratorTestCase extends TestCase {
    private MockType foo;
    private BytecodeInterfaceGenerator gen;
    private TestClassLoader cl;

    public void testHeaderNoBaseClass() {
        gen.visitType(foo);
        gen.visitEnd();
        Class c = cl.addClass(gen.getClassData());
        assertEquals("Foo", c.getName());
        assertTrue(c.isInterface());
        assertEquals(0, c.getInterfaces().length);
        assertEquals(0, c.getMethods().length);
    }

    public void testHeaderWithPackage() {
        gen.visitType(new MockType("org.apache.Foo", null));
        gen.visitEnd();
        Class c = cl.addClass(gen.getClassData());
        assertEquals("org.apache.Foo", c.getName());
        assertEquals(0, c.getInterfaces().length);
        assertEquals(0, c.getMethods().length);
    }

    public void testHeaderOneBaseClass() throws NoJavaImplementationException {
        foo.addBaseType(new MockType("bar1", Bar1.class));
        gen.visitType(foo);
        gen.visitEnd();
        Class c = cl.addClass(gen.getClassData());
        assertEquals("Foo", c.getName());
        assertEquals(1, c.getInterfaces().length);
        assertEquals(Bar1.class, c.getInterfaces()[0]);
        assertEquals(0, c.getMethods().length);
    }

    public void testHeaderMultipleBaseClass() throws NoJavaImplementationException {
        foo.addBaseType(new MockType("bar1", Bar1.class));
        foo.addBaseType(new MockType("bar2", Bar2.class));
        gen.visitType(foo);
        gen.visitEnd();
        Class c = cl.addClass(gen.getClassData());
        assertEquals("Foo", c.getName());
        assertEquals(2, c.getInterfaces().length);
        assertEquals(Bar1.class, c.getInterfaces()[0]);
        assertEquals(Bar2.class, c.getInterfaces()[1]);
        assertEquals(0, c.getMethods().length);
    }

    public void testBooleanProperty() throws NoJavaImplementationException, NoSuchMethodException {
        gen.visitType(foo);
        gen.visitProperty(new MockProperty("true", Boolean.TYPE, false, false));
        gen.visitEnd();
        Class c = cl.addClass(gen.getClassData());
        assertEquals(2, c.getMethods().length);
        Method getter = c.getMethod("isTrue", new Class[0]);
        assertEquals(boolean.class, getter.getReturnType());
        Method setter = c.getMethod("setTrue", new Class[] {boolean.class});
        assertEquals(void.class, setter.getReturnType());
    }

    public void testByteArrayProperty() throws NoJavaImplementationException, NoSuchMethodException {
        gen.visitType(foo);
        gen.visitProperty(new MockProperty("bytes", byte[].class, false, false));
        gen.visitEnd();
        Class c = cl.addClass(gen.getClassData());
        assertEquals(2, c.getMethods().length);
        Method getter = c.getMethod("getBytes", new Class[0]);
        assertEquals(byte[].class, getter.getReturnType());
        Method setter = c.getMethod("setBytes", new Class[] {byte[].class});
        assertEquals(void.class, setter.getReturnType());
    }

    public void testObjectProperty() throws NoJavaImplementationException, NoSuchMethodException {
        gen.visitType(foo);
        gen.visitProperty(new MockProperty("bar", Bar1.class, false, false));
        gen.visitEnd();
        Class c = cl.addClass(gen.getClassData());
        assertEquals(2, c.getMethods().length);
        Method getter = c.getMethod("getBar", new Class[0]);
        assertEquals(Bar1.class, getter.getReturnType());
        Method setter = c.getMethod("setBar", new Class[] {Bar1.class});
        assertEquals(void.class, setter.getReturnType());
    }

    public void testReadOnlyProperty() throws NoJavaImplementationException, NoSuchMethodException {
        gen.visitType(foo);
        gen.visitProperty(new MockProperty("int", Integer.TYPE, false, true));
        gen.visitEnd();
        Class c = cl.addClass(gen.getClassData());
        assertEquals(1, c.getMethods().length);
        Method getter = c.getMethod("getInt", new Class[0]);
        assertEquals(int.class, getter.getReturnType());
    }

    public void testManyProperty() throws NoJavaImplementationException, NoSuchMethodException {
        gen.visitType(foo);
        gen.visitProperty(new MockProperty("list", Integer.TYPE, true, false));
        gen.visitEnd();
        Class c = cl.addClass(gen.getClassData());
        assertEquals(1, c.getMethods().length);
        Method getter = c.getMethod("getList", new Class[0]);
        assertEquals(List.class, getter.getReturnType());
    }

    public void testTwoProperties() throws NoJavaImplementationException, NoSuchMethodException {
        gen.visitType(foo);
        gen.visitProperty(new MockProperty("true", Boolean.TYPE, false, false));
        gen.visitProperty(new MockProperty("int", Integer.TYPE, false, false));
        gen.visitEnd();
        Class c = cl.addClass(gen.getClassData());
        assertEquals(4, c.getMethods().length);
        Method getter = c.getMethod("isTrue", new Class[0]);
        assertEquals(boolean.class, getter.getReturnType());
        Method setter = c.getMethod("setTrue", new Class[] {boolean.class});
        assertEquals(void.class, setter.getReturnType());
        getter = c.getMethod("getInt", new Class[0]);
        assertEquals(int.class, getter.getReturnType());
        setter = c.getMethod("setInt", new Class[] {int.class});
        assertEquals(void.class, setter.getReturnType());
    }

    protected void setUp() throws Exception {
        super.setUp();
        foo = new MockType("foo", null);
        gen = new BytecodeInterfaceGenerator();
        cl = new TestClassLoader();
    }

    private class TestClassLoader extends ClassLoader {
        public TestClassLoader() {
            super(TestClassLoader.class.getClassLoader());
        }

        Class addClass(byte[] bytes) {
            return defineClass(null, bytes, 0, bytes.length);
        }
    }
}
