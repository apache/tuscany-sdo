
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
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllTests extends TestCase {
	
	
  public static TestSuite suite() {

        TestSuite suite = new TestSuite();
      
        suite.addTestSuite(ChangeSummaryOnDataObjectTestCase.class);
        suite.addTestSuite(ChangeSummaryPropertyTestCase.class);
        suite.addTestSuite(ChangeSummaryTestCase.class);
        suite.addTestSuite(ContainmentCycleTestCase.class);
        suite.addTestSuite(CrossScopeCopyTestCase.class);
        suite.addTestSuite(DataGraphTestCase.class);
        suite.addTestSuite(DataTypeBaseTypeTestCase.class);
        suite.addTestSuite(DateConversionTestCase.class);
        suite.addTestSuite(DefineOpenContentPropertyTestCase.class);
        suite.addTestSuite(DefineTypeTestCase.class);
        suite.addTestSuite(FormTestCase.class);
        suite.addTestSuite(HelperContextTestCase.class);
        suite.addTestSuite(IsManyTestCase.class);
        suite.addTestSuite(BoundsTestCase.class);
        suite.addTestSuite(JavaSerializeDeserializeTestCase.class);
        suite.addTestSuite(MixedTypeTestCase.class);
        suite.addTestSuite(NeverStaleChangeSummaryTestCase.class);
        suite.addTestSuite(OpenTypeTestCase.class);
        suite.addTestSuite(SchemaLocationTestCase.class);
        suite.addTestSuite(SerializeTypesTestCase.class);
        suite.addTestSuite(SimpleCopyTestCase.class);
        suite.addTestSuite(SimpleDynamicTestCase.class);
        suite.addTestSuite(SimpleEqualityTestCase.class);
        suite.addTestSuite(SubstitutionValuesTestCase.class);
        suite.addTestSuite(TypeConversionTestCase.class);
        suite.addTestSuite(TypeRoundTripTestCase.class);
        suite.addTestSuite(XMLDocumentTestCase.class);
        suite.addTestSuite(XMLHelperTestCase.class);
        suite.addTestSuite(XMLStreamHelperTestCase.class);
        suite.addTestSuite(XPathTestCase.class);
        suite.addTestSuite(XSDHelperTestCase.class);
        suite.addTestSuite(XSDQNameTestCase.class);
        suite.addTestSuite(XMLLoadOptionsTestCase.class);
        suite.addTestSuite(XMLSaveOptionsTestCase.class);
        suite.addTestSuite(XMLUnknownPropertiesTestCase.class);
        suite.addTestSuite(ExpectedExceptionsTestCase.class);
        suite.addTestSuite(TypeHelperTestCase.class);
        suite.addTestSuite(NotificationTestCase.class);
        suite.addTestSuite(ImplSpecificTestCase.class);
        return suite;
    }


    
    /**
     * Runs the test suite using the textual runner.
     */
    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }
}




