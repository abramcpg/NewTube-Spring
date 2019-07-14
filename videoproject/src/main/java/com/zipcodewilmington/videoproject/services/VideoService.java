package com.zipcodewilmington.videoproject.services;

import com.zipcodewilmington.videoproject.exceptions.NotFoundException;
import com.zipcodewilmington.videoproject.exceptions.StorageException;
import com.zipcodewilmington.videoproject.models.User;
import com.zipcodewilmington.videoproject.models.Video;
import com.zipcodewilmington.videoproject.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class VideoService {

    private VideoRepository repository;
    private final Path videoLocation;

//    @Autowired
//    public VideoService(VideoRepository repository) {
//        this.repository = repository;
//    }

    @Autowired
    public VideoService(StorageProperties StorageProperties, VideoRepository repository) {
        this.repository = repository;
        this.videoLocation = Paths.get(StorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.videoLocation);
        } catch (Exception ex) {
            throw new StorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }


    public Iterable<Video> index(){
        return repository.findAll();
    }


    public String storeVideo(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new StorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.videoLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new StorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.videoLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new NotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new NotFoundException("File not found " + fileName, ex);
        }
    }
}
