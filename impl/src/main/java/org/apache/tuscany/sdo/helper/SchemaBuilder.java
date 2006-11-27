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

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

import javax.xml.namespace.QName;

import org.apache.tuscany.sdo.util.SDOUtil;
import org.eclipse.xsd.XSDAttributeDeclaration;
import org.eclipse.xsd.XSDAttributeUse;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDCompositor;
import org.eclipse.xsd.XSDConstraint;
import org.eclipse.xsd.XSDDerivationMethod;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDFactory;
import org.eclipse.xsd.XSDForm;
import org.eclipse.xsd.XSDImport;
import org.eclipse.xsd.XSDInclude;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDProcessContents;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSchemaContent;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.XSDWildcard;

import commonj.sdo.Property;
import commonj.sdo.Type;
import commonj.sdo.helper.XSDHelper;

public class SchemaBuilder extends SDOAnnotations
{
    public static final String DEFAULT_SCHEMA_LOCATION = "";
    public static final String NAME_SPACE_PREFIX        = "stn_";
    private static int prefixCount                      = 1;
    
    //public static final String MIXED = "mixed";
    //public static final String GROUP = "group";
    public static final String EFEATURE_MAP_ENTRY = "EFeatureMapEntry";
    
    private Map schemaMap = null;
    protected Map targetNamespacePrefixMap = new Hashtable();
    protected Map schemaLocationMap = null;
    protected TypeTable typeTable = null;
    protected XSDFactory xsdFactory = XSDFactory.eINSTANCE;
    
    
    protected SchemaBuilder(Map schemaMap,
                            Map nsPrefixMap,
                            TypeTable typeTable,
                            Map schemaLocMap )
    {
        this.schemaMap = schemaMap;
        this.targetNamespacePrefixMap = nsPrefixMap;
        this.typeTable = typeTable;
        this.schemaLocationMap = schemaLocMap;
    }
        
    
    
    
    private QName addAttribute2ComplexType(String targetNamespace, 
                                                XSDComplexTypeDefinition complexType, 
                                                Property aProperty) 
    {
        QName attributeSchemaType = null;
        String prefix = null;
        
        try
        {
            attributeSchemaType = buildSchema(aProperty.getType());
        }
        catch ( IllegalArgumentException e )
        {
            //schema cannot be generated for this type as there exists an xsd already
            //so include that original XSD
            attributeSchemaType = new QName(aProperty.getType().getURI(), 
                                            aProperty.getType().getName(),
                                            generatePrefix());
            if ( aProperty.getType().isDataType() )
            {
                typeTable.addSimpleSchemaType(aProperty.getType().getName(), attributeSchemaType);
                
                XSDSimpleTypeDefinition simpleType = xsdFactory.createXSDSimpleTypeDefinition();
                simpleType.setName(aProperty.getType().getName());
                simpleType.setTargetNamespace(aProperty.getType().getURI());
                typeTable.addXSDTypeDef(attributeSchemaType.getNamespaceURI(), 
                                        attributeSchemaType.getLocalPart(), 
                                        simpleType);
            }
            else
            {
                typeTable.addComplexSchemaType(aProperty.getType().getURI(),
                                                aProperty.getType().getName(),
                                                attributeSchemaType);
                
                XSDComplexTypeDefinition extComplexType = xsdFactory.createXSDComplexTypeDefinition();
                extComplexType.setName(aProperty.getType().getName());
                extComplexType.setTargetNamespace(aProperty.getType().getURI());
                typeTable.addXSDTypeDef(attributeSchemaType.getNamespaceURI(), 
                                        attributeSchemaType.getLocalPart(), 
                                        extComplexType);
            }
            includeExtXSD(aProperty.getType());
        }
        //ensure than an import is done rightaway so that the right prefixes will be used by the 
        //attribute whose type is set as 'this type'.  Otherwise when setting the type for the attribute
        //there will be a duplicate prefix (like Q1 or Q2... ) that will be created
        prefix = addImports((XSDSchema)schemaMap.get(targetNamespace), attributeSchemaType);
        
        XSDAttributeDeclaration attribute  = xsdFactory.createXSDAttributeDeclaration();
        attribute.setName(aProperty.getName());    
        XSDAttributeUse orderDateAttributeUse = xsdFactory.createXSDAttributeUse();
        orderDateAttributeUse.setContent(attribute);
        complexType.getAttributeContents().add(orderDateAttributeUse);
        attribute.updateElement();
        
        if ( aProperty.getType().isDataType() )
        {
            attribute.setTypeDefinition((XSDSimpleTypeDefinition)typeTable.getXSDTypeDef(attributeSchemaType.getNamespaceURI(), 
                                            attributeSchemaType.getLocalPart()));
            
        }
        else
        {
            attribute.setTypeDefinition((XSDSimpleTypeDefinition)typeTable.getXSDTypeDef(
                    typeTable.getSimpleSchemaTypeName("URI").getNamespaceURI(), 
                    typeTable.getSimpleSchemaTypeName("URI").getLocalPart()));
            
        }
        
        if ( aProperty.getDefault() != null  )
        {
            attribute.setConstraint(XSDConstraint.DEFAULT_LITERAL);
            attribute.setLexicalValue(aProperty.getDefault().toString());
        }

        addAnnotations(attribute, aProperty );
        if ( !aProperty.getType().isDataType() )
        {
            String value = prefix + COLON + attributeSchemaType.getLocalPart();
            attribute.getElement().setAttribute(PROPERTY_TYPE, value);
        }
        
        return attributeSchemaType;
    }
    
