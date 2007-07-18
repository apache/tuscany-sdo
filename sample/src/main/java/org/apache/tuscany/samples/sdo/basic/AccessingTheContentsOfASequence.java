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
        commentary("We've loaded a documet from an XML file that contains mixed content.\n" +
        		"Here's how the XML looks ...\n");
        System.out.println(scope.getXMLHelper().save(letter, "letter.xsd", "letter"));
 
        
        
        System.out.println("\nThe Type for the letter DataObject is mixed: " + scope.getXSDHelper().isMixed(letter.getType()));
        
        Sequence letterSequence = letter.getSequence();

// FIXME -- sort out how this should be -- i think it is confusing
        
        System.out.println("Unstructured text:");
        for (int i = 0; i < letterSequence.size(); i++) {
            Property prop = letterSequence.getProperty(i);                                 
            if (prop == null) {
                String text = (String) letterSequence.getValue(i);
                System.out.println("\t(" + text + ")");
            }
        }
        
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
