/**
 *
 *  Copyright 2005 The Apache Software Foundation or its licensors, as applicable.
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
package org.apache.tuscany.sdo.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.helper.TypeHelperImpl;
import org.apache.tuscany.sdo.util.SDOUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;

import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.TypeHelper;

public class SerializeTypesTestCase extends TestCase {

    public void testSerializeTypesRoundTrip() throws Exception {
        TypeHelper types = SDOUtil.createTypeHelper();
        DataFactory factory = SDOUtil.createDataFactory(types);

        Type intType = types.getType("commonj.sdo", "Int");
        Type stringType = types.getType("commonj.sdo", "String");

        // create a new Type for Addresses
        DataObject addressType = factory.create("commonj.sdo", "Type");
        addressType.set("uri", "http://example.com/address");
        addressType.set("name", "Address");

        // create a address street property
        DataObject addrStProperty = addressType.createDataObject("property");
        addrStProperty.set("name", "addrSt");
        addrStProperty.set("type", stringType);

        // create a new Type for Customers
        DataObject customerType = factory.create("commonj.sdo", "Type");
        customerType.set("uri", "http://example.com/customer");
        customerType.set("name", "Customer");

        // create a customer number property
        DataObject custNumProperty = customerType.createDataObject("property");
        custNumProperty.set("name", "custNum");
        custNumProperty.set("type", intType);

        // create a first name property
        DataObject firstNameProperty = customerType.createDataObject("property");
        firstNameProperty.set("name", "firstName");
        firstNameProperty.set("type", stringType);

        // create a last name property
        DataObject lastNameProperty = customerType.createDataObject("property");
        lastNameProperty.set("name", "lastName");
        lastNameProperty.set("type", stringType);

        // create an address property
        DataObject addressProperty = customerType.createDataObject("property");
        addressProperty.set("name", "address");
        addressProperty.set("type", addressType);
        addressProperty.setBoolean("containment", true);

        // now define the Address and Customer type so that addresses and customers can be made
        List types2define = new ArrayList();
        types2define.add(addressType);
        types2define.add(customerType);
        List typesDefined = types.define(types2define);

        // Create an empty data graph and add a root object, an instance of customerType
        //

        DataGraph dataGraph = SDOUtil.createDataGraph();
        Type customerTypeDefined = (Type) typesDefined.get(1);
        DataObject customer1 = dataGraph.createRootObject(customerTypeDefined);

        customer1.setInt("custNum", 1);
        customer1.set("firstName", "John");
        customer1.set("lastName", "Adams");
        DataObject address = customer1.createDataObject("address");
        address.set("addrSt", "577 Airport Blvd");

        SDOUtil.registerDataGraphTypes(dataGraph, typesDefined);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        SDOUtil.saveDataGraph(dataGraph, baos, null);
        //SDOUtil.saveDataGraph(dataGraph, System.out, null);

        TypeHelper deserializingTypeHelper = SDOUtil.createTypeHelper();
        
        // The following is a kludge to force deserialization of metadata into a different TypeHelper (scope)
        // TBD figure out a proper non-EMF way to do this.
        Map options = new HashMap();
        Object differentFromSerializing = ((TypeHelperImpl) deserializingTypeHelper).getExtendedMetaData();
        options.put(XMLResource.OPTION_EXTENDED_META_DATA, differentFromSerializing);

        byte[] serialized = baos.toByteArray();
        ByteArrayInputStream bais = new ByteArrayInputStream(serialized);
        DataGraph loadedDataGraph = SDOUtil.loadDataGraph(bais, options);

        DataObject loadedRootObject = loadedDataGraph.getRootObject();
        assertNotSame(loadedRootObject.getType(), customer1.getType());

        // EqualityHelper requires same Type
        assertEquals(loadedRootObject.getInt("custNum"), customer1.getInt("custNum"));
        assertEquals(loadedRootObject.get("firstName"), customer1.get("firstName"));
        assertEquals(loadedRootObject.get("lastName"), customer1.get("lastName"));
        DataObject loadedAddress = loadedRootObject.getDataObject("address");
        assertEquals(loadedAddress.get("addrSt"), address.get("addrSt"));
    }
}