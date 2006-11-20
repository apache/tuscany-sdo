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

import org.apache.tuscany.sdo.model.ChangeSummaryType;
import org.apache.tuscany.sdo.model.ModelFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Change Summary Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.ChangeSummaryTypeImpl#getAny <em>Any</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.ChangeSummaryTypeImpl#getCreate <em>Create</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.ChangeSummaryTypeImpl#getDelete <em>Delete</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.model.impl.ChangeSummaryTypeImpl#isLogging <em>Logging</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChangeSummaryTypeImpl extends DataObjectBase implements ChangeSummaryType
{
  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int ANY = 0;

  /**
   * The feature id for the '<em><b>Create</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int CREATE = 1;

  /**
   * The feature id for the '<em><b>Delete</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int DELETE = 2;

  /**
   * The feature id for the '<em><b>Logging</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int LOGGING = 3;

  /**
   * This represents the number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  
  public final static int SDO_PROPERTY_COUNT = 4;

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
   * The default value of the '{@link #getCreate() <em>Create</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCreate()
   * @generated
   * @ordered
   */
  protected static final String CREATE_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getCreate() <em>Create</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCreate()
   * @generated
   * @ordered
   */
  protected String create = CREATE_DEFAULT_;

  /**
   * The default value of the '{@link #getDelete() <em>Delete</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDelete()
   * @generated
   * @ordered
   */
  protected static final String DELETE_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getDelete() <em>Delete</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDelete()
   * @generated
   * @ordered
   */
  protected String delete = DELETE_DEFAULT_;

  /**
   * The default value of the '{@link #isLogging() <em>Logging</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLogging()
   * @generated
   * @ordered
   */
  protected static final boolean LOGGING_DEFAULT_ = false;

  /**
   * The cached value of the '{@link #isLogging() <em>Logging</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLogging()
   * @generated
   * @ordered
   */
  protected boolean logging = LOGGING_DEFAULT_;

  /**
   * This is true if the Logging attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean logging_set_ = false;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ChangeSummaryTypeImpl()
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
    return ((ModelFactoryImpl)ModelFactory.INSTANCE).getChangeSummaryType();
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
      any = createSequence(ANY);
    }
    return any;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCreate()
  {
    return create;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCreate(String newCreate)
  {
    String oldCreate = create;
    create = newCreate;
    if (isNotifying())
      notify(ChangeKind.SET, CREATE, oldCreate, create);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDelete()
  {
    return delete;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDelete(String newDelete)
  {
    String oldDelete = delete;
    delete = newDelete;
    if (isNotifying())
      notify(ChangeKind.SET, DELETE, oldDelete, delete);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isLogging()
  {
    return logging;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLogging(boolean newLogging)
  {
    boolean oldLogging = logging;
    logging = newLogging;
    boolean oldLogging_set_ = logging_set_;
    logging_set_ = true;
    if (isNotifying())
      notify(ChangeKind.SET, LOGGING, oldLogging, logging, !oldLogging_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetLogging()
  {
    boolean oldLogging = logging;
    boolean oldLogging_set_ = logging_set_;
    logging = LOGGING_DEFAULT_;
    logging_set_ = false;
    if (isNotifying())
      notify(ChangeKind.UNSET, LOGGING, oldLogging, LOGGING_DEFAULT_, oldLogging_set_);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetLogging()
  {
    return logging_set_;
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
      case ANY:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        //if (coreType) 
        return getAny();
      case CREATE:
        return getCreate();
      case DELETE:
        return getDelete();
      case LOGGING:
        return isLogging() ? Boolean.TRUE : Boolean.FALSE;
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
      case ANY:
      	setSequence(getAny(), newValue);
        return;
      case CREATE:
        setCreate((String)newValue);
        return;
      case DELETE:
        setDelete((String)newValue);
        return;
      case LOGGING:
        setLogging(((Boolean)newValue).booleanValue());
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
      case ANY:
        unsetSequence(getAny());
        return;
      case CREATE:
        setCreate(CREATE_DEFAULT_);
        return;
      case DELETE:
        setDelete(DELETE_DEFAULT_);
        return;
      case LOGGING:
        unsetLogging();
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
      case ANY:
        return any != null && !isSequenceEmpty(getAny());
      case CREATE:
        return CREATE_DEFAULT_ == null ? create != null : !CREATE_DEFAULT_.equals(create);
      case DELETE:
        return DELETE_DEFAULT_ == null ? delete != null : !DELETE_DEFAULT_.equals(delete);
      case LOGGING:
        return isSetLogging();
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
    result.append(" (any: ");
    result.append(any);
    result.append(", create: ");
    result.append(create);
    result.append(", delete: ");
    result.append(delete);
    result.append(", logging: ");
    if (logging_set_) result.append(logging); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //ChangeSummaryTypeImpl
