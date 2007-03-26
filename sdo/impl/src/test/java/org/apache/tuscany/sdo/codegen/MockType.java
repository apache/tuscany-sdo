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
import java.util.ArrayList;

import commonj.sdo.Type;
import commonj.sdo.Property;

/**
 * @version $Rev$ $Date$
 */
class MockType implements Type {
    private final String name;
    private final Class javaClass;
    private final List baseTypes = new ArrayList();

    public MockType(String name, Class javaClass) {
        this.javaClass = javaClass;
        this.name = name;
    }

    public void addBaseType(Type baseType) {
        baseTypes.add(baseType);
    }

    public String getName() {
        return name;
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
        return baseTypes;
    }

    public List /*Property*/ getDeclaredProperties() {
        throw new UnsupportedOperationException();
    }

    public List /*String*/ getAliasNames() {
        throw new UnsupportedOperationException();
    }
    
    public List getInstanceProperties() {
        throw new UnsupportedOperationException();
    }

    public Object get(Property property) {
        throw new UnsupportedOperationException();
    }
}
