package com.mrsurenk.contactmanager.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

import static org.hibernate.Length.LONG;


@Data
@Entity
public class Contacts {

    @Id
    private UUID id;

    @OneToMany(mappedBy=UserAccount_.USER_CONTACT)
    private Set<UserAccount> userAccount;

    @OneToMany(mappedBy =UserAccount_.FRIEND_CONTACT)
    private Set<UserAccount> friendAccount;

    @Column(length=LONG)
    private String notes;

    private boolean deleted;

    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;

}
