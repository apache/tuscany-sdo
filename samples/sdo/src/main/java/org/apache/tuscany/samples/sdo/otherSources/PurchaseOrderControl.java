/**
 *
 *  Copyright 2006 The Apache Software Foundation or its licensors, as applicable.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.tuscany.samples.sdo.otherSources;

import java.io.*;

import java.util.List;
import java.math.BigDecimal;

import commonj.sdo.DataObject;
import commonj.sdo.ChangeSummary;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;
import commonj.sdo.helper.CopyHelper;

import org.apache.tuscany.samples.sdo.SdoSampleConstants;

import org.apache.tuscany.samples.sdo.specCodeSnippets.*;

/**
 * Provides operational API for purchase order sample for SDO. It is used by
 * {@link PurchaseOrderCmdLine} for an interactive sample. Often relies upon 
 * methods that are located within the {@link org.apache.tuscany.samples.sdo.otherSources} package.
 * 
 * @author Robbie Minshall
 * @see org.apache.tuscany.samples.sdo.otherSources.PurchaseOrderCmdLine
 * 
 */
public class PurchaseOrderControl {

    // there are a number of ways to set properties
    // these constants define which mechanism the user
    // would like to use.
    public static final int SET_DECIMAL_PROPERTY_VIA_SET = 1;

    public static final int SET_DECIMAL_PROPERTY_VIA_SET_STRING = 2;

    public static final int SET_DECIMAL_PROPERTY_VIA_SET_DOUBLE = 3;

    // local variable to determine which of the above mechanisms to use
    private int decimalPropertyMethod = SET_DECIMAL_PROPERTY_VIA_SET_STRING;

    // these files can be optionally used to specify where to locate xsd and xml
    // to define types and populate DataObject
    // if these are null will use the resources above
    private String xmlFileName;

    private String xsdFileName;

    // root DataObject
    private DataObject purchaseOrder;

    /**
     * Uses resources files included in jar file to define types (using xsd), and
     * populate DataObjects (xml)
     * 
     * @throws Exception
     */
    public PurchaseOrderControl() throws Exception {
        this(null, null);
    }

    /**
     * Uses files on the file system to define types (using xsd), and populate
     * DataObjects (xml)
     * 
     * @param xsdFileName
     *            location of po.xsd
     * @param xmlFileName
     *            location of xml to populate DataObject (for example po.xml)
     * @throws Exception
     */
    public PurchaseOrderControl(String xsdFileName, String xmlFileName) throws Exception {
        this.xsdFileName = xsdFileName;
        this.xmlFileName = xmlFileName;

        // define purchase order types for SDO
        definePurchaseOrderTypes();
        // read in existing xml and populate DataObjects
        readPurchaseOrderXml();
    }

    /**
     * Method to take XSD (w3c) to define SDO types. This is static so that it can be
     * used as a helper method for some simpler examples Uses either fileName used to
     * construct this class or will use resource ( po.xsd ) included within jar file
     */
    private void definePurchaseOrderTypes() throws Exception {

        if ((xsdFileName == null) || (xsdFileName.equals("")) || (xsdFileName.equalsIgnoreCase("null"))) {

            // use simple example to define type from resource
            CreateDataObjectFromXsdAndXmlFiles.definePurchaseOrderTypeUsingXsdResource();

        } else {
            System.out.println("Using file to access xsd in order to define types");
            try {
                FileInputStream fis = new FileInputStream(xsdFileName);
                XSDHelper.INSTANCE.define(fis, null);
                fis.close();
                System.out.println("Sucessfully used " + xsdFileName + " to define types");

            } catch (Exception e) {
                System.out.println("Could not access file " + xsdFileName);
                e.printStackTrace();
                throw e;
            }

        }
    }

    /**
     * Reads in xml and populates DataGraph.
     * 
     * Will set the purchaseOrder to the root object Uses either fileName used to
     * construct this class or will use resource ( po.xml ) included within jar file
     */
    public void readPurchaseOrderXml() throws Exception, FileNotFoundException {

        if ((xmlFileName == null) || (xmlFileName.equals("")) || (xmlFileName.equalsIgnoreCase("null"))) {

            purchaseOrder = CreateDataObjectFromXsdAndXmlFiles.createPurchaseOrderDataObjectUsingXmlResource();
        } else {
            try {

                System.out.println("Using file to access xml to populate DataObjects");
                FileInputStream fis = new FileInputStream(xmlFileName);
                XMLDocument xmlDoc = XMLHelper.INSTANCE.load(fis);
                purchaseOrder = xmlDoc.getRootObject();
                System.out.println("Sucessfully used file to populate DataObjects");
                fis.close();
            } catch (Exception e) {
                System.out.println("Could not open and use file " + xmlFileName);
                e.printStackTrace();
                throw e;
            }
        }

    }

