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
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Method;

import commonj.sdo.Type;
import commonj.sdo.Property;

import org.apache.tuscany.sdo.SDOPropertyVisitor;
import org.apache.tuscany.sdo.SDOTypeVisitor;

/**
 * @version $Rev$ $Date$
 */
public class JavaInterfaceGenerator implements SDOTypeVisitor {
    private String packageName;
    private String interfaceName;
    private List<Type> baseTypes = new ArrayList<Type>();
    private List<PropVisitor> props = new ArrayList<PropVisitor>();

    public SDOTypeVisitor visitType(String namespace, String name, boolean open, boolean sequenced, boolean isAbstract) {
        int lastDot = name.lastIndexOf('.');
        if (lastDot == -1) {
            packageName = null;
            this.interfaceName = name;
        } else {
            packageName = name.substring(0, lastDot);
            interfaceName = name.substring(lastDot + 1);
        }
        return this;
    }

    public SDOTypeVisitor visitBaseType(Type baseType) throws NoJavaImplementationException {
        if (baseType.getInstanceClass() == null) {
            throw new NoJavaImplementationException(baseType);
        }
        baseTypes.add(baseType);
        return this;
    }

    public SDOTypeVisitor visitAlias(String aliasName) {
        return this;
    }

    public SDOPropertyVisitor visitProperty(String name, Type type, boolean many, boolean contains, boolean readOnly) throws NoJavaImplementationException {
        if (type.getInstanceClass() == null) {
            throw new NoJavaImplementationException(type);
        }
        PropVisitor propVisitor = new PropVisitor(name, type, many, readOnly);
        props.add(propVisitor);
        return propVisitor;
    }

    public SDOTypeVisitor visitJavaType(java.lang.reflect.Type javaType) {
        if (javaType instanceof Class<?>) {
            Class<?> javaClass = (Class<?>) javaType;
            packageName = javaClass.getPackage().getName();
            interfaceName = javaClass.getSimpleName();
        } else {
            throw new UnsupportedOperationException();
        }
        return this;
    }

    public void visitEnd() {
    }

    public void writeTo(PrintWriter writer) {
        if (packageName != null) {
            writer.print("package ");
            writer.print(packageName);
            writer.println(';');
            writer.println();
        }
        writer.print("public interface ");
        writer.print(interfaceName);
        for (int i = 0; i < baseTypes.size(); i++) {
            Type type = baseTypes.get(i);
            if (i == 0) {
                writer.print(" extends ");
            } else {
                writer.print(", ");
            }
            writer.print(type.getInstanceClass().getName());
        }
        writer.println(" {");
        for (PropVisitor prop : props) {
            prop.writeTo(writer);
        }
        writer.println('}');
    }

    public String toString() {
        StringWriter out = new StringWriter();
        PrintWriter writer = new PrintWriter(out);
        writeTo(writer);
        writer.flush();
        return out.toString();
    }

    private static class PropVisitor implements SDOPropertyVisitor {
        private final String name;
        private final Type type;
        private final boolean many;
        private final boolean readOnly;

        public PropVisitor(String name, Type type, boolean many, boolean readOnly) {
            this.name = name;
            this.type = type;
            this.many = many;
            this.readOnly = readOnly;
        }

        public SDOPropertyVisitor visitDefault(Object defaultValue) {
            return this;
        }

        public SDOPropertyVisitor visitAlias(String aliasName) {
            throw new UnsupportedOperationException();
        }

        public SDOPropertyVisitor visitOpposite(Property opposite) {
            return this;
        }

        public SDOPropertyVisitor visitGetter(Method getter) {
            throw new UnsupportedOperationException();
        }

        public SDOPropertyVisitor visitSetter(Method setter) {
            throw new UnsupportedOperationException();
        }

        public void visitEnd() {
        }

        public void writeTo(PrintWriter writer) {
            String propertyName = Character.toUpperCase(name.charAt(0)) + name.substring(1);
            String javaType = type.getInstanceClass().getCanonicalName();

            if (!many) {
                writer.print("    ");
                writer.print(javaType);
                writer.print("boolean".equals(javaType) ? " is" : " get");
                writer.print(propertyName);
                writer.println("();");
                if (!readOnly) {
                    writer.print("    void set");
                    writer.print(propertyName);
                    writer.print('(');
                    writer.print(javaType);
                    writer.println(" value);");
                }
            } else {
                writer.print("    java.util.List get");
                writer.print(propertyName);
                writer.println("();");
            }
        }
    }
}
