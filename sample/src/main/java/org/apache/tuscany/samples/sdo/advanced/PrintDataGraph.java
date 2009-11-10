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
package org.apache.tuscany.samples.sdo.advanced;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.apache.tuscany.samples.sdo.SampleBase;
import org.apache.tuscany.samples.sdo.internal.SampleInfrastructure;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.Type;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XSDHelper;
import commonj.sdo.impl.HelperProvider;

/**
 * 
 * This sample program traverses data graphs and builds up a text representation of the
 * data graph. As it traverses a graph it outputs commentary to the console
 * about what it has encountered and how it intends to process what it finds. At
 * the end of each traversal the text representation of the graph is printed to
 * the console.
 * <p>
 * <h3>Running this Sample</h3> See <A HREF="../../../../../../index.html" 
 * target="_top">the main overview</A> for instructions on how to run this 
 * sample.
 */
public class PrintDataGraph extends SampleBase {

  StringBuffer buf = null;
  HelperContext scope = HelperProvider.getDefaultContext();

  private int indent;

  private int indentIncrement = 2;

  public PrintDataGraph(Integer userLevel) {
    super(userLevel, SAMPLE_LEVEL_ADVANCED);
    buf = new StringBuffer();
  }

  public static void main(String[] args) {
    PrintDataGraph sample = new PrintDataGraph(COMMENTARY_FOR_NOVICE);
    sample.run();
  }
  
  /*
   *  metadata for the sample documenting the areas of SDO that are explored
   */
  public static int [] CORE_FUNCTION = {
    SDOFacets.GENERIC_DATA_GRAPH_TRAVERSAL
  };

  public static int [] SIGNIFICANT_FUNCTION = {
    SDOFacets.GET_SET_PROPERTIES_BY_INSTANCE_PROPERTIES,
    SDOFacets.ISMANY_PROPERTIES,
    SDOFacets.CREATE_TYPES_USING_THE_SDO_API,
    SDOFacets.ACCESSING_VALUES_IN_A_SEQUENCE,
    SDOFacets.NON_CONTAINMENT
  };
  
  public void runSample() throws Exception {
    commentary("This sample demonstrates a common pattern of traversing a data graph\n"
        + "and printing the values of its Properties.  As the sample traverses a couple of\n"
        + "graphs it provides commentary about what it has found and what actions it\n"
        + "is taking, whilst building up a text representation of the graph. It then\n"
        + "shows you the results of its labours.");

    HelperContext scope = createScopeForTypes();

    commentary(
        COMMENTARY_ALWAYS,
        "First we look at a data graph of a Purchase Order which has a fairly simple XML schema\n"
            + "and the graph's containment hierarchy has a couple of levels of depth");

    loadTypesFromXMLSchemaFile(scope, SampleInfrastructure.PO_XSD_RESOURCE);

    XMLDocument purchaseOrder = getXMLDocumentFromFile(scope,
        SampleInfrastructure.PO_XML_RESOURCE);

    printXMLDocument(purchaseOrder);

    commentary(COMMENTARY_ALWAYS,
        "And here is the resultant view of the data graph\n\n");
    System.out.println(getBuf().toString());

    commentary(COMMENTARY_ALWAYS,
        "Next we look at a graph representing a form letter,  where the Type of the\n"
            + "root data object is 'Sequenced'");

    loadTypesFromXMLSchemaFile(scope, "letter.xsd");
    DataObject letter = getDataObjectFromFile(scope, "letter.xml");

    reset();
    print(letter);

    commentary(COMMENTARY_ALWAYS,
        "And here is the resultant view of the data graph\n\n");

    System.out.println(getBuf().toString());

  }

  public void reset() {
    indent = 0;
    buf = new StringBuffer();
  }

  /*
   * a convenience method allowing untyped access to the print function for
   * selected SDO artifacts
   */
  public void print(Object sdoObject) throws Exception {

    if (sdoObject instanceof XMLDocument) {
      printXMLDocument((XMLDocument) sdoObject);
    } else if (sdoObject instanceof DataObject) {
      printDataObject((DataObject) sdoObject);
    }

  }

