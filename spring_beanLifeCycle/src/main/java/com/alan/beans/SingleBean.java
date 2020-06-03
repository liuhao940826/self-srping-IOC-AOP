package com.alan.beans;

import org.springframework.stereotype.Component;

/**
 * @PACKAGE_NAME: com.alan.beans
 * @NAME: SingleBean
 * @USER: liuhao
 * @DATE: 2020-06-03 17:58
 * @WEEK: Wednesday
 * @PROJECT_NAME: self-srping-IOC-AOP
 **/

@Component
public class SingleBean {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
