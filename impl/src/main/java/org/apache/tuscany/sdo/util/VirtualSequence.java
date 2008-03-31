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
package org.apache.tuscany.sdo.util;

import java.util.Iterator;
import java.util.List;

import org.apache.tuscany.sdo.impl.ClassImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Sequence;

/**
 *  SDO Sequance implementation which delegates to a Collection of DataObject properties.
 */
public class VirtualSequence implements Sequence
{
  private final DataObject dataObject;
  protected final List delegateProperties; // size > 1

  public VirtualSequence(DataObject object)
  {
    dataObject = object;
    delegateProperties = ((ClassImpl)dataObject.getType()).getVirtualSequenceProperties();
  }
  
  static protected boolean isSequenceProperty(Object property)
  {
    return FeatureMapUtil.isFeatureMap((EStructuralFeature)property);
  }
  
  public int size()
  {
    int size = 0;
    for (Iterator iterator = delegateProperties.iterator() ; iterator.hasNext() ;)
    {
      Property property = (Property)iterator.next();
      if (dataObject.isSet(property))
        if (isSequenceProperty(property))
          size += ((Sequence)dataObject.get(property)).size();
        else if (property.isMany())
          size += dataObject.getList(property).size();
        else
          ++size;
    }
    return size;
  }

  public Property getProperty(int index)
  {
    for (Iterator iterator = delegateProperties.iterator() ; iterator.hasNext() ;)
    {
      Property property = (Property)iterator.next();
      if (dataObject.isSet(property))
        if (isSequenceProperty(property))
        {
          Sequence sequence = (Sequence)dataObject.get(property);
          int size = sequence.size();
          if (index < size)
            return sequence.getProperty(index);
          index -= size;
        }
        else if (property.isMany())
        {
          int size = dataObject.getList(property).size();
          if (index < size)
            return property;
          index -= size;
        }
        else if (index == 0)
          return property;
        else
          --index;
    }
    throw new IndexOutOfBoundsException();
  }

  public Object getValue(int index)
  {
    for (Iterator iterator = delegateProperties.iterator() ; iterator.hasNext() ;)
    {
      Property property = (Property)iterator.next();
      if (dataObject.isSet(property))
        if (isSequenceProperty(property))
        {
          Sequence sequence = (Sequence)dataObject.get(property);
          int size = sequence.size();
          if (index < size)
            return sequence.getValue(index);
          index -= size;
        }
        else if (property.isMany())
        {
          List values = dataObject.getList(property);
          int size = values.size();
          if (index < size)
            return values.get(index);
          index -= size;
        }
        else if (index == 0)
          return dataObject.get(property);
        else
          --index;
    }
    throw new IndexOutOfBoundsException();
  }

  public Object setValue(int index, Object value)
  {
    for (Iterator iterator = delegateProperties.iterator() ; iterator.hasNext() ;)
    {
      Property property = (Property)iterator.next();
      if (dataObject.isSet(property))
        if (isSequenceProperty(property))
        {
          Sequence sequence = (Sequence)dataObject.get(property);
          int size = sequence.size();
          if (index < size)
            return sequence.setValue(index, value);
          index -= size;
        }
        else if (property.isMany())
        {
          List values = dataObject.getList(property);
          int size = values.size();
          if (index < size)
            return values.set(index, value);
          index -= size;
        }
        else if (index == 0)
        {
          Object old = dataObject.get(property);  
          dataObject.set(property, value);
          return old;
        }
        else
          --index;
    }
    throw new IndexOutOfBoundsException();
  }
  
  boolean validate(EStructuralFeature feature, Object property)
  {
    return FeatureMapUtil.getValidator((EClass)dataObject.getType(), feature).isValid((EStructuralFeature)property);
  }

  boolean append(Property delegateProperty, Property property, Object value)
  {
    return ((Sequence)dataObject.get(delegateProperty)).add(property, value);
  }
  
  boolean append(Property property, Object value)
  {
    return dataObject.getList(property).add(value);
  }
  
  boolean set(Property property, Object value)
  {
    if (property.isMany())
      return append(property, value);
    dataObject.set(property, value);
    return true;
  }
  
  public final boolean add(Property p, Object value)
  {
    Property property;
    int size = delegateProperties.size(), index = size;
    do
    {
      property = (Property)delegateProperties.get(--index);
      if (!dataObject.isSet(property))
        continue;
      EStructuralFeature feature = (EStructuralFeature)property;
      if (FeatureMapUtil.isFeatureMap(feature))
      {
        if (validate(feature, p))
          return append(property, p, value);
      }
      else if (property == p && property.isMany())
        return append(property, value);
      if (size == ++index)
        return false;
      property = (Property)delegateProperties.get(index);
      break;
    }
    while (index != 0);
    for (;;)
    {
      EStructuralFeature feature = (EStructuralFeature)property;
      if (FeatureMapUtil.isFeatureMap(feature))
      {
        if (validate(feature, p))
          return append(property, p, value);
      }
      else if (property == p)
        return set(p, value);
      if (size == ++index)
        return false;
      property = (Property)delegateProperties.get(index);
    }
  }

