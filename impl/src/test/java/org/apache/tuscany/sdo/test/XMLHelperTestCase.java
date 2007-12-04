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
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.api.SDOHelper;
import org.apache.tuscany.sdo.api.SDOUtil;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;
import commonj.sdo.impl.HelperProvider;

public class XMLHelperTestCase extends TestCase {

  HelperContext hc;
  private XSDHelper xsdHelper;
  XMLHelper xmlh;
  static final String INDENT = "    ", MARGIN = "  ", LINE_BREAK = "\n\n";

  void define(String model) throws Exception {
    // Populate the meta data for the test model
    URL url = getClass().getResource(model);
    xsdHelper.define(url.openStream(), url.toString());
  }
  
  protected void setUp() throws Exception {
    super.setUp();
    hc = SDOUtil.createHelperContext();
    xsdHelper = hc.getXSDHelper();
    xmlh = hc.getXMLHelper();

    // Populate the meta data for the test (Stock Quote) model
    define("/simpleWithChangeSummary.xsd");

    define("/SequenceChangeSummary.xsd");
    
    define("/simple.xsd");
  }

  protected void tearDown() throws Exception {
    super.tearDown();
  }

  public void testLoadInputStreamStringObject() throws IOException {
 
  }

  protected final void format(String xml,String formatted) throws IOException {
    XMLDocument doc = xmlh.load(getClass().getResource(xml).openStream());
    Map options = new HashMap();

    options.put(SDOHelper.XMLOptions.XML_SAVE_INDENT, INDENT);
    options.put(SDOHelper.XMLOptions.XML_SAVE_MARGIN, MARGIN);
    options.put(SDOHelper.XMLOptions.XML_SAVE_LINE_BREAK, LINE_BREAK);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    
    // doc declares NameSpaces at root
    xmlh.save(xmlh.createDocument(doc.getRootObject(), doc.getRootElementURI(), doc.getRootElementName()), baos, options);
    //xmlh.save(xmlh.createDocument(doc.getRootObject(), doc.getRootElementURI(), doc.getRootElementName()), System.out, options);
    
    assertEquals(formatted, baos.toString());
  }

  public void notestSaveXMLDocumentOutputStreamObject() throws IOException {
    format("/simpleWithChangeSummary.xml",
MARGIN+  "<?xml version=\"1.0\" encoding=\"ASCII\"?>"  +LINE_BREAK+
MARGIN+  "<cs:stockQuote xmlns:cs=\"http://www.example.com/simpleCS\">"  +LINE_BREAK+
MARGIN+INDENT+  "<symbol>FBNT</symbol>"  +LINE_BREAK+
MARGIN+INDENT+  "<companyName>FlyByNightTechnology</companyName>"  +LINE_BREAK+
MARGIN+INDENT+  "<price>999.0</price>"  +LINE_BREAK+
MARGIN+INDENT+  "<volume>1000.0</volume>"  +LINE_BREAK+
MARGIN+INDENT+  "<quotes>"  +LINE_BREAK+
MARGIN+INDENT+INDENT+  "<price>1500.0</price>"  +LINE_BREAK+
MARGIN+INDENT+  "</quotes>"  +LINE_BREAK+
MARGIN+INDENT+  "<quotes>"  +LINE_BREAK+
MARGIN+INDENT+INDENT+  "<price>2500.0</price>"  +LINE_BREAK+
MARGIN+INDENT+  "</quotes>"  +LINE_BREAK+
MARGIN+INDENT+  "<quotes>"  +LINE_BREAK+
MARGIN+INDENT+INDENT+  "<price>3000.0</price>"  +LINE_BREAK+
MARGIN+INDENT+  "</quotes>"  +LINE_BREAK+
MARGIN+INDENT+  "<quotes>"  +LINE_BREAK+
MARGIN+INDENT+INDENT+  "<price>4000.0</price>"  +LINE_BREAK+
MARGIN+INDENT+  "</quotes>"  +LINE_BREAK+
MARGIN+INDENT+  "<changes create=\"#//quotes[3] #//quotes[4]\" delete=\"#//changes/stockQuote[1]/quotes[2]\" logging=\"false\" xmlns:sdo=\"commonj.sdo\">"  +LINE_BREAK+
MARGIN+INDENT+INDENT+  "<cs:stockQuote sdo:ref=\"#/stockQuote\" sdo:unset=\"volume\">"  +LINE_BREAK+
MARGIN+INDENT+INDENT+INDENT+  "<symbol>fbnt</symbol>"  +LINE_BREAK+
MARGIN+INDENT+INDENT+INDENT+  "<price>1000.0</price>"  +LINE_BREAK+
MARGIN+INDENT+INDENT+INDENT+  "<quotes sdo:ref=\"#//quotes[1]\" />"  +LINE_BREAK+
MARGIN+INDENT+INDENT+INDENT+  "<quotes><price>2000.0</price><quotes><price>2000.99</price></quotes></quotes>"  +LINE_BREAK+
MARGIN+INDENT+INDENT+INDENT+  "<quotes sdo:ref=\"#//quotes[2]\" />"  +LINE_BREAK+
MARGIN+INDENT+INDENT+  "</cs:stockQuote>"  +LINE_BREAK+
MARGIN+INDENT+  "</changes>"  +LINE_BREAK+
MARGIN+  "</cs:stockQuote>");
  }

