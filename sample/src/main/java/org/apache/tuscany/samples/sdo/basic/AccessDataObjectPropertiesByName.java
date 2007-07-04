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

package org.apache.tuscany.samples.sdo.basic;

import java.util.List;

import org.apache.tuscany.samples.sdo.SampleBase;
import org.apache.tuscany.samples.sdo.SampleInfrastructure;


import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;

/**
 * Demonstrates accessing a DataObject's Property values by name.
 * 
 * This sample is from the <a href="http://incubator.apache.org/tuscany"
 * target="_blank"> Apache Tuscany</a> project. It was written to help users
 * understand and experiment with SDO. It is based upon code snippets contained
 * within, and is meant for use with, and reference to the <a
 * href="http://osoa.org/download/attachments/36/Java-SDO-Spec-v2.1.0-FINAL.pdf?version=1"
 * target="_bank">SDO Specification</a>.
 * <P>
 * <A HREF="overview.html">See here</A> for instructions on how to download
 */
public class AccessDataObjectPropertiesByName extends SampleBase {

    public AccessDataObjectPropertiesByName(Integer commentaryLevel) {
      super(commentaryLevel, SAMPLE_LEVEL_BASIC);
    }


    public static void main(String[] args) {
      AccessDataObjectPropertiesByName sample = new AccessDataObjectPropertiesByName(COMMENTARY_FOR_NOVICE);
      sample.run();

    }

    public void runSample () throws Exception {

        banner("This sample will access a DataObject's properties by name\n"+
            "Take a look at the sample code to see all the uses of dataObject.get(String)\n"+
            "dataObject.getList(String) and dataobhect.getdataObject(String)");

        // setting up the type system for the example,  see the utility methods for details of these operations
        HelperContext scope = createScopeForTypes();
        loadTypesFromXMLSchemaFile(scope, SampleInfrastructure.PO_XSD_RESOURCE);

        DataObject purchaseOrder = getDataObjectFromFile(scope, SampleInfrastructure.PO_XML_RESOURCE);


        System.out.println("Accessing properties by name");
        System.out.println("Purchase Order: ");
        System.out.println("    Order date: " + purchaseOrder.get("orderDate"));
        System.out.println("    Comment: " + purchaseOrder.get("comment"));
        
        DataObject shipTo = purchaseOrder.getDataObject("shipTo");
        System.out.println("    Ship to name: " + shipTo.get("name"));
        
        DataObject billTo = purchaseOrder.getDataObject("billTo");
        System.out.println("    Bill to name: " + billTo.get("name"));
        
        DataObject items = purchaseOrder.getDataObject("items");
        List itemList = items.getList("item");
        
        System.out.println("    Items:");
        for (int i = 0; i < itemList.size(); i++) {
            DataObject item = (DataObject) itemList.get(i);
            System.out.println("        Item " + i);
            System.out.println("            Part num: " + item.get("partNum"));
            System.out.println("            Product name: " + item.get("productName"));
        }

    }

}