package com.alan.config;

import com.alan.beans.Dog;
import com.alan.beans.MyBeanPostProcessor;
import org.springframework.context.annotation.*;

/**
 * @Author: liuhao
 * @Description:
 * @Date: Create in 11:07 AM 2019/5/27
 */

/**
 * 排除注解类型的注解交给spring管理
 * 排除controller和Service
 * filterType 有五种点进去看
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

        Dog dog = (Dog) context.getBean("dog");
        System.out.println(dog);
        context.close();
        System.out.println("spring 容器关闭.......");
    }
}
