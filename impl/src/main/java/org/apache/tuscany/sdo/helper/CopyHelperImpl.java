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


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import commonj.sdo.ChangeSummary;
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

        protected void copyAttribute(EAttribute eAttribute, EObject eObject, EObject copyEObject) {
            if(("ChangeSummaryType".equals(eAttribute.getEType().getName()) && "commonj.sdo".equals(eAttribute.getEType().getEPackage().getNsURI()))) {
                boolean isLogging = ((ChangeSummary)eObject.eGet(eAttribute)).isLogging();
                ChangeSummary destSum = (ChangeSummary)copyEObject.eGet(eAttribute);
                if(isLogging) {
                    if(!destSum.isLogging()) destSum.beginLogging();
                } else {
                    if(destSum.isLogging()) destSum.endLogging();
                }
            } else {
                super.copyAttribute(eAttribute, eObject, copyEObject);
            }
        }
      };
    EObject result = copier.copy((EObject)dataObject);
    copier.copyReferences();
    return (DataObject)result;
  }

  public DataObject copy(DataObject dataObject)
  {
    Copier copier = new Copier()
    {

        protected void copyAttribute(EAttribute eAttribute, EObject eObject, EObject copyEObject) {
            if(("ChangeSummaryType".equals(eAttribute.getEType().getName()) && "commonj.sdo".equals(eAttribute.getEType().getEPackage().getNsURI()))) {
                throw new UnsupportedOperationException("This will be implemented when change summary serialization/deserialization is in place");
            } else {
                super.copyAttribute(eAttribute, eObject, copyEObject);
            }
        }
    };
    EObject result = copier.copy((EObject)dataObject);
    copier.copyReferences();
    return (DataObject)result;
  }


}
