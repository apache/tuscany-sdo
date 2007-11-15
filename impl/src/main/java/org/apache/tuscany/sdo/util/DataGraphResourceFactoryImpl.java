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
package org.apache.tuscany.sdo.util;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.tuscany.sdo.SDOFactory;
import org.apache.tuscany.sdo.SDOPackage;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;
import org.apache.tuscany.sdo.impl.ChangeSummaryImpl;
import org.apache.tuscany.sdo.impl.DataGraphImpl;
import org.apache.tuscany.sdo.impl.DynamicDataObjectImpl;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.EcoreBuilder;
import org.eclipse.emf.ecore.xmi.NameInfo;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.SAXXMLHandler;
import org.eclipse.emf.ecore.xmi.impl.XMLHelperImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLLoadImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLSaveImpl;
import org.eclipse.emf.ecore.xmi.util.DefaultEcoreBuilder;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;

import commonj.sdo.ChangeSummary;
import commonj.sdo.helper.TypeHelper;


public class DataGraphResourceFactoryImpl extends ResourceFactoryImpl
{
  /**
   * Constructor for DataGraphResourceFactoryImpl.
   */
  public DataGraphResourceFactoryImpl()
  {
    super();
  }
  
  public Resource createResource(URI uri)
  {
    XMLResourceImpl result = new DataGraphResourceImpl(uri);

    ExtendedMetaData extendedMetaData = ((TypeHelperImpl)TypeHelper.INSTANCE).getExtendedMetaData();
    DataObjectUtil.configureXMLResource(result, extendedMetaData);
    
    result.getDefaultSaveOptions().put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
    result.getDefaultLoadOptions().put(XMLResource.OPTION_USE_DEPRECATED_METHODS, Boolean.TRUE);
    //result.setEncoding("UTF-8");
    //result.getDefaultLoadOptions().put(XMLResource.OPTION_USE_LEXICAL_HANDLER, Boolean.TRUE);
    //result.getDefaultSaveOptions().put(XMLResource.OPTION_LINE_WIDTH, new Integer(80));

    return result;
  }

  public static class DataGraphResourceImpl extends XMLResourceImpl
  {
    public DataGraphResourceImpl(URI uri)
    {
      super(uri);
    }
    
    public static class HelperImpl extends XMLHelperImpl
    {
      protected DataGraphImpl eDataGraph;

      protected List resources;
      protected List uris;
      
      public HelperImpl(XMLResource xmlResource)
      {
        super(xmlResource);
      }
      
      public void setResource(XMLResource resource)
      {
        super.setResource(resource);
        if (!resource.getContents().isEmpty())
        {
          eDataGraph = (DataGraphImpl)resource.getContents().get(0);

          resources = new ArrayList();
          uris = new ArrayList();

          resources.add(eDataGraph.getRootResource());
          uris.add("#" + resource.getURIFragment(eDataGraph) + "/@eRootObject");

          if (eDataGraph.getEChangeSummary() != null)
          {
            // Ensure that resource exists.
            //
            resources.add(((EObject)eDataGraph.getChangeSummary()).eResource());
            uris.add("#" + resource.getURIFragment(eDataGraph) + "/@eChangeSummary");
          }

          if (eDataGraph.eResource() != null && eDataGraph.eResource().getResourceSet() != null)
          {
            int count = 0;
            for (Iterator i = eDataGraph.eResource().getResourceSet().getResources().iterator(); i.hasNext();)
            {
              Resource ePackageResource = (Resource)i.next();
              List resourceContents = ePackageResource.getContents();
              if (resourceContents.size() == 1 && resourceContents.get(0) instanceof EPackage)
              {
                resources.add(ePackageResource);
                uris.add("#" + resource.getURIFragment(eDataGraph) + "/@models." + count++);
              }
            }
          }
        }
      }

      public String getID(EObject eObject)
      {
        return super.getID(eObject);
      }

      public String getIDREF(EObject eObject)
      {
        String fragment = super.getIDREF(eObject);
        if (fragment.startsWith("/"))
        {
          int index = resources.indexOf(eObject.eResource());
          if (index != -1)
          {
            fragment = ((String)uris.get(index)).substring(1) + fragment.substring(1);
          }
        }
        return fragment;
      }

