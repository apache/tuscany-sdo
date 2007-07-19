/**
 *
 *   Licensed to the Apache Software Foundation (ASF) under one
 *   or more contributor license agreements.  See the NOTICE file
 *   distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *   to you under the Apache License, Version 2.0 (the
 *   "License"); you may not use this file except in compliance
 *   with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing,
 *   software distributed under the License is distributed on an
 *   "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *   KIND, either express or implied.  See the License for the
 *   specific language governing permissions and limitations
 *   under the License.
 *
 */
package org.apache.tuscany.sdo.test;

import java.util.List;

import junit.framework.TestCase;
import commonj.sdo.*;
import commonj.sdo.helper.*;
import commonj.sdo.impl.HelperProvider;

import org.apache.tuscany.sdo.api.SDOUtil;
import java.util.HashMap;

/**
 * The follow test cases are based upon code snipets in the SDO specification.
 * They are also implemented as working samples in the sample-sdo artifact
 *
 */
public class JiraTestCases extends TestCase {

	/**
	 * Bogus company namespace
	 */
	public static final String COMPANY_NAMESPACE = "company.xsd";

	/**
	 * previously defined XSD file used
	 */
	public static final String COMPANY_XSD = "/company.xsd";

	/**
	 * XML file containing DataGraph representing a company. This xml file
	 * conforms to the company model defined in 'Complete DataGraph for Company
	 * Example' section of the SDO specification
	 */
	public static final String COMPANY_DATAGRAPH_XML = "/companyDataGraphGenerated.xml";

	/**
	 * Generated DataGraph
	 * {@link org.apache.tuscany.samples.sdo.company.CreateCompany}
	 */
	public static final String COMPANY_DATAOBJECT_XML = "/companyGenerated.xml";

	/**
	 * Defines xsd resource contained within jar file for PurchaseOrder
	 * DataObject
	 */
	public static final String PO_XSD_RESOURCE = "/po.xsd";

	/**
	 * Defines xml resource contained within jar file that is used to populate
	 * PurchaseOrder DataObjects
	 */
	public static final String PO_XML_RESOURCE = "/po.xml";

	/**
	 * previously created XSD file used
	 */
	public static final String LETTER_XSD = "/letter.xsd";

	/**
	 * JIRA Details : Add a method to SDOUtil to return all Types associated
	 * with a specific URI
	 */
	public void test_TUSCANY583() {
	    HelperContext hc = HelperProvider.getDefaultContext();
            XSDHelper xsdHelper = hc.getXSDHelper();
		// define some types
		try {
			xsdHelper.define(getClass().getResourceAsStream(
					PO_XSD_RESOURCE), null);

			xsdHelper.define(getClass().getResourceAsStream(
					COMPANY_XSD), null);

			createDynamicType();

			String[] expectedPoTypeNames = {"item", "Items",
					"PurchaseOrderType", "quantity", "SKU", "USAddress"};

			String[] expectedCompanyTypeNames = {"EmployeeType", "DepartmentType", "CompanyType"};

			String[] expectedCustomerTypeNames = {"Customer"};

			confirmTypes("http://www.example.com/PO", expectedPoTypeNames);
			confirmTypes("company.xsd", expectedCompanyTypeNames);
			confirmTypes("http://example.com/customer",
					expectedCustomerTypeNames);

		} catch (Exception e) {
			fail("Unexpected error " + e.toString());
			e.printStackTrace();
		}

	}

	/**
	 * Dynamically define customer Type
	 */
	public static void createDynamicType() {
		// get an instance of the type helper
		TypeHelper typeH = TypeHelper.INSTANCE;
		Type intType = typeH.getType("commonj.sdo", "Int");
		Type stringType = typeH.getType("commonj.sdo", "String");

		// create a new Type for Customers
		DataObject customerType = DataFactory.INSTANCE.create("commonj.sdo",
				"Type");

		customerType.set("uri", "http://example.com/customer");
		customerType.set("name", "Customer");

		// create a customer number property
		DataObject custNumProperty = customerType.createDataObject("property");
		custNumProperty.set("name", "custNum");
		custNumProperty.set("type", intType);

		// create a last name property
		DataObject lastNameProperty = customerType.createDataObject("property");
		lastNameProperty.set("name", "lastName");
		lastNameProperty.set("type", stringType);

		// create a first name property
		DataObject firstNameProperty = customerType
				.createDataObject("property");
		firstNameProperty.set("name", "firstName");
		firstNameProperty.set("type", stringType);

		// now define the Customer type so that customers can be made
		typeH.define(customerType);
	}

	private void confirmTypes(String uri, String[] expectedTypeNames) {
            HelperContext hc = HelperProvider.getDefaultContext();
		try {

			List actualTypes = SDOUtil.getTypes(hc, uri);
			assertNotNull("Testing that list of types for " + uri
					+ " is not null", actualTypes);

			// test the number of Types
			assertEquals("Testing number of types for " + uri,
					expectedTypeNames.length, actualTypes.size());

			// put into a HashMap for easy lookup
			HashMap typeLookup = new HashMap();
			for (int i = 0; i < actualTypes.size(); i++) {
				Type type = (Type) actualTypes.get(i);
				typeLookup.put(type.getName(), type);
			}

			// check that we have the same types
			for (int i = 0; i < expectedTypeNames.length; i++) {
				assertTrue("testing that type " + expectedTypeNames[i]
						+ "was returned for " + uri, typeLookup
						.containsKey(expectedTypeNames[i]));
			}

		} catch (Exception e) {
			fail("Exception caught comparing expected types to actual types for uri "
					+ uri + ":" + e.toString());
			e.printStackTrace();
		}
	}
}
