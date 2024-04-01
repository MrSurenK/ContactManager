package com.mrsurenk.contactmanager.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import static jakarta.persistence.FetchType.LAZY;

@Data
@Entity
public class UserAccount {
    @Id
    @GeneratedValue
    private UUID id;

    @OneToMany(mappedBy = Contacts_.USER_ID)
    private Set<Contacts> contacts;

    @Column(unique = true)
    private String email;

    private String password;

    private String contact;

    private LocalDate lastLogin;

    private boolean hidden;

}
