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
package org.apache.tuscany.sdo.rtlib.util;

import java.util.List;

import org.apache.tuscany.sdo.api.SDOUtil;

import commonj.sdo.DataObject;
import commonj.sdo.Property;


public final class DataObjectUtil 
{
	protected static StringBuffer getXPath(DataObject dataObject, StringBuffer path, DataObject root) {
		DataObject container = dataObject.getContainer();
		if (container == null)
			return path;

		if (container == root) {
			throw new IllegalStateException(
					"There is a cycle in the containment hierarchy of " + root);
		}

		boolean first = path.length() == 0;
		Property property = dataObject.getContainmentProperty();
		if (SDOUtil.isMany(property, dataObject)) {
			List list = container.getList(property);
			int pos = list.indexOf(dataObject);
			path.insert(0, property.getName() + "." + pos + (first ? "" : "/"));
		} else {
			path.insert(0, property.getName() + (first ? "" : "/"));
		}

		return getXPath(container, path, root);
	}

	public static String getXPath(DataObject dataObject) {
		StringBuffer path = getXPath(dataObject, new StringBuffer(), dataObject);
		return path.toString();
	}

}
