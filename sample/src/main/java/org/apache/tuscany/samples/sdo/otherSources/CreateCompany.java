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

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.List;

import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.DataGraph;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;

import org.apache.tuscany.samples.sdo.SdoSampleConstants;
import org.apache.tuscany.sdo.util.SDOUtil;

/**
 * Demonstrates creating a DataObject using the Types defined in a previously generated XML Schema ({@link SdoSampleConstants#COMPANY_XSD}) then persisting to an XML file
 * This example is useful as a reference for creating valid xml documents that conform to an existing XSD and has been used to create valid XML files for use 
 * with specification code samples.
 * <p>
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
 * These jar files can be obtained by downloading a binary distribution of Tuscany SDO Java</LI>
 * <LI>Execute: <br>
 * java org.apache.tuscany.samples.sdo.otherSources.CreateCompany</LI>
 * </UL>
 */
public class CreateCompany {

    /**
     * XML file generated for the company DataObject
     */    
    public static final String COMPANY_GENERATED_XML = "companyGenerated.xml";

    /**
     * XML file generated for the company DataGraph
     */  
    public static final String COMPANY_DATAGRAPH_GENERATED_XML = "companyDataGraphGenerated.xml";

    
    /**
     * Main method.  Execute this method in order to run sample
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        System.out.println("***************************************");
        System.out.println("SDO Sample CreateCompany");
        System.out.println("***************************************");
        System.out.println("Demonstrates creating a DataObject using the Types defined in a previously generated xsd {@link SdoSampleConstants#COMPANY_XSD} then persisting to a XML file");
        System.out.println("***************************************");
        /**
         * Use xsd to define model
         */
        defineCompanyTypes();

        /**
         * DataObjects can exist on there own or can be associated with a DataGraph. This sample allows you to create and then generate xml for a
         * company DataObject That is either associated with a DataGraph or independent
         */
        boolean useDataGraph = shouldUseDataGraph();

        // define these so that they will be scoped appropriately.
        DataGraph dataGraph = null;
        DataObject company = null;

        if (useDataGraph) {

            /**
             * The SDO specification says the following about creating a DataGraph. A DataGraph is created by a DAS, which returns either an empty
             * DataGraph, or a DataGraph filled with DataObjects. An empty DataGraph can have a root assigned by the createRootObject() methods.
             * However, if a previous root DataObject exists then an IllegalStateException is thrown.
             * 
             * In order to create a simple sample which creates a DataGraph without the use of a DAS this sample will use the
             * {@link org.apache.tuscany.sdo.util.SDOUtil} class to create a DataObject
             */

            dataGraph = SDOUtil.createDataGraph();
            company = dataGraph.createRootObject(SdoSampleConstants.COMPANY_NAMESPACE, "CompanyType");                                         
            
        } else {

            /*
             * The following creates a DataObject without a DataGraph
             */
            Type companyType = TypeHelper.INSTANCE.getType(SdoSampleConstants.COMPANY_NAMESPACE, "CompanyType");
            // this is equivilent to
            // DataObject company = DataFactory.INSTANCE.create(SdoSampleConstants.COMPANY_NAMESPACE, "CompanyType");            
            company = DataFactory.INSTANCE.create(companyType);
        }

        System.out.println("Populating company DataObject");
        company.setString("name", "ACME");
        company.setString("employeeOfTheMonth", "E0001");

        System.out.println("Creating Deptartment");
        DataObject depts = company.createDataObject("departments",SdoSampleConstants.COMPANY_NAMESPACE,"DepartmentType");

        depts.setString("name", "Advanced Technologies");
        depts.setString("location", "NY");
        depts.setString("number", "123");

        System.out.println("Creating employee John Jones");
        DataObject johnJones = depts.createDataObject("employees",SdoSampleConstants.COMPANY_NAMESPACE, "EmployeeType");
        johnJones.setString("name", "John Jones");

        johnJones.setString("SN", "E0001");

        System.out.println("Creating employee Jane Doe");
        DataObject janeDoe = depts.createDataObject("employees",SdoSampleConstants.COMPANY_NAMESPACE, "EmployeeType");
        janeDoe.setString("name", "Jane Doe");
        janeDoe.setString("SN", "E0003");

        System.out.println("Creating manager A Varone");
        DataObject fVarone = depts.createDataObject("employees",SdoSampleConstants.COMPANY_NAMESPACE, "EmployeeType");
        fVarone.setString("name", "A Varone");
        fVarone.setString("SN", "E0004");
        fVarone.setString("manager", "true");
        System.out.println("DataObject creation completed");
        System.out.println();
                
        // print out the generated company DataObject or DataGraph according to user preferences
        if (useDataGraph) {
            //write the DataGraph to generated xml file
            FileOutputStream fos = new FileOutputStream(COMPANY_DATAGRAPH_GENERATED_XML);
            System.out.println("Writing company DataGraph to " + COMPANY_DATAGRAPH_GENERATED_XML);
            // print the Company DataObject
            SDOUtil.saveDataGraph(dataGraph, fos, null);
                        
            // print the company DataGraph to System.out
            System.out.println("The xml for the created DataGraph would like : ");
            SDOUtil.saveDataGraph(dataGraph, System.out, null);

        } else {
            
            //write out to a generated xml file      
            FileOutputStream fos = new FileOutputStream(COMPANY_GENERATED_XML);
            System.out.println("Writing company DataObject to " + COMPANY_GENERATED_XML);
            // print the Company DataObject
            XMLHelper.INSTANCE.save(company, SdoSampleConstants.COMPANY_NAMESPACE, "company", fos);
            
            // print the company DataObject to System.out
            String generatedXml = XMLHelper.INSTANCE.save(company, SdoSampleConstants.COMPANY_NAMESPACE, "company");
            System.out.println("The generated xml for the DataObject would look like : " );
                    System.out.println(generatedXml);
        }

    }
    
    /**
     * Defines company types using XSD.
     * @throws Exception
     */
    private static void defineCompanyTypes() throws Exception {

        System.out.println("Defining Types using XSD");
        InputStream is = null;

        System.out.println("Opening input stream to  " + SdoSampleConstants.COMPANY_XSD);
        is = ClassLoader.getSystemResourceAsStream(SdoSampleConstants.COMPANY_XSD);
        List types = XSDHelper.INSTANCE.define(is, null);      
        is.close();
        System.out.println("Type definition completed");

    }

    /**
     * Utility method to obtain information from the user about whether or not they would like to use a DataGraph or simply use a DataObject
     * 
     * @return whether or not a DataGraph should be used
     * @throws Exception
     */
    private static boolean shouldUseDataGraph() throws Exception {

        System.out.print("Create company DataObject associated with a DataGraph {y,n} :");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String answer = in.readLine();
        while ((! answer.equalsIgnoreCase("n")) && (! answer.equalsIgnoreCase("y"))) {
            
            System.out.println();
            System.out.print("Sorry, please enter 'y' or 'n':");
            answer = in.readLine();
        }
        System.out.println();

        if (answer.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }


}
