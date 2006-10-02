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
import org.apache.tuscany.samples.sdo.SdoSampleConstants;

/**
 * Provides interactive menu based command line interface to modify, save, view purchase order DataObject.
 * 
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
 * These jar files can be obtained from directly from Tuscany and EMF projects or from <a
 * href="http://wiki.apache.org/ws-data/attachments/Tuscany(2f)TuscanyJava(2f)SDO_Java_Overview/attachments/SDO%20Execution%20Dependencies"
 * target="_bank">SDO Execution Dependancies </a> </LI>
 * <LI>Execute: <br>
 * java org.apache.tuscany.samples.sdo.otherSources.PurchaseOrderCmdLine</LI>
 * </UL>
 * @author Robbie Minshall
 * @see org.apache.tuscany.samples.sdo.SdoSampleConstants
 * @see org.apache.tuscany.samples.sdo.otherSources.PurchaseOrderControl
 */

public class PurchaseOrderCmdLine {

    private static final int MENU = 1;

    private static final int PRINT_SUMMARY = 2;

    private static final int PRINT_ALL_PROPERTIES = 3;

    private static final int PRINT_BILLTO = 4;

    private static final int PRINT_SHIPTO = 5;

    private static final int APPEND_COMMENT = 6;

    private static final int MODIFY_SHIP_TO = 7;

    private static final int MODIFY_BILL_TO = 8;

    private static final int ADD_ITEM = 9;

    private static final int REMOVE_ITEM = 10;

    private static final int SAVE = 11;

    private static final int SAVE_AS = 12;

    private static final int SHOW_CHANGE_SUMMARY = 13;

    private static final int SHOW_XML_DOCUMENT = 14;

    private static final int QUIT = 15;

