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

package org.apache.tuscany.samples.sdo.internal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import org.apache.tuscany.samples.sdo.advanced.MedicalScenario;
import org.apache.tuscany.samples.sdo.advanced.MedicalScenarioWithChangeMonitoring;
import org.apache.tuscany.samples.sdo.advanced.ObtainingDataGraphFromXml;
import org.apache.tuscany.samples.sdo.advanced.PrintDataGraph;
import org.apache.tuscany.samples.sdo.basic.AccessDataObjectPropertiesByName;
import org.apache.tuscany.samples.sdo.basic.AccessingTheContentsOfASequence;
import org.apache.tuscany.samples.sdo.basic.CreateCompany;
import org.apache.tuscany.samples.sdo.basic.CreatePurchaseOrder;
import org.apache.tuscany.samples.sdo.basic.ReadPurchaseOrder;
import org.apache.tuscany.samples.sdo.intermediate.AccessDataObjectUsingValidXPath;
import org.apache.tuscany.samples.sdo.intermediate.AccessingDataObjectsViaPropertyIndex;
import org.apache.tuscany.samples.sdo.intermediate.CreateCompanyTuscanyAPI;
import org.apache.tuscany.samples.sdo.intermediate.CreateDataObjectFromXmlString;
import org.apache.tuscany.samples.sdo.intermediate.DynamicCustomerTypeSample;
import org.apache.tuscany.samples.sdo.intermediate.SerializingDeserializingADataObject;

/**
 * One of a pair of base classes for samples. This one contains all the
 * infrastructure code that a person wanting to learn SDO would not want to look
 * at.
 */
public abstract class SampleInfrastructure {

  protected int sampleComplexityLevel = SAMPLE_LEVEL_BASIC.intValue();
  protected int commentaryLevel = COMMENTARY_FOR_NOVICE.intValue();
  
  /**
   * Here's the list of sample programs
   */
  public static final Class[] sampleClasses = {
    CreateCompany.class,
    ReadPurchaseOrder.class,
    CreatePurchaseOrder.class,
    AccessDataObjectPropertiesByName.class,
    AccessingTheContentsOfASequence.class,
    
    AccessDataObjectUsingValidXPath.class,
    DynamicCustomerTypeSample.class,
    CreateCompanyTuscanyAPI.class,
    CreateDataObjectFromXmlString.class,
    SerializingDeserializingADataObject.class,
    AccessingDataObjectsViaPropertyIndex.class,
  
    ObtainingDataGraphFromXml.class,
    PrintDataGraph.class,
    MedicalScenario.class,
    MedicalScenarioWithChangeMonitoring.class
  
  };

  public static class SDOFacets {
    public static final int GET_PROPERTIES_OF_DATAOBJECT_BY_NAME = 1; 
    public static final int SET_PROPERTIES_OF_DATAOBJECT_BY_NAME = 2; 
    public static final int CREATE_DATAOBJECTS_BY_NAME = 3; 
    public static final int GET_SET_PROPERTIES_OF_DATAOBJECT_BY_INDEX = 4; 
    public static final int GET_SET_PROPERTIES_BY_INSTANCE_PROPERTIES = 5; 
    public static final int GET_SET_PROPERTIES_OF_DATAOBJECT_BY_XPATH = 6; 
    public static final int ISMANY_PROPERTIES = 7; 
    public static final int CONTAINMENT = 8; 
    public static final int CREATE_TYPES_USING_THE_SDO_API = 9; 
    public static final int CREATE_TYPES_USING_XML_SCHEMA = 10; 
    public static final int CREATE_TYPES_USING_THE_TUSCANY_API = 11; 
    public static final int USING_BUILT_IN_TYPES = 12; 
    public static final int ACCESSING_VALUES_IN_A_SEQUENCE = 13; 
    public static final int GENERIC_DATA_GRAPH_TRAVERSAL = 14; 
    public static final int LOADING_DATA_FROM_XML = 15; 
    public static final int SAVING_DATA_TO_XML = 16; 
    public static final int CHANGE_MONITORING_USING_A_DATAGRAPH = 17; 
    public static final int CHANGE_MONITORING_USING_A_CHANGESUMMARY_PROPERTY_ON_A_DATAOBJECT = 18; 
    public static final int WRAPPING_DATA_GRAPH_IN_A_DATAGRAPH_INSTANCE = 19; 
    public static final int OPEN_CONTENT = 20;
    public static final int NON_CONTAINMENT = 21; 
    public static final int CREATE_XML_SCHEMA_FROM_TYPES = 22; 
    public static final int JAVA_SERIALIZATION_OF_DATA_GRAPH = 23; 
    public static final int TESTING_FOR_GRAPH_EQUALITY = 24;
    
