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

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 *  SDO Sequance implementation which delegates to a feature map.
 */
public class BasicSequence implements Sequence, FeatureMap.Internal.Wrapper
{
  protected FeatureMap.Internal featureMap;

  public BasicSequence(FeatureMap.Internal featureMap)
  {
    this.featureMap = featureMap;
    featureMap.setWrapper(this);
  }

  public FeatureMap featureMap()
  {
    return featureMap;
  }

  public int size()
  {
    return featureMap.size();
  }

  public Property getProperty(int index)
  {
    EStructuralFeature feature = featureMap.getEStructuralFeature(index);
    return getFeatureProperty(feature);
  }
  
  public static Property getFeatureProperty(EStructuralFeature feature)
  {
    boolean isText = 
      feature == XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT ||
      feature == XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__CDATA ||    
      feature == XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__COMMENT;
    return isText ? null : (Property)feature;
  }
  
  public Object getValue(int index)
  {
    return featureMap.getValue(index);
  }
  
  public Object setValue(int index, Object value)
  {
    return featureMap.setValue(index, value);
  }

  /*
  protected EStructuralFeature getEStructuralFeature(String propertyName)
  {
    return featureMap.getEObject().eClass().getEStructuralFeature(propertyName);
  }
  */

  protected EStructuralFeature getEStructuralFeature(String propertyName, Object value)
  {
    EStructuralFeature result = featureMap.getEObject().eClass().getEStructuralFeature(propertyName);
    if (result == null)
    {
      Type type = (Type)featureMap.getEObject().eClass();
      if (type.isOpen())
      {
        result = (EStructuralFeature)DataObjectUtil.demandOpenProperty(type, propertyName, value, true);
      }
    }
    return result;
  }

  protected EStructuralFeature getEStructuralFeature(int propertyIndex)
  {
    return (EStructuralFeature)DataObjectUtil.getProperty((DataObject)featureMap.getEObject(), propertyIndex);
  }

  public boolean add(String propertyName, Object value)
  {
    return featureMap.add(getEStructuralFeature(propertyName, value), value);
  }

  public boolean add(int propertyIndex, Object value)
  {
    return featureMap.add(getEStructuralFeature(propertyIndex), value);
  }

  public boolean add(Property property, Object value)
  {
    return featureMap.add((EStructuralFeature)property, value);
  }

  public void add(int index, String propertyName, Object value)
  {
    featureMap.add(index, getEStructuralFeature(propertyName, value), value);
  }

  public void add(int index, int propertyIndex, Object value)
  {
    featureMap.add(index, getEStructuralFeature(propertyIndex), value);
  }

  public void add(int index, Property property, Object value)
  {
    featureMap.add(index, (EStructuralFeature)property, value);
  }

  /**
   * @deprecated
   */
  public void add(String text)
  {
    FeatureMapUtil.addText(featureMap, text);
  }

  /**
   * @deprecated
   */
  public void add(int index, String text)
  {
    FeatureMapUtil.addText(featureMap, index, text);
  }
 
  public void addText(String text)
  {
    FeatureMapUtil.addText(featureMap, text);
  }

  public void addText(int index, String text)
  {
    FeatureMapUtil.addText(featureMap, index, text);
  }
 
  public void remove(int index)
  {
    featureMap.remove(index);
  }

  public void move(int toIndex, int fromIndex)
  {
    featureMap.move(toIndex, fromIndex);
  }

  public String toString()
  {
    return featureMap.toString();
  }
}
