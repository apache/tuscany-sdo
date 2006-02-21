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
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.tuscany.sdo.helper.XSDHelperImpl;
import org.apache.tuscany.sdo.util.DataObjectUtil;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenDelegationKind;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenResourceKind;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import commonj.sdo.helper.XSDHelper;


public class JavaGenerator
{
  public static int OPTION_NO_INTERFACES=0x1;
  public static int OPTION_SPARSE_PATTERN=0x2;
  public static int OPTION_STORE_PATTERN=0x4;
  public static int OPTION_NO_CONTAINMENT=0x8;
  public static int OPTION_NO_NOTIFICATION=0x10;
  public static int OPTION_ARRAY_ACCESSORS=0x20;
  public static int OPTION_GENERATE_LOADER=0x40;
  public static int OPTION_NO_UNSETTABLE=0x80;
  
  /**
   * Generate static SDOs from XML Schema
   * 
   *   Usage arguments:
   *   
   *     [ -targetDirectory <target-root-directory> ]
   *     [ -javaPackage <java-package-name> ]
   *     [ -prefix <prefix-string> ]
   *     [ -sparsePattern | -storePattern ]
   *     [ -noInterfaces ]
   *     [ -noContainment ]
   *     [ -noNotification ]
   *     [ -arrayAccessors ]
   *     [ -generateLoader ]
   *     [ -noUnsettable ]
   *     <xsd-file> | <wsdl-file>
   *
   *   For example:
   *   
   *     generate somedir/somefile.xsd
   *     
   *   Basic options:
   *   
   *     -targetDirectory
   *         Generates the Java source code in the specified directory. By default, the code is generated
   *         in the same directory as the input xsd or wsdl file.
   *     -javaPackage
   *         Overrides the Java package for the generated classes. By default the package name is derived
   *         from the targetNamespace of the XML schema being generated. For example, if the targetNamespace is
   *         "http://www.example.com/simple", the default package will be "com.example.simple".
   *     -prefix
   *         Specifies the prefix string to use for naming the generated factory. For example "-prefix Foo" will
   *         result in a factory interface with the name "FooFactory".
   *     -sparsePattern
   *         For SDO metamodels that have classes with many properties of which only a few are typically set at
   *         runtime, this option can be used to produce a space-optimized implementation (at the expense of speed).
   *     -storePattern
   *         This option can be used to generate static classes that work with a Store-based DataObject
   *         implementation. It changes the generator pattern to generate accessors which delegate to the
   *         reflective methods (as opposed to the other way around) and changes the DataObject base class
   *         to org.apache.tuscany.sdo.impl.StoreDataObjectImpl. Note that this option generates classes that
   *         require a Store implementation to be provided before they can be run.    
   *         
   *   The following options can be used to increase performance, but with some loss of SDO functionality:
   *   
   *     -noInterfaces
   *         By default, each DataObject generates both a Java interface and a corresponding implementation
   *         class. If an SDO metamodel does not use multiple inheritance (which is always the case for
   *         XML Schema derived models), then this option can be used to eliminate the interface and to generate
   *         only an implementation class.
   *         
   *   Following are planned but not supported yet:
   *   
   *     -noNotification
   *         This option eliminates all change notification overhead in the generated classes. Changes to
   *         DataObjects generated using this option cannot be recorded, and consequently the classes cannot
   *         be used with an SDO ChangeSummary or DataGraph.
   *     -noContainment
   *         Turns off container management for containment properties. DataObject.getContainer() will always
   *         return null for data objects generated with this option, even if a containment reference is set.
   *         Setting a containment reference will also not automatically remove the target object from its
   *         previous container, if it had one, so it will need to be explicitly removed by the client. Use
   *         of this option is only recommended for scenarios where this kind of container movement/management
   *         is not necessary.
   *     -arrayAccessors
   *         Generates Java array getters/setters for multiplicity-many properties. With this option, 
   *         the set of "standard" JavaBean array accessor methods (e.g., Foo[] getFoo(), Foo getFoo(int),
   *         int getFooLength(), setFoo(Foo[]), and void setFoo(int, Foo)) are generated. The normal
   *         List-returning accessor is renamed with the suffix "List" (e.g., List getFooList()). The array
   *         returned by the generated method is not a copy, but instead a pointer to the underlying storage 
   *         array, so directly modifying it can have undesirable consequences and should be avoided.
   *     -generateLoader
   *         Generate a fast XML parser/loader for instances of the model. The details of this option are 
   *         subject to change, but currently it generates two additional classes in a "util" package: 
   *         <prefix>ResourceImpl and <prefix>ResourceFactoryImpl. To use the generated loader at runtime,
   *         you need to pass an option to the XMLHelper.load() method like this:
   *           Map options = new HashMap();
   *           options.put("GENERATED_LOADER", <prefix>ResourceFactoryImpl.class);
   *           XMLDocument doc = XMLHelper.INSTANCE.load(new FileInputStream("somefile.xml"), null, options);
   *         Note: this option currently only works for simple schemas without substitution groups or wildcards.
   *     -noUnsettable
   *         By default, some XML constructs result in SDO property implementations that maintain additional
   *         state information to record when the property has been set to the "default value", as opposed to
   *         being truly unset (see DataObject.isSet() and DataObject.unset()). The SDO specification allows an
   *         implementation to choose to provide this behavior or not. With this option, all generated properties
   *         will not record their unset state. The generated isSet() methods simply returns whether the current
   *         value is equal to the property's "default value".
   */
  public static void main(String args[])
  {
    if (args.length == 0)
    {
      printUsage();
      return;
    }

    String targetDirectory = null;
    String javaPackage = null;
    String prefix = null;
    
    int genOptions = 0;

    int index = 0;
    for (; index < args.length && args[index].startsWith("-"); ++index)
    {
      if (args[index].equalsIgnoreCase("-targetDirectory"))
      {
        targetDirectory = args[++index];
      }
      else if (args[index].equalsIgnoreCase("-javaPackage"))
      {
        javaPackage = args[++index];
      }
      else if (args[index].equalsIgnoreCase("-prefix"))
      {
        prefix = args[++index];
      }
      else if (args[index].equalsIgnoreCase("-noInterfaces"))
      {
        genOptions |= OPTION_NO_INTERFACES;
      }
      else if (args[index].equalsIgnoreCase("-sparsePattern"))
      {
        genOptions |= OPTION_SPARSE_PATTERN;
      }
      else if (args[index].equalsIgnoreCase("-storePattern"))
      {
        genOptions |= OPTION_STORE_PATTERN;
      }
      else if (args[index].equalsIgnoreCase("-noContainment"))
      {
        genOptions |= OPTION_NO_CONTAINMENT;
      }
      else if (args[index].equalsIgnoreCase("-noNotification"))
      {
        genOptions |= OPTION_NO_NOTIFICATION;
      }
      else if (args[index].equalsIgnoreCase("-arrayAccessors"))
      {
        genOptions |= OPTION_ARRAY_ACCESSORS;
      }
      else if (args[index].equalsIgnoreCase("-generateLoader"))
      {
        genOptions |= OPTION_GENERATE_LOADER;
      }
      else if (args[index].equalsIgnoreCase("-noUnsettable"))
      {
        genOptions |= OPTION_NO_UNSETTABLE;
      }
      //else if (...)
      else
      {
        printUsage();
        return;
      }
    }

    String xsdFileName = args[index];
    
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
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public static void generateFromEPackage(EPackage ePackage, String targetDirectory, String basePackage, String prefix, int genOptions)
  {
    GenModel genModel = ecore2GenModel(ePackage, basePackage, prefix, genOptions);

    ResourceSet resourceSet = DataObjectUtil.createResourceSet();
    URI ecoreURI = URI.createURI("file:///temp.ecore");
    URI genModelURI = ecoreURI.trimFileExtension().appendFileExtension("genmodel");

    Resource ecoreResource = resourceSet.createResource(ecoreURI);
    ecoreResource.getContents().add(ePackage);

    Resource genModelResource = resourceSet.createResource(genModelURI);
    genModelResource.getContents().add(genModel);

    generateFromGenModel(genModel, targetDirectory);
  }

  public static void generateFromGenModel(GenModel genModel, String targetDirectory)
  {
    Resource resource = genModel.eResource();

    if (targetDirectory != null)
    {
      resource.getResourceSet().getURIConverter().getURIMap().put(
        URI.createURI("platform:/resource/TargetProject/"),
        URI.createFileURI(targetDirectory + "/"));
      genModel.setModelDirectory("/TargetProject");
    }

    genModel.gen(new BasicMonitor.Printing(System.out));

    for (Iterator j = resource.getContents().iterator(); j.hasNext();)
    {
      EObject eObject = (EObject)j.next();
      Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
      if (diagnostic.getSeverity() != Diagnostic.OK)
      {
        printDiagnostic(diagnostic, "");
      }
    }
  }

  public static GenModel ecore2GenModel(EPackage ePackage, String basePackage, String prefix, int genOptions)
  {
    GenModel genModel = GenModelFactory.eINSTANCE.createGenModel();
    genModel.initialize(Collections.singleton(ePackage));
    
    genModel.setRootExtendsInterface("");
    genModel.setRootImplementsInterface("commonj.sdo.DataObject");
    genModel.setRootExtendsClass("org.apache.tuscany.sdo.impl.DataObjectImpl");
    genModel.setFeatureMapWrapperInterface("commonj.sdo.Sequence");
    genModel.setFeatureMapWrapperInternalInterface("org.apache.tuscany.sdo.util.BasicSequence");
    genModel.setFeatureMapWrapperClass("org.apache.tuscany.sdo.util.BasicSequence");
    genModel.setSuppressEMFTypes(true);
    genModel.setSuppressEMFMetaData(true);
    genModel.setSuppressEMFModelTags(true);
    genModel.setCanGenerate(true);
    //FIXME workaround java.lang.NoClassDefFoundError: org/eclipse/jdt/core/jdom/IDOMNode with 02162006 build
    genModel.setFacadeHelperClass("Hack");
    genModel.setForceOverwrite(true);
    
    if ((genOptions & OPTION_NO_INTERFACES) != 0)
    {
      genModel.setSuppressInterfaces(true);
    }
    
    if ((genOptions & OPTION_SPARSE_PATTERN) != 0)
    {
      genModel.setFeatureDelegation(GenDelegationKind.VIRTUAL_LITERAL);
    }
    else if ((genOptions & OPTION_STORE_PATTERN) != 0)
    {
      genModel.setFeatureDelegation(GenDelegationKind.REFLECTIVE_LITERAL);
      genModel.setRootExtendsClass("org.apache.tuscany.sdo.impl.StoreDataObjectImpl");
    }

    if ((genOptions & OPTION_NO_CONTAINMENT) != 0)
    {
      genModel.setSuppressContainment(true);
    }
    
    if ((genOptions & OPTION_NO_NOTIFICATION) != 0)
    {
      genModel.setSuppressNotification(true);
    }
    
    if ((genOptions & OPTION_ARRAY_ACCESSORS) != 0)
    {
      genModel.setArrayAccessors(true);
    }
    
    if ((genOptions & OPTION_NO_UNSETTABLE) != 0)
    {
      genModel.setSuppressUnsettable(true);
    }
    
    GenPackage genPackage = (GenPackage)genModel.getGenPackages().get(0);

    if (basePackage != null)
    {
      genPackage.setBasePackage(basePackage);
    }
    if (prefix != null) 
    {
      genPackage.setPrefix(prefix);
    }
    
    genPackage.setAdapterFactory(false);

    if ((genOptions & OPTION_GENERATE_LOADER) != 0)
    {
      //FIXME workaround compile error with 02162006 build, generated code references non-existent EcoreResourceImpl class
      genPackage.setResource(GenResourceKind.XML_LITERAL);
      //genPackage.setDataTypeConverters(true);
    }
    else
    {
      genPackage.setResource(GenResourceKind.NONE_LITERAL);
      for (Iterator iter = genPackage.getGenClasses().iterator(); iter.hasNext();)
      {
        GenClass genClass = (GenClass)iter.next();
        if ("DocumentRoot".equals(genClass.getName()))
        {
          genClass.setDynamic(true); // Don't generate DocumentRoot class
          break;
        }
      }
    }

    return genModel;
  }

  public static String extractBasePackageName(EPackage ePackage, String javaPackage)
  {
    String qualifiedName = javaPackage != null ? javaPackage : ePackage.getName();
    String name = /*CodeGenUtil.*/shortName(qualifiedName);
    String baseName = qualifiedName.substring(0, qualifiedName.length() - name.length());
    if (javaPackage != null || !name.equals(qualifiedName))
    {
      ePackage.setName(name);
    }
    return baseName != null ? /*CodeGenUtil.*/safeQualifiedName(baseName) : null;
  }

  public static String shortName(String qualifiedName)
  {
    int index = qualifiedName.lastIndexOf(".");
    return index != -1 ? qualifiedName.substring(index + 1) : qualifiedName;
  }

  public static String safeQualifiedName(String qualifiedName)
  {
    StringBuffer safeQualifiedName = new StringBuffer();
    for (StringTokenizer stringTokenizer = new StringTokenizer(qualifiedName, "."); stringTokenizer.hasMoreTokens();)
    {
      String name = stringTokenizer.nextToken();
      safeQualifiedName.append(CodeGenUtil.safeName(name));
      if (stringTokenizer.hasMoreTokens())
      {
        safeQualifiedName.append('.');
      }
    }
    return safeQualifiedName.toString();
  }

  protected static void printDiagnostic(Diagnostic diagnostic, String indent)
  {
    System.out.print(indent);
    System.out.println(diagnostic.getMessage());
    for (Iterator i = diagnostic.getChildren().iterator(); i.hasNext();)
    {
      printDiagnostic((Diagnostic)i.next(), indent + "  ");
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
