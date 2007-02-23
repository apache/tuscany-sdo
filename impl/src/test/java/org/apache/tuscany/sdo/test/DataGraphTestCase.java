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
package org.apache.tuscany.sdo.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.util.SDOUtil;

import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.XSDHelper;

/**
  * Tests methods of DataGraph except for change summary which is tested elsewhere.
  */
public class DataGraphTestCase extends TestCase {
    private final String SIMPLE_MODEL = "/simple.xsd";
    private final String ANYTYPE_MODEL = "/anytype.xsd";

    /**
     * createRootObject(type) test with good parms.
     */
    public void testCreateRootObjectType() throws IOException {
        // Create an empty data graph and add a root object, an instance of type Quote
      
        DataGraph dataGraph = SDOUtil.createDataGraph();
        Type quoteType = dataGraph.getType("http://www.example.com/simple", "Quote");
        DataObject quote = dataGraph.createRootObject(quoteType);

        assertNotNull(quote);
    }
    
    /**
     * createRootObject(type) test with bad parm.
     */
    public void testCreateRootObjectTypeBad() throws IOException {
        // Create an empty data graph and pass bad parms to createRootObject
      
        DataGraph dataGraph = SDOUtil.createDataGraph();
        boolean success = false;
        try {
            dataGraph.createRootObject(null);
        } catch(NullPointerException npe) {
            fail("createRootObject with null type threw NullPointerException");
        } catch(Exception e) {
            success = true;
        }
        if (!success) {
            fail("createRootObject with null type parameter did not throw an exception");
        }
    }
    
    /**
     * createRootObject(type) test with good parms but too often to ensure
     * that IllegalStateException is thrown
     */
    public void testCreateRootObjectTypeIllegalState() throws IOException {
        // Create an empty data graph and add a root object, then add another root object
      
        DataGraph dataGraph = SDOUtil.createDataGraph();
        DataObject quote = dataGraph.createRootObject("http://www.example.com/anytype", "Person");
        
        assertNotNull(quote);        

        Type quoteType = dataGraph.getType("http://www.example.com/simple", "Quote");
        assertNotNull(quoteType);
        boolean success = false;
        try {
            dataGraph.createRootObject(quoteType);            
        } catch(IllegalStateException ise) {
            success = true;
        } catch(Exception e) {
            fail("createRootObject called when a root was already created and an exception other than IllegalStateException was thrown: "+e.getMessage());
        }
        if (!success) {
            fail("createRootObject called when a root was already created but no IllegalStateException was thrown");
        }
    }
    
    /**
     * createRootObject(type) test with good parms but too often to ensure
     * that IllegalStateException is thrown
     */
    public void testCreateRootObjectUriTypenameIllegalState() throws IOException {
        // Create an empty data graph and add a root object, then add another root object
      
        DataGraph dataGraph = SDOUtil.createDataGraph();
        DataObject quote = dataGraph.createRootObject("http://www.example.com/anytype", "Person");
        
        assertNotNull(quote);        

        boolean success = false;
        try {
            dataGraph.createRootObject("http://www.example.com/simple", "Quote");            
        } catch(IllegalStateException ise) {
            success = true;
        } catch(Exception e) {
            fail("createRootObject called when a root was already created and an exception other than IllegalStateException was thrown: "+e.getMessage());
        }
        if (!success) {
            fail("createRootObject called when a root was already created but no IllegalStateException was thrown");
        }
    }
    
    /**
     * createRootObject(uri_string, typeName_string) test with good parms.
     */
    public void testCreateRootObjectUriTypename() throws IOException {
        // Create an empty data graph and add a root object, an instance of type Quote
      
        DataGraph dataGraph = SDOUtil.createDataGraph();
        DataObject quote = dataGraph.createRootObject("http://www.example.com/simple", "Quote");

        assertNotNull(quote);
    }
    
