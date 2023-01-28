package com.MiniProject.URLShortner.Service;

import com.MiniProject.URLShortner.Constants.URLResponseMessages;
import com.MiniProject.URLShortner.Entities.URL;
import com.MiniProject.URLShortner.Models.URLRequest;
import com.MiniProject.URLShortner.Models.URLStatsResponse;
import com.MiniProject.URLShortner.Repository.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import java.sql.Date;



import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class URLShortner implements IURLShortner {
    public static final int NUM_CHARS_SHORT_LINK = 5;
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private Random random = new Random();

    URLRepository urlRepository;

    public URLShortner(URLRepository urlRepository) {
        this.urlRepository = urlRepository;
    }



    @Override
    public String getShortenURL(URLRequest urlRequest) {
        if(!isValidURL(urlRequest.getRequest()))
            return null;
        else
            return generateRandomShortUrl(urlRequest);
    }



    @Override
    public boolean isValidURL(String request) {
        try {
            new java.net.URL(request).toURI();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<String> getAllShortUrl() {
        urlRepository.updateStatsAll();
        return urlRepository.getAllShortUrl();
    }

    @Override
    public String getCompleteURL(String shortURL) {
        urlRepository.updateStatsShortURL(shortURL);
        return urlRepository.getCompleteURL(shortURL);
    }

    @Override
    public List<URLStatsResponse> getAllStats() {
        List<URL> URLEntries=urlRepository.getAllStats();
         return URLEntries.stream().map(url -> new URLStatsResponse(url.getLongurl(),url.getShortenUrl(),url.getCount())).collect(Collectors.toList());
    }

    @Override
    public String generateRandomShortUrl(URLRequest urlRequest) {
        char[] result = new char[NUM_CHARS_SHORT_LINK];
        while (true) {
            for (int i = 0; i < NUM_CHARS_SHORT_LINK; i++) {
                int randomIndex = random.nextInt(ALPHABET.length() - 1);
                result[i] = ALPHABET.charAt(randomIndex);
            }
            String shortLink = new String(result);
            String shortcode= urlRepository.getShortLinkIfExists(shortLink);
            String longURL=urlRepository.getLongLinkIfExists(urlRequest.getRequest());
                if(shortcode == null && longURL==null ) {
                    urlRepository.save(new URL(1, urlRequest.getUser(), urlRequest.getRequest(), URLResponseMessages.TINY_URL_DOMAIN+shortLink,shortLink,Date.valueOf(LocalDate.now()) ));
                    return URLResponseMessages.TINY_URL_DOMAIN+shortLink;
                }
                if(longURL!=null && !longURL.isEmpty()){
                    String existingShortURL= urlRepository.getShortLinkIfLongUrlExists(urlRequest.getRequest());
                    urlRepository.updateStats(existingShortURL);
                    return  existingShortURL;
                }

        }
    }
}

