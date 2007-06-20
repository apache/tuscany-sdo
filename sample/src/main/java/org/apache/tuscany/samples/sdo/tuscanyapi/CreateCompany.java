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

package org.apache.tuscany.samples.sdo.tuscanyapi;

import java.io.FileOutputStream;

import org.apache.tuscany.samples.sdo.SdoSampleConstants;
import org.apache.tuscany.sdo.api.SDOUtil;

import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;

/**
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
 * java org.apache.tuscany.samples.sdo.tuscanyApi.CreateCompany</LI>
 * </UL>
 */
public class CreateCompany extends org.apache.tuscany.samples.sdo.otherSources.CreateCompany {

    public CreateCompany(Integer userLevel) {
      super(userLevel);
    }

    /**
     * XML file generated for the company DataGraph
     */  
    private String COMPANY_DATAGRAPH_GENERATED_XML = "companyDataGraphGenerated.xml";

    
    /**
     * Main method.  Execute this method in order to run sample
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) {
      /*
       * this sample is best suited so someone with an intermediate level
       * of understanding of SDO.  Change the experience level argument to get more
       * or less commentary.
       */
      CreateCompany sample = new CreateCompany(INTERMEDIATE);
      sample.run();

    }

    public void runSample () throws Exception {
      
        banner('*',
               "              SDO Sample Create Company in a DataGraph              \n\n"+
               "This is a variant of the simple CreateCompany sample, but\n"+
               "demonstrates how to create a DataGraph in the absence of a Data Access Service (DAS)\n"+
               "This is not typical of how an SDO user would code, because a DAS is usually\n"+
               "responsible for creating a DataGraph instance. This is why we must use a Tuscany API\n"+
               "to create the dataGraph in the first place\n"+
               "If you don't have a need to use a DataGraph instance then you may want to skip this\n"+
               "sample,  or leave it until you have explored the DataObject interface fully\n");
        
        commentary(INTERMEDIATE,
            "As we are dealing with a DataGraph,  the SDO API has some gray areas at the moment\n"+
            "in that the DataGraph API hasn't yet been developed to deal with scopes\n"+
            "other than the default scope. So here is an occasion where we must use"+
            "the default singleton scope");
        HelperContext scope = useDefaultScopeForTypes();
        loadXMLSchemaFromFile(scope, SdoSampleConstants.COMPANY_XSD);
       
        commentary (INTERMEDIATE,
            "Here is the use of the Tuscany API for creating a DataGraph instance\n\n"+
            "DataGraph dataGraph = SDOUtil.createDataGraph();");

        DataGraph dataGraph = SDOUtil.createDataGraph();
        
        commentary(INTERMEDIATE,
            "Now we create a root object of a selected type for the DataGraph wrapper to contain.\n"+
            "This is an example of a DataGraph interface that currently forces us to use the default scope.\n\n"+
            "company = dataGraph.createRootObject(SdoSampleConstants.COMPANY_NAMESPACE, \"CompanyType\");");
        
        DataObject company = dataGraph.createRootObject(SdoSampleConstants.COMPANY_NAMESPACE, "CompanyType");
        
        populateGraph(scope, company);
        
        commentary(INTERMEDIATE,
            "Since the SDO API doesn't currently have a method for serializing the DataGraph instance\n"+
            "we again use a Tuscany specific API\n\n"+
            "SDOUtil.saveDataGraph(dataGraph, fos, null);");
        
        FileOutputStream fos = new FileOutputStream(COMPANY_DATAGRAPH_GENERATED_XML);
        SDOUtil.saveDataGraph(dataGraph, fos, null);
                    
        SDOUtil.saveDataGraph(dataGraph, System.out, null);
    }

}
