package com.mrsurenk.contactmanager.dto;

import com.mrsurenk.contactmanager.services.PasswordEncoder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class AccountCreationDTOMapperTest {

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AccountCreationDTOMapper mapper;

    //Test to see if userAccount is mapped to DTO
    public void testValidFieldsMaptoDTO(){
       String email = "test@email.com";
       String password="strongpassword";
       String userName="John";
       String contact="+6581234567";

      AccountCreation dto = mapper.mapFieldsToDTO(email, password, userName, contact);

      assertNotNull(dto);
      assertEquals(email, dto.email());
      assertEquals(password, dto.password());
      assertEquals(userName, dto.userName());
      assertEquals(contact, dto.contact());

    }



}
