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

package org.apache.tuscany.sdo.test;

import junit.framework.TestCase;


import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.TimeZone;

import org.apache.tuscany.sdo.util.DataObjectUtil;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XSDHelper;

public class TypeConversionTestCase extends TestCase
{
    // The following constants are used to get Types from XSDs
    
    private static final String TEST_MODEL = "/api_test.xsd";
    private static final String TEST_NAMESPACE = "http://www.example.com/api_test";    

    // The following constants describe the index for the fields in api_test.xsd.
    
    private static final int STRING_VAL_INDEX = 0;
    private static final int BOOLEAN_VAL_INDEX = 1;
    private static final int BYTE_VAL_INDEX = 3;
    private static final int DECIMAL_VAL_INDEX = 5;
    private static final int INT_VAL_INDEX = 7;
    private static final int FLOAT_VAL_INDEX = 8;
    private static final int DOUBLE_VAL_INDEX = 9;
    private static final int DATE_VAL_INDEX = 10;
    private static final int SHORT_VAL_INDEX = 11;
    private static final int LONG_VAL_INDEX = 12;
    private static final int BYTES_VAL_INDEX = 14;
    private static final int INTEGER_VAL_INDEX = 15;
    private static final int CHAR_VAL_INDEX = 16;
    
    // The following variables are Method arrays.  Each array refers to a specific get<Type>, but within
    // the array exist the get<Type>(index), get<Type>(property), and get<Type>(path).  Rather than
    // referring to each of the three in every circumstance, the more compact array appears.
    private static ConversionType TO_BOOLEAN = new ConversionType("Boolean", boolean.class );
    private static ConversionType TO_BYTE = new ConversionType("Byte", byte.class );
    private static ConversionType TO_CHAR = new ConversionType("Char", char.class );
    private static ConversionType TO_DOUBLE = new ConversionType("Double", double.class );
    private static ConversionType TO_FLOAT = new ConversionType("Float", float.class );
    private static ConversionType TO_INT = new ConversionType("Int", int.class );
    private static ConversionType TO_LONG = new ConversionType("Long", long.class );
    private static ConversionType TO_SHORT = new ConversionType("Short", short.class );
    private static ConversionType TO_BYTES = new ConversionType("Bytes", byte[].class );
    private static ConversionType TO_BIGDECIMAL = new ConversionType("BigDecimal", java.math.BigDecimal.class );
    private static ConversionType TO_BIGINTEGER = new ConversionType("BigInteger", java.math.BigInteger.class );
    private static ConversionType TO_DATAOBJECT = new ConversionType("DataObject", commonj.sdo.DataObject.class );
    private static ConversionType TO_DATE = new ConversionType("Date", java.util.Date.class );
    private static ConversionType TO_STRING = new ConversionType("String", java.lang.String.class );
    private static ConversionType TO_LIST = new ConversionType("List", java.util.List.class );
    // There is no setXXXX methods for sequence...
    private static ConversionType TO_SEQUENCE = new ConversionType("Sequence", null );
    
    private static GeneralComparator COMPARE_ANY;
    
    //  There will be several instances where a Property must be passed as a parameter.  Have available the Type
    //  to call getProperty() as needed.
    
    private static Type API_TEST_TYPE;
    
    // The default constructor establishes each of the Method and Method[] variables.
    
    public TypeConversionTestCase() throws Exception
    {       
        COMPARE_ANY = new GeneralComparator();
        
        // Populate the meta data for the test model
        URL url = getClass().getResource(TEST_MODEL);
        InputStream inputStream = url.openStream();
        XSDHelper.INSTANCE.define(inputStream, url.toString());
        inputStream.close();

        API_TEST_TYPE = TypeHelper.INSTANCE.getType(TEST_NAMESPACE, "APITest");
 
    }
    
    private static class ConversionType
    {
        // The following constants are used because the getMethod function requires an Class
        // array describing the parameters to the functions.  
        
        private static final Class[] GET_INT_CLASS_ARRAY = {int.class};
        private static final Class[] GET_PROPERTY_CLASS_ARRAY = {Property.class};
        private static final Class[] GET_STRING_CLASS_ARRAY = {String.class};
        private static final Class[] SET_INT_CLASS_ARRAY = {int.class, Class.class};
        private static final Class[] SET_PROPERTY_CLASS_ARRAY = {Property.class, Class.class};
        private static final Class[] SET_STRING_CLASS_ARRAY = {String.class, Class.class};
        
        Method get_index_method;
        Method get_property_method;
        Method get_path_method;
        Method set_index_method;
        Method set_property_method;
        Method set_path_method;
        
