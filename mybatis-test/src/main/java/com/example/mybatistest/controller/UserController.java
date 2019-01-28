package com.example.mybatistest.controller;
import com.example.mybatistest.dao.UserDaoMapper;
import com.example.mybatistest.model.TResult;
import com.example.mybatistest.model.User;
import com.example.mybatistest.service.UserServiceInter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Description 测试类
 * @Author lss0555
 * @Date 2019/1/15/015 10:54
 **/
@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    UserServiceInter userServiceInter;

    @GetMapping("/userList")
    public TResult getUserList(){
        Date date=new Date();
        TResult<User> result = new TResult<>();
        result.setList(userServiceInter.user_list());
        logger.info("花费时间:"+ (System.currentTimeMillis()-date.getTime()) +" ms");
        return result;
    }

    @GetMapping("/userList1")
    public TResult getUserList1(){
        TResult<User> result = new TResult<>();
        result.setList(userServiceInter.userList1());
        return result;
    }

    @GetMapping("/userList2")
    public TResult userList2(){
        TResult<User> result = new TResult<>();
        result.setList(userServiceInter.userList2());
        return result;
    }
}
