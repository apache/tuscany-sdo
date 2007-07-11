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

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.tuscany.sdo.impl.DynamicDataObjectImpl;
import org.apache.tuscany.sdo.util.DataObjectUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.ecore.XSDEcoreBuilder;
import org.eclipse.xsd.util.XSDResourceFactoryImpl;
import org.eclipse.xsd.util.XSDResourceImpl;
import org.xml.sax.InputSource;

import commonj.sdo.Property;
import commonj.sdo.Type;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XSDHelper;

/**
 * Provides access to additional information when the Type or Property is
 * defined by an XML Schema (XSD). Methods return null/false otherwise or if the
 * information is unavailable. Defines Types from an XSD.
 */
public class XSDHelperImpl implements XSDHelper {
    protected boolean extensibleNamespaces = false;
    protected HelperContext helperContext;
    protected SDOXSDEcoreBuilder nondelegatingEcoreBuilder = null;
    protected HashMap tcclToEcoreBuilderMap = null;
    private ExtendedMetaData extendedMetaData;

    public XSDHelperImpl(HelperContext hc, String redefineBuiltIn, boolean extensibleNamespaces) {
        this.helperContext = hc;
        this.extensibleNamespaces = extensibleNamespaces;
        extendedMetaData = ((HelperContextImpl)helperContext).extendedMetaData;

        SDOXSDEcoreBuilder ecoreBuilder = createEcoreBuilder();

        if (extendedMetaData instanceof SDOExtendedMetaDataImpl && ((SDOExtendedMetaDataImpl)extendedMetaData)
            .getRegistry() instanceof EPackageRegistryImpl.Delegator) {
            tcclToEcoreBuilderMap = new HashMap();
            putTCCLEcoreBuilder(ecoreBuilder);
        } else {
            nondelegatingEcoreBuilder = ecoreBuilder;
        }

        if (redefineBuiltIn != null) { // Redefining/regenerating this built-in
                                        // model
            ecoreBuilder.getTargetNamespaceToEPackageMap().remove(redefineBuiltIn);
        }
    }

    public XSDHelperImpl(HelperContext hc) {
        this(hc, null, false);
    }

    /**
     * Redefine/regenerating the built-in model
     * @param redefineBuiltIn
     */
    public void setRedefineBuiltIn(String redefineBuiltIn) {
        if (redefineBuiltIn != null) {
            getEcoreBuilder().getTargetNamespaceToEPackageMap().remove(redefineBuiltIn);
        }
    }
    
    public void setExtensibleNamespaces(boolean extensibleNamespaces) {
        this.extensibleNamespaces = extensibleNamespaces;
    }

    protected SDOXSDEcoreBuilder createEcoreBuilder() {
        SDOXSDEcoreBuilder ecoreBuilder = new SDOXSDEcoreBuilder(extendedMetaData, extensibleNamespaces);

        // Add the built-in models to the targetNamespaceToEPackageMap so they
        // can't be (re)defined/overridden
        for (Iterator iter = TypeHelperImpl.getBuiltInModels().iterator(); iter.hasNext();) {
            EPackage ePackage = (EPackage)iter.next();
            ecoreBuilder.getTargetNamespaceToEPackageMap().put(ePackage.getNsURI(), ePackage);
        }

        return ecoreBuilder;
    }

    protected void putTCCLEcoreBuilder(XSDEcoreBuilder ecoreBuilder) {
        ClassLoader tccl = Thread.currentThread().getContextClassLoader();
        if (tcclToEcoreBuilderMap.get(tccl) == null) {
            tcclToEcoreBuilderMap.put(tccl, ecoreBuilder);
        }
    }

    protected SDOXSDEcoreBuilder getEcoreBuilder() {
        if (nondelegatingEcoreBuilder != null)
            return nondelegatingEcoreBuilder;

        SDOXSDEcoreBuilder result = null;
        try {
            for (ClassLoader tccl = Thread.currentThread().getContextClassLoader(); tccl != null; tccl =
                tccl.getParent()) {
                result = (SDOXSDEcoreBuilder)tcclToEcoreBuilderMap.get(tccl);
                if (result != null)
                    return result;
            } // for
        } catch (SecurityException exception) {
            // exception.printStackTrace();
        }

        result = createEcoreBuilder();
        putTCCLEcoreBuilder(result);

        return result;
    }

    public String getLocalName(Type type) {
        return extendedMetaData.getName((EClassifier)type);
    }

    public String getLocalName(Property property) {
        return extendedMetaData.getName((EStructuralFeature)property);
    }

    public String getNamespaceURI(Property property) {
        return extendedMetaData.getNamespace((EStructuralFeature)property);
    }

    public boolean isAttribute(Property property) {
        return extendedMetaData.getFeatureKind((EStructuralFeature)property) == ExtendedMetaData.ATTRIBUTE_FEATURE;
    }

    public boolean isElement(Property property) {
        return extendedMetaData.getFeatureKind((EStructuralFeature)property) == ExtendedMetaData.ELEMENT_FEATURE;
    }

