package com.alan.beans;

/**
 * @Author: liuhao
 * @Description:
 * @Date: Create in 11:39 PM 2019/5/24
 */
public class Brid {

    private String type;

    private Organ organ;

    public Organ getOrgan() {
        return organ;
    }

    public void setOrgan(Organ organ) {
        this.organ = organ;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Brid() {
        System.out.println("brid constructor");
    }

    @Override
    public String toString() {
        return "地址"+getClass().getName() + "@" + Integer.toHexString(hashCode())+"Brid{" +
                "type='" + type + '\'' +
                ", organ=" + organ +
                '}';
    }
}
