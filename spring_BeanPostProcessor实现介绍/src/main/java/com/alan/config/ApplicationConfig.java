package com.alan.config;

import com.alan.beans.Brid;
import com.alan.beans.MyBeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: liuhao
 * @Description:
 * @Date: Create in 11:07 AM 2019/5/27
 */

/**
 * 获取spring的的属性
 */
@ComponentScan(value = "com.alan.beans")
@Configuration
public class ApplicationConfig {

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }

    public static void main(String[] args) {

        //构造函数的参数千万不能忘记
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        System.out.println("spring 容器启动了......");

        Brid brid = (Brid) context.getBean("brid");
        System.out.println(brid);
        context.close();
        System.out.println("spring 容器关闭.......");
    }
}
