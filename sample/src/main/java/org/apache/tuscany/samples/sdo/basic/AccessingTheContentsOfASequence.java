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

package org.apache.tuscany.samples.sdo.basic;


import org.apache.tuscany.samples.sdo.SampleBase;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.helper.HelperContext;

/**
 * Demonstrates accessing the sequence from a DataObject containing mixed content.
 * <p>
 * <h3>Running this Sample</h3> See <A HREF="../../../../../../index.html" 
 * target="_top">the main overview</A> for instructions on how to run this 
 * sample.
 */

public class AccessingTheContentsOfASequence  extends SampleBase {

    HelperContext scope;

    public AccessingTheContentsOfASequence(Integer userLevel) {
      super(userLevel, SAMPLE_LEVEL_BASIC);
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

      AccessingTheContentsOfASequence sample =
        new AccessingTheContentsOfASequence(COMMENTARY_FOR_NOVICE);

      sample.run();

    }
    
    /*
     *  metadata for the sample documenting the areas of SDO that are explored
     */
    public static int [] CORE_FUNCTION = {
      SDOFacets.ACCESSING_VALUES_IN_A_SEQUENCE
    };

    public void runSample () throws Exception {
 
        commentary("Demonstrates accessing the sequence from a DataObject containing mixed content.");

        scope = createScopeForTypes();
        loadTypesFromXMLSchemaFile(scope, LETTER_XSD);
        DataObject letter = getDataObjectFromFile(scope, LETTER_XML);

        // print letter sequence
        commentary("We've loaded a document from an XML file that contains mixed content.\n" +
        		"Here's how the XML looks ...\n");
        System.out.println(scope.getXMLHelper().save(letter, "letter.xsd", "letter"));
 
        commentary("We can iterate over the sequence,  getting the Property / Value pairs\n" +
        		"using the Sequence.getProperty(int) and Sequence.getValue(int) methods.\n" +
        		"The model for this document is \"mixed\", i.e.\n" +
        		"letter.getType().isMixed() returns \"true\".\n" +
        		"Let's take a look at the Properties in this sequence.");
        
        Sequence letterSequence = letter.getSequence();

        for (int i = 0; i < letterSequence.size(); i++) {
            Property prop = letterSequence.getProperty(i);                                 
            if (prop == null) {
                String text = (String) letterSequence.getValue(i);
                System.out.println("Unstructured text (" + text + ")");
            } else {
                System.out.println("Property: " + prop.getName() + " Value : " + letterSequence.getValue(i));
            }
        }
        
        commentary("The values of the modeled Properties are still accessible through the DataObject\n" +
        		"getter and setter methods,  but only through the Sequence API can we get to the unstructured\n" +
        		"text and see the ordering of the instance document");

    }
}
