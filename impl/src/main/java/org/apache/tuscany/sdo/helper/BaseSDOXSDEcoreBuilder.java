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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDAttributeDeclaration;
import org.eclipse.xsd.XSDAttributeUse;
import org.eclipse.xsd.XSDComplexTypeContent;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDComponent;
import org.eclipse.xsd.XSDContentTypeCategory;
import org.eclipse.xsd.XSDDerivationMethod;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDFeature;
import org.eclipse.xsd.XSDLengthFacet;
import org.eclipse.xsd.XSDMaxLengthFacet;
import org.eclipse.xsd.XSDMinLengthFacet;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDModelGroupDefinition;
import org.eclipse.xsd.XSDNamedComponent;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTerm;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.XSDVariety;
import org.eclipse.xsd.XSDWildcard;
import org.eclipse.xsd.ecore.XSDEcoreBuilder;
import org.eclipse.xsd.util.XSDConstants;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * An XSDEcoreBuilder that uses a supplied (SDO) ecore factory to create properties and types.
 */
public class BaseSDOXSDEcoreBuilder extends XSDEcoreBuilder
{
  protected EcorePackage ecorePackage = EcorePackage.eINSTANCE;
  protected EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;

  public BaseSDOXSDEcoreBuilder(ExtendedMetaData extendedMetaData)
  {
    super(extendedMetaData);
  }
  
  private void createDocumentRoot(XSDSchema xsdSchema, EPackage ePackage) {
      EClass documentEClass = ecoreFactory.createEClass();
      String name = getEcoreAttribute(xsdSchema, "documentRoot");
      if (name == null)
      {
        name = "DocumentRoot";
      }
      documentEClass.setName(name);

      extendedMetaData.setDocumentRoot(documentEClass);

      ePackage.getEClassifiers().add(documentEClass);

      createFeature
        (documentEClass,
         "mixed",
         ecorePackage.getEFeatureMapEntry(),
         null,
         0,
         -1);

      EStructuralFeature xmlnsPrefixMapFeature =
        createFeature
          (documentEClass,
           "xMLNSPrefixMap",
           ecorePackage.getEStringToStringMapEntry(),
           null,
           0,
           -1);
      extendedMetaData.setName(xmlnsPrefixMapFeature, "xmlns:prefix");

      EStructuralFeature xsiSchemaLocationMapFeature =
        createFeature
          (documentEClass,
           "xSISchemaLocation",
           ecorePackage.getEStringToStringMapEntry(),
           null,
           0,
           -1);
      extendedMetaData.setName(xsiSchemaLocationMapFeature, "xsi:schemaLocation");
  }

  public EPackage getEPackage(XSDNamedComponent xsdNamedComponent)
  {
    XSDSchema containingXSDSchema = xsdNamedComponent.getSchema();
    if (containingXSDSchema != null && !xsdSchemas.contains(containingXSDSchema))
    {
      xsdSchemas.add(containingXSDSchema);
      addInput(containingXSDSchema);
      validate(containingXSDSchema);
    }

    String targetNamespace = 
      containingXSDSchema == null ? 
        xsdNamedComponent.getTargetNamespace() : 
        containingXSDSchema.getTargetNamespace();
    EPackage ePackage = (EPackage)targetNamespaceToEPackageMap.get(targetNamespace);
    if (ePackage == null)
    {
      ePackage = ecoreFactory.createEPackage();
      setAnnotations(ePackage, containingXSDSchema);
      addOutput(ePackage);
      if (targetNamespace == null)
      {
        if (containingXSDSchema == null)
        {
          containingXSDSchema = rootSchema;
        }
        ePackage.setName(validName(containingXSDSchema.eResource().getURI().trimFileExtension().lastSegment(), true));
        ePackage.setNsURI(containingXSDSchema.eResource().getURI().toString());

        // Also register against the nsURI for the case that the target namespace is null.
        //
        // extendedMetaData.putPackage(ePackage.getNsURI(), ePackage);
      }
      else
      {
        String qualifiedPackageName = qualifiedPackageName(targetNamespace);
        ePackage.setName(qualifiedPackageName);
        ePackage.setNsURI(targetNamespace);
      }

      String nsPrefix = ePackage.getName();
      int index = nsPrefix.lastIndexOf('.');
      nsPrefix = index == -1 ? nsPrefix : nsPrefix.substring(index + 1);

      // http://www.w3.org/TR/REC-xml-names/#xmlReserved
      // Namespace Constraint: Leading "XML"
      // Prefixes beginning with the three-letter sequence x, m, l, in any case combination, 
      // are reserved for use by XML and XML-related specifications.
      //
      if (nsPrefix.toLowerCase().startsWith("xml"))
      {
        nsPrefix = "_" + nsPrefix;
      }
      ePackage.setNsPrefix(nsPrefix);

      extendedMetaData.setQualified(ePackage, targetNamespace != null);
      extendedMetaData.putPackage(targetNamespace, ePackage);

      targetNamespaceToEPackageMap.put(targetNamespace, ePackage);
      
      createDocumentRoot(xsdNamedComponent.getSchema(), ePackage);
    }

    return ePackage;
  }

  protected EClassifier computeEClassifier(XSDTypeDefinition xsdTypeDefinition)
  {
    if (xsdTypeDefinition == null)
    {
      return getBuiltInEClassifier(rootSchema.getSchemaForSchemaNamespace(), "anySimpleType");
    }
    else if (xsdTypeDefinition instanceof XSDSimpleTypeDefinition)
    {
      return computeEDataType((XSDSimpleTypeDefinition)xsdTypeDefinition);
    }
    else
    {
      return computeEClass((XSDComplexTypeDefinition)xsdTypeDefinition);
    }
  }

