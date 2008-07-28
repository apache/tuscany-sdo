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

import java.util.List;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.util.SDOUtil;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.Type;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XSDHelper;

public class SequenceTestCase extends TestCase {
    HelperContext hc;
    Type type;
    Property localA, choiceX, choiceY, localB, open;

    String xml = "<schema xmlns=\"http://www.w3.org/2001/XMLSchema\" targetNamespace=\"testNS\" xmlns:tns=\"testNS\">"+
                   "<element name=\"open\" type=\"string\"/>"+
                   "<complexType name=\"Sequenced\">"+
                     "<sequence>"+
                       "<element name=\"localA\" type=\"string\" maxOccurs=\"unbounded\"/>"+
                       "<choice maxOccurs=\"unbounded\">"+
                         "<element name=\"choiceX\" type=\"string\"/>"+
                         "<element name=\"choiceY\" type=\"string\"/>"+
                       "</choice>"+
                       "<element name=\"localB\" type=\"string\"/>"+
                       "<any namespace=\"##any\" maxOccurs=\"unbounded\"/>"+
                     "</sequence>"+
                     "<anyAttribute/>"+
                   "</complexType>"+
		         "</schema>";

    protected void setUp() throws Exception {
        super.setUp();
        hc = SDOUtil.createHelperContext();
        hc.getXSDHelper().define(xml);
        type = hc.getTypeHelper().getType("testNS", "Sequenced");
        localA = type.getProperty("localA");
        choiceX = type.getProperty("choiceX");
        choiceY = type.getProperty("choiceY");
        localB = type.getProperty("localB");
        XSDHelper xsdHelper = hc.getXSDHelper();
        open = xsdHelper.getGlobalProperty("testNS", "open", true);
    }

    public void testSequenced() {
        DataObject dataObject = hc.getDataFactory().create(type);
        Sequence sequence = dataObject.getSequence();
        
        sequence.add(choiceX, "x1");
        sequence.add(0, localA, "a");
        sequence.add(choiceY, "y1");
        sequence.add(choiceX, "x2");
        sequence.add(localB, "b");
        sequence.add(open, "open");
        
        List list = dataObject.getList(localA);
        assertEquals(list.size(), 1);
        assertEquals(list.get(0), "a");

        assertEquals(dataObject.getString(localB), "b");
        
        list = dataObject.getList(choiceX);
        assertEquals(list.size(), 2);
        assertEquals(list.get(0), "x1");
        assertEquals(list.get(1), "x2");

        list = dataObject.getList(choiceY);
        assertEquals(list.size(), 1);
        assertEquals(list.get(0), "y1");
        
        list = dataObject.getList(open);
        assertEquals(list.size(), 1);
        assertEquals(list.get(0), "open");
    }
    
}
