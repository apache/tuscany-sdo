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

package org.apache.tuscany.samples.sdo.specExampleSection;

import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;
import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.Property;

import java.util.List;

import org.apache.tuscany.samples.sdo.SdoSampleConstants;

/**
 * Demonstrates the use of Type and Property to display and the META-DATA for and access Properties of a DataObject.
 * <br>
 * The following sample is from the <a href="http://incubator.apache.org/tuscany"
 * target="_blank"> Apache Tuscany</a> project. It was written to help users
 * understand and experiement with SDO. It is based upon example code contained
 * within, and is meant for use with, and reference to the <a
 * href="http://www.osoa.org/download/attachments/791/SDO_Specification_Java_V2.01.pdf?version=1"
 * target="_bank">SDO Specification</a>. In general this sample attempts to use the
 * code and comments contained within the specification, exceptions to this are noted
 * in comments.<br>
 * <br>
 * The following sample is based upon the 'Using Type and Property with DataObjects' example from the Examples section of the SDO specification. <br>
 * <br>
 * The Type interface provides access to the metadata for DataObjects. The methods on Type and Property provide information that describes the
 * properties of a DataObject. To obtain the Type for a DataObject use the getType() method. This example prints out the contents of a DataObject,
 * each property has it's meta-data displayed, accessed dynamically using Type and Property.<br>
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
 * These jar files can be obtained from directly from Tuscany and EMF projects or from <a
 * href="http://wiki.apache.org/ws-data/attachments/Tuscany(2f)TuscanyJava(2f)SDO_Java_Overview/attachments/SDO%20Execution%20Dependencies"
 * target="_bank">SDO Execution Dependancies </a> </LI>
 * <LI>Execute: <br>
 * java org.apache.tuscany.samples.sdo.specExampleSection.UsingTypeAndPropertyWithDataObjects</LI>
 * </UL>
 * 
 * @author Robbie Minshall
 * @see org.apache.tuscany.samples.sdo.specCodeSnippets.PrintPropertiesOfDataObject
 */

public class UsingTypeAndPropertyWithDataObjects {

    /**
     * Execute this method in order to run the sample.
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("***************************************");
        System.out.println("SDO Sample UsingTypeAndPropertyWithDataObjects");
        System.out.println("***************************************");
        System.out.println("Demonstrates the use of Type and Property to display and the META-DATA for and access Properties of a DataObject.");
        System.out.println("***************************************");

        try {
            // define Types using XSDHelper and predefined xsd file
            System.out.println("Defining company Types using XSD");
            XSDHelper.INSTANCE.define(ClassLoader.getSystemResourceAsStream(SdoSampleConstants.COMPANY_XSD), null);
            System.out.println("Type definition completed");

            // create company DataObject using XMLHelper which is an example of a XML DAS
            System.out.println("Creating company DataObject");
            DataObject company = XMLHelper.INSTANCE.load(ClassLoader.getSystemResourceAsStream(SdoSampleConstants.COMPANY_DATAOBJECT_XML))
                    .getRootObject();

            printDataObject(company, 0);
            
            System.out.println("Defining purchase order types");
            XSDHelper.INSTANCE.define(ClassLoader.getSystemResourceAsStream(SdoSampleConstants.PO_XSD_RESOURCE), null);
            System.out.println("Type definition completed");

            // create company DataObject using XMLHelper which is an example of a XML DAS
            System.out.println("Creating purchase order DataObject");
            DataObject po = XMLHelper.INSTANCE.load(ClassLoader.getSystemResourceAsStream(SdoSampleConstants.PO_XML_RESOURCE))
                    .getRootObject();

            printDataObject(po, 0);

            
            
            
            
            
            
        } catch (Exception e) {
            System.out.println("Sorry there was an error encountered " + e.toString());
            e.printStackTrace();
        }
        System.out.println("GoodBye");
    }

    /**
     * Prints out the contents of a DataObject, each property has it's meta-data displayed, accessed dynamically using Type and Property.
     * @param dataObject.  DataObject to be printed.
     * @param indent.  For formatting
     */
    public static void printDataObject(DataObject dataObject, int indent) {
        // For each Property
        List properties = dataObject.getInstanceProperties();
        for (int p = 0, size = properties.size(); p < size; p++) {
            if (dataObject.isSet(p)) {
                Property property = (Property) properties.get(p);
                if (property.isMany()) {
                    // For many-valued properties, process a list of values
                    List values = dataObject.getList(p);
                    for (int v = 0, count = values.size(); v < count; v++) {
                        printValue(values.get(v), property, indent);
                    }
                } else {
                    // For single-valued properties, print out the value
                    printValue(dataObject.get(p), property, indent);
                }
            }
        }
    }

    /**
     * Prints the value of a property
     * @param value.  Value of Property to be printed
     * @param property.  Property to be printed
     * @param indent.  For formatting
     */
    public static void printValue(Object value, Property property, int indent) {
        // Get the name of the property
        String propertyName = property.getName();
        // Construct a string for the proper indentation
        String margin = "";
        for (int i = 0; i < indent; i++)
            margin += "\t";
        if (value != null && property.isContainment()) {
            // For containment properties, display the value
            // with printDataObject
            Type type = property.getType();
            String typeName = type.getName();
            System.out.println(margin + propertyName + " (" + typeName + "):");
            printDataObject((DataObject) value, indent + 1);
        } else {
            // For non-containment properties, just print the value
            System.out.println(margin + propertyName + ": " + value);
        }
    }

}
