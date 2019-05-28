package com.alan.beans;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: liuhao
 * @Description:
 * @Date: Create in 8:07 PM 2019/5/27
 */
//这样可以交给spring扫描生效 也可以在config中注册成bean
//@Component
public class MyFactoryBean implements FactoryBean<Student> {

    /**
     * 通知spring 容器 当前学生类的实例对象的创建方式
     * @return
     * @throws Exception
     */
    public Student getObject() throws Exception {
        return new Student();
    }

    /**
     * 通知spring 容器 被管理的bean对象在spring容器对应的类型
     * @return
     */
    public Class<?> getObjectType() {
        return Student.class;
    }

    /**
     * 告诉spring 是否是单例 默认是单例  true 是单例 false是多例
     * @return
     */
    public boolean isSingleton() {
        return true;
    }
}
