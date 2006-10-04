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

package org.apache.tuscany.samples.sdo.specExampleSection;

import java.io.FileOutputStream;
import java.io.OutputStream;

import commonj.sdo.DataObject;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;

import org.apache.tuscany.samples.sdo.SdoSampleConstants;

/**
 * Demonstrates programmatically creating a DataObject and generating an XML String.
 * <br>
 * The following sample is from the <a href="http://incubator.apache.org/tuscany"
 * target="_blank"> Apache Tuscany</a> project. It was written to help users
 * understand and experiement with SDO. It is based upon example code contained
 * within, and is meant for use with, and reference to the <a
 * href="http://www.osoa.org/download/attachments/791/SDO_Specification_Java_V2.01.pdf?version=1"
 * target="_bank">SDO Specification</a>. In general this sample attempts to use the
 * code and comments contained within the specification, exceptions to this are noted
 * in comments.<br>
 * <br>
 * Specifically this sample is based upon the 'Creating XML from DataObjects' example
 * from the SDO specification's Examples section. <br>
 * <br>
 * Uses previously defined model
 * {@link org.apache.tuscany.samples.sdo.SdoSampleConstants#PO_XSD_RESOURCE} to
 * define types then generates a purchase order DataObject and persists to
 * {@link org.apache.tuscany.samples.sdo.SdoSampleConstants#PO_XML_GENERATED}
 * <br><br>
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
 * These jar files can be obtained from directly from Tuscany and EMF projects or from <a
 * href="http://wiki.apache.org/ws-data/attachments/Tuscany(2f)TuscanyJava(2f)SDO_Java_Overview/attachments/SDO%20Execution%20Dependencies"
 * target="_bank">SDO Execution Dependancies </a> </LI>
 * <LI>Execute: <br>
 * java org.apache.tuscany.samples.sdo.specExampleSection.CreatingXmlFromDataObjects</LI>
 * </UL>
 * 
 * @author Robbie Minshall
 * @see {@link org.apache.tuscany.samples.sdo.otherSources.CreatePurchaseOrder}
 */

public class CreatingXmlFromDataObjects {

    /**
     * Drives sample
     * 
     * @param args.
     *            none required.
     */
    public static void main(String[] args) {
        try {

            System.out.println("***************************************");
            System.out.println("SDO Sample CreatingXmlFromDataObjects");
            System.out.println("***************************************");
            System.out.println("Demonstrates programmatically creating a DataObject and generating an XML String");
            System.out.println("***************************************");

            XSDHelper.INSTANCE.define(ClassLoader.getSystemResourceAsStream(SdoSampleConstants.PO_XSD_RESOURCE), null);
            System.out.println("Defined Types using xsd");
            DataObject purchaseOrder = DataFactory.INSTANCE.create(SdoSampleConstants.PO_NAMESPACE, "PurchaseOrderType");
            System.out.println("Created DataObject using DataFactory");

            System.out.println("Populating purchase order data object");

            purchaseOrder.setString("orderDate", "1999-10-20");

            DataObject shipTo = purchaseOrder.createDataObject("shipTo");
            shipTo.set("country", "US");
            shipTo.set("name", "Alice Smith");
            shipTo.set("street", "123 Maple Street");
            shipTo.set("city", "Mill Valley");
            shipTo.set("state", "CA");
            shipTo.setString("zip", "90952");
            DataObject billTo = purchaseOrder.createDataObject("billTo");
            billTo.set("country", "US");
            billTo.set("name", "Robert Smith");
            billTo.set("street", "8 Oak Avenue");
            billTo.set("city", "Mill Valley");
            billTo.set("state", "PA");
            billTo.setString("zip", "95819");
            purchaseOrder.set("comment", "Hurry, my lawn is going wild!");

            DataObject items = purchaseOrder.createDataObject("items");

            DataObject item1 = items.createDataObject("item");
            item1.set("partNum", "872-AA");
            item1.set("productName", "Lawnmower");
            item1.setInt("quantity", 1);
            item1.setString("price", "148.95");

            item1.set("comment", "Confirm this is electric");

            DataObject item2 = items.createDataObject("item");
            item2.set("partNum", "926-AA");
            item2.set("productName", "Baby Monitor");
            item2.setInt("quantity", 1);
            item2.setString("price", "39.98");
            item2.setString("shipDate", "1999-05-21");

            OutputStream stream = new FileOutputStream(SdoSampleConstants.PO_XML_GENERATED);
            XMLHelper.INSTANCE.save(purchaseOrder, SdoSampleConstants.PO_NAMESPACE, "purchaseOrder", stream);
            System.out.println("Created file " + SdoSampleConstants.PO_XML_GENERATED);
            System.out.println("Populated with :");
            System.out.println(XMLHelper.INSTANCE.save(purchaseOrder, SdoSampleConstants.PO_NAMESPACE, "purchaseOrder"));
        } catch (Exception e) {
            System.out.println("Sorry an error occured " + e.toString());
            e.printStackTrace();
        }
        System.out.println("GoodBye");
    }
}
