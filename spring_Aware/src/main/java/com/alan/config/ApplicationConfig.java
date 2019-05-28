package com.alan.config;

import com.alan.beans.Brid;
import com.alan.beans.MyBeanPostProcessor;
import org.springframework.context.annotation.*;

/**
 * @Author: liuhao
 * @Description:
 * @Date: Create in 11:07 AM 2019/5/27
 */

/**
 * 获取spring的的属性
 */
@PropertySource("classpath:/config.properties")
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

        context.close();
        System.out.println("spring 容器关闭.......");
    }
}
