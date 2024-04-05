package com.mrsurenk.contactmanager.controllers;


import com.mrsurenk.contactmanager.dto.AccountCreation;
import com.mrsurenk.contactmanager.models.UserAccount;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountManagement {




    @PostMapping("/signup")
    public UserAccount createNewUser(){



    };




}
