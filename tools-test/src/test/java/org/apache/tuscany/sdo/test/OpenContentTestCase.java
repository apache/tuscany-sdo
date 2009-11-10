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

import junit.framework.TestCase;

import org.apache.tuscany.sdo.api.SDOUtil;

import com.example.open.OneElementAndAnyAttr;
import com.example.open.OpenFactory;
import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.helper.HelperContext;


public class OpenContentTestCase extends TestCase
{
  
  HelperContext scope;

  public void testAnyAttribute() throws IOException
  {

      OpenFactory.INSTANCE.register(scope);
      DataObject dob = scope.getDataFactory().create(OneElementAndAnyAttr.class);
      OneElementAndAnyAttr staticDob = (OneElementAndAnyAttr)dob;

      staticDob.setName("fred");
      
      assertEquals(1, dob.getInstanceProperties().size());
      Sequence s = ((OneElementAndAnyAttr)dob).getAnyAttribute();

      assertFalse(dob.getType().isSequenced());
      assertTrue(dob.getType().isOpen());
      assertNull(dob.getSequence());
      
      Property prop = scope.getTypeHelper().getOpenContentProperty("http://www.example.com/open", "globAttribute");
      s.add(prop, "foo");
      assertEquals(2, dob.getInstanceProperties().size());
      assertTrue(dob.getInstanceProperties().contains(prop));

      // scope.getXMLHelper().save((DataObject)dob, "http://www.example.com/open", "bar", System.out);
  }

  protected void setUp() throws Exception {
    scope = SDOUtil.createHelperContext();
    super.setUp();
  }
  
  protected void tearDown() throws Exception {
  	super.tearDown();
  }

  
}
