package com.example.multisource.dynamic;
import java.lang.annotation.*;

/**
 * @Description: 在方法上使用，用于指定使用哪个数据源
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String name();
}