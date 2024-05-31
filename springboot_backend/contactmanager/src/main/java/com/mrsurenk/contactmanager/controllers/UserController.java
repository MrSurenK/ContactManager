package com.mrsurenk.contactmanager.controllers;

import com.mrsurenk.contactmanager.models.UserAccount;
import com.mrsurenk.contactmanager.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/loggedIn")
    public ResponseEntity<UserAccount> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserAccount currentUser = (UserAccount) authentication.getPrincipal();
        currentUser.setLastLogin(LocalDate.now());

        return ResponseEntity.ok(currentUser);
    }

    // Useful if admin features were to be developed.
    @GetMapping("/allUsers")
    public ResponseEntity<List<UserAccount>> allUsers(){
        List<UserAccount> users = userService.allUsers();

        return ResponseEntity.ok(users);
    }

}
