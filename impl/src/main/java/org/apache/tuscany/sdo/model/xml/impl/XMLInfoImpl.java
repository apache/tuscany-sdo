/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.sdo.model.xml.impl;

import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import org.apache.tuscany.sdo.model.xml.XMLInfo;
import org.apache.tuscany.sdo.model.xml.XMLFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XML Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.model.xml.impl.XMLInfoImpl#getXmlElement <em>Xml Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XMLInfoImpl extends DataObjectBase implements XMLInfo
{
  /**
   * The feature id for the '<em><b>Xml Element</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int XML_ELEMENT = 0;

  /**
   * This represents the number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  
  public final static int SDO_PROPERTY_COUNT = 1;

  /**
   * The default value of the '{@link #getXmlElement() <em>Xml Element</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXmlElement()
   * @generated
   * @ordered
   */
  protected static final Object XML_ELEMENT_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getXmlElement() <em>Xml Element</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXmlElement()
   * @generated
   * @ordered
   */
  protected Object xmlElement = XML_ELEMENT_DEFAULT_;

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
  public Type getType()
  {
    return ((XMLFactoryImpl)XMLFactory.INSTANCE).getXMLInfo();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object getXmlElement()
  {
    return xmlElement;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setXmlElement(Object newXmlElement)
  {
    Object oldXmlElement = xmlElement;
    xmlElement = newXmlElement;
    if (isNotifying())
      notify(ChangeKind.SET, XML_ELEMENT, oldXmlElement, xmlElement);
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
        return getXmlElement();
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
        setXmlElement((Object)newValue);
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
        setXmlElement(XML_ELEMENT_DEFAULT_);
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
        return XML_ELEMENT_DEFAULT_ == null ? xmlElement != null : !XML_ELEMENT_DEFAULT_.equals(xmlElement);
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
    result.append(xmlElement);
    result.append(')');
    return result.toString();
  }

} //XMLInfoImpl