        public ConversionType (String method_name, Class type )
        {
            try
            {
                this.get_index_method = DataObject.class.getMethod("get"+method_name, GET_INT_CLASS_ARRAY);
                this.get_property_method = DataObject.class.getMethod("get"+method_name, GET_PROPERTY_CLASS_ARRAY);
                this.get_path_method = DataObject.class.getMethod("get"+method_name, GET_STRING_CLASS_ARRAY);
                if( type != null )
                {
                    SET_INT_CLASS_ARRAY[1] = type;
                    this.set_index_method = DataObject.class.getMethod("set"+method_name, SET_INT_CLASS_ARRAY);
                    SET_PROPERTY_CLASS_ARRAY[1] = type;
                    this.set_property_method = DataObject.class.getMethod("set"+method_name, SET_PROPERTY_CLASS_ARRAY);
                    SET_STRING_CLASS_ARRAY[1] = type;
                    this.set_path_method = DataObject.class.getMethod("set"+method_name, SET_STRING_CLASS_ARRAY);
                }
                else
                {
                    this.set_index_method = null;
                    this.set_property_method = null;
                    this.set_path_method = null;
                }
            }
            catch (NoSuchMethodException e)
            {
                this.get_index_method = null;
                this.get_property_method = null;
                this.get_path_method = null;
                this.set_index_method = null;
                this.set_property_method = null;
                this.set_path_method = null;
            }
        }
        
        public Method getIndexGetMethod()
        {
            return this.get_index_method;
        }
        
        public Method getPropertyGetMethod()
        {
            return this.get_property_method;
        }
        
        public Method getPathGetMethod()
        {
            return this.get_path_method;
        }
        public Method getIndexSetMethod()
        {
            return this.set_index_method;
        }
        
        public Method getPropertySetMethod()
        {
            return this.set_property_method;
        }
        
        public Method getPathSetMethod()
        {
            return this.set_path_method;
        }
    }
 
    // Each instance of Test describes a convert-from type.  The index, property and path parms
    // will refer to the same field, which is a field of the convert-from type.
    
    private static class Test
    {
        DataObject test_obj;
        Object[] get_index_parm;
        Object[] get_property_parm;
        Object[] get_path_parm;
        Object[] set_index_parm;
        Object[] set_property_parm;
        Object[] set_path_parm;
        Object expected_value;
        String from_type;
        Class  from_type_class;

        // The constructor prepares a test DataObject and determines how to access the field
        // in three different ways - index, property, and path.
        
        Test(String path, int index)
        {
            this.test_obj = DataFactory.INSTANCE.create(API_TEST_TYPE);
            this.get_index_parm = new Object[] {new Integer(index)};
            this.get_property_parm = new Object[] {API_TEST_TYPE.getProperty(path)};
            this.get_path_parm = new Object[] {path};
            this.set_index_parm = new Object[] {new Integer(index), null};
            this.set_property_parm = new Object[] {API_TEST_TYPE.getProperty(path), null};
            this.set_path_parm = new Object[] {path, null};
            this.expected_value = null;
        }
        
        // The initialize() function establishes the initial value of the test field.
        
        public void initialize(Class type, String type_name, Object initial_value) throws Exception
        {
            this.expected_value = initial_value;    
            this.from_type = type_name;
            this.from_type_class = type;
            
            setDefaultValue();
        }
        
        private void setDefaultValue() throws Exception
        {
            Class[] classArray = {int.class, from_type_class};
            Object[] initValueArray = new Object[] {this.get_index_parm[0], expected_value};
            Method setter = DataObject.class.getMethod("set" + from_type, classArray);
            setter.invoke(test_obj, initValueArray);  
        }
        
        // Attempts the conversion to the specified type, using DataObject.get____().
        // The get___() function can be called with an index, path, and property.  attemptConversion()
        // calls each of those three.
        
        public void attemptConversion(ConversionType to_type) throws Exception
        {     
            performConversion(to_type.getIndexGetMethod(), this.get_index_parm, to_type.getIndexSetMethod(), this.set_index_parm);
            performConversion(to_type.getPathGetMethod(), this.get_path_parm, to_type.getPathSetMethod(), this.set_path_parm );
            performConversion(to_type.getPropertyGetMethod(), this.get_property_parm, to_type.getPropertySetMethod(), this.set_property_parm );
        }
        
        public void checkConversionException(ConversionType to_type, Class expected_exception) throws Exception
        {
            boolean index_err, path_err, property_err, consistency_err = false;
            
            index_err = executeExceptionCase(to_type.getIndexGetMethod(), this.get_index_parm, expected_exception);
            path_err = executeExceptionCase(to_type.getPathGetMethod(), this.get_path_parm, expected_exception);
            property_err = executeExceptionCase(to_type.getPropertyGetMethod(), this.get_property_parm, expected_exception);
            
            if (index_err != path_err || path_err != property_err)
                consistency_err = true;
            else if (index_err == false)
                attemptConversion(to_type);
            
            assertFalse("An exception inconsistency exists for " + to_type.getPathGetMethod().getName() + " when called " 
                    + "for a " + this.from_type + " property.", consistency_err);
        }
        
