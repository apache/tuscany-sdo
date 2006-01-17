/**
 *
 *  Copyright 2005 The Apache Software Foundation or its licensors, as applicable.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.tuscany.sdo.test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;

import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;


public class SimpleDynamicTest
{
  static final String QUOTE_MODEL = "src/test/resources/simple.xsd";
  static final String QUOTE_NAMESPACE = "http://www.example.com/simple";
  static final String QUOTE_INSTANCE = "src/test/resources/quote.xml";

  /**
   * Simple Dynamic SDO 2 test.
   */
  public static void main(String[] args)
  {
    try
    {
      File xsdFile = new File(QUOTE_MODEL).getAbsoluteFile();
      InputStream inputStream = new FileInputStream(xsdFile);
      XSDHelper.INSTANCE.define(inputStream, xsdFile.toURI().toString());

      Type quoteType = TypeHelper.INSTANCE.getType(QUOTE_NAMESPACE, "Quote");
      DataObject quote = DataFactory.INSTANCE.create(quoteType);

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

      XMLHelper.INSTANCE.save(quote, QUOTE_NAMESPACE, "stockQuote", new FileOutputStream(QUOTE_INSTANCE));
      XMLDocument doc = XMLHelper.INSTANCE.load(new FileInputStream(QUOTE_INSTANCE));
      
      System.out.println("Root element URI: " + doc.getRootElementURI());
      System.out.println("Root element name: " + doc.getRootElementName());
      System.out.println("Root object type: " + doc.getRootObject().getType().getName());
      XMLHelper.INSTANCE.save(doc, System.out, null);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
