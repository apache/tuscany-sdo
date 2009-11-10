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
package org.apache.tuscany.sdo.generate;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.tuscany.sdo.util.DataObjectUtil;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;

import commonj.sdo.helper.TypeHelper;

public class Interface2JavaGenerator extends JavaGenerator
{
  /**
   * Generate static SDOs from Java interfaces
   *
   *   Usage arguments: see JavaGenerator
   *
   *     [ -targetDirectory <target-root-directory> ]
   *     [ -javaPackage <java-package-name> ]
   *     [ -namespace <xsd-namespace> ]
   *     [ other options ... ]
   *     interface-names
   *
   *   Options:
   *
   *     -namespace
   *         Set the namespaceURI of the generated SDO Types to the specified value.
   *
   *     NOTE: see the base class JavaGenerator for other options.
   *
   *   Example:
   *
   *     generate somepackage.InterfaceA somepackage.InterfaceB
   *
   */
  public static void main(String args[])
  {
    try
    {
      JavaGenerator generator = new Interface2JavaGenerator();
      generator.processArguments(args);
      generator.run(args);
    }
    catch (IllegalArgumentException e)
    {
      printUsage();
    }
  }

  protected String namespace = null;

  protected int handleArgument(String args[], int index)
  {
    if (args[index].equalsIgnoreCase("-namespace"))
    {
      namespace = args[++index];
    }
    else
    {
      return super.handleArgument(args, index);
    }

    return index + 1;
  }

  protected void run(String args[])
  {
    List javaInterfaces=new ArrayList();

    for (int index = inputIndex; index < args.length; ++index)
    {
      javaInterfaces.add(args[index]);
    }

    ClassLoader classLoader=JavaGenerator.class.getClassLoader();
    generateFromJavaInterfaces(classLoader, javaInterfaces, namespace, targetDirectory, javaPackage, prefix, genOptions);
  }

  public static void generateFromJavaInterfaces(ClassLoader classLoader, List javaInterfaces, String packageURI, String targetDirectory, String javaPackage, String prefix, int genOptions)
  {
    try
    {
      // Initialize the SDO runtime
      DataObjectUtil.initRuntime();
      EPackage.Registry packageRegistry = new EPackageRegistryImpl(EPackage.Registry.INSTANCE);

      // Create an EPackage for the generated SDO
      if (packageURI == null)
        packageURI = "http://" + javaPackage;
      EPackage implEPackage = EcoreFactory.eINSTANCE.createEPackage();
      implEPackage.setNsURI(packageURI);
      String shortName = shortName(packageURI);
      implEPackage.setName(shortName);
      implEPackage.setNsPrefix(shortName.toLowerCase());
      packageRegistry.put(packageURI, implEPackage);

      // Create EClasses for all the given Java interfaces
      Map eClasses = new HashMap();
      for (Iterator iter = javaInterfaces.iterator(); iter.hasNext();)
      {
        String interfaceName = (String)iter.next();
        Class instanceClass = Class.forName(interfaceName, true, classLoader);

        EClass implEClass = EcoreFactory.eINSTANCE.createEClass();
        String className = shortName(instanceClass.getName());
        implEClass.setName(className);
        implEClass.setInstanceClass(instanceClass);

        eClasses.put(instanceClass, implEClass);
        implEPackage.getEClassifiers().add(implEClass);
      }

      // Populate the EClasses with EAttributes and EReferences for their properties
      for (Iterator iter = implEPackage.getEClassifiers().iterator(); iter.hasNext();)
      {
        EClass implEClass = (EClass)iter.next();
        Class instanceClass = implEClass.getInstanceClass();
        Method[] methods = instanceClass.getMethods();
        for (int m = 0; m < methods.length; m++)
        {
          Method method = methods[m];
          String propertyName = null;
          if (method.getName().startsWith("get"))
            propertyName = method.getName().substring(3);
          else if (method.getName().startsWith("is"))
            propertyName = method.getName().substring(2);

          if (propertyName != null)
          {
            if (propertyName.length() > 1)
              propertyName = propertyName.substring(0, 1).toLowerCase() + propertyName.substring(1);

            Class propertyClass = method.getReturnType();
            EClass propertyEClass = (EClass)eClasses.get(propertyClass);

            if (propertyEClass != null)
            {
              // The property is another SDO, create an EReference to represent the property
              EReference reference = EcoreFactory.eINSTANCE.createEReference();
              reference.setName(propertyName);
              reference.setContainment(true);
              reference.setEType(propertyEClass);
              implEClass.getEStructuralFeatures().add(reference);

            }
            else
            {
              // The property is a List<T> and T is an SDO, created a 0..many EReference to represent the property
              if (propertyClass == List.class)
              {
                Type genericType = method.getGenericReturnType();
                if (genericType instanceof ParameterizedType)
                {
                  ParameterizedType parameterizedType = (ParameterizedType)genericType;
                  Type[] targs = parameterizedType.getActualTypeArguments();
                  if (targs.length != 0 && eClasses.containsKey(targs[0]))
                  {
                    propertyEClass = (EClass)eClasses.get(targs[0]);
                    if (propertyEClass != null)
                    {
                      EReference reference = EcoreFactory.eINSTANCE.createEReference();
                      reference.setName(propertyName);
                      reference.setContainment(true);
                      reference.setEType(propertyEClass);
                      reference.setUpperBound(-1);
                      implEClass.getEStructuralFeatures().add(reference);
                    }
                  }
                }
                continue;
              }

              // The property is a regular Java type / not an SDO, create an EAttribute to represent it
              EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
              attribute.setName(propertyName);
              EDataType dataType = (EDataType)TypeHelper.INSTANCE.getType(propertyClass);
              attribute.setEType(dataType);
              implEClass.getEStructuralFeatures().add(attribute);
            }
          }
        }
      }

      generatePackages(packageRegistry.values(), packageURI, shortName, targetDirectory, javaPackage, prefix, genOptions);
    }
    catch (ClassNotFoundException e)
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
    System.out.println("  [ -namespace <xsd-namespace> ]");
    System.out.println("  [ -noInterfaces ]");
    System.out.println("  [ -noContainment ]");
    System.out.println("  [ -noNotification ]");
    System.out.println("  [ -noUnsettable ]");
    /* Future Option: System.out.println("  [ -sparsePattern | -storePattern ]"); */
    /* Future Option: System.out.println("  [ -arrayAccessors ]"); */
    /* Future Option: System.out.println("  [ -generateLoader ]"); */
    System.out.println("  interface-names");
    System.out.println("");
    System.out.println("For example:");
    System.out.println("");
    System.out.println("  generate somepackage.InterfaceA somepackage.InterfaceB");
  }

}