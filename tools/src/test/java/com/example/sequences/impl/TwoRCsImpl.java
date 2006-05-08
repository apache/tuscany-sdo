/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.example.sequences.impl;

import com.example.sequences.TwoRCs;

import commonj.sdo.Sequence;
import commonj.sdo.Type;

import commonj.sdo.helper.TypeHelper;

import java.util.Collection;
import java.util.List;

import org.apache.tuscany.sdo.impl.DataObjectBase;

import org.apache.tuscany.sdo.util.BasicSequence;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Two RCs</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.example.sequences.impl.TwoRCsImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link com.example.sequences.impl.TwoRCsImpl#getA <em>A</em>}</li>
 *   <li>{@link com.example.sequences.impl.TwoRCsImpl#getB <em>B</em>}</li>
 *   <li>{@link com.example.sequences.impl.TwoRCsImpl#getSplit <em>Split</em>}</li>
 *   <li>{@link com.example.sequences.impl.TwoRCsImpl#getGroup1 <em>Group1</em>}</li>
 *   <li>{@link com.example.sequences.impl.TwoRCsImpl#getY <em>Y</em>}</li>
 *   <li>{@link com.example.sequences.impl.TwoRCsImpl#getZ <em>Z</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TwoRCsImpl extends DataObjectBase implements TwoRCs
{
  /**
   * The feature id for the '<em><b>Group</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int GROUP = 0;

  /**
   * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroup()
   * @generated
   * @ordered
   */
  
  // How to get BasicSequence from Sequence?
  
  protected BasicSequence group = null;
  
  /**
   * The feature id for the '<em><b>A</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int A = 1;

  /**
   * The feature id for the '<em><b>B</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int B = 2;

  /**
   * The feature id for the '<em><b>Split</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int SPLIT = 3;

  /**
   * The default value of the '{@link #getSplit() <em>Split</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSplit()
   * @generated
   * @ordered
   */
  protected static final String SPLIT_DEFAULT_ = null;

  /**
   * The cached value of the '{@link #getSplit() <em>Split</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSplit()
   * @generated
   * @ordered
   */
  protected String split = SPLIT_DEFAULT_;

  /**
   * The feature id for the '<em><b>Group1</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int GROUP1 = 4;

  /**
   * The cached value of the '{@link #getGroup1() <em>Group1</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroup1()
   * @generated
   * @ordered
   */
  
  // How to get BasicSequence from Sequence?
  
  protected BasicSequence group1 = null;
  
  /**
   * The feature id for the '<em><b>Y</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int Y = 5;

  /**
   * The feature id for the '<em><b>Z</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public final static int Z = 6;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TwoRCsImpl()
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
    return TypeHelper.INSTANCE.getType(TwoRCs.class); //TBD Generate a more efficient implementation
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sequence getGroup()
  {
    if (group == null)
    {
        		group = createSequence(GROUP);
        	
    }
    return group;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getA()
  {
          return getList(getGroup(), getType(), A);

  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getB()
  {
          return getList(getGroup(), getType(), B);

  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSplit()
  {
    return split;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSplit(String newSplit)
  {
    String oldSplit = split;
    split = newSplit;
    if (isNotifying())
      notify(ChangeKind.SET, SPLIT, oldSplit, split);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sequence getGroup1()
  {
    if (group1 == null)
    {
        		group1 = createSequence(GROUP1);
        	
    }
    return group1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getY()
  {
          return getList(getGroup1(), getType(), Y);

  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getZ()
  {
          return getList(getGroup1(), getType(), Z);

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
      case GROUP:
      			return removeFromSequence(getGroup(), otherEnd, changeContext);
      case GROUP1:
      			return removeFromSequence(getGroup1(), otherEnd, changeContext);
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
      case GROUP:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        		//if (coreType) 
        return getGroup();
      case A:
        return getA();
      case B:
        return getB();
      case SPLIT:
        return getSplit();
      case GROUP1:
        // XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view
        		//if (coreType) 
        return getGroup1();
      case Y:
        return getY();
      case Z:
        return getZ();
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
      case GROUP:
      	setSequence(getGroup(), newValue);
        return;
      case A:
        getA().clear();
        getA().addAll((Collection)newValue);
        return;
      case B:
        getB().clear();
        getB().addAll((Collection)newValue);
        return;
      case SPLIT:
        setSplit((String)newValue);
        return;
      case GROUP1:
      	setSequence(getGroup1(), newValue);
        return;
      case Y:
        getY().clear();
        getY().addAll((Collection)newValue);
        return;
      case Z:
        getZ().clear();
        getZ().addAll((Collection)newValue);
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
      case GROUP:
      			unsetSequence(getGroup());
        return;
      case A:
        getA().clear();
        return;
      case B:
        getB().clear();
        return;
      case SPLIT:
        setSplit(SPLIT_DEFAULT_);
        return;
      case GROUP1:
      			unsetSequence(getGroup1());
        return;
      case Y:
        getY().clear();
        return;
      case Z:
        getZ().clear();
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
      case GROUP:
        		// KDK - should this be !isSequenceEmpty?
        return group != null && !isSequenceEmpty(getGroup());
      case A:
        return !getA().isEmpty();
      case B:
        return !getB().isEmpty();
      case SPLIT:
        return SPLIT_DEFAULT_ == null ? split != null : !SPLIT_DEFAULT_.equals(split);
      case GROUP1:
        		// KDK - should this be !isSequenceEmpty?
        return group1 != null && !isSequenceEmpty(getGroup1());
      case Y:
        return !getY().isEmpty();
      case Z:
        return !getZ().isEmpty();
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
    if (isProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (group: ");
    result.append(group);
    result.append(", split: ");
    result.append(split);
    result.append(", group1: ");
    result.append(group1);
    result.append(')');
    return result.toString();
  }

} //TwoRCsImpl
