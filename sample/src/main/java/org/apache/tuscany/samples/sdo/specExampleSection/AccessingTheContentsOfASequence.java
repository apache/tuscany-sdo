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

package org.apache.tuscany.samples.sdo.specExampleSection;


import org.apache.tuscany.samples.sdo.SampleBase;
import org.apache.tuscany.samples.sdo.specCodeSnippets.AccessDataObjectPropertiesByName;

import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;
import commonj.sdo.DataObject;
import commonj.sdo.Sequence;
import commonj.sdo.Property;

/**
 * Demonstrates accessing the sequence from a DataObject containing mixed content.
 * 
 * The following sample is from the <a href="http://incubator.apache.org/tuscany"
 * target="_blank"> Apache Tuscany</a> project. It was written to help users
 * understand and experiement with SDO. It is based upon example code contained
 * within, and is meant for use with, and reference to the <a
 * href="http://www.osoa.org/download/attachments/791/SDO_Specification_Java_V2.01.pdf?version=1"
 * target="_bank">SDO Specification</a>. In general this sample attempts to use the
 * code and comments contained within the specification, exceptions to this are noted
 * in comments.<br>
 * 
 * Specifically the following sample is based upon the 'Accessing the contents of a Sequence' example from the Examples section of the SDO specification. <br>
 * <br>
 * The following code uses the Sequence interface to analyze the contents of a DataObject that conforms to teh Letter model defined in
 * {@link #LETTER_XSD}. This code first goes through the Sequence looking for unformatted text entrires and prints them out. Then the code checks to
 * verify that the contents of teh "lastName" property of the DataObject matches the contents of the same property of the Sequence. <br>
 * <br>
 * This sample reads an xml file (@link #LETTER_XML} representing a DataObject of a letter. In order to create a DataObject or DataGraph this sample
 * relies upon XMLHelper class which is an example of a XML DAS. The code shown here would work just as well against an equivalent DataObject that was
 * provided by any DAS. <br>
 * 
 * The XSD for {@link #LETTER_XSD} defines the FormLetter complex type as mixed.   Mixed content and sequences are often used for semi structured business data.
 * <br><br>
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
 * These jar files can be obtained by downloading and unpacking a <a href="http://cwiki.apache.org/TUSCANY/sdo-downloads.html" target="_blank">Tuscany binary distribution </a> </LI>
 * <LI>Execute: <br>
 * java org.apache.tuscany.samples.sdo.specExampleSection.AccessingTheContentsOfASequence</LI>
 * </UL>
 * 
 * @author Robbie Minshall
 */

public class AccessingTheContentsOfASequence  extends SampleBase {


    HelperContext scope;

    public AccessingTheContentsOfASequence(Integer userLevel) {
      super(userLevel);
    }


    /**
     * previously created XSD file used
     */
    public static final String LETTER_XSD = "letter.xsd";

    /**
     * previously created XML file used
     */
    public static final String LETTER_XML = "letter.xml";

    /**
     * Execute this method in order to run the sample.
     * 
     * @param args
     */
    public static void main(String[] args) {
      // TODO make the default level COMMENTARY_FOR_NOVICE, once the rest of the sample has been
      // converted to using commentary()
      AccessDataObjectPropertiesByName sample = new AccessDataObjectPropertiesByName(COMMENTARY_FOR_INTERMEDIATE);

      sample.run();

    }

    public void runSample () throws Exception {
        System.out.println("***************************************");
        System.out.println("SDO Sample AccessingTheContentsOfASequence");
        System.out.println("***************************************");
        System.out.println("Demonstrates accessing the sequence from a DataObject containing mixed content.");
        System.out.println("***************************************");

        scope = createScopeForTypes();
        
        try {
            // define model
            System.out.println("Defining Types using XSD");
            scope.getXSDHelper().define(ClassLoader.getSystemResourceAsStream(LETTER_XSD), null);

            // define letter data object
            System.out.println("Loading Letter DataObject from XML");
            DataObject letter = scope.getXMLHelper().load(ClassLoader.getSystemResourceAsStream(LETTER_XML)).getRootObject();

            // print letter sequence
            System.out.println("Printing sequence for " + letter);
            System.out.println(scope.getXMLHelper().save(letter, "letter.xsd", "letter"));
            printSequence(letter);

        } catch (Exception e) {
            System.out.println("Sorry there was an error encountered " + e.toString());
            e.printStackTrace();
        }
        System.out.println("GoodBye");

    }

    /**
     * Uses the Sequence interface to analyze the contents of a DataObject that conforms to teh Letter model defined in
     * {@link #LETTER_XSD}. This code first goes through the Sequence looking for unformatted text entrires and prints them out. Then the code checks
     * to verify that the contents of the "lastName" property of the DataObject matches the contents of the same property of the Sequence. <br>
     * 
     * @param letter.  Letter DataObject conforming to {@link #LETTER_XSD}
     */
    public void printSequence(DataObject letter) {
        // Access the Sequence of the FormLetter
        System.out.println("The type is for letter dataObject is mixed " + scope.getXSDHelper().isMixed(letter.getType()));
        
        Sequence letterSequence = letter.getSequence();
        // Print out all the settings that contain unstructured text
        System.out.println("Unstructured text:");
        for (int i = 0; i < letterSequence.size(); i++) {

            /*
             * Please note that the following line is a correction to the 2.0 specification which incorrectly calls:
             * 
             * String propertyName = ((Property) letterSequence.getProperty(i)).getName();
             * 
             * According to the SDO API sequence.getProperty will return null if the content is mixed, in this case
             * we want to print it out as unstructured text         
             */
            Property prop = letterSequence.getProperty(i);                                 
            if (prop == null) {
                String text = (String) letterSequence.getValue(i);
                System.out.println("\t(" + text + ")");
            }
           
        }

        /*
         * Please note that the following line is a correction to the 2.0 Specification which incorrectly uses letterDataObject variable rather than
         * simply letter
         */
        // Verify that the lastName property of the DataObject has the same
        // value as the lastName property for the Sequence.
        String dataObjectLastName = letter.getString("lastName");
        for (int i = 0; i < letterSequence.size(); i++) {

            /*
             * The following line has been corrected from the 2.0 specification
             * According to the SDO API sequence.getProperty will return null if the content is mixed.
             * We want to check that the content is not mixed, and then check that it it is the property which 
             * we are looking for
             */
            Property property = letterSequence.getProperty(i);
            
            if ( (property != null) && ("lastName".equals(property.getName()))) {
                String sequenceLastName = (String) letterSequence.getValue(i);
                if (dataObjectLastName == sequenceLastName)
                    System.out.println("Last Name property matches");
                break;
            }
        }
    }

}
