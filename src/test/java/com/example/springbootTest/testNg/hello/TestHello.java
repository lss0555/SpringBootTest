package com.example.springbootTest.testNg.hello;

import com.example.springbootTest.testNg.BaseTestNg;
import com.example.springbootTest.testNg.HelloController;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * @Description test hello
 * @Author lss0555
 * @Date 2018/12/20/020 14:51
 **/
public class TestHello extends BaseTestNg {
    @Resource
    HelloController helloController;

    @Test()
    public void testEmailGenerator() {
        String result = helloController.hello();

        Assert.assertNotNull(result,"okok");
        Assert.assertEquals(result, "hello world","ok");

    }

}
