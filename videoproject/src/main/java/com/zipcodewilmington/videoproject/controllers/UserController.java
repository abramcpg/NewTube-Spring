package com.zipcodewilmington.videoproject.controllers;

import com.zipcodewilmington.videoproject.models.Comment;
import com.zipcodewilmington.videoproject.models.User;
import com.zipcodewilmington.videoproject.models.UserJson;
import com.zipcodewilmington.videoproject.services.CommentService;
import com.zipcodewilmington.videoproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {
    private UserService service;

    @Autowired
    public UserController(UserService service){
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{userId}")
    public UserJson getVideoComments(@PathVariable("userId") String userId) {
        return service.getUserJson(userId);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/users")
    public void postUserJson(@RequestBody UserJson userJson) {
        service.postUserJson(userJson);
    }


}
