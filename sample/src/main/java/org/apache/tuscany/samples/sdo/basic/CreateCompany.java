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

package org.apache.tuscany.samples.sdo.basic;

import java.io.FileOutputStream;

import org.apache.tuscany.samples.sdo.SampleBase;
import org.apache.tuscany.samples.sdo.internal.SampleInfrastructure;


import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;

/**
 * This sample uses the scenario of building a description of a company to demonstrate
 * primarily the setting of data using strings to name Properties.
 * <p>
 * <h3>Running this Sample</h3> See <A HREF="../../../../../../index.html" 
 * target="_top">the main overview</A> for instructions on how to run this 
 * sample.
 */
public class CreateCompany extends SampleBase {

    public CreateCompany(Integer commentaryLevel) {
      this(commentaryLevel, SAMPLE_LEVEL_BASIC);
    }

    public CreateCompany(Integer commentaryLevel, Integer sampleLevel) {
      super(commentaryLevel, sampleLevel);
    }
    
    /*
     *  metadata for the sample documenting the areas of SDO that are explored
     */
    public static int [] CORE_FUNCTION = {
        SDOFacets.SET_PROPERTIES_OF_DATAOBJECT_BY_NAME
    };
    
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
        loadTypesFromXMLSchemaFile(scope, SampleInfrastructure.COMPANY_XSD);
        
        commentary(
            "Now that our type system has been loaded and made available through the scope\n"+
            "DataObjects can be created by a DataFactory that has access to the required types.\n\n"+
            "DataObject company = scope.getDataFactory().create(SampleInfrastructure.COMPANY_NAMESPACE, \"CompanyType\");");
        
        DataObject company = scope.getDataFactory().create(SampleInfrastructure.COMPANY_NAMESPACE, "CompanyType");
        
        populateGraph(scope, company);
            
        FileOutputStream fos = new FileOutputStream(COMPANY_GENERATED_XML);
        
        commentary(
            "The XMLHelper can be used to write an XML serialized version of the data graph\n\n"+
            "scope.getXMLHelper().save(company, SampleInfrastructure.COMPANY_NAMESPACE, \"company\", fos);");
        
        scope.getXMLHelper().save(company, SampleInfrastructure.COMPANY_NAMESPACE, "company", fos);
        
        commentary(
            "Similarly we can serialize the graph to an XML String using the XMLHelper\n\n"+
            "String xml = scope.getXMLHelper().save(company, SampleInfrastructure.COMPANY_NAMESPACE, \"company\");\n");
        
        String xml = scope.getXMLHelper().save(company, SampleInfrastructure.COMPANY_NAMESPACE, "company");
        
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
