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

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;

/**
 * Provides methods to dynamically create the ContainemntTest Type using the XSDHelper
 * and the TypeHelper.
 */
public class ContainmentTypeUtil {  
	
    /**
     * createDynamicWithStaticResources creates the DataObject type from an existing
     * XSD.  The same XSD is used to create the Types statically using the XSD2JavaGenerator.
     * The XSD should be kept in synch with the createDynamically method in this class.
     * @throws IOException
     * @return true if 
     */
    public static boolean createDynamicWithStaticResources(HelperContext hc) {
        try {
            // Populate the meta data for the test model (ContainTest)
            URL url = ContainmentCycleTestCase.class.getResource("/containmenttest.xsd");
            InputStream inputStream = url.openStream();
            hc.getXSDHelper().define(inputStream, url.toString());
            inputStream.close();
        } catch(IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * createDynamically() creates the SDO Types using the TypeHelper.  This method should be kept in
     * synch with the XSD used for createDynamicallyWithStaticResources.  The same XSD is used for
     * the static generation of SDO Types using XSD2JavaGenerator.
     */
    public static void createDynamically(HelperContext hc) {
        TypeHelper types = hc.getTypeHelper();
        Type stringType = types.getType("commonj.sdo", "String");

        DataObject testType = hc.getDataFactory().create("commonj.sdo", "Type");
        testType.set("uri", "http://www.example.com/ContainmentTest");
        testType.set("name", "ContainmentTest");
        testType.setBoolean("sequenced", true);

        DataObject nameProperty = testType.createDataObject("property");
        nameProperty.set("name", "Name");
        nameProperty.set("type", stringType);

        DataObject containProperty = testType.createDataObject("property");
        containProperty.set("name", "Contain");
        containProperty.setBoolean("containment", true);
        containProperty.set("type", testType);

        DataObject containManyProperty = testType.createDataObject("property");
        containManyProperty.set("name", "ContainMany");
        containManyProperty.setBoolean("many", true);
        containManyProperty.setBoolean("containment", true);
        containManyProperty.set("type", testType);

        types.define(testType);
    }
}