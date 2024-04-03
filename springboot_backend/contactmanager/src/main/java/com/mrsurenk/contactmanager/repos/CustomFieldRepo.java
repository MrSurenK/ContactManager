package com.mrsurenk.contactmanager.repos;

import com.mrsurenk.contactmanager.models.CustomField;
import org.springframework.data.repository.CrudRepository;

public interface CustomFieldRepo extends CrudRepository<CustomField, Long> {
}
