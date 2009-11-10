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
import org.apache.tuscany.samples.sdo.advanced.PrintDataGraph;
import org.apache.tuscany.samples.sdo.internal.SampleInfrastructure;

import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;

/**
 * Demonstrates accessing the properties of a DataObject using integer property indices.
 * <p>
 * <h3>Running this Sample</h3> See <A HREF="../../../../../../index.html" 
 * target="_top">the main overview</A> for instructions on how to run this 
 * sample.
 */

public class AccessingDataObjectsViaPropertyIndex  extends SampleBase {

    HelperContext scope;
    PrintDataGraph printer;

    public AccessingDataObjectsViaPropertyIndex(Integer userLevel) {
      /*
       * Classifying this sample as intermediate,  not because it is complex
       * but because it's a scenario not to be encouraged for use by
       * people new to SDO.
       */
      super(userLevel, SAMPLE_LEVEL_INTERMEDIATE);
      printer = new PrintDataGraph(SAMPLE_LEVEL_ADVANCED);
    }


    /**
     * Predefine the property indexes.
     */

    private static final int COMPANY_DEPARTMENT = 0;
    private static final int COMPANY_NAME = 1;
    private static final int COMPANY_EMPLOYEE_OF_MONTH = 2;

    private static final int DEPARTMENT_EMPLOYEES = 0;

    private static final int EMPLOYEE_NAME = 0;
    private static final int EMPLOYEE_SN = 1;
    private static final int EMPLOYEE_MANAGER = 2;


    /**
     * Execute this method in order to run the sample.
     * 
     * @param args
     */
    public static void main(String[] args) {
      AccessingDataObjectsViaPropertyIndex sample =
        new AccessingDataObjectsViaPropertyIndex(COMMENTARY_FOR_NOVICE);

      sample.run();
 
    }
    
    /*
     *  metadata for the sample documenting the areas of SDO that are explored
     */
    public static int [] CORE_FUNCTION = {
      SDOFacets.GET_SET_PROPERTIES_OF_DATAOBJECT_BY_INDEX
    };


    public void runSample () throws Exception {


      commentary(
          "This sample demonstrates the use of integer index to get and set\n" +
      		"Property values of a DataObject. This approach is optimized for\n" +
      		"performance,  but is fragile to changes to the Type system.  It will be\n" +
      		"broken if someone alters the XML schema that is used to load the type system." +
      		"This kind of approach is well suited to a situation where the SDO code is being\n" +
      		"generated.");
      
      scope = createScopeForTypes();
        
      loadTypesFromXMLSchemaFile(scope, SampleInfrastructure.COMPANY_XSD);

      DataObject company = getDataObjectFromFile(scope, SampleInfrastructure.COMPANY_DATAOBJECT_XML);

      commentary("We've loaded a data graph that looks like this ...");
      
      printer.print(company);
      System.out.println(printer.getBuf());
      printer.reset();

      commentary("Here's how the data graph looks rendered in XML ...");
      System.out.println(
          scope.getXMLHelper().save(company, SampleInfrastructure.COMPANY_NAMESPACE, "company"));
 
      commentary(
          "This sample class has primitive int static constants defined for the Properties\n" +
      		"of the Types that the program is designed to work with, e.g.\n\n" +
      		"private static final int COMPANY_NAME = 2;\n\n" +
      		"The value of the integers is defined by the sequence the Properties\n" +
      		"appear in the List returned by dataObject.getType().getDeclaredProperties()\n" +
      		"For a type derived from an XML schema this will be the sequence they appeared in the\n" +
      		"schema document.\n" +
      		"We can use these integer values to get and set Properties on the company DataObject\n\n" +
      		"company.setString(COMPANY_NAME, \"MegaCorp\");\n" +
      		"List departments = company.getList(COMPANY_DEPARTMENT);\n" +
      		"List employees = department.getList(DEPARTMENT_EMPLOYEES);\n");
      
      company.setString(COMPANY_NAME, "MegaCorp");

      
      
      commentary("The sample continues,  altering the data graph by using the getter\n" +
      		"and setter methods that take int arguments");
      
      List departments = company.getList(COMPANY_DEPARTMENT);
      DataObject department = (DataObject) departments.get(0);
      List employees = department.getList(DEPARTMENT_EMPLOYEES);
      DataObject employeeFromList = (DataObject) employees.get(2);
      employeeFromList.detach();

      DataObject newEmployee = department.createDataObject(DEPARTMENT_EMPLOYEES);

      newEmployee.set(EMPLOYEE_NAME, "Al Smith");
      newEmployee.set(EMPLOYEE_SN, "E0005");
      newEmployee.setBoolean(EMPLOYEE_MANAGER, true);

      company.set(COMPANY_EMPLOYEE_OF_MONTH, newEmployee.get(EMPLOYEE_SN));

      commentary("After some more manipulation (take a look at the sample code to see the detail)\n" +
      		"we can examine the state of the modified graph");
      
      printer.print(company);
      System.out.println(printer.getBuf());
      printer.reset();

      commentary("Or rendered in XML it now looks like this ...");
      System.out.println(scope.getXMLHelper().save(company, SampleInfrastructure.COMPANY_NAMESPACE, "company"));

    }
}