    private QName addElement2ComplexType(String targetNamespace, 
                                            XSDComplexTypeDefinition complexType, 
                                            Property aProperty) 
    {
        String prefix = null;
        QName elementSchemaType = null;
        try 
        {
            elementSchemaType = buildSchema(aProperty.getType());
        }
        catch ( IllegalArgumentException e )
        {
            //schema cannot be generated for this type as there exists an xsd already
            //so include that original XSD
            elementSchemaType = new QName(aProperty.getType().getURI(), 
                                            aProperty.getType().getName(),
                                            generatePrefix());
            if ( aProperty.getType().isDataType() )
            {
                typeTable.addSimpleSchemaType(aProperty.getType().getName(), elementSchemaType);
                
                XSDSimpleTypeDefinition simpleType = xsdFactory.createXSDSimpleTypeDefinition();
                simpleType.setName(aProperty.getType().getName());
                simpleType.setTargetNamespace(aProperty.getType().getURI());
                typeTable.addXSDTypeDef(elementSchemaType.getNamespaceURI(), 
                                        elementSchemaType.getLocalPart(), 
                                        simpleType);
            }
            else
            {
                typeTable.addComplexSchemaType(aProperty.getType().getURI(),
                                                aProperty.getType().getName(),
                                                elementSchemaType);
                XSDComplexTypeDefinition extComplexType = xsdFactory.createXSDComplexTypeDefinition();
                extComplexType.setName(aProperty.getType().getName());
                extComplexType.setTargetNamespace(aProperty.getType().getURI());
                typeTable.addXSDTypeDef(elementSchemaType.getNamespaceURI(), 
                                        elementSchemaType.getLocalPart(), 
                                        extComplexType);
            }
            includeExtXSD(aProperty.getType());
        }
        
        //ensure than an import is done rightaway so that the right prefixes will be used by the 
        //element whose type is set as 'this type'.  Otherwise when setting the type for the element
        //there will be a duplicate prefix (like Q1 or Q2... ) that will be created
        prefix = addImports((XSDSchema)schemaMap.get(targetNamespace), elementSchemaType);
        
        //XmlSchemaElement element = new XmlSchemaElement();
        XSDElementDeclaration element = xsdFactory.createXSDElementDeclaration();
        element.setName(aProperty.getName());
         
        XSDParticle aParticle = xsdFactory.createXSDParticle();
        aParticle.setContent(element);
        
        ((XSDModelGroup)((XSDParticle)complexType.getContent()).getContent()).
        getContents().add(aParticle);
        
        element.updateElement();

        if ( aProperty.isMany() )
        {
            aParticle.setMaxOccurs(-1);
            aParticle.setMinOccurs(0);
            
        }
        
        if ( aProperty.isContainment() )
        {
            element.setTypeDefinition(typeTable.getXSDTypeDef(elementSchemaType.getNamespaceURI(),
                                                                elementSchemaType.getLocalPart()));
        }
        else
        {
            if ( !aProperty.getType().isDataType() )
            {
                QName qName = typeTable.getSimpleSchemaTypeName("URI");
                element.setTypeDefinition(typeTable.getXSDTypeDef(qName.getNamespaceURI(),
                                            qName.getLocalPart())); 
            }
        }
        
        addAnnotations(element, aProperty);
        if ( !aProperty.isContainment() && !aProperty.getType().isDataType() )
        {
            String value = prefix + COLON + elementSchemaType.getLocalPart();
            element.getElement().setAttribute(PROPERTY_TYPE, value);
        }
        return elementSchemaType;
        
    }
    
