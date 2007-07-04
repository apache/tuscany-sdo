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

package org.apache.tuscany.samples.sdo.advanced;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.tuscany.samples.sdo.SampleBase;
import org.apache.tuscany.samples.sdo.SampleInfrastructure;
import org.apache.tuscany.sdo.api.SDOUtil;


import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;
import commonj.sdo.DataObject;
import commonj.sdo.DataGraph;
import commonj.sdo.Sequence;

/**
 * This sample program demonstrates a variety of methods available to obtain the root DataObject
 * contained within an xml representation of a DataGraph. This is currently a grey
 * area of the specification and this sample demonstrates spec compliant methods, as
 * well as utility methods that have been added to Tuscany to address issues within
 * the specification.
 * 
 * The following sample is from the <a href="http://incubator.apache.org/tuscany"
 * target="_blank"> Apache Tuscany</a> project. It was written to help users
 * understand and experiment with SDO. It is based upon example code contained
 * within, and is meant for use with, and reference to the <a
 * href="http://osoa.org/download/attachments/36/Java-SDO-Spec-v2.1.0-FINAL.pdf?version=1"
 * target="_bank">SDO Specification</a>. This sample attempts to clarify aspects of
 * the the AccessDataObjectsUsingXPath example from the Examples section of the SDO
 * specification.<br>
 * <br>
 * To define the correct Types for each DataObject ( CompanyType, DepartmentType etc )
 * this sample relies upon
 * {@link org.apache.tuscany.samples.sdo.SampleInfrastructure#COMPANY_XSD} which is
 * provided in the resources directory of these samples. The xml file
 * {@link org.apache.tuscany.samples.sdo.SampleInfrastructure#COMPANY_DATAGRAPH_XML} is
 * used to load the DataGraph and is also located in this resources directory. <br>
 * <P>
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
 * These jar files can be obtained by downloading and unpacking a <a href="http://cwiki.apache.org/TUSCANY/sdo-downloads.html" target="_blank">Tuscany binary distribution</a>  </LI>
 * <LI>Execute: <br>
 * java org.apache.tuscany.samples.sdo.specCodeSnippets.ObtainingDataGraphFromXml</LI>
 * </UL>
 * 
 * @see org.apache.tuscany.samples.sdo.specExampleSection.AccessDataObjectsUsingXPath
 */

public class ObtainingDataGraphFromXml extends SampleBase {
  
    HelperContext scope;


   
    public ObtainingDataGraphFromXml(Integer userLevel) {
      super(userLevel, SAMPLE_LEVEL_ADVANCED);
    }
    
    public static void main(String[] args) {
      
      /*
       * Create an instance of the sample program.  Edit the "commentaryLevel" argument to suit
       * your experience, COMMENTARY_FOR_NOVICE, COMMENTARY_FOR_INTERMEDIATE or COMMENTARY_FOR_ADVANCED
       */
      ObtainingDataGraphFromXml sample =
    	  new ObtainingDataGraphFromXml(COMMENTARY_FOR_ADVANCED);
      sample.run();
      
    }
    
    
    public void runSample () {
        banner('*',
            "SDO Sample " + this.getClass().getName() + "\n\n" +

            "This sample touches an area of the SDO API where the emphasis has changed over the various\n"+
            "version of the specification,  and so it's important to be clear what's going on\n"+
            "First off lets be sure of our terminology ...\n"+
            "1) A \"data graph\" is a just collection of DataObjects, all contained within a single\n"+
            "containment hierarchy, with a single root object, and possibly having some non-containment\n"+
            "references\n"+
            "2) A \"DataGraph\" is an instance of the SDO DataGraph class, used as a container for the root\n"+
            "DataObject of a data graph, and providing a means to access a change summary for the data graph.\n\n"+
            "More recent versions of the SDO specification have provided alternative means of containment\n"+
            "of a data graph ...\n"+
            "3) The graph can be contained in a DataObject of a built-in SDO Type  with namespace URI \"commonj.sdo\"\n" +
            "and name \"DataGraph\":  so this is a modeled version of the special DataGraph class.\n"+
            "4) The Graph can be contained in an XMLDocument instance,  which provides for things such as\n"+
            "naming the root element of an XML instance document"
        );
        
        scope = useDefaultScopeForTypes();
        loadTypesFromXMLSchemaFile(scope, SampleInfrastructure.COMPANY_XSD);
        


        try {
          



            DataObject company = null;

            commentary(
                "Here we see the specification's example for obtaining dealing with\n"+
                "loading a data graph which uses a method, XMLHelper.load().  This loads an XML instance document\n"+
                "into an instance of XMLDocument ...\n\n"+
                "XMLDocument doc = scope.getXMLHelper().load(\n"+
                "ClassLoader.getSystemResourceAsStream(SdoSampleConstants.COMPANY_DATAGRAPH_XML));"
                );
            
            InputStream is = ClassLoader.getSystemResourceAsStream(SampleInfrastructure.COMPANY_DATAGRAPH_XML);
            int x= is.available();
            byte b[]= new byte[x];
            is.read(b);
            String instanceDoc = new String(b);
            
            System.out.println(instanceDoc);

            XMLDocument doc = scope.getXMLHelper().load(
                    ClassLoader.getSystemResourceAsStream(SampleInfrastructure.COMPANY_DATAGRAPH_XML));
            
            commentary(
                "Now we can get the wrapper for the data graph, which in this case is the DataObject\n"+
                "of type commonj.sdo#DataGraph.  Note how there's no magic here;  no special class for\n"+
                "DataGraph,  no special handling,  this is just a standard pattern of using a built in SDO Type.\n"+
                "The wrapper is there purely because it was serialized\n"+
                "into the XML document, using the standard serialization technique.\n\n" +
                "DataObject dataObjectRepresentingDataGraph = doc.getRootObject();");
            
            DataObject dataObjectRepresentingDataGraph = doc.getRootObject();
 
            System.out.println(dataObjectRepresentingDataGraph);
            
            commentary(
                "If you are confused by the fact that what we really get is an instance of DataGraphTypeImpl\n"+
                "This really is a DataObject,  but it is a generated class extending DataObjectImpl\n+"+
                "representing the DataGraph model.");

            company = dataObjectRepresentingDataGraph.getDataObject("company");

            commentary(
                "We've obtained a DataObject representing the data graph, and from that we have obtained\n"+
                "the true root object of the business data");
            
            System.out.println(company);            
            System.out.println();
            
            commentary(
               "Using an instance of DataGraph can perhaps be seen as an older style pattern of wrapping a data graph\n"+
               "and the first approach is likely to get more emphaissi and attention in future revisions of the spec.\n"+
               "The SDO API has some limitations in the area of saving and loading instances of the\n"+
               "Java DataGraph type, so Tuscany has an API for doing this ...\n\n"+
               "DataGraph datagraph = SDOUtil.loadDataGraph(\n"+
               "      ClassLoader.getSystemResourceAsStream(SdoSampleConstants.COMPANY_DATAGRAPH_XML), null);"

            );

            DataGraph datagraph = SDOUtil.loadDataGraph(ClassLoader.getSystemResourceAsStream(SampleInfrastructure.COMPANY_DATAGRAPH_XML), null);

            System.out.println(datagraph);

            commentary(
                "In this case we directly receive an instance of DataGraph and can retrieve the root\n"+
                "business object from the DataGraph\n\n"+
                "DataObject company = datagraph.getRootObject();");
            
            company = datagraph.getRootObject();
            System.out.println(company);            
            System.out.println();
                      
        } catch (Exception e) {
            somethingUnexpectedHasHappened(e);
        }

    }
}
