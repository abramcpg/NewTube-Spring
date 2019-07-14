package com.zipcodewilmington.videoproject.models;


import javax.persistence.*;

@Entity
@Table(name = "video", schema = "group4")
public class Video {

    @Id
    private int videoId;
    private String videoName;
    private byte[] video;
    private int userId;

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

    public byte[] getVideo() {
        return video;
    }

    public void setVideo(byte[] video) {
        this.video = video;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