    private void addAnnotations(XSDSchemaContent xsdContent, Property aProperty)
    {
        if ( !aProperty.getAliasNames().isEmpty() )
        {
            addAliasNamesAnnotation(xsdContent, aProperty.getAliasNames());
        }
        
        if ( aProperty.isReadOnly() )
        {
            xsdContent.getElement().setAttribute(READ_ONLY, Boolean.toString(aProperty.isReadOnly()));
        }
        
        if ( aProperty.getOpposite() != null )
        {
            xsdContent.getElement().setAttribute(OPPOSITE_PROPERTY, aProperty.getOpposite().getName());
        }
    }
    
    
    private QName buildComplexSchemaTypeContents(String targetNamespace, 
                                                        XSDComplexTypeDefinition complexType, 
                                                        Type dataType)
    {
        //clipProperties(dataType);
        List properties = dataType.getDeclaredProperties();
        Iterator iterator = properties.iterator();
        Property aProperty; 
        QName propertySchemaTypeName = null;
        
        while ( iterator.hasNext() )
        {
            aProperty = (Property)iterator.next();
            if ( aProperty.isContainment() || aProperty.isMany() || !aProperty.getType().isDataType() )
            {
                propertySchemaTypeName = addElement2ComplexType(targetNamespace, complexType, aProperty);
            }
            else
            {
                propertySchemaTypeName = addAttribute2ComplexType(targetNamespace, complexType, aProperty);
            }
            
            /*if ( !EFEATURE_MAP_ENTRY.equals(aProperty.getType().getName()) )
            {
                addContents2ComplexType(targetNamespace, complexType, aProperty);
            }*/
        }
        
        return propertySchemaTypeName;
        
    }
    
    public QName buildComplexSchemaType(Type dataType) 
    {
        //this is called from buildSchema only if isXSD(dataType) is false
        QName complexSchemaTypeName = null ;
        if ( !dataType.isDataType() && 
                (complexSchemaTypeName = typeTable.getComplexSchemaTypeName(dataType.getURI(), dataType.getName())) == null )
        {
            XSDSchema xmlSchema = getXmlSchema(dataType);
            String targetNamespace = dataType.getURI(); 
            String targetNamespacePrefix = (String)targetNamespacePrefixMap.get(targetNamespace);
            
            complexSchemaTypeName = new QName(targetNamespace, 
                                                dataType.getName(), 
                                                targetNamespacePrefix);
            
            XSDComplexTypeDefinition complexType = xsdFactory.createXSDComplexTypeDefinition();
            complexType.setName(dataType.getName());
            complexType.setTargetNamespace(targetNamespace);     
            complexType.setAbstract(dataType.isAbstract());
            
            xmlSchema.getTypeDefinitions().add(complexType);
            xmlSchema.getContents().add(complexType);
            
            complexType.updateElement();
            
            addAnnotations(complexType, dataType);
            
            handleBaseExtn(xmlSchema, dataType, complexType);
            handleSDOSequence(dataType, complexType);
            handleSDOOpenType(dataType, complexType);
            
            //add before constructing the contents because a content element could
            //possibly be of type 'complexType'. 
            typeTable.addComplexSchemaType(dataType.getURI(), dataType.getName(), complexSchemaTypeName);
            typeTable.addXSDTypeDef(dataType.getURI(), dataType.getName(), complexType);
            
            //now compose the contents for this complex type
            buildComplexSchemaTypeContents(targetNamespace, complexType, dataType);
            
            //finally create a global element for this type
            createGlobalElement(xmlSchema, complexType, complexSchemaTypeName);
        }
        
        return complexSchemaTypeName;
    }
    
