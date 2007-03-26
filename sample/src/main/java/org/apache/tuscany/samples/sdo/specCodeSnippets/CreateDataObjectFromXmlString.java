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

import commonj.sdo.DataObject;
import commonj.sdo.Sequence;
import commonj.sdo.helper.XMLHelper;

/**
 * Demonstrates creating a DataObject from a String of XML.
 * 
 * The following sample is from the <a href="http://incubator.apache.org/tuscany"
 * target="_blank"> Apache Tuscany</a> project. It was written to help users
 * understand and experiment with SDO. It is based upon code snippets contained
 * within, and is meant for use with, and reference to the <a
 * href="http://osoa.org/download/attachments/36/Java-SDO-Spec-v2.1.0-FINAL.pdf?version=1"
 * target="_blank">SDO Specification</a>. Specifically this sample is based upon section titled "Creating DataObjects from XML documents" <br>
 * <br>
 * <b>Usage:</b> <br>
 * This sample can easily be run from within Eclipse as a Java Application if Tuscany or 
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
 * These jar files can be obtained by downloading and unpacking a <a href="http://cwiki.apache.org/TUSCANY/sdo-downloads.html" target="_blank">Tuscany binary distribution </a> </LI>
 * <LI>Execute: <br>
 * java org.apache.tuscany.samples.sdo.specCodeSnippets.CreateDataObjectFromXmlString</LI>
 * </UL>
 */
public class CreateDataObjectFromXmlString {

    /**
     * String representing a PurchaseOrder in XML format
     */
    public static final String XML_STRING = "<purchaseOrder orderDate='1999-10-20'>" + " <shipTo country='US'>" + " <name>Alice Smith</name>"
            + " <street>123 Maple Street</street>" + " <city>Mill Valley</city>" + " <state>PA</state>" + " <zip>90952</zip>" + "</shipTo>"
            + "</purchaseOrder>";

    /**
     * Creates a DataObject from an Xml String
     * 
     * @return
     */
    public static DataObject createDataObjectFromXmlString() {

        // TODO: do this with and without defining the schema
        DataObject po = XMLHelper.INSTANCE.load(XML_STRING).getRootObject();
        System.out.println("DataObject has been created : " + po.toString());
        return po;
    }

    /**
     * @param args
     *            None required
     */
    public static void main(String[] args) {

        // information
        System.out.println("***************************************");
        System.out.println("SDO Sample CreateDataObjectFromXmlString");
        System.out.println("***************************************");
        System.out.println("Demonstrates creating a DataObject from a String of XML, based upon section titled 'Creating DataObjects from XML documents'");
        System.out.println("***************************************");

        // sample
        try {

            System.out.println("Use the following XML String: " + XML_STRING);
            System.out.println("Creating DataObject");
            DataObject po = createDataObjectFromXmlString();
            System.out.println("The following DataObject was sucessfully created from the XML String");

            System.out.println(XMLHelper.INSTANCE.save(po, "http://example.com/purchaseOrder", "purchaseOrder"));

            /*
             * Without a Type definition accessing a DataObject is slightly more
             * difficult. This is because without a Type definition SDO does not know
             * the intended multiplicity of properties. Currently the Tuscany
             * implementation assumes that elements and attributes are lists. There
             * is some discussion (SDO-3, also mentioned in SDO Specification JIRA SDO-22) about adding
             * annotations to the XML (sdo:many="false") to control the indended
             * multiplicity of DataObjects created without a model.
             * 
             * The following code will not work when a model/schema is not defined
             * shipTo = purchaseOrder.getDataObject("shipTo"); assertEquals("testing
             * ship to name", shipTo.getString("name"), "Alice Smith");
             * assertEquals("testing ship to zip", shipTo.getString("zip"), "90952");
             */

            System.out.println("Programatically access content of DataObject - getting name of the person this is getting shipped to");
            // access the shipTo DataObject
            List shipToList = po.getList("shipTo");
            DataObject shipTo = (DataObject) shipToList.get(0);
            // access the name DataObject

            /*
             * This is currently quite cumbersome. In future specifications accessing
             * the name element will be simplier and the user could simply execute:
             * List nameList = shipTo.getList("name"); String actualName = (String)
             * nameList.get(0);
             * 
             * Or if name is an attribute ("<shipTo country='US' name='Alice
             * Smith'>") simply: String actualName = shipTo.getString("name");
             * 
             * There are currently more elegant means to perform this task using the xPath support
             */
            List nameList = shipTo.getList("name");
            DataObject name = (DataObject) nameList.get(0);
            // access the contents of the name DataObject
            Sequence s = name.getSequence();
            String actualName = (String) s.getValue(0);
            System.out.println("Name being shipped to: " + actualName);

        } catch (Exception e) {
            System.out.println("Sorry, exception caught when creating DataObject : " + e.toString());
            e.printStackTrace();
        }
        // end of sample
        System.out.println("GoodBye");
    }
}
