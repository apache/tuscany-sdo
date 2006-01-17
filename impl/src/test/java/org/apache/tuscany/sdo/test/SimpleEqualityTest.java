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

import commonj.sdo.DataObject;
import commonj.sdo.helper.EqualityHelper;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;

public class SimpleEqualityTest
{
  static final String QUOTE_MODEL = "src/test/resources/simple.xsd";
  static final String QUOTE_NAMESPACE = "http://www.example.com/simple";
  static final String QUOTE_INSTANCE = "src/test/resources/quote.xml";
  static final String SHALLOWQUOTE_INSTANCE = "src/test/resources/shallowquote.xml";

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    try
    {
      File xsdFile = new File(QUOTE_MODEL).getAbsoluteFile();
      InputStream inputStream = new FileInputStream(xsdFile);
      XSDHelper.INSTANCE.define(inputStream, xsdFile.toURI().toString());
      
      XMLDocument doc = XMLHelper.INSTANCE.load(new FileInputStream(QUOTE_INSTANCE));
      DataObject sdo = doc.getRootObject();
      
      System.out.println("Source DataObject:");
      XMLHelper.INSTANCE.save(sdo, QUOTE_NAMESPACE, "stockQuote", System.out);

      System.out.println();
      System.out.println("******************************");
      
      doc = XMLHelper.INSTANCE.load(new FileInputStream(SHALLOWQUOTE_INSTANCE));
      DataObject shallowSdo = doc.getRootObject();
      
      System.out.println("Target DataObject:");
      XMLHelper.INSTANCE.save(shallowSdo, QUOTE_NAMESPACE, "stockQuote", System.out);
      
      System.out.println();
      System.out.println("******************************");
      
      boolean result = EqualityHelper.INSTANCE.equalShallow(sdo, shallowSdo);
      System.out.println("Shallow comparison result: " + result);
      
      result = EqualityHelper.INSTANCE.equal(sdo, shallowSdo);
      System.out.println("Deep comparison result: " + result);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

  }

}
