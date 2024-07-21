package com.mrsurenk.contactmanager.services;

import com.mrsurenk.contactmanager.dto.UserAccountDTO;
import com.mrsurenk.contactmanager.exceptions.NoContactsFoundException;
import com.mrsurenk.contactmanager.exceptions.UserNotFoundException;
import com.mrsurenk.contactmanager.models.UserAccount;
import com.mrsurenk.contactmanager.repos.UserAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FriendService {

    @Autowired
    private UserAccountRepo userAccountRepo;


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
    public UserAccountDTO getAccountInfo(UUID id) {
        UserAccount account = userAccountRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        return new UserAccountDTO(
                account.getEmail(),
                account.getName(),
                account.getContact(),
                account.getDisplayPic()
        );
    }


}

//ToDo: Create a DTO to view certain fields of friend account so that selected fields only are shown.
