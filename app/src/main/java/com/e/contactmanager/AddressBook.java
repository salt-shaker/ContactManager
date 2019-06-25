package com.e.contactmanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 * The Class AddressBook.
 *
 * The central class to the address book. All other classes except the console
 * class associate with the address book class.
 *
 * @author Sashae
 */
public class AddressBook {

    private int curMenu;
    private int curContact;
    private MenuOptions menu;
    private Logger logger;
    private Settings settings;
    private UserInput uInput;
    private Scanner scanner;
    private ArrayList<BaseContact> contacts = new ArrayList<BaseContact>();
    private BusinessService biz;

    /**
     * Instantiates a new address book.
     *
     */
    public AddressBook(Logger newLogger) {
        this.logger = newLogger;
        //this.settings = newSettings;
        this.biz = new BusinessService(newLogger);
        logger.log("Address Book Created.");
    }

    public void load() {
        this.contacts = biz.load();
    }

    public void save() {
        biz.save(contacts);
    }

    public ArrayList<BaseContact> getContacts(){
        return this.contacts;
    }


    // Sort Menu
    private boolean sortBy(String input) {
        // Check User Input
        switch (input.toLowerCase()) {
            case "uid ascending":
                /* Sorting based on UID */
                System.out.println("Contact UID ASC Sorting:");
                Collections.sort(contacts, BaseContact.uidComparatorDSC);

                for (BaseContact x : contacts) {
                    System.out.println(x.toString());
                }
                break;
            case "uid descending":
                /* Sorting based on UID */
                System.out.println("Contact UID DSC Sorting:");
                Collections.sort(contacts, BaseContact.uidComparatorDSC);

                for (BaseContact x : contacts) {
                    System.out.println(x.toString());
                }
                break;
            case "first name ascending":
                /* Sorting based on Contact Name */
                System.out.println("Contact First Name ASC Sorting:");
                Collections.sort(contacts, BaseContact.fNameComparatorASC);

                for (BaseContact x : contacts) {
                    System.out.println(x.toString());
                }
                break;
            case "first name descending":
                /* Sorting based on Contact Name */
                System.out.println("Contact First Name DSC Sorting:");
                Collections.sort(contacts, BaseContact.fNameComparatorDSC);

                for (BaseContact x : contacts) {
                    System.out.println(x.toString());
                }
                break;
            case "last name ascending":
                /* Sorting based on Contact Name */
                System.out.println("Contact Last Name DSC Sorting:");
                Collections.sort(contacts, BaseContact.lNameComparatorASC);

                for (BaseContact x : contacts) {
                    System.out.println(x.toString());
                }
                break;
            case "last name descending":
                /* Sorting based on Contact Name */
                System.out.println("Contact Last Name DSC Sorting:");
                Collections.sort(contacts, BaseContact.lNameComparatorDSC);

                for (BaseContact x : contacts) {
                    System.out.println(x.toString());
                }
                break;
            case "back":
                curMenu = 0;
                break;
            case "exit":
                return false;
            default:
                System.out.println("Input not valid!");
        }
        return true;
    }



    /**
     * Removes contact from contact list if match is found
     */
    // Remove a contact
    private void delete(String input) {

        boolean match = false;
        // Get User Input

        Iterator<BaseContact> iter = contacts.iterator();

        while (iter.hasNext()) {
            BaseContact x = iter.next();
            if (input.toLowerCase().equals(x.getUID())) {
                System.out.println("User Found!");
                System.out.println("Are you sure you want to delete UID. y/n");
                System.out.println(x.toString());
                match = true;

                while (true) {
                    String input2 = uInput.getInputString(scanner);
                    if (input2.toLowerCase().equals("y")) {
                        iter.remove();
                        curMenu = 0;
                        break;
                    } else if (input2.toLowerCase().equals("n")) {
                        curMenu = 0;
                        break;
                    } else if (!input2.toLowerCase().equals("y") && !input2.toLowerCase().equals("n")) {
                        System.out.println("Invalid input. Try again.");
                    }
                }

            }
        }
        if (match == false) {
            System.out.println("No Match Found");
        }
    }


    /**
     * Search contacts for based search criteria
     */
    // Display contact matching search criteria
    private void search(String input) {

        Iterator<BaseContact> iter = contacts.iterator();

        while (iter.hasNext()) {
            BaseContact x = iter.next();
            if (input.toLowerCase().equals(x.getUID())) {
                System.out.println("User Found!");
                curMenu = 8;
                curContact = contacts.indexOf(x);
                break;
            }
        }
    }

    /**
     * @return
     */
    private boolean userExist(String input) {
        try {
            for (BaseContact x : contacts) {
                if (x.getUID().equals(input)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Something Went Wrong in UserExist()");
        }

        return false;
    }
}

