package org.apache.tuscany.sdo;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

    public static Test suite() {

        TestSuite suite = new TestSuite();
      
        suite.addTest(org.apache.tuscany.sdo.codegen.AllTests.suite());
        suite.addTest(org.apache.tuscany.sdo.test.AllTests.suite());

        return suite;
    }


    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }
}

