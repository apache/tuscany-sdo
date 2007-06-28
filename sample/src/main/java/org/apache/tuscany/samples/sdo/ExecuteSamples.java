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

package org.apache.tuscany.samples.sdo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.tuscany.samples.sdo.otherSources.*;
import org.apache.tuscany.samples.sdo.specCodeSnippets.*;
import org.apache.tuscany.samples.sdo.specExampleSection.*;

/**
 * Executes all command line samples. <br>
 * <br>
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
 * <LI>Execute: <br>
 * java org.apache.tuscany.samples.sdo.ExecuteSamples </LI>
 * </UL>
 */
public class ExecuteSamples {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {

            System.out.println("Welcome to SDO Sample Land");
            System.out.println("This class will simply execute samples within this jar file");

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println();
            System.out.println();
            System.out.println("There are currently three groups of samples");
            System.out.println("1. Simple code snippets located throughout the specifiction with comparative methods for acheiving the same results");
            System.out.println("2. Full examples located within Examples section of specification");
            System.out.println("3. Other sample sources such as white papers and online articles");
            System.out.println(">>>Press Enter to continue");
            in.readLine();
            System.out
                    .println("--------------------------------------------------------------------------------------------------------------------------");
            System.out
                    .println("Lets start with some basics.  These samples are located within the org.apache.tuscany.sdo.samples.specCodeSnipets package."
                            + "  They demonstrate many code snippets that are located throughout the SDO specification");
            System.out
                    .println("--------------------------------------------------------------------------------------------------------------------------");

            System.out.println(">>>Press Enter to continue");
            in.readLine();
            CreateDataObjectFromXmlString.main(args);
            System.out.println(">>>Press Enter for next sample");
            in.readLine();
            AccessDataObjectPropertiesByName.main(args);
            System.out.println(">>>Press Enter to continue");
            in.readLine();
            
            //The following samples are still under construction 
            
            //CreateXmlAndXsdFromDataObject.main(args);
            //System.out.println(">>>Press Enter for next sample");
            //in.readLine();
            //DataObjectWithChangeSummary.main(args);
            //System.out.println(">>>Press Enter for next sample");
            //in.readLine();
            
            DynamicCustomerTypeSample.main(args);
            System.out.println(">>>Press Enter for next sample");
            in.readLine();

            ObtainingDataGraphFromXml.main(args);

            System.out.println();
            System.out
                    .println("--------------------------------------------------------------------------------------------------------------------------");
            System.out
                    .println("The following group of samples implement the examples located within Examples section of specification and are located in "
                            + "the org.apache.tuscany.sdo.samples.specExampleSection package");
            System.out
                    .println("--------------------------------------------------------------------------------------------------------------------------");

            System.out.println(">>>Press Enter to continue");
            in.readLine();
            AccessDataObjectsUsingXPath.main(args);
            System.out.println(">>>Press Enter for next sample");
            in.readLine();

            AccessingDataObjectsViaPropertyIndex.main(args);
            System.out.println(">>>Press Enter for next sample");
            in.readLine();

            AccessingTheContentsOfASequence.main(args);
            System.out.println(">>>Press Enter for next sample");
            in.readLine();

            CreatingDataObjectTreesFromXMLDocuments.main(args);
            System.out.println(">>>Press Enter for next sample");
            in.readLine();

            CreatingXmlFromDataObjects.main(args);
            System.out.println(">>>Press Enter for next sample");
            in.readLine();

            SerializingDeserializingADataObject.main(args);
            System.out.println(">>>Press Enter for next sample");
            in.readLine();

            UsingTypeAndPropertyWithDataObjects.main(args);
            System.out.println(">>>Press Enter for next sample");
            in.readLine();

            System.out.println();
            System.out
                    .println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("The following group of samples come from sources other than the specification");
            System.out
                    .println("--------------------------------------------------------------------------------------------------------------------------");

            System.out
                    .println("The next two samples are based upon Fuhwei Lwo's paper http://www-128.ibm.com/developerworks/webservices/library/ws-sdoxmlschema/");
            System.out.println(">>>Press Enter to continue");
            in.readLine();
            CreatePurchaseOrder.main(args);
            System.out.println(">>>Press Enter for next sample");
            in.readLine();
            ReadPurchaseOrder.main(args);

            System.out.println();
            System.out.println();
            System.out
                    .println("The following sample is slightly more extensive and provides a interactive menu to play with purchase order DataObjects");
            System.out.println(">>>Press Enter to continue");
            in.readLine();
            PurchaseOrderCmdLine.main(args);

        } catch (Exception e) {
            System.out.println("Sorry an exception was encountered " + e.toString());
            e.printStackTrace();
        }
        System.out.println("All done, goodBye");

    }

}
