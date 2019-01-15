package com.example.testng.testNg.group;

import org.testng.annotations.Test;

/**
 * @Description
 * @Author lss0555
 * @Date 2018/12/21/021 17:01
 **/
@Test(groups = "groups2")
public class TestGroup2 {

    public void test1() {
        System.out.println("TestGroup2==>test1");
    }

    public void test2() {
        System.out.println("TestGroup2==>test2");
    }

}
