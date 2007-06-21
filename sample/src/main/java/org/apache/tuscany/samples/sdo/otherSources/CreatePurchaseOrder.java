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

package org.apache.tuscany.samples.sdo.otherSources;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.tuscany.samples.sdo.SampleBase;
import org.apache.tuscany.samples.sdo.SampleInfrastructure;
import org.apache.tuscany.samples.sdo.SdoSampleConstants;

import commonj.sdo.DataObject;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLDocument;

/**
 * Demonstrates creating a purchaseOrder DataObject from an existing XSD and then
 * persisting to disk. Uses previously defined model
 * {@link org.apache.tuscany.samples.sdo.SdoSampleConstants#PO_XSD_RESOURCE} to
 * define types then generates a purchase order DataObject and persists to
 * {@link org.apache.tuscany.samples.sdo.SdoSampleConstants#PO_XML_GENERATED}. This
 * sample was used to generate valid XML for Fuhwei Lwo's paper <A
 * HREF="http://www-128.ibm.com/developerworks/webservices/library/ws-sdoxmlschema/"
 * title="Me" onClick="checkLinks(this)">Create and read an XML document based on XML
 * Schema</A>
 * <p>
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
 * These jar files can be obtained by downloading and unpacking a <a href="http://cwiki.apache.org/TUSCANY/sdo-downloads.html" target="_blank">Tuscany binary distribution</a></LI>
 * <LI>Execute: <br>
 * java org.apache.tuscany.samples.sdo.otherSources.CreatePurchaseOrder</LI>
 * </UL>
 * @see ReadPurchaseOrder
 * @see org.apache.tuscany.samples.sdo.specExampleSection.CreatingXmlFromDataObjects
 */

public class CreatePurchaseOrder extends SampleBase {

    public CreatePurchaseOrder(Integer commentaryLevel) {
      super(commentaryLevel, SampleInfrastructure.SAMPLE_LEVEL_NOVICE);
    }

    /**
     * Drives sample
     * 
     * @param args.
     *            none required.
     */
    public static void main(String[] args) {


      CreatePurchaseOrder sample = new CreatePurchaseOrder(COMMENTARY_FOR_NOVICE);

      sample.run();

    }
    
    public void runSample() throws Exception {

          commentary(COMMENTARY_ALWAYS,
              "This sample is based upon Fuhwei Lwo's paper\n"
              + "http://www-128.ibm.com/developerworks/webservices/library/ws-sdoxmlschema/\n"
              + "and demonstrates creating a purchaseOrder DataObject from an\n"
              + "existing XSD and then persisting to disk. Uses previously defined model");

          HelperContext scope = createScopeForTypes();
          
          loadTypesFromXMLSchemaFile(scope, SdoSampleConstants.PO_XSD_RESOURCE);
          
          
          commentary (COMMENTARY_FOR_NOVICE,
              "We are creating a DataObject using a DataFactory by specifying the URI and name of\n"+
              "the Type that we want to use for the DataObject.\n\n"+
              "DataFactory factory = scope.getDataFactory();\n"+
              "DataObject purchaseOrder = factory.create(SdoSampleConstants.PO_NAMESPACE, \"PurchaseOrderType\");");
          
          DataFactory factory = scope.getDataFactory();           
          DataObject purchaseOrder = factory.create(SdoSampleConstants.PO_NAMESPACE, "PurchaseOrderType");


          commentary(COMMENTARY_FOR_NOVICE,
              "Now we build on the graph using the DataObject's set() and createDataObject() methods.\n"+
              "Take a look inside the program code for the full detail of these steps");
          
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
          System.out.println("Created 2 items");

          commentary(COMMENTARY_FOR_NOVICE,
              "Now we use the XMLHelper to write an XML document representing the data graph\n"+
              "to a file.  We must supply a namespace and a name for the root element of the graph, since it is\n"+
              "not contained in the DataObject\n\n"+
              "OutputStream stream = new FileOutputStream(SdoSampleConstants.PO_XML_GENERATED);\n"+
              "scope.getXMLHelper().save(purchaseOrder, SdoSampleConstants.PO_NAMESPACE, \"purchaseOrder\", stream);"
              );
          
          
          OutputStream stream = new FileOutputStream(SdoSampleConstants.PO_XML_GENERATED);
          scope.getXMLHelper().save(purchaseOrder, SdoSampleConstants.PO_NAMESPACE, "purchaseOrder", stream);
          stream.close();

          commentary(COMMENTARY_FOR_NOVICE,
              "We could instead have created an XMLDocument instance to wrap the DataObject\n"+
              "This has the advantage that the namespace URI and root element name are preserved in the Object\n"+
              "This interface was introduced after Fuhwei's paper,  and has particular advantage\n"+
              "when loading an XML document from a file\n\n"+
              "scope.getXMLHelper().createDocument(purchaseOrder, SdoSampleConstants.PO_NAMESPACE, \"purchaseOrder\");\n"+
              "scope.getXMLHelper().save(doc, System.out, null);");
          
          
          XMLDocument doc = scope.getXMLHelper().createDocument(purchaseOrder, SdoSampleConstants.PO_NAMESPACE, "purchaseOrder");
          scope.getXMLHelper().save(doc, System.out, null);
          System.out.println();
      }

}
