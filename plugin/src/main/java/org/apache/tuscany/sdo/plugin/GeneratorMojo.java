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
package org.apache.tuscany.sdo.plugin;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.descriptor.MojoDescriptor;
import org.apache.maven.plugin.descriptor.PluginDescriptor;
import org.apache.maven.project.MavenProject;
import org.apache.tuscany.sdo.generate.JavaGenerator;
import org.apache.tuscany.sdo.generate.XSD2JavaGenerator;

/**
 * @version $Rev$ $Date$
 * @goal generate
 * @phase generate-sources
 * @description Generate SDO interface classes from an XML Schema
 */
public class GeneratorMojo extends AbstractMojo {
    /**
     * The directory containing schema files; defaults to
     * ${basedir}/src/main/xsd
     * 
     * @parameter expression="${basedir}/src/main/xsd"
     */
    private String schemaDir;

    /**
     * Name of the schema file; if omitted all files in the directory are
     * processed
     * 
     * @parameter
     */
    private File schemaFile;

    /**
     * The Java package to generate into. By default the value is derived from
     * the schema URI.
     * 
     * @parameter
     */
    private String javaPackage;

    /**
     * The directory to generate into; defaults to
     * ${project.build.directory}/sdo-source
     * 
     * @parameter expression="${project.build.directory}/sdo-source"
     */
    private String targetDirectory;

    /**
     * Specifies the prefix string to use for naming the generated factory.
     * 
     * @parameter
     */
    private String prefix;

    /**
     * This option can be used to eliminate the generated interface and to
     * generate only an implementation class.
     * 
     * @parameter
     */
    private Boolean noInterfaces;

    /**
     * Turns off container management for containment properties.
     * 
     * @parameter
     */
    private Boolean noContainment;

    /**
     * This option eliminates all change notification overhead in the generated
     * classes.
     * 
     * @parameter
     */
    private Boolean noNotification;

    /**
     * With this option, all generated properties will not record their unset
     * state.
     * 
     * @parameter
     */
    private Boolean noUnsettable;

    /**
     * Generate a fast XML parser/loader for instances of the model.
     * 
     * @parameter
     */
    private Boolean generateLoader;

    /**
     * Generate a Switch class for the model.
     * 
     * @parameter
     */
    private Boolean generateSwitch;

    /**
     * @parameter expression="${project}"
     * @required
     */
    private MavenProject project;

    /**
     * @parameter expression="${plugin.mojos}"
     */
    private List mojos;

    /**
     * With this option, generated interfaces will extend
     * commonj.sdo.DataObject.
     * 
     * @parameter
     */
    private Boolean interfaceDataObject;

    /**
     * Support for generating multiple schema files.
     * 
     * @parameter
     */
    private SchemaFileOption[] schemaFiles;
    
    /**
     * The namespace to generate Java codes from.
     * Setting to "all" will generate all namespaces.
     * 
     * @parameter
     */
    private String schemaNamespace;

