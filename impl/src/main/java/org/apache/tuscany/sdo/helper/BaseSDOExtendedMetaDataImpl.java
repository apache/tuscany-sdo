/**
 * <copyright>
 *
 * Copyright (c) 2003-2004 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: BasicExtendedMetaData.java,v 1.26 2006/04/29 11:45:28 emerks Exp $
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
  protected EcoreFactory ecoreFactory;

  public BaseSDOExtendedMetaDataImpl(EcoreFactory ecoreFactory)
  {
    super();
    this.ecoreFactory = ecoreFactory;
  }

  public BaseSDOExtendedMetaDataImpl(EPackage.Registry registry, EcoreFactory ecoreFactory)
  {
    super(registry);
    this.ecoreFactory = ecoreFactory;
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
      documentRootEClass.getESuperTypes().add(XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot());
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
      eClass.getESuperTypes().add(XMLTypePackage.eINSTANCE.getAnyType());
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
        eReference.setEType(EcorePackage.eINSTANCE.getEObject());
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
        eAttribute.setEType(XMLTypePackage.eINSTANCE.getAnySimpleType());
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
