package com.willbest.keepfit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/files")
public class FileDealController {
    @RequestMapping("/uploadpic")
    public  String uploadPic(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        String originalFilename = file.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        String eFileName = UUID.randomUUID()+substring;
        String path ="E:/kitpic/";
        File uploadFile = new File(path+eFileName);
        try{
            file.transferTo(uploadFile);
        }catch (IOException e){
            e.printStackTrace();
        }
        return eFileName;
    }
}
