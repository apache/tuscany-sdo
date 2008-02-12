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
package org.apache.tuscany.sdo.test.osgi;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashSet;

import org.apache.tuscany.sdo.test.AllTests;
import commonj.sdo.impl.HelperProvider;

import junit.framework.Assert;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;

/*
 * This test runs the SDO implementation test suite in a multi-classloader environment
 */
public class ClassLoaderTestCase extends TestCase {
	
	private ClassLoader contextClassLoader;
	
	protected void setUp() throws Exception {

		contextClassLoader = Thread.currentThread().getContextClassLoader();
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		Thread.currentThread().setContextClassLoader(contextClassLoader);
	}
	
	// Load the test class using a separate test classloader which
	// loads SDO API, LIB and IMPL using different classloaders
	// Run the SDO test suite under this multi-classloader environment
	// Third party libraries and test classes/resources are available
	// on the thread context classloader when this test is run
	public void test() throws Exception {
		ClassLoader testClassLoader = createTestClassLoader();
		
		Class testClass = testClassLoader.loadClass(this.getClass().getName());
		Method testMethod = testClass.getMethod("runSDOTest", null);
		Object testObj = testClass.newInstance();
		testMethod.invoke(testObj, null);
		
		
	}
	
	
	public void runSDOTest() throws Exception {
		
		HelperProvider.setDefaultInstance(this.getClass().getClassLoader());
			
		TestSuite allTests = AllTests.suite();
		TestResult testResult = new TestResult();
		allTests.run(testResult);
		Assert.assertEquals(0, testResult.errorCount());
    }
	
	
	// Get all the URLs for a classloader, remove these from dependentJars
	private URL[] getClassLoaderURLs(
			URL[] classPathEntries, 
			HashSet dependentJars,
			String[] jarList) 
	throws IOException {
		
		String pathSeparator = "/";
    	HashSet classPathEntrySet;

        classPathEntrySet = new HashSet();
        
        for (int i = 0; i < classPathEntries.length; i++) { 
            
        	URL classPathEntry = classPathEntries[i];
        	String classPathEntryStr = classPathEntry.getPath();
        	if (jarList != null) {
        		for (int k = 0; k < jarList.length; k++) {
        			String jarName = "tuscany-" + jarList[k];
        		    String alternateJarName = "tuscany-sdo-" + jarList[k];
        		    String folderName = pathSeparator + jarList[k] + pathSeparator;
        			if (classPathEntryStr.indexOf(jarName) >= 0 ||
        					classPathEntryStr.indexOf(alternateJarName) >=0 ||
        					classPathEntryStr.indexOf(folderName) >=0) {
        				
        				classPathEntrySet.add(classPathEntry);
        				dependentJars.remove(classPathEntry);
        			}
        		}
        	}        	
        }
        return (URL [])classPathEntrySet.toArray(new URL[classPathEntrySet.size()]);
	}


	// Create the test classloader. It uses separate classloaders to load SDO API, SDO LIB,
	// SDO IMPL and 3rd part libraries
	private ClassLoader createTestClassLoader() throws Exception {
		
		String[] sdoApiJars  = {"sdo-api"};
		String[] sdoLibJars  = {"lib"};
		String[] sdoImplJars = {"impl"};
					
		URL[] sdoApiUrls;
		URL[] sdoLibUrls;
		URL[] sdoImplUrls;
		URL[] dependencyUrls;
			
		if (!(this.getClass().getClassLoader() instanceof URLClassLoader))
			return this.getClass().getClassLoader();
			
		HashSet dependentJars = new HashSet();
		URL[] classPathEntries = ((URLClassLoader)this.getClass().getClassLoader()).getURLs();
		for (int i = 0; i < classPathEntries.length; i++) { 
	        dependentJars.add(classPathEntries[i]);
		}
		sdoApiUrls = getClassLoaderURLs(classPathEntries, dependentJars, sdoApiJars);
		sdoLibUrls = getClassLoaderURLs(classPathEntries, dependentJars, sdoLibJars);
		sdoImplUrls = getClassLoaderURLs(classPathEntries, dependentJars, sdoImplJars);
		dependencyUrls = (URL [])dependentJars.toArray(new URL[dependentJars.size()]);
	    		
	    ClassLoader dependencyLoader = new URLClassLoader(dependencyUrls, null);
	    ClassLoader sdoApiLoader = new URLClassLoader(sdoApiUrls, dependencyLoader);
	    ClassLoader sdoLibClassLoader = new URLClassLoader(sdoLibUrls, sdoApiLoader);
	    ClassLoader sdoImplClassLoader = new URLClassLoader(sdoImplUrls, sdoLibClassLoader);


	    TestClassLoader testClassLoader = new TestClassLoader(
	    		new ClassLoader[] {sdoApiLoader, sdoLibClassLoader, sdoImplClassLoader, dependencyLoader}
	    		);

	    	
	    // Test classes and 3rd party libraries should be on the context classloader	    	
	    URL testUrl = new File("./target/test-classes").toURL();
	    ClassLoader contextClassLoader = new URLClassLoader(new URL[]{testUrl}, dependencyLoader);
	    Thread.currentThread().setContextClassLoader(contextClassLoader);	    	
	    	
	    return testClassLoader;
	}
	
	

	private class TestClassLoader extends ClassLoader {
		
		ClassLoader[] parentLoaders;
		
		private TestClassLoader(ClassLoader[] parentLoaders) {
			this.parentLoaders = parentLoaders;
		}

		public Class loadClass(String className) throws ClassNotFoundException {
			
			Class clazz = findLoadedClass(className);			
			if (clazz != null)
				return clazz;
			
			for (int i = 0; i < parentLoaders.length; i++) {
				try {
					return parentLoaders[i].loadClass(className);					
				} catch (Exception e) {
				  // speculative load using parent class loader failed,  but that's OK
				}
			}
			return super.loadClass(className);
		}
		
		
	}
}
