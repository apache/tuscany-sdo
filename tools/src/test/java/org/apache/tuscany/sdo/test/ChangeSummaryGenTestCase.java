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


import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import junit.framework.TestCase;

import org.example.simple.cs.CSFactory;
import org.example.simple.cs.Quote;
import org.example.simple.cs.QuoteBase;

import commonj.sdo.ChangeSummary;
import commonj.sdo.DataObject;
import commonj.sdo.helper.XMLHelper;


public class ChangeSummaryGenTestCase extends TestCase {

    public void testMixedQuoteType() throws IOException {
// TODO T-153 reintroduce once generator special cases the change summary type property
//       QuoteBase quote = CSFactory.INSTANCE.createQuoteBase();
//        DataObject dQuote = (DataObject)quote;
//        // FBCHECK should generated method trigger creation of C/S
//        // also gen method returns Impl class -- change to interface?
//        // ChangeSummary csp = quote.getChanges();
//        ChangeSummary cs = dQuote.getChangeSummary();
//        ChangeSummary csp = quote.getChanges();
//        cs.beginLogging();
//
//        assertSame(cs, csp);
//        
//        quote.setSymbol("fbnt");
//        quote.setCompanyName("FlyByNightTechnology");
//        quote.setPrice(new BigDecimal("1000.0"));
//        quote.setOpen1(new BigDecimal("1000.0"));
//        quote.setHigh(new BigDecimal("1000.0"));
//        quote.setLow(new BigDecimal("1000.0"));
//        quote.setVolume(1000);
//        quote.setChange1(1000);
//        
//        List quotes = quote.getQuotes();
//        Quote innerQuote = CSFactory.INSTANCE.createQuote();
//        
//        quotes.add(innerQuote);
//        innerQuote.setPrice(new BigDecimal("2000.0"));
//        
//        cs.endLogging();
//        
//        XMLHelper.INSTANCE.save(dQuote, "http://www.example.com/simpleCS", "quoteBase", System.out);
//               
//        cs.undoChanges();
//        System.out.println("\nAfter Undo Changes:");
//        XMLHelper.INSTANCE.save(dQuote, "http://www.example.com/simpleCS", "quoteBase", System.out);
        
        
        
    }
    
 
    
    
}
