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
}
