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
package org.apache.tuscany.sdo;

import java.lang.reflect.Method;

import commonj.sdo.Property;

/**
 * Visitor interface that allows applications to visit SDO Property metadata.
 * @version $Rev$ $Date$
 */
public interface SDOPropertyVisitor {
    /**
     * Visit the default value for this property.
     * @param defaultValue the default value for this property
     * @return this visitor
     */
    SDOPropertyVisitor visitDefault(Object defaultValue);

    /**
     * Visit the declaration of an alias for this property.
     *
     * @param aliasName an alias for this property
     * @return this visitor
     */
    SDOPropertyVisitor visitAlias(String aliasName);

    /**
     * Visit the property opposite of this property.
     * @param opposite the opposing property
     * @return this visitor
     */
    SDOPropertyVisitor visitOpposite(Property opposite);

    /**
     * Visit a Java method that can be used to read this property. A Java interface must be
     * associated with this property's containing type and must contain this method.
     * The method signature must follow the JavaBean naming convention and its return type
     * must be compatible with the Java type of this property.
     *
     * @param getter a method that can be used to read this property
     * @return this visitor
     */
    SDOPropertyVisitor visitGetter(Method getter);

    /**
     * Visit a Java method that can be used to set this property. A Java interface must be
     * associated with this property's containing type and must contain this method.
     * The method signature must follow the JavaBean naming convention and its parameter type
     * must be compatible with the Java type of this property.
     *
     * @param setter a method that can be used to read this property
     * @return this visitor
     */
    SDOPropertyVisitor visitSetter(Method setter);

    /**
     * Indicate that this visitor will not be called again.
     */
    void visitEnd();
}
