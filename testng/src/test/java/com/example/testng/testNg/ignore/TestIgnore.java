package com.example.testng.testNg.ignore;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Description 忽略测试
 * @Author lss0555
 * @Date 2018/12/21/021 16:42
 **/
public class TestIgnore {
    /**
     *有时，我们编写的代码并没有准备就绪，并且测试用例要测试该方法/代码是否失败(或成功)。
     * 在本示例中，注释@Test(enabled = false)有助于禁用此测试用例。
     * 如果使用@Test(enabled = false)注释在测试方法上，则会绕过这个未准备好测试的测试用例。
     * 在本教程中，我们将演示如何使用@Test(enabled = false)来忽略测试方法。
     **/


    @Test // default enable=true
    public void test1() {
        System.out.println("test1");
        Assert.assertEquals(true, true);
    }

    @Test(enabled = true)
    public void test2() {
        System.out.println("test2");
        Assert.assertEquals(true, true);
    }

    @Test(enabled = false)
    public void test3() {
        System.out.println("test3");
        Assert.assertEquals(true, true);
    }
}
