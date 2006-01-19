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
     * @parameter expression="${project.compileSourceRoots}"
     * @readonly
     */
    private List compilerSourceRoots;

    public void execute() throws MojoExecutionException {
        getLog().info("schemaDir = " + schemaDir);
        getLog().info("targetDirectory = " + targetDirectory);
        getLog().info("javaPackage = " + javaPackage);
        getLog().info("Generating SDO interfaces");

        File[] files = new File(schemaDir).listFiles(FILTER);
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            getLog().info("Generating from " + file);
            JavaGenerator.generateFromXMLSchema(file.toString(), targetDirectory, javaPackage, null, 0);
        }

        compilerSourceRoots.add(targetDirectory);
    }

    private static final FileFilter FILTER = new FileFilter() {
        public boolean accept(File pathname) {
            return (pathname.isFile() || !pathname.isHidden());
        }
    };
}