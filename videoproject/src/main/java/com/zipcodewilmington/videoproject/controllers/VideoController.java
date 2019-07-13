package com.zipcodewilmington.videoproject.controllers;

import com.zipcodewilmington.videoproject.models.User;
import com.zipcodewilmington.videoproject.models.Video;
import com.zipcodewilmington.videoproject.services.UserService;
import com.zipcodewilmington.videoproject.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/videos")
public class VideoController {

    private VideoService service;

    @Autowired
    public VideoController(VideoService service){
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Video>> index(){
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

}
