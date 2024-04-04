package com.mrsurenk.contactmanager.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


//service to encrypt and decrypt password
@Service
public class PasswordEncoder {

    public String encrypt(String rawPassword){
        return new BCryptPasswordEncoder().encode(rawPassword);
    }

    public boolean passwordMatch(String rawPassword, String encodedPassword){
        return new BCryptPasswordEncoder().matches(rawPassword, encodedPassword);
    }
}
