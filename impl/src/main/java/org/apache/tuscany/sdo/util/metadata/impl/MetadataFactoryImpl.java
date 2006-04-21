/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.sdo.util.metadata.impl;

import org.apache.tuscany.sdo.util.metadata.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetadataFactoryImpl extends EFactoryImpl implements MetadataFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final MetadataFactoryImpl eINSTANCE = init();

  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MetadataFactoryImpl init()
  {
    try
    {
      MetadataFactoryImpl theMetadataFactory = (MetadataFactoryImpl)EPackage.Registry.INSTANCE.getEFactory("org.apache.tuscany.sdo/metadata"); 
      if (theMetadataFactory != null)
      {
        return theMetadataFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new MetadataFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MetadataFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case MetadataPackageImpl.DOCUMENT_ROOT: return (EObject)createDocumentRoot();
      case MetadataPackageImpl.JAVA_META_DATA: return (EObject)createJavaMetaData();
      case MetadataPackageImpl.SDO_META_DATA_GROUP: return (EObject)createSDOMetaDataGroup();
      case MetadataPackageImpl.TYPE_META_DATA: return (EObject)createTypeMetaData();
      case MetadataPackageImpl.XSD_META_DATA: return (EObject)createXSDMetaData();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject createDocumentRoot()
  {
    EObject documentRoot = super.create(MetadataPackageImpl.Literals.DOCUMENT_ROOT);
    return documentRoot;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaMetaData createJavaMetaData()
  {
    JavaMetaDataImpl javaMetaData = new JavaMetaDataImpl();
    return javaMetaData;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SDOMetaDataGroup createSDOMetaDataGroup()
  {
    SDOMetaDataGroupImpl sdoMetaDataGroup = new SDOMetaDataGroupImpl();
    return sdoMetaDataGroup;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeMetaData createTypeMetaData()
  {
    TypeMetaDataImpl typeMetaData = new TypeMetaDataImpl();
    return typeMetaData;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XSDMetaData createXSDMetaData()
  {
    XSDMetaDataImpl xsdMetaData = new XSDMetaDataImpl();
    return xsdMetaData;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MetadataPackageImpl getMetadataPackageImpl()
  {
    return (MetadataPackageImpl)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  public static MetadataPackageImpl getPackage()
  {
    return MetadataPackageImpl.eINSTANCE;
  }

} //MetadataFactoryImpl
