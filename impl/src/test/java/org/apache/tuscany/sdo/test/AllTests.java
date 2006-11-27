package org.apache.tuscany.sdo.test;
import junit.framework.TestSuite;

public class AllTests {
	
	
  public static TestSuite suite() {

        TestSuite suite = new TestSuite();
      
        // suite.addTestSuite(ChangeSummaryOnDataObjectTestCase.class);
        suite.addTestSuite(ChangeSummaryTestCase.class);
        suite.addTestSuite(CrossScopeCopyTestCase.class);
        suite.addTestSuite(DataTypeBaseTypeTestCase.class);
        suite.addTestSuite(DateConversionTestCase.class);
        suite.addTestSuite(DefineOpenContentPropertyTestCase.class);
        suite.addTestSuite(DefineTypeTestCase.class);
        suite.addTestSuite(MixedTypeTestCase.class);
        suite.addTestSuite(OpenTypeTestCase.class);
        suite.addTestSuite(SerializeTypesTestCase.class);
        suite.addTestSuite(SimpleCopyTestCase.class);
        suite.addTestSuite(SimpleDynamicTestCase.class);
        suite.addTestSuite(SimpleEqualityTestCase.class);
        suite.addTestSuite(SubstitutionValuesTestCase.class);
        suite.addTestSuite(TypeConversionTestCase.class);
        suite.addTestSuite(TypeRoundTripTestCase.class);
        suite.addTestSuite(XMLDocumentTestCase.class);
        suite.addTestSuite(XMLStreamHelperTestCase.class);
        suite.addTestSuite(XPathTestCase.class);
        suite.addTestSuite(XSDHelperTestCase.class);

        return suite;
    }


    
    /**
     * Runs the test suite using the textual runner.
     */
    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }
}

