package com.alan.beans;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: liuhao
 * @Description:
 * @Date: Create in 8:26 PM 2019/5/27
 */
public class MyImportSelecter implements ImportSelector {

    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        String[] classNames ={"com.alan.beans.Student"};
        return classNames;
    }
}
