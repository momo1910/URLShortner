package com.MiniProject.URLShortner.Models;

public class URLStatsResponse {
    private String longURL;
    private String shortURL;
    int count;

    public String getLongURL() {
        return longURL;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public URLStatsResponse(String longURL, String shortURL, int count) {
        this.longURL = longURL;
        this.shortURL = shortURL;
        this.count = count;
    }
}
