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
import org.eclipse.emf.codegen.ecore.genmodel.GenDataType;
import org.eclipse.emf.codegen.ecore.genmodel.GenDelegationKind;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.impl.GenFeatureImpl;
import org.eclipse.emf.codegen.ecore.genmodel.impl.Literals;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EcorePackage;

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
        
        if (suppressNotification)
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
    }

    public static boolean hasChangeSummaryProperty(GenClass genClass)
    {
      return getChangeSummaryProperty(genClass) != null;
    }
    
    public static String getQualifiedInternalPropertyID(GenFeature genFeature)
    {
      return genFeature.getGenClass().getImportedClassName() + ".INTERNAL_" + genFeature.getUpperName();
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
    
    /*
     * EMF doesn't do what we want in all cases,  so filter the cases we need to handle
     * and drop through to EMF for all others.
     */
    public static String getStaticDefaultValue(GenFeature genFeature) {
      String result = "null";
      boolean defaultFound = false;
  
      String defaultString = genFeature.getEcoreFeature()
          .getDefaultValueLiteral();
      EClassifier eType = genFeature.getEcoreFeature().getEType();
      if (eType instanceof EDataType) {
        GenPackage genPackage = ((GenFeatureImpl) genFeature)
            .findGenPackage(genFeature.getEcoreFeature().getEType().getEPackage());
        GenDataType gdt = null;
        if (genPackage != null) {
          for (Iterator iter = genPackage.getGenDataTypes().iterator(); iter
              .hasNext()
              && gdt == null;) {
            GenDataType genDataType = (GenDataType) iter.next();
            if (eType.getName().equals(genDataType.getEcoreDataType().getName())) {
              gdt = genDataType;
            }
          }
        }
        EClassifier eDataType = gdt.getEcoreDataType();
        if (eDataType.getEPackage() != EcorePackage.eINSTANCE
            && defaultString != null) {
          boolean replaced = false;
          for (Iterator i = EcorePackage.eINSTANCE.getEClassifiers().iterator(); i
              .hasNext();) {
            EClassifier eClassifier = (EClassifier) i.next();
            if (eClassifier instanceof EDataType
                && eClassifier.getInstanceClassName().equals(
                    eDataType.getInstanceClassName())
                && ((EDataType) eClassifier).isSerializable()
                && eClassifier != EcorePackage.eINSTANCE.getEDate()) {
              replaced = true;
              eDataType = eClassifier;
              break;
            }
          }
          if (!replaced) {
            result = "((" + genPackage.getFactoryClassName() + ")"
                + genPackage.getFactoryInterfaceName() + "."
                + genPackage.getFactoryInstanceName() + ")." + "create"
                + gdt.getName() + "FromString("
                + Literals.toLiteral(defaultString) + ")";
            
  
            if (gdt.isPrimitiveType())
            {
              result = "((" + gdt.getObjectInstanceClassName() + ")" + result
                  + ")." + gdt.getPrimitiveValueFunction() + "()";
            } else if (!gdt.isObjectType()) {
              result = "(" + gdt.getImportedInstanceClassName() + ")" + result;
            }
  
            defaultFound = true;
          }
        }
      }
  
      if (!defaultFound) {
        // the input didn't match any special case that we want to handle differently
        // from EMF's default approach,  so go ahead and get EMF to do it
        result = genFeature.getStaticDefaultValue();
      }
  
      return result;
    }
}
