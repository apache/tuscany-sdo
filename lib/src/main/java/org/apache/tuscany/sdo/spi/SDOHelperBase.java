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
package org.apache.tuscany.sdo.spi;

/**
 * Base class for an implementation of the SDOHelper and SDOHelper.MetaDataBuilder interfaces.
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tuscany.sdo.api.SDOHelper;
import org.apache.tuscany.sdo.api.SDOUtil;
import org.apache.tuscany.sdo.lib.SDOObjectInputStream;
import org.apache.tuscany.sdo.lib.SDOObjectOutputStream;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.helper.HelperContext;

public abstract class SDOHelperBase implements SDOHelper, SDOHelper.MetaDataBuilder
{
  public HelperContext createHelperContext()
  {
    return createHelperContext(false);
  }
  
  public ObjectInputStream createObjectInputStream(InputStream inputStream, HelperContext helperContext) throws IOException
  {
    return new SDOObjectInputStream(inputStream, helperContext);
  }
  
  public ObjectOutputStream createObjectOutputStream(OutputStream outputStream, HelperContext helperContext) throws IOException
  {
    return new SDOObjectOutputStream(outputStream, helperContext);
  }
  
  public String getXPath(DataObject dataObject)
  {
    StringBuffer path = getXPath(dataObject, new StringBuffer(), dataObject);
    return path.toString();
  }

  protected StringBuffer getXPath(DataObject dataObject, StringBuffer path, DataObject root)
  {
    DataObject container = dataObject.getContainer();
    if (container == null)
      return path;

    if (container == root)
      throw new IllegalStateException("There is a cycle in the containment hierarchy of " + root);

    boolean first = path.length() == 0;
    Property property = dataObject.getContainmentProperty();
    if (SDOUtil.isMany(property, dataObject))
    {
      List list = container.getList(property);
      int pos = list.indexOf(dataObject);
      path.insert(0, property.getName() + "." + pos + (first ? "" : "/"));
    }
    else
    {
      path.insert(0, property.getName() + (first ? "" : "/"));
    }

    return getXPath(container, path, root);
  }

  public MetaDataBuilder getMetaDataBuilder()
  {
    return this;
  }
  
  //Java instance class to SDO mappings (section 8.1 of the SDO spec)
  protected static Map javaToSdoMappings = new HashMap();
  static {
    javaToSdoMappings.put(boolean.class, "Boolean");
    javaToSdoMappings.put(byte.class, "Byte");
    javaToSdoMappings.put(char.class, "Character");
    javaToSdoMappings.put(Date.class, "Date");
    javaToSdoMappings.put(BigDecimal.class, "Decimal");
    javaToSdoMappings.put(double.class, "Double");
    javaToSdoMappings.put(float.class, "Float");
    javaToSdoMappings.put(int.class, "Int");
    javaToSdoMappings.put(BigInteger.class, "Integer");
    javaToSdoMappings.put(long.class, "Long");
    javaToSdoMappings.put(Object.class, "Object");
    javaToSdoMappings.put(short.class, "Short");
    javaToSdoMappings.put(String.class, "String");
    javaToSdoMappings.put(Boolean.class, "BooleanObject");
    javaToSdoMappings.put(Byte.class, "ByteObject");
    javaToSdoMappings.put(Character.class, "CharacterObject");
    javaToSdoMappings.put(Double.class, "DoubleObject");
    javaToSdoMappings.put(Float.class, "FloatObject");
    javaToSdoMappings.put(Integer.class, "IntObject");
    javaToSdoMappings.put(Long.class, "LongObject");
    javaToSdoMappings.put(Short.class, "ShortObject");
  }

  //XSD to SDO mappings (section 9.4 of the SDO spec)
  protected static Map xsdToSdoMappings = new HashMap();
  static {
    xsdToSdoMappings.put("anySimpleType", "Object");
    xsdToSdoMappings.put("anyType", "DataObject");
    xsdToSdoMappings.put("anyURI", "URI");
    xsdToSdoMappings.put("base64Binary", "Bytes");
    xsdToSdoMappings.put("boolean", "Boolean");
    xsdToSdoMappings.put("byte", "Byte");
    xsdToSdoMappings.put("date", "YearMonthDay");
    xsdToSdoMappings.put("dateTime", "DateTime");
    xsdToSdoMappings.put("decimal", "Decimal");
    xsdToSdoMappings.put("double", "Double");
    xsdToSdoMappings.put("duration", "Duration");
    xsdToSdoMappings.put("ENTITIES", "Strings");
    xsdToSdoMappings.put("ENTITY", "String");
    xsdToSdoMappings.put("float", "Float");
    xsdToSdoMappings.put("gDay", "Day");
    xsdToSdoMappings.put("gMonth", "Month");
    xsdToSdoMappings.put("gMonthDay", "MonthDay");
    xsdToSdoMappings.put("gYear", "Year");
    xsdToSdoMappings.put("gYearMonth", "YearMonth");
    xsdToSdoMappings.put("hexBinary", "Bytes");
    xsdToSdoMappings.put("ID","String");
    xsdToSdoMappings.put("IDREF","String");
    xsdToSdoMappings.put("IDREFS","Strings");
    xsdToSdoMappings.put("int","Int");
    xsdToSdoMappings.put("integer","Integer");
    xsdToSdoMappings.put("language","String");
    xsdToSdoMappings.put("long","Long");
    xsdToSdoMappings.put("Name","String");
    xsdToSdoMappings.put("NCName","String");
    xsdToSdoMappings.put("negativeInteger","Integer");
    xsdToSdoMappings.put("NMTOKEN","String");
    xsdToSdoMappings.put("NMTOKENS","Strings");
    xsdToSdoMappings.put("nonNegativeInteger","Integer");
    xsdToSdoMappings.put("nonPositiveInteger","Integer");
    xsdToSdoMappings.put("normalizedString","String");
    xsdToSdoMappings.put("NOTATION","String");
    xsdToSdoMappings.put("positiveInteger","Integer");
    xsdToSdoMappings.put("QName","URI");
    xsdToSdoMappings.put("short","Short");
    xsdToSdoMappings.put("string","String");
    xsdToSdoMappings.put("time","Time");
    xsdToSdoMappings.put("token","String");
    xsdToSdoMappings.put("unsignedByte","Short");
    xsdToSdoMappings.put("unsignedInt","Long");
    xsdToSdoMappings.put("unsignedLong","Integer");
    xsdToSdoMappings.put("unsignedShort","Int");
  }
  
}
