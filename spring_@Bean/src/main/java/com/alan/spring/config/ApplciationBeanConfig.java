package com.alan.spring.config;

import com.alan.beans.Student;
import com.alan.beans.Teacher;
import com.alan.beans.TheClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @Author: liuhao
 * @Description:
 * @Date: Create in 10:28 AM 2019/5/27
 */
@Configuration
public class ApplciationBeanConfig {

    /**
     * bean的名字是对应的方法名 默认为单例
     * @return
     */
    @Bean
    public Student hi(){
        return  new Student();
    }

    /**
     * 指定关键词 是stu1
     * @return
     */
    @Bean(value = {"s1"})
    public TheClass theClass(){
        return  new TheClass();
    }

    /**
     * 这个注解专用于单例的bean 此时bean不会再spring容器被加载的时候创建在被使用的时候创建
     * @return
     */
    @Lazy
    @Bean
    public Teacher teacher(){
        return  new Teacher();
    }

    public static void main(String[] args) {
        //每次选择 标注数字的一段代码释放查看效果
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplciationBeanConfig.class);

        //1 获取注解上下文中所有定义的bean名字
        String[] beanDefinitionNames = context.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            //输出bean的名字
            System.out.println(beanDefinitionName);
        }
//


        System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>>>>defalut single test");
        //2 默认单例
        Object stu1 = context.getBean("s1");
        Object stu2 = context.getBean("s1");
        System.out.println(stu1);
        System.out.println(stu2);

        //3
        System.out.println("=>>>>>>>>>>>>>>>>>>>>>>> context loading"  );



        System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>bean used");
        //4 单例被索要时候创建
//        Object organ = context.getBean("teacher");

    }
}
