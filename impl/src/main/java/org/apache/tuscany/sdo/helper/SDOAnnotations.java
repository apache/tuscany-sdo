package org.apache.tuscany.sdo.helper;

public class SDOAnnotations 
{
    public static final String COLON = ":";
    public static final String COMMONJ_SDO_NS           = "commonj.sdo";
    public static final String COMMONJ_SDO_NS_PREFIX    = "sdo";
    public static final String SDO_JAVA_NS              = "commonj.sdo/java";
    public static final String SDO_JAVA_NS_PREFIX       = "sdoJava";
    
    public static final String JAVA_PACKAGE = SDO_JAVA_NS_PREFIX + COLON + "package";
    public static final String ALIAS_NAMES = COMMONJ_SDO_NS_PREFIX + COLON + "aliasName";
    public static final String READ_ONLY = COMMONJ_SDO_NS_PREFIX + COLON + "readOnly";
    public static final String INSTANCE_CLASS = SDO_JAVA_NS_PREFIX + COLON + "instanceClass";
    public static final String ABSTRACT_TYPE = "abstract";
    public static final String PROPERTY_TYPE = COMMONJ_SDO_NS_PREFIX + COLON + "propertyType";
    public static final String OPPOSITE_PROPERTY = COMMONJ_SDO_NS_PREFIX + COLON + "oppositeProperty";
    
    
    //used by the annotations map to uniquely identify schema elements that need to be annotated
    //and to store the corresponding annotations in a map
    public static final String SCHEMA = "schema";
    public static final String ELEMENT = "element";
    public static final String COMPLEX_TYPE = "complexType";
    public static final String SIMPLE_TYPE = "simpleType";
    public static final String ATTRIBUTE = "attribute";
    
    public static String makeAnnotationMapKey(String namespace, String schemaElementType, String nameAttrValue)
    {
        return namespace + schemaElementType + nameAttrValue;
    }
}
