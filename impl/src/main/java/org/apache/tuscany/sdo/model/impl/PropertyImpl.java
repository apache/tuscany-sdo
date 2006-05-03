/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.sdo.model.impl;

import commonj.sdo.Sequence;

import java.util.Collection;
import java.util.List;


import org.apache.tuscany.sdo.impl.DataObjectImpl;
import org.apache.tuscany.sdo.model.Property;
import org.apache.tuscany.sdo.model.Type;

import org.apache.tuscany.sdo.util.BasicSequence;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.PropertyImpl#getAliasName <em>Alias Name</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.PropertyImpl#getAny <em>Any</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.PropertyImpl#isContainment <em>Containment</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.PropertyImpl#getDefault <em>Default</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.PropertyImpl#isMany <em>Many</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.PropertyImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.PropertyImpl#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.PropertyImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.PropertyImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.PropertyImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * Note: The getDefault and getOpposite methods had to be renamed to avoid
 *       conflict with the commonj.sdo.Property getDefault and getOpposite
 *       methods in classes that implement both.  Eventually, the two interfaces
 *       should be brought in-line with one another -- James Snell
 *
 * @generated
 */
public class PropertyImpl extends DataObjectImpl implements Property
{
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
   * The default value of the '{@link #isContainment() <em>Containment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isContainment()
   * @generated
   * @ordered
   */
  protected static final boolean CONTAINMENT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isContainment() <em>Containment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isContainment()
   * @generated
   * @ordered
   */
  protected boolean containment = CONTAINMENT_EDEFAULT;

  /**
   * This is true if the Containment attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean containmentESet = false;

  /**
   * The default value of the '{@link #getDefault() <em>Default</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefault()
   * @generated
   * @ordered
   */
  protected static final String DEFAULT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDefault() <em>Default</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefault()
   * @generated
   * @ordered
   */
  protected String default_ = DEFAULT_EDEFAULT;

  /**
   * The default value of the '{@link #isMany() <em>Many</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMany()
   * @generated
   * @ordered
   */
  protected static final boolean MANY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isMany() <em>Many</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMany()
   * @generated
   * @ordered
   */
  protected boolean many = MANY_EDEFAULT;

  /**
   * This is true if the Many attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean manyESet = false;

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
   * The cached value of the '{@link #getOpposite() <em>Opposite</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpposite()
   * @generated
   * @ordered
   */
  protected Property opposite = null;

  /**
   * The default value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isReadOnly()
   * @generated
   * @ordered
   */
  protected static final boolean READ_ONLY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isReadOnly()
   * @generated
   * @ordered
   */
  protected boolean readOnly = READ_ONLY_EDEFAULT;

