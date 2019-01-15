package com.example.testng.testNg.exception;

import org.testng.annotations.Test;

/**
 * @Description runtime异常
 * @Author lss0555
 * @Date 2018/12/21/021 16:06
 **/
public class TestRuntime {
    @Test(expectedExceptions = ArithmeticException.class)
    public void divisionWithException() {
        int a = 1 / 0;
        System.out.println("结果:"+ a);
    }
}
