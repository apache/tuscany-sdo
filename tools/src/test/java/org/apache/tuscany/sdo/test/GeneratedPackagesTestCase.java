/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */

package org.apache.tuscany.sdo.test;

import java.util.Iterator;
import java.util.List;

import org.apache.tuscany.sdo.generate.XSD2JavaGenerator;

import junit.framework.TestCase;


public class GeneratedPackagesTestCase extends TestCase
{
    static String expectedNamespace = "http://www.example.com/sequences";
    
    public void testPackageValidity()
    {
        XSD2JavaGenerator codeGen = new XSD2JavaGenerator();
        String [] genArgs = { "-schemaNamespace", "all", "-noGenerate", "src/test/resources/sequences.xsd" };
        codeGen.generateFromXMLSchema( genArgs );
        List packages = codeGen.getGeneratedPackageInfo();
        
        for (Iterator iter = packages.iterator(); iter.hasNext();)
        {
            XSD2JavaGenerator.GeneratedPackage packageInfo = (XSD2JavaGenerator.GeneratedPackage)iter.next();
            assertTrue(expectedNamespace.equals(packageInfo.getNamespace()));
            
            String name;
            boolean validatedMixedQuote = false;
            boolean validatedRC = false;
            for (Iterator iterClass = packageInfo.getClasses().iterator(); iterClass.hasNext();)
            {
                XSD2JavaGenerator.GeneratedPackage.PackageClassInfo classInfo = (XSD2JavaGenerator.GeneratedPackage.PackageClassInfo)iterClass.next();
                name = classInfo.getName();
                
                if( "mixedStockQuote".equals(name))
                {
                    assertTrue("com.example.sequences.MixedQuote".equals(classInfo.getClassName()));
                    validatedMixedQuote = true;
                }
                
                if( "rc".equals(name))
                {
                    assertTrue("com.example.sequences.RepeatingChoice".equals(classInfo.getClassName()));
                    validatedRC = true;
                }
            }
            assertTrue(validatedMixedQuote);
            assertTrue(validatedRC);
        }    
    }
}
