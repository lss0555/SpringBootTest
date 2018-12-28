package com.example.springbootTest.testNg.depend.dependsOnGroups;

import org.testng.annotations.Test;

/**
 * @Description
 * @Author lss0555
 * @Date 2018/12/21/021 17:18
 **/
public class Test2 {
    @Test(groups="test2_method1")
    public void method1() {
        System.out.println("Test2==>This is method 1");
    }

    @Test(dependsOnMethods = { "method1" })
    public void method2() {
        System.out.println("Test2==>This is method 2");
    }
}
