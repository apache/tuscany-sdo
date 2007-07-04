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

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLHelper;

/**
 * Demonstrates creating a DataObject from a String of XML without an explicit model.
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
public class CreateDataObjectFromXmlString extends SampleBase {
    HelperContext scope;


    public CreateDataObjectFromXmlString(Integer userLevel) {
      super(userLevel, SAMPLE_LEVEL_INTERMEDIATE);
    }


    /**
     * String representing a PurchaseOrder in XML format
     */
    public static final String XML_STRING = "<purchaseOrder orderDate='1999-10-20'>" + " <shipTo country='US'>" + " <name>Alice Smith</name>"
            + " <street>123 Maple Street</street>" + " <city>Mill Valley</city>" + " <state>PA</state>" + " <zip>90952</zip>" + "</shipTo>"
            + "</purchaseOrder>";


    public static void main(String[] args) {

      CreateDataObjectFromXmlString sample = new CreateDataObjectFromXmlString(COMMENTARY_FOR_NOVICE);
      sample.run();
 
    }

    public void runSample () throws Exception {

        
        commentary("Demonstrates creating a DataObject from a String of XML,\n" +
            "based upon section titled 'Creating DataObjects from XML documents'\n"+
            "This quite unassuming sample demonstrates the maxim of 'less is more'\n"+
            "in that it might look like other samples where the XML document was loaded\n"+
            "from a file or string,  but note that we don't define any Types before loading\n"+
            "the document. Built in generic types are used to model the data graph");


        scope = createScopeForTypes();

        commentary("don't define any types! Just go ahead and load from the String\n\n"+
            "DataObject purchaseOrder = scope.getXMLHelper().load(XML_STRING).getRootObject();");
        
        DataObject purchaseOrder = scope.getXMLHelper().load(XML_STRING).getRootObject();
        
        commentary("Note that the Type of the newly created DataObject has no Properties defined for it\n"+
            "but the type is said to be \"Open\",  which means that an instance of the Type may make use of other Properties\n"+
            "defined elsewhere.  The XMLHelper's load operation creates Properties on demand for the DataObject instance to use as it loads\n"+
            "the document\n\n");
        
        
        // FIXME I'm not sure how to explain why the top level data object is of type AnyTypeDataObject
        // and the shipTo Property's type is DataObject
        System.out.println("The type of the DataObject is " + purchaseOrder.getType().getName() +
            " and has " + purchaseOrder.getType().getProperties().size() + " Properties");
        System.out.println("The DataObject itself has " + purchaseOrder.getInstanceProperties().size() + " Properties\n");
        Property p0 = (Property)purchaseOrder.getInstanceProperties().get(0);
        System.out.println("The first of these instance Properties is " + p0.getName() + " and is of type " + p0.getType().getName());

        commentary(
            "Without a Type definition accessing a DataObject is slightly\n"+
            "different, since without a Type definition SDO does not know\n"+
            "the intended multiplicity of properties. So every Property is assumed to\n"+
            "be multi-valued, and must be accessed via a list\n\n"+
            "List shipToList = purchaseOrder.getList(\"shipTo\");\n"+
            "DataObject shipTo = (DataObject) shipToList.get(0);"); 

        List shipToList = purchaseOrder.getList("shipTo");
        DataObject shipTo = (DataObject) shipToList.get(0);
        
        

        /*
         * With no model around, this next operation is currently quite cumbersome.
         * In future specifications accessing
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

    }
}
