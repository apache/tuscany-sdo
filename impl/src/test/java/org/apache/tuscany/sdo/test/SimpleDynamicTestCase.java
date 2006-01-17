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


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.net.URL;

import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;
import junit.framework.TestCase;


public class SimpleDynamicTestCase extends TestCase {
    private static final String TEST_MODEL = "/simple.xsd";
    private static final String TEST_NAMESPACE = "http://www.example.com/simple";
    private File tmpFile;

    /**
     * Simple Dynamic SDO 2 test.
     */
    public void testDynamic() throws IOException {
        Type quoteType = TypeHelper.INSTANCE.getType(TEST_NAMESPACE, "Quote");
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

/*      FIXME the next line causes a ClassCastException when run from mvn
        XMLHelper.INSTANCE.save(quote, TEST_NAMESPACE, "stockQuote", new FileOutputStream(tmpFile));

        XMLDocument doc = XMLHelper.INSTANCE.load(new FileInputStream(tmpFile));

        System.out.println("Root element URI: " + doc.getRootElementURI());
        System.out.println("Root element name: " + doc.getRootElementName());
        System.out.println("Root object type: " + doc.getRootObject().getType().getName());
        XMLHelper.INSTANCE.save(doc, System.out, null);
*/
    }


    protected void setUp() throws Exception {
        super.setUp();

        // Populate the meta data for the test (Stock Quote) model
        URL url = getClass().getResource(TEST_MODEL);
        InputStream inputStream = url.openStream();
        XSDHelper.INSTANCE.define(inputStream, url.toString());
        inputStream.close();

        tmpFile = File.createTempFile("SimpleDynamicTestCase", ".xml");
    }

    protected void tearDown() throws Exception {
        tmpFile.delete();
        super.tearDown();
    }
}
