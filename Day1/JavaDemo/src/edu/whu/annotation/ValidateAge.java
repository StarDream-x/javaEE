package edu.whu.annotation;

import java.lang.annotation.*;

/**
 * 年龄校验的注解
 * @author jia
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Inherited
public @interface ValidateAge {
    /**
     * 最小值
     */
    int min() default 18;
    /**
     * 最大值
     */
    int max() default 99;
}
