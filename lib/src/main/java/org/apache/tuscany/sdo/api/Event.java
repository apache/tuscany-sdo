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
package org.apache.tuscany.sdo.api;

import commonj.sdo.Property;

/**
 * An experimental Tuscany API interface, subject to possible change,
 * to permit notification of change events on a DataObject instance
 */
public interface Event {

    Object getNotifier();

    /**
     * constants returned from getEventType()
     */
    int SET = 1;
    int UNSET = 2;
    int ADD = 3;
    int REMOVE = 4;
    int ADD_MANY = 5;
    int REMOVE_MANY = 6;
    int MOVE = 7; 
    int REMOVE_LISTENER = 8;

    int getEventType();

    /**
     * get the Property for which the value changed
     */
    Property getProperty();
    Object getOldValue();
    Object getNewValue();
    
    /*
     * returns true if the Property value was in state "set" before this change occurred.
     */
    boolean wasSet();
    boolean isTouch();

    int NO_INDEX = -1;
    int getPosition();

  }

