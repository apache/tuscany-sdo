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
import org.apache.tuscany.samples.sdo.internal.SampleInfrastructure;

import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;

/**
 * Demonstrates accessing a created DataObject's properties using the SDO XPath like syntax.
 * <p>
 * <h3>Running this Sample</h3> See <A HREF="../../../../../../index.html" 
 * target="_top">the main overview</A> for instructions on how to run this 
 * sample.
 */
public class AccessDataObjectUsingValidXPath extends SampleBase {
    HelperContext scope;
  
    public AccessDataObjectUsingValidXPath(Integer userLevel) {
      super(userLevel, SampleInfrastructure.SAMPLE_LEVEL_INTERMEDIATE);
    }


    /**
     * Accesses and modifies properties of a purchase order DataObject using xPath(
     * properties are defined in the xsd
     * {@link org.apache.tuscany.samples.sdo.internal.SampleInfrastructure#PO_XSD_RESOURCE} and
     * populated by xml
     * {@link org.apache.tuscany.samples.sdo.internal.SampleInfrastructure#PO_XML_RESOURCE} )
     * 
     * @param args.
     *            No parameters required.
     */
    public static void main(String[] args) {
      AccessDataObjectUsingValidXPath sample = new AccessDataObjectUsingValidXPath(COMMENTARY_FOR_NOVICE);
      sample.run();

    }
    
    /*
     *  metadata for the sample documenting the areas of SDO that are explored
     */
    public static int [] CORE_FUNCTION = {
      SDOFacets.GET_SET_PROPERTIES_OF_DATAOBJECT_BY_XPATH
    };


    public void runSample () throws Exception {

        commentary("Demonstrates accessing a DataObject's properties using the XPath style getter/setter methods");


        HelperContext scope = createScopeForTypes();
        
        
        commentary(
            "First we create the type system using an XML Schema file and then create\n"+
            "A DataObject using an XML document for convenience");
        
        loadTypesFromXMLSchemaFile(scope, SampleInfrastructure.PO_XSD_RESOURCE);
        DataObject purchaseOrder = getDataObjectFromFile(scope, SampleInfrastructure.PO_XML_RESOURCE);



        commentary(
            "Accessing data from the purchase order using the DataObjects XPath style methods\n");
        

        System.out.println("First we use the simplest kind of path\n" +
            "purchaseOrder.getString(\"billTo/name\")\n" +
            "The purchase is to be paid for by .... " +
            purchaseOrder.getString("billTo/name"));
        
        
        System.out.println("\nThen we use indexing by integer starting from 1\n" +
            "purchaseOrder.getString(\"items/item[1]/productName\")\n" +
            "The first item in the order is a ... " +
            purchaseOrder.getString("items/item[1]/productName"));
        
       
        System.out.println("\nThe alternative style of indexing uses a . notation and starts from 0\n"+
            "purchaseOrder.getFloat(\"items/item.0/price\")\n" +
            "The price of this item is ... " +
            purchaseOrder.getFloat("items/item.0/price"));
        

        System.out.println("\nDataObjects can be looked up by supplying the value of one of the contained simple valued Properties\n"+
            "DataObject babyMonitorItem = purchaseOrder.getDataObject(\"items/item[productName=\\\"Baby Monitor\\\"]");
                
        DataObject babyMonitorItem = purchaseOrder.getDataObject("items/item[productName=\"Baby Monitor\"]");
        System.out.println("The price of the Baby Monitor is .... " +
        babyMonitorItem.getFloat("price"));
        
        
        System.out.println("\nA parent DataObject can be accessed with the .. notation\n"+
            "List onlyIfBuyingGrassSeed = purchaseOrder.getList(\"items/item[productName=GrassSeed]/../item\");");
        List onlyIfBuyingGrassSeed = purchaseOrder.getList("items/item[productName=GrassSeed]/../item");
        if(onlyIfBuyingGrassSeed != null) {
          System.out.println("The purchase order included grass seed and " + new Integer(onlyIfBuyingGrassSeed.size()-1) + " other items");
        } else {
          System.out.println("The purchase order did not include GrassSeed");
        }


    }

}
