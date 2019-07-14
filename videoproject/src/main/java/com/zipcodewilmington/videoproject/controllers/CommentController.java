package com.zipcodewilmington.videoproject.controllers;

import com.zipcodewilmington.videoproject.models.Comment;
import com.zipcodewilmington.videoproject.models.Video;
import com.zipcodewilmington.videoproject.models.VideoComments;
import com.zipcodewilmington.videoproject.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.GET, value = "/videos/{videoId}/comments")
    public VideoComments getVideoComments(@PathVariable("videoId") int videoId) {
        return commentService.getVideoComments(videoId);
    }

}


