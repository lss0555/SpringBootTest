package com.example.testng.Controller;

import com.example.testng.model.TResult;
import com.example.testng.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 测试用户异常
 * @Author lss0555
 * @Date 2018/12/21/021 16:23
 **/
@RestController
public class UserNgController {
    @Resource
    UserService userService;

    //注册用户
    @PostMapping("/saveUser")
    public TResult saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}
