package com.mrsurenk.contactmanager.controllers;

import com.mrsurenk.contactmanager.dto.AccountCreation;
import com.mrsurenk.contactmanager.dto.AccountCreationDTOMapper;
import com.mrsurenk.contactmanager.models.UserAccount;
import com.mrsurenk.contactmanager.repos.UserAccountRepo;
import com.mrsurenk.contactmanager.services.ImageUploadService;
import com.mrsurenk.contactmanager.services.SignUpService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AccountManagement.class)
@AutoConfigureMockMvc
//@SpringBootTest(classes = ContactmanagerApplication.class, exclude = SecurityConfig.class)
public class AccountManagementTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ImageUploadService imageUploadService;

    @MockBean
    private SignUpService signUpService;

    @MockBean
    private UserAccountRepo userAccountRepo;

    @MockBean
    private AccountCreationDTOMapper mapper;

    @Test
    void shouldCreateNewUser() throws Exception {
        MockMultipartFile file = new MockMultipartFile("imageFile", "test.jpg", MediaType.IMAGE_JPEG_VALUE, "test image content".getBytes());
        AccountCreation accountCreation = new AccountCreation("test@example.com", "password", "username", "+6581234567");
        UserAccount userAccount = UserAccount.builder().build();

        when(mapper.mapDTOtoUser(any(AccountCreation.class))).thenReturn(userAccount);
        when(imageUploadService.uploadImage(file)).thenReturn("imageDir");

        mockMvc.perform(multipart("/signup")
                        .file(file)
                        .param("email", accountCreation.email())
                        .param("password", accountCreation.password())
                        .param("userName", accountCreation.userName())
                        .param("contact", accountCreation.contact())
                        .contentType(MediaType.MULTIPART_FORM_DATA)
                )
                        .andExpect(status().isOk());
    }

    @Test
    void shouldHandleDuplicateEmailException() throws Exception {
        MockMultipartFile file = new MockMultipartFile("imageFile", "filename.txt", "text/plain", "some xml".getBytes());

        // Mock the behavior to throw an IllegalStateException when checkIfAccountExists is called
        doThrow(new IllegalStateException("Email already in use.")).when(signUpService).checkIfAccountExists(any(AccountCreation.class));

        mockMvc.perform(multipart("/signup")
                .file(file)
                .param("email", "test@example.com")
                .param("password", "password")
                .param("userName", "username")
                .param("contact", "1234567890")
                .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(status().isConflict())
                .andExpect(content().string("Email already in use."));
    }
}
