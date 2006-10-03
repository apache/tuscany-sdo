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

package commonj.sdo;

import java.util.List;

/**
 * A representation of a Property in the {@link Type type} of a {@link DataObject data object}.
 */
public interface Property
{
  /**
   * Returns the name of the Property.
   * @return the Property name.
   */
  String getName();
  
  /**
   * Returns the type of the Property.
   * @return the Property type.
   */
  Type getType();
  
  /**
   * Returns whether the Property is many-valued.
   * @return <code>true</code> if the Property is many-valued.
   */
  boolean isMany();
  
  /**
   * Returns whether the Property is containment, i.e., whether it represents by-value composition.
   * @return <code>true</code> if the Property is containment.
   */
  boolean isContainment();
  
  /**
   * Returns the containing type of this Property.
   * @return the Property's containing type.
   * @see Type#getProperties()
   */
  Type getContainingType();

  /**
   * Returns the default value this Property will have in a {@link DataObject data object} where the Property hasn't been set.
   * @return the default value.
   */
  Object getDefault();

  /**
   * Returns true if values for this Property cannot be modified using the SDO APIs.
   * When true, DataObject.set(Property property, Object value) throws an exception.
   * Values may change due to other factors, such as services operating on DataObjects.
   * @return true if values for this Property cannot be modified.
   */
  boolean isReadOnly();

  /**
   * Returns the opposite Property if the Property is bi-directional or null otherwise.
   * @return the opposite Property if the Property is bi-directional or null
   */
  Property getOpposite();

  /**
   * Return a list of alias names for this Property.
   * @return a list of alias names for this Property.
   */
  List /*String*/ getAliasNames();
}