    private void addAnnotations(XSDTypeDefinition xsdType, Type dataType)
    {
        if ( dataType.isAbstract() )
        {
            if ( xsdType instanceof XSDComplexTypeDefinition )
            {
                ((XSDComplexTypeDefinition)xsdType).setAbstract(dataType.isAbstract());
            }
            else
            {
                xsdType.getElement().setAttribute(ABSTRACT_TYPE, 
                                Boolean.toString(dataType.isAbstract()));
            }
        }
        
        //add alias names if it exists
        addAliasNamesAnnotation(xsdType, 
                                    dataType.getAliasNames());
        
        //add instanceClass annotation
        if ( dataType.getInstanceClass() != null )
        {
            xsdType.getElement().setAttribute(INSTANCE_CLASS, dataType.getInstanceClass().getName());
        }
    }
    
    
    private QName buildSimpleSchemaType(Type dataType)
    {
        QName simpleSchemaTypeName = null;
        if ( dataType.isDataType() &&
                (simpleSchemaTypeName = typeTable.getSimpleSchemaTypeName(dataType.getName()) ) == null )
        {
            XSDSchema xmlSchema = getXmlSchema(dataType);
            XSDSimpleTypeDefinition simpleType = xsdFactory.createXSDSimpleTypeDefinition();
            //set the name
            simpleType.setName(dataType.getName());
            simpleType.setTargetNamespace(dataType.getURI());
            //set abstract=true if abstract
            simpleSchemaTypeName = new QName(dataType.getURI(), 
                                             dataType.getName(), 
                                             (String)targetNamespacePrefixMap.get(dataType.getURI()));
            xmlSchema.getContents().add(simpleType);
            simpleType.updateElement();
            
            addAnnotations(simpleType, dataType);
            
            if ( !dataType.getBaseTypes().isEmpty() )
            {
                Type baseType = (Type)dataType.getBaseTypes().get(0);
                
                QName baseSchemaType = null;
                
                try
                {
                    baseSchemaType = buildSchema(baseType);
                }
                catch ( IllegalArgumentException e )
                {
                    //this means that the base type comes from a original xsd and hence not generated
                    baseSchemaType = new QName(baseType.getURI(), 
                                                baseType.getName(),
                                                generatePrefix());
                    
                    typeTable.addSimpleSchemaType(baseType.getName(), baseSchemaType);

                    XSDSimpleTypeDefinition baseTypeDef = xsdFactory.createXSDSimpleTypeDefinition();
                    baseTypeDef.setName(baseType.getName());
                    baseTypeDef.setTargetNamespace(baseType.getURI());
                    typeTable.addXSDTypeDef(baseType.getURI(), baseType.getName(), baseTypeDef);
                        
                    //include external XSD locations
                    includeExtXSD(baseType);
                }
                
                simpleType.setBaseTypeDefinition((XSDSimpleTypeDefinition)typeTable.
                        getXSDTypeDef(baseSchemaType.getNamespaceURI(),baseSchemaType.getLocalPart()));
                addImports(xmlSchema, baseSchemaType);
            }
            
            
            typeTable.addSimpleSchemaType(dataType.getName(), simpleSchemaTypeName);
            typeTable.addXSDTypeDef(dataType.getURI(), dataType.getName(), simpleType);
        }
        return simpleSchemaTypeName;
    }

