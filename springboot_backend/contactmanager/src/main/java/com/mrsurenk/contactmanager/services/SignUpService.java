package com.mrsurenk.contactmanager.services;

import com.mrsurenk.contactmanager.dto.AccountCreation;
import com.mrsurenk.contactmanager.repos.UserAccountRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Check if account already exists
@Slf4j
@Service
public class SignUpService {

    @Autowired
    UserAccountRepo userAccountRepo;

    //Method that returns the dto from user input fields
    public void checkIfAccountExists(AccountCreation accountCreation){
//        log.info("Checking if account exists for email: {}", accountCreation.email());
        //Validation check if user account already exists via email
        if (userAccountRepo.findByEmail(accountCreation.email()).isPresent()){
//            log.info("Attempt to create a user with an existing email: {}", accountCreation.email());
            throw new IllegalStateException("Email already in use.");
        }

    }
}


