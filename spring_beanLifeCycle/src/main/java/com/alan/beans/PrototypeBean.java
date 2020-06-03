package com.alan.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @PACKAGE_NAME: com.alan.beans
 * @NAME: PrototypeBean
 * @USER: liuhao
 * @DATE: 2020-06-03 18:02
 * @WEEK: Wednesday
 * @PROJECT_NAME: self-srping-IOC-AOP
 **/
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeBean {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
