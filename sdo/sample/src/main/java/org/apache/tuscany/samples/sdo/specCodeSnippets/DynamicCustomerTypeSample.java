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

package org.apache.tuscany.samples.sdo.specCodeSnippets;

import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.TypeHelper;
import java.util.List;

/**
 * Demonstrates creating and using Types dynamically. This sample is from the <a
 * href="http://incubator.apache.org/tuscany" target="_blank"> Apache Tuscany</a>
 * project. It was written to help users understand and experiement with SDO. It is
 * based upon code snippets contained within, and is meant for use with, and reference
 * to the <a
 * href="http://www.osoa.org/download/attachments/791/SDO_Specification_Java_V2.01.pdf?version=1"
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
 * These jar files can be obtained from directly from Tuscany and EMF projects or from <a
 * href="http://wiki.apache.org/ws-data/attachments/Tuscany(2f)TuscanyJava(2f)SDO_Java_Overview/attachments/SDO%20Execution%20Dependencies"
 * target="_bank">SDO Execution Dependancies </a> </LI>
 * <LI>Execute: <br>
 * java org.apache.tuscany.samples.sdo.specCodeSnippets.DynamicCustomerTypeSample</LI>
 * </UL>
 * 
 * @author Robbie Minshall
 */
public class DynamicCustomerTypeSample {

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
     * Method dynamically defines customer types
     */
    public static void defineCustomerTypes() {
        // get an instance of the type helper
        TypeHelper types = TypeHelper.INSTANCE;
        Type intType = types.getType("commonj.sdo", "Int");
        Type stringType = types.getType("commonj.sdo", "String");

        // create a new Type for Customers
        DataObject customerType = DataFactory.INSTANCE.create("commonj.sdo", "Type");
        customerType.set("uri", "http://example.com/customer");
        customerType.set("name", "Customer");

        // create a customer number property
        DataObject custNumProperty = customerType.createDataObject("property");
        custNumProperty.set("name", "custNum");
        custNumProperty.set("type", intType);

        // create a last name property
        DataObject lastNameProperty = customerType.createDataObject("property");
        lastNameProperty.set("name", "lastName");
        lastNameProperty.set("type", stringType);

        // create a first name property
        DataObject firstNameProperty = customerType.createDataObject("property");
        firstNameProperty.set("name", "firstName");
        firstNameProperty.set("type", stringType);

        // now define the Customer type so that customers can be made
        types.define(customerType);

        Type testType = TypeHelper.INSTANCE.getType("http://example.com/customer", "Customer");
        List props = testType.getProperties();
        for (int i = 0; i < props.size(); i++) {
            System.out.println(props.get(i));
        }
    }

    /**
     * Creates a new Customer using dynamically defined Customer Type
     * 
     * @param custNum
     * @param firstName
     * @param lastName
     * @return
     */
    private static DataObject createCustomer(int custNum, String firstName, String lastName) {
        DataFactory factory = DataFactory.INSTANCE;
        DataObject customer1 = factory.create("http://example.com/customer", "Customer");
        customer1.setInt("custNum", custNum);
        customer1.set("firstName", firstName);
        customer1.set("lastName", lastName);
        return customer1;
    }

    /**
     * Drives sample methods
     * 
     * @param args
     *            no arguments required
     */
    public static void main(String args[]) {
        System.out.println("***************************************");
        System.out.println("SDO Sample DynamicCustomerTypeSample");
        System.out.println("***************************************");
        System.out.println("Demonstrats creating and using Types dynamically");
        System.out.println("***************************************");
        try {
            System.out.println("Dynamically defining Customer Type");
            defineCustomerTypes();

            System.out.println("Creating new customer DataObject");
            DataObject customer1 = createCustomer(1, "John", "Adams");
            System.out.println("Customer Created");

            System.out.println("converting to xml");
            String xmlDocString = XMLHelper.INSTANCE.save(customer1, CUSTOMER_NAMESPACE, "customer");
            System.out.println(xmlDocString);

        } catch (Exception e) {
            System.out.println("Sorry unexpected exception caught during sample execution : " + e.toString());
            e.printStackTrace();
        }
        System.out.println("GoodBye");
    }

}