    public boolean isMixed(Type type) {
        if (type instanceof EClass) {
            return extendedMetaData.getContentKind((EClass)type) == ExtendedMetaData.MIXED_CONTENT;
        } else {
            return false;
        }
    }

    public boolean isXSD(Type type) {
        return ((EModelElement)type).getEAnnotation(ExtendedMetaData.ANNOTATION_URI) != null;
    }

    public Property getGlobalProperty(String uri, String propertyName, boolean isElement) {
        if (isElement) {
            return (Property)extendedMetaData.getElement(uri, propertyName);
        } else {
            return (Property)extendedMetaData.getAttribute(uri, propertyName);
        }
    }

    public String getAppinfo(Type type, String source) {
        return getAppinfo((EModelElement)type, source);
    }

    public String getAppinfo(Property property, String source) {
        return getAppinfo((EModelElement)property, source);
    }

    protected String getAppinfo(EModelElement eModelElement, String source) {
        return (String)eModelElement.getEAnnotation(source).getDetails().get("appinfo");
    }

    public List /* Type */define(String xsd) {
        InputStream inputStream = new ByteArrayInputStream(xsd.getBytes());
        return define(inputStream, "*.xsd");
    }

    public List /* Type */define(Reader xsdReader, String schemaLocation) {
        InputSource inputSource = new InputSource(xsdReader);
        return define(inputSource, schemaLocation);

    }

    public List /* Type */define(InputStream xsdInputStream, String schemaLocation) {
        InputSource inputSource = new InputSource(xsdInputStream);
        return define(inputSource, schemaLocation);
    }

    protected List /* Type */define(InputSource inputSource, String schemaLocation) {
        try {
            SDOXSDEcoreBuilder ecoreBuilder = getEcoreBuilder();
            ResourceSet resourceSet = ecoreBuilder.createResourceSet();
            Resource model =
                resourceSet.createResource(URI.createURI(schemaLocation != null ? schemaLocation : "null.xsd"));
            ((XSDResourceImpl)model).load(inputSource, null);

            List newTypes = new ArrayList();
            for (Iterator schemaIter = model.getContents().iterator(); schemaIter.hasNext();) {
                XSDSchema schema = (XSDSchema)schemaIter.next();

                String targetNamespace = schema.getTargetNamespace();
                EPackage ePackage = extendedMetaData.getPackage(targetNamespace);
                if (extensibleNamespaces || ePackage == null || TypeHelperImpl.getBuiltInModels().contains(ePackage)) {
                    Map targetNamespaceToEPackageMap = ecoreBuilder.getTargetNamespaceToEPackageMap();
                    targetNamespaceToEPackageMap.remove(targetNamespace);

                    Collection originalEPackages = new HashSet(targetNamespaceToEPackageMap.values());
                    ecoreBuilder.generate(schema);
                    Collection newEPackages = ecoreBuilder.getTargetNamespaceToEPackageMap().values();

                    for (Iterator iter = newEPackages.iterator(); iter.hasNext();) {
                        EPackage currentPackage = (EPackage)iter.next();
                        if (!originalEPackages.contains(currentPackage)) {
                            currentPackage.setEFactoryInstance(new DynamicDataObjectImpl.FactoryImpl());
                            EcoreUtil.freeze(currentPackage);
                            newTypes.addAll(currentPackage.getEClassifiers());
                        }
                    }
                }
            }

            return newTypes;
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public String generate(List /* Type */types) throws IllegalArgumentException {
        return generate(types, new Hashtable());
    }

    public String generate(List /* Type */types, Map /* String, String */namespaceToSchemaLocation)
        throws IllegalArgumentException {
        if (types != null && !types.isEmpty()) {
            Hashtable schemaMap = new Hashtable();
            Hashtable nsPrefixMap = new Hashtable();
            TypeTable typeTable = new TypeTable();

            SchemaBuilder schemaBuilder =
                new SchemaBuilder(schemaMap, nsPrefixMap, typeTable, namespaceToSchemaLocation);

            Iterator iterator = types.iterator();
            Type dataType = null;

            try {
                while (iterator.hasNext()) {
                    dataType = (Type)iterator.next();
                    schemaBuilder.buildSchema(dataType);
                }

                XSDSchema xmlSchema = null;
                iterator = schemaMap.values().iterator();
                StringWriter writer = new StringWriter();

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

                while (iterator.hasNext()) {
                    xmlSchema = (XSDSchema)iterator.next();

                    if (xmlSchema.getElement() == null) {
                        xmlSchema.updateElement();
                    }

                    transformer.transform(new DOMSource(xmlSchema.getElement().getOwnerDocument()),
                                          new StreamResult(writer));
                }
                writer.close();
                return writer.getBuffer().toString();
            } catch (Exception e) {
                // System.out.println("Unable to generate schema due to ..." +
                // e);
                // e.printStackTrace();
                throw new IllegalArgumentException(e.getMessage());
            }
        } else {
            // System.out.println("No SDO Types to generate schema ...");
            return "";
        }
    }

    public HelperContext getHelperContext() {
        return helperContext;
    }
}
