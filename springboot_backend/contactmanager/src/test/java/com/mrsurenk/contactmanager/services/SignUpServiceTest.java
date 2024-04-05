package com.mrsurenk.contactmanager.services;

import com.mrsurenk.contactmanager.dto.AccountCreation;
import com.mrsurenk.contactmanager.dto.AccountCreationDTOMapper;
import com.mrsurenk.contactmanager.models.UserAccount;
import com.mrsurenk.contactmanager.repos.UserAccountRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SignUpServiceTest {

    @Mock
    private UserAccountRepo userAccountRepo;

    @Mock
    private AccountCreationDTOMapper mapper;

    @InjectMocks
    private SignUpService signUpService;


    @Test
    public void testNewSaveAccount(){
        AccountCreation accountCreation = new AccountCreation(
                "testemail@gmail.com",
                "strongpassword",
                "John",
                "+6581234567",
                "/displayPic"
        );

        UserAccount newUserAccount = UserAccount.builder()
                        .email("testemail@gmail.com")
                                .password("strongpassword")
                                        .userName("John")
                                                .contact("+6581234567")
                                                        .displayPic("/displayPic")
                                                                .build();


        when(userAccountRepo.findByEmail(anyString())).thenReturn(Optional.empty());
        when(mapper.mapDTOtoUser(any(AccountCreation.class))).thenReturn(newUserAccount);

        signUpService.saveNewAccount(accountCreation);

        verify(userAccountRepo).save(newUserAccount);

    }

    @Test
    public void testIfUserExists(){
    // Given: Setup the existing user in the repository
    String testEmail = "testemail@gmail.com";
    when(userAccountRepo.findByEmail(eq(testEmail))).thenReturn(Optional.of(UserAccount.builder()
            .email(testEmail)
            .password("strongpassword")
            .userName("John")
            .contact("+6581234567")
            .displayPic("/displayPic")
            .build()));

    // When & Then: Verify that attempting to save a new account with the same email throws an exception
    IllegalStateException thrownException = assertThrows(IllegalStateException.class, () ->
            signUpService.saveNewAccount(new AccountCreation(
                    testEmail,
                    "strongpassword",
                    "John",
                    "+6581234567",
                    "/displayPic"
            )));
    assertEquals("Email already in use.", thrownException.getMessage());

    // Verify the interaction with the repository
    verify(userAccountRepo).findByEmail(testEmail);

    }

}