  public void notestSaveMixedOutputStreamObject() throws IOException {
    format("/mixedChangeSummary.xml",
MARGIN+  "<?xml version=\"1.0\" encoding=\"ASCII\"?>"  +LINE_BREAK+
MARGIN+  "<cs:stockQuote xmlns:cs=\"http://www.example.com/sequenceCS\"><changes create=\"#//quotes[3] #//quotes[4]\" delete=\"#//changes/stockQuote[1]/quotes[2]\" logging=\"false\" xmlns:sdo=\"commonj.sdo\">"  +LINE_BREAK+
INDENT+  "<cs:stockQuote sdo:ref=\"#/stockQuote\">"  +LINE_BREAK+
INDENT+INDENT+  "<symbol>fbnt</symbol>"  +LINE_BREAK+
INDENT+INDENT+  "<companyName>FlyByNightTechnology</companyName>"  +LINE_BREAK+
INDENT+INDENT+  "<price>1000.0</price>"  +LINE_BREAK+
INDENT+INDENT+  "<quotes sdo:ref=\"#//quotes[1]\" />"  +LINE_BREAK+
INDENT+INDENT+  "<quotes><price>2000.0</price><quotes><price>2000.99</price></quotes></quotes>"  +LINE_BREAK+
INDENT+INDENT+  "<quotes sdo:ref=\"#//quotes[2]\" />"  +LINE_BREAK+
INDENT+  "</cs:stockQuote>"  +LINE_BREAK+
"</changes><symbol>FBNT</symbol><companyName>FlyByNightTechnology</companyName><price>999.0</price><quotes><price>1500.0</price></quotes><quotes><price>2500.0</price></quotes><volume>1000.0</volume><quotes><price>3000.0</price></quotes><quotes><price>4000.0</price></quotes></cs:stockQuote>");
  }

