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

import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;

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
 

}