      public String getHREF(EObject eObject)
      {
        return super.getHREF(eObject);
      }

      protected URI getHREF(Resource otherResource, EObject obj)
      {
        int index = resources.indexOf(otherResource);
        if (index == -1)
        {
          return super.getHREF(otherResource, obj);
        }
        else
        {
          return createHREF((String)uris.get(index), otherResource.getURIFragment(obj));
        }
      }

      protected URI createHREF(String baseURI, String fragment)
      {
        if (fragment.startsWith("/"))
        {
          return URI.createURI(baseURI + fragment.substring(1));
        }
        else
        {
          return URI.createURI("#" + fragment);
        }
      }
      
      public void populateNameInfo(NameInfo nameInfo, EClass c)
      {
        if (c == SDOPackage.eINSTANCE.getDataGraph())
        {
          if (extendedMetaData != null)
          {
            extendedMetaData.demandPackage("commonj.sdo").setNsPrefix("sdo");
          }
          nameInfo.setQualifiedName(getQName("commonj.sdo", "datagraph"));
          nameInfo.setNamespaceURI("commonj.sdo");
          nameInfo.setLocalPart("datagraph");
        }
        else if (c == SDOPackage.eINSTANCE.getChangeSummary())
        {
          if (extendedMetaData != null)
          {
            extendedMetaData.demandPackage("commonj.sdo").setNsPrefix("sdo");
          }
          nameInfo.setQualifiedName("changeSummary");
          nameInfo.setNamespaceURI(null);
          nameInfo.setLocalPart("changeSummary");
        }
        else
        {
          super.populateNameInfo(nameInfo, c);
        }
      }

      public String getQName(EClass c)
      {
        if (c == SDOPackage.eINSTANCE.getDataGraph())
        {
          if (extendedMetaData != null)
          {
            extendedMetaData.demandPackage("commonj.sdo").setNsPrefix("sdo");
          }
          return getQName("commonj.sdo", "datagraph");
        }
        else if (c == SDOPackage.eINSTANCE.getChangeSummary())
        {
          if (extendedMetaData != null)
          {
            extendedMetaData.demandPackage("commonj.sdo").setNsPrefix("sdo");
          }
          return getQName((String)null, "changeSummary");
        }
        else
        {
          return super.getQName(c);
        }
      }
    }

    protected XMLHelper createXMLHelper()
    {
      return new HelperImpl(this);
    }

    protected EObject getEObjectByID(String id)
    {
      List contents = getContents();
      if (contents.size() >= 1)
      {
        Object rootObject = contents.get(0);
        if (rootObject instanceof DataGraphImpl)
        {
          DataGraphImpl eDataGraph = (DataGraphImpl)rootObject;
          EObject result = eDataGraph.getRootResource().getEObject(id);
          if (result != null)
          {
            return result;
          }
          else
          {
            ChangeSummary eChangeSummary = eDataGraph.getEChangeSummary();
            if (eChangeSummary != null)
            {
              result = ((EObject)eDataGraph.getChangeSummary()).eResource().getEObject(id);
              if (result != null)
              {
                return result;
              }
            }
          }
        }
      }
      return super.getEObjectByID(id);
    }

    public static class SaveImpl extends XMLSaveImpl
    {
      protected DataGraphImpl eDataGraph;

      public SaveImpl(XMLHelper xmlHelper)
      {
        super(xmlHelper);
      }