  protected final Property property(String name)
  {
    return dataObject.getType().getProperty(name);
  }

  public boolean add(String propertyName, Object value)
  {
    return add(property(propertyName), value);
  }

  protected final Property property(int index)
  {
    return (Property)dataObject.getType().getProperties().get(index);
  }

  public boolean add(int propertyIndex, Object value)
  {
    return add(property(propertyIndex), value);
  }
  
  void insert(Property property, Property p, Object value)
  {
    ((Sequence)dataObject.get(property)).add(0, p, value);
  }
  
  void insert(Property property, Object value)
  {
    dataObject.getList(property).add(0, value);
  }
  
  protected final int insert(Iterator iterator, Property p, Object value)
  {
    while (iterator.hasNext())
    {
      Property property = (Property)iterator.next();
      EStructuralFeature feature = (EStructuralFeature)property;
      if (dataObject.isSet(property))
      {
        if (FeatureMapUtil.isFeatureMap(feature))
        {
          if (!validate(feature, p))
            return 2;
          insert(property, p, value);
          return 0;
        }
        if (property != p || !property.isMany())
          return 2;
        insert(property, value);
        return 0;
      }
      if (FeatureMapUtil.isFeatureMap(feature))
      {
        if (validate(feature, p))
        {
          append(property, p, value);
          return 0;
        }
      }
      else if (property == p)
      {
        set(property, value);
        return 0;
      }
    } // iterator.hasNext()
    return 1;
  }
  
  public final void add(int index, Property p, Object value)
  {
    Iterator iterator = delegateProperties.iterator();
    if (index == 0)
      switch (insert(iterator, p, value))
      {
        case 0:
          return;
        case 1:  
          throw new IndexOutOfBoundsException();
        default: // 2  
          throw new IllegalArgumentException();
      }
    while (iterator.hasNext())
    {
      Property property = (Property)iterator.next();
      if (dataObject.isSet(property))
        if (isSequenceProperty(property))
        {
          Sequence sequence = (Sequence)dataObject.get(property);
          int size = sequence.size();
          if (index < size)
          {
            sequence.add(index, p, value);
            return;
          }
          index -= size;
          if (index != 0)
            continue;
          if (insert(iterator, p, value) != 0)
            /*assert */sequence.add(p, value);
          return;
        } // sequence(property)
        else if (property.isMany())
        {
          List values = dataObject.getList(property);
          int size = values.size();
          if (index < size)
          {
            values.add(index, value);
            return;
          }
          index -= size;
          if (index == 0 && property == p)
          {
            values.add(value);
            return;
          }
        }
        else if (index == 0)
          throw new IllegalArgumentException();
        else
          --index;
    }
    throw new IndexOutOfBoundsException();
  }

  public void add(int index, String propertyName, Object value)
  {
    add(index, property(propertyName), value);
  }

  public void add(int index, int propertyIndex, Object value)
  {
    add(index, property(propertyIndex), value);
  }

  public final void addText(String text)
  {
    throw new IllegalArgumentException();
  }

  /**
   * @deprecated
   */
  public void add(String text)
  {
    addText(text);
  }

  public final void addText(int index, String text)
  {
    throw new IllegalArgumentException();
  }

  /**
   * @deprecated
   */
  public void add(int index, String text)
  {
    addText(index, text);
  }

  public void remove(int index)
  {
    for (Iterator iterator = delegateProperties.iterator() ; iterator.hasNext() ;)
    {
      Property property = (Property)iterator.next();
      if (dataObject.isSet(property))
        if (isSequenceProperty(property))
        {
          Sequence sequence = (Sequence)dataObject.get(property);
          int size = sequence.size();
          if (index < size)
          {
            sequence.remove(index);
            return;
          }
          index -= size;
        }
        else if (property.isMany())
        {
          List values = dataObject.getList(property);
          int size = values.size();
          if (index < size)
          {
            values.remove(index);
            return;
          }
          index -= size;
        }
        else if (index == 0)
        {
          dataObject.unset(property);
          return;
        }
        else
          --index;
    }
    throw new IndexOutOfBoundsException();
  }

  static private Object remove(Sequence sequence, int index)
  {
    Object value = sequence.getValue(index);
    sequence.remove(index);
    return value;
  }
  
  static void move(Sequence fromSequence, int fromIndex, Sequence toSequence, int toIndex, Property property)
  {
    toSequence.add(toIndex, property, remove(fromSequence, fromIndex)); // removes containment
  }
  
