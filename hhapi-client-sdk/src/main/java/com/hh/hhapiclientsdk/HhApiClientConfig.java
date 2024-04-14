package com.hh.hhapiclientsdk;

import com.hh.hhapiclientsdk.client.HhApiClient;
import com.hh.hhapiclientsdk.model.User;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 黄昊
 * @version 1.0
 **/
@Configuration
@ConfigurationProperties(prefix = "hhapi.client")
@Data
@ComponentScan
public class HhApiClientConfig {
    private String accessKey;
    private String secretKey;
    @Bean
    public HhApiClient hhApiClient(){
     return new HhApiClient(accessKey,secretKey);
    }
}