    public static final String [] subject_areas =  {
      "",
      "Get Properties of DataObject by name",
      "Set Properties of DataObject by name",
      "Create DataObjects by name",
      "Get/Set Properties of DataObject by index",
      "Get/Set Properties by Instance Properties",
      "Get/Set Properties of DataObject by Xpath",
      "isMany Properties","Containment",
      "Create Types using the SDO API",
      "Create Types using XML Schema",
      "Create Types using the Tuscany API",
      "Using Built-in Types",
      "Accessing values in a Sequence",
      "Generic data graph traversal",
      "Loading data from XML",
      "Saving data to XML",
      "Change Monitoring using a DataGraph",
      "Change Monitoring using a ChangeSummary Property on a DataObject",
      "Wrapping data graph in a DataGraph instance",
      "Open Content","Non-Containment",
      "Create XML Schema from Types",
      "Java Serialization of data graph",
      "Testing for Graph Equality"
    };
  }


  /*
   * keep a record of what's been said, so that if alternative terse text is
   * offered, the verbose text need not be repeated for repeat actions.
   */
  private static Set commentaryHistory = new HashSet();

  public SampleInfrastructure(Integer commentaryLevel) {
    this.commentaryLevel = commentaryLevel.intValue();
  }

  public SampleInfrastructure(Integer commentaryLevel, Integer sampLevel) {
    this.commentaryLevel = commentaryLevel.intValue();
    this.sampleComplexityLevel = sampLevel.intValue();
  }

  private static String hrule = "********************************************";

  /*
   * Constants which allow the sample program infrastructure to understand the
   * complexity of a sample program.
   */
  protected static final Integer SAMPLE_LEVEL_BASIC = new Integer(0);
  protected static final Integer SAMPLE_LEVEL_INTERMEDIATE = new Integer(1);
  protected static final Integer SAMPLE_LEVEL_ADVANCED = new Integer(2);

  /*
   * Constants which can be used to reduce the amount of information output by
   * an executing sample program.
   */
  protected static final Integer COMMENTARY_FOR_NOVICE = new Integer(0);
  protected static final Integer COMMENTARY_FOR_INTERMEDIATE = new Integer(1);
  protected static final Integer COMMENTARY_FOR_ADVANCED = new Integer(2);
  protected static final Integer COMMENTARY_ALWAYS = new Integer(3);

  protected static final String[] userLevels = { "novice", "intermediate",
      "advanced" };
  
  /*
   * Various constants that reference resources etc shared between the samples
   */
  public static final String COMPANY_DATAOBJECT_XML = "companyGenerated.xml";
  public static final String COMPANY_DATAGRAPH_XML = "companyDataGraphGenerated.xml";
  public static final String COMPANY_XSD = "company.xsd";
  public static final String COMPANY_NAMESPACE = "company.xsd";
  public static final String PO_NAMESPACE = "http://www.example.com/PO";
  public static final String PO_XML_GENERATED = "temporaryPoGenerated.xml";
  public static final String PO_XML_RESOURCE = "po.xml";
  public static final String PO_XSD_RESOURCE = "po.xsd";


