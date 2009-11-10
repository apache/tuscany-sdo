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

package org.apache.tuscany.samples.sdo;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.tuscany.samples.sdo.internal.SampleInfrastructure;
import org.apache.tuscany.sdo.api.SDOUtil;

import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XSDHelper;
import commonj.sdo.impl.HelperProvider;

/**
 * the base function for samples is split into two classes.  This one is intended
 * to house all the interesting SDO utility methods,  and the superclass houses
 * all the infrastructure that the SDO user isn't interested in inspecting.
 */
public abstract class SampleBase extends SampleInfrastructure {


  public SampleBase()
  {
    super(COMMENTARY_FOR_NOVICE);
  }
  

  public SampleBase(Integer commentaryLevel, Integer sampLevel) {
    super(commentaryLevel, sampLevel);
  }

  protected HelperContext createScopeForTypes() {
    commentary(
        COMMENTARY_FOR_NOVICE,
        "All MetaData for SDO types can be viewed as being scoped within an instance of HelperContext\n" +
        "The Helper Context instance provides access to a collection of other helpers\n" +
        "that you will see exercised in the SDO samples\n" +
        "All the Helpers related to a given helper context instance know about the same set of types\n\n" +
        "The SDO specification doesn't state how an SDO implementation should create a HelperContext\n" +
        "So we use a Tuscany specific API to do this ...\n\n" +
        "HelperContext scope = SDOUtil.createHelperContext();",
        
        "Creating a new HelperContext scope for types for the next sample run as we did in previous samples"
    );
        
    HelperContext scope = SDOUtil.createHelperContext();
    return scope;
  }
  
  protected HelperContext useDefaultScopeForTypes() {
    commentary(
        COMMENTARY_FOR_NOVICE,
        "All MetaData for SDO types can be viewed as being held in an instance of HelperContext\n" +
        "The Helper Context instance provides access to a collection of other helpers\n" +
        "that you will see exercised in the SDO samples\n" +
        "All the Helpers related to a given helper context instance know about the same set of types\n\n" +
        "For most cases it's best to take control of the type scope by creating a new HelperContext,\n" +
        "but a default helper context is provided and can be accessed using ...\n\n" +
        "HelperContext scope = HelperProvider.getDefaultContext();\n\n" +
        "A case in point where the default scope must be used is when using some of the DataGraph APIs\n" +
        "which don't all support the type scoping extensions which were introduced in the SDO 2.1 specification",
        
        "Retrieving the default HelperContext scope for types for the next sample run as we saw in a previous sample"
    );
        
    HelperContext scope = HelperProvider.getDefaultContext();
    return scope;
  }
  
  
  protected void loadTypesFromXMLSchemaFile(HelperContext scope, String fileName) {
    commentary(COMMENTARY_FOR_NOVICE,
        "If you want to create types dynamically by loading an XML schema you\n" +
        "use an instance of XSDHelper. You get that helper from a HelperContext.\n" +
        "After successful loading of a schema, the new types are available to every\n" +
        "other helper belonging to the HelperContext instance\n\n" +
        "XSDHelper xsdHelper = scope.getXSDHelper();\n"+
        "xsdHelper.define(inputStream, null);",
        
        "Using an XSDHelper again to create types from an XML schema file as we saw in a previous sample"
        );
    
    XSDHelper xsdHelper = scope.getXSDHelper();
    
    InputStream is = null;
    try {
    	
        URL url = getClass().getResource("/"+fileName);
        is = url.openStream();
        xsdHelper.define(is, url.toString());

     } catch (Exception e) {
        somethingUnexpectedHasHappened(e);
     } finally {
       try {
         is.close();
       } catch (Exception e) {
         somethingUnexpectedHasHappened(e);
       }
   }
  }
  
  public DataObject getDataObjectFromFile(HelperContext scope, String filename)
      throws Exception {


    XMLDocument xmlDoc = getXMLDocumentFromFile(scope, filename);
    commentary(COMMENTARY_FOR_NOVICE,
        "An XMLDocument instance provides a wrapper for the root DataObject of a data graph\n" +
        "along with other aspects of the XML nature of the document\n\n"+
        "DataObject result = xmlDoc.getRootObject();",
        
        "Getting the root object from an XMLDocument as seen in previous samples"
    );
    DataObject result = xmlDoc.getRootObject();

    return result;
  }
  
  public XMLDocument getXMLDocumentFromFile(HelperContext scope,
      String filename) throws Exception {

    XMLDocument result = null;
    InputStream is = null;

    try {
      commentary(COMMENTARY_FOR_NOVICE,
          "The XMLHelper can be used to create an SDO XMLDocument instance from a file\n\n"+
          "inputStream = ClassLoader.getSystemResourceAsStream(filename);\n"+
          "result = scope.getXMLHelper().load(is);",
      
          "Getting an XMLDocument instance from an XML file as seen in previous samples"
      );
      is = ClassLoader.getSystemResourceAsStream(filename);
      result = scope.getXMLHelper().load(is);
      
    } catch (Exception e) {
      somethingUnexpectedHasHappened(e);
    } finally {
      try {
        is.close();
      } catch (Exception e) {
        somethingUnexpectedHasHappened(e);
      }
    }

    return result;
  }
  
  protected XMLDocument getXMLDocumentFromString(HelperContext scope, String xmlDoc) throws IOException {
    XMLDocument result = null;
    InputStream is = null;


      commentary(COMMENTARY_FOR_NOVICE,
          "The XMLHelper can be used to create an SDO XMLDocument instance from an\n\n"+
          "inputStream = new ByteArrayInputStream(xmlDoc.getBytes());\n"+
          "result = scope.getXMLHelper().load(is);",
      
          "Getting an XMLDocument instance from an XML file as seen in previous samples"
      );
      
      is = new ByteArrayInputStream(xmlDoc.getBytes());
      result = scope.getXMLHelper().load(is);
      
      return result;
  }

}
