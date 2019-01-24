package com.example.apitest.controller;

import com.example.apitest.dao.UserDaoMapper;
import com.example.apitest.model.TResult;
import com.example.apitest.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 测试类
 * @Author lss0555
 * @Date 2019/1/15/015 10:54
 **/
@RestController
public class UserController {
    @Resource
    UserDaoMapper userDaoMapper;

    //mysql数据库
    @GetMapping("/userList")
    public TResult getUserList(){
        TResult<User> result = new TResult<>();
        result.setList(userDaoMapper.userList());
        return result;
    }
}
