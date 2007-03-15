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

import junit.framework.TestCase;

import org.apache.tuscany.sdo.util.SDOUtil;

import commonj.sdo.helper.CopyHelper;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.DataHelper;
import commonj.sdo.helper.EqualityHelper;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;
import commonj.sdo.impl.HelperProvider;

public class HelperContextTestCase extends TestCase {

  public void testDefaultHelperContext() {
    HelperContext defaultHelperContext = HelperProvider.getDefaultContext();
    
    assertNotNull(defaultHelperContext.getCopyHelper());
    assertEquals(defaultHelperContext.getCopyHelper(), CopyHelper.INSTANCE);
    assertNotNull(defaultHelperContext.getDataFactory());
    assertEquals(defaultHelperContext.getDataFactory(), DataFactory.INSTANCE);
    assertNotNull(defaultHelperContext.getDataHelper());
    assertEquals(defaultHelperContext.getDataHelper(), DataHelper.INSTANCE);
    assertNotNull(defaultHelperContext.getEqualityHelper());
    assertEquals(defaultHelperContext.getEqualityHelper(), EqualityHelper.INSTANCE);
    assertNotNull(defaultHelperContext.getTypeHelper());
    assertEquals(defaultHelperContext.getTypeHelper(), TypeHelper.INSTANCE);
    assertNotNull(defaultHelperContext.getXMLHelper());
    assertEquals(defaultHelperContext.getXMLHelper(), XMLHelper.INSTANCE);
    assertNotNull(defaultHelperContext.getXSDHelper());
    assertEquals(defaultHelperContext.getXSDHelper(), XSDHelper.INSTANCE);
    
  }
  
  public void testCreateHelperContext() {
    HelperContext hc = SDOUtil.createHelperContext();
    assertNotNull(hc.getCopyHelper());
    assertNotNull(hc.getDataFactory());
    assertNotNull(hc.getDataHelper());
    assertNotNull(hc.getEqualityHelper());
    assertNotNull(hc.getTypeHelper());
    assertNotNull(hc.getXMLHelper());
    assertNotNull(hc.getXSDHelper());
    
    assertNotSame(hc.getDataFactory(), DataFactory.INSTANCE);
    assertNotSame(hc.getTypeHelper(), TypeHelper.INSTANCE);
    assertNotSame(hc.getXMLHelper(), XMLHelper.INSTANCE);
    assertNotSame(hc.getXSDHelper(), XSDHelper.INSTANCE);
    // the other "stateless" helpers may be the same as the singletons
  }

}
