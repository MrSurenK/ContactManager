package com.mrsurenk.contactmanager.services;

import com.mrsurenk.contactmanager.exceptions.NoContactsFoundException;
import com.mrsurenk.contactmanager.models.UserAccount;
import com.mrsurenk.contactmanager.repos.UserAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FriendService {

    @Autowired
    private UserAccountRepo userAccountRepo;

    @Autowired
    private UserAccount userAccount;

    //Method to search for contacts
    public List<UserAccount> searchContacts(String name) {
        List<UserAccount> contacts = userAccountRepo.findByNameContainingIgnoreCase(name);
        if (contacts.isEmpty()) {
            throw new NoContactsFoundException("No contacts found.");
        } else {
            return contacts;
        }
    }

    //Method to access contact information


}
