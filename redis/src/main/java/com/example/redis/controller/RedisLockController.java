package com.example.redis.controller;

import com.example.redis.rocks.RedisLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description redislock
 * @Author lss0555
 * @Date 2018/12/6/006 8:18
 **/
@RestController
public class RedisLockController {
    private Logger logger = LoggerFactory.getLogger(RedisLockController.class);
    ExecutorService executorService= Executors.newFixedThreadPool(10);
    @Resource
    RedisLock lock;
    private static int num=1000;

    @GetMapping("/lock")
    public String redislockTest(){
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

    private void locks() {
        while (num>0){
            lock.lock();
            try {
                if(num>0){
                    logger.info("抢到第"+num--+"个");
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
