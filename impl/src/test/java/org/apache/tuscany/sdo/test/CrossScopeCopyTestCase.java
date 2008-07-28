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
import java.math.BigDecimal;
import java.net.URL;
import java.util.Iterator;
import java.util.Vector;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.api.SDOUtil;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;
import commonj.sdo.helper.CopyHelper;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;

public class CrossScopeCopyTestCase extends TestCase 
{
   // Literals
   private static final String TEST_NAMESPACE  = "http://www.example.com/bank";
   private static final String BANK_MODEL      = "/bank.xsd";
   private static final String BANK_TYPE       = "bankType";
   private static final String BRANCH_TYPE     = "branchType";
   private static final String SERVICE_TYPE    = "serviceType";
   private static final String ACCOUNT_TYPE    = "accountType";
   private static final String CUSTOMER_TYPE   = "customerType";
   private static final String ADDRESS_TYPE    = "addressType";
   private static final String DYNAMIC_TYPE    = "dynamicType";
    
   // SDO model objects
   private HelperContext hca;
   private HelperContext hcb;
   private TypeHelper scopeA;
   private TypeHelper scopeB;

   // SDO instance objects
   private DataObject bankSDO;
   private DataObject branchSDO1;
   private DataObject branchSDO2;
   private DataObject serviceSDO1;
   private DataObject serviceSDO2;
   private DataObject serviceSDO3;
   private DataObject customerSDO1;
   private DataObject customerSDO2;
   private DataObject customerSDO3;
   private DataObject customerSDO4;
    
   private int indent = 0;
    
   public void testCrossScopeCopy() throws IOException 
   {
       CopyHelper copyHelperB = SDOUtil.createCrossScopeCopyHelper(hcb);
       
       // Perform Shallow Copy Test 
       DataObject copiedSDO = copyHelperB.copyShallow(bankSDO);
       shallowCopyAssertions(bankSDO, copiedSDO);
       
       // Perform Deep Copy Test
       copiedSDO = copyHelperB.copy(bankSDO);
       deepCopyAssertions(bankSDO, copiedSDO);
       
       // Inter-Reference Copy
       copiedSDO = copyHelperB.copy(customerSDO1);
       DataObject prop = (DataObject)copiedSDO.get("HomeBranch");
       assertTrue(prop==null);
       
       // Perform invalid namespace test
       DataObject sdo = hca.getDataFactory().create(TEST_NAMESPACE, DYNAMIC_TYPE );
       sdo.set("custNum", "099" );
       sdo.set("firstName", "John");
       sdo.set("lastName", "Doe");
       boolean failed = false;
       try
       {
           // In this case, we are copying an object to a scope 
           // where the object's type has not been defined.  That
           // will generate a null pointer exception what we will 
           // catch.
           copyHelperB.copy(sdo);
       }
       catch(java.lang.NullPointerException ex)
       {
           failed = true;
       }
       assertTrue(failed);
   }

   protected void setUp() throws Exception 
   {
       super.setUp();

       // Create Two Scopes
       hca = SDOUtil.createHelperContext();
       hcb = SDOUtil.createHelperContext();
       scopeA = hca.getTypeHelper();
       scopeB = hcb.getTypeHelper();
          
       // Populate scopes with bank model now
       URL url = getClass().getResource(BANK_MODEL);
       InputStream inputStream = url.openStream();
       hca.getXSDHelper().define(inputStream, url.toString());
       inputStream.close();
       inputStream = url.openStream();
       hcb.getXSDHelper().define(inputStream, url.toString());
       inputStream.close();

       // Now Populate scopeA with some dynamic models
       populateScopeWithDynamicTypes(scopeA);
       
       // Construct Source Tree
       constructSourceTree(hca.getDataFactory());
   }   

