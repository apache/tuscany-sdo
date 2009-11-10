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


import org.apache.tuscany.sdo.spi.HelperProviderBase;

import commonj.sdo.helper.HelperContext;

/**
 * Create and manage all the default helper INSTANCEs
 */
public class HelperProviderImpl extends HelperProviderBase
{   
  public HelperContext createDefaultHelpers()
  {
    //FB HelperContext hc = SDOUtil.createHelperContext();
    //FB The defulat HelperContext must use EMF's ClassLoader-delegating EPackage.Registry.INSTANCE, until we provide
    //FB another way to get (ClassLoader scope) support for HelperContext.
      HelperContext hc = new DefaultHelperContextImpl(false);
    typeHelper = hc.getTypeHelper();
    dataFactory = hc.getDataFactory();
    xmlHelper = hc.getXMLHelper();
    xsdHelper = hc.getXSDHelper();
    copyHelper = new CopyHelperImpl();
    equalityHelper = new EqualityHelperImpl();
    dataHelper = new DataHelperImpl();
    sdoHelper = new SDOHelperImpl();
    xmlStreamHelper = ((HelperContextImpl)hc).getXMLStreamHelper();
    
    return hc;
  }  
}
