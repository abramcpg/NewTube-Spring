package com.zipcodewilmington.videoproject.controllers;

import com.zipcodewilmington.videoproject.models.User;
import com.zipcodewilmington.videoproject.models.Video;
import com.zipcodewilmington.videoproject.services.UserService;
import com.zipcodewilmington.videoproject.services.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
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


    @PostMapping("uploadFile")
    public Video uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        //String fileName = service.storeVideo(file);
        Video video = service.storeVideo(file);
        String videoName = video.getVideoName();

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                //.path("videos/downloadFile/")
                .path("videos/")
                .path(String.valueOf(video.getVideoId()))
                .toUriString();
        video.setVideoPath(fileDownloadUri);
//        video = new Video(videoName, fileDownloadUri,
//                file.getContentType(), file.getSize(), file.getBytes());
        update(video.getVideoId(), video);
        return video;

//        return new Video(fileName, fileDownloadUri,
//                file.getContentType(), file.getSize());
    }

//    @PostMapping
//    public Video postVideo(@RequestParam("video") Video video){
//        return video;
//    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Video> create(@RequestBody Video video) {
        return new ResponseEntity<>(service.create(video), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Video> update(@PathVariable Long id, @RequestBody Video video) {
        return new ResponseEntity<>(service.update(id, video), HttpStatus.OK);
    }


//    @GetMapping("/videoStorage")
//        public ResponseEntity<Iterable<Video>> getPostedVideos(){
//            return new ResponseEntity<>(service.index(), HttpStatus.OK);
//        }

    @GetMapping("/videos/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long fileId) {
        // Load file from database
        Video dbFile = service.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getVideoType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getVideoName() + "\"")
                .body(new ByteArrayResource(dbFile.getVideoBytes()));
    }







//    @GetMapping("/downloadFile/{fileName:.+}")
//    public ResponseEntity<Resource> getFile(@PathVariable String fileName, HttpServletRequest request) {
//        // Load file as Resource
//        Resource resource = service.loadFileAsResource(fileName);
//        //Resource resource = UrlResource("file:$videoLocation/$name");
//
//        // Try to determine file's content type
//        String contentType = null;
//        try {
//            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
//        } catch (IOException ex) {
//            logger.info("Could not determine file type.");
//        }
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(contentType))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                .body(resource);
//    }




}
