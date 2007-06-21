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

import org.apache.tuscany.samples.sdo.SampleBase;
import org.apache.tuscany.samples.sdo.SdoSampleConstants;

import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;

/**
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
public class CreateCompany extends SampleBase {

    public CreateCompany(Integer commentaryLevel) {
      this(commentaryLevel, SAMPLE_LEVEL_NOVICE);
    }

    public CreateCompany(Integer commentaryLevel, Integer sampleLevel) {
      super(commentaryLevel, sampleLevel);
    }
    /**
     * XML file generated for the company DataObject
     */    
    private static final String COMPANY_GENERATED_XML = "companyGenerated.xml";
    
    /**
     * Main method.  Execute this method in order to run sample
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) {
      /*
       * this sample is suitable for a novice to SDO.
       * Change the experience level constructor argument to one of
       * COMMENTARY_FOR_NOVICE, COMMENTARY_FOR_INTERMEDIATE, COMMENTARY_FOR_ADVANCED, change
       * the level of commentary output.
       */
      CreateCompany sample = new CreateCompany(COMMENTARY_FOR_NOVICE);

      sample.run();

    }

    public void runSample () throws Exception {
      
        banner('*',
               "Demonstrates how to create a data graph using a model loaded\n"+
               "from an XML Schema contained in a file on the file system");
                
        HelperContext scope = createScopeForTypes();       
        loadTypesFromXMLSchemaFile(scope, SdoSampleConstants.COMPANY_XSD);
        
        commentary(
            "Now that our type system has been loaded and made available through the scope\n"+
            "DataObjects can be created by a DataFactory that has access to the required types.\n\n"+
            "DataObject company = scope.getDataFactory().create(SdoSampleConstants.COMPANY_NAMESPACE, \"CompanyType\");");
        
        DataObject company = scope.getDataFactory().create(SdoSampleConstants.COMPANY_NAMESPACE, "CompanyType");
        
        populateGraph(scope, company);
            
        FileOutputStream fos = new FileOutputStream(COMPANY_GENERATED_XML);
        
        commentary(
            "The XMLHelper can be used to write an XML serialized version of the data graph\n\n"+
            "scope.getXMLHelper().save(company, SdoSampleConstants.COMPANY_NAMESPACE, \"company\", fos);");
        
        scope.getXMLHelper().save(company, SdoSampleConstants.COMPANY_NAMESPACE, "company", fos);
        
        commentary(
            "Similarly we can serialize the graph to an XML String using the XMLHelper\n\n"+
            "String xml = scope.getXMLHelper().save(company, SdoSampleConstants.COMPANY_NAMESPACE, \"company\");\n");
        
        String xml = scope.getXMLHelper().save(company, SdoSampleConstants.COMPANY_NAMESPACE, "company");
        
        System.out.println(xml);

    }
    
    public void populateGraph(HelperContext scope, DataObject company)
    {

      System.out.println("Populating the company DataObject");
      company.setString("name", "ACME");
      company.setString("employeeOfTheMonth", "E0001");
    
      System.out.println("Creating a Department");
    
      DataObject depts = company.createDataObject("departments");
    
      depts.setString("name", "Advanced Technologies");
      depts.setString("location", "NY");
      depts.setString("number", "123");
    
      System.out.println("Creating an employee: John Jones");
      DataObject johnJones = depts.createDataObject("employees");
      johnJones.setString("name", "John Jones");
    
      johnJones.setString("SN", "E0001");
    
      System.out.println("Creating an employee: Jane Doe");
      DataObject janeDoe = depts.createDataObject("employees");
      janeDoe.setString("name", "Jane Doe");
      janeDoe.setString("SN", "E0003");
    
      System.out.println("Creating a manager: Fred Bloggs");
      DataObject fVarone = depts.createDataObject("employees");
      fVarone.setString("name", "Fred Bloggs");
      fVarone.setString("SN", "E0004");
      fVarone.setString("manager", "true");
      System.out.println("DataObject creation completed");
      System.out.println();
    }

}
