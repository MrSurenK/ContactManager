package com.mrsurenk.contactmanager.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class ImageUploadService {


    public String uploadImage(MultipartFile image) throws IOException {
        //ToDo: Change to relative path before deploying(This path is only for local dev)
        String FOLDER_PATH = "/Users/suren/Projects/ContactManager/springboot_backend/contactmanager/src/main/resources/displaypics/";
        if (image == null || image.isEmpty()) {
            return FOLDER_PATH + "default_dp.png";
        } else {
            String filePath = FOLDER_PATH + image.getOriginalFilename();
            File destination = new File(filePath);
            image.transferTo(destination);
            return filePath;
        }
    }
}
