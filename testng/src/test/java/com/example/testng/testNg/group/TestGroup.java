package com.example.testng.testNg.group;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * @Description 测试分组
 * @Author lss0555
 * @Date 2018/12/21/021 16:58
 **/
public class TestGroup {
    @BeforeGroups("groups1")
    public void setupDB() {
        System.out.println("setupDB()");
    }
    @AfterGroups("groups2")
    public void cleanDB() {
        System.out.println("cleanDB()");
    }
    @Test(groups = "groups1")
    public void runSelenium() {
        System.out.println("groups1()");
    }
    @Test(groups = "groups2")
    public void testConnectMsSQL() {
        System.out.println("groups2");
    }
    @Test(dependsOnGroups = { "groups1", "groups2" })
    public void runFinal() {
        System.out.println("runFinal");
    }
}
