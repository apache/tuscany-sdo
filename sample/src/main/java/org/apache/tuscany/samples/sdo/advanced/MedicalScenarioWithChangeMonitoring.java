/**
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
package org.apache.tuscany.samples.sdo.advanced;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tuscany.samples.sdo.SampleBase;
import org.apache.tuscany.sdo.api.SDOUtil;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;

/**
 * This sample is based on a 2 part article by Kelvin Goodson and Geoffrey Winn.
 * In this variant of the sample the model for the test includes change monitoring.
 * The facility for undoing changes on the basis of the change monitoring is
 * demonstrated.
 * See <A href="http://soa.sys-con.com/read/313547.htm">Part1</A> and <A
 * href="http://soa.sys-con.com/read/358059.htm">Part 2</A> of the article.
 * <p>
 * <h3>Running this Sample</h3> See <A HREF="../../../../../../index.html" 
 * target="_top">the main overview</A> for instructions on how to run this 
 * sample.
 */
public class MedicalScenarioWithChangeMonitoring extends SampleBase {

  private static final String sdoApiUri = "commonj.sdo";

  private static final String peopleURI = "www.example.org/people";

  private static final String medicalURI = "www.example.org/MedicalTest";

  boolean typesViaAPI = false;

  private static final String usage = " [-api |-xsd]\n"
      + "   -api : define the types using the SDO API\n"
      + "   -xsd : define the types using an XML schema file";

  public MedicalScenarioWithChangeMonitoring(String[] args, Integer userLevel) {

    super(userLevel, SAMPLE_LEVEL_ADVANCED);

    if (args.length > 1) {
      printUsage(args);
      System.exit(-1);
    }
    if (args.length == 1) {
      if (args[0].equals("-xsd")) {
        typesViaAPI = false;
      } else if (args[0].equals("-api")) {
        typesViaAPI = true;
      } else {
        printUsage(args);
        System.exit(-1);
      }
    }
  }
  
  public MedicalScenarioWithChangeMonitoring(Integer userLevel) {
    super(userLevel, SAMPLE_LEVEL_ADVANCED);
  }
  

  private void printUsage(String[] args) {
    System.out.println("Usage: " + this.getClass().getName() + usage);
  }

  /**
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {

    MedicalScenarioWithChangeMonitoring s = new MedicalScenarioWithChangeMonitoring(args, COMMENTARY_FOR_NOVICE);
    s.run();

  }
  
  /*
   *  metadata for the sample documenting the areas of SDO that are explored
   */
  public static int [] CORE_FUNCTION = {
    SDOFacets.CONTAINMENT,
    SDOFacets.CREATE_TYPES_USING_THE_SDO_API,
    SDOFacets.CREATE_TYPES_USING_XML_SCHEMA,
    SDOFacets.OPEN_CONTENT,
    SDOFacets.NON_CONTAINMENT,
    SDOFacets.CHANGE_MONITORING_USING_A_CHANGESUMMARY_PROPERTY_ON_A_DATAOBJECT
  };
  
  public static int [] SIGNIFICANT_FUNCTION = {
    SDOFacets.CREATE_DATAOBJECTS_BY_NAME,
    SDOFacets.ISMANY_PROPERTIES,
    SDOFacets.GENERIC_DATA_GRAPH_TRAVERSAL,
    SDOFacets.SAVING_DATA_TO_XML
  };

