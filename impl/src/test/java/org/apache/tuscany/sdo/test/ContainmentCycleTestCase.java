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
package org.apache.tuscany.sdo.test;

import junit.framework.TestCase;
import commonj.sdo.DataObject;
import commonj.sdo.Sequence;
import commonj.sdo.Type;
import commonj.sdo.helper.HelperContext;

import org.apache.tuscany.sdo.api.XMLStreamHelper;
import org.apache.tuscany.sdo.api.SDOUtil;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.example.test.Containment.ContainmentFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Tests serialization of containment cycles.  For JavaSerialization, the test case
 * passes if an IllegalStateException is thrown.  For XMLHelper and XMLStreamHelper
 * serialization, serization should complete without throwing an Exception.  In all 
 * cases, the actual structure of the DataObject should not be changed by the 
 * method call to serialize the DO.
 * 
 * The same test is run for a static model (Type created using XSD2JavaGenerator), a
 * dynamic model (Type created using TypeHelper), and a 'mixed' model (Type created
 * using XSDHelper - dynamic Type creation using static resources).
 */
public class ContainmentCycleTestCase extends TestCase {    

	private static final String CONTAIN_URI = "http://www.example.com/ContainmentTest";
	private static final String CONTAIN_TYPE = "ContainmentTest";
	private static HelperContext staticScope;
	private static HelperContext dynamicScope;
	private static HelperContext mixedScope;
	private static boolean initialized = false;
	private static boolean mixedCreated = false;
	
    /**
     * Attempt to create a 1-Member Containment Cycle using set____ on a single valued property
     * and verify the behavior of serialization.  This is the static version of this test case.
     */
	// Note:  Static test cases are prevented due to a JVM Error in ObjectOutputStream.
	// The IllegalStateException thrown by Java serialization is caught, which in turn allows
	// the StackOverflowException to occur.  The catcher is catching RuntimeException, so it does
	// not matter which Exception is thrown by the SDO code.
    public void atestStaticOneMemberSingleValueSetDataObject() {           
        final DataObject dataObj1 = (DataObject) ContainmentFactory.INSTANCE.createContainmentTest();
        
        dataObj1.setString("Name", "dataObj1");      
        
        setSingleValueOneMember(dataObj1);
        attemptSerialization(dataObj1, staticScope);
    }
    
    /**
     * Attempt to create an n-Member Containment Cycle using set____ on a single valued property
     * and verify the behavior of serialization.  This is the static version of this test case.
     */
    public void atestStaticNMemberSingleValueSetDataObject() {
        final DataObject dataObj1 = (DataObject) ContainmentFactory.INSTANCE.createContainmentTest();
        final DataObject dataObj2 = (DataObject) ContainmentFactory.INSTANCE.createContainmentTest();
        final DataObject dataObj3 = (DataObject) ContainmentFactory.INSTANCE.createContainmentTest();

        dataObj1.setString("Name", "dataObj1");
        dataObj2.setString("Name", "dataObj2");
        dataObj3.setString("Name", "dataObj3");
        
        setSingleValueNMember(dataObj1, dataObj2, dataObj3);
        attemptSerialization(dataObj1, staticScope);
    }
    
    
    /**
     * Attempt to create a 1-Member Containment Cycle using set____ on a multi valued property
     * and verify the behavior of serialization.  This is the static version of this test case.
     */
    public void atestStaticOneMemberMultiValueSetDataObject() {
        final DataObject dataObj1 = (DataObject) ContainmentFactory.INSTANCE.createContainmentTest();
        final DataObject dataObj2 = (DataObject) ContainmentFactory.INSTANCE.createContainmentTest();
        final DataObject dataObj3 = (DataObject) ContainmentFactory.INSTANCE.createContainmentTest();
         
        dataObj1.setString("Name", "dataObj1");
        dataObj2.setString("Name", "dataObj2");
        dataObj3.setString("Name", "dataObj3");
        
        setMultiValueOneMember(dataObj1, dataObj2, dataObj3);
        attemptSerialization(dataObj1, staticScope);
    }
    
