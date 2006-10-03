/**
 * <copyright>
 *
 * Service Data Objects
 * Version 2.0
 * Licensed Materials - Property of BEA and IBM
 *
 * (c) Copyright BEA Systems, Inc. and International Business Machines Corp 2005.  All rights reserved.
 *
 * </copyright>
 * 
 */

package commonj.sdo.helper;

import java.util.List;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;
import commonj.sdo.impl.HelperProvider;

/**
 * Look up a Type given the uri and typeName or interfaceClass.
 * SDO Types are available through the
 *   getType("commonj.sdo", typeName) method.
 * Defines Types from DataObjects.
 */
public interface TypeHelper
{
  /**
   * Return the Type specified by typeName with the given uri,
   *   or null if not found.
   * @param uri The uri of the Type - type.getURI();
   * @param typeName The name of the Type - type.getName();
   * @return the Type specified by typeName with the given uri,
   *   or null if not found.
   */
  Type getType(String uri, String typeName);
  
  /**
   * Return the Type for this interfaceClass or null if not found.
   * @param interfaceClass is the interface for the DataObject's Type -  
   *   type.getInstanceClass();
   * @return the Type for this interfaceClass or null if not found.
   */
  Type getType(Class interfaceClass);
  
  /**
   * Define the DataObject as a Type.
   * The Type is available through TypeHelper and DataGraph getType() methods.
   * @param type the DataObject representing the Type.
   * @return the defined Type.
   * @throws IllegalArgumentException if the Type could not be defined.
   */
  Type define(DataObject type);

  /**
   * Define the list of DataObjects as Types.
   * The Types are available through TypeHelper and DataGraph getType() methods.
   * @param types a List of DataObjects representing the Types.
   * @return the defined Types.
   * @throws IllegalArgumentException if the Types could not be defined.
   */
  List /*Type*/ define(List /*DataObject*/ types);

  /**
   * Define the DataObject as a Property for setting open content.
   * The containing Type of the open content property is not specified by SDO.
   * If the specified uri is not null the defined property is accessible through
   * TypeHelper.getOpenContentProperty(uri, propertyName).
   * If a null uri is specified, the location and management of the open content property
   * is not specified by SDO.
   * @param uri the namespace URI of the open content Property or null.
   * @return the defined open content Property.
   * @throws IllegalArgumentException if the Property could not be defined.
   * 
   * NOTE: this is an early addition of an SDO 2.1 feature.
   */
  public Property defineOpenContentProperty(String uri, DataObject property);
  
  /**
   * Get the open content Property with the specified uri and name, or null if 
   * not found.
   * @param uri the namespace URI of the open content Property.
   * @param propertyName the name of the open content Property.
   * @return the global Property.
   * 
   * NOTE: this is an early addition of an SDO 2.1 feature.
   */
  public Property getOpenContentProperty(String uri, String propertyName);
  
    /**
   * The default TypeHelper.
   */
  TypeHelper INSTANCE = HelperProvider.getTypeHelper();
}
