package org.apache.tuscany.sdo.test;

import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.helper.XMLStreamHelper;
import org.apache.tuscany.sdo.util.SDOUtil;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XSDHelper;

public class AnyTypeTest extends TestCase {
    private static TypeHelper typeHelper;
    private static DataFactory dataFactory;
    private static XMLStreamHelper streamHelper;
    private static XSDHelper xsdHelper;

    private static final String TEST_MODEL = "/anytype.xsd";
    private static final String TEST_NAMESPACE = "http://www.example.com/anytype";

    public void testAnySimpleType() throws Exception {
        Property property = typeHelper.getOpenContentProperty(TEST_NAMESPACE, "globalElement");
        Type propertyType = property.getType();

        DataObject dataObject = dataFactory.create(TEST_NAMESPACE, "Person");
        dataObject.set("firstName", "Fuhwei");

        DataObject rootObject = dataFactory.create(propertyType);
        rootObject.set("anyTypeElement", dataObject);

        dataObject = dataFactory.create(TEST_NAMESPACE, "Person");
        dataObject.set("firstName", "Mindy");
        rootObject.set("personElement", dataObject);

        // XMLStreamHelper.saveObject has a problem to serialize the any type
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        StringWriter writer = new StringWriter();
        XMLStreamWriter streamWriter = outputFactory.createXMLStreamWriter(writer);
        streamHelper.saveObject(rootObject, streamWriter);
        streamWriter.flush();
        System.out.println(writer.toString());

        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        StringReader reader = new StringReader(writer.toString());
        XMLStreamReader streamReader = inputFactory.createXMLStreamReader(reader);
        XMLDocument doc = streamHelper.load(streamReader);
        rootObject = doc.getRootObject();
        DataObject testObject = rootObject.getDataObject("anyTypeElement");
        System.out.println("anyTypeElement dataobject: " + testObject);
        testObject = rootObject.getDataObject("personElement");
        System.out.println("personElement dataobject: " + testObject);
    }

    protected void setUp() throws Exception {
        typeHelper = SDOUtil.createTypeHelper();
        dataFactory = SDOUtil.createDataFactory(typeHelper);
        streamHelper = SDOUtil.createXMLStreamHelper(typeHelper);
        xsdHelper = SDOUtil.createXSDHelper(typeHelper);

        // Populate the meta data for the test (Stock Quote) model
        URL url = getClass().getResource(TEST_MODEL);
        InputStream inputStream = url.openStream();
        xsdHelper.define(inputStream, url.toString());
        inputStream.close();
    }

}
