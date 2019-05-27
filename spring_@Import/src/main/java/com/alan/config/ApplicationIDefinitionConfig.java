package com.alan.config;

import com.alan.beans.MyImportBeanDefinitionRegistrar;
import com.alan.beans.MyImportSelecter;
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
 * 第一个加载Student
 * 第二个加载Teacher
 */
@Import(value = {MyImportSelecter.class, MyImportBeanDefinitionRegistrar.class})
@Configuration
public class ApplicationIDefinitionConfig {


        public static void main(String[] args) {

            //构造函数的参数千万不能忘记
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationIDefinitionConfig.class);

            System.out.println("spring 容器启动了......");

            String[] beanDefinitionNames = context.getBeanDefinitionNames();
            for (String beanDefinitionName : beanDefinitionNames) {
                System.out.println(beanDefinitionName);
            }

            Teacher liuhao = (Teacher)context.getBean("liuhao");
            liuhao.say();

            context.close();
            System.out.println("spring 容器关闭.......");
        }
}