  public void printXMLDocument(XMLDocument xmlDocument) {

    commentary(
        COMMENTARY_FOR_NOVICE,
        "We are going to traverse a data graph that has been wrapped in an instance of XMLDocument\n"
            + "Amongst other things, the XMLDocument instance provides access to the root element name\n"
            + "and the root DataObject of the data graph.\n\n"
            + "xmlDocument.getRootElementName();\n"
            + "xmlDocument.getRootObject();",

        "Accessing another graph via an XMLDocument instance as we saw previously ...\n"
            + "xmlDocument.getRootElementName();\n"
            + "xmlDocument.getRootObject();");

    buf.append("XMLDocument: ").append(xmlDocument.getRootElementName());
    lineBreak();
    incrementIndent();
    printDataObject(xmlDocument.getRootObject());
    decrementIndent();
  }

  public void printDataObject(DataObject dataObject) {

    if (dataObject.getContainer() == null) {
      commentary(
          COMMENTARY_FOR_NOVICE,
          "We begin traversing the data graph by examining the root object of the graph's containment hierarchy,\n"
              + "making a record of the values of its Properties. As we inspect the values of the Properties of this object\n"
              + "if we encounter contained DataObjects, then we will recurs through the containment hierarchy of the\n"
              + "data graph in a depth first fashion, and create a text representation of the graph that we'll print\n"
              + "out after the graph traversal has been completed.",

          "We are beginning to traverse another data graph from its root object, in the same way that we saw previously");
    } else {
      commentary(
          COMMENTARY_FOR_NOVICE,
          "We have arrived at a contained dataObject in the graph, and will inspect its Property values,\n"
              + "recursing deeper if necessary",

          "Inspecting another contained dataObject");
    }

    lineBreak();
    indent();
    buf.append("DataObject: ");
    Type type = dataObject.getType();
    buf.append("Type: ").append(type.getURI()).append('#').append(
        type.getName());
    lineBreak();

    if (dataObject.getType().isSequenced()) {

      commentary(
          COMMENTARY_FOR_INTERMEDIATE,
          "We've encountered a DataObject in the graph for which the Type is 'Sequenced'\n"
              + "That is to say that the order of addition of Property values to the DataObject instance\n"
              + "is important,  and is preserved by the DataObject\n\n"
              + "dataObject.getType().isSequenced();",

          "We've encountered another sequenced DataObject instance, and so will traverse the Property\n"
              + "values in the order preerved by the instance, as we saw before\n\n"
              + "dataObject.getType().isSequenced();");
      
      commentary(
          "There's a subtlety here which we must deal with if this sample code is to\n" +
      		"handle both Type systems that derive from XML schema, and those that come from elsewhere,\n" +
      		"e.g. using the SDO API.  If a Sequenced DataObject has a Type that comes from XML schema\n" +
      		"then its Properties that derive from XML attributes are not ordered, whereas those that\n" +
      		"derive from XML elements are ordered.  The SDO specification doesn't say whether\n" +
      		"the attribute related Properties should appear at the start of a Sequence or not.\n" +
      		"Currently in Tuscany we leave them out of the Sequence;  other SDO implementations may\n" +
      		"include the XML attributes in the Sequence.  This sample code is written to deal with\n" +
      		"either approach\n." +
      		"We use the XSDHelper.isAttribute(Property) and isElement(Property) methods to distinguish\n" +
      		"between the two kinds of Property",
      		
      		"Examining the xml attributes and elements of a Sequenced DataObject again."
      		);
      
      XSDHelper xsdHelper = getScope().getXSDHelper();
      incrementIndent();
      for(Iterator it=dataObject.getInstanceProperties().iterator(); it.hasNext();) {
        Property property = (Property)it.next();
        if (xsdHelper.isAttribute(property)) {
          indent();
          buf.append("Property (XML Attribute): ").append(property.getName()).append(" - ").append(dataObject.get(property));
          lineBreak();
        }

      }
      decrementIndent();
      Sequence seq = dataObject.getSequence();

      commentary(
          "The Property/Value pairs of a Sequence can be accessed via the getProperty(int) and getValue(int)\n"
              + "accessor methods of the Sequence interface.  The size() method of the Sequence tells us how many there are.\n"
              + "If the getProperty(int) method returns null,  then the value is text.  These text values may be encountered\n"
              + "when the DataObject's type is 'mixed' (dataObject.getType().isMixed() == true). A typical example of this\n"
              + "is when the data graph represents a form letter.",
      
          "Inspecting the Property/Value pairs of another Sequence");
      
      incrementIndent();
      indent();
      buf.append("Sequence: {\n");
      
      incrementIndent();
      for (int i = 0; i < seq.size(); i++) {
        Property p = seq.getProperty(i);
        if (p == null) {
          indent();
          buf.append("text: ").append(seq.getValue(i));
          lineBreak();
        } else if(!xsdHelper.isAttribute(p)){
          printPropertyValuePair(p, seq.getValue(i));
       }
      }
      decrementIndent();
      
      indent();
      buf.append("}\n");
      decrementIndent();

    } else {
      incrementIndent();

      commentary(
          COMMENTARY_FOR_INTERMEDIATE,
          "We access the Property values of this DataObject by first getting the list of 'Instance Properties'\n"
              + "from the DataObject.  For many DataObjects, this will be the same set of Properties that are defined\n"
              + "by the DataObject's Type.  However, if the DataObject's type is 'Open' then an instance of that Type\n"
              + "may contain more Properties than the type itself.  The list of Instance Properties will always include\n"
              + "the Properties defined in the Type,  but will also include any Properties that the instance has values for\n"
              + "by virtue of it's type being 'Open'\n\n"
              + "for (int i = 0; i < dataObject.getInstanceProperties().size(); i++) {\n"
              + "  Property p = (Property) dataObject.getInstanceProperties().get(i);",

          "Traversing the instance Properties of this DataObject\n"
              + "for (int i = 0; i < dataObject.getInstanceProperties().size(); i++) {\n"
              + "  Property p = (Property) dataObject.getInstanceProperties().get(i);"

      );

      for (int i = 0; i < dataObject.getInstanceProperties().size(); i++) {
        Property p = (Property) dataObject.getInstanceProperties().get(i);
        indent();
        printValueOfProperty(dataObject, p);
      }

      decrementIndent();
    }

  }





