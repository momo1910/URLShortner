package com.MiniProject.URLShortner.Controller;

import com.MiniProject.URLShortner.Constants.URLResponseMessages;
import com.MiniProject.URLShortner.Models.URLRequest;
import com.MiniProject.URLShortner.Models.URLResponse;
import com.MiniProject.URLShortner.Models.URLStatsResponse;
import com.MiniProject.URLShortner.Service.URLShortner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class URLShortnerController {


    @Autowired
    URLShortner urlShortner ;

    @PostMapping("/ShortenUrl")
    public URLResponse getShortenURL(@RequestBody URLRequest urlRequest){
        String shortenURL =urlShortner.getShortenURL(urlRequest);
        if(shortenURL!=null)
        return new URLResponse(urlRequest.getRequest(),shortenURL,urlRequest.getUser(), URLResponseMessages.TINY_URL);
        else return new URLResponse(urlRequest.getRequest(),"",urlRequest.getUser(),URLResponseMessages.INVALID_URL);
    }

    @GetMapping("/allShorterUrl")
    public List<String> getAllShortUrl(){
        return urlShortner.getAllShortUrl();
    }

    @PostMapping("/completeURL")
    public URLResponse getCompleteURL(@RequestBody URLRequest urlRequest){
        String longUrl=urlShortner.getCompleteURL(urlRequest.getRequest());
        if(longUrl==null)
            return new URLResponse(urlRequest.getRequest(),"",urlRequest.getUser(),URLResponseMessages.LONG_URL_UNSCUESSFULL);
        else
            return new URLResponse(urlRequest.getRequest(),longUrl,urlRequest.getUser(),URLResponseMessages.LONG_URL);
    }


    @GetMapping("/getURLStats")
    public List<URLStatsResponse> getAllStats(){
        return urlShortner.getAllStats();
    }



}
