/**
 *
 *  Copyright 2005 The Apache Software Foundation or its licensors, as applicable.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.tuscany.sdo.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TestUtil
{
  private static void getAllNodes(NodeList nodeList, List<Node> nodes)
  {
    int length = nodeList.getLength();
    if (length == 0)
    {
      return;
    }
    
    for (int i=0; i<length; i++)
    {
      Node node = nodeList.item(i);
      nodes.add(node);
      getAllNodes(node.getChildNodes(), nodes);
    } // for
  }
  
  private static boolean equalNodes(NodeList sourceNodeList, NodeList targetNodeList)
  {
    ArrayList<Node> sourceNodes = new ArrayList<Node>();
    ArrayList<Node> targetNodes = new ArrayList<Node>();
    
    getAllNodes(sourceNodeList, sourceNodes);
    getAllNodes(targetNodeList, targetNodes);
    
    int sourceLength = sourceNodes.size();
    int targetLength = targetNodes.size();
    
    if (sourceLength != targetLength)
    {
      return false;
    }
    
    for (int i=0; i<sourceLength; i++)
    {
      Node sourceNode = sourceNodes.get(i);
      Node targetNode = targetNodes.get(i);
      
      if (!sourceNode.isEqualNode(targetNode))
      {
        return false;
      }
    } // for
    
    return true;
  }
  
  public static boolean equalXmlFiles(URL source, URL target)
  { 
    try {
      return equalXmlFiles(source.openStream(), target.openStream());
    }
    catch (IOException e)
    {
      return false;
    }
  }
  
  public static boolean equalXmlFiles(InputStream sourceStream, URL target)
  {
    try {
      return equalXmlFiles(sourceStream, target.openStream());
    }
    catch (IOException e)
    {
      return false;
    }
  }
  
  public static boolean equalXmlFiles(URL source, InputStream targetStream)
  {
    try {
      return equalXmlFiles(source.openStream(), targetStream);
    }
    catch (IOException e)
    {
      return false;
    }
  }
  
  public static boolean equalXmlFiles(InputStream sourceStream, InputStream targetStream)
  {
    DocumentBuilder builder;
    Document sourceDocument;
    Document targetDocument;
    
    try {
      builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      sourceDocument = builder.parse(sourceStream);
      targetDocument = builder.parse(targetStream);
    }
    catch (FactoryConfigurationError fce) {
      return false;
    }
    catch (ParserConfigurationException ce) {
      return false;
    }
    catch (SAXException se)
    {
      return false;
    }
    catch (IOException ie)
    {
      return false;
    }

    sourceDocument.normalizeDocument();
    targetDocument.normalizeDocument();
    
    if (!sourceDocument.getXmlVersion().equals(targetDocument.getXmlVersion()))
    {
      return false;
    }
    
    String sourceXmlEncoding = sourceDocument.getXmlEncoding();
    String targetXmlEncoding = targetDocument.getXmlEncoding();
    
    if (sourceXmlEncoding != null && targetXmlEncoding != null &&
        sourceXmlEncoding.equalsIgnoreCase(targetXmlEncoding))
    {
      // continue
    }
    else
    {
      return false;
    }

    NodeList sourceNodes = sourceDocument.getChildNodes();
    NodeList targetNodes = targetDocument.getChildNodes();
    
    return equalNodes(sourceNodes, targetNodes);
  }
}
