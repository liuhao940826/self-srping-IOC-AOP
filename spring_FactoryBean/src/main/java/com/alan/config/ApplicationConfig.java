package com.alan.config;

import com.alan.beans.MyFactoryBean;
import com.alan.beans.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

@Configuration
public class ApplicationConfig {
    /**
     * 注意FactoryBean 在使用的时候才会被创建 不是在容器创建的时候
     *
     * @return
     */
    @Bean
    public MyFactoryBean factoryBean() {
        return new MyFactoryBean();
    }

    public static void main(String[] args) {

        //构造函数的参数千万不能忘记
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        System.out.println("spring 容器启动了......");


        Student student = (Student) context.getBean("factoryBean");

        System.out.println(student);

        context.close();
        System.out.println("spring 容器关闭.......");
    }
}
