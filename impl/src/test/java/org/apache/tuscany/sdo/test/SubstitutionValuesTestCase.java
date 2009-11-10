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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.api.SDOUtil;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.Type;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;

public final class SubstitutionValuesTestCase extends TestCase
{
  public void test() throws IOException
  {
    HelperContext hc = SDOUtil.createHelperContext();
    URL url = getClass().getResource("/SubstitutionValues.xsd");
    XSDHelper xsdHelper = hc.getXSDHelper();
    xsdHelper.define(url.openStream(), url.toString());

    XMLHelper xmlHelper = hc.getXMLHelper();
    DataObject loadedObject = 
        xmlHelper.load(getClass().getResourceAsStream("/substitutionValues1.xml")).getRootObject();
    Type type = loadedObject.getType();
    Sequence groupHeadSubstitutionValues = SDOUtil.getSubstitutionValues(loadedObject, type.getProperty("groupHead"));
    assertNotNull(groupHeadSubstitutionValues);
    assertNull(SDOUtil.getSubstitutionValues(loadedObject, type.getProperty("nonGroupHead")));
    
    String nsURI = "http://www.apache.org/tuscany/SubstitutionValues";
    DataObject createdObject = hc.getDataFactory().create(nsURI, "TestObject");
    Property groupMemberProperty = xsdHelper.getGlobalProperty(nsURI, "groupMember", true);
    createdObject.set(groupMemberProperty, groupHeadSubstitutionValues.getValue(0));
    createdObject.setString("nonGroupHead", loadedObject.getString("nonGroupHead"));
   
    assertTrue(hc.getEqualityHelper().equal(loadedObject, createdObject));
    
    ByteArrayOutputStream loadedBaos = new ByteArrayOutputStream();
    xmlHelper.save(loadedObject, nsURI, "testObject", loadedBaos);
    ByteArrayOutputStream createdBaos = new ByteArrayOutputStream();
    xmlHelper.save(createdObject, nsURI, "testObject", createdBaos);
    assertTrue(
        TestUtil.equalXmlFiles(
            new ByteArrayInputStream(loadedBaos.toByteArray()), 
            new ByteArrayInputStream(createdBaos.toByteArray())));
    
    loadedObject = 
      xmlHelper.load(getClass().getResourceAsStream("/substitutionValues2.xml")).getRootObject();
    groupHeadSubstitutionValues = SDOUtil.getSubstitutionValues(loadedObject, type.getProperty("groupHead"));
    
    createdObject = hc.getDataFactory().create(nsURI, "TestObject");
    createdObject.set("groupHead", groupHeadSubstitutionValues.getValue(0));
    createdObject.setString("nonGroupHead", loadedObject.getString("nonGroupHead"));
    
    assertTrue(hc.getEqualityHelper().equal(loadedObject, createdObject));
  }
}