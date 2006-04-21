/**
 *
 *  Copyright 2005 The Apache Software Foundation or its licensors, as applicable.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.tuscany.sdo.util.metadata.impl;

import java.io.InputStream;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.tuscany.sdo.impl.DataObjectImpl;
import org.apache.tuscany.sdo.model.Types;
import org.apache.tuscany.sdo.util.SDOUtil;
import org.apache.tuscany.sdo.util.metadata.JavaMetaData;
import org.apache.tuscany.sdo.util.metadata.SDOMetaDataGroup;
import org.apache.tuscany.sdo.util.metadata.TypeMetaData;
import org.apache.tuscany.sdo.util.metadata.XSDMetaData;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SDO Meta Data Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.util.metadata.impl.SDOMetaDataGroupImpl#getJavaMetaData <em>Java Meta Data</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.util.metadata.impl.SDOMetaDataGroupImpl#getXsdMetaData <em>Xsd Meta Data</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.util.metadata.impl.SDOMetaDataGroupImpl#getTypeMetaData <em>Type Meta Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SDOMetaDataGroupImpl extends DataObjectImpl implements SDOMetaDataGroup
{
  public void register(TypeHelper typeHelper)
  {
    try
    {
      ClassLoader classLoader = (ClassLoader)AccessController.doPrivileged(new PrivilegedAction()
        {
          public Object run()
          {
            return Thread.currentThread().getContextClassLoader();
          }
        });
      register(typeHelper, classLoader);
    }
    catch (SecurityException e)
    {
    }
  }

  public void register(TypeHelper typeHelper, ClassLoader classLoader)
  {
    try
    {
      for (Iterator iter = getJavaMetaData().iterator(); iter.hasNext();)
      {
        JavaMetaData metadata = (JavaMetaData)iter.next();
        String factoryInterface = metadata.getFactoryInterface();
        if (factoryInterface != null)
        {
          Class factoryInterfaceClass = classLoader.loadClass(factoryInterface);
          SDOUtil.registerStaticTypes(factoryInterfaceClass);
        }
        else
        {
          String typeInterface = metadata.getTypeInterface();
          Class typeInterfaceClass = classLoader.loadClass(typeInterface);
          // TODO: introspect and register the type
        }
      }

      XSDHelper xsdHelper = SDOUtil.createXSDHelper(typeHelper);
      for (Iterator iter = getXsdMetaData().iterator(); iter.hasNext();)
      {
        XSDMetaData metadata = (XSDMetaData)iter.next();
        URL url = getClass().getResource(metadata.getLocation());
        InputStream inputStream = url.openStream();
        xsdHelper.define(inputStream, url.toString());
      }

      XMLHelper xmlHelper = SDOUtil.createXMLHelper(typeHelper);
      for (Iterator iter = getTypeMetaData().iterator(); iter.hasNext();)
      {
        TypeMetaData metadata = (TypeMetaData)iter.next();
        URL url = getClass().getResource(metadata.getLocation());
        InputStream inputStream = url.openStream();
        XMLDocument xmlDocument = xmlHelper.load(inputStream);
        Types types = (Types)xmlDocument.getRootObject();
        typeHelper.define(types.getTypeList());
      }
    }
    catch (Exception e)
    {
    }
  }
  
  /**
   * The cached value of the '{@link #getJavaMetaData() <em>Java Meta Data</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJavaMetaData()
   * @generated
   * @ordered
   */
  protected EList javaMetaData = null;

  /**
   * The cached value of the '{@link #getXsdMetaData() <em>Xsd Meta Data</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXsdMetaData()
   * @generated
   * @ordered
   */
  protected EList xsdMetaData = null;

  /**
   * The cached value of the '{@link #getTypeMetaData() <em>Type Meta Data</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeMetaData()
   * @generated
   * @ordered
   */
  protected EList typeMetaData = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SDOMetaDataGroupImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EClass eStaticClass()
  {
    return MetadataPackageImpl.Literals.SDO_META_DATA_GROUP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getJavaMetaData()
  {
    if (javaMetaData == null)
    {
      javaMetaData = new EObjectContainmentEList(JavaMetaData.class, this, MetadataPackageImpl.SDO_META_DATA_GROUP__JAVA_META_DATA);
    }
    return javaMetaData;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getXsdMetaData()
  {
    if (xsdMetaData == null)
    {
      xsdMetaData = new EObjectContainmentEList(XSDMetaData.class, this, MetadataPackageImpl.SDO_META_DATA_GROUP__XSD_META_DATA);
    }
    return xsdMetaData;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getTypeMetaData()
  {
    if (typeMetaData == null)
    {
      typeMetaData = new EObjectContainmentEList(TypeMetaData.class, this, MetadataPackageImpl.SDO_META_DATA_GROUP__TYPE_META_DATA);
    }
    return typeMetaData;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MetadataPackageImpl.SDO_META_DATA_GROUP__JAVA_META_DATA:
        return ((InternalEList)getJavaMetaData()).basicRemove(otherEnd, msgs);
      case MetadataPackageImpl.SDO_META_DATA_GROUP__XSD_META_DATA:
        return ((InternalEList)getXsdMetaData()).basicRemove(otherEnd, msgs);
      case MetadataPackageImpl.SDO_META_DATA_GROUP__TYPE_META_DATA:
        return ((InternalEList)getTypeMetaData()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MetadataPackageImpl.SDO_META_DATA_GROUP__JAVA_META_DATA:
        return getJavaMetaData();
      case MetadataPackageImpl.SDO_META_DATA_GROUP__XSD_META_DATA:
        return getXsdMetaData();
      case MetadataPackageImpl.SDO_META_DATA_GROUP__TYPE_META_DATA:
        return getTypeMetaData();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MetadataPackageImpl.SDO_META_DATA_GROUP__JAVA_META_DATA:
        getJavaMetaData().clear();
        getJavaMetaData().addAll((Collection)newValue);
        return;
      case MetadataPackageImpl.SDO_META_DATA_GROUP__XSD_META_DATA:
        getXsdMetaData().clear();
        getXsdMetaData().addAll((Collection)newValue);
        return;
      case MetadataPackageImpl.SDO_META_DATA_GROUP__TYPE_META_DATA:
        getTypeMetaData().clear();
        getTypeMetaData().addAll((Collection)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MetadataPackageImpl.SDO_META_DATA_GROUP__JAVA_META_DATA:
        getJavaMetaData().clear();
        return;
      case MetadataPackageImpl.SDO_META_DATA_GROUP__XSD_META_DATA:
        getXsdMetaData().clear();
        return;
      case MetadataPackageImpl.SDO_META_DATA_GROUP__TYPE_META_DATA:
        getTypeMetaData().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MetadataPackageImpl.SDO_META_DATA_GROUP__JAVA_META_DATA:
        return javaMetaData != null && !javaMetaData.isEmpty();
      case MetadataPackageImpl.SDO_META_DATA_GROUP__XSD_META_DATA:
        return xsdMetaData != null && !xsdMetaData.isEmpty();
      case MetadataPackageImpl.SDO_META_DATA_GROUP__TYPE_META_DATA:
        return typeMetaData != null && !typeMetaData.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SDOMetaDataGroupImpl