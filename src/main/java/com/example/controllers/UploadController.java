package com.example.controllers;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Part;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.multipart.CompletedFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

@Controller("/upload")
public class UploadController {

    private static final Logger LOG = LoggerFactory.getLogger(UploadController.class);

    @Get("/hello")
    public String sayHello(){
        return "Hello World! This is Sameer responding at " + new Date();
    }

    @Post(value = "/content", consumes = MediaType.MULTIPART_FORM_DATA,
            produces = MediaType.TEXT_PLAIN)
    public String uploadPackage(@Part("file") CompletedFileUpload file) throws Exception{
        long start = System.currentTimeMillis();
        LOG.info(new Date() + ". Request landed with file: " + file.getFilename());
        String returnMessage = new Date()+". File got uploaded successfully with size=" + file.getSize()+", name=" + file.getFilename();
        LOG.trace(returnMessage);
        return returnMessage;
    }
}
