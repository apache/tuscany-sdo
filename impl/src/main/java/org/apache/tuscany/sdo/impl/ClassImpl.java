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
package org.apache.tuscany.sdo.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.tuscany.sdo.SDOFactory;
import org.apache.tuscany.sdo.SDOPackage;
import org.apache.tuscany.sdo.model.ModelFactory;
import org.apache.tuscany.sdo.model.impl.ModelFactoryImpl;
import org.apache.tuscany.sdo.util.BasicSequence;
import org.apache.tuscany.sdo.util.DataObjectUtil;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ClassImpl extends EClassImpl implements Type, org.apache.tuscany.sdo.model.Type/*, DataObject*/
{
  private static final long serialVersionUID = 1L;
	
  private static final Property UNINITIALIZED_PROPERTY = SDOFactory.eINSTANCE.createAttribute();
  
  private Property changeSummaryPropertyCache = UNINITIALIZED_PROPERTY;
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  protected EClass eStaticClass()
  {
    return SDOPackage.eINSTANCE.getClass_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String getURI()
  {
    return getEPackage().getNsURI();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean isDataType()
  {
    return false;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean isOpen()
  {
    final List properties = getExtendedProperties();
    if (properties != Collections.EMPTY_LIST)
    {
      for (int i = 0, count = properties.size(); i < count; ++i)
      {
        EStructuralFeature eStructuralFeature = (EStructuralFeature)properties.get(i);
        if (isOpenFeatureMap(eStructuralFeature))
          return true;
      }
    }

    for (final Iterator iterator = getBaseTypes().iterator() ; iterator.hasNext(); )
    {
      Type baseType = (Type)iterator.next();
      if (baseType.isOpen())
        return true;
    }

    return false;
  }

  private static final EStructuralFeature UNINITIALIZED_SEQUENCE_FEATURE = (EAttribute)SDOFactory.eINSTANCE.createAttribute();
  protected static final EStructuralFeature VIRTUAL_SEQUENCE_FEATURE = (EAttribute)SDOFactory.eINSTANCE.createAttribute();
  
  private EStructuralFeature sequenceFeature = UNINITIALIZED_SEQUENCE_FEATURE;

  public EStructuralFeature getSequenceFeature()
  {
    if (sequenceFeature == UNINITIALIZED_SEQUENCE_FEATURE)
    {
      EStructuralFeature sequenceFeatureCandidate = null;
      boolean hasNonDerivedFeatures = false;
      
      for (Iterator iterator = getEAllStructuralFeatures().iterator(); iterator.hasNext(); ) 
      {
        EStructuralFeature eStructuralFeature = (EStructuralFeature)iterator.next();
        if (!eStructuralFeature.isDerived()) {
          if (sequenceFeatureCandidate == null && isSequenceFeatureMap(eStructuralFeature))
            sequenceFeatureCandidate = eStructuralFeature;
          else if (isElementFeature(eStructuralFeature) && !DataObjectUtil.isInternalProperty(eStructuralFeature))
            hasNonDerivedFeatures = true;
        }
      }
      
      sequenceFeature = 
        sequenceFeatureCandidate != null && hasNonDerivedFeatures ? 
          VIRTUAL_SEQUENCE_FEATURE : 
          sequenceFeatureCandidate;
    }
    
    return sequenceFeature;
  }
  
  protected boolean isSequenceFeatureMap(EStructuralFeature eStructuralFeature)
  {
    switch (ExtendedMetaData.INSTANCE.getFeatureKind(eStructuralFeature))
    {
      case ExtendedMetaData.ELEMENT_WILDCARD_FEATURE:
        return eStructuralFeature.getUpperBound() != 1;
      case ExtendedMetaData.GROUP_FEATURE:
        return true;
    }
    return false;
  }

  protected boolean isElementFeature(EStructuralFeature eStructuralFeature)
  {
    switch (ExtendedMetaData.INSTANCE.getFeatureKind(eStructuralFeature))
    {
      case ExtendedMetaData.ATTRIBUTE_FEATURE:
      case ExtendedMetaData.ATTRIBUTE_WILDCARD_FEATURE:
        return false;
    }
    return true;
  }
  
  public List getVirtualSequenceProperties()
  {
    List result = new ArrayList();
    for (Iterator iterator = getEAllStructuralFeatures().iterator(); iterator.hasNext(); ) 
    {
      EStructuralFeature eStructuralFeature = (EStructuralFeature)iterator.next();
      if (!eStructuralFeature.isDerived() && isElementFeature(eStructuralFeature))
        result.add(eStructuralFeature);
    }
    return result;
  }
  
  public void setSequenceFeature(EAttribute sequenceFeature)
  {
    getEStructuralFeatures().add(sequenceFeature);
    this.sequenceFeature = sequenceFeature;
  }
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean isSequenced()
  {
    return getSequenceFeature() != null;      
  }
  
  protected List aliasNames = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public List getAliasNames()
  {
    if (aliasNames == null)
    {
      aliasNames = DataObjectUtil.getAliasNames(this);
    }
    return aliasNames;
  }
  
  protected List declaredProperties = null;
  
  public List getDeclaredProperties()
  {
    if (declaredProperties == null) {
      initPropertyLists();
    }
    return declaredProperties;
  }
  
  protected List extendedProperties = null;
  
  public List getExtendedProperties()
  {
    if (extendedProperties == null) {
      initPropertyLists();
    }
    return extendedProperties;
  }
  
  protected List getTypeFeatures()
  {
    return getEStructuralFeatures();    
  }
  
  protected void initPropertyLists()
  {
    List declaredProperties = new ArrayList();
    List extendedProperties = Collections.EMPTY_LIST;
    
    for (Iterator i = getTypeFeatures().iterator(); i.hasNext(); ) {
      EStructuralFeature eStructuralFeature = (EStructuralFeature)i.next();
      boolean isExtendedProperty = DataObjectUtil.isInternalProperty(eStructuralFeature);
      if (isExtendedProperty) {
        if (extendedProperties == Collections.EMPTY_LIST)
          extendedProperties = new ArrayList();
        extendedProperties.add(eStructuralFeature);
      }
      else
        declaredProperties.add(eStructuralFeature);
    }
    this.declaredProperties = declaredProperties;
    this.extendedProperties = extendedProperties;
  }
  
  public EList getEStructuralFeatures()
  {
    if (eStructuralFeatures == null)
    {
      eStructuralFeatures = 
        new EObjectContainmentWithInverseEList(EStructuralFeature.class, this, EcorePackage.ECLASS__ESTRUCTURAL_FEATURES, EcorePackage.ESTRUCTURAL_FEATURE__ECONTAINING_CLASS)
        {
          protected void didChange()
          {
            declaredProperties = extendedProperties = null;
          }
        };
    }
    return eStructuralFeatures;
  }

  protected List allProperties = null;
  protected List allExtendedProperties = null;
  protected EList allFeaturesCache = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public List getProperties()
  {
    final EList allFeatures = getEAllStructuralFeatures();
    if (allFeatures != allFeaturesCache) 
    {
      allFeaturesCache = allFeatures;
      allProperties = allExtendedProperties = null;
    }
    if (allProperties == null)
    { 
      List allProperties = new UniqueEList();
      for (final Iterator iterator = getBaseTypes().iterator(); iterator.hasNext(); )
      {
        Type baseType = (Type)iterator.next();
        allProperties.addAll(baseType.getProperties());
      }
      allProperties.addAll(getDeclaredProperties());     
      this.allProperties = allProperties;
    }
    return allProperties;
  }

  public List getAllExtendedProperties()
  {
    final EList allFeatures = getEAllStructuralFeatures();
    if (allFeatures != allFeaturesCache) 
    {
      allFeaturesCache = allFeatures;
      allProperties = allExtendedProperties = null;
    }
    if (allExtendedProperties == null)
    {
      List allExtendedProperties = new UniqueEList();
      for (final Iterator iterator = getBaseTypes().iterator(); iterator.hasNext(); )
      {
        Type baseType = (Type)iterator.next();
        allExtendedProperties.addAll(((ClassImpl)baseType).getAllExtendedProperties());
      }
      allExtendedProperties.addAll(getExtendedProperties());     
      this.allExtendedProperties = allExtendedProperties;
    }
    return allExtendedProperties;
  }
  
  protected boolean isOpenFeatureMap(EStructuralFeature eStructuralFeature)
  {
    switch (ExtendedMetaData.INSTANCE.getFeatureKind(eStructuralFeature))
    {
      case ExtendedMetaData.ELEMENT_WILDCARD_FEATURE:
        return eStructuralFeature != ExtendedMetaData.INSTANCE.getMixedFeature(this);
      case ExtendedMetaData.ATTRIBUTE_WILDCARD_FEATURE:
      //FB I think this is wrong ... case ExtendedMetaData.GROUP_FEATURE:
        return true;
    }
    return false;
  }

  public void addOpenProperties(EObject dataObject, Collection propertyList)
  {
    for (final Iterator iterator = getBaseTypes().iterator(); iterator.hasNext(); )
    {
      ClassImpl baseType = (ClassImpl)iterator.next();
      baseType.addOpenProperties(dataObject, propertyList);
    }

    for (final Iterator iter = getExtendedProperties().iterator(); iter.hasNext(); )
    {
      EStructuralFeature eStructuralFeature = (EStructuralFeature)iter.next();
      if (isOpenFeatureMap(eStructuralFeature))
      {
        List features = (List)dataObject.eGet(eStructuralFeature);
        for (int j = 0, size = features.size(); j < size; ++j)
        {
          FeatureMap.Entry entry = (FeatureMap.Entry)features.get(j);
          EStructuralFeature entryFeature = entry.getEStructuralFeature();
          Property property = BasicSequence.getFeatureProperty(entryFeature);
          if (property != null) propertyList.add(entryFeature);
        }
      }
    }
  }
  
  public Property getOpenProperty(EObject dataObject, String featureName)
  {
    for (final Iterator iterator = getBaseTypes().iterator(); iterator.hasNext(); )
    {
      ClassImpl baseType = (ClassImpl)iterator.next();
      Property result = baseType.getOpenProperty(dataObject, featureName);
      if (result != null) return result;
    }
    
    Set openFeatureSet = new HashSet();
    for (final Iterator iter = getExtendedProperties().iterator(); iter.hasNext(); )
    {
      EStructuralFeature eStructuralFeature = (EStructuralFeature)iter.next();
      //if (isOpenFeatureMap(eStructuralFeature)) 
      //FB The above check excludes subsitition groups - i.e., doesn't support dObj.get("element.substitution")
      if (FeatureMapUtil.isFeatureMap(eStructuralFeature))
      {
        List features = (List)dataObject.eGet(eStructuralFeature);
        for (int j = 0, size = features.size(); j < size; ++j)
        {
          FeatureMap.Entry entry = (FeatureMap.Entry)features.get(j);
          EStructuralFeature entryFeature = entry.getEStructuralFeature();
          if (openFeatureSet.add(entryFeature))
          {
            Property property = BasicSequence.getFeatureProperty(entryFeature);
            if (property != null)
            {
              if (property.getName().equals(featureName)) return (Property)entryFeature;
               List aliasNames = property.getAliasNames();
              for (int aliasCount = aliasNames.size(); aliasCount > 0; )
              {
                if (aliasNames.get(--aliasCount).equals(featureName)) return (Property)entryFeature;
              }
            }
          }
        }
      }
    }
    
    return null;
  }
  
  /*
  public Property getOpenProperty(DataObject dataObject, String featureName)
  {
    EObject eObject = (EObject)dataObject;
    EClass eClass = eObject.eClass();
    Set openFeatureSet = new HashSet();
    for (int i = 0, count = eClass.getEAllStructuralFeatures().size(); i < count; ++i)
    {
      EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(i);
      if (FeatureMapUtil.isFeatureMap(eStructuralFeature))
      {
        List features = (List)eObject.eGet(eStructuralFeature);
        for (int j = 0, size = features.size(); j < size; ++j)
        {
          FeatureMap.Entry entry = (FeatureMap.Entry)features.get(j);
          EStructuralFeature entryFeature = entry.getEStructuralFeature();
          if (openFeatureSet.add(entryFeature))
          {
            Property property = (Property)entryFeature;
            if (property.getName().equals(featureName)) return (Property)entryFeature;
  
            List aliasNames = property.getAliasNames();
            for (int aliasCount = aliasNames.size(); aliasCount > 0; )
            {
              if (aliasNames.get(--aliasCount).equals(featureName)) return (Property)entryFeature;
            }
          }
        }
      }
    }
    return null;
  }
  */

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public List getBaseTypes()
  {
    return getESuperTypes();
  }

  private void initAliasNames() {
    Map result = new HashMap();
    for (Iterator i = getProperties().iterator(); i.hasNext();)
    {
      Property property = (Property)i.next();
      result.put(property.getName(), property);

      List aliasNames = property.getAliasNames();
      for (int count = aliasNames.size(); count > 0;)
      {
        result.put(aliasNames.get(--count), property);
      }
    }
    propertyNameToPropertyMap = result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Property getProperty(String propertyName)
  {
    if (propertyNameToPropertyMap == null) initAliasNames();
    Property property = (Property)propertyNameToPropertyMap.get(propertyName);
    if (property == null && !isOpen()) {
      initAliasNames();
      property = (Property)propertyNameToPropertyMap.get(propertyName);
    }
    return property;
  }
  
  protected Map propertyNameToPropertyMap;
  
  public List getInstanceProperties() {
    return DataObjectUtil.getMetaObjectInstanceProperties(this);
  }

  public Object get(Property property) {
    return DataObjectUtil.getMetaObjectInstanceProperty(this, property);
  }
  
  /////////////////////////////////////////////////////////////////////////////////////////////////////////
  // org.apache.tuscany.sdo.model.Type method implementations
  /////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  public List getBaseType() {
    return this.getBaseTypes();
  }

  public List getProperty() {
    return this.getProperties();
  }

  public List getAliasName() {
    return this.getAliasNames();
  }

  public void unsetAbstract() {
    eUnset(EcorePackage.eINSTANCE.getEClass_Abstract());
  }

  public boolean isSetAbstract() {
    return eIsSet(EcorePackage.eINSTANCE.getEClass_Abstract());
  }
  
  public Sequence getAny() {
    throw new UnsupportedOperationException();
  }

  public Sequence getAnyAttribute() {
    throw new UnsupportedOperationException();
  }
  
  public void setDataType(boolean value) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public void unsetDataType() {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public boolean isSetDataType() {
    return false;
  }

  public void setOpen(boolean value) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public void unsetOpen() {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public boolean isSetOpen() {
    return isOpen();
  }

  public void setSequenced(boolean value) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public void unsetSequenced() {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public boolean isSetSequenced() {
    return isSequenced();
  }

  public void unsetName()
  {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public boolean isSetName()
  {
    return true;
  }
  
  public void unsetUri()
  {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public boolean isSetUri()
  {
    return true;
  }

  public void setUri(String value) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }
  
  public String getUri() {
    return getURI();
  }

  public Property getChangeSummaryProperty() {
    if (changeSummaryPropertyCache == UNINITIALIZED_PROPERTY) {
      changeSummaryPropertyCache = null;

      // Find property of type ChangeSummaryType, if one exists
      Type csType = ((ModelFactoryImpl)ModelFactory.INSTANCE).getChangeSummaryType();
      for (Iterator props = getProperties().iterator(); props.hasNext(); ) {
        Property p = (Property)props.next();
        if(csType == p.getType()) {
          changeSummaryPropertyCache = p;
          break;
        }
      }
    }

    return changeSummaryPropertyCache;
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////
  // DataObject method implementations
  /////////////////////////////////////////////////////////////////////////////////////////////////////////
  /*
  public Object get(int propertyIndex) {
    return DataObjectUtil.get(this, propertyIndex);
  }
  
  public void set(int propertyIndex, Object value) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public boolean isSet(int propertyIndex) {
    return DataObjectUtil.isSet(this, propertyIndex);
  }

  public void unset(int propertyIndex) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }
  
  public Object get(Property property) {
    return DataObjectUtil.get(this, ((EStructuralFeature)property).getFeatureID());
  }
  
  public void set(Property property, Object value) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public boolean isSet(Property property) {
    return DataObjectUtil.isSet(this, ((EStructuralFeature)property).getFeatureID());
  }

  public void unset(Property property) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }
  
  public DataObject getContainer() {
    return (DataObject)eContainer();
  }

  public Property getContainmentProperty() {
    return (Property)eContainmentFeature();
  }

  public Type getType() {
    return (Type)ModelPackageImpl.eINSTANCE.getType();
  }
  
  // Remaining DataObject methods are (will be) implemented as straight delegation to DataObjectUtil

  public Object get(String path) {
    return DataObjectUtil.get(this, path);
  }
  
  public void set(String path, Object value) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public boolean isSet(String path) {
    return DataObjectUtil.isSet(this, path);
  }

  public void unset(String path) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public boolean getBoolean(String path) {
    return DataObjectUtil.getBoolean(get(path));
  }

  public byte getByte(String path) {
    return DataObjectUtil.getByte(get(path));
  }

  public char getChar(String path) {
    return DataObjectUtil.getChar(get(path));
  }

  public double getDouble(String path) {
    return DataObjectUtil.getDouble(get(path));
  }

  public float getFloat(String path) {
    return DataObjectUtil.getFloat(get(path));
  }

  public int getInt(String path) {
    return DataObjectUtil.getInt(get(path));
  }

  public long getLong(String path) {
    return DataObjectUtil.getLong(get(path));
  }

  public short getShort(String path) {
    return DataObjectUtil.getShort(get(path));
  }

  public byte[] getBytes(String path) {
    return DataObjectUtil.getBytes(get(path));
  }

  public BigDecimal getBigDecimal(String path) {
    return DataObjectUtil.getBigDecimal(get(path));
  }

  public BigInteger getBigInteger(String path) {
    return DataObjectUtil.getBigInteger(get(path));
  }

  public DataObject getDataObject(String path) {
    return (DataObject)get(path);
  }

  public Date getDate(String path) {
    return DataObjectUtil.getDate(get(path));
  }

  public String getString(String path) {
    return DataObjectUtil.getString(get(path));
  }

  public List getList(String path) {
    return (List)get(path);
  }

  public Sequence getSequence(String path) {
    return (Sequence)get(path);
  }

  public void setBoolean(String path, boolean value) {
    set(path, new Boolean(value));
  }

  public void setByte(String path, byte value) {
    set(path, new Byte(value));
  }

  public void setChar(String path, char value) {
    set(path, new Character(value));
  }

  public void setDouble(String path, double value) {
    set(path, new Double(value));
  }

  public void setFloat(String path, float value) {
    set(path, new Float(value));
  }

  public void setInt(String path, int value) {
    set(path, new Integer(value));
  }

  public void setLong(String path, long value) {
    set(path, new Long(value));
  }

  public void setShort(String path, short value) {
    set(path, new Short(value));
  }

  public void setBytes(String path, byte[] value) {
    set(path, value);
  }

  public void setBigDecimal(String path, BigDecimal value) {
    set(path, value);
  }

  public void setBigInteger(String path, BigInteger value) {
    set(path, value);
  }

  public void setDataObject(String path, DataObject value) {
    set(path, value);
  }

  public void setDate(String path, Date value) {
    set(path, value);
  }

  public void setString(String path, String value) {
    set(path, value);
  }

  public void setList(String path, List value) {
    set(path, value);
  }

  public boolean getBoolean(int propertyIndex) {
    return DataObjectUtil.getBoolean(this, propertyIndex);
  }

  public byte getByte(int propertyIndex) {
    return DataObjectUtil.getByte(this, propertyIndex);
  }

  public char getChar(int propertyIndex) {
    return DataObjectUtil.getChar(this, propertyIndex);
  }

  public double getDouble(int propertyIndex) {
    return DataObjectUtil.getDouble(this, propertyIndex);
  }

  public float getFloat(int propertyIndex) {
    return DataObjectUtil.getFloat(this, propertyIndex);
  }

  public int getInt(int propertyIndex) {
    return DataObjectUtil.getInt(this, propertyIndex);
  }

  public long getLong(int propertyIndex) {
    return DataObjectUtil.getLong(this, propertyIndex);
  }

  public short getShort(int propertyIndex) {
    return DataObjectUtil.getShort(this, propertyIndex);
  }

  public byte[] getBytes(int propertyIndex) {
    return DataObjectUtil.getBytes(this, propertyIndex);
  }

  public BigDecimal getBigDecimal(int propertyIndex) {
    return DataObjectUtil.getBigDecimal(this, propertyIndex);
  }

  public BigInteger getBigInteger(int propertyIndex) {
    return DataObjectUtil.getBigInteger(this, propertyIndex);
  }

  public DataObject getDataObject(int propertyIndex) {
    return DataObjectUtil.getDataObject(this, propertyIndex);
  }

  public Date getDate(int propertyIndex) {
    return DataObjectUtil.getDate(this, propertyIndex);
  }

  public String getString(int propertyIndex) {
    return DataObjectUtil.getString(this, propertyIndex);
  }

  public List getList(int propertyIndex) {
    return DataObjectUtil.getList(this, propertyIndex);
  }

  public Sequence getSequence(int propertyIndex) {
    return DataObjectUtil.getSequence(this, propertyIndex);
  }

  public void setBoolean(int propertyIndex, boolean value) {
    set(propertyIndex, new Boolean(value));
  }

  public void setByte(int propertyIndex, byte value) {
    set(propertyIndex, new Byte(value));
  }

  public void setChar(int propertyIndex, char value) {
    set(propertyIndex, new Character(value));
  }

  public void setDouble(int propertyIndex, double value) {
    set(propertyIndex, new Double(value));
  }

  public void setFloat(int propertyIndex, float value) {
    set(propertyIndex, new Float(value));
  }

  public void setInt(int propertyIndex, int value) {
    set(propertyIndex, new Integer(value));
  }

  public void setLong(int propertyIndex, long value) {
    set(propertyIndex, new Long(value));
  }

  public void setShort(int propertyIndex, short value) {
    set(propertyIndex, new Short(value));
  }

  public void setBytes(int propertyIndex, byte[] value) {
    set(propertyIndex, value);
  }

  public void setBigDecimal(int propertyIndex, BigDecimal value) {
    set(propertyIndex, value);
  }

  public void setBigInteger(int propertyIndex, BigInteger value) {
    set(propertyIndex, value);
  }

  public void setDataObject(int propertyIndex, DataObject value) {
    set(propertyIndex, value);
  }

  public void setDate(int propertyIndex, Date value) {
    set(propertyIndex, value);
  }

  public void setString(int propertyIndex, String value) {
    set(propertyIndex, value);
  }

  public void setList(int propertyIndex, List value) {
    set(propertyIndex, value);
  }

  public boolean getBoolean(Property property) {
    return DataObjectUtil.getBoolean(this, property);
  }

  public byte getByte(Property property) {
    return DataObjectUtil.getByte(this, property);
  }

  public char getChar(Property property) {
    return DataObjectUtil.getChar(this, property);
  }

  public double getDouble(Property property) {
    return DataObjectUtil.getDouble(this, property);
  }

  public float getFloat(Property property) {
    return DataObjectUtil.getFloat(this, property);
  }

  public int getInt(Property property) {
    return DataObjectUtil.getInt(this, property);
  }

  public long getLong(Property property) {
    return DataObjectUtil.getLong(this, property);
  }

  public short getShort(Property property) {
    return DataObjectUtil.getShort(this, property);
  }

  public byte[] getBytes(Property property) {
    return DataObjectUtil.getBytes(this, property);
  }

  public BigDecimal getBigDecimal(Property property) {
    return DataObjectUtil.getBigDecimal(this, property);
  }

  public BigInteger getBigInteger(Property property) {
    return DataObjectUtil.getBigInteger(this, property);
  }

  public DataObject getDataObject(Property property) {
    return DataObjectUtil.getDataObject(this, property);
  }

  public Date getDate(Property property) {
    return DataObjectUtil.getDate(this, property);
  }

  public String getString(Property property) {
    return DataObjectUtil.getString(this, property);
  }

  public List getList(Property property) {
    return DataObjectUtil.getList(this, property);
  }

  public Sequence getSequence(Property property) {
    return DataObjectUtil.getSequence(this, property);
  }

  public void setBoolean(Property property, boolean value) {
    set(property, new Boolean(value));
  }

  public void setByte(Property property, byte value) {
    set(property, new Byte(value));
  }

  public void setChar(Property property, char value) {
    set(property, new Character(value));
  }

  public void setDouble(Property property, double value) {
    set(property, new Double(value));
  }

  public void setFloat(Property property, float value) {
    set(property, new Float(value));
  }

  public void setInt(Property property, int value) {
    set(property, new Integer(value));
  }

  public void setLong(Property property, long value) {
    set(property, new Long(value));
  }

  public void setShort(Property property, short value) {
    set(property, new Short(value));
  }

  public void setBytes(Property property, byte[] value) {
    set(property, value);
  }

  public void setBigDecimal(Property property, BigDecimal value) {
    set(property, value);
  }

  public void setBigInteger(Property property, BigInteger value) {
    set(property, value);
  }

  public void setDataObject(Property property, DataObject value) {
    set(property, value);
  }

  public void setDate(Property property, Date value) {
    set(property, value);
  }

  public void setString(Property property, String value) {
    set(property, value);
  }

  public void setList(Property property, List value) {
    set(property, value);
  }

  public DataObject createDataObject(String propertyName) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public DataObject createDataObject(int propertyIndex) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public DataObject createDataObject(Property property) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public DataObject createDataObject(String propertyName, String namespaceURI, String typeName) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public DataObject createDataObject(int propertyIndex, String namespaceURI, String typeName) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public DataObject createDataObject(Property property, Type type) {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public void delete() {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
  }

  public DataGraph getDataGraph() {
    return DataObjectUtil.getDataGraph(this);
  }

  public Sequence getSequence() {
    EAttribute mixedFeature = BasicExtendedMetaData.INSTANCE.getMixedFeature(eClass());
    return mixedFeature != null ? (Sequence)eGet(mixedFeature, true, false) : null;
  }

  public List getInstanceProperties() {
    return DataObjectUtil.getInstanceProperties(this);
  }

  public DataObject getRootObject() {
    return DataObjectUtil.getRootObject(this);
  }

  public ChangeSummary getChangeSummary() {
    // TODO: implement this method
    throw new UnsupportedOperationException();
  }

  public void detach() {
    throw new UnsupportedOperationException("Type is frozen and cannot be modified");
    //DataObjectUtil.detach(this);
  }
  */

} //ClassTypeImpl
