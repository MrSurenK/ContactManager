package com.mrsurenk.contactmanager.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

import static jakarta.persistence.FetchType.LAZY;

@Data
@Entity
public class UserAccount {
    @Id
    @GeneratedValue
    private UUID id;

//    ToDO: Figure out the rls between this table and Contacts table and fix the issue with mapping.

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="fk_userContact_id")
    private Contacts userContact;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="fk_friendContact_id")
    private Contacts friendContact;

    @Column(unique = true)
    private String email;

    private String password;

    private String contact;

    private LocalDate lastLogin;

    private boolean hidden;

}
