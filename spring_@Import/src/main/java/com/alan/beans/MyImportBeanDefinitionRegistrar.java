package com.alan.beans;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: liuhao
 * @Description:  bean对象注册器
 * @Date: Create in 8:31 PM 2019/5/27
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param annotationMetadata
     * @param registry  注册器需要去注册需要管理的实例类
     */
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {

        //1.获得一个对象定义管理器 将java类注册到spring中
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Teacher.class);

        //2.创建当前java类的实例对象
        BeanDefinition obj = builder.getBeanDefinition();
        //3.通过spring的bean注册器  将当前java类添加到spring容器中  第一个参数是名字 ,第二个参数这个类的实例对象

        registry.registerBeanDefinition("liuhao",obj);


    }
}