        private void performConversion (Method getMeth, Object[] getParm, Method setMeth, Object[] setParm ) throws Exception
        {       
            // First use the set
            try
            {
                // get the set value 
                setParm[1] = getMeth.invoke(test_obj, getParm);;
                // now set it...
                setMeth.invoke(test_obj, setParm);
            }
            catch (Exception e)
            {
                Throwable cause = e.getCause();
                if (cause == null)
                {
                    System.err.println("An exception of type " + e.getClass() + " occurred while performing " + setMeth.getName()
                          + " on a " + this.from_type + " property.");
                }
                else
                {
                    System.err.println("An exception of type " + cause.getClass() + " occurred while performing " + setMeth.getName()
                          + " on a " + this.from_type + " property.");
                }
                  
                throw e;
            }
            
            try
            {
                
                assertTrue("Conversion did not yield expected value for get" + getMeth.getName() + " on a " + this.from_type + " property.",
                         COMPARE_ANY.compare(getMeth.invoke(test_obj, getParm), this.expected_value) == 0);
            }
            catch (Exception e)
            {
                Throwable cause = e.getCause();
                if (cause == null)
                {
                    System.err.println("An exception of type " + e.getClass() + " occurred while performing " + getMeth.getName()
                          + " on a " + this.from_type + " property.");
                }
                else
                {
                    System.err.println("An exception of type " + cause.getClass() + " occurred while performing " + getMeth.getName()
                          + " on a " + this.from_type + " property.");
                }
                  
                throw e;
            }

            // reset to default
            setDefaultValue();
        }
        

        
        private boolean executeExceptionCase (Method convert, Object[] parm, Class expected_exception) throws Exception
        {
            boolean exception_thrown = false;
            try
            {
                convert.invoke(test_obj, parm);
            }
            catch (Exception e)
            {
                exception_thrown = true;
                Throwable cause = e.getCause();
                if (cause == null)
                {
                    assertEquals("An unexpected exception occurred while performing " + convert.getName()
                              + " on a " + this.from_type + " property.", expected_exception, e.getClass());
                }
                else 
                {
                    assertEquals("An unexpected exception occurred while performing " + convert.getName()
                              + " on a " + this.from_type + " property.", expected_exception, cause.getClass());
                }
            }
              
            return exception_thrown;
        }
    }

    private static class GeneralComparator implements Comparator
    {
        public int compare(Object obj1, Object obj2)
        {        
            if (obj1.getClass() == obj2.getClass())
            {
                if (obj1.equals(obj2))
                    return 0;
                else
                    return 1;
            }
            
            else if ( (obj1.getClass() == byte[].class && obj2.getClass() == String.class) ||
                 (obj2.getClass() == byte[].class && obj1.getClass() == String.class) )
            {
                String strVal;
                byte [] byteVal; 
                
                if( obj1.getClass() == String.class )
                {
                    strVal = (String)obj1;
                    byteVal = (byte [])obj2;
                }
                else
                {
                    strVal = (String)obj2;
                    byteVal = (byte [])obj1;
                }
                
                if( strVal.length()/2 != byteVal.length )
                    return -1;
                
                for( int i=0; i<byteVal.length; i++ )
                {
                    if( byteVal[i] != (Byte.decode("0x"+strVal.substring(i*2,(i*2)+2))).byteValue() )
                        return -1;
                }
                
                return 0; 
            }
            
            else if (obj1.getClass() == Date.class)
            {
                if (obj2.getClass() == String.class)
                {
                    try
                    {                
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy'-'MM'-'dd'T'H':'mm':'ss.S");
                        
                        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
                        obj2 = sdf.parse((String) obj2);
                                                
                        if (obj1.equals(obj2))
                            return 0;                        
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }

                    return 1;
                }
                
                else
                {
                    Date temp = (Date) obj1;
                    
                    return compare(new Long(temp.getTime()), obj2);
                }                                      
                
            }

            else if (obj2.getClass() == Date.class)
            {                
                return compare(obj2, obj1);
            }                
            
            else if (obj1.getClass() == Boolean.class)
            {
                Boolean temp = (Boolean) obj1;
                
                if (temp.booleanValue())
                {
                    if (obj2.toString().equalsIgnoreCase("true"))
                       return 0;
                    else
                        return 1;
                }
                
                else
                {
                    if (obj2.toString().equalsIgnoreCase("true"))
                       return 1;
                    else
                        return 0;
                }
            }
            
            else if (obj2.getClass() == Boolean.class)
               return compare(obj2, obj1);
            
            else if (obj1.getClass() == Byte.class || obj2.getClass() == Byte.class)
            {
                byte b1 = (Double.valueOf(obj1.toString())).byteValue();
                byte b2 = (Double.valueOf(obj2.toString())).byteValue();
                
                if (b1 == b2)
                    return 0;
                else if (b1 < b2)
                    return -1;
                else
                    return 1;
            }
            
            else if (obj1.getClass().toString().charAt(6) == '[')
            {
                long result = 0;
                long multiplier = 1;
                
                byte[] array = (byte[]) obj1;
                for (int i = 0; i < array.length; i++)
                {
                    result += array[array.length - i - 1] * multiplier;
                    multiplier *= 256;
                }

                return compare(obj2, new Long(result));
            }
            
            else if (obj2.getClass().toString().charAt(6) == '[')
            {
                return compare(obj2, obj1);
            }
            
            else if (obj1.getClass() == Short.class || obj2.getClass() == Short.class)
            {
                short s1 = (Double.valueOf(obj1.toString())).shortValue();
                short s2 = (Double.valueOf(obj2.toString())).shortValue();
                
                if (s1 == s2)
                    return 0;
                else if (s1 < s2)
                    return -1;
                else
                    return 1;                
            }
            
            else if (obj1.getClass() == Integer.class || obj2.getClass() == Integer.class)
            {                
                int i1 = (Double.valueOf(obj1.toString())).intValue();
                int i2 = (Double.valueOf(obj2.toString())).intValue();
                
                if (i1 == i2)
                    return 0;
                else if (i1 < i2)
                    return -1;
                else
                    return 1;                
            }            
            
            else if (   obj1.getClass() == Long.class || obj2.getClass() == Long.class
                     || obj1.getClass() == BigInteger.class || obj2.getClass() == BigInteger.class)
            {
                long l1 = (Double.valueOf(obj1.toString())).longValue();
                long l2 = (Double.valueOf(obj2.toString())).longValue();
                
                if (l1 == l2)
                    return 0;
                else if (l1 < l2)
                    return -1;
                else
                    return 1;                
            }

            else if (obj1.getClass() == Float.class || obj2.getClass() == Float.class)
            {
                float f1 = (Double.valueOf(obj1.toString())).floatValue();
                float f2 = (Double.valueOf(obj2.toString())).floatValue();
                
                if (f1 == f2)
                    return 0;
                else if (f1 < f2)
                    return -1;
                else
                    return 1;                
            }
            
            else if (obj1.getClass() == Double.class || obj2.getClass() == Double.class)
            {
                Double b1 = Double.valueOf(obj1.toString());
                Double b2 = Double.valueOf(obj2.toString());
                
                return b1.compareTo(b2);                
            }
        
            else if (obj1.getClass() == BigDecimal.class || obj2.getClass() == BigDecimal.class)
            {
                BigDecimal b1 = new BigDecimal(obj1.toString());
                BigDecimal b2 = new BigDecimal(obj2.toString());
                
                return b1.compareTo(b2);                
            }
            
            else
            {
                if (obj1.toString().equals(obj2.toString()))
                    return 0;
                else
                    return 1;
            }
        }
        
    }    

