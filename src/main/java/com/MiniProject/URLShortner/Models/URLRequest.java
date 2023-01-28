package com.MiniProject.URLShortner.Models;

public class URLRequest {
    private String Request;
    private String User;

    public String getRequest() {
        return Request;
    }

    public void setRequest(String request) {
        Request = request;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public URLRequest(String request, String user) {
        Request = request;
        User = user;
    }
}
