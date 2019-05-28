package com.alan.config;

import com.alan.service.MainService;
import org.springframework.context.annotation.*;

/**
 * @Author: liuhao
 * @Description:
 * @Date: Create in 11:07 AM 2019/5/27
 */

/**
 * 配置勒种添加开启AOP注解
 * @EnableAspectJAutoProxy 注解里面有import加载一个类 跟踪进去 是一个类 对spring初始化时候进行拦截 同事也是aware接口的子类
 * 在初始化时候得到 spring的资源   典型的一个富二代 和一个官二代的 后代
 * AbstractAutoProxyCreator.postProcessAfterInitialization()   AbstractAutoProxyCreator.wrapIfNecessary()方法中绑定代理关系
 */
@ComponentScan(value = "com.alan")
@Configuration
@EnableAspectJAutoProxy
public class ApplicationConfig {

    public static void main(String[] args) {

        //构造函数的参数千万不能忘记
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        System.out.println("spring 容器启动了......");

        MainService mainService = (MainService) context.getBean("mainService");

        mainService.doSomthing();

        context.close();
        System.out.println("spring 容器关闭.......");
    }
}