  public void notestOpenMixedOutputStreamObject() throws IOException {
    format("/openChangeSummary.xml",
MARGIN+  "<?xml version=\"1.0\" encoding=\"ASCII\"?>"  +LINE_BREAK+
MARGIN+  "<cs:openQuote xmlns:cs=\"http://www.example.com/sequenceCS\" xmlns:open=\"http://www.example.com/open\">"  +LINE_BREAK+
MARGIN+INDENT+  "<symbol>FBNT</symbol>"  +LINE_BREAK+
MARGIN+INDENT+  "<open:openStockQuote>"  +LINE_BREAK+
MARGIN+INDENT+INDENT+  "<symbol>1500.0</symbol>"  +LINE_BREAK+
MARGIN+INDENT+  "</open:openStockQuote>"  +LINE_BREAK+
MARGIN+INDENT+  "<open:openStockQuote>"  +LINE_BREAK+
MARGIN+INDENT+INDENT+  "<symbol>2500.0</symbol>"  +LINE_BREAK+
MARGIN+INDENT+  "</open:openStockQuote>"  +LINE_BREAK+
MARGIN+INDENT+  "<open:openStockQuote>"  +LINE_BREAK+
MARGIN+INDENT+INDENT+  "<symbol>3000.0</symbol>"  +LINE_BREAK+
MARGIN+INDENT+  "</open:openStockQuote>"  +LINE_BREAK+
MARGIN+INDENT+  "<open:openStockQuote>"  +LINE_BREAK+
MARGIN+INDENT+INDENT+  "<symbol>4000.0</symbol>"  +LINE_BREAK+
MARGIN+INDENT+  "</open:openStockQuote>"  +LINE_BREAK+
MARGIN+INDENT+  "<changes create=\"#//open:openStockQuote[3] #//open:openStockQuote[4]\" delete=\"#//changes/openQuote[1]/open:openStockQuote[2]\" logging=\"false\" xmlns:sdo=\"commonj.sdo\">"  +LINE_BREAK+
MARGIN+INDENT+INDENT+  "<cs:openQuote sdo:ref=\"#/openQuote\">"  +LINE_BREAK+
MARGIN+INDENT+INDENT+INDENT+  "<symbol>fbnt</symbol>"  +LINE_BREAK+
MARGIN+INDENT+INDENT+INDENT+  "<open:openStockQuote sdo:ref=\"#//open:openStockQuote[1]\" />"  +LINE_BREAK+
MARGIN+INDENT+INDENT+INDENT+  "<open:openStockQuote><symbol>2000.0</symbol><open:openStockQuote><symbol>2000.99</symbol></open:openStockQuote></open:openStockQuote>"  +LINE_BREAK+
MARGIN+INDENT+INDENT+INDENT+  "<open:openStockQuote sdo:ref=\"#//open:openStockQuote[2]\" />"  +LINE_BREAK+
MARGIN+INDENT+INDENT+  "</cs:openQuote>"  +LINE_BREAK+
MARGIN+INDENT+  "</changes>"  +LINE_BREAK+
MARGIN+  "</cs:openQuote>");
  }
  
  private String quoteXML =
      "<?xml version=\"1.0\" encoding=\"ASCII\"?>" +
      "<simple:stockQuote xmlns:simple=\"http://www.example.com/simple\">" +
          "<symbol>fbnt</symbol>" +
          "<companyName>FlyByNightTechnology</companyName>" +
          "<price>1000.0</price>" +
          "<open1>1000.0</open1>" +
          "<high>1000.0</high>" +
          "<low>1000.0</low>" +
          "<volume>1000.0</volume>" +
          "<change1>1000.0</change1>" +
          "<quotes>" +
              "<price>2000.0</price>" +
          "</quotes>" +
      "</simple:stockQuote>";

  public void testLoadDOMSource() throws IOException, ParserConfigurationException, SAXException
  {
      DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
      dFactory.setNamespaceAware(true);

      DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
      Document document = dBuilder.parse(new ByteArrayInputStream(quoteXML.getBytes()));
      
      DOMSource domSource = new DOMSource(document);
      
      XMLDocument xmlDocument = hc.getXMLHelper().load(domSource, null, null);
      
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      
      Map options = new HashMap();
      options.put(SDOHelper.XMLOptions.XML_SAVE_INDENT, "");
      options.put(SDOHelper.XMLOptions.XML_SAVE_MARGIN, "");
      options.put(SDOHelper.XMLOptions.XML_SAVE_LINE_BREAK, "");
      
      hc.getXMLHelper().save(xmlDocument, baos, options);
      
      boolean isEqual = TestUtil.equalXmlFiles(new ByteArrayInputStream(quoteXML.getBytes()), new ByteArrayInputStream(baos.toByteArray()));
      assertTrue(isEqual);
  }
  
