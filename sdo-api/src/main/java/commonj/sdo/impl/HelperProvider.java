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

package commonj.sdo.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.AccessController;
import java.security.PrivilegedAction;

import commonj.sdo.helper.CopyHelper;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.DataHelper;
import commonj.sdo.helper.EqualityHelper;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;

/**
 * A HelperProvider obtains specific default helpers and other
 * implementation-specific objects used by a Java implementation of SDO.
 *
 * @version $Rev$ $Date$
 */
public abstract class HelperProvider {
    /**
     * The default HelperProvider INSTANCE. This is located using the ClassLoader used
     * to load the HelperProvider class itself and if no default implementation is available
     * this field will be set to null.
     */
    public static HelperProvider INSTANCE;

    /**
     * The name of the resource that is used for service location.
     */
    public static final String SERVICE_RESOURCE_NAME = "META-INF/services/commonj.sdo.impl.HelperProvider";

    /**
     * The name of the system property that will be checked for an implementation name.
     */
    public static final String PROPERTY_NAME = "commonj.sdo.impl.HelperProvider";

    static {
        // initialize the default instance using this class's classloader
        // set to null if none could be located (implies no default implementation)
        HelperProvider provider;
        try {
            provider = getInstance(HelperProvider.class.getClassLoader());
        } catch (NoHelperProviderException e) {
            provider = null;
        }
        INSTANCE = provider;
    }
    
    public static synchronized void setDefaultInstance(ClassLoader cl) {
    	if (INSTANCE == null) {
            try {
                INSTANCE = getInstance(cl);
            } catch (NoHelperProviderException e) {
            }
    	}
    }

    /**
     * Locate and instantiate a HelperProvider.
     * <p/>
     * Attempt to locate a HelperProvider using first the Thread's current context classloader and then,
     * if that is not set, not readable, or does not provide an implementation, using the classloader
     * used to load the HelperProvider class itself.
     * <p/>
     * A new instance is returned for each sucessful invocation.
     *
     * @return an implementation of HelperProvider
     * @throws NoHelperProviderException if no provider implementation was defined or it could not be instantiated
     */
    public static HelperProvider getInstance() throws NoHelperProviderException {
        String implName = getImplementationName();

        ClassLoader cl = getContextClassLoader();
        if (cl != null) {
            HelperProvider provider = loadImplementation(cl, implName);
            if (provider != null) {
                return provider;
            }
        }

        cl = HelperProvider.class.getClassLoader();
        HelperProvider provider = loadImplementation(cl, implName);
        if (provider != null) {
            return provider;
        }

        throw new NoHelperProviderException(implName);
    }


    /**
     * Locate and instantiate a HelperProvider using the supplied ClassLoader.
     * <p/>
     * The name of the implementation to use is determined by the value of the "commonj.sdo.impl.HelperProvider"
     * system property. If this is not set or this code does not have permission to read it then the name
     * will be retrieved from the META-INF/services/commonj.sdo.impl.HelperProvider resource as returned
     * by the supplied classloader as described in the
     * <a href="http://java.sun.com/j2se/1.5.0/docs/guide/jar/jar.html#Service%20Provider">JAR file specification</a>.
     * <p/>
     * A new instance is returned for each sucessful invocation.
     *
     * @param cl the classloader to use to locate and instantiate the implementation
     * @return the specified implementation of HelperProvider
     * @throws NoHelperProviderException if no provider implementation was defined or it could not be instantiated
     */
    public static HelperProvider getInstance(ClassLoader cl) throws NoHelperProviderException {
        String implName = getImplementationName();
        HelperProvider provider = loadImplementation(cl, implName);
        if (provider == null) {
            throw new NoHelperProviderException(implName);
        }
        return provider;
    }

