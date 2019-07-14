package com.zipcodewilmington.videoproject.controllers;

import com.zipcodewilmington.videoproject.models.User;
import com.zipcodewilmington.videoproject.models.Video;
import com.zipcodewilmington.videoproject.services.UserService;
import com.zipcodewilmington.videoproject.services.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/videos")
public class VideoController {

    private static final Logger logger = LoggerFactory.getLogger(VideoController.class);
    private VideoService service;

    @Autowired
    public VideoController(VideoService service){
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Video>> index(){
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }


    @PostMapping("/uploadFile")
    public Video uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = service.storeVideo(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("videos/downloadFile/")
                .path(fileName)
                .toUriString();

        return new Video(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }


    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = service.loadFileAsResource(fileName);
        //Resource resource = UrlResource("file:$videoLocation/$name");

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }




}
