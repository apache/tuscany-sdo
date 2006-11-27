/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.simple.cs.impl;

import commonj.sdo.Type;

import org.apache.tuscany.sdo.model.ChangeSummaryType;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.example.simple.cs.CSFactory;
import org.example.simple.cs.QuoteBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Quote Base</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.example.simple.cs.impl.QuoteBaseImpl#getChanges <em>Changes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QuoteBaseImpl extends QuoteImpl implements QuoteBase
{
  /**
   * The feature id for the '<em><b>Symbol</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int SYMBOL = QuoteImpl.SYMBOL;

  /**
   * The feature id for the '<em><b>Company Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int COMPANY_NAME = QuoteImpl.COMPANY_NAME;

  /**
   * The feature id for the '<em><b>Price</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int PRICE = QuoteImpl.PRICE;

  /**
   * The feature id for the '<em><b>Open1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int OPEN1 = QuoteImpl.OPEN1;

  /**
   * The feature id for the '<em><b>High</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int HIGH = QuoteImpl.HIGH;

  /**
   * The feature id for the '<em><b>Low</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int LOW = QuoteImpl.LOW;

  /**
   * The feature id for the '<em><b>Volume</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int VOLUME = QuoteImpl.VOLUME;

  /**
   * The feature id for the '<em><b>Change1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int CHANGE1 = QuoteImpl.CHANGE1;

  /**
   * The feature id for the '<em><b>Quotes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int QUOTES = QuoteImpl.QUOTES;

  /**
   * The feature id for the '<em><b>Changes</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int CHANGES = QuoteImpl.SDO_PROPERTY_COUNT + 0;

  /**
   * This represents the number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  
  public final static int SDO_PROPERTY_COUNT = QuoteImpl.SDO_PROPERTY_COUNT + 1;

  /**
   * The cached value of the '{@link #getChanges() <em>Changes</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChanges()
   * @generated
   * @ordered
   */
  
  protected ChangeSummaryType changes = null;
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected QuoteBaseImpl()
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
    return ((CSFactoryImpl)CSFactory.INSTANCE).getQuoteBase();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeSummaryType getChanges()
  {
    if (changes != null && ((EObject)changes).isProxy())
    {
      InternalEObject oldChanges = (InternalEObject)changes;
      changes = (ChangeSummaryType)eResolveProxy(oldChanges);
      if (changes != oldChanges)
      {
        if (isNotifying())
          notify(ChangeKind.RESOLVE, CHANGES, oldChanges, changes);
      }
    }
    return changes;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeSummaryType basicGetChanges()
  {
    return changes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChanges(ChangeSummaryType newChanges)
  {
    ChangeSummaryType oldChanges = changes;
    changes = newChanges;
    if (isNotifying())
      notify(ChangeKind.SET, CHANGES, oldChanges, changes);
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
        if (resolve) return getChanges();
        return basicGetChanges();
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
        setChanges((ChangeSummaryType)newValue);
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
        setChanges((ChangeSummaryType)null);
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
        return changes != null;
    }
    return super.isSet(propertyIndex);
  }

} //QuoteBaseImpl
