package com.alan.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

/**
 * @Author: liuhao
 * @Description: 次要业务逻辑
 * @Date: Create in 2:04 PM 2019/5/28
 */
@Aspect
@Service
public class MinorService {


    @Pointcut("execution(public * com.alan.service..*(..)))")
    public  void pointCut(){

    }

    @Before(value ="pointCut()" )
    public void doSomethingBefore(){
        System.out.println("do something before");
    }

    @After(value = "pointCut()")
    public void doSomethingAfter(){
        System.out.println("do something afte ");
    }

}
