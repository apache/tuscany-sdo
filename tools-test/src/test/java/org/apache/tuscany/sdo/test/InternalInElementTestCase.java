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
package org.apache.tuscany.sdo.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.api.SDOUtil;
import org.apache.tuscany.sdo.generate.XSD2JavaGenerator;

import com.example.internal.InternalFactory;
import com.example.internal.Wrapper;

import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;

public class InternalInElementTestCase extends TestCase {
	HelperContext scope;
		
	/*TUSCANy-1483 check correct code generation for internalAbc */
	public void testPackageValidityWithInternalInElement() throws Exception {
		//if dob is instantiated, it proves that the code got generated without any duplicates
		//without the fix, 
		//public final static int INTERNAL_ABC = 1;
		//public final static int INTERNAL_ABC = 0;
		//was getting generated and so invalid java class WrapperImpl.java.
		InternalFactory.INSTANCE.register(scope);
		DataObject dob = scope.getDataFactory().create(Wrapper.class);

		assertTrue(true);
	}
	
	protected void setUp() throws Exception {
	    super.setUp();
	    scope = SDOUtil.createHelperContext();
	}
	
	protected void tearDown() throws Exception {
	 	super.tearDown();
	}
	
}
