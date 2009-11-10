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
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory;
import org.eclipse.emf.common.notify.Adapter;

public class SDOGenModelGeneratorAdapterFactory extends
		GenModelGeneratorAdapterFactory {
	
	public static final GeneratorAdapterFactory.Descriptor DESCRIPTOR = new GeneratorAdapterFactory.Descriptor()
	  {
	    public GeneratorAdapterFactory createAdapterFactory()
	    {
	      return new SDOGenModelGeneratorAdapterFactory();
	    }
	  };
	  
	  public Adapter createGenClassAdapter()
	  {
	    if (genClassGeneratorAdapter == null)
	    {
	      genClassGeneratorAdapter = new SDOGenClassGeneratorAdapter(this);
	    }
	    return genClassGeneratorAdapter;
	  }
	  
	  public Adapter createGenPackageAdapter()
	  {
	    if (genPackageGeneratorAdapter == null)
	    {
	      genPackageGeneratorAdapter = new SDOGenPackageGeneratorAdapter(this);
	    }
	    return genPackageGeneratorAdapter;
	  }

    public Adapter createGenModelAdapter()
    {
      if (genModelGeneratorAdapter == null)
      {
        genModelGeneratorAdapter = new SDOGenModelGeneratorAdapter(this);
      }
      return genModelGeneratorAdapter;
    }
}
