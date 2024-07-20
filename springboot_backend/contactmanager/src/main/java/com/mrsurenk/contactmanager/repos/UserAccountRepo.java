package com.mrsurenk.contactmanager.repos;

import com.mrsurenk.contactmanager.models.UserAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserAccountRepo extends CrudRepository<UserAccount, UUID> {
    Optional<UserAccount> findByEmail(String email);

    List<UserAccount> findByNameContainingIgnoreCase(String name);
}