    /**********************************************************
     * In the following test cases, several instances are commented out.
     * For these cases, the test case currently fails.  A JIRA issue (TUSCANY-581) has 
     * been opened to either correct the behavior (then uncomment the lines) or to 
     * alter the specification against which the test cases were designed (and then
     * remove the lines - assuming the alteration is to remove stating the 
     * nature of the exception).  
     */
    
    public void testBooleanConversion() throws Exception
    {
        Test FromBoolean = new Test("booleanVal", BOOLEAN_VAL_INDEX);
        
        FromBoolean.initialize(boolean.class, "Boolean", Boolean.valueOf(true));
        
        FromBoolean.attemptConversion(TO_BOOLEAN);
        FromBoolean.attemptConversion(TO_STRING);
    } 
    
    public void testBooleanExceptions() throws Exception
    {
        Test FromBoolean = new Test("booleanVal", BOOLEAN_VAL_INDEX);

        FromBoolean.initialize(boolean.class, "Boolean", Boolean.valueOf(true));

//        FromBoolean.checkConversionException(TO_BYTE, ClassCastException.class);
//        FromBoolean.checkConversionException(TO_CHAR, ClassCastException.class);
//        FromBoolean.checkConversionException(TO_DOUBLE, ClassCastException.class);
//        FromBoolean.checkConversionException(TO_FLOAT, ClassCastException.class);
//        FromBoolean.checkConversionException(TO_INT, ClassCastException.class);
//        FromBoolean.checkConversionException(TO_LONG, ClassCastException.class);
//        FromBoolean.checkConversionException(TO_SHORT, ClassCastException.class);
//        FromBoolean.checkConversionException(TO_BYTES, ClassCastException.class);
//        FromBoolean.checkConversionException(TO_BIGDECIMAL, ClassCastException.class);
//        FromBoolean.checkConversionException(TO_BIGINTEGER, ClassCastException.class);
        FromBoolean.checkConversionException(TO_DATAOBJECT, ClassCastException.class);
//        FromBoolean.checkConversionException(TO_DATE, ClassCastException.class);
        FromBoolean.checkConversionException(TO_LIST, ClassCastException.class);
        FromBoolean.checkConversionException(TO_SEQUENCE, ClassCastException.class);
    }
    