      public void traverse(List contents)
      {
        if (contents.size() >= 1 && contents.get(0) instanceof DataGraphImpl)
        {
          eDataGraph = (DataGraphImpl)contents.get(0);
                   
          Object datagraphMark = null;
          if (!toDOM)
          {
            if (declareXML)
            {
              doc.add("<?xml version=\"" + xmlVersion + "\" encoding=\"" + encoding + "\"?>");
              doc.addLine();
            }
            String elementName = helper.getQName(eDataGraph.eClass());
            doc.startElement(elementName);
            datagraphMark = doc.mark();
          }
          else
          {
            helper.populateNameInfo(nameInfo, eDataGraph.eClass());
            currentNode = document.createElementNS(nameInfo.getNamespaceURI(), nameInfo.getQualifiedName());
            document.appendChild(currentNode);
            // not calling handler since there is no corresponding EObject
          }

          if (eDataGraph.eResource() != null && eDataGraph.eResource().getResourceSet() != null)
          {
            List ePackages = new ArrayList();
            for (Iterator i = eDataGraph.eResource().getResourceSet().getResources().iterator(); i.hasNext();)
            {
              List resourceContents = ((Resource)i.next()).getContents();
              if (resourceContents.size() == 1 && resourceContents.get(0) instanceof EPackage)
              {
                ePackages.add(resourceContents.get(0));
              }
            }
            if (!ePackages.isEmpty())
            {
              if (!toDOM)
              {
                doc.startElement("models");
                doc.addAttribute("xmlns", "");
              }
              else
              {
                currentNode = currentNode.appendChild(document.createElementNS(null, "models"));
                ((Element)currentNode).setAttributeNS(ExtendedMetaData.XMLNS_URI, ExtendedMetaData.XMLNS_PREFIX, "");
                //  not calling handler since there is no corresponding EObject
              }
              for (Iterator i = ePackages.iterator(); i.hasNext();)
              {
                writeTopObject((EPackage)i.next());
              }
              if (!toDOM)
              {
                doc.endElement();
              }
              else
              {
                currentNode = currentNode.getParentNode();
              }
            }
          }

          // use namespace declarations defined in the document (if any)
          EObject eRootObject = eDataGraph.getERootObject();
          EReference xmlnsPrefixMapFeature = extendedMetaData.getXMLNSPrefixMapFeature(eRootObject.eClass());
          if (xmlnsPrefixMapFeature != null)
          {
            EMap xmlnsPrefixMap = (EMap)eRootObject.eGet(xmlnsPrefixMapFeature);
            helper.setPrefixToNamespaceMap(xmlnsPrefixMap);
          }
          ChangeSummary changeSummary = eDataGraph.getEChangeSummary();

          if (changeSummary != null)
          {
            helper.setMustHavePrefix(true);
            if (changeSummary.isLogging())
            {
              ((ChangeSummaryImpl)changeSummary).summarize();
              writeTopObject((EObject)changeSummary);
            }
            else
            {
              writeTopObject((EObject)changeSummary);
            }
            helper.setMustHavePrefix(false);
          }

          if (eRootObject != null && writeTopObject(eRootObject) == null && !toDOM)
          {
            doc.addLine();
            doc.setMixed(false);
          }
          if (!toDOM)
          {
            doc.endElement();
            // reset to add namespace declarations
            //
            doc.resetToMark(datagraphMark);
          }
          else
          {
            currentNode = document.getFirstChild();
          }
          addNamespaceDeclarations();
        }
        else
        {
          super.traverse(contents);
        }
      }

      protected void writeTopAttributes(EObject top)
      {
        if (top == eDataGraph.getEChangeSummary())
        {
          if (!toDOM)
          {
            doc.addAttribute("xmlns", "");
            doc.addAttribute("logging", String.valueOf(eDataGraph.getEChangeSummary().isLogging()));
          }
          else
          {
            ((Element)currentNode).setAttributeNS(ExtendedMetaData.XMLNS_URI, ExtendedMetaData.XMLNS_PREFIX, "");
            ((Element)currentNode).setAttributeNS("", "logging", String.valueOf(eDataGraph.getEChangeSummary().isLogging()));
          }
        }
      }

      protected EObject getSchemaLocationRoot(EObject eObject)
      {
        return eDataGraph.getERootObject();
      }
    }

    protected XMLSave createXMLSave()
    {
      return new SaveImpl(createXMLHelper());
    }

    public static class LoadImpl extends XMLLoadImpl
    {
      protected boolean resumeLogging = false;
      
      public void load(XMLResource resource, InputSource inputSource, Map options) throws IOException
      {
        super.load(resource, inputSource, options);
        if (resumeLogging) ((ChangeSummaryImpl)((DataGraphImpl)resource.getContents().get(0)).getChangeSummary()).resumeLogging();
      }

