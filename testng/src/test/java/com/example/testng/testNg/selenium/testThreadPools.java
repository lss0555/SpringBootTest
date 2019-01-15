package com.example.testng.testNg.selenium;

import org.testng.annotations.Test;

/**
 * @Description 线程池测试
 * @Author lss0555
 * @Date 2018/12/28/028 9:44
 **/
public class testThreadPools {
    @Test(invocationCount = 10, threadPoolSize = 2)
    public void testThreadPools() {
        System.out.println("当前线程:"+Thread.currentThread().getName());
    }
}
