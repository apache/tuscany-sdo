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


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.util.SDOUtil;

import com.example.sequences.MixedQuote;
import com.example.sequences.MixedRepeatingChoice;
import com.example.sequences.RepeatingChoice;
import com.example.sequences.SequencesFactory;
import com.example.sequences.TwoRCs;
import com.example.sequences.TwoRCsMixed;
import commonj.sdo.DataObject;
import commonj.sdo.Sequence;
import commonj.sdo.Type;
import commonj.sdo.helper.XMLHelper;


public class StaticSequenceNoEmfTest extends TestCase {
    private final String TEST_NAMESPACE = "http://www.example.com/sequences";
    private final String MQ_TEST_DATA = "/mixedStaticTestResult.xml";
    private final String RC_TEST_DATA = "/repeatingChoiceTestResult.xml";
    private final String MRC_TEST_DATA = "/mixedRepeatingChoiceTestResult.xml";
    private final String RC2_TEST_DATA = "/twoRepeatingChoicesTestResult.xml";
    private final String RC2M_TEST_DATA = "/twoRepeatingChoicesMixedTestResult.xml";

    /**
     * Sequenced type SDO 2 test.
     */
    public void testMixedQuoteType() throws IOException {
        MixedQuote quote = SequencesFactory.INSTANCE.createMixedQuote();
        
        Type t = ((DataObject)quote).getType();
        List ps = t.getProperties();


        Sequence sequence = quote.getMixed();

        sequence.add("\n  ");

        quote.setSymbol("fbnt");

        sequence.add("\n  ");

        quote.setCompanyName("FlyByNightTechnology");

        sequence.add("\n  some text\n  ");

        List quotes = quote.getQuotes();
        MixedQuote child = SequencesFactory.INSTANCE.createMixedQuote();
        quotes.add(child);
        
        child.setPrice(new BigDecimal("2000.0"));

        sequence.add("\n  more text\n  ");

        sequence.add("price", new BigDecimal("1000.0"));

        sequence.add("\n");
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        XMLHelper.INSTANCE.save((DataObject)quote, TEST_NAMESPACE, "mixedStockQuote", baos);
        assertTrue(baos.toString(), TestUtil.equalXmlFiles(new ByteArrayInputStream(baos.toByteArray()), getClass().getResource(MQ_TEST_DATA)));
    }
    
    public void testRepeatingChoice() throws IOException
    {
      RepeatingChoice rc = SequencesFactory.INSTANCE.createRepeatingChoice();
      
      List as = rc.getA();
      List bs = rc.getB();
      
      bs.add(new Integer(1));      
      as.add("foo");
      as.add("bar");
      bs.add(new Integer(2));
     

      
     
      Sequence group = rc.getGroup();
      assertEquals(group.size(), 4);
      assertEquals(rc.getA().size(), 2);
      assertEquals(rc.getB().size(),2);
      
      assertEquals(group.getValue(0), new Integer(1));
      assertEquals(group.getValue(1), "foo");
      assertEquals(group.getValue(2), "bar");
      assertEquals(group.getValue(3), new Integer(2));
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      
      XMLHelper.INSTANCE.save((DataObject)rc, TEST_NAMESPACE, "rc", baos);
      assertTrue(baos.toString(), TestUtil.equalXmlFiles(new ByteArrayInputStream(baos.toByteArray()), getClass().getResource(RC_TEST_DATA)));
    }
    
    public void testMixedRepeatingChoice() throws Exception {
      MixedRepeatingChoice mrc = SequencesFactory.INSTANCE.createMixedRepeatingChoice();
      
      List as = mrc.getA();
      List bs = mrc.getB();
      

      bs.add(new Integer(1));
      as.add("foo");
      Sequence mixed = mrc.getMixed();
      mixed.add("some mixed text");
      as.add("bar");
      bs.add(new Integer(2));
      
      // FIXME reintroduce check
      // assertEquals(4, mrc.getGroup().size());
      assertEquals(5, mrc.getMixed().size());
      assertEquals(2, mrc.getA().size());
      assertEquals(2, mrc.getB().size(),2);
      
      
       
      assertEquals(mixed.getValue(0), new Integer(1));
      assertEquals(mixed.getValue(1), "foo");
      assertEquals(mixed.getValue(3), "bar");
      assertEquals(mixed.getValue(4), new Integer(2));
      
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      
      
      XMLHelper.INSTANCE.save((DataObject)mrc, TEST_NAMESPACE, "mrc", baos);
      assertTrue(baos.toString(), TestUtil.equalXmlFiles(new ByteArrayInputStream(baos.toByteArray()), getClass().getResource(MRC_TEST_DATA)));
    }
    
