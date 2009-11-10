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
package org.apache.tuscany.sdo.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import commonj.sdo.helper.XSDHelper;

import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.Type;
import commonj.sdo.helper.CopyHelper;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;

/**
 * This interface provides helper functions which are not included in the SDO specification itself.
 * Use of the functions in this interface is recommended, instead of resorting to low-level 
 * implementation-specific APIs.
 */
public interface SDOHelper
{
	final int UNBOUNDED = -1; //return value from getUpperBound() when maxOccurs="unbounded"
	final int UNSPECIFIED = -2; //return value from getUpperBound() for global property
	
  /**
   * Create a non-extensible HelperContext to provide access to a consistent set of Helpers which make use
   * of a new TypeHelper instance to provide scope for type definitions.
   * @return the new HelperContext
   * @see #createHelperContext(boolean)
   */
  public HelperContext createHelperContext();

  /**
   * Create a non-extensible HelperContext to provide access to a consistent set of Helpers which make use
   * of a new TypeHelper instance to provide scope for type definitions.
   * @param options Map of default XMLOptions
   * @return the new HelperContext
   * @see #createHelperContext(boolean)
   */
  public HelperContext createHelperContext(boolean extensibleNamespaces, Map options);
  
  /**
   * Create a HelperContext to provide access to a consistent set of Helpers which make use of a new
   * TypeHelper instance to provide scope for type definitions.
   * @param extensibleNamespaces true if the contents of a namespaces should be incrementally modifiable over time
   * @return the new HelperContext
   */
  public HelperContext createHelperContext(boolean extensibleNamespaces);
  
  /**
   * create a non-extensible HelperContext with default load/save options
   * @param options default load/save options from XMLOptions
   * @return the new HelperContext
   */
  public HelperContext createHelperContext(Map options);

  /**
   * Creates an instance of a data type from the specified string.
   * @param dataType a Type, for which isDataType() returns true, to instantiate.
   * @param literal the string value of the dataType.
   * @return an instance of the dataType.
   * @see #convertToString(Type, Object)
   */
  public Object createFromString(Type dataType, String literal);

  /**
   * Converts an instance of a data type to a string literal representation.
   * @param dataType the Type, for which isDataType() returns true, of the value to convert.
   * @param value a value of the dataType.
   * @return the string literal representation of the value.
   * @see #createFromString(Type, String)
   */
  public String convertToString(Type dataType, Object value);

  /**
   * Create a DataObject wrapper for an instance of the specified dataType.
   * This method is typically used to create a root object that can be passed to the XMLHelper.save() 
   * method when the root element to be serialized is an XMLSchema simpleType.
   * @param dataType a Type for which isDataType() returns true.
   * @param value the instance value.
   * @return a DataObject wrapper for the specified value.
   */
  public DataObject createDataTypeWrapper(Type dataType, Object value);

  /**
   * Get the SDO built-in type corresponding to the specified XSD type in the XML Schema
   * namespace ("http://www.w3.org/2001/XMLSchema").
   * @param xsdType a type name in the XML Schema namespace.
   * @return the SDO built-in Type corresponding to the specified XSD type.
   */
  public Type getXSDSDOType(String xsdType);

  /**
   * Gets the Sequence corresponding to the specified substitutable Property of the specified DataObject.
   * @param dataObject the data object.
   * @param head a substitution group head property.
   * @return the Sequence corresponding to the specified substitutable Property of the specified DataObject or
   *         null if the specified Property isn't a substitution head.
   */
  public Sequence getSubstitutionValues(DataObject dataObject, Property head);

  /**
   * Get the SDO built-in type corresponding to the specified Java instanceClass.
   * @param javaClass the Java instanceClass of the type.
   * @return the SDO built-in Type corresponding to the specified instanceClass.
   */
  public Type getJavaSDOType(Class javaClass);

  /**
   * Return whether at least one value is required for a valid instance of the specified property.
   * @param the property in question.
   * @return true if the property is required.
   */
  public boolean isRequired(Property property);

  /**
   * Return the upper bound of the specified property or -1 if unbounded.
   * @param the property in question.
   * @return the upper bound.
   */
  public int getUpperBound(Property property);

  /**
   * Return the lower bound of the specified property or 1 by default
   * @param the property in question.
   * @return the lower bound.
   */
  public int getLowerBound(Property property);
  
  /**
   * Return Enumeration facet 
   * @param type
   * @return List of enum facets in a Type
   *///Amita
  public List getEnumerationFacet(Type type);
  