      public void load(XMLResource resource, InputStream inputStream, Map options) throws IOException
      {
        super.load(resource, inputStream, options);
        if (resumeLogging) ((ChangeSummaryImpl)((DataGraphImpl)resource.getContents().get(0)).getChangeSummary()).resumeLogging();
      }

      public void load(XMLResource resource, Node node, Map options) throws IOException
      {
        super.load(resource, node, options);
        if (resumeLogging) ((ChangeSummaryImpl)((DataGraphImpl)resource.getContents().get(0)).getChangeSummary()).resumeLogging();
      }

      public LoadImpl(XMLHelper xmlHelper)
      {
        super(xmlHelper);
      }

      protected DefaultHandler makeDefaultHandler()
      {
        return new SAXXMLHandler(resource, helper, options)
          {
            protected DataGraphImpl eDataGraph;

            protected boolean isInModels;

            protected List ePackages = new ArrayList();

            protected EObject createDocumentRoot(String prefix, String uri, String name, EFactory eFactory, boolean top)
            {
              return null;
            }

            protected void setAttribValue(EObject object, String name, String value)
            {
              if ("logging".equals(name) && object instanceof ChangeSummaryImpl)
              {
                resumeLogging = Boolean.valueOf(value).booleanValue();
              }
              else
              {
                super.setAttribValue(object, name, value);
              }
            }
            
            protected EMap recordNamespacesSchemaLocations(EObject root)
            {
              EObject dgroot = eDataGraph.getERootObject();
              if (dgroot == null)
              {
                return null;
              }
              EMap prefixToNamespaceMap = super.recordNamespacesSchemaLocations(dgroot);
              if (prefixToNamespaceMap != null)
              {
                for (Iterator i = prefixToNamespaceMap.iterator(); i.hasNext();)
                {
                  Map.Entry entry = (Map.Entry)i.next();
                  String prefix = (String)entry.getKey();
                  String namespace = (String)entry.getValue();
                  if (namespace.equals("commonj.sdo"))
                  {
                    prefixToNamespaceMap.removeKey(prefix);
                    break;
                  }
                }
              }
              return prefixToNamespaceMap;
            }

            protected void handleFeature(String prefix, String name)
            {
              if (isInModels && objects.size() == 2)
              {
                EObject modelObject = createObjectByType(prefix, name, false);
                processObject(modelObject);
                ePackages.add(modelObject);
              }
              else if (objects.size() == 1)
              {
                eDataGraph = (DataGraphImpl)objects.peek();
                eDataGraph.getResourceSet();
                if ("".equals(prefix) && "changeSummary".equals(name))
                {
                  ChangeSummary eChangeSummary = (ChangeSummary)createObjectFromFactory(SDOFactory.eINSTANCE, "ChangeSummary");
                  eDataGraph.setEChangeSummary(eChangeSummary);
                  processObject((EObject)eChangeSummary);
                }
                else if ("".equals(prefix) && "models".equals(name))
                {
                  isInModels = true;
                  types.push(OBJECT_TYPE);
                  objects.push(eDataGraph);
                  mixedTargets.push(null);
                }
                else if (eDataGraph.getERootObject() == null)
                {
                  if (useNewMethods)
                  {
                    handleSchemaLocation();
                  }
                  processSchemaLocations(prefix, name);
                  if (processAnyXML)
                  {
                    // Ensure that anything can be handled, even if it's not recognized.
                    //
                    String namespaceURI = helper.getURI(prefix);
                    if (extendedMetaData.getPackage(namespaceURI) == null)
                    {
                      EStructuralFeature rootFeature = extendedMetaData.demandFeature(namespaceURI, name, true);
                      rootFeature.getEContainingClass().getEPackage().setEFactoryInstance(new DynamicDataObjectImpl.FactoryImpl());
                    }
                  }

                  //FB TEMPORARY allow loading proper serialization (global element instead of type name)
                  //FB Proper fix is to reimplement DataGraph as proper DataObject, and remove this entire class
                  EStructuralFeature rootFeature = extendedMetaData.getElement(helper.getURI(prefix), name);
                  if (rootFeature != null) name = rootFeature.getEType().getName();
                  
                  EObject rootObject = createObjectByType(prefix, name, false);
                  
                  eDataGraph.setERootObject(rootObject);
                  processObject(rootObject);
                  if (rootObject != null
                    && rootObject.eClass() == ExtendedMetaData.INSTANCE.getDocumentRoot(rootObject.eClass().getEPackage()))
                  {
                    super.handleFeature(prefix, name);

                    // Remove the document root from the stack.
                    //
                    Object mixedTarget = mixedTargets.pop();
                    Object object = objects.pop();
                    mixedTargets.pop();
                    objects.pop();
                    mixedTargets.push(mixedTarget);
                    objects.push(object);
                  }
                }
              }
              else
              {
                super.handleFeature(prefix, name);
              }
            }

            public void endElement(String uri, String localName, String name)
            {
              if (isInModels && objects.size() == 2)
              {
                if (!ePackages.isEmpty())
                {
                  for (Iterator i = ePackages.iterator(); i.hasNext();)
                  {
                    EPackage ePackage = (EPackage)i.next();
                    ePackage.setEFactoryInstance(new DynamicDataObjectImpl.FactoryImpl());
                    Resource resource = resourceSet.createResource(URI.createURI("*.ecore"));
                    resource.getContents().add(ePackage);
                    if (ePackage.getNsURI() != null)
                    {
                      resource.setURI(URI.createURI(ePackage.getNsURI()));
                    }

                    if (extendedMetaData != null)
                    {
                      extendedMetaData.putPackage(extendedMetaData.getNamespace(ePackage), ePackage);
                    }
                    else
                    {
                      packageRegistry.put(ePackage.getNsURI(), ePackage);
                    }
                  }
                  handleForwardReferences();
                }
                isInModels = false;
              }
              // TODO The following 3 lines of code are a temporary work-around for JIRA issue TUSCANY-1862. 
              // These lines of code should be removed when TUSCANY-1862 is resolved.
              if ("".equals(uri) && "objectsToAttach".equals(name) && text != null && text.length() == 0)
              {
                text = null;
              }              
              super.endElement(uri, localName, name);
            }

            protected EPackage getPackageForURI(String uriString)
            {
              if ("commonj.sdo".equals(uriString))
              {
                return SDOPackage.eINSTANCE;
              }
              else
              {
                return super.getPackageForURI(uriString);
              }
            }

            protected EObject createObjectFromFactory(EFactory factory, String typeName)
            {
              if (factory == SDOFactory.eINSTANCE)
              {
                if ("datagraph".equals(typeName))
                {
                  return super.createObjectFromFactory(factory, "DataGraph");
                }
              }
              return super.createObjectFromFactory(factory, typeName);
            }

            protected EcoreBuilder createEcoreBuilder(Map options, ExtendedMetaData extendedMetaData)
            {
              return new DefaultEcoreBuilder(extendedMetaData)
                {
                  public Collection generate(Map urisToLocations) throws Exception
                  {
                    Collection result = super.generate(urisToLocations);
                    return updateDynamicFactory(result);
                  }

                  public Collection generate(Collection urisToLocations) throws Exception
                  {
                    Collection result = super.generate(urisToLocations);
                    return updateDynamicFactory(result);
                  }

                  protected Collection updateDynamicFactory(Collection result)
                  {
                    for (Iterator i = result.iterator(); i.hasNext();)
                    {
                      Resource resource = (Resource)i.next();
                      for (Iterator j = EcoreUtil.getObjectsByType(resource.getContents(), EcorePackage.eINSTANCE.getEPackage()).iterator(); j.hasNext();)
                      {
                        EPackage ePackage = (EPackage)j.next();
                        ePackage.setEFactoryInstance(new DynamicDataObjectImpl.FactoryImpl());
                      }
                    }
                    return result;
                  }

                };
            }

            protected EPackage handleMissingPackage(String uriString)
            {
              EPackage result = super.handleMissingPackage(uriString);
              if (processAnyXML && objects.size() == 1)
              {
                result = extendedMetaData.demandPackage(uriString);
              }
              return result;
            }
          };
      }
    }

    protected XMLLoad createXMLLoad()
    {
      return new LoadImpl(createXMLHelper());
    }
  }
}
