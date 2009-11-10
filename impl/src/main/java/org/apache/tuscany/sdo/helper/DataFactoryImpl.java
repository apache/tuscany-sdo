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
package org.apache.tuscany.sdo.helper;

import org.apache.tuscany.sdo.util.DataObjectUtil;

import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.HelperContext;

/**
 * A Factory for creating DataObjects. The created DataObjects are not connected
 * to any other DataObjects.
 */
public class DataFactoryImpl implements DataFactory {
    protected HelperContext helperContext;

    public DataFactoryImpl(HelperContext hc) {
        this.helperContext = hc;
    }

    public DataObject create(String uri, String typeName) {
        Type type = helperContext.getTypeHelper().getType(uri, typeName);
        return create(type);
    }

    public DataObject create(Class interfaceClass) {
        // TODO more efficient implementation ... this is a really bad one!
        Type type = helperContext.getTypeHelper().getType(interfaceClass);
        return create(type);
    }

    public DataObject create(Type type) {
        return DataObjectUtil.create(type);
    }

    public HelperContext getHelperContext() {
        return helperContext;
    }

}
