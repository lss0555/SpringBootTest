package com.sxkj.jwt.controller;

import com.sxkj.jwt.aop.PassToken;
import com.sxkj.jwt.aop.UserLoginToken;
import com.sxkj.jwt.model.User;
import com.sxkj.jwt.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController  {

    /**
     * 用户登录
     * @param user
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        String token =JwtTokenUtil.generateToken(user);
        return token;
    }

    /**
     * 获取用户信息
     * @return
     */
    @UserLoginToken
    @GetMapping("/getUserInfo")
    public String getUserInfo(){
        return "get success";
    }


    /**
     * 刷新token
     * @return
     */
    @UserLoginToken(required = false)
    @GetMapping("/fresh")
    public String refreshToken(String token){
        return JwtTokenUtil.refreshHeadToken(token);
    }

    /**
     * 从token中获取用户名
     * @return
     */
    @PassToken
    @GetMapping("/getUserNameFromToken")
    public String getUserNameFromToken(String token){
        String authToken = token.substring(JwtTokenUtil.getHeaderKey().length());// The part after "Bearer "
        return JwtTokenUtil.getUserNameFromToken(authToken);
    }
}
