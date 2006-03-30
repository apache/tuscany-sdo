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
import java.util.List;

import commonj.sdo.Property;
import commonj.sdo.Type;

import org.apache.tuscany.sdo.SDOTypeVisitor;

/**
 * Implementation of a generator that will output the source code for a Java interface
 * that corresponds to the SDO Type's static properties.
 *
 * @version $Rev$ $Date$
 */
public class JavaInterfaceGenerator implements SDOTypeVisitor {
    
    private static String canonicalize(String className) {
        if (className == null) {
            return "";
        }
        if (className.charAt(0) != '[') { // if not array
            return className;
        }
        // process array
        boolean invalidClassName = false;
        int nestLevel = 1;
        StringBuffer sb = new StringBuffer();
        try {
            while (className.charAt(nestLevel) == '[') {
                nestLevel++;
            }
            char typeChar = className.charAt(nestLevel);
            int end = nestLevel;
            switch (typeChar) {
            case 'L':
                end = className.length() - 1;
                if (className.charAt(end) != ';') {
                    invalidClassName = true;
                } else {
                    sb.append(className.substring(nestLevel+1, end));    
                }
                break;
            case 'Z':
                sb.append("boolean"); 
                break;
            case 'B':
                sb.append("byte"); 
                break;
            case 'C':
                sb.append("char"); 
                break;
            case 'D':
                sb.append("double"); 
                break;
            case 'F':
                sb.append("float"); 
                break;
            case 'I':
                sb.append("int"); 
                break;
            case 'J':
                sb.append("long"); 
                break;
            case 'S':
                sb.append("short"); 
                break;
            default:
                invalidClassName = true;
                break;
            }
            if (end != (className.length() - 1)) {
                invalidClassName = true; // we have not used all the characters
            } else {
                for (int i=0; i<nestLevel; i++) {
                    sb.append("[]");
                }
            }
        } catch(Exception e) {
            invalidClassName = true;
        }
        if (invalidClassName) {
            System.err.println("unable to canonicalize class name: "+className);
            return className;
        }
        return sb.toString();
    }
    
    private final PrintWriter writer;

    /**
     * Constructor providing the Writer to output the source to.
     *
     * @param writer where the generated source code will be written to 
     */
    public JavaInterfaceGenerator(PrintWriter writer) {
        this.writer = writer;
    }

    public void visitType(Type type) {
        String name = type.getName();
        int lastDot = name.lastIndexOf('.');
        if (lastDot != -1) {
            writer.print("package ");
            writer.print(name.substring(0, lastDot));
            writer.println(';');
            writer.println();

            name = name.substring(lastDot + 1);
        } else {
            name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        }

        writer.print("public interface ");
        writer.print(name);
        List baseTypes = type.getBaseTypes();
        for (int i = 0; i < baseTypes.size(); i++) {
            Type baseType = (Type) baseTypes.get(i);
            if (i == 0) {
                writer.print(" extends ");
            } else {
                writer.print(", ");
            }
            writer.print(baseType.getInstanceClass().getName());
        }

        writer.println(" {");
    }

    public void visitProperty(Property property) {
        String name = property.getName();
        String propertyName = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        String javaType = canonicalize(property.getType().getInstanceClass().getName());

        if (!property.isMany()) {
            writer.print("    ");
            writer.print(javaType);
            writer.print("boolean".equals(javaType) ? " is" : " get");
            writer.print(propertyName);
            writer.println("();");
            if (!property.isReadOnly()) {
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

    public void visitEnd() {
        writer.println('}');
        writer.flush();
    }
}