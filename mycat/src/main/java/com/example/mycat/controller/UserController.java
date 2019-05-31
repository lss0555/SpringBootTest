package com.example.mycat.controller;

import com.example.mycat.dao.UserDao;
import com.example.mycat.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * @Description 用户控制器
 * @Author lss0555
 **/
@RestController
public class UserController {
    @Resource
    UserDao userDao;

    @GetMapping("addMuach")
    public String addMuach(Long num){
        for (int i=0;i<num;i++){
            User user = new User();
            user.setUsername("user:"+(int)(1+Math.random()*(1000))+"");
            user.setPassword("pass:"+(int)(1+Math.random()*(1000))+"");
            userDao.save(user);
        }
        return "添加成功";
    }


    @GetMapping("addUser")
    public String addUser(){
        User user = new User();
        user.setUsername("user:"+(int)(1+Math.random()*(1000))+"");
        user.setPassword("pass:"+(int)(1+Math.random()*(1000))+"");
        User save = userDao.save(user);
        if(save==null){
            return "添加失败";
        }else {
            return "添加成功";
        }
    }



    @GetMapping("userList")
    public String userList(){
        List<User> userDaoAll = userDao.findAll();
        return "用户数量:"+userDaoAll.size();
    }

}
