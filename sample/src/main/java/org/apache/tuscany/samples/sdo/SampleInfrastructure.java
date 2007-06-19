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

import java.util.HashSet;
import java.util.Set;

import org.apache.tuscany.sdo.api.SDOUtil;

import commonj.sdo.helper.HelperContext;

public class SampleInfrastructure {

  
  /*
   * sample program infrastructure
   */
  protected int userLevel = NOVICE;
  private Set commentaryHistory = new HashSet();
  
  public SampleInfrastructure (int userLevel) {
    this.userLevel = userLevel;
  }
  
  private static String hrule = "********************************************";
  protected static final int NOVICE = 1;
  protected static final int INTERMEDIATE = 2;
  protected static final int ADVANCED = 3;
  
  protected static final String noviceStr = " novice ";
  protected static final String intermediateStr = " intermediate ";
  protected static final String advancedStr = " advanced ";
  
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
  
  protected void commentary(int commentLevel, String text, String repeatText) {

    if(commentLevel < userLevel) return;
    
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
  
  protected void commentary(int commentLevel, String text) {
    if(commentLevel >= userLevel) {
      banner(text);
    }
  }
  
  public void somethingUnexpectedHasHappened(Exception e) {
    banner('!',
        "Something unexpected has gone wrong with the execution of this sample program\n" +
        "Please take a look at the exception and see if its something wrong with your environment\n" +
        "If you can't figure it out please send a note to the tuscany-user@ws.apache.org mailing list\n" +
        "including the text of the exception and any other useful information, thanks");
    
    e.printStackTrace();
  }
  

  
  
  
}
