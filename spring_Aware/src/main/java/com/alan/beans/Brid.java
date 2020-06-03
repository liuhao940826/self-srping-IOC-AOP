package com.alan.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @Author: liuhao
 * @Description: 只要实现这个接口就可以 并且这个类被BeanPostProcessor拦截的
 *               ApplicationContextAware  实现了这个接口可以获得spring初始化的容器
 *               BeanNameAware 可以获得beanName
 *               EmbeddedValueResolverAware 可以获得解析器
 *               上面3个都属于Aware接口 实现了Aware接口可以获取spring的更多资源
 *
 * @Date: Create in 9:54 PM 2019/5/27
 */
@Component
public class Brid implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {

    private int age;
    /**
     * 可以赋值spring 内部的值
     */
    private ApplicationContext applicationContext;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 重写  applicationContextAwareProcessor中被调用
     * @param applicationContext
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    /**
     * 获取在spring容器中的关键词
     * @param s
     */
    public void setBeanName(String s) {
        System.out.println("brid beanName:"+s);
    }

    /**
     * 在没有@value的情况下 可以解析对应的spel表达式 字符串解析器例如不需要用@Value +表达式去获取值
     * @param stringValueResolver
     */
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {

        String value = stringValueResolver.resolveStringValue("我是${teacher.name} , 我今年#{2019-1994}");

        System.out.println(value);
    }

    @Override
    public String toString() {
        return "Brid{" +
                "age=" + age +
                ", applicationContext=" + applicationContext +
                '}';
    }
}
