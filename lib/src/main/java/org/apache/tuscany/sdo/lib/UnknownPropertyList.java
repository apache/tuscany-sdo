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
package org.apache.tuscany.sdo.lib;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;

import commonj.sdo.DataObject;

public class UnknownPropertyList extends AbstractList {
    protected List delegateList = Collections.EMPTY_LIST;
    protected DataObject dataObject;
    protected String path;

    public UnknownPropertyList(DataObject dataObject, String path) {
        this.dataObject = dataObject;
        this.path = path;
    }

    public Object get(int index) {
        return getDelegateList().get(index);
    }

    public int size() {
    	return getDelegateList().size();
    }

    public Object remove(int index) {
        return getDelegateList().remove(index);
    }
    public Object set(int index, Object element) {
        return getDelegateList().set(index, element);
    }

    public void add(int index, Object element) {
        if (getDelegateList() == Collections.EMPTY_LIST && index == 0) {
            dataObject.set(path, Collections.singletonList(element));
            delegateList = (List)dataObject.get(path);
        }
        else {        
        	delegateList.add(index, element);
        }
    }
    
    protected List getDelegateList() {
        if (delegateList == Collections.EMPTY_LIST) {
            List propertyList = (List)dataObject.get(path);
            if (propertyList != null) delegateList = propertyList;
        }
        return delegateList;
    }
}
