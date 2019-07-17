package com.zipcodewilmington.videoproject.services;

import com.zipcodewilmington.videoproject.models.Comment;
import com.zipcodewilmington.videoproject.models.User;
import com.zipcodewilmington.videoproject.models.UserJson;
import com.zipcodewilmington.videoproject.repositories.CommentRepository;
import com.zipcodewilmington.videoproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;


    public UserJson getUserJson(String userId){

        User user = repository.findById(userId).get();
        UserJson userJson = new UserJson();
        userJson.setUserId(user.getUserId());
        userJson.setFirstName(user.getFirstName());
        userJson.setLastName(user.getLastName());
        return userJson;
    }
    public void postUserJson(UserJson userJson) {
        User user = new User();
        user.setUserId(userJson.getUserId());
        user.setFirstName(userJson.getFirstName());
        user.setLastName(userJson.getLastName());
        repository.save(user);
    }


}
