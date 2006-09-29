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

import java.io.InputStream;

import org.apache.tuscany.samples.sdo.SdoSampleConstants;

import org.apache.tuscany.sdo.util.SDOUtil;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;
import commonj.sdo.DataObject;
import commonj.sdo.DataGraph;
import commonj.sdo.Sequence;

/**
 * Demonstrates a vareity of methods available to obtain the root DataObject
 *  contained within an xml representation of a DataGraph. This is currently a grey
 * area of the specification and this samples demonstrates spec complant means, as
 * well as utility methods that have been added to Tuscany to address issues within
 * the specification.
 * 
 * The following sample is from the <a href="http://incubator.apache.org/tuscany"
 * target="_blank"> Apache Tuscany</a> project. It was written to help users
 * understand and experiement with SDO. It is based upon example code contained
 * within, and is meant for use with, and reference to the <a
 * href="http://www.osoa.org/download/attachments/791/SDO_Specification_Java_V2.01.pdf?version=1"
 * target="_bank">SDO Specification</a>. This sample addresses confusing aspects of
 * the the AccessDataObjectsUsingXPath example from the Examples section of the SDO
 * specification.<br>
 * <br>
 * To define the correct Types for each DataObject ( CompanyType, DepartmentType etc )
 * this sample relies upon
 * {@link org.apache.tuscany.samples.sdo.SdoSampleConstants#COMPANY_XSD} which is
 * provided in the resources directory of these samples. The xml file
 * {@link org.apache.tuscany.samples.sdo.SdoSampleConstants#COMPANY_DATAGRAPH_XML} is
 * used to load the DataGraph and is also located in this resources directory. <br>
 * <br>
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
 * These jar files can be obtained from directly from Tuscany and EMF projects or from <a
 * href="http://wiki.apache.org/ws-data/attachments/Tuscany(2f)TuscanyJava(2f)SDO_Java_Overview/attachments/SDO%20Execution%20Dependencies"
 * target="_bank">SDO Execution Dependancies </a> </LI>
 * <LI>Execute: <br>
 * java org.apache.tuscany.samples.sdo.specCodeSnippets.ObtainingDataGraphFromXml</LI>
 * </UL>
 * 
 * @see org.apache.tuscany.samples.sdo.specExampleSection.AccessDataObjectsUsingXPath
 * @author Robbie Minshall
 */

public class ObtainingDataGraphFromXml {

    /**
     * Execute this method in order to run the sample.
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("***************************************");
        System.out.println("SDO Sample ObtainingDataGraphFromXml");
        System.out.println("***************************************");
        System.out.println("Demonstrates a vareity of methods available to obtain the root DataObject"
                + "contained within an xml representation of a DataGraph.");
        System.out.println("***************************************");
        

        // define Types
        try {
            System.out.println("Defining Types using XSD");
            InputStream is = null;
            is = ClassLoader.getSystemResourceAsStream(SdoSampleConstants.COMPANY_XSD);
            XSDHelper.INSTANCE.define(is, null);
            is.close();
            System.out.println("Type definition completed");
        } catch (Exception e) {
            System.out.println("Exception caught defining types " + e.toString());
            e.printStackTrace();
        }

        try {

            /**
             * A DataGraph is an optional envelope for a graph of DataObjects and an
             * associated ChangeSummary.
             * 
             * The specification group is currently investigating options regarding
             * obtaining a DataGraph from an xml file as well as the role of the
             * DataGraph within the SDO specification.
             * 
             * In order to obtain the rootObject contained within the specification
             * the specification demonstrates reading in an XML file and obtaining a
             * DataObject that represents the datagraph contained within the file.
             * Note, that the specification does not obtain a DataGraph - there are
             * not mechanisms within the specification for obtaining a DataGraph from
             * xml. Obtaining the root DataObject from this datagraph representation
             * is quite cumbersome and is demonstrated below.
             * 
             * In order to address this current limitation within the specification
             * Tuscany has added a utility method to SDOUtil that allows a user to
             * obtain an actual DataGraph from xml.
             */

            DataObject company = null;

            /**
             * Use specification mechanism for obtaining a DataObject that represents
             */
            // the a datagraph
            System.out.println("Using specification methods to obtain DataObject represeenting a datagraph from xml");

            // When the xml file represents a DataGraph the root Object
            // of the XMLDocument is a DataGraph
            DataObject dataObjectRepresentingDataGraph = XMLHelper.INSTANCE.load(
                    ClassLoader.getSystemResourceAsStream(SdoSampleConstants.COMPANY_DATAGRAPH_XML)).getRootObject();
                                              
            // Obtain the company DataObject from the DataObject representing the datagraph
            Sequence mySeq = (Sequence) dataObjectRepresentingDataGraph.getSequence("any");
            company = (DataObject) mySeq.getValue(0);

            System.out.println("Obtained DataObject representing datagraph");
            System.out.println(dataObjectRepresentingDataGraph);
            System.out.println("Obtained root DataObject from datagraph");
            System.out.println(company);            
            System.out.println();
            
            
            /**
             * Use utility method to obtain an actual DataGraph from the xml
             */                        
            DataGraph datagraph = SDOUtil.loadDataGraph(ClassLoader.getSystemResourceAsStream(SdoSampleConstants.COMPANY_DATAGRAPH_XML), null);
            // Obtain the company DataObject from the actual DataGraph
            company = datagraph.getRootObject();
            System.out.println("Obtained actual DataGraph:");
            System.out.println(datagraph);
            System.out.println("Obtained root DataObject from DataGraph:");
            System.out.println(company);            
            System.out.println();
                      
        } catch (Exception e) {
            System.out.println("Sorry there was an error encountered " + e.toString());
            e.printStackTrace();
        }
        System.out.println("GoodBye");

    }
}
