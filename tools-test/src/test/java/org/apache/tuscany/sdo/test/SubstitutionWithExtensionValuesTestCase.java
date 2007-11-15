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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.api.SDOUtil;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import com.example.substitution.ev.SEVFactory;
import com.example.substitution.ev.impl.SEVFactoryImpl;
import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.impl.HelperProvider;

public final class SubstitutionWithExtensionValuesTestCase extends TestCase 
{
  private static String sev2NamespaceURI;
  private HelperContext hc;
  private DataObject dataObject;
  
  protected void setUp() throws Exception {
    super.setUp();
    hc = HelperProvider.getDefaultContext();
    registerSEV(hc, true);
    
    InputStream inputStream = null;
    URL url = getClass().getResource("/substitutionWithExtensionValues2.xsd");
    inputStream = url.openStream();
    List sev2TypeList = hc.getXSDHelper().define(inputStream, url.toString());
    inputStream.close();
    
    inputStream = getClass().getResourceAsStream("/substitutionWithExtensionValues1.xml");
    dataObject = hc.getXMLHelper().load(inputStream).getRootObject();
    inputStream.close();
    
    if (sev2NamespaceURI == null)
    {
      sev2NamespaceURI = ((Type) sev2TypeList.get(0)).getURI();
    }
  }
  
  private void registerSEV(HelperContext hc, boolean useStaticRegistration) throws IOException
  {
    if (useStaticRegistration)
    {
      SEVFactory.INSTANCE.register(hc);
    }
    else
    {
      InputStream inputStream = null;
      URL url = getClass().getResource("/substitutionWithExtensionValues.xsd");
      inputStream = url.openStream();
      hc.getXSDHelper().define(inputStream, url.toString());
      inputStream.close();
    }
  }

  public void testComplexTypeWithSubstitutionExtension() throws IOException 
  {
    TypeHelper typeHelper = hc.getTypeHelper();
    
    Type resultsType = typeHelper.getType(SEVFactoryImpl.NAMESPACE_URI, "ResultsType");
    Type results2Type = typeHelper.getType(sev2NamespaceURI, "Results2Type");
    assertTrue("Results2 type does not report Results as a base type", 
        results2Type.getBaseTypes().contains(resultsType));
    
    assertEquals("results.1/myResult.0/id has unexpected value", 
        "BBBBBBBBBBBBBBBBBBBB", dataObject.getString("results.1/myResult.0/id"));
  }
  
  public void testComplexTypeWithSimpleContentExtensionMetaData() 
  {
    TypeHelper typeHelper = hc.getTypeHelper();
    
    Type commentType = typeHelper.getType(SEVFactoryImpl.NAMESPACE_URI, "CommentType");
    Type myCommentType = typeHelper.getType(SEVFactoryImpl.NAMESPACE_URI, "MyCommentType");
    Type _myCommentType = typeHelper.getType(SEVFactoryImpl.NAMESPACE_URI, "_MyCommentType");
    Type comment2Type = typeHelper.getType(sev2NamespaceURI, "Comment2Type");
    Type _comment2Type = typeHelper.getType(sev2NamespaceURI, "_Comment2Type");
    assertTrue("MyComment type does not report Comment as a base type", 
        myCommentType.getBaseTypes().contains(commentType));
    assertTrue("Comment2 type does not report Comment as a base type", 
        comment2Type.getBaseTypes().contains(commentType));
    
    // Test length facets - resort to EMF APIs until Tuscany SDO exposes these directly
    ExtendedMetaData extendedMetaData = ExtendedMetaData.INSTANCE;

    EStructuralFeature simpleFeature = null;
    EDataType commentSimpleType = null;
    
    // FIXME Work-around EMF's lack of support for re-definable features - SEE TUSCANY-1832
    commentSimpleType = (EDataType) _myCommentType;
    assertEquals(40, extendedMetaData.getMaxLengthFacet(commentSimpleType));
    
    // FIXME Work-around EMF's lack of support for re-definable features - SEE TUSCANY-1832
    commentSimpleType = (EDataType) _comment2Type;
    assertEquals(20, extendedMetaData.getMaxLengthFacet(commentSimpleType));
  }

  public void testComplexTypeWithSimpleContentExtensionChangeSummary() throws IOException 
  {
    DataGraph dg = SDOUtil.createDataGraph();
    SDOUtil.setRootObject(dg, dataObject);
    dg.getChangeSummary().beginLogging();
    dataObject.getDataObject("results.1/myResult.0").delete();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    SDOUtil.saveDataGraph(dg, baos, null);
    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
    SDOUtil.loadDataGraph(bais, null, hc);
  }    
  
  public void testSimpleTypeExtension() 
  {
    TypeHelper typeHelper = hc.getTypeHelper();
    
    Type asciiStringType = typeHelper.getType(SEVFactoryImpl.NAMESPACE_URI, "AsciiStringType");
    Type idType = typeHelper.getType(SEVFactoryImpl.NAMESPACE_URI, "IdType");
    assertTrue("IdType does not report AsciiStringType as a base type", 
        idType.getBaseTypes().contains(asciiStringType));
    
    Type id2Type = typeHelper.getType(sev2NamespaceURI, "Id2Type");
    assertTrue("Id2Type does not report IdType as a base type", 
        id2Type.getBaseTypes().contains(idType));
  }
}
