package com.alan.config;

import com.alan.beans.Linux;
import com.alan.beans.Mac;
import com.alan.beans.Windows;
import com.alan.conditions.LinuxConditions;
import com.alan.conditions.MacConditions;
import com.alan.conditions.WindowsConditions;
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

@Configuration
public class ApplicationConfig{

        @Conditional(value = {LinuxConditions.class})
        @Bean
        public Linux linux() {
            return new Linux();

        }
        @Conditional(value = {WindowsConditions.class})
        @Bean
        public Windows windows() {
            return new Windows();
        }

    /**
     * 默认单例容器启动时候加载
     * @return
     */
        @Conditional(value = {MacConditions.class})
        @Bean
        public Mac mac() {
            return new Mac();
        }

        public static void main(String[] args) {

            //构造函数的参数千万不能忘记
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

            String[] beanDefinitionNames = context.getBeanDefinitionNames();
            for (String beanDefinitionName : beanDefinitionNames) {

                System.out.println(beanDefinitionName);
            }

        }
}
