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


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.tuscany.sdo.generate.adapter.SDOGenModelGeneratorAdapterFactory;
import org.apache.tuscany.sdo.helper.HelperContextImpl;
import org.apache.tuscany.sdo.impl.SDOPackageImpl;
import org.apache.tuscany.sdo.model.ModelFactory;
import org.apache.tuscany.sdo.model.internal.InternalFactory;
import org.apache.tuscany.sdo.util.DataObjectUtil;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenDelegationKind;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenResourceKind;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory;
import org.eclipse.emf.codegen.merge.java.JControlModel;
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
import org.eclipse.xsd.XSDSchema;

import commonj.sdo.helper.XSDHelper;

/**
 * Abstract base class for static SDO code generators. See XSD2JavaGenerator and Interface2JavaGenerator for
 * concrete generator commands.
 * 
 *   Supports the following command line options:
 * 
 *     [ -targetDirectory <target-root-directory> ]
 *     [ -javaPackage <java-package-name> ]
 *     [ -prefix <prefix-string> ]
 *     [ -noInterfaces ]
 *     [ -noContainment ]
 *     [ -noNotification ]
 *     [ -noUnsettable ]
 *     
 *   Not supported (future options):
 *   
 *     [ -arrayAccessors ]
 *     [ -generateLoader ]
 *     [ -interfaceDataObject ]
 *     [ -sparsePattern | -storePattern ]
 *     [ -noGenerate ]
 *     
 *   Basic options:
 *   
 *     -javaPackage
 *         Overrides the Java package for the generated classes. By default the package name is derived
 *         from the targetNamespace of the XML schema being generated. For example, if the targetNamespace is
 *         "http://www.example.com/simple", the default package will be "com.example.simple".
 *     -prefix
 *         Specifies the prefix string to use for naming the generated factory. For example "-prefix Foo" will
 *         result in a factory interface with the name "FooFactory".
 *     -targetDirectory
 *         Generates the Java source code in the specified directory. By default, the code is generated
 *         in the same directory as the input xsd or wsdl file.
 *         is not necessary.
 *
 *   Extended options:
 *
 *     -noContainment
 *         Turns off container management for containment properties. DataObject.getContainer() will always
 *         return null for data objects generated with this option, even if a containment reference is set.
 *         Setting a containment reference will also not automatically remove the target object from its
 *         previous container, if it had one, so it will need to be explicitly removed by the client. Use
 *         of this option is only recommended for scenarios where this kind of container movement/management
 *     -noInterfaces
 *         By default, each DataObject generates both a Java interface and a corresponding implementation
 *         class. If an SDO metamodel does not use multiple inheritance (which is always the case for
 *         XML Schema derived models), then this option can be used to eliminate the interface and to generate
 *         only an implementation class.
 *     -noNotification
 *         This option eliminates all change notification overhead in the generated classes. Changes to
 *         DataObjects generated using this option cannot be recorded, and consequently the classes cannot
 *         be used with an SDO ChangeSummary or DataGraph.
 *     -noUnsettable
 *         By default, some XML constructs result in SDO property implementations that maintain additional
 *         state information to record when the property has been set to the "default value", as opposed to
 *         being truly unset (see DataObject.isSet() and DataObject.unset()). The SDO specification allows an
 *         implementation to choose to provide this behavior or not. With this option, all generated properties
 *         will not record their unset state. The generated isSet() methods simply returns whether the current
 *         value is equal to the property's "default value".
 *         
 *   Following are planned but not supported yet:
 *   
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
 *     -interfaceDataObject
 *         This option is used to generate static interfaces that extend commonj.sdo.DataObject  
 *     -sparsePattern
 *         For SDO metamodels that have classes with many properties of which only a few are typically set at
 *         runtime, this option can be used to produce a space-optimized implementation (at the expense of speed).
 *     -storePattern
 *         This option can be used to generate static classes that work with a Store-based DataObject
 *         implementation. It changes the generator pattern to generate accessors which delegate to the
 *         reflective methods (as opposed to the other way around) and changes the DataObject base class
 *         to org.apache.tuscany.sdo.impl.StoreDataObjectImpl. Note that this option generates classes that
 *         require a Store implementation to be provided before they can be run.
 *     -noGenerate
 *         A basic implementation of this switch is in place, but is not fully implemented. An intention
 *         behind this is to provide commentary on the artifacts that would be generated.  
 *         
 *         
 */
