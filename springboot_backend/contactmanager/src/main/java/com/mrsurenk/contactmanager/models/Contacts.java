package com.mrsurenk.contactmanager.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

import static jakarta.persistence.FetchType.LAZY;
import static org.hibernate.Length.LONG;


@Data
@Entity
public class Contacts {

    @Id
    private UUID id;

    @ManyToOne(fetch=LAZY)
    private UserAccount userId;

    @Column(length=LONG)
    private String notes;

    private boolean deleted;

    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;

}