  protected EDataType computeEDataType(XSDSimpleTypeDefinition xsdSimpleTypeDefinition)
  {
    if (xsdSimpleTypeDefinition == null)
    {
      return (EDataType)getBuiltInEClassifier(rootSchema.getSchemaForSchemaNamespace(), "anySimpleType");
    }
    else if (XSDConstants.isSchemaForSchemaNamespace(xsdSimpleTypeDefinition.getTargetNamespace()))
    {
      String name = xsdSimpleTypeDefinition.getName();
      if (name != null)
      {
        EDataType result = (EDataType)getBuiltInEClassifier(xsdSimpleTypeDefinition.getTargetNamespace(), "anyType".equals(name) ? "anySimpleType" : name);
        if (result != null)
        {
          return result;
        }
      }
    }
    else if (xsdSimpleTypeDefinition.getContainer() == null)
    {
      return (EDataType)getBuiltInEClassifier(rootSchema.getSchemaForSchemaNamespace(), "anySimpleType");
    }

    String explicitInstanceClassName = getEcoreAttribute(xsdSimpleTypeDefinition, "instanceClass");
    if (explicitInstanceClassName != null)
    {
      EDataType eDataType = ecoreFactory.createEDataType();
      setAnnotations(eDataType, xsdSimpleTypeDefinition);

      String aliasName = getEcoreAttribute(xsdSimpleTypeDefinition, "name");
      if (aliasName == null)
      {
        aliasName = validAliasName(xsdSimpleTypeDefinition, true);
      }
      eDataType.setName(aliasName);
      extendedMetaData.setName(eDataType, xsdSimpleTypeDefinition.getAliasName());

      eDataType.setInstanceClassName(explicitInstanceClassName);

      EPackage ePackage = getEPackage(xsdSimpleTypeDefinition);
      addToSortedList(ePackage.getEClassifiers(), eDataType);

      checkForPrimitive(xsdSimpleTypeDefinition, eDataType);

      handleFacets(xsdSimpleTypeDefinition, eDataType);

      String constraints = getEcoreAttribute(xsdSimpleTypeDefinition, "constraints");
      if (constraints != null)
      {
        EcoreUtil.setAnnotation(eDataType, EcorePackage.eNS_URI, "constraints", constraints);
      }

      if ("false".equals(getEcoreAttribute(xsdSimpleTypeDefinition, "serializable")))
      {
        eDataType.setSerializable(false);
      }
      return eDataType;
    }
    else
    {
      EEnum eEnum = computeEEnum(xsdSimpleTypeDefinition);
      if (eEnum != null)
      {
        return eEnum;
      }
      else
      {
        XSDSimpleTypeDefinition baseTypeDefinition = xsdSimpleTypeDefinition.getBaseTypeDefinition();
        if (baseTypeDefinition != null)
        {
          EDataType eDataType = ecoreFactory.createEDataType();
          setAnnotations(eDataType, xsdSimpleTypeDefinition);

          String name = getEcoreAttribute(xsdSimpleTypeDefinition, "name");
          if (name == null)
          {
            name = validAliasName(xsdSimpleTypeDefinition, true);
          }

          eDataType.setName(name);
          extendedMetaData.setName(eDataType, xsdSimpleTypeDefinition.getAliasName());

          EPackage ePackage = getEPackage(xsdSimpleTypeDefinition);
          addToSortedList(ePackage.getEClassifiers(), eDataType);

          if (baseTypeDefinition.getVariety() != xsdSimpleTypeDefinition.getVariety())
          {
            if (xsdSimpleTypeDefinition.getVariety() == XSDVariety.LIST_LITERAL)
            {
              EDataType itemEDataType = getEDataType(xsdSimpleTypeDefinition.getItemTypeDefinition());
              extendedMetaData.setItemType(eDataType, itemEDataType);
              eDataType.setInstanceClassName("java.util.List");
            }
            else
            {
              String instanceClassName = null;
              List memberTypes = new ArrayList();
              for (Iterator i = xsdSimpleTypeDefinition.getMemberTypeDefinitions().iterator(); i.hasNext(); )
              {
                XSDSimpleTypeDefinition memberTypeDefinition = (XSDSimpleTypeDefinition)i.next();
                EDataType memberEDataType = getEDataType(memberTypeDefinition);
                memberTypes.add(memberEDataType);
                String memberInstanceClassName = memberEDataType.getInstanceClassName();
                if (memberInstanceClassName == null && memberEDataType instanceof EEnum)
                {
                  memberInstanceClassName = "org.eclipse.emf.common.util.Enumerator";
                }
                if (instanceClassName == null)
                {
                  instanceClassName = memberInstanceClassName;
                }
                else if (instanceClassName != memberInstanceClassName)
                {
                  instanceClassName = "java.lang.Object";
                }
              }
              extendedMetaData.setMemberTypes(eDataType, memberTypes);
              eDataType.setInstanceClassName(instanceClassName);
            }
          }
          else
          {
            EDataType baseEDataType = getEDataType(baseTypeDefinition);
            extendedMetaData.setBaseType(eDataType, baseEDataType);
            String instanceClassName = getInstanceClassName(xsdSimpleTypeDefinition, baseEDataType);
            eDataType.setInstanceClassName
              (instanceClassName == null ? 
                 "org.eclipse.emf.common.util.Enumerator" : 
                 instanceClassName);
          }

          checkForPrimitive(xsdSimpleTypeDefinition, eDataType);
          handleFacets(xsdSimpleTypeDefinition, eDataType);

          String constraints = getEcoreAttribute(xsdSimpleTypeDefinition, "constraints");
          if (constraints != null)
          {
            EcoreUtil.setAnnotation(eDataType, EcorePackage.eNS_URI, "constraints", constraints);
          }

          if ("false".equals(getEcoreAttribute(xsdSimpleTypeDefinition, "serializable")))
          {
            eDataType.setSerializable(false);
          }

          return eDataType;
        }
      }
      return (EDataType)getBuiltInEClassifier(rootSchema.getSchemaForSchemaNamespace(), "anySimpleType");
    }
  }

  protected void checkForPrimitive(EDataType eDataType)
  {
    int index = PRIMITIVES.indexOf(eDataType.getInstanceClassName());
    if (index != -1 || eDataType instanceof EEnum)
    {
      EDataType eDataTypeObject = ecoreFactory.createEDataType();
      eDataTypeObject.setName(eDataType.getName() + "Object");
      if (index != -1)
      {
        eDataTypeObject.setInstanceClassName(PRIMITIVE_WRAPPERS[index]);
      }
      else
      {
        eDataTypeObject.setInstanceClassName("org.eclipse.emf.common.util.Enumerator");
      }
      extendedMetaData.setName(eDataTypeObject, extendedMetaData.getName(eDataType) + ":Object");
      addToSortedList(eDataType.getEPackage().getEClassifiers(), eDataTypeObject);
      extendedMetaData.setBaseType(eDataTypeObject, eDataType);

      typeToTypeObjectMap.put(eDataType, eDataTypeObject);
    }
  }

