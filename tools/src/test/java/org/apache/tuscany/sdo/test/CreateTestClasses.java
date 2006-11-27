package org.apache.tuscany.sdo.test;

import org.apache.tuscany.sdo.generate.XSD2JavaGenerator;

/**
 * A utility class to regenerate the classes for the test cases
 */
public class CreateTestClasses {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    CreateTestClasses ctc = new CreateTestClasses();
    ctc.run();
 

  }

  private void run() {

    XSD2JavaGenerator.generateFromXMLSchema(getClass().getResource("/simpleWithChangeSummary.xsd").getFile(), "http://www.example.com/simpleCS", "src/test/java/", "org.example.simple.cs", "CS", 0);
            
  }

}
