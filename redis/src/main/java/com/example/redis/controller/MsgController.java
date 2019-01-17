package com.example.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 消息发送
 * @Author lss0555
 * @Date 2019/1/17/017 11:33
 **/
@RestController
public class MsgController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/sendMsg")
    public String sendMsg(){
        stringRedisTemplate.convertAndSend("paragram_vt", "Hello world!");
        return "ok";
    }
}
