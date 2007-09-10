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

import java.io.InputStream;
import java.net.URL;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.api.SDOUtil;

import com.example.mixedtypes.statictypes.StatictypesFactory;
import com.example.mixedtypes.statictypes.Address;
import com.example.mixedtypes.statictypes.Customer;
import commonj.sdo.DataObject;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.HelperContext;

public class MixedTypesTestCase extends TestCase {

	private final String[] MODELS = new String[] {
			"/mixedTypesDynamic.xsd"
	};

    private final String NS_DYNAMIC = "http://www.example.com/mixedtypes/dynamictypes";

	private HelperContext scope;

    public void testSetDynamicToStatic() {
		DataFactory factory = scope.getDataFactory();

		DataObject staticCustomer = factory.create(Customer.class);
		assertTrue("The account property type has to be abstract, pre condition to this test.",
		  staticCustomer.getInstanceProperty("account").getType().isAbstract());

		DataObject dynamicSavingsAccount = factory.create(NS_DYNAMIC, "SavingsAccount");
		staticCustomer.set("account", dynamicSavingsAccount);
		assertNotNull("The account property in the static customer has to be set",
		  ((Customer)staticCustomer).getAccount());
	}

	public void testSetStaticToDynamic() {
		DataFactory factory = scope.getDataFactory();

		DataObject dynamicSavingsAccount = factory.create(NS_DYNAMIC, "SavingsAccount");
		DataObject staticAddress = factory.create(Address.class);

		dynamicSavingsAccount.set("alternateAddress", staticAddress);
		assertTrue("The address property on the dynamic account object has to be set",
		  dynamicSavingsAccount.isSet("alternateAddress"));
	}

	protected void setUp() throws Exception {
		super.setUp();
		scope = SDOUtil.createHelperContext();

		StatictypesFactory.INSTANCE.register(scope);

        // Populate the meta data for the models
		for (int i = 0; i < MODELS.length; i++) {
			String model = MODELS[i];
	        URL url = getClass().getResource(model);
	        InputStream inputStream = url.openStream();
	        scope.getXSDHelper().define(inputStream, url.toString());
	        inputStream.close();
		}
	}

}