  public void runSample() throws Exception {

    HelperContext scope = SDOUtil.createHelperContext();

    if (typesViaAPI) {

      commentary("In this execution of the sample we use Types created\n"
          + "using the SDO API");

      createTypesViaAPI(scope);

    } else {

      commentary("In this execution of the sample we use Types created\n"
          + "by loading a variant of the XMLSchema that includes a change summary Property");

      loadTypesFromXMLSchemaFile(scope, "MedicalTest_CS.xsd");

    }

    commentary(
        COMMENTARY_FOR_NOVICE,
        "The DataFactory associated with the scope that the types were created within\n"
            + "can be used to create an instance of the Person Type\n\n"
            + "DataFactory dataFactory = scope.getDataFactory();\n"
            + "DataObject person1 = dataFactory.create(\"www.example.org/people\", \"Person\");");

    DataFactory dataFactory = scope.getDataFactory();
    DataObject person1 = dataFactory.create("www.example.org/people", "Person");

    commentary("The setString() of dataObject method is used to set the properties of the\n"
        + "new Person DataObject, including a unique identifier reference value\n"
        + "for the Person instance.\n\n"
        + "person1.setString(\"id\", \"1\");\n"
        + "person1.setString(\"name\", \"Joe Johnson Snr.\");\n"
        + "person1.setString(\"gender\", \"male\"););");

    person1.setString("id", "1");
    person1.setString("name", "Joe Johnson Snr.");
    person1.setString("gender", "male");

    commentary("An alternative approach to using the DataFactory directly to create\n"
        + "all DataObjects is to use a top-down approach,  where we create the\n"
        + "root object for a data graph,  and then use the createDataObject(String propertyName)\n"
        + "method to create the contained DataObjects.  Here we create the overall\n"
        + "medical test DataObject,  and then create the contained \"referrals\" DataObject\n\n"
        + "DataObject test = dataFactory.create(\"www.example.org/MedicalTest\", \"Test\");\n"
        + "DataObject referrals = test.createDataObject(\"referrals\");");

    DataObject test = dataFactory.create("www.example.org/MedicalTest", "Test");

    DataObject referrals = test.createDataObject("referrals");

    commentary("The default state for monitoring changes for the DataObject when created in this\n" +
    		"way is the monitoring is switched off, so we switch it on. (Note that if you\n" +
    		"get your data graphs from a data Access Service then this service may turn on\n" +
    		"change monitoring be default\n\n" +
    		"test.getChangeSummary().beginLogging();");
    test.getChangeSummary().beginLogging();
    
    commentary("We'll repeat the whole of the MedicalScenario sample,  but then at the \n" +
    		"last minute we'll decide it was all wrong and roll back the changes......");
    
    commentary("Now we can add the person we created earlier into the set of people who have\n"
        + "been referred for this medical test.\n\n"
        + "test.set(\"referrals\", referrals);\n"
        + "referrals.getList(\"person\").add(person1);");

    test.set("referrals", referrals);
    referrals.getList("person").add(person1);

    commentary("Let's take a look at how the current state of the data"
        + "graph is rendered in XML ...");

    System.out.println(scope.getXMLHelper().save(test,
        "www.example.org/MedicalTest", "test"));

    commentary("The scenario unfolds and the Joe Johnson Snr. becomes a patient\n\n"
        + "DataObject patients = test.createDataObject(\"patients\");\n"
        + "patients.getList(\"person\").add(person1);");

    DataObject patients = test.createDataObject("patients");

    patients.getList("person").add(person1);

    commentary("Having added Joe Johnson Snr. to the set of patients we can see\n"
        + "the way that SDO preserves a single containment hierarchy within a\n"
        + "datagraph.  If we look at the XML rendering of the graph again, we will\n"
        + "see that by adding him to the set of patients he has been removed from the\n"
        + "containment property associated with the referrals set ...");

    System.out.println(scope.getXMLHelper().save(test,
        "www.example.org/MedicalTest", "test"));

    commentary("The 'Person' Type we are making use of here has been designed to be\n"
        + "multi-purpose,  in that the type has been declared to be 'Open'.\n"
        + "That means that we can make use of 'Open Content' Properties\n"
        + "(If the type system has been defined using an XML schema\n"
        + "then these properties will derive from global elements)\n"
        + "We can look up open content Properties using the TypeHelper\n\n"
        + "Property conditionProperty = scope.getTypeHelper().getOpenContentProperty(\n"
        + "    \"www.example.org/MedicalTest\", \"condition\");");

    Property conditionProperty = scope.getTypeHelper().getOpenContentProperty(
        "www.example.org/MedicalTest", "condition");

    commentary("We can create a value of the appropriate Type for this open\n"
        + "content Property\n\n"
        + "DataObject condition = dataFactory.create(conditionProperty.getType());\n"
        + "condition.setString(\"name\", \"Panar Syndrome\");");

    DataObject condition = dataFactory.create(conditionProperty.getType());
    condition.setString("name", "Panar Syndrome");

    commentary("If you ask a DataObject that has an 'Open' Type for its list of\n"
        + "values associated with an open content Property, and the DataObject\n"
        + "doesn't currently have any values for the Property,  it will return\n"
        + "an empty list. We can use the list to add values for the Property\n\n"
        + "List conditions = person1.getList(conditionProperty);\n"
        + "conditions.add(condition);");

    List conditions = person1.getList(conditionProperty);
    conditions.add(condition);

    commentary("A further look at the data graph in XML form shows\n"
        + "the presence of the new condition Property's value ...");

    System.out.println(scope.getXMLHelper().save(test,
        "www.example.org/MedicalTest", "test"));

    commentary("Having looked at the way SDO handles Open content\n"
        + "We now turn our attention to 'non-containment' relationships.\n"
        + "To do this we first create the set of people in the test that\n"
        + "constitute the blood relatives of patients -- 'relatives'\n"
        + "and define a new person to be Joe Johnson Snr's child.\n\n"
        + "DataObject relatives = test.createDataObject(\"relatives\");\n"
        + "DataObject person2 = relatives.createDataObject(\"person\");\n"
        + "person2.setString(\"id\", \"2\");\n"
        + "person2.setString(\"name\", \"Joe Johnson Jnr.\");\n"
        + "person2.setString(\"gender\", \"male\");");

    DataObject relatives = test.createDataObject("relatives");
    DataObject person2 = relatives.createDataObject("person");

    person2.setString("id", "2");
    person2.setString("name", "Joe Johnson Jnr.");
    person2.setString("gender", "male");

    commentary("Another quick look at the XML rendering of the graph confirms that\n"
        + "the set of relatives now includes Joe Johnson Jnr, but we haven't yet\n"
        + "defined who he is related to, or how.");

    System.out.println(scope.getXMLHelper().save(test,
        "www.example.org/MedicalTest", "test"));

    commentary("The Person type has a Property 'relative'\n"
        + "so we create a relative for Joe Johnson Snr.\n\n"
        + "DataObject relation = person1.createDataObject(\"relative\");\n"
        + "relation.set(\"target\", person2);\n"
        + "relation.set(\"relationship\", \"child\");");

    DataObject relation = person1.createDataObject("relative");
    relation.set("target", person2);
    relation.set("relationship", "child");

    commentary("Now when we look at the XML rendering of the data graph\n"
        + "we can see that the action of setting the 'target' of the\n"
        + "relationship to Joe Johnson Jnr didn't displace him from the\n"
        + "set of 'relatives',  because the 'target' Property is a\n"
        + "non-containment Property.  This non-containment relationship\n"
        + "is reflected in the XML by a reference to the Person DataObject\n"
        + "describing Joe Johnson Jnr, \"2\" ...\n"
        + "If the Type system has been created from an XML schema then the\n"
        + "unique ID of the target can be used in the serialization.\n"
        + "If however the type system was defined dynamically,  then the reference\n"
        + "will be represented as an XPath from the root of the data graph.");

    System.out.println(scope.getXMLHelper().save(test,
        "www.example.org/MedicalTest", "test"));
    
    commentary("Now that the graph is complete we can use the PrintDataGraph sample utility\n" +
        "to reveal the full SDO nature of the final data graph\n\n" +
        "");

    PrintDataGraph printer = new PrintDataGraph(COMMENTARY_FOR_ADVANCED);
    printer.printDataObject(test);
    System.out.println(printer.getBuf());
    
    commentary("But Wait! it's all wrong.  Let's go back to our checkpoint where we started monitoring changes\n\n" +
    		"test.getChangeSummary().undoChanges();");
    
    test.getChangeSummary().undoChanges();
    
    printer.reset();
    printer.printDataObject(test);
    System.out.println(printer.getBuf());
    
  }

