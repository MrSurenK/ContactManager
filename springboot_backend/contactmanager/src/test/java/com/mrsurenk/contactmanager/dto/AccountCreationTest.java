package com.mrsurenk.contactmanager.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AccountCreationTest {

    //Test valid account creation
    @Test
    public void testValidAccountCreation(){
        assertDoesNotThrow(()-> new AccountCreation(
                "test@example.com",
                "strongpassword",
                "john",
                "+6581234565"
        ));
    }

    //Test validations
    @Test
    public void testInvalidEmail(){
        assertThrows(IllegalArgumentException.class, ()-> new AccountCreation(
                "invalidemail",
                "strongpassword",
                "John",
                "+6581234565"
        ));
    }

    @Test
    public void testInvalidPassword(){
        assertThrows(IllegalArgumentException.class, ()-> new AccountCreation(
                "test@example.com",
                "invalid",
                "John",
                "+6581234565"
        ));
    }

    @Test
    public void testInvalidName(){
        assertThrows(IllegalArgumentException.class, ()-> new AccountCreation(
                "test@example.com",
                "invalid",
                "",
                "+6581234565"
        ));
    }

    @Test
    public void testInvalidSGContact(){
        assertThrows(IllegalArgumentException.class, ()-> new AccountCreation(
                 "test@example.com",
                "invalid",
                "",
                "+12234565"
        ));
    }
}
