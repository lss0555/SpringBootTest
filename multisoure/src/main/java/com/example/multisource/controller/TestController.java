package com.example.multisource.controller;

import com.example.multisource.dao.StudentDaoMapper;
import com.example.multisource.dao.UserDaoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 测试类
 * @Author lss0555
 * @Date 2019/1/15/015 10:54
 **/
@RestController
public class TestController {
    @Resource
    UserDaoMapper userDaoMapper;
    @Resource
    StudentDaoMapper studentDaoMapper;

    //mysql数据库
    @GetMapping("/userList")
    public String getUserList(){
        return userDaoMapper.userList().toString();
    }

    //sql server
    @GetMapping("/stuList")
    public String getStuList(){
        return studentDaoMapper.userList().toString();
    }
}
