package com.example.springbootTest.testNg.selenium;

import org.testng.annotations.Test;

/**
 * @Description 负载测试
 * @Author lss0555
 * @Date 2018/12/28/028 9:43
 **/
public class TestRepeatThis {
    //确定TestNG应该运行这个测试方法的次数
    @Test(invocationCount = 3)
    public void test() {
        System.out.println("hello world " );
    }
}
