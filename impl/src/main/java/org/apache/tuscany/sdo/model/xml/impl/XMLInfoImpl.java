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
package org.apache.tuscany.sdo.model.xml.impl;

import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import org.apache.tuscany.sdo.model.xml.XMLFactory;
import org.apache.tuscany.sdo.model.xml.XMLInfo;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.model.xml.impl.XMLInfoImpl#isXmlElement <em>Xml Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XMLInfoImpl extends DataObjectBase implements XMLInfo
{

  public final static int XML_ELEMENT = 0;

  public final static int SDO_PROPERTY_COUNT = 1;

  public final static int EXTENDED_PROPERTY_COUNT = 0;


  /**
   * The internal feature id for the '<em><b>Xml Element</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_XML_ELEMENT = 0;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 1;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_XML_ELEMENT: return XML_ELEMENT;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The default value of the '{@link #isXmlElement() <em>Xml Element</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isXmlElement()
   * @generated
   * @ordered
   */
  protected static final boolean XML_ELEMENT_DEFAULT_ = false;

  /**
   * The cached value of the '{@link #isXmlElement() <em>Xml Element</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isXmlElement()
   * @generated
   * @ordered
   */
  protected boolean xmlElement = XML_ELEMENT_DEFAULT_;

  /**
   * This is true if the Xml Element attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean xmlElement_set_ = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMLInfoImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getStaticType()
  {
    return ((XMLFactoryImpl)XMLFactory.INSTANCE).getXMLInfo();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isXmlElement()
  {
    return xmlElement;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setXmlElement(boolean newXmlElement)
  {
    boolean oldXmlElement = xmlElement;
    xmlElement = newXmlElement;
    boolean oldXmlElement_set_ = xmlElement_set_;
    xmlElement_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_XML_ELEMENT, oldXmlElement, xmlElement, !oldXmlElement_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetXmlElement()
  {
    boolean oldXmlElement = xmlElement;
    boolean oldXmlElement_set_ = xmlElement_set_;
    xmlElement = XML_ELEMENT_DEFAULT_;
    xmlElement_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_XML_ELEMENT, oldXmlElement, XML_ELEMENT_DEFAULT_, oldXmlElement_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetXmlElement()
  {
    return xmlElement_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object get(int propertyIndex, boolean resolve)
  {
    switch (propertyIndex)
    {
      case XML_ELEMENT:
        return isXmlElement() ? Boolean.TRUE : Boolean.FALSE;
    }
    return super.get(propertyIndex, resolve);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void set(int propertyIndex, Object newValue)
  {
    switch (propertyIndex)
    {
      case XML_ELEMENT:
        setXmlElement(((Boolean)newValue).booleanValue());
        return;
    }
    super.set(propertyIndex, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unset(int propertyIndex)
  {
    switch (propertyIndex)
    {
      case XML_ELEMENT:
        unsetXmlElement();
        return;
    }
    super.unset(propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSet(int propertyIndex)
  {
    switch (propertyIndex)
    {
      case XML_ELEMENT:
        return isSetXmlElement();
    }
    return super.isSet(propertyIndex);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String toString()
  {
    if (isProxy(this)) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (xmlElement: ");
    if (xmlElement_set_) result.append(xmlElement); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //XMLInfoImpl
