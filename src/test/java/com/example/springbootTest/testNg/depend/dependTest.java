package com.example.springbootTest.testNg.depend;

import org.testng.annotations.Test;

/**
 * @Description 依赖测试
 * @Author lss0555
 * @Date 2018/12/21/021 17:15
 **/
public class dependTest {
    @Test
    public void method1() {
        System.out.println("This is method 1");
    }

    @Test(dependsOnMethods = { "method1" })
    public void method2() {
        System.out.println("This is method 2");
    }
}
