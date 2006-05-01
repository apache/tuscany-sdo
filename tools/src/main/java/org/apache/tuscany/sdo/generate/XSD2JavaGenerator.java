/**
 *
 *  Copyright 2005 The Apache Software Foundation or its licensors, as applicable.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.tuscany.sdo.generate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tuscany.sdo.helper.XSDHelperImpl;
import org.apache.tuscany.sdo.util.DataObjectUtil;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import commonj.sdo.helper.XSDHelper;

public class XSD2JavaGenerator extends JavaGenerator
{
  /**
   * Generate static SDOs from XML Schema
   * 
   *   Usage arguments: see JavaGenerator
   *   
   *     [ -targetDirectory <target-root-directory> ]
   *     [ -javaPackage <java-package-name> ]
   *     <xsd-file> | <wsdl-file>
   *
   *   For example:
   *   
   *     generate somedir/somefile.xsd
   *     
   *   See base class JavaGenerator for details and the other options.
   *
   */
  public static void main(String args[])
  {
    try
    {
      XSD2JavaGenerator generator = new XSD2JavaGenerator();
      generator.processArguments(args);
      generator.run(args);
    }
    catch (IllegalArgumentException e)
    {
      printUsage();
    }
  }
  
  protected void run(String args[])
  {
    String xsdFileName = args[inputIndex];
    generateFromXMLSchema(xsdFileName, targetDirectory, javaPackage, prefix, genOptions);
  }

  public static void generateFromXMLSchema(String xsdFileName, String targetDirectory, String javaPackage, String prefix, int genOptions)
  {
    DataObjectUtil.initRuntime();
    EPackage.Registry packageRegistry = new EPackageRegistryImpl(EPackage.Registry.INSTANCE);
    ExtendedMetaData extendedMetaData = new BasicExtendedMetaData(packageRegistry);
    XSDHelper xsdHelper = new XSDHelperImpl(extendedMetaData);

    try
    {
      File inputFile = new File(xsdFileName).getAbsoluteFile();
      InputStream inputStream = new FileInputStream(inputFile);
      xsdHelper.define(inputStream, inputFile.toURI().toString());

      if (targetDirectory == null)
      {
        targetDirectory = new File(xsdFileName).getCanonicalFile().getParent();
      }
      else
      {
        targetDirectory = new File(targetDirectory).getCanonicalPath();
      }

      if (!packageRegistry.values().isEmpty())
      {
        String packageURI = getSchemaNamespace(xsdFileName);
        generatePackages(packageRegistry.values(), packageURI, null, targetDirectory, javaPackage, prefix, genOptions);
      }

      /*
      for (Iterator iter = packageRegistry.values().iterator(); iter.hasNext();)
      {
        EPackage ePackage = (EPackage)iter.next();
        String basePackage = extractBasePackageName(ePackage, javaPackage);
        if (prefix == null)
        {
          prefix = CodeGenUtil.capName(ePackage.getName());
        }
        generateFromEPackage(ePackage, targetDirectory, basePackage, prefix, genOptions);
      }
      */
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
  
  protected static void printUsage()
  {
    System.out.println("Usage arguments:");
    System.out.println("  [ -targetDirectory <target-root-directory> ]");
    System.out.println("  [ -javaPackage <java-package-name> ]");
    System.out.println("  [ -prefix <prefix-string> ]");
    System.out.println("  [ -sparsePattern | -storePattern ]");
    System.out.println("  [ -noInterfaces ]");
    System.out.println("  [ -noContainment ]");
    System.out.println("  [ -noNotification ]");
    System.out.println("  [ -arrayAccessors ]");
    System.out.println("  [ -generateLoader ]");
    System.out.println("  [ -noUnsettable ]");
    System.out.println("  <xsd-file> | <wsdl-file>");
    System.out.println("");
    System.out.println("For example:");
    System.out.println("");
    System.out.println("  generate somedir/somefile.xsd");
  }

}