  public EClass computeEClass(XSDComplexTypeDefinition xsdComplexTypeDefinition)
  {
    if (xsdComplexTypeDefinition == null)
    {
      return (EClass)getBuiltInEClassifier(rootSchema.getSchemaForSchemaNamespace(), "anyType");
    }
    else if (XSDConstants.isSchemaForSchemaNamespace(xsdComplexTypeDefinition.getTargetNamespace()))
    {
      String name = xsdComplexTypeDefinition.getName();
      if (name != null)
      {
        EClass result = (EClass)getBuiltInEClassifier(xsdComplexTypeDefinition.getTargetNamespace(), name);
        if (result != null)
        {
          return result;
        }
      }
    }
    else if (xsdComplexTypeDefinition.getContainer() == null)
    {
      return (EClass)getBuiltInEClassifier(rootSchema.getSchemaForSchemaNamespace(), "anyType");
    }

    EClass eClass = ecoreFactory.createEClass();
    setAnnotations(eClass, xsdComplexTypeDefinition);
    // Do this early to prevent recursive loop.
    xsdComponentToEModelElementMap.put(xsdComplexTypeDefinition, eClass);

    if ("true".equals(getEcoreAttribute(xsdComplexTypeDefinition, "interface")))
    {
      eClass.setInterface(true);
    }

    String instanceClassName = getEcoreAttribute(xsdComplexTypeDefinition, "instanceClass");
    if (instanceClassName != null)
    {
      eClass.setInstanceClassName(instanceClassName);
    }

    String aliasName = getEcoreAttribute(xsdComplexTypeDefinition, "name");
    if (aliasName == null)
    {
      aliasName = validAliasName(xsdComplexTypeDefinition, true);
    }
    eClass.setName(aliasName);
    extendedMetaData.setName(eClass, xsdComplexTypeDefinition.getAliasName());

    String constraints = getEcoreAttribute(xsdComplexTypeDefinition, "constraints");
    if (constraints != null)
    {
      EcoreUtil.setAnnotation(eClass, EcorePackage.eNS_URI, "constraints", constraints);
    }

    EPackage ePackage = getEPackage(xsdComplexTypeDefinition);
    addToSortedList(ePackage.getEClassifiers(), eClass);

    if (xsdComplexTypeDefinition.isAbstract())
    {
      eClass.setAbstract(true);
    }

    EClass baseClass = null;
    XSDTypeDefinition baseTypeDefinition = xsdComplexTypeDefinition.getBaseTypeDefinition();
    if (!baseTypeDefinition.isCircular())
    {
      EClassifier baseType = getEClassifier(baseTypeDefinition);
      if (baseType instanceof EClass && baseType != ecorePackage.getEObject())
      {
        eClass.getESuperTypes().add(baseClass = (EClass)baseType);
      }
    }

    boolean isRestriction = 
      !eClass.getESuperTypes().isEmpty() && 
        xsdComplexTypeDefinition.getDerivationMethod() == XSDDerivationMethod.RESTRICTION_LITERAL;

    for (Iterator i = getEcoreTypeQNamesAttribute(xsdComplexTypeDefinition, "implements").iterator(); i.hasNext(); )
    {
      XSDTypeDefinition mixin = (XSDTypeDefinition)i.next();
      if (!XSDConstants.isURType(mixin))
      {
        EClassifier mixinType = getEClassifier(mixin);
        if (mixinType instanceof EClass && mixinType != ecorePackage.getEObject())
        {
          eClass.getESuperTypes().add(mixinType);
        }
      }
    }

    // 51210
    // EAnnotation contentParticle = null;

    if (xsdComplexTypeDefinition.getContentTypeCategory() == XSDContentTypeCategory.SIMPLE_LITERAL)
    {
      extendedMetaData.setContentKind(eClass, ExtendedMetaData.SIMPLE_CONTENT);
      if (!"SimpleAnyType".equals(eClass.getName()) || !XMLTypePackage.eNS_URI.equals(eClass.getEPackage().getNsURI()))
      {
        if (eClass.getEAllStructuralFeatures().isEmpty())
        {
          XSDComplexTypeContent xsdComplexTypeContent = xsdComplexTypeDefinition.getContent();
          String name = getEcoreAttribute(xsdComplexTypeContent, "name");
          if (name == null)
          {
            name = "value";
          }
          createFeature
            (eClass,
             null,
             name,
             xsdComplexTypeContent,
             false);
        }
        else
        {
          XSDSimpleTypeDefinition xsdSimpleTypeDefinition = xsdComplexTypeDefinition.getSimpleType();
          getEClassifier(xsdSimpleTypeDefinition);
        }
      }
    }
    else 
    {
      EStructuralFeature globalGroup = null;
      boolean isMixed = xsdComplexTypeDefinition.getContentTypeCategory() == XSDContentTypeCategory.MIXED_LITERAL;
      String featureMapName = getEcoreAttribute(xsdComplexTypeDefinition, "featureMap");
      if (eClass.getESuperTypes().isEmpty() ?
            "true".equals(getEcoreAttribute(xsdComplexTypeDefinition, "mixed")) :
            extendedMetaData.getMixedFeature((EClass)eClass.getESuperTypes().get(0)) != null)
      {
        isMixed = true;
      }
      extendedMetaData.setContentKind
        (eClass, 
         isMixed ? 
           ExtendedMetaData.MIXED_CONTENT : 
           xsdComplexTypeDefinition.getContentTypeCategory() == XSDContentTypeCategory.EMPTY_LITERAL ?
             ExtendedMetaData.EMPTY_CONTENT :
             ExtendedMetaData.ELEMENT_ONLY_CONTENT);
      if (isMixed)
      {
        EStructuralFeature mixedFeature = extendedMetaData.getMixedFeature(eClass);
        if (mixedFeature == null)
        {
          if (featureMapName == null)
          {
            featureMapName = "mixed";
          }
          mixedFeature =
            createFeature
              (eClass,
               featureMapName,
               ecorePackage.getEFeatureMapEntry(),
               null,
               0,
               -1);
          extendedMetaData.setName(mixedFeature, ":mixed");
        }
      }
      else 
      {
        globalGroup = extendedMetaData.getElement(eClass, null, ":group");
        if (globalGroup == null && featureMapName != null && eClass.getESuperTypes().isEmpty())
        {
          globalGroup =
            createFeature
              (eClass,
               featureMapName,
               ecorePackage.getEFeatureMapEntry(),
               null,
               0,
               -1);
          extendedMetaData.setName(globalGroup, ":group");
          extendedMetaData.setFeatureKind(globalGroup, ExtendedMetaData.GROUP_FEATURE);
        }
      }

      if (xsdComplexTypeDefinition.getContent() != null)
      {
        // 51210
        // Map particleMap = new HashMap();
        Map groups = new HashMap();
        List particleInformation = collectParticles((XSDParticle)xsdComplexTypeDefinition.getContent());
        for (Iterator i = particleInformation.iterator(); i.hasNext(); )
        {
          EffectiveOccurrence effectiveOccurrence = (EffectiveOccurrence)i.next();
          XSDParticle xsdParticle = effectiveOccurrence.xsdParticle;
          EStructuralFeature group = (EStructuralFeature)groups.get(effectiveOccurrence.xsdModelGroup);
          XSDTerm xsdTerm = xsdParticle.getTerm();
          EStructuralFeature eStructuralFeature = null;
          String name = getEcoreAttribute(xsdParticle, "name");
          if (xsdTerm instanceof XSDModelGroup)
          {
            if (!isRestriction) 
            {
              XSDModelGroup xsdModelGroup = (XSDModelGroup)xsdTerm;
              if (name == null)
              {
                name = getEcoreAttribute(xsdParticle, "featureMap");
                if (name == null)
                {
                  name = getEcoreAttribute(xsdModelGroup, "name");
                  if (name == null)
                  {
                    name = getEcoreAttribute(xsdModelGroup, "featureMap");
                    if (name == null)
                    {
                      if (xsdModelGroup.getContainer() instanceof XSDModelGroupDefinition)
                      {
                        XSDModelGroupDefinition xsdModelGroupDefinition = (XSDModelGroupDefinition)xsdModelGroup.getContainer();
                        name =  getEcoreAttribute(xsdModelGroupDefinition, "name");
                        if (name == null)
                        {
                          name = validName(xsdModelGroupDefinition.getName(), true);
                        }
                      }
                      else
                      {
                        name = "group";
                      }
                    }
                  }
                }
              }

              eStructuralFeature =
                createFeature
                  (eClass,
                   name,
                   ecorePackage.getEFeatureMapEntry(),
                   xsdParticle,
                   0,
                   -1);
              groups.put(xsdTerm, eStructuralFeature);
              extendedMetaData.setName(eStructuralFeature, name + ":" + eClass.getEAllStructuralFeatures().indexOf(eStructuralFeature));
            }
          }
          else if (xsdTerm instanceof XSDWildcard)
          {
            if (!isRestriction) 
            {
              if (name == null)
              {
                name = getEcoreAttribute(xsdTerm, "name");
                if (name == null)
                {
                  name = "any";
                }
              }
              eStructuralFeature =
                createFeature
                  (eClass,
                   name,
                   ecorePackage.getEFeatureMapEntry(),
                   xsdParticle,
                   effectiveOccurrence.minOccurs,
                   effectiveOccurrence.maxOccurs);
              // 51210
              // particleMap.put(xsdParticle, eStructuralFeature);
            }
          }
          else
          {
            XSDElementDeclaration xsdElementDeclaration = (XSDElementDeclaration)xsdTerm;

            boolean isRedundant = false;
            if (isRestriction)
            {
              isRedundant = 
                extendedMetaData.getElement
                  (baseClass, xsdElementDeclaration.getTargetNamespace(), xsdElementDeclaration.getName()) != null;
              
              if (!isRedundant)
              {
                group = 
                  extendedMetaData.getElementWildcardAffiliation
                    (baseClass, xsdElementDeclaration.getTargetNamespace(), xsdElementDeclaration.getName());
              }  
            }

            if (!isRedundant) 
            {
              if (name == null)
              {
                name = getEcoreAttribute(xsdElementDeclaration, "name");
                if (name == null)
                {
                  name = validName(xsdElementDeclaration.getName(), true);
                }
              }

              String groupName = getEcoreAttribute(xsdParticle, "featureMap");
              if (groupName == null)
              {
                groupName = getEcoreAttribute(xsdElementDeclaration, "featureMap");
              }

              if (!"".equals(groupName) &&
                   (groupName != null  ||
                      xsdElementDeclaration.isAbstract() || 
                      xsdElementDeclaration.getSubstitutionGroup().size() > 1))
              {
                if (groupName == null)
                {
                  groupName = name + "Group";
                }
                eStructuralFeature = 
                  createFeature
                    (eClass,
                     groupName,
                     ecorePackage.getEFeatureMapEntry(),
                     xsdParticle,
                     effectiveOccurrence.minOccurs,
                     effectiveOccurrence.maxOccurs);

                eStructuralFeature.setChangeable(true);

                extendedMetaData.setFeatureKind(eStructuralFeature, ExtendedMetaData.GROUP_FEATURE);
                extendedMetaData.setName(eStructuralFeature, xsdElementDeclaration.getName() + ":group");

                if (group != null)
                {
                  extendedMetaData.setGroup(eStructuralFeature, group);
                  eStructuralFeature.setDerived(true);
                  eStructuralFeature.setTransient(true);
                  eStructuralFeature.setVolatile(true);
                }
                else if (isMixed)
                {
                  eStructuralFeature.setDerived(true);
                  eStructuralFeature.setTransient(true);
                  eStructuralFeature.setVolatile(true);
                }
                else if (globalGroup != null)
                {
                  extendedMetaData.setGroup(eStructuralFeature, globalGroup);
                  eStructuralFeature.setDerived(true);
                  eStructuralFeature.setTransient(true);
                  eStructuralFeature.setVolatile(true);
                }

                group = eStructuralFeature;
              }

              eStructuralFeature = 
                 createFeature(eClass, xsdElementDeclaration, name, xsdParticle, effectiveOccurrence.minOccurs, effectiveOccurrence.maxOccurs);
              // 51210
              // particleMap.put(xsdParticle, eStructuralFeature);

              // If the group is turned off, we better make the feature changeable.
              //
              if (!eStructuralFeature.isChangeable() && group == null && getEcoreAttribute(xsdParticle, xsdElementDeclaration, "changeable") == null)
              {
                eStructuralFeature.setChangeable(true);
              }
            }
          }

          if (eStructuralFeature != null) 
          {
            if (group != null)
            {
              extendedMetaData.setGroup(eStructuralFeature, group);
              eStructuralFeature.setDerived(true);
              eStructuralFeature.setTransient(true);
              eStructuralFeature.setVolatile(true);
            }
            else if (isMixed)
            {
              eStructuralFeature.setDerived(true);
              eStructuralFeature.setTransient(true);
              eStructuralFeature.setVolatile(true);
            }
            else if (globalGroup != null)
            {
              extendedMetaData.setGroup(eStructuralFeature, globalGroup);
              eStructuralFeature.setDerived(true);
              eStructuralFeature.setTransient(true);
              eStructuralFeature.setVolatile(true);
            }
          }
        }

        // 51210
        // contentParticle = computeParticleConstraints(eClass, particleMap, (XSDParticle)xsdComplexTypeDefinition.getContent());
      }
    }

    // 51210
    // EAnnotation attributeParticle = null;
    // if (isRestriction)
    // {
    //   attributeParticle = ecoreFactory.createEAnnotation();
    //   attributeParticle.setSource("attributes");
    // }

    XSDWildcard baseXSDWildcard = null;
    Collection baseAttributeUses = Collections.EMPTY_LIST;
    Map baseAttributeURIs = new HashMap();
    if (baseTypeDefinition instanceof XSDComplexTypeDefinition)
    {
      XSDComplexTypeDefinition complexBaseTypeDefinition = (XSDComplexTypeDefinition)baseTypeDefinition;
      baseXSDWildcard = complexBaseTypeDefinition.getAttributeWildcard();
      baseAttributeUses = complexBaseTypeDefinition.getAttributeUses();
      for (Iterator i = baseAttributeUses.iterator(); i.hasNext(); )
      {
        XSDAttributeUse xsdAttributeUse = (XSDAttributeUse)i.next();
        baseAttributeURIs.put(xsdAttributeUse.getAttributeDeclaration().getURI(), xsdAttributeUse);
      }
    }

    for (Iterator i = getAttributeUses(xsdComplexTypeDefinition).iterator(); i.hasNext(); )
    {
      XSDAttributeUse xsdAttributeUse = (XSDAttributeUse)i.next();
      XSDAttributeDeclaration xsdAttributeDeclaration = xsdAttributeUse.getAttributeDeclaration();
      if (baseAttributeURIs.remove(xsdAttributeDeclaration.getURI()) == null)
      {
        String name = getEcoreAttribute(xsdAttributeUse, "name");
        if (name == null)
        {
          name = getEcoreAttribute(xsdAttributeDeclaration, "name");
        }
        if (name == null)
        {
          name = validName(xsdAttributeDeclaration.getName(), true);
        }

        EStructuralFeature eStructuralFeature = 
          createFeature(eClass, xsdAttributeDeclaration, name, xsdAttributeUse, xsdAttributeUse.isRequired());
      
        if (isRestriction)
        {
          EStructuralFeature attributeWildcardEStructuralFeature = 
            extendedMetaData.getAttributeWildcardAffiliation
              (baseClass, xsdAttributeDeclaration.getTargetNamespace(), xsdAttributeDeclaration.getName());
          if (attributeWildcardEStructuralFeature != null)
          {
            extendedMetaData.setGroup(eStructuralFeature, attributeWildcardEStructuralFeature);
            eStructuralFeature.setDerived(true);
            eStructuralFeature.setTransient(true);
            eStructuralFeature.setVolatile(true);
          }
        } 
      }
      /* 51210
      else if (isRestriction && !baseAttributeUses.contains(xsdAttributeUse))
      {
        EStructuralFeature eStructuralFeature = 
          extendedMetaData.getAttribute(eClass, xsdAttributeDeclaration.getTargetNamespace(), xsdAttributeDeclaration.getName());
        if (eStructuralFeature != null)
        {
          EAnnotation attributeEAnnotation = ecoreFactory.createEAnnotation();
          if (xsdAttributeUse.isRequired())
          {
            attributeEAnnotation.getDetails().put("minOccurs", "1");
          }
          attributeEAnnotation.getReferences().add(eStructuralFeature);

          if (xsdAttributeDeclaration.getTypeDefinition() != null)
          {
            EClassifier type = getEClassifier(xsdAttributeDeclaration.getTypeDefinition());
            if (type != eStructuralFeature.getEType() && type != null)
            {
              attributeEAnnotation.getReferences().add(type);
            }
          }

          attributeParticle.getContents().add(attributeEAnnotation);
        }
      }
      */
    }

    /* 51210
    if (isRestriction && !baseAttributeURIs.isEmpty())
    {
      for (Iterator i = baseAttributeURIs.values().iterator(); i.hasNext(); )
      {
        XSDAttributeUse xsdAttributeUse = (XSDAttributeUse)i.next();
        XSDAttributeDeclaration xsdAttributeDeclaration = xsdAttributeUse.getAttributeDeclaration();
        EStructuralFeature eStructuralFeature = 
          extendedMetaData.getAttribute(eClass, xsdAttributeDeclaration.getTargetNamespace(), xsdAttributeDeclaration.getName());
        if (eStructuralFeature != null)
        {
          EAnnotation attributeEAnnotation = ecoreFactory.createEAnnotation();
          attributeEAnnotation.getReferences().add(eStructuralFeature);
          attributeEAnnotation.getDetails().put("maxOccurs", "0");
          attributeParticle.getContents().add(attributeEAnnotation);
        }
      }
    }
    */

    XSDWildcard xsdWildcard = xsdComplexTypeDefinition.getAttributeWildcard();
    if (xsdWildcard != null && baseXSDWildcard != xsdWildcard || XSDConstants.isURType(xsdComplexTypeDefinition))
    {
      if (isRestriction && !XSDConstants.isURType(xsdComplexTypeDefinition))
      {
        // 51210
        // attributeParticle.getDetails().put
        //   ("wildcard", BasicExtendedMetaData.getEncodedWildcards(xsdComplexTypeDefinition.getTargetNamespace(), getWildcards(xsdWildcard)));
      }
      else
      {
        String name = getEcoreAttribute(xsdWildcard, "name");
        if (name == null)
        {
          name = "anyAttribute";
        }
        createFeature
          (eClass,
           name,
           ecorePackage.getEFeatureMapEntry(),
           xsdWildcard,
           0,
           -1);
      }
    }

    if (isRestriction)
    {
      // 51210
      // EAnnotation restrictionParticle = ecoreFactory.createEAnnotation();
      // restrictionParticle.setSource("restriction");
      // if (contentParticle != null)
      // {
      //  restrictionParticle.getContents().add(contentParticle);
      // }
      // if (!attributeParticle.getContents().isEmpty() || !attributeParticle.getDetails().isEmpty())
      // {
      //   restrictionParticle.getContents().add(attributeParticle);
      // }
      // contentParticle = restrictionParticle;

      int baseContentKind = extendedMetaData.getContentKind((EClass)eClass.getESuperTypes().get(0));
      if (baseContentKind == ExtendedMetaData.MIXED_CONTENT && 
            xsdComplexTypeDefinition.getContentTypeCategory() == XSDContentTypeCategory.SIMPLE_LITERAL)
      {
        extendedMetaData.setContentKind(eClass, ExtendedMetaData.SIMPLE_CONTENT);
        EStructuralFeature eStructuralFeature =
          createFeature
            (eClass,
             "rawValue",
             getBuiltInEClassifier(xsdComplexTypeDefinition.getSchema().getSchemaForSchemaNamespace(), "string"),
             null,
             0,
             1);
        eStructuralFeature.setDerived(true);
        eStructuralFeature.setTransient(true);
        eStructuralFeature.setVolatile(true);

        eStructuralFeature =
          createFeature
            (eClass,
             "value",
             getBuiltInEClassifier(xsdComplexTypeDefinition.getSchema().getSchemaForSchemaNamespace(), "anySimpleType"),
             null,
             0,
             1);
        eStructuralFeature.setDerived(true);
        eStructuralFeature.setTransient(true);
        eStructuralFeature.setVolatile(true);

        if ("SimpleAnyType".equals(eClass.getName()) && XMLTypePackage.eNS_URI.equals(eClass.getEPackage().getNsURI()))
        {
          eStructuralFeature =
            createFeature
              (eClass,
               "instanceType",
               ecorePackage.getEDataType(),
               null,
               1,
               1);

          ((EReference)eStructuralFeature).setResolveProxies(false);
        }
      }
      else
      {
        extendedMetaData.setContentKind(eClass, baseContentKind);
      }
    }

    // 51210
    // extendedMetaData.setContent(eClass, contentParticle);

    XSDAnnotation xsdAnnotation = xsdComplexTypeDefinition.getAnnotation();
    if (xsdAnnotation != null)
    {
      List applicationInformationList = xsdAnnotation.getApplicationInformation(EcorePackage.eNS_URI);
      for (Iterator i = applicationInformationList.iterator(); i.hasNext(); )
      {
        Element applicationInformation = (Element)i.next();
        if ("operations".equals(applicationInformation.getAttributeNS(EcorePackage.eNS_URI, "key")))
        {
          for (Iterator j =  getElements(applicationInformation, "operation").iterator(); j.hasNext(); )
          {
            EOperation eOperation = ecoreFactory.createEOperation();
            Element operation = (Element)j.next();
            String operationName = operation.getAttributeNS(null, "name");
            eOperation.setName(operationName);
            XSDTypeDefinition returnType = getEcoreTypeQNameAttribute(xsdComplexTypeDefinition, operation, null, "type");
            if (returnType != null)
            {
              EClassifier returnEType = getEClassifier(returnType);
              eOperation.setEType(returnEType);
            }
            
            List exceptions = getEcoreTypeQNamesAttribute(xsdComplexTypeDefinition, operation, null, "exceptions");
            for (Iterator k = exceptions.iterator(); k.hasNext(); )
            {
              XSDTypeDefinition exceptionTypeDefinition = (XSDTypeDefinition)k.next();
              eOperation.getEExceptions().add(getEClassifier(exceptionTypeDefinition));
            }
          
            for (Iterator k = getElements(operation, "parameter").iterator(); k.hasNext(); )
            {
              EParameter eParameter = ecoreFactory.createEParameter();
              Element parameter = (Element)k.next();
              String paramaterName = parameter.getAttributeNS(null, "name");
              XSDTypeDefinition parameterType = getEcoreTypeQNameAttribute(xsdComplexTypeDefinition, parameter, null, "type");
              EClassifier parameterEType = getEClassifier(parameterType);
              eParameter.setName(paramaterName);
              eParameter.setEType(parameterEType);

              populateETypedElement(eParameter, parameter);
              eOperation.getEParameters().add(eParameter);
            }
            
            List body = getElements(operation, "body");
            if (!body.isEmpty())
            {
              EcoreUtil.setAnnotation(eOperation, "http://www.eclipse.org/emf/2002/GenModel", "body", getText((Element)body.get(0)));
            }

            populateETypedElement(eOperation, operation);
            eClass.getEOperations().add(eOperation);
          }
        }
      }
    }
    return eClass;
  }
    
