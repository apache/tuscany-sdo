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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.change.ChangePackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xml.namespace.XMLNamespacePackage;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import commonj.sdo.helper.CopyHelper;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.DataHelper;
import commonj.sdo.helper.EqualityHelper;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;

import org.apache.tuscany.sdo.SDOPackage;
import org.apache.tuscany.sdo.api.XMLStreamHelper;

public class HelperContextImpl implements HelperContext {
    /*
     * Relationship: HelperContext*Impl* ---1:1---> ExtendedMetaData ---1:1--->
     * Map (:defaultOption) <---1:1---> TypeHelper <---1:1---> XMLHelper
     * <---1:1---> XMLStreamHelper <---1:1---> XSDHelper <---1:1---> DataFactory
     */

    protected ExtendedMetaData extendedMetaData;
    protected DataFactory dataFactory;
    protected TypeHelper typeHelper;
    protected XMLHelper xmlHelper;
    protected XSDHelper xsdHelper;
    protected XMLStreamHelper xmlStreamHelper;
    protected Map defaultOptions = null;
    
    public HelperContextImpl(ExtendedMetaData extendedMetaData, boolean extensibleNamespaces) {
        this.defaultOptions = null;
        this.extendedMetaData = extendedMetaData;
        typeHelper = new TypeHelperImpl(this);
        dataFactory = new DataFactoryImpl(this);
        xmlHelper = new XMLHelperImpl(this);
        xsdHelper = new XSDHelperImpl(this, null, extensibleNamespaces);
        xmlStreamHelper = new XMLStreamHelperImpl(this);
    }
    

    public HelperContextImpl(ExtendedMetaData extendedMetaData, boolean extensibleNamespaces, Map options) {
        this.defaultOptions = options;
        this.extendedMetaData = extendedMetaData;
        typeHelper = new TypeHelperImpl(this);
        dataFactory = new DataFactoryImpl(this);
        xmlHelper = new XMLHelperImpl(this);
        xsdHelper = new XSDHelperImpl(this, null, extensibleNamespaces);
        xmlStreamHelper = new XMLStreamHelperImpl(this);
    }

    // many places this is called in existing code
    // This is used for supporting the deprecated util -
    // org.apache.tuscany.sdo.util.SDOUtil
    // Once we conpletely remove this deprecated util, we can remove the below
    // constructor
    public HelperContextImpl(TypeHelper scope) {
        this(scope, null);
    }


    public HelperContextImpl(TypeHelper scope, Map options) {
        this.defaultOptions = options;
        typeHelper = scope;
        this.extendedMetaData = ((TypeHelperImpl)scope).getExtendedMetaData();
        dataFactory = new DataFactoryImpl(this);
        xmlHelper = new XMLHelperImpl(this);
        xsdHelper = new XSDHelperImpl(this);
        xmlStreamHelper = new XMLStreamHelperImpl(this);
    }

    public HelperContextImpl(boolean extensibleNamespaces) {
        this(new SDOExtendedMetaDataImpl(new EPackageRegistryImpl(getBuiltInModelRegistry())), extensibleNamespaces);
    }


    public HelperContextImpl(boolean extensibleNamespaces, Map options) {
        this(new SDOExtendedMetaDataImpl(new EPackageRegistryImpl(getBuiltInModelRegistry())), extensibleNamespaces,
             options);
    }

    static protected EPackage.Registry builtInModelRegistry = null;

    static public EPackage.Registry getBuiltInModelRegistry() {
        if (builtInModelRegistry == null) {
            EPackageRegistryImpl registry = new EPackageRegistryImpl();
            for (Iterator iter = TypeHelperImpl.getBuiltInModels().iterator(); iter.hasNext();) {
                EPackage ePackage = (EPackage)iter.next();
                registry.put(ePackage.getNsURI(), ePackage);
            }
            
            registry.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
            registry.put(XMLTypePackage.eNS_URI, XMLTypePackage.eINSTANCE);
            registry.put(ChangePackage.eNS_URI, ChangePackage.eINSTANCE);
            registry.put(XMLNamespacePackage.eNS_URI, XMLNamespacePackage.eINSTANCE);
            registry.put(SDOPackage.eNS_URI, SDOPackage.eINSTANCE);
            
            builtInModelRegistry = registry;
        }
        return builtInModelRegistry;
    }

    public CopyHelper getCopyHelper() {
        return CopyHelper.INSTANCE;
    }

    public DataFactory getDataFactory() {
        return dataFactory;
    }

    public DataHelper getDataHelper() {
        return DataHelper.INSTANCE;
    }

    public EqualityHelper getEqualityHelper() {
        return EqualityHelper.INSTANCE;
    }

    public TypeHelper getTypeHelper() {
        return typeHelper;
    }

    public XMLHelper getXMLHelper() {
        return xmlHelper;
    }

    public XMLStreamHelper getXMLStreamHelper() {
        return xmlStreamHelper;
    }

    public XSDHelper getXSDHelper() {
        return xsdHelper;
    }

    public void setOptions(Map options) {
        this.defaultOptions = options;
    }

    public Map getOptions() {
        return this.defaultOptions;
    }

    public Map getMergedOption(Map options) {
        Map mergedOptions = null;// copy to be used for merge

        if (defaultOptions == null) {
            return options;
        }
        
        mergedOptions = new HashMap(defaultOptions);
        if (options == null) {
            return mergedOptions;
        }
        mergedOptions.putAll(options);
        
        return mergedOptions;
    }

    public ExtendedMetaData getExtendedMetaData() {
        return extendedMetaData;
    }
}
