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

import org.apache.tuscany.samples.sdo.otherSources.CreatePurchaseOrder;
import org.apache.tuscany.samples.sdo.otherSources.ReadPurchaseOrder;
import org.apache.tuscany.samples.sdo.specCodeSnippets.AccessDataObjectPropertiesByName;
import org.apache.tuscany.samples.sdo.specCodeSnippets.AccessDataObjectUsingValidXPath;
import org.apache.tuscany.samples.sdo.specCodeSnippets.DynamicCustomerTypeSample;
import org.apache.tuscany.samples.sdo.specCodeSnippets.ObtainingDataGraphFromXml;

public class ExecuteSamples2 {
  
  public static void main(String [] args) throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {

    Class[] sampleClasses = {
      org.apache.tuscany.samples.sdo.otherSources.CreateCompany.class,
      ReadPurchaseOrder.class,
      CreatePurchaseOrder.class,
      AccessDataObjectPropertiesByName.class,
      AccessDataObjectUsingValidXPath.class,
      DynamicCustomerTypeSample.class,
      ObtainingDataGraphFromXml.class,
      org.apache.tuscany.samples.sdo.tuscanyapi.CreateCompany.class 

     
    };
    
    Class[] constructorArgTypes = { Integer.class };

    /*
     * Edit the value of this argument to one of COMMENTARY_FOR_NOVICE, COMMENTARY_FOR_INTERMEDIATE or COMMENTARY_FOR_ADVANCED to see
     * more or less commentary.  Note,  this value only controls the level of commentary,
     * not which samples are executed.  Use it to filter out the noise if you have already
     * understood the more basic commentary.
     */
    Object[] constructorArgs = { SampleInfrastructure.COMMENTARY_FOR_NOVICE };  
    

    /*
     *  By default run all samples from novice level right up to advanced level.
     *  Edit this to run fewer samples.
     */
    int runSamplesUpToLevel = SampleInfrastructure.SAMPLE_LEVEL_ADVANCED.intValue(); 
    
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    int sampleCount = 0;
    for (int i=0; i < sampleClasses.length; i++) {
      Constructor c = sampleClasses[i].getConstructor(constructorArgTypes);
      SampleBase sample = (SampleBase)c.newInstance(constructorArgs);
      if(sample.getSampleComplexityLevel() <= runSamplesUpToLevel) {
        sample.run();
        sampleCount++;
        System.out.println(">>>Press Enter to continue");
        in.readLine();
      }
    }
    System.out.println("Ran " + sampleCount + " samples");
  }
}
