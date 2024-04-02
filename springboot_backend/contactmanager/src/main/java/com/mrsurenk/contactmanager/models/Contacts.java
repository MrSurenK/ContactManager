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

    @ManyToOne(fetch=FetchType.LAZY)
    private UserAccount userAccount;

    @ManyToOne(fetch=FetchType.LAZY)
    private UserAccount friendAccount;

    @Column(length=LONG)
    private String notes;

    private boolean deleted;

    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;

}
