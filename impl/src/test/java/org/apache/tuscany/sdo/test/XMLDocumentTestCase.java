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

import junit.framework.TestCase;

import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XMLHelper;


public class XMLDocumentTestCase extends TestCase
{
  private final String TEST_XML_DOCUMENT = "/XMLDocumentTestCase.xml";

  // remember that NS1... and NS2... items are expected in sorted order by name
  private final String NS1_SCHEMA_NAME = "http://www.example.com/open";

  private final String NS1_SCHEMA_LOCATION = "/open.xsd";

  private final String NS2_SCHEMA_NAME = "http://www.example.com/xmlDocumentSchemaLocation";

  private final String NS2_SCHEMA_LOCATION = "/XMLDocumentSchemaLocation.xsd";

  private final String NS_SET_NAME_LOCATION = "namespace schemaLocation";

  //private final String NNS_SCHEMA_LOCATION = "http://www.example.com/XMLDocumentNoNamespaceSchemaLocation.xsd";
  private final String NNS_SCHEMA_LOCATION = "/XMLDocumentNoNamespaceSchemaLocation.xsd";

  private final String NNS_SET_LOCATION = "noNamespaceSchemaLocation";

  /**
   * This method will load an xml document consisting of a xsi:schemaLocation and 
   * xsi:noNamespaceSchemaLocation defined.  It will then use the XMLDocument API to get and
   * set the schemaLocation property.
   * 
   * @throws IOException
   */
  public void testSchemaLocation() throws IOException
  {
    // load the xml document which has xsi:noNamespaceSchemaLocation and xsi:schemaLocation defined
    XMLDocument doc = XMLHelper.INSTANCE.load(getClass().getResourceAsStream(TEST_XML_DOCUMENT));

    // get the schemaLocation
    assertEquals(NS1_SCHEMA_NAME + " " + NS1_SCHEMA_LOCATION + " " + NS2_SCHEMA_NAME + " " + NS2_SCHEMA_LOCATION, doc.getSchemaLocation());

    // set the schemaLocation to another value and test to see if the value was set
    doc.setSchemaLocation(NS_SET_NAME_LOCATION);
    assertEquals(NS_SET_NAME_LOCATION, doc.getSchemaLocation());

    // remove the schemaLocation and ensure it returns null
    doc.setSchemaLocation(null);
    assertNull(doc.getSchemaLocation());

    // ensure changes to schemaLocation have not changed noNamespaceSchemaLocation
    assertEquals(NNS_SCHEMA_LOCATION, doc.getNoNamespaceSchemaLocation());
  }

  /**
   * This method will load an xml document consisting of a xsi:schemaLocation and 
   * xsi:noNamespaceSchemaLocation defined.  It will then use the XMLDocument API to get and
   * set the noNamespaceSchemaLocation property.
   * 
   * @throws IOException
   */
  public void testNoNamespaceSchemaLocation() throws IOException
  {
    // load the xml document which has xsi:noNamespaceSchemaLocation and xsi:schemaLocation defined
    XMLDocument doc = XMLHelper.INSTANCE.load(getClass().getResourceAsStream(TEST_XML_DOCUMENT));

    // get the noNamespaceSchemaLocation
    assertEquals(NNS_SCHEMA_LOCATION, doc.getNoNamespaceSchemaLocation());

    // set the noNameSpaceSchemaLocation to another value and test to see if the value was set
    doc.setNoNamespaceSchemaLocation(NNS_SET_LOCATION);
    assertEquals(NNS_SET_LOCATION, doc.getNoNamespaceSchemaLocation());

    // remove the noNameSpaceSchemaLocation and ensure it returns null
    doc.setNoNamespaceSchemaLocation(null);
    assertNull(doc.getNoNamespaceSchemaLocation());

    // ensure changes to noNameSpaceSchemaLocation have not changed schemaLocation
    assertEquals(NS1_SCHEMA_NAME + " " + NS1_SCHEMA_LOCATION + " " + NS2_SCHEMA_NAME + " " + NS2_SCHEMA_LOCATION, doc.getSchemaLocation());
  }

  protected void setUp() throws Exception
  {
    super.setUp();
  }

}
