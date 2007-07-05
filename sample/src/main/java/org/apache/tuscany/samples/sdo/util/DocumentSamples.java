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
package org.apache.tuscany.samples.sdo.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.tuscany.samples.sdo.SampleInfrastructure;
import org.apache.tuscany.samples.sdo.SampleInfrastructure.SDOFacets;

public class DocumentSamples {

  private Map classToCoreFunction = new HashMap();
  private Map coreFunctionToClass = new HashMap();
  private Map classToSignificantFunction = new HashMap();
  private Map significantFunctionToClass = new HashMap();

  public static void main(String[] args) throws SecurityException,
      NoSuchMethodException, IllegalArgumentException, InstantiationException,
      IllegalAccessException, InvocationTargetException, IOException {

    DocumentSamples ds = new DocumentSamples();
    ds.run();
    
  }
  
  private static String HTML_HEADER =
    "<html>\n"+
    "<!--                                                             \n"+
    "*                                                              \n"+
    "*  Licensed to the Apache Software Foundation (ASF) under one  \n"+
    "*  or more contributor license agreements.  See the NOTICE file\n"+
    "*  distributed with this work for additional information       \n"+
    "*  regarding copyright ownership.  The ASF licenses this file  \n"+
    "*  to you under the Apache License, Version 2.0 (the           \n"+
    "*  \"License\"); you may not use this file except in compliance  \n"+
    "*  with the License.  You may obtain a copy of the License at  \n"+
    "*                                                              \n"+
    "*    http://www.apache.org/licenses/LICENSE-2.0                \n"+
    "*                                                              \n"+
    "*  Unless required by applicable law or agreed to in writing,  \n"+
    "*  software distributed under the License is distributed on an \n"+
    "*  \"AS IS\" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY      \n"+
    "*  KIND, either express or implied.  See the License for the   \n"+
    "*  specific language governing permissions and limitations     \n"+
    "*  under the License.                                          \n"+
    "-->                                                             \n"+
    "<head><title>SDO Samples</title></head><body>\n" +
    "  <h1>SDO Samples</h1>\n";

  private static String CLASSES_HEADING =
    "<H2>Index by Sample Program Name</H2>\n";
  
  private static String FUNCTION_HEADING =
    "<H2>Index by function</H2>\n";
  
  private static String HTML_FOOTER =
    "</body>\n</html>";
  

  private void run() throws IllegalAccessException {
    /*
     * gather the data
     */
    for (int i = 0; i < SampleInfrastructure.sampleClasses.length; i++) {
      Class c = SampleInfrastructure.sampleClasses[i];
      classToCoreFunction.put(c, new HashSet());
      try {
        Field coreFunction = c.getField("CORE_FUNCTION");
        recordFunction(c, coreFunction, coreFunctionToClass, classToCoreFunction);
      } catch (NoSuchFieldException e) {
        // no problem
      }
      try {
        Field sigFunction = c.getField("SIGNIFICANT_FUNCTION");
        recordFunction(c, sigFunction, significantFunctionToClass, classToSignificantFunction);
      } catch (NoSuchFieldException e) {
        // no problem
      }
    }
    
    /*
     * create the documentation
     */
    StringBuffer doc = new StringBuffer();
    doc.append(HTML_HEADER);
    
    doc.append(CLASSES_HEADING);
    Class [] classes = SampleInfrastructure.sampleClasses;
    for(int i=0; i < classes.length;i++) {
      doc.append("<h3>Sample Program " + classes[i].getSimpleName() + "</h3>\n");
      doc.append("<b>Core function:</b><br/>\n");
      int [] functions = (int[])classToCoreFunction.get(classes[i]);
      for(int j=0;j<functions.length;j++) {
        doc.append("<a href=\"#facet")
        .append(functions[j])
        .append("\">")
        .append(SDOFacets.subject_areas[functions[j]])
        .append("</a><br/>\n");      }
      doc.append("<br/>");
      if(classToSignificantFunction.get(classes[i])!= null) {
        doc.append("<b>Also demonstrates:</b><br/>\n");
        functions = (int[])classToSignificantFunction.get(classes[i]);
        for(int j=0;j<functions.length;j++) {
          doc.append("<a href=\"#facet")
            .append(functions[j])
            .append("\">")
            .append(SDOFacets.subject_areas[functions[j]])
            .append("</a><br/>\n");
        }
      }
    }
    
    doc.append(FUNCTION_HEADING);
    
    String [] facets = SDOFacets.subject_areas;
    for(int f = 0; f<facets.length; f++) {
      Integer fobj = new Integer(f);
      doc.append("<a name=\"facet")  
        .append(f)
        .append("\"/>\n<h3>")
        .append(SDOFacets.subject_areas[f])
        .append("</h3>\n");
      if(coreFunctionToClass.keySet().contains(fobj)) {
        doc.append("<b>Samples which demonstrate this as their core function</b><br/>\n");
        Set classesWithFunction = (Set)coreFunctionToClass.get(fobj);
        for(Iterator cwf = classesWithFunction.iterator(); cwf.hasNext();) {
          Class c = (Class)cwf.next();
          doc.append(c.getSimpleName()).append("<br/>\n");
        }
      }
      if(significantFunctionToClass.keySet().contains(fobj)) {
        doc.append("<b>Samples which demonstrate this in addition to their core function</b><br/>\n");
        Set classesWithFunction = (Set)significantFunctionToClass.get(fobj);
        for(Iterator cwf = classesWithFunction.iterator(); cwf.hasNext();) {
          Class c = (Class)cwf.next();
          doc.append(c.getSimpleName()).append("<br/>\n");
        }
      }
      
    }
    
    doc.append(HTML_FOOTER); 
    System.out.println(doc);
  }

  private int[] recordFunction(Class c, Field functionIndices,  Map ftoc, Map ctof)
      throws IllegalAccessException {
    int[] functions = (int[]) functionIndices.get(c);
    for (int j = 0; j < functions.length; j++) {
      addClassesToFunction(ftoc, functions[j], c);
    }
    ctof.put(c, functions);
    return functions;
  }

  private void addClassesToFunction(Map functionToClass, int i, Class c) {
    Integer iobj = new Integer(i);
    if (!functionToClass.containsKey(iobj)) {
      functionToClass.put(iobj, new HashSet());
    }
    ((Set) (functionToClass.get(iobj))).add(c);
  }
}