    public void test2RepeatingChoices()  throws Exception {
      TwoRCs rc2 = SequencesFactory.INSTANCE.createTwoRCs();
      
      List as = rc2.getA();
      List bs = rc2.getB();
      List ys = rc2.getY();
      List zs = rc2.getZ();
      
      zs.add(new Integer(99));
      bs.add(new Integer(1));      
      ys.add("fred");
      as.add("foo");
      as.add("bar");
      bs.add(new Integer(2));
      rc2.setSplit("banana");
     
     
      Sequence group = rc2.getGroup();
      assertEquals(group.size(), 4);
      assertEquals(rc2.getA().size(), 2);
      assertEquals(rc2.getB().size(),2);
      
      Sequence group1 = rc2.getGroup1();
      assertEquals(group1.size(), 2);
      assertEquals(rc2.getY().size(), 1);
      assertEquals(rc2.getZ().size(),1);
      
      assertEquals(group.getValue(0), new Integer(1));
      assertEquals(group.getValue(1), "foo");
      assertEquals(group.getValue(2), "bar");
      assertEquals(group.getValue(3), new Integer(2));
      assertEquals(group1.getValue(0), new Integer(99));
      assertEquals(group1.getValue(1), "fred");
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      

      XMLHelper.INSTANCE.save((DataObject)rc2, TEST_NAMESPACE, "rc2", baos);
      assertTrue(baos.toString(), TestUtil.equalXmlFiles(new ByteArrayInputStream(baos.toByteArray()), getClass().getResource(RC2_TEST_DATA)));
    }

    protected void setUp() throws Exception {
        super.setUp();
        SDOUtil.registerStaticTypes(SequencesFactory.class);
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void test2RepeatingChoicesMixed()  throws Exception {
      TwoRCsMixed rc2m = SequencesFactory.INSTANCE.createTwoRCsMixed();
      
      List as = rc2m.getA();
      List bs = rc2m.getB();
      List ys = rc2m.getY();
      List zs = rc2m.getZ();
      Sequence mixed = rc2m.getMixed();
      
      bs.add(new Integer(1));
      mixed.add("where will this appear?");
      as.add("foo");
      as.add("bar");
      bs.add(new Integer(2));
      rc2m.setSplit("pea");
      zs.add(new Integer(99));
      ys.add("fred");

    
      assertEquals(8, mixed.size());
      
      Sequence group = rc2m.getGroup();
      // FIXME reintroduce test assertEquals(4, group.size());
      assertEquals(rc2m.getA().size(), 2);
      assertEquals(rc2m.getB().size(),2);
      
      Sequence group1 = rc2m.getGroup1();
      // FIXME ditto assertEquals(group1.size(), 2);
      assertEquals(rc2m.getY().size(), 1);
      assertEquals(rc2m.getZ().size(),1);
      
      int i = 0;
      assertEquals(mixed.getValue(i++), new Integer(1));
      assertEquals(mixed.getValue(i++), "where will this appear?");
      assertEquals(mixed.getValue(i++), "foo");
      assertEquals(mixed.getValue(i++), "bar");
      assertEquals(mixed.getValue(i++), new Integer(2));
      assertEquals(mixed.getValue(i++), "pea");
      assertEquals(mixed.getValue(i++), new Integer(99));
      assertEquals(mixed.getValue(i++), "fred");
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      
      XMLHelper.INSTANCE.save((DataObject)rc2m, TEST_NAMESPACE, "rc2m", baos);
      assertTrue(baos.toString(), TestUtil.equalXmlFiles(new ByteArrayInputStream(baos.toByteArray()), getClass().getResource(RC2M_TEST_DATA)));
    }
    
    
}
