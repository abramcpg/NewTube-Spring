package com.zipcodewilmington.videoproject.services;

import com.zipcodewilmington.videoproject.models.Comment;
import com.zipcodewilmington.videoproject.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private CommentRepository repository;

    @Autowired
    public CommentService(CommentRepository repository) {
        this.repository = repository;
    }

    public Iterable<Comment> index(){
        return repository.findAll();
    }

}
