package com.zipcodewilmington.videoproject.models;


import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "videos", schema = "group4")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long videoId;
    private String videoName;
    private String videoPath;
    private String userId;
    private String videoType;
    private Long videoSize;
    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] videoBytes;

    public Video(String videoName, String videoPath, String videoType, Long videoSize) {
        this.videoName = videoName;
        this.videoPath = videoPath;
        this.videoType = videoType;
        this.videoSize = videoSize;
        //setVideoPath("http://localhost:8080/videos/" + this.videoId);
    }

    public Video(String videoName, String videoPath, String videoType, Long videoSize, byte[] videoBytes) {
        this.videoName = videoName;
        this.videoPath = videoPath;
        this.videoType = videoType;
        this.videoSize = videoSize;
        this.videoBytes = videoBytes;
        //setVideoPath("http://localhost:8080/videos/" + this.videoId);
    }

    public Video() {}


    public long getVideoId() {
        return videoId;
    }

    public void setVideoId(long videoId) {
        this.videoId = videoId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }
//
//    public byte[] getVideoBytes() {
//        return videoBytes;
//    }
//
//    public void setVideoBytes(byte[] videoBytes) {
//        this.videoBytes = videoBytes;
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

    public byte[] getVideoBytes() {
        return videoBytes;
    }

    public void setVideoBytes(byte[] videoBytes) {
        this.videoBytes = videoBytes;
    }
}
