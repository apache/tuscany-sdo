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

import java.util.List;

import commonj.sdo.Property;
import commonj.sdo.Type;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import org.apache.tuscany.sdo.SDOTypeVisitor;

/**
 * Implementation of a generator that will directly emit bytecode for an interface that
 * corresponds to the static properties of a SDO type.
 *
 * @version $Rev$ $Date$
 */
public class BytecodeInterfaceGenerator implements SDOTypeVisitor {
    private final ClassWriter cw;

    public BytecodeInterfaceGenerator() {
        cw = new ClassWriter(false);
    }

    public void visitType(Type type) {
        String name = type.getName();
        int lastDot = name.lastIndexOf('.');
        if (lastDot != -1) {
            name = name.replace('.', '/');
        } else {
            name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        }

        List baseTypes = type.getBaseTypes();
        String[] interfaces = new String[baseTypes.size()];
        for (int i = 0; i < baseTypes.size(); i++) {
            Type baseType = (Type) baseTypes.get(i);
            interfaces[i] = baseType.getInstanceClass().getName().replace('.', '/');
        }

        cw.visit(Opcodes.V1_4,
                 Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT + Opcodes.ACC_INTERFACE,
                 name, null, "java/lang/Object", interfaces);
    }

    public void visitProperty(Property property) {
        String name = property.getName();
        String propertyName = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        Class javaType = property.getType().getInstanceClass();
        String desc = org.objectweb.asm.Type.getDescriptor(javaType);

        if (property.isMany()) {
            cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT, "get" + propertyName, "()Ljava/util/List;", null, null).visitEnd();
        } else {
            if (boolean.class.equals(javaType)) {
                cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT, "is" + propertyName, "()Z", null, null).visitEnd();
            } else {
                cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT, "get" + propertyName, "()" + desc, null, null).visitEnd();
            }
            if (!property.isReadOnly()) {
                cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT, "set" + propertyName, '(' + desc + ")V", null, null).visitEnd();
            }
        }
    }

    public void visitEnd() {
        cw.visitEnd();
    }

    /**
     * Return the bytecode for the interface class in a form that can be written
     * to disk, added to a JAR file, or passed to a ClassLoader.
     *
     * @return the bytecode for the SDO Type's interface class
     */
    public byte[] getClassData() {
        return cw.toByteArray();
    }
}
