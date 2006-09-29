/**
 *
 *  Copyright 2006 The Apache Software Foundation or its licensors, as applicable.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.tuscany.samples.sdo.otherSources;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import commonj.sdo.DataObject;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;

import org.apache.tuscany.samples.sdo.SdoSampleConstants;

/**
 * Demonstrates creating a purchaseOrder DataObject from an existing XSD and then
 * persisting to disk. Uses previously defined model
 * {@link org.apache.tuscany.samples.sdo.SdoSampleConstants#PO_XSD_RESOURCE} to
 * define types then generates a purchase order DataObject and persists to
 * {@link org.apache.tuscany.samples.sdo.SdoSampleConstants#PO_XML_GENERATED}. This
 * sample was used to generate valid XML for Fuhwei Lo's paper <A
 * HREF="http://www-128.ibm.com/developerworks/webservices/library/ws-sdoxmlschema/"
 * title="Me" onClick="checkLinks(this)">Create and read an XML document based on XML
 * Schema</A>
 * 
 *  * <b>Usage:</b> <br>
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
 * java org.apache.tuscany.samples.sdo.otherSources.CreatePurchaseOrder</LI>
 * </UL>
 * 
 * @author Fuhwei Lwo
 * @author Robbie Minshall
 * @see ReadPurchaseOrder
 * @see org.apache.tuscany.samples.sdo.specExampleSection.CreatingXmlFromDataObjects
 */

public class CreatePurchaseOrder {

    /**
     * Defines purchase order types using
     * {@link org.apache.tuscany.samples.sdo.SdoSampleConstants#PO_XSD_RESOURCE}
     * 
     * @throws Exception
     */
    private static void definePOTypes() throws Exception {

        InputStream is = ClassLoader.getSystemResourceAsStream(SdoSampleConstants.PO_XSD_RESOURCE);
        if (is == null) {
            System.out.println("InputStream is null");
        } else {
            System.out.println("Obtained Input Stream from resoruce");
        }
        XSDHelper.INSTANCE.define(is, null);
        is.close();
    }

    /**
     * Drives sample
     * 
     * @param args.
     *            none required.
     */
    public static void main(String[] args) {
        try {

            System.out.println("***************************************");
            System.out.println("SDO Sample CreatePurchaseOrder");
            System.out.println("***************************************");
            System.out.println("This sample is based upon Fuhwei Lo's paper "
                    + "http://www-128.ibm.com/developerworks/webservices/library/ws-sdoxmlschema/"
                    + " and demonstrates creating a purchaseOrder DataObject from an "
                    + " existing XSD and then persisting to disk. Uses previously defined model");

            System.out.println("***************************************");

            definePOTypes();
            System.out.println("Defined Types using xsd");
            DataObject purchaseOrder = DataFactory.INSTANCE.create(SdoSampleConstants.PO_NAMESPACE, "PurchaseOrderType");
            System.out.println("Created DataObject using DataFactory");

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
            System.out.println("Created orderDate, shipTo, billTo and comment properties");

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
            System.out.println("Created 2 items");

            OutputStream stream = new FileOutputStream(SdoSampleConstants.PO_XML_GENERATED);
            XMLHelper.INSTANCE.save(purchaseOrder, SdoSampleConstants.PO_NAMESPACE, "purchaseOrder", stream);
            System.out.println("Created file " + SdoSampleConstants.PO_XML_GENERATED);
        } catch (Exception e) {
            System.out.println("Sorry an error occured " + e.toString());
            e.printStackTrace();
        }
        System.out.println("GoodBye");
    }
}
