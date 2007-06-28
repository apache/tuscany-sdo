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

import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.TypeHelper;
import java.util.List;

import org.apache.tuscany.samples.sdo.SampleBase;

/**
 * Demonstrates creating and using Types dynamically. This sample is from the <a
 * href="http://incubator.apache.org/tuscany" target="_blank"> Apache Tuscany</a>
 * project. It was written to help users understand and experiment with SDO. It is
 * based upon code snippets contained within, and is meant for use with, and reference
 * to the <a
 * href="http://osoa.org/download/attachments/36/Java-SDO-Spec-v2.1.0-FINAL.pdf?version=1"
 * target="_bank">SDO Specification</a>. Specifically, this sample is based upon the
 * section titled "Defining SDO Types Dynamically" <br>
 * <br> * <b>Usage:</b> <br>
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
 * These jar files can be obtained by downloading and unpacking a <a href="http://cwiki.apache.org/TUSCANY/sdo-downloads.html" target="_blank">Tuscany binary distribution </a> </LI>
 * <LI>Execute: <br>
 * java org.apache.tuscany.samples.sdo.specCodeSnippets.DynamicCustomerTypeSample</LI>
 * </UL>
 */
public class DynamicCustomerTypeSample extends SampleBase {
    HelperContext scope;

    public DynamicCustomerTypeSample(Integer userLevel) {
      super(userLevel, SAMPLE_LEVEL_INTERMEDIATE);
    }


    /**
     * XSD file used to define the model and Types for Customer Dataobject
     */
    public static final String CUSTOMER_MODEL = "customer.xsd";

    /**
     * Default file name to use when generated customer XSD files.
     * 
     * @see org.apache.tuscany.samples.sdo.specCodeSnippets.CreateXmlAndXsdFromDataObject
     */
    public static final String CUSTOMER_MODEL_GENERATED = "generatedCustomer.xsd";

    /**
     * Fake namespace used for Customer
     */
    public static final String CUSTOMER_NAMESPACE = "http://www.example.com/customer";

    /**
     * XML file used to populate Customer DataObjects
     */
    public static final String CUSTOMER_XML = "customer.xml";

    /**
     * Default file name to use when generated customer XML files.
     * 
     * @see org.apache.tuscany.samples.sdo.specCodeSnippets.CreateXmlAndXsdFromDataObject
     */
    public static final String CUSTOMER_XML_GENERATED = "generatedCustomer.xml";

    /**
     * Drives sample methods
     * 
     * @param args
     *            no arguments required
     */
    public static void main(String[] args) {

      DynamicCustomerTypeSample sample =
        new DynamicCustomerTypeSample(COMMENTARY_FOR_INTERMEDIATE);
      sample.run();

    }

    public void runSample () throws Exception {

      commentary(COMMENTARY_ALWAYS,
          "Demonstrates the use of the SDO API to build types dynamically\n"+
          "by building a data graph representing the type system and\n"+
          "submitting that graph to TypeHelper.define()");
      

      scope = createScopeForTypes();

    
      commentary("A TypeHelper is used for both looking up types,  and later creating them\n\n"+
          "TypeHelper typeHelper = scope.getTypeHelper();");
      
      TypeHelper typeHelper = scope.getTypeHelper();
      
      commentary("We can look up existing types to use in the creation of Properties\n\n"+
          "Type intType = types.getType(\"commonj.sdo\", \"Int\");\n"+
          "Type stringType = types.getType(\"commonj.sdo\", \"String\");");
      
      Type intType = typeHelper.getType("commonj.sdo", "Int");
      Type stringType = typeHelper.getType("commonj.sdo", "String");
      
      commentary("To begin modelling the type system we create a DataObject with\n"+
          "Type \"commonj.sdo#Type\" and set the URI and name for that type\n\n"+
          
          "DataObject customerType = scope.getDataFactory().create(\"commonj.sdo\", \"Type\");\n"+
          "customerType.set(\"uri\", \"http://example.com/customer\");\n"+
          "customerType.set(\"name\", \"Customer\");");
      
      DataObject customerType = scope.getDataFactory().create("commonj.sdo", "Type");
      customerType.set("uri", "http://example.com/customer");
      customerType.set("name", "Customer");
      
      commentary("Now we can create a model for the Properties for the Type\n"+
          "and set the name and Types of those Properties\n\n"+
          "DataObject custNumProperty = customerType.createDataObject(\"property\");\n"+
          "custNumProperty.set(\"name\", \"custNum\");\n"+
          "custNumProperty.set(\"type\", intType);"
      );
      
      DataObject custNumProperty = customerType.createDataObject("property");
      custNumProperty.set("name", "custNum");
      custNumProperty.set("type", intType);
      
      commentary("We continue in this manner until all the Types and their Properties are modelled");
      DataObject lastNameProperty = customerType.createDataObject("property");
      lastNameProperty.set("name", "lastName");
      lastNameProperty.set("type", stringType);
      
      DataObject firstNameProperty = customerType.createDataObject("property");
      firstNameProperty.set("name", "firstName");
      firstNameProperty.set("type", stringType);
      
      commentary("Now that our type is fully modelled we submit the model to the TypeHelper\n"+
          "The new Type instance is retuend to us,  but is also available for lookup within\n"+
          "the scope associated with the TypeHelper\n\n"+
          "Type t = typeHelper.define(customerType);");
      Type t = typeHelper.define(customerType);
      
      commentary("Here we see the newly created Type being accessed via the TypeHelper\n"+
          "along with a printout of the Type's Properties\n\n"+
          "Type testType = scope.getTypeHelper().getType(\"http://example.com/customer\", \"Customer\");");
      
      Type testType = scope.getTypeHelper().getType("http://example.com/customer", "Customer");
      List props = testType.getProperties();
      for (int i = 0; i < props.size(); i++) {
          System.out.println(props.get(i));
      }

      commentary("Now we can create an instance of the type using the DataFactory associated with the type scope\n\n"+
          "DataFactory factory = scope.getDataFactory();\n"+
          "DataObject customer1 = factory.create(\"http://example.com/customer\", \"Customer\");");

      DataFactory factory = scope.getDataFactory();
      DataObject customer1 = factory.create("http://example.com/customer", "Customer");
      customer1.setInt("custNum", 1);
      customer1.set("firstName", "John");
      customer1.set("lastName", "Adams");

      commentary("Here's an XML String representing a DataObject we have created with the new type");
      String xmlDocString = scope.getXMLHelper().save(customer1, CUSTOMER_NAMESPACE, "customer");
      System.out.println(xmlDocString);


    }

}
