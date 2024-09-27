package com.sky.annotation;

import com.sky.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解类
 */
@Target(ElementType.METHOD) //只能作用于方法上
@Retention(RetentionPolicy.RUNTIME) //表明该注解的生命周期由,JVM 加载，包含在类文件中，在运行时可以被获取到
public @interface AutoFill {
    /**
     * OperationType 注解类型
     * value 标志参数
     * 注解类型元素是注解中内容，根据需要标志参数，例如上面的注解的value
     * @return
     */
    OperationType value();
}
