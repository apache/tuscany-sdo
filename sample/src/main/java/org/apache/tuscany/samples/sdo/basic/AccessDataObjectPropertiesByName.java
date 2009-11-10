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
import org.apache.tuscany.samples.sdo.internal.SampleInfrastructure;

import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;

/**
 * Demonstrates accessing a DataObject's Property values by name.
 * <p>
 * <h3>Running this Sample</h3> See <A HREF="../../../../../../index.html" 
 * target="_top">the main overview</A> for instructions on how to run this 
 * sample.
 */
public class AccessDataObjectPropertiesByName extends SampleBase {

    public AccessDataObjectPropertiesByName(Integer commentaryLevel) {
      super(commentaryLevel, SAMPLE_LEVEL_BASIC);
    }


    public static void main(String[] args) {
      AccessDataObjectPropertiesByName sample = new AccessDataObjectPropertiesByName(COMMENTARY_FOR_NOVICE);
      sample.run();

    }
    
    /*
     *  metadata for the sample documenting the areas of SDO that are explored
     */
    public static int [] CORE_FUNCTION = {
      SDOFacets.GET_PROPERTIES_OF_DATAOBJECT_BY_NAME
    };

    public void runSample () throws Exception {

        banner("This sample will access a DataObject's properties by name\n"+
            "Take a look at the sample code to see all the uses of dataObject.get(String)\n"+
            "dataObject.getList(String) and dataObject.getDataObject(String)");

        // setting up the type system for the example,  see the utility methods for details of these operations
        HelperContext scope = createScopeForTypes();
        loadTypesFromXMLSchemaFile(scope, SampleInfrastructure.PO_XSD_RESOURCE);

        DataObject purchaseOrder = getDataObjectFromFile(scope, SampleInfrastructure.PO_XML_RESOURCE);

        System.out.println("Accessing properties of purchaseOrder by name");
        System.out.println("Purchase Order: ");
        System.out.println("    purchaseOrder.get(\"orderDate\"): " + purchaseOrder.get("orderDate"));
        System.out.println("    purchaseOrder.get(\"comment\"): " + purchaseOrder.get("comment"));
        
        System.out.println("    DataObject shipTo = purchaseOrder.getDataObject(\"shipTo\");");
        DataObject shipTo = purchaseOrder.getDataObject("shipTo");
        System.out.println("    shipTo.get(\"name\"): " + shipTo.get("name"));
        
        System.out.println("    DataObject billTo = purchaseOrder.getDataObject(\"billTo\");");
        DataObject billTo = purchaseOrder.getDataObject("billTo");
        System.out.println("    billTo.get(\"name\"): " + billTo.get("name"));
        
        System.out.println("    DataObject items = purchaseOrder.getDataObject(\"items\");\n" +
        		               "    List itemList = items.getList(\"item\");\n" +
        		               "    DataObject item = (DataObject) itemList.get(i);");
        DataObject items = purchaseOrder.getDataObject("items");
        List itemList = items.getList("item");
        
        System.out.println("    Items:");
        for (int i = 0; i < itemList.size(); i++) {
            DataObject item = (DataObject) itemList.get(i);
            System.out.println("        item[" + i + "]");
            System.out.println("            item.get(\"partNum\"): " + item.get("partNum"));
            System.out.println("            item.get(\"productName\"): " + item.get("productName"));
        }

    }

}
