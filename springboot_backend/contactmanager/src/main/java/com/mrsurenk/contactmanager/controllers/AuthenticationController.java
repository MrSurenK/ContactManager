package com.mrsurenk.contactmanager.controllers;

import com.mrsurenk.contactmanager.configurations.LoginResponse;
import com.mrsurenk.contactmanager.dto.AccountCreation;
import com.mrsurenk.contactmanager.dto.LoginDTO;
import com.mrsurenk.contactmanager.models.UserAccount;
import com.mrsurenk.contactmanager.repos.UserAccountRepo;
import com.mrsurenk.contactmanager.services.AuthenticationService;
import com.mrsurenk.contactmanager.services.ImageUploadService;
import com.mrsurenk.contactmanager.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    @Autowired
    ImageUploadService imageUploadService;

    @Autowired
    UserAccountRepo userAccountRepo;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    JwtService jwtService;

    //AccountCreation is the DTO
    @PostMapping("/signup")
    public ResponseEntity<UserAccount> createNewUser(@ModelAttribute AccountCreation formFields, @RequestParam(name="imgFile", required = false) MultipartFile imageFile) throws IOException {
            if (userAccountRepo.findByEmail(formFields.email()).isPresent()){
//            log.info("Attempt to create a user with an existing email: {}", accountCreation.email());
            throw new IllegalStateException("Email already in use.");
            }

            String imageDir = imageUploadService.uploadImage(imageFile);


            UserAccount newUser = authenticationService.signup(formFields);
            newUser.setDisplayPic(imageDir);
            userAccountRepo.save(newUser);
            return ResponseEntity.ok(newUser);
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginDTO loginDTO){

        UserAccount authenticatedUser = authenticationService.authenticate(loginDTO);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = LoginResponse.builder()
                .accessToken(jwtToken)
                .expiresIn(jwtService.getExpirationTime())
                .userName(authenticatedUser.getName())
                .build();

        return ResponseEntity.ok(loginResponse);
    }
}

/*ToDO:
   1. Refresh Token feature
   2. Logout Feature
 */
