package org.apache.tuscany.sdo.helper;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axiom.om.util.StAXUtils;
import org.apache.ws.commons.schema.XmlSchema;



/**
 * This class parses the Schema document and inserts sdo annotations wherever required
 *
 */
public class SDOAnnotationsDecorator extends SDOAnnotations
{
    private Map sdoAnnotations = null;
    
    
    public SDOAnnotationsDecorator()
    {
    }
    
    public OMElement decorateWithAnnotations(Map schemaMap, Map annotationsMap) throws Exception 
    {
        StringWriter writer = new StringWriter();
        Iterator iterator = schemaMap.values().iterator();
        XmlSchema xmlSchema = null;
        
        writer.write("<xmlSchemas>\n");
        while ( iterator.hasNext() )
        {
            xmlSchema = (XmlSchema)iterator.next();
            xmlSchema.write(writer);
        }
        writer.write("</xmlSchemas>");
        
        XMLStreamReader xmlReader = StAXUtils.createXMLStreamReader(
                                        new ByteArrayInputStream(writer.toString().getBytes()));
        StAXOMBuilder staxOMBuilders = new StAXOMBuilder(OMAbstractFactory.getOMFactory(), xmlReader);
        OMElement documentElement = staxOMBuilders.getDocumentElement();
        
        decorateWithAnnotations(annotationsMap, documentElement);
        return documentElement;
    }
    
       
    public void decorateWithAnnotations(Map annotationsMap, OMElement schemaDoc)
    {
        sdoAnnotations = annotationsMap;
        Iterator schemaElements = schemaDoc.getChildElements();
        OMElement schema = null;
        String targetNamespace = null;
        String annoMapKey = null;
        
        while ( schemaElements.hasNext() )
        {
            schema = (OMElement)schemaElements.next();
            targetNamespace = getSchemaTargetNamespace(schema);
            annoMapKey = makeAnnotationMapKey(targetNamespace, SCHEMA, "");
            if ( sdoAnnotations.get(annoMapKey) != null )
            {
                addSDOAnnotations(schema, annoMapKey);
            }
            decorateWithAnnotations(targetNamespace, schema);  
        }
    }
    
    private void decorateWithAnnotations(String targetNamespace, OMElement schemaElement)
    {
        Iterator childElements = schemaElement.getChildElements();
        OMElement childElement = null;
        String annoMapKey = null;
        while ( childElements.hasNext() )
        {
            childElement = (OMElement)childElements.next();
            annoMapKey = makeAnnotationMapKey(targetNamespace, 
                                                childElement.getLocalName(), 
                                                getTypeNameAttribute(childElement));
            if ( sdoAnnotations.get(annoMapKey) != null )
            {
                addSDOAnnotations(childElement, annoMapKey);
            }
            decorateWithAnnotations(targetNamespace, childElement);   
        }
    }
    
    private void addSDOAnnotations(OMElement childElement, String annoMapKey)
    {
        Map annotations = (Map)sdoAnnotations.get(annoMapKey);
        if ( annotations != null )
        {
            Iterator keys = annotations.keySet().iterator();
            String attrName = null;
            while ( keys.hasNext() )
            {
                attrName = (String)keys.next();
                childElement.addAttribute(attrName, 
                                            (String)annotations.get(attrName),
                                            null);
            }
        }
    }
    
    
    private String getSchemaTargetNamespace(OMElement element)
    {
        return element.getAttributeValue(new QName("","targetNamespace"));
    }
    
    
    private String getTypeNameAttribute(OMElement element)
    {
        return element.getAttributeValue(new QName("","name"));
    }
}
