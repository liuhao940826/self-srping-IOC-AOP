package com.alan.beans;

/**
 * @Author: liuhao
 * @Description:
 * @Date: Create in 11:39 PM 2019/5/24
 */
public class Brid {

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Brid() {
        System.out.println("brid的构造函数被调用");
    }
}
