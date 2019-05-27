package com.alan.beans;

import org.springframework.stereotype.Component;

/**
 * @Author: liuhao
 * @Description:
 * @Date: Create in 9:54 PM 2019/5/27
 */
@Component
public class Brid {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Brid{" +
                "age=" + age +
                '}';
    }
}
