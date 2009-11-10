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

import java.io.InputStream;
import java.math.BigDecimal;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.api.SDOUtil;

import com.example.simple.Quote;
import com.example.simple.SimpleFactory;

import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.impl.HelperProvider;


public class SimpleStaticTestCase extends TestCase
{
  
  HelperContext scope;
  /**
   * Simple Static SDO 2 test.
   */
  public void testSimpleStatic()
  {
    try
    {
      Quote quote = SimpleFactory.INSTANCE.createQuote();
      
      quote.setSymbol("fbnt");
      quote.setCompanyName("FlyByNightTechnology");
      quote.setPrice(new BigDecimal("1000.0"));
      quote.setOpen1(new BigDecimal("1000.0"));
      quote.setHigh(new BigDecimal("1000.0"));
      quote.setLow(new BigDecimal("1000.0"));
      quote.setVolume(1000);
      quote.setChange1(1000);

      //Quote child = (Quote)((DataObject)quote).createDataObject(8);
      Quote child = SimpleFactory.INSTANCE.createQuote();
      quote.getQuotes().add(child);
      child.setPrice(new BigDecimal("2000.0"));

      // scope.getXMLHelper().save((DataObject)quote, "http://www.example.com/simple", "stockQuote", System.out);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  public void testSimpleStaticViaDomSource() throws Exception {
    // created for TUSCANY-2080

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);

    DocumentBuilder builder = factory.newDocumentBuilder();

    java.net.URL url = getClass().getResource("/stockquote.xml");
    InputStream inputStream = url.openStream();
    org.w3c.dom.Document dom = builder.parse(inputStream);

    // Now load from dom to object
    DOMSource source = new DOMSource(dom);

    XMLDocument xml = scope.getXMLHelper().load(source, null, null);
    assertTrue("Root element is not an instance of the generated class", xml
        .getRootObject() instanceof Quote);

  }

  protected void setUp() throws Exception {
    scope = SDOUtil.createHelperContext();
    SimpleFactory.INSTANCE.register(scope);
    
    super.setUp();
  }
  
  protected void tearDown() throws Exception {
  	super.tearDown();
  }

  
}
