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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import commonj.sdo.DataObject;
import commonj.sdo.helper.EqualityHelper;


/**
 * A helper for comparing DataObjects.
 */
public class EqualityHelperImpl implements EqualityHelper
{
  public boolean equalShallow(DataObject dataObject1, DataObject dataObject2)
  {
    EcoreUtil.EqualityHelper equalityHelper = new EcoreUtil.EqualityHelper()
      {
        protected boolean haveEqualFeature(EObject eObject1, EObject eObject2, EStructuralFeature feature)
        {
          if (feature instanceof EAttribute)
          {   
              if(!("ChangeSummaryType".equals(feature.getEType().getName()) && "commonj.sdo".equals(feature.getEType().getEPackage().getNsURI()))) {
                  boolean eIsSet = eObject1.eIsSet(feature);
                  if (eIsSet != eObject2.eIsSet(feature) || !haveEqualAttribute(eObject1, eObject2, (EAttribute)feature))
                  {
                      return false;
                  }
              }
          }
          return true;
        }

        protected boolean equalFeatureMapValues(Object value1, Object value2, EStructuralFeature feature)
        {
          if (feature instanceof EAttribute)
          {
            return value1 == null ? value2 == null : value1.equals(value2);
          }
          return true;
        }
      };
    return equalityHelper.equals((EObject)dataObject1, (EObject)dataObject2);
  }

  public boolean equal(DataObject dataObject1, DataObject dataObject2)
  {
      EcoreUtil.EqualityHelper equalityHelper = new EcoreUtil.EqualityHelper()
      {
        protected boolean haveEqualAttribute(EObject eObject1, EObject eObject2, EAttribute attribute) {
            if(("ChangeSummaryType".equals(attribute.getEType().getName()) && "commonj.sdo".equals(attribute.getEType().getEPackage().getNsURI()))) {
                throw new UnsupportedOperationException("This will be implemented when change summary serialzation/deserialization is in place"); 
            } 
            else if( "Bytes".equals(attribute.getEType().getName()) ) {
                try
                {
                    byte [] value1 = (byte [])eObject1.eGet(attribute);
                    byte [] value2 = (byte [])eObject2.eGet(attribute);
                
                    return( java.util.Arrays.equals(value1,value2) );
                }
                catch(Exception ex)
                {
                    // if any exception is thrown, assumption is they are not equal
                    return false;
                }
            } 
            else {
                return super.haveEqualAttribute(eObject1, eObject2, attribute);
            }
        }
      };
    return equalityHelper.equals((EObject)dataObject1, (EObject)dataObject2);  }
}
