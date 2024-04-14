package com.hh.hhinterface;

import com.hh.hhapiclientsdk.client.HhApiClient;
import com.hh.hhapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class HhInterfaceApplicationTests {
    @Resource
    private HhApiClient hhApiClient;

    @Test
    void contextLoads() {
        String hh = hhApiClient.getNameByGet("hh");
        User user = new User();
        user.setUsername("huanghai");
        String userNameByPost = hhApiClient.getUserNameByPost(user);
        System.out.println(hh);
        System.out.println(userNameByPost);
    }

}
