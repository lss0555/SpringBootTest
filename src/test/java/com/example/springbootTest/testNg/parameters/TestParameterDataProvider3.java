package com.example.springbootTest.testNg.parameters;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @Description 方法此示例显示如何根据测试方法名称传递不同的参数
 * @Author lss0555
 * @Date 2018/12/28/028 9:36
 **/
public class TestParameterDataProvider3 {
    @Test(dataProvider = "dataProvider")
    public void test1(int number, int expected) {
        Assert.assertEquals(number, expected);
        System.out.println("test1结果:"+expected);
    }

    @Test(dataProvider = "dataProvider")
    public void test2(String email, String expected) {
        Assert.assertEquals(email, expected);
        System.out.println("test2结果:"+expected);
    }

    @DataProvider(name = "dataProvider")
    public Object[][] provideData(Method method) {

        Object[][] result = null;

        if (method.getName().equals("test1")) {
            result = new Object[][] {
                    { 1, 1 }, { 2, 2 }
            };
        } else if (method.getName().equals("test2")) {
            result = new Object[][] {
                    { "sxkj.com", "sxkj.com" },
                    { "lss0555.com", "lss0555.com" }
            };
        }

        return result;

    }

}