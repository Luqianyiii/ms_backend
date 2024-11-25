package com.MusicShare.Model;

public class MusicList {
    private int musicListId;
    private int userId;
    private int musicId;
    private String createdAt;

    // Getter and Setter methods
    public int getMusicListId() {
        return musicListId;
    }

    public void setMusicListId(int musicListId) {
        this.musicListId = musicListId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}

