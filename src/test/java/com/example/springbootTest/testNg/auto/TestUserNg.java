package com.example.springbootTest.testNg.auto;

import com.example.springbootTest.model.TResult;
import com.example.springbootTest.testNg.BaseTestNg;
import com.example.springbootTest.testNg.TestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * @Description user
 * @Author lss0555
 * @Date 2018/12/20/020 16:10
 **/
public class TestUserNg extends BaseTestNg {
    @Autowired
    TestController testController;

    @Test
    public void testUser(){
        TResult list = testController.getPatientList();

        System.out.println("结果:"+list.toString());
    }
}
