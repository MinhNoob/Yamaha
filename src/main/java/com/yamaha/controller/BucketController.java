package com.yamaha.controller;

import com.yamaha.service.AmazonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/bucket/")
public class BucketController {

    @Autowired
    AmazonClient amazonClient;

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file, @RequestPart(value = "folder") String folderName) {
        return this.amazonClient.uploadFilewithFolder(file, folderName);
    }


//    @DeleteMapping("/deleteFile")
//    public String deleteFileInFolder(@RequestPart(value = "url") String fileUrl ,@RequestPart(value = "folder")String folderName) {
//        return this.amazonClient.deleteFileFromS3BucketInFolder(fileUrl,folderName);
//    }
    @DeleteMapping("/deleteFile")
    public String deleteFileInFolder(@RequestPart(value = "bucketName") String bucketName ,@RequestPart(value = "keyName")String keyName) {
        return this.amazonClient.deleteObjectFromBucket(bucketName,keyName);
    }



}