    private static ClassLoader getContextClassLoader() {
        try {
            return (ClassLoader)AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    return Thread.currentThread().getContextClassLoader();
                }
            });
        } catch (SecurityException e) {
            return null;
        }
    }

    private static HelperProvider loadImplementation(ClassLoader cl, String implName) throws NoHelperProviderException {
        // if no name is requested, locate using the supplied classloader
        if (implName == null) {
            implName = getImplementationName(cl);
        }
        // no implementation to try, return null
        if (implName == null) {
            return null;
        }

        // try an instantiate the implementation
        try {
            return (HelperProvider) cl.loadClass(implName).newInstance();
        } catch (InstantiationException e) {
            throw new NoHelperProviderException(implName, e);
        } catch (IllegalAccessException e) {
            throw new NoHelperProviderException(implName, e);
        } catch (ClassNotFoundException e) {
            throw new NoHelperProviderException(implName, e);
        }
    }

    private static String getImplementationName() {
        try {
            return (String)AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    return System.getProperty(PROPERTY_NAME);
                }
            });
        } catch (SecurityException e) {
            return null;
        }
    }

    private static String getImplementationName(ClassLoader cl) {
        InputStream is = cl.getResourceAsStream(SERVICE_RESOURCE_NAME);
        if (is == null) {
            return null;
        }

        InputStreamReader in;
        try {
            in = new InputStreamReader(is, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("UTF-8 encoding not available");
        }

        try {
            BufferedReader reader = new BufferedReader(in, 128);
            try {
                String line;
                while ((line = reader.readLine()) != null) {
                    int i = line.indexOf('#');
                    if (i != -1) {
                        line = line.substring(0, i);
                    }
                    line = line.trim();
                    if (line.length() > 0) {
                        return line;
                    }
                }
                return null;
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            throw new NoHelperProviderException(e);
        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // implementation specific methods for users that don't want to use the default implementation

    /**
     * Returns a CopyHelper obtained from this implementation.
     *
     * @return a CopyHelper obtained from this implementation
     */
    public abstract CopyHelper copyHelper();

    /**
     * Returns a DataFactory obtained from this implementation.
     *
     * @return a DataFactory obtained from this implementation
     */
    public abstract DataFactory dataFactory();

    /**
     * Returns a DataHelper obtained from this implementation.
     *
     * @return a DataHelper obtained from this implementation
     */
    public abstract DataHelper dataHelper();

    /**
     * Returns a EqualityHelper obtained from this implementation.
     *
     * @return a EqualityHelper obtained from this implementation
     */
    public abstract EqualityHelper equalityHelper();

    /**
     * Returns a TypeHelper obtained from this implementation.
     *
     * @return a TypeHelper obtained from this implementation
     */
    public abstract TypeHelper typeHelper();

    /**
     * Returns a XMLHelper obtained from this implementation.
     *
     * @return a XMLHelper obtained from this implementation
     */
    public abstract XMLHelper xmlHelper();

    /**
     * Returns a XSDHelper obtained from this implementation.
     *
     * @return a XSDHelper obtained from this implementation
     */
    public abstract XSDHelper xsdHelper();

    /**
     * Create a Resolvable using this implementation
     *
     * @return a Resolvable created using this implementation
     */
    public abstract ExternalizableDelegator.Resolvable resolvable();

    /**
     * Create a Resolvable using this implementation
     *
     * @param target the object to be resolved
     * @return a Resolvable created using this implementation
     */
    public abstract ExternalizableDelegator.Resolvable resolvable(Object target);


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // static helper methods required by the specification

    /**
     * Returns a CopyHelper obtained from the default HelperProvider.
     *
     * @return a CopyHelper obtained from the default HelperProvider
     */
    public static CopyHelper getCopyHelper() {
        return INSTANCE.copyHelper();
    }

    /**
     * Returns a DataFactory obtained from the default HelperProvider.
     *
     * @return a DataFactory obtained from the default HelperProvider
     */
    public static DataFactory getDataFactory() {
        return INSTANCE.dataFactory();
    }

    /**
     * Returns a DataHelper obtained from the default HelperProvider.
     *
     * @return a DataHelper obtained from the default HelperProvider
     */
    public static DataHelper getDataHelper() {
        return INSTANCE.dataHelper();
    }

    /**
     * Returns a EqualityHelper obtained from the default HelperProvider.
     *
     * @return a EqualityHelper obtained from the default HelperProvider
     */
    public static EqualityHelper getEqualityHelper() {
        return INSTANCE.equalityHelper();
    }

    /**
     * Returns a TypeHelper obtained from the default HelperProvider.
     *
     * @return a TypeHelper obtained from the default HelperProvider
     */
    public static TypeHelper getTypeHelper() {
        return INSTANCE.typeHelper();
    }

    /**
     * Returns a XMLHelper obtained from the default HelperProvider.
     *
     * @return a XMLHelper obtained from the default HelperProvider
     */
    public static XMLHelper getXMLHelper() {
        return INSTANCE.xmlHelper();
    }

    /**
     * Returns a XSDHelper obtained from the default HelperProvider.
     *
     * @return a XSDHelper obtained from the default HelperProvider
     */
    public static XSDHelper getXSDHelper() {
        return INSTANCE.xsdHelper();
    }

    /**
     * Create a Resolvable using the default HelperProvider
     *
     * @return a Resolvable created using the default HelperProvider
     */
    public static ExternalizableDelegator.Resolvable createResolvable() {
        return INSTANCE.resolvable();
    }

    /**
     * Create a Resolvable using the default HelperProvider
     *
     * @param target the object to be resolved
     * @return a Resolvable created using the default HelperProvider
     */
    public static ExternalizableDelegator.Resolvable createResolvable(Object target) {
        return INSTANCE.resolvable(target);
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // New in SDO 2.1
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Gets the default HelperContext
     * @return a HelperContext object
     */
    public static HelperContext getDefaultContext()
    {
      return INSTANCE.helperContext();
    }
      
    HelperContext helperContext()
    {
      return defaultContext;
    }
      
//    static HelperContext defaultContext = new DefaultHelperContext();
//  TODO: Tuscany SDO implementation specific to create a special implementation of HelperContext
    protected static HelperContext defaultContext;

    static class DefaultHelperContext implements HelperContext
    {
      public CopyHelper getCopyHelper() { return INSTANCE.copyHelper(); }
      public DataFactory getDataFactory() { return INSTANCE.dataFactory(); }
      public DataHelper getDataHelper() { return INSTANCE.dataHelper(); }
      public EqualityHelper getEqualityHelper() { return INSTANCE.equalityHelper(); }
      public TypeHelper getTypeHelper() { return INSTANCE.typeHelper(); }
      public XMLHelper getXMLHelper() { return INSTANCE.xmlHelper(); }
      public XSDHelper getXSDHelper() { return INSTANCE.xsdHelper(); }
    }

}
