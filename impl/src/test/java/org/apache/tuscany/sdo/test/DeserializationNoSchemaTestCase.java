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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.List;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.util.SDOUtil;

import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XMLHelper;


public class DeserializationNoSchemaTestCase extends TestCase
{
  HelperContext hc;

  TypeHelper th;

  private final String xmlStr =
      "<?xml version=\"1.0\" encoding=\"ASCII\"?> " +
      "<simple:stockQuote xmlns:simple=\"www.example.com/simple\"> " +
          "<symbol>fbnt</symbol> " +
          "<companyName>FlyByNightTechnology</companyName> " +
          "<price>1000.0</price> " +
          "<open1>1000.0</open1> " +
          "<high>1000.0</high> " +
          "<low>1000.0</low> " +
          "<volume>1000.0</volume> " +
          "<change1>1000.0</change1> " +
          "<quotes> " +
              "<price>2000.0</price> " +
          "</quotes> " +
      "</simple:stockQuote>";
  
  public void testLoadQuoteXMLDoc() throws IOException
  {
    XMLHelper xmlHelper = hc.getXMLHelper();
/*    URL url = getClass().getResource("/quote.xml");
    InputStream inputStream = url.openStream();*/
    XMLDocument doc = xmlHelper.load(xmlStr);
    DataObject root = doc.getRootObject();

    List symbols = root.getList("symbol");
    DataObject symbol = (DataObject)symbols.get(0);

    String seqValue = (String)symbol.getSequence().getValue(0);
    assertEquals(seqValue, "fbnt");

    //String symbol = root.getString("symbol");
    //System.out.println("symbol: " + symbol);
  }

  public void testAnyTypeContainer() throws Exception
  {
    HelperContext hc = SDOUtil.createHelperContext();

    URL url = getClass().getResource("/simple.xsd");
    InputStream inputStream = url.openStream();
    hc.getXSDHelper().define(inputStream, url.toString());

    XMLHelper xmlHelper = hc.getXMLHelper();
    url = getClass().getResource("/quoteInSOAP.xml");
    inputStream = url.openStream();
    XMLDocument doc = xmlHelper.load(inputStream);
    DataObject root = doc.getRootObject();
    DataObject body = (DataObject)root.getList("Body").get(0);
    DataObject stockQuote = (DataObject)body.getList("stockQuote").get(0);

    //xmlHelper.save(stockQuote, stockQuote.getType().getURI(), "stockQuote", System.out);

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = SDOUtil.createObjectOutputStream(bos, hc);
    oos.writeObject(stockQuote);
    oos.close();
    bos.close();

    ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
    ObjectInputStream ois = SDOUtil.createObjectInputStream(bis, hc);
    DataObject objectCopy = (DataObject)ois.readObject();
    ois.close();
    bis.close();
    
    assertEquals(objectCopy.getString("symbol"), "fbnt");
    
    //xmlHelper.save(objectCopy, stockQuote.getType().getURI(), "stockQuote", System.out);
  }

  protected void setUp() throws Exception
  {
    super.setUp();

    hc = SDOUtil.createHelperContext();
    th = hc.getTypeHelper();
  }
}
