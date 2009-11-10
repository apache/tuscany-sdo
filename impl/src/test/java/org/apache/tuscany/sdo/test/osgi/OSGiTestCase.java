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
package org.apache.tuscany.sdo.test.osgi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;

import org.apache.felix.framework.Felix;
import org.apache.felix.main.Main;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import junit.framework.TestCase;

/*
 * This test runs the SDO implementation test suite under a Felix OSGi runtime
 */
public class OSGiTestCase extends TestCase {

  private Felix felix;
  private BundleContext bundleContext;
  private ClassLoader contextClassLoader;

  protected void setUp() throws Exception {

    contextClassLoader = Thread.currentThread().getContextClassLoader();

    super.setUp();

    // Start a Felix OSGi runtime
    File profileDir = new File(".felix");
    if (profileDir.isDirectory())
      deleteDirectory(profileDir);
    else
      profileDir.delete();
    profileDir.mkdir();

    Properties props = Main.loadConfigProperties();
    props.put("felix.cache.profiledir", profileDir.getAbsolutePath());
    props.put("felix.embedded.execution", "true");
    props.put("org.osgi.framework.system.packages",
        "org.osgi.framework; version=1.3.0,"
            + "org.osgi.service.packageadmin; version=1.2.0, "
            + "org.osgi.service.startlevel; version=1.0.0, "
            + "org.osgi.service.url; version=1.0.0, " + "javax.xml, "
            + "javax.xml.parsers, " + "javax.xml.namespace, "
            + "org.xml.sax, "  + "org.xml.sax.helpers, " + "org.xml.sax.ext, "
            + "org.w3c.dom, " + "org.w3c.dom.events, " + "javax.xml.stream, "
            + "javax.xml.transform, " + "javax.xml.transform.dom, "
            + "javax.xml.transform.stream, " + "org.objectweb.asm, "
            + "junit.framework");

    List activators = new ArrayList();
    Felix felix = new Felix(props, activators);
    felix.start();
    bundleContext = felix.getBundleContext();
  }

  protected void tearDown() throws Exception {

    super.tearDown();
    Thread.currentThread().setContextClassLoader(contextClassLoader);

    if (felix != null) {
      felix.stop();
      felix = null;
    }
  }

  // Install SDO spec, SDO lib, SDO impl, and its EMF dependencies
  // Create a test bundle containing all the SDO tests, and run the entire
  // test suite inside an OSGi container
  public void test() throws Exception {

    ArrayList bundles = new ArrayList();
    FilenameFilter jarFileFilter = new JarFileFilter();

    File apiDir = new File("../sdo-api/target");
    File[] apiJars = apiDir.listFiles(jarFileFilter);
    for (int i = 0; i < apiJars.length; i++) {
      Bundle bundle = bundleContext
          .installBundle(apiJars[i].toURL().toString());
      bundles.add(bundle);
    }

    File libDir = new File("../lib/target");
    File[] libJars = libDir.listFiles(jarFileFilter);
    for (int i = 0; i < libJars.length; i++) {
      Bundle bundle = bundleContext
          .installBundle(libJars[i].toURL().toString());
      bundles.add(bundle);
    }

    if (!(contextClassLoader instanceof URLClassLoader))
      return;

    URL[] classPathURLs = ((URLClassLoader) contextClassLoader).getURLs();
    for (int i = 0; i < classPathURLs.length; i++) {
      String url = classPathURLs[i].toString();
      if (url.indexOf("eclipse") > 0 && url.endsWith(".jar")) {
        Bundle bundle = installEclipseBundle(classPathURLs[i]);
        if (bundle != null)
          bundles.add(bundle);
      }
    }

    // When this test is run during the build, sdo.impl.jar would not yet have
    // been created
    // Create this bundle - use the manifest file provided in the test
    // directory, which works
    // with Felix.
    Bundle implBundle = installBundle("file:sdo.impl",
        "../impl/target/test-classes/osgi/sdo.impl.mf",
        new String[] { "../impl/target/classes" });
    bundles.add(implBundle);

    // Start all the installed bundles
    for (int i = 0; i < bundles.size(); i++) {
      Bundle bundle = (Bundle) bundles.get(i);
      try {
        bundle.start();
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Could not start bundle " + bundle);
        // don't stop on first failure, so we document all failures
        // any failure will be re-triggered by the testBundle.start() call below
      }
    }

    // Install the test bundle - it contains all the test classes. The bundle
    // activator for
    // this class runs the entire test suite
    Bundle testBundle = installBundle("file:sdo.osgi.test",
        "../impl/target/test-classes/osgi/sdo.osgi.test.mf",
        new String[] { "../impl/target/test-classes" });

    TestClassLoader testClassLoader = new TestClassLoader(testBundle,
        contextClassLoader);
    Thread.currentThread().setContextClassLoader(testClassLoader);

    // The test suite is run inside an OSGi container by this call.
    testBundle.start();
  }

  // Delete any old Felix configuration files left over from previous runs
  private static void deleteDirectory(File dir) {

    File[] files = dir.listFiles();
    for (int i = 0; i < files.length; i++) {
      if (files[i].isDirectory())
        deleteDirectory(files[i]);
      else
        files[i].delete();
    }
    dir.delete();

  }