   private void shallowCopyAssertions(DataObject sdo, DataObject copiedSdo)
   {
       assertEquals(sdo.getType().getName(), copiedSdo.getType().getName());
       assertEquals(sdo.getType().getURI(), copiedSdo.getType().getURI());
       assertNotSame(sdo.getType(), copiedSdo.getType());
       assertEquals(sdo.getInstanceProperties().size(), copiedSdo
                    .getInstanceProperties().size());

       for(Iterator it = sdo.getInstanceProperties().iterator(), it2 = copiedSdo
           .getInstanceProperties().iterator(); it.hasNext();)
       {
           Property p1 = (Property) it.next(), p2 = (Property) it2.next();
           assertEquals(p1.getName(), p2.getName());
           Object o1 = sdo.get(p1), o2 = copiedSdo.get(p2);
           if(p1.getType().isDataType())
           {
               assertEquals(o1, o2);
               // TODO is there a way I can distinguish between mutable and
               // immutable types
               // so that I can do some "same object" tests
           }
           else
           {
               assertNotSame(p1, p2);
               if(p2.isMany())
               {
                   assertEquals(copiedSdo.getList(p2).size(), 0);
               }
               else
               {
                   assertNull(copiedSdo.get(p2));
               }
           }
           try
           {
               sdo.get(p2);
               assertTrue(false);
           }
           catch(Exception e)
           {
               // expected route
           }
           try
           {
               copiedSdo.get(p1);
               assertTrue(false);
           }
           catch(Exception e2)
           {
               // expected route
           }
       }
   }
   
   private void deepCopyAssertions(DataObject sdo, DataObject copiedSdo)
   {
       //indent();
       
       //System.out.println("checking objects of types: "
       //                   + sdo.getType().getName() + ", "
       //                   + copiedSdo.getType().getName());
       indent++;

       assertEquals(sdo.getType().getName(), copiedSdo.getType().getName());
       assertEquals(sdo.getType().getURI(), copiedSdo.getType().getURI());
       assertNotSame(sdo.getType(), copiedSdo.getType());
       assertEquals(sdo.getInstanceProperties().size(), copiedSdo
                    .getInstanceProperties().size());

       for(Iterator it = sdo.getInstanceProperties().iterator(), it2 = copiedSdo
           .getInstanceProperties().iterator(); it.hasNext();)
       {
           Property p1 = (Property) it.next(), p2 = (Property) it2.next();
           assertEquals(p1.getName(), p2.getName());
           Object o1 = sdo.get(p1), o2 = copiedSdo.get(p2);
           if(p1.getType().isDataType())
           {
               assertEquals(o1, o2);
               // TODO is there a way I can distinguish between mutable and
               // immutable types
               // so that I can do some "same object" tests
           }
           else
           {
               assertNotSame(p1, p2);
               if(p2.isMany())
               {
                   assertEquals(sdo.getList(p1).size(), copiedSdo.getList(p2)
                                .size());
                   for(Iterator it3 = sdo.getList(p1).iterator(), it4 = copiedSdo
                       .getList(p2).iterator(); it3.hasNext();)
                   {
                       deepCopyAssertions((DataObject) it3.next(),
                                          (DataObject) it4.next());
                   }
               }
               else
               {
                   deepCopyAssertions(sdo.getDataObject(p1), copiedSdo
                                      .getDataObject(p2));
               }
           }
           try
           {
               sdo.get(p2);
               assertTrue(false);
           }
           catch(Exception e)
           {
               // expected route
           }
           try
           {
               copiedSdo.get(p1);
               assertTrue(false);
           }
           catch(Exception e2)
           {
               // expected route
           }
       }

       indent--;
   }

   /*
   private void indent()
   {
       for(int i=0; i <indent; i++) System.out.print(" ");
   }
   */   
   
