package com.zipcodewilmington.videoproject.controllers;

import com.zipcodewilmington.videoproject.models.Comment;
import com.zipcodewilmington.videoproject.models.UserComment;
import com.zipcodewilmington.videoproject.models.VideoComments;
import com.zipcodewilmington.videoproject.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

//    @CrossOrigin
//    @RequestMapping(method = RequestMethod.GET, value = "/videos/{videoId}/comments")
//    public VideoComments getVideoComments(@PathVariable("videoId") int videoId) {
//        return commentService.getVideoComments(videoId);
//    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/videos/{videoId}/comments")
    public void postVideoComment(@RequestBody UserComment userComment, @PathVariable("videoId") int videoId) {
        commentService.postVideoComments(videoId, userComment);
    }

    @GetMapping(value = "/videos/{videoId}/comments")
    public ResponseEntity<Iterable<Comment>> getCommentsByVideoId(@PathVariable("videoId") int videoId){
      return new ResponseEntity<>(commentService.getCommentsByVideoId(videoId), HttpStatus.OK);
    }



}


