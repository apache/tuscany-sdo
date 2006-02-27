/**
 *
 *  Copyright 2005 BEA Systems Inc.
 *  Copyright 2005 International Business Machines Corporation
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
package org.apache.tuscany.sdo.plugin;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.List;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import org.apache.tuscany.sdo.generate.JavaGenerator;

/**
 * @version $Rev$ $Date$
 * @goal generate
 * @phase generate-sources
 * @description Generate SDO interface classes from an XML Schema
 */
public class GeneratorMojo extends AbstractMojo {
    /**
     * The directory containing schema files; defaults to ${basedir}/src/main/xsd
     * @parameter expression="${basedir}/src/main/xsd"
     */
    private String schemaDir;

    /**
     * Name of the schema file; if omitted all files in the directory are processed
     * @parameter
     */
    private File schemaFile;

    /**
     * The Java package to generate into. By default the value is derived from the schema URI.
     *
     * @parameter
     */
    private String javaPackage;

    /**
     * The directory to generate into; defaults to ${project.build.directory}/sdo-source
     *
     * @parameter expression="${project.build.directory}/sdo-source"
     */
    private String targetDirectory;

    /**
     * Specifies the prefix string to use for naming the generated factory. 
     * @parameter
     */
    private String prefix;

    /**
     * This option can be used to eliminate the generated interface and to generate only an implementation class. 
     * @parameter
     */
    private boolean noInterfaces;

    /**
     * Turns off container management for containment properties.  
     * @parameter
     */
    private boolean noContainment;

    /**
     * This option eliminates all change notification overhead in the generated classes.   
     * @parameter
     */
    private boolean noNotification;

    /**
     * With this option, all generated properties will not record their unset state. 
     * @parameter
     */
    private boolean noUnsettable;

    /**
     * Generate a fast XML parser/loader for instances of the model.   
     * @parameter
     */
    private boolean generateLoader;

    /**
     * Generate a Switch class for the model.   
     * @parameter
     */
    private boolean generateSwitch;

    /**
     * @parameter expression="${project.compileSourceRoots}"
     * @readonly
     */
    private List compilerSourceRoots;

    public void execute() throws MojoExecutionException {
        File[] files;
        if (schemaFile == null) {
            files = new File(schemaDir).listFiles(FILTER);
        } else {
            files = new File[]{schemaFile};
        }
        
        int genOptions = 0;
        if (noInterfaces) {
          genOptions |= JavaGenerator.OPTION_NO_INTERFACES;
        }
        if (noContainment) {
          genOptions |= JavaGenerator.OPTION_NO_CONTAINMENT;
        }
        if (noNotification) {
          genOptions |= JavaGenerator.OPTION_NO_NOTIFICATION;
        }
        if (generateLoader) {
          genOptions |= JavaGenerator.OPTION_GENERATE_LOADER;
        }
        if (noUnsettable) {
          genOptions |= JavaGenerator.OPTION_NO_UNSETTABLE;
        }
        if (generateSwitch) {
            genOptions |= JavaGenerator.OPTION_GENERATE_SWITCH;
          }

        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            File marker = new File(targetDirectory, ".gen#" + file.getName());
            if (file.lastModified() > marker.lastModified()) {
                getLog().info("Generating SDO interfaces from " + file);
                JavaGenerator.generateFromXMLSchema(file.toString(), targetDirectory, javaPackage, prefix, genOptions);
            }
            try {
                marker.createNewFile();
            } catch (IOException e) {
                throw new MojoExecutionException(e.getMessage(), e);
            }
            marker.setLastModified(System.currentTimeMillis());
        }

        compilerSourceRoots.add(targetDirectory);
    }

    private static final FileFilter FILTER = new FileFilter() {
        public boolean accept(File pathname) {
            return (pathname.isFile() || !pathname.isHidden());
        }
    };
}