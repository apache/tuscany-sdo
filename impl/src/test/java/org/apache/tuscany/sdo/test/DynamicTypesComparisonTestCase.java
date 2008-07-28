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
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.util.SDOUtil;

import commonj.sdo.DataObject;
import commonj.sdo.Sequence;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;

/**
 * Test to compare data objects created with SDO API with one created from XML
 */
public class DynamicTypesComparisonTestCase extends TestCase {
    private final String COMMONJ_SDO = "commonj.sdo";

    private final String DYNAMIC_ROOT_TYPE_0 = "TestType0";

    private final String DYNAMIC_TYPES_SCHEMA_STRING = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<xsd:schema\n"
            + "    targetNamespace=\"http://www.example.com/dynamicTypesFromSchemaSimple\"\n"
            + "    xmlns:dtfs=\"http://www.example.com/dynamicTypesFromSchemaSimple\"\n"
            + "    xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n" + "    \n"
            + "  <xsd:complexType name=\"TestType0\" mixed=\"true\">\n" + "    <xsd:sequence>\n"
            + "      <xsd:element name=\"aString\" minOccurs=\"0\" maxOccurs=\"unbounded\" type=\"xsd:string\"/>\n"
            + "      <xsd:element name=\"aBoolean\" minOccurs=\"0\" maxOccurs=\"unbounded\" type=\"xsd:boolean\"/>\n"
            + "      <xsd:element name=\"aFloat\" minOccurs=\"0\" maxOccurs=\"unbounded\" type=\"xsd:float\"/>\n"
            + "    </xsd:sequence>\n" + "  </xsd:complexType>\n" + "    \n"
            + "  <xsd:element name=\"testElement0\" type=\"dtfs:TestType0\"/>\n" + "    \n" + "</xsd:schema>\n";

    private final String DYNAMIC_TYPES_URI = "http://www.example.com/dynamicTypesFromSchemaSimple";

    private final String SDO_FROM_API_AND_DYN = "object created with API with dynamic type ";

    private final String SDO_FROM_API_AND_REF = "object created with API with type from XSD";

    private final String SDO_FROM_XML_AND_REF = "object created with XML with type from XSD";

    private final String TEST_XML_DOC_0_STRING = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
            + "<dtfs:testElement0 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"
            + "    xmlns:dtfs=\"http://www.example.com/dynamicTypesFromSchemaSimple\">\n"
            + "  <aString>This is a repeated string.</aString>\n" + "  <aString>This is a repeated string.</aString>\n"
            + "  <aBoolean>true</aBoolean>\n" + "  <aBoolean>false</aBoolean>\n" + "  <aBoolean>true</aBoolean>\n"
            + "  <aBoolean>1</aBoolean>\n" + "  <aBoolean>0</aBoolean>\n" + "  <aFloat>0</aFloat>\n"
            + "  <aFloat>12.5</aFloat>\n" + "  <aFloat>0</aFloat>\n" + "</dtfs:testElement0>\n";

    private void comparePropertyObjects(String propName, String name1, String name2, Object propObj1, Object propObj2) {
        if (propObj1 == null) {
            if (propObj2 != null) {
                localFail("property " + propName + " for " + name1 + " was null but " + name2 + " was '" + propObj2
                        + "'");
            }
        } else if (propObj2 == null) {
            localFail("property " + propName + " for " + name2 + " was null but " + name1 + " was '" + propObj1 + "'");
        } else {
            if (!propObj1.equals(propObj2)) {
                localFail("property " + propName + " for " + name1 + " was '" + propObj1 + "' but " + name2 + " was '"
                        + propObj2 + "'");
            }
        }
    }

