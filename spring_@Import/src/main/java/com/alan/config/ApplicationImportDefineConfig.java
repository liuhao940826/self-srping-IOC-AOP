package com.alan.config;

import com.alan.beans.Student;
import com.alan.beans.Teacher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

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
public class ApplicationImportDefineConfig {


        public static void main(String[] args) {

            //构造函数的参数千万不能忘记
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationImportDefineConfig.class);

            System.out.println("spring 容器启动了......");

            String[] beanDefinitionNames = context.getBeanDefinitionNames();
            for (String beanDefinitionName : beanDefinitionNames) {
                System.out.println(beanDefinitionName);
            }

            context.close();
            System.out.println("spring 容器关闭.......");
        }
}
