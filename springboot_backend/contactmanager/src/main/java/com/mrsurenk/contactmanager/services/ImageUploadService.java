package com.mrsurenk.contactmanager.services;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@Log
public class ImageUploadService {


    public String uploadImage(MultipartFile image) throws IOException {
        //ToDo: Change to relative path before deploying(This path is only for local dev)
        String FOLDER_PATH = "/Users/suren/Projects/ContactManager/springboot_backend/contactmanager/src/main/resources/displaypics/";
        if (image == null || image.isEmpty()) {
//            log.info("Default image only");
            return FOLDER_PATH + "default_dp.png";
        } else {
//            log.info("Getting the uploaded image");
            String filePath = FOLDER_PATH + image.getOriginalFilename();
            File destination = new File(filePath);
            image.transferTo(destination);
            return filePath;
        }
    }
}

// Image uploads do not work! 