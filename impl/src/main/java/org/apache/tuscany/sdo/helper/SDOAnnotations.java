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
