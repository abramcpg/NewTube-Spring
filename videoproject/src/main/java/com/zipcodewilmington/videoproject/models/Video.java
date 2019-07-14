package com.zipcodewilmington.videoproject.models;


import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "videos", schema = "group4")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int videoId;
    private String videoName;
    //private byte[] video;
    private String videoPath;
    private String userId;
    private String videoType;
    private Long videoSize;

    public Video(String videoName, String videoPath, String videoType, Long videoSize) {
        this.videoName = videoName;
        this.videoPath = videoPath;
        this.videoType = videoType;
        this.videoSize = videoSize;
    }

    public Video() {
        this.videoName = "bleh";
        this.videoPath = "bsdfgf";
        this.videoType = "/mp4";
    }

//    public Video(MultipartFile file) {
//        this.videoName = StringUtils.cleanPath(file.getOriginalFilename());
//        this.videoPath = videoPath;
//        this.videoType = videoType;
//        this.videoSize = videoSize;
//    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }
//
//    public byte[] getVideo() {
//        return video;
//    }
//
//    public void setVideo(byte[] video) {
//        this.video = video;
//    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public Long getVideoSize() {
        return videoSize;
    }

    public void setVideoSize(Long videoSize) {
        this.videoSize = videoSize;
    }

//    public byte[] getVideo() {
//        return video;
//    }
//
//    public void setVideo(byte[] video) {
//        this.video = video;
//    }
}
