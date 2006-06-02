/**
 * 
 */
package org.apache.tuscany.sdo.util.resource;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamReader;

interface XMLFragmentStreamReader extends XMLStreamReader {

    // this will help to handle Text within the current element.
    // user should pass the element text to the property list as this
    // ELEMENT_TEXT as the key. This key deliberately has a space in it
    // so that it is not a valid XML name
    static final String ELEMENT_TEXT = "Element Text";

    /**
     * Extra method to query the state of the pullparser
     * @return
     */
     boolean isEndOfFragment();

    /**
     * add the parent namespace context to this parser
     */
     void setParentNamespaceContext(NamespaceContext nsContext);

    /**
     * Initiate the parser - this will do whatever the needed
     * tasks to initiate the parser and must be called before
     * attempting any specific parsing using this parser
     */
     void init();
}
