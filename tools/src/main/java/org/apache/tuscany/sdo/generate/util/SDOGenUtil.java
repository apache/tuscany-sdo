/**
 *
 * Copyright 2005 The Apache Software Foundation
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
package org.apache.tuscany.sdo.generate.util;

import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;

public class SDOGenUtil {
	
	public static String getQualifiedTypeAccessor(GenClassifier genClassifier){
		GenPackage genPackage = genClassifier.getGenPackage();
		return "((" + genPackage.getImportedFactoryClassName() + ")" 
		+ genPackage.getImportedFactoryInterfaceName() + ".INSTANCE).get" + genClassifier.getClassifierAccessorName() + "()";
	}

}