    /**
     * Attempt to create an n-Member Containment Cycle using set____ on a multi valued property
     * and verify the behavior of serialization.  This is the static version of this test case.
     */
    public void atestStaticNMemberMultiValueSetDataObject() {
        final DataObject dataObj1 = (DataObject) ContainmentFactory.INSTANCE.createContainmentTest();
        final DataObject dataObj2 = (DataObject) ContainmentFactory.INSTANCE.createContainmentTest();
        final DataObject dataObj3 = (DataObject) ContainmentFactory.INSTANCE.createContainmentTest();
         
        dataObj1.setString("Name", "dataObj1");
        dataObj2.setString("Name", "dataObj2");
        dataObj3.setString("Name", "dataObj3");
        
        setManyValueNMember(dataObj1, dataObj2, dataObj3);
        attemptSerialization(dataObj1, staticScope);
    }
    
    /**
     * Attempt to create a 1-Member Containment Cycle by making updates to a List returned
     * from the DataObject and verify the behavior of serialization.  This is the static version 
     * of this test case.
     */
    public void atestStaticOneMemberReturnedList() {      
        final DataObject dataObj1 = (DataObject) ContainmentFactory.INSTANCE.createContainmentTest();
         
        dataObj1.setString("Name", "dataObj1");
        
        returnedListOneMember(dataObj1);
        attemptSerialization(dataObj1, staticScope);
    }
    
    /**
     * Attempt to create an n-Member Containment Cycle by making updates to a List returned
     * from the DataObject and verify the behavior of serialization.  This is the static version 
     * of this test case.
     */
    public void atestStaticNMemberReturnedList() {
        final DataObject dataObj1 = (DataObject) ContainmentFactory.INSTANCE.createContainmentTest();
        final DataObject dataObj2 = (DataObject) ContainmentFactory.INSTANCE.createContainmentTest();
        final DataObject dataObj3 = (DataObject) ContainmentFactory.INSTANCE.createContainmentTest();
         
        dataObj1.setString("Name", "dataObj1");
        dataObj2.setString("Name", "dataObj2");
        dataObj3.setString("Name", "dataObj3");
        
        returnedListNMember(dataObj1, dataObj2, dataObj3);
        attemptSerialization(dataObj1, staticScope);
    }
    
    /**
     * Attempt to create a 1-Member Containment Cycle using by using a Sequence to make updates
     * to the DataObject, affecting a single valued property, and verify the behavior of 
     * serialization.  This is the static version of this test case.
     */
    public void atestStaticOneMemberSingleValueSequence() {
        final DataObject dataObj1 = (DataObject) ContainmentFactory.INSTANCE.createContainmentTest();
         
        dataObj1.setString("Name", "dataObj1");
        
        sequenceSingleValueOneMember(dataObj1);
        attemptSerialization(dataObj1, staticScope);
    }
    
    /**
     * Attempt to create an n-Member Containment Cycle using by using a Sequence to make updates
     * to the DataObject, affecting a single valued property, and verify the behavior of 
     * serialization.  This is the static version of this test case.
     */
    public void atestStaticNMemberSingleValueSequence() {
        final DataObject dataObj1 = (DataObject) ContainmentFactory.INSTANCE.createContainmentTest();
        final DataObject dataObj2 = (DataObject) ContainmentFactory.INSTANCE.createContainmentTest();
        final DataObject dataObj3 = (DataObject) ContainmentFactory.INSTANCE.createContainmentTest();
         
        dataObj1.setString("Name", "dataObj1");
        dataObj2.setString("Name", "dataObj2");
        dataObj3.setString("Name", "dataObj3");
        
        sequenceSingleValueNMember(dataObj1, dataObj2, dataObj3);
        attemptSerialization(dataObj1, staticScope);
    }
    
    /**
     * Attempt to create a 1-Member Containment Cycle using by using a Sequence to make updates
     * to the DataObject, affecting a multi valued property, and verify the behavior of 
     * serialization.  This is the static version of this test case.
     */
    public void atestStaticOneMemberMultiValueSequence() {
        final DataObject dataObj1 = (DataObject) ContainmentFactory.INSTANCE.createContainmentTest();
        final DataObject dataObj2 = (DataObject) ContainmentFactory.INSTANCE.createContainmentTest();
        final DataObject dataObj3 = (DataObject) ContainmentFactory.INSTANCE.createContainmentTest();
         
        dataObj1.setString("Name", "dataObj1");
        dataObj2.setString("Name", "dataObj2");
        dataObj3.setString("Name", "dataObj3");
        
        sequenceMultiValueOneMember(dataObj1, dataObj2, dataObj3);
        attemptSerialization(dataObj1, staticScope);
    }
    
