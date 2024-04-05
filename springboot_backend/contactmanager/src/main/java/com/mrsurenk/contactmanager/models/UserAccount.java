package com.mrsurenk.contactmanager.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

//ToDO: Add display picture to entity and corresponding DTO etc...
@Data
@Builder
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

    @Column(length = 72)
    private String password;

    private String contact;

    private LocalDate lastLogin;

    private String displayPic;

    private boolean hidden;

}
