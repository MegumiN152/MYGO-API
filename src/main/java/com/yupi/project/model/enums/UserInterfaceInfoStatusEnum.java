package com.yupi.project.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 黄昊
 * @version 1.0
 **/
public enum UserInterfaceInfoStatusEnum {
    NORMAL("正常",0),
    BUSY("禁用",1);

    private final String text;
    private final int value;

    UserInterfaceInfoStatusEnum(String text, int value) {
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
