package org.apache.tuscany.sdo.helper;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

import javax.xml.namespace.QName;

import org.apache.tuscany.sdo.util.SDOUtil;
import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaAny;
import org.apache.ws.commons.schema.XmlSchemaAnyAttribute;
import org.apache.ws.commons.schema.XmlSchemaAttribute;
import org.apache.ws.commons.schema.XmlSchemaChoice;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.XmlSchemaComplexContent;
import org.apache.ws.commons.schema.XmlSchemaComplexContentExtension;
import org.apache.ws.commons.schema.XmlSchemaComplexType;
import org.apache.ws.commons.schema.XmlSchemaContentProcessing;
import org.apache.ws.commons.schema.XmlSchemaElement;
import org.apache.ws.commons.schema.XmlSchemaGroupBase;
import org.apache.ws.commons.schema.XmlSchemaImport;
import org.apache.ws.commons.schema.XmlSchemaInclude;
import org.apache.ws.commons.schema.XmlSchemaSequence;
import org.apache.ws.commons.schema.XmlSchemaSimpleType;
import org.apache.ws.commons.schema.XmlSchemaSimpleTypeRestriction;

import commonj.sdo.DataObject;
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
    
    protected XmlSchemaCollection xmlSchemaCollection = new XmlSchemaCollection();
    private Map schemaMap = null;
    protected Map targetNamespacePrefixMap = new Hashtable();
    protected Map schemaLocationMap = null;
    protected TypeTable typeTable = null;
    protected Map sdoAnnoMap = new Hashtable();
    
    
    protected SchemaBuilder(XmlSchemaCollection schemaCollection,
                                                Map schemaMap,
                                                Map nsPrefixMap,
                                                TypeTable typeTable,
                                                Map annotationMap,
                                                Map schemaLocMap )
    {
        this.schemaMap = schemaMap;
        this.xmlSchemaCollection = schemaCollection;
        this.targetNamespacePrefixMap = nsPrefixMap;
        this.typeTable = typeTable;
        this.sdoAnnoMap = annotationMap;
        this.schemaLocationMap = schemaLocMap;
    }
        
    
    
    
    private QName addAttribute2ComplexType(String targetNamespace, 
                                                XmlSchemaComplexType complexType, 
                                                Property aProperty) 
    {
        QName attributeSchemaType = null;
        
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
            }
            else
            {
                typeTable.addComplexSchemaType(aProperty.getType().getURI(),
                                                aProperty.getType().getName(),
                                                attributeSchemaType);
            }
            
            includeExtXSD(aProperty.getType());
        }
        
        XmlSchemaAttribute attribute  = new XmlSchemaAttribute();
        attribute.setName(aProperty.getName());    
        
        if ( !aProperty.getAliasNames().isEmpty() )
        {
            addAliasNamesAnnotation(targetNamespace, aProperty.getAliasNames(), ATTRIBUTE, aProperty.getName());
        }
        
        if ( aProperty.isReadOnly() )
        {
            addReadOnlyAnnotation(targetNamespace, aProperty.isReadOnly(), ATTRIBUTE, aProperty.getName());
        }
        
        if ( aProperty.getDefault() != null  )
        {
            attribute.setDefaultValue(aProperty.getDefault().toString());
        }
        
        if ( aProperty.getType().isDataType() )
        {
            attribute.setSchemaTypeName(attributeSchemaType);
        }
        else
        {
            attribute.setSchemaTypeName(typeTable.getSimpleSchemaTypeName("URI"));
            //addPropertyTypeAnnotation(targetNamespace, attributeSchemaType, ATTRIBUTE, aProperty.getName());
        }
        
        if ( aProperty.getOpposite() != null )
        {
            addOppositePropertyAnnotation(targetNamespace,
                                            aProperty.getOpposite().getName(),
                                            ATTRIBUTE,
                                            aProperty.getName());
        }
        complexType.getAttributes().add(attribute);
        return attributeSchemaType;
    }
    
    private QName addElement2ComplexType(String targetNamespace, 
                                            XmlSchemaComplexType complexType, 
                                            Property aProperty) 
    {
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
            }
            else
            {
                typeTable.addComplexSchemaType(aProperty.getType().getURI(),
                                                aProperty.getType().getName(),
                                                elementSchemaType);
            }
            includeExtXSD(aProperty.getType());
        }
        
        XmlSchemaElement element = new XmlSchemaElement();
        element.setName(aProperty.getName());
        
        if ( !aProperty.getAliasNames().isEmpty() )
        {
            addAliasNamesAnnotation(targetNamespace, aProperty.getAliasNames(), ELEMENT, aProperty.getName());
        }
        
        if ( aProperty.isReadOnly() )
        {
            addReadOnlyAnnotation(targetNamespace, aProperty.isReadOnly(), ELEMENT, aProperty.getName());
        }
        
        if ( aProperty.isMany() )
        {
            element.setMaxOccurs(Long.MAX_VALUE);
            element.setMinOccurs(0);
        }
        
        if ( aProperty.isContainment() )
        {
            element.setSchemaTypeName(elementSchemaType);
        }
        else
        {
            if ( !aProperty.getType().isDataType() )
            {
                element.setSchemaTypeName(typeTable.getSimpleSchemaTypeName("URI"));
                //addPropertyTypeAnnotation(targetNamespace, elementSchemaType, ELEMENT, aProperty.getName());
                
            }
        }
        
        if ( aProperty.getOpposite() != null )
        {
            addOppositePropertyAnnotation(targetNamespace,
                                            aProperty.getOpposite().getName(),
                                            ELEMENT,
                                            aProperty.getName());
        }
        
        ((XmlSchemaGroupBase)complexType.getParticle()).getItems().add(element);
        
        return elementSchemaType;
        
    }
    
    
    
    private QName buildComplexSchemaTypeContents(String targetNamespace, 
                                                        XmlSchemaComplexType complexType, 
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
                String prefix = addImports((XmlSchema)schemaMap.get(targetNamespace), propertySchemaTypeName);
                
                //need to do this only after adding imports to ensure the right namespace prefix is used
                if ( !aProperty.isContainment() && !aProperty.getType().isDataType() )
                {
                    addPropertyTypeAnnotation(targetNamespace, 
                                                prefix,
                                                aProperty.getType().getName(), 
                                                ELEMENT, 
                                                aProperty.getName());
                    
                }
                
            }
            else
            {
                propertySchemaTypeName = addAttribute2ComplexType(targetNamespace, complexType, aProperty);
                String prefix = addImports((XmlSchema)schemaMap.get(targetNamespace), propertySchemaTypeName);
                
                //need to do this only after adding imports to ensure the right namespace prefix is used
                if ( !aProperty.getType().isDataType() )
                {
                        addPropertyTypeAnnotation(targetNamespace, 
                                                    prefix,
                                                    aProperty.getType().getName(), 
                                                    ATTRIBUTE, 
                                                    aProperty.getName());
                }
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
            String targetNamespace = dataType.getURI(); 
            XmlSchema xmlSchema = getXmlSchema(dataType);
            
            String targetNamespacePrefix = (String)targetNamespacePrefixMap.get(targetNamespace);
            complexSchemaTypeName = new QName(targetNamespace, 
                                                dataType.getName(), 
                                                targetNamespacePrefix);
            
            
            XmlSchemaComplexType complexType = new XmlSchemaComplexType(xmlSchema);
            complexType.setName(dataType.getName());
            complexType.setAbstract(dataType.isAbstract());
            
            //add annotations for alias names
            if ( !dataType.getAliasNames().isEmpty() )
            {
                addAliasNamesAnnotation(targetNamespace,
                                        dataType.getAliasNames(), 
                                        COMPLEX_TYPE, 
                                        dataType.getName());
            }
            //add annotations for java instance class
            if ( dataType.getInstanceClass() != null )
            {
                addInstanceClassAnnotation(targetNamespace,
                                    dataType.getInstanceClass().getName(), 
                                    COMPLEX_TYPE, 
                                    dataType.getName());
            }
            
            handleBaseExtn(xmlSchema, dataType, complexType);
            handleSDOSequence(dataType, complexType);
            handleSDOOpenType(dataType, complexType);
            createGlobalElement(xmlSchema, complexType, complexSchemaTypeName);
            
            xmlSchema.getItems().add(complexType);
            xmlSchema.getSchemaTypes().add(complexSchemaTypeName, complexType);
            typeTable.addComplexSchemaType(dataType.getURI(), dataType.getName(), complexSchemaTypeName);
            
            buildComplexSchemaTypeContents(targetNamespace, complexType, dataType);
        }
        
        return complexSchemaTypeName;
    }
    
    private QName buildSimpleSchemaType(Type dataType)
    {
        QName simpleSchemaTypeName = null;
        if ( dataType.isDataType() &&
                (simpleSchemaTypeName = typeTable.getSimpleSchemaTypeName(dataType.getName()) ) == null )
        {
            XmlSchema xmlSchema = getXmlSchema(dataType);
            XmlSchemaSimpleType simpleType = new XmlSchemaSimpleType(xmlSchema);
            //set the name
            simpleType.setName(dataType.getName());
            //set abstract=true if abstract
            if ( dataType.isAbstract() )
            {
                addAbstractTypeAnnotation(dataType.getURI(), 
                                            dataType.isAbstract(),
                                            SIMPLE_TYPE,
                                            dataType.getName());
            }
            
            //add alias names if it exists
            addAliasNamesAnnotation(dataType.getURI(), 
                                        dataType.getAliasNames(),
                                        SIMPLE_TYPE,
                                        dataType.getName());
            
            //add instanceClass annotation
            if ( dataType.getInstanceClass() != null )
            {
                addInstanceClassAnnotation(dataType.getURI(), 
                                                dataType.getInstanceClass().getName(),
                                                SIMPLE_TYPE,
                                                dataType.getName());
            }
            
            if ( !dataType.getBaseTypes().isEmpty() )
            {
                Type baseType = (Type)dataType.getBaseTypes().get(0);
                XmlSchemaSimpleTypeRestriction restriction = new XmlSchemaSimpleTypeRestriction();
                
                
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
                    //include external XSD locations
                    includeExtXSD(baseType);
                }
                
                restriction.setBaseTypeName(baseSchemaType);
                simpleType.setContent(restriction);
                addImports(xmlSchema, baseSchemaType);
            }
            
            simpleSchemaTypeName = new QName(dataType.getURI(), 
                                                dataType.getName(), 
                                                (String)targetNamespacePrefixMap.get(dataType.getURI()));
            xmlSchema.getSchemaTypes().add(simpleSchemaTypeName, simpleType);
            typeTable.addSimpleSchemaType(dataType.getName(), simpleSchemaTypeName);
        }
        return simpleSchemaTypeName;
    }

    private void includeExtXSD(Type dataType)
    {
        //now we know there is a type for which the xsd must come from outside
        //create a schema for the namespace of this type and add an include in it for 
        //the xsd that is defined externally
        XmlSchema xmlSchema = getXmlSchema(dataType);
        
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
        
        Iterator includesIterator = xmlSchema.getIncludes().getIterator();
        Iterator schemaLocIterator = schemaLocations.iterator();
        String aSchemaLocation = null;
        boolean includeExists = false;
        //include all external schema locations
        while ( schemaLocIterator.hasNext() )
        {
            aSchemaLocation = (String)schemaLocIterator.next();
            while ( includesIterator.hasNext() )
            {
                if ( !includeExists && aSchemaLocation.equals(
                        ((XmlSchemaInclude)includesIterator.next()).getSchemaLocation() 
                                           ))
                {
                    includeExists = true;
                }
            }
            
            if ( !includeExists )
            {
                XmlSchemaInclude includeElement = new XmlSchemaInclude();
                includeElement.setSchemaLocation(aSchemaLocation);
                xmlSchema.getIncludes().add(includeElement);
                xmlSchema.getItems().add(includeElement);
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
            XSDHelper xsdHelper = SDOUtil.createXSDHelper(SDOUtil.createTypeHelper());
        
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
    
    
    private XmlSchema getXmlSchema(Type dataType) 
    {
        XmlSchema xmlSchema; 
        
        if ((xmlSchema = (XmlSchema) schemaMap.get(dataType.getURI())) == null) 
        {
            String targetNamespacePrefix = generatePrefix();
            
            xmlSchema = new XmlSchema(dataType.getURI(), xmlSchemaCollection);
            targetNamespacePrefixMap.put(dataType.getURI(), targetNamespacePrefix);
            schemaMap.put(dataType.getURI(), xmlSchema);
            
            Hashtable prefixmap = new Hashtable();
            prefixmap.put(TypeTable.XS_URI_PREFIX, TypeTable.XML_SCHEMA_URI);
            prefixmap.put(targetNamespacePrefix, dataType.getURI());
            xmlSchema.setPrefixToNamespaceMap(prefixmap);
            
            addSDONamespaces(xmlSchema);
            addPackageAnnotation(dataType);
        }
        return xmlSchema;
    }

    
    private void addSDONamespaces(XmlSchema xmlSchema)
    {
        xmlSchema.getPrefixToNamespaceMap().put(COMMONJ_SDO_NS_PREFIX, COMMONJ_SDO_NS);
        xmlSchema.getPrefixToNamespaceMap().put(SDO_JAVA_NS_PREFIX, SDO_JAVA_NS);
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
    
    private String addImports(XmlSchema xmlSchema, QName schemaTypeName)
    {
        String prefix = null;
        Enumeration enumeration = xmlSchema.getPrefixToNamespaceMap().keys();
        while ( enumeration.hasMoreElements() )
        {
            prefix = (String)enumeration.nextElement();
            if ( schemaTypeName.getNamespaceURI().equals(
                    xmlSchema.getPrefixToNamespaceMap().get(prefix)) )
            {
                return prefix;
            }
        }
        
        //the following lines are executed only if a prefix was not found which implies that the 
        //schemaTypeName was not imported earlier and also it does not belong to the targetnamespace
        String schemaLocation = null;
        XmlSchemaImport importElement = new XmlSchemaImport();
        importElement.setNamespace(schemaTypeName.getNamespaceURI());
        xmlSchema.getItems().add(importElement);
        prefix = generatePrefix();
        xmlSchema.getPrefixToNamespaceMap().put(prefix, schemaTypeName.getNamespaceURI());

        return prefix;
    }
    
    private void handleSDOSequence(Type datatype, XmlSchemaComplexType complexType)
    {
        if ( datatype.isSequenced()     )
        {
            complexType.setMixed(true);
            XmlSchemaChoice choice = new XmlSchemaChoice();
            choice.setMaxOccurs(Long.MAX_VALUE);
            complexType.setParticle(choice);
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
                XmlSchemaSequence sequence = new XmlSchemaSequence(); 
                complexType.setParticle(sequence);
            }
        }
    }
    
    private void handleSDOOpenType(Type datatype, XmlSchemaComplexType complexType)
    {
        if ( datatype.isOpen() /*&& 
                getPropertyStartsWithName(datatype.getDeclaredProperties(), GROUP).size() <= 0 */)
        {
            XmlSchemaAny anyType = new XmlSchemaAny();
            XmlSchemaContentProcessing cp = new XmlSchemaContentProcessing("lax");
            anyType.setProcessContent(new XmlSchemaContentProcessing("lax"));
            anyType.setMaxOccurs(Long.MAX_VALUE);
            ((XmlSchemaGroupBase)complexType.getParticle()).getItems().add(anyType);
            
            XmlSchemaAnyAttribute anyAttr = new XmlSchemaAnyAttribute();
            anyAttr.setProcessContent(new XmlSchemaContentProcessing("lax"));
            complexType.setAnyAttribute(anyAttr);
        }
    }
    
    private void handleBaseExtn(XmlSchema xmlSchema, 
                                    Type datatype, 
                                    XmlSchemaComplexType complexType) 
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
                includeExtXSD(baseType);
            }
                
            XmlSchemaComplexContent complexContent = new XmlSchemaComplexContent();
            XmlSchemaComplexContentExtension compContExtn = new XmlSchemaComplexContentExtension();
            compContExtn.setBaseTypeName(baseSchemaType);
            complexContent.setContent(compContExtn);
            complexType.setContentModel(complexContent);
            addImports(xmlSchema, baseSchemaType);
        }
    }
    
    private String formGlobalElementName(String typeName)
    {
        String firstChar = typeName.substring(0,1);
        return typeName.replaceFirst(firstChar, firstChar.toLowerCase());
    }
    
    private void createGlobalElement(XmlSchema xmlSchema, XmlSchemaComplexType complexType, QName elementName )
    {
        XmlSchemaElement globalElement = new XmlSchemaElement();
        globalElement.setSchemaTypeName(complexType.getQName());
        globalElement.setName(formGlobalElementName(complexType.getName()));
        globalElement.setQName(elementName);
        
        xmlSchema.getItems().add(globalElement);
        xmlSchema.getElements().add(elementName, globalElement);
    }
    
    private Map getAnnoMapForElement(String elementKey)
    {
        if ( sdoAnnoMap.get(elementKey) == null )
        {
            sdoAnnoMap.put(elementKey, new Hashtable());
        }
        return (Map)sdoAnnoMap.get(elementKey);
    }
    
    private void addAliasNamesAnnotation(String targetNamespace, 
                                            List aliasNames,    
                                            String schemeElement, 
                                            String schemeElementNameAttr)
    {
        if ( !aliasNames.isEmpty() )
        {
            StringBuffer sb = new StringBuffer();
            Iterator iterator = aliasNames.iterator();
            while ( iterator.hasNext() )
            {
            sb.append(iterator.next());
            }
            getAnnoMapForElement(makeAnnotationMapKey(targetNamespace, 
                                        schemeElement, 
                                        schemeElementNameAttr)).
                                            put(ALIAS_NAMES, sb.toString());
        }
    }
    
    private void addAbstractTypeAnnotation(String targetNamespace,            
                                                boolean isAbstract,
                                                String schemeElement, 
                                                String schemeElementNameAttr)
    {
        getAnnoMapForElement(makeAnnotationMapKey(targetNamespace, 
                                                    schemeElement, 
                                                    schemeElementNameAttr)).
                                                        put(ABSTRACT_TYPE, new Boolean(isAbstract).toString()); 
    }
    
    
    private void addPackageAnnotation(Type dataType)
    {
        if ( dataType.getInstanceClass() != null )
        {
            getAnnoMapForElement(makeAnnotationMapKey(dataType.getURI(),
                                                   SCHEMA,
                                                   "")).put(JAVA_PACKAGE, 
                                                             dataType.getInstanceClass().getPackage().getName());
        }
    }
    
    
    private void addReadOnlyAnnotation(String targetNamespace,            
                                        boolean isReadOnly,
                                        String schemeElement, 
                                        String schemeElementNameAttr)
    {
        getAnnoMapForElement(makeAnnotationMapKey(targetNamespace, 
                                            schemeElement, 
                                            schemeElementNameAttr)).
                                                put(READ_ONLY, new Boolean(isReadOnly).toString()); 
    }
    
    
    
    private void addPropertyTypeAnnotation(String targetNamespace,  
                                            String prefix,
                                            String propertyTypeName,
                                            String schemeElement, 
                                            String schemeElementNameAttr)
    {
        String value = prefix + COLON + propertyTypeName;
        getAnnoMapForElement(makeAnnotationMapKey(targetNamespace, 
                                                    schemeElement, 
                                                    schemeElementNameAttr)).
                                                    put(PROPERTY_TYPE, value); 
    }
    
    
    
    private void addOppositePropertyAnnotation(String targetNamespace,            
                                            String oppositePropName,
                                            String schemeElement, 
                                            String schemeElementNameAttr)
    {
        getAnnoMapForElement(makeAnnotationMapKey(targetNamespace, 
                                                    schemeElement, 
                                                    schemeElementNameAttr)).
                                                    put(OPPOSITE_PROPERTY, oppositePropName); 
    }
    
    
    
    private void addInstanceClassAnnotation(String targetNamespace,            
                                                String className,
                                                String schemeElement, 
                                                String schemeElementNameAttr)
    {
        getAnnoMapForElement(makeAnnotationMapKey(targetNamespace, 
                                    schemeElement, 
                                    schemeElementNameAttr)).
                                        put(INSTANCE_CLASS, className); 
    }    
    
    private DataObject createDataObject(Class sdoType) throws Exception
    {
        Constructor constructor = sdoType.getDeclaredConstructor(new Class[0]);
        constructor.setAccessible(true);
        Object instance = constructor.newInstance(new Object[0]);
        return (DataObject)instance;
    }
    
    public void clipProperties(Type dataType)
    {
        Property aProperty = null; 
        //clip properties with name 'mixed' when parent data type is sequenced
        /*if ( dataType.isSequenced() && 
                (aProperty = getPropertyByName(dataType.getDeclaredProperties(), MIXED)) != null )
        {
            dataType.getDeclaredProperties().remove(aProperty);
        }*/
    }
    
    private Property getPropertyByName(List propertiesList, String propertyName)
    {
        Iterator iterator = propertiesList.iterator();
        Property aProperty = null;
        while ( iterator.hasNext())
        {
            aProperty = (Property)iterator.next();
            if ( aProperty.getName().equals(propertyName) )
            {
                return aProperty;
            }
        }
        return null;
    }
    
    private Collection getPropertyStartsWithName(List propertiesList, String propertyName)
    {
        Iterator iterator = propertiesList.iterator();
        Property aProperty = null;
        Vector matchingProperties = new Vector();
        while ( iterator.hasNext())
        {
            aProperty = (Property)iterator.next();
            if ( aProperty.getName().startsWith(propertyName) )
            {
                matchingProperties.addElement(aProperty);
            }
        }
        return matchingProperties;
    }
    
    private String generatePrefix() 
    {
        return NAME_SPACE_PREFIX + prefixCount++;
    }
}
