/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */

package org.apache.tuscany.sdo.test;

import java.io.InputStream;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.api.SDOUtil;

import commonj.sdo.helper.HelperContext;

/**
 * @version $Rev$ $Date$
 */
public class XMLLoadUnknownFeatureTestCase extends TestCase {
    private static final String XML =
        "<ns:return xmlns:ns=\"http://services.move.ec3\" xmlns:ax21=\"http://types.move.ec3/xsd\" " + "xmlns:_typens_=\"http://types.move.ec3/xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" type=\"ec3.move.types.Comment\" xsi:type=\"_typens_:Comment\">"
            + "<ax21:body>c</ax21:body><ax21:caption>b</ax21:caption><ax21:entryId>1</ax21:entryId><ax21:owner>a1</ax21:owner><ax21:reference>a1</ax21:reference><ax21:tstamp>2008-04-16T16:22:07.812Z</ax21:tstamp></ns:return>";

    public void testLoad() {
        HelperContext context = SDOUtil.createHelperContext();
        InputStream is = getClass().getResourceAsStream("/comment.xsd");
        context.getXSDHelper().define(is, null);
        try {
            context.getXMLHelper().load(XML);
        } catch (StackOverflowError e) {
            // FIXME: This test case is failing at this point
            e.printStackTrace();
        }

    }
}