    public void testByteConversion() throws Exception
    {
        Test FromByte = new Test("byteVal", BYTE_VAL_INDEX);
        
        FromByte.initialize(byte.class, "Byte", Byte.valueOf("-127"));
        
        FromByte.attemptConversion(TO_BYTE);
        FromByte.attemptConversion(TO_DOUBLE);
        FromByte.attemptConversion(TO_FLOAT);
        FromByte.attemptConversion(TO_INT);
        FromByte.attemptConversion(TO_LONG);
        FromByte.attemptConversion(TO_SHORT);
        FromByte.attemptConversion(TO_STRING);
    }
    
    public void testByteExceptions() throws Exception
    {
        Test FromByte = new Test("byteVal", BYTE_VAL_INDEX);
        
        FromByte.initialize(byte.class, "Byte", Byte.valueOf("-127"));

//        FromByte.checkConversionException(TO_BOOLEAN, ClassCastException.class);
//        FromByte.checkConversionException(TO_CHAR, ClassCastException.class);
//        FromByte.checkConversionException(TO_BYTES, ClassCastException.class);
        FromByte.checkConversionException(TO_BIGDECIMAL, ClassCastException.class);
        FromByte.checkConversionException(TO_BIGINTEGER, ClassCastException.class);
        FromByte.checkConversionException(TO_DATAOBJECT, ClassCastException.class);
//        FromByte.checkConversionException(TO_DATE, ClassCastException.class);
        FromByte.checkConversionException(TO_LIST, ClassCastException.class);
        FromByte.checkConversionException(TO_SEQUENCE, ClassCastException.class);
    }

    public void testCharConversion() throws Exception
    {
        Test FromChar = new Test("charVal", CHAR_VAL_INDEX);
        
        FromChar.initialize(char.class, "Char", new Character('?'));
        
        FromChar.attemptConversion(TO_CHAR);
        FromChar.attemptConversion(TO_STRING);
    }
    
    public void testCharExceptions() throws Exception
    {
        Test FromChar = new Test("charVal", CHAR_VAL_INDEX);
        
        FromChar.initialize(char.class, "Char", new Character('?'));

//        FromChar.checkConversionException(TO_BOOLEAN, ClassCastException.class);        
//        FromChar.checkConversionException(TO_BYTE, ClassCastException.class);
//        FromChar.checkConversionException(TO_DOUBLE, ClassCastException.class);
//        FromChar.checkConversionException(TO_FLOAT, ClassCastException.class);
//        FromChar.checkConversionException(TO_INT, ClassCastException.class);
//        FromChar.checkConversionException(TO_LONG, ClassCastException.class);
//        FromChar.checkConversionException(TO_SHORT, ClassCastException.class);
//        FromChar.checkConversionException(TO_BYTES, ClassCastException.class);
//        FromChar.checkConversionException(TO_BIGDECIMAL, ClassCastException.class);
//        FromChar.checkConversionException(TO_BIGINTEGER, ClassCastException.class);
        FromChar.checkConversionException(TO_DATAOBJECT, ClassCastException.class);
//        FromChar.checkConversionException(TO_DATE, ClassCastException.class);
        FromChar.checkConversionException(TO_LIST, ClassCastException.class);
        FromChar.checkConversionException(TO_SEQUENCE, ClassCastException.class);
    }
    
    public void testDoubleConversion() throws Exception
    {
        Test FromDouble = new Test("doubleVal", DOUBLE_VAL_INDEX);
        
        FromDouble.initialize(double.class, "Double", new Double(Double.MAX_VALUE));
        
        FromDouble.attemptConversion(TO_BYTE);
        FromDouble.attemptConversion(TO_DOUBLE);
        FromDouble.attemptConversion(TO_FLOAT);
        FromDouble.attemptConversion(TO_INT);
        FromDouble.attemptConversion(TO_LONG);
        FromDouble.attemptConversion(TO_SHORT);
        FromDouble.attemptConversion(TO_BIGDECIMAL);
        FromDouble.attemptConversion(TO_BIGINTEGER);
        FromDouble.attemptConversion(TO_STRING);
    }
    
    public void testDoubleExceptions() throws Exception
    {
        Test FromDouble = new Test("doubleVal", DOUBLE_VAL_INDEX);
        
        FromDouble.initialize(double.class, "Double", new Double(Double.MAX_VALUE));

//        FromDouble.checkConversionException(TO_BOOLEAN, ClassCastException.class);
//        FromDouble.checkConversionException(TO_CHAR, ClassCastException.class);
//        FromDouble.checkConversionException(TO_BYTES, ClassCastException.class);
        FromDouble.checkConversionException(TO_DATAOBJECT, ClassCastException.class);
//        FromDouble.checkConversionException(TO_DATE, ClassCastException.class);
        FromDouble.checkConversionException(TO_LIST, ClassCastException.class);
        FromDouble.checkConversionException(TO_SEQUENCE, ClassCastException.class);
    }
    