  static protected void move(Sequence fromSequence, int fromIndex, Sequence toSequence, int toIndex)
  {
    move(fromSequence, fromIndex, toSequence, toIndex, fromSequence.getProperty(fromIndex));
  }
  
  static protected void add(Object value,List list,int index, int size)
  {
    if (++index == size)
      /*assert */list.add(value);
    else
      list.add(index, value); // removes containment
  }
  
  static protected void add(Property property, Object value, Sequence toSequence, int toIndex, int size)
  {
    if (++toIndex == size)
      toSequence.add(property, value); // removes containment
    else
      toSequence.add(toIndex, property, value); // removes containment
  }
  
  public void move(int toIndex, int fromIndex)
  {
    for (Iterator iterator = delegateProperties.iterator(); iterator.hasNext() ;)
    {
      Property property = (Property)iterator.next();
      if (dataObject.isSet(property))
        if (isSequenceProperty(property))
        {
          Sequence sequence = (Sequence)dataObject.get(property);
          int size = sequence.size();
          if (toIndex < size)
          {
            if (fromIndex < size)
            {
              sequence.move(toIndex, fromIndex);
              return;
            }
            while (iterator.hasNext())
            {
              property = (Property)iterator.next();
              if (!dataObject.isSet(property))
                continue;
              fromIndex -= size;
              if (isSequenceProperty(property))
              {
                Sequence fromSequence = (Sequence)dataObject.get(property);
                size = fromSequence.size();
                if (fromIndex >= size)
                  continue;
                move(fromSequence, fromIndex, sequence, toIndex);
                return;
              }
              if (property.isMany())
              {
                List list = dataObject.getList(property);
                size = list.size();
                if (fromIndex >= size)
                  continue;
                sequence.add(toIndex, property, list.remove(fromIndex)); // removes containment
                return;
              }
              if (fromIndex == 0)
              {
                sequence.add(toIndex, property, dataObject.get(property)); // removes containment
                dataObject.unset(property);
                return;
              }
              size = 1;
            } // iterator.hasNext()
            break;
          } // toIndex < size
          if (fromIndex < size)
          {
            while (iterator.hasNext())
            {
              property = (Property)iterator.next();
              if (!dataObject.isSet(property))
                continue;
              toIndex -= size;
              if (isSequenceProperty(property))
              {
                Sequence toSequence = (Sequence)dataObject.get(property);
                size = toSequence.size();
                if (toIndex >= size)
                  continue;
                if (++toIndex == size)
                  toSequence.add(sequence.getProperty(fromIndex), remove(sequence, fromIndex)); // Java pushes stack from left to right
                    // removes containment
                else
                  move(sequence, fromIndex, toSequence, toIndex);
                return;
              }
              if (property.isMany())
              {
                List list = dataObject.getList(property);
                size = list.size();
                if (toIndex >= size)
                  continue;
                if (sequence.getProperty(fromIndex) != property)
                  throw new IllegalArgumentException();
                add(remove(sequence, fromIndex), list, toIndex, size);
                return;
              }
              if (toIndex == 0)
              {
                while (iterator.hasNext())
                {
                  Property p = sequence.getProperty(fromIndex);
                  property = (Property)iterator.next();
                  EStructuralFeature feature = (EStructuralFeature)property;
                  if (dataObject.isSet(property))
                  {
                    if (FeatureMapUtil.isFeatureMap(feature))
                    {
                      /*if (!validate(feature, p))
                        throw new IllegalArgumentException(); */
                      move(sequence, fromIndex, (Sequence)dataObject.get(property), 0, p);
                      return;
                    }
                    if (property != p || !property.isMany())
                      throw new IllegalArgumentException();
                    insert(property, remove(sequence, fromIndex)); // removes containment
                    return;
                  }
                  if (FeatureMapUtil.isFeatureMap(feature))
                  {
                    if (validate(feature, p))
                    {
                      append(property, p, remove(sequence, fromIndex)); // removes containment
                      return;
                    }
                  }
                  else if (property == p)
                  {
                    set(property, remove(sequence, fromIndex));
                    return;
                  }
                } // iterator.hasNext()
                break;
              }
              size = 1;
            } // iterator.hasNext()
            break;
          } // fromIndex < size
          toIndex -= size;
          fromIndex -= size;
        } // sequence(property)
        else if (property.isMany())
        {
          List list = dataObject.getList(property);
          int size = list.size();
          if (toIndex < size)
          {
            if (fromIndex < size)
            {
              ((EList)list).move(toIndex, fromIndex);
              return;
            }
            while (iterator.hasNext())
            {
              Property p = (Property)iterator.next();
              if (!dataObject.isSet(p))
                continue;
              fromIndex -= size;
              if (isSequenceProperty(p))
              {
                Sequence fromSequence = (Sequence)dataObject.get(p);
                size = fromSequence.size();
                if (fromIndex >= size)
                  continue;
                if (fromSequence.getProperty(fromIndex) != property)
                  throw new IllegalArgumentException();
                list.add(toIndex, remove(fromSequence, fromIndex)); // removes containment
                return;
              }
              if (p.isMany())
              {
                List l = dataObject.getList(p);
                size = l.size();
                if (fromIndex >= size)
                  continue;
                /*if (p != property)
                  throw new IllegalArgumentException(); */
                list.add(toIndex, l.remove(fromIndex)); // removes containment
                return;
              }
              if (fromIndex == 0)
              {
                /*if (p != property)
                throw new IllegalArgumentException(); */
                list.add(toIndex, dataObject.get(p)); // removes containment
                dataObject.unset(p);
                return;
              }
              size = 1;
            } // iterator.hasNext()
            break;
          } // toIndex < size
          if (fromIndex < size)
          {
            while (iterator.hasNext())
            {
              Property p = (Property)iterator.next();
              if (!dataObject.isSet(p))
                continue;
              toIndex -= size;
              if (isSequenceProperty(p))
              {
                Sequence toSequence = (Sequence)dataObject.get(p);
                size = toSequence.size();
                if (toIndex >= size)
                  continue;
                add(property, list.remove(fromIndex), toSequence, toIndex, size);
                return;
              }
              if (p.isMany())
              {
                List l = dataObject.getList(p);
                size = l.size();
                if (toIndex >= size)
                  continue;
                /*if (property != p)
                  throw new IllegalArgumentException(); */
                add(list.remove(fromIndex), l, toIndex, size);
                return;
              }
              if (toIndex == 0)
              {
                while (iterator.hasNext())
                {
                  p = (Property)iterator.next();
                  EStructuralFeature feature = (EStructuralFeature)p;
                  if (dataObject.isSet(p))
                  {
                    if (FeatureMapUtil.isFeatureMap(feature))
                    {
                      /*if (!validate(feature, property))
                        throw new IllegalArgumentException(); */
                      insert(p, property, list.remove(fromIndex));
                      return;
                    }
                    if (/*p != property || */!p.isMany())
                      throw new IllegalArgumentException();
                    insert(p, list.remove(fromIndex)); // removes containment
                    return;
                  }
                  if (FeatureMapUtil.isFeatureMap(feature))
                  {
                    if (!validate(feature, property))
                      continue;
                    append(p, property, list.remove(fromIndex)); // removes containment
                    return;
                  }
                  else if (p == property)
                  {
                    set(p, list.remove(fromIndex));
                    return;
                  }
                } // iterator.hasNext()
                break;
              } // toIndex == 0
              size = 1;
            } // iterator.hasNext()
            break;
          } // fromIndex < size
          toIndex -= size;
          fromIndex -= size;
        } // property.isMany()
        else if (toIndex == 0)
          throw new IllegalArgumentException();
        else if (fromIndex == 0)
        {
          for (int size = 1; iterator.hasNext() ;)
          {
            Property p = (Property)iterator.next();
            if (!dataObject.isSet(p))
              continue;
            toIndex -= size;
            if (isSequenceProperty(p))
            {
              Sequence toSequence = (Sequence)dataObject.get(p);
              size = toSequence.size();
              if (toIndex >= size)
                continue;
              add(property, dataObject.get(property), toSequence, toIndex, size);
              dataObject.unset(property);
              return;
            }
            if (p.isMany())
            {
              List l = dataObject.getList(p);
              size = l.size();
              if (toIndex >= size)
                continue;
              /*if (property != p)
                throw new IllegalArgumentException(); */
              add(dataObject.get(property), l, toIndex, size);
              dataObject.unset(property);
              return;
            }
            if (toIndex == 0)
            {
              while (iterator.hasNext())
              {
                p = (Property)iterator.next();
                EStructuralFeature feature = (EStructuralFeature)p;
                if (dataObject.isSet(p))
                  if (FeatureMapUtil.isFeatureMap(feature))
                    /*if (!validate(feature, property))
                      throw new IllegalArgumentException(); */
                    insert(p, property, dataObject.get(property));
                  else if (/*p == property && */p.isMany())
                    insert(p, dataObject.get(property)); // removes containment
                  else
                    throw new IllegalArgumentException();
                else if (FeatureMapUtil.isFeatureMap(feature))
                {
                  if (!validate(feature, property))
                    continue;
                  append(p, property, dataObject.get(property)); // removes containment
                }
                else if (p == property)
                  set(p, dataObject.get(property));
                else
                  continue;
                dataObject.unset(property);
                return;
              } // iterator.hasNext()
              break;
            } // toIndex == 0
            size = 1;
          } // iterator.hasNext()
          break;
        } // fromIndex == 0
        else
        {
          --toIndex;
          --fromIndex;
        }
    }
    throw new IndexOutOfBoundsException();
  }
}
