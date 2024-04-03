package com.mrsurenk.contactmanager.dto;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.regex.Pattern;

public record AccountCreation(

        String email,

        String password,

        String userName,

        String contact

) {

    private static final Pattern CONTACT_PATTERN = Pattern.compile("\\+65[689]\\d{7}");

    //Record field validations
    public AccountCreation{
        if(email.isBlank()){
            throw new IllegalArgumentException("Email cannot be empty!");
        }
        if (!EmailValidator.getInstance().isValid(email)){
            throw new IllegalArgumentException("Invalid email!");
        }
        if (password.isBlank()){
            throw new IllegalArgumentException("Password cannot be empty");
        }
        if (password.length()< 8){
            throw new IllegalArgumentException("Password has to be longer than 8 characters");
        }
        if (userName.isBlank()){
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (contact.isBlank()){
            throw new IllegalArgumentException("Contact cannot be empty");
        }
        if (!contactValidator(contact)){
            throw new IllegalArgumentException("Contact invalid");
        }
    }

    public boolean contactValidator(String tester){
       return CONTACT_PATTERN.matcher(tester).matches();
    }

}
