package com.mrsurenk.contactmanager.dto;

import com.mrsurenk.contactmanager.models.UserAccount;
import com.mrsurenk.contactmanager.services.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountCreationDTOMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;

//  Map user input fields to DTO (Redundant, only useful in testing)
    public AccountCreation mapFieldsToDTO(String email, String password, String userName, String contact){
        return new AccountCreation(
                email,
                password,
                userName,
                contact
        );
    }

   //Map DTO back to entity instances
    public UserAccount mapDTOtoUser(AccountCreation dto){
//      UserAccount newAccount = new UserAccount();
//      newAccount.setEmail(dto.email());
//      newAccount.setPassword(passwordEncoder.encrypt(dto.password()));
//      newAccount.setUserName(dto.userName());
//      newAccount.setContact(dto.contact());
//      return newAccount;

        //Build using lombok instead (same as above commented code)
        return UserAccount
                .builder()
                .email(dto.email())
                .password(passwordEncoder.encrypt(dto.password()))
                .name(dto.userName())
                .contact(dto.contact())
                .build();
    }

}
