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
   * The default TypeHelper.
   */
  TypeHelper INSTANCE = HelperProvider.getTypeHelper();
}
