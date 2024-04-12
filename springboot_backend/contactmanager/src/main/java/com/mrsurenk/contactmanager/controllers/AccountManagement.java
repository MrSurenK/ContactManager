package com.mrsurenk.contactmanager.controllers;

import com.mrsurenk.contactmanager.dto.AccountCreation;
import com.mrsurenk.contactmanager.dto.AccountCreationDTOMapper;
import com.mrsurenk.contactmanager.models.UserAccount;
import com.mrsurenk.contactmanager.repos.UserAccountRepo;
import com.mrsurenk.contactmanager.services.ImageUploadService;
import com.mrsurenk.contactmanager.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class AccountManagement {

    @Autowired
    ImageUploadService imageUploadService;

    @Autowired
    SignUpService signUpService;

    @Autowired
    UserAccountRepo userAccountRepo;

    @Autowired
    AccountCreationDTOMapper mapper;


    //AccountCreation is the DTO
    @PostMapping("/signup")
    public ResponseEntity<String> createNewUser(@ModelAttribute AccountCreation formFields, @RequestParam MultipartFile imageFile) throws IOException {
            signUpService.checkIfAccountExists(formFields);
            String imageDir = imageUploadService.uploadImage(imageFile);
            UserAccount newUser = mapper.mapDTOtoUser(formFields);
            newUser.setDisplayPic(imageDir);
            userAccountRepo.save(newUser);
            return ResponseEntity.ok("User account successfully created!");
    }
}


