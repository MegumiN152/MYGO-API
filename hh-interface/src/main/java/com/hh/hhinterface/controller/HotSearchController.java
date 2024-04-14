package com.hh.hhinterface.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hostlist")
public class HotSearchController {

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/all")
    public  String getHostSearch(){
        String apiUrl = "https://api.vvhan.com/api/hotlist/bili";
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        String result = response.getBody();
        return result;
    }
}