/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.example.simple.cs.impl;

import com.example.simple.cs.CSFactory;
import com.example.simple.cs.QuoteBase;

import commonj.sdo.ChangeSummary;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Quote Base</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.example.simple.cs.impl.QuoteBaseImpl#getChanges <em>Changes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QuoteBaseImpl extends QuoteImpl implements QuoteBase
{

  public final static int CHANGES = QuoteImpl.SDO_PROPERTY_COUNT + 0;

  public final static int SDO_PROPERTY_COUNT = QuoteImpl.SDO_PROPERTY_COUNT + 1;

  public final static int EXTENDED_PROPERTY_COUNT = QuoteImpl.EXTENDED_PROPERTY_COUNT - 0;


  /**
   * The internal feature id for the '<em><b>Symbol</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_SYMBOL = QuoteImpl.SYMBOL;

  /**
   * The internal feature id for the '<em><b>Company Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_COMPANY_NAME = QuoteImpl.COMPANY_NAME;

  /**
   * The internal feature id for the '<em><b>Price</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_PRICE = QuoteImpl.PRICE;

  /**
   * The internal feature id for the '<em><b>Open1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_OPEN1 = QuoteImpl.OPEN1;

  /**
   * The internal feature id for the '<em><b>High</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_HIGH = QuoteImpl.HIGH;

  /**
   * The internal feature id for the '<em><b>Low</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_LOW = QuoteImpl.LOW;

  /**
   * The internal feature id for the '<em><b>Volume</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_VOLUME = QuoteImpl.VOLUME;

  /**
   * The internal feature id for the '<em><b>Change1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_CHANGE1 = QuoteImpl.CHANGE1;

  /**
   * The internal feature id for the '<em><b>Quotes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_QUOTES = QuoteImpl.QUOTES;

  /**
   * The internal feature id for the '<em><b>Changes</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */ 
  public final static int INTERNAL_CHANGES = QuoteImpl.INTERNAL_PROPERTY_COUNT + 0;

  /**
   * The number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int INTERNAL_PROPERTY_COUNT = QuoteImpl.INTERNAL_PROPERTY_COUNT + 1;

  protected int internalConvertIndex(int internalIndex)
  {
    switch (internalIndex)
    {
      case INTERNAL_SYMBOL: return SYMBOL;
      case INTERNAL_COMPANY_NAME: return COMPANY_NAME;
      case INTERNAL_PRICE: return PRICE;
      case INTERNAL_OPEN1: return OPEN1;
      case INTERNAL_HIGH: return HIGH;
      case INTERNAL_LOW: return LOW;
      case INTERNAL_VOLUME: return VOLUME;
      case INTERNAL_CHANGE1: return CHANGE1;
      case INTERNAL_QUOTES: return QUOTES;
      case INTERNAL_CHANGES: return CHANGES;
    }
    return super.internalConvertIndex(internalIndex);
  }


  /**
   * The default value of the '{@link #getChanges() <em>Changes</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChanges()
   * @generated
   * @ordered
   */
  protected static final ChangeSummary CHANGES_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getChanges() <em>Changes</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChanges()
   * @generated
   * @ordered
   */
  protected ChangeSummary changes = CHANGES_DEFAULT_;

  /**
   * This is true if the Changes attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean changes_set_ = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QuoteBaseImpl()
  {
    super();
    createChangeSummary(CHANGES);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getType()
  {
    return ((CSFactoryImpl)CSFactory.INSTANCE).getQuoteBase();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeSummary getChanges()
  {
    return changes;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChanges(ChangeSummary newChanges)
  {
    ChangeSummary oldChanges = changes;
    changes = newChanges;
    boolean oldChanges_set_ = changes_set_;
    changes_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, CHANGES, oldChanges, changes, !oldChanges_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetChanges()
  {
    ChangeSummary oldChanges = changes;
    boolean oldChanges_set_ = changes_set_;
    changes = CHANGES_DEFAULT_;
    changes_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, CHANGES, oldChanges, CHANGES_DEFAULT_, oldChanges_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetChanges()
  {
    return changes_set_;
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
      case CHANGES:
        return getChanges();
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
      case CHANGES:
        setChanges((ChangeSummary)newValue);
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
      case CHANGES:
        unsetChanges();
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
      case CHANGES:
        return isSetChanges();
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
    result.append(" (changes: ");
    if (changes_set_) result.append(changes); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //QuoteBaseImpl
