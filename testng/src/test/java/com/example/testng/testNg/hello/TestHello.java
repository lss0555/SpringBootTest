package com.example.testng.testNg.hello;

import com.example.testng.testNg.BaseTestNg;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * @Description test hello
 * @Author lss0555
 * @Date 2018/12/20/020 14:51
 **/
public class TestHello extends BaseTestNg {
//    @Resource
//    HelloController helloController;

    @Test()
    public void testEmailGenerator() {
//        String result = helloController.hello();
        String result = "123";

        Assert.assertNotNull(result,"okok");
        Assert.assertEquals(result, "hello world","ok");

    }

    @Test
    public void test(){
        System.out.println("hello world");
    }

}
