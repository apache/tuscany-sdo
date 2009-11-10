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
import java.math.BigDecimal;
import java.util.List;

import org.apache.tuscany.sdo.api.SDOUtil;

import junit.framework.TestCase;

import com.example.customer.Account;
import com.example.customer.Customer;
import com.example.customer.CustomerFactory;
import com.example.simple.cs.CSFactory;
import com.example.simple.cs.Quote;
import com.example.simple.cs.QuoteBase;
import commonj.sdo.ChangeSummary;
import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.impl.HelperProvider;


public class ChangeSummaryGenTestCase extends TestCase {

    public void testMixedQuoteType() throws IOException {
        QuoteBase quote = CSFactory.INSTANCE.createQuoteBase();
        DataObject dQuote = (DataObject)quote;

        // ChangeSummary csp = quote.getChanges();
        ChangeSummary cs = dQuote.getChangeSummary();
        ChangeSummary csp = quote.getChanges();
        cs.beginLogging();

        assertSame(cs, csp);
        
        quote.setSymbol("fbnt");
        quote.setCompanyName("FlyByNightTechnology");
        quote.setPrice(new BigDecimal("1000.0"));
        quote.setOpen1(new BigDecimal("1000.0"));
        quote.setHigh(new BigDecimal("1000.0"));
        quote.setLow(new BigDecimal("1000.0"));
        quote.setVolume(1000);
        quote.setChange1(1000);
        
        List quotes = quote.getQuotes();
        Quote innerQuote = CSFactory.INSTANCE.createQuote();
        
        quotes.add(innerQuote);
        innerQuote.setPrice(new BigDecimal("2000.0"));
        
        cs.endLogging();
       
        //XMLHelper.INSTANCE.save(dQuote, "http://www.example.com/simpleCS", "quoteBase", System.out);
               
        cs.undoChanges();
        
        //System.out.println("\nAfter Undo Changes:");
        //XMLHelper.INSTANCE.save(dQuote, "http://www.example.com/simpleCS", "quoteBase", System.out);
    }

    public void testChangeSummaryOnDatagraphWithContainmentStatic() throws Exception {
      
      HelperContext hc = HelperProvider.getDefaultContext();
      CustomerFactory.INSTANCE.register(hc);    
      
      Type customerType = hc.getTypeHelper().getType(Customer.class);   
      DataGraph dataGraph = SDOUtil.createDataGraph();
      Customer customer = (Customer) dataGraph.createRootObject(customerType);
    
      Account account = CustomerFactory.INSTANCE.createAccount();
      customer.setAccount(account);
      customer.setFirstName("John");
      customer.getAccount().setAccountNum(1234);
        
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      SDOUtil.saveDataGraph(dataGraph, outputStream, null);
      DataGraph loadDataGraph = SDOUtil.loadDataGraph(new ByteArrayInputStream(outputStream.toByteArray()), null);
      
      loadDataGraph.getChangeSummary().beginLogging();
      
      customer = (Customer) loadDataGraph.getRootObject();
      customer.getAccount().setAccountNum(987);   
      
      loadDataGraph.getChangeSummary().endLogging();
      
      List changedDataObjects = loadDataGraph.getChangeSummary().getChangedDataObjects();   
        assertEquals("in fact 1 Object was changed in the code", 1, changedDataObjects.size());     
    }
    
    public void testChangeSummaryOnDataGraphWithIntAndFloat() throws Exception {
      
      HelperContext hc = HelperProvider.getDefaultContext();
      CustomerFactory factory = CustomerFactory.INSTANCE;
      factory.register(hc);
      Customer customer = factory.createCustomer();
      Account account = factory.createAccount();
      customer.setAccount(account);
      DataObject customerDO = (DataObject) customer; 
      DataGraph dg = SDOUtil.createDataGraph();
      SDOUtil.setRootObject(dg, customerDO);
      dg.getChangeSummary().beginLogging();
      dg.getRootObject().getDataObject(0).delete();
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      SDOUtil.saveDataGraph(dg, baos, null);
    }
    
}
