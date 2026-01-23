package com.ecommerce.project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl extends FileService{

    @Override
    protected String uploadImage(String path, MultipartFile file) throws IOException {
        //Get the file name of current / original file
        String originalFilename = file.getOriginalFilename();

        //Generate a unique file name
        String randomId = UUID.randomUUID().toString();

        //mat.jpg -> 1234 -> 1234.jpg
        String fileName = randomId.concat(originalFilename.substring(originalFilename.lastIndexOf('.')));
        String filePath = path + File.separator + fileName;

        //Check if path exist and create
        File folder =  new File(path);
        if(!folder.exists()){
            folder.mkdirs();
        }

        //Upload a server
        Files.copy(file.getInputStream(), Paths.get(filePath));

        //Returning file name
        return fileName;
    }
}
