package com.example.flowable.controller;

import org.flowable.engine.IdentityService;
import org.flowable.idm.api.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 用户测试
 * @Author lss0555
 **/
@RestController
public class UserTestController {
    @Resource
    IdentityService identityService;

    /**
     * @Description  创建用户
     * 涉及到的表: act_id_user
     **/
    @GetMapping("/creatUser")
    public String creatUser(String userid){
        if(userid==null||userid.equals("")){
            return "请设置用户的userid";
        }else {
            //根据用户的userid创建用户
            User user = identityService.newUser(userid);
            //设置用户的属性
            user.setEmail("lss05555@126.com");
            user.setFirstName("lss");
            user.setLastName("0555");
            user.setPassword("888888");
            //保存用户
            identityService.saveUser(user);
            //查询用户
            User singleResult = identityService.createUserQuery().userId(userid).singleResult();
            return "用户ID:"+singleResult.getId()+" 用户名称:"+singleResult.getFirstName();
        }
    }
}
