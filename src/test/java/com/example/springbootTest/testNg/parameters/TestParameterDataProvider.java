package com.example.springbootTest.testNg.parameters;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @Description 参数测试
 * @Author lss0555
 * @Date 2018/12/21/021 17:29
 **/
public class TestParameterDataProvider {
    @Test(dataProvider = "provideNumbers")
    public void test(int number, int expected) {
        Assert.assertEquals(number + 10, expected);
        System.out.println("结果:"+(number+expected));
    }

    @DataProvider(name = "provideNumbers")
    public Object[][] provideData() {

        return new Object[][] { { 10, 20 }, { 100, 110 }, { 200, 210 } };
    }
}
