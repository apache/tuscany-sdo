/*
 * Copyright 2004,2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.tuscany.sdo.util.resource;

import java.util.Map;
import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import org.apache.tuscany.sdo.api.SDOHelper;
import org.apache.tuscany.sdo.api.SDOUtil;
/**
 * The XMLStreamSerializer pulls events from the XMLStreamReader and dumps into the XMLStreamWriter
 */
public class XMLStreamSerializer implements XMLStreamConstants {

    private static int namespaceSuffix = 0;

    public static final String NAMESPACE_PREFIX = "ns";

    /*
     * The behavior of the serializer is such that it returns when it encounters the starting element for the second time. The depth variable tracks
     * the depth of the serilizer and tells it when to return. Note that it is assumed that this serialization starts on an Element.
     */

    /**
     * Field depth
     */
    private int depth = 0;

    /**
     * Method serialize.
     * 
     * @param node
     * @param writer
     * @throws XMLStreamException
     */
    public void serialize(XMLStreamReader node, XMLStreamWriter writer) throws XMLStreamException {
        serializeNode(node, writer);
    }

    public void serialize(XMLStreamReader node, XMLStreamWriter writer, Map options) throws XMLStreamException {
    	this.options = options;
        serializeNode(node, writer);
    }
    /**
     * Method serializeNode.
     * 
     * @param reader
     * @param writer
     * @throws XMLStreamException
     */
    protected void serializeNode(XMLStreamReader reader, XMLStreamWriter writer) throws XMLStreamException {
        // TODO We get the StAXWriter at this point and uses it hereafter assuming that this is the only entry point to this class.
        // If there can be other classes calling methodes of this we might need to change methode signatures to OMOutputer
        while (reader.hasNext()) {
            int event = reader.next();
            if (event == START_ELEMENT) {
            	if(options == null){
            		serializeElement(reader, writer);
            	}
            	else{
            		serializeElementWithOptions(reader, writer);
            	}
                depth++;
            } else if (event == ATTRIBUTE) {
                serializeAttributes(reader, writer);
            } else if (event == CHARACTERS) {
                serializeText(reader, writer);
            } else if (event == COMMENT) {
                serializeComment(reader, writer);
            } else if (event == CDATA) {
                serializeCData(reader, writer);
            } else if (event == END_ELEMENT) {
            	if(options == null){
            		serializeEndElement(writer);
            	}else{
            		serializeEndElementWithOptions(writer);
            	}
                depth--;
            } else if (event == START_DOCUMENT) {
                depth++; // if a start document is found then increment the depth
            } else if (event == END_DOCUMENT) {
                if (depth != 0)
                    depth--; // for the end document - reduce the depth
                try {
                	if(options == null){
                		serializeEndElement(writer);
                	}
                	else{
                		serializeEndElementWithOptions(writer);	
                	}                    
                } catch (Exception e) {
                    // TODO: log exceptions
                }
            }
            if (depth == 0) {
                break;
            }
        }
    }