    /**
     * Appends new comment to comment property of purchase order Accesses comment
     * property by name
     * 
     * @param newComment
     */
    public void appendComment(String newComment) {
        String oldComment = (String) purchaseOrder.get("comment");
        setComment(oldComment + "-" + newComment);
    }

    /**
     * Sets comment property on purchase order by accessing property by name
     * 
     * @param comment
     */
    public void setComment(String comment) {
        // set using path info
        purchaseOrder.set("comment", comment);
    }

    /**
     * Modifies complex address type for billTo. If any parameter is null it will not
     * be modified
     * 
     * @param name
     * @param street
     * @param city
     * @param state
     * @param zip
     */
    public void modifyBillTo(String name, String street, String city, String state, String zip) {

        DataObject billTo = purchaseOrder.getDataObject("billTo");
        modifyAddress(billTo, name, street, city, state, zip);
    }

    /**
     * Modifies complex address type for shipTo. If any parameter is null it will not
     * be modified
     * 
     * @param name
     * @param street
     * @param city
     * @param state
     * @param zip
     */
    public void modifyShipTo(String name, String street, String city, String state, String zip) {

        DataObject shipTo = purchaseOrder.getDataObject("shipTo");
        modifyAddress(shipTo, name, street, city, state, zip);
    }

    /**
     * Modifies complex address type ( used for either billTo or shipTo ) If any
     * parameter is null it will not be modified
     * 
     * @param name
     * @param street
     * @param city
     * @param state
     * @param zip
     */
    private void modifyAddress(DataObject dataObject, String name, String street, String city, String state, String zip) {
        if ((name != null) && (!name.equals(""))) {
            dataObject.set("name", name);
        }
        if ((street != null) && (!street.equals(""))) {
            dataObject.set("street", street);
        }
        if ((city != null) && (!city.equals(""))) {
            dataObject.set("city", city);
        }
        if ((state != null) && (!state.equals(""))) {
            dataObject.set("state", state);
        }
        if ((zip != null) && (!zip.equals(""))) {
            // there are a number of ways to set a decimal property
            // so in order to demonstrate the various output results
            // the user can determine which manner to do so
            setDecimalPropertyOnDataObject(dataObject, "zip", zip);
        }
    }

    /**
     * Adds an additional item to the items list of the item property on purchase
     * order DataObject
     * 
     * @param partNumber
     * @param productName
     * @param price
     * @param quantity
     * @param comment
     */
    public void addItem(String partNumber, String productName, double price, int quantity, String comment) {
        // get items dataObject
        DataObject items = purchaseOrder.getDataObject("items");

        // create a new child data object
        DataObject newItem = items.createDataObject("item");
        newItem.setString("partNum", partNumber);
        newItem.setString("productName", productName);
        newItem.setInt("quantity", quantity);
        newItem.setDouble("price", price);
        newItem.setString("comment", comment);

    }

    /**
     * Removes a particular item from the items list. Obtains the List associated
     * with the item property and removes by index
     * 
     * @param index
     */
    public void removeItem(int index) {
        // TODO: this is not working due to java.lang.ClassCastException:
        // org.eclipse.emf.ecore.util.EcoreEList$Dynamic incompatible with
        // commonj.sdo.DataObject
        // access a DataObject by the index and then remove it
        DataObject items = purchaseOrder.getDataObject("items");
        List itemList = items.getList("item");
        itemList.remove(index);
    }

    /**
     * Saves modified purchase order DataObject to original xml used to populate it
     * If resource packaged within jar is used will create a new file on file system
     * 
     * @throws IOException
     */
    public void save() throws IOException {
        if (this.xmlFileName != null) {
            saveAs(xmlFileName);            
        } else {
            System.out.println("Sorry, can not save to resource within jar, will create file called " + SdoSampleConstants.PO_XML_RESOURCE
                    + " and save");
            saveAs(SdoSampleConstants.PO_XML_RESOURCE);
        }
    }

    /**
     * Saves modified purchaseOrder DataObject to file
     * 
     * @param fileName.
     *            Location to save file to save DataObject to
     * @throws IOException
     */
    public void saveAs(String fileName) throws IOException {
        OutputStream stream = new FileOutputStream(fileName);
        XMLHelper.INSTANCE.save(purchaseOrder, SdoSampleConstants.PO_NAMESPACE, "purchaseOrder", stream);
        System.out.println("Saved to " + fileName);
    }

    // PRINTING METHODS TO SYSTEM.OUT

    /**
     * Prints purchase order summary to System.out
     */

    public void printChangeSummary() {

        // TODO: change summary is not currently working
        ChangeSummary changeSummary = getChangeSummary();
        boolean logging = changeSummary.isLogging();
        if (!logging) {
            System.out.println("Change logging is disabled");
        } else {
            System.out.println("Change logging is enabled");
        }
        // TODO: complete this method

    }

