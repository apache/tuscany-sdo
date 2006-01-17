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
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;


public class OpenTypeTest
{
  static final String QUOTE_MODEL = "src/test/resources/open.xsd";
  static final String QUOTE_NAMESPACE = "http://www.example.com/open";

  /**
   * Open content SDO 2 test.
   */
  public static void main(String[] args)
  {
    try
    {
      File xsdFile = new File(QUOTE_MODEL).getAbsoluteFile();
      InputStream inputStream = new FileInputStream(xsdFile);
      XSDHelper.INSTANCE.define(inputStream, xsdFile.toURI().toString());

      Type quoteType = TypeHelper.INSTANCE.getType(QUOTE_NAMESPACE, "OpenQuote");
      DataObject quote = DataFactory.INSTANCE.create(quoteType);
      
      System.out.println("quote type isOpen: " + quoteType.isOpen());
      System.out.println("quote type isSequenced: " + quoteType.isSequenced());

      quote.setString("symbol", "s1");

      System.out.println("Before instance properties: " + quote.getInstanceProperties().size());
      for (Iterator iter = quote.getInstanceProperties().iterator(); iter.hasNext(); )
      {
        Property property = (Property)iter.next();
        System.out.println("  " + property.getName());
      }
      
      Property companyProperty = XSDHelper.INSTANCE.getGlobalProperty(QUOTE_NAMESPACE, "company", true);
      DataObject company = quote.createDataObject(companyProperty);
      company.setString("name", "FlyByNightTechnology");

      Property priceProperty = XSDHelper.INSTANCE.getGlobalProperty(QUOTE_NAMESPACE, "price", true);
      quote.getList(priceProperty).add(new BigDecimal("1000.0"));
      
      System.out.println("After instance properties: " + quote.getInstanceProperties().size());
      for (Iterator iter = quote.getInstanceProperties().iterator(); iter.hasNext(); )
      {
        Property property = (Property)iter.next();
        System.out.println("  " + property.getName());
      }
      
      XMLHelper.INSTANCE.save(quote, QUOTE_NAMESPACE, "openStockQuote", System.out);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
