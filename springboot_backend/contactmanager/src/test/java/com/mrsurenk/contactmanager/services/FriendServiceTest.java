package com.mrsurenk.contactmanager.services;

import com.mrsurenk.contactmanager.dto.UserAccountDTO;
import com.mrsurenk.contactmanager.exceptions.NoContactsFoundException;
import com.mrsurenk.contactmanager.models.UserAccount;
import com.mrsurenk.contactmanager.repos.UserAccountRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

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
        account1 = new UserAccount();
        account1.setName("John");
        account2 = new UserAccount();
        account2.setName("Jonathan");
    }

    // Test search for friend
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

    @Test
    @DisplayName("Test if no such contact exists")
    public void noContactInSearch() {
        //arrange
        when(userAccountRepo.findByNameContainingIgnoreCase((anyString()))).thenReturn(new ArrayList<>());

        //act and assert
        assertThrows(NoContactsFoundException.class, () ->
                friendService.searchContacts("Sarah")
        );

    }

    //Get friend contact information
    @Test
    @DisplayName("Test if account information can be retrieved")
    public void testAccountInfo() {
        //arrange
        UUID id = UUID.randomUUID();
        account1.setEmail("test@gmail.com");
        account1.setContact("+6588612344");
        when(userAccountRepo.findById(id)).thenReturn(Optional.of(account1));

        //act
        UserAccountDTO acc = friendService.getAccountInfo(id);
        

        //assert
        assertNotNull(acc);
        assertEquals("John", acc.name());
        assertEquals("test@gmail.com",acc.email());
        assertEquals("+6588612344",acc.contact());
        //ToDO: assert to test display picture is set

    }
}
