package com.mrsurenk.contactmanager.services;

import com.mrsurenk.contactmanager.models.UserAccount;
import com.mrsurenk.contactmanager.repos.UserAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserAccountRepo userAccountRepo;

    public List<UserAccount> allUsers(){
        List<UserAccount> users = new ArrayList<>();

        userAccountRepo.findAll().forEach(users::add);

        return users;
    }

}