    /**
     * Attempt to create an n-Member Containment Cycle using by using a Sequence to make updates
     * to the DataObject, affecting a multi valued property, and verify the behavior of 
     * serialization.  This is the static version of this test case.
     */
    public void atestStaticNMemberMultiValueSequence() {
        final DataObject dataObj1 = (DataObject) ContainmentFactory.INSTANCE.createContainmentTest();
        final DataObject dataObj2 = (DataObject) ContainmentFactory.INSTANCE.createContainmentTest();
        final DataObject dataObj3 = (DataObject) ContainmentFactory.INSTANCE.createContainmentTest();
         
        dataObj1.setString("Name", "dataObj1");
        dataObj2.setString("Name", "dataObj2");
        dataObj3.setString("Name", "dataObj3");
        
        sequenceManyValueNMember(dataObj1, dataObj2, dataObj3);
        attemptSerialization(dataObj1, staticScope);
    }
    
    /**
     * Attempt to create a 1-Member Containment Cycle using set____ on a single valued property
     * and verify the behavior of serialization.  This is the hybrid version of this test case.
     */
    public void testHybridOneMemberSingleValueSetDataObject() {        
    	assertTrue("Test case cannot proceed due to error creating Type.", mixedCreated);
    	
        final DataObject dataObj1 = mixedScope.getDataFactory().create(CONTAIN_URI,
                                                          CONTAIN_TYPE);
        dataObj1.setString("Name", "dataObj1");

        setSingleValueOneMember(dataObj1);
        attemptSerialization(dataObj1, mixedScope);
    }
    
    /**
     * Attempt to create an n-Member Containment Cycle using set____ on a single valued property
     * and verify the behavior of serialization.  This is the hybrid version of this test case.
     */
    public void testHybridNMemberSingleValueSetDataObject() {
    	assertTrue("Test case cannot proceed due to error creating Type.", mixedCreated);
        
        final DataObject dataObj1 = mixedScope.getDataFactory().create(CONTAIN_URI,
                                                          CONTAIN_TYPE);
        final DataObject dataObj2 = mixedScope.getDataFactory().create(CONTAIN_URI,
                                                          CONTAIN_TYPE);
        final DataObject dataObj3 = mixedScope.getDataFactory().create(CONTAIN_URI,
                                                          CONTAIN_TYPE);
        dataObj1.setString("Name", "dataObj1");
        dataObj2.setString("Name", "dataObj2");
        dataObj3.setString("Name", "dataObj3");
        
        setSingleValueNMember(dataObj1, dataObj2, dataObj3);
        attemptSerialization(dataObj1, mixedScope);
    }
    
    /**
     * Attempt to create a 1-Member Containment Cycle using set____ on a multi valued property
     * and verify the behavior of serialization.  This is the hybrid version of this test case.
     */
    public void testHybridOneMemberMultiValueSetDataObject() {
    	assertTrue("Test case cannot proceed due to error creating Type.", mixedCreated);
        
        final DataObject dataObj1 = mixedScope.getDataFactory().create(CONTAIN_URI,
                                                          CONTAIN_TYPE);
        final DataObject dataObj2 = mixedScope.getDataFactory().create(CONTAIN_URI,
                                                          CONTAIN_TYPE);
        final DataObject dataObj3 = mixedScope.getDataFactory().create(CONTAIN_URI,
                                                          CONTAIN_TYPE);
         
        dataObj1.setString("Name", "dataObj1");
        dataObj2.setString("Name", "dataObj2");
        dataObj3.setString("Name", "dataObj3");
        
        setMultiValueOneMember(dataObj1, dataObj2, dataObj3);
        attemptSerialization(dataObj1, mixedScope);
    }
    
