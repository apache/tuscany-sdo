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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.tuscany.samples.sdo.SampleBase;
import org.apache.tuscany.samples.sdo.internal.SampleInfrastructure;

import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;

/**
 * Demonstrates serializing and deserializing a DataObject to disk
 * using java serialization.
 * <p>
 * <h3>Running this Sample</h3> See <A HREF="../../../../../../index.html" 
 * target="_top">the main overview</A> for instructions on how to run this 
 * sample.
 */
public class SerializingDeserializingADataObject  extends SampleBase {
    HelperContext scope;

    public SerializingDeserializingADataObject(Integer userLevel) {
      super(userLevel, SAMPLE_LEVEL_INTERMEDIATE);
    }


    public static void main(String[] args) {

      SerializingDeserializingADataObject sample =
    	  new SerializingDeserializingADataObject(COMMENTARY_FOR_INTERMEDIATE);
      sample.run();

    }

    /*
     *  metadata for the sample documenting the areas of SDO that are explored
     */
    public static int [] CORE_FUNCTION = {
      SDOFacets.JAVA_SERIALIZATION_OF_DATA_GRAPH
    };
    /*
     *  metadata for the sample documenting the areas of SDO that are explored
     */
    public static int [] SIGNIFICANT_FUNCTION = {
      SDOFacets.TESTING_FOR_GRAPH_EQUALITY
    };
    
    public void runSample () throws Exception {

        commentary(
        		"Demonstrates serializing and deserializing a DataObject\n" +
        		"to disk using Java serialization.");

        scope = useDefaultScopeForTypes();
        loadTypesFromXMLSchemaFile(scope, SampleInfrastructure.COMPANY_XSD);
        DataObject company = getDataObjectFromFile(scope, SampleInfrastructure.COMPANY_DATAOBJECT_XML);


        commentary("We've loaded a data graph 'company' from a file\n" +
        		"using XML schema for the model and XML for the graph in the usual manner\n");
        String fileName = "temporarySerializedDataObject.xml";
        commentary("We've loaded a data graph 'company' from a file\n" +
        "using XML schema for the model and XML for the graph in the usual manner\n" +
        "Now we are going to serialize it to, and read it from a temporary file: "+fileName);
        
        commentary(
        		"The following code,  which doesn't use any SDO APIs, demonstrates the\n" +
        		"underlying SDO function of performing Java serialization on SDO objects\n\n" +
        		"FileOutputStream fos = new FileOutputStream(fileName);\n" +
        		"ObjectOutputStream out = new ObjectOutputStream(fos);\n" +
        		"out.writeObject(company);\n" +
        		"out.close();");

        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(company);
        out.close();            
        
        // read in DataObject
        commentary("Having written the data graph to the temporary file we\n" +
        		"can read it back\n\n" +
        		"FileInputStream fis = new FileInputStream(fileName);\n" +
        		"ObjectInputStream input = new ObjectInputStream(fis);\n" +
        		"DataObject newDataObject = (DataObject) input.readObject();\n" +
        		"input.close();");
        
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream input = new ObjectInputStream(fis);
        DataObject newDataObject = (DataObject) input.readObject();
        input.close();
        
        /**
         * Compare data graphs
         */
        
        commentary("We can use the SDO EqualityHelper to check that we have got\n" +
        		"back an equivalent graph to the one we had originally\n\n" +
        		"boolean equal = scope.getEqualityHelper().equal(company, newDataObject);");                       

        boolean equal = scope.getEqualityHelper().equal(company, newDataObject);
        System.out.println("DataObjects are equal: " + equal);
        
       //print out xml representation
        System.out.println();
        System.out.println("Original company DataObject:");
        System.out.println(scope.getXMLHelper().save(company, SampleInfrastructure.COMPANY_NAMESPACE, "company"));
        
        System.out.println();
        System.out.println("Deserialized company DataObject:");
        System.out.println(scope.getXMLHelper().save(newDataObject, SampleInfrastructure.COMPANY_NAMESPACE, "company"));                       
            

    }
}
