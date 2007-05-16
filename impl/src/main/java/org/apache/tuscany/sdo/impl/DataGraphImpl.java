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


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.tuscany.sdo.SDOFactory;
import org.apache.tuscany.sdo.SDOPackage;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;
import org.apache.tuscany.sdo.lib.SDOObjectInputStream;
import org.apache.tuscany.sdo.util.DataObjectUtil;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import commonj.sdo.ChangeSummary;
import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.TypeHelper;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EData Graph</b></em>'.
 * @extends DataGraph, Adapter, Serializable
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.sdo.impl.DataGraphImpl#getResourceSet <em>Resource Set</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.impl.DataGraphImpl#getRootResource <em>Root Resource</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.impl.DataGraphImpl#getEChangeSummary <em>EChange Summary</em>}</li>
 *   <li>{@link org.apache.tuscany.sdo.impl.DataGraphImpl#getERootObject <em>ERoot Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataGraphImpl extends EObjectImpl implements DataGraph, Adapter, Serializable
{
  /**
   * The default value of the '{@link #getResourceSet() <em>Resource Set</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResourceSet()
   * @generated
   * @ordered
   */
  protected static final ResourceSet RESOURCE_SET_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getResourceSet() <em>Resource Set</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResourceSet()
   * @generated
   * @ordered
   */
  protected ResourceSet resourceSet = RESOURCE_SET_EDEFAULT;

  /**
   * The default value of the '{@link #getRootResource() <em>Root Resource</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRootResource()
   * @generated
   * @ordered
   */
  protected static final Resource ROOT_RESOURCE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEChangeSummary() <em>EChange Summary</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEChangeSummary()
   * @generated
   * @ordered
   */
  protected ChangeSummary eChangeSummary = null;

  /**
   * The cached value of the '{@link #getERootObject() <em>ERoot Object</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getERootObject()
   * @generated
   * @ordered
   */
  protected EObject eRootObject = null;

  /**
   * The cached extended metadata to wrap the resource set's package registry.
   */
  protected ExtendedMetaData extendedMetaData;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DataGraphImpl()
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
    return SDOPackage.eINSTANCE.getDataGraph();
  }

  public boolean isAdapterForType(Object type)
  {
    return type == DataGraph.class;
  }

  public void notifyChanged(Notification msg)
  {
  }

  public Notifier getTarget()
  {
    return getResourceSet();
  }

  public void setTarget(Notifier newTarget)
  {
  }

  protected ExtendedMetaData getExtendedMetaData()
  {
    if (extendedMetaData == null)
    {
      getResourceSet();
    }
    return extendedMetaData;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public ResourceSet getResourceSet()
  {
    if (resourceSet == null)
    {
      if (eResource() != null)
      {
        resourceSet = eResource().getResourceSet();
      }
      if (resourceSet == null)
      {
        resourceSet = createResourceSet();
      }
      initializeResourceSet(resourceSet);
    }
    return resourceSet;
  }

  protected ResourceSet createResourceSet()
  {
    return DataObjectUtil.createResourceSet();
  }

  protected Resource createRootResource()
  {
    Resource result = resourceSet.createResource(URI.createURI("root.xml"));
    result.getContents().clear();
    return result;
  }

  protected Resource createChangeSummaryResource()
  {
    Resource result = resourceSet.createResource(URI.createURI("change-summary.xml"));
    result.getContents().clear();
    return result;
  }

  protected void initializeResourceSet(ResourceSet resourceSet)
  {
    if (resourceSet == null)
    {
      extendedMetaData = null;
    }
    else
    {
      extendedMetaData = new BasicExtendedMetaData(resourceSet.getPackageRegistry());
      resourceSet.eAdapters().add(this);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setResourceSetGen(ResourceSet newResourceSet)
  {
    ResourceSet oldResourceSet = resourceSet;
    resourceSet = newResourceSet;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SDOPackage.DATA_GRAPH__RESOURCE_SET, oldResourceSet, resourceSet));
  }

  public void setResourceSet(ResourceSet newResourceSet)
  {
    if (resourceSet != null)
    {
      resourceSet.eAdapters().remove(this);
    }
    setResourceSetGen(newResourceSet);
    initializeResourceSet(newResourceSet);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Resource getRootResource()
  {
    if (eRootObject == null)
    {
      Resource result = getResourceSet().getResource(URI.createURI("root.xml"), false);
      if (result == null)
      {
        result = createRootResource();
      }

      return result;
    }
    else
    {
      return eRootObject.eResource();
    }
  }

  public Resource getDataGraphResource()
  {
    Resource result = eResource();
    if (result == null)
    {
      result = getResourceSet().createResource(URI.createURI("all.datagraph"));
      result.getContents().add(this);
    }
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChangeSummary getEChangeSummary()
  {
    return eChangeSummary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEChangeSummary(ChangeSummary newEChangeSummary, NotificationChain msgs)
  {
    ChangeSummary oldEChangeSummary = eChangeSummary;
    eChangeSummary = newEChangeSummary;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SDOPackage.DATA_GRAPH__ECHANGE_SUMMARY, oldEChangeSummary, newEChangeSummary);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEChangeSummary(ChangeSummary newEChangeSummary)
  {
    if (newEChangeSummary != eChangeSummary)
    {
      NotificationChain msgs = null;
      if (eChangeSummary != null)
        msgs = ((InternalEObject)eChangeSummary).eInverseRemove(this, SDOPackage.CHANGE_SUMMARY__EDATA_GRAPH, ChangeSummary.class, msgs);
      if (newEChangeSummary != null)
        msgs = ((InternalEObject)newEChangeSummary).eInverseAdd(this, SDOPackage.CHANGE_SUMMARY__EDATA_GRAPH, ChangeSummary.class, msgs);
      msgs = basicSetEChangeSummary(newEChangeSummary, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SDOPackage.DATA_GRAPH__ECHANGE_SUMMARY, newEChangeSummary, newEChangeSummary));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getERootObject()
  {
    return eRootObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setERootObjectGen(EObject newERootObject)
  {
    EObject oldERootObject = eRootObject;
    eRootObject = newERootObject;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SDOPackage.DATA_GRAPH__EROOT_OBJECT, oldERootObject, eRootObject));
  }

  public void setERootObject(EObject newERootObject)
  {
    // If there is a resource set already...
    //
    if (resourceSet != null)
    {
      // Get the root resource and if there's a root object in it already, clear it.
      // Then set the root object and add it to the root resource.
      //
      List contents = getRootResource().getContents();
      if (eRootObject != null)
      {
        contents.clear();
      }
      setERootObjectGen(newERootObject);
      if (newERootObject != null)
      {
        contents.add(newERootObject);
      }
    }
    else
    {
      // Set the root object and see if it has a resource we can reuse.
      //
      setERootObjectGen(newERootObject);
      Resource rootResource = newERootObject.eResource();
      if (rootResource != null)
      {
        // If there is no resource set
        //
        if (rootResource.getResourceSet() == null)
        {
          // Demand create one and add this resource to it.
          //
          getResourceSet().getResources().add(rootResource);
        }
        else
        {
          // Reuse the existing resource set.
          //
          setResourceSet(rootResource.getResourceSet());
        }
      }
      else
      {
        // Demand create the resource set and the root resource, and add to it's contents.
        //
        getResourceSet();
        createRootResource().getContents().add(newERootObject);
      }
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public EClassifier getEClassifier(String namespaceURI, String typeName)
  {
    ExtendedMetaData extendedMetaData = getExtendedMetaData();
    EPackage ePackage = extendedMetaData.getPackage(namespaceURI);
    if (ePackage != null)
    {
      EClassifier eClassifier = ePackage.getEClassifier(typeName);
      if (eClassifier == null)
      {
        eClassifier = extendedMetaData.getType(ePackage, typeName);
      }
      return eClassifier;
    }
    else
    {
      return null;
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Type getType(String namespaceURI, String typeName)
  {
    return TypeHelper.INSTANCE.getType(namespaceURI, typeName);
    //EClassifier eClassifier = getEClassifier(namespaceURI, typeName);
    //return eClassifier == null ? null : SDOUtil.getType(eClassifier);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs)
  {
    if (featureID >= 0)
    {
      switch (eDerivedStructuralFeatureID(featureID, baseClass))
      {
        case SDOPackage.DATA_GRAPH__ECHANGE_SUMMARY:
          if (eChangeSummary != null)
            msgs = ((InternalEObject)eChangeSummary).eInverseRemove(this, SDOPackage.CHANGE_SUMMARY__EDATA_GRAPH, ChangeSummary.class, msgs);
          return basicSetEChangeSummary((ChangeSummary)otherEnd, msgs);
        default:
          return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
      }
    }
    if (eInternalContainer() != null)
      msgs = eBasicRemoveFromContainer(msgs);
    return eBasicSetContainer(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs)
  {
    if (featureID >= 0)
    {
      switch (eDerivedStructuralFeatureID(featureID, baseClass))
      {
        case SDOPackage.DATA_GRAPH__ECHANGE_SUMMARY:
          return basicSetEChangeSummary(null, msgs);
        default:
          return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
      }
    }
    return eBasicSetContainer(null, featureID, msgs);
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
      case SDOPackage.DATA_GRAPH__RESOURCE_SET:
        return getResourceSet();
      case SDOPackage.DATA_GRAPH__ROOT_RESOURCE:
        return getRootResource();
      case SDOPackage.DATA_GRAPH__ECHANGE_SUMMARY:
        return getEChangeSummary();
      case SDOPackage.DATA_GRAPH__EROOT_OBJECT:
        return getERootObject();
    }
    return eDynamicGet(featureID, resolve, coreType);
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
      case SDOPackage.DATA_GRAPH__RESOURCE_SET:
        setResourceSet((ResourceSet)newValue);
        return;
      case SDOPackage.DATA_GRAPH__ECHANGE_SUMMARY:
        setEChangeSummary((ChangeSummary)newValue);
        return;
      case SDOPackage.DATA_GRAPH__EROOT_OBJECT:
        setERootObject((EObject)newValue);
        return;
    }
    eDynamicSet(featureID, newValue);
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
      case SDOPackage.DATA_GRAPH__RESOURCE_SET:
        setResourceSet(RESOURCE_SET_EDEFAULT);
        return;
      case SDOPackage.DATA_GRAPH__ECHANGE_SUMMARY:
        setEChangeSummary((ChangeSummary)null);
        return;
      case SDOPackage.DATA_GRAPH__EROOT_OBJECT:
        setERootObject((EObject)null);
        return;
    }
    eDynamicUnset(featureID);
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
      case SDOPackage.DATA_GRAPH__RESOURCE_SET:
        return RESOURCE_SET_EDEFAULT == null ? resourceSet != null : !RESOURCE_SET_EDEFAULT.equals(resourceSet);
      case SDOPackage.DATA_GRAPH__ROOT_RESOURCE:
        return ROOT_RESOURCE_EDEFAULT == null ? getRootResource() != null : !ROOT_RESOURCE_EDEFAULT.equals(getRootResource());
      case SDOPackage.DATA_GRAPH__ECHANGE_SUMMARY:
        return eChangeSummary != null;
      case SDOPackage.DATA_GRAPH__EROOT_OBJECT:
        return eRootObject != null;
    }
    return eDynamicIsSet(featureID);
  }

  public DataObject createEDataObject(Type type)
  {
    return DataObjectUtil.create(type);
  }

  public DataObject getRootObject()
  {
    return (DataObject)getERootObject();
  }

  public DataObject createRootObject(String namespaceURI, String typeName)
  {
    Type type = getType(namespaceURI, typeName);
    if (type == null) {
        throw new IllegalArgumentException(
                "createRootObject given invalid parameters: getType("+
                namespaceURI+", "+typeName+") returned null type");
    }
    if (getERootObject() != null) {
        throw new IllegalStateException(
                "createRootObject was called when a root object already exists");
    }
    DataObject dataObject = DataObjectUtil.create(type);
    setERootObject((EObject)dataObject);
    return dataObject;
  }

  public DataObject createRootObject(Type type)
  {
    if (type == null) {
      throw new IllegalArgumentException(
              "createRootObject must be provided a non-null type");
    }
    if (getERootObject() != null) {
        throw new IllegalStateException(
                "createRootObject was called when a root object already exists");
    }
    DataObject dataObject = DataObjectUtil.create(type);
    setERootObject((EObject)dataObject);
    return dataObject;
  }

  public ChangeSummary getChangeSummary()
  {
    //FB is this the right place to create the resources?
    ChangeSummary changeSummary = getEChangeSummary();
    if (changeSummary == null)
    {
      getRootResource();
      changeSummary = createEChangeSummary();
      setEChangeSummary(changeSummary);
    }

    if (((ChangeSummaryImpl)changeSummary).eResource() == null)
    {
      Resource changeSummaryResource = createChangeSummaryResource();
      changeSummaryResource.getContents().add(changeSummary);
    }

    return changeSummary;
  }

  protected ChangeSummaryImpl createEChangeSummary()
  {
    return (ChangeSummaryImpl)SDOFactory.eINSTANCE.createChangeSummary();
  }

  public static class EDataGraphExternalizable implements Externalizable
  {
    protected DataGraphImpl eDataGraph;
    //protected Map writeReplacements = new HashMap();

    public EDataGraphExternalizable()
    {
    }

    public EDataGraphExternalizable(DataGraphImpl eDataGraph)
    {
      this.eDataGraph = eDataGraph;
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException
    {
      ByteArrayOutputStream byteArrayOutputStream =
        new ByteArrayOutputStream()
        {
          public byte [] toByteArray()
          {
            return super.toByteArray();
          }
        };

      eDataGraph.getDataGraphResource().save(byteArrayOutputStream, null);
      objectOutput.writeInt(byteArrayOutputStream.toByteArray().length);
      objectOutput.write(byteArrayOutputStream.toByteArray());
    }

    public void readExternal(ObjectInput objectInput) throws IOException
    {
      int length = objectInput.readInt();
      byte [] bytes = new byte [length];
      objectInput.readFully(bytes);

      ResourceSet resourceSet = createResourceSet();
      Resource resource = resourceSet.createResource(URI.createURI("all.datagraph"));

      HashMap map = null;
      if(objectInput instanceof SDOObjectInputStream)
      {
         TypeHelperImpl th = (TypeHelperImpl)((SDOObjectInputStream)objectInput).getHelperContext().getTypeHelper();
         map = new HashMap();
         map.put("EXTENDED_META_DATA", th.getExtendedMetaData());
      }
      resource.load(new ByteArrayInputStream(bytes), map);
      eDataGraph = (DataGraphImpl)resource.getContents().get(0);
    }

    protected ResourceSet createResourceSet()
    {
      return DataObjectUtil.createResourceSet();
    }

    /*
    public Object getWriteReplacement(EObject eObject)
    {
      Object result = writeReplacements.get(eObject);
      if (result == null)
      {
        result = new EDataObjectExternalizable(eDataGraph, eObject);
        writeReplacements.put(eObject, result);
      }
      return result;
    }
    */

    protected Object readResolve()
    {
      return eDataGraph;
    }
  }

  /*
  public static class EDataObjectExternalizable implements Externalizable
  {
    protected EObject eObject;
    protected DataGraphImpl eDataGraph;

    public EDataObjectExternalizable()
    {
    }

    public EDataObjectExternalizable(DataGraphImpl eDataGraph, EObject eObject)
    {
      this.eDataGraph = eDataGraph;
      this.eObject = eObject;
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException
    {
      // Write the data object reference too.
      String uri = eObject.eResource().getURIFragment(eObject);
      objectOutput.writeUTF(uri);
      objectOutput.writeObject(eDataGraph.getWriteReplacement());
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException
    {
      String uri = objectInput.readUTF();
      eDataGraph = (DataGraphImpl)objectInput.readObject();
      eObject = eDataGraph.getRootResource().getEObject(uri);
    }

    protected Object readResolve()
    {
      return eObject;
    }
  }
  */
  
  protected EDataGraphExternalizable eDataGraphExternalizable;
  //protected Adapter modificationTracker;

  public Object getWriteReplacement()
  {
    if (eDataGraphExternalizable == null)
    {
      eDataGraphExternalizable = createEDataGraphExternalizable();
      /*
      getRootResource().setTrackingModification(true);
      modificationTracker = 
        new AdapterImpl()
        {
          public void notifyChanged(Notification notification)
          {
            if (notification.getFeatureID(Resource.class) == Resource.RESOURCE__IS_MODIFIED && notification.getNewBooleanValue())
            {
              eDataGraphExternalizable = null;
              modificationTracker = null;
              ((Resource)target).eAdapters().remove(this);
            }
          }
        };
      getRootResource().eAdapters().add(modificationTracker);
      */
    }
    return eDataGraphExternalizable;
  }

  protected EDataGraphExternalizable createEDataGraphExternalizable()
  {
    return new EDataGraphExternalizable(this);
  }

  /*
  public Object getWriteReplacement(EObject eObject)
  {
    return ((EDataGraphExternalizable)getWriteReplacement()).getWriteReplacement(eObject);
  }
  */

  public Object writeReplace()
  {
    return getWriteReplacement();
  }

  public EObject eObjectForURIFragmentSegment(String uriFragmentSegment)
  {
    if (uriFragmentSegment.startsWith("@models."))
    {
      if (resourceSet != null)
      {
        int count = Integer.parseInt(uriFragmentSegment.substring(8));
        for (Iterator i = resourceSet.getResources().iterator(); i.hasNext(); )
        {
          Resource ePackageResource =  (Resource)i.next();
          List resourceContents =  ePackageResource.getContents();
          if (resourceContents.size() == 1 && resourceContents.get(0) instanceof EPackage && count-- == 0)
          {
            return (EObject)resourceContents.get(0);
          }
        }
      }

      return null;
    }
    else
    {
      return super.eObjectForURIFragmentSegment(uriFragmentSegment);
    }
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
    result.append(" (resourceSet: ");
    result.append(resourceSet);
    result.append(')');
    return result.toString();
  }

} //EDataGraphImpl
