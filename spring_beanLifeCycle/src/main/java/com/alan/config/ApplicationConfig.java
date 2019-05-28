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

    /**
     * 单例bean  在spring 容器启动时候 由spring负责创建 会先去向容器获取没有创建
     *          在spring容器运行期间,单例Bean只会被创建一次
     *          在spring 容器关闭的时候 会抛弃bean对象的管理权, 然后无主对象会被回收
     * @param args
     */
    public static void main(String[] args) {

        //构造函数的参数千万不能忘记
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        System.out.println("spring 容器启动了......");
        Brid brid = context.getBean(Brid.class);
        System.out.println(brid);
        context.close();
        System.out.println("spring 容器关闭.......");
        System.out.println(brid);
    }
}
