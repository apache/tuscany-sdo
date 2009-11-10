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
import commonj.sdo.helper.XMLDocument;

/**
 * Reads purchase order DataObject from XML, based upon Fuhwei Lwo's paper <A
 * HREF="http://www-128.ibm.com/developerworks/webservices/library/ws-sdoxmlschema/">
 * Create and read an XML document based on XML Schema</A>.
 * <p>
 * <h3>Running this Sample</h3> See <A HREF="../../../../../../index.html" 
 * target="_top">the main overview</A> for instructions on how to run this 
 * sample.
 * 
 */
public class ReadPurchaseOrder extends SampleBase {

  
  public static String purchaseOrderDoc = 
    "<?xml version=\"1.0\" encoding=\"ASCII\"?>\n"+
    "    <po:purchaseOrder xmlns:po=\"http://www.example.com/PO\" orderDate=\"1999-10-20\">\n"+
    "      <shipTo country=\"US\">\n"+
    "        <name>Alice Smith</name>\n"+
    "        <street>123 Maple Street</street>\n"+
    "        <city>Mill Valley</city>\n"+
    "        <state>CA</state>\n"+
    "        <zip>90952</zip>\n"+
    "      </shipTo>\n"+
    "      <billTo country=\"US\">\n"+
    "        <name>Robert Smith</name>\n"+
    "        <street>8 Oak Avenue</street>\n"+
    "        <city>Mill Valley</city>\n"+
    "        <state>PA</state>\n"+
    "        <zip>95819</zip>\n"+
    "      </billTo>\n"+
    "      <po:comment>Hurry, my lawn is going wild!</po:comment>\n"+
    "      <items>\n"+
    "        <item partNum=\"872-AA\">\n"+
    "          <productName>Lawnmower</productName>\n"+
    "          <price>148.95</price>\n"+
    "          <quantity>1</quantity>\n"+
    "          <po:comment>Confirm this is electric</po:comment>\n"+
    "        </item>\n"+
    "        <item partNum=\"926-AA\">\n"+
    "          <productName>Baby Monitor</productName>\n"+
    "          <price>39.98</price>\n"+
    "          <quantity>1</quantity>\n"+
    "          <shipDate>1999-05-21</shipDate>\n"+
    "        </item>\n"+
    "      </items>\n"+
    "    </po:purchaseOrder>\n";

    public ReadPurchaseOrder(Integer commentaryLevel) {
      super(commentaryLevel, SampleInfrastructure.SAMPLE_LEVEL_BASIC);
    }

    public static void main(String[] args) {
      ReadPurchaseOrder sample = new ReadPurchaseOrder(COMMENTARY_FOR_NOVICE);
      sample.run();

    }
    
    /*
     *  metadata for the sample documenting the areas of SDO that are explored
     */
    public static int [] CORE_FUNCTION = {
      SDOFacets.LOADING_DATA_FROM_XML,
      SDOFacets.SAVING_DATA_TO_XML
    };
    public static int [] SIGNIFICANT_FUNCTION = {
      SDOFacets.GET_PROPERTIES_OF_DATAOBJECT_BY_NAME
    };



    public void runSample () throws Exception {
        commentary(COMMENTARY_ALWAYS,
            "This sample is based upon Fuhwei Lwo's paper \n"+
            "http://www-128.ibm.com/developerworks/webservices/library/ws-sdoxmlschema/\n");

        HelperContext scope = createScopeForTypes();
        
        loadTypesFromXMLSchemaFile(scope, SampleInfrastructure.PO_XSD_RESOURCE);

        commentary(
            "We load the purchase order document into an instance of XMLDocument\n\n"+
            "XMLDocument xmlDoc = getXMLDocumentFromString(scope, purchaseOrderDoc);\n");

        XMLDocument xmlDoc = getXMLDocumentFromString(scope, purchaseOrderDoc);      

        commentary(
            "We then retrieve the root DataObject from the XMLDocument\n"+
            "then print out some of the details\n\n"+
            "DataObject purchaseOrder = xmlDoc.getRootObject();");
        
        DataObject purchaseOrder = xmlDoc.getRootObject();

        System.out.println("Order date: " + purchaseOrder.get("orderDate"));
        System.out.println("Comment: " + purchaseOrder.get("comment"));

        DataObject shipTo = purchaseOrder.getDataObject("shipTo");
        System.out.println("Ship to name: " + shipTo.get("name"));

        DataObject billTo = purchaseOrder.getDataObject("billTo");
        System.out.println("Bill to name: " + billTo.get("name"));
        System.out.println();

        DataObject items = purchaseOrder.getDataObject("items");
        List itemList = items.getList("item");
        for (int i = 0; i < itemList.size(); i++) {

            DataObject item = (DataObject) itemList.get(i);

            System.out.println("Part num: " + item.get("partNum"));
            System.out.println("Product name: " + item.get("productName"));
        }

    }


}
