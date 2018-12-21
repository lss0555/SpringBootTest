package com.example.springbootTest.testNg.depend.dependsOnGroups;

import org.testng.annotations.Test;

/**
 * @Description
 * @Author lss0555
 * @Date 2018/12/21/021 17:18
 **/
@Test(groups = "deploy")
public class TestServer {

    @Test
    public void deployServer() {
        System.out.println("Deploying Server...");
    }

    // Run this if deployServer() is passed.
    @Test(dependsOnMethods = "deployServer")
    public void deployBackUpServer() {
        System.out.println("Deploying Backup Server...");
    }

}
