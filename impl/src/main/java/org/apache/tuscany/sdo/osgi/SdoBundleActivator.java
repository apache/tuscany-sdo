package org.apache.tuscany.sdo.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import commonj.sdo.impl.HelperProvider;

public class SdoBundleActivator implements BundleActivator {
	

	public void start(BundleContext bundleContext) throws Exception {
			
		HelperProvider.setDefaultInstance(this.getClass().getClassLoader());
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
	}
	

}
