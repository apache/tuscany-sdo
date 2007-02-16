package org.apache.tuscany.sdo.test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllTests extends TestCase {
	
	
  public static TestSuite suite() {

        TestSuite suite = new TestSuite();
      
        // suite.addTestSuite(ChangeSummaryOnDataObjectTestCase.class);
        suite.addTestSuite(ChangeSummaryGenTestCase.class);
        suite.addTestSuite(GenPatternsTestCase.class);
        //suite.addTestSuite(org.apache.tuscany.sdo.test.StaticSequenceNoEmfTestCase.class);


        return suite;
    }


    
    /**
     * Runs the test suite using the textual runner.
     */
    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }
}