    private void includeExtXSD(Type dataType)
    {
        //now we know there is a type for which the xsd must come from outside
        //create a schema for the namespace of this type and add an include in it for 
        //the xsd that is defined externally
        XSDSchema xmlSchema = getXmlSchema(dataType);
        
        //ideally there could  be more than one external schema defintions for a namespace
        //and hence schemalocations will be a list of locations
        //List schemaLocations = (List)schemaLocationMap.get(dataType.getURI());
        
        //since as per the specs the input to XSDHelper is a map of <String, String> allowing
        //only one schemalocation for a namespace.  So for now this single location will be
        //picked up and put into a list
        List schemaLocations = new Vector();
        if ( schemaLocationMap.get(dataType.getURI()) != null )
        {
            schemaLocations.add(schemaLocationMap.get(dataType.getURI()));
        }
        
        if ( schemaLocations.size() <= 0 )
        {
            schemaLocations.add(DEFAULT_SCHEMA_LOCATION);
        }
        
        Object schemaContent = null;
        Iterator includesIterator = xmlSchema.getContents().iterator();
        Iterator schemaLocIterator = schemaLocations.iterator();
        String aSchemaLocation = null;
        boolean includeExists = false;
        //include all external schema locations
        while ( schemaLocIterator.hasNext() )
        {
            aSchemaLocation = (String)schemaLocIterator.next();
            while ( includesIterator.hasNext() )
            {
                schemaContent = includesIterator.next();
                if ( schemaContent instanceof XSDInclude )
                {
                    if ( !includeExists && aSchemaLocation.equals(
                            ((XSDInclude)schemaContent).getSchemaLocation() 
                                 ))
                    {
                        includeExists = true;
                    }
                }
            }
            
            if ( !includeExists )
            {
                XSDInclude includeElement = xsdFactory.createXSDInclude();
                includeElement.setSchemaLocation(aSchemaLocation);
                xmlSchema.getContents().add(0, includeElement);
            }
        }
    }
    
    protected QName buildSchema(Type dataType) throws IllegalArgumentException
    {
        QName schemaTypeName = null;
        
        if ( dataType.isDataType() )
        {
            schemaTypeName = typeTable.getSimpleSchemaTypeName(dataType.getName());
        }
        else
        {
            schemaTypeName = typeTable.getComplexSchemaTypeName(dataType.getURI(), dataType.getName());
        }
        
        //attempt to generate only if we have not done it already..i.e the type is 
        //not found in the typetable
        if ( schemaTypeName == null )
        {
            XSDHelper xsdHelper = SDOUtil.createHelperContext().getXSDHelper();
        
            if ( !xsdHelper.isXSD( dataType ) )
            {
                if ( dataType.isDataType() )
                {
                    schemaTypeName =  buildSimpleSchemaType(dataType);
                }
                else
                {
                    schemaTypeName =  buildComplexSchemaType(dataType);
                }
            }
            else
            {
                throw new IllegalArgumentException("Cannot generate XSD since SDO Type '" + 
                        dataType.getName() + "' was orginally generated from XSD.  Use original XSD");
            }
        }
        return schemaTypeName;
    }
    
    
    private XSDSchema getXmlSchema(Type dataType) 
    {
        XSDSchema xmlSchema = null; 
        
        if ((xmlSchema = (XSDSchema) schemaMap.get(dataType.getURI())) == null) 
        {
            String targetNamespacePrefix = generatePrefix();
            
            xmlSchema = xsdFactory.createXSDSchema();
            xmlSchema.setTargetNamespace(dataType.getURI());
            xmlSchema.setAttributeFormDefault(XSDForm.QUALIFIED_LITERAL);
            xmlSchema.setElementFormDefault(XSDForm.QUALIFIED_LITERAL);
            
            targetNamespacePrefixMap.put(dataType.getURI(), targetNamespacePrefix);
            schemaMap.put(dataType.getURI(), xmlSchema);
            
            xmlSchema.getQNamePrefixToNamespaceMap().put(TypeTable.XS_URI_PREFIX, TypeTable.XML_SCHEMA_URI);
            xmlSchema.setSchemaForSchemaQNamePrefix(TypeTable.XS_URI_PREFIX);

            xmlSchema.getQNamePrefixToNamespaceMap().put(targetNamespacePrefix, dataType.getURI());
            //xmlSchema.setSchemaForSchemaQNamePrefix(targetNamespacePrefix);
            
            addSDONamespaces(xmlSchema);
            addPackageAnnotation(xmlSchema, dataType);
        }
        return xmlSchema;
    }

    
    private void addSDONamespaces(XSDSchema xmlSchema)
    {
        xmlSchema.getQNamePrefixToNamespaceMap().put(COMMONJ_SDO_NS_PREFIX, COMMONJ_SDO_NS);
        //xmlSchema.setSchemaForSchemaQNamePrefix(COMMONJ_SDO_NS_PREFIX);
        
        xmlSchema.getQNamePrefixToNamespaceMap().put(SDO_JAVA_NS_PREFIX, SDO_JAVA_NS);
        //xmlSchema.setSchemaForSchemaQNamePrefix(SDO_JAVA_NS_PREFIX);
    }
    
    
    /**
     * JAM convert first name of an attribute into UpperCase as an example if
     * there is a instance variable called foo in a bean , then Jam give that as
     * Foo so this method is to correct that error
     *
     * @param wrongName
     * @return the right name, using english as the locale for case conversion
     */
    public static String getCorrectName(String wrongName) 
    {
        if (wrongName.length() > 1) {
            return wrongName.substring(0, 1).toLowerCase(Locale.ENGLISH)
                    + wrongName.substring(1, wrongName.length());
        } else {
            return wrongName.substring(0, 1).toLowerCase(Locale.ENGLISH);
        }
    }
    
