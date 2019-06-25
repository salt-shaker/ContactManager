package com.e.contactmanager;

import java.util.ArrayList;

/**
 * The Interface DataAccessService.
 *
 * @author Sashae
 */
public interface DataAccessService {

    /**
     * Gets the all contacts.
     *
     * @return the all contacts
     */
    public ArrayList<BaseContact> getAllContacts();

    /**
     * @param contacts
     */
    void saveAllContacts(ArrayList<BaseContact> contacts);
}

