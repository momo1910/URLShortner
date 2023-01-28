package com.MiniProject.URLShortner.Models;

public class

URLResponse {
    private String longURL;
    private String shortURL;
    private String User;
    private String message;

    public String getLongURL() {
        return longURL;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setLongURL(String longURL) {
        this.longURL = longURL;
    }

    public String getShortURL() {
        return shortURL;
    }

    public void setShortURL(String shortURL) {
        this.shortURL = shortURL;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public URLResponse(String longURL, String shortURL, String user, String message) {
        this.longURL = longURL;
        this.shortURL = shortURL;
        User = user;
        this.message=message;
       ;
    }
}