  /**
   * This is true if the Read Only attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean readOnlyESet = false;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected Type type = null;

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
  protected PropertyImpl()
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
    return ModelPackageImpl.Literals.PROPERTY;
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
      aliasName = new EDataTypeEList(String.class, this, ModelPackageImpl.PROPERTY__ALIAS_NAME);
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
      any = new BasicSequence(new BasicFeatureMap(this, ModelPackageImpl.PROPERTY__ANY));
    }
    return any;
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
    boolean oldContainmentESet = containmentESet;
    containmentESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.PROPERTY__CONTAINMENT, oldContainment, containment, !oldContainmentESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetContainment()
  {
    boolean oldContainment = containment;
    boolean oldContainmentESet = containmentESet;
    containment = CONTAINMENT_EDEFAULT;
    containmentESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackageImpl.PROPERTY__CONTAINMENT, oldContainment, CONTAINMENT_EDEFAULT, oldContainmentESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetContainment()
  {
    return containmentESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
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
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.PROPERTY__DEFAULT, oldDefault, default_));
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
    boolean oldManyESet = manyESet;
    manyESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.PROPERTY__MANY, oldMany, many, !oldManyESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetMany()
  {
    boolean oldMany = many;
    boolean oldManyESet = manyESet;
    many = MANY_EDEFAULT;
    manyESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackageImpl.PROPERTY__MANY, oldMany, MANY_EDEFAULT, oldManyESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetMany()
  {
    return manyESet;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.PROPERTY__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Property getOpposite_()
  {
    if (opposite != null && ((EObject)opposite).eIsProxy())
    {
      InternalEObject oldOpposite = (InternalEObject)opposite;
      opposite = (Property)eResolveProxy(oldOpposite);
      if (opposite != oldOpposite)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackageImpl.PROPERTY__OPPOSITE, oldOpposite, opposite));
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
   * @generated NOT
   */
  public void setOpposite_(Property newOpposite)
  {
    Property oldOpposite = opposite;
    opposite = newOpposite;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.PROPERTY__OPPOSITE, oldOpposite, opposite));
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
    boolean oldReadOnlyESet = readOnlyESet;
    readOnlyESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.PROPERTY__READ_ONLY, oldReadOnly, readOnly, !oldReadOnlyESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetReadOnly()
  {
    boolean oldReadOnly = readOnly;
    boolean oldReadOnlyESet = readOnlyESet;
    readOnly = READ_ONLY_EDEFAULT;
    readOnlyESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, ModelPackageImpl.PROPERTY__READ_ONLY, oldReadOnly, READ_ONLY_EDEFAULT, oldReadOnlyESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetReadOnly()
  {
    return readOnlyESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getType_()
  {
    if (type != null && ((EObject)type).eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (Type)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackageImpl.PROPERTY__TYPE, oldType, type));
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
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.PROPERTY__TYPE, oldType, type));
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
      anyAttribute = new BasicSequence(new BasicFeatureMap(this, ModelPackageImpl.PROPERTY__ANY_ATTRIBUTE));
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
      case ModelPackageImpl.PROPERTY__ANY:
        return ((InternalEList)((FeatureMap.Internal.Wrapper)getAny()).featureMap()).basicRemove(otherEnd, msgs);
      case ModelPackageImpl.PROPERTY__ANY_ATTRIBUTE:
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
      case ModelPackageImpl.PROPERTY__ALIAS_NAME:
        return getAliasName();
      case ModelPackageImpl.PROPERTY__ANY:
        if (coreType) return ((FeatureMap.Internal.Wrapper)getAny()).featureMap();
        return getAny();
      case ModelPackageImpl.PROPERTY__CONTAINMENT:
        return isContainment() ? Boolean.TRUE : Boolean.FALSE;
      case ModelPackageImpl.PROPERTY__DEFAULT:
        return getDefault_();
      case ModelPackageImpl.PROPERTY__MANY:
        return isMany() ? Boolean.TRUE : Boolean.FALSE;
      case ModelPackageImpl.PROPERTY__NAME:
        return getName();
      case ModelPackageImpl.PROPERTY__OPPOSITE:
        if (resolve) return getOpposite_();
        return basicGetOpposite();
      case ModelPackageImpl.PROPERTY__READ_ONLY:
        return isReadOnly() ? Boolean.TRUE : Boolean.FALSE;
      case ModelPackageImpl.PROPERTY__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case ModelPackageImpl.PROPERTY__ANY_ATTRIBUTE:
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
      case ModelPackageImpl.PROPERTY__ALIAS_NAME:
        getAliasName().clear();
        getAliasName().addAll((Collection)newValue);
        return;
      case ModelPackageImpl.PROPERTY__ANY:
        ((FeatureMap.Internal)((FeatureMap.Internal.Wrapper)getAny()).featureMap()).set(newValue);
        return;
      case ModelPackageImpl.PROPERTY__CONTAINMENT:
        setContainment(((Boolean)newValue).booleanValue());
        return;
      case ModelPackageImpl.PROPERTY__DEFAULT:
        setDefault_((String)newValue);
        return;
      case ModelPackageImpl.PROPERTY__MANY:
        setMany(((Boolean)newValue).booleanValue());
        return;
      case ModelPackageImpl.PROPERTY__NAME:
        setName((String)newValue);
        return;
      case ModelPackageImpl.PROPERTY__OPPOSITE:
        setOpposite_((Property)newValue);
        return;
      case ModelPackageImpl.PROPERTY__READ_ONLY:
        setReadOnly(((Boolean)newValue).booleanValue());
        return;
      case ModelPackageImpl.PROPERTY__TYPE:
        setType((Type)newValue);
        return;
      case ModelPackageImpl.PROPERTY__ANY_ATTRIBUTE:
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
      case ModelPackageImpl.PROPERTY__ALIAS_NAME:
        getAliasName().clear();
        return;
      case ModelPackageImpl.PROPERTY__ANY:
        ((FeatureMap.Internal.Wrapper)getAny()).featureMap().clear();
        return;
      case ModelPackageImpl.PROPERTY__CONTAINMENT:
        unsetContainment();
        return;
      case ModelPackageImpl.PROPERTY__DEFAULT:
        setDefault_(DEFAULT_EDEFAULT);
        return;
      case ModelPackageImpl.PROPERTY__MANY:
        unsetMany();
        return;
      case ModelPackageImpl.PROPERTY__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ModelPackageImpl.PROPERTY__OPPOSITE:
        setOpposite_((Property)null);
        return;
      case ModelPackageImpl.PROPERTY__READ_ONLY:
        unsetReadOnly();
        return;
      case ModelPackageImpl.PROPERTY__TYPE:
        setType((Type)null);
        return;
      case ModelPackageImpl.PROPERTY__ANY_ATTRIBUTE:
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
      case ModelPackageImpl.PROPERTY__ALIAS_NAME:
        return aliasName != null && !aliasName.isEmpty();
      case ModelPackageImpl.PROPERTY__ANY:
        return any != null && !any.featureMap().isEmpty();
      case ModelPackageImpl.PROPERTY__CONTAINMENT:
        return isSetContainment();
      case ModelPackageImpl.PROPERTY__DEFAULT:
        return DEFAULT_EDEFAULT == null ? default_ != null : !DEFAULT_EDEFAULT.equals(default_);
      case ModelPackageImpl.PROPERTY__MANY:
        return isSetMany();
      case ModelPackageImpl.PROPERTY__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ModelPackageImpl.PROPERTY__OPPOSITE:
        return opposite != null;
      case ModelPackageImpl.PROPERTY__READ_ONLY:
        return isSetReadOnly();
      case ModelPackageImpl.PROPERTY__TYPE:
        return type != null;
      case ModelPackageImpl.PROPERTY__ANY_ATTRIBUTE:
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
    result.append(", containment: ");
    if (containmentESet) result.append(containment); else result.append("<unset>");
    result.append(", default: ");
    result.append(default_);
    result.append(", many: ");
    if (manyESet) result.append(many); else result.append("<unset>");
    result.append(", name: ");
    result.append(name);
    result.append(", readOnly: ");
    if (readOnlyESet) result.append(readOnly); else result.append("<unset>");
    result.append(", anyAttribute: ");
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //PropertyImpl
