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

package org.apache.tuscany.sdo.helper;

import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;

public class DefaultHelperContextImpl extends HelperContextImpl {
    public DefaultHelperContextImpl(final boolean extensibleNamespaces) {
        super(new SDOExtendedMetaDataImpl(new SDOPackageRegistryDelegator()), extensibleNamespaces);
    }

    public DefaultHelperContextImpl(final boolean extensibleNamespaces, final Map options) {
        super(new SDOExtendedMetaDataImpl(new SDOPackageRegistryDelegator()), extensibleNamespaces, options);
    }
    
    protected static class SDOPackageRegistryDelegator extends EPackageRegistryImpl.Delegator {
        /**
         * A map from class loader to its associated registry.
         */
        protected Map classLoaderToRegistryMap = new WeakHashMap();
        
        /**
         * Returns the package registry associated with the given class loader.
         * @param classLoader the class loader.
         * @return the package registry associated with the given class loader.
         */
        public synchronized EPackage.Registry getRegistry(final ClassLoader classLoader)
        {
          EPackage.Registry result = (EPackage.Registry)classLoaderToRegistryMap.get(classLoader);
          if (result == null)
          {
            if (classLoader == null)
            {
              result = HelperContextImpl.getBuiltInModelRegistry();  
            }
            else
            {
              result = new EPackageRegistryImpl(getRegistry(classLoader.getParent()));
              classLoaderToRegistryMap.put(classLoader, result);
            }
          }
          return result;
        }
        
        protected EPackage.Registry delegateRegistry(final ClassLoader classLoader)
        {
          return getRegistry(classLoader);
        }
    }
}
