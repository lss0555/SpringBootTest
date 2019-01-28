package com.example.mybatistest.service;

import com.example.mybatistest.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 用户service
 * @Author lss0555
 * @Date 2019/1/25/025 11:32
 **/
public interface UserServiceInter {
    List<User> user_list();
    List<User> userList1();
    List<User> userList2();
}
