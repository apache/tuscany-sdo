/**
 *
 *  Copyright 2005 The Apache Software Foundation or its licensors, as applicable.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.tuscany.sdo.util;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.tuscany.sdo.impl.SDOFactoryImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xmi.impl.EMOFResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.ecore.xml.type.internal.XMLCalendar;
import org.eclipse.xsd.util.XSDResourceFactoryImpl;

import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;
import commonj.sdo.helper.TypeHelper;


public final class DataObjectUtil
{
  public static BigDecimal getBigDecimal(Object value)
  {
    if (value instanceof BigDecimal)
    {
      return (BigDecimal)value;
    }

    if (value instanceof BigInteger)
    {
      return new BigDecimal((BigInteger)value);
    }

    if (value instanceof Number)
    {
      return new BigDecimal(((Number)value).doubleValue());
    }

    if (value instanceof String)
    {
      return new BigDecimal((String)value);
    }

    if (value == null)
    {
      return null;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to BigDecimal");
  }

  public static Object getSetValue(Property property, BigDecimal value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    EClassifier eType = eStructuralFeature.getEType();
    if (value == null)
    {
      return eType.getDefaultValue();
    }

    String name = eType.getInstanceClassName();
    if (name == "java.math.BigDecimal")
    {
      return value;
    }

    if (name == "java.math.BigInteger")
    {
      return value.toBigInteger();
    }

    if (name == "java.lang.Byte" || name == "byte")
    {
      return new Byte(value.byteValue());
    }

    if (name == "java.lang.Double" || name == "double")
    {
      return new Double(value.doubleValue());
    }

    if (name == "java.lang.Float" || name == "float")
    {
      return new Float(value.floatValue());
    }

    if (name == "java.lang.Integer" || name == "int")
    {
      return new Integer(value.intValue());
    }

    if (name == "java.lang.Long" || name == "long")
    {
      return new Long(value.longValue());
    }

    if (name == "java.lang.Short" || name == "short")
    {
      return new Short(value.shortValue());
    }

    if (name == "java.lang.String")
    {
      return String.valueOf(value);
    }

    //Instead of throwing an IllegalArgumentException we will pass the value to the property
    return value;
  }

  public static BigInteger getBigInteger(Object value)
  {
    if (value instanceof BigInteger)
    {
      return (BigInteger)value;
    }

    if (value instanceof BigDecimal)
    {
      return ((BigDecimal)value).toBigInteger();
    }

    if (value instanceof Number)
    {
      return BigInteger.valueOf(((Number)value).longValue());
    }

    if (value instanceof String)
    {
      return new BigInteger((String)value);
    }

    if (value instanceof byte[])
    {
      return new BigInteger((byte[])value);
    }

    if (value == null)
    {
      return null;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to BigInteger");
  }

  public static Object getSetValue(Property property, BigInteger value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    EClassifier eType = eStructuralFeature.getEType();
    if (value == null)
    {
      return eType.getDefaultValue();
    }

    String name = eType.getInstanceClassName();
    if (name == "java.math.BigInteger")
    {
      return value;
    }

    if (name == "java.math.BigDecimal")
    {
      return new BigDecimal(value);
    }

    if (name == "java.lang.Byte" || name == "byte")
    {
      return new Byte(value.byteValue());
    }

    if (name == "java.lang.Double" || name == "double")
    {
      return new Double(value.doubleValue());
    }

    if (name == "java.lang.Float" || name == "float")
    {
      return new Float(value.floatValue());
    }

    if (name == "java.lang.Integer" || name == "int")
    {
      return new Integer(value.intValue());
    }

    if (name == "java.lang.Long" || name == "long")
    {
      return new Long(value.longValue());
    }

    if (name == "java.lang.Short" || name == "short")
    {
      return new Short(value.shortValue());
    }

    if (name == "java.lang.String")
    {
      return String.valueOf(value);
    }

    if (name == "byte[]")
    {
      return value.toByteArray();
    }

    //Instead of throwing an IllegalArgumentException we will pass the value to the property
    return value;
  }

  public static boolean getBoolean(Object value)
  {
    if (value instanceof Boolean)
    {
      return ((Boolean)value).booleanValue();
    }

    if (value instanceof String)
    {
      return Boolean.valueOf((String)value).booleanValue();
    }

    if (value == null)
    {
      return false;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to boolean");
  }

  public static Object getSetValue(Property property, boolean value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    String name = eStructuralFeature.getEType().getInstanceClassName();
    if (name == "java.lang.Boolean" || name == "boolean")
    {
      return value ? Boolean.TRUE : Boolean.FALSE;
    }

    if (name == "java.lang.String")
    {
      return String.valueOf(value);
    }

    //Instead of throwing an IllegalArgumentException we will pass the value to the property
    return value ? Boolean.TRUE : Boolean.FALSE;
  }

  public static byte getByte(Object value)
  {
    if (value instanceof Number)
    {
      return ((Number)value).byteValue();
    }

    if (value instanceof String)
    {
      return Byte.parseByte((String)value);
    }

    if (value == null)
    {
      return 0;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to byte");
  }

  public static Object getSetValue(Property property, byte value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    String name = eStructuralFeature.getEType().getInstanceClassName();
    if (name == "java.lang.Byte" || name == "byte")
    {
      return new Byte(value);
    }

    if (name == "java.lang.Double" || name == "double")
    {
      return new Double(value);
    }

    if (name == "java.lang.Float" || name == "float")
    {
      return new Float(value);
    }

    if (name == "java.lang.Integer" || name == "int")
    {
      return new Integer(value);
    }

    if (name == "java.lang.Long" || name == "long")
    {
      return new Long(value);
    }

    if (name == "java.lang.Short" || name == "short")
    {
      return new Short(value);
    }

    if (name == "java.math.BigDecimal")
    {
      return getBigDecimal(new Byte(value));
    }

    if (name == "java.math.BigInteger")
    {
      return getBigInteger(new Byte(value));
    }

    if (name == "java.lang.String")
    {
      return String.valueOf(value);
    }

    //Instead of throwing an IllegalArgumentException we will pass the value to the property
    return new Byte(value);
  }

  public static byte[] getBytes(Object value)
  {
    if (value instanceof byte[])
    {
      return (byte[])value;
    }

    if (value instanceof BigInteger)
    {
      return ((BigInteger)value).toByteArray();
    }

    if (value == null)
    {
      return null;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to byte array");
  }

  public static Object getSetValue(Property property, byte[] value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    EClassifier eType = eStructuralFeature.getEType();
    if (value == null)
    {
      return eType.getDefaultValue();
    }

    String name = eType.getInstanceClassName();
    if (name == "byte[]")
    {
      return value;
    }

    if (name == "java.math.BigInteger")
    {
      return new BigInteger(value);
    }

    //Instead of throwing an IllegalArgumentException we will pass the value to the property
    return value;
  }

  public static char getChar(Object value)
  {
    if (value instanceof Character)
    {
      return ((Character)value).charValue();
    }

    if (value instanceof String)
    {
      return ((String)value).charAt(0);
    }

    if (value == null)
    {
      return 0;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to char");
  }

  public static Object getSetValue(Property property, char value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    String name = eStructuralFeature.getEType().getInstanceClassName();
    if (name == "java.lang.Character" || name == "char")
    {
      return new Character(value);
    }

    if (name == "java.lang.String")
    {
      return String.valueOf(value);
    }

    //Instead of throwing an IllegalArgumentException we will pass the value to the property
    return new Character(value);
  }

  public static Date getDate(Object value)
  {
    if (value instanceof XMLCalendar)
    {
      return ((XMLCalendar)value).getDate();
    }

    if (value instanceof Date)
    {
      return (Date)value;
    }

    if (value instanceof Long)
    {
      return new Date(((Long)value).longValue());
    }

    if (value == null)
    {
      return null;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to Date");
  }

  public static Object getSetValue(Property property, Date value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    EClassifier eType = eStructuralFeature.getEType();
    if (value == null)
    {
      return eType.getDefaultValue();
    }

    String name = eType.getInstanceClassName();
    if (name == "java.lang.Object")
    {
      String typeName = getDateTypeName((EDataType)eType);
      if ("Date".equals(typeName))
      {
        return new XMLCalendar(value, XMLCalendar.DATE);
      }
      if ("DateTime".equals(typeName))
      {
        return new XMLCalendar(value, XMLCalendar.DATETIME);
      }
      // Instead of throwing an IllegalArgumentException we will pass the value to the property
      return value;
    }

    if (name == "java.lang.Long" || name == "long")
    {
      return new Long(value.getTime());
    }
    if (name == "java.lang.String")
    {
      return value.toString();
    }

    // Instead of throwing an IllegalArgumentException we will pass the value to the property
    return value;
  }

  protected static String getDateTypeName(EDataType eDataType)
  {
    String name = eDataType.getName();
    if (("DateTime".equals(name)) || ("Date".equals(name)))
    {
      return name;
    }

    EDataType baseType = ExtendedMetaData.INSTANCE.getBaseType(eDataType);
    if (baseType != null)
    {
      return getDateTypeName(baseType);
    }

    List memberTypes = ExtendedMetaData.INSTANCE.getMemberTypes(eDataType);
    if (!memberTypes.isEmpty())
    {
      for (int i = 0, size = memberTypes.size(); i < size; ++i)
      {
        EDataType memberType = (EDataType)memberTypes.get(i);
        String memberTypeName = getDateTypeName(memberType);
        if (("DateTime".equals(memberTypeName)) || ("Date".equals(memberTypeName)))
        {
          return memberTypeName;
        }
      }
    }

    return "";
  }

  public static double getDouble(Object value)
  {
    if (value instanceof Number)
    {
      return ((Number)value).doubleValue();
    }

    if (value instanceof String)
    {
      return Double.parseDouble((String)value);
    }

    if (value == null)
    {
      return 0;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to double");
  }

  public static Object getSetValue(Property property, double value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    String name = eStructuralFeature.getEType().getInstanceClassName();
    if (name == "java.lang.Byte" || name == "byte")
    {
      return new Byte((byte)value);
    }

    if (name == "java.lang.Double" || name == "double")
    {
      return new Double(value);
    }

    if (name == "java.lang.Float" || name == "float")
    {
      return new Float(value);
    }

    if (name == "java.lang.Integer" || name == "int")
    {
      return new Integer((int)value);
    }

    if (name == "java.lang.Long" || name == "long")
    {
      return new Long((long)value);
    }

    if (name == "java.lang.Short" || name == "short")
    {
      return new Short((short)value);
    }

    if (name == "java.math.BigDecimal")
    {
      return getBigDecimal(new Double(value));
    }

    if (name == "java.math.BigInteger")
    {
      return getBigInteger(new Double(value));
    }

    if (name == "java.lang.String")
    {
      return String.valueOf(value);
    }

    //Instead of throwing an IllegalArgumentException we will pass the value to the property
    return new Double(value);
  }

  public static float getFloat(Object value)
  {
    if (value instanceof Number)
    {
      return ((Number)value).floatValue();
    }

    if (value instanceof String)
    {
      return Float.parseFloat((String)value);
    }

    if (value == null)
    {
      return 0;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to float");
  }

  public static Object getSetValue(Property property, float value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    String name = eStructuralFeature.getEType().getInstanceClassName();
    if (name == "java.lang.Byte" || name == "byte")
    {
      return new Byte((byte)value);
    }

    if (name == "java.lang.Double" || name == "double")
    {
      return new Double(value);
    }

    if (name == "java.lang.Float" || name == "float")
    {
      return new Float(value);
    }

    if (name == "java.lang.Integer" || name == "int")
    {
      return new Integer((int)value);
    }

    if (name == "java.lang.Long" || name == "long")
    {
      return new Long((long)value);
    }

    if (name == "java.lang.Short" || name == "short")
    {
      return new Short((short)value);
    }

    if (name == "java.math.BigDecimal")
    {
      return getBigDecimal(new Float(value));
    }

    if (name == "java.math.BigInteger")
    {
      return getBigInteger(new Float(value));
    }

    if (name == "java.lang.String")
    {
      return String.valueOf(value);
    }

    // Instead of throwing an IllegalArgumentException we will pass the value to the property
    return new Float(value);
  }

  public static int getInt(Object value)
  {
    if (value instanceof Number)
    {
      return ((Number)value).intValue();
    }

    if (value instanceof String)
    {
      return Integer.parseInt((String)value);
    }

    if (value == null)
    {
      return 0;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to int");
  }

  public static Object getSetValue(Property property, int value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    String name = eStructuralFeature.getEType().getInstanceClassName();
    if (name == "java.lang.Byte" || name == "byte")
    {
      return new Byte((byte)value);
    }

    if (name == "java.lang.Double" || name == "double")
    {
      return new Double(value);
    }

    if (name == "java.lang.Float" || name == "float")
    {
      return new Float(value);
    }

    if (name == "java.lang.Integer" || name == "int")
    {
      return new Integer(value);
    }

    if (name == "java.lang.Long" || name == "long")
    {
      return new Long(value);
    }

    if (name == "java.lang.Short" || name == "short")
    {
      return new Short((short)value);
    }

    if (name == "java.math.BigDecimal")
    {
      return getBigDecimal(new Integer(value));
    }

    if (name == "java.math.BigInteger")
    {
      return getBigInteger(new Integer(value));
    }

    if (name == "java.lang.String")
    {
      return String.valueOf(value);
    }

    // Instead of throwing an IllegalArgumentException we will pass the value to the property
    return new Integer(value);
  }

  public static long getLong(Object value)
  {
    if (value instanceof Number)
    {
      return ((Number)value).longValue();
    }

    if (value instanceof String)
    {
      return Long.parseLong((String)value);
    }

    if (value instanceof Date)
    {
      return ((Date)value).getTime();
    }

    if (value == null)
    {
      return 0;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to long");
  }

  public static Object getSetValue(Property property, long value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    String name = eStructuralFeature.getEType().getInstanceClassName();
    if (name == "java.lang.Byte" || name == "byte")
    {
      return new Byte((byte)value);
    }

    if (name == "java.lang.Double" || name == "double")
    {
      return new Double(value);
    }

    if (name == "java.lang.Float" || name == "float")
    {
      return new Float(value);
    }

    if (name == "java.lang.Integer" || name == "int")
    {
      return new Integer((int)value);
    }

    if (name == "java.lang.Long" || name == "long")
    {
      return new Long(value);
    }

    if (name == "java.lang.Short" || name == "short")
    {
      return new Short((short)value);
    }

    if (name == "java.math.BigDecimal")
    {
      return getBigDecimal(new Long(value));
    }

    if (name == "java.math.BigInteger")
    {
      return getBigInteger(new Long(value));
    }

    if (name == "java.lang.String")
    {
      return String.valueOf(value);
    }

    if (name == "java.util.Date")
    {
      return new Date(value);
    }

    // Instead of throwing an IllegalArgumentException we will pass the value to the property
    return new Long(value);
  }

  public static short getShort(Object value)
  {
    if (value instanceof Number)
    {
      return ((Number)value).shortValue();
    }

    if (value instanceof String)
    {
      return Short.parseShort((String)value);
    }

    if (value == null)
    {
      return 0;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to short");
  }

  public static Object getSetValue(Property property, short value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    String name = eStructuralFeature.getEType().getInstanceClassName();
    if (name == "java.lang.Byte" || name == "byte")
    {
      return new Byte((byte)value);
    }

    if (name == "java.lang.Double" || name == "double")
    {
      return new Double(value);
    }

    if (name == "java.lang.Float" || name == "float")
    {
      return new Float(value);
    }

    if (name == "java.lang.Integer" || name == "int")
    {
      return new Integer(value);
    }

    if (name == "java.lang.Long" || name == "long")
    {
      return new Long(value);
    }

    if (name == "java.lang.Short" || name == "short")
    {
      return new Short(value);
    }

    if (name == "java.math.BigDecimal")
    {
      return getBigDecimal(new Short(value));
    }

    if (name == "java.math.BigInteger")
    {
      return getBigInteger(new Short(value));
    }

    if (name == "java.lang.String")
    {
      return String.valueOf(value);
    }

    // Instead of throwing an IllegalArgumentException we will pass the value to the property
    return new Short(value);
  }

  public static String getString(Object value)
  {
    if (value instanceof String)
    {
      return (String)value;
    }

    if (value instanceof Number || value instanceof Boolean || value instanceof Character)
    {
      return String.valueOf(value);
    }

    if (value == null)
    {
      return null;
    }

    throw new IllegalArgumentException("The value of type '" + value.getClass().getName() + "' cannot be converted to String");
  }

  public static Object getSetValue(Property property, String value)
  {
    EStructuralFeature eStructuralFeature = (EStructuralFeature)property;
    EClassifier eType = eStructuralFeature.getEType();
    if (value == null)
    {
      return eType.getDefaultValue();
    }

    String name = eType.getInstanceClassName();
    if (name == "java.lang.String")
    {
      return value;
    }

    if (name == "java.lang.Byte" || name == "byte")
    {
      return Byte.valueOf(value);
    }

    if (name == "java.lang.Double" || name == "double" || name == "java.lang.Number")
    {
      return Double.valueOf(value);
    }

    if (name == "java.lang.Float" || name == "float")
    {
      return new Float(value);
    }

    if (name == "java.lang.Integer" || name == "int")
    {
      return Integer.valueOf(value);
    }

    if (name == "java.lang.Long" || name == "long")
    {
      return Long.valueOf(value);
    }

    if (name == "java.lang.Short" || name == "short")
    {
      return Short.valueOf(value);
    }

    if (name == "java.lang.Character" || name == "char")
    {
      return new Character(value.charAt(0));
    }

    if (name == "java.math.BigDecimal")
    {
      return getBigDecimal(value);
    }

    if (name == "java.math.BigInteger")
    {
      return getBigInteger(value);
    }

    if (name == "java.lang.Boolean" || name == "boolean")
    {
      return Boolean.valueOf(value);
    }

    // Instead of throwing an IllegalArgumentException we will pass the value to the property
    return value;
  }
  
  public static EStructuralFeature getOpenFeature(EObject eObject, int featureID)
  {
    EClass eClass = eObject.eClass();
    int openFeatureCount = featureID - eClass.getFeatureCount();
    Set openFeatureSet = new HashSet();
    for (int i = 0, count = eClass.getEAllStructuralFeatures().size(); i < count; ++i)
    {
      EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(i);
      if (!eStructuralFeature.isDerived() && FeatureMapUtil.isFeatureMap(eStructuralFeature))
      {
        List features = (List)eObject.eGet(eStructuralFeature);
        for (int j = 0, size = features.size(); j < size; ++j)
        {
          FeatureMap.Entry entry = (FeatureMap.Entry)features.get(j);
          EStructuralFeature entryFeature = entry.getEStructuralFeature();
          if (openFeatureSet.add(entryFeature))
          {
            if (--openFeatureCount < 0) return entryFeature;
          }
        }
      }
    }
    throw new IndexOutOfBoundsException();
  }
  
  public static EStructuralFeature getOpenFeature(EObject eObject, String featureName)
  {
    EClass eClass = eObject.eClass();
    Set openFeatureSet = new HashSet();
    for (int i = 0, count = eClass.getEAllStructuralFeatures().size(); i < count; ++i)
    {
      EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(i);
      if (/*!eStructuralFeature.isDerived() && */FeatureMapUtil.isFeatureMap(eStructuralFeature))
      {
        List features = (List)eObject.eGet(eStructuralFeature);
        for (int j = 0, size = features.size(); j < size; ++j)
        {
          FeatureMap.Entry entry = (FeatureMap.Entry)features.get(j);
          EStructuralFeature entryFeature = entry.getEStructuralFeature();
          if (openFeatureSet.add(entryFeature))
          {
            Property property = (Property)entryFeature;
            if (property.getName().equals(featureName)) return entryFeature;

            List aliasNames = property.getAliasNames();
            for (int aliasCount = aliasNames.size(); aliasCount > 0; )
            {
              if (aliasNames.get(--aliasCount).equals(featureName)) return entryFeature;
            }
          }
        }
      }
    }
    throw new IllegalArgumentException("Class '" + eObject.eClass().getName() + "' does not have a feature named '" + featureName + "'");
  }
  
  public static List getAliasNames(EStructuralFeature eStructuralFeature)
  {
    List aliasNames = new ArrayList();
    String xmlName = ExtendedMetaData.INSTANCE.getName(eStructuralFeature);
    if (!xmlName.equals(eStructuralFeature.getName()))
    {
      aliasNames.add(xmlName);
    }
    return aliasNames;
  }

  public static List getAliasNames(EClassifier eClassifier)
  {
    List aliasNames = new ArrayList();
    String xmlName = ExtendedMetaData.INSTANCE.getName(eClassifier);
    if (!xmlName.equals(eClassifier.getName()))
    {
      aliasNames.add(xmlName);
    }
    return aliasNames;
  }

  /**
   * Process the default EMF path and minimal XPath syntax.
   * This design is still under review and construction.
   *
   * Syntax:
   * 
   *<pre>
   * path = /? (step '/')* step
   * step = feature
   *      | feature '.' index_from_0 
   *      | feature '[' index_from_1 ']'
   *      | reference '[' attribute '=' value ']'
   *      | ..
   *      | '@' step
   *</pre>
   * 
   * feature = the name of an attribute or reference
   * attribute = the name of an attribute
   * reference = the name of a reference
   * index = positive integer
   * value = the string value of an attribute
   * leading / begins at the root
   * .. is containing object
   * 
   * features must be multi-valued to use '.' and '[' operations.
   * Only the last step may have an attribute as the feature.
   */
  public static final class Accessor //TODO rewrite this using SDO APIs
  {
    /**
     * Creates an accessor for the path of the object.
     */
    public static Accessor create(EObject eObject, String path)
    {
      Accessor result = pool.get();
      result.init(eObject, path);
      return result;
    }

    /**
     * Only the get and recycle methods should be call; they are the only synchronized methods.
     */
    protected static class Pool extends BasicEList
    {
      protected Accessor[] accessors;

      public Pool()
      {
        super(10);
      }

      protected Object[] newData(int capacity)
      {
        return accessors = new Accessor [capacity];
      }

      /**
       *  Returns a recyled instance or a new instance.
       */
      public synchronized Accessor get()
      {
        if (size > 0)
        {
          return accessors[--size];
        }
        else
        {
          return new Accessor();
        }
      }

      /** Safely gives the accessor back for recycled use.
       */
      public synchronized void recycle(Accessor accessor)
      {
        int minimumCapacity = size + 1;
        if (minimumCapacity > data.length)
        {
          grow(minimumCapacity);
        }
        accessors[size++] = accessor;
      }
    }

    /**
     * A static thread safe pool of Accessors.
     */
    static final Pool pool = new Pool();

    protected static final int NO_INDEX = -1;

    protected EObject eObject;

    protected EStructuralFeature feature;

    protected int index;

    protected Accessor()
    {
    }

    protected Accessor(EObject eObject, String path)
    {
      init(eObject, path);
    }

    protected void init(EObject eObject, String path)
    {
      this.eObject = eObject;

      // This should only be called with a path right now.
      //
      //feature = getType(eObject).getProperty(path).getEStructuralFeature(); 
      //if (feature == null)
      {
        process(path);
      }
      //else
      {
        //index = NO_INDEX;
      }
    }

    public Object get()
    {
      if (feature == null)
      {
        return eObject;
      }
      else
      {
        Object value = eObject.eGet(feature, true);
        if (index >= 0)
        {
          value = ((List)value).get(index);
          if (value instanceof FeatureMap.Entry)
          {
            value = ((FeatureMap.Entry)value).getValue();
          }
        }
        else if (FeatureMapUtil.isFeatureMap(feature))
        {
          value = new BasicSequence((FeatureMap.Internal)value);
        }
        return value;
      }
    }

    public Object getAndRecyle()
    {
      Object result = get();
      pool.recycle(this);
      return result;
    }

    public void set(Object newValue)
    {
      if (index >= 0)
      {
        List list = (List)eObject.eGet(feature, true);
        list.set(index, newValue);
      }
      else
      {
        // EATM newValue = string2Enum(feature, newValue);
        eObject.eSet(feature, newValue);
      }
    }

    public void setAndRecyle(Object newValue)
    {
      set(newValue);
      pool.recycle(this);
    }

    public boolean isSet()
    {
      return eObject.eIsSet(feature);
    }

    public boolean isSetAndRecyle()
    {
      boolean result = isSet();
      pool.recycle(this);
      return result;
    }

    public void unset()
    {
      eObject.eUnset(feature);
    }

    public void unsetAndRecyle()
    {
      unset();
      pool.recycle(this);
    }

    public void recycle()
    {
      pool.recycle(this);
    }

    public EObject getEObject()
    {
      return eObject;
    }

    protected void setEObject(EObject eObject)
    {
      this.eObject = eObject;
      feature = null;
      index = NO_INDEX;
    }

    public EStructuralFeature getEStructuralFeature()
    {
      return feature;
    }

    public Property getProperty()
    {
      return (Property)feature;
    }

    protected void setFeatureName(String name)
    {
      if (name != null)
      {
        feature = (EStructuralFeature)((DataObject)eObject).getProperty(name);
      }
      else
      {
        feature = null;
      }
      index = NO_INDEX;
    }

    protected int getIndex()
    {
      return index;
    }

    protected void setIndex(int index)
    {
      this.index = index;
      if (!FeatureMapUtil.isMany(eObject, feature))
      {
        throw new IndexOutOfBoundsException("Index applies only to multi-valued features.");
      }
    }

    protected void process(String pathString)
    {
      TokenList tokens = new TokenList(pathString.toCharArray());
      String token;
      int size = tokens.size();
      int x = 0;

      if ("/".equals(tokens.peek(0)))
      {
        setEObject(EcoreUtil.getRootContainer(eObject));
        x++;
      }

      for (; x < size; x++)
      {
        token = tokens.peek(x);
        char c = token.charAt(0);
        if ('/' == c)
        {
          setEObject((EObject)get());
        }
        else if ("..".equals(token))
        {
          EObject container = eObject.eContainer();
          if (container == null)
          {
            throw new IllegalArgumentException("No containing object for " + eObject);
          }
          setEObject(container);
        }
        else if ('.' == c)
        {
          x++; // skip .
          token = tokens.peek(x);
          int index = Integer.parseInt(token);
          setIndex(index);
        }
        else if ('[' == c)
        {
          x++; // skip [
          token = tokens.peek(x); // name or index
          char following = tokens.peek(x + 1).charAt(0);
          if ('=' != following)
          {
            int index = Integer.parseInt(token) - 1;
            setIndex(index);
            x++; // skip ]
          }
          else
          {
            x++; // done name
            x++; // skip =
            String attributeValue = tokens.peek(x); // value
            if ("\"".equals(attributeValue))
            {
              x++; // skip "
              attributeValue = tokens.peek(++x);
            }
            x++; // skip ]
            int index = matchingIndex((List)get(), token, attributeValue);
            if (index < 0)
            {
              setEObject(null);
            }
            else
            {
              setIndex(index);
            }
          }
        }
        else if ('@' == c)
        {
          x++; // skip @
        }
        else
        {
          setFeatureName(token);
        }
      }
    }

    protected static int matchingIndex(List eObjects, String attributeName, String attributeValue)
    {
      for (int i = 0, size = eObjects.size(); i < size; i++)
      {
        EObject eObject = (EObject)eObjects.get(i);
        EStructuralFeature feature = (EStructuralFeature)((Type)eObject.eClass()).getProperty(attributeName);
        if (feature != null)
        {
          Object test = eObject.eGet(feature, true);
          if (test != null)
          {
            String testString = EcoreUtil.convertToString((EDataType)feature.getEType(), test);
            if (attributeValue.equals(testString))
            {
              return i;
            }
          }
        }
      }
      return -1;
    }

    protected static class TokenList extends BasicEList
    {
      public TokenList(char[] path)
      {
        super(4);

        int pathLength = path.length;
        StringBuffer token = new StringBuffer();
        char cPrev;
        char c = 0;
        char cNext;
        char stringConstant = 0;
        for (int pos = 0; pos < pathLength; pos++)
        {
          cPrev = c;
          c = path[pos];
          cNext = pos < pathLength - 1 ? path[pos + 1] : 0;

          if (stringConstant != 0)
          {
            if (c == stringConstant)
            {
              endToken(token, true);
              stringConstant = 0;
            }
            else
            {
              token.append(c);
            }
          }
          else
          {
            switch (c)
            {
              case ' ':
              case 0xA:
              case 0xD:
              case 0x9:
                if (cPrev != ' ')
                {
                  endToken(token, false);
                }
                c = ' ';
                break;

              case '"':
              case '\'':
                endToken(token, false);
                stringConstant = c;
                break;

              // double or single tokens
              case '/':
              case ':':
              case '.':
                if (cPrev != c)
                {
                  endToken(token, false);
                }
                token.append(c);
                if (cNext != c)
                {
                  endToken(token, false);
                }
                break;

              // single tokens
              case '*':
              case '@':
              case '[':
              case ']':
              case '(':
              case ')':
              case '|':
                endToken(token, false);
                add(String.valueOf(c));
                break;

              // TODO: < > <= >= + - !=
              case '!':
                endToken(token, false);
                token.append(c);
                break;

              case '=':
                endToken(token, false);
                add(String.valueOf(c));
                break;

              default:
                token.append(c);
            }
          }
        }
        endToken(token, false);
      }

      public String peek()
      {
        return size > 0 ? (String)data[0] : " ";
      }

      public String peek(int index)
      {
        return index < size ? (String)data[index] : " ";
      }

      public TokenList pop()
      {
        remove(0);
        return this;
      }

      public TokenList pop(int count)
      {
        while (count-- > 0)
        {
          remove(count);
        }
        return this;
      }

      protected void endToken(StringBuffer token, boolean includeEmpty)
      {
        if (includeEmpty || token.length() > 0)
        {
          add(token.toString());
        }
        token.setLength(0);
      }

      protected boolean canContainNull()
      {
        return false;
      }

      protected Object[] newData(int capacity)
      {
        return new String [capacity];
      }
    }

    public String toString()
    {
      StringBuffer result = new StringBuffer("Accessor (object:");
      result.append(eObject == null ? "null" : eObject.toString());
      result.append(", feature:");
      result.append(feature == null ? "null" : feature.getName());
      result.append(", index:");
      result.append(index);
      result.append(")");
      return result.toString();
    }
  }
  
  public static Type getType(DataObject dataObject, String namespaceURI, String typeName)
  {
    DataGraph dataGraph = dataObject.getDataGraph();
    if (dataGraph != null)
    {
      return dataGraph.getType(namespaceURI, typeName);
    }
    else
    {
      //TODO think about where else to find the type
      return TypeHelper.INSTANCE.getType(namespaceURI, typeName);
    }
  }

  public static Property getProperty(DataObject dataObject, String propertyName)
  {
    Property property = dataObject.getProperty(propertyName);
    if (property == null)
    {
      throw new IllegalArgumentException("Type '" + dataObject.getType().getName() + "' does not have a property named '" + propertyName + "'");
    }
  
    return property;
  }

  public static Property getProperty(DataObject dataObject, int propertyIndex)
  {
    List typeProperties = dataObject.getType().getProperties();
    
    Property property = propertyIndex < typeProperties.size() ?
        (Property)typeProperties.get(propertyIndex) :
        (Property)dataObject.getInstanceProperties().get(propertyIndex);
    
    //FB maybe should catch bad index exception and throw IllegalArgumentException?
    return property;
  }

  public static Property getContainmentProperty(Property property)
  {
    if (property.isContainment())
    {
      return property;
    }
    throw new IllegalArgumentException("The property '" + property.getName() + "' of '" + property.getContainingType().getName()
      + "' isn't a containment");
  }

  public static DataObject create(Type type)
  {
    return (DataObject)EcoreUtil.create((EClass)type);
  }
  
  public static ResourceSet createResourceSet()
  {
    ResourceSet result = new ResourceSetImpl();
    configureResourceSet(result);
    return result;
  }

  protected static Map registrations;

  protected static Map getRegistrations()
  {
    if (registrations == null)
    {
      Map result = new HashMap();

      if (!(Resource.Factory.Registry.INSTANCE.getFactory(URI.createURI("*.datagraph")) instanceof DataGraphResourceFactoryImpl))
      {
        result.put("datagraph", new DataGraphResourceFactoryImpl());
      }
      if (!(Resource.Factory.Registry.INSTANCE.getFactory(URI.createURI("*.ecore")) instanceof EcoreResourceFactoryImpl))
      {
        result.put("ecore", new EcoreResourceFactoryImpl());
      }

      if (!(Resource.Factory.Registry.INSTANCE.getFactory(URI.createURI("*.emof")) instanceof EMOFResourceFactoryImpl))
      {
        result.put("emof", new EMOFResourceFactoryImpl());
      }

      if (Resource.Factory.Registry.INSTANCE.getFactory(URI.createURI("*.xsd")) == null)
      {
        result.put("xsd", new XSDResourceFactoryImpl());
      }

      //FIXME ClassCastException in XSDHelper.define() if you give it a WSDL file
      // Patch for JIRA TUSCANY-42
      if (Resource.Factory.Registry.INSTANCE.getFactory(URI.createURI("*.wsdl")) == null)
      {
        result.put("wsdl", new XSDResourceFactoryImpl());
      }

      if (Resource.Factory.Registry.INSTANCE.getFactory(URI.createURI("*.*")) == null)
      {
        result.put("*", new XMLResourceFactoryImpl());
      }

      registrations = result;
    }

    return registrations;
  }

  protected static void configureResourceSet(ResourceSet resourceSet)
  {
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().putAll(getRegistrations());
  }

  /**
   * Configure EMF to support the SDO runtime by registering a specialized Ecore factory, SDOEcoreFactory.
   *  This static initializion must run before any SDO metadata is created or loaded.
   *  As long as SDO helper classes (e.g., TypeHelper, XMLHelper, etc.) are accessed though their
   *  corresponding INSTANCE fields (e.g., TypeHelper.INSTANCE), or using the SDOUtil methods (e.g.,
   *  SDOUtil.createTypeHelper(), this will always be the case.
   */
  static
  {
    EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, new EPackage.Descriptor()
      {
        public EPackage getEPackage()
        {
          return EcorePackage.eINSTANCE;
        }

        public EFactory getEFactory()
        {
          return new SDOFactoryImpl.SDOEcoreFactory();
        }
      });
  }
  
  public static void initRuntime()
  {
    // NOOP since init is done during static initialization of this class. See above.
  }
  
}
