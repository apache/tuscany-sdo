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

import commonj.sdo.Type;

import org.apache.tuscany.sdo.codegen.GenerationException;

/**
 * Visitor interface that allows applications to process SDO type metadata.
 *
 * @version $Rev$ $Date$
 */
public interface SDOTypeVisitor {
    /**
     * Visit the type definition.
     *
     * @param namespace  the namespace that the type is declared in
     * @param name       the name of the type
     * @param open       true if the type is open
     * @param sequenced  true if the type is sequenced
     * @param isAbstract true if the type is abstract
     * @return this visitor
     */
    SDOTypeVisitor visitType(String namespace, String name, boolean open, boolean sequenced, boolean isAbstract);

    /**
     * Visit the declaration of a base type this type extends.
     *
     * @param baseType a base type this type extends
     * @return this visitor
     */
    SDOTypeVisitor visitBaseType(Type baseType) throws GenerationException;

    /**
     * Visit the declaration of an alias for this type.
     *
     * @param aliasName an alias for this type
     * @return this visitor
     */
    SDOTypeVisitor visitAlias(String aliasName);

    /**
     * Visit a property declared by this type. Property indices are determined by the order in which
     * properties are visited.
     *
     * @param name     the name of the property
     * @param type     the SDO type of the property
     * @param many     true if the property is multi-valued
     * @param contains true if the property is a containing property
     * @param readOnly true if the property only supports read access through the SDO API
     * @return a property visitor that can be used to visit the property
     */
    SDOPropertyVisitor visitProperty(String name, Type type, boolean many, boolean contains, boolean readOnly) throws GenerationException;

    /**
     * Visit the Java type associated with this SDO type.
     *
     * @param javaType the Java type for an interface associated with this SDO type
     * @return this visitor
     */
    SDOTypeVisitor visitJavaType(java.lang.reflect.Type javaType);

    /**
     * Indicate that this visitor will not be called again.
     */
    void visitEnd();
}
