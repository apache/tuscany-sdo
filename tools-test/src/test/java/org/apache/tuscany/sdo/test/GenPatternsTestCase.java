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

import java.math.BigDecimal;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.api.SDOUtil;

import com.example.simple.SimpleFactory;
import commonj.sdo.helper.HelperContext;


public class GenPatternsTestCase extends TestCase
{
  /**
   * Simple Default Generation Pattern Static SDO 2.1 test.
   */
  public void testSimpleDefaultGeneratedClasses()
  {
    try
    {
      HelperContext scope = SDOUtil.createHelperContext();
      com.example.simple.SimpleFactory.INSTANCE.register(scope);
      
      com.example.simple.Quote quote =
        (com.example.simple.Quote)scope.getDataFactory().create(com.example.simple.Quote.class);
      
      quote.setSymbol("fbnt");
      quote.setCompanyName("FlyByNightTechnology");
      quote.setPrice(new BigDecimal("1000.0"));
      quote.setOpen1(new BigDecimal("1000.0"));
      quote.setHigh(new BigDecimal("1000.0"));
      quote.setLow(new BigDecimal("1000.0"));
      quote.setVolume(1000);
      quote.setChange1(1000);

      com.example.simple.Quote child =
        (com.example.simple.Quote)scope.getDataFactory().create(com.example.simple.Quote.class);
      quote.getQuotes().add(child);
      child.setPrice(new BigDecimal("2000.0"));

      //XMLHelper.INSTANCE.save((DataObject)quote, "http://www.example.com/simple", "stockQuote", System.out);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  /**
   * Simple Default Generation Pattern Static SDO 2.1 test.
   */
  public void testSimpleNoInterfaceGeneratedClasses()
  {
    try
    {
      HelperContext scope = SDOUtil.createHelperContext();
      com.example.noInterfaces.simple.SimpleFactory.INSTANCE.register(scope);
      
      com.example.noInterfaces.simple.Quote quote =
        (com.example.noInterfaces.simple.Quote)scope.getDataFactory().create(com.example.noInterfaces.simple.Quote.class);
      
      quote.setSymbol("fbnt");
      quote.setCompanyName("FlyByNightTechnology");
      quote.setPrice(new BigDecimal("1000.0"));
      quote.setOpen1(new BigDecimal("1000.0"));
      quote.setHigh(new BigDecimal("1000.0"));
      quote.setLow(new BigDecimal("1000.0"));
      quote.setVolume(1000);
      quote.setChange1(1000);

      com.example.noInterfaces.simple.Quote child =
        (com.example.noInterfaces.simple.Quote)scope.getDataFactory().create(com.example.noInterfaces.simple.Quote.class);
      quote.getQuotes().add(child);
      child.setPrice(new BigDecimal("2000.0"));

      //XMLHelper.INSTANCE.save((DataObject)quote, "http://www.example.com/simple", "stockQuote", System.out);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  public void testFailureOnNullScope() {
    try {
      SimpleFactory.INSTANCE.register(null);
      assertTrue("Should not be able to register in null scope", false);
    }
    catch (Exception e) {
      // caught expected exception
    }
  }
  

}
