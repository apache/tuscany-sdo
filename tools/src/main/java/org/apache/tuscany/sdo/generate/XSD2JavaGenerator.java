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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.apache.tuscany.sdo.helper.HelperContextImpl;
import org.apache.tuscany.sdo.helper.XSDHelperImpl;
import org.apache.tuscany.sdo.util.DataObjectUtil;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.xsd.XSDSchema;

import commonj.sdo.helper.HelperContext;
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
   *     [ -schemaNamespace <namespace-uri> ]
   *     [ -namespaceInfo <namespaces-file> ]
   *     [ other options ... ]
   *     <xsd-file> | <wsdl-file>
   *
   *   Options:
   *   
   *     -schemaNamespace
   *         Generate classes for XSD types in the specified targetNamespace. By default, types in the
   *         targetNamespace of the first schema in the specified xsd or wsdl file are generated. Specify   
   *         'all' and this parameter will act as a wildcard selecting all namespaces for code generation.
   *     -namespaceInfo 
   *         Specifies the name of a file that should contain a list of namespaces and their associated package names.
   *         Optionally, a prefix may be assigned to each namespace as well.  These values are separated by semicolons.
   *         So each line in the file would look something like this:
   *         
   *         some\namespace;custom.package.name;optionalPrefix
   *         
   *     NOTE: see the base class JavaGenerator for other options.
   *         
   *   Example:
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
    catch (Exception e)
    {
      e.printStackTrace();
      printUsage();
    }
  }

  
  protected String schemaNamespace = null;
  protected String namespaceInfo = null;
  protected String generateBuiltIn = null;
  protected static GeneratedPackages generatedPackages = null;
  protected boolean allNamespaces = false;

  protected int handleArgument(String args[], int index)
  {
    if (args[index].equalsIgnoreCase("-schemaNamespace"))
    {
      schemaNamespace = args[++index];
      if( "all".equalsIgnoreCase(schemaNamespace) )
      {
        schemaNamespace = null;
        allNamespaces = true;
      }
    }
    else if (args[index].equalsIgnoreCase("-generateBuiltIn"))
    {
      // Internal option used when regenerating one of the built-in (predefined) models (e.g., commonj.sdo).
      generateBuiltIn = args[++index];
    }
    else if (args[index].equalsIgnoreCase("-namespaceInfo"))
    {
        namespaceInfo = args[++index];
    }
    else
    {
      return super.handleArgument(args, index);
    }
    
    return index + 1;
  }

  protected void run(String args[])
  {
    String xsdFileName = args[inputIndex];
    EPackage.Registry packageRegistry = new EPackageRegistryImpl(EPackage.Registry.INSTANCE);
    ExtendedMetaData extendedMetaData = new BasicExtendedMetaData(packageRegistry);
    String packageURI = getSchemaNamespace(xsdFileName);
    Hashtable packageInfoTable = createPackageInfoTable(packageURI, schemaNamespace, javaPackage, prefix, namespaceInfo );
    generateFromXMLSchema(xsdFileName, packageRegistry, extendedMetaData, targetDirectory, packageInfoTable, genOptions, generateBuiltIn, allNamespaces);
  }

  /**
   * This method was invoked by the SDO Mojo plugin
   * 
   * @param xsdFileName
   * @param namespace
   * @param targetDirectory
   * @param javaPackage
   * @param prefix
   * @param genOptions
   */
  public static void generateFromXMLSchema(String xsdFileName, String namespace, String targetDirectory, String javaPackage, String prefix, int genOptions)
  {
	  boolean allNamespaces = false;
	  
	  // Need to process the passed-in schemaNamespace value from Mojo plugin the same as the command line
	  if( "all".equalsIgnoreCase(namespace))
      {
        namespace = null;
        allNamespaces = true;
      }
	  
    EPackage.Registry packageRegistry = new EPackageRegistryImpl(EPackage.Registry.INSTANCE);
    ExtendedMetaData extendedMetaData = new BasicExtendedMetaData(packageRegistry);
    String packageURI = getSchemaNamespace(xsdFileName);
    Hashtable packageInfoTable = createPackageInfoTable(packageURI, namespace, javaPackage, prefix, null );
    generateFromXMLSchema(xsdFileName, packageRegistry, extendedMetaData, targetDirectory, packageInfoTable, genOptions, null, allNamespaces);
  }

  
  protected static GenModel generateFromXMLSchema(String xsdFileName,
                                                  EPackage.Registry packageRegistry,
                                                  ExtendedMetaData extendedMetaData,
                                                  String targetDirectory, 
                                                  Hashtable packageInfoTable, 
                                                  int genOptions,
                                                  String regenerateBuiltIn,
                                                  boolean allNamespaces )
  {
    GenModel genModel = null;  
      
    HelperContext hc = new HelperContextImpl(extendedMetaData, false);
    XSDHelper xsdHelper = hc.getXSDHelper();
    ((XSDHelperImpl)xsdHelper).setRedefineBuiltIn(regenerateBuiltIn);
    
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
        genModel = generatePackages(packageRegistry.values(), targetDirectory, packageInfoTable, genOptions, allNamespaces );
        // For now, this option is not supported
        /*
        if(  (genModel != null) )
        {
          if((extendedMetaData != null))
          {    
            // Display only, will report all namespaces and associated packages found
            List genPackages = genModel.getGenPackages();
            for (Iterator iter = genPackages.iterator(); iter.hasNext();)
            {
              GenPackage genPackage = (GenPackage)iter.next();
              EPackage ecorePackage = genPackage.getEcorePackage();
              if( (genOptions & OPTION_DISPLAY_NAMESPACES) != 0)                      
                System.out.println(extendedMetaData.getNamespace(ecorePackage)+";"+genPackage.getInterfacePackageName()+"."+ecorePackage.getName());
            }
          }    
        }
        */
      } else {
        System.err.println("Input schema file " + xsdFileName + " defined no metadata.");
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
    return genModel;
  }
  
  public static String getSchemaNamespace(String xsdFileName)
  {
    ResourceSet resourceSet = DataObjectUtil.createResourceSet();
    File inputFile = new File(xsdFileName).getAbsoluteFile();
    Resource model = resourceSet.getResource(URI.createURI(inputFile.toURI().toString()), true);
    XSDSchema schema = (XSDSchema)model.getContents().get(0);
    String targetNS = schema.getTargetNamespace();
    if (targetNS == null) {
    	targetNS = schema.getSchemaLocation();
    }
    
    return targetNS;
  }

  protected static void printUsage()
  {
    System.out.println("Usage arguments:");
    System.out.println("  [ -targetDirectory <target-root-directory> ]");
    System.out.println("  [ -javaPackage <java-package-name> ]");
    System.out.println("  [ -prefix <prefix-string> ]");
    System.out.println("  [ -schemaNamespace <namespace-uri> ]");
    System.out.println("  [ -namespaceInfo <namespaces-file> ]");
    System.out.println("  [ -noInterfaces ]");
    System.out.println("  [ -noContainment ]");
    System.out.println("  [ -noNotification ]");
    System.out.println("  [ -noUnsettable ]");
    /* Future Option: System.out.println("  [ -sparsePattern | -storePattern ]"); */
    /* Future Option: System.out.println("  [ -arrayAccessors ]"); */
    /* Future Option: System.out.println("  [ -generateLoader ]"); */
    /* Future Option: System.out.println("  [ -interfaceDataObject ]"); */
    System.out.println("  <xsd-file> | <wsdl-file>");
    System.out.println("");
    System.out.println("For example:");
    System.out.println("");
    System.out.println("  generate somedir/somefile.xsd");
  }

  public void generateFromXMLSchema(String args[])
  {
    try
    {
      processArguments(args);
      EPackage.Registry packageRegistry = new EPackageRegistryImpl(EPackage.Registry.INSTANCE);
      ExtendedMetaData extendedMetaData = new BasicExtendedMetaData(packageRegistry);
      String xsdFileName = args[inputIndex];
      String packageURI = getSchemaNamespace(xsdFileName);
      Hashtable packageInfoTable = createPackageInfoTable(packageURI, schemaNamespace, javaPackage, prefix, namespaceInfo );
      GenModel genModel = generateFromXMLSchema(xsdFileName, packageRegistry, extendedMetaData, targetDirectory, packageInfoTable, genOptions, generateBuiltIn, allNamespaces);
      generatedPackages = new GeneratedPackages(genModel,extendedMetaData);
    }
    catch (IllegalArgumentException e)
    {
      printUsage();
    }      
  }
  
  private static Hashtable createPackageInfoTable( String packageURI, String schemaNamespace, String javaPackage, String prefix, String namespaceInfo )
  {
    Hashtable packageInfoTable = new Hashtable();
      
    if( namespaceInfo != null )
    {
      try
      {
        FileReader inputFile = new FileReader(namespaceInfo);
        BufferedReader bufRead = new BufferedReader(inputFile);
          
        String line = bufRead.readLine();
        while( line != null )
        {
          if( line.length() > 0 )
          {
            String [] options = line.split(";");
            if( options.length > 1 )
            {
              if( options.length > 2 )
                packageInfoTable.put(options[0], new PackageInfo(options[1], options[2], options[0], null ));
              else    
                packageInfoTable.put(options[0], new PackageInfo(options[1], null, options[0], null ));
            }
            else
              packageInfoTable.put(options[0], new PackageInfo(null, null, options[0], null ));
          }
              line = bufRead.readLine();
        }
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    else
    {
        if( schemaNamespace != null )
            packageInfoTable.put(schemaNamespace, new PackageInfo(javaPackage, prefix, schemaNamespace, null ));
        else if( packageURI != null )
            packageInfoTable.put(packageURI, new PackageInfo(javaPackage, prefix, null, null ));
    }    
    return packageInfoTable;
  }
  
  public List getGeneratedPackageInfo()
  {
    if( generatedPackages != null )
      return generatedPackages.getPackageList();
    else
      return null;
  }
  
  protected class GeneratedPackages
  {
    private List genPackages = null;
      
    GeneratedPackages(GenModel genModel, ExtendedMetaData extendedMetaData)
    {
      List packages = genModel.getGenPackages();
      Hashtable genClasses = new Hashtable();
      for (Iterator iter = packages.iterator(); iter.hasNext();)
      {
        // loop through the list, once to build up the eclass to genclass mapper
        GenPackage genPackage = (GenPackage)iter.next();
        List classes = genPackage.getGenClasses();
        for (Iterator classIter = classes.iterator(); classIter.hasNext();)
        {
          GenClass genClass = (GenClass)classIter.next();
          genClasses.put(genClass.getEcoreClass(), genClass);
        }
      }
      genPackages = new ArrayList();
      for (Iterator iter = packages.iterator(); iter.hasNext();)
      {
        // now process the pckage list
        GenPackage genPackage = (GenPackage)iter.next();
        genPackages.add(new GeneratedPackage(genPackage,extendedMetaData,genClasses));
      }
    }
      
    List getPackageList() {return genPackages;}
  }
  
  public class GeneratedPackage
  {
    private String  namespace;
    private Hashtable classes;
    
    public String getNamespace() {return namespace;}
    public List getClasses() {return new ArrayList(classes.values());}
    
    GeneratedPackage(GenPackage genPackage, ExtendedMetaData extendedMetaData, Hashtable eclassGenClassMap )
    {
      classes = new Hashtable();
         
      EPackage ePackage = genPackage.getEcorePackage();
      namespace     = extendedMetaData.getNamespace(ePackage);
        
      List genClasses = genPackage.getGenClasses();
      for (Iterator iterClass = genClasses.iterator(); iterClass.hasNext();)
      {
        GenClass genClass = (GenClass)iterClass.next();
        if ("DocumentRoot".equals(genClass.getEcoreClass().getName())) {
	        List features = genClass.getGenFeatures();
	        for (Iterator iterFeatures = features.iterator(); iterFeatures.hasNext();)
	        {
	          GenFeature feature = (GenFeature)iterFeatures.next();
	          addGlobalElement(feature.getEcoreFeature(),extendedMetaData, eclassGenClassMap);
	        }
        }
      }
    }
    
    private void addGlobalElement(EStructuralFeature eFeature, ExtendedMetaData extendedMetaData, Hashtable eclassGenClassMap )
    {
        
      String name               = eFeature.getName();
      String classname          = "";
      boolean anonymous         = false;
      List propertyClassNames   = null;
          
      EClassifier eClassifier = eFeature.getEType();
      
      if( eClassifier instanceof EClass )
      {
        // complex type
        EClass eClass = (EClass)eClassifier;
        GenClass genEClass = (GenClass)eclassGenClassMap.get(eClassifier);
        if( genEClass != null )
        {    
          classname = genEClass.getGenPackage().getInterfacePackageName()
                 + '.' + genEClass.getInterfaceName();
          anonymous = extendedMetaData.isAnonymous(eClass);
                        
          // Build list of property names
          propertyClassNames = new ArrayList();
          List properties = eClass.getEStructuralFeatures(); 
          for (Iterator iterProperties = properties.iterator(); iterProperties.hasNext();)
          {
            EStructuralFeature property = (EStructuralFeature)iterProperties.next();
            EClassifier propertyType = property.getEType();
            if (propertyType instanceof EClass) 
            {
              GenClass propertyGenClass = (GenClass)eclassGenClassMap.get(propertyType);
              if( propertyGenClass != null )
              {    
                String propertyClassName =  propertyGenClass.getGenPackage().getInterfacePackageName() + '.'
                                            + propertyGenClass.getInterfaceName();
                propertyClassNames.add(propertyClassName);
              }        
            } 
            else if (propertyType instanceof EClassifier) 
            {
              String propertyClassName = propertyType.getInstanceClass().getName();
              propertyClassNames.add(propertyClassName);
            }
          }
        }
      }
      else
      {
          // simple type
          classname = eClassifier.getInstanceClass().getName();
      }
      classes.put( name, new PackageClassInfo( name, classname, anonymous, propertyClassNames ) );
    }
    
    public class PackageClassInfo
    {
      private String name;
      private String className = null;
      private boolean anonymous = false;
      private List properties = null;
        
      PackageClassInfo( String name, String className, boolean anonymous, List properties )
      {
        this.name = name;
        this.className = className;
        this.anonymous = anonymous;
        this.properties = properties;
      }
        
      public String getName() {return name;}
      public String getClassName() {return className;}
      public boolean getAnonymous() {return anonymous;}
      public List getProperties() {return properties;}
    }
  }
}