    private String addImports(XSDSchema xmlSchema, QName schemaTypeName)
    {
        String prefix = null;
        Iterator iterator = xmlSchema.getQNamePrefixToNamespaceMap().keySet().iterator();
        while ( iterator.hasNext() )
        {
            prefix = (String)iterator.next();
            
            if ( schemaTypeName.getNamespaceURI().equals(
                    xmlSchema.getQNamePrefixToNamespaceMap().get(prefix)) )
            {
                return prefix;
            }
        }
        
        //the following lines are executed only if a prefix was not found which implies that the 
        //schemaTypeName was not imported earlier and also it does not belong to the targetnamespace
        XSDImport importElement = xsdFactory.createXSDImport();
        importElement.setNamespace(schemaTypeName.getNamespaceURI());
        xmlSchema.getContents().add(0, importElement);
        prefix = schemaTypeName.getPrefix();
        if ( prefix == null || prefix.length() <= 0 )
        {
            prefix = generatePrefix();
        }
        xmlSchema.getQNamePrefixToNamespaceMap().put(prefix, schemaTypeName.getNamespaceURI());

        return prefix;
    }
    
    private void handleSDOSequence(Type datatype, XSDComplexTypeDefinition complexType)
    {
        if ( datatype.isSequenced()     )
        {
            complexType.setMixed(true);
            XSDModelGroup choice = xsdFactory.createXSDModelGroup();
            choice.setCompositor(XSDCompositor.CHOICE_LITERAL);
            XSDParticle aParticle = xsdFactory.createXSDParticle();
            aParticle.setContent(choice);
            aParticle.setMaxOccurs(-1);
            complexType.setContent(aParticle);
        }
        else
        {
            //hack to handle group property as choice
            /*if ( getPropertyStartsWithName(datatype.getDeclaredProperties(), GROUP).size() > 0 )
            {
                XmlSchemaChoice choice = new XmlSchemaChoice();
                choice.setMaxOccurs(Long.MAX_VALUE);
                complexType.setParticle(choice);
            }
            else*/
            {
                XSDModelGroup sequence = xsdFactory.createXSDModelGroup();
                sequence.setCompositor(XSDCompositor.SEQUENCE_LITERAL);
                XSDParticle aParticle = xsdFactory.createXSDParticle();
                aParticle.setContent(sequence);
                complexType.setContent(aParticle);
            }
        }
    }
    
    private void handleSDOOpenType(Type datatype, XSDComplexTypeDefinition complexType)
    {
        if ( datatype.isOpen() /*&& 
                getPropertyStartsWithName(datatype.getDeclaredProperties(), GROUP).size() <= 0 */)
        {
            XSDWildcard elementWildcard = xsdFactory.createXSDWildcard();
            elementWildcard.getLexicalNamespaceConstraint().add("##other");
            elementWildcard.setProcessContents(XSDProcessContents.LAX_LITERAL);
            // Create a particle to hold the wildcard.
            XSDParticle wildcardParticle = xsdFactory.createXSDParticle();
            wildcardParticle.setContent(elementWildcard);
            wildcardParticle.setMaxOccurs(-1);
            ((XSDModelGroup)((XSDParticle)complexType.getContent()).getContent()).
                getContents().add(wildcardParticle);
               
            XSDWildcard attributeWildcard = xsdFactory.createXSDWildcard();
            attributeWildcard.getLexicalNamespaceConstraint().add("##other");
            attributeWildcard.setProcessContents(XSDProcessContents.LAX_LITERAL);
            complexType.setAttributeWildcard(attributeWildcard);
        }
    }
    
