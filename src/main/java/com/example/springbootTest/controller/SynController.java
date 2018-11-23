package com.example.springbootTest.controller;

import com.example.springbootTest.common.annotation.Log;
import com.example.springbootTest.model.TResult;
import com.example.springbootTest.model.User;
import com.example.springbootTest.service.inter.DeferredResultServiceInter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.Resource;
import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * @Description 异步接口
 * @Author lss0555
 * @Date 2018/11/23/023 10:49
 **/
@RestController
public class SynController {
    private Logger logger = LoggerFactory.getLogger(SynController.class);
    @Resource
    DeferredResultServiceInter deferredResultServiceInter;

    ExecutorService executors= Executors.newCachedThreadPool();

    @GetMapping("/login")
    @Log
    public TResult<User> login() {
        TResult login = deferredResultServiceInter.login();
        return login;
    }

    @GetMapping("/login1")
    @Log
    public Callable<TResult<User>> login1() {
        Callable<TResult<User>> result = (() -> {
            return deferredResultServiceInter.login();
        });
        return result;
    }

    @GetMapping("/login2")
    @Log
    public DeferredResult<TResult<User>> login2() {
        DeferredResult<TResult<User>> deferredResult = new DeferredResult<>(5000L, "---请求超时---");
        executors.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("=====异步线程开始===="+System.currentTimeMillis());
                deferredResultServiceInter.login1(deferredResult);
                System.out.println("=====异步线程结束===="+System.currentTimeMillis());
            }
        });
        return deferredResult;
    }
}
