package com.mrsurenk.contactmanager.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class UserAccount {
    @Id
    @GeneratedValue
    private UUID id;

    private String userName;

    private String password;

    private String contact;

    private Date lastLogin;

    private boolean hidden;

}