  private String xsdStr =
      "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
      "<xsd:schema xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" " +
          "xmlns:simple=\"http://www.example.com/simple\" " +
          "targetNamespace=\"http://www.example.com/simple\">" +
//          "<xsd:element name=\"stockQuote\" type=\"simple:Quote\"/>" +
          "<xsd:complexType name=\"Quote\">" +
              "<xsd:sequence>" +
                  "<xsd:element name=\"symbol\" type=\"xsd:string\"/>" +
              "</xsd:sequence>" +
          "</xsd:complexType>" +
      "</xsd:schema>";
  
  /**
   * Test the scenario of serializing and deserializing an SDO with an undefined global SDO property
   * In this scenario, the target XSD namespace doesn't have any global element defined 
   *
   */
  public void testDemandCreateRootObject() {
      HelperContext hc = SDOUtil.createHelperContext();
      hc.getXSDHelper().define(xsdStr);
      DataObject quote = hc.getDataFactory().create("http://www.example.com/simple", "Quote");
      quote.set("symbol", "abc");
      
      String xmlStr = hc.getXMLHelper().save(quote, quote.getType().getURI(), "demandcreate");
      
      XMLDocument doc = hc.getXMLHelper().load(xmlStr);
      try {
          doc.getRootObject();
      }
      catch (ClassCastException e) {
          fail(e.toString());
      }
  }
  
  /**
   * This test case is similar to the testDemandCreateRootObject above. The only difference is
   * the data model was created using SDO APIs instead of XSD.
   *
   */
  public void testDemandCreateRootObject2() {
      HelperContext hc1 = SDOUtil.createHelperContext();
      Type stringType = hc1.getTypeHelper().getType("commonj.sdo", "String");
      
      DataObject quoteTypeDef = hc1.getDataFactory().create("commonj.sdo", "Type");
      quoteTypeDef.set("uri", "http://www.example.com/simple");
      quoteTypeDef.set("name", "Quote");
      
      DataObject symbolPropDef = quoteTypeDef.createDataObject("property");
      symbolPropDef.set("name", "symbol");
      symbolPropDef.set("type", stringType);
      
      hc1.getTypeHelper().define(quoteTypeDef);
      
      DataObject quote = hc1.getDataFactory().create("http://www.example.com/simple", "Quote");
      quote.set("symbol", "abc");
      
      String xmlStr = hc1.getXMLHelper().save(quote, quote.getType().getURI(), "demandcreate");

      HelperContext hc2 = SDOUtil.createHelperContext();
      hc2.getXSDHelper().define(xsdStr);
      
      XMLDocument doc = hc2.getXMLHelper().load(xmlStr);
      try {
          doc.getRootObject();
      }
      catch (ClassCastException e) {
          fail(e.toString());
      }
  }
  
  public void testEncoding() throws IOException 
  {
      TypeHelper types = hc.getTypeHelper();
      Type stringType = types.getType("commonj.sdo", "String");
      DataObject customerType = hc.getDataFactory().create("commonj.sdo", "Type");
      customerType.set("uri", "http://example.com/simple");
      customerType.set("name", "Simple");
      DataObject multiProperty = customerType.createDataObject("property");
      multiProperty.set("name", "name");
      multiProperty.set("type", stringType);
      types.define(customerType);
      DataObject obj = hc.getDataFactory().create("http://example.com/simple", 
      "Simple");
      obj.set("name", "John Smith");
      
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      hc.getXMLHelper().save(obj, "http://www.example.com/company" , "company", baos);
      ByteArrayInputStream bais = new ByteArrayInputStream(baos.toString().getBytes());
      XMLDocument xmlDoc = hc.getXMLHelper().load(bais);
      if( !"UTF-8".equals(xmlDoc.getEncoding()) )
      {
          fail("Encoding ('" + xmlDoc.getEncoding() +"' is not correct.  UTF-8 is the expected encoding.");
      }
   }
}
