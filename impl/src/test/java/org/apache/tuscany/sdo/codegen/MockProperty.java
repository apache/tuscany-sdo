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

/**
 * @version $Rev$ $Date$
 */
class MockProperty implements Property {
    private final String name;
    private final Type type;
    private final boolean many;
    private final boolean readOnly;

    public MockProperty(String name, Class type, boolean many, boolean readOnly) {
        this.name = name;
        this.type = new MockType(null, type);
        this.many = many;
        this.readOnly = readOnly;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public boolean isMany() {
        return many;
    }

    public boolean isContainment() {
        throw new UnsupportedOperationException();
    }

    public Type getContainingType() {
        throw new UnsupportedOperationException();
    }

    public Object getDefault() {
        throw new UnsupportedOperationException();
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public Property getOpposite() {
        throw new UnsupportedOperationException();
    }

    public List /*String*/ getAliasNames() {
        throw new UnsupportedOperationException();
    }
}
