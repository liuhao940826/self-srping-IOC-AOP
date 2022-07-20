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
 * @PropertySource 获取spring的的属性 代替context:property-placeholder
 * 作用:第一个加载指定的property文件,将读取到的key/value 去替换spring上下文中的属性占位符${xxx}
 * 实例化 > aware > beforePostProcesserBeforeInitialization >postConstruct> InitializingBean的afterPropertiesSet
 *       > init> afterPostProcesserBeforeInitialization
 */
@PropertySource("classpath:/config.properties")
//@ComponentScan(value = "com.alan.beans")
@Configuration
public class ApplicationConfig {

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }

    @Bean(initMethod = "initMethod",destroyMethod = "destory")
    public Brid bridName1() {
        return new Brid();
    }

    public static void main(String[] args) {

        //构造函数的参数千万不能忘记
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        System.out.println("spring 容器启动了......");

        context.close();
        System.out.println("spring 容器关闭.......");
    }
}
