package com.hh.hhinterface.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

import static com.hh.hhinterface.constant.ChickenSuop.CHICKEN_SOUP;

@RestController
@RequestMapping("/txt")
public class TxtController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/chickSoup")
    public  String getChickenSoup(){
        Random random = new Random();
        int index = random.nextInt(CHICKEN_SOUP.size());
        return CHICKEN_SOUP.get(index);
    }
    @GetMapping("/joke")
    public  String getJoke(){
        String apiUrl = "https://api.vvhan.com/api/text/joke";
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        String result = response.getBody();
        return result;
    }
}