  private String getText(Element element)
  {
    StringBuffer text = new StringBuffer();
    for (Node node = element.getFirstChild(); node != null; node = node.getNextSibling())
    {
      switch (node.getNodeType())
      {
        case Node.TEXT_NODE:
        case Node.CDATA_SECTION_NODE:
        {
          text.append(node.getNodeValue());
        }
      }
    }
    return text.toString();
  }

  private List getElements(Element element, String localName)
  {
    List result = new ArrayList();
    for (Node node = element.getFirstChild(); node != null; node = node.getNextSibling())
    {
      if (node.getNodeType() == Node.ELEMENT_NODE)
      {
        Element child = (Element)node;
        if (localName.equals(child.getLocalName()) && child.getNamespaceURI() == null)
        {
          result.add(child);
        }
      }
    }
    return result;
  }
  
  protected EStructuralFeature createFeature
    (EClass eClass, String name, EClassifier type, XSDComponent xsdComponent, int minOccurs, int maxOccurs)
  {
    if (xsdComponent != null)
    {
      XSDSchema containingXSDSchema = xsdComponent.getSchema();
      if (containingXSDSchema != null && !xsdSchemas.contains(containingXSDSchema))
      {
        xsdSchemas.add(containingXSDSchema);
        addInput(containingXSDSchema);
        validate(containingXSDSchema);
      }
    }
    else if (extendedMetaData.getContentKind(eClass) == ExtendedMetaData.MIXED_CONTENT)
    {
      if (type == ecorePackage.getEFeatureMapEntry())
      {
        EAttribute eAttribute = ecoreFactory.createEAttribute();
        setAnnotations(eAttribute, xsdComponent);
        eAttribute.setName(Character.toLowerCase(name.charAt(0)) + name.substring(1));
        eAttribute.setUnique(false);
        eAttribute.setEType(type);
        eAttribute.setLowerBound(minOccurs);
        eAttribute.setUpperBound(maxOccurs);
        eClass.getEStructuralFeatures().add(eAttribute);
        extendedMetaData.setFeatureKind(eAttribute, ExtendedMetaData.ELEMENT_WILDCARD_FEATURE);
        extendedMetaData.setName(eAttribute, ":" + eAttribute.getName());
        return eAttribute;
      }
      else
      {
        EReference eReference = ecoreFactory.createEReference();
        setAnnotations(eReference, xsdComponent);
        eReference.setName(name);
        eReference.setEType(ecorePackage.getEStringToStringMapEntry());
        eReference.setLowerBound(0);
        eReference.setUpperBound(-1);
        eReference.setContainment(true);
        eReference.setResolveProxies(false);
        eReference.setTransient(true);
        eClass.getEStructuralFeatures().add(eReference);
        extendedMetaData.setFeatureKind(eReference, ExtendedMetaData.ATTRIBUTE_FEATURE);
        return eReference;
      }
    }

    if (type instanceof EClass)
    {
      EReference eReference = ecoreFactory.createEReference();
      setAnnotations(eReference, xsdComponent);
      eReference.setName(Character.toLowerCase(name.charAt(0)) + name.substring(1));
      eReference.setEType(type);
      eReference.setLowerBound(minOccurs);
      eReference.setUpperBound(maxOccurs);

      eClass.getEStructuralFeatures().add(eReference);
      if (xsdComponent == null || xsdComponent instanceof XSDSimpleTypeDefinition)
      {
        extendedMetaData.setName(eReference, ":" + eClass.getEAllStructuralFeatures().indexOf(eReference));
        extendedMetaData.setFeatureKind(eReference, ExtendedMetaData.SIMPLE_FEATURE);
        eReference.setResolveProxies(!isLocalReferenceType((XSDSimpleTypeDefinition)xsdComponent));
      }
      else 
      {
        map(xsdComponent, eReference);
        if (xsdComponent instanceof XSDParticle)
        {
          eReference.setContainment(true);
          eReference.setResolveProxies(false);

          XSDParticle xsdParticle = (XSDParticle)xsdComponent;

          XSDTerm xsdTerm = ((XSDParticle)xsdComponent).getTerm();
          if (xsdTerm instanceof XSDElementDeclaration)
          {
            XSDElementDeclaration xsdElementDeclaration = (XSDElementDeclaration)xsdTerm;
            extendedMetaData.setFeatureKind(eReference, ExtendedMetaData.ELEMENT_FEATURE);
            extendedMetaData.setName(eReference, xsdElementDeclaration.getName());
            extendedMetaData.setNamespace(eReference, xsdElementDeclaration.getTargetNamespace());

            XSDTypeDefinition xsdType = getEffectiveTypeDefinition(xsdParticle, xsdElementDeclaration);
            if (xsdType instanceof XSDSimpleTypeDefinition)
            {
              eReference.setContainment(false);
              eReference.setResolveProxies(!isLocalReferenceType((XSDSimpleTypeDefinition)xsdType));
            }

            if (maxOccurs == 1 && xsdElementDeclaration.isNillable())
            {
              eReference.setUnsettable(true);
            }

            if (xsdElementDeclaration.isAbstract())
            {
              eReference.setChangeable(false);
            }

            String opposite = getEcoreAttribute(xsdParticle, "opposite");
            if (opposite != null)
            {
              eReferenceToOppositeNameMap.put(eReference, opposite);
            }
          }
          else if (xsdTerm instanceof XSDWildcard)
          {
            // EATM shouldn't happen
            XSDWildcard xsdWildcard = (XSDWildcard)xsdTerm;
            extendedMetaData.setFeatureKind(eReference, ExtendedMetaData.ELEMENT_WILDCARD_FEATURE);
            extendedMetaData.setWildcards(eReference, getWildcards(xsdWildcard));
            extendedMetaData.setProcessingKind(eReference, xsdWildcard.getProcessContents().getValue() + 1);
            extendedMetaData.setName(eReference, ":" + eClass.getEAllStructuralFeatures().indexOf(eReference));
          }
          else
          {
            extendedMetaData.setFeatureKind(eReference, ExtendedMetaData.GROUP_FEATURE);
            extendedMetaData.setName(eReference, ":" + eClass.getEAllStructuralFeatures().indexOf(eReference));
          }
        }
        else if (xsdComponent instanceof XSDElementDeclaration)
        {
          XSDElementDeclaration xsdElementDeclaration = (XSDElementDeclaration)xsdComponent;
          eReference.setContainment(true);
          eReference.setResolveProxies(false);
          extendedMetaData.setFeatureKind(eReference, ExtendedMetaData.ELEMENT_FEATURE);
          extendedMetaData.setName(eReference, xsdElementDeclaration.getName());
          extendedMetaData.setNamespace(eReference, xsdElementDeclaration.getTargetNamespace());

          XSDElementDeclaration substitutionGroupAffiliation = xsdElementDeclaration.getSubstitutionGroupAffiliation();
          if (substitutionGroupAffiliation != null)
          {
            EStructuralFeature affiliation = getEStructuralFeature(substitutionGroupAffiliation);
            extendedMetaData.setAffiliation(eReference, affiliation);
          }
          XSDTypeDefinition xsdType = getEffectiveTypeDefinition(null, xsdElementDeclaration);
          if (xsdType instanceof XSDSimpleTypeDefinition)
          {
            eReference.setResolveProxies(!isLocalReferenceType((XSDSimpleTypeDefinition)xsdType));
          }

          if (maxOccurs == 1 && xsdElementDeclaration.isNillable())
          {
            eReference.setUnsettable(true);
          }

          if (xsdElementDeclaration.isAbstract())
          {
            eReference.setChangeable(false);
          }
        }
        else if (xsdComponent instanceof XSDAttributeUse)
        {
          String opposite = getEcoreAttribute(xsdComponent, "opposite");
          if (opposite != null)
          {
            eReferenceToOppositeNameMap.put(eReference, opposite);
          }
          
          XSDAttributeUse xsdAttributeUse = (XSDAttributeUse)xsdComponent;
          XSDAttributeDeclaration xsdAttributeDeclaration = xsdAttributeUse.getAttributeDeclaration();
          extendedMetaData.setFeatureKind(eReference, ExtendedMetaData.ATTRIBUTE_FEATURE);
          extendedMetaData.setName(eReference, xsdAttributeDeclaration.getName());
          extendedMetaData.setNamespace(eReference, xsdAttributeDeclaration.getTargetNamespace());
          eReference.setResolveProxies
            (!isLocalReferenceType((XSDSimpleTypeDefinition)getEffectiveTypeDefinition(xsdAttributeUse, xsdAttributeDeclaration)));
        }
        else if (xsdComponent instanceof XSDAttributeDeclaration)
        {
          XSDAttributeDeclaration xsdAttributeDeclaration = (XSDAttributeDeclaration)xsdComponent;
          extendedMetaData.setFeatureKind(eReference, ExtendedMetaData.ATTRIBUTE_FEATURE);
          extendedMetaData.setName(eReference, xsdAttributeDeclaration.getName());
          extendedMetaData.setNamespace(eReference, xsdAttributeDeclaration.getTargetNamespace());
          eReference.setResolveProxies
            (!isLocalReferenceType((XSDSimpleTypeDefinition)getEffectiveTypeDefinition(null, xsdAttributeDeclaration)));
        }
      }

      return eReference;
    }
    else
    {
      EAttribute eAttribute = ecoreFactory.createEAttribute();
      setAnnotations(eAttribute, xsdComponent);
      eAttribute.setName(Character.toLowerCase(name.charAt(0)) + name.substring(1));
      eAttribute.setUnique(false);
      eAttribute.setEType(type);
      eAttribute.setLowerBound(minOccurs);
      eAttribute.setUpperBound(maxOccurs);
      eClass.getEStructuralFeatures().add(eAttribute);

      if (xsdComponent == null || xsdComponent instanceof XSDSimpleTypeDefinition)
      {
        extendedMetaData.setName(eAttribute, ":" + eClass.getEAllStructuralFeatures().indexOf(eAttribute));
        extendedMetaData.setFeatureKind(eAttribute, ExtendedMetaData.SIMPLE_FEATURE);
      }
      else
      {
        map(xsdComponent, eAttribute);
        if (xsdComponent instanceof XSDAttributeUse)
        {
          XSDAttributeUse xsdAttributeUse = (XSDAttributeUse)xsdComponent;
          XSDAttributeDeclaration xsdAttributeDeclaration = xsdAttributeUse.getAttributeDeclaration();
          extendedMetaData.setFeatureKind(eAttribute, ExtendedMetaData.ATTRIBUTE_FEATURE);
          extendedMetaData.setName(eAttribute, xsdAttributeDeclaration.getName());
          extendedMetaData.setNamespace(eAttribute, xsdAttributeDeclaration.getTargetNamespace());

          String defaultValue = getEcoreAttribute(xsdComponent, "default");
          if (defaultValue == null)
          {
            defaultValue = xsdAttributeUse.getLexicalValue();
          }
          eAttribute.setDefaultValueLiteral(defaultValue);
          initialize(eAttribute, (XSDSimpleTypeDefinition)getEffectiveTypeDefinition(xsdAttributeUse, xsdAttributeDeclaration));
        }
        else if (xsdComponent instanceof XSDAttributeDeclaration)
        {
          XSDAttributeDeclaration xsdAttributeDeclaration = (XSDAttributeDeclaration)xsdComponent;
          extendedMetaData.setFeatureKind(eAttribute, ExtendedMetaData.ATTRIBUTE_FEATURE);
          extendedMetaData.setName(eAttribute, xsdAttributeDeclaration.getName());
          extendedMetaData.setNamespace(eAttribute, xsdAttributeDeclaration.getTargetNamespace());

          eAttribute.setDefaultValueLiteral(xsdAttributeDeclaration.getLexicalValue());
          initialize(eAttribute, (XSDSimpleTypeDefinition)getEffectiveTypeDefinition(null, xsdAttributeDeclaration));
        }
        else if (xsdComponent instanceof XSDParticle)
        {
          XSDTerm xsdTerm = ((XSDParticle)xsdComponent).getTerm();
          if (xsdTerm instanceof XSDElementDeclaration)
          {
            XSDElementDeclaration xsdElementDeclaration = (XSDElementDeclaration)xsdTerm;
            extendedMetaData.setFeatureKind(eAttribute, ExtendedMetaData.ELEMENT_FEATURE);
            extendedMetaData.setName(eAttribute, xsdElementDeclaration.getName());
            extendedMetaData.setNamespace(eAttribute, xsdElementDeclaration.getTargetNamespace());

            eAttribute.setDefaultValueLiteral(xsdElementDeclaration.getLexicalValue());
            XSDTypeDefinition xsdType = getEffectiveTypeDefinition(xsdComponent, xsdElementDeclaration);
            if (xsdType instanceof XSDSimpleTypeDefinition)
            {
              initialize(eAttribute, (XSDSimpleTypeDefinition)xsdType);
            }

            if (xsdElementDeclaration.isNillable())
            {
              if (!canSupportNull((EDataType)type))
              {
                eAttribute.setEType(type = (EDataType)typeToTypeObjectMap.get(type));
              }
              if (maxOccurs == 1)
              {
                eAttribute.setUnsettable(true);
              }
            }

            if (xsdElementDeclaration.isAbstract())
            {
              eAttribute.setChangeable(false);
            }
          }
          else if (xsdTerm instanceof XSDWildcard)
          {
            XSDWildcard xsdWildcard = (XSDWildcard)xsdTerm;
            extendedMetaData.setFeatureKind(eAttribute, ExtendedMetaData.ELEMENT_WILDCARD_FEATURE);
            extendedMetaData.setWildcards(eAttribute, getWildcards(xsdWildcard));
            extendedMetaData.setProcessingKind(eAttribute, xsdWildcard.getProcessContents().getValue() + 1);
            extendedMetaData.setName(eAttribute, ":" + eClass.getEAllStructuralFeatures().indexOf(eAttribute));
          }
          else
          {
            extendedMetaData.setFeatureKind(eAttribute, ExtendedMetaData.GROUP_FEATURE);
          }
        }
        else if (xsdComponent instanceof XSDWildcard)
        {
          XSDWildcard xsdWildcard = (XSDWildcard)xsdComponent;
          extendedMetaData.setFeatureKind(eAttribute, ExtendedMetaData.ATTRIBUTE_WILDCARD_FEATURE);
          extendedMetaData.setWildcards(eAttribute, getWildcards(xsdWildcard));
          extendedMetaData.setProcessingKind(eAttribute, xsdWildcard.getProcessContents().getValue() + 1);
          extendedMetaData.setName(eAttribute, ":" + eClass.getEAllStructuralFeatures().indexOf(eAttribute));
        }
        else if (xsdComponent instanceof XSDElementDeclaration)
        {
          XSDElementDeclaration xsdElementDeclaration = (XSDElementDeclaration)xsdComponent;
          extendedMetaData.setFeatureKind(eAttribute, ExtendedMetaData.ELEMENT_FEATURE);
          extendedMetaData.setName(eAttribute, xsdElementDeclaration.getName());
          extendedMetaData.setNamespace(eAttribute, xsdElementDeclaration.getTargetNamespace());

          eAttribute.setDefaultValueLiteral(xsdElementDeclaration.getLexicalValue());
          XSDTypeDefinition xsdType = getEffectiveTypeDefinition(null, xsdElementDeclaration);
          if (xsdType instanceof XSDSimpleTypeDefinition)
          {
            initialize(eAttribute, (XSDSimpleTypeDefinition)xsdType);
          }

          XSDElementDeclaration substitutionGroupAffiliation = xsdElementDeclaration.getSubstitutionGroupAffiliation();
          if (substitutionGroupAffiliation != null)
          {
            EStructuralFeature affiliation = getEStructuralFeature(substitutionGroupAffiliation);
            extendedMetaData.setAffiliation(eAttribute, affiliation);
          }

          if (xsdElementDeclaration.isNillable() && !canSupportNull((EDataType)type))
          {
              eAttribute.setEType(type = (EDataType)typeToTypeObjectMap.get(type));
            if (maxOccurs == 1)
            {
              eAttribute.setUnsettable(true);
            }
          }

          if (xsdElementDeclaration.isAbstract())
          {
            eAttribute.setChangeable(false);
          }
        }
      }

      if (maxOccurs == 1 && (type.getDefaultValue() != null || eAttribute.getDefaultValueLiteral() != null))
      {
        eAttribute.setUnsettable(true);
      }

      return eAttribute;
    }
  }

