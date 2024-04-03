package com.mrsurenk.contactmanager.models;

import com.mrsurenk.contactmanager.models.Contacts_;
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

    @OneToMany(mappedBy= Contacts_.USER_ACCOUNT)
    private Set<Contacts> contactOwner;

    @OneToMany(mappedBy=Contacts_.FRIEND_ACCOUNT)
    private Set<Contacts> friendAcc;

    @Column(unique = true)
    private String email;

    private String userName;

    private String password;

    private String contact;

    private LocalDate lastLogin;

    private boolean hidden;

}
