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

import commonj.sdo.Type;

/**
 * Exception that indicates there is no Java mapping for an SDO type.
 *
 * @version $Rev$ $Date$
 */
public class NoJavaImplementationException extends GenerationException {
    private final Type type;

    /**
     * Constructor supplying the Type that did not have a Java implementation.
     * A default message is provided of the form "${URI}#${Name}"
     *
     * @param type the type that did not have a Java implementation.
     */
    public NoJavaImplementationException(Type type) {
        super(type == null ? null : type.getURI() + "#" + type.getName());
        this.type = type;
    }

    /**
     * Constructor supplying a message and the Type that did not have a Java implementation.
     *
     * @param message the message
     * @param type the type that did not have a Java implementation.
     */
    public NoJavaImplementationException(String message, Type type) {
        super(message);
        this.type = type;
    }

    /**
     * Return the type that did not have a Java implementation.
     * @return the type that did not have a Java implementation
     */
    public Type getType() {
        return type;
    }
}