    /**
     * createRootObject(uri_string, typeName_string) test with bad parms.
     */
    public void testCreateRootObjectUriTypenameBad1() throws IOException {
        // Create an empty data graph and pass bad parms to createRootObject
      
        DataGraph dataGraph = SDOUtil.createDataGraph();
        boolean success = false;
        try {
            dataGraph.createRootObject("http://www.example.com/mangled", "Quote");            
        } catch(NullPointerException npe) {
            fail("createRootObject with mangled URI threw NullPointerException");
        } catch(Exception e) {
            success = true;
        }
        if (!success) {
            fail("createRootObject with mangled URI did not throw an exception");
        }
    }
    
    /**
     * createRootObject(uri_string, typeName_string) test with bad parms.
     */
    public void testCreateRootObjectUriTypenameBad2() throws IOException {
        // Create an empty data graph and pass bad parms to createRootObject
      
        DataGraph dataGraph = SDOUtil.createDataGraph();
        boolean success = false;
        try {
            dataGraph.createRootObject("http://www.example.com/simple", "Mangled");            
        } catch(NullPointerException npe) {
            fail("createRootObject with mangled type name threw NullPointerException");
        } catch(Exception e) {
            success = true;
        }
        if (!success) {
            fail("createRootObject with mangled type name did not throw an exception");
        }
    }
    
    /**
     * getType(uri_string, typeName_string) test with good parms.
     */
    public void testGetType() throws IOException {
        // Create an empty data graph and get a type, a Quote type
      
        DataGraph dataGraph = SDOUtil.createDataGraph();
        Type quoteType = dataGraph.getType("http://www.example.com/simple", "Quote");

        assertNotNull(quoteType);
    }
    
    /**
     * getType(uri_string, typeName_string) test with bad URI parm.
     */
    public void testGetTypeBad1() throws IOException {
        // Create an empty data graph and pass bad parms to getType
      
        DataGraph dataGraph = SDOUtil.createDataGraph();
        Type quoteType = null;
        try {
            quoteType = dataGraph.getType("http://www.example.com/mangled", "Quote");            
        } catch(Exception e) {
            fail("getType with mangled URI threw an exception: "+e.getMessage());
        }
        assertNull(quoteType);
    }
    
    /**
     * getType(uri_string, typeName_string) test with bad type name parm.
     */
    public void testGetTypeBad2() throws IOException {
        // Create an empty data graph and pass bad parms to getType
      
        DataGraph dataGraph = SDOUtil.createDataGraph();
        Type quoteType = null;
        try {
            quoteType = dataGraph.getType("http://www.example.com/simple", "Mangled"); 
        } catch(Exception e) {
            fail("getType with mangled type name threw an exception: "+e.getMessage());
        }
        assertNull(quoteType);
    }

    /**
     * getType(uri_string, typeName_string) test with null URI parm.
     */
    public void testGetTypeBad3() throws IOException {
        // Create an empty data graph and pass bad parms to getType
      
        DataGraph dataGraph = SDOUtil.createDataGraph();
        Type quoteType = null;
        try {
            quoteType = dataGraph.getType(null, "Quote");            
        } catch(Exception e) {
            fail("getType with null URI threw an exception: "+e.getMessage());
        }
        assertNull(quoteType);
    }
    
    /**
     * getType(uri_string, typeName_string) test with null type name parm.
     */
    public void testGetTypeBad4() throws IOException {
        // Create an empty data graph and pass bad parms to getType
      
        DataGraph dataGraph = SDOUtil.createDataGraph();
        Type quoteType = null;
        try {
            quoteType = dataGraph.getType("http://www.example.com/simple", null); 
        } catch(Exception e) {
            fail("getType with null type name threw an exception: "+e.getMessage());
        }
        assertNull(quoteType);
    }
    
    protected void setUp() throws Exception {
        super.setUp();

        // Populate the meta data for the Quote type
        URL url = getClass().getResource(SIMPLE_MODEL);
        InputStream inputStream = url.openStream();
        XSDHelper.INSTANCE.define(inputStream, url.toString());
        inputStream.close();
        
        // Populate the meta data for the Person type
        URL url2 = getClass().getResource(ANYTYPE_MODEL);
        InputStream inputStream2 = url2.openStream();
        XSDHelper.INSTANCE.define(inputStream2, url2.toString());
        inputStream2.close();
    }
}
