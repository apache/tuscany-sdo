/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.sdo.model.impl;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import org.apache.tuscany.sdo.model.BaseDataGraphType;
import org.apache.tuscany.sdo.model.ChangeSummaryType;
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
 *   <li>{@link org.apache.tuscany.sdo.model.impl.BaseDataGraphTypeImpl#getChangeSummary_ <em>Change Summary</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.BaseDataGraphTypeImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class BaseDataGraphTypeImpl extends DataObjectBase implements BaseDataGraphType
{
  /**
   * The feature id for the '<em><b>Models</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int MODELS = 0;

  /**
   * The feature id for the '<em><b>Xsd</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int XSD = 1;

  /**
   * The feature id for the '<em><b>Change Summary</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int CHANGE_SUMMARY = 2;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int ANY_ATTRIBUTE = 3;

  /**
   * This represents the number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  
  public final static int SDO_PROPERTY_COUNT = 4;

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
   * The cached value of the '{@link #getXsd() <em>Xsd</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXsd()
   * @generated
   * @ordered
   */
  
  protected XSDType xsd = null;
  
  /**
   * The cached value of the '{@link #getChangeSummary_() <em>Change Summary</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChangeSummary_()
   * @generated
   * @ordered
   */
  
  protected ChangeSummaryType changeSummary = null;
  
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
  protected BaseDataGraphTypeImpl()
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
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, MODELS, oldModels, newModels, changeContext);
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
        changeContext = inverseRemove(models, this, OPPOSITE_FEATURE_BASE - MODELS, null, changeContext);
      if (newModels != null)
        changeContext = inverseAdd(newModels, this, OPPOSITE_FEATURE_BASE - MODELS, null, changeContext);
      changeContext = basicSetModels(newModels, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else if (isNotifying())
      notify(ChangeKind.SET, MODELS, newModels, newModels);
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
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, XSD, oldXsd, newXsd, changeContext);
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
        changeContext = inverseRemove(xsd, this, OPPOSITE_FEATURE_BASE - XSD, null, changeContext);
      if (newXsd != null)
        changeContext = inverseAdd(newXsd, this, OPPOSITE_FEATURE_BASE - XSD, null, changeContext);
      changeContext = basicSetXsd(newXsd, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else if (isNotifying())
      notify(ChangeKind.SET, XSD, newXsd, newXsd);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeSummaryType getChangeSummary_()
  {
    return changeSummary;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeContext basicSetChangeSummary(ChangeSummaryType newChangeSummary, ChangeContext changeContext)
  {
    ChangeSummaryType oldChangeSummary = changeSummary;
    changeSummary = newChangeSummary;
    if (isNotifying())
    {
      addNotification(this, ChangeKind.SET, CHANGE_SUMMARY, oldChangeSummary, newChangeSummary, changeContext);
    }
    return changeContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChangeSummary(ChangeSummaryType newChangeSummary)
  {
    if (newChangeSummary != changeSummary)
    {
      ChangeContext changeContext = null;
      if (changeSummary != null)
        changeContext = inverseRemove(changeSummary, this, OPPOSITE_FEATURE_BASE - CHANGE_SUMMARY, null, changeContext);
      if (newChangeSummary != null)
        changeContext = inverseAdd(newChangeSummary, this, OPPOSITE_FEATURE_BASE - CHANGE_SUMMARY, null, changeContext);
      changeContext = basicSetChangeSummary(newChangeSummary, changeContext);
      if (changeContext != null) dispatch(changeContext);
    }
    else if (isNotifying())
      notify(ChangeKind.SET, CHANGE_SUMMARY, newChangeSummary, newChangeSummary);
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
      anyAttribute = createSequence(ANY_ATTRIBUTE);
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
        return basicSetModels(null, changeContext);
      case XSD:
        return basicSetXsd(null, changeContext);
      case CHANGE_SUMMARY:
        return basicSetChangeSummary(null, changeContext);
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
        return getChangeSummary_();
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
        setChangeSummary((ChangeSummaryType)newValue);
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
        setModels((ModelsType)null);
        return;
      case XSD:
        setXsd((XSDType)null);
        return;
      case CHANGE_SUMMARY:
        setChangeSummary((ChangeSummaryType)null);
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
        return models != null;
      case XSD:
        return xsd != null;
      case CHANGE_SUMMARY:
        return changeSummary != null;
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
    result.append(" (anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //BaseDataGraphTypeImpl