    /**
     * Drives sample program
     * 
     * @param args.
     *            args[0] is optional xsdFilename, args[1] is optional xmlFileName
     */
    public static void main(String[] args) {

        System.out.println("***************************************");
        System.out.println("SDO Purchase Order Sample Command Line Interface");
        System.out.println("***************************************");
        System.out.println("Provides an interactive menu to play with purchase order DataObjects");
        System.out.println("***************************************");

        printUsage();

        PurchaseOrderControl poc = null;
        String xsdFileName = null;
        String xmlFileName = null;

        // see if we should load an xsd file or if we should use a resource
        if ((args.length >= 1)) {
            xsdFileName = args[0];
        }

        // see if we should load an xml file or if we should use a resource
        if ((args.length >= 2)) {
            xmlFileName = args[1];
        }
        try {
            poc = new PurchaseOrderControl(xsdFileName, xmlFileName);
        } catch (Exception e) {
            System.out.println("Sorry could not initialize PurchaseOrderControl.  Error: " + e.toString());
            e.printStackTrace();
            return;
        }
        boolean inOperation = true;
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int command = QUIT;

            printMenu();
            while (inOperation) {
                System.out.print(">>>  ");
                try {
                    command = Integer.valueOf(in.readLine()).intValue();
                } catch (Exception e) {
                    System.out.println("Invalid option, please try again.");
                    command = MENU;

                }
                switch (command) {
                case MENU:
                    printMenu();
                    
                    break;
                case PRINT_SUMMARY:
                    poc.printPurchaseOrderSummary();
                    break;
                case PRINT_ALL_PROPERTIES:
                    try {
                        poc.printPurchaseOrderProperties();
                    } catch (Exception e) {
                        System.out.println("Sorry the following error was received when printing all properties " + e.toString());
                        e.printStackTrace();
                    }
                    break;
                case PRINT_BILLTO:
                    poc.printBillTo();
                    break;
                case PRINT_SHIPTO:
                    poc.printShipTo();
                    break;
                case APPEND_COMMENT:
                    try {

                        System.out.println("Append Comment: ");
                        poc.appendComment(in.readLine());
                    } catch (Exception e) {
                        System.out.println("Sorry unexpected exception occured appending comment" + e.toString());
                        e.printStackTrace();
                    }

                    break;
                case MODIFY_SHIP_TO:
                    try {

                        System.out.println("Modify Ship To ( press enter to leave unchanged )");
                        poc.printShipTo();
                        System.out.print("Name: ");
                        String name = in.readLine();
                        System.out.println();

                        System.out.print("Street: ");
                        String street = in.readLine();
                        System.out.println();

                        System.out.print("City: ");
                        String city = in.readLine();
                        System.out.println();

                        System.out.print("State: ");
                        String state = in.readLine();
                        System.out.println();

                        System.out.print("Zip: ");
                        String zip = in.readLine();
                        if ((zip != null) && (!zip.equals(""))) {
                            selectSetDecimalOption(in, poc);
                        }
                        System.out.println();

                        poc.modifyShipTo(name, street, city, state, zip);
                    } catch (Exception e) {
                        System.out.println("Sorry unexpected exception occured modifying ShipTo address :" + e.toString());
                        e.printStackTrace();
                    }

                    break;
                case MODIFY_BILL_TO:
                    try {

                        System.out.println("Modify Bill To ( press enter to leave unchanged )");
                        poc.printBillTo();
                        System.out.print("Name: ");
                        String name = in.readLine();
                        System.out.println();

                        System.out.print("Street: ");
                        String street = in.readLine();
                        System.out.println();

                        System.out.print("City: ");
                        String city = in.readLine();
                        System.out.println();

                        System.out.print("State: ");
                        String state = in.readLine();
                        System.out.println();

                        System.out.print("Zip: ");
                        String zip = in.readLine();
                        if ((zip != null) && (!zip.equals(""))) {
                            selectSetDecimalOption(in, poc);
                        }
                        System.out.println();

                        poc.modifyBillTo(name, street, city, state, zip);
                    } catch (Exception e) {
                        System.out.println("Sorry unexpected exception occured when modifying address :" + e.toString());
                        e.printStackTrace();
                    }

                    break;

                case ADD_ITEM:

                    try {
                        System.out.println("Add item to Purchase Order");
                        System.out.print("Product Number: ");
                        String productNumber = in.readLine();
                        System.out.println();

                        System.out.print("Product Name: ");
                        String productName = in.readLine();
                        System.out.println();

                        System.out.print("Quantity: ");
                        int quantity = Integer.valueOf(in.readLine()).intValue();
                        System.out.println();

                        System.out.print("Price: ");
                        double price = Double.valueOf(in.readLine()).doubleValue();
                        System.out.println();

                        System.out.print("Comment: ");
                        String comment = in.readLine();
                        System.out.println();

                        poc.addItem(productNumber, productName, price, quantity, comment);
                    } catch (Exception e) {
                        System.out.println("Sorry unexpected exception occured when adding item :" + e.toString());
                        e.printStackTrace();
                    }

                    break;
                case REMOVE_ITEM:
                    try {
                        System.out.print("Please enter the index of the item you would like to remove :");
                        String index = in.readLine();
                        poc.removeItem(Integer.valueOf(index).intValue());

                    } catch (Exception e) {
                        System.out.println("Sorry there was an error when remove item : " + e.toString());
                        e.printStackTrace();

                    }
                    break;
                case SAVE:
                    try {
                        poc.save();
                    } catch (IOException e) {
                        System.out.println("Sorry an error was received : " + e.toString());
                        e.printStackTrace();
                    }
                    break;
                case SAVE_AS:
                    System.out.print("FileName:");
                    String fileName = in.readLine();
                    try {
                        poc.saveAs(fileName);
                        System.out.println("File saved to " + fileName);
                    } catch (IOException e) {
                        System.out.println("Sorry an error was received : " + e.toString());
                        e.printStackTrace();
                    }
                    break;
                case SHOW_CHANGE_SUMMARY:
                    try {

                        poc.printChangeSummary();
                    } catch (Exception e) {
                        System.out.println("Sorry exception caught when accessing change summary : " + e.toString());
                        e.printStackTrace();
                    }

                    break;
                case SHOW_XML_DOCUMENT:
                    try {
                        System.out.println("XMLDocument representing purchase order: ");
                        System.out.println(poc.getXMLString());
                    } catch (Exception e) {
                        System.out.println("Sorry there was an erorr when printing the XMLDocument :" + e.toString());
                        e.printStackTrace();
                    }
                    break;
                case QUIT:
                    inOperation = false;
                    break;
                default:
                    System.out.println("Sorry I did not understand the command");
                    printMenu();
                }
            }
            System.out.println("Goodbye");

        } catch (Exception e) {
            System.out.println("Unexpected exception occured during execution: " + e.toString());
            e.printStackTrace();
        }

    }

    private static void selectSetDecimalOption(BufferedReader in, PurchaseOrderControl poc) {
        try {

            System.out.println("SDO provides a number of methods to set properties on a DataObject");
            System.out.println("Please select the method that you would like to use in order to set decimal values");
            System.out.println("1.  dataObject.set(. . . )");
            System.out.println("2.  dataObject.setString(. . . )");
            System.out.println("3.  dataObject.setDouble(. . . )");
            System.out.print(">>>");

            poc.setDecimalPropertyMethod(Integer.valueOf(in.readLine()).intValue());
        } catch (Exception e) {
            System.out.println("invalid option - oh well");
        }

    }

    private static void printUsage() {
        System.out.println("***************************************");
        System.out.println("java org.apache.tuscany.samples.sdo.otherSources.PurchaseOrderCmdLine <xsdFileName> <xmlFileName>");
        System.out.println("If xsdFileName and xmlFileName are not specified " + SdoSampleConstants.PO_XSD_RESOURCE + " and "
                + SdoSampleConstants.PO_XML_RESOURCE + " will be used as resources");
        System.out.println("Specify null if you wish to use the appropiate resource from the jar rather specifying a fileName");
        System.out.println("***************************************");
    }

    private static void printMenu() {
        System.out.println("***************************************");
        System.out.println("Purchase Order Control Menu");
        System.out.println(MENU + ".  MENU");
        System.out.println(PRINT_SUMMARY + ".  PRINT_SUMMARY");
        System.out.println(PRINT_ALL_PROPERTIES + ".  PRINT_ALL_PROPERTIES");
        System.out.println(PRINT_BILLTO + ".  PRINT_BILLTO");
        System.out.println(PRINT_SHIPTO + ".  PRINT_SHIPTO");
        System.out.println(APPEND_COMMENT + ".  APPEND_COMMENT");
        System.out.println(MODIFY_SHIP_TO + ".  MODIFY_SHIP_TO");
        System.out.println(MODIFY_BILL_TO + ".  MODIFY_BILL_TO");
        System.out.println(ADD_ITEM + ".  ADD_ITEM");
        System.out.println(REMOVE_ITEM + ". REMOVE_ITEM");
        System.out.println(SAVE + ". SAVE");
        System.out.println(SAVE_AS + ". SAVE_AS");
        System.out.println(SHOW_CHANGE_SUMMARY + ". SHOW_CHANGE_SUMMARY");
        System.out.println(SHOW_XML_DOCUMENT + ". SHOW_XML_DOCUMENT");
        System.out.println(QUIT + ". QUIT");
        System.out.println("***************************************");
    }
}
