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

package org.apache.tuscany.samples.sdo.intermediate;

import java.util.List;

import org.apache.tuscany.samples.sdo.SampleBase;
import org.apache.tuscany.samples.sdo.SampleInfrastructure;

import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;

/**
 * Demonstrates accessing a created DataObject's properties using the SDO XPath like syntax.
 * 
 * This sample is from the <a href="http://incubator.apache.org/tuscany"
 * target="_blank"> Apache Tuscany</a> project. It was written to help users
 * understand and experiment with SDO. It is based upon code snipets contained
 * within, and is meant for use with, and reference to the <a
 * href="http://osoa.org/download/attachments/36/Java-SDO-Spec-v2.1.0-FINAL.pdf?version=1"
 * target="_bank">SDO Specification</a>. <br>
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
 * <LI>Execute: java
 * org.apache.tuscany.samples.sdo.specCodeSnippets.AccessDataObjectUsingValidXPath</LI>
 */
public class AccessDataObjectUsingValidXPath extends SampleBase {
    HelperContext scope;
  
    public AccessDataObjectUsingValidXPath(Integer userLevel) {
      super(userLevel, SampleInfrastructure.SAMPLE_LEVEL_INTERMEDIATE);
    }


    /**
     * Accesses and modifies properties of a purchase order DataObject using xPath(
     * properties are defined in the xsd
     * {@link org.apache.tuscany.samples.sdo.SampleInfrastructure#PO_XSD_RESOURCE} and
     * populated by xml
     * {@link org.apache.tuscany.samples.sdo.SampleInfrastructure#PO_XML_RESOURCE} )
     * 
     * @param args.
     *            No parameters required.
     */
    public static void main(String[] args) {
      AccessDataObjectUsingValidXPath sample = new AccessDataObjectUsingValidXPath(COMMENTARY_FOR_NOVICE);
      sample.run();

    }

    public void runSample () throws Exception {

        commentary("Demonstrates accessing a DataObject's properties using the XPath style getter/setter methods");


        HelperContext scope = createScopeForTypes();
        
        
        commentary(
            "First we create the type system using an XML Schema file and then create\n"+
            "A DataObject using an XML document for convenience");
        
        loadTypesFromXMLSchemaFile(scope, SampleInfrastructure.PO_XSD_RESOURCE);
        DataObject purchaseOrder = getDataObjectFromFile(scope, SampleInfrastructure.PO_XML_RESOURCE);



        commentary(
            "Accessing data from the purchase order using the DataObjects XPath style methods\n");
        

        System.out.println("First we use the simplest kind of path\n" +
            "purchaseOrder.getString(\"billTo/name\")\n" +
            "The purchase is to be paid for by .... " +
            purchaseOrder.getString("billTo/name"));
        
        
        System.out.println("\nThen we use indexing by integer starting from 1\n" +
            "purchaseOrder.getString(\"items/item[1]/productName\"\n" +
            "The first item in the order is a ... " +
            purchaseOrder.getString("items/item[1]/productName"));
        
       
        System.out.println("\nThe alternative style of indexing uses a . notation and starts from 0\n"+
            "purchaseOrder.getFloat(\"items/item.0/price\")\n" +
            "The price of this item is ... " +
            purchaseOrder.getFloat("items/item.0/price"));
        

        System.out.println("\nDataObjects can be looked up by supplying the value of one of the contained simple valued Properties\n"+
            "DataObject babyMonitorItem = purchaseOrder.getDataObject(\"items/item[productName=\\\"Baby Monitor\\\"]");
                
        DataObject babyMonitorItem = purchaseOrder.getDataObject("items/item[productName=\"Baby Monitor\"]");
        System.out.println("The price of the Baby Monitor is .... " +
        babyMonitorItem.getFloat("price"));
        
        
        System.out.println("\nA parent DataObject can be accessed with the .. notation\n"+
            "List onlyIfBuyingGrassSeed = purchaseOrder.getList(\"items/item[productName=GrassSeed]/../item\");");
        List onlyIfBuyingGrassSeed = purchaseOrder.getList("items/item[productName=GrassSeed]/../item");
        if(onlyIfBuyingGrassSeed != null) {
          System.out.println("The purchase order included grass seed and " + new Integer(onlyIfBuyingGrassSeed.size()-1) + " other items");
        } else {
          System.out.println("The purchase order did not include GrassSeed");
        }


    }

}