    /**
     * Uses simple sample PrintPropertiesOfDataObject
     */
    public void printPurchaseOrderProperties() throws Exception {
        // use previously created method from simple sample
        PrintPropertiesOfDataObject.printDataObjectProperties(purchaseOrder);
    }

    /**
     * Accesses key properties via name and prints to System.out
     * 
     */
    public void printPurchaseOrderSummary() {
        // use previously created method from simple sample
        // for an example of accessing properties by name see
        // AccessDataObjectPropertiesByName or
        // the method below printAddressInfo
        AccessDataObjectPropertiesByName.printPurchaseOrderSummary(purchaseOrder);
    }

    /**
     * Accesses properties of USAddress Type by name and prints to System.out
     * 
     * @param dataObject.
     *            Either shipTo and billTo property of purchase order
     */
    private void printAddressInfo(DataObject dataObject) {
        System.out.println("    name: " + dataObject.get("name"));
        System.out.println("    street: " + dataObject.get("street"));
        System.out.println("    city: " + dataObject.get("city"));
        System.out.println("    state: " + dataObject.get("state"));
        System.out.println("    zip: " + dataObject.get("zip"));
    }

    /**
     * Prints properties of shipTo
     * 
     */
    public void printBillTo() {
        DataObject billTo = purchaseOrder.getDataObject("billTo");
        printAddressInfo(billTo);
    }

    /**
     * Prints properties of billTo
     * 
     */
    public void printShipTo() {
        DataObject shipTo = purchaseOrder.getDataObject("shipTo");
        printAddressInfo(shipTo);
    }

    // GETTERS AND SETTERS

    /**
     * Sets the mechanism to set decimal property for zip code Decimals can be set in
     * a number of ways. This scenario controls how this class will set the zip code
     * when modifying address
     */
    public void setDecimalPropertyMethod(int i) {
        decimalPropertyMethod = i;
    }

    /**
     * Gets the mechanism used to zip decimal property for the zip code of an address
     * 
     * @return
     */
    public int getDecimalPropertyMethod() {
        return decimalPropertyMethod;
    }

    // METHODS TO GET AND COPY DATAOBJECTS
    /**
     * @return purchaseOrder DataObject
     */
    public DataObject getPurchaseOrder() {
        return purchaseOrder;
    }

    /**
     * 
     * @return deep copy of the purchase order DataObject
     */
    public DataObject getDeepCopyPurchaseOrder() {
        return CopyHelper.INSTANCE.copy(purchaseOrder);

    }

    /**
     * 
     * @return shallow copy of the purchase order DataObject
     */
    public DataObject getShallowCopyPurchaseOrder() {
        return CopyHelper.INSTANCE.copyShallow(purchaseOrder);
    }

    /**
     * Currently this does not work
     * 
     * @return Change summary for purchaseOrder
     * 
     */
    public ChangeSummary getChangeSummary() {
        // TODO: why is the data graph null
        return purchaseOrder.getDataGraph().getChangeSummary();
    }

    /**
     * 
     * @return XMLDocument that represents current purchase order DataObject
     */
    public XMLDocument getXMLDocuement() {
        return XMLHelper.INSTANCE.createDocument(purchaseOrder, SdoSampleConstants.PO_NAMESPACE, "purchaseOrder");
    }

    /**
     * 
     * @return String xml representation of current purcahse order DataObject
     */
    public String getXMLString() {
        // alternativly could use the following
        // return XMLHelper.INSTANCE.createDocument(purchaseOrder, PO_NAMESPACE,
        // "purchaseOrder").toString();
        return XMLHelper.INSTANCE.save(purchaseOrder, SdoSampleConstants.PO_NAMESPACE, "purchaseOrder");
    }

    // PRIVATE HELPER METHODS

    /**
     * Uses a variety of ways to set a decimal property on a DataObject
     * 
     * @param dataObject
     * @param propertyName
     * @param propertyValue
     */
    private void setDecimalPropertyOnDataObject(DataObject dataObject, String propertyName, String propertyValue) {
        // since the type specified in the xsd is of type decimal when we
        // wish to just use the set method one must construct a BigDecimal or
        // else a ClassCastException will occur
        // alternativly one could call dataObject.setString(zip) or
        // dataObject.setDouble( Double.valueOf(zip))
        switch (decimalPropertyMethod) {

        case (SET_DECIMAL_PROPERTY_VIA_SET): {
            dataObject.set(propertyName, new BigDecimal(propertyValue));
            break;
        }
        case (SET_DECIMAL_PROPERTY_VIA_SET_DOUBLE): {
            dataObject.setDouble(propertyName, Double.valueOf(propertyValue).doubleValue());
            break;
        }
        case (SET_DECIMAL_PROPERTY_VIA_SET_STRING): {
            dataObject.setString(propertyName, propertyValue);
            break;
        }
        default: {
            dataObject.setString(propertyName, propertyValue);
        }

        }// end of switch

    }
}