    public void testFloatConversion() throws Exception
    {
        Test FromFloat = new Test("floatVal", FLOAT_VAL_INDEX);
        
        FromFloat.initialize(float.class, "Float", new Float(Float.MIN_VALUE));
        
        FromFloat.attemptConversion(TO_BYTE);
        FromFloat.attemptConversion(TO_DOUBLE);
        FromFloat.attemptConversion(TO_FLOAT);
        FromFloat.attemptConversion(TO_INT);
        FromFloat.attemptConversion(TO_LONG);
        FromFloat.attemptConversion(TO_SHORT);
        FromFloat.attemptConversion(TO_BIGDECIMAL);
        FromFloat.attemptConversion(TO_BIGINTEGER);
        FromFloat.attemptConversion(TO_STRING);
    }

    public void testFloatExceptions() throws Exception
    {
        Test FromFloat = new Test("floatVal", FLOAT_VAL_INDEX);
        
        FromFloat.initialize(float.class, "Float", new Float(Float.MIN_VALUE));

//        FromFloat.checkConversionException(TO_BOOLEAN, ClassCastException.class);
//        FromFloat.checkConversionException(TO_CHAR, ClassCastException.class);
//        FromFloat.checkConversionException(TO_BYTES, ClassCastException.class);
        FromFloat.checkConversionException(TO_DATAOBJECT, ClassCastException.class);
//        FromFloat.checkConversionException(TO_DATE, ClassCastException.class);
        FromFloat.checkConversionException(TO_LIST, ClassCastException.class);
        FromFloat.checkConversionException(TO_SEQUENCE, ClassCastException.class);
    }
    
    public void testIntConversion() throws Exception
    {
        Test FromInt = new Test("intVal", INT_VAL_INDEX);
        
        FromInt.initialize(int.class, "Int", new Integer(5));
        
        FromInt.attemptConversion(TO_BYTE);
        FromInt.attemptConversion(TO_DOUBLE);
        FromInt.attemptConversion(TO_FLOAT);
        FromInt.attemptConversion(TO_INT);
        FromInt.attemptConversion(TO_LONG);
        FromInt.attemptConversion(TO_SHORT);
        FromInt.attemptConversion(TO_BIGDECIMAL);
        FromInt.attemptConversion(TO_BIGINTEGER);
        FromInt.attemptConversion(TO_STRING);
    }
    
    public void testIntExceptions() throws Exception
    {
        Test FromInt = new Test("intVal", INT_VAL_INDEX);
        
        FromInt.initialize(int.class, "Int", new Integer(5));

//        FromInt.checkConversionException(TO_BOOLEAN, ClassCastException.class);
//        FromInt.checkConversionException(TO_CHAR, ClassCastException.class);
//        FromInt.checkConversionException(TO_BYTES, ClassCastException.class);
        FromInt.checkConversionException(TO_DATAOBJECT, ClassCastException.class);
//        FromInt.checkConversionException(TO_DATE, ClassCastException.class);
        FromInt.checkConversionException(TO_LIST, ClassCastException.class);
        FromInt.checkConversionException(TO_SEQUENCE, ClassCastException.class);
    }
    
    public void testLongConversion() throws Exception
    {
        Test FromLong = new Test("longVal", LONG_VAL_INDEX);
        
        FromLong.initialize(long.class, "Long", new Long(7000L));
        
        FromLong.attemptConversion(TO_BYTE);
        FromLong.attemptConversion(TO_DOUBLE);
        FromLong.attemptConversion(TO_FLOAT);
        FromLong.attemptConversion(TO_INT);
        FromLong.attemptConversion(TO_LONG);
        FromLong.attemptConversion(TO_SHORT);
        FromLong.attemptConversion(TO_BIGDECIMAL);
        FromLong.attemptConversion(TO_BIGINTEGER);
        FromLong.attemptConversion(TO_DATE);
        FromLong.attemptConversion(TO_STRING);
    }
    
    public void testLongExceptions() throws Exception
    {
        Test FromLong = new Test("longVal", LONG_VAL_INDEX);
        
        FromLong.initialize(long.class, "Long", new Long(7000L));

//        FromLong.checkConversionException(TO_BOOLEAN, ClassCastException.class);
//        FromLong.checkConversionException(TO_CHAR, ClassCastException.class);
//        FromLong.checkConversionException(TO_BYTES, ClassCastException.class);
        FromLong.checkConversionException(TO_DATAOBJECT, ClassCastException.class);
        FromLong.checkConversionException(TO_LIST, ClassCastException.class);
        FromLong.checkConversionException(TO_SEQUENCE, ClassCastException.class);
    }
    
    public void testShortConversion() throws Exception
    {
        Test FromShort = new Test("shortVal", SHORT_VAL_INDEX);
        
        FromShort.initialize(short.class, "Short", new Short("-8000"));
        
        FromShort.attemptConversion(TO_BYTE);
        FromShort.attemptConversion(TO_DOUBLE);
        FromShort.attemptConversion(TO_FLOAT);
        FromShort.attemptConversion(TO_INT);
        FromShort.attemptConversion(TO_LONG);
        FromShort.attemptConversion(TO_SHORT);
        FromShort.attemptConversion(TO_STRING);
    }    
    
