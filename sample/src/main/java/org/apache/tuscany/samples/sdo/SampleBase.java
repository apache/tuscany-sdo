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

import java.io.InputStream;

import org.apache.tuscany.sdo.api.SDOUtil;

import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XSDHelper;
import commonj.sdo.impl.HelperProvider;

public class SampleBase extends SampleInfrastructure {

  protected HelperContext scope;

  public SampleBase()
  {
    super(NOVICE);
  }
  
  public SampleBase(int userLevel) {
    super(userLevel);

  }
  

  protected HelperContext createScopeForTypes() {
    commentary(
        NOVICE,
        "All MetaData for SDO types can be viewed as being held in an instance of HelperContext\n" +
        "The Helper Context instance provides access to a collection of other helpers\n" +
        "that you will see exercised in the SDO samples\n" +
        "All the Helpers related to a given helper context instance know about the same set of types\n\n" +
        "The SDO specification doesn't currently state how an SDO implementation should create a HelperContext\n" +
        "So we use a Tuscany specific API to do this ...\n\n" +
        "HelperContext scope = SDOUtil.createHelperContext();",
        
        "Setting a new HelperContext scope for types for the next sample run"
    );
        
    HelperContext scope = SDOUtil.createHelperContext();
    return scope;
  }
  
  protected HelperContext useDefaultScopeForTypes() {
    commentary(
        NOVICE,
        "All MetaData for SDO types can be viewed as being held in an instance of HelperContext\n" +
        "The Helper Context instance provides access to a collection of other helpers\n" +
        "that you will see exercised in the SDO samples\n" +
        "All the Helpers related to a given helper context instance know about the same set of types\n\n" +
        "For most cases it's best to take control of the type scope by creating a new HelperContext,\n" +
        "but a default helper context is provided and can be accessed using ...\n\n" +
        "HelperContext scope = HelperProvider.getDefaultContext();\n\n" +
        "A case in point where the default scope must be used is when using some of the DataGraph APIs\n" +
        "which don't all support the type scoping extensions which were introduced in the SDO 2.1 specification",
        
        "Retrieving the default HelperContext scope for types for the next sample run"
    );
        
    HelperContext scope = HelperProvider.getDefaultContext();
    return scope;
  }
  
  
  protected void loadXMLSchemaFromFile(String fileName) {
    commentary(NOVICE,
        "If you want to create types dynamically by loading an XML schema you\n" +
        "use an instance of XSDHelper. You get that helper from a HelperContext.\n" +
        "After successful loading of a schema, the new types are available to every\n" +
        "other helper belonging to the HelperContext instance\n\n" +
        "XSDHelper xsdHelper = scope.getXSDHelper();",
        
        "Using an XSDHelper again to create types from an XML schema file"
        );
    
    XSDHelper xsdHelper = scope.getXSDHelper();
    
    InputStream is = null;
    try {

        is = ClassLoader.getSystemResourceAsStream(fileName);
        xsdHelper.define(is, null);
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
  
  public DataObject loadXMLFromFile(String filename)
      throws Exception {

    DataObject result = null;
    InputStream is = null;

    try {
      is = ClassLoader
          .getSystemResourceAsStream(filename);
      XMLDocument xmlDoc = scope.getXMLHelper().load(is);
      result = xmlDoc.getRootObject();

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

}
