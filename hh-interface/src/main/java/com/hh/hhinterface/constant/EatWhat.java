package com.hh.hhinterface.constant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EatWhat {
    public static Map<String, Map<String, List<String>>> EAT_WHAT = new HashMap<>();
    public  static final String []  CUISINES= {"lucai","chuancai","yuecai","sucai","xiangcai","mincai","zhecai","huicai"};
    public  static final String []   FOODTIMES= {"breakfast","lunch","dinner"};

    static {
        // 添加地点-食物数据
        Map<String, List<String>> lucai = new HashMap<>();
        Map<String, List<String>> chuancai = new HashMap<>();
        Map<String, List<String>> yuecai = new HashMap<>();
        Map<String, List<String>> sucai = new HashMap<>();
        Map<String, List<String>> xiangcai = new HashMap<>();
        Map<String, List<String>> mincai = new HashMap<>();
        Map<String, List<String>> zhecai = new HashMap<>();
        Map<String, List<String>> huicai = new HashMap<>();

//鲁菜
        lucai.put("breakfast", Arrays.asList("豆腐脑", "蔬菜煎饼", "灌汤包", "酱牛肉面", "老北京炸酱面", "豆浆油条"));
        lucai.put("lunch", Arrays.asList("红烧肉", "煎炸大虾", "花雕醉鸡", "红烧排骨", "爆炒猪肝", "鱼香茄子"));
        lucai.put("dinner", Arrays.asList("红烧鲤鱼", "三鲜豆腐", "烤全羊", "梅菜扣肉", "葱烧海参", "西红柿炒鸡蛋"));

//川菜
        chuancai.put("breakfast", Arrays.asList("酸辣粉", "辣油饼", "香菇炖鸡蛋", "香辣牛肉面", "粉蒸肉", "豆浆油条"));
        chuancai.put("lunch", Arrays.asList("鱼香肉丝", "口水鸡", "宫保鸡丁", "麻辣香锅", "干煸四季豆", "川味酸菜鱼"));
        chuancai.put("dinner", Arrays.asList("水煮鱼", "回锅肉", "麻辣火锅", "干锅牛蛙", "麻婆豆腐", "酸辣土豆丝"));

//粤菜
        yuecai.put("breakfast", Arrays.asList("油条", "茶叶蛋", "云吞面", "鲜虾云吞", "花卷", "肠粉"));
        yuecai.put("lunch", Arrays.asList("烧鹅", "白切鸡", "清蒸鲈鱼", "蚝油牛肉", "百花豆腐", "酸辣鸡片"));
        yuecai.put("dinner", Arrays.asList("糖醋排骨", "清蒸石斑鱼", "虾饺", "龙虾炒面", "芙蓉蟹", "虾仁蒸蛋"));

//苏菜
        sucai.put("breakfast", Arrays.asList("香菇油面筋", "鲜肉小笼包", "蟹黄汤包", "花卷", "葱油饼", "豆浆油条"));
        sucai.put("lunch", Arrays.asList("东坡肉", "松鼠桂鱼", "白斩鸡", "红烧肉", "糖醋排骨", "虎皮尖椒"));
        sucai.put("dinner", Arrays.asList("松鼠鳜鱼", "红烧鲈鱼", "笋尖炒肉", "红烧排骨", "醋溜白菜心", "素炒时蔬"));

//湘菜
        xiangcai.put("breakfast", Arrays.asList("辣椒炒肉", "炸臭豆腐", "蒸米粉", "酸豆角炒肉", "豆皮", "红薯粉皮"));
        xiangcai.put("lunch", Arrays.asList("毛氏红烧肉", "椒麻鸭", "干锅牛蛙", "湘味小炒肉", "麻辣香锅", "酸辣土豆丝"));
        xiangcai.put("dinner", Arrays.asList("酸菜鱼", "毛血旺", "辣椒炒蛏子", "湘西口味鸡", "藕片炖肉", "小炒肉"));

//闽菜
        mincai.put("breakfast", Arrays.asList("肉松面包", "福州丝瓜汤", "干面条", "葱油饼", "鸡蛋烧饼", "红薯粥"));
        mincai.put("lunch", Arrays.asList("佛跳墙", "红烧鲈鱼", "蛏子酱蒸豆腐", "福州鱼丸汤", "闽南鸭", "海蛎煎"));
        mincai.put("dinner", Arrays.asList("红烧肉", "东坡肉", "闽北米粉", "蟹黄豆腐", "闽南三杯鸡", "金桔鸡"));

//浙菜
        zhecai.put("breakfast", Arrays.asList("糯米藕饼", "油面筋", "蟹黄汤包", "灌汤包", "豆浆油条", "鸡蛋灌饼"));
        zhecai.put("lunch", Arrays.asList("龙井虾仁", "西湖醋鱼", "虾饺", "红烧肉", "干炒牛河", "东坡肉"));
        zhecai.put("dinner", Arrays.asList("虾龙井茶", "绍兴酒鸭", "三丝炒鲜竹笋", "东坡鲜肉包", "醉蟹", "清蒸海鲈鱼"));

//徽菜
        huicai.put("breakfast", Arrays.asList("老坛酸菜面", "鲜肉月饼", "五谷杂粮粥", "葱油饼", "酱鸭粉丝汤", "鲜肉蒸饺"));
        huicai.put("lunch", Arrays.asList("徽州排骨", "毛豆炒腊肉", "笋干焖肉", "老虎菜炖土鸡", "清蒸野鸡", "卤菜拼盘"));
        huicai.put("dinner", Arrays.asList("笋尖炒肉", "红烧狮子头", "笋干炖鸡", "安徽酱鱼", "黄山炖鸡", "徽州腊味拼盘"));

        // 添加到总的数据集合
        EAT_WHAT.put("lucai",lucai);
        EAT_WHAT.put("chuancai", chuancai);
        EAT_WHAT.put("yuecai", yuecai);
        EAT_WHAT.put("sucai", sucai);
        EAT_WHAT.put("xiangcai", xiangcai);
        EAT_WHAT.put("mincai", mincai);
        EAT_WHAT.put("zhecai", zhecai);
        EAT_WHAT.put("huicai", huicai);
    }
}