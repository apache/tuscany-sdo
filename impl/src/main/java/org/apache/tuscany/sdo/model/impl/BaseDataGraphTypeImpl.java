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

import commonj.sdo.ChangeSummary;
import commonj.sdo.Sequence;
import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import org.apache.tuscany.sdo.model.BaseDataGraphType;
import org.apache.tuscany.sdo.model.ModelFactory;
import org.apache.tuscany.sdo.model.ModelsType;
import org.apache.tuscany.sdo.model.XSDType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Base Data Graph Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.BaseDataGraphTypeImpl#getModels <em>Models</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.BaseDataGraphTypeImpl#getXsd <em>Xsd</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.BaseDataGraphTypeImpl#getChangeSummary <em>Change Summary</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.BaseDataGraphTypeImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class BaseDataGraphTypeImpl extends DataObjectBase implements BaseDataGraphType
{

  public final static int MODELS = 0;

  public final static int XSD = 1;

  public final static int CHANGE_SUMMARY = 2;

  public final static int ANY_ATTRIBUTE = -1;

  public final static int SDO_PROPERTY_COUNT = 3;

  public final static int EXTENDED_PROPERTY_COUNT = -1;


  /**
   * The internal feature id for the '<em><b>Models</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_MODELS = 0;

  /**
   * The internal feature id for the '<em><b>Xsd</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_XSD = 1;

  /**
   * The internal feature id for the '<em><b>Change Summary</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_CHANGE_SUMMARY = 2;

  /**
   * The internal feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_ANY_ATTRIBUTE = 3;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = 4;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_MODELS: return MODELS;
      case INTERNAL_XSD: return XSD;
      case INTERNAL_CHANGE_SUMMARY: return CHANGE_SUMMARY;
      case INTERNAL_ANY_ATTRIBUTE: return ANY_ATTRIBUTE;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The cached value of the '{@link #getModels() <em>Models</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModels()
   * @generated
   * @ordered
   */
  
  protected ModelsType models = null;
  
  /**
   * This is true if the Models containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean models_set_ = false;

  /**
   * The cached value of the '{@link #getXsd() <em>Xsd</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXsd()
   * @generated
   * @ordered
   */
  
  protected XSDType xsd = null;
  
  /**
   * This is true if the Xsd containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean xsd_set_ = false;

  /**
   * The default value of the '{@link #getChangeSummary() <em>Change Summary</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChangeSummary()
   * @generated
   * @ordered
   */
  protected static final ChangeSummary CHANGE_SUMMARY_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getChangeSummary() <em>Change Summary</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChangeSummary()
   * @generated
   * @ordered
   */
  protected ChangeSummary changeSummary = CHANGE_SUMMARY_DEFAULT_;

  /**
   * This is true if the Change Summary attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean changeSummary_set_ = false;

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
  public BaseDataGraphTypeImpl()
  {
    super();
    createChangeSummary(CHANGE_SUMMARY);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getStaticType()
  {
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).getBaseDataGraphType();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelsType getModels()
  {
    return models;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetModels(ModelsType newModels, ChangeContext changeContext)
  {
    ModelsType oldModels = models;
    models = newModels;
    boolean oldModels_set_ = models_set_;
    models_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_MODELS, oldModels, newModels, !oldModels_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModels(ModelsType newModels)
  {
    if (newModels != models)
    {
      ChangeContext changeContext = null;
      if (models != null)
        changeContext = inverseRemove(models, this, OPPOSITE_FEATURE_BASE - INTERNAL_MODELS, null, changeContext);
      if (newModels != null)
        changeContext = inverseAdd(newModels, this, OPPOSITE_FEATURE_BASE - INTERNAL_MODELS, null, changeContext);
      changeContext = basicSetModels(newModels, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldModels_set_ = models_set_;
      models_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_MODELS, newModels, newModels, !oldModels_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetModels(ChangeContext changeContext)
  {
    ModelsType oldModels = models;
    models = null;
    boolean oldModels_set_ = models_set_;
    models_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_MODELS, oldModels, null, !oldModels_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetModels()
  {
    if (models != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(models, this, EOPPOSITE_FEATURE_BASE - INTERNAL_MODELS, null, changeContext);
      changeContext = basicUnsetModels(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldModels_set_ = models_set_;
      models_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_MODELS, null, null, oldModels_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetModels()
  {
    return models_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XSDType getXsd()
  {
    return xsd;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetXsd(XSDType newXsd, ChangeContext changeContext)
  {
    XSDType oldXsd = xsd;
    xsd = newXsd;
    boolean oldXsd_set_ = xsd_set_;
    xsd_set_ = true;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, INTERNAL_XSD, oldXsd, newXsd, !oldXsd_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setXsd(XSDType newXsd)
  {
    if (newXsd != xsd)
    {
      ChangeContext changeContext = null;
      if (xsd != null)
        changeContext = inverseRemove(xsd, this, OPPOSITE_FEATURE_BASE - INTERNAL_XSD, null, changeContext);
      if (newXsd != null)
        changeContext = inverseAdd(newXsd, this, OPPOSITE_FEATURE_BASE - INTERNAL_XSD, null, changeContext);
      changeContext = basicSetXsd(newXsd, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    {
      boolean oldXsd_set_ = xsd_set_;
      xsd_set_ = true;
      if (isNotifying())
        notify(ChangeKind.SET, INTERNAL_XSD, newXsd, newXsd, !oldXsd_set_);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicUnsetXsd(ChangeContext changeContext)
  {
    XSDType oldXsd = xsd;
    xsd = null;
    boolean oldXsd_set_ = xsd_set_;
    xsd_set_ = false;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.UNSET, INTERNAL_XSD, oldXsd, null, !oldXsd_set_, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetXsd()
  {
    if (xsd != null)
    {
      ChangeContext changeContext = null;
      changeContext = inverseRemove(xsd, this, EOPPOSITE_FEATURE_BASE - INTERNAL_XSD, null, changeContext);
      changeContext = basicUnsetXsd(changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else
    	{
      boolean oldXsd_set_ = xsd_set_;
      xsd_set_ = false;
      if (isNotifying())
        notify(ChangeKind.UNSET, INTERNAL_XSD, null, null, oldXsd_set_);
    	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetXsd()
  {
    return xsd_set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeSummary getChangeSummary()
  {
    return changeSummary;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChangeSummary(ChangeSummary newChangeSummary)
  {
    ChangeSummary oldChangeSummary = changeSummary;
    changeSummary = newChangeSummary;
    boolean oldChangeSummary_set_ = changeSummary_set_;
    changeSummary_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, INTERNAL_CHANGE_SUMMARY, oldChangeSummary, changeSummary, !oldChangeSummary_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetChangeSummary()
  {
    ChangeSummary oldChangeSummary = changeSummary;
    boolean oldChangeSummary_set_ = changeSummary_set_;
    changeSummary = CHANGE_SUMMARY_DEFAULT_;
    changeSummary_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, INTERNAL_CHANGE_SUMMARY, oldChangeSummary, CHANGE_SUMMARY_DEFAULT_, oldChangeSummary_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetChangeSummary()
  {
    return changeSummary_set_;
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
      case MODELS:
        return basicUnsetModels(changeContext);
      case XSD:
        return basicUnsetXsd(changeContext);
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
      case MODELS:
        return getModels();
      case XSD:
        return getXsd();
      case CHANGE_SUMMARY:
        return getChangeSummary();
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
      case MODELS:
        setModels((ModelsType)newValue);
        return;
      case XSD:
        setXsd((XSDType)newValue);
        return;
      case CHANGE_SUMMARY:
        setChangeSummary((ChangeSummary)newValue);
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
      case MODELS:
        unsetModels();
        return;
      case XSD:
        unsetXsd();
        return;
      case CHANGE_SUMMARY:
        unsetChangeSummary();
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
      case MODELS:
        return isSetModels();
      case XSD:
        return isSetXsd();
      case CHANGE_SUMMARY:
        return isSetChangeSummary();
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
    result.append(" (changeSummary: ");
    if (changeSummary_set_) result.append(changeSummary); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //BaseDataGraphTypeImpl
