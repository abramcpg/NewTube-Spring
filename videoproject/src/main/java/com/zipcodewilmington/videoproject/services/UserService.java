package com.zipcodewilmington.videoproject.services;

import com.zipcodewilmington.videoproject.models.Comment;
import com.zipcodewilmington.videoproject.models.User;
import com.zipcodewilmington.videoproject.repositories.CommentRepository;
import com.zipcodewilmington.videoproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Iterable<User> index(){
        return repository.findAll();
    }


}