    private void handleBaseExtn(XSDSchema xmlSchema, 
                                    Type datatype, 
                                    XSDComplexTypeDefinition complexType) 
    {
        if ( datatype.getBaseTypes().size() > 0 )
        {
            Type baseType = (Type)datatype.getBaseTypes().get(0);
            QName baseSchemaType = null;
            
            try
            {
                baseSchemaType = buildSchema(baseType);
            }
            catch ( IllegalArgumentException e )
            {
                //schema cannot be generated for this type as there exists an xsd already
                //so include that original XSD
                baseSchemaType = new QName(baseType.getURI(), 
                                            baseType.getName(),
                                            generatePrefix());
                
                XSDSimpleTypeDefinition baseTypeDef = xsdFactory.createXSDSimpleTypeDefinition();
                baseTypeDef.setName(baseType.getName());
                baseTypeDef.setTargetNamespace(baseType.getURI());
                typeTable.addXSDTypeDef(baseType.getURI(), baseType.getName(), baseTypeDef);
                
                includeExtXSD(baseType);
            }
            
            complexType.setDerivationMethod(XSDDerivationMethod.EXTENSION_LITERAL);
            
            if ( baseType.isDataType() )
            {
                XSDSimpleTypeDefinition anonymousSimpleTypeDefinition 
                    = xsdFactory.createXSDSimpleTypeDefinition();
                anonymousSimpleTypeDefinition.setBaseTypeDefinition((XSDSimpleTypeDefinition)typeTable.
                        getXSDTypeDef(baseSchemaType.getNamespaceURI(),baseSchemaType.getLocalPart()));
                complexType.setContent(anonymousSimpleTypeDefinition);
            }
            else
            {
                complexType.setBaseTypeDefinition((XSDSimpleTypeDefinition)typeTable.
                    getXSDTypeDef(baseSchemaType.getNamespaceURI(),baseSchemaType.getLocalPart()));
                
            }    
                
            addImports(xmlSchema, baseSchemaType);
        }
    }
    
    private String formGlobalElementName(String typeName)
    {
        String firstChar = typeName.substring(0,1);
        return typeName.replaceFirst(firstChar, firstChar.toLowerCase());
    }
    
    private void createGlobalElement(XSDSchema xmlSchema, 
                                         XSDComplexTypeDefinition complexType, 
                                         QName schemaElementName )
    {
        XSDElementDeclaration globalElement = xsdFactory.createXSDElementDeclaration();
        globalElement.setTargetNamespace(xmlSchema.getTargetNamespace());
        globalElement.setName(formGlobalElementName(complexType.getName()));
        globalElement.setTypeDefinition
            (typeTable.getXSDTypeDef(schemaElementName.getNamespaceURI(), 
                                                    schemaElementName.getLocalPart()));
        xmlSchema.getContents().add(globalElement);
        xmlSchema.getElementDeclarations().add(globalElement);
    }
    
    private void addAliasNamesAnnotation(XSDSchemaContent typeDef, 
                                            List aliasNames)
    {
        if ( !aliasNames.isEmpty() )
        {
            StringBuffer sb = new StringBuffer();
            Iterator iterator = aliasNames.iterator();
            while ( iterator.hasNext() )
            {
                sb.append(iterator.next());
            }
            typeDef.getElement().setAttribute(ALIAS_NAMES, sb.toString());
        }
    }
    
    private void addPackageAnnotation(XSDSchema xmlSchema, Type dataType)
    {
        if ( dataType.getInstanceClass() != null )
        {
            xmlSchema.updateElement();
            xmlSchema.getElement().setAttribute(JAVA_PACKAGE, 
                                                dataType.getInstanceClass().getPackage().getName());
        }
    }
    
    private String generatePrefix() 
    {
        return NAME_SPACE_PREFIX + prefixCount++;
    }
}
