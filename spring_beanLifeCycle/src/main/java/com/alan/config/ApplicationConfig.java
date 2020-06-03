package com.alan.config;

import com.alan.beans.PrototypeBean;
import com.alan.beans.SingleBean;
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

        //获取单例bean
        SingleBean single = context.getBean(SingleBean.class);

        SingleBean single2 = context.getBean(SingleBean.class);
        //打印单例的地址
        System.out.println(single);
        System.out.println(single2);

        PrototypeBean prototypeBean1 = context.getBean(PrototypeBean.class);

        PrototypeBean prototypeBean2 = context.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1);
        System.out.println(prototypeBean2);


        //spring 容器关闭的时候关闭了对单例的管理权 但是不一定销毁对象
        //spring 容器不会去管理多例对象 每次用会新建 并且丢弃
        context.close();
        System.out.println("spring 容器关闭.......");

    }
}
