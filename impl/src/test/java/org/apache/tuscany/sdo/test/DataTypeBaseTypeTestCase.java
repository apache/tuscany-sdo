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
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import junit.framework.TestCase;

import commonj.sdo.Type;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XSDHelper;


public class DataTypeBaseTypeTestCase extends TestCase {
    private final String TEST_MODEL = "/datatype.xsd";
    private final String TEST_NAMESPACE = "http://www.example.com/datatype";

    public void testSimpleSDOType() throws IOException
    {
      Type type = TypeHelper.INSTANCE.getType(TEST_NAMESPACE, "SimpleSDOType");
      List baseTypes = type.getBaseTypes();
      assertTrue(baseTypes.size() == 1);
    }
    
    public void testSimpleSDOTypeInstanceClass() throws IOException
    {
      Type type = TypeHelper.INSTANCE.getType(TEST_NAMESPACE, "SimpleSDOTypeInstanceClass");
      List baseTypes = type.getBaseTypes();
      assertTrue(baseTypes.size() == 0);
    }
    
    public void testSimpleSDOTypeExtendedInstanceClass() throws IOException
    {
      Type type = TypeHelper.INSTANCE.getType(TEST_NAMESPACE, "SimpleSDOTypeExtendedInstanceClass");
      List baseTypes = type.getBaseTypes();
      assertTrue(baseTypes.size() == 1);
    }

    public void setUp() throws Exception
    {
      URL url = getClass().getResource(TEST_MODEL);
      InputStream inputStream = url.openStream();
      XSDHelper.INSTANCE.define(inputStream, url.toString());
      inputStream.close();   
    }

}
