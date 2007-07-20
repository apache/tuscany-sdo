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
package org.apache.tuscany.sdo.model.impl;

import commonj.sdo.Sequence;
import commonj.sdo.helper.TypeHelper;

import java.util.Collection;
import java.util.List;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import org.apache.tuscany.sdo.model.ModelFactory;
import org.apache.tuscany.sdo.model.Property;
import org.apache.tuscany.sdo.model.Type;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;

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
 *   <li>{@link org.apache.tuscany.sdo.model.impl.TypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.TypeImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.TypeImpl#isDataType <em>Data Type</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.TypeImpl#isOpen <em>Open</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.TypeImpl#isSequenced <em>Sequenced</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.TypeImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.TypeImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeImpl extends DataObjectBase implements Type
{

  public final static int BASE_TYPE = 0;

  public final static int PROPERTY = 1;

  public final static int ALIAS_NAME = 2;

  public final static int ANY = -1;

  public final static int NAME = 3;

  public final static int URI = 4;

  public final static int DATA_TYPE = 5;

  public final static int OPEN = 6;

  public final static int SEQUENCED = 7;

  public final static int ABSTRACT = 8;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 9;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Base Type</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_BASE_TYPE = 0;

  /**
   * The internal feature id for the '<em><b>Property</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PROPERTY = 1;

  /**
   * The internal feature id for the '<em><b>Alias Name</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ALIAS_NAME = 2;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 3;

  /**
   * The internal feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_NAME = 4;

  /**
   * The internal feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_URI = 5;

  /**
   * The internal feature id for the '<em><b>Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DATA_TYPE = 6;

  /**
   * The internal feature id for the '<em><b>Open</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_OPEN = 7;

  /**
   * The internal feature id for the '<em><b>Sequenced</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_SEQUENCED = 8;

  /**
   * The internal feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ABSTRACT = 9;

  /**
   * The internal feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY_ATTRIBUTE = 10;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 11;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_BASE_TYPE: return BASE_TYPE;
      case INTERNAL_PROPERTY: return PROPERTY;
      case INTERNAL_ALIAS_NAME: return ALIAS_NAME;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_NAME: return NAME;
      case INTERNAL_URI: return URI;
      case INTERNAL_DATA_TYPE: return DATA_TYPE;
      case INTERNAL_OPEN: return OPEN;
      case INTERNAL_SEQUENCED: return SEQUENCED;
      case INTERNAL_ABSTRACT: return ABSTRACT;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getBaseType() <em>Base Type</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBaseType()
   * @generated
   * @ordered
   */
  
  protected List baseType = null;
  
  /**
   * The cached value of the '{@link #getProperty() <em>Property</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperty()
   * @generated
   * @ordered
   */
  
  protected List property = null;
  
  /**
   * The cached value of the '{@link #getAliasName() <em>Alias Name</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAliasName()
   * @generated
   * @ordered
   */
  
  protected List aliasName = null;
  
  /**
   * The cached value of the '{@link #getAny() <em>Any</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAny()
   * @generated
   * @ordered
   */
  
  protected Sequence any = null;
  
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_DEFAULT_;

  /**
   * This is true if the Name attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean name_set_ = false;

  /**
   * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUri()
   * @generated
   * @ordered
   */
  protected static final String URI_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUri()
   * @generated
   * @ordered
   */
  protected String uri = URI_DEFAULT_;

  /**
   * This is true if the Uri attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean uri_set_ = false;

  /**
   * The default value of the '{@link #isDataType() <em>Data Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDataType()
   * @generated
   * @ordered
   */
  protected static final boolean DATA_TYPE_DEFAULT_ = false;

  /**
   * The cached value of the '{@link #isDataType() <em>Data Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDataType()
   * @generated
   * @ordered
   */
  protected boolean dataType = DATA_TYPE_DEFAULT_;

  /**
   * This is true if the Data Type attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean dataType_set_ = false;

  /**
   * The default value of the '{@link #isOpen() <em>Open</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOpen()
   * @generated
   * @ordered
   */
  protected static final boolean OPEN_DEFAULT_ = false;

  /**
   * The cached value of the '{@link #isOpen() <em>Open</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOpen()
   * @generated
   * @ordered
   */
  protected boolean open = OPEN_DEFAULT_;

  /**
   * This is true if the Open attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean open_set_ = false;

  /**
   * The default value of the '{@link #isSequenced() <em>Sequenced</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSequenced()
   * @generated
   * @ordered
   */
  protected static final boolean SEQUENCED_DEFAULT_ = false;

  /**
   * The cached value of the '{@link #isSequenced() <em>Sequenced</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSequenced()
   * @generated
   * @ordered
   */
  protected boolean sequenced = SEQUENCED_DEFAULT_;

  /**
   * This is true if the Sequenced attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean sequenced_set_ = false;

  /**
   * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected static final boolean ABSTRACT_DEFAULT_ = false;

  /**
   * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected boolean abstract_ = ABSTRACT_DEFAULT_;

  /**
   * This is true if the Abstract attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean abstract_set_ = false;

  /**
   * The cached value of the '{@link #getAnyAttribute() <em>Any Attribute</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnyAttribute()
   * @generated
   * @ordered
   */
  
  protected Sequence anyAttribute = null;
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public commonj.sdo.Type getStaticType()
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).getType();
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
      baseType = createPropertyList(ListKind.NONCONTAINMENT_RESOLVING, Type.class, BASE_TYPE, 0);
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
      property = createPropertyList(ListKind.CONTAINMENT, Property.class, PROPERTY, 0);
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
      aliasName = createPropertyList(ListKind.DATATYPE, String.class, ALIAS_NAME, 0);
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
      any = createSequence(INTERNAL_ANY);
    }
    return any;
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
    boolean oldName_set_ = name_set_;
    name_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_NAME, oldName, name, !oldName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetName()
  {
    String oldName = name;
    boolean oldName_set_ = name_set_;
    name = NAME_DEFAULT_;
    name_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_NAME, oldName, NAME_DEFAULT_, oldName_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetName()
  {
    return name_set_;
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
    boolean oldUri_set_ = uri_set_;
    uri_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_URI, oldUri, uri, !oldUri_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetUri()
  {
    String oldUri = uri;
    boolean oldUri_set_ = uri_set_;
    uri = URI_DEFAULT_;
    uri_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_URI, oldUri, URI_DEFAULT_, oldUri_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetUri()
  {
    return uri_set_;
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
    boolean oldDataType_set_ = dataType_set_;
    dataType_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_DATA_TYPE, oldDataType, dataType, !oldDataType_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDataType()
  {
    boolean oldDataType = dataType;
    boolean oldDataType_set_ = dataType_set_;
    dataType = DATA_TYPE_DEFAULT_;
    dataType_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_DATA_TYPE, oldDataType, DATA_TYPE_DEFAULT_, oldDataType_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDataType()
  {
    return dataType_set_;
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
    boolean oldOpen_set_ = open_set_;
    open_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_OPEN, oldOpen, open, !oldOpen_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetOpen()
  {
    boolean oldOpen = open;
    boolean oldOpen_set_ = open_set_;
    open = OPEN_DEFAULT_;
    open_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_OPEN, oldOpen, OPEN_DEFAULT_, oldOpen_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetOpen()
  {
    return open_set_;
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
    boolean oldSequenced_set_ = sequenced_set_;
    sequenced_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_SEQUENCED, oldSequenced, sequenced, !oldSequenced_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetSequenced()
  {
    boolean oldSequenced = sequenced;
    boolean oldSequenced_set_ = sequenced_set_;
    sequenced = SEQUENCED_DEFAULT_;
    sequenced_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_SEQUENCED, oldSequenced, SEQUENCED_DEFAULT_, oldSequenced_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetSequenced()
  {
    return sequenced_set_;
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
    boolean oldAbstract_set_ = abstract_set_;
    abstract_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_ABSTRACT, oldAbstract, abstract_, !oldAbstract_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetAbstract()
  {
    boolean oldAbstract = abstract_;
    boolean oldAbstract_set_ = abstract_set_;
    abstract_ = ABSTRACT_DEFAULT_;
    abstract_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_ABSTRACT, oldAbstract, ABSTRACT_DEFAULT_, oldAbstract_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetAbstract()
  {
    return abstract_set_;
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
      anyAttribute = createSequence(INTERNAL_ANY_ATTRIBUTE);
    }
    return anyAttribute;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext inverseRemove(Object otherEnd, int propertyIndex, ChangeContext changeContext)
  {
    switch (propertyIndex)
    {
      case PROPERTY:
        return removeFromList(getProperty(), otherEnd, changeContext);
      case ANY:
        return removeFromSequence(getAny(), otherEnd, changeContext);
      case ANY_ATTRIBUTE:
        return removeFromSequence(getAnyAttribute(), otherEnd, changeContext);
    }
    return super.inverseRemove(otherEnd, propertyIndex, changeContext);
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
      case BASE_TYPE:
        return getBaseType();
      case PROPERTY:
        return getProperty();
      case ALIAS_NAME:
        return getAliasName();
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case NAME:
        return getName();
      case URI:
        return getUri();
      case DATA_TYPE:
        return isDataType() ? Boolean.TRUE : Boolean.FALSE;
      case OPEN:
        return isOpen() ? Boolean.TRUE : Boolean.FALSE;
      case SEQUENCED:
        return isSequenced() ? Boolean.TRUE : Boolean.FALSE;
      case ABSTRACT:
        return isAbstract() ? Boolean.TRUE : Boolean.FALSE;
      case ANY_ATTRIBUTE:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAnyAttribute();
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
      case BASE_TYPE:
        getBaseType().clear();
        getBaseType().addAll((Collection)newValue);
        return;
      case PROPERTY:
        getProperty().clear();
        getProperty().addAll((Collection)newValue);
        return;
      case ALIAS_NAME:
        getAliasName().clear();
        getAliasName().addAll((Collection)newValue);
        return;
      case ANY:
      	setSequence(getAny(), newValue);
        return;
      case NAME:
        setName((String)newValue);
        return;
      case URI:
        setUri((String)newValue);
        return;
      case DATA_TYPE:
        setDataType(((Boolean)newValue).booleanValue());
        return;
      case OPEN:
        setOpen(((Boolean)newValue).booleanValue());
        return;
      case SEQUENCED:
        setSequenced(((Boolean)newValue).booleanValue());
        return;
      case ABSTRACT:
        setAbstract(((Boolean)newValue).booleanValue());
        return;
      case ANY_ATTRIBUTE:
      	setSequence(getAnyAttribute(), newValue);
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
      case BASE_TYPE:
        getBaseType().clear();
        return;
      case PROPERTY:
        getProperty().clear();
        return;
      case ALIAS_NAME:
        getAliasName().clear();
        return;
      case ANY:
        unsetSequence(getAny());
        return;
      case NAME:
        unsetName();
        return;
      case URI:
        unsetUri();
        return;
      case DATA_TYPE:
        unsetDataType();
        return;
      case OPEN:
        unsetOpen();
        return;
      case SEQUENCED:
        unsetSequenced();
        return;
      case ABSTRACT:
        unsetAbstract();
        return;
      case ANY_ATTRIBUTE:
        unsetSequence(getAnyAttribute());
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
      case BASE_TYPE:
        return baseType != null && !baseType.isEmpty();
      case PROPERTY:
        return property != null && !property.isEmpty();
      case ALIAS_NAME:
        return aliasName != null && !aliasName.isEmpty();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case NAME:
        return isSetName();
      case URI:
        return isSetUri();
      case DATA_TYPE:
        return isSetDataType();
      case OPEN:
        return isSetOpen();
      case SEQUENCED:
        return isSetSequenced();
      case ABSTRACT:
        return isSetAbstract();
      case ANY_ATTRIBUTE:
        return anyAttribute != null && !isSequenceEmpty(getAnyAttribute());
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
    result.append(" (aliasName: ");
    result.append(aliasName);
    result.append(", any: ");
    result.append(any);
    result.append(", name: ");
    if (name_set_) result.append(name); else result.append("<unset>");
    result.append(", uri: ");
    if (uri_set_) result.append(uri); else result.append("<unset>");
    result.append(", dataType: ");
    if (dataType_set_) result.append(dataType); else result.append("<unset>");
    result.append(", open: ");
    if (open_set_) result.append(open); else result.append("<unset>");
    result.append(", sequenced: ");
    if (sequenced_set_) result.append(sequenced); else result.append("<unset>");
    result.append(", abstract: ");
    if (abstract_set_) result.append(abstract_); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

EStructuralFeature javaClassFeature = null;

public String getInstanceClassName()
  {
    if (javaClassFeature == null)
    {
      //FB TODO figure out what helper to use
      javaClassFeature = (EStructuralFeature)TypeHelper.INSTANCE.getOpenContentProperty("commonj.sdo/java", "javaClass");
    }

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
