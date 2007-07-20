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

import java.util.Collection;
import java.util.List;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import org.apache.tuscany.sdo.model.ModelFactory;
import org.apache.tuscany.sdo.model.Property;
import org.apache.tuscany.sdo.model.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.PropertyImpl#getAliasName <em>Alias Name</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.PropertyImpl#getAny <em>Any</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.PropertyImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.PropertyImpl#isMany <em>Many</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.PropertyImpl#isContainment <em>Containment</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.PropertyImpl#getDefault <em>Default</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.PropertyImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.PropertyImpl#getType_ <em>Type</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.PropertyImpl#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.PropertyImpl#isNullable <em>Nullable</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.PropertyImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyImpl extends DataObjectBase implements Property
{

  public final static int ALIAS_NAME = 0;

  public final static int ANY = -1;

  public final static int NAME = 1;

  public final static int MANY = 2;

  public final static int CONTAINMENT = 3;

  public final static int DEFAULT = 4;

  public final static int READ_ONLY = 5;

  public final static int TYPE = 6;

  public final static int OPPOSITE = 7;

  public final static int NULLABLE = 8;

  public final static int ANY_ATTRIBUTE = -2;

  public final static int SDO_PROPERTY_COUNT = 9;

  public final static int EXTENDED_PROPERTY_COUNT = -2;


  /**
   * The internal feature id for the '<em><b>Alias Name</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ALIAS_NAME = 0;

  /**
   * The internal feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY = 1;

  /**
   * The internal feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_NAME = 2;

  /**
   * The internal feature id for the '<em><b>Many</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_MANY = 3;

  /**
   * The internal feature id for the '<em><b>Containment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_CONTAINMENT = 4;

  /**
   * The internal feature id for the '<em><b>Default</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_DEFAULT = 5;

  /**
   * The internal feature id for the '<em><b>Read Only</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_READ_ONLY = 6;

  /**
   * The internal feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_TYPE = 7;

  /**
   * The internal feature id for the '<em><b>Opposite</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_OPPOSITE = 8;

  /**
   * The internal feature id for the '<em><b>Nullable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_NULLABLE = 9;

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
      case INTERNAL_ALIAS_NAME: return ALIAS_NAME;
      case INTERNAL_ANY: return ANY;
      case INTERNAL_NAME: return NAME;
      case INTERNAL_MANY: return MANY;
      case INTERNAL_CONTAINMENT: return CONTAINMENT;
      case INTERNAL_DEFAULT: return DEFAULT;
      case INTERNAL_READ_ONLY: return READ_ONLY;
      case INTERNAL_TYPE: return TYPE;
      case INTERNAL_OPPOSITE: return OPPOSITE;
      case INTERNAL_NULLABLE: return NULLABLE;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


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
   * The default value of the '{@link #isMany() <em>Many</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMany()
   * @generated
   * @ordered
   */
  protected static final boolean MANY_DEFAULT_ = false;

  /**
   * The cached value of the '{@link #isMany() <em>Many</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMany()
   * @generated
   * @ordered
   */
  protected boolean many = MANY_DEFAULT_;

  /**
   * This is true if the Many attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean many_set_ = false;

  /**
   * The default value of the '{@link #isContainment() <em>Containment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isContainment()
   * @generated
   * @ordered
   */
  protected static final boolean CONTAINMENT_DEFAULT_ = false;

  /**
   * The cached value of the '{@link #isContainment() <em>Containment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isContainment()
   * @generated
   * @ordered
   */
  protected boolean containment = CONTAINMENT_DEFAULT_;

  /**
   * This is true if the Containment attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean containment_set_ = false;

  /**
   * The default value of the '{@link #getDefault_() <em>Default</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefault_()
   * @generated
   * @ordered
   */
  protected static final String DEFAULT_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getDefault_() <em>Default</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefault_()
   * @generated
   * @ordered
   */
  protected String default_ = DEFAULT_DEFAULT_;

  /**
   * This is true if the Default attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean default_set_ = false;

  /**
   * The default value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isReadOnly()
   * @generated
   * @ordered
   */
  protected static final boolean READ_ONLY_DEFAULT_ = false;

  /**
   * The cached value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isReadOnly()
   * @generated
   * @ordered
   */
  protected boolean readOnly = READ_ONLY_DEFAULT_;

  /**
   * This is true if the Read Only attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean readOnly_set_ = false;

  /**
   * The cached value of the '{@link #getType_() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType_()
   * @generated
   * @ordered
   */
  
  protected Type type = null;
  
  /**
   * This is true if the Type reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean type_set_ = false;

  /**
   * The cached value of the '{@link #getOpposite_() <em>Opposite</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpposite_()
   * @generated
   * @ordered
   */
  
  protected Property opposite = null;
  
  /**
   * This is true if the Opposite reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean opposite_set_ = false;

  /**
   * The default value of the '{@link #isNullable() <em>Nullable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNullable()
   * @generated
   * @ordered
   */
  protected static final boolean NULLABLE_DEFAULT_ = false;

  /**
   * The cached value of the '{@link #isNullable() <em>Nullable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNullable()
   * @generated
   * @ordered
   */
  protected boolean nullable = NULLABLE_DEFAULT_;

  /**
   * This is true if the Nullable attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean nullable_set_ = false;

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
  public PropertyImpl()
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
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).getProperty();
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
  public boolean isMany()
  {
    return many;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMany(boolean newMany)
  {
    boolean oldMany = many;
    many = newMany;
    boolean oldMany_set_ = many_set_;
    many_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_MANY, oldMany, many, !oldMany_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetMany()
  {
    boolean oldMany = many;
    boolean oldMany_set_ = many_set_;
    many = MANY_DEFAULT_;
    many_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_MANY, oldMany, MANY_DEFAULT_, oldMany_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetMany()
  {
    return many_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isContainment()
  {
    return containment;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContainment(boolean newContainment)
  {
    boolean oldContainment = containment;
    containment = newContainment;
    boolean oldContainment_set_ = containment_set_;
    containment_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_CONTAINMENT, oldContainment, containment, !oldContainment_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetContainment()
  {
    boolean oldContainment = containment;
    boolean oldContainment_set_ = containment_set_;
    containment = CONTAINMENT_DEFAULT_;
    containment_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_CONTAINMENT, oldContainment, CONTAINMENT_DEFAULT_, oldContainment_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetContainment()
  {
    return containment_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDefault_()
  {
    return default_;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefault_(String newDefault)
  {
    String oldDefault = default_;
    default_ = newDefault;
    boolean oldDefault_set_ = default_set_;
    default_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_DEFAULT, oldDefault, default_, !oldDefault_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDefault()
  {
    String oldDefault = default_;
    boolean oldDefault_set_ = default_set_;
    default_ = DEFAULT_DEFAULT_;
    default_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_DEFAULT, oldDefault, DEFAULT_DEFAULT_, oldDefault_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDefault()
  {
    return default_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isReadOnly()
  {
    return readOnly;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReadOnly(boolean newReadOnly)
  {
    boolean oldReadOnly = readOnly;
    readOnly = newReadOnly;
    boolean oldReadOnly_set_ = readOnly_set_;
    readOnly_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_READ_ONLY, oldReadOnly, readOnly, !oldReadOnly_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetReadOnly()
  {
    boolean oldReadOnly = readOnly;
    boolean oldReadOnly_set_ = readOnly_set_;
    readOnly = READ_ONLY_DEFAULT_;
    readOnly_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_READ_ONLY, oldReadOnly, READ_ONLY_DEFAULT_, oldReadOnly_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetReadOnly()
  {
    return readOnly_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getType_()
  {
    if (type != null && isProxy(type))
    {
      Object oldType = type;
      type = (Type)resolveProxy(oldType);
      if (type != oldType)
      {
        if (isNotifying())
          notify(ChangeKind.RESOLVE, INTERNAL_TYPE, oldType, type);
      }
    }
    return type;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(Type newType)
  {
    Type oldType = type;
    type = newType;
    boolean oldType_set_ = type_set_;
    type_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_TYPE, oldType, type, !oldType_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetType()
  {
    Type oldType = type;
    boolean oldType_set_ = type_set_;
    type = null;
    type_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_TYPE, oldType, null, oldType_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetType()
  {
    return type_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property getOpposite_()
  {
    if (opposite != null && isProxy(opposite))
    {
      Object oldOpposite = opposite;
      opposite = (Property)resolveProxy(oldOpposite);
      if (opposite != oldOpposite)
      {
        if (isNotifying())
          notify(ChangeKind.RESOLVE, INTERNAL_OPPOSITE, oldOpposite, opposite);
      }
    }
    return opposite;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property basicGetOpposite()
  {
    return opposite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOpposite_(Property newOpposite)
  {
    Property oldOpposite = opposite;
    opposite = newOpposite;
    boolean oldOpposite_set_ = opposite_set_;
    opposite_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_OPPOSITE, oldOpposite, opposite, !oldOpposite_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetOpposite()
  {
    Property oldOpposite = opposite;
    boolean oldOpposite_set_ = opposite_set_;
    opposite = null;
    opposite_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_OPPOSITE, oldOpposite, null, oldOpposite_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetOpposite()
  {
    return opposite_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isNullable()
  {
    return nullable;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNullable(boolean newNullable)
  {
    boolean oldNullable = nullable;
    nullable = newNullable;
    boolean oldNullable_set_ = nullable_set_;
    nullable_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_NULLABLE, oldNullable, nullable, !oldNullable_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetNullable()
  {
    boolean oldNullable = nullable;
    boolean oldNullable_set_ = nullable_set_;
    nullable = NULLABLE_DEFAULT_;
    nullable_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_NULLABLE, oldNullable, NULLABLE_DEFAULT_, oldNullable_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetNullable()
  {
    return nullable_set_;
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
      case ALIAS_NAME:
        return getAliasName();
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case NAME:
        return getName();
      case MANY:
        return isMany() ? Boolean.TRUE : Boolean.FALSE;
      case CONTAINMENT:
        return isContainment() ? Boolean.TRUE : Boolean.FALSE;
      case DEFAULT:
        return getDefault_();
      case READ_ONLY:
        return isReadOnly() ? Boolean.TRUE : Boolean.FALSE;
      case TYPE:
        if (resolve) return getType_();
        return basicGetType();
      case OPPOSITE:
        if (resolve) return getOpposite_();
        return basicGetOpposite();
      case NULLABLE:
        return isNullable() ? Boolean.TRUE : Boolean.FALSE;
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
      case MANY:
        setMany(((Boolean)newValue).booleanValue());
        return;
      case CONTAINMENT:
        setContainment(((Boolean)newValue).booleanValue());
        return;
      case DEFAULT:
        setDefault_((String)newValue);
        return;
      case READ_ONLY:
        setReadOnly(((Boolean)newValue).booleanValue());
        return;
      case TYPE:
        setType((Type)newValue);
        return;
      case OPPOSITE:
        setOpposite_((Property)newValue);
        return;
      case NULLABLE:
        setNullable(((Boolean)newValue).booleanValue());
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
      case ALIAS_NAME:
        getAliasName().clear();
        return;
      case ANY:
        unsetSequence(getAny());
        return;
      case NAME:
        unsetName();
        return;
      case MANY:
        unsetMany();
        return;
      case CONTAINMENT:
        unsetContainment();
        return;
      case DEFAULT:
        unsetDefault();
        return;
      case READ_ONLY:
        unsetReadOnly();
        return;
      case TYPE:
        unsetType();
        return;
      case OPPOSITE:
        unsetOpposite();
        return;
      case NULLABLE:
        unsetNullable();
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
      case ALIAS_NAME:
        return aliasName != null && !aliasName.isEmpty();
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case NAME:
        return isSetName();
      case MANY:
        return isSetMany();
      case CONTAINMENT:
        return isSetContainment();
      case DEFAULT:
        return isSetDefault();
      case READ_ONLY:
        return isSetReadOnly();
      case TYPE:
        return isSetType();
      case OPPOSITE:
        return isSetOpposite();
      case NULLABLE:
        return isSetNullable();
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
    result.append(", many: ");
    if (many_set_) result.append(many); else result.append("<unset>");
    result.append(", containment: ");
    if (containment_set_) result.append(containment); else result.append("<unset>");
    result.append(", default: ");
    if (default_set_) result.append(default_); else result.append("<unset>");
    result.append(", readOnly: ");
    if (readOnly_set_) result.append(readOnly); else result.append("<unset>");
    result.append(", nullable: ");
    if (nullable_set_) result.append(nullable); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //PropertyImpl
