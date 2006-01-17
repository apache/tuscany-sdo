/**
 *
 *  Copyright 2005 The Apache Software Foundation or its licensors, as applicable.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.tuscany.sdo.helper;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import commonj.sdo.DataObject;
import commonj.sdo.helper.CopyHelper;


/**
 * A helper for copying DataObjects.
 */
public class CopyHelperImpl implements CopyHelper
{
  public DataObject copyShallow(DataObject dataObject)
  {
    Copier copier = new Copier()
      {
        protected void copyContainment(EReference eReference, EObject eObject, EObject copyEObject)
        {
        }
      };
    EObject result = copier.copy((EObject)dataObject);
    copier.copyReferences();
    return (DataObject)result;
  }

  public DataObject copy(DataObject dataObject)
  {
    return (DataObject)EcoreUtil.copy((EObject)dataObject);
  }
}
