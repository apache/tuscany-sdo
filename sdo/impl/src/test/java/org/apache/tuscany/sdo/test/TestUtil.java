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
import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TestUtil
{
  private static void getAllNodes(NodeList nodeList, List nodes)
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
  
  private static boolean equalNamedNodeMap(NamedNodeMap mapA, NamedNodeMap mapB) {
        if (mapA == null) {
            if (mapB == null) {
                return true;
            }
            return false;
        }
        if (mapA.getLength() != mapB.getLength()) {
            return false;
        }
        for (int i = 0; i < mapA.getLength(); i++) {
            Node trialNode = mapA.item(i);
            if (trialNode == null) {
                return false;
            }
            Node checkNode = mapB.getNamedItem(trialNode.getNodeName());
            if (checkNode == null) {
                return false;
            }
            if (!equalNode(trialNode, checkNode)) {
                return false;
            }
        }
        return true;
    }

    private static boolean equalNode(Node nodeA, Node nodeB) {
        if (nodeA == null) {
            if (nodeB == null) {
                return true;
            }
            return false;
        }
        // following is intended to provide same function as 1.5 isEqualNode()
        if (nodeA.getNodeType() != nodeB.getNodeType()) {
            return false;
        }
        if (!equalString(nodeA.getNodeName(), nodeB.getNodeName())) {
            return false;
        }
        if (!equalString(nodeA.getLocalName(), nodeB.getLocalName())) {
            return false;
        }
        if (!equalString(nodeA.getNamespaceURI(), nodeB.getNamespaceURI())) {
            return false;
        }
        if (!equalString(nodeA.getNamespaceURI(), nodeB.getNamespaceURI())) {
            return false;
        }
        if (!equalString(nodeA.getPrefix(), nodeB.getPrefix())) {
            return false;
        }
        if (!equalString(nodeA.getNodeValue(), nodeB.getNodeValue())) {
            return false;
        }
        if (!equalNamedNodeMap(nodeA.getAttributes(), nodeB.getAttributes())) {
            return false;
        }
        if (!equalNodeList(nodeA.getChildNodes(), nodeB.getChildNodes())) {
            return false;
        }
        if (nodeA.getNodeType() == Node.DOCUMENT_TYPE_NODE) {
            DocumentType documentTypeA = (DocumentType) nodeA;
            DocumentType documentTypeB = (DocumentType) nodeB;
            if (!equalString(documentTypeA.getPublicId(), documentTypeB.getPublicId())) {
                return false;
            }
            if (!equalString(documentTypeA.getSystemId(), documentTypeB.getSystemId())) {
                return false;
            }
            if (!equalString(documentTypeA.getInternalSubset(), documentTypeB.getInternalSubset())) {
                return false;
            }
            if (!equalNamedNodeMap(documentTypeA.getEntities(), documentTypeB.getEntities())) {
                return false;
            }
            if (!equalNamedNodeMap(documentTypeA.getNotations(), documentTypeB.getNotations())) {
                return false;
            }
        }
        return true;
    }

    private static boolean equalNodeList(NodeList nodeListA, NodeList nodeListB) {
        if (nodeListA == null) {
            if (nodeListB == null) {
                return true;
            }
            return false;
        }
        return equalNodes(nodeListA, nodeListB);
    }

    private static boolean equalString(String stringA, String stringB) {
        if (stringA == null) {
            if (stringB == null) {
                return true;
            }
            return false;
        }
        return stringA.equals(stringB);
    }
  
  private static boolean equalNodes(NodeList sourceNodeList, NodeList targetNodeList)
  {
    ArrayList sourceNodes = new ArrayList();
    ArrayList targetNodes = new ArrayList();
    
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
      Node sourceNode = (Node)sourceNodes.get(i);
      Node targetNode = (Node)targetNodes.get(i);
      
      /* remove comment when migrated to Java 1.5
      if (!sourceNode.isEqualNode(targetNode))
      {
        return false;
      }
      */
      // following is intended as 1.4 equivalent of isEqualNode()
      if (!equalNode(sourceNode, targetNode))
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

    sourceDocument.normalize();
    targetDocument.normalize();
    
    /* remove comment when migrated to Java 1.5 
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
    */

    NodeList sourceNodes = sourceDocument.getChildNodes();
    NodeList targetNodes = targetDocument.getChildNodes();
    
    return equalNodes(sourceNodes, targetNodes);
  }
}
