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

package org.apache.tuscany.sdo.helper;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import commonj.sdo.helper.CopyHelper;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.DataHelper;
import commonj.sdo.helper.EqualityHelper;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;

public class HelperContextImpl implements HelperContext {
		
	private DataFactory dataFactory;
	private TypeHelper typeHelper;
	private XMLHelper xmlHelper;
	private XSDHelper xsdHelper;

	
	public HelperContextImpl(TypeHelper scope) {
		if(scope == null) {
		    EPackage.Registry registry = new EPackageRegistryImpl(EPackage.Registry.INSTANCE);
		    ExtendedMetaData extendedMetaData = new SDOExtendedMetaDataImpl(registry); //TODO create subclass that makes demand() methods synchronous
		    typeHelper = new TypeHelperImpl(extendedMetaData);
		} else {
			typeHelper = scope;
		}
		dataFactory = new DataFactoryImpl(typeHelper);
		xmlHelper = new XMLHelperImpl(typeHelper);
		xsdHelper = new XSDHelperImpl(typeHelper);
	}

	public CopyHelper getCopyHelper() {
		return CopyHelper.INSTANCE;
	}

	public DataFactory getDataFactory() {
		return dataFactory;
	}

	public DataHelper getDataHelper() {
		return DataHelper.INSTANCE;
	}

	public EqualityHelper getEqualityHelper() {
		return EqualityHelper.INSTANCE;
	}

	public TypeHelper getTypeHelper() {
		return typeHelper;
	}

	public XMLHelper getXMLHelper() {
		return xmlHelper;
	}

	public XSDHelper getXSDHelper() {
		return xsdHelper;
	}

}
