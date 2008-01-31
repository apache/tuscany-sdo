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

import java.util.List;

import org.apache.tuscany.samples.sdo.SampleBase;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.helper.HelperContext;

/**
 * Demonstrates creating a DataObject from a String of XML without an explicit model.
 * <p>
 * <h3>Running this Sample</h3> See <A HREF="../../../../../../index.html" 
 * target="_top">the main overview</A> for instructions on how to run this 
 * sample.
 */
public class CreateDataObjectFromXmlString extends SampleBase {
    HelperContext scope;


    public CreateDataObjectFromXmlString(Integer userLevel) {
      super(userLevel, SAMPLE_LEVEL_INTERMEDIATE);
    }


    /**
     * String representing a PurchaseOrder in XML format
     */
    public static final String XML_STRING = "<purchaseOrder orderDate='1999-10-20'>" + " <shipTo country='US'>" + " <name>Alice Smith</name>"
            + " <street>123 Maple Street</street>" + " <city>Mill Valley</city>" + " <state>PA</state>" + " <zip>90952</zip>" + "</shipTo>"
            + "</purchaseOrder>";


    public static void main(String[] args) {

      CreateDataObjectFromXmlString sample = new CreateDataObjectFromXmlString(COMMENTARY_FOR_NOVICE);
      sample.run();
 
    }
    
    /*
     *  metadata for the sample documenting the areas of SDO that are explored
     */
    public static int [] CORE_FUNCTION = {
      SDOFacets.USING_BUILT_IN_TYPES,
      SDOFacets.LOADING_DATA_FROM_XML
    };

    public void runSample () throws Exception {

        
        commentary("Demonstrates creating a DataObject from a String of XML,\n" +
            "based upon section titled 'Creating DataObjects from XML documents'\n"+
            "This quite unassuming sample demonstrates the maxim of 'less is more'\n"+
            "in that it might look like other samples where the XML document was loaded\n"+
            "from a file or string,  but note that we don't define any Types before loading\n"+
            "the document. Built in generic types are used to model the data graph");


        scope = createScopeForTypes();

        commentary("don't define any types! Just go ahead and load from the String\n\n"+
            "DataObject purchaseOrder = scope.getXMLHelper().load(XML_STRING).getRootObject();");
        
        DataObject purchaseOrder = scope.getXMLHelper().load(XML_STRING).getRootObject();
        
        commentary("Note that the Type of the newly created DataObject has no Properties defined for it\n"+
            "but the type is said to be \"Open\",  which means that an instance of the Type may make use of other Properties\n"+
            "defined elsewhere.  The XMLHelper's load operation creates Properties on demand for the DataObject instance to use as it loads\n"+
            "the document\n\n" +
            "purchaseOrder.getType().isOpen returns true\n" +
            "purchaseOrder.getType().getProperty(\"shipTo\") returns null and\n" +
            "purchaseOrder.getInstanceProperty(\"shipTo\") returns a Property");
        
        System.out.println("DataObject's type is open?: " + purchaseOrder.getType().isOpen());
        System.out.println("Data Object's type has a property shipTo?: " + (purchaseOrder.getType().getProperty("shipTo") != null));
        System.out.println("Data Object instance has a property shipTo?: " + (purchaseOrder.getInstanceProperty("shipTo") != null));

        commentary(
            "Without a Type definition accessing a DataObject is slightly\n"+
            "different, since without a Type definition SDO does not know\n"+
            "the intended multiplicity of properties. So every Property is assumed to\n"+
            "be multi-valued, and must be accessed via a list\n\n"+
            "List shipToList = purchaseOrder.getList(\"shipTo\");\n"+
            "DataObject shipTo = (DataObject) shipToList.get(0);"); 

        List shipToList = purchaseOrder.getList("shipTo");
        DataObject shipTo = (DataObject) shipToList.get(0);
        
        

        /*
         * With no model around, this next operation is currently quite cumbersome.
         * In future specifications accessing
         * the name element will be simplier and the user could simply execute:
         * List nameList = shipTo.getList("name"); String actualName = (String)
         * nameList.get(0);
         * 
         * Or if name is an attribute ("<shipTo country='US' name='Alice
         * Smith'>") simply: String actualName = shipTo.getString("name");
         * 
         * There are currently more elegant means to perform this task using the xPath support
         */
        List nameList = shipTo.getList("name");
        DataObject name = (DataObject) nameList.get(0);
        // access the contents of the name DataObject
        Sequence s = name.getSequence();
        String actualName = (String) s.getValue(0);
        System.out.println("Name being shipped to: " + actualName);

    }
}
