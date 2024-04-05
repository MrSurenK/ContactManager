package com.mrsurenk.contactmanager.dto;

import com.mrsurenk.contactmanager.models.UserAccount;
import com.mrsurenk.contactmanager.services.PasswordEncoder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountCreationDTOMapperTest {

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AccountCreationDTOMapper mapper;

    //Test to see if userAccount is mapped to DTO
    @Test
    public void testValidFieldsMaptoDTO(){
       String email = "test@email.com";
       String password="strongpassword";
       String userName="John";
       String contact="+6581234567";
       String displayPic= "/displayPic.jpg";

      AccountCreation dto = mapper.mapFieldsToDTO(email, password, userName, contact, displayPic);

      assertNotNull(dto);
      assertEquals(email, dto.email());
      assertEquals(password, dto.password());
      assertEquals(userName, dto.userName());
      assertEquals(contact, dto.contact());
      assertEquals(displayPic, dto.displayPic());

    }

    //Test dto mapping to entity instance
    @Test
    public void testMapToDTO(){
        String email = "test@email.com";
        String password="strongpassword";
        String encryptedPassword = "encryptedPassword";
        String userName="John";
        String contact="+6581234567";
        String displayPic="./displayPic.jpg";

        AccountCreation dto = mapper.mapFieldsToDTO(email, password, userName, contact, displayPic);

        when(passwordEncoder.encrypt(password)).thenReturn(encryptedPassword);

        UserAccount userAccount = mapper.mapDTOtoUser(dto);

        assertNotNull(userAccount);
        assertEquals(email, userAccount.getEmail());
        assertEquals(encryptedPassword, userAccount.getPassword());
        assertEquals(userName, userAccount.getUserName());
        assertEquals(contact, userAccount.getContact());

        verify(passwordEncoder).encrypt(password);
    }






}
