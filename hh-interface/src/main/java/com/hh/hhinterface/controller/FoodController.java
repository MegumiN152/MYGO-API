package com.hh.hhinterface.controller;

import com.hh.hhapiclientsdk.model.Food;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.hh.hhinterface.constant.EatWhat.*;

@RestController
@RequestMapping("/food")
public class FoodController {
    @PostMapping("/taste")
    public String foodTaste(@RequestBody Food food) {
        Random random = new Random();

        if (food.getCuisine()==null){
            food.setCuisine(CUISINES[random.nextInt(CUISINES.length)]);
        }
        if (food.getFoodtime()==null){
            food.setFoodtime(FOODTIMES[random.nextInt(FOODTIMES.length)]);
        }
        List<String> foods = null;
        try {
            Map<String, List<String>> cuisines = EAT_WHAT.get(food.getCuisine());
            foods = cuisines.get(food.getFoodtime());
            if (foods==null){
                return "输入有误,请输入菜系如(lucai)和餐点如(lunch)";
            }
        } catch (Exception e) {
            return "输入有误,请输入菜系如(lucai)和餐点如(lunch)";
        }
        return foods.get(random.nextInt(foods.size()));

    }

}