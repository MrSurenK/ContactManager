package com.mrsurenk.contactmanager.services;

import com.mrsurenk.contactmanager.dto.AccountCreation;
import com.mrsurenk.contactmanager.dto.AccountCreationDTOMapper;
import com.mrsurenk.contactmanager.models.UserAccount;
import com.mrsurenk.contactmanager.repos.UserAccountRepo;
import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SignUpServiceTest {

   @Mock
    private UserAccountRepo userAccountRepo;

    @InjectMocks
    private SignUpService signUpService;

    private AccountCreation accountCreation;
    private final String testEmail = "test@example.com";

    @BeforeEach
    void setUp() {
        accountCreation = new AccountCreation(testEmail,
                "password",
                "username",
                "+6588614532");
    }

    @Test
    void shouldNotThrowWhenEmailIsNotInUse() {
        when(userAccountRepo.findByEmail(testEmail)).thenReturn(Optional.empty());

        // Should not throw an exception
        signUpService.checkIfAccountExists(accountCreation);

        verify(userAccountRepo, times(1)).findByEmail(testEmail);
    }

    @Test
    void shouldThrowWhenEmailIsInUse() {
        when(userAccountRepo.findByEmail(testEmail)).thenReturn(Optional.of(UserAccount.builder().build()));

        // Expect an IllegalStateException
        assertThrows(IllegalStateException.class, () -> signUpService.checkIfAccountExists(accountCreation));

        verify(userAccountRepo, times(1)).findByEmail(testEmail);
    }

}