    /**
     * Attempt to create an n-Member Containment Cycle using set____ on a multi valued property
     * and verify the behavior of serialization.  This is the hybrid version of this test case.
     */
    public void testHybridNMemberMultiValueSetDataObject() {
    	assertTrue("Test case cannot proceed due to error creating Type.", mixedCreated);
       
        final DataObject dataObj1 = mixedScope.getDataFactory().create(CONTAIN_URI,
                                                          CONTAIN_TYPE);
        final DataObject dataObj2 = mixedScope.getDataFactory().create(CONTAIN_URI,
                                                          CONTAIN_TYPE);
        final DataObject dataObj3 = mixedScope.getDataFactory().create(CONTAIN_URI,
                                                          CONTAIN_TYPE);
        dataObj1.setString("Name", "dataObj1");
        dataObj2.setString("Name", "dataObj2");
        dataObj3.setString("Name", "dataObj3");
        
        setManyValueNMember(dataObj1, dataObj2, dataObj3);
        attemptSerialization(dataObj1, mixedScope);
    }
    
    /**
     * Attempt to create a 1-Member Containment Cycle by making updates to a List returned
     * from the DataObject and verify the behavior of serialization.  This is the hybrid version 
     * of this test case.
     */
    public void testHybridOneMemberReturnedList() {
    	assertTrue("Test case cannot proceed due to error creating Type.", mixedCreated);
        
        final DataObject dataObj1 = mixedScope.getDataFactory().create(CONTAIN_URI,
                                                          CONTAIN_TYPE);
        dataObj1.setString("Name", "dataObj1");

        returnedListOneMember(dataObj1);
        attemptSerialization(dataObj1, mixedScope);
    }
    
    /**
     * Attempt to create an n-Member Containment Cycle by making updates to a List returned
     * from the DataObject and verify the behavior of serialization.  This is the hybrid version 
     * of this test case.
     */
    public void testHybridNMemberReturnedList() {
    	assertTrue("Test case cannot proceed due to error creating Type.", mixedCreated);
        
        final DataObject dataObj1 = mixedScope.getDataFactory().create(CONTAIN_URI,
                                                          CONTAIN_TYPE);
        final DataObject dataObj2 = mixedScope.getDataFactory().create(CONTAIN_URI,
                                                          CONTAIN_TYPE);
        final DataObject dataObj3 = mixedScope.getDataFactory().create(CONTAIN_URI,
                                                          CONTAIN_TYPE);
        dataObj1.setString("Name", "dataObj1");
        dataObj2.setString("Name", "dataObj2");
        dataObj3.setString("Name", "dataObj3");
        
        returnedListNMember(dataObj1, dataObj2, dataObj3);
        attemptSerialization(dataObj1, mixedScope);
    }
    
    /**
     * Attempt to create a 1-Member Containment Cycle using by using a Sequence to make updates
     * to the DataObject, affecting a single valued property, and verify the behavior of 
     * serialization.  This is the hybrid version of this test case.
     */
    public void testHybridOneMemberSingleValueSequence() {
    	assertTrue("Test case cannot proceed due to error creating Type.", mixedCreated);
        
        final DataObject dataObj1 = mixedScope.getDataFactory().create(CONTAIN_URI,
                                                          CONTAIN_TYPE);
        dataObj1.setString("Name", "dataObj1");

        sequenceSingleValueOneMember(dataObj1);
        attemptSerialization(dataObj1, mixedScope);
    }
    
    /**
     * Attempt to create an n-Member Containment Cycle using by using a Sequence to make updates
     * to the DataObject, affecting a single valued property, and verify the behavior of 
     * serialization.  This is the hybrid version of this test case.
     */
    public void testHybridNMemberSingleValueSequence() {
    	assertTrue("Test case cannot proceed due to error creating Type.", mixedCreated);
        
        final DataObject dataObj1 = mixedScope.getDataFactory().create(CONTAIN_URI,
                                                          CONTAIN_TYPE);
        final DataObject dataObj2 = mixedScope.getDataFactory().create(CONTAIN_URI,
                                                          CONTAIN_TYPE);
        final DataObject dataObj3 = mixedScope.getDataFactory().create(CONTAIN_URI,
                                                          CONTAIN_TYPE);
        dataObj1.setString("Name", "dataObj1");
        dataObj2.setString("Name", "dataObj2");
        dataObj3.setString("Name", "dataObj3");
        
        sequenceSingleValueNMember(dataObj1, dataObj2, dataObj3);
        attemptSerialization(dataObj1, mixedScope);
    }
    
