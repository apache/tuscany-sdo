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
package org.apache.tuscany.sdo.test;

import java.io.IOException;
import java.net.URL;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.util.SDOUtil;

import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.XSDHelper;

public final class SubstitutionValuesTestCase extends TestCase
{
  public void test() throws IOException
  {
    URL url = getClass().getResource("/SubstitutionValues.xsd");
    XSDHelper.INSTANCE.define(url.openStream(), url.toString());

    final DataObject  object = DataFactory.INSTANCE.create("http://www.apache.org/tuscany/SubstitutionValues", "TestObject");
    final Type  type = object.getType();
    
    assertNotNull( SDOUtil.getSubstitutionValues(object, type.getProperty("groupHead")));
    assertNull( SDOUtil.getSubstitutionValues(object, type.getProperty("nonGroupHead")));
  }
}