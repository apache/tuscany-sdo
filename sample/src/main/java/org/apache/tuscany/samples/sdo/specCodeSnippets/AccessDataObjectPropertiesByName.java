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

package org.apache.tuscany.samples.sdo.specCodeSnippets;

import java.util.List;

import org.apache.tuscany.samples.sdo.SampleBase;
import org.apache.tuscany.samples.sdo.SdoSampleConstants;

import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;

/**
 * Demonstrates accessing a created DataObject's properties by name.
 * 
 * This sample is from the <a href="http://incubator.apache.org/tuscany"
 * target="_blank"> Apache Tuscany</a> project. It was written to help users
 * understand and experiment with SDO. It is based upon code snippets contained
 * within, and is meant for use with, and reference to the <a
 * href="http://osoa.org/download/attachments/36/Java-SDO-Spec-v2.1.0-FINAL.pdf?version=1"
 * target="_bank">SDO Specification</a>.
 * 
 * <br>
 * <br>
 * <b>Usage:</b> <br>
 * This sample can easily be run from within Eclipse as a Java Application if tuscany or 
 * the sample-sdo project is imported into Eclipse as an existing project.
 * <br><br>
 * If executing as a standalone application please do the following: 
 * <br>
 * <UL>
 * <LI>Include the following jar files on your classpath :
 * <UL>
 * <LI>SDO API and Tuscany Implementation
 * <UL>
 * <LI>sdo-api-{version}.jar - SDO API
 * <LI>tuscany-sdo-impl-{version}.jar - Tuscany SDO implementation
 * </UL>
 * </LI>
 * <LI>EMF dependencies. 
 * <UL>
 * <LI>emf-common-{version}.jar - some common framework utility and base classes
 * <LI>emf-ecore-{version}.jar - the EMF core runtime implementation classes (the Ecore metamodel)
 * <LI>emf-ecore-change-{version}.jar - the EMF change recorder and framework
 * <LI>emf-ecore-xmi-{version}.jar - EMF's default XML (and XMI) serializer and loader
 * <LI>xsd-{version}.jar - the XML Schema model
 * </UL>
 * </LI>
 * </UL>
 * 
 * These jar files can be obtained by downloading and unpacking a <a href="http://cwiki.apache.org/TUSCANY/sdo-downloads.html" target="_blank">Tuscany binary distribution</a> </LI>
 * <LI>Execute: <br>
 * java org.apache.tuscany.samples.sdo.specCodeSnippets.AccessDataObjectPropertiesByName</LI>
 * </UL>
 */
public class AccessDataObjectPropertiesByName extends SampleBase {

    HelperContext scope;

    public AccessDataObjectPropertiesByName(int userLevel) {
      super(userLevel);
    }

    /**
     * Prints a subset of PurchaseOrder properties to System.out
     * 
     * @param purchaseOrder.
     *            DataObject defined by Types in
     *            {@link org.apache.tuscany.samples.sdo.SdoSampleConstants#PO_XSD_RESOURCE}
     */
    public static void printPurchaseOrderSummary(DataObject purchaseOrder) {

        // example accessing properties via property names
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

    /**
     * Prints properties of a purchase order DataObject( properties are defined in
     * the xsd
     * {@link org.apache.tuscany.samples.sdo.SdoSampleConstants#PO_XSD_RESOURCE} and
     * populated by xml
     * {@link org.apache.tuscany.samples.sdo.SdoSampleConstants#PO_XML_RESOURCE} )
     * 
     * @param args.
     *            No parameters required.
     */
    public static void main(String[] args) {
      // TODO make the default level NOVICE, once the rest of the sample has been
      // converted to using commentary()
      AccessDataObjectPropertiesByName sample = new AccessDataObjectPropertiesByName(INTERMEDIATE);

      try {
        sample.run();
      }
      catch (Exception e) {
        sample.somethingUnexpectedHasHappened(e);
      }
    }

    public void run () throws Exception {

        // information
        System.out.println("***************************************");
        System.out.println("SDO Sample AccessDataObjectPropertiesByName");
        System.out.println("***************************************");
        System.out.println("This sample will access a DataObject properties by name");
        System.out.println("***************************************");

        // create a DataObejct
        scope = createScopeForTypes();
        
        DataObject purchaseOrder = null;
        try {
            scope.getXSDHelper().define(ClassLoader.getSystemResourceAsStream(SdoSampleConstants.PO_XSD_RESOURCE), null);           
            purchaseOrder = scope.getXMLHelper().load(ClassLoader.getSystemResourceAsStream(SdoSampleConstants.PO_XML_RESOURCE)).getRootObject();
            System.out.println("DataObject created");
        } catch (Exception e) {
            System.out.println("Error creating DataObject " + e.toString());
            e.printStackTrace();
            return;
        }

        // start of sample
        try {
            System.out.println("Accessing properties by name");
            printPurchaseOrderSummary(purchaseOrder);
        } catch (Exception e) {
            System.out.println("Sorry there was an error accessing properties by name " + e.toString());
            e.printStackTrace();
        }
        System.out.println("GoodBye");
        // end of sample
    }

}
