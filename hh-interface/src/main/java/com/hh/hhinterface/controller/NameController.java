package com.hh.hhinterface.controller;

import com.hh.hhapiclientsdk.model.User;
import com.hh.hhapiclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 名称api
 * @author 黄昊
 * @version 1.0
 **/
@RestController
@RequestMapping("/name")
public class NameController {
    @GetMapping("/get")
    public String getNameByGet(String name,HttpServletRequest request){
        System.out.println(request.getHeader("yupi"));
        return "GET 你的名字是"+name;
    }
    @PostMapping("/user")
    public String getUserNameByPost(@RequestBody User user, HttpServletRequest request){
//        String accessKey = request.getHeader("accessKey");
//        String body = request.getHeader("body");
//        String nonce = request.getHeader("nonce");
//        String timestamp = request.getHeader("timestamp");
//        String sign = request.getHeader("sign");
//
//        if (Long.parseLong(nonce)>10000){
//            throw new RuntimeException("无权限");
//        }
//        if (!accessKey.equals("huanghao")){
//            throw new RuntimeException("签名错误，无权限");
//        }
//        //时间和当前时间不超过 5分钟
//        if (Math.abs(Long.parseLong(timestamp)-new Date().getTime()/1000)>300){
//            throw new RuntimeException("shijian无权限");
//        }
//        String serverSign= SignUtils.genSign(body,"java");
//        if (!sign.equals(serverSign)){
//            throw new RuntimeException("无权限");
//        }

        return "POST REST 你的名字是"+user.getUsername();
    }
    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name){
        return "POST 你的名字是"+name;
    }
}