    private void compareSequencesIgnoringWhitespace(String name1, String name2, Sequence sequence1, Sequence sequence2) {
        if (sequence1 == null) {
            if (sequence2 != null) {
                localFail("sequence for " + name1 + " was null but " + name2 + " was not null");
            }
        } else if (sequence2 == null) {
            localFail("sequence for " + name2 + " was null but " + name1 + " was not null");
        } else {
            List trimmedSeq1 = new ArrayList();
            List trimmedSeq2 = new ArrayList();
            trimWhitespaceFromSequence(trimmedSeq1, sequence1);
            trimWhitespaceFromSequence(trimmedSeq2, sequence2);
            int size1 = trimmedSeq1.size();
            int size2 = trimmedSeq2.size();
            if (size1 != size2) {
                localFail("lengths of trimmed sequences differ: " + name1 + " was " + size1 + ", " + name2 + " was "
                        + size2);
            } else {
                Object[] objArr1 = trimmedSeq1.toArray();
                Object[] objArr2 = trimmedSeq2.toArray();
                for (int i = 0; i < size1; i++) {
                    Object obj1 = objArr1[i];
                    Object obj2 = objArr2[i];
                    if (obj1 == null) {
                        if (obj2 != null) {
                            localFail("sequence for " + name1 + " had null element for which " + name2 + " had '" + obj2
                                    + "'");
                        }
                    } else if (obj2 == null) {
                        localFail("sequence for " + name2 + " had null element for which " + name1 + " had '" + obj1 + "'");
                    } else {
                        if (!obj1.equals(obj2)) {
                            localFail("sequences did not match: " + name1 + " had '" + obj1 + "' but " + name2 + " had '"
                                    + obj2 + "'");
                        }
                    }
                }
            }
        }
    }

    private void getAndCompareProperties(String propName, DataObject xmlAndRefTypDO, DataObject apiAndDynTypDO,
            DataObject apiAndRefTypDO) {
        Object xmlRefProperty = xmlAndRefTypDO.get(propName);
        Object apiDynProperty = apiAndDynTypDO.get(propName);
        Object apiRefProperty = apiAndRefTypDO.get(propName);
        comparePropertyObjects(propName, SDO_FROM_XML_AND_REF, SDO_FROM_API_AND_DYN, xmlRefProperty, apiDynProperty);
        comparePropertyObjects(propName, SDO_FROM_XML_AND_REF, SDO_FROM_API_AND_REF, xmlRefProperty, apiRefProperty);
    }