public abstract class JavaGenerator
{
  public static int OPTION_NO_INTERFACES=0x1;
  public static int OPTION_SPARSE_PATTERN=0x2;
  public static int OPTION_STORE_PATTERN=0x4;
  public static int OPTION_NO_CONTAINMENT=0x8;
  public static int OPTION_NO_NOTIFICATION=0x10;
  public static int OPTION_ARRAY_ACCESSORS=0x20;
  public static int OPTION_GENERATE_LOADER=0x40;
  public static int OPTION_NO_UNSETTABLE=0x80;
  //FIXME Temporary, I need this option for now to get Switch classes generated for the SCDL models
  public static int OPTION_GENERATE_SWITCH=0x100;
  public static int OPTION_INTERFACE_DO=0x400;
  public static int OPTION_NO_GENERATE=0x800;
  
  static 
  {
    System.setProperty("EMF_NO_CONSTRAINTS", "true"); // never generate a validator class
  }
  
  /**
   * @deprecated replaced by XSD2JavaGenerator
   */
  public static void main(String args[])
  {
    try
    {
      JavaGenerator generator = new XSD2JavaGenerator();
      generator.processArguments(args);
      generator.run(args);
    }
    catch (IllegalArgumentException e)
    {
      printUsage();
    }
  }

  protected void processArguments(String args[])
  {
    if (args.length == 0)
    {
      throw new IllegalArgumentException();
    }

    int index = 0;
    while (args[index].startsWith("-"))
    {
      int newIndex = handleArgument(args, index);
      if (newIndex == index)
      {
        throw new IllegalArgumentException();
      }
      index = newIndex;
      if (index == args.length)
      {
        throw new IllegalArgumentException();
      }
    }

    inputIndex = index;
  }
  
  protected String targetDirectory = null;
  protected String javaPackage = null;
  protected String prefix = null;
  protected int genOptions = 0;
  protected String xsdFileName;
  protected int inputIndex;

  protected int handleArgument(String args[], int index)
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
    else if (args[index].equalsIgnoreCase("-noEMF"))
    {
      System.out.println("Warning: -noEMF is deprecated. It is the default now.");
      //genOptions |= OPTION_NO_EMF;
    }
    else if (args[index].equalsIgnoreCase("-interfaceDataObject"))
    {
      genOptions |= OPTION_INTERFACE_DO;
    }
    else if (args[index].equalsIgnoreCase("-noGenerate"))
    {
      genOptions |= OPTION_NO_GENERATE;
    }
    //else if (...)
    else
    {
      return index;
    }
    
