package com.alan.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: liuhao
 * @Description:
 * @Date: Create in 8:07 PM 2019/5/27
 */
@Component
public class Student {

    @Value("alan")
    private String name;

    @Value("#{29-2}")
    private int age;

    @Value("${student.home}")
    private String home;

    public Student() {
        System.out.println("I'm student");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", home='" + home + '\'' +
                '}';
    }
}
