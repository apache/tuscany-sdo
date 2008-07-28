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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * A BasicExtendedMetaData that uses a supplied (SDO) ecore factory to create properties and types.
 */
public class BaseSDOExtendedMetaDataImpl extends BasicExtendedMetaData
{
  protected EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;
  protected DemandMetaData demandMetaData = new DemandMetaData();
  
  public static class DemandMetaData {
    EClassifier getEObject() { return EcorePackage.eINSTANCE.getEObject(); }
    EClassifier getAnyType() { return XMLTypePackage.eINSTANCE.getAnyType(); }
    EClassifier getAnySimpleType() { return XMLTypePackage.eINSTANCE.getAnySimpleType(); }
    EClassifier getXMLTypeDocumentRoot() { return XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot(); }
  }

  public BaseSDOExtendedMetaDataImpl(EPackage.Registry registry)
  {
    super(registry);
  }

  public EPackage demandPackage(String namespace)
  {
    EPackage ePackage = demandRegistry.getEPackage(namespace);
    if (ePackage == null)
    {
      ePackage = ecoreFactory.createEPackage();
      ePackage.setNsURI(namespace);
      setQualified(ePackage, namespace != null);
      if (namespace != null)
      {
        ePackage.setNsPrefix
          (namespace.equals(ExtendedMetaData.XMLNS_URI) ? 
             namespace.equals(ExtendedMetaData.XML_URI) ?
               "xml" : 
               "xmlns" : 
             computePrefix(namespace));
      }
      demandRegistry.put(namespace, ePackage);

      // demandDocumentRoot(ePackage);

      EClass documentRootEClass = ecoreFactory.createEClass();
      documentRootEClass.getESuperTypes().add(demandMetaData.getXMLTypeDocumentRoot());
      documentRootEClass.setName("DocumentRoot");
      ePackage.getEClassifiers().add(documentRootEClass);
      setDocumentRoot(documentRootEClass);
    }
    return ePackage;
  }
  
  public EClassifier demandType(String namespace, String name)
  {
    EPackage ePackage = demandPackage(namespace);
    EClassifier eClassifier = getType(ePackage, name);
    if (eClassifier != null)
    {
      return eClassifier;
    }
    else
    {
      EClass eClass = ecoreFactory.createEClass();
      eClass.setName(name);
      eClass.getESuperTypes().add(demandMetaData.getAnyType());
      setContentKind(eClass, MIXED_CONTENT);
      ePackage.getEClassifiers().add(eClass);
      return eClass;
    }
  }

  public EStructuralFeature demandFeature(String namespace, String name, boolean isElement, boolean isReference)
  {
    EPackage ePackage = demandPackage(namespace);
    EClass documentRootEClass = getDocumentRoot(ePackage);
    EStructuralFeature eStructuralFeature = 
      isElement ? 
        getLocalElement(documentRootEClass, namespace, name) : 
        getLocalAttribute(documentRootEClass, namespace, name);
    if (eStructuralFeature != null)
    {
      return eStructuralFeature;
    }
    else
    {
      if (isReference)
      {
        EReference eReference = ecoreFactory.createEReference();
        eReference.setContainment(isElement);
        eReference.setEType(demandMetaData.getEObject());
        eReference.setName(name);
        eReference.setDerived(true);
        eReference.setTransient(true);
        eReference.setVolatile(true);
        documentRootEClass.getEStructuralFeatures().add(eReference);

        setFeatureKind(eReference, isElement ? ELEMENT_FEATURE : ATTRIBUTE_FEATURE);
        setNamespace(eReference, namespace);

        // Mark the bound as unspecified so that it won't be considered many
        // but can nevertheless be recognized as being unspecified and perhaps still be treat as many.
        //
        if (isElement)
        {
          eReference.setUpperBound(ETypedElement.UNSPECIFIED_MULTIPLICITY);
        }

        return eReference;
      }
      else
      {
        EAttribute eAttribute = ecoreFactory.createEAttribute();
        eAttribute.setName(name);
        eAttribute.setEType(demandMetaData.getAnySimpleType());
        eAttribute.setDerived(true);
        eAttribute.setTransient(true);
        eAttribute.setVolatile(true);
        documentRootEClass.getEStructuralFeatures().add(eAttribute);

        setFeatureKind(eAttribute, isElement ? ELEMENT_FEATURE : ATTRIBUTE_FEATURE);
        setNamespace(eAttribute, namespace);

        // Mark the bound as unspecified so that it won't be considered many
        // but can nevertheless be recognized as being unspecified and perhaps still be treat as many.
        //
        if (isElement)
        {
          eAttribute.setUpperBound(ETypedElement.UNSPECIFIED_MULTIPLICITY);
        }

        return eAttribute;
      }
    }
  }
}