  /**
   * @throws Exception
   * @throws FileNotFoundException
   */
  private void createTypesViaAPI(HelperContext scope) throws Exception {

    List typeDeclarations = new ArrayList();

    TypeHelper typeHelper = scope.getTypeHelper();

    Type stringType = typeHelper.getType(sdoApiUri, "String");
    Type dateType = typeHelper.getType(sdoApiUri, "Date");
    Type booleanType = typeHelper.getType(sdoApiUri, "Boolean");

    // <complexType name="Person">
    // <sequence>
    // <element name="dob" type="date"/>
    // <element name="relative" maxOccurs="unbounded" type="tns:Relative"/>
    // <any namespace="##other" processContents="lax" maxOccurs="unbounded"/>
    // </sequence>
    // <attribute name="id" type="ID"/>
    // <attribute name="name" type="string"/>
    // <attribute name="gender" type = "tns:Gender"/>
    // </complexType>

    DataObject personTypeDesc = createTypeDescription(scope, peopleURI,
        "Person");
    typeDeclarations.add(personTypeDesc);

    addPropertyDescription(personTypeDesc, stringType, "name");
    addPropertyDescription(personTypeDesc, dateType, "dob");
    addPropertyDescription(personTypeDesc, stringType, "id"); // set to unique
    // identifier?
    addPropertyDescription(personTypeDesc, stringType, "gender"); // restrict?

    DataObject relativeType = createTypeDescription(scope, peopleURI,
        "Relative"); // forward declare the Relative type
    typeDeclarations.add(relativeType);

    DataObject rp = addPropertyDescription(personTypeDesc, relativeType,
        "relative");
    rp.setBoolean("many", true);
    personTypeDesc.set("open", Boolean.TRUE);

    // <complexType name="Relative">
    // <attribute name="target" type="IDREF" sdoxml:propertyType="tns:Person"
    // use="required"/>
    // <attribute name="relationship" type="string" />
    // <attribute name="genetic" use="optional" type="boolean"/>
    // </complexType>

    addPropertyDescription(relativeType, stringType, "relationship");
    addPropertyDescription(relativeType, booleanType, "genetic");
    DataObject targetPersonProp = addPropertyDescription(relativeType,
        personTypeDesc, "target");
    targetPersonProp.setBoolean("containment", false);

    // <complexType name="PersonSet">
    // <sequence>
    // <element name="person" type="tns:Person" maxOccurs="unbounded"/>
    // </sequence>
    // </complexType>

    DataObject pSet = createTypeDescription(scope, peopleURI, "PersonSet");
    typeDeclarations.add(pSet);
    DataObject pSetProperty = addPropertyDescription(pSet, personTypeDesc,
        "person");
    pSetProperty.setBoolean("many", true);

    // <complexType name="Condition">
    // <sequence>
    // <element name="diagnosed" type="date" />
    // </sequence>
    // <attribute name="name" type="tns:ConditionName" />
    // </complexType>

    DataObject condition = createTypeDescription(scope, medicalURI, "Condition");
    typeDeclarations.add(condition);
    addPropertyDescription(condition, booleanType, "diagnosed");
    addPropertyDescription(condition, stringType, "name"); // constrain?

    // <complexType name="Test">
    // <sequence>
    // <element name="referrals" type="people:PersonSet" />
    // <element name="patients" type="people:PersonSet" />
    // <element name="relatives" type="people:PersonSet" />
    // </sequence>
    // </complexType>

    DataObject testType = createTypeDescription(scope, medicalURI, "Test");
    typeDeclarations.add(testType);
    addPropertyDescription(testType, pSet, "referrals");
    addPropertyDescription(testType, pSet, "patients");
    addPropertyDescription(testType, pSet, "relatives");

    List types = typeHelper.define(typeDeclarations);

    DataObject p = scope.getDataFactory().create("commonj.sdo", "Property");
    p.set("type", typeHelper.getType(medicalURI, "Condition"));
    p.set("name", "condition");
    p.setBoolean("many", true);
    p.setBoolean("containment", true); // why is this not the default?

    typeHelper.defineOpenContentProperty(medicalURI, p);

  }

  /**
   * @param uri
   * @param name
   * @return
   */
  private DataObject createTypeDescription(HelperContext scope, String uri,
      String name) {
    DataObject typeDesc = scope.getDataFactory().create(sdoApiUri, "Type");
    typeDesc.set("name", name);
    typeDesc.set("uri", uri);
    return typeDesc;
  }

  private DataObject addPropertyDescription(
      DataObject containerTypeDescription, Object propertyType,
      String propertyName) {
    DataObject property = containerTypeDescription.createDataObject("property");
    property.set("type", propertyType);
    property.setString("name", propertyName);
    property.setBoolean("containment", true);
    return property;
  }

}
