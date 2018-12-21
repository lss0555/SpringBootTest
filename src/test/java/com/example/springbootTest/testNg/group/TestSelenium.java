package com.example.springbootTest.testNg.group;

import org.testng.annotations.Test;

/**
 * @Description
 * @Author lss0555
 * @Date 2018/12/21/021 17:01
 **/
@Test(groups = "selenium-test")
public class TestSelenium {

    public void runSelenium() {
        System.out.println("runSelenium()");
    }

    public void runSelenium1() {
        System.out.println("runSelenium()1");
    }

}