    /**
     * Attempt to create a 1-Member Containment Cycle using by using a Sequence to make updates
     * to the DataObject, affecting a multi valued property, and verify the behavior of serialization.  
     * This is the hybrid version of this test case.
     */
    public void testHybridOneMemberMultiValueSequence() {
    	assertTrue("Test case cannot proceed due to error creating Type.", mixedCreated);
        
        final DataObject dataObj1 = mixedScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        final DataObject dataObj2 = mixedScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        final DataObject dataObj3 = mixedScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        dataObj1.setString("Name", "dataObj1");
        dataObj2.setString("Name", "dataObj2");
        dataObj3.setString("Name", "dataObj3");
        
        sequenceMultiValueOneMember(dataObj1, dataObj2, dataObj3);
        attemptSerialization(dataObj1, mixedScope);
    }
    
    /**
     * Attempt to create an n-Member Containment Cycle using by using a Sequence to make updates
     * to the DataObject, affecting a multi valued property, and verify the behavior of serialization.  
     * This is the hybrid version of this test case.
     */
    public void testHybridNMemberMultiValueSequence() {
    	assertTrue("Test case cannot proceed due to error creating Type.", mixedCreated);
        
        final DataObject dataObj1 = mixedScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        final DataObject dataObj2 = mixedScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        final DataObject dataObj3 = mixedScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        dataObj1.setString("Name", "dataObj1");
        dataObj2.setString("Name", "dataObj2");
        dataObj3.setString("Name", "dataObj3");
        
        sequenceManyValueNMember(dataObj1, dataObj2, dataObj3);
        attemptSerialization(dataObj1, mixedScope);
    }    
 
    /**
     * Attempt to create a 1-Member Containment Cycle using set____ on a single valued property
     * and verify the behavior of serialization.  This is the dynamic version of this test case.
     */
    public void testDynamicOneMemberSingleValueSetDataObject() {
        final DataObject dataObj1 = dynamicScope.getDataFactory().create(CONTAIN_URI,
                                                          CONTAIN_TYPE);
        dataObj1.setString("Name", "dataObj1");

        setSingleValueOneMember(dataObj1);
        attemptSerialization(dataObj1, dynamicScope);
    }
    
    /**
     * Attempt to create an n-Member Containment Cycle using set____ on a single valued property
     * and verify the behavior of serialization.  This is the dynamic version of this test case.
     */
    public void testDynamicNMemberSingleValueSetDataObject() {
        final DataObject dataObj1 = dynamicScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        final DataObject dataObj2 = dynamicScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        final DataObject dataObj3 = dynamicScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        dataObj1.setString("Name", "dataObj1");
        dataObj2.setString("Name", "dataObj2");
        dataObj3.setString("Name", "dataObj3");
        
        setSingleValueNMember(dataObj1, dataObj2, dataObj3);
        attemptSerialization(dataObj1, dynamicScope);
    }
    
    /**
     * Attempt to create a 1-Member Containment Cycle using set____ on a multi valued property
     * and verify the behavior of serialization.  This is the dynamic version of this test case.
     */
    public void testDynamicOneMemberMultiValueSetDataObject() {
        final DataObject dataObj1 = dynamicScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        final DataObject dataObj2 = dynamicScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        final DataObject dataObj3 = dynamicScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        dataObj1.setString("Name", "dataObj1");
        dataObj2.setString("Name", "dataObj2");
        dataObj3.setString("Name", "dataObj3");
        
        setMultiValueOneMember(dataObj1, dataObj2, dataObj3);
        attemptSerialization(dataObj1, dynamicScope);
    }
    
    /**
     * Attempt to create an n-Member Containment Cycle using set____ on a multi valued property
     * and verify the behavior of serialization.  This is the dynamic version of this test case.
     */
    public void testDynamicNMemberMultiValueSetDataObject() {
        final DataObject dataObj1 = dynamicScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        final DataObject dataObj2 = dynamicScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        final DataObject dataObj3 = dynamicScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        dataObj1.setString("Name", "dataObj1");
        dataObj2.setString("Name", "dataObj2");
        dataObj3.setString("Name", "dataObj3");

        setManyValueNMember(dataObj1, dataObj2, dataObj3);
        attemptSerialization(dataObj1, dynamicScope);
    }
    
    /**
     * Attempt to create a 1-Member Containment Cycle by making updates to a List returned
     * from the DataObject and verify the behavior of serialization.  This is the dynamic version 
     * of this test case.
     */
    public void testDynamicOneMemberReturnedList() {
        final DataObject dataObj1 = dynamicScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        dataObj1.setString("Name", "dataObj1");

        returnedListOneMember(dataObj1);
        attemptSerialization(dataObj1, dynamicScope);
    }
    
