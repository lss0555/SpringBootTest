package com.example.springbootTest.testNg.timeout;

import org.testng.annotations.Test;

import java.util.Date;

/**
 * @Description 超时测试
 * @Author lss0555
 * @Date 2018/12/21/021 16:47
 **/
public class TestTimeout {

    /**
     * @Description  “超时”表示如果单元测试花费的时间超过指定的毫秒数，
     * 那么TestNG将会中止它并将其标记为失败。“超时”也可用于性能测试，以确保方法在合理的时间内返回。
     **/
    
    /**
     * @Description  超时设置
     **/
    @Test(timeOut = 5000) // time in mulliseconds
    public void testThisShouldPass() throws InterruptedException {
        System.out.println("当前时间:"+new Date());
        Thread.sleep(4000);
        System.out.println("超时4秒收执行,时间:"+new Date());
    }

    /**
     * @Description  超时设置
     **/
    @Test(timeOut = 5000) // time in mulliseconds
    public void testThisPass() throws InterruptedException {
        System.out.println("当前时间:"+new Date());
        Thread.sleep(5000);
        System.out.println("超时4秒收执行,时间:"+new Date());
    }

    @Test(timeOut = 1000)
    public void testThisShouldFail() {
        while (true){
            // do nothing
            System.out.println("哈哈哈..."+System.currentTimeMillis());
        }
    }

}
