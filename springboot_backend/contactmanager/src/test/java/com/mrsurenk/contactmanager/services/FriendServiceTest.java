package com.mrsurenk.contactmanager.services;

import com.mrsurenk.contactmanager.models.UserAccount;
import com.mrsurenk.contactmanager.repos.UserAccountRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FriendServiceTest {

    //TDD principles
    @Mock
    private UserAccountRepo userAccountRepo;

    @InjectMocks
    private FriendService friendService;

    private UserAccount account1;

    private UserAccount account2;

    @BeforeEach
    public void setUp() {
        account1.setName("John");
        account2.setName("Jonathan");
    }

    // Method 1: Send friend request
    @Test
    @DisplayName("Test if user can find friend")
    public void searchTest() {
        //arrange
        when(userAccountRepo.findByNameContainingIgnoreCase(anyString())).thenReturn(Arrays.asList(account1, account2));

        //act
        List<UserAccount> results = friendService.searchContacts("Jon");

        //assert
        assertNotNull(results);
        assertEquals("Jonathan", results.get(1).getName());
        assertNotEquals("John", results.get(1).getName());
    }


}