    /**
     * @param reader
     * @param writer
     * @throws XMLStreamException
     */
    protected void serializeElement(XMLStreamReader reader, XMLStreamWriter writer) throws XMLStreamException {
        String prefix = reader.getPrefix();
        String nameSpaceName = reader.getNamespaceURI();
        if (nameSpaceName != null) {
            String writer_prefix = writer.getPrefix(nameSpaceName);
            if (writer_prefix != null) {
                writer.writeStartElement(nameSpaceName, reader.getLocalName());
            } else {
                if (prefix != null) {
                    writer.writeStartElement(prefix, reader.getLocalName(), nameSpaceName);
                    writer.writeNamespace(prefix, nameSpaceName);
                    writer.setPrefix(prefix, nameSpaceName);
                } else {
                    writer.writeStartElement(nameSpaceName, reader.getLocalName());
                    writer.writeDefaultNamespace(nameSpaceName);
                    writer.setDefaultNamespace(nameSpaceName);
                }
            }
        } else {
            writer.writeStartElement(reader.getLocalName());
        }

        // add the namespaces
        int count = reader.getNamespaceCount();
        String namespacePrefix;
        for (int i = 0; i < count; i++) {
            namespacePrefix = reader.getNamespacePrefix(i);
            if (namespacePrefix != null && namespacePrefix.length() == 0)
                continue;

            serializeNamespace(namespacePrefix, reader.getNamespaceURI(i), writer);
        }

        // add attributes
        serializeAttributes(reader, writer);

    }
    /**
     * @param reader
     * @param writer
     * @throws XMLStreamException
     */
    protected void serializeElementWithOptions(XMLStreamReader reader, XMLStreamWriter writer) throws XMLStreamException {
    	++nest;
    	boolean brk=false;
    	if(oldNest != nest){
    		if(oldNest < nest) brk = true;
    		oldNest = nest;    		
    	}
    	startElement(writer);
        String prefix = reader.getPrefix();
        String nameSpaceName = reader.getNamespaceURI();
        if (nameSpaceName != null) {
            String writer_prefix = writer.getPrefix(nameSpaceName);
            
            if (writer_prefix != null) {
                if(brk && nest != 1){
                	breakLine(writer, true, true);
                }
                else{
                	breakLine(writer, false, true);
                }

                writer.writeStartElement(nameSpaceName, reader.getLocalName());                
            } else {
                if (prefix != null) {
                    if(brk && nest == 1){
                    	breakLine(writer, false, true);
                    }                    
                    writer.writeStartElement(prefix, reader.getLocalName(), nameSpaceName);
                    writer.writeNamespace(prefix, nameSpaceName);
                    writer.setPrefix(prefix, nameSpaceName);
                } else {
                    if(brk && nest == 1){
                    	breakLine(writer, false, true);
                    }                                    	
                    writer.writeStartElement(nameSpaceName, reader.getLocalName());
                    writer.writeDefaultNamespace(nameSpaceName);
                    writer.setDefaultNamespace(nameSpaceName);
                    if(brk && nest == 1){
                    	breakLine(writer, false, true);
                    }                    
                }
            }
        } else {
            writer.writeStartElement(reader.getLocalName());
        }
 
        // add the namespaces
        int count = reader.getNamespaceCount();
        String namespacePrefix;
        for (int i = 0; i < count; i++) {
            namespacePrefix = reader.getNamespacePrefix(i);
            if (namespacePrefix != null && namespacePrefix.length() == 0)
                continue;

            serializeNamespace(namespacePrefix, reader.getNamespaceURI(i), writer);
        }

        // add attributes
        serializeAttributes(reader, writer);    	
    }
    /**
     * Method serializeEndElement.
     * 
     * @param writer
     * @throws XMLStreamException
     */
    protected void serializeEndElement(XMLStreamWriter writer) throws XMLStreamException {
        writer.writeEndElement();
    }

    /**
     * Method serializeEndElement.
     * 
     * @param writer
     * @throws XMLStreamException
     */
    protected void serializeEndElementWithOptions(XMLStreamWriter writer) throws XMLStreamException {
        --nest;
        if(oldNest > nest+1){
        	nest++;
        	breakLine(writer, false, true);
        	writer.writeEndElement();
        	breakLine(writer, true, false);
        	nest--;
        }
        else{
        	writer.writeEndElement();
        	breakLine(writer, true, false);        	
        }
    }
    /**
     * @param reader
     * @param writer
     * @throws XMLStreamException
     */
    protected void serializeText(XMLStreamReader reader, XMLStreamWriter writer) throws XMLStreamException {
        writer.writeCharacters(reader.getText());
    }

    /**
     * Method serializeCData.
     * 
     * @param reader
     * @param writer
     * @throws XMLStreamException
     */
    protected void serializeCData(XMLStreamReader reader, XMLStreamWriter writer) throws XMLStreamException {
        writer.writeCData(reader.getText());
    }

    /**
     * Method serializeComment.
     * 
     * @param reader
     * @param writer
     * @throws XMLStreamException
     */
    protected void serializeComment(XMLStreamReader reader, XMLStreamWriter writer) throws XMLStreamException {
        writer.writeComment(reader.getText());
    }

