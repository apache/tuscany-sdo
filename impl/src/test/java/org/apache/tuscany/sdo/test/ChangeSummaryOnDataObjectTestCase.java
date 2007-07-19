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
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.api.SDOUtil;

import commonj.sdo.ChangeSummary;
import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XSDHelper;


public class ChangeSummaryOnDataObjectTestCase extends TestCase {

  
  private final String TEST_DATA = "/simplechangesummary.xml";
  HelperContext hc;
  XSDHelper xh;
  TypeHelper th;

  public void testBasicsDO() {
    Type cst = th.getType("commonj.sdo","ChangeSummaryType");
    Type strt = th.getType("commonj.sdo", "String");
    
    Type newt = SDOUtil.createType(hc, "testcases.changesummary", "simpleCS", false);
    Property strProp = SDOUtil.createProperty(newt, "strElem", strt);
    SDOUtil.createProperty(newt, "changeSummary", cst);
    
    DataObject iNewt = hc.getDataFactory().create(newt);
        
    testBasicsBody(strProp, iNewt);
}

  public void testBasicsDG() {

    Type strt = th.getType("commonj.sdo", "String");
    

    Type newt = SDOUtil.createType(hc, "testcases.changesummary", "simpleNOCS", false);
    Property strProp = SDOUtil.createProperty(newt, "strElem", strt);

    DataGraph graph = SDOUtil.createDataGraph();
    DataObject iNewt = graph.createRootObject(newt);
    
    testBasicsBody(strProp, iNewt);
}
  
  
  /**
   * @param strProp
   * @param iNewt
   */
  private void testBasicsBody(Property strProp, DataObject iNewt) {
    ChangeSummary cs = iNewt.getChangeSummary();
    cs.beginLogging();

    List co = cs.getChangedDataObjects();
    assertEquals(0, co.size());
    iNewt.set(strProp, "some text");
    assertEquals(0, co.size());
    co = cs.getChangedDataObjects();
    assertEquals(1, co.size());
    
    List oldValues = cs.getOldValues((DataObject)co.get(0));
    
    ChangeSummary.Setting ov1 = (ChangeSummary.Setting)oldValues.get(0);
    Property p = ov1.getProperty();
    assertEquals("strElem", p.getName());
    Object v = ov1.getValue();
    assertEquals(null, v);

    assertTrue(cs.isLogging());
    cs.endLogging();
    assertFalse(cs.isLogging());
    
  }



  public void testDynamicNestedDataObjectsDG() throws Exception {
    DataGraph dataGraph = SDOUtil.createDataGraph();
    DataObject quote = dataGraph.createRootObject(th.getType("http://www.example.com/simple", "Quote"));

    testDynamicNestedDOBody(quote);
    
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    SDOUtil.saveDataGraph(dataGraph, baos, null);
    // SDOUtil.saveDataGraph(dataGraph, System.out, null);
    
   assertTrue(TestUtil.equalXmlFiles(new ByteArrayInputStream(baos.toByteArray()), getClass().getResource(TEST_DATA)));

   
    assertEquals(1, quote.getList("quotes").size());
    assertEquals("fbnt", quote.getString("symbol"));
    dataGraph.getChangeSummary().undoChanges();
    // SDOUtil.saveDataGraph(dataGraph, System.out, null);
    assertEquals(0, quote.getList("quotes").size());
    assertNull(quote.getString("symbol"));
    

  }
  
  public void testDynamicNestedDataObjectsDO() throws Exception {
    Type quoteType = th.getType("http://www.example.com/simpleCS", "RootQuote");
    DataObject quote = hc.getDataFactory().create(quoteType);

    testDynamicNestedDOBody(quote);   
    //hc.getXMLHelper().save(quote, "http://www.example.com/simpleCS", "stockQuote", System.out);
    assertEquals(1, quote.getList("quotes").size());
    assertEquals("fbnt", quote.getString("symbol"));

    quote.getChangeSummary().undoChanges();
    
    assertEquals(0, quote.getList("quotes").size());
    assertNull(quote.getString("symbol"));

    

  }
  
  /**
   * @param quote
   */
  private void testDynamicNestedDOBody(DataObject quote) {
    // Begin logging changes
    //
    ChangeSummary changeSummary = quote.getChangeSummary();
    assertNotNull(changeSummary);
    assertFalse(changeSummary.isLogging());
    changeSummary.beginLogging();
    

    // Modify the data graph in various fun and interesting ways
    //
    quote.setString("symbol", "fbnt");
    quote.setString("companyName", "FlyByNightTechnology");
    quote.setBigDecimal("price", new BigDecimal("1000.0"));
    quote.setBigDecimal("open1", new BigDecimal("1000.0"));
    quote.setBigDecimal("high", new BigDecimal("1000.0"));
    quote.setBigDecimal("low", new BigDecimal("1000.0"));
    quote.setDouble("volume", 1000);
    quote.setDouble("change1", 1000);

    DataObject child = quote.createDataObject("quotes");
    child.setBigDecimal("price", new BigDecimal("2000.0"));

    changeSummary.endLogging();
    assertEquals(2, changeSummary.getChangedDataObjects().size());  // 2 DataObjects
    assertTrue(changeSummary.getChangedDataObjects().contains(quote));
    assertTrue(changeSummary.getChangedDataObjects().contains(child));
    assertFalse(changeSummary.isCreated(quote));
    assertTrue(changeSummary.isCreated(child));
    
    ChangeSummary.Setting ov = changeSummary.getOldValue(quote, quote.getType().getProperty("symbol"));
    assertNull(ov.getValue());
    

  }

  protected void setUp() throws Exception {
    super.setUp();

//    uncomment these lines for sending aspect trace to a file
//    tracing.lib.TraceMyClasses tmc = (TraceMyClasses)Aspects.aspectOf(TraceMyClasses.class);
//    tmc.initStream(new PrintStream("c:\\temp\\trace.log"));

    // Populate the meta data for the test (Stock Quote) model
    URL url = getClass().getResource("/simple.xsd");
    InputStream inputStream = url.openStream();
    hc = SDOUtil.createHelperContext();
    th = hc.getTypeHelper();
    xh = hc.getXSDHelper();
    xh.define(inputStream, url.toString());
    inputStream.close();

    URL url2 = getClass().getResource("/simpleWithChangeSummary.xsd");
    InputStream inputStream2 = url2.openStream();
    xh.define(inputStream2, url2.toString());
    inputStream.close();
    
    
  
}

}
