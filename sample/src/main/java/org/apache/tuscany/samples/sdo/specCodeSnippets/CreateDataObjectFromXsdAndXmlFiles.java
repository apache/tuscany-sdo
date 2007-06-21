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

package org.apache.tuscany.samples.sdo.specCodeSnippets;

import java.io.InputStream;

import org.apache.tuscany.samples.sdo.SampleBase;
import org.apache.tuscany.samples.sdo.SdoSampleConstants;
import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;


/**
 * Demonstrates defining Types by using a predefined xsd resource, and populating a DataObject by using a previously created xml file.
 * 
 * The following sample is from the <a href="http://incubator.apache.org/tuscany"
 * target="_blank"> Apache Tuscany</a> project. It was written to help users
 * understand and experiment with SDO. It is based upon code snippets contained
 * within, and is meant for use with, and reference to the <a
 * href="http://osoa.org/download/attachments/36/Java-SDO-Spec-v2.1.0-FINAL.pdf?version=1"
 * target="_bank">SDO Specification</a>. <br>
 * <br> 
 * <br>Uses {@link org.apache.tuscany.samples.sdo.SdoSampleConstants#PO_XSD_RESOURCE} and {@link org.apache.tuscany.samples.sdo.SdoSampleConstants#PO_XML_RESOURCE} in order to define purcahseOrder DataObjects
 * <br><br>
 * <b>Usage:</b> <br>
 * This sample can easily be run from within Eclipse as a Java Application if tuscany or 
 * the sample-sdo project is imported into Eclipse as an existing project.
 * <br><br>
 * If executing as a standalone application please do the following: 
 * <br>
 * <UL>
 * <LI>Include the following jar files on your classpath :
 * <UL>
 * <LI>SDO API and Tuscany Implementation
 * <UL>
 * <LI>sdo-api-{version}.jar - SDO API
 * <LI>tuscany-sdo-impl-{version}.jar - Tuscany SDO implementation
 * </UL>
 * </LI>
 * <LI>EMF dependencies. 
 * <UL>
 * <LI>emf-common-{version}.jar - some common framework utility and base classes
 * <LI>emf-ecore-{version}.jar - the EMF core runtime implementation classes (the Ecore metamodel)
 * <LI>emf-ecore-change-{version}.jar - the EMF change recorder and framework
 * <LI>emf-ecore-xmi-{version}.jar - EMF's default XML (and XMI) serializer and loader
 * <LI>xsd-{version}.jar - the XML Schema model
 * </UL>
 * </LI>
 * </UL>
 * 
 * These jar files can be obtained by downloading and unpacking a <a href="http://cwiki.apache.org/TUSCANY/sdo-downloads.html" target="_blank">Tuscany binary distribution</a> </LI>
 * <LI>Execute: <br>
 * java org.apache.tuscany.samples.sdo.specCodeSnippets.CreateDataObjectFromXsdAndXmlFiles</LI>
 * </UL>
 */
public class CreateDataObjectFromXsdAndXmlFiles extends SampleBase  {
    HelperContext scope;

  
    public CreateDataObjectFromXsdAndXmlFiles(Integer userLevel) {
      super(userLevel);
    }


	public static boolean typesDefined = false;

    
  	/**
	 * Loads the {@link org.apache.tuscany.samples.sdo.SdoSampleConstants#PO_XSD_RESOURCE} resource in order to define PurchaseOrder
	 * Types 
	 */
	public void definePurchaseOrderTypeUsingXsdResource()
			throws Exception {

		InputStream is = null;
		try {
			System.out.println("Attempting to define types using resource "
					+ SdoSampleConstants.PO_XSD_RESOURCE);
			is = ClassLoader.getSystemResourceAsStream(SdoSampleConstants.PO_XSD_RESOURCE);
			if (is == null) {
				System.out.println("InputStream is null, you may need to add the resources directory is on the classpath");
                throw new Exception("InputStream for " + SdoSampleConstants.PO_XSD_RESOURCE + " was null, ensure that it is located on the classpath");
			} else {
				System.out.println("Obtained Input Stream from resoruce");
			}
			scope.getXSDHelper().define(is, null);

		} catch (Exception e) {
			System.out
					.println("Exception caught defining Types from resoruce stream to "
							+ SdoSampleConstants.PO_XSD_RESOURCE);
			throw e;
		} finally {
			// try to close the input stream
			if (is != null) {
				try {
					is.close();
					System.out.println("Closed input stream");
				} catch (Exception e) {	
					System.out.println("could not close input stream " + e.toString());
				}
			}
		}
	}

	/**
	 * Uses resource {@link org.apache.tuscany.samples.sdo.SdoSampleConstants#PO_XML_RESOURCE} to populate DataObject
	 * @return populated purchase order DataObject
	 */
	public DataObject createPurchaseOrderDataObjectUsingXmlResource()
			throws Exception {

		if (! typesDefined){
			definePurchaseOrderTypeUsingXsdResource();
		}
		DataObject purchaseOrder = null;
		InputStream is = null;
		
		try {
			
			System.out
					.println("Using resource as stream to access xml to populate DataObjects");
			// FileInputStream fis = new FileInputStream(xmlFileName);
			is = ClassLoader.getSystemResourceAsStream(SdoSampleConstants.PO_XML_RESOURCE);
			if (is == null) {
				System.out.println("InputStream is null");
			} else {
				System.out
						.println("Successfully obtained InputStream from resource");
			}
			XMLDocument xmlDoc = scope.getXMLHelper().load(is);
			purchaseOrder = xmlDoc.getRootObject();
			
		} catch (Exception e) {
			System.out.println("Could not use resourceAsStream "
					+ e.toString());
			e.printStackTrace();
			throw e;
		}finally {
			// try to close the input stream
			if (is != null) {
				try {
					is.close();
					System.out.println("Closed input stream");
				} catch (Exception e) {
					System.out.println("Could not close input stream " + e.toString());
				}
			}
		}

		return purchaseOrder;
	}

	/**
	 * @param args.  No arguments required
	 */
  public static void main(String[] args) {
    // TODO make the default level COMMENTARY_FOR_NOVICE, once the rest of the sample has been
    // converted to using commentary()
    CreateDataObjectFromXsdAndXmlFiles sample = new CreateDataObjectFromXsdAndXmlFiles(COMMENTARY_FOR_INTERMEDIATE);

    try {
      sample.run();
    }
    catch (Exception e) {
      sample.somethingUnexpectedHasHappened(e);
    }
  }

  public void runSample () throws Exception {
		// information
		System.out.println("***************************************");
		System.out.println("SDO Sample CreateDataObjectFromXsdAndXmlFiles");
		System.out.println("***************************************");
		System.out.println("Demonstrates defining Types by using a predefined xsd resource, and populating a DataObject by using a previously created xml file");
		System.out.println("***************************************");
	

		try {
			// define the types
      scope = createScopeForTypes();

			definePurchaseOrderTypeUsingXsdResource();

			// create a dataObject
			DataObject purchaseOrder = createPurchaseOrderDataObjectUsingXmlResource();
			System.out.println("DataObject sucessfully created");
				
		} catch (Exception e) {
			System.out.println("Sorry there was an error encountered " + e.toString());			
		}
                System.out.println("GoodBye");
	}

}
