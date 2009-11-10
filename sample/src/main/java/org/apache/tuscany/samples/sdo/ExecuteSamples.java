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

import org.apache.tuscany.samples.sdo.SampleBase;
import org.apache.tuscany.samples.sdo.internal.SampleInfrastructure;


/**
 * A program to execute a sequence of SDO sample programs. The program executes
 * the sample programs listed in the {@link SampleInfrastructure#sampleClasses sample classes}
 * static constant.  These samples are executed in roughly increasing order of complexity.
 * You can edit the {@link #pauseBetweenSamples}, {@link #runSamplesUpToLevel} and
 * {@link #constructorArgs} variables to change the way this program executes the samples. 
 * 
 * <P>
 * Each of the samples creates text output to the console.  If the commentary
 * level in {@link #constructorArgs the sample program constructor arguments}
 * used to construct each sample is set to
 * {@link SampleInfrastructure#COMMENTARY_FOR_NOVICE COMMENTARY_FOR_NOVICE} then there
 * will be much more output than if set to one of the other values. 
 * 
 */
public class ExecuteSamples extends SampleBase {

  /**
   * Edit this value to cause the program to pause between each sample program
   * and wait for the user to hit the enter key.
   */
  private static final boolean pauseBetweenSamples = true;

  /**
   *  By default run all samples from novice level right up to advanced level.
   *  Edit this to run fewer samples.
   */
  private static final int runSamplesUpToLevel = SampleInfrastructure.SAMPLE_LEVEL_ADVANCED.intValue(); 

  /**
   * Edit the value of this argument to one of COMMENTARY_FOR_NOVICE, COMMENTARY_FOR_INTERMEDIATE or COMMENTARY_FOR_ADVANCED to see
   * more or less commentary.  Note,  this value only controls the level of commentary,
   * not which samples are executed.  Use it to filter out the noise if you have already
   * understood the more basic commentary.
   */
  private static final Object[] constructorArgs = { SampleInfrastructure.COMMENTARY_FOR_NOVICE };
  
  
  public static void main(String [] args) throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {
    ExecuteSamples sample = new ExecuteSamples(COMMENTARY_FOR_NOVICE);
    sample.run();
  }

  public ExecuteSamples(Integer userLevel) {
    super(userLevel, SAMPLE_LEVEL_BASIC);
  }

  public void runSample() throws Exception {
    Class[] constructorArgTypes = { Integer.class };

    
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    int sampleCount = 0;
    for (int i=0; i < SampleInfrastructure.sampleClasses.length; i++) {
      Constructor c = SampleInfrastructure.sampleClasses[i].getConstructor(constructorArgTypes);
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
