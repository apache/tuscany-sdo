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
import java.net.URL;
import java.util.List;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.util.SDOUtil;

import commonj.sdo.ChangeSummary;
import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;

public class ChangeSummaryPropertyTestCase extends TestCase {
    private final String TEST_MODEL = "/simpleWithChangeSummary.xsd";
    private final String TEST_NAMESPACE = "http://www.example.com/simpleCS";

    private final String TEST_DATA_BEFORE_UNDO = "/simpleWithChangeSummary.xml";
    private final String TEST_DATA_AFTER_UNDO = "/simpleWithChangeSummaryUndone.xml";
    
    HelperContext hc;
    DataFactory dataFactory;
    XMLHelper xmlHelper;
    
    void verify(ChangeSummary cs, DataObject quote, String nameSpace, String element, String beforeUndo, String afterUndo) throws IOException {
        // Stop logging changes and serialize the resulting data graph
        //
        cs.endLogging();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        xmlHelper.save(quote, nameSpace, element, baos);
        //xmlHelper.save(quote, nameSpace, element, System.out);

        byte[] bytes = baos.toByteArray();
        URL url = getClass().getResource(beforeUndo);
        assertTrue(TestUtil.equalXmlFiles(new ByteArrayInputStream(bytes), url));
        
        DataObject loaded = xmlHelper.load(new ByteArrayInputStream(bytes)).getRootObject();
        baos.reset();
        xmlHelper.save(loaded, nameSpace, element, baos);
        //xmlHelper.save(loaded, nameSpace, element, System.out);
        assertTrue(TestUtil.equalXmlFiles(new ByteArrayInputStream(baos.toByteArray()), url));
        
        // Undo all changes and then serialize the resulting data graph again
        //
        cs.undoChanges();
        
        baos.reset();
        xmlHelper.save(quote, nameSpace, element, baos);
        //xmlHelper.save(quote, nameSpace, element, System.out);
        
        assertTrue(TestUtil.equalXmlFiles(new ByteArrayInputStream(baos.toByteArray()), getClass().getResource(afterUndo)));
    }
    
    /**
     * ChangeSummary property test.
     */
    protected final void change(String nameSpace, String beforeUndo, String afterUndo) throws Exception {
        Type quoteType = hc.getTypeHelper().getType(nameSpace, "RootQuote");
        DataObject quote = dataFactory.create(quoteType);
        
        ChangeSummary cs = quote.getChangeSummary();
        ChangeSummary csp = (ChangeSummary)quote.get("changes");

        assertSame(cs, csp);

        quote.setString("symbol", "fbnt");
        quote.setString("companyName", "FlyByNightTechnology");
        quote.setBigDecimal("price", new BigDecimal("1000.0"));
        DataObject child = quote.createDataObject("quotes");
        child.setBigDecimal("price", new BigDecimal("1500.0"));
        child = quote.createDataObject("quotes");
        child.setBigDecimal("price", new BigDecimal("2000.0"));
        child = child.createDataObject("quotes");
        child.setBigDecimal("price", new BigDecimal("2000.99"));
        child = quote.createDataObject("quotes");
        child.setBigDecimal("price", new BigDecimal("2500.0"));

        // Begin logging changes
        //
        cs.beginLogging();

        // Modify the data graph in various ways
        //
        quote.setString("symbol", "FBNT");
        quote.setBigDecimal("price", new BigDecimal("999.0"));
        quote.setDouble("volume", 1000);

        child = quote.createDataObject("quotes");
        child.setBigDecimal("price", new BigDecimal("3000.0"));
        child = quote.createDataObject("quotes");
        child.setBigDecimal("price", new BigDecimal("4000.0"));

        quote.getDataObject("quotes[2]").delete();

        verify(cs, quote, nameSpace, "stockQuote", beforeUndo, afterUndo);
    }
    
    /**
     * Simple ChangeSummary property test.
     */
    public void testChangeSummary() throws Exception {
        change(TEST_NAMESPACE, TEST_DATA_BEFORE_UNDO, TEST_DATA_AFTER_UNDO);
    }
    
    static final String SequenceTest_NameSpace = "http://www.example.com/sequenceCS";

    /**
     * Mixed ChangeSummary property test.
     */
    public void testMixedChangeSummary() throws Exception {
        change(SequenceTest_NameSpace, "/mixedChangeSummary.xml", "/mixedChangeSummaryUndone.xml");
    }
    
    protected final DataObject createDataObject(Type quoteType, Object value, Sequence sequence, Property property) {
        DataObject child = dataFactory.create(quoteType);
        child.set("symbol", value);
        sequence.add(property, child);
        return child;
    }
    
    static final String SequenceTest_ELEMENT = "openQuote";

    private XSDHelper xsdHelper;

    /**
     * Open/any ChangeSummary property test.
     */
    public void testOpenChangeSummary() throws Exception {
        DataObject quote = dataFactory.create(xsdHelper.getGlobalProperty(SequenceTest_NameSpace, SequenceTest_ELEMENT, true).getType());
        
        ChangeSummary cs = quote.getChangeSummary();
        ChangeSummary csp = (ChangeSummary)quote.get("changes");

        assertSame(cs, csp);

        quote.set("symbol", "fbnt");
        Property property = xsdHelper.getGlobalProperty("http://www.example.com/open", "openStockQuote", true);
        Type quoteType = property.getType();
        List openStockQuotes = ((DataObject)quote).getList(property);
        
        addQuote(openStockQuotes, quoteType, "1500.0");
        DataObject osq2 = addQuote(openStockQuotes, quoteType, "2000.0");
        addQuote(osq2.getList(property), quoteType, "2000.99");
        addQuote(openStockQuotes, quoteType, "2500.0");

        // Begin logging changes
        //
        cs.beginLogging();

        // Modify the data graph in various ways
        //
        quote.set("symbol", "FBNT");

        addQuote(openStockQuotes, quoteType, "3000.0");
        addQuote(openStockQuotes, quoteType, "4000.0");

        openStockQuotes.remove(osq2);


        verify(cs, quote, SequenceTest_NameSpace, SequenceTest_ELEMENT, "/openChangeSummary.xml", "/openChangeSummaryUndone.xml");
    }

    private DataObject addQuote(List openStockQuotes, Type quoteType,
            Object value) {
        DataObject osq = dataFactory.create(quoteType);
        osq.set("symbol", value);
	    openStockQuotes.add(osq);
        return osq;
    }

    void define(String model) throws Exception {
        // Populate the meta data for the test model
        URL url = getClass().getResource(model);
        xsdHelper.define(url.openStream(), url.toString());
    }
    
    protected void setUp() throws Exception {
        super.setUp();
        hc = SDOUtil.createHelperContext();
        xsdHelper = hc.getXSDHelper();
        dataFactory = hc.getDataFactory();
        xmlHelper = hc.getXMLHelper();

        // Populate the meta data for the test (Stock Quote) model
        define(TEST_MODEL);

        define("/SequenceChangeSummary.xsd");
    }
}
