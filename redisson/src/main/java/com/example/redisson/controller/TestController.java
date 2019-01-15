package com.example.redisson.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 测试
 * @Author lss0555
 * @Date 2019/1/2/002 11:06
 **/
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "hello world";
    }
}