    /**
     * Attempt to create an n-Member Containment Cycle by making updates to a List returned
     * from the DataObject and verify the behavior of serialization.  This is the dynamic version 
     * of this test case.
     */
    public void testDynamicNMemberReturnedList() {
        final DataObject dataObj1 = dynamicScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        final DataObject dataObj2 = dynamicScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        final DataObject dataObj3 = dynamicScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        dataObj1.setString("Name", "dataObj1");
        dataObj2.setString("Name", "dataObj2");
        dataObj3.setString("Name", "dataObj3");
        
        returnedListNMember(dataObj1, dataObj2, dataObj3);
        attemptSerialization(dataObj1, dynamicScope);
    }
    
    /**
     * Attempt to create a 1-Member Containment Cycle using by using a Sequence to make updates
     * to the DataObject, affecting a single valued property, and verify the behavior of 
     * serialization.  This is the dynamic version of this test case.
     */
    public void testDynamicOneMemberSingleValueSequence() {
        final DataObject dataObj1 = dynamicScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        dataObj1.setString("Name", "dataObj1");

        sequenceSingleValueOneMember(dataObj1);
        attemptSerialization(dataObj1, dynamicScope);
    }
    
    /**
     * Attempt to create an n-Member Containment Cycle using by using a Sequence to make updates
     * to the DataObject, affecting a single valued property, and verify the behavior of 
     * serialization.  This is the dynamic version of this test case.
     */
    public void testDynamicNMemberSingleValueSequence() {
        final DataObject dataObj1 = dynamicScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        final DataObject dataObj2 = dynamicScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        final DataObject dataObj3 = dynamicScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        dataObj1.setString("Name", "dataObj1");
        dataObj2.setString("Name", "dataObj2");
        dataObj3.setString("Name", "dataObj3");
        
        sequenceSingleValueNMember(dataObj1, dataObj2, dataObj3);
        attemptSerialization(dataObj1, dynamicScope);
    }
    
    /**
     * Attempt to create a 1-Member Containment Cycle using by using a Sequence to make updates
     * to the DataObject, affecting a multi valued property, and verify the behavior of 
     * serialization.  This is the dynamic version of this test case.
     */
    public void testDynamicOneMemberMultiValueSequence() {
        final DataObject dataObj1 = dynamicScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        final DataObject dataObj2 = dynamicScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        final DataObject dataObj3 = dynamicScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        dataObj1.setString("Name", "dataObj1");
        dataObj2.setString("Name", "dataObj2");
        dataObj3.setString("Name", "dataObj3");
        
        sequenceMultiValueOneMember(dataObj1, dataObj2, dataObj3);
        attemptSerialization(dataObj1, dynamicScope);
    }
    
    /**
     * Attempt to create an n-Member Containment Cycle using by using a Sequence to make updates
     * to the DataObject, affecting a multi valued property, and verify the behavior of 
     * serialization.  This is the dynamic version of this test case.
     */
    public void testDynamicNMemberMultiValueSequence() {
        final DataObject dataObj1 = dynamicScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        final DataObject dataObj2 = dynamicScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        final DataObject dataObj3 = dynamicScope.getDataFactory().create(CONTAIN_URI, CONTAIN_TYPE);
        dataObj1.setString("Name", "dataObj1");
        dataObj2.setString("Name", "dataObj2");
        dataObj3.setString("Name", "dataObj3");
        
        sequenceManyValueNMember(dataObj1, dataObj2, dataObj3);
        attemptSerialization(dataObj1, dynamicScope);
    }
    
