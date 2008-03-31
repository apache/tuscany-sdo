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
import java.net.URL;
import java.util.List;
//import java.util.regex.MatchResult;
//import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.api.SDOUtil;

import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.HelperContext;

public class DupElementTestCase extends TestCase {
    HelperContext hc;

    private final String TEST_MODEL = "/dupelement.xsd";
    private final String TEST_URI = "http://www.example.com/dupelement";
    
    protected void setUp() throws Exception {
        super.setUp();
        
        URL url = getClass().getResource(TEST_MODEL);
        InputStream inputStream = url.openStream();
        
        hc = SDOUtil.createHelperContext();
        
        hc.getXSDHelper().define(inputStream, url.toString());
        
        inputStream.close();
    }


    public void test() {
        Type quoteType = hc.getTypeHelper().getType(TEST_URI, "Quote");
        
        DataObject quote = hc.getDataFactory().create(quoteType);
        quote.set("symbol", "ACME");
        quote.set("companyName", "ACME Corp.");
        
        DataObject quote2 = hc.getDataFactory().create(quoteType);
        
        List quotes = quote.getList("quotes");
        quotes.add(quote2);
        
        try {
            quote.set("quotes.0/symbol", "ACME-CHILD");
            quote.set("quotes.0/companyName", "ACME subsidiary corp.");
            quote.setInt("quotes.0/companyNameInInt", 99);
            quote.setInt("quotes.0/symbolInInt", 55);
        }
        catch (Exception e) {
            fail("Set value on the wrong properties with the same name");
        }
        assert(quote.get("quotes.0/companyName") instanceof String);
        assert(quote.get("quotes.0/symbol") instanceof String);
        assert(quote.get("quotes.0/companyNameInInt") instanceof Integer);
        assert(quote.get("quotes.0/symbolInInt") instanceof Integer);
        
        String doc = hc.getXMLHelper().save(quote, "http://www.example.com/dupelement", "stockQuote");
        //System.out.println(doc);
        assertTrue(
            Pattern.matches("[\\s\\S]*<companyName>[\\s]*ACME Corp.[\\s]*</companyName>[\\s\\S]*",
                doc));
        assertTrue(
            Pattern.matches("[\\s\\S]*<companyName>[\\s]*99[\\s]*</companyName>[\\s\\S]*",
                doc));
        assertTrue(
            Pattern.matches("[\\s\\S]*symbol[\\s]*=[\\s]*\"55\"[\\s\\S]*",
                doc));        
        assertTrue(
            Pattern.matches("[\\s\\S]*<symbol>[\\s]*ACME-CHILD[\\s]*</symbol>[\\s\\S]*",
                doc));
        
    }
}
