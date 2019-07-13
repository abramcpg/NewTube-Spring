package com.zipcodewilmington.videoproject.services;

import com.zipcodewilmington.videoproject.models.User;
import com.zipcodewilmington.videoproject.models.Video;
import com.zipcodewilmington.videoproject.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    private VideoRepository repository;

    @Autowired
    public VideoService(VideoRepository repository) {
        this.repository = repository;
    }

    public Iterable<Video> index(){
        return repository.findAll();
    }

}
