package com.mrsurenk.contactmanager.services;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


//ToDo: hash password and store into database.
@Service
public class PasswordEncoder {

    public BCryptPasswordEncoder encrypt(String password){

        return new BCryptPasswordEncoder();
    }


}
