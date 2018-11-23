package com.example.springbootTest.controller;

import com.example.springbootTest.common.aop.LogAspect;
import com.example.springbootTest.dao.inter.PatientDaoInter;
import com.example.springbootTest.dao.inter.UserDaoInter;
import com.example.springbootTest.model.Patient;
import com.example.springbootTest.model.TResult;
import com.example.springbootTest.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 测试
 * @Author lss0555
 * @Date 2018/11/20/020 16:51
 **/
@RestController
public class TestController {
    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource
    UserDaoInter userDaoInter;

    @Resource
    PatientDaoInter patientDaoInter;

    @GetMapping("/test")
    public String test(){
        logger.info("测试");
        return "hello  world";
    }

    @GetMapping("/user")
    public TResult getUserList(){
        List<User> users = userDaoInter.userList();
        TResult<User> result = new TResult<>();
        result.setList(users);
        return result;
    }

    @GetMapping("/user1")
    public TResult getUserList1(){
        List<User> users = userDaoInter.usersList();
        TResult<User> result = new TResult<>();
        result.setList(users);
        return result;
    }

    @GetMapping("/patient")
    public TResult getPatientList(){
        List<Patient> users = patientDaoInter.patientList();
        TResult<Patient> result = new TResult<>();
        result.setList(users);
        return result;
    }

}
