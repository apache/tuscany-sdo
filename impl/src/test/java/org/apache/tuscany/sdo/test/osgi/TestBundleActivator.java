package org.apache.tuscany.sdo.test.osgi;
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
import java.util.Enumeration;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestFailure;
import junit.framework.TestResult;

import org.apache.tuscany.sdo.AllTests;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


/*
 * Bundle activator for running the SDO test suite under OSGi
 * The SDO test suite is run inside an OSGi container when the bundle is started.
 */
public class TestBundleActivator implements BundleActivator {

	public void start(BundleContext bundleContext) throws Exception {
		runSDOTests();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
	}


	public void runSDOTests() throws Exception {

		Test allTests = AllTests.suite();
		TestResult testResult = new TestResult();
		allTests.run(testResult);
		System.out.println("Runs " + testResult.runCount() + ", Errors: "
				+ testResult.errorCount());

		Enumeration e = testResult.errors();
		while (e.hasMoreElements()) {
			TestFailure f = (TestFailure) e.nextElement();
			System.out.println(f);
			System.out.println(f.exceptionMessage());
		}

		Assert.assertEquals(0, testResult.errorCount());

	}
}
