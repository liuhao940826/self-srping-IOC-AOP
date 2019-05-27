package com.alan.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author: liuhao
 * @Description: 只要实现这个接口就可以
 * @Date: Create in 9:54 PM 2019/5/27
 */
@Component
public class Brid implements ApplicationContextAware {

    private int age;

    private ApplicationContext applicationContext;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 重写
     * @param applicationContext
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    @Override
    public String toString() {
        return "Brid{" +
                "age=" + age +
                ", applicationContext=" + applicationContext +
                '}';
    }
}