  /**
   * Return Pattern facet 
   * @param type
   * @return List of pattern facets in a Type
   *///Amita
  public List getPatternFacet(Type type);

  /**
   * Returns whether the Property is many-valued given the specified context.
   * @param property The Property in question
   * @param context The context to check whether the specified Property is many-valued
   * @return true if the Property is many-valued given the specified context.
   */
  public boolean isMany(Property property, DataObject context);

  /**
   * Create an empty data graph.
   * @return the new data graph instance.
   */
  public DataGraph createDataGraph();

  /**
   * Set the root object of a data graph.
   * @param dataGraph the data graph in which to set the root object.
   * @param rootObject the root object.
   */
  public void setRootObject(DataGraph dataGraph, DataObject rootObject);

  /**
   * Load a serialized data graph from the specified insputStream.
   * 
   * @param inputStream the inputStream of the data graph.
   * @param options loader control options, or null.
   * @param hc the HelperContext in which to register deserialized Types and to find Types when
   *              creating DataObject instances, or null for default HelperContext.
   * @return the de-serialized data graph.
   * @throws IOException
   */
  public DataGraph loadDataGraph(InputStream inputStream, Map options, HelperContext hc) throws IOException;
  
  /**
   * Serialize the specified data graph to the specified outputStream.
   * @param dataGraph the data graph to save.
   * @param outputStream the outputStream for the data graph.
   * @param options serializer control options, or null.
   * @throws IOException
   */
  public void saveDataGraph(DataGraph dataGraph, OutputStream outputStream, Map options) throws IOException;

  /**
   * Registers the specified {@link Type type}(s) to be serialized along with
   * the {@link DataObject data object}(s) in the graph. For example, the list of types returned from 
   * {@link TypeHelper#define} can be registered with this method, allowing deserialization of
   * instances of a dynamically defined model.
   * @param dataGraph the DataGraph in which to register the specified type(s).
   * @param types a list containing the type(s) to be registered (TBD or null to automatically register all 
   * types used by the objects in the DataGraph).
   */
  public void registerDataGraphTypes(DataGraph dataGraph, List/*Type*/types);
  
  /**
   * Create a new cross scope CopyHelper.
   * @param hc the HelperContext containing the Types to use to create the copy objects.
   * @return the new CopyHelper.
   */
  public CopyHelper createCrossScopeCopyHelper(HelperContext targetScope);

  
  /**
   * Create a new XMLStreamHelper, with visibility to types in the specified HelperContext scope.
   * @param hc the HelperContext to use for locating types.
   * @return the new XMLStreamHelper.
   */
  public XMLStreamHelper createXMLStreamHelper(HelperContext hc);
  
  /**
   * Create a new ObjectInputStream in the specifice HelperContext scope.
   * @param inputStream the inputStream with which to create the ObjectInputStream.
   * @param helperContext the HelperContext scope.
   * @return the new ObjectInputStream.
   */
  public ObjectInputStream createObjectInputStream(InputStream inputStream, HelperContext helperContext) throws IOException;

  /**
   * Create a new ObjectOutputStream in the specifice HelperContext scope.
   * @param outputStream the outputStream with which to create the ObjectOutputStream.
   * @param helperContext the HelperContext scope.
   * @return the new ObjectOutputStream.
   */
  public ObjectOutputStream createObjectOutputStream(OutputStream outputStream, HelperContext helperContext) throws IOException;
  
  /**
   * Gets all of the types associated with a uri.
   * @param hc the HelperContext to use for locating types.
   * @param uri the URI of the Types
   * @return a List containing instances of Type, null if uri is not found.
   */
  public List getTypes(HelperContext hc, String uri);

  /**
   * Gets the open content subset of the specified DataObject's instance properties.
   * @param dataObject the DataObject instance
   * @return a List containing any open content properties of the DataObject
   */
  public List getOpenContentProperties(DataObject dataObject);

  /**
   * Return true if the specified type is a special DocumentRoot Type.
   * @param type the Type in question
   * @return true if type is a DocumentRoot
   */
  public boolean isDocumentRoot(Type type);
  
  /**
   * Return an XPath from the containment root to the specified DataObject.
   * @param dataObject a DataObject
   * @return the XPath from the containment root.
   */
  public String getXPath(DataObject dataObject);
  
  /**
   * Gets a MetaDataBuilder which can be used to programatically create SDO Types and Properties.
   * @return a MetaDataBuilder instance
   */
  public MetaDataBuilder getMetaDataBuilder();
  
  /**
   * An experimental interface,  subject to possible change that permits
   * registration of an event listener with a DataObject instance
   * @param dob DataObject
   * @param listener EventListener
   */
  public void addChangeListener(DataObject dob, EventListener listener);

