package com.mrsurenk.contactmanager.repos;

import com.mrsurenk.contactmanager.models.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactsRepo extends JpaRepository<Contacts, Long> { }
