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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.XMLConstants;

import org.apache.tuscany.sdo.SDOExtendedMetaData;
import org.apache.tuscany.sdo.api.SDOUtil;
import org.apache.tuscany.sdo.impl.AttributeImpl;
import org.apache.tuscany.sdo.impl.SDOFactoryImpl.SDOEcoreFactory;
import org.apache.tuscany.sdo.model.ModelFactory;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDComponent;
import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDFeature;
import org.eclipse.xsd.XSDNamedComponent;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTerm;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.ecore.EcoreSchemaBuilder;
import org.eclipse.xsd.util.XSDResourceFactoryImpl;
import org.eclipse.xsd.util.XSDResourceImpl;
import org.eclipse.xsd.util.XSDSchemaLocator;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class SDOXSDEcoreBuilder extends BaseSDOXSDEcoreBuilder
{
  protected boolean replaceConflictingTypes = false;

  public SDOXSDEcoreBuilder(ExtendedMetaData extendedMetaData, boolean replaceConflictingTypes)
  {
    super(extendedMetaData);
    ecoreFactory = new SDOEcoreFactory();
    this.replaceConflictingTypes = replaceConflictingTypes;
    populateTypeToTypeObjectMap((EPackage)ModelFactory.INSTANCE);
  }
  
  /**
   * Overrides method in EMF. This will cause the SDO Properties to be in the
   * order in which the Attributes appeared in the XSD.
   */
  protected boolean useSortedAttributes()
  {
    return false;
  }

  /*
   * Required for Java 1.4.2 support
   * Node#lookupPrefix is only available since DOM Level 3 (Java 5)
   * and it doesn't return rebound prefix.
   * XSDConstants.lookupQualifier isn't supposed to return rebound prefix either.
   * This lookupPrefix returns any bound prefix no matter rebound to other NameSpace or not, for {@link #getEPackage}.
   */
  static protected String lookupPrefix(Node element, String namespaceURI) {
    String prefix = element.getPrefix();
    if (prefix != null && namespaceURI != null && namespaceURI.equals(element.getNamespaceURI()))
      return prefix;
    NamedNodeMap attributes = element.getAttributes();
    if (attributes != null)
      for (int index = attributes.getLength(); index != 0;) {
        Node attribute = attributes.item(--index);
        if (XMLConstants.XMLNS_ATTRIBUTE_NS_URI.equals(attribute.getNamespaceURI()) && attribute.getNodeValue().equals(namespaceURI)
              && XMLConstants.XMLNS_ATTRIBUTE.equals(attribute.getPrefix()))
          return attribute.getLocalName();
      }
    for (Node parent; (parent = element.getParentNode()) != null; element = parent)
      if (parent.getNodeType() == Node.ELEMENT_NODE)
        return lookupPrefix(parent, namespaceURI);
    return null;
  }

  public EPackage getEPackage(XSDNamedComponent xsdNamedComponent) {
    XSDSchema containingXSDSchema = xsdNamedComponent.getSchema();
    String targetNamespace = containingXSDSchema == null ?
        xsdNamedComponent.getTargetNamespace() : containingXSDSchema.getTargetNamespace();
    EPackage ePackage = (EPackage) targetNamespaceToEPackageMap.get(targetNamespace);
    if (ePackage != null)
      return ePackage;
    ePackage = super.getEPackage(xsdNamedComponent);
    String nsPrefix = lookupPrefix(xsdNamedComponent.getElement(), targetNamespace);
    if (nsPrefix != null)
      ePackage.setNsPrefix(nsPrefix);
    return ePackage;
  }

  public EClassifier getEClassifier(XSDTypeDefinition xsdTypeDefinition) {
    EClassifier eClassifier = null;
    if (xsdTypeDefinition != null)
    {
      if (rootSchema.getSchemaForSchemaNamespace().equals(xsdTypeDefinition.getTargetNamespace())) {
        eClassifier = 
          getBuiltInEClassifier(xsdTypeDefinition.getURI(), xsdTypeDefinition.getName());
      } 
      else if (xsdTypeDefinition.getContainer() == null) {
        EPackage pkg = extendedMetaData.getPackage(xsdTypeDefinition.getTargetNamespace());
        if(pkg != null) {
          eClassifier = pkg.getEClassifier(xsdTypeDefinition.getName());
        }
      }
    }
    if (eClassifier == null) {
      eClassifier = super.getEClassifier(xsdTypeDefinition);
    }
    return eClassifier;
  }
  
  public EDataType getEDataType(XSDSimpleTypeDefinition xsdSimpleTypeDefinition) {
    EDataType eClassifier = null;
    if (xsdSimpleTypeDefinition != null && rootSchema.getSchemaForSchemaNamespace().equals(xsdSimpleTypeDefinition.getTargetNamespace())) {
      eClassifier =
        (EDataType)getBuiltInEClassifier(
          xsdSimpleTypeDefinition.getURI(),
          xsdSimpleTypeDefinition.getName());
    } else {
      eClassifier = super.getEDataType(xsdSimpleTypeDefinition);
    }
    return (EDataType)eClassifier;
  }

  
  /* (non-Javadoc)
   * @see org.eclipse.xsd.ecore.XSDEcoreBuilder#createResourceSet()
   */
  protected ResourceSet createResourceSet() {
    ResourceSet result = super.createResourceSet();
    result.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XSDResourceFactoryImpl());
    result.getAdapterFactories().add(new XSDSchemaAdapterFactoryImpl());
    result.setPackageRegistry(new EPackageRegistryImpl(HelperContextImpl.getBuiltInModelRegistry()));     
    
    return result;
  }

  protected EClassifier getBuiltInEClassifier(String namespace, String name)
  {
      EClassifier eClassifier = null;
      if ("base64Binary".equals(name)) {
          eClassifier = (EClassifier)AttributeImpl.INTERNAL_BASE64_BYTES;
      }
      else if ("QName".equals(name)) {
          eClassifier = (EClassifier)AttributeImpl.INTERNAL_QNAME;
      }
      else {
          eClassifier = (EClassifier)SDOUtil.getXSDSDOType(name);
      }
      
    if (eClassifier == null)
      eClassifier = super.getBuiltInEClassifier(namespace, name);
    return eClassifier;
  }
  
  private void updateReferences(EObject oldEObject, EObject newEObject)
  {
    Collection usages = UsageCrossReferencer.find(oldEObject, targetNamespaceToEPackageMap.values());
    for (Iterator iter = usages.iterator(); iter.hasNext(); )
    {
      EStructuralFeature.Setting setting = (EStructuralFeature.Setting)iter.next();
      EObject referencingEObject = setting.getEObject();
      EStructuralFeature eStructuralFeature = setting.getEStructuralFeature();
      if (eStructuralFeature.isChangeable())
      {
        if (eStructuralFeature.isMany())
        {
          List refList = (List)referencingEObject.eGet(eStructuralFeature);
          int refIndex = refList.indexOf(oldEObject);
          if (refIndex != -1) refList.set(refIndex, newEObject);
        }
        else
        {
          referencingEObject.eSet(eStructuralFeature, newEObject);
        }
      }
    }
  }
  
  private XSDTypeDefinition getXSDTypeDefinition(EClassifier eClassifier)
  {
    //TODO Maybe we should create a reverse (eModelElementToXSDComponentMap) for better performance.
    //     Use a HashMap subclass for xsdComponentToEModelElementMap that overrides put() to also add the 
    //     reverse mapping in eModelElementToXSDComponentMap
    XSDTypeDefinition xsdTypeDefinition = null;
    for (Iterator i = xsdComponentToEModelElementMap.entrySet().iterator(); i.hasNext(); )
    {
      Entry e = (Entry) i.next();
      if (eClassifier == e.getValue()) 
      {
        xsdTypeDefinition = (XSDTypeDefinition)e.getKey();
        break;
      }
    }
    return xsdTypeDefinition;
  }
  
  private boolean sameType(XSDTypeDefinition t1, XSDTypeDefinition t2)
  {
    XSDConcreteComponent n1 = t1, n2 = t2;
    while (n1 != null && n2 != null)
    {
      if (n1.eClass() != n2.eClass()) break;
      if (n1 instanceof XSDNamedComponent /*&& n2 instanceof XSDNamedComponent*/)
      {
        String s1 = ((XSDNamedComponent)n1).getName();
        String s2 = ((XSDNamedComponent)n2).getName();
        if (s1 == null ? s1 != s2 : !s1.equals(s2)) break;
      }
      n1 = n1.getContainer();
      n2 = n2.getContainer();
    }
    return n1 == null && n2 == null;
  }
  
  protected void removeDuplicateEClassifier(EClassifier eClassifier, XSDTypeDefinition xsdTypeDefinition)
  {
    EPackage ePackage = eClassifier.getEPackage();
    List eClassifiers = ePackage.getEClassifiers();
    String name = eClassifier.getName();
    int size = eClassifiers.size();
    for (int index = eClassifiers.indexOf(eClassifier); ++index < size; )
    {
      EClassifier nextEClassifier = (EClassifier)eClassifiers.get(index);
      if (!name.equals(nextEClassifier.getName())) break;
      if (extendedMetaData.getName(eClassifier).equals(extendedMetaData.getName(nextEClassifier)))
      {
        XSDTypeDefinition nextXSDTypeDefinition = getXSDTypeDefinition(nextEClassifier);
        if (!sameType(nextXSDTypeDefinition, xsdTypeDefinition))
        {
          //System.out.println("###EClassifier mismatch: ");
          //System.out.println("    old: " + extendedMetaData.getName(nextEClassifier));
          //System.out.println("    new: " + extendedMetaData.getName(eClassifier));
          continue;
        }
        eClassifiers.remove(index); 
        updateReferences(nextEClassifier, eClassifier);
        break;
      }
    }
  }
  
  protected void removeDuplicateDocumentRootFeature(EClass eClass, EStructuralFeature eStructuralFeature)
  {
    List eStructuralFeatures = eClass.getEStructuralFeatures();
    int last = eStructuralFeatures.size() - 1;
    String name = extendedMetaData.getName(eStructuralFeature);
    for (int index = 0; index < last; index++)
    {
      EStructuralFeature otherEStructuralFeature = (EStructuralFeature)eStructuralFeatures.get(index);
      if (name.equals(extendedMetaData.getName(otherEStructuralFeature)))
      {
        if (otherEStructuralFeature.eClass() != eStructuralFeature.eClass())
        {
          //System.out.println("###EStructuralFeature mismatch: ");
          //System.out.println("    old: " + extendedMetaData.getName(otherEStructuralFeature));
          //System.out.println("    new: " + extendedMetaData.getName(eStructuralFeature));
          continue;
        }
        eStructuralFeatures.remove(index);
        updateReferences(otherEStructuralFeature, eStructuralFeature);
        break;
      }
    }
  }
  
  public EClass computeEClass(XSDComplexTypeDefinition xsdComplexTypeDefinition) {
    if (xsdComplexTypeDefinition == null) return super.computeEClass(xsdComplexTypeDefinition);
    EPackage ePackage = (EPackage)targetNamespaceToEPackageMap.get(xsdComplexTypeDefinition.getTargetNamespace());
    if (ePackage != null && TypeHelperImpl.getBuiltInModels().contains(ePackage)) {
      EClassifier eclassifier = ePackage.getEClassifier(xsdComplexTypeDefinition.getName());
      if (eclassifier != null) return (EClass)eclassifier;
    }
    EClass eClass = super.computeEClass(xsdComplexTypeDefinition);
    if (replaceConflictingTypes) removeDuplicateEClassifier(eClass, xsdComplexTypeDefinition);
    String aliasNames = getEcoreAttribute(xsdComplexTypeDefinition.getElement(), "aliasName");
    if (aliasNames != null) {
      SDOExtendedMetaData.INSTANCE.setAliasNames(eClass, aliasNames);
    }
    return eClass;
  }

  protected EClassifier computeEClassifier(XSDTypeDefinition xsdTypeDefinition) {
    if (xsdTypeDefinition == null) return super.computeEClassifier(xsdTypeDefinition);
    EPackage ePackage = (EPackage)targetNamespaceToEPackageMap.get(xsdTypeDefinition.getTargetNamespace());
    if (ePackage != null && TypeHelperImpl.getBuiltInModels().contains(ePackage)) {
      EClassifier eclassifier = ePackage.getEClassifier(xsdTypeDefinition.getName());
      if (eclassifier != null) return eclassifier;
    }
    EClassifier eclassifier = super.computeEClassifier(xsdTypeDefinition);
    EClassifier etype = (EClassifier) typeToTypeObjectMap.get(eclassifier);
    String aliasNames = getEcoreAttribute(xsdTypeDefinition.getElement(), "aliasName");
    if (aliasNames != null) {
      SDOExtendedMetaData.INSTANCE.setAliasNames(eclassifier, aliasNames);
      if (etype != null) {
        SDOExtendedMetaData.INSTANCE.setAliasNames(etype, aliasNames);
      }
    }
    return eclassifier;
  }

  protected EDataType computeEDataType(XSDSimpleTypeDefinition xsdSimpleTypeDefinition) {
    if (xsdSimpleTypeDefinition == null) return super.computeEDataType(xsdSimpleTypeDefinition);
    EPackage ePackage = (EPackage)targetNamespaceToEPackageMap.get(xsdSimpleTypeDefinition.getTargetNamespace());
    if (ePackage != null && TypeHelperImpl.getBuiltInModels().contains(ePackage)) {
      EClassifier eclassifier = ePackage.getEClassifier(xsdSimpleTypeDefinition.getName());
      if (eclassifier != null) return (EDataType)eclassifier;
    }
    EDataType eDataType = super.computeEDataType(xsdSimpleTypeDefinition);
    if (replaceConflictingTypes) removeDuplicateEClassifier(eDataType, xsdSimpleTypeDefinition);
    String aliasNames = getEcoreAttribute(xsdSimpleTypeDefinition.getElement(), "aliasName");
    if (aliasNames != null) {
      SDOExtendedMetaData.INSTANCE.setAliasNames(eDataType, aliasNames);
    }
    return eDataType;
  }

  protected EEnum computeEEnum(XSDSimpleTypeDefinition xsdSimpleTypeDefinition) {
    return null;
  }
    
  protected EStructuralFeature createFeature(EClass eClass, String name, EClassifier type, XSDComponent xsdComponent, int minOccurs, int maxOccurs) {
    EStructuralFeature feature = super.createFeature(eClass, name, type, xsdComponent, minOccurs, maxOccurs);

    if (xsdComponent instanceof XSDParticle) {
      XSDTerm xsdTerm = ((XSDParticle)xsdComponent).getTerm();
      if (xsdTerm instanceof XSDElementDeclaration && ((XSDElementDeclaration)xsdTerm).isNillable())
        EcoreUtil.setAnnotation(feature, ExtendedMetaData.ANNOTATION_URI, "nillable", "true");
    }

    //FB What is the following for?
    if (feature instanceof EReference)
    {
      EReference eReference = (EReference)feature;
      if (xsdComponent != null && xsdComponent instanceof XSDParticle)
      {
        XSDTerm xsdTerm = ((XSDParticle)xsdComponent).getTerm();
        if (xsdTerm instanceof XSDElementDeclaration)
        {
          XSDTypeDefinition elementTypeDefinition = getEffectiveTypeDefinition(xsdComponent, (XSDElementDeclaration)xsdTerm);
          EClassifier eClassifier = getEClassifier(elementTypeDefinition);
          if (elementTypeDefinition instanceof XSDSimpleTypeDefinition && eClassifier instanceof EClass)
          {
            eReference.setContainment(true);
          }
        }
      }
    }
    
    feature.setName(name); // this is needed because super.createFeature() does EMF name mangling (toLower)
    
    if (replaceConflictingTypes && "".equals(extendedMetaData.getName(eClass)))
      removeDuplicateDocumentRootFeature(eClass, feature);
    
    if (xsdComponent != null)
    {
      String aliasNames = getEcoreAttribute(xsdComponent.getElement(), "aliasName");
      if (aliasNames != null)
      {
        SDOExtendedMetaData.INSTANCE.setAliasNames(feature, aliasNames);
      }
    }
    return feature;
  }

  protected String getInstanceClassName(XSDTypeDefinition typeDefinition, EDataType baseEDataType) {
    String name = getEcoreAttribute(typeDefinition, "extendedInstanceClass");
    return (name != null) ? name : super.getInstanceClassName(typeDefinition, baseEDataType);
  }
  
  protected String getEcoreAttribute(Element element, String attribute)
  {
    String sdoAttribute = null;

    if ("name".equals(attribute))
      sdoAttribute = "name";
    else if ("opposite".equals(attribute))
      sdoAttribute = "oppositeProperty";
    else if ("mixed".equals(attribute))
      sdoAttribute = "sequence";
    else if ("string".equals(attribute))
      sdoAttribute = "string";
    else if ("changeable".equals(attribute))
      sdoAttribute = "readOnly";
    else if ("aliasName".equals(attribute))
      sdoAttribute = "aliasName";
    
    if (sdoAttribute != null)
    {
      String value = 
        element != null && element.hasAttributeNS("commonj.sdo/xml", sdoAttribute) ? 
          element.getAttributeNS("commonj.sdo/xml", sdoAttribute) : 
          null;
      if ("changeable".equals(attribute)) {
        if ("true".equals(value)) value = "false";
        else if ("false".equals(value)) value = "true";
      }
      return value;
    }
    
    if ("package".equals(attribute))
      sdoAttribute = "package";
    else if ("instanceClass".equals(attribute))
      sdoAttribute = "instanceClass";
    else if ("extendedInstanceClass".equals(attribute))
      sdoAttribute = "extendedInstanceClass";
    else if ("nestedInterfaces".equals(attribute))
      sdoAttribute = "nestedInterfaces";
    
    if (sdoAttribute != null)
    {
      return 
        element != null && element.hasAttributeNS("commonj.sdo/java", sdoAttribute) ? 
          element.getAttributeNS("commonj.sdo/java", sdoAttribute) : 
          null;
    }

    return super.getEcoreAttribute(element, attribute);
  }

  /*
  protected String getEcoreAttribute(XSDConcreteComponent xsdConcreteComponent, String attribute)
  {
    String value = super.getEcoreAttribute(xsdConcreteComponent, attribute);
    if ("package".equals(attribute) && value == null)
    {
      XSDSchema xsdSchema = (XSDSchema)xsdConcreteComponent;
      value = getDefaultPackageName(xsdSchema.getTargetNamespace());
    }
    return value;
  }
  */
  
  protected XSDTypeDefinition getEcoreTypeQNameAttribute(XSDConcreteComponent xsdConcreteComponent, String attribute)
  {    
    if (xsdConcreteComponent == null) return null;
    String sdoAttribute = null;

    if ("reference".equals(attribute)) sdoAttribute = "propertyType";
    if ("dataType".equals(attribute)) sdoAttribute = "dataType";
    
    if (sdoAttribute != null)
    {
      Element element = xsdConcreteComponent.getElement();
      return  element == null ? null : getEcoreTypeQNameAttribute(xsdConcreteComponent, element, "commonj.sdo/xml", sdoAttribute);
    }

    return super.getEcoreTypeQNameAttribute(xsdConcreteComponent, attribute);
  }
   
  /**
   * Override default EMF behavior so that the name is not mangled.
   */
  protected String validName(String name, int casing, String prefix) {
    return name; 
  }

  /**
  * Override default EMF name mangling for anonymous types (simple and complex)
  */
  protected String validAliasName(XSDTypeDefinition xsdTypeDefinition, boolean isUpperCase) {
    return getAliasName(xsdTypeDefinition);
  }

  protected String getAliasName(XSDNamedComponent xsdNamedComponent) {
    String result = xsdNamedComponent.getName();
    if (result == null)
    {
      XSDConcreteComponent container = xsdNamedComponent.getContainer();
      if (container instanceof XSDNamedComponent)
      {
        result = getAliasName((XSDNamedComponent)container);
        if (container instanceof XSDTypeDefinition)
        {
          result = "_" + result;
        }
      }

    }
    return result; 
  }
  
  protected XSDTypeDefinition getEffectiveTypeDefinition(XSDComponent xsdComponent, XSDFeature xsdFeature) 
  {
    if (xsdFeature == null)
    {
      return super.getEffectiveTypeDefinition(xsdComponent, xsdFeature);
    }
    XSDTypeDefinition typeDef = getEcoreTypeQNameAttribute(xsdComponent, "dataType");

    String isString = getEcoreAttribute(xsdComponent, xsdFeature, "string");
    if ("true".equalsIgnoreCase(isString)) {
      typeDef = 
        xsdFeature.resolveSimpleTypeDefinition(rootSchema.getSchemaForSchemaNamespace(), "string");
    }
    if (typeDef == null)
      typeDef = xsdFeature.getType();
    return typeDef;
  }

  /**
   * Override EMF algorithm.
   */
  public String qualifiedPackageName(String namespace)
  {
    return getDefaultPackageName(namespace);
  }

  //Code below here to provide common URI to java packagname
  
  public static String uncapNameStatic(String name)
  {
    if (name.length() == 0)
    {
      return name;
    }
    else
    {
      String lowerName = name.toLowerCase();
      int i;
      for (i = 0; i < name.length(); i++)
      {
        if (name.charAt(i) == lowerName.charAt(i))
        {
          break;
        }
      }
      if (i > 1 && i < name.length() && !Character.isDigit(name.charAt(i)))
      {
        --i;
      }
      return name.substring(0, i).toLowerCase() + name.substring(i);
    }
  }

  protected static String validNameStatic(String name, int casing, String prefix)
  {
    List parsedName = parseNameStatic(name, '_');
    StringBuffer result = new StringBuffer();
    for (Iterator i = parsedName.iterator(); i.hasNext(); )
    {
      String nameComponent = (String)i.next();
      if (nameComponent.length() > 0)
      {
        if (result.length() > 0 || casing == UPPER_CASE)
        {
          result.append(Character.toUpperCase(nameComponent.charAt(0)));
          result.append(nameComponent.substring(1));
        }
        else
        {
          result.append(nameComponent);
        }
      }
    }

    return
      result.length() == 0 ?
        prefix :
        Character.isJavaIdentifierStart(result.charAt(0)) ?
          casing == LOWER_CASE ?
            uncapNameStatic(result.toString()) :
            result.toString() :
          prefix + result;
  }

  protected static List parseNameStatic(String sourceName, char separator)
  {
    List result = new ArrayList();
    if (sourceName != null)
    {
      StringBuffer currentWord = new StringBuffer();
      boolean lastIsLower = false;
      for (int index = 0, length = sourceName.length(); index < length; ++index)
      {
        char curChar = sourceName.charAt(index);
        if (!Character.isJavaIdentifierPart(curChar))
        {
          curChar = separator;
        }
        if (Character.isUpperCase(curChar) || (!lastIsLower && Character.isDigit(curChar)) || curChar == separator)
        {
          if (lastIsLower && currentWord.length() > 1 || curChar == separator && currentWord.length() > 0)
          {
            result.add(currentWord.toString());
            currentWord = new StringBuffer();
          }
          lastIsLower = false;
        }
        else
        {
          if (!lastIsLower)
          {
            int currentWordLength = currentWord.length();
            if (currentWordLength > 1)
            {
              char lastChar = currentWord.charAt(--currentWordLength);
              currentWord.setLength(currentWordLength);
              result.add(currentWord.toString());
              currentWord = new StringBuffer();
              currentWord.append(lastChar);
            }
          }
          lastIsLower = true;
        }

        if (curChar != separator)
        {
          currentWord.append(curChar);
        }
      }

      result.add(currentWord.toString());
    }
    return result;
  }
  
  public static String getDefaultPackageName(String targetNamespace)
  {
      if (targetNamespace == null)
          return null;
     
      URI uri = URI.createURI(targetNamespace);
      List parsedName;
      if (uri.isHierarchical())
      {
        String host = uri.host();
        if (host != null && host.startsWith("www."))
        {
          host = host.substring(4);
        }
        parsedName = parseNameStatic(host, '.');
        Collections.reverse(parsedName);
        if (!parsedName.isEmpty())
        {
          parsedName.set(0, ((String)parsedName.get(0)).toLowerCase());
        }
  
        parsedName.addAll(parseNameStatic(uri.trimFileExtension().path(), '/'));
      }
      else
      {
        String opaquePart = uri.opaquePart();
        int index = opaquePart.indexOf(":");
        if (index != -1 && "urn".equalsIgnoreCase(uri.scheme()))
        {
          parsedName = parseNameStatic(opaquePart.substring(0, index), '-');
          if (parsedName.size() > 0 && DOMAINS.contains(parsedName.get(parsedName.size() - 1))) 
          {
            Collections.reverse(parsedName);
            parsedName.set(0, ((String)parsedName.get(0)).toLowerCase());
          }
          parsedName.addAll(parseNameStatic(opaquePart.substring(index + 1), '/'));
        }
        else
        {
          parsedName = parseNameStatic(opaquePart, '/');
        }
      }

      StringBuffer qualifiedPackageName = new StringBuffer();
      for (Iterator i = parsedName.iterator(); i.hasNext(); )
      {
        String packageName = (String)i.next();
        if (packageName.length() > 0)
        {
          if (qualifiedPackageName.length() > 0)
          {
            qualifiedPackageName.append('.');
          }
          qualifiedPackageName.append(validNameStatic(packageName, LOWER_CASE,"_"));
        }
      }
    
    return qualifiedPackageName.toString().toLowerCase(); //make sure it's lower case .. we can't work with Axis if not.
  }
  
  private XSDSchema loadEPackage(EPackage ePackage)
  {
    XSDSchema ePackageXSDSchema = null;
    XSDEcoreSchemaBuilder schemaBuilder = new XSDEcoreSchemaBuilder(extendedMetaData);
    ePackageXSDSchema = schemaBuilder.getSchema(ePackage);
    xsdComponentToEModelElementMap.putAll(schemaBuilder.getXSDComponentToEModelElementMap());
    targetNamespaceToEPackageMap.put(ePackage.getNsURI(), ePackage);
    populateTypeToTypeObjectMap(ePackage);
    xsdSchemas.add(ePackageXSDSchema);
    return ePackageXSDSchema;
  }
  
  private static class XSDEcoreSchemaBuilder extends EcoreSchemaBuilder
  {
    public XSDEcoreSchemaBuilder(ExtendedMetaData extendedMetaData) 
    {
      super(extendedMetaData);
    }
    
    public Map getXSDComponentToEModelElementMap()
    {
      return xsdComponentToEModelElementMap;
    }
  }
  
  class XSDSchemaAdapterFactoryImpl extends AdapterFactoryImpl
  {
    protected SchemaLocator schemaLocator = new SchemaLocator();
    
    public boolean isFactoryForType(Object type)
    {
      return type == XSDSchemaLocator.class;
    }
    
    public Adapter adaptNew(Notifier target, Object type)
    {
      return schemaLocator;
    }
    
    class SchemaLocator extends XSDResourceImpl.SchemaLocator
    {
      public XSDSchema locateSchema(XSDSchema xsdSchema, String namespaceURI,
                                    String rawSchemaLocationURI, String resolvedSchemaLocation)
      {
        if (targetNamespaceToEPackageMap.containsKey(namespaceURI))
        {
          for (Iterator iter = xsdSchemas.iterator(); iter.hasNext();) {
            XSDSchema schema = (XSDSchema)iter.next();
            String targetNamespace = schema.getTargetNamespace();
            if (targetNamespace != null && targetNamespace.equals(namespaceURI))
            {
              return schema;
            } 
          }
        }
        if (namespaceURI != null && !namespaceURI.equals(xsdSchema.getTargetNamespace()))
        {
          EPackage ePackage = extendedMetaData.getPackage(namespaceURI);
          if (ePackage != null)
          {
            XSDSchema schema = loadEPackage(ePackage);
            return schema;
          }
        }
        return super.locateSchema(xsdSchema, namespaceURI, rawSchemaLocationURI, resolvedSchemaLocation);
      }
    }
  }
  
}
