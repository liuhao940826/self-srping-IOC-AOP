package com.alan.beans;

/**
 * @Author: liuhao
 * @Description:
 * @Date: Create in 12:13 AM 2019/5/25
 */
public class Animal {

    private Brid brid;

    public Brid getBrid() {
        return brid;
    }

    public void setBrid(Brid brid) {
        this.brid = brid;
    }

    @Override
    public String toString() {
        return "地址"+getClass().getName() + "@" + Integer.toHexString(hashCode())+"Animal{" +
                "brid=" + brid +
                '}';
    }
}