  // Create and install a bundle with the specified manifest file
  // The bundle contains all files from the list of directories specified
  public Bundle installBundle(String bundleLocation, String manifestFileName,
      String[] dirNames) throws Exception {

    ByteArrayOutputStream out = new ByteArrayOutputStream();

    File manifestFile = new File(manifestFileName);
    Manifest manifest = new Manifest();
    manifest.read(new FileInputStream(manifestFile));

    JarOutputStream jarOut = new JarOutputStream(out, manifest);

    for (int i = 0; i < dirNames.length; i++) {
      File dir = new File(dirNames[i]);
      addFilesToJar(dir, dirNames[i], jarOut);
    }

    jarOut.close();
    out.close();

    ByteArrayInputStream inStream = new ByteArrayInputStream(out.toByteArray());
    return bundleContext.installBundle(bundleLocation, inStream);

  }

  // Add all the files from a build directory into a jar file
  // This method is used to create bundles on the fly
  private void addFilesToJar(File dir, String rootDirName,
      JarOutputStream jarOut) throws Exception {

    if (dir.getName().equals(".svn"))
      return;

    File[] files = dir.listFiles();

    for (int i = 0; i < files.length; i++) {

      if (files[i].isDirectory()) {
        addFilesToJar(files[i], rootDirName, jarOut);
        continue;
      }
      if (files[i].getName().endsWith("MANIFEST.MF"))
        continue;

      String entryName = files[i].getPath().substring(rootDirName.length() + 1);
      entryName = entryName.replaceAll("\\\\", "/");
      ZipEntry ze = new ZipEntry(entryName);

      jarOut.putNextEntry(ze);
      FileInputStream file = new FileInputStream(files[i]);
      byte[] fileContents = new byte[file.available()];
      file.read(fileContents);
      jarOut.write(fileContents);
    }
  }

  // Install a bundle corresponding to an jar file from Eclipse (eg. EMF jars)
  // These bundle manifest entries use Require-Bundle of
  // eclipse core runtime. The Plugin class from the Eclipse runtime
  // is loaded by the bundle activator of some of these bundles.
  // Since this test is run under Felix, remove the dependency on
  // Eclipse runtime by removing the Require-Bundle and
  // Bundle-Activator entries from the manifest
  private Bundle installEclipseBundle(URL jarURL) throws Exception {

    JarInputStream jarInput = new JarInputStream(jarURL.openStream());

    Manifest manifest = jarInput.getManifest();
    if (manifest == null) {
      manifest = new Manifest();
      ZipEntry entry;
      while ((entry = jarInput.getNextEntry()) != null) {
        if (entry.getName().equals("META-INF/MANIFEST.MF")) {
          byte bytes[] = new byte[(int) entry.getSize()];
          jarInput.read(bytes);
          manifest.read(new ByteArrayInputStream(bytes));
        }
      }
      jarInput.close();
      jarInput = new JarInputStream(jarURL.openStream());
    }
    if (manifest == null
        || manifest.getMainAttributes() == null
        || !manifest.getMainAttributes().containsKey(
            new Attributes.Name("Bundle-SymbolicName"))) {

      return null;
    }
    manifest.getMainAttributes().remove(new Attributes.Name("Require-Bundle"));
    manifest.getMainAttributes()
        .remove(new Attributes.Name("Bundle-Activator"));
    manifest.getMainAttributes().put(
        new Attributes.Name("DynamicImport-Package"), "*");

    ByteArrayOutputStream out = new ByteArrayOutputStream();

    JarOutputStream jarOut = new JarOutputStream(out, manifest);
    ZipEntry entry;
    byte bytes[] = new byte[1024];
    while ((entry = jarInput.getNextEntry()) != null) {
      if (!entry.getName().equals("META-INF/MANIFEST.MF")) {
        jarOut.putNextEntry((JarEntry) entry);
        int len;
        while ((len = jarInput.read(bytes)) != -1) {
          jarOut.write(bytes, 0, len);
        }
        jarOut.closeEntry();
      }
      jarInput.closeEntry();
    }
    jarOut.close();
    out.close();
    jarInput.close();

    ByteArrayInputStream byteStream = new ByteArrayInputStream(out
        .toByteArray());

    return bundleContext.installBundle(jarURL.toString(), byteStream);

  }

  // Filter used to list jar files from a directory
  private class JarFileFilter implements FilenameFilter {

    public boolean accept(File dir, String name) {
      if (name.endsWith(".jar") && !name.endsWith("javadoc.jar"))
        return true;
      else
        return false;
    }

  }

  // Test classloader - used as context classloader
  private static class TestClassLoader extends ClassLoader {

    Bundle testBundle;

    private TestClassLoader(Bundle testBundle, ClassLoader parentClassLoader) {
      super(parentClassLoader);
      this.testBundle = testBundle;
    }

    public Class loadClass(String className) throws ClassNotFoundException {
      Class clazz = findLoadedClass(className);
      if (clazz != null)
        return clazz;

      try {
        return testBundle.loadClass(className);
      } catch (Exception e) {
      }
      return super.loadClass(className);
    }

    public URL getResource(String resName) {
      URL resource = testBundle.getResource(resName);
      if (resource == null)
        resource = super.getResource(resName);
      return resource;
    }

  }
}