    return index + 1;
  }

  protected abstract void run(String args[]);

  /**
   * @deprecated moved to XSD2JavaGenerator
   */
  public static void generateFromXMLSchema(String xsdFileName, String targetDirectory, String javaPackage, String prefix, int genOptions)
  {
    DataObjectUtil.initRuntime();
    EPackage.Registry packageRegistry = new EPackageRegistryImpl(EPackage.Registry.INSTANCE);
    ExtendedMetaData extendedMetaData = new BasicExtendedMetaData(packageRegistry);
    XSDHelper xsdHelper = (new HelperContextImpl(extendedMetaData, false)).getXSDHelper();

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
  
  protected static void generatePackages(Collection packageList, String packageURI, String shortName, String targetDirectory, String javaPackage, String prefix, int genOptions)
  {
    Hashtable packageInfoTable = new Hashtable();
    packageInfoTable.put(packageURI, new PackageInfo(javaPackage, prefix, packageURI, shortName ));
    generatePackages(packageList, targetDirectory, packageInfoTable, genOptions, false);      
  }
  
  protected static GenModel generatePackages(Collection packageList, String targetDirectory, Hashtable packageInfoTable, int genOptions, boolean allNamespaces )
  {
    ResourceSet resourceSet = DataObjectUtil.createResourceSet();
    List usedGenPackages = new ArrayList();
    GenModel genModel = null;
    ArrayList packagesToModel = new ArrayList();
    for (Iterator iter = packageList.iterator(); iter.hasNext();)
    {
      EPackage currentEPackage = (EPackage)iter.next();
      String packageNamespace  = currentEPackage.getNsURI();
      PackageInfo packageInfo  = (PackageInfo)packageInfoTable.get(packageNamespace);
      boolean bTargetPackage   = allNamespaces;
      String javaPackage       = null;
      String prefix            = null;
      String shortName         = null;
      if( packageInfo != null )
      {
        bTargetPackage = true;
        javaPackage    = packageInfo.getBasePackage();
        prefix         = packageInfo.getPrefix();
        shortName      = packageInfo.getShortName();
      }    
      String currentBasePackage = extractBasePackageName(currentEPackage, bTargetPackage ? javaPackage : null);
      String currentPrefix = bTargetPackage && prefix != null ? prefix : CodeGenUtil.capName(shortName != null ? shortName : currentEPackage.getName());
      packageInfoTable.put(currentEPackage, new PackageInfo(currentBasePackage, currentPrefix, null, null ));
      
      if( allNamespaces || packageInfo != null )
          packagesToModel.add(currentEPackage);
      else
      {    
          GenPackage currentGenPackage = createGenPackage(currentEPackage, currentBasePackage, currentPrefix, genOptions, resourceSet);
          usedGenPackages.add(currentGenPackage);
      }    
    }
    genModel = createGenPackages(packagesToModel, packageInfoTable, genOptions, resourceSet);
      
    if (genModel == null) return null; // nothing to generate

    //TODO Figure out which predefined packages are really "used"
    usedGenPackages.add(createGenPackage(SDOPackageImpl.eINSTANCE, "org.apache.tuscany", "SDO", 0, resourceSet));
    usedGenPackages.add(createGenPackage((EPackage)ModelFactory.INSTANCE, "org.apache.tuscany.sdo", "Model", 0, resourceSet));
    usedGenPackages.add(createGenPackage((EPackage)InternalFactory.INSTANCE, "org.apache.tuscany.sdo.model", "Internal", 0, resourceSet));
    //usedGenPackages.add(createGenPackage((EPackage)JavaFactory.INSTANCE, "org.apache.tuscany.sdo.model", "Java", 0, resourceSet));
    //usedGenPackages.add(createGenPackage((EPackage)XMLFactory.INSTANCE, "org.apache.tuscany.sdo.model", "XML", 0, resourceSet));
   
    genModel.getUsedGenPackages().addAll(usedGenPackages);
      
    // If the display namespace option is selected, Don't generate
    if( (genOptions & OPTION_NO_GENERATE) == 0)                      
    {
      // Invoke the SDO JavaGenerator to generate the SDO classes
      try
      {
        generateFromGenModel(genModel, new File(targetDirectory).getCanonicalPath(), genOptions);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
      
    return genModel;    
  }
  
  /**
   * @deprecated
   */
  public static String getSchemaNamespace(String xsdFileName)
  {
    ResourceSet resourceSet = DataObjectUtil.createResourceSet();
    File inputFile = new File(xsdFileName).getAbsoluteFile();
    Resource model = resourceSet.getResource(URI.createURI(inputFile.toURI().toString()), true);
    XSDSchema schema = (XSDSchema)model.getContents().get(0);
    return schema.getTargetNamespace();
  }

  protected static GenModel createGenPackages(Collection ePackages, Hashtable packageInfoTable, int genOptions, ResourceSet resourceSet)
  {
    GenModel genModel = ecore2GenModel(ePackages, packageInfoTable, genOptions);

    for (Iterator iter = ePackages.iterator(); iter.hasNext();)
    {
      EPackage ePackage = (EPackage)iter.next(); 
        
      URI ecoreURI = URI.createURI("file:///" + ePackage.getName() + ".ecore");
      URI genModelURI = ecoreURI.trimFileExtension().appendFileExtension("genmodel");

      Resource ecoreResource = resourceSet.createResource(ecoreURI);
      ecoreResource.getContents().add(ePackage);

      Resource genModelResource = resourceSet.createResource(genModelURI);
      genModelResource.getContents().add(genModel);
    }    

    return genModel;
  }
  
  public static GenPackage createGenPackage(EPackage ePackage, String basePackage, String prefix, int genOptions, ResourceSet resourceSet)
  {
    GenModel genModel = ecore2GenModel(ePackage, basePackage, prefix, genOptions);

    URI ecoreURI = URI.createURI("file:///" + ePackage.getName() + ".ecore");
    URI genModelURI = ecoreURI.trimFileExtension().appendFileExtension("genmodel");

    Resource ecoreResource = resourceSet.createResource(ecoreURI);
    ecoreResource.getContents().add(ePackage);

    Resource genModelResource = resourceSet.createResource(genModelURI);
    genModelResource.getContents().add(genModel);

    return (GenPackage)genModel.getGenPackages().get(0);
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

    generateFromGenModel(genModel, targetDirectory, genOptions);
  }

  public static void generateFromGenModel(GenModel genModel, String targetDirectory, int genOptions)
  {
    Resource resource = genModel.eResource();

    // Return if nothing is found 
    if( resource == null )
        return;
    
    if (targetDirectory != null)
    {
      resource.getResourceSet().getURIConverter().getURIMap().put(
        URI.createURI("platform:/resource/TargetProject/"),
        URI.createFileURI(targetDirectory + "/"));
      genModel.setModelDirectory("/TargetProject");
    }

    //genModel.gen(new BasicMonitor.Printing(System.out));
    GeneratorAdapterFactory.Descriptor.Registry.INSTANCE.addDescriptor
    (GenModelPackage.eNS_URI, GenModelGeneratorAdapterFactory.DESCRIPTOR);
    
    //Generator generator = new Generator();
    Generator generator = new Generator()
    {
      public JControlModel getJControlModel()
      {
        if (jControlModel == null)
        {
          jControlModel = new JControlModel();
        }
        return jControlModel;
      }
    };


    //if ((genOptions & OPTION_USE_EMF_PATTERNS) == 0)
    {
      generator.getAdapterFactoryDescriptorRegistry().addDescriptor
      (GenModelPackage.eNS_URI, SDOGenModelGeneratorAdapterFactory.DESCRIPTOR);
    }
    
    generator.setInput(genModel);
    generator.generate(genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, new BasicMonitor.Printing(System.out));


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
      ArrayList ePackages = new ArrayList();
      ePackages.add(ePackage);
      Hashtable packageInfoTable = new Hashtable();
      packageInfoTable.put(ePackage, new PackageInfo(basePackage, prefix, null, null ));
      return ecore2GenModel(ePackages, packageInfoTable, genOptions ); 
  }
  
  private static GenModel ecore2GenModel(Collection ePackages, Hashtable packageInfoTable, int genOptions)
  {
    GenModel genModel = GenModelFactory.eINSTANCE.createGenModel();
    genModel.initialize(ePackages);
    
    genModel.setRootExtendsInterface("");
    genModel.setRootImplementsInterface("commonj.sdo.DataObject");
    genModel.setRootExtendsClass("org.apache.tuscany.sdo.impl.ExtensibleDataObjectImpl");
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
    
    //if ((genOptions & OPTION_USE_EMF_PATTERNS) == 0)
    {
      genModel.setRootExtendsClass("org.apache.tuscany.sdo.impl.DataObjectBase");
    }
    
    if ((genOptions & OPTION_INTERFACE_DO) != 0)
    {
      genModel.setRootExtendsInterface("commonj.sdo.DataObject");
    }
    else
    {
      genModel.setRootExtendsInterface("java.io.Serializable");
    }
    
    //GenPackage genPackage = (GenPackage)genModel.getGenPackages().get(0);
    Collection packages = genModel.getGenPackages(); 
    for (Iterator iter1 = packages.iterator(); iter1.hasNext();)
    {
      GenPackage genPackage   = (GenPackage)iter1.next();
      PackageInfo packageInfo = (PackageInfo)packageInfoTable.get(genPackage.getEcorePackage());
        
      if (packageInfo.getBasePackage() != null)
      {
          genPackage.setBasePackage(packageInfo.getBasePackage());
      }
      if (packageInfo.getPrefix() != null) 
      {
          genPackage.setPrefix(packageInfo.getPrefix());
      }

      //FIXME Temporary, I need this option for now to get Switch classes generated for the SCDL models
      if ((genOptions & OPTION_GENERATE_SWITCH) == 0)
      {
          genPackage.setAdapterFactory(false);
      }

      if ((genOptions & OPTION_GENERATE_LOADER) != 0)
      {
        //FIXME workaround compile error with 02162006 build, generated code references non-existent EcoreResourceImpl class
        genPackage.setResource(GenResourceKind.XML_LITERAL);
        //genPackage.setDataTypeConverters(true);
      }
      else
      {
        genPackage.setResource(GenResourceKind.NONE_LITERAL);
        for (Iterator iter2 = genPackage.getGenClasses().iterator(); iter2.hasNext();)
        {
          GenClass genClass = (GenClass)iter2.next();
          if ("DocumentRoot".equals(genClass.getName()))
          {
            genClass.setDynamic(true); // Don't generate DocumentRoot class
            break;
          }
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
    System.out.println("Usage: this is a deprecated command replaced by XSD2JavaGenerator");
  }

  public static class PackageInfo
  {
    private String   basePackage;
    private String   prefix;
    private String   namespace;
    private String   shortName;

    public PackageInfo(String basePackage, String prefix, String namespace, String shortName ) 
    { 
      setBasePackage(basePackage);
      setPrefix(prefix);
      setNamespace(namespace);
      setShortName(shortName);
    }
      
    public void setBasePackage(String basePackage) { this.basePackage = basePackage; }
    public String getBasePackage() { return basePackage; }
    public void setPrefix(String prefix) { this.prefix = prefix; }
    public String getPrefix() { return prefix; }
    public void setNamespace(String namespace) { this.namespace = namespace; }
    public String getNamespace() { return namespace; }
    public void setShortName(String shortName) { this.shortName = shortName; }
    public String getShortName() { return shortName; }
  }
}
