package com.hh.hhinterface.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 黄昊
 * @version 1.0
 **/
@RestController
@RequestMapping("/world")
public class WorldController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/60s")
    public  String getWorld(){
        String apiUrl = "https://api.vvhan.com/api/60s";
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        String result = response.getBody();
        return result;
    }
}
