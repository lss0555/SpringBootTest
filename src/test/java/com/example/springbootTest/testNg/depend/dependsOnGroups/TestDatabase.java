package com.example.springbootTest.testNg.depend.dependsOnGroups;

import org.testng.annotations.Test;

/**
 * @Description
 * @Author lss0555
 * @Date 2018/12/21/021 17:18
 **/
public class TestDatabase {
    //belong to "db" group,
    //Run if all methods from "deploy" group are passed.
    @Test(groups="db", dependsOnGroups="deploy")
    public void initDB() {
        System.out.println("This is initDB()");
    }

    //belong to "db" group,
    //Run if "initDB" method is passed.
    @Test(dependsOnMethods = { "initDB" }, groups="db")
    public void testConnection() {
        System.out.println("This is testConnection()");
    }
}
