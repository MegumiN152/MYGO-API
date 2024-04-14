package com.yupi.project.service.suanfa;

import lombok.Data;

/**
 * @author 黄昊
 * @version 1.0
 **/
@Data
public class Student {
    private String name;
    private Double sorce;
    Student(String name,Double sorce){
       this.name=name;
       this.sorce=sorce;
    }
    Student(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSorce() {
        return sorce;
    }

    public void setSorce(Double sorce) {
        this.sorce = sorce;
    }
}
