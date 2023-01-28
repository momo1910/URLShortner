package com.MiniProject.URLShortner.Service;

import com.MiniProject.URLShortner.Models.URLRequest;
import com.MiniProject.URLShortner.Models.URLStatsResponse;

import java.util.List;

public interface IURLShortner {

    public String getShortenURL(URLRequest URLRequest);
    public String generateRandomShortUrl(URLRequest urlRequest);
    public boolean isValidURL(String request);
    public List<String> getAllShortUrl();
    public String getCompleteURL(String shortURL);

    public List<URLStatsResponse> getAllStats();
}