    /** 
     * Attempt to serialize the DataObject in via XML, XMLStreamHelper,
     * and Java serialization.
     * @param dataObj
     */
    private void attemptSerialization(final DataObject dataObj, final HelperContext scope) {
        
        assertTrue("Containment cycle was not established.", 
                containmentCycleExists(dataObj));
        
    	try {
            serializeDataObjectXML(dataObj, scope);
    	} catch (final Exception e) {
    		fail("XML serialization of a containment cycle resulted in a(n) " + e.getClass().getName() + ".");
    		e.printStackTrace();
    	}
    	
        assertTrue("Containment cycle was affected by XMLHelper serialization.", 
                containmentCycleExists(dataObj));
        
    	try {
             serializeDataObjectJava(dataObj); 
             fail("Java serialization of a containment cycle should result in an IllegalStateException.");
    	} catch (final Exception e) {
    		// Do nothing.  An Exception is expected in this case.
    	}
    	
        assertTrue("Containment cycle was affected by Java serialization.", 
                containmentCycleExists(dataObj));
        
    	try {
          serializeDataObjectStream(dataObj, scope);	
    	} catch (final Exception e) {
       		fail("XMLStreamHelper serialization of a containment cycle resulted in a(n) " + e.getClass().getName() + ".");
    		e.printStackTrace();
    	}
        assertTrue("Containment cycle was affected by XMLStreamHelper serialization.", 
                containmentCycleExists(dataObj));
    }
    /**
     * Uses the XMLHelper to serialize the input DataObject
     * 
     * @param dataObject
     * @param fileName
     * @throws IOException
     */
    private static void serializeDataObjectXML(final DataObject dataObject, final HelperContext scope) {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final Type type = dataObject.getType();

        try {
            scope.getXMLHelper().save(dataObject, type.getURI(), type.getName(), baos);
        }
        catch (final IOException e) {
            fail("Could not complete test case due to IOException.");
        }
    }
    
    /**
     * Uses Java serialization to serialize the input DataObject
     * 
     * @param dataObject
     * @param fileName
     * @throws IOException
     */
    private static void serializeDataObjectStream(final DataObject dataObject, final HelperContext scope) {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();

        final XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter serializer;
        final XMLStreamHelper xmlStreamHelper = SDOUtil.createXMLStreamHelper(scope);
        try {
            serializer = factory.createXMLStreamWriter(baos);
            xmlStreamHelper.saveObject(dataObject, serializer);
            serializer.flush();
        }
        catch (final XMLStreamException e) {
            fail("Exception encountered during XMLStreamHelper serialization.");
            e.printStackTrace();
        }
    }
    
    /**
     * Uses Java serialization to serialize the input DataObject
     * 
     * @param dataObject
     * @param fileName
     * @throws IOException
     */
    private static void serializeDataObjectJava(final DataObject dataObject) {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        try {
            final ObjectOutputStream out = new ObjectOutputStream(baos);
            out.writeObject(dataObject);
            out.close();
        }
        catch (final IOException e) {
            fail("Could not complete test case due to IOException.");
        }
    }
    
    /**
     * Returns true if input DataObject root is part of a containment cycle, 
     * false otherwise.
     * @param root
     * @return
     */
    private static boolean containmentCycleExists (final DataObject root)
    {
        DataObject curr = root.getContainer();
        
        while (curr != null)
        {
            if (curr == root) {
                return true;
            }
            
            curr = curr.getContainer();
        }
        return false;
    }
    
    /**
     * Use setDataObject to create a one member containment cycle.  
     * @param dataObj1
     */
    private void setSingleValueOneMember(final DataObject dataObj1) {
        dataObj1.setDataObject("Contain", dataObj1);
    }
    
    /**
     * Use setDataObject to create an N-member containment cycle.
     * @param dataObj1
     * @param dataObj2
     * @param dataobj3
     */
    private void setSingleValueNMember(final DataObject dataObj1, final DataObject dataObj2, final DataObject dataObj3) {
        dataObj1.setDataObject("Contain", dataObj2);
        dataObj2.setDataObject("Contain", dataObj3);
        dataObj3.setDataObject("Contain", dataObj1);
    }

    /**
     * Use setList to create a one member containment cycle. 
     * @param dataObj1
     * @param dataObj2
     * @param dataObj3
     */
    private void setMultiValueOneMember(final DataObject dataObj1, final DataObject dataObj2, final DataObject dataObj3) {
        final List addList = new ArrayList();
        
        addList.add(dataObj2);
        addList.add(dataObj1);
        addList.add(dataObj3);
        dataObj1.setList("ContainMany", addList);
    }

    /**
     * Use setList to create an N-member containment cycle. 
     * @param dataObj1
     * @param dataObj2
     * @param dataObj3
     */
    private void setManyValueNMember(final DataObject dataObj1, final DataObject dataObj2, final DataObject dataObj3) {
        final List addList = new ArrayList();
        
        dataObj1.setDataObject("Contain", dataObj2);
        dataObj2.setDataObject("Contain", dataObj3);
        addList.add(dataObj1);
        dataObj3.setList("ContainMany", addList);
    }

