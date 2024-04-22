package com.example.journalapp;

import com.google.firebase.Timestamp;

public class Journal {
    public String title;
    public  String Thoughts , ImgUrl , UserId , UserName;
    public Timestamp TimeAdded;

    public Journal() {
    }

    public Journal(String title, String thoughts, String imgUrl, String userId, String userName, Timestamp timeAdded) {
        this.title = title;
        Thoughts = thoughts;
        ImgUrl = imgUrl;
        UserId = userId;
        UserName = userName;
        TimeAdded = timeAdded;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThoughts() {
        return Thoughts;
    }

    public void setThoughts(String thoughts) {
        Thoughts = thoughts;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public Timestamp getTimeAdded() {
        return TimeAdded;
    }

    public void setTimeAdded(Timestamp timeAdded) {
        TimeAdded = timeAdded;
    }
}