  protected XSDTypeDefinition getEffectiveTypeDefinition(XSDComponent xsdComponent, XSDFeature xsdFeature) 
  {
    return xsdFeature == null ? 
        ((XSDComplexTypeDefinition)xsdComponent.eContainer()).getSimpleType() : xsdFeature.getType();
  }
  
  protected EStructuralFeature createFeature
   (EClass eClass, XSDElementDeclaration xsdElementDeclaration, String name, XSDComponent xsdComponent, int minOccurs, int maxOccurs)
  {
    XSDTypeDefinition elementTypeDefinition = getEffectiveTypeDefinition(xsdComponent, xsdElementDeclaration);
    EClassifier eClassifier = getEClassifier(elementTypeDefinition);
  
    XSDTypeDefinition referenceType = getEcoreTypeQNameAttribute(xsdComponent, "reference");
    if (referenceType == null)
    {
      referenceType = getEcoreTypeQNameAttribute(xsdElementDeclaration, "reference");
    }
    if (referenceType != null)
    {
      EClassifier referenceClassifier = getEClassifier(referenceType);
      boolean needsHolder = false;
      if (elementTypeDefinition instanceof XSDSimpleTypeDefinition)
      {
        XSDSimpleTypeDefinition xsdSimpleTypeDefinition = (XSDSimpleTypeDefinition)elementTypeDefinition;
        if (xsdSimpleTypeDefinition.getVariety() == XSDVariety.LIST_LITERAL)
        {
          needsHolder = true;
          
          EPackage holderPackage = getEPackage(xsdElementDeclaration);
          String holderName = xsdElementDeclaration.getName() + ":holder";
          EClass holderClass = (EClass)extendedMetaData.getType(holderPackage, holderName);
          if (holderClass == null)
          {
            // Create a holder class like an anonymous complex type.
            //
            holderClass = ecoreFactory.createEClass();
            setAnnotations(holderClass, xsdElementDeclaration);
            holderClass.setName(validName(holderName, true));
            extendedMetaData.setName(holderClass, holderName);
            extendedMetaData.setContentKind(holderClass, ExtendedMetaData.SIMPLE_CONTENT);
                   
            addToSortedList(holderPackage.getEClassifiers(), holderClass);
     
            EReference holderReference =
              (EReference)createFeature
                (holderClass,
                 "value",
                 referenceClassifier,
                 null,
                 0,
                 -1);
     
            holderReference.setResolveProxies(!isLocalReferenceType(xsdSimpleTypeDefinition));
          }
          referenceClassifier = holderClass;
        }
      }
      EStructuralFeature result =
        createFeature
          (eClass,
           name,
           referenceClassifier,
           xsdComponent,
           minOccurs,
           maxOccurs);
      ((EReference)result).setContainment(needsHolder);
      if (needsHolder)
      {
        ((EReference)result).setUnsettable(false);
        ((EReference)result).setResolveProxies(false);
      }
      initialize(result, xsdElementDeclaration, xsdComponent);
      return result;
    }
    else
    {
      EStructuralFeature result =
        createFeature
          (eClass,
           name,
           eClassifier,
           xsdComponent,
           minOccurs,
           maxOccurs);
      initialize(result, xsdElementDeclaration, xsdComponent);
      return result;
    }
  }

