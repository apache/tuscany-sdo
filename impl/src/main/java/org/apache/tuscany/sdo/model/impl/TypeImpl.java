/**
 *
 * Copyright 2005 The Apache Software Foundation
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
package org.apache.tuscany.sdo.model.impl;

import commonj.sdo.Sequence;

import java.util.Collection;
import java.util.List;


import org.apache.tuscany.sdo.impl.DataObjectImpl;
import org.apache.tuscany.sdo.model.Property;
import org.apache.tuscany.sdo.model.Type;
import org.apache.tuscany.sdo.model.java.impl.JavaPackageImpl;

import org.apache.tuscany.sdo.util.BasicSequence;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.TypeImpl#getBaseType <em>Base Type</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.TypeImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.TypeImpl#getAliasName <em>Alias Name</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.TypeImpl#getAny <em>Any</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.TypeImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.TypeImpl#isDataType <em>Data Type</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.TypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.TypeImpl#isOpen <em>Open</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.TypeImpl#isSequenced <em>Sequenced</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.TypeImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.TypeImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeImpl extends DataObjectImpl implements Type
{
  /**
   * The cached value of the '{@link #getBaseType() <em>Base Type</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBaseType()
   * @generated
   * @ordered
   */
  protected EList baseType = null;

  /**
   * The cached value of the '{@link #getProperty() <em>Property</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperty()
   * @generated
   * @ordered
   */
  protected EList property = null;

  /**
   * The cached value of the '{@link #getAliasName() <em>Alias Name</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAliasName()
   * @generated
   * @ordered
   */
  protected EList aliasName = null;

  /**
   * The cached value of the '{@link #getAny() <em>Any</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAny()
   * @generated
   * @ordered
   */
  protected BasicSequence any = null;

  /**
   * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected static final boolean ABSTRACT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected boolean abstract_ = ABSTRACT_EDEFAULT;

  /**
   * This is true if the Abstract attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean abstractESet = false;

  /**
   * The default value of the '{@link #isDataType() <em>Data Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDataType()
   * @generated
   * @ordered
   */
  protected static final boolean DATA_TYPE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDataType() <em>Data Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDataType()
   * @generated
   * @ordered
   */
  protected boolean dataType = DATA_TYPE_EDEFAULT;

  /**
   * This is true if the Data Type attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean dataTypeESet = false;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #isOpen() <em>Open</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOpen()
   * @generated
   * @ordered
   */
  protected static final boolean OPEN_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isOpen() <em>Open</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOpen()
   * @generated
   * @ordered
   */
  protected boolean open = OPEN_EDEFAULT;

  /**
   * This is true if the Open attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean openESet = false;

  /**
   * The default value of the '{@link #isSequenced() <em>Sequenced</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSequenced()
   * @generated
   * @ordered
   */
  protected static final boolean SEQUENCED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSequenced() <em>Sequenced</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSequenced()
   * @generated
   * @ordered
   */
  protected boolean sequenced = SEQUENCED_EDEFAULT;

  /**
   * This is true if the Sequenced attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean sequencedESet = false;

  /**
   * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUri()
   * @generated
   * @ordered
   */
  protected static final String URI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUri()
   * @generated
   * @ordered
   */
  protected String uri = URI_EDEFAULT;

  /**
   * The cached value of the '{@link #getAnyAttribute() <em>Any Attribute</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnyAttribute()
   * @generated
   * @ordered
   */
  protected BasicSequence anyAttribute = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeImpl()
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
    return ModelPackageImpl.Literals.TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getBaseType()
  {
    if (baseType == null)
    {
      baseType = new EObjectResolvingEList(Type.class, this, ModelPackageImpl.TYPE__BASE_TYPE);
    }
    return baseType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getProperty()
  {
    if (property == null)
    {
      property = new EObjectContainmentEList(Property.class, this, ModelPackageImpl.TYPE__PROPERTY);
    }
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getAliasName()
  {
    if (aliasName == null)
    {
      aliasName = new EDataTypeEList(String.class, this, ModelPackageImpl.TYPE__ALIAS_NAME);
    }
    return aliasName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sequence getAny()
  {
    if (any == null)
    {
      any = new BasicSequence(new BasicFeatureMap(this, ModelPackageImpl.TYPE__ANY));
    }
    return any;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAbstract()
  {
    return abstract_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAbstract(boolean newAbstract)
  {
    boolean oldAbstract = abstract_;
    abstract_ = newAbstract;
    boolean oldAbstractESet = abstractESet;
    abstractESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.TYPE__ABSTRACT, oldAbstract, abstract_, !oldAbstractESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetAbstract()
  {
    boolean oldAbstract = abstract_;
    boolean oldAbstractESet = abstractESet;
    abstract_ = ABSTRACT_EDEFAULT;
    abstractESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackageImpl.TYPE__ABSTRACT, oldAbstract, ABSTRACT_EDEFAULT, oldAbstractESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetAbstract()
  {
    return abstractESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDataType()
  {
    return dataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDataType(boolean newDataType)
  {
    boolean oldDataType = dataType;
    dataType = newDataType;
    boolean oldDataTypeESet = dataTypeESet;
    dataTypeESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.TYPE__DATA_TYPE, oldDataType, dataType, !oldDataTypeESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDataType()
  {
    boolean oldDataType = dataType;
    boolean oldDataTypeESet = dataTypeESet;
    dataType = DATA_TYPE_EDEFAULT;
    dataTypeESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackageImpl.TYPE__DATA_TYPE, oldDataType, DATA_TYPE_EDEFAULT, oldDataTypeESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDataType()
  {
    return dataTypeESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.TYPE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isOpen()
  {
    return open;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOpen(boolean newOpen)
  {
    boolean oldOpen = open;
    open = newOpen;
    boolean oldOpenESet = openESet;
    openESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.TYPE__OPEN, oldOpen, open, !oldOpenESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetOpen()
  {
    boolean oldOpen = open;
    boolean oldOpenESet = openESet;
    open = OPEN_EDEFAULT;
    openESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackageImpl.TYPE__OPEN, oldOpen, OPEN_EDEFAULT, oldOpenESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetOpen()
  {
    return openESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSequenced()
  {
    return sequenced;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSequenced(boolean newSequenced)
  {
    boolean oldSequenced = sequenced;
    sequenced = newSequenced;
    boolean oldSequencedESet = sequencedESet;
    sequencedESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.TYPE__SEQUENCED, oldSequenced, sequenced, !oldSequencedESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetSequenced()
  {
    boolean oldSequenced = sequenced;
    boolean oldSequencedESet = sequencedESet;
    sequenced = SEQUENCED_EDEFAULT;
    sequencedESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackageImpl.TYPE__SEQUENCED, oldSequenced, SEQUENCED_EDEFAULT, oldSequencedESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetSequenced()
  {
    return sequencedESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUri()
  {
    return uri;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUri(String newUri)
  {
    String oldUri = uri;
    uri = newUri;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.TYPE__URI, oldUri, uri));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sequence getAnyAttribute()
  {
    if (anyAttribute == null)
    {
      anyAttribute = new BasicSequence(new BasicFeatureMap(this, ModelPackageImpl.TYPE__ANY_ATTRIBUTE));
    }
    return anyAttribute;
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
      case ModelPackageImpl.TYPE__PROPERTY:
        return ((InternalEList)getProperty()).basicRemove(otherEnd, msgs);
      case ModelPackageImpl.TYPE__ANY:
        return ((InternalEList)((FeatureMap.Internal.Wrapper)getAny()).featureMap()).basicRemove(otherEnd, msgs);
      case ModelPackageImpl.TYPE__ANY_ATTRIBUTE:
        return ((InternalEList)((FeatureMap.Internal.Wrapper)getAnyAttribute()).featureMap()).basicRemove(otherEnd, msgs);
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
      case ModelPackageImpl.TYPE__BASE_TYPE:
        return getBaseType();
      case ModelPackageImpl.TYPE__PROPERTY:
        return getProperty();
      case ModelPackageImpl.TYPE__ALIAS_NAME:
        return getAliasName();
      case ModelPackageImpl.TYPE__ANY:
        if (coreType) return ((FeatureMap.Internal.Wrapper)getAny()).featureMap();
        return getAny();
      case ModelPackageImpl.TYPE__ABSTRACT:
        return isAbstract() ? Boolean.TRUE : Boolean.FALSE;
      case ModelPackageImpl.TYPE__DATA_TYPE:
        return isDataType() ? Boolean.TRUE : Boolean.FALSE;
      case ModelPackageImpl.TYPE__NAME:
        return getName();
      case ModelPackageImpl.TYPE__OPEN:
        return isOpen() ? Boolean.TRUE : Boolean.FALSE;
      case ModelPackageImpl.TYPE__SEQUENCED:
        return isSequenced() ? Boolean.TRUE : Boolean.FALSE;
      case ModelPackageImpl.TYPE__URI:
        return getUri();
      case ModelPackageImpl.TYPE__ANY_ATTRIBUTE:
        if (coreType) return ((FeatureMap.Internal.Wrapper)getAnyAttribute()).featureMap();
        return getAnyAttribute();
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
      case ModelPackageImpl.TYPE__BASE_TYPE:
        getBaseType().clear();
        getBaseType().addAll((Collection)newValue);
        return;
      case ModelPackageImpl.TYPE__PROPERTY:
        getProperty().clear();
        getProperty().addAll((Collection)newValue);
        return;
      case ModelPackageImpl.TYPE__ALIAS_NAME:
        getAliasName().clear();
        getAliasName().addAll((Collection)newValue);
        return;
      case ModelPackageImpl.TYPE__ANY:
        ((FeatureMap.Internal)((FeatureMap.Internal.Wrapper)getAny()).featureMap()).set(newValue);
        return;
      case ModelPackageImpl.TYPE__ABSTRACT:
        setAbstract(((Boolean)newValue).booleanValue());
        return;
      case ModelPackageImpl.TYPE__DATA_TYPE:
        setDataType(((Boolean)newValue).booleanValue());
        return;
      case ModelPackageImpl.TYPE__NAME:
        setName((String)newValue);
        return;
      case ModelPackageImpl.TYPE__OPEN:
        setOpen(((Boolean)newValue).booleanValue());
        return;
      case ModelPackageImpl.TYPE__SEQUENCED:
        setSequenced(((Boolean)newValue).booleanValue());
        return;
      case ModelPackageImpl.TYPE__URI:
        setUri((String)newValue);
        return;
      case ModelPackageImpl.TYPE__ANY_ATTRIBUTE:
        ((FeatureMap.Internal)((FeatureMap.Internal.Wrapper)getAnyAttribute()).featureMap()).set(newValue);
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
      case ModelPackageImpl.TYPE__BASE_TYPE:
        getBaseType().clear();
        return;
      case ModelPackageImpl.TYPE__PROPERTY:
        getProperty().clear();
        return;
      case ModelPackageImpl.TYPE__ALIAS_NAME:
        getAliasName().clear();
        return;
      case ModelPackageImpl.TYPE__ANY:
        ((FeatureMap.Internal.Wrapper)getAny()).featureMap().clear();
        return;
      case ModelPackageImpl.TYPE__ABSTRACT:
        unsetAbstract();
        return;
      case ModelPackageImpl.TYPE__DATA_TYPE:
        unsetDataType();
        return;
      case ModelPackageImpl.TYPE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ModelPackageImpl.TYPE__OPEN:
        unsetOpen();
        return;
      case ModelPackageImpl.TYPE__SEQUENCED:
        unsetSequenced();
        return;
      case ModelPackageImpl.TYPE__URI:
        setUri(URI_EDEFAULT);
        return;
      case ModelPackageImpl.TYPE__ANY_ATTRIBUTE:
        ((FeatureMap.Internal.Wrapper)getAnyAttribute()).featureMap().clear();
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
      case ModelPackageImpl.TYPE__BASE_TYPE:
        return baseType != null && !baseType.isEmpty();
      case ModelPackageImpl.TYPE__PROPERTY:
        return property != null && !property.isEmpty();
      case ModelPackageImpl.TYPE__ALIAS_NAME:
        return aliasName != null && !aliasName.isEmpty();
      case ModelPackageImpl.TYPE__ANY:
        return any != null && !any.featureMap().isEmpty();
      case ModelPackageImpl.TYPE__ABSTRACT:
        return isSetAbstract();
      case ModelPackageImpl.TYPE__DATA_TYPE:
        return isSetDataType();
      case ModelPackageImpl.TYPE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ModelPackageImpl.TYPE__OPEN:
        return isSetOpen();
      case ModelPackageImpl.TYPE__SEQUENCED:
        return isSetSequenced();
      case ModelPackageImpl.TYPE__URI:
        return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
      case ModelPackageImpl.TYPE__ANY_ATTRIBUTE:
        return anyAttribute != null && !anyAttribute.featureMap().isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (aliasName: ");
    result.append(aliasName);
    result.append(", any: ");
    result.append(any);
    result.append(", abstract: ");
    if (abstractESet) result.append(abstract_); else result.append("<unset>");
    result.append(", dataType: ");
    if (dataTypeESet) result.append(dataType); else result.append("<unset>");
    result.append(", name: ");
    result.append(name);
    result.append(", open: ");
    if (openESet) result.append(open); else result.append("<unset>");
    result.append(", sequenced: ");
    if (sequencedESet) result.append(sequenced); else result.append("<unset>");
    result.append(", uri: ");
    result.append(uri);
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }
  
  public String getInstanceClassName()
  {
    EStructuralFeature javaClassFeature = JavaPackageImpl.eINSTANCE.getDocumentRoot_JavaClass();
    Sequence anyAttribute = getAnyAttribute();
    int count = anyAttribute.size();
    for (int i = 0; i < count; i++)
    {
      EStructuralFeature eFeature = (EStructuralFeature)anyAttribute.getProperty(i);
      if (eFeature == javaClassFeature)
      {
        return (String)anyAttribute.getValue(i);
      }
    }
    return null;
  }
  
} //TypeImpl
