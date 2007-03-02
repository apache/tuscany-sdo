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
package org.apache.tuscany.sdo.generate.util;

import java.util.Iterator;

import org.apache.tuscany.sdo.model.ModelFactory;
import org.apache.tuscany.sdo.model.impl.ModelFactoryImpl;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenDelegationKind;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.ecore.EClassifier;

import commonj.sdo.Type;

public class SDOGenUtil {
	
	public static String getQualifiedTypeAccessor(GenClassifier genClassifier)
    {
	  GenPackage genPackage = genClassifier.getGenPackage();
	  return getFactoryImpl(genPackage) + ".get" + genClassifier.getClassifierAccessorName() + "()";
	}
    
    public static String getDependentFactoryArgumentList(GenPackage genPackage, boolean isFormalArguments)
    {
      StringBuffer result = new StringBuffer();
      for (Iterator iter = genPackage.getPackageInitializationDependencies().iterator(); iter.hasNext(); )
      {
        GenPackage dep = (GenPackage)iter.next();
        if (isFormalArguments)
        {
          result.append(dep.getImportedFactoryClassName());
          result.append(" ");
        }
        result.append(genPackage.getPackageInstanceVariable(dep));
        if (iter.hasNext()) result.append(", ");
      }
      return result.toString();
    }

    public static String getFactoryImpl(GenPackage genPackage)
    {
      return "((" + genPackage.getImportedFactoryClassName() + ")" 
        + genPackage.getImportedFactoryInterfaceName() + ".INSTANCE)";
    }
 
    public static String getListKind(GenFeature genFeature, boolean suppressNotification )
    {
        boolean unsettable = genFeature.isUnsettable();
        
        if(suppressNotification)
        {
            return "ListKind.BASIC";
        }
        else if (genFeature.isEffectiveContains())
        {
            if (genFeature.isBidirectional())
            {
                if (genFeature.isResolveProxies())
                {
                    if( unsettable )
                        return "ListKind.CONTAINMENT_INVERSE_RESOLVING_UNSETTABLE";
                    else
                        return "ListKind.CONTAINMENT_INVERSE_RESOLVING";
                }
                else
                {
                    if( unsettable )
                        return "ListKind.CONTAINMENT_INVERSE_UNSETTABLE";
                    else
                        return "ListKind.CONTAINMENT_INVERSE";
                }
            }
            else
            {
                if (genFeature.isBidirectional())
                {
                    if (genFeature.isResolveProxies())
                    {
                        if( unsettable )
                            return "ListKind.CONTAINMENT_RESOLVING_UNSETTABLE";
                        else
                            return "ListKind.CONTAINMENT_RESOLVING";
                    }
                    else
                    {
                        if( unsettable )
                            return "ListKind.CONTAINMENT_UNSETTABLE";
                        else
                            return "ListKind.CONTAINMENT";
                    }
                }
            }
        }
        else if (genFeature.isReferenceType())
        {
            if (genFeature.isBidirectional())
            {
                GenFeature reverseFeature = genFeature.getReverse();
                if (genFeature.isResolveProxies())
                {
                    if (reverseFeature.isListType())
                    {
                        if( unsettable )
                            return "ListKind.NONCONTAINMENT_MANYINVERSE_RESOLVING_UNSETTABLE";
                        else
                            return "ListKind.NONCONTAINMENT_MANYINVERSE_RESOLVING";
                    }
                    else
                    {
                        if( unsettable )
                            return "ListKind.NONCONTAINMENT_INVERSE_RESOLVING_UNSETTABLE";
                        else
                            return "ListKind.NONCONTAINMENT_INVERSE_RESOLVING";
                    }
                }
                else
                {
                    if (reverseFeature.isListType())
                    {
                        if( unsettable )
                            return "ListKind.NONCONTAINMENT_MANYINVERSE_UNSETTABLE";
                        else
                            return "ListKind.NONCONTAINMENT_MANYINVERSE";
                    }
                    else
                    {
                        if( unsettable )
                            return "ListKind.NONCONTAINMENT_INVERSE_UNSETTABLE";
                        else
                            return "ListKind.NONCONTAINMENT_INVERSE";
                    }
                }
            }
            else
            {
                if (genFeature.isResolveProxies())
                {
                    if( unsettable )
                        return "ListKind.NONCONTAINMENT_RESOLVING_UNSETTABLE";
                    else
                        return "ListKind.NONCONTAINMENT_RESOLVING";
                }
                else
                {
                    if( unsettable )
                        return "ListKind.NONCONTAINMENT_UNSETTABLE";
                    else
                        return "ListKind.NONCONTAINMENT";
                }
            }
        }
        else
        {   //datatype
            if (genFeature.isUnique())
            {
                if( unsettable )
                    return "ListKind.DATATYPE_UNIQUE_UNSETTABLE";
                else
                    return "ListKind.DATATYPE_UNIQUE";
            }
            else
            {
                if( unsettable )
                    return "ListKind.DATATYPE_UNSETTABLE";
                else
                    return "ListKind.DATATYPE";
            }
        }
        return "ListKind.CONTAINMENT";
    }

    public static boolean hasChangeSummaryProperty(GenClass genClass)
    {
      return getChangeSummaryProperty(genClass) != null;
    }
    
    public static String getChangeSummaryProperty(GenClass genClass)
    {
      Type csType = ((ModelFactoryImpl)ModelFactory.INSTANCE).getChangeSummaryType();
      for (Iterator i = genClass.getGenFeatures().iterator(); i.hasNext(); )
      {
        GenFeature genFeature = (GenFeature)i.next();
        EClassifier eClassifier = genFeature.getEcoreFeature().getEType();
        if (eClassifier instanceof Type)
        {
          Type type = (Type)eClassifier;
          //if (csType == type)// this doesn't work when generating sdoModel.xsd
          if (csType.getName().equals(type.getName()) && csType.getURI().equals(type.getURI()))
          {            
            return genFeature.getUpperName();
          }
        }
      }
      return null;
    }
    
    public static String printArguments(GenPackage genPackage, GenModel genModel) {
    	StringBuffer result = new StringBuffer();
    	if(!CodeGenUtil.capName(genPackage.getNSName()).equals(genPackage.getPrefix())) {
    		result.append(" -prefix " + genPackage.getPrefix());
    	}
    	if (genModel.isSuppressInterfaces()) {
    		result.append(" -noInterfaces");
    	}
    	if ( genModel.getFeatureDelegation() == GenDelegationKind.VIRTUAL_LITERAL) {
    		result.append(" -sparsePattern");
    	}
    	if ("org.apache.tuscany.sdo.impl.StoreDataObjectImpl".equals(genModel.getRootExtendsClass())) { 
    		result.append(" -storePattern");
        }
    	if (genModel.isSuppressNotification()) {
    		result.append(" -noNotification");
    	}
    	if (genModel.isSuppressContainment()) {
    		result.append(" -noContainment");
    	}
    	if (genModel.isArrayAccessors()) {
    		result.append(" -arrayAccessors");
    	}
    	if (genModel.isSuppressUnsettable()) {
    		result.append(" -noUnsettable");
    	}
    	
    	return result.toString();
    }

}
