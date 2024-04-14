package com.hh.hhinterface.controller;

import com.hh.hhapiclientsdk.model.Ip;
import com.hh.hhapiclientsdk.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author 黄昊
 * @version 1.0
 **/
@RestController
@RequestMapping("/ip")
public class IPController {
    @Autowired
    private RestTemplate restTemplate;
    @PostMapping("/get")
    public String getIp(@RequestBody Ip ip) {
        StringBuilder apiUrlBuilder = new StringBuilder("https://api.vvhan.com/api/ipInfo");
        if (ip != null) {
            apiUrlBuilder.append("?ip=").append(ip.getIpName());
        }
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrlBuilder.toString(), String.class);
        String result = response.getBody();
        return result;
    }
}