    private void localFail(String message) {
        // System.err.println(message);
        fail(message);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    private void specifyProperty(DataObject containingTypeDO, String nameString, Type typ, boolean isMany) {
        DataObject subordinateProperty = containingTypeDO.createDataObject("property");
        subordinateProperty.set("name", nameString);
        subordinateProperty.set("type", typ);
        subordinateProperty.setBoolean("many", isMany);
    }

    /**
     * test #0 of Data Object primitive datatypes
     */
    public void testDynamicTypesGroup0DO() throws IOException {
        HelperContext hcDO = SDOUtil.createHelperContext();

        TypeHelper thDO = hcDO.getTypeHelper();
        DataFactory dfDO = hcDO.getDataFactory();

        // create a container object type
        DataObject containerTypeDO = dfDO.create("commonj.sdo", "Type");
        containerTypeDO.set("uri", DYNAMIC_TYPES_URI);
        containerTypeDO.set("name", DYNAMIC_ROOT_TYPE_0);
        containerTypeDO.set("sequenced", Boolean.TRUE);

        specifyProperty(containerTypeDO, "aString", thDO.getType(COMMONJ_SDO, "String"), true);
        specifyProperty(containerTypeDO, "aBoolean", thDO.getType(COMMONJ_SDO, "Boolean"), true);
        specifyProperty(containerTypeDO, "aFloat", thDO.getType(COMMONJ_SDO, "Float"), true);

        Type containerType = thDO.define(containerTypeDO);
        assertNotNull(containerType);

        DataObject doFromApiAndDynTyp = dfDO.create(containerType);
        assertNotNull(doFromApiAndDynTyp);
        doFromApiAndDynTyp.getList("aString").add("This is a repeated string.");
        doFromApiAndDynTyp.getList("aString").add("This is a repeated string.");
        doFromApiAndDynTyp.getList("aBoolean").add(new Boolean(true));
        doFromApiAndDynTyp.getList("aBoolean").add(new Boolean(false));
        doFromApiAndDynTyp.getList("aBoolean").add(new Boolean(true));
        doFromApiAndDynTyp.getList("aBoolean").add(new Boolean(true));
        doFromApiAndDynTyp.getList("aBoolean").add(new Boolean(false));
        doFromApiAndDynTyp.getList("aFloat").add(new Float(0));
        doFromApiAndDynTyp.getList("aFloat").add(new Float(12.5));
        doFromApiAndDynTyp.getList("aFloat").add(new Float(0));

        Type rootType = thDO.getType(DYNAMIC_TYPES_URI, DYNAMIC_ROOT_TYPE_0);
        assertNotNull(rootType);
        assertSame(containerType, rootType);

        // now load xml to get a reference data object using schema
        HelperContext hcRef = SDOUtil.createHelperContext();
        XSDHelper xsdHelper = hcRef.getXSDHelper();
        List typeList = xsdHelper.define(DYNAMIC_TYPES_SCHEMA_STRING);
        assertNotNull(typeList);
        TypeHelper thRef = hcRef.getTypeHelper();
        Type rootTypeRef = thRef.getType(DYNAMIC_TYPES_URI, DYNAMIC_ROOT_TYPE_0);

        assertNotNull(rootTypeRef);

        XMLHelper xhRef = hcRef.getXMLHelper();
        // XMLDocument docRef =
        // xhRef.load(getClass().getResourceAsStream(TEST_XML_DOC_0));
        XMLDocument docRef = xhRef.load(TEST_XML_DOC_0_STRING);
        DataObject doFromXmlAndRefTyp = docRef.getRootObject();

        assertNotNull(doFromXmlAndRefTyp);

        // create a data object using dynamic API from reference type
        DataFactory dfRef = hcRef.getDataFactory();
        DataObject doFromApiAndRefTyp = dfRef.create(rootTypeRef);
        assertNotNull(doFromApiAndRefTyp);
        doFromApiAndRefTyp.getList("aString").add("This is a repeated string.");
        doFromApiAndRefTyp.getList("aString").add("This is a repeated string.");
        doFromApiAndRefTyp.getList("aBoolean").add(new Boolean(true));
        doFromApiAndRefTyp.getList("aBoolean").add(new Boolean(false));
        doFromApiAndRefTyp.getList("aBoolean").add(new Boolean(true));
        doFromApiAndRefTyp.getList("aBoolean").add(new Boolean(true));
        doFromApiAndRefTyp.getList("aBoolean").add(new Boolean(false));
        doFromApiAndRefTyp.getList("aFloat").add(new Float(0));
        doFromApiAndRefTyp.getList("aFloat").add(new Float(12.5));
        doFromApiAndRefTyp.getList("aFloat").add(new Float(0));

        getAndCompareProperties("aString", doFromXmlAndRefTyp, doFromApiAndDynTyp, doFromApiAndRefTyp);
        getAndCompareProperties("aBoolean", doFromXmlAndRefTyp, doFromApiAndDynTyp, doFromApiAndRefTyp);
        getAndCompareProperties("aFloat", doFromXmlAndRefTyp, doFromApiAndDynTyp, doFromApiAndRefTyp);
        Sequence seqFromXmlAndRefTyp = doFromXmlAndRefTyp.getSequence();
        Sequence seqFromApiAndDynTyp = doFromApiAndDynTyp.getSequence();
        Sequence seqFromApiAndRefTyp = doFromApiAndRefTyp.getSequence();
        compareSequencesIgnoringWhitespace(SDO_FROM_XML_AND_REF, SDO_FROM_API_AND_DYN, seqFromXmlAndRefTyp,
                seqFromApiAndDynTyp);
        compareSequencesIgnoringWhitespace(SDO_FROM_XML_AND_REF, SDO_FROM_API_AND_REF, seqFromXmlAndRefTyp,
                seqFromApiAndRefTyp);
    }

    private void trimWhitespaceFromSequence(List trimmedSeq, Sequence sequence) {
        if (sequence != null) {
            for (int i = 0; i < sequence.size(); i++) {
                Object obj = sequence.getValue(i);
                if (obj instanceof String) {
                    String str = ((String) obj).trim();
                    if (str.length() > 0) {
                        trimmedSeq.add(str);
                    }
                } else {
                    trimmedSeq.add(obj);
                }
            }
        }
    }
}
