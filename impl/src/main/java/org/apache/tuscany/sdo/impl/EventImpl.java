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
package org.apache.tuscany.sdo.impl;

import org.apache.tuscany.sdo.api.Event;
import org.eclipse.emf.common.notify.Notification;

import commonj.sdo.Property;


public class EventImpl implements Event {

  protected Notification emfEvent;
  protected Object notifier;

  public EventImpl(Notification notification)
  {
    this.emfEvent = notification;
  }
  
  public Object getNotifier()
  {
    return notifier == null ? emfEvent.getNotifier() : notifier;
  }

  public int getEventType()
  {
    return emfEvent.getEventType();
  }


  public Property getProperty()
  {
    return (Property)emfEvent.getFeature();
  }

  public Object getOldValue()
  {
    return emfEvent.getOldValue();
  }

  public Object getNewValue()
  {
    return emfEvent.getNewValue();
  }

  public boolean wasSet()
  {
    return emfEvent.wasSet();
  }

  public boolean isTouch()
  {
    return emfEvent.isTouch();
  }

  public int getPosition()
  {
    return emfEvent.getPosition();
  }
}