   protected void constructSourceTree(DataFactory df)
   {
       // Create Instances
       bankSDO      = df.create(TEST_NAMESPACE, BANK_TYPE );
       branchSDO1   = df.create(TEST_NAMESPACE, BRANCH_TYPE );  
       branchSDO2   = df.create(TEST_NAMESPACE, BRANCH_TYPE );  
       serviceSDO1  = df.create(TEST_NAMESPACE, SERVICE_TYPE );  
       serviceSDO2  = df.create(TEST_NAMESPACE, SERVICE_TYPE );  
       serviceSDO3  = df.create(TEST_NAMESPACE, SERVICE_TYPE );  
       customerSDO1 = df.create(TEST_NAMESPACE, CUSTOMER_TYPE );  
       customerSDO2 = df.create(TEST_NAMESPACE, CUSTOMER_TYPE );  
       customerSDO3 = df.create(TEST_NAMESPACE, CUSTOMER_TYPE );  
       customerSDO4 = df.create(TEST_NAMESPACE, CUSTOMER_TYPE );  
       
       // Populate the Bank Instance
       bankSDO.set("name", "Fourth National");
       Vector v = new Vector();
       v.add(branchSDO1);
       v.add(branchSDO2);
       bankSDO.set("Branch",v);
       v.removeAllElements();
       v.add(serviceSDO1);
       v.add(serviceSDO2);
       v.add(serviceSDO3);
       bankSDO.set("Service",v);
       v.removeAllElements();
       v.add(customerSDO1);
       v.add(customerSDO2);
       v.add(customerSDO3);
       v.add(customerSDO4);
       bankSDO.set("Customer",v);
       v.removeAllElements();
       
       // Populate Branch Instances
       // Branch 1
       branchSDO1.set("ID", "BR100");
       DataObject addr = df.create(TEST_NAMESPACE, ADDRESS_TYPE );
       addr.set("Street", "1302 Money Street");
       addr.set("City",   "Apex");
       addr.set("State", "NC");
       addr.set("Zip", "27502");
       branchSDO1.set("Address", addr);
       v.add("If you are north, head south");
       v.add("If you are south, head north");
       branchSDO1.set("Directions", v);
       v.removeAllElements();
       DataObject account1 = df.create(TEST_NAMESPACE, ACCOUNT_TYPE );
       account1.set("ID", "0000 1200 0001");
       account1.set("Service",  serviceSDO1 );
       account1.setBigDecimal("Balance", new BigDecimal("3124.12"));
       v.add(account1);
       DataObject account2 = df.create(TEST_NAMESPACE, ACCOUNT_TYPE );
       account2.set("ID", "0000 8899 0001");
       account2.set("Service",  serviceSDO1 );
       account2.setBigDecimal("Balance", new BigDecimal("20.00"));
       v.add(account2);
       DataObject account3 = df.create(TEST_NAMESPACE, ACCOUNT_TYPE );
       account3.set("ID", "0000 3110 0020");
       account3.set("Service",  serviceSDO3 );
       account3.setBigDecimal("Balance", new BigDecimal("5000.00"));
       v.add(account3);
       branchSDO1.set("Account", v);
       v.removeAllElements();
       // Branch 2
       branchSDO2.set("ID", "BR200");
       addr = df.create(TEST_NAMESPACE, ADDRESS_TYPE );
       addr.set("Street", "1207 Cash Court");
       addr.set("City",  "Raleigh");
       addr.set("State", "NC");
       addr.set("Zip", "27701");
       branchSDO2.set("Address", addr);
       v.add("If you are east, head west");
       v.add("If you are west, head east");
       branchSDO2.set("Directions", v);
       v.removeAllElements();
       DataObject account4 = df.create(TEST_NAMESPACE, ACCOUNT_TYPE );
       account4.set("ID", "0000 0011 0001");
       account4.set("Service",  serviceSDO1 );
       account4.setBigDecimal("Balance", new BigDecimal("99.12"));
       v.add(account4);
       DataObject account5 = df.create(TEST_NAMESPACE, ACCOUNT_TYPE );
       account5.set("ID", "0000 9911 0001");
       account5.set("Service",  serviceSDO2 );
       account5.setBigDecimal("Balance", new BigDecimal("820.00"));
       v.add(account5);
       DataObject account6 = df.create(TEST_NAMESPACE, ACCOUNT_TYPE );
       account6.set("ID", "0000 0001 0020");
       account6.set("Service",  serviceSDO3 );
       account6.setBigDecimal("Balance", new BigDecimal("9000.00"));
       v.add(account6);
       branchSDO2.set("Account", v);
       v.removeAllElements();
       
       // Populate Service Instances
       serviceSDO1.set("ID", "SRV01");  
       serviceSDO1.set("Name", "Checking");  
       serviceSDO1.setBigDecimal("Fee", new BigDecimal("0.00"));
       serviceSDO2.set("ID", "SRV02");  
       serviceSDO2.set("Name", "Savings");  
       serviceSDO2.setBigDecimal("Fee", new BigDecimal("0.00"));
       serviceSDO3.set("ID", "SRV03");  
       serviceSDO3.set("Name", "Loan");  
       serviceSDO3.setBigDecimal("Fee", new BigDecimal("0.00"));
       
       // Populate Customer Instances
       // Customer 1
       customerSDO1.set("ID", "CUST01");  
       customerSDO1.set("First", "James");  
       customerSDO1.set("Last", "Madison");  
       addr = df.create(TEST_NAMESPACE, ADDRESS_TYPE );
       addr.set("Street", "1234 Easy Street");
       addr.set("City",  "New York");
       addr.set("State", "NY");
       addr.set("Zip", "27511");
       customerSDO1.set("Address", addr);
       customerSDO1.set("HomeBranch", branchSDO1);
       v.add(account1);
       customerSDO1.set("Account", v);
       v.removeAllElements();
       v.add(customerSDO2);
       v.add(customerSDO3);
       customerSDO1.set("Related", v);
       v.removeAllElements();
       // Customer 2
       customerSDO2.set("ID", "CUST02");  
       customerSDO2.set("First", "George");  
       customerSDO2.set("Last", "Washington");  
       addr = df.create(TEST_NAMESPACE, ADDRESS_TYPE );
       addr.set("Street", "1776 Potomac Avenue");
       addr.set("City",  "Washington");
       addr.set("State", "DC");
       addr.set("Zip", "50555");
       customerSDO2.set("Address", addr);
       customerSDO2.set("HomeBranch", branchSDO1);
       v.add(account2);
       v.add(account3);
       customerSDO2.set("Account", v);
       v.removeAllElements();
       // Customer 3
       customerSDO3.set("ID", "CUST03");  
       customerSDO3.set("First", "Thomas");  
       customerSDO3.set("Last", "Jefferson");  
       addr = df.create(TEST_NAMESPACE, ADDRESS_TYPE );
       addr.set("Street", "1492 Columbus Avenue");
       addr.set("City",  "Charlottesville");
       addr.set("State", "VA");
       addr.set("Zip", "20121");
       customerSDO3.set("Address", addr);
       customerSDO3.set("HomeBranch", branchSDO2);
       v.add(account4);
       customerSDO3.set("Account", v);
       v.removeAllElements();
       // Customer 4
       customerSDO4.set("ID", "CUST04");  
       customerSDO4.set("First", "Benjamin");  
       customerSDO4.set("Last", "Franklin");  
       addr = df.create(TEST_NAMESPACE, ADDRESS_TYPE );
       addr.set("Street", "99 Light Street");
       addr.set("City",  "Philadelphia");
       addr.set("State", "PA");
       addr.set("Zip", "19251");
       customerSDO4.set("Address", addr);
       customerSDO4.set("HomeBranch", branchSDO2);
       v.add(account5);
       v.add(account6);
       customerSDO4.set("Account", v);
       v.removeAllElements();
       
   }
   
   private void populateScopeWithDynamicTypes(TypeHelper scope)
   {
       Type stringType = scope.getType("commonj.sdo", "String");
       DataObject customerType = DataFactory.INSTANCE.create("commonj.sdo", "Type");
       customerType.set("uri", TEST_NAMESPACE);
       customerType.set("name", DYNAMIC_TYPE );
       DataObject custNumProperty = customerType.createDataObject("property");
       custNumProperty.set("name", "custNum");
       custNumProperty.set("type", stringType);
       DataObject firstNameProperty = customerType.createDataObject("property");
       firstNameProperty.set("name", "firstName");
       firstNameProperty.set("type", stringType);
       DataObject lastNameProperty = customerType.createDataObject("property");
       lastNameProperty.set("name", "lastName");
       lastNameProperty.set("type", stringType);
       scope.define(customerType);
   }
   
   /*
   private void dumpObject(DataObject sdo, String node )
   {
       try 
       {
           ByteArrayOutputStream baos = new ByteArrayOutputStream();
           SDOUtil.createXMLHelper(scopeA).save(sdo, TEST_NAMESPACE, 
                                   node, baos);
           System.out.println(baos.toString());
       } 
       catch (IOException e)
       {
           e.printStackTrace();
       }
   }  
   */ 
}
