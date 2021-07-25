package com.alan.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;

/**
 * @Author: liuhao
 * @Description: BeanPostProcessor   针对所有的bean
 * @Date: Create in 9:49 PM 2019/5/27
 */

public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * bean初始化之前调用 在AbstractAutowireCapableBeanFactory 中被调用
     * @param bean bean是spring 管理的一个对象
     * @param beanName 就是对应的关键字
     * @return
     * @throws BeansException
     */
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        try {
            if (bean instanceof Brid) {
                Field age = bean.getClass().getDeclaredField("age");
                age.setAccessible(true);
                age.set(bean, 9);
            }
            System.out.println("前置被执行了");
        }catch (Exception e){
            e.printStackTrace();
        }

        return bean;
    }


    /**
     * bean初始化之后调用
     * @param bean bean是spring 管理的一个对象
     * @param beanName 就是对应的关键字
     * @return
     * @throws BeansException
     */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("后置被执行了");
        return bean;
    }
}
