package com.alan.config;

import com.alan.custom.MyFilterType;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @Author: liuhao
 * @Description:
 * @Date: Create in 11:07 AM 2019/5/27
 */

/**
 * 排除注解类型的注解交给spring管理
 * 排除controller和Service
 * filterType 有五种点进去看
 *              ANNOTATION 根据注解
 *              ASSIGNABLE_TYPE 指定的类
 *              ASPECTJ 根据表达式过滤
 *              REGEX   根据正则过滤
 *              CUSTOM  根据开发人员自己的规则规律
 *
 *              自定义鬼贼类 根据myfilterTyoe去过滤注册bean
 *
 *
 */
@ComponentScan(value = "com.alan.beans",useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM,
           classes = {MyFilterType.class})
})
@Configuration
public class ApplicationCustomConfig {

    public static void main(String[] args) {

        //构造函数的参数千万不能忘记
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationCustomConfig.class);

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {

            System.out.println(beanDefinitionName);
        }

    }
}