  protected EStructuralFeature createFeature
    (EClass eClass, XSDAttributeDeclaration xsdAttributeDeclaration, String name, XSDComponent xsdComponent, boolean isRequired)
  {
    XSDSimpleTypeDefinition attributeTypeDefinition = (XSDSimpleTypeDefinition)getEffectiveTypeDefinition(xsdComponent, xsdAttributeDeclaration);
    if (attributeTypeDefinition == null)
    {
      attributeTypeDefinition = xsdComponent.getSchema().getSchemaForSchema().resolveSimpleTypeDefinition("anySimpleType");
    }
  
    XSDTypeDefinition referenceType = getEcoreTypeQNameAttribute(xsdComponent, "reference");
    if (referenceType == null && xsdAttributeDeclaration != null)
    {
      referenceType = getEcoreTypeQNameAttribute(xsdAttributeDeclaration, "reference");
    }
    if (referenceType != null)
    {
      int lowerBound = isRequired ? 1 : 0;
      int upperBound = 1;
      if (attributeTypeDefinition.getVariety() == XSDVariety.LIST_LITERAL)
      {
        XSDLengthFacet xsdLengthFacet = attributeTypeDefinition.getEffectiveLengthFacet();
        if (isRequired)
        {
          if (xsdLengthFacet != null)
          {
            lowerBound = xsdLengthFacet.getValue();
          }
          else
          {
            XSDMinLengthFacet xsdMinLengthFacet = attributeTypeDefinition.getEffectiveMinLengthFacet();
            if (xsdMinLengthFacet != null)
            {
              lowerBound = xsdMinLengthFacet.getValue();
            }
          }
        }
        if (xsdLengthFacet != null)
        {
          upperBound = xsdLengthFacet.getValue();
        }
        else
        {
          XSDMaxLengthFacet xsdMaxLengthFacet = attributeTypeDefinition.getEffectiveMaxLengthFacet();
          if (xsdMaxLengthFacet != null)
          {
            upperBound = xsdMaxLengthFacet.getValue();
          }
          else
          {
            upperBound = -1;
          }
        }
      }
  
      EClassifier referenceClassifier = getEClassifier(referenceType);
      EStructuralFeature result =
        createFeature
          (eClass,
           name,
           referenceClassifier,
           xsdComponent,
           lowerBound,
           upperBound);
      initialize(result, xsdAttributeDeclaration, xsdComponent);
      return result;
    }
    else
    {
      boolean isMany = 
          attributeTypeDefinition.getVariety() == XSDVariety.LIST_LITERAL &&
          xsdComponent instanceof XSDAttributeUse && 
          "true".equals(getEcoreAttribute(xsdComponent, "many"));
      if (isMany)
      {
        EDataType eDataType = getEDataType(attributeTypeDefinition.getItemTypeDefinition());
        XSDLengthFacet xsdLengthFacet = attributeTypeDefinition.getEffectiveLengthFacet();
        int lowerBound = isRequired ? 1 : 0;
        int upperBound = -1;
        if (isRequired)
        {
          if (xsdLengthFacet != null)
          {
            lowerBound = xsdLengthFacet.getValue();
          }
          else
          {
            XSDMinLengthFacet xsdMinLengthFacet = attributeTypeDefinition.getEffectiveMinLengthFacet();
            if (xsdMinLengthFacet != null)
            {
              lowerBound = xsdMinLengthFacet.getValue();
            }
          }
        }
        if (xsdLengthFacet != null)
        {
          upperBound = xsdLengthFacet.getValue();
        }
        else
        {
          XSDMaxLengthFacet xsdMaxLengthFacet = attributeTypeDefinition.getEffectiveMaxLengthFacet();
          if (xsdMaxLengthFacet != null)
          {
            upperBound = xsdMaxLengthFacet.getValue();
          }
        }
        EStructuralFeature result =
          createFeature
            (eClass,
             name,
             eDataType,
             xsdComponent,
             lowerBound,
             upperBound);
        initialize(result, xsdAttributeDeclaration, xsdComponent);
        return result;
      }
      else
      {
        EDataType eDataType = getEDataType(attributeTypeDefinition);
        EStructuralFeature result =
          createFeature
            (eClass,
             name,
             eDataType,
             xsdComponent,
             isRequired ? 1 : 0,
             1);
        initialize(result, xsdAttributeDeclaration, xsdComponent);
        return result;
      }
    }
  }
  
