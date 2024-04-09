package com.mrsurenk.contactmanager.services;

import com.mrsurenk.contactmanager.dto.AccountCreation;
import com.mrsurenk.contactmanager.repos.UserAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Check if account already exists
@Service
public class SignUpService {


    @Autowired
    UserAccountRepo userAccountRepo;

    //Method that returns the dto from user input fields
    public void checkIfAccountExists(AccountCreation accountCreation){

        //Validation check if user account already exists via email
        if (userAccountRepo.findByEmail(accountCreation.email()).isPresent()){
            throw new IllegalStateException("Email already in use.");
        }

    }
}
