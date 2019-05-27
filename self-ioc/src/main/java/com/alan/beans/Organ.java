package com.alan.beans;

/**
 * @Author: liuhao
 * @Description:
 * @Date: Create in 7:22 AM 2019/5/25
 */
public class Organ {


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "地址"+getClass().getName() + "@" + Integer.toHexString(hashCode())+"Organ{" +
                "name='" + name + '\'' +
                '}';
    }

    public Organ() {
        System.out.println("I'm Organ ");
    }
}
