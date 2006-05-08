package org.apache.tuscany.sdo.generate.adapter;

import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenClassGeneratorAdapter;

public class SDOGenClassGeneratorAdapter extends GenClassGeneratorAdapter {
	
	public SDOGenClassGeneratorAdapter(GeneratorAdapterFactory generatorAdapterFactory)
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
	      jetEmitterDescriptors[CLASS_ID] = new JETEmitterDescriptor("model/SDOClass.javajet", "org.apache.tuscany.sdo.generate.templates.model.SDOClass");
	  }
	    return jetEmitterDescriptors;
	}
	
}
