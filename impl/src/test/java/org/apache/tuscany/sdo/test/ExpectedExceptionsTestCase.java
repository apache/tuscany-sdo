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

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.apache.tuscany.sdo.util.SDOUtil;

import com.example.ExpectedException.ExpectedExceptionFactory;

import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Sequence;
import commonj.sdo.Type;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;

import junit.framework.TestCase;

/**
 * Verifies the Exception related behavior which is explicitly identified in
 * the 2.1 SDO Specification.
 */
public class ExpectedExceptionsTestCase extends TestCase {

    private static final String TEST_URI = "http://example.com/ExpectedException";
    private static final String TEST_TYPE_NAME = "ExpectedExceptionType";
    private static final String SEQ_TYPE_NAME = "SequenceReadOnlyType";   
    private static boolean typeDefined = false;
    private static HelperContext helperContext;
    private static DataObject testDO;
    private static DataObject seqDO;

    /**
     * Verifies the following statement.
     * Get<T>(String path) will not throw exceptions other than ClassCastException
     * if it is impossible to convert between the actual and expected types.
     * Note:  This test case will not be implmented because it is already covered
     * by testCannnotConvertClassCastException.
     */

    public void testGetTStringClassCastExceptionOnly()  {
        // This test case will not be implemented.
    }

    /**
     * Verifies the following statement.
     * get<T>(Property property) throws an IllegalArgumentException when
     * getInstanceProperties().contains(property) == false.
     */
    public void testGetViaPropertyIllegalArgumentException() {
        DataObject invalidPropDO = helperContext.getDataFactory().create(TEST_URI, SEQ_TYPE_NAME);
        Property invalidProp = invalidPropDO.getInstanceProperty("uniqueName");

        try {
            testDO.get(invalidProp);
            fail("get(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("get(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getBoolean(invalidProp);
            fail("getBoolean(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getBoolean(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getByte(invalidProp);
            fail("getByte(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getByte(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getChar(invalidProp);
            fail("getChar(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getChar(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getDouble(invalidProp);
            fail("getDouble(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getDouble(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getFloat(invalidProp);
            fail("getFloat(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getFloat(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getInt(invalidProp);
            fail("getInt(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getInt(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getLong(invalidProp);
            fail("getLong(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getLong(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getShort(invalidProp);
            fail("getShort(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getShort(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getBytes(invalidProp);
            fail("getBytes(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getBytes(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getBigDecimal(invalidProp);
            fail("getBigDecimal(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getBigDecimal(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getBigInteger(invalidProp);
            fail("getBigInteger(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getBigInteger(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getDataObject(invalidProp);
            fail("getDataObject(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getDataObject(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getDate(invalidProp);
            fail("getDate(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getDate(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getString(invalidProp);
            fail("getString(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getString(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getList(invalidProp);
            fail("getList(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(propert)== false.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getList(Property property) should throw an IllegalArgumentException when getInstanceProperties().contains(property)== false.  " + e.getClass().getName() + " was thrown.");
        }
    }

    /**
     * Verfies the following statement.
     * get<T>(int propertyIndex) throws an IllegalArgumentException when
     * propertIndex <0 or >= getInstanceProerties().size()
     */
    public void testGetViaIndexIllegalArgumentException() {
        int numProps = testDO.getInstanceProperties().size();

        try {
            testDO.get(-1);
            fail("get(-1) should throw an IllegalArgumentException.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("get(-1) should throw an IllegalArgumentException.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getBoolean(-1);
            fail("getBoolean(-1) should throw an IllegalArgumentException.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getBoolean(-1) should throw an IllegalArgumentException.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getByte(-1);
            fail("getByte(-1) should throw an IllegalArgumentException.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getByte(-1) should throw an IllegalArgumentException.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getChar(-1);
            fail("getChar(-1) should throw an IllegalArgumentException.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getChar(-1) should throw an IllegalArgumentException.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getDouble(-1);
            fail("getDouble(-1) should throw an IllegalArgumentException.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getDouble(-1) should throw an IllegalArgumentException.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getFloat(-1);
            fail("getFloat(-1) should throw an IllegalArgumentException.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getFloat(-1) should throw an IllegalArgumentException.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getInt(-1);
            fail("getInt(-1) should throw an IllegalArgumentException.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getInt(-1) should throw an IllegalArgumentException.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getLong(-1);
            fail("getLong(-1) should throw an IllegalArgumentException.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getLong(-1) should throw an IllegalArgumentException.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getShort(-1);
            fail("getShort(-1) should throw an IllegalArgumentException.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getShort(-1) should throw an IllegalArgumentException.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getBytes(-1);
            fail("getBytes(-1) should throw an IllegalArgumentException.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getBytes(-1) should throw an IllegalArgumentException.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getBigDecimal(-1);
            fail("getBigDecimal(-1) should throw an IllegalArgumentException.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getBigDecimal(-1) should throw an IllegalArgumentException.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getBigInteger(-1);
            fail("getBigInteger(-1) should throw an IllegalArgumentException.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getBigInteger(-1) should throw an IllegalArgumentException.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getDataObject(-1);
            fail("getDataObject(-1) should throw an IllegalArgumentException.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getDataObject(-1) should throw an IllegalArgumentException.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getDate(-1);
            fail("getDate(-1) should throw an IllegalArgumentException.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getDate(-1) should throw an IllegalArgumentException.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getString(-1);
            fail("getString(-1) should throw an IllegalArgumentException.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getString(-1) should throw an IllegalArgumentException.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getList(-1);
            fail("getList(-1) should throw an IllegalArgumentException.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getList(-1) should throw an IllegalArgumentException.  " + e.getClass().getName() + " was thrown.");
        }

        try {
            testDO.get(numProps);
            fail("get(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("get(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getBoolean(numProps);
            fail("getBoolean(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getBoolean(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getByte(numProps);
            fail("getByte(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getByte(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getChar(numProps);
            fail("getChar(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getChar(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getDouble(numProps);
            fail("getDouble(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getDouble(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getFloat(numProps);
            fail("getFloat(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getFloat(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getInt(numProps);
            fail("getInt(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getInt(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getLong(numProps);
            fail("getLong(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getLong(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getShort(numProps);
            fail("getShort(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getShort(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getBytes(numProps);
            fail("getBytes(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getBytes(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getBigDecimal(numProps);
            fail("getBigDecimal(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getBigDecimal(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getBigInteger(numProps);
            fail("getBigInteger(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getBigInteger(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getDataObject(numProps);
            fail("getDataObject(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getDataObject(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getDate(numProps);
            fail("getDate(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getDate(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getString(numProps);
            fail("getString(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getString(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getList(numProps);
            fail("getList(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getList(int) should throw an IllegalArgumentException when int >= getInstanceProperties.size().  " + e.getClass().getName() + " was thrown.");
        }
    }

    /**
     * Verifies the following statement.
     * Using an Index out of range (index < 0 or >= getList(Property property).size())
     * will result in an IndexOutOfBoundsException.
     */
    public void testListIndexOutOfBoundsException() {
        List list = testDO.getList("listVal");

// Not fixed in TUSCANY-578
//        try {
//            list.get(-1);
//            fail("list.get(-1) should throw an IndexOutOfBoundsException.  No Exception was thrown.");
//        } catch (IndexOutOfBoundsException e) {
//            // Success - do nothing
//        } catch (Exception e) {
//            fail("list.get(-1) should throw an IndexOutOfBoundsException.  " + e.getClass().getName() + " was thrown.");
//        }
//        try {
//            list.get(list.size());
//            fail("list.get(int) should throw an IndexOutOfBoundsException when int >= list.size().  No Exception was thrown.");
//        } catch (IndexOutOfBoundsException e) {
//            // Success - do nothing
//        } catch (Exception e) {
//            fail("list.get(int) should throw an IndexOutOfBoundsException when int >= list.size().  " + e.getClass().getName() + " was thrown.");
//        }
//        try {
//            list.remove(-1);
//            fail("list.remove(-1) should throw an IndexOutOfBoundsException.  No Exception was thrown.");
//        } catch (IndexOutOfBoundsException e) {
//            // Success - do nothing
//        } catch (Exception e) {
//            fail("list.remove(-1) should throw an IndexOutOfBoundsException.  " + e.getClass().getName() + " was thrown.");
//        }
        try {
            list.remove(list.size());
            fail("list.remove(int) should throw an IndexOutOfBoundsException when int >= list.size().  No Exception was thrown.");
        } catch (IndexOutOfBoundsException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("list.remove(int) should throw an IndexOutOfBoundsException when int >= list.size().  " + e.getClass().getName() + " was thrown.");
        }  
    }

    /**
     * Verifies the following statement.
     * Modification of a read-only property results in UnsupportedOperationException.
     * This test case is for modifications done through the DataObject API.
     */
    public void testModifyReadOnlyUnsupportedOperationException() {
        Property readOnlyProp = testDO.getInstanceProperty("readOnlyVal");
        List properties = testDO.getInstanceProperties();
        Property currProp;
        int readOnlyIndex = -1, i = 0, size = properties.size();

        // Verify the precondition
        assertTrue("readOnlyVal should be read-only.", readOnlyProp.isReadOnly());

        while (readOnlyIndex < 0 && i < size) {
            currProp = (Property) properties.get(i);
            if (currProp.equals(readOnlyProp))
                readOnlyIndex = i;
            i++;
        }

        try {
            testDO.set("readOnlyVal", "NewValue");
            fail("DataObject.set(string, value) should throw an UnsupportedOperationException when the Property represented by string is read-only.  No Exception was thrown.");
        } catch (UnsupportedOperationException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("DataObject.set(string, value) should throw an UnsupportedOperationException when the Property represented by string is read-only.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.set(readOnlyProp, "NewValue");
            System.out.println("propname =" + readOnlyProp.getName());
            fail("DataObject.set(property, value) should throw an UnsupportedOperationException when the Property represented by property is read-only.  No Exception was thrown.");
        } catch (UnsupportedOperationException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("DataObject.set(property, value) should throw an UnsupportedOperationException when the Property represented by property is read-only.  " + e.getClass().getName() + " was thrown.");
        }
        assertTrue("The test case could not procede because the index of the read only Property was not found.", readOnlyIndex > -1);
        try {
            testDO.set(readOnlyIndex, "NewValue");
            fail("DataObject.set(index, value) should throw an UnsupportedOperationException when the Property represented by index is read-only.  No Exception was thrown.");
        } catch (UnsupportedOperationException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("DataObject.set(index, value) should throw an UnsupportedOperationException when the Property represented by index is read-only.  " + e.getClass().getName() + " was thrown.");
        }

        try {
            testDO.unset("readOnlyVal");
            fail("DataObject.unset(string) should throw an UnsupportedOperationException when the Property represented by string is read-only.  No Exception was thrown.");
        } catch (UnsupportedOperationException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("DataObject.unset(string) should throw an UnsupportedOperationException when the Property represented by string is read-only.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.unset(readOnlyProp);
            fail("DataObject.unset(property) should throw an UnsupportedOperationException when the Property represented by property is read-only.  No Exception was thrown.");
        } catch (UnsupportedOperationException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("DataObject.unset(property) should throw an UnsupportedOperationException when the Property represented by property is read-only.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.unset(readOnlyIndex);
            fail("DataObject.unset(index) should throw an UnsupportedOperationException when the Property represented by index is read-only.  No Exception was thrown.");
        } catch (UnsupportedOperationException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("DataObject.unset(index) should throw an UnsupportedOperationException when the Property represented by index is read-only.  " + e.getClass().getName() + " was thrown.");
        }
    }

    /**
     * Verifies the following statement.
     * Modification of a read-only property results in UnsupportedOperationException.
     * This test case is for modification done through the List API.
     */
    public void testModifyReadOnlyUnsupportedOperationExceptionList() {
        Property readOnlyProp = testDO.getInstanceProperty("readOnlyVal");
        List properties = testDO.getInstanceProperties();
        Property currProp;
        int readOnlyIndex = -1, i = 0, size = properties.size();

        while (readOnlyIndex < 0 && i < size) {
            currProp = (Property) properties.get(i);
            if (currProp.equals(readOnlyProp))
                readOnlyIndex = i;
            i++;
        }

// Not fixed in TUSCANY-578
//        try {
//            List temp = testDO.getList("readOnlyListVal");
//            temp.add("String to add.");
//            fail("DataObject.getList(path).add(value) should throw an UnsupportedOperationException when the Property represented by path is read-only.  No Exception was thrown.");
//        } catch (UnsupportedOperationException e) {
//            // Success - do nothing
//        } catch (Exception e) {
//            fail("DataObject.getList(path).add(value) should throw an IllegalArgumentException when the Property represented by path is read-only.  " + e.getClass().getName() + " was thrown.");
//        }
//        try {
//            Sequence temp = testDO.getSequence();
//            temp.add("readOnlyListVal", "String to add.");
//            fail("DataObject.getSequence().add(path, value) should throw an UnsupportedOperationException when the Property represtend by path is read-only.  No Exception was thrown.");
//        } catch (UnsupportedOperationException e) {
//            // Success - do nothing
//        } catch (Exception e) {
//            fail("DataObject.getSequence().add(path, value) should throw an UnsupportedOperationException when the Property represtend by path is read-only.  " + e.getClass().getName() + " was thrown.");
//        }
    }    

    /**
     * Verifies the following statement.
     * Modification of a read-only property results in UnsupportedOperationException.
     * This test case is for modification done through the List API.
     */
    public void testModifyReadOnlyUnsupportedOperationExceptionSequence() {
        Property readOnlyProp = seqDO.getInstanceProperty("readOnlyVal");
        List properties = seqDO.getInstanceProperties();
        Property currProp;
        int readOnlyIndex = -1, i = 0, size = properties.size();

        while (readOnlyIndex < 0 && i < size) {
            currProp = (Property) properties.get(i);
            if (currProp.equals(readOnlyProp))
                readOnlyIndex = i;
            i++;
        }

// Not fixed in TUSCANY-578
//        try {
//            Sequence sequence = seqDO.getSequence();
//            sequence.add(readOnlyProp, "New Value");
//            fail("Sequence.add(property, value) should throw an UnsupportedOperationException when the Property represented by property is read-only.  No Exception was thrown.");
//        } catch (UnsupportedOperationException e) {
//            // Success - do nothing
//        } catch (Exception e) {
//            fail("Sequence.add(property, value) should throw an UnsupportedOperationException when the Property represented by property is read-only.  " + e.getClass().getName() + " was thrown.");
//        }
    }

    /**
     * Verifies the following statement.
     * A ClassCastException results when cannot convert between value and requested Type.
     */

    public void testCannotConvertClassCastException() {
        //  Attempt conversion from boolean

        try {
            testDO.getByte("booleanVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        } 
        try {
            testDO.getChar("booleanVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }       
        try {
            testDO.getDouble("booleanVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getFloat("booleanVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getInt("booleanVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getLong("booleanVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getShort("booleanVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getBytes("booleanVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getBigDecimal("booleanVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getBigInteger("booleanVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getDate("booleanVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }

        //  Attempt conversion from byte
        try {
            testDO.getBoolean("byteVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getChar("byteVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }       
        try {
            testDO.getBigDecimal("byteVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getBigInteger("byteVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getDate("byteVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getBytes("byteVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        //  Attempt conversion from character
        try {
            testDO.getBoolean("charVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getByte("charVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }    
        try {
            testDO.getDouble("charVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getFloat("charVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getInt("charVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getLong("charVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getShort("charVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getBytes("charVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getBigDecimal("charVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getBigInteger("charVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getDate("charVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }

//        Attempt conversion from double
        try {
            testDO.getBoolean("doubleVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getChar("doubleVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }       
        try {
            testDO.getBytes("doubleVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getDate("doubleVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }

//        Attempt conversion from float
        try {
            testDO.getBoolean("floatVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getChar("floatVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }       
        try {
            testDO.getBytes("floatVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getDate("floatVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }

//        Attempt conversion from int
        try {
            testDO.getBoolean("intVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getChar("intVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }       
        try {
            testDO.getBytes("intVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getDate("intVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }

//        Attempt conversion from long
        try {
            testDO.getBoolean("longVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getChar("longVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }       
        try {
            testDO.getBytes("longVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }

//        Attempt conversion from short
        try {
            testDO.getBoolean("shortVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getChar("shortVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }       
        try {
            testDO.getBytes("shortVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getBigDecimal("shortVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getBigInteger("shortVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getDate("shortVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }

//        Attempt conversion from bytes
        try {
            testDO.getBoolean("bytesVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getByte("bytesVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getChar("bytesVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }       
        try {
            testDO.getDouble("bytesVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getFloat("bytesVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getInt("bytesVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getLong("bytesVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getShort("bytesVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getBigDecimal("bytesVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getDate("bytesVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }

//        Attempt conversion from decimal
        try {
            testDO.getBoolean("decimalVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getByte("decimalVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getChar("decimalVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }       
        try {
            testDO.getShort("decimalVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getBytes("decimalVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getDate("decimalVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }

//        Attempt conversion from BigInteger
        try {
            testDO.getBoolean("integerVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getByte("integerVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getChar("integerVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }       
        try {
            testDO.getShort("integerVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getDate("integerVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }

//        Attempt conversion from date
        try {
            testDO.getBoolean("dateVal");
        } catch (ClassCastException e) {
            // success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getByte("dateVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getChar("dateVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }       
        try {
            testDO.getDouble("dateVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getFloat("dateVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getInt("dateVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getShort("dateVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getBytes("dateVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getBigDecimal("dateVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
        try {
            testDO.getBigInteger("dateVal");
        } catch (ClassCastException e) {
//            success - do nothing
        } catch (Exception e) {
            fail("Attempted implicit unsupported conversion did not throw the correct Exception.  Expected:  ClassCastException.  Received:  " + e.getClass().getName());
        }
    }


    /**
     * Verifies the following statement.
     * Mixing single-valued and multi-valued Property access results in 
     * ClassCastException.
     */
    public void testMixSingleMultiValueClassCastException() {
        Property testedProp = testDO.getInstanceProperty("intVal");
        List properties = testDO.getInstanceProperties();
        Property currProp;
        int testedIndex = -1, i = 0, size = properties.size();

        while (testedIndex < 0 && i < size) {
            currProp = (Property) properties.get(i);

            if (currProp.equals(testedProp))
                testedIndex = i;
            i++;
        }

        try {
            testDO.getList("intVal");
            fail("getList(string) should throw a ClassCastException when the property represented by string is single-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getList(string) should throw a ClassCastException when the property represented by string is single-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getList(testedProp);
            fail("getList(property) should throw a ClassCastException when the property represented by property is single-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getList(property) should throw a ClassCastException when the property represented by property is single-valued.  " + e.getClass().getName() + " was thrown.");
        }

        assertTrue("The test case could not procede because the index of the single-valued Property was not found.", testedIndex > -1);

        try {
            testDO.getList(testedIndex);
            fail("getList(index) should throw a ClassCastException when the property represented by index is single-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getList(index) should throw a ClassCastException when the property represented by index is single-valued.  " + e.getClass().getName() + " was thrown.");
        }

        testedProp = testDO.getInstanceProperty("listVal");
        testedIndex = -1;
        i = 0;
        while (testedIndex < 0 && i < size) {
            currProp = (Property) properties.get(i);
            if (currProp.equals(testedProp))
                testedIndex = i;
            i++;
        }

        try {
            testDO.getBoolean("listVal");
            fail("getBoolean(string) should throw a ClassCastException when the property represented by string is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getBoolean(string) should throw a ClassCastException when the property represented by string is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getByte("listVal");
            fail("getByte(string) should throw a ClassCastException when the property represented by string is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getByte(string) should throw a ClassCastException when the property represented by string is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getChar("listVal");
            fail("getChar(string) should throw a ClassCastException when the property represented by string is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getChar(string) should throw a ClassCastException when the property represented by string is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getDouble("listVal");
            fail("getDouble(string) should throw a ClassCastException when the property represented by string is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getDouble(string) should throw a ClassCastException when the property represented by string is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getFloat("listVal");
            fail("getFloat(string) should throw a ClassCastException when the property represented by string is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getFloat(string) should throw a ClassCastException when the property represented by string is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getInt("listVal");
            fail("getInt(string) should throw a ClassCastException when the property represented by string is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getInt(string) should throw a ClassCastException when the property represented by string is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getLong("listVal");
            fail("getLong(string) should throw a ClassCastException when the property represented by string is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getLong(string) should throw a ClassCastException when the property represented by string is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getShort("listVal");
            fail("getShort(string) should throw a ClassCastException when the property represented by string is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getShort(string) should throw a ClassCastException when the property represented by string is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getBytes("listVal");
            fail("getBytes(string) should throw a ClassCastException when the property represented by string is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getBytes(string) should throw a ClassCastException when the property represented by string is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getBigDecimal("listVal");
            fail("getBigDecimal(string) should throw a ClassCastException when the property represented by string is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getBigDecimal(string) should throw a ClassCastException when the property represented by string is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getBigInteger("listVal");
            fail("getBigInteger(string) should throw a ClassCastException when the property represented by string is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getBigInteger(string) should throw a ClassCastException when the property represented by string is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getDataObject("listVal");
            fail("getDataObject(string) should throw a ClassCastException when the property represented by string is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getDataObject(string) should throw a ClassCastException when the property represented by string is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getDate("listVal");
            fail("getDate(string) should throw a ClassCastException when the property represented by string is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getDate(string) should throw a ClassCastException when the property represented by string is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getString("listVal");
            fail("getString(string) should throw a ClassCastException when the property represented by string is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getString(string) should throw a ClassCastException when the property represented by string is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }

        try {
            testDO.getBoolean(testedProp);
            fail("getBoolean(property) should throw a ClassCastException when the property represented by property is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getBoolean(property) should throw a ClassCastException when the property represented by property is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getByte(testedProp);
            fail("getByte(property) should throw a ClassCastException when the property represented by property is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getByte(property) should throw a ClassCastException when the property represented by property is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getChar(testedProp);
            fail("getChar(property) should throw a ClassCastException when the property represented by property is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getChar(property) should throw a ClassCastException when the property represented by property is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getDouble(testedProp);
            fail("getDouble(property) should throw a ClassCastException when the property represented by property is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getDouble(property) should throw a ClassCastException when the property represented by property is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getFloat(testedProp);
            fail("getFloat(property) should throw a ClassCastException when the property represented by property is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getFloat(property) should throw a ClassCastException when the property represented by property is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getInt(testedProp);
            fail("getInt(property) should throw a ClassCastException when the property represented by property is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getInt(property) should throw a ClassCastException when the property represented by property is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getLong(testedProp);
            fail("getLong(property) should throw a ClassCastException when the property represented by property is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getLong(property) should throw a ClassCastException when the property represented by property is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getShort(testedProp);
            fail("getShort(property) should throw a ClassCastException when the property represented by property is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getShort(property) should throw a ClassCastException when the property represented by property is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getBytes(testedProp);
            fail("getBytes(property) should throw a ClassCastException when the property represented by property is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getBytes(property) should throw a ClassCastException when the property represented by property is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getBigDecimal(testedProp);
            fail("getBigDecimal(property) should throw a ClassCastException when the property represented by property is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getBigDecimal(property) should throw a ClassCastException when the property represented by property is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getBigInteger(testedProp);
            fail("getBigInteger(property) should throw a ClassCastException when the property represented by property is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getBigInteger(property) should throw a ClassCastException when the property represented by property is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getDataObject(testedProp);
            fail("getDataObject(property) should throw a ClassCastException when the property represented by property is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getDataObject(property) should throw a ClassCastException when the property represented by property is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getDate(testedProp);
            fail("getDate(property) should throw a ClassCastException when the property represented by property is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getDate(property) should throw a ClassCastException when the property represented by property is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getString(testedProp);
            fail("getString(property) should throw a ClassCastException when the property represented by property is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getString(property) should throw a ClassCastException when the property represented by property is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }

        assertTrue("The test case could not procede because the index of the multi-valued Property was not found.", testedIndex > -1);

        try {
            testDO.getBoolean(testedIndex);
            fail("getBoolean(index) should throw a ClassCastException when the property represented by index is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getBoolean(index) should throw a ClassCastException when the property represented by  is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getByte(testedIndex);
            fail("getByte(index) should throw a ClassCastException when the property represented by index is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getByte(index) should throw a ClassCastException when the property represented by index is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getChar(testedIndex);
            fail("getChar(index) should throw a ClassCastException when the property represented by index is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getChar(index) should throw a ClassCastException when the property represented by index is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getDouble(testedIndex);
            fail("getDouble(index) should throw a ClassCastException when the property represented by index is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getDouble(index) should throw a ClassCastException when the property represented by index is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getFloat(testedIndex);
            fail("getFloat(index) should throw a ClassCastException when the property represented by index is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getFloat(index) should throw a ClassCastException when the property represented by index is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getInt(testedIndex);
            fail("getInt(index) should throw a ClassCastException when the property represented by index is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getInt(index) should throw a ClassCastException when the property represented by index is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getLong(testedIndex);
            fail("getLong(index) should throw a ClassCastException when the property represented by index is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getLong(index) should throw a ClassCastException when the property represented by index is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getShort(testedIndex);
            fail("getShort(index) should throw a ClassCastException when the property represented by index is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getShort(index) should throw a ClassCastException when the property represented by index is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getBytes(testedIndex);
            fail("getBytes(index) should throw a ClassCastException when the property represented by index is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getBytes(index) should throw a ClassCastException when the property represented by index is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getBigDecimal(testedIndex);
            fail("getBigDecimal(index) should throw a ClassCastException when the property represented by index is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getBigDecimal(index) should throw a ClassCastException when the property represented by index is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getBigInteger(testedIndex);
            fail("getBigInteger(index) should throw a ClassCastException when the property represented by index is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getBigInteger(index) should throw a ClassCastException when the property represented by index is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getDataObject(testedIndex);
            fail("getDataObject(index) should throw a ClassCastException when the property represented by index is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getDataObject(index) should throw a ClassCastException when the property represented by index is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getDate(testedIndex);
            fail("getDate(index) should throw a ClassCastException when the property represented by index is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getDate(index) should throw a ClassCastException when the property represented by index is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
        try {
            testDO.getString(testedIndex);
            fail("getString(index) should throw a ClassCastException when the property represented by index is multi-valued.  No Exception was thrown.");
        } catch (ClassCastException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("getString(index) should throw a ClassCastException when the property represented by index is multi-valued.  " + e.getClass().getName() + " was thrown.");
        }
    }

    /*
    /**
     * Verifies the following statement.
     * Establishing circular containment results in an IllegalArgumentException.
     * Note:  This test case will not be implemented because it has been determined
     * that the statement will be removed from the spec.
     */
    /*
    public void testContainmentCycleIllegalArgumentException() {
        // This test case will not be implemented.
    }
     */

    /**
     * Verifies the following statement.
     * An empty DataGraph can have a root assigned by the createRootObject() methods.
     * However, if a previous root DataObject exists than an IllegalStateException is 
     * thrown.
     */
    public void testCreateRootObjectAgainIllegalStateException() {
        DataGraph dataGraph = SDOUtil.createDataGraph();
        Type type = testDO.getType();

        // verify the initial condition
        assertNull("The DataGraph should have been created without a root DataObject.", dataGraph.getRootObject());
        assertNotNull("DataObject.getType() returned null.", type);

        dataGraph.createRootObject(type);

        // verify the pre-condition
        assertNotNull("The DataGraph.createRootObject() should have created a root DataObject for the DataGraph.", dataGraph.getRootObject());

        try {
            dataGraph.createRootObject(type);
            fail("DataGraph.createRootObject(Type) should throw an IllegalStateException a root Object already exists for the DataGraph.  No Exception was thrown.");
        } catch (IllegalStateException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("DataGraph.createRootObject(Type) should throw an IllegalStateException a root Object already exists for the DataGraph.  " + e.getClass().getName() + " was thrown.");
        }
    }

    /**
     * Verifies the following statement.
     * DataFactory.create() throws an IllegalArgumentException if the instanceClass does
     * not correspond to a Type this factory can instantiate.
     */
    public void testDataFactoryCreateIllegalArgumentException() {
        try {
            helperContext.getDataFactory().create(java.lang.Object.class);    
            fail("DataFactory.create(Object) should throw an IllegalArgumentException when it cannot instantiate the Type specified.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing  
        } catch (Exception e) {
            fail("DataFactory.create(Object) should throw an IllegalArgumentException when it cannot instantiate the Type specified.   " + e.getClass().getName() + " was thrown.");
        }

        try {
            helperContext.getDataFactory().create(commonj.sdo.DataObject.class);    
            fail("DataFactory.create(DataObject) should throw an IllegalArgumentException when it cannot instantiate the Type specified.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("DataFactory.create(DataObject) should throw an IllegalArgumentException when it cannot instantiate the Type specified.   " + e.getClass().getName() + " was thrown.");
        }

        try {
            helperContext.getDataFactory().create(commonj.sdo.ChangeSummary.class);    
            fail("DataFactory.create(ChangeSummary) should throw an IllegalArgumentException when it cannot instantiate the Type specified.  No Exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Success - do nothing
        } catch (Exception e) {
            fail("DataFactory.create(ChangeSummary) should throw an IllegalArgumentException when it cannot instantiate the Type specified.   " + e.getClass().getName() + " was thrown.");
        }
    }

    /**
     * Defines the Type the first time through.
     */
    public void setUp() {
        if (!typeDefined) {
            helperContext = SDOUtil.createHelperContext();
//            createWithXSD(helperContext);
//            createDynamically(helperContext);
            createStatically(helperContext);
            typeDefined = true;
        }
//          testDO = helperContext.getDataFactory().create(TEST_URI, TEST_TYPE_NAME);
//          seqDO = helperContext.getDataFactory().create(TEST_URI, SEQ_TYPE_NAME);
            testDO = (DataObject) ExpectedExceptionFactory.INSTANCE.createExpectedExceptionType();
            seqDO = (DataObject) ExpectedExceptionFactory.INSTANCE.createSequenceReadOnlyType();
    }

    public static void createStatically(HelperContext hc) {
        ExpectedExceptionFactory.INSTANCE.register(hc);
    }

    public static void createWithXSD(HelperContext hc) {
        // Populate the meta data for the test model 
        URL url = ExpectedExceptionsTestCase.class.getResource("/expectedExceptions.xsd");
        try {
            InputStream inputStream = url.openStream();
            hc.getXSDHelper().define(inputStream, url.toString());
            inputStream.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * createDynamically() creates the SDO Types using the TypeHelper. This
     * method should be kept in synch with the XSD used for
     * createDynamicallyWithStaticResources. The same XSD is used for the static
     * generation of SDO Types using XSD2JavaGenerator.
     */
    public static void createDynamically(HelperContext hc) {

        TypeHelper types = hc.getTypeHelper();
        Type stringType = types.getType("commonj.sdo", "String");
        Type intType = types.getType("commonj.sdo", "Int");
        Type booleanType = types.getType("commonj.sdo", "Boolean");
        Type byteType = types.getType("commonj.sdo", "Byte");
        Type decimalType = types.getType("commonj.sdo", "Decimal");
        Type floatType = types.getType("commonj.sdo", "Float");
        Type doubleType = types.getType("commonj.sdo", "Double");
        Type dateType = types.getType("commonj.sdo", "Date");
        Type shortType = types.getType("commonj.sdo", "Short");
        Type longType = types.getType("commonj.sdo", "Long");
        Type bytesType = types.getType("commonj.sdo", "Bytes");
        Type integerType = types.getType("commonj.sdo", "Integer");
        Type charType = types.getType("commonj.sdo", "Character");

        DataObject testType = hc.getDataFactory().create("commonj.sdo", "Type");
        testType.set("uri", TEST_URI);
        testType.set("name", TEST_TYPE_NAME);

        DataObject stringProperty = testType.createDataObject("property");
        stringProperty.set("name", "stringVal");
        stringProperty.set("type", stringType);

        DataObject booleanProperty = testType.createDataObject("property");
        booleanProperty.set("name", "booleanVal");
        booleanProperty.set("type", booleanType);

        DataObject byteProperty = testType.createDataObject("property");
        byteProperty.set("name", "byteVal");
        byteProperty.set("type", byteType);

        DataObject decimalProperty = testType.createDataObject("property");
        decimalProperty.set("name", "decimalVal");
        decimalProperty.set("type", decimalType);

        DataObject intProperty = testType.createDataObject("property");
        intProperty.set("name", "intVal");
        intProperty.set("type", intType);

        DataObject floatProperty = testType.createDataObject("property");
        floatProperty.set("name", "floatVal");
        floatProperty.set("type", floatType);

        DataObject doubleProperty = testType.createDataObject("property");
        doubleProperty.set("name", "doubleVal");
        doubleProperty.set("type", doubleType);

        DataObject dateProperty = testType.createDataObject("property");
        dateProperty.set("name", "dateVal");
        dateProperty.set("type", dateType);

        DataObject shortProperty = testType.createDataObject("property");
        shortProperty.set("name", "shortVal");
        shortProperty.set("type", shortType);

        DataObject longProperty = testType.createDataObject("property");
        longProperty.set("name", "longVal");
        longProperty.set("type", longType);

        DataObject childrenProperty = testType.createDataObject("property");
        childrenProperty.set("name", "listVal");
        childrenProperty.setBoolean("many", true);
        childrenProperty.set("type", stringType);

        DataObject bytesProperty = testType.createDataObject("property");
        bytesProperty.set("name", "bytesVal");
        bytesProperty.set("type", bytesType);

        DataObject integerProperty = testType.createDataObject("property");
        integerProperty.set("name", "integerVal");
        integerProperty.set("type", integerType);

        DataObject charProperty = testType.createDataObject("property");
        charProperty.set("name", "charVal");
        charProperty.set("type", charType);

        DataObject readOnlyProperty = testType.createDataObject("property");
        readOnlyProperty.set("name", "readOnlyVal");
        readOnlyProperty.set("type", stringType);
        readOnlyProperty.setBoolean("readOnly", true);

        DataObject readOnlyListProperty = testType.createDataObject("property");
        readOnlyListProperty.set("name", "readOnlyListVal");
        readOnlyListProperty.set("type", stringType);
        readOnlyListProperty.setBoolean("readOnly", true);
        readOnlyListProperty.setBoolean("many", true);

        types.define(testType);

        DataObject seqType = hc.getDataFactory().create("commonj.sdo", "Type");
        seqType.set("uri", TEST_URI);
        seqType.set("name", SEQ_TYPE_NAME);
        seqType.setBoolean("sequenced", true);

        DataObject seqROProperty = seqType.createDataObject("property");
        seqROProperty.set("name", "readOnlyVal");
        seqROProperty.set("type", stringType);
        seqROProperty.setBoolean("readOnly", true);

        DataObject seqROListProperty = seqType.createDataObject("property");
        seqROListProperty.set("name", "readOnlyListVal");
        seqROListProperty.set("type", stringType);
        seqROListProperty.setBoolean("readOnly", true);
        seqROListProperty.setBoolean("many", true);

        DataObject uniqueNameProperty = seqType.createDataObject("property");
        uniqueNameProperty.set("name", "uniqueName");
        uniqueNameProperty.set("type", stringType);

        types.define(seqType);
    }
}