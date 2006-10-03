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
package test;

import commonj.sdo.impl.HelperProvider;
import commonj.sdo.impl.ExternalizableDelegator;
import commonj.sdo.helper.CopyHelper;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.DataHelper;
import commonj.sdo.helper.EqualityHelper;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;

/**
 * @version $Revision$ $Date$
 */
public class TCCL1HelperProvider extends HelperProvider {
    public CopyHelper copyHelper() {
        throw new UnsupportedOperationException();
    }

    public DataFactory dataFactory() {
        throw new UnsupportedOperationException();
    }

    public DataHelper dataHelper() {
        throw new UnsupportedOperationException();
    }

    public EqualityHelper equalityHelper() {
        throw new UnsupportedOperationException();
    }

    public TypeHelper typeHelper() {
        throw new UnsupportedOperationException();
    }

    public XMLHelper xmlHelper() {
        throw new UnsupportedOperationException();
    }

    public XSDHelper xsdHelper() {
        throw new UnsupportedOperationException();
    }

    public ExternalizableDelegator.Resolvable resolvable() {
        throw new UnsupportedOperationException();
    }

    public ExternalizableDelegator.Resolvable resolvable(Object target) {
        throw new UnsupportedOperationException();
    }
}