    public void execute() throws MojoExecutionException {

        // check for schemaFiles parameter first, if properties are not set, use
        // global property
        if (null != schemaFiles) {
            for (int i = 0; i < schemaFiles.length; ++i) {
                SchemaFileOption sf = schemaFiles[i];

                if (null == sf.getTargetDirectory()) {
                    sf.setTargetDirectory(targetDirectory);
                }
                if (null == sf.getJavaPackage()) {
                    sf.setJavaPackage(javaPackage);
                }
                if (null == sf.getSchemaNamespace()) {
                	sf.setSchemaNamespace(schemaNamespace);
                }
                if (null == sf.isNoInterfaces()) {
                    sf.setNoInterfaces(noInterfaces);
                }
                if (null == sf.isNoContainment()) {
                    sf.setNoContainment(noContainment);
                }
                if (null == sf.isNoNotification()) {
                    sf.setNoNotification(noNotification);
                }
                if (null == sf.isNoUnsettable()) {
                    sf.setNoUnsettable(noUnsettable);
                }
                if (null == sf.isGenerateLoader()) {
                    sf.setGenerateLoader(generateLoader);
                }
                if (null == sf.isGenerateSwitch()) {
                    sf.setGenerateSwitch(generateSwitch);
                }
                // if (null == sf.getCompilerSourceRoots()) {
                // sf.setCompilerSourceRoots(compileSourceRoots);
                // }
                if (null == sf.isInterfaceDataObject()) {
                    sf.setInterfaceDataObject(interfaceDataObject);
                }
                if (sf.getFileName() == null || sf.getFileName().length() == 0) {
                    throw new MojoExecutionException("no fileName specfied for schema.");
                }
                if (!sf.getFileName().canRead() || !sf.getFileName().isFile()) {

                    throw new MojoExecutionException("file can not be read:" + sf.getFileName());
                }
            }
        } else {

            if (schemaFile == null) {
                File[] files = new File(schemaDir).listFiles(FILTER);
                schemaFiles = new SchemaFileOption[files.length];
                for (int i = files.length - 1; i > -1; --i) {
                    schemaFiles[i] = new SchemaFileOption();
                    schemaFiles[i].setFileName(files[i]);
                    schemaFiles[i].setJavaPackage(javaPackage);
                    // schemaFiles[i].setCompilerSourceRoots(compileSourceRoots);
                    schemaFiles[i].setGenerateLoader(generateLoader);
                    schemaFiles[i].setGenerateSwitch(generateSwitch);
                    schemaFiles[i].setNoContainment(noContainment);
                    schemaFiles[i].setInterfaceDataObject(interfaceDataObject);
                    schemaFiles[i].setNoInterfaces(noInterfaces);
                    schemaFiles[i].setNoNotification(noNotification);
                    schemaFiles[i].setNoUnsettable(noUnsettable);
                    schemaFiles[i].setPrefix(prefix);
                    schemaFiles[i].setTargetDirectory(targetDirectory);
                    schemaFiles[i].setSchemaNamespace(schemaNamespace);
                }
            } else {
                schemaFiles = new SchemaFileOption[] {new SchemaFileOption()};
                schemaFiles[0].setFileName(schemaFile);
                schemaFiles[0].setJavaPackage(javaPackage);
                // schemaFiles[0].setCompilerSourceRoots(compileSourceRoots);
                schemaFiles[0].setGenerateLoader(generateLoader);
                schemaFiles[0].setGenerateSwitch(generateSwitch);
                schemaFiles[0].setNoContainment(noContainment);
                schemaFiles[0].setInterfaceDataObject(interfaceDataObject);
                schemaFiles[0].setNoInterfaces(noInterfaces);
                schemaFiles[0].setNoNotification(noNotification);
                schemaFiles[0].setNoUnsettable(noUnsettable);
                schemaFiles[0].setPrefix(prefix);
                schemaFiles[0].setTargetDirectory(targetDirectory);
                schemaFiles[0].setSchemaNamespace(schemaNamespace);
            }
        }

        for (int i = 0; i < schemaFiles.length; i++) {
            File file = schemaFiles[i].getFileName();
            File marker = new File(schemaFiles[i].getTargetDirectory(), ".gen#" + file.getName());
            if (file.lastModified() > marker.lastModified()) {
                getLog().info("Generating SDO interfaces from " + file);

                int genOptions = 0;

                if (schemaFiles[i].isNoInterfaces() != null && schemaFiles[i].isNoInterfaces().booleanValue()) {
                    genOptions |= JavaGenerator.OPTION_NO_INTERFACES;
                }
                if (schemaFiles[i].isNoContainment() != null && schemaFiles[i].isNoContainment().booleanValue()) {
                    genOptions |= JavaGenerator.OPTION_NO_CONTAINMENT;
                }
                if (schemaFiles[i].isNoNotification() != null && schemaFiles[i].isNoNotification().booleanValue()) {
                    genOptions |= JavaGenerator.OPTION_NO_NOTIFICATION;
                }
                if (schemaFiles[i].isGenerateLoader() != null && schemaFiles[i].isGenerateLoader().booleanValue()) {
                    genOptions |= JavaGenerator.OPTION_GENERATE_LOADER;
                }
                if (schemaFiles[i].isNoUnsettable() != null && schemaFiles[i].isNoUnsettable().booleanValue()) {
                    genOptions |= JavaGenerator.OPTION_NO_UNSETTABLE;
                }
                if (schemaFiles[i].isGenerateSwitch() != null && schemaFiles[i].isGenerateSwitch().booleanValue()) {
                    genOptions |= JavaGenerator.OPTION_GENERATE_SWITCH;
                }
                if (schemaFiles[i].isInterfaceDataObject() != null && schemaFiles[i].isInterfaceDataObject()
                    .booleanValue()) {
                    genOptions |= JavaGenerator.OPTION_INTERFACE_DO;
                }

                XSD2JavaGenerator.generateFromXMLSchema(file.toString(),
                                                        schemaFiles[i].getSchemaNamespace(),
                                                        schemaFiles[i].getTargetDirectory(),
                                                        schemaFiles[i].getJavaPackage(),
                                                        schemaFiles[i].getPrefix(),
                                                        genOptions);
            }
            try {
                marker.createNewFile();
            } catch (IOException e) {
                throw new MojoExecutionException(e.getMessage() + "'" + marker.getAbsolutePath() + "'", e);
            }
            marker.setLastModified(System.currentTimeMillis());
        }

        targetDirectory = targetDirectory.replace('/', File.separatorChar);

        // FIXME: [rfeng] Workaround to figure out the current execution phase
        MojoDescriptor descriptor = (MojoDescriptor)mojos.get(0);
        PluginDescriptor pluginDescriptor = descriptor.getPluginDescriptor();
        Map pluginMap = project.getBuild().getPluginsAsMap();
        Plugin plugin = (Plugin)pluginMap.get(pluginDescriptor.getGroupId() + ":" + pluginDescriptor.getArtifactId());
        // How to get the current execution id?
        for (Iterator i = plugin.getExecutions().iterator(); i.hasNext();) {
            PluginExecution execution = (PluginExecution)i.next();
            String phase = execution.getPhase();
            if (phase != null && phase.indexOf("-test-") != -1) {
                project.addTestCompileSourceRoot(targetDirectory);
            } else {
                project.addCompileSourceRoot(targetDirectory);
            }
        }
    }

    private static final FileFilter FILTER = new FileFilter() {
        public boolean accept(File pathname) {
            return (pathname.isFile() || !pathname.isHidden());
        }
    };
}
