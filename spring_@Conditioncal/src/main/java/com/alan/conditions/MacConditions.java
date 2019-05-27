package com.alan.conditions;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author: liuhao
 * @Description:
 * @Date: Create in 11:50 AM 2019/5/27
 */
public class MacConditions implements Condition {
    /**
     * 如果返回   true 成功能注册
     *          false 失败不能注册
     * @param conditionContext  上下文环境
     * @param annotatedTypeMetadata  注解类型元数据
     * @return
     */
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        String property = conditionContext.getEnvironment().getProperty("os.name");
        System.out.println(property);

        if(property.contains("Mac")){
            return true;
        }
        return false;
    }
}