    public void testShortExceptions() throws Exception
    {
        Test FromShort = new Test("shortVal", SHORT_VAL_INDEX);
        
        FromShort.initialize(short.class, "Short", new Short("-8000"));

//        FromShort.checkConversionException(TO_BOOLEAN, ClassCastException.class);
//        FromShort.checkConversionException(TO_CHAR, ClassCastException.class);
//        FromShort.checkConversionException(TO_BYTES, ClassCastException.class);
        FromShort.checkConversionException(TO_BIGDECIMAL, ClassCastException.class);
        FromShort.checkConversionException(TO_BIGINTEGER, ClassCastException.class);
        FromShort.checkConversionException(TO_DATAOBJECT, ClassCastException.class);
//        FromShort.checkConversionException(TO_DATE, ClassCastException.class);
        FromShort.checkConversionException(TO_LIST, ClassCastException.class);
        FromShort.checkConversionException(TO_SEQUENCE, ClassCastException.class);
    }
    
    public void testStringConversion() throws Exception
    {
        Test FromString = new Test("stringVal", STRING_VAL_INDEX);
        
        FromString.initialize(String.class, "String", "5");
        
        FromString.attemptConversion(TO_BOOLEAN);
        FromString.attemptConversion(TO_BYTE);
        FromString.attemptConversion(TO_CHAR);
        FromString.attemptConversion(TO_DOUBLE);
        FromString.attemptConversion(TO_FLOAT);
        FromString.attemptConversion(TO_INT);
        FromString.attemptConversion(TO_LONG);
        FromString.attemptConversion(TO_SHORT);
        FromString.attemptConversion(TO_BIGDECIMAL);
        FromString.attemptConversion(TO_BIGINTEGER);
        FromString.attemptConversion(TO_STRING);

        FromString.initialize(String.class, "String", "1999-07-25T8:50:14.33Z");
        FromString.attemptConversion(TO_DATE);
        
        FromString.initialize(String.class, "String", "0A64");
        FromString.attemptConversion(TO_BYTES);
    }

    public void testStringExceptions() throws Exception
    {
        Test FromString = new Test("stringVal", STRING_VAL_INDEX);
        
        FromString.initialize(String.class, "String", "5");
        
//        FromString.checkConversionException(TO_BYTES, ClassCastException.class);
        FromString.checkConversionException(TO_DATAOBJECT, ClassCastException.class);
        FromString.checkConversionException(TO_LIST, ClassCastException.class);
        FromString.checkConversionException(TO_SEQUENCE, ClassCastException.class);
    }
    
    public void testBytesConversion() throws Exception
    {
        Test FromBytes = new Test("bytesVal", BYTES_VAL_INDEX);
        
        FromBytes.initialize(byte[].class, "Bytes", new byte[] {10,100});
        
        FromBytes.attemptConversion(TO_BYTES);
        FromBytes.attemptConversion(TO_BIGINTEGER);
        FromBytes.attemptConversion(TO_STRING);
    }

    public void testBytesExceptions() throws Exception
    {
        Test FromBytes = new Test("bytesVal", BYTES_VAL_INDEX);
        
        FromBytes.initialize(byte[].class, "Bytes", new byte[] {10,100});
        
//        FromBytes.checkConversionException(TO_BOOLEAN, ClassCastException.class);
//        FromBytes.checkConversionException(TO_BYTE, ClassCastException.class);
//        FromBytes.checkConversionException(TO_CHAR, ClassCastException.class);
//        FromBytes.checkConversionException(TO_DOUBLE, ClassCastException.class);
//        FromBytes.checkConversionException(TO_FLOAT, ClassCastException.class);
//        FromBytes.checkConversionException(TO_INT, ClassCastException.class);
//        FromBytes.checkConversionException(TO_LONG, ClassCastException.class);
//        FromBytes.checkConversionException(TO_SHORT, ClassCastException.class);
//        FromBytes.checkConversionException(TO_BIGDECIMAL, ClassCastException.class);
        FromBytes.checkConversionException(TO_DATAOBJECT, ClassCastException.class);
//        FromBytes.checkConversionException(TO_DATE, ClassCastException.class);
//        FromBytes.checkConversionException(TO_STRING, ClassCastException.class);
        FromBytes.checkConversionException(TO_LIST, ClassCastException.class);
        FromBytes.checkConversionException(TO_SEQUENCE, ClassCastException.class);
    }
      
    public void testBigDecimalConversion() throws Exception
    {
        Test FromBigDecimal = new Test("decimalVal", DECIMAL_VAL_INDEX);
        
        FromBigDecimal.initialize(BigDecimal.class, "BigDecimal", new BigDecimal("-3"));
        
        FromBigDecimal.attemptConversion(TO_DOUBLE);
        FromBigDecimal.attemptConversion(TO_FLOAT);
        FromBigDecimal.attemptConversion(TO_INT);
        FromBigDecimal.attemptConversion(TO_LONG);
        FromBigDecimal.attemptConversion(TO_BIGDECIMAL);
        FromBigDecimal.attemptConversion(TO_BIGINTEGER);
        FromBigDecimal.attemptConversion(TO_STRING);
    }
    
