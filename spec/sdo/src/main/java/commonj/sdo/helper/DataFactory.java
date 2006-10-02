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

import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.impl.HelperProvider;

/**
 * A Factory for creating DataObjects.  
 * The created DataObjects are not connected to any other DataObjects.
 */
public interface DataFactory
{
  /**
   * Create a DataObject of the Type specified by typeName with the given package uri.
   * @param uri The uri of the Type.
   * @param typeName The name of the Type.
   * @return the created DataObject.
   * @throws IllegalArgumentException if the uri and typeName does
   *   not correspond to a Type this factory can instantiate.
   */
  DataObject create(String uri, String typeName);
  
  /**
   * Create a DataObject supporting the given interface.
   * InterfaceClass is the interface for the DataObject's Type.
   * The DataObject created is an instance of the interfaceClass.
   * @param interfaceClass is the interface for the DataObject's Type.
   * @return the created DataObject.
   * @throws IllegalArgumentException if the instanceClass does
   *   not correspond to a Type this factory can instantiate.
   */
  DataObject create(Class interfaceClass);
  
  /**
   * Create a DataObject of the Type specified.
   * @param type The Type.
   * @return the created DataObject.
   * @throws IllegalArgumentException if the Type
   *   cannot be instantiaed by this factory.
   */
  DataObject create(Type type);
  
  /**
   * The default DataFactory.
   */
  DataFactory INSTANCE = HelperProvider.getDataFactory();
 
}