  public EStructuralFeature getEStructuralFeature(XSDFeature xsdFeature)
  {
    if ("true".equals(getEcoreAttribute(xsdFeature, "ignore"))) return null;
    EStructuralFeature eStructuralFeature = (EStructuralFeature)xsdComponentToEModelElementMap.get(xsdFeature);
    if (eStructuralFeature == null)
    {
      EPackage ePackage = getEPackage(xsdFeature);
      EClass documentEClass = extendedMetaData.getDocumentRoot(ePackage);
      if (documentEClass == null)
      {
          createDocumentRoot(xsdFeature.getSchema(), ePackage);
      }

      String name = getEcoreAttribute(xsdFeature, "name");
      if (name == null)
      {
        name= validName(xsdFeature.getName(), true);       
      }
      
      if (xsdFeature instanceof XSDElementDeclaration)
      {
        // Mark the bound as unspecified so that it won't be considered many 
        // but can nevertheless be recognized as being unspecified and perhaps still be treat as many.
        //
        EStructuralFeature result = 
          createFeature(documentEClass, (XSDElementDeclaration)xsdFeature, name, xsdFeature, 0, ETypedElement.UNSPECIFIED_MULTIPLICITY);            

        result.setDerived(true);
        result.setTransient(true);
        result.setVolatile(true);
        return result;
      }
      else
      {
        EStructuralFeature result = 
          createFeature(documentEClass, (XSDAttributeDeclaration)xsdFeature, name, xsdFeature, false);
        return result;
      }
    }

    return eStructuralFeature;
  }

