package com.alan.beans;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: liuhao
 * @Description: 导入选择器 返回类的名字
 * @Date: Create in 8:26 PM 2019/5/27
 */
public class MyImportSelecter implements ImportSelector {

    /**
     *
     * @param annotationMetadata 指的是import在使用的时候修饰的类的信息 ApplicationImPortSelectorConfig
     * @return
     */
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        String[] classNames ={"com.alan.beans.Student"};
        return classNames;
    }
}