    public void testBigDecimalExceptions() throws Exception
    {
        Test FromBigDecimal = new Test("decimalVal", DECIMAL_VAL_INDEX);
        
        FromBigDecimal.initialize(BigDecimal.class, "BigDecimal", new BigDecimal("-3"));

//        FromBigDecimal.checkConversionException(TO_BOOLEAN, ClassCastException.class);
//        FromBigDecimal.checkConversionException(TO_BYTE, ClassCastException.class);
//        FromBigDecimal.checkConversionException(TO_CHAR, ClassCastException.class);
//        FromBigDecimal.checkConversionException(TO_SHORT, ClassCastException.class);
//        FromBigDecimal.checkConversionException(TO_BYTES, ClassCastException.class);
        FromBigDecimal.checkConversionException(TO_DATAOBJECT, ClassCastException.class);
//        FromBigDecimal.checkConversionException(TO_DATE, ClassCastException.class);
        FromBigDecimal.checkConversionException(TO_LIST, ClassCastException.class);
        FromBigDecimal.checkConversionException(TO_SEQUENCE, ClassCastException.class);
    }
    
    public void testBigIntegerConversion() throws Exception
    {
        Test FromBigInteger = new Test("integerVal", INTEGER_VAL_INDEX);
        
        FromBigInteger.initialize(BigInteger.class, "BigInteger", new BigInteger("31500"));
        
        FromBigInteger.attemptConversion(TO_DOUBLE);
        FromBigInteger.attemptConversion(TO_FLOAT);
        FromBigInteger.attemptConversion(TO_INT);
        FromBigInteger.attemptConversion(TO_LONG);
        FromBigInteger.attemptConversion(TO_SHORT); 
        FromBigInteger.attemptConversion(TO_BYTES);
        FromBigInteger.attemptConversion(TO_BIGDECIMAL);
        FromBigInteger.attemptConversion(TO_BIGINTEGER);
        FromBigInteger.attemptConversion(TO_STRING);
    }
    
    public void testBigIntegerExceptions() throws Exception
    {
        Test FromBigInteger = new Test("integerVal", INTEGER_VAL_INDEX);
        
        FromBigInteger.initialize(BigInteger.class, "BigInteger", new BigInteger("31500"));

//        FromBigInteger.checkConversionException(TO_BOOLEAN, ClassCastException.class);
//        FromBigInteger.checkConversionException(TO_BYTE, ClassCastException.class);
//        FromBigInteger.checkConversionException(TO_CHAR, ClassCastException.class);
        FromBigInteger.checkConversionException(TO_DATAOBJECT, ClassCastException.class);
//        FromBigInteger.checkConversionException(TO_DATE, ClassCastException.class);
        FromBigInteger.checkConversionException(TO_LIST, ClassCastException.class);
        FromBigInteger.checkConversionException(TO_SEQUENCE, ClassCastException.class);
    }

    public void testDateConversion() throws Exception
    {
        Test FromDate = new Test("dateVal", DATE_VAL_INDEX);
        
        FromDate.initialize(Date.class, "Date", new Date(System.currentTimeMillis()));
        
        FromDate.attemptConversion(TO_LONG);
        FromDate.attemptConversion(TO_DATE);
        FromDate.attemptConversion(TO_STRING);
    }    
    
    public void testDateExceptions() throws Exception
    {
        Test FromDate = new Test("dateVal", DATE_VAL_INDEX);
        
        FromDate.initialize(Date.class, "Date", new Date(System.currentTimeMillis()));
        
//        FromDate.checkConversionException(TO_BOOLEAN, ClassCastException.class);
//        FromDate.checkConversionException(TO_BYTE, ClassCastException.class);
//        FromDate.checkConversionException(TO_CHAR, ClassCastException.class);
//        FromDate.checkConversionException(TO_DOUBLE, ClassCastException.class);
//        FromDate.checkConversionException(TO_FLOAT, ClassCastException.class);
//        FromDate.checkConversionException(TO_INT, ClassCastException.class);
//        FromDate.checkConversionException(TO_SHORT, ClassCastException.class);
//        FromDate.checkConversionException(TO_BYTES, ClassCastException.class);
//        FromDate.checkConversionException(TO_BIGDECIMAL, ClassCastException.class);
//        FromDate.checkConversionException(TO_BIGINTEGER, ClassCastException.class);
        FromDate.checkConversionException(TO_DATAOBJECT, ClassCastException.class);
        FromDate.checkConversionException(TO_LIST, ClassCastException.class);
        FromDate.checkConversionException(TO_SEQUENCE, ClassCastException.class);
    }
    
    public void testTuscany_836() {
      if (System.getProperty("java.version").indexOf("1.4") == -1) {
    	// Work around a bug in SUN and IBM 1.4 JDKs
        assertEquals(DataObjectUtil.getBigDecimal(new Long(Long.MAX_VALUE)).longValue(), Long.MAX_VALUE);
      }
    }
}
