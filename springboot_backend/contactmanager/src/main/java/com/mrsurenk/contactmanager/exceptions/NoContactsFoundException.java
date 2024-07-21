package com.mrsurenk.contactmanager.exceptions;

public class NoContactsFoundException extends RuntimeException {

    public NoContactsFoundException(String message) {
        super(message);
    }
}
