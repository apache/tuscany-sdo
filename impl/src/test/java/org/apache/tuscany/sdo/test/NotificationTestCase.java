/**
 *
 *   Licensed to the Apache Software Foundation (ASF) under one
 *   or more contributor license agreements.  See the NOTICE file
 *   distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *   to you under the Apache License, Version 2.0 (the
 *   "License"); you may not use this file except in compliance
 *   with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing,
 *   software distributed under the License is distributed on an
 *   "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *   KIND, either express or implied.  See the License for the
 *   specific language governing permissions and limitations
 *   under the License.
 *
 */
package org.apache.tuscany.sdo.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.api.SDOUtil;
import org.apache.tuscany.sdo.api.Event;
import org.apache.tuscany.sdo.impl.ListenerBase;

import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;

/**
 * Test DataObject Property value change notification
 */
public class NotificationTestCase extends TestCase {

  HelperContext hc;
  TypeHelper th;

  private class Observer extends ListenerBase {

    private int notificationCount;
    private Event lastEvent;

    public int getNotificationCount() {
      return notificationCount;
    }

    public Event getLastEvent() {
      return lastEvent;
    }

    public Observer() {
      notificationCount = 0;
    }

    public void eventNotification(Event e) {

      if (e.getEventType() != Event.REMOVE_LISTENER) {
        notificationCount++;
        lastEvent = e;
      }
    }

  }

  public void testTransitions() throws IOException {
    final String TEST_MODEL = "/simple.xsd";
    final String TEST_NAMESPACE = "http://www.example.com/simple";

    // Populate the meta data for the test (Stock Quote) model
    URL url = getClass().getResource(TEST_MODEL);
    InputStream inputStream = url.openStream();
    hc.getXSDHelper().define(inputStream, url.toString());
    inputStream.close();

    Type quoteType = th.getType(TEST_NAMESPACE, "Quote");
    DataObject quote = hc.getDataFactory().create(quoteType);
    Observer o = new Observer();
    SDOUtil.addChangeListener(quote, o);

    Event e;

    String firstName = "FlyByNightTechnology";

    int changeCount = 0;
    
    quote.setString("companyName", firstName);
    assertEquals(++changeCount, o.getNotificationCount());
    e = o.getLastEvent();
    assertEquals(Event.SET, e.getEventType());
    assertEquals(null, e.getOldValue());
    assertFalse(e.wasSet());

    quote.setString("companyName", "FBNT");
    e = o.getLastEvent();
    assertTrue(e.wasSet());

    assertEquals(firstName, e.getOldValue());
    assertEquals(++changeCount, o.getNotificationCount());
    assertEquals("companyName", e.getProperty().getName());

    SDOUtil.removeChangeListener(quote, o);

    quote.setString("companyName", "3rdValue");
    e = o.getLastEvent();

    assertEquals(firstName, e.getOldValue());
    assertEquals(changeCount /* no ++ */, o.getNotificationCount());

    SDOUtil.addChangeListener(quote, o);

    quote.setString("companyName", "3rdValue");
    assertEquals(++changeCount, o.getNotificationCount());
    e = o.getLastEvent();
    assertTrue(e.isTouch());
    assertTrue(e.wasSet());

    quote.unset("companyName");
    assertEquals(++changeCount, o.getNotificationCount());
    e = o.getLastEvent();
    assertTrue(e.wasSet());
   

    quote.set("companyName", "4thValue");
    assertEquals(++changeCount, o.getNotificationCount());
    e = o.getLastEvent();
    assertFalse(e.wasSet());
    
    assertEquals(Event.NO_INDEX, e.getPosition());
    
    DataObject child = quote.createDataObject("quotes");
    assertEquals(++changeCount, o.getNotificationCount());
    e = o.getLastEvent();
    assertFalse(e.wasSet());
    assertEquals(0, e.getPosition());
    assertEquals(Event.ADD, e.getEventType());
    
    DataObject child2 = quote.createDataObject("quotes");
    assertEquals(++changeCount, o.getNotificationCount());
    e = o.getLastEvent();
    assertTrue(e.wasSet());  // the quotes property was previously set to a non empty list
    assertEquals(1, e.getPosition());
    
    child2.setString("companyName", "subsidiary");
    
    assertEquals(changeCount /* no ++ */, o.getNotificationCount()); // not monitoring the child
    
    quote.getList("quotes").clear();
    e = o.getLastEvent();
    assertEquals(++changeCount, o.getNotificationCount());
    assertEquals(Event.REMOVE_MANY, e.getEventType());
    
    List newList = new ArrayList();
    
    newList.add(hc.getDataFactory().create(quoteType));
    newList.add(hc.getDataFactory().create(quoteType));
    
    quote.getList("quotes").addAll(newList);
    e = o.getLastEvent();
    assertEquals(++changeCount, o.getNotificationCount());
    assertEquals(Event.ADD_MANY, e.getEventType());
    

    

  }
  

  protected void setUp() throws Exception {
    super.setUp();

    hc = SDOUtil.createHelperContext();
    th = hc.getTypeHelper();

  }

}
