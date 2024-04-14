package com.hh.hhinterface.controller;

import com.hh.hhapiclientsdk.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/get")
    public String  getWeather(@RequestBody Weather weather) {

        // 构建请求URL
        StringBuilder apiUrlBuilder = new StringBuilder("https://api.vvhan.com/api/weather");
        if (weather.getIp() != null) {
            apiUrlBuilder.append("?ip=").append(weather.getIp());
            if (weather.getType() != null) {
                apiUrlBuilder.append("&type=").append(weather.getType());
            }
        } else if (weather.getCity() != null) {
            apiUrlBuilder.append("?city=").append(weather.getCity());
            if (weather.getType() != null) {
                apiUrlBuilder.append("&type=").append(weather.getType());
            }
        } else if (weather.getType() != null) {
            apiUrlBuilder.append("?type=").append(weather.getType());
        }
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrlBuilder.toString(), String.class);
        String result = response.getBody();
        return result;
    }

}