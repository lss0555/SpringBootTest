package com.example.springbootTest.testNg.depend;

import org.testng.annotations.Test;

/**
 * @Description 依赖测试
 * @Author lss0555
 * @Date 2018/12/21/021 17:15
 **/
public class dependTest {
    @Test
    public void test1() {
        System.out.println("This is test1");
        throw new RuntimeException();
    }
    @Test(dependsOnMethods = { "test1" })
    public void test2() {
        System.out.println("This is test2");
    }
}