  /**
   * An experimental interface,  subject to possible change that permits
   * deregistration of an event listener with a DataObject instance
   * @param dob DataObject
   * @param listener EventListener
   */
  public void removeChangeListener(DataObject dob, EventListener listener);

  /**
   * This interface provides methods which can be used to programatically create SDO Types and Properties.
   * It provides a lower level and more efficient API then the DataObject-based one of TypeHelper.define().
   */
 
  public interface MetaDataBuilder
  {

    /**
     * Create a Type in the specified TypeHelper scope.
     * @return the new Type.
     */
    public Type createType(HelperContext hc, String uri, String name, boolean isDataType);

    /**
     * Add a baseType to the specified type.
     */
    public void addBaseType(Type type, Type baseType);

    /**
     * Add an aliasName to the specified type.
     */
    public void addAliasName(Type type, String aliasName);

    /**
     * Set the isOpen value of the specified type.
     */
    public void setOpen(Type type, boolean isOpen);

    /**
     * Set the isSequenced value of the specified type.
     */
    public void setSequenced(Type type, boolean isSequenced);

    /**
     * Set the isAbstract value of the specified type.
     */
    public void setAbstract(Type type, boolean isAbstract);

    /**
     * Set the isAbstract value of the specified type.
     */
    public void setJavaClassName(Type type, String javaClassName);

    /**
     * Create a new property in the specified containingType.
     */
    public Property createProperty(Type containingType, String name, Type propertyType);

    /**
     * Set a SDO property to become an XSD element or attribute
     */
    public void setPropertyXMLKind(Property property, boolean isXmlElement);

    /**
     * Create a new open content property in the specified TypeHelper scope.
     */
    public Property createOpenContentProperty(HelperContext hc, String uri, String name, Type type);

    /**
     * Add an aliasName to the specified property.
     */
    public void addAliasName(Property property, String aliasName);

    /**
     * Set the isMany value of the specified property.
     */
    public void setMany(Property property, boolean isMany);

    /**
     * Set the isContainment value of the specified property.
     */
    public void setContainment(Property property, boolean isContainment);

    /**
     * Set the default value of the specified property.
     */
    public void setDefault(Property property, String defaultValue);

    /**
     * Set the isReadOnly value of the specified property.
     */
    public void setReadOnly(Property property, boolean isReadOnly);

    /**
     * Set the opposite value of the specified property.
     */
    public void setOpposite(Property property, Property opposite);

    /**
     * Add an instance property to the specified type.
     */
    public void addTypeInstanceProperty(Type definedType, Property instanceProperty, Object value);

    /**
     * Add anf instance property to the specified property.
     */
    public void addPropertyInstanceProperty(Property definedProperty, Property instanceProperty, Object value);
  }

  /**
   * This interface contains options that can be passed to the XMLHelper load() and save() methods.
   */
  public interface XMLOptions
  {
    /**
     * Line Break String such as "\n", "\r\n", "\r" and "", absence/null is the default (line.separator System Property)
     */
    final String XML_SAVE_LINE_BREAK = "LineBreak";

    /**
     * Indent String such as "\t", "", etc. absence/null is the default ("  ")
     */
    final String XML_SAVE_INDENT = "indent";

    /**
     * Margin String such as " ", "\t\t", etc. Absence/null/"" is the default (no margin)
     */
    final String XML_SAVE_MARGIN = "margin";

    /**
     * Attribute formatting that exceeds the specified width as Integer will cause a line break so that formatting will continue indented on the next line
     */
    final String XML_SAVE_LINE_WIDTH = "LINE_WIDTH";

    /**
     * Boolean to save a doctype declaration 
     */
    final String XML_SAVE_DOCTYPE = "SAVE_DOCTYPE";

    /**
     * Boolean to process the schemaLocation/noNamespaceSchemaLocation attributes occurring in the instance document to {@link XSDHelper#define convert XSD(s) to Types} 
     */
    final String XML_LOAD_SCHEMA = "ProcessSchemaLocations";

    /**
     * To tolerate malformed elements and attributes (default unless set by System property XML.load.form.lax). 0 not to.  
     */
    final String XML_LOAD_LAX_FORM = "load malform";
    
    /**
     * Allows you to record unknown features during deserialization/loading. 
     * The default is Boolean.FALSE unless set to Boolean.TRUE explicitly. 
     */
    final String XML_LOAD_UNKNOWN_PROPERTIES = "load unknown properties";
  }

}
