package com.example.springbootTest.testNg.kit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * @Description 单测试类2
 * @Author lss0555
 * @Date 2018/12/20/020 17:05
 **/
public class DBConfig {
    //对于套件测试，在此套件中的所有测试运行之前运行。
    @BeforeSuite()
    public void beforeSuite() {
        System.out.println("@BeforeSuite");
    }

    // 对于套件测试，在此套件中的所有测试运行之后运行
    @AfterSuite()
    public void afterSuite() {
        System.out.println("@AfterSuite");
    }

    //对于套件测试，在运行属于<test>标签内的类的任何测试方法之前运行
    @BeforeTest()
    public void beforeTest() {
        System.out.println("@BeforeTest");
    }

    //对于套件测试，在运行属于<test>标签内的类的所有测试方法都已运行之后运行。
    @AfterTest()
    public void afterTest() {
        System.out.println("@AfterTest");
    }
}