  public void generate(XSDSchema xsdSchema)
  {
    this.rootSchema = xsdSchema;
    if (xsdSchemas.add(xsdSchema))
    {
      addInput(xsdSchema);
      validate(xsdSchema);
    }

    Collection visitedElementDeclarations = new ArrayList();
    Collection elementDeclarations = new ArrayList(xsdSchema.getElementDeclarations());

    Collection visitedAttributeDeclarations = new ArrayList();
    Collection attributeDeclarations = new ArrayList(xsdSchema.getAttributeDeclarations());

    Collection visitedTypeDefinitions = new ArrayList();
    Collection typeDefinitions = new ArrayList(xsdSchema.getTypeDefinitions());

    while (!elementDeclarations.isEmpty() || !attributeDeclarations.isEmpty() || !typeDefinitions.isEmpty())
    {
      for (Iterator i = elementDeclarations.iterator(); i.hasNext(); )
      {
        XSDElementDeclaration xsdElementDeclaration = (XSDElementDeclaration)i.next();
        getEStructuralFeature(xsdElementDeclaration);
      }
      visitedElementDeclarations.addAll(elementDeclarations);
      elementDeclarations = new ArrayList(xsdSchema.getElementDeclarations());
      elementDeclarations.removeAll(visitedElementDeclarations);

      for (Iterator i = attributeDeclarations.iterator(); i.hasNext(); )
      {
        XSDAttributeDeclaration xsdAttributeDeclaration = (XSDAttributeDeclaration)i.next();
        if (!XSDConstants.isSchemaInstanceNamespace(xsdAttributeDeclaration.getTargetNamespace()))
        {
          getEStructuralFeature(xsdAttributeDeclaration);
        }
      }
      visitedAttributeDeclarations.addAll(attributeDeclarations);
      attributeDeclarations = new ArrayList(xsdSchema.getAttributeDeclarations());
      attributeDeclarations.removeAll(visitedAttributeDeclarations);

      for (Iterator i = typeDefinitions.iterator(); i.hasNext(); )
      {
        XSDTypeDefinition xsdTypeDefinition = (XSDTypeDefinition)i.next();
        getEClassifier(xsdTypeDefinition);
      }
      visitedTypeDefinitions.addAll(typeDefinitions);
      typeDefinitions = new ArrayList(xsdSchema.getTypeDefinitions());
      typeDefinitions.removeAll(visitedTypeDefinitions);
    }

    resolveNameConflicts();

    for (Iterator i = xsdSchemas.iterator(); i.hasNext(); )
    {
      XSDSchema generatedXSDSchema = (XSDSchema)i.next();
      EPackage ePackage = (EPackage)targetNamespaceToEPackageMap.get(generatedXSDSchema.getTargetNamespace());
      if (ePackage != null)
      {
        String packageName= getEcoreAttribute(generatedXSDSchema, "package");
        if (packageName != null)
        {
          ePackage.setName(packageName);
        }
        String packageNsPrefix= getEcoreAttribute(generatedXSDSchema, "nsPrefix");
        if (packageNsPrefix != null)
        {
          ePackage.setNsPrefix(packageNsPrefix);
        }
      }
    }

    for (Iterator i = eReferenceToOppositeNameMap.entrySet().iterator(); i.hasNext(); )
    {
      Map.Entry entry = (Map.Entry)i.next();
      EReference eReference = (EReference)entry.getKey();
      String opposite = (String)entry.getValue();
      EClass oppositeEClass = eReference.getEReferenceType();
      if (eReference.getEOpposite() == null)
      {
        EStructuralFeature eOppositeFeature =  oppositeEClass.getEStructuralFeature(opposite);
        
        // Match by XML name if this fails.
        if (eOppositeFeature == null)
        {
          for (Iterator j = oppositeEClass.getEAllStructuralFeatures().iterator(); j.hasNext(); )
          {
            EStructuralFeature feature = (EStructuralFeature)j.next();
            if (opposite.equals(extendedMetaData.getName(feature)))
            {
              eOppositeFeature = feature;
              break;
            }
          }
        }
        
        if (eOppositeFeature instanceof EReference)
        {
          EReference eOpposite = (EReference)eOppositeFeature;
          eOpposite.setEOpposite(eReference);
          eReference.setEOpposite(eOpposite);
        }
      }

      if (eReference.getEOpposite() == null && eReference.isContainment())
      {
        EReference eOpposite = ecoreFactory.createEReference();
        eOpposite.setName(opposite);
        eOpposite.setEType(eReference.getEContainingClass());
        eOpposite.setLowerBound(0);
        eOpposite.setEOpposite(eReference);
        eReference.setEOpposite(eOpposite);
        eOpposite.setTransient(true);
        oppositeEClass.getEStructuralFeatures().add(eOpposite);
      }
    }

    eReferenceToOppositeNameMap.clear();
  }

}
