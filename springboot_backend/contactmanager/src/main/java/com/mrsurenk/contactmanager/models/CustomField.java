package com.mrsurenk.contactmanager.models;

import com.mrsurenk.contactmanager.models.FieldDefinition_;
import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class CustomField {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Contacts contact;

    private String value; //JSON string data

    private boolean deleted;

    @ManyToOne(fetch = FetchType.LAZY)
    private FieldDefinition fieldDefinition;

}
