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

    //Class methods to send friend request and add friends to contact table
    public List<UserAccount> searchContacts(String name) {
        List<UserAccount> contacts = userAccountRepo.findByNameContainingIgnoreCase(name);
        if (contacts.isEmpty()) {
            throw new NoContactsFoundException("No contacts found.");
        } else {
            return contacts;
        }
    }
    
}
