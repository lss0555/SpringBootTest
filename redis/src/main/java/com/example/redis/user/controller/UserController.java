package com.example.redis.user.controller;

import com.example.redis.model.TResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 用户类
 * @Author lss0555
 * @Date 2019/1/4/004 16:06
 **/
@RestController
public class UserController {



    @GetMapping("/getUsers")
    public TResult userList(){
        return null;
    }
}
