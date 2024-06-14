package com.mrsurenk.contactmanager.dto;

public record LoginDTO(
        String email,
        String password
) {

    public LoginDTO {
        if (email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be empty!");
        }
        if (password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be empty!");
        }
    }
}