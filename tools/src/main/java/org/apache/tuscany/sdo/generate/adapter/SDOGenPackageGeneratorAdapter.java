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
package org.apache.tuscany.sdo.generate.adapter;

import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenPackageGeneratorAdapter;
import org.eclipse.emf.common.util.Monitor;

public class SDOGenPackageGeneratorAdapter extends GenPackageGeneratorAdapter 
{
	public SDOGenPackageGeneratorAdapter(GeneratorAdapterFactory generatorAdapterFactory)
	{
		super(generatorAdapterFactory);
	}

	private static JETEmitterDescriptor[] jetEmitterDescriptors; 
    
	protected JETEmitterDescriptor[] getJETEmitterDescriptors()
	{
	  if (jetEmitterDescriptors == null)
	  {
	      JETEmitterDescriptor[] base = super.getJETEmitterDescriptors();
	      jetEmitterDescriptors = new JETEmitterDescriptor[base.length];
	      System.arraycopy(base, 0, jetEmitterDescriptors, 0, base.length);
	      jetEmitterDescriptors[FACTORY_CLASS_ID] = new JETEmitterDescriptor("model/SDOFactoryClass.javajet", "org.apache.tuscany.sdo.generate.templates.model.SDOFactoryClass");
	  }
	    return jetEmitterDescriptors;
	}
	
	protected void generatePackageClass(GenPackage genPackage, Monitor monitor)
	{
		// do nothing
	}
        
        protected void ensureProjectExists(String workspacePath, Object object,
                                           Object projectType, boolean force, Monitor monitor) 
        {
                // Do nothing -- this avoids differential behaviour according to whether we
                // are running in Eclipse or not
        }        
}
