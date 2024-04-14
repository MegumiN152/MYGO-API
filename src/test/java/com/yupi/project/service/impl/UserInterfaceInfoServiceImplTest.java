package com.yupi.project.service.impl;

import com.yupi.project.service.UserInterfaceInfoService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 黄昊
 * @version 1.0
 **/
@SpringBootTest
class UserInterfaceInfoServiceImplTest {
    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;
    @Test
    public void invokecount(){
        boolean b=userInterfaceInfoService.invokeCount(1L,1L);
        Assertions.assertTrue(b);
    }
}