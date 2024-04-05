package com.mrsurenk.contactmanager.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ImageUploadServiceTest {
    private final ImageUploadService imageUploadService = new ImageUploadService();

    @Mock
    private MultipartFile mockImg;

    //Test image upload service
    @Test
    void whenUploadImage_thenVerifyFilePath() throws IOException {
        String originalFileName = "testImage.jpg";
        String expectedFilePath = "/Users/suren/Projects/ContactManager/springboot_backend/contactmanager/src/main/resources/displaypics/testImage.jpg";

        when(mockImg.isEmpty()).thenReturn(false);
        when(mockImg.getOriginalFilename()).thenReturn(originalFileName);
        //Don't want to actually add anything in the filesystem during test
        doNothing().when(mockImg).transferTo(any(File.class));

        String resultPath = imageUploadService.uploadImage(mockImg);

        //Check that transfer to is only called once (mockito library)
        verify(mockImg, times(1)).transferTo(any(File.class));
        assertEquals(expectedFilePath, resultPath);
    }


    //Test if default image returned by image upload service
    @Test
    void whenNoImageUploaded()throws IOException {
        String expectedFilePath = "/Users/suren/Projects/ContactManager/springboot_backend/contactmanager/src/main/resources/displaypics/default_dp.png";

        when(mockImg.isEmpty()).thenReturn(true);

        String resultPath = imageUploadService.uploadImage(mockImg);

        verify(mockImg, never()).transferTo(any(File.class));
        assertEquals(expectedFilePath, resultPath);
    }
}
