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

package org.apache.tuscany.samples.sdo.intermediate;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.tuscany.sdo.api.SDOUtil;
import org.apache.tuscany.sdo.model.ModelFactory;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLDocument;

// TODO -- make this a proper integrated sample
public class OppositeProperty {

  
  final HelperContext hc = SDOUtil.createHelperContext();
  static final String NSURI = "http://www.apache.org/tuscany/opposite"; 
  
  public static void main(String[] args) throws IOException {
    
    OppositeProperty inst = new OppositeProperty();
    inst.run();

  }

  private void run() throws IOException {

    
    final URL url = getClass().getResource("/sports.xsd");
    final InputStream inputStream = url.openStream();
    hc.getXSDHelper().define(inputStream, url.toString());
    inputStream.close();
    
    final URL url2 = getClass().getResource("/sports.xml");
    final InputStream inputStream2 = url2.openStream();
    XMLDocument unionDoc = hc.getXMLHelper().load(inputStream2, url2.toString(), null);
    inputStream2.close();
    
    {
      StringWriter w = new StringWriter();
      hc.getXMLHelper().save(unionDoc, w, null);
      System.out.println(w.toString());
    }
    
    DataObject union = unionDoc.getRootObject();
    DataObject p3 = union.getDataObject("member[ID=p3]");
    DataObject t0 = union.getDataObject("team[ID=t0]");
    t0.set("captain", p3);
    
    {
      StringWriter w = new StringWriter();
      hc.getXMLHelper().save(unionDoc, w, null);
      System.out.println(w.toString());
    }

    
  }

}
