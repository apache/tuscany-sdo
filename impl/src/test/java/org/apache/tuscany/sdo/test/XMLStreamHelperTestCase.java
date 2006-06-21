package org.apache.tuscany.sdo.test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.tuscany.sdo.helper.XMLStreamHelper;
import org.apache.tuscany.sdo.util.SDOUtil;

import commonj.sdo.DataObject;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;

public class XMLStreamHelperTestCase extends TestCase {

    private XSDHelper xsdHelper = XSDHelper.INSTANCE;

    private TypeHelper typeHelper = TypeHelper.INSTANCE;

    private XMLStreamHelper streamHelper;

    private XMLInputFactory inputFactory;

    private XMLOutputFactory outputFactory;

    private QName module = new QName("http://foo", "module");

    private QName name = new QName("http://bar", "implementation.mock");

    private String testName = "foo-ext";
    // private String testName = "complex";

    private String xml;

    // = "<module name=\"m\" xmlns=\"http://foo\" xmlns:bar=\"http://bar\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"
    // xsi:schemaLocation=\"http://bar foo-ext.xsd http://foo foo.xsd \"><component name=\"c\"><bar:implementation.mock
    // myAttr=\"helloworld.HelloWorldImpl\" listAttr=\"1 2\">1<bar:myElement>Dummy</bar:myElement>2</bar:implementation.mock></component></module>";

    protected void setUp() throws Exception {
        super.setUp();
        streamHelper = SDOUtil.createXMLStreamHelper(typeHelper);
        URL url = getClass().getClassLoader().getResource(testName + ".xsd");
        xsdHelper.define(url.openStream(), url.toExternalForm());
        inputFactory = XMLInputFactory.newInstance();
        outputFactory = XMLOutputFactory.newInstance();
        url = getClass().getClassLoader().getResource(testName + ".xml");
        InputStreamReader reader = new InputStreamReader(url.openStream());
        StringBuffer stringBuffer = new StringBuffer();
        char buf[] = new char[1024];
        int size;
        while ((size = reader.read(buf)) != -1)
            stringBuffer.append(buf, 0, size);
        xml = stringBuffer.toString();
        reader.close();
    }

    public void testLoadObject() throws Exception {
        XMLStreamReader reader = inputFactory.createXMLStreamReader(new StringReader(xml));
        int event = reader.getEventType();
        while (!(event == XMLStreamConstants.START_ELEMENT && reader.getName().equals(name)) && reader.hasNext()) {
            event = reader.next();
        }
        DataObject dataObject = streamHelper.loadObject(reader);
        Assert.assertNotNull(dataObject);
        Assert.assertTrue(dataObject.getString("myAttr").equals("helloworld.HelloWorldImpl"));
    }

    public void testLoad() throws Exception {
        XMLStreamReader reader = inputFactory.createXMLStreamReader(new StringReader(xml));
        XMLDocument document = streamHelper.load(reader);
        Assert.assertNotNull(document);
        Assert.assertEquals(document.getRootElementURI(), module.getNamespaceURI());
        Assert.assertEquals(document.getRootElementName(), module.getLocalPart());
        DataObject moduleObject = document.getRootObject();
        List components = moduleObject.getList("component");
        DataObject componentObject = (DataObject) components.get(0);
        // componentObject.getDataObject("implementation.mock");
        DataObject implObject = (DataObject) componentObject.getSequence(0).getValue(0);
        Assert.assertTrue(implObject.getString("myAttr").equals("helloworld.HelloWorldImpl"));
    }

    public void testSave() throws XMLStreamException {
        XMLDocument document = XMLHelper.INSTANCE.load(xml);
        StringWriter writer = new StringWriter();
        XMLStreamWriter streamWriter = outputFactory.createXMLStreamWriter(writer);
        streamHelper.save(document, streamWriter);
        streamWriter.flush();
        String xmlStr = writer.toString();
        // System.out.println(xmlStr);
         Assert.assertTrue(xmlStr.contains("myAttr=\"helloworld.HelloWorldImpl\""));
    }

    public void testSaveObject() throws XMLStreamException {
        XMLDocument document = XMLHelper.INSTANCE.load(xml);
        DataObject moduleObject = document.getRootObject();
        List components = moduleObject.getList("component");
        DataObject componentObject = (DataObject) components.get(0);
        StringWriter writer = new StringWriter();
        XMLStreamWriter streamWriter = outputFactory.createXMLStreamWriter(writer);
        streamHelper.saveObject(componentObject, streamWriter);
        streamWriter.flush();
        Assert.assertTrue(writer.toString().contains("myAttr=\"helloworld.HelloWorldImpl\""));
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

}
