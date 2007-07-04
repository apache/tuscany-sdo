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
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * One of a pair of base classes for samples.  This one contains all the
 * infrastructure code that a person wanting to learn SDO would not want to look at.
 */
public abstract class SampleInfrastructure {


  protected int sampleComplexityLevel = SAMPLE_LEVEL_BASIC.intValue();
  protected int commentaryLevel = COMMENTARY_FOR_NOVICE.intValue();
  
  /*
   * keep a record of what's been said,  so that if alternative terse text is
   * offered,  the verbose text need not be repeated for repeat actions.
   */
  private static Set commentaryHistory = new HashSet();
  
  public SampleInfrastructure (Integer commentaryLevel) {
    this.commentaryLevel = commentaryLevel.intValue();
  }
  
  public SampleInfrastructure(Integer commentaryLevel, Integer sampLevel) {
    this.commentaryLevel = commentaryLevel.intValue();
    this.sampleComplexityLevel = sampLevel.intValue();
  }

  private static String hrule = "********************************************";
  
  /*
   * Constants which allow the sample program infrastructure to understand
   * the complexity of a sample program.
   */
  protected static final Integer SAMPLE_LEVEL_BASIC = new Integer(0);
  protected static final Integer SAMPLE_LEVEL_INTERMEDIATE = new Integer(1);
  protected static final Integer SAMPLE_LEVEL_ADVANCED = new Integer(2);
  
  
  /*
   * Constants which can be used to reduce the amount of information output
   * by an executing sample program.
   */
  protected static final Integer COMMENTARY_FOR_NOVICE = new Integer(0);
  protected static final Integer COMMENTARY_FOR_INTERMEDIATE = new Integer(1);
  protected static final Integer COMMENTARY_FOR_ADVANCED = new Integer(2);
  protected static final Integer COMMENTARY_ALWAYS = new Integer(3);
  
  protected static final String[] userLevels = {"novice","intermediate","advanced"};
  
  public void banner(char borderChar, String text) {
    if(text == null || text.length() == 0) {
      System.out.println(hrule);
      return;
    }
    String [] lines = text.split("\n");
    int maxlinelen = 0;
    
    for(int i=0; i<lines.length; i++) {
      maxlinelen = lines[i].length() > maxlinelen ? lines[i].length() : maxlinelen;
    }
    
    StringBuffer buf = new StringBuffer();
    for (int p = 0; p < maxlinelen + 4; p++) {
      buf.append(borderChar);
    }
    buf.append("\n");
    for(int l=0; l<lines.length; l++) {
      buf.append(borderChar).append(" ");
      buf.append(lines[l]);
      for(int rem=lines[l].length()+2; rem < maxlinelen+3; rem++) buf.append(" ");
      buf.append(borderChar).append("\n");
    }
    for (int p = 0; p < maxlinelen + 4; p++) {
      buf.append(borderChar);
    }
    buf.append("\n");
    System.out.println(buf.toString());
  }
  
  public void banner(String text) {
    banner('-', text);
  }
  
  protected void commentary(Integer commentLevel, String text, String repeatText) {

    if(commentLevel.intValue() < commentaryLevel) return;
    
    if(repeatText != null)  {
      boolean alreadySeen = commentaryHistory.contains(text);
      if(alreadySeen) {
        commentary(commentLevel, repeatText);
      } else {
        commentary(commentLevel, text);
        commentaryHistory.add(text);
      }
    } else {
      commentary(commentLevel, text);
    }
    
  }
  
  protected void commentary(Integer commentLevel, String text) {
    if(commentLevel.intValue() >= commentaryLevel) {
      banner(text);
    }
  }
  
  /*
   * convenience method to allow commentary level to default to that of
   * the sample's complexity
   */
  protected void commentary(String text) {
    commentary(new Integer(getSampleComplexityLevel()), text);
  }
  
  public void somethingUnexpectedHasHappened(Exception e) {
    banner('!',
        "Something unexpected has gone wrong with the execution of this sample program\n" +
        "Please take a look at the exception and see if its something wrong with your environment\n" +
        "If you can't figure it out please send a note to the tuscany-user@ws.apache.org mailing list\n" +
        "including the text of the exception and any other useful information, thanks");
    
    e.printStackTrace();
  }
  

  /**
   * Utility method to obtain information from the user about whether or not they would like to use a DataGraph or simply use a DataObject
   * 
   * @return whether or not a DataGraph should be used
   * @throws Exception
   */
  protected boolean yesOrNoFromUser(String question) throws Exception {

      System.out.print(question + " {y,n} :");
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String answer = in.readLine();
      while ((! answer.equalsIgnoreCase("n")) && (! answer.equalsIgnoreCase("y"))) {
          
          System.out.println();
          System.out.print("Sorry, please enter 'y' or 'n':");
          answer = in.readLine();
      }
      System.out.println();

      if (answer.equalsIgnoreCase("y")) {
          return true;
      } else {
          return false;
      }
  }
  
  public void run() {
 
    
    commentary(COMMENTARY_FOR_INTERMEDIATE, "Running with commentary level for a " + userLevels[commentaryLevel] + " user\n"+
        "Edit the sample program's constructor argument to one from\n"+
        "COMMENTARY_FOR_NOVICE\nCOMMENTARY_FOR_INTERMEDIATE or\nCOMMENTARY_FOR_ADVANCED\n"+
        "in order to alter the level of commentary you are seeing",
        "");
    
    commentary(COMMENTARY_ALWAYS,"    Tuscany SDO Java Sample " + this.getClass().getName() + "    \n"+
        "    This sample is aimed at a " + userLevels[sampleComplexityLevel] + " user");

    
    try {
      runSample();
    } catch (Exception e) {
      somethingUnexpectedHasHappened(e);
    }
    finally {   
      commentary(COMMENTARY_ALWAYS, "    End of sample "  + this.getClass().getName() + "    ");
    }
  }
  
  public abstract void runSample() throws Exception ;

  public int getSampleComplexityLevel() {
    return sampleComplexityLevel;
  }

  public void setSampleComplexityLevel(Integer sampleComplexityLevel) {
    this.sampleComplexityLevel = sampleComplexityLevel.intValue();
  }
  
  
}
