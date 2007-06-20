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

import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;

import org.apache.tuscany.samples.sdo.SampleBase;
import org.apache.tuscany.samples.sdo.SdoSampleConstants;
import org.apache.tuscany.samples.sdo.specCodeSnippets.AccessDataObjectPropertiesByName;

/**
 * Demonstrates creating a DataObject from an XML String.
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
 * Specifically this sample is based upon the 'Creating DataObject Trees from XML
 * documents' example from the Examples section of the SDO Specification. It is
 * possible to convert to and from XML documents to build DataObject trees, which is
 * useful when assembling DataObjects from serval data sources. This sample uses the
 * XMLHelper to convert xml Strings to DataObjects. <br>
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
 * These jar files can be obtained by downloading and unpacking a <a href="http://cwiki.apache.org/TUSCANY/sdo-downloads.html" target="_blank">Tuscany binary distribution </a>  </LI>
 * <LI>Execute: <br>
 * java org.apache.tuscany.samples.sdo.specExampleSection.CreatingDataObjectTreesFromXMLDocuments</LI>
 * </UL>
 * 
 * @author Robbie Minshall
 * @see {@link org.apache.tuscany.samples.sdo.otherSources.CreatePurchaseOrder}
 */

public class CreatingDataObjectTreesFromXMLDocuments  extends SampleBase {

    HelperContext scope;

    public CreatingDataObjectTreesFromXMLDocuments(Integer userLevel) {
      super(userLevel);
    }


    /**
     * Drives sample
     * 
     * @param args.
     *            none required.
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

  public void runSample () throws Exception {
        try {

            System.out.println("***************************************");
            System.out.println("SDO Sample CreatingDataObjectTreesFromXMLDocuments");
            System.out.println("***************************************");
            
            scope = createScopeForTypes();

            // use xsd to define purchase order types
            System.out.println("Definging purchase order types using " + SdoSampleConstants.PO_XSD_RESOURCE);
            scope.getXSDHelper().define(ClassLoader.getSystemResourceAsStream(SdoSampleConstants.PO_XSD_RESOURCE), null);
            System.out.println("Defined Types using xsd");

            System.out.println("Creating purchase order DataObject using previously created " + SdoSampleConstants.PO_XML_RESOURCE);
            DataObject purchaseOrder = scope.getXMLHelper().load(ClassLoader.getSystemResourceAsStream(SdoSampleConstants.PO_XML_RESOURCE))
                    .getRootObject();

            // To create the shipTo DataObject from XML:
            String shipToXML = "<shipTo country='US'>" + " <name>Alice Smith</name>" + " <street>123 Maple Street</street>"
                    + " <city>Mill Valley</city>" + " <state>PA</state>" + " <zip>90952</zip>" + "</shipTo>";
            DataObject shipTo = scope.getXMLHelper().load(shipToXML).getRootObject();

            // Modify shipTo DataObject on purchaseOrder to value created from a
            // String
            System.out.println("Modifying shipTo DataObject on purchaseOrder to value created from a String");
            purchaseOrder.set("shipTo", shipTo);

            // Obtain and convert the billTo DataObject to XML
            System.out.println("Obtaining billTo dataObject from purchase order and converting to XML");
            DataObject billTo = purchaseOrder.getDataObject("billTo");
            String billToXML = scope.getXMLHelper().save(billTo, null, "billTo");
            System.out.println("billTo DataObject:");
            System.out.println(billToXML);

        } catch (Exception e) {
            System.out.println("Sorry an error occured " + e.toString());
            e.printStackTrace();
        }
        System.out.println("GoodBye");
    }
}
