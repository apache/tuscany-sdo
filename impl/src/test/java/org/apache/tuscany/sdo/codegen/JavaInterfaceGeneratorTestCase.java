/**
 *
 * Copyright 2005 The Apache Software Foundation
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
package org.apache.tuscany.sdo.codegen;

import java.util.List;

import junit.framework.TestCase;
import commonj.sdo.Type;
import commonj.sdo.Property;

/**
 * @version $Rev$ $Date$
 */
public class JavaInterfaceGeneratorTestCase extends TestCase {
    private static final String SEP = System.getProperty("line.separator");

    private JavaInterfaceGenerator gen;

    public void testHeaderNoBaseClass() {
        gen.visitType(null, "Foo", false, false, false);
        gen.visitEnd();
        assertEquals(localize("public interface Foo {\n}\n"), gen.toString());
    }

    public void testHeaderWithPackage() {
        gen.visitType(null, "org.apache.Foo", false, false, false);
        gen.visitEnd();
        assertEquals(localize("package org.apache;\n\npublic interface Foo {\n}\n"), gen.toString());
    }

    public void testJavaTypeOverridesSDO() {
        gen.visitType(null, "org.apache.Foo", false, false, false);
        gen.visitJavaType(Bar1.class);
        gen.visitEnd();
        assertEquals(localize("package org.apache.tuscany.sdo.codegen;\n\npublic interface Bar1 {\n}\n"), gen.toString());
    }

    public void testHeaderOneBaseClass() throws NoJavaImplementationException {
        gen.visitType(null, "Foo", false, false, false);
        gen.visitBaseType(new MockType(Bar1.class));
        gen.visitEnd();
        assertEquals(localize("public interface Foo extends org.apache.tuscany.sdo.codegen.Bar1 {\n}\n"), gen.toString());
    }

    public void testHeaderMultipleBaseClass() throws NoJavaImplementationException {
        gen.visitType(null, "Foo", false, false, false);
        gen.visitBaseType(new MockType(Bar1.class));
        gen.visitBaseType(new MockType(Bar2.class));
        gen.visitEnd();
        assertEquals(localize("public interface Foo extends org.apache.tuscany.sdo.codegen.Bar1, org.apache.tuscany.sdo.codegen.Bar2 {\n}\n"), gen.toString());
    }

    public void testBooleanProperty() throws NoJavaImplementationException {
        gen.visitType(null, "Foo", false, false, false);
        gen.visitProperty("true", new MockType(Boolean.TYPE), false, false, false);
        gen.visitEnd();
        assertEquals(localize("public interface Foo {\n\tboolean isTrue();\n\tvoid setTrue(boolean value);\n}\n"), gen.toString());
    }

    public void testByteArrayProperty() throws NoJavaImplementationException {
        gen.visitType(null, "Foo", false, false, false);
        gen.visitProperty("bytes", new MockType(byte[].class), false, false, false);
        gen.visitEnd();
        assertEquals(localize("public interface Foo {\n\tbyte[] getBytes();\n\tvoid setBytes(byte[] value);\n}\n"), gen.toString());
    }

    public void testObjectProperty() throws NoJavaImplementationException {
        gen.visitType(null, "Foo", false, false, false);
        gen.visitProperty("bar", new MockType(Bar1.class), false, false, false);
        gen.visitEnd();
        assertEquals(localize("public interface Foo {\n\torg.apache.tuscany.sdo.codegen.Bar1 getBar();\n\tvoid setBar(org.apache.tuscany.sdo.codegen.Bar1 value);\n}\n"), gen.toString());
    }

    public void testReadOnlyProperty() throws NoJavaImplementationException {
        gen.visitType(null, "Foo", false, false, false);
        gen.visitProperty("int", new MockType(Integer.TYPE), false, false, true);
        gen.visitEnd();
        assertEquals(localize("public interface Foo {\n\tint getInt();\n}\n"), gen.toString());
    }

    public void testManyProperty() throws NoJavaImplementationException {
        gen.visitType(null, "Foo", false, false, false);
        gen.visitProperty("list", new MockType(Integer.TYPE), true, false, false);
        gen.visitEnd();
        assertEquals(localize("public interface Foo {\n\tjava.util.List getList();\n}\n"), gen.toString());
    }

    public void testTwoProperties() throws NoJavaImplementationException {
        gen.visitType(null, "Foo", false, false, false);
        gen.visitProperty("true", new MockType(Boolean.TYPE), false, false, false);
        gen.visitProperty("int", new MockType(Integer.TYPE), false, false, false);
        gen.visitEnd();
        assertEquals(localize("public interface Foo {\n\tboolean isTrue();\n\tvoid setTrue(boolean value);\n\tint getInt();\n\tvoid setInt(int value);\n}\n"), gen.toString());
    }

    protected void setUp() throws Exception {
        super.setUp();
        gen = new JavaInterfaceGenerator();
    }

    private String localize(String s) {
        StringBuilder b = new StringBuilder(s.length() + s.length()/10);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '\t') {
                b.append("    ");
            } else if (ch == '\n') {
                b.append(SEP);
            } else {
                b.append(ch);
            }
        }
        return b.toString();
    }

    private static class MockType implements Type {
        private final Class javaClass;

        public MockType(Class javaClass) {
            this.javaClass = javaClass;
        }

        public String getName() {
            return javaClass.toString();
        }

        public String getURI() {
            throw new UnsupportedOperationException();
        }

        public Class getInstanceClass() {
            return javaClass;
        }

        public boolean isInstance(Object object) {
            throw new UnsupportedOperationException();
        }

        public List /*Property*/ getProperties() {
            throw new UnsupportedOperationException();
        }

        public Property getProperty(String propertyName) {
            throw new UnsupportedOperationException();
        }

        public boolean isDataType() {
            throw new UnsupportedOperationException();
        }

        public boolean isOpen() {
            throw new UnsupportedOperationException();
        }

        public boolean isSequenced() {
            throw new UnsupportedOperationException();
        }

        public boolean isAbstract() {
            throw new UnsupportedOperationException();
        }

        public List /*Type*/ getBaseTypes() {
            throw new UnsupportedOperationException();
        }

        public List /*Property*/ getDeclaredProperties() {
            throw new UnsupportedOperationException();
        }

        public List /*String*/ getAliasNames() {
            throw new UnsupportedOperationException();
        }
    }
}
