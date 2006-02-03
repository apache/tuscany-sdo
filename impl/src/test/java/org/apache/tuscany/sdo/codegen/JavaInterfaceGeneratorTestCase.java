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

import java.io.PrintWriter;
import java.io.StringWriter;

import junit.framework.TestCase;

/**
 * @version $Rev$ $Date$
 */
public class JavaInterfaceGeneratorTestCase extends TestCase {
    private static final String SEP = System.getProperty("line.separator");

    private JavaInterfaceGenerator gen;
    private StringWriter writer;
    private MockType foo;

    public void testHeaderNoBaseClass() {
        gen.visitType(foo);
        gen.visitEnd();
        assertEquals(localize("public interface Foo {\n}\n"), writer.toString());
    }

    public void testHeaderWithPackage() {
        gen.visitType(new MockType("org.apache.Foo", null));
        gen.visitEnd();
        assertEquals(localize("package org.apache;\n\npublic interface Foo {\n}\n"), writer.toString());
    }

    public void testHeaderOneBaseClass() throws NoJavaImplementationException {
        foo.addBaseType(new MockType("bar1", Bar1.class));
        gen.visitType(foo);
        gen.visitEnd();
        assertEquals(localize("public interface Foo extends org.apache.tuscany.sdo.codegen.Bar1 {\n}\n"), writer.toString());
    }

    public void testHeaderMultipleBaseClass() throws NoJavaImplementationException {
        foo.addBaseType(new MockType("bar1", Bar1.class));
        foo.addBaseType(new MockType("bar2", Bar2.class));
        gen.visitType(foo);
        gen.visitEnd();
        assertEquals(localize("public interface Foo extends org.apache.tuscany.sdo.codegen.Bar1, org.apache.tuscany.sdo.codegen.Bar2 {\n}\n"), writer.toString());
    }

    public void testBooleanProperty() throws NoJavaImplementationException {
        gen.visitType(foo);
        gen.visitProperty(new MockProperty("true", Boolean.TYPE, false, false));
        gen.visitEnd();
        assertEquals(localize("public interface Foo {\n\tboolean isTrue();\n\tvoid setTrue(boolean value);\n}\n"), writer.toString());
    }

    public void testByteArrayProperty() throws NoJavaImplementationException {
        gen.visitType(foo);
        gen.visitProperty(new MockProperty("bytes", byte[].class, false, false));
        gen.visitEnd();
        assertEquals(localize("public interface Foo {\n\tbyte[] getBytes();\n\tvoid setBytes(byte[] value);\n}\n"), writer.toString());
    }

    public void testObjectProperty() throws NoJavaImplementationException {
        gen.visitType(foo);
        gen.visitProperty(new MockProperty("bar", Bar1.class, false, false));
        gen.visitEnd();
        assertEquals(localize("public interface Foo {\n\torg.apache.tuscany.sdo.codegen.Bar1 getBar();\n\tvoid setBar(org.apache.tuscany.sdo.codegen.Bar1 value);\n}\n"), writer.toString());
    }

    public void testReadOnlyProperty() throws NoJavaImplementationException {
        gen.visitType(foo);
        gen.visitProperty(new MockProperty("int", Integer.TYPE, false, true));
        gen.visitEnd();
        assertEquals(localize("public interface Foo {\n\tint getInt();\n}\n"), writer.toString());
    }

    public void testManyProperty() throws NoJavaImplementationException {
        gen.visitType(foo);
        gen.visitProperty(new MockProperty("list", Integer.TYPE, true, false));
        gen.visitEnd();
        assertEquals(localize("public interface Foo {\n\tjava.util.List getList();\n}\n"), writer.toString());
    }

    public void testTwoProperties() throws NoJavaImplementationException {
        gen.visitType(foo);
        gen.visitProperty(new MockProperty("true", Boolean.TYPE, false, false));
        gen.visitProperty(new MockProperty("int", Integer.TYPE, false, false));
        gen.visitEnd();
        assertEquals(localize("public interface Foo {\n\tboolean isTrue();\n\tvoid setTrue(boolean value);\n\tint getInt();\n\tvoid setInt(int value);\n}\n"), writer.toString());
    }

    protected void setUp() throws Exception {
        super.setUp();
        writer = new StringWriter();
        gen = new JavaInterfaceGenerator(new PrintWriter(writer));
        foo = new MockType("foo", null);
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

}