    /**
     * Create a 1-member containment cycle by making updates to a returned List.  
     * @param dataObj1
     */
    private void returnedListOneMember(final DataObject dataObj1) {
        final List returnedList = dataObj1.getList("ContainMany");

        returnedList.add(dataObj1);
    }
    
    /**
     * Create an n-member containment cycle by making updates to a returned List.  
     * @param dataObj1
     * @param dataObj2
     * @param dataobj3
     */
    private void returnedListNMember(final DataObject dataObj1, final DataObject dataObj2, final DataObject dataObj3) {
        dataObj1.setDataObject("Contain", dataObj2);
        dataObj2.setDataObject("Contain", dataObj3);
        
        final List returnedList = dataObj3.getList("ContainMany");

        returnedList.add(dataObj1);
    }

    /**
     * Create a 1-member containment cycle by making updates to a Sequence.  
     * The data member in this case is single valued.
     * @param dataObj1
     * @param dataObj2
     * @param dataObj3
     */
    private void sequenceSingleValueOneMember(final DataObject dataObj1) {
        assertTrue("DataObject is not Sequenced.  Test case may not proceed.", dataObj1.getType().isSequenced());
        
        final Sequence sequence = dataObj1.getSequence();

        sequence.add("Contain", dataObj1);
    }

    /**
     * Create an n-member containment cycle by making updates to a Sequence.  
     * The data member in this case is single valued.
     * @param dataObj1
     * @param dataObj2
     * @param dataObj3
     */
    private void sequenceSingleValueNMember(final DataObject dataObj1, final DataObject dataObj2, final DataObject dataObj3) {
        assertTrue("DataObject is not Sequenced.  Test case may not proceed.", dataObj1.getType().isSequenced());

        final Sequence sequence1 = dataObj1.getSequence();
        final Sequence sequence2 = dataObj2.getSequence();
        final Sequence sequence3 = dataObj3.getSequence();

        sequence1.add("Contain", (Object) dataObj2);
        sequence2.add("Contain", (Object) dataObj3);

        sequence3.add("Contain", (Object) dataObj1);
    }

    /**
     * Create a 1-member containment cycle by making updates to a Sequence.  
     * The data member in this case is many valued.
     * @param dataObj1
     * @param dataObj2
     * @param dataObj3
     */
    private void sequenceMultiValueOneMember(final DataObject dataObj1, final DataObject dataObj2, final DataObject dataObj3) {
        assertTrue("DataObject is not Sequenced.  Test case may not proceed.", dataObj1.getType().isSequenced());

        final Sequence sequence = dataObj1.getSequence();
        
        sequence.add("ContainMany", dataObj2);
        sequence.add("ContainMany", dataObj3);
        sequence.add("ContainMany", dataObj1);
    }
    
    /**
     * Create an n-member containment cycle by making updates to a Sequence.  
     * The data member in this case is many valued.
     * @param dataObj1
     * @param dataObj2
     * @param dataObj3
     */
    private void sequenceManyValueNMember(final DataObject dataObj1, final DataObject dataObj2, final DataObject dataObj3) {
        assertTrue("DataObject is not Sequenced.  Test case may not proceed.", dataObj1.getType().isSequenced());

        final List addList = new ArrayList();
        
        addList.add(dataObj2);
        dataObj1.setList("ContainMany", addList);
        
        addList.clear();
        addList.add(dataObj3);
        dataObj2.setList("ContainMany", addList);

        final Sequence sequence = dataObj3.getSequence();

        sequence.add("ContainMany", dataObj1);
    }
    
    public void setUp() {
    	if (!initialized) {
    	    staticScope = SDOUtil.createHelperContext();
            ContainmentFactory.INSTANCE.register(staticScope);
            
    	    dynamicScope = SDOUtil.createHelperContext();
            ContainmentTypeUtil.createDynamically(dynamicScope);
            
    	    mixedScope = SDOUtil.createHelperContext();
    	    mixedCreated = ContainmentTypeUtil.createDynamicWithStaticResources(mixedScope);
    	    
    	    initialized = true;
    	}
    }
}
