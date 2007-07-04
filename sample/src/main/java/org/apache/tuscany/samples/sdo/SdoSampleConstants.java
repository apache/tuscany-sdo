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

package org.apache.tuscany.samples.sdo;

/**
 * Interface provides some common Constants that are used across the samples.
 */
public interface SdoSampleConstants {
    
    /**
     * Defines xsd resource contained within jar file for PurchaseOrder DataObject
     */
    public static final String PO_XSD_RESOURCE = "po.xsd";
    
    /**
     * Defines xml resource contained within jar file that is used to populate PurchaseOrder DataObjects
     */
    public static final String PO_XML_RESOURCE = "po.xml";

    /**
     * Default file name to use when generated xml file for purchase order
     * @see org.apache.tuscany.samples.sdo.basic.CreatePurchaseOrder
     */
    public static final String PO_XML_GENERATED = "temporaryPoGenerated.xml";

    /**
     * Fake namespace used for PurchaseOrder 
     */
    public static final String PO_NAMESPACE = "http://www.example.com/PO";
    
    /**
     * Bogus company namespace
     */
    public static final String COMPANY_NAMESPACE = "company.xsd";

    /**
     * previously defined XSD file used
     */
    public static final String COMPANY_XSD = "company.xsd";

    /**
     * XML file containing DataGraph representing a company. This xml file conforms to the company model defined in 'Complete DataGraph for Company
     * Example' section of the SDO specification
     */   
    public static final String COMPANY_DATAGRAPH_XML = "companyDataGraphGenerated.xml";
        
    /**
     * Generated DataGraph {@link org.apache.tuscany.samples.sdo.basic.CreateCompany}
     */
    public static final String COMPANY_DATAOBJECT_XML = "companyGenerated.xml";
        
}
