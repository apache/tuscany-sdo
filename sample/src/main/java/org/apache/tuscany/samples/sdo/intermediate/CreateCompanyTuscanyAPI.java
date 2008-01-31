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

import java.io.FileOutputStream;

import org.apache.tuscany.samples.sdo.internal.SampleInfrastructure;
import org.apache.tuscany.sdo.api.SDOUtil;

import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;

/**
 * This sample is a variant of the CreateCompany sample where the graph of DataObjects
 * is contained in an instance of DataGraph.
 * <p>
 * <h3>Running this Sample</h3> See <A HREF="../../../../../../index.html" 
 * target="_top">the main overview</A> for instructions on how to run this 
 * sample.
 */
public class CreateCompanyTuscanyAPI extends org.apache.tuscany.samples.sdo.basic.CreateCompany {

    public CreateCompanyTuscanyAPI(Integer commentaryLevel) {
      super(commentaryLevel, SAMPLE_LEVEL_INTERMEDIATE);
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
      CreateCompanyTuscanyAPI sample = new CreateCompanyTuscanyAPI(COMMENTARY_FOR_INTERMEDIATE);
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
        
        commentary(COMMENTARY_FOR_INTERMEDIATE,
            "As we are dealing with a DataGraph,  the SDO API has some gray areas at the moment\n"+
            "in that the DataGraph API hasn't yet been developed to deal with scopes\n"+
            "other than the default scope. So here is an occasion where we must use "+
            "the default singleton scope");
        HelperContext scope = useDefaultScopeForTypes();
        loadTypesFromXMLSchemaFile(scope, SampleInfrastructure.COMPANY_XSD);
       
        commentary (COMMENTARY_FOR_INTERMEDIATE,
            "Here is the use of the Tuscany API for creating a DataGraph instance\n\n"+
            "DataGraph dataGraph = SDOUtil.createDataGraph();");

        DataGraph dataGraph = SDOUtil.createDataGraph();
        
        commentary(COMMENTARY_FOR_INTERMEDIATE,
            "Now we create a root object of a selected type for the DataGraph wrapper to contain.\n"+
            "This is an example of a DataGraph interface that currently forces us to use the default scope.\n\n"+
            "company = dataGraph.createRootObject(SampleInfrastructure.COMPANY_NAMESPACE, \"CompanyType\");");
        
        DataObject company = dataGraph.createRootObject(SampleInfrastructure.COMPANY_NAMESPACE, "CompanyType");
        
        populateGraph(scope, company);
        
        commentary(COMMENTARY_FOR_INTERMEDIATE,
            "Since the SDO API doesn't currently have a method for serializing the DataGraph instance\n"+
            "we again use a Tuscany specific API\n\n"+
            "SDOUtil.saveDataGraph(dataGraph, fos, null);");
        
        FileOutputStream fos = new FileOutputStream(COMPANY_DATAGRAPH_GENERATED_XML);
        SDOUtil.saveDataGraph(dataGraph, fos, null);
                    
        SDOUtil.saveDataGraph(dataGraph, System.out, null);
    }

}
