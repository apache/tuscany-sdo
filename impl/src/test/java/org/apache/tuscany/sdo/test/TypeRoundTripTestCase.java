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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.util.SDOUtil;

import commonj.sdo.Type;
import commonj.sdo.helper.DataHelper;
import commonj.sdo.helper.TypeHelper;

public class TypeRoundTripTestCase extends TestCase {

  private static class Test {
    Type type;
    String value;
    Object obj;
    Comparator comp;
    
    Test(Type type, String value, Object obj) {
      this.type = type;
      this.value = value;
      this.obj = obj;
    }
    
    Test(Type type, String value, Object obj, Comparator comp) {
      this.type = type;
      this.value = value;
      this.obj = obj;
      this.comp = comp;
    }    
  }
  
  private static class ListComparator implements Comparator {
    public int compare(Object list1, Object list2) {
      int answer = 1;
      if (list1 instanceof List && list2 instanceof List) {
        List l1 = (List) list1;
        List l2 = (List) list2;
        if (l1.size() == l2.size()) {
          for (int n = 0; n < l1.size(); n++) {
            if (!l1.get(n).equals(l2.get(n))) {
              answer = 0;
              break;
            }
          }
        } else {
          answer = 0;
        }
      } else {
        answer = 0;
      }
      return answer;
    }    
  }
  
  private static class BytesComparator implements Comparator {
    public int compare(Object o1, Object o2) {
      o2 = new String((byte[])o2);
      if (o1.equals(o2)) return 1;
      else return 0;
    }
  }
  
  public void testTypeRoundTrips() throws Exception {
    String URI = "commonj.sdo";
    TypeHelper types = TypeHelper.INSTANCE;
    
    List list = new ArrayList();
    list.add("foo");
    list.add("bar");
    list.add("test");
    Test[] tests = {
      new Test(types.getType(URI, "Boolean"),      "true", new Boolean(true)),
      new Test(types.getType(URI, "Byte"),         "49", new Byte((byte)49)),
      new Test(types.getType(URI, "Bytes"),        "666F6F", "foo", new BytesComparator()),
      new Test(types.getType(URI, "Character"),    "a", new Character('a')),
      new Test(types.getType(URI, "Date"),         "2005-12-12T12:12:12.012Z", DataHelper.INSTANCE.toDate("2005-12-12T12:12:12.012Z")),
      new Test(types.getType(URI, "DateTime"),     "2005-12-12T12:12:12zz", "2005-12-12T12:12:12zz"),
      new Test(types.getType(URI, "Day"),          "---12", "---12"),
      new Test(types.getType(URI, "Decimal"),      "12.12", new BigDecimal("12.12")),
      new Test(types.getType(URI, "Double"),       "12.12", new Double(12.12)),
      new Test(types.getType(URI, "Duration"),     "P5Y2M10D", "P5Y2M10D"),
      new Test(types.getType(URI, "Float"),        "12.12", new Float(12.12f)),
      new Test(types.getType(URI, "Int"),          "12", new Integer(12)),
      new Test(types.getType(URI, "Integer"),      "12", new BigInteger("12")),
      new Test(types.getType(URI, "Long"),         "12", new Long(12l)),
      new Test(types.getType(URI, "Month"),        "--12", "--12"),
      new Test(types.getType(URI, "MonthDay"),     "--12-12", "--12-12"),
      new Test(types.getType(URI, "Object"),       "test", "test"),
      new Test(types.getType(URI, "Short"),        "12", new Short((short)12)),
      new Test(types.getType(URI, "String"),       "test", "test"),
      new Test(types.getType(URI, "Strings"),      "foo bar test", list, new ListComparator()),
      new Test(types.getType(URI, "Time"),         "12:12:12.12", "12:12:12.12"),
      new Test(types.getType(URI, "URI"),          "http://example.org", "http://example.org"),
      new Test(types.getType(URI, "Year"),         "2005", "2005"),
      new Test(types.getType(URI, "YearMonth"),    "2005-12", "2005-12"),
      new Test(types.getType(URI, "YearMonthDay"), "2005-12-12", "2005-12-12")
    };
    
    for (int n = 0; n < tests.length; n++) {
      assertEquals(
        SDOUtil.convertToString(tests[n].type, SDOUtil.createFromString(tests[n].type, tests[n].value)), 
        tests[n].value
      );
      
      //System.out.print(".");
      
      if (tests[n].comp == null) {
        assertEquals(
          SDOUtil.createFromString(tests[n].type, SDOUtil.convertToString(tests[n].type, tests[n].obj)), 
          tests[n].obj
        );
      } else {
        String o1 = SDOUtil.convertToString(tests[n].type, tests[n].obj);
        Object o2 = SDOUtil.createFromString(tests[n].type, o1);
        assertEquals(tests[n].comp.compare(tests[n].obj, o2), 1);
      }
    }
    
  }
  
}