  private void printPropertyValuePair(Property p, Object value) {

    indent();
    buf.append("Property: ").append(p.getName()).append(": ");
    if(p.getType().isDataType()) {
      printSimpleValue(value);
      lineBreak();
    } else {
      if(p.isContainment()) {
        incrementIndent();
        printDataObject((DataObject)value);
        decrementIndent();
      } else {
        printReferencedDataObject((DataObject)value);
      }
    }

    
  }

  private void printValueOfProperty(DataObject dataObject, Property p) {

    commentary(
        COMMENTARY_FOR_INTERMEDIATE,
        "We are about to inspect the value of a Property,  but we must\n"
            + "consider the nature of that Property in order to deal with it appropriately.\n"
            + "Firstly we see if the Property value has been set (dataObject.isSet(property))\n"
            + "Then we see if the Property is simple valued (property.isDataType() == true)\n"
            + "--if not then we know it's a DataObject and we must recurs deeper into the graph's\n"
            + "containment hierarchy\n"
            + "Whether or not the property value is a DataObject,  is may be single or multi-valued\n"
            + "so we must either use one of the DataObject's get*(Property) accessors for single\n"
            + "valued Properties or the getList() method for multi-valued properties.\n"
            + "Another thing we must deal with when the Property is a DataObject, is whether or not the\n"
            + "Property is a 'containment' Property.  If it isn't, then here we simply record the fact that\n"
            + "we have encountered this non-containment relationship,  and move on to the next Property",

        "Inspecting another property to determine how to access its value,  as we saw before");

    // TODO deal with nullable

    buf.append("Property ").append(p.getName()).append(": ").append(" - ");

    if (dataObject.isSet(p)) {
      if (p.getType().isDataType()) {
        if (p.isMany()) {
          printSimpleValues(dataObject.getList(p));
        } else {
          printSimpleValue(dataObject.get(p));
        }
      } else {
        if (p.isContainment()) {
          incrementIndent();
          if (p.isMany()) {
            printDataObjects(dataObject.getList(p));
          } else {
            printDataObject(dataObject.getDataObject(p));
          }
          decrementIndent();
        } else {
          if (p.isMany()) {
            printReferencedDataObjects(dataObject.getList(p));
          } else {
            printReferencedDataObject(dataObject.getDataObject(p));
          }
        }
      }
    } else {
      buf.append(" is not set");
    }

    lineBreak();

  }

