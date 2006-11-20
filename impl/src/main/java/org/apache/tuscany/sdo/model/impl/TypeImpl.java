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
  /**
   * The feature id for the '<em><b>Base Type</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int BASE_TYPE = 0;

  /**
   * The feature id for the '<em><b>Property</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int PROPERTY = 1;

  /**
   * The feature id for the '<em><b>Alias Name</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int ALIAS_NAME = 2;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int ANY = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int NAME = 4;

  /**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int URI = 5;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int DATA_TYPE = 6;

  /**
   * The feature id for the '<em><b>Open</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int OPEN = 7;

  /**
   * The feature id for the '<em><b>Sequenced</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int SEQUENCED = 8;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int ABSTRACT = 9;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */	 
  public final static int ANY_ATTRIBUTE = 10;

  /**
   * This represents the number of properties for this type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  
  public final static int SDO_PROPERTY_COUNT = 11;

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
  protected TypeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public commonj.sdo.Type getType()
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
      baseType = createPropertyList(ListKind.CONTAINMENT, Type.class, BASE_TYPE);
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
      property = createPropertyList(ListKind.CONTAINMENT, Property.class, PROPERTY);
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
      aliasName = createPropertyList(ListKind.CONTAINMENT, String.class, ALIAS_NAME);
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
      any = createSequence(ANY);
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
    if (isNotifying())
      notify(ChangeKind.SET, NAME, oldName, name);
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
    if (isNotifying())
      notify(ChangeKind.SET, URI, oldUri, uri);
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
      notify(ChangeKind.SET, DATA_TYPE, oldDataType, dataType, !oldDataType_set_);
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
      notify(ChangeKind.UNSET, DATA_TYPE, oldDataType, DATA_TYPE_DEFAULT_, oldDataType_set_);
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
      notify(ChangeKind.SET, OPEN, oldOpen, open, !oldOpen_set_);
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
      notify(ChangeKind.UNSET, OPEN, oldOpen, OPEN_DEFAULT_, oldOpen_set_);
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
      notify(ChangeKind.SET, SEQUENCED, oldSequenced, sequenced, !oldSequenced_set_);
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
      notify(ChangeKind.UNSET, SEQUENCED, oldSequenced, SEQUENCED_DEFAULT_, oldSequenced_set_);
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
      notify(ChangeKind.SET, ABSTRACT, oldAbstract, abstract_, !oldAbstract_set_);
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
      notify(ChangeKind.UNSET, ABSTRACT, oldAbstract, ABSTRACT_DEFAULT_, oldAbstract_set_);
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
        setName(NAME_DEFAULT_);
        return;
      case URI:
        setUri(URI_DEFAULT_);
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
        return NAME_DEFAULT_ == null ? name != null : !NAME_DEFAULT_.equals(name);
      case URI:
        return URI_DEFAULT_ == null ? uri != null : !URI_DEFAULT_.equals(uri);
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
    result.append(name);
    result.append(", uri: ");
    result.append(uri);
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
    //FB EStructuralFeature javaClassFeature = JavaFactory.getGlobal_JavaClass();
    //FB TODO figure out proper way to access global properties
    if (javaClassFeature == null)
    {
      javaClassFeature = BasicExtendedMetaData.INSTANCE.getAttribute("commonj.sdo/java", "javaClass");
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
