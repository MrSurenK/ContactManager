package com.mrsurenk.contactmanager.dto;

import com.mrsurenk.contactmanager.models.UserAccount;
import org.springframework.stereotype.Component;

@Component
public class AccountCreationDTOMapper {

    //Map user input fields to DTO
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
      UserAccount newAccount = new UserAccount();
      newAccount.setEmail(dto.email());
      return newAccount;
    };

}
