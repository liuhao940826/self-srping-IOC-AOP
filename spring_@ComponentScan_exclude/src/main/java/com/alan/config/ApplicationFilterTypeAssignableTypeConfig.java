package com.alan.config;

import com.alan.beans.TestDao;
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
 * 默认的过滤条件为false
 * 只加载controller和service
 * 加载Dao
 */
@ComponentScan(value = "com.alan.beans",useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
                                                value = {Controller.class, Service.class}),
                          @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
                                    value = {TestDao.class})
}
)
@Configuration
public class ApplicationFilterTypeAssignableTypeConfig {

    public static void main(String[] args) {

        //构造函数的参数千万不能忘记
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationFilterTypeAssignableTypeConfig.class);

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {

            System.out.println(beanDefinitionName);
        }

    }
}
