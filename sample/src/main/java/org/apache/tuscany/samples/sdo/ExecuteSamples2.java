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
package org.apache.tuscany.samples.sdo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.tuscany.samples.sdo.advanced.MedicalScenario;
import org.apache.tuscany.samples.sdo.advanced.ObtainingDataGraphFromXml;
import org.apache.tuscany.samples.sdo.advanced.PrintDataGraph;
import org.apache.tuscany.samples.sdo.basic.AccessDataObjectPropertiesByName;
import org.apache.tuscany.samples.sdo.basic.CreatePurchaseOrder;
import org.apache.tuscany.samples.sdo.basic.ReadPurchaseOrder;
import org.apache.tuscany.samples.sdo.intermediate.AccessDataObjectUsingValidXPath;
import org.apache.tuscany.samples.sdo.intermediate.CreateDataObjectFromXmlString;
import org.apache.tuscany.samples.sdo.intermediate.DynamicCustomerTypeSample;

/**
 * A Program to execute a sequence of SDO sample programs.
 */
public class ExecuteSamples2 {
  
  public static void main(String [] args) throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {

    /**
     * Here's the list of sample programs that we are going to execute,  in this sequence.
     */
    Class[] sampleClasses = {
      org.apache.tuscany.samples.sdo.basic.CreateCompany.class,
      ReadPurchaseOrder.class,
      CreatePurchaseOrder.class,
      AccessDataObjectPropertiesByName.class,
      AccessDataObjectUsingValidXPath.class,
      DynamicCustomerTypeSample.class,
      ObtainingDataGraphFromXml.class,
      org.apache.tuscany.samples.sdo.tuscanyapi.CreateCompanyTuscanyAPI.class,
      CreateDataObjectFromXmlString.class,
      PrintDataGraph.class,
      MedicalScenario.class
     
    };
    
    Class[] constructorArgTypes = { Integer.class };

    /**
     * Edit the value of this argument to one of COMMENTARY_FOR_NOVICE, COMMENTARY_FOR_INTERMEDIATE or COMMENTARY_FOR_ADVANCED to see
     * more or less commentary.  Note,  this value only controls the level of commentary,
     * not which samples are executed.  Use it to filter out the noise if you have already
     * understood the more basic commentary.
     */
    Object[] constructorArgs = { SampleInfrastructure.COMMENTARY_FOR_NOVICE };  
    

    /**
     *  By default run all samples from novice level right up to advanced level.
     *  Edit this to run fewer samples.
     */
    int runSamplesUpToLevel = SampleInfrastructure.SAMPLE_LEVEL_ADVANCED.intValue(); 
    boolean pauseBetweenSamples = false;
    
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    int sampleCount = 0;
    for (int i=0; i < sampleClasses.length; i++) {
      Constructor c = sampleClasses[i].getConstructor(constructorArgTypes);
      SampleBase sample = (SampleBase)c.newInstance(constructorArgs);
      if(sample.getSampleComplexityLevel() <= runSamplesUpToLevel) {
        sample.run();
        sampleCount++;
        if(pauseBetweenSamples) {
          System.out.println(">>>Press Enter to continue");
          in.readLine();
        }
      }
    }
    System.out.println("Ran " + sampleCount + " samples");
  }
}
