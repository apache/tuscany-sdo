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
package org.apache.tuscany.sdo.test;

import junit.framework.TestCase;

public class ImplSpecificTestCase extends TestCase {

    public void testThreadSafeHashmapIsAvailable() {
      // this will fail if using Java 1.4.x and the backport library has been removed from the classpath.
      // It is here because ChangeSummaryImpl contains the same logic for finding a threadsafe hashmap implementation
      // but it will fallback to a synchronized hashmap
      // if no threadsafe hashmap is available,  hence no test failure will occur,  but a performance hit
      // will.  This test is here top show a failure with java 1.4 to ensure that no-one removes the backport
      // dependency introduced for TUSCANY-1006.
       assertNotNull(loadConcurrentHashMapClazz());
    }

    protected void setUp() throws Exception {
        super.setUp();

    }
    
    private static String[] concurrentHashMapClazzNames = new String[] {
      "java.util.concurrent.ConcurrentHashMap", 
      "edu.emory.mathcs.backport.java.util.concurrent.ConcurrentHashMap"};
    
    private static Class loadConcurrentHashMapClazz() 
    {
      Class mapClazz = null;
      for (int i = 0; i < concurrentHashMapClazzNames.length; i++) 
      {
        String concurrentHashMapClazzName = concurrentHashMapClazzNames[i];
        try 
        {
          mapClazz = Class.forName(concurrentHashMapClazzName, true, Thread.currentThread().getContextClassLoader());
        } 
        catch (Exception ignored) {}
        if (mapClazz != null) 
        {
          break;
        }
        try 
        {
          mapClazz = Class.forName(concurrentHashMapClazzName);
        } 
        catch (Exception ignored) {}
        if (mapClazz != null) 
        {
          break;
        }
      }
      // System.out.println("threadsafe hashmap = " + mapClazz.getName());
      return mapClazz;
    }

}
