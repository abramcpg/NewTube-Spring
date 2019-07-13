package com.zipcodewilmington.videoproject.controllers;

import com.zipcodewilmington.videoproject.models.Comment;
import com.zipcodewilmington.videoproject.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/comments")
public class CommentController {


    private CommentService service;

    @Autowired
    public CommentController(CommentService service){
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Comment>> index(){
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

}


