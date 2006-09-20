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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import commonj.sdo.DataObject;
import commonj.sdo.helper.CopyHelper;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;
import junit.framework.TestCase;

public class SimpleCopyTestCase extends TestCase {

  private final String TEST_MODEL = "/simple.xsd";
  private final String TEST_NAMESPACE = "http://www.example.com/simple";
  private final String QUOTE_XML = "/quote.xml";
  private final String SHALLOW_QUOTE_XML = "/shallowquote.xml";

  public void testSimpleCopy() throws IOException {
      XMLDocument doc = XMLHelper.INSTANCE.load(getClass().getResourceAsStream(QUOTE_XML));
      DataObject sdo = doc.getRootObject();

      DataObject copiedSdo = CopyHelper.INSTANCE.copyShallow(sdo);

      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      XMLHelper.INSTANCE.save(copiedSdo, TEST_NAMESPACE, "stockQuote", baos);
      assertTrue(TestUtil.equalXmlFiles(new ByteArrayInputStream(baos.toByteArray()), getClass().getResource(SHALLOW_QUOTE_XML)));
      assertFalse(TestUtil.equalXmlFiles(new ByteArrayInputStream(baos.toByteArray()), getClass().getResource(QUOTE_XML)));

      copiedSdo = CopyHelper.INSTANCE.copy(sdo);
      
      baos.reset();
      XMLHelper.INSTANCE.save(copiedSdo, TEST_NAMESPACE, "stockQuote", baos);
      assertFalse(TestUtil.equalXmlFiles(new ByteArrayInputStream(baos.toByteArray()), getClass().getResource(SHALLOW_QUOTE_XML)));
      assertTrue(TestUtil.equalXmlFiles(new ByteArrayInputStream(baos.toByteArray()), getClass().getResource(QUOTE_XML)));
  }

    protected void setUp() throws Exception {
        super.setUp();

        // Populate the meta data for the test (Stock Quote) model
        URL url = getClass().getResource(TEST_MODEL);
        InputStream inputStream = url.openStream();
        XSDHelper.INSTANCE.define(inputStream, url.toString());
        inputStream.close();
    }

}
