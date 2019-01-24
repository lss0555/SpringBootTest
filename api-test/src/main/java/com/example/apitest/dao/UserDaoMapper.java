package com.example.apitest.dao;

import com.example.apitest.model.User;

import java.util.List;

/**
 * @Description 用户类
 * @Author lss0555
 **/
public interface UserDaoMapper {
    List<User> userList();
}