  public void banner(char borderChar, String text) {
    if (text == null || text.length() == 0) {
      System.out.println(hrule);
      return;
    }
    String[] lines = text.split("\n");
    int maxlinelen = 0;

    for (int i = 0; i < lines.length; i++) {
      maxlinelen = lines[i].length() > maxlinelen ? lines[i].length()
          : maxlinelen;
    }

    StringBuffer buf = new StringBuffer();
    for (int p = 0; p < maxlinelen + 4; p++) {
      buf.append(borderChar);
    }
    buf.append("\n");
    for (int l = 0; l < lines.length; l++) {
      buf.append(borderChar).append(" ");
      buf.append(lines[l]);
      for (int rem = lines[l].length() + 2; rem < maxlinelen + 3; rem++)
        buf.append(" ");
      buf.append(borderChar).append("\n");
    }
    for (int p = 0; p < maxlinelen + 4; p++) {
      buf.append(borderChar);
    }
    buf.append("\n");
    System.out.println(buf.toString());
  }

  public void banner(String text) {
    banner('-', text);
  }
  
  protected void commentary(String text, String repeatText) {
    commentary(new Integer(sampleComplexityLevel), text, repeatText);
    
  }

  protected void commentary(Integer commentLevel, String text, String repeatText) {

    if (commentLevel.intValue() < commentaryLevel)
      return;

    if (repeatText != null) {
      boolean alreadySeen = commentaryHistory.contains(text);
      if (alreadySeen) {
        commentary(commentLevel, repeatText);
      } else {
        commentary(commentLevel, text);
        commentaryHistory.add(text);
      }
    } else {
      commentary(commentLevel, text);
    }

  }

  protected void commentary(Integer commentLevel, String text) {
    if (commentLevel.intValue() >= commentaryLevel) {
      banner(text);
    }
  }

  /*
   * convenience method to allow commentary level to default to that of the
   * sample's complexity
   */
  protected void commentary(String text) {
    commentary(new Integer(getSampleComplexityLevel()), text);
  }

  public void somethingUnexpectedHasHappened(Exception e) {
    banner(
        '!',
        "Something unexpected has gone wrong with the execution of this sample program\n"
            + "Please take a look at the exception and see if its something wrong with your environment\n"
            + "If you can't figure it out please send a note to the tuscany-user@ws.apache.org mailing list\n"
            + "including the text of the exception and any other useful information, thanks");

    e.printStackTrace();
  }

  /**
   * Utility method to obtain information from the user about whether or not
   * they would like to use a DataGraph or simply use a DataObject
   * 
   * @return whether or not a DataGraph should be used
   * @throws Exception
   */
  protected boolean yesOrNoFromUser(String question) throws Exception {

    System.out.print(question + " {y,n} :");
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String answer = in.readLine();
    while ((!answer.equalsIgnoreCase("n")) && (!answer.equalsIgnoreCase("y"))) {

      System.out.println();
      System.out.print("Sorry, please enter 'y' or 'n':");
      answer = in.readLine();
    }
    System.out.println();

    if (answer.equalsIgnoreCase("y")) {
      return true;
    } else {
      return false;
    }
  }

  public void run() {

    commentary(
        COMMENTARY_FOR_INTERMEDIATE,
        "Running with commentary level for a "
            + userLevels[commentaryLevel]
            + " user\n"
            + "Edit the sample program's constructor argument to one from\n"
            + "COMMENTARY_FOR_NOVICE\nCOMMENTARY_FOR_INTERMEDIATE or\nCOMMENTARY_FOR_ADVANCED\n"
            + "in order to alter the level of commentary you are seeing", "");

    commentary(COMMENTARY_ALWAYS, "    Tuscany SDO Java Sample "
        + this.getClass().getName() + "    \n"
        + "    This sample is aimed at a " + userLevels[sampleComplexityLevel]
        + " user");

    try {
      runSample();
    } catch (Exception e) {
      somethingUnexpectedHasHappened(e);
    } finally {
      commentary(COMMENTARY_ALWAYS, "    End of sample "
          + this.getClass().getName() + "    ");
    }
  }

  public abstract void runSample() throws Exception;

  public int getSampleComplexityLevel() {
    return sampleComplexityLevel;
  }

  public void setSampleComplexityLevel(Integer sampleComplexityLevel) {
    this.sampleComplexityLevel = sampleComplexityLevel.intValue();
  }

}
