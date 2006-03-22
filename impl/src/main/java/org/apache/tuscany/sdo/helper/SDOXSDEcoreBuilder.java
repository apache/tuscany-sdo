package org.apache.tuscany.sdo.helper;

import org.apache.tuscany.sdo.SDOExtendedMetaData;
import org.apache.tuscany.sdo.util.SDOUtil;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDComponent;
import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.XSDFeature;
import org.eclipse.xsd.XSDNamedComponent;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.ecore.XSDEcoreBuilder;
import org.w3c.dom.Element;

/**
 * TODO: 
 *  - Implement support for the SDO XSD Schema annotations
 *  - Override the default ecore type mappings
 *  
 * DONE:
 *  - Override the default XSDEcoreBuilder name mangling
 */
class SDOXSDEcoreBuilder extends XSDEcoreBuilder
{

  public SDOXSDEcoreBuilder(ExtendedMetaData extendedMetaData)
  {
    super(extendedMetaData);
  }

  @Override
  public EClassifier getEClassifier(XSDTypeDefinition xsdTypeDefinition) {
    EClassifier eClassifier = null;
    if (rootSchema.getSchemaForSchemaNamespace().equals(xsdTypeDefinition.getTargetNamespace())) {
      eClassifier = 
        getBuiltInEClassifier(
          xsdTypeDefinition.getURI(), 
          xsdTypeDefinition.getName());
    } else {
      eClassifier = super.getEClassifier(xsdTypeDefinition);
    }
    return eClassifier;
  }
  
  @Override
  public EDataType getEDataType(XSDSimpleTypeDefinition xsdSimpleTypeDefinition) {
    EDataType eClassifier = null;
    if (rootSchema.getSchemaForSchemaNamespace().equals(xsdSimpleTypeDefinition.getTargetNamespace())) {
      eClassifier =
        (EDataType)getBuiltInEClassifier(
          xsdSimpleTypeDefinition.getURI(),
          xsdSimpleTypeDefinition.getName());
    } else {
      eClassifier = super.getEDataType(xsdSimpleTypeDefinition);
    }
    return (EDataType)eClassifier;
  }
  
  @Override
  protected EClassifier getBuiltInEClassifier(String namespace, String name)
  {
    EClassifier eClassifier = (EClassifier)SDOUtil.getXSDSDOType(name);
    if (eClassifier == null) {
      eClassifier = super.getBuiltInEClassifier(namespace, name);
    }
    return eClassifier;
  }
  
  @Override
  public EClass computeEClass(XSDComplexTypeDefinition xsdComplexTypeDefinition) {
    EClass eclass = super.computeEClass(xsdComplexTypeDefinition);
    String aliasNames = getEcoreAttribute(xsdComplexTypeDefinition.getElement(), "aliasName");
    if (aliasNames != null) {
      SDOExtendedMetaData.INSTANCE.setAliasNames(eclass, aliasNames);
    }
    return eclass;
  }

  @Override
  protected EClassifier computeEClassifier(XSDTypeDefinition xsdTypeDefinition) {
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

  @Override
  protected EDataType computeEDataType(XSDSimpleTypeDefinition xsdSimpleTypeDefinition) {
    EDataType edatatype = super.computeEDataType(xsdSimpleTypeDefinition);
    String aliasNames = getEcoreAttribute(xsdSimpleTypeDefinition.getElement(), "aliasName");
    if (aliasNames != null) {
      SDOExtendedMetaData.INSTANCE.setAliasNames(edatatype, aliasNames);
    }
    return edatatype;
  }

  @Override
  protected EEnum computeEEnum(XSDSimpleTypeDefinition xsdSimpleTypeDefinition) {
    EEnum eenum = super.computeEEnum(xsdSimpleTypeDefinition);
    return eenum;
  }

    
  @Override
  protected EStructuralFeature createFeature(EClass eClass, String name, EClassifier type, XSDComponent xsdComponent, int minOccurs, int maxOccurs) {
    EStructuralFeature feature = 
      super.createFeature(eClass, name, type, xsdComponent, minOccurs, maxOccurs);
    if (xsdComponent != null) {
      String aliasNames = getEcoreAttribute(xsdComponent.getElement(), "aliasName");
      if (aliasNames != null) {
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
  @Override
  protected String validName(String name, int casing, String prefix) {
    return name; 
  }

  /**
  * Override default EMF name mangling for anonymous types (simple and complex)
  */
  @Override
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
      }
    }
    return result;
  }
  
  @Override
  protected XSDTypeDefinition getEffectiveTypeDefinition(XSDComponent xsdComponent, XSDFeature xsdFeature) {
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

}