package com.hh.hhinterface.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/img")
public class ImgController {

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/boyAvatar")
    public  String getManavatar(){
        String apiUrl = "https://api.vvhan.com/api/avatar/boy?type=json";
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        String result = response.getBody();
        return result;
    }
    @GetMapping("/girlAvatar")
    public  String getGirlAvatar(){
        String apiUrl = "https://api.vvhan.com/api/avatar/girl?type=json";
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        String result = response.getBody();
        return result;
    }

}