package com.yupi.project.model.enums;

/**
 * @author 黄昊
 * @version 1.0
 **/

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 接口状态枚举
 *
 */
public enum  InterfaceInfoStatusEnum {
    OFFLINE("关闭",0),
    ONLINE("上线",1);

    private final String text;
    private final int value;

    InterfaceInfoStatusEnum(String text, int value) {
        this.text = text;
        this.value = value;
    }
    public static List<Integer> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }
    public String getText() {
        return text;
    }

    public int getValue() {
        return value;
    }
}