  private void printReferencedDataObject(DataObject dataObject) {

    commentary(
        COMMENTARY_FOR_INTERMEDIATE,
        "We have encounted a non-containment reference to a DataObject, and so\n"
            + "we know that this DataObject will be fully inspected when encountered by the\n"
            + "traversal of the data graph's containment hierarchy.\n"
            + "We therefore record the fact that this association has been encountered by\n"
            + "establishing the path from the root object of the data graph to the referenced\n"
            + "DataObject",

        "Recording the fact that we have encountered another non-containment reference");

    List path = new ArrayList();
    DataObject current = dataObject;
    while (current != null) {
      Property containmentProperty = current.getContainmentProperty();
      if(containmentProperty != null) {
        if(containmentProperty.isMany()) {
          List pValues = current.getContainer().getList(containmentProperty);
          int index = pValues.indexOf(current)+1;
          path.add("["+index+"]");
        }
        path.add("/"+current.getContainmentProperty().getName());
      }
      current = current.getContainer();
    }
    buf.append("reference to: ");
    for (ListIterator i = path.listIterator(path.size()); i.hasPrevious();) {
      buf.append(i.previous());
    }
  }

  private void printReferencedDataObjects(List list) {

    commentary(
        COMMENTARY_FOR_NOVICE,
        "Traversing a list of DataObjects which represent the values of a multi-valued non-containment Property");

    indent();
    buf.append('[');
    for (Iterator i = list.iterator(); i.hasNext();) {
      printReferencedDataObject((DataObject) i.next());
    }
    indent();
    buf.append(']');
  }

  private void printDataObjects(List list) {

    commentary(
        COMMENTARY_FOR_NOVICE,
        "Traversing a list of DataObjects which represent the values of a multi-valued containment Property");


    lineBreak();
    indent();
    buf.append("[");
    incrementIndent();
    for (Iterator i = list.iterator(); i.hasNext();) {
      printDataObject((DataObject) i.next());
    }
    decrementIndent();
    indent();
    buf.append(']');
  }

  private void printSimpleValue(Object object) {
    buf.append(object);
  }

  private void printSimpleValues(List values) {
    buf.append('[');
    for (Iterator i = values.iterator(); i.hasNext();) {
      printSimpleValue(i.next());
      if (i.hasNext()) {
        buf.append(',');
      }
    }
    buf.append(']');

  }

  private void decrementIndent() {
    indent -= indentIncrement;

  }

  private void incrementIndent() {
    indent += indentIncrement;

  }

  private void indent() {
    for (int i = 0; i < indent; i++) {
      buf.append(' ');
    }
  }

  private void lineBreak() {
    buf.append('\n');
  }

  public StringBuffer getBuf() {
    return buf;
  }

  public void setBuf(StringBuffer b) {
    buf = b;
  }

  public HelperContext getScope() {
    return scope;
  }

  public void setScope(HelperContext scope) {
    this.scope = scope;
  }

}
