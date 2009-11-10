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

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.tuscany.sdo.api.SDOUtil;
import org.apache.tuscany.sdo.api.XMLStreamHelper;

import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLDocument;

public class XMLStreamHelperTestCase extends TestCase {

    private HelperContext hc;

    private XMLStreamHelper streamHelper;

    private XMLInputFactory inputFactory;

    private XMLOutputFactory outputFactory;

    private final QName module = new QName("http://foo", "module");

    private final QName name = new QName("http://bar", "implementation.mock");

    private final String testName = "foo-ext";
    // private String testName = "complex";

    private String xml;

    // = "<module name=\"m\" xmlns=\"http://foo\" xmlns:bar=\"http://bar\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"
    // xsi:schemaLocation=\"http://bar foo-ext.xsd http://foo foo.xsd \"><component name=\"c\"><bar:implementation.mock
    // myAttr=\"helloworld.HelloWorldImpl\" listAttr=\"1 2\">1<bar:myElement>Dummy</bar:myElement>2</bar:implementation.mock></component></module>";

    protected void setUp() throws Exception {
        super.setUp();
        
        hc = SDOUtil.createHelperContext();
        streamHelper = SDOUtil.createXMLStreamHelper(hc);

        URL url = getClass().getClassLoader().getResource(testName + ".xsd");
        hc.getXSDHelper().define(url.openStream(), url.toExternalForm());
        url = getClass().getResource("/mixed.xsd");
        hc.getXSDHelper().define(url.openStream(), url.toString());

        inputFactory = XMLInputFactory.newInstance();
        outputFactory = XMLOutputFactory.newInstance();
        
        url = getClass().getClassLoader().getResource(testName + ".xml");
        final InputStreamReader reader = new InputStreamReader(url.openStream());
        final StringBuffer stringBuffer = new StringBuffer();
        final char buf[] = new char[1024];
        int size;
        while ((size = reader.read(buf)) != -1) {
            stringBuffer.append(buf, 0, size);
        }
        xml = stringBuffer.toString();
        reader.close();
    }

    public void testLoadObject() throws Exception {
        final XMLStreamReader reader = inputFactory.createXMLStreamReader(new StringReader(xml));
        int event = reader.getEventType();
        while (!((event == XMLStreamConstants.START_ELEMENT) && reader.getName().equals(name)) && reader.hasNext()) {
            event = reader.next();
        }
        final DataObject dataObject = streamHelper.loadObject(reader);
        Assert.assertNotNull(dataObject);
        Assert.assertTrue(dataObject.getString("myAttr").equals("helloworld.HelloWorldImpl"));
    }

    public void testLoadUnqualifiedObject() throws Exception {
        final XMLStreamReader reader = inputFactory.createXMLStreamReader(new StringReader(xml.replaceAll("bar:", "")));
        int event = reader.getEventType();
        while (!((event == XMLStreamConstants.START_ELEMENT) && reader.getName().getLocalPart().equals(name.getLocalPart())) && reader.hasNext()) {
            event = reader.next();
        }
        final Map options = new HashMap();
        options.put(XMLStreamHelper.OPTION_DEFAULT_ROOT_TYPE, hc.getTypeHelper().getType(name.getNamespaceURI(), "MockImplementation"));
        final DataObject dataObject = streamHelper.loadObject(reader, options);
        Assert.assertNotNull(dataObject);
        Assert.assertTrue(dataObject.getString("myAttr").equals("helloworld.HelloWorldImpl"));
    }

    public void testLoad() throws Exception {
        final XMLStreamReader reader = inputFactory.createXMLStreamReader(new StringReader(xml));
        final XMLDocument document = streamHelper.load(reader);
        Assert.assertNotNull(document);
        Assert.assertEquals(document.getRootElementURI(), module.getNamespaceURI());
        Assert.assertEquals(document.getRootElementName(), module.getLocalPart());
        final DataObject moduleObject = document.getRootObject();
        final List components = moduleObject.getList("component");
        final DataObject componentObject = (DataObject) components.get(0);
        final DataObject implObject = componentObject.getDataObject("implementation.mock");
        Assert.assertTrue(implObject.getString("myAttr").equals("helloworld.HelloWorldImpl"));
    }

    public void testSave() throws XMLStreamException {
        final XMLDocument document = hc.getXMLHelper().load(xml);
        final StringWriter writer = new StringWriter();
        final XMLStreamWriter streamWriter = outputFactory.createXMLStreamWriter(writer);
        streamHelper.save(document, streamWriter);
        streamWriter.flush();
        final String xmlStr = writer.toString();
        //System.out.println(xmlStr);
        Assert.assertTrue(xmlStr.indexOf("myAttr=\"helloworld.HelloWorldImpl\"")!=-1);
    }

    public void testSaveObject() throws XMLStreamException {
        final XMLDocument document = hc.getXMLHelper().load(xml);
        final DataObject moduleObject = document.getRootObject();
        final List components = moduleObject.getList("component");
        final DataObject componentObject = (DataObject) components.get(0);
        final StringWriter writer = new StringWriter();
        final XMLStreamWriter streamWriter = outputFactory.createXMLStreamWriter(writer);
        streamHelper.saveObject(componentObject, streamWriter);
        streamWriter.flush();
        Assert.assertTrue(writer.toString().indexOf("myAttr=\"helloworld.HelloWorldImpl\"")!=-1);
    }

    public void testSaveSequence() throws IOException, XMLStreamException {
        final DataObject quote = hc.getDataFactory().create("http://www.example.com/mixed", "MixedQuote");
        quote.setString("symbol", "fbnt");
        quote.getSequence().addText(0, "testing");
        quote.getSequence().addText("more testing");

        final StringWriter writer = new StringWriter();
        final XMLStreamWriter streamWriter = outputFactory.createXMLStreamWriter(writer);
        streamHelper.saveObject(quote, streamWriter);
        streamWriter.flush();
        //System.out.println(writer);
        assertTrue(writer.toString().indexOf("<symbol>fbnt</symbol>") != -1);
    }
    
    // Test case for TUSCANY-1788
    public void testXSIType() throws Exception {
        URL ipo = getClass().getResource("/ipo.xsd");
        hc.getXSDHelper().define(ipo.openStream(), ipo.toString());
        DataObject d = hc.getDataFactory().create("http://www.example.com/IPO", "PurchaseOrderType");
        DataObject billTo = hc.getDataFactory().create("http://www.example.com/IPO", "USAddress");
        billTo.setString("city", "San Jose");
        billTo.setString("state", "CA");
        d.setDataObject("billTo", billTo);
        XMLDocument ipoDoc = hc.getXMLHelper().createDocument(d, "http://www.example.com/IPO", "purchaseOrder");
        final StringWriter writer = new StringWriter();
        final XMLStreamWriter xmlWriter = outputFactory.createXMLStreamWriter(writer);
        streamHelper.save(ipoDoc, xmlWriter, null);
        xmlWriter.close();
        String xml = writer.toString();
        assertTrue(xml.indexOf("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"") != -1);
        assertTrue(xml.indexOf("xsi:type") != -1);
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

}
