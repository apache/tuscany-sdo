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
package org.apache.tuscany.sdo.helper;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.CopyHelper;
import commonj.sdo.helper.TypeHelper;

/**
 * A CopyHelper implementation that creates the copy objects in a specific metadata scope.
 * The target scope must contain a compatible version of the Types needed to create the copy objects.
 */
public class CrossScopeCopyHelperImpl implements CopyHelper 
{
  protected TypeHelper scope;
    
  public CrossScopeCopyHelperImpl(TypeHelper targetScope)
  {
    scope = targetScope;
  }
    
  public DataObject copyShallow(DataObject dataObject)
  {
    Copier copier = new CrossScopeCopier()
    {
      protected void copyContainment(EReference eReference, EObject eObject, EObject copyEObject)
      {
      }
      protected void copyAttribute(EAttribute eAttribute, EObject eObject, EObject copyEObject)
      {
        if (eObject.eIsSet(eAttribute) && !FeatureMapUtil.isFeatureMap(eAttribute))
		{
		  super.copyAttribute(eAttribute,eObject,copyEObject);
		}
	  }
    };
    EObject result = copier.copy((EObject)dataObject);
    copier.copyReferences();
    return (DataObject)result;
  }

  public DataObject copy(DataObject dataObject)
  {
    Copier copier = new CrossScopeCopier();
    DataObject result = (DataObject)copier.copy((EObject)dataObject);
    copier.copyReferences();
    return (DataObject)result;
  }
    
  protected class CrossScopeCopier extends EcoreUtil.Copier
  {
    protected boolean useOriginalReferences = false;
      
    protected EClass getTarget(EClass eClass)
    {
      EClass target = (EClass)get(eClass);
      if (target == null)
      {
        Type type = (Type)eClass;
        target = (EClass)scope.getType(type.getURI(), type.getName());
      }
      return target;
    }
      
    protected EStructuralFeature getTarget(EStructuralFeature eStructuralFeature)
    {
      EClass eClass = getTarget(eStructuralFeature.getEContainingClass());
      EStructuralFeature targetEf = eClass.getEStructuralFeature(eStructuralFeature.getName());
      return targetEf;
    }
    
    /**
     * This Method WILL BE REMOVED when EMF 3.0 is available
     */
    public void copyReferences()
    {
      for (Iterator i = entrySet().iterator(); i.hasNext();)
      {
        Map.Entry entry = (Map.Entry)i.next();
        EObject eObject = (EObject)entry.getKey();
        EObject copyEObject = (EObject)entry.getValue();
        EClass eClass = eObject.eClass();
        for (int j = 0, size = eClass.getFeatureCount(); j < size; ++j)
        {
          EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(j);
          if (eStructuralFeature.isChangeable() && !eStructuralFeature.isDerived())
          {
            if (eStructuralFeature instanceof EReference)
            {
              EReference eReference = (EReference)eStructuralFeature;
              if (!eReference.isContainment() && !eReference.isContainer())
              {
                copyReference(eReference, eObject, copyEObject);
              }
            }
            else if (FeatureMapUtil.isFeatureMap(eStructuralFeature))
            {
              FeatureMap featureMap = (FeatureMap)eObject.eGet(eStructuralFeature);
              FeatureMap copyFeatureMap = (FeatureMap)copyEObject.eGet(getTarget(eStructuralFeature));
              int copyFeatureMapSize = copyFeatureMap.size();
              for (int k = 0, featureMapSize = featureMap.size(); k < featureMapSize; ++k)
              {
                EStructuralFeature feature = featureMap.getEStructuralFeature(k);
                if (feature instanceof EReference)
                {
                  Object referencedEObject = featureMap.getValue(k);
                  Object copyReferencedEObject = get(referencedEObject);
                  if (copyReferencedEObject == null && referencedEObject != null)
                  {
                    EReference reference = (EReference)feature;
                    if (!useOriginalReferences || reference.isContainment() || reference.getEOpposite() != null)
                    {
                      continue;
                    }
                    copyReferencedEObject = referencedEObject;
                  }
                  // If we can't add it, it must aleady be in the list so find it and move it to the end.
                  //
                  if (!copyFeatureMap.add(feature, copyReferencedEObject))
                  {
                    for (int l = 0; l < copyFeatureMapSize; ++l) 
                    {
                      if (copyFeatureMap.getEStructuralFeature(l) == feature && copyFeatureMap.getValue(l) == copyReferencedEObject)
                      {
                        copyFeatureMap.move(copyFeatureMap.size() - 1, l);
                        --copyFeatureMapSize;
                        break;
                      }
                    }
                  }
                }
                else
                {
                  copyFeatureMap.add(featureMap.get(k));
                }
              }
            }
          }
        }
      }
    }

    /**
     * This Method WILL BE REMOVED when EMF 3.0 is available
     */
    protected void copyReference(EReference eReference, EObject eObject, EObject copyEObject)
    {
      if (eObject.eIsSet(eReference))
      {
        if (eReference.isMany())
        {
          InternalEList source = (InternalEList)eObject.eGet(eReference);
          InternalEList target = (InternalEList)copyEObject.eGet(getTarget(eReference));
          if (source.isEmpty())
          {
            target.clear();
          }
          else
          {
            boolean isBidirectional = eReference.getEOpposite() != null;
            int index = 0;
            for (Iterator k = resolveProxies ? source.iterator() : source.basicIterator(); k.hasNext();)
            {
              Object referencedEObject = k.next();
              Object copyReferencedEObject = get(referencedEObject);
              if (copyReferencedEObject == null)
              {
                if (useOriginalReferences && !isBidirectional)
                {
                  target.addUnique(index, referencedEObject);
                  ++index;
                }
              }
              else
              {
                if (isBidirectional)
                {
                  int position = target.indexOf(copyReferencedEObject);
                  if (position == -1)
                  {
                    target.addUnique(index, copyReferencedEObject);
                  }
                  else if (index != position)
                  {
                    target.move(index, copyReferencedEObject);
                  }
                }
                else
                {
                  target.addUnique(index, copyReferencedEObject);
                }
                ++index;
              }
            }
          }
        }
        else
        {
          Object referencedEObject = eObject.eGet(eReference, resolveProxies);
          if (referencedEObject == null)
          {
            copyEObject.eSet(getTarget(eReference), null);
          }
          else
          {
            Object copyReferencedEObject = get(referencedEObject);
            if (copyReferencedEObject == null)
            {
              if (useOriginalReferences && eReference.getEOpposite() == null)
              {
                copyEObject.eSet(getTarget(eReference), referencedEObject);
              }
            }
            else
            {
              copyEObject.eSet(getTarget(eReference), copyReferencedEObject);
            }
          }
        }
      }
    }
  }
}
