package com.example.redis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description redislock
 * @Date 2018/12/6/006 8:18
 **/
@RestController
public class RedisCacheController {
    private Logger logger = LoggerFactory.getLogger(RedisCacheController.class);
    ExecutorService executorService=Executors.newCachedThreadPool();

//    @Resource
//    UserDaoInter userDaoInter;
//
//    @GetMapping("/CacheLock")
//    public String redislockTest(int a){
//        long begin=System.currentTimeMillis();
//        if(a==0){
//            a=1;
//        }
//        for (int i=0;i<a;i++){
//            executorService.submit(new Runnable() {
//                @Override
//                public void run() {
//                    List<User> users = userDaoInter.userList();
//                }
//            });
//        }
//        long end=System.currentTimeMillis();
//        System.out.println("消耗时间:"+(end-begin));
//        return "";
//    }
}
