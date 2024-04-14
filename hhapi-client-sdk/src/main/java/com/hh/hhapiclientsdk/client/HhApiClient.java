package com.hh.hhapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.hh.hhapiclientsdk.model.Food;
import com.hh.hhapiclientsdk.model.Ip;
import com.hh.hhapiclientsdk.model.User;
import com.hh.hhapiclientsdk.model.Weather;
import com.hh.hhapiclientsdk.utils.SignUtils;


import java.util.HashMap;
import java.util.Map;

/**
 * @author 黄昊
 * @version 1.0
 * 调用第三方接口客户端
 **/
public class HhApiClient {
    private static final String GATEWAY_HOST="http://localhost:8090";
    private String accesskey;
    private String secretkey;

    public HhApiClient(String accesskey, String secretkey) {
        this.accesskey = accesskey;
        this.secretkey = secretkey;
    }


    public String getNameByGet( String name){
        HashMap<String,Object> parammap=new HashMap<>();
        parammap.put("name",name);
       return HttpUtil.get(GATEWAY_HOST+"/api/name/",parammap);
    }
    private Map<String,String> getHeaderMap(String body){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey",accesskey);
//        hashMap.put("secretkey","ab");
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body",body);
        hashMap.put("timestamp",String.valueOf(System.currentTimeMillis()/1000));
        hashMap.put("sign", SignUtils.genSign(body,secretkey));
        return hashMap;
    }
    public String getUserNameByPost( User user){
        String json= JSONUtil.toJsonStr(user);
        HttpResponse execute = HttpRequest.post(GATEWAY_HOST+"/api/name/user/")
                .addHeaders(getHeaderMap(json)).body(json).execute();
        System.out.println(execute.getStatus());
        String result=execute.body();
        System.out.println(result);
        return result;
    }
    public String getNameByPost(String name){

        HashMap<String,Object> parammap=new HashMap<>();
        parammap.put("name",name);
        return HttpUtil.post(GATEWAY_HOST+"/api/name/",parammap);
    }
    public  String getChickenSoup(){
        HttpResponse execute = HttpRequest.get(GATEWAY_HOST + "/api/txt/chickSoup/")
                .addHeaders(getHeaderMap("")).body("").execute();
        System.out.println(execute.getStatus());
        String result = execute.body();
        System.out.println(result);
        return result;
    }
    public  String getJoke(){
        HttpResponse execute = HttpRequest.get(GATEWAY_HOST + "/api/txt/joke/")
                .addHeaders(getHeaderMap("")).body("").execute();
        System.out.println(execute.getStatus());
        String result = execute.body();
        System.out.println(result);
        return result;
    }

    public String getFood(Food food)  {
        String json = JSONUtil.toJsonStr(food);
        HttpResponse execute = HttpRequest.post(GATEWAY_HOST + "/api/food/taste/")
                .addHeaders(getHeaderMap(json)).body(json).execute();
        System.out.println(execute.getStatus());
        String result = execute.body();
        System.out.println(result);
        return result;
    }
    public String getWeather(Weather weather)  {
        String json = JSONUtil.toJsonStr(weather);
        HttpResponse execute = HttpRequest.post(GATEWAY_HOST + "/api/weather/get/")
                .addHeaders(getHeaderMap(json)).body(json).execute();
        System.out.println(execute.getStatus());
        String result = execute.body();
        System.out.println(result);
        return result;
    }
    public String getIp(Ip ip)  {
        String json = JSONUtil.toJsonStr(ip);
        HttpResponse execute = HttpRequest.post(GATEWAY_HOST + "/api/ip/get/")
                .addHeaders(getHeaderMap(json)).body(json).execute();
        System.out.println(execute.getStatus());
        String result = execute.body();
        System.out.println(result);
        return result;
    }
    public String  getBoyAvatar()  {
        HttpResponse execute = HttpRequest.get(GATEWAY_HOST + "/api/img/boyAvatar/")
                .addHeaders(getHeaderMap("")).body("").execute();
        System.out.println(execute.getStatus());
        String result = execute.body();
        return  result;
    }
    public String  getGirlAvatar()  {
        HttpResponse execute = HttpRequest.get(GATEWAY_HOST + "/api/img/girlAvatar/")
                .addHeaders(getHeaderMap("")).body("").execute();
        System.out.println(execute.getStatus());
        String result = execute.body();
        return  result;
    }
    public String  getHostSearch()  {
        HttpResponse execute = HttpRequest.get(GATEWAY_HOST + "/api/hostlist/all/")
                .addHeaders(getHeaderMap("")).body("").execute();
        System.out.println(execute.getStatus());
        String result = execute.body();
        return  result;
    }
    public String  getWorld()  {
        HttpResponse execute = HttpRequest.get(GATEWAY_HOST + "/api/world/60s/")
                .addHeaders(getHeaderMap("")).body("").execute();
        System.out.println(execute.getStatus());
        String result = execute.body();
        return  result;
    }

}
