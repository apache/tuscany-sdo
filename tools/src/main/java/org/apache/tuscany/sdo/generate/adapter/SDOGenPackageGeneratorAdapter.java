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
}
