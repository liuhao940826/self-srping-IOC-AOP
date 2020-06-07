package com.alan.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;

/**
 * @PACKAGE_NAME: com.alan.beans
 * @NAME: OrderBean
 * @USER: liuhao
 * @DATE: 2020-06-07 14:30
 * @WEEK: Sunday
 * @PROJECT_NAME: self-srping-post-order
 **/
public class OrderBean implements InitializingBean , BeanPostProcessor {


    /**
     * InitializingBean 接口中
     * @throws Exception
     */
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet..................");
    }

    /**
     * BeanPostProcessor
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("post Before..................");
        return bean;
    }
    /**
     * BeanPostProcessor
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("post After..................");
        return bean;
    }

    @PostConstruct
    public void postConstruct (){
        System.out.println("postConstruct..................");
    }

    public void initMethod(){
        System.out.println("init ..................");
    }

    public void destory(){
        System.out.println("destory ..................");
    }

    public OrderBean() {
        System.out.println("构造函数.................");
    }
}
