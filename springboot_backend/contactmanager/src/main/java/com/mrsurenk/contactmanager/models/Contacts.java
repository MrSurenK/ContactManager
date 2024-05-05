package com.mrsurenk.contactmanager.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mrsurenk.contactmanager.models.CustomField_;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;
import static org.hibernate.Length.LONG;


@Data
@Entity
public class Contacts {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="userAccount_id", foreignKey = @ForeignKey(name="userAccount_id"))
    private UserAccount userAccount;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="friendAccount_id", foreignKey = @ForeignKey(name="friendAccount_id"))
    private UserAccount friendAccount;

    @Column(length=LONG)
    private String notes;

    private boolean deleted; //for soft delete

    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;

    @OneToMany(mappedBy= CustomField_.CONTACT)
    private Set<CustomField> customField;
}