    /**
     * @param reader
     * @param writer
     * @throws XMLStreamException
     */
    protected void serializeAttributes(XMLStreamReader reader, XMLStreamWriter writer)
        throws XMLStreamException {
        int count = reader.getAttributeCount();
        String prefix = null;
        String namespaceName = null;
        String writerPrefix = null;
        for (int i = 0; i < count; i++) {
            prefix = reader.getAttributePrefix(i);
            namespaceName = reader.getAttributeNamespace(i);
            if (namespaceName != null) {
                writerPrefix = writer.getNamespaceContext().getPrefix(namespaceName);
            }

            if (!"".equals(namespaceName)) {
                // prefix has already being declared but this particular attrib
                // has a
                // no prefix attached. So use the prefix provided by the writer
                if (writerPrefix != null && (prefix == null || prefix.equals(""))) {
                    writer.writeAttribute(writerPrefix,
                                          namespaceName,
                                          reader.getAttributeLocalName(i),
                                          reader.getAttributeValue(i));

                    // writer prefix is available but different from the current
                    // prefix of the attrib. We should be decalring the new
                    // prefix
                    // as a namespace declaration
                } else if (prefix != null && !"".equals(prefix) && !prefix.equals(writerPrefix)) {
                    writer.writeNamespace(prefix, namespaceName);
                    writer.writeAttribute(prefix, namespaceName, reader.getAttributeLocalName(i), reader
                        .getAttributeValue(i));

                    // prefix is null (or empty), but the namespace name is
                    // valid! it has not
                    // being written previously also. So we need to generate a
                    // prefix
                    // here
                } else if (prefix == null || prefix.equals("")) {
                    prefix = generateUniquePrefix(writer.getNamespaceContext());
                    writer.writeNamespace(prefix, namespaceName);
                    writer.writeAttribute(prefix, namespaceName, reader.getAttributeLocalName(i), reader
                        .getAttributeValue(i));
                } else {
                    writer.writeAttribute(prefix, namespaceName, reader.getAttributeLocalName(i), reader
                        .getAttributeValue(i));
                }
            } else {
                // empty namespace is equal to no namespace!
                writer.writeAttribute(reader.getAttributeLocalName(i), reader.getAttributeValue(i));
            }

        }
    }

    /**
     * Generates a unique namespace prefix that is not in the scope of the NamespaceContext
     * 
     * @param nsCtxt
     * @return string
     */
    private String generateUniquePrefix(NamespaceContext nsCtxt) {
        String prefix = NAMESPACE_PREFIX + namespaceSuffix++;
        // null should be returned if the prefix is not bound!
        while (nsCtxt.getNamespaceURI(prefix) != null) {
            prefix = NAMESPACE_PREFIX + namespaceSuffix++;
        }

        return prefix;
    }

    /**
     * Method serializeNamespace.
     * 
     * @param prefix
     * @param URI
     * @param writer
     * @throws XMLStreamException
     */
    private void serializeNamespace(String prefix, String URI, XMLStreamWriter writer) throws XMLStreamException {
        String prefix1 = writer.getPrefix(URI);
        if (prefix1 == null) {
            writer.writeNamespace(prefix, URI);
            writer.setPrefix(prefix, URI);
        }
    }
    private String lineBreak, indent, margin = null;

    private int nest;
    private int oldNest;

    private void breakLine(XMLStreamWriter writer, boolean breakLine, boolean others) throws XMLStreamException {
        if (options == null || (lineBreak==null && indent==null && margin==null) )
            return;    	
   		if(breakLine) 
   			writer.writeCharacters(lineBreak);

        if (margin != null){
            if(others)
            	writer.writeCharacters(margin);
        }

        if (indent != null && others){
            for (int count = nest; count != 1; --count){//!= 0
                writer.writeCharacters(indent);
            }
        }
    }

    private Map options;

    static private final String STRING_OPTION = "String option";
    
    void startElement(XMLStreamWriter writer) throws XMLStreamException {
        if (options == null)
            return;
        lineBreak = (String) options.get(SDOHelper.XMLOptions.XML_SAVE_LINE_BREAK);
        if (lineBreak == null)
            return;
       	margin = (String) options.get(SDOHelper.XMLOptions.XML_SAVE_MARGIN);
       	indent = (String) options.get(SDOHelper.XMLOptions.XML_SAVE_INDENT);
    }
}
