package com.mrsurenk.contactmanager.models;

import com.mrsurenk.contactmanager.models.CustomField_;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class FieldDefinition {
    //Seed this table to control allowable entries
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fieldName;

    private String fieldType;

    @OneToMany(mappedBy = CustomField_.FIELD_DEFINITION)
    private Set<CustomField> customField;

}
