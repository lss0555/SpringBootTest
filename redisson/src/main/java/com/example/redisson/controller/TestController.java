package com.example.redisson.controller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description 测试
 * @Author lss0555
 * @Date 2019/1/2/002 11:06
 **/
@RestController
public class TestController {
    @Autowired
    private RedissonClient redissonClient;

    ExecutorService executorService= Executors.newFixedThreadPool(10);
    private static int num=100;

    @GetMapping("/lock")
    public String lockTest(){
        num=1000;
        for (int i=0;i<10;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    locks();
                }
            });
        }
        return "ok";
    }


    public void locks() {
        while (num>0){
            RLock rlock = redissonClient.getLock("lss_lock");
            //设置锁超时时间，防止异常造成死锁
            rlock.lock(20, TimeUnit.SECONDS);
            try{
                //执行业务逻辑
                if(num>0){
                    System.out.println("抢到第"+num--+"个");
                }
            } catch(Exception e){
            }finally{
                rlock.unlock();
            }
        }
    }

}
