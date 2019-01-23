package com.example.testng.Controller;

import com.example.testng.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description hello
 * @Author lss0555
 * @Date 2018/12/20/020 14:50
 **/
@RestController
public class TestController {
    @Resource
    HttpServletRequest  request;

    @GetMapping("/hello")
    public String hello(int a){
        System.out.println("hello =>");
        request.getSession().setAttribute("a","123");
        return "hello world:"+a;
    }

    @PostMapping("/login")
    public String login(User user){
        System.out.println("用户:"+user.toString());
        return "结果:"+"用户名"+user.getUsername()+"  密码"+user.getPassword();
    }
}
