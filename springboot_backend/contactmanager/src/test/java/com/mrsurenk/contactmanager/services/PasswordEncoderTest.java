package com.mrsurenk.contactmanager.services;


import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PasswordEncoderTest {
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    //Test that password is being encrypted
    @Test
    public void testPasswordEncryption(){
        String rawPassword = "mypassword";
        String encryptedPassword = passwordEncoder.encode(rawPassword);

        assertNotEquals(rawPassword, encryptedPassword, "Raw password should not match encrypted password");
    }

    //Test password matcher
    @Test
    public void testPasswordMatcher(){
        String rawPassword = "mypassword";
        String encryptedPassword1 = passwordEncoder.encode(rawPassword);
        String encryptedPassword2 = passwordEncoder.encode(rawPassword);

        assertNotEquals(encryptedPassword1,encryptedPassword2,"Encrypting the same password twice should not equal each other");
    }


}
