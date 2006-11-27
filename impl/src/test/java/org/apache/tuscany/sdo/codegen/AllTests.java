package org.apache.tuscany.sdo.codegen;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
	
	
    public static TestSuite suite() {

        TestSuite suite = new TestSuite();
      
        suite.addTestSuite(BytecodeInterfaceGeneratorTestCase.class);
        suite.addTestSuite(JavaInterfaceGeneratorTestCase.class);


        return suite;
    }

    
    /**
     * Runs the test suite using the textual runner.
     */
    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }
}

