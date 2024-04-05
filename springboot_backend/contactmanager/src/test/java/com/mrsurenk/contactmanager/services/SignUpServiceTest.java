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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
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

}
