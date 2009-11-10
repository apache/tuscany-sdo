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


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    Copier copier = new SDOCopier()
      {
        protected void copyContainment(EReference eReference, EObject eObject, EObject copyEObject)
        {
        }


      };
    return (DataObject)copier.copy((EObject)dataObject);
  }

  public DataObject copy(DataObject dataObject)
  {
    Copier copier = new SDOCopier(){

        protected void copyAttribute(EAttribute eAttribute, EObject eObject, EObject copyEObject) {
            if(("ChangeSummaryType".equals(eAttribute.getEType().getName()) && "commonj.sdo".equals(eAttribute.getEType().getEPackage().getNsURI()))) {
                throw new UnsupportedOperationException("Copying of change summary yet to be done");
            } else {
                super.copyAttribute(eAttribute, eObject, copyEObject);
            }
        }
    };
    
    return (DataObject)copier.copy((EObject)dataObject);
  }


}


class SDOCopier extends Copier {
	
	List csToTurnOn = new ArrayList();
	List csToTurnOff = new ArrayList();

	public EObject copy(EObject object) {
		
		EObject result = super.copy(object);
	    copyReferences();
		
		for (Iterator csit = csToTurnOn.iterator(); csit.hasNext();) {
			ChangeSummary cs = (ChangeSummary) csit.next();
			if(!cs.isLogging()) { cs.beginLogging(); }
		}
		for (Iterator csit = csToTurnOff.iterator(); csit.hasNext();) {
			ChangeSummary cs = (ChangeSummary) csit.next();
			if(cs.isLogging()) { cs.endLogging(); }
		}
		
		return result;
	}
	
	
	
    protected void copyAttribute(EAttribute eAttribute, EObject eObject, EObject copyEObject) {
 
    	if(("ChangeSummaryType".equals(eAttribute.getEType().getName()) && "commonj.sdo".equals(eAttribute.getEType().getEPackage().getNsURI()))) {
            if (((ChangeSummary)eObject.eGet(eAttribute)).isLogging()) {
            	csToTurnOn.add(((DataObject)copyEObject).getChangeSummary());
            } else {
            	csToTurnOff.add(((DataObject)copyEObject).getChangeSummary());
            }
            ChangeSummary copyCS = (ChangeSummary)copyEObject.eGet(eAttribute);
            if(copyCS.isLogging()) copyCS.endLogging();
            
        } else {
            super.copyAttribute(eAttribute, eObject, copyEObject);
        }
    }

}