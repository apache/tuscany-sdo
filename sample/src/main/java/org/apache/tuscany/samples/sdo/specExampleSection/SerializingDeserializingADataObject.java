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

import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;
import commonj.sdo.helper.EqualityHelper;
import commonj.sdo.DataObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;


import org.apache.tuscany.samples.sdo.SampleBase;
import org.apache.tuscany.samples.sdo.SdoSampleConstants;
import org.apache.tuscany.samples.sdo.specCodeSnippets.AccessDataObjectPropertiesByName;

/**
 * Demonstrates serializing and deserializing a DataObject to disk.
 * 
 * The following sample is from the <a href="http://incubator.apache.org/tuscany"
 * target="_blank"> Apache Tuscany</a> project. It was written to help users
 * understand and experiement with SDO. It is based upon example code contained
 * within, and is meant for use with, and reference to the <a
 * href="http://www.osoa.org/download/attachments/791/SDO_Specification_Java_V2.01.pdf?version=1"
 * target="_bank">SDO Specification</a>. In general this sample attempts to use the
 * code and comments contained within the specification, exceptions to this are noted
 * in comments.<br>
 * <br>
 * The following sample is based upon the 'Serializing/Deserializing a DataGraph or DataObject' example from the Examples section of the SDO
 * specification. <br>
 * <br>
 * The DataObject and DataGraph interfaces extend java.io.Serializable, so any DataObject
 * or DataGraph be serialized.  The following code serializes the company dataObject to a file
 * of the user's choosing.  The file is not deleted after execution.<br> 
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
 * java org.apache.tuscany.samples.sdo.specExampleSection.SerializingDeserializingADataObject</LI>
 * </UL>
 * 
 * @author Robbie Minshall
 */

public class SerializingDeserializingADataObject  extends SampleBase {


    HelperContext scope;

    public SerializingDeserializingADataObject(Integer userLevel) {
      super(userLevel);
    }


    /**
     * Default fileName to serialize DataObject to
     */
    public static final String DEFAULT_FILE_NAME = "temporarySerializedDataObject.xml";
    
    public static void serializeDO(DataObject DataObject, String fileName) throws IOException {
        // serialize data object
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(DataObject);
        out.close();
    }

    /**
     * Execute this method in order to run the sample.
     * 
     * @param args
     */
    public static void main(String[] args) {
      // TODO make the default level COMMENTARY_FOR_NOVICE, once the rest of the sample has been
      // converted to using commentary()
      AccessDataObjectPropertiesByName sample = new AccessDataObjectPropertiesByName(COMMENTARY_FOR_INTERMEDIATE);

      try {
        sample.run();
      }
      catch (Exception e) {
        sample.somethingUnexpectedHasHappened(e);
      }
    }

    public void runSample () throws Exception {
        System.out.println("***************************************");
        System.out.println("SDO Sample AccessingTheContentsOfASequence");
        System.out.println("***************************************");
        System.out.println("Demonstrates serializing and deserializing a DataObject to disk.");
        System.out.println("***************************************");
        

        try {
            scope = createScopeForTypes();

            // define Types using XSDHelper and predefined xsd file
            System.out.println("Defining Types using XSD");
            scope.getXSDHelper().define(ClassLoader.getSystemResourceAsStream(SdoSampleConstants.COMPANY_XSD), null);
            System.out.println("Type definition completed");

            // create company DataObject using XMLHelper which is an example of a XML DAS
            System.out.println("Creating company DataObject");
            DataObject company = scope.getXMLHelper().load(ClassLoader.getSystemResourceAsStream(SdoSampleConstants.COMPANY_DATAOBJECT_XML))
                    .getRootObject();

            // prompt user for a fileName
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Please enter file name, enter for default :");
            String fileName = in.readLine();
            if ( (fileName == null) || (fileName.equals(""))){
                fileName = DEFAULT_FILE_NAME;
            }
                     
            // serialize dataObject out
            System.out.println("Serializing DataObject to " + fileName);
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(company);
            out.close();            
            
            // read in DataObject
            System.out.println("Deserialize DataObject from file");
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream input = new ObjectInputStream(fis);
            DataObject newDataObject = (DataObject) input.readObject();
            input.close();
            
            /**
             * Compare DataObjects
             */
            
            System.out.println("Comparing original and deserialized DataObject");                       
            //determine if two graphs of DataObjects are equal 
            System.out.println("DataObjects are equal: " + scope.getEqualityHelper().equal(company, newDataObject));
            
            //determine if two DataObjects have the same values for their datatype properties          
            System.out.println("DataObjects have same values for their datatype properties : " + scope.getEqualityHelper().equalShallow(company, newDataObject));
                                 
            //print out xml representation
            System.out.println();
            System.out.println("Original company DataObject:");
            System.out.println(scope.getXMLHelper().save(company, SdoSampleConstants.COMPANY_NAMESPACE, "company"));
            
            System.out.println();
            System.out.println("Deserialized company DataObject:");
            System.out.println(scope.getXMLHelper().save(newDataObject, SdoSampleConstants.COMPANY_NAMESPACE, "company"));                       
            
        } catch (Exception e) {
            System.out.println("Sorry there was an error encountered " + e.toString());
            e.printStackTrace();
        }
        
        System.out.println("GoodBye");

    }
}
