package com.example.testng.testNg.auto;

import com.example.testng.Controller.TestController;
import com.example.testng.testNg.BaseTestNg;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @Description user
 * @Author lss0555
 * @Date 2018/12/20/020 16:10
 **/
public class TestUserNg extends BaseTestNg {
    @Autowired
    TestController helloController;


    @Test(dataProvider = "num")
    public void testUser(int a){
//        System.out.println("结果:"+helloController.hello(a));

    }
    @DataProvider(name = "num")
    public Object[][] provideData() {
        return new Object[][] { { 1}, { 2}, { 4} };
    }
}